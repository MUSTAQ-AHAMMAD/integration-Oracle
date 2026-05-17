'use strict';

require('dotenv').config();
const express    = require('express');
const path       = require('path');
const morgan     = require('morgan');
const rateLimit  = require('express-rate-limit');
const helmet     = require('helmet');
const crypto     = require('crypto');
const logger     = require('./src/logger');
const db         = require('./src/db');
const bcrypt     = require('bcryptjs');
const { readMiddlewareCredentials } = require('./src/middlewareCredentials');
const { seedFusionSalesMetadata }   = require('./src/fusionMetadataSeed');

const salesRoutes      = require('./src/routes/sales');
const configRoutes     = require('./src/routes/config');
const odooRoutes       = require('./src/routes/odoo');
const authRoutes       = require('./src/routes/auth');
const usersRoutes      = require('./src/routes/users');
const benchmarkRoutes  = require('./src/routes/benchmark');
const reportsRoutes    = require('./src/routes/reports');
const { requireAuth } = require('./src/middleware/auth');

// ── Validate required environment variables ──────────────────────────────────
function validateEnv() {
  const required = ['JWT_SECRET'];
  const missing  = required.filter(v => !process.env[v]);
  
  if (missing.length > 0 && process.env.NODE_ENV === 'production') {
    logger.error('Missing required environment variables in production', { missing });
    throw new Error(`Missing required env vars: ${missing.join(', ')}`);
  }
  
  if (missing.length > 0) {
    logger.warn('Missing environment variables (will use defaults)', { missing });
  }
}

try {
  validateEnv();
} catch (err) {
  logger.error('Environment validation failed', { error: err.message });
  process.exit(1);
}

const app  = express();
const PORT = process.env.PORT || 3000;

const limiter = rateLimit({
  windowMs: 15 * 60 * 1000,
  max: process.env.RATE_LIMIT_MAX || 150,  // Reduced from 500 for better security
  standardHeaders: true,
  legacyHeaders: false,
  skip: (req) => req.path === '/api/health' || req.path === '/api/live' || req.path === '/api/ready',  // Skip health checks
});

// ── Request tracing middleware ────────────────────────────────────────────────
app.use((req, res, next) => {
  req.id = req.headers['x-request-id'] || crypto.randomUUID();
  res.setHeader('X-Request-ID', req.id);
  next();
});

// ── CORS middleware (optional - only if cors package is installed) ──────────
let corsMiddleware;
try {
  const cors = require('cors');
  corsMiddleware = cors({
    origin: (process.env.ALLOWED_ORIGINS || 'http://localhost:3000').split(',').map(o => o.trim()),
    credentials: true,
    optionsSuccessStatus: 200,
  });
  app.use(corsMiddleware);
} catch (e) {
  logger.debug('cors package not installed - skipping CORS middleware');
}

// Security headers
app.use(helmet({
  contentSecurityPolicy: false,  // Disabled to allow inline scripts and event handlers
  hsts: {
    maxAge: 31536000,
    includeSubDomains: true,
    preload: true
  }
}));

// ── Request logging & rate limiting ──────────────────────────────────────────
app.use(morgan('combined', { stream: { write: msg => logger.info(msg.trim(), { source: 'http' }) } }));
app.use(limiter);
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ extended: false, limit: '10mb' }));

// Health check endpoint (no auth required) – wrapped in setImmediate per db.js docs
app.get('/api/health', (req, res) => {
  setImmediate(() => {
    const health = {
      status: 'ok',
      timestamp: new Date().toISOString(),
      uptime: process.uptime(),
      environment: process.env.NODE_ENV || 'development',
      version: require('./package.json').version
    };

    // Check database connectivity
    try {
      db.listUsers(); // Simple DB query to verify connection
      health.database = 'connected';
    } catch (err) {
      health.database = 'error';
      health.status = 'degraded';
      logger.error('Health check: database error', { err: err.message, requestId: req.id });
    }

    const statusCode = health.status === 'ok' ? 200 : 503;
    res.status(statusCode).json(health);
  });
});

// Readiness check endpoint (for Kubernetes) – wrapped in setImmediate
app.get('/api/ready', (req, res) => {
  setImmediate(() => {
    try {
      db.listUsers();
      res.status(200).json({ ready: true });
    } catch (err) {
      logger.warn('Readiness check failed', { error: err.message, requestId: req.id });
      res.status(503).json({ ready: false, error: err.message });
    }
  });
});

// Liveness check endpoint (for Kubernetes)
app.get('/api/live', (req, res) => {
  res.status(200).json({ alive: true });
});

// Static files (public HTML/CSS/JS – no auth required)
app.use(express.static(path.join(__dirname, 'public')));

// Auth routes (public)
app.use('/api/auth', authRoutes);

// Protected API routes
app.use('/api/sales',     requireAuth, salesRoutes);
app.use('/api/config',    requireAuth, configRoutes);
app.use('/api/odoo',      requireAuth, odooRoutes);
app.use('/api/benchmark', requireAuth, benchmarkRoutes);
app.use('/api/reports',   requireAuth, reportsRoutes);
app.use('/api/users',     usersRoutes);  // admin check is inside

// SPA fallback – serve index.html for unknown routes (except /api/*)
app.get('*', (req, res, next) => {
  if (req.path.startsWith('/api/')) return next();
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// ── Error handling middleware ────────────────────────────────────────────────
app.use((err, req, res, next) => {
  const requestId = req.id || 'unknown';
  logger.error('Unhandled error', {
    error: err.message,
    stack: err.stack,
    path: req.path,
    method: req.method,
    requestId,
  });
  
  res.status(err.status || 500).json({
    error: process.env.NODE_ENV === 'production' ? 'Internal server error' : err.message,
    code: 'INTERNAL_ERROR',
    statusCode: err.status || 500,
    requestId,
  });
});

/**
 * Seed default admin user with random temporary password.
 * Users must change their password on first login.
 */
async function seedAdminUser() {
  try {
    const users = db.listUsers();
    if (users.length === 0) {
      // Create super_admin user with random password
      const tempPassword = crypto.randomBytes(16).toString('hex');
      const superAdminHash = await bcrypt.hash(tempPassword, 10);
      db.createUser({
        username: 'superadmin',
        email: 'superadmin@oracle-crm.local',
        passwordHash: superAdminHash,
        role: 'super_admin',
        displayName: 'Super Administrator'
      });
      logger.warn('Default super_admin user created – CHANGE PASSWORD IMMEDIATELY', { 
        username: 'superadmin', 
        note: 'Random temporary password generated. Use /api/auth/change-password to set a new one.' 
      });

      // Create regular admin user with random password
      const adminTempPassword = crypto.randomBytes(16).toString('hex');
      const adminHash = await bcrypt.hash(adminTempPassword, 10);
      db.createUser({
        username: 'admin',
        email: 'admin@oracle-crm.local',
        passwordHash: adminHash,
        role: 'admin',
        displayName: 'Administrator'
      });
      logger.warn('Default admin user created – CHANGE PASSWORD IMMEDIATELY', { 
        username: 'admin', 
        note: 'Random temporary password generated. Use /api/auth/change-password to set a new one.' 
      });
    } else {
      // Ensure at least one super_admin exists
      if (db.countSuperAdmins() === 0) {
        const tempPassword = crypto.randomBytes(16).toString('hex');
        const superAdminHash = await bcrypt.hash(tempPassword, 10);
        db.createUser({
          username: 'superadmin',
          email: 'superadmin@oracle-crm.local',
          passwordHash: superAdminHash,
          role: 'super_admin',
          displayName: 'Super Administrator'
        });
        logger.warn('Super admin user created – CHANGE PASSWORD IMMEDIATELY', { 
          username: 'superadmin', 
          note: 'Random temporary password generated. Use /api/auth/change-password to set a new one.' 
        });
      }
    }
  } catch (err) {
    logger.error('Failed to seed admin user', { err: err.message, stack: err.stack });
  }
}

/**
 * Auto-import Oracle Fusion credentials from Java middleware files into the
 * database if they have not been set yet.  Both test and production credential
 * slots are populated when empty.
 */
function seedCredentialsFromMiddleware() {
  try {
    const { oracle, found } = readMiddlewareCredentials();
    if (!found) {
      logger.debug('No middleware credentials file found');
      return;
    }

    // Persist for each mode only when the slot is empty
    let imported = 0;
    for (const mode of ['production', 'test']) {
      if (!db.getAppSetting(`oracle_${mode}_base_url`)  && oracle.baseUrl) {
        db.setAppSetting(`oracle_${mode}_base_url`,  oracle.baseUrl);
        imported++;
      }
      if (!db.getAppSetting(`oracle_${mode}_username`) && oracle.username) {
        db.setAppSetting(`oracle_${mode}_username`, oracle.username);
        imported++;
      }
      if (!db.getAppSetting(`oracle_${mode}_password`) && oracle.password) {
        db.setAppSetting(`oracle_${mode}_password`, oracle.password);
        imported++;
      }
    }

    if (imported > 0) {
      logger.info('Oracle credentials auto-imported from middleware files', { count: imported });
    }
  } catch (err) {
    logger.warn('Could not auto-import Oracle credentials from middleware files', { 
      error: err.message, 
      stack: err.stack 
    });
  }
}

// ── Graceful shutdown ────────────────────────────────────────────────────────
let server = null;

function gracefulShutdown(signal) {
  logger.info(`Received ${signal} signal. Starting graceful shutdown...`);
  
  if (server) {
    server.close(() => {
      logger.info('HTTP server closed');
      db.closeDb();
      logger.info('Database connection closed');
      process.exit(0);
    });

    // Force shutdown after 30 seconds
    setTimeout(() => {
      logger.error('Forced shutdown after 30 second timeout');
      db.closeDb();
      process.exit(1);
    }, 30000);
  } else {
    process.exit(0);
  }
}

process.on('SIGTERM', () => gracefulShutdown('SIGTERM'));
process.on('SIGINT', () => gracefulShutdown('SIGINT'));

// ── Start server ─────────────────────────────────────────────────────────────
server = app.listen(PORT, async () => {
  try {
    logger.info(`Oracle CRM server starting on port ${PORT}`, { environment: process.env.NODE_ENV });
    
    // Seed admin users (with await to ensure completion)
    await seedAdminUser();
    
    // Import middleware credentials
    seedCredentialsFromMiddleware();
    
    // Seed Fusion metadata
    await seedFusionSalesMetadata(db);
    
    logger.info('Server initialization complete. Ready to accept connections.', { port: PORT });
  } catch (err) {
    logger.error('Failed to initialize server', { error: err.message, stack: err.stack });
    process.exit(1);
  }
});

server.on('error', (err) => {
  logger.error('Server error', { error: err.message, stack: err.stack });
  process.exit(1);
});
