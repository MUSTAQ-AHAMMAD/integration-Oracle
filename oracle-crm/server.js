'use strict';

require('dotenv').config();
const express    = require('express');
const path       = require('path');
const morgan     = require('morgan');
const rateLimit  = require('express-rate-limit');
const helmet     = require('helmet');
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

const app  = express();
const PORT = process.env.PORT || 3000;

const limiter = rateLimit({
  windowMs: 15 * 60 * 1000,
  max: 500,
  standardHeaders: true,
  legacyHeaders: false,
});

// Security headers
app.use(helmet({
  contentSecurityPolicy: {
    directives: {
      defaultSrc: ["'self'"],
      styleSrc: ["'self'", "'unsafe-inline'"],
      scriptSrc: ["'self'", "'unsafe-inline'"],
      imgSrc: ["'self'", "data:", "https:"],
    }
  },
  hsts: {
    maxAge: 31536000,
    includeSubDomains: true,
    preload: true
  }
}));

app.use(morgan('combined', { stream: { write: msg => logger.info(msg.trim(), { source: 'http' }) } }));
app.use(limiter);
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ extended: false }));

// Health check endpoint (no auth required)
app.get('/api/health', (req, res) => {
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
    logger.error('Health check: database error', { err: err.message });
  }

  const statusCode = health.status === 'ok' ? 200 : 503;
  res.status(statusCode).json(health);
});

// Readiness check endpoint (for Kubernetes)
app.get('/api/ready', (req, res) => {
  try {
    db.listUsers();
    res.status(200).json({ ready: true });
  } catch (err) {
    res.status(503).json({ ready: false, error: err.message });
  }
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

// Seed default admin user
async function seedAdminUser() {
  try {
    const users = db.listUsers();
    if (users.length === 0) {
      // Create super_admin user
      const superAdminHash = await bcrypt.hash('SuperAdmin@1234', 10);
      db.createUser({
        username: 'superadmin',
        email: 'superadmin@oracle-crm.local',
        passwordHash: superAdminHash,
        role: 'super_admin',
        displayName: 'Super Administrator'
      });
      logger.info('Default super_admin user created (username: superadmin, password: SuperAdmin@1234) – CHANGE THIS IMMEDIATELY');

      // Create regular admin user
      const adminHash = await bcrypt.hash('Admin@1234', 10);
      db.createUser({
        username: 'admin',
        email: 'admin@oracle-crm.local',
        passwordHash: adminHash,
        role: 'admin',
        displayName: 'Administrator'
      });
      logger.info('Default admin user created (username: admin, password: Admin@1234) – CHANGE THIS IMMEDIATELY');
    } else {
      // Ensure at least one super_admin exists
      if (db.countSuperAdmins() === 0) {
        const superAdminHash = await bcrypt.hash('SuperAdmin@1234', 10);
        db.createUser({
          username: 'superadmin',
          email: 'superadmin@oracle-crm.local',
          passwordHash: superAdminHash,
          role: 'super_admin',
          displayName: 'Super Administrator'
        });
        logger.info('Super admin user created (username: superadmin, password: SuperAdmin@1234) – CHANGE THIS IMMEDIATELY');
      }
    }
  } catch (err) {
    logger.warn('Could not seed admin user', { err: err.message });
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
    if (!found) return;

    // Persist for each mode only when the slot is empty
    for (const mode of ['production', 'test']) {
      if (!db.getAppSetting(`oracle_${mode}_base_url`)  && oracle.baseUrl)
        db.setAppSetting(`oracle_${mode}_base_url`,  oracle.baseUrl);
      if (!db.getAppSetting(`oracle_${mode}_username`) && oracle.username)
        db.setAppSetting(`oracle_${mode}_username`, oracle.username);
      if (!db.getAppSetting(`oracle_${mode}_password`) && oracle.password)
        db.setAppSetting(`oracle_${mode}_password`, oracle.password);
    }

    logger.info('Oracle credentials auto-imported from middleware files into DB');
  } catch (err) {
    logger.warn('Could not auto-import Oracle credentials from middleware files', { err: err.message });
  }
}

app.listen(PORT, async () => {
  await seedAdminUser();
  seedCredentialsFromMiddleware();
  seedFusionSalesMetadata(db);
  logger.info(`Oracle CRM server listening on port ${PORT}`);
});
