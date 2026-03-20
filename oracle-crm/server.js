'use strict';

require('dotenv').config();
const express    = require('express');
const path       = require('path');
const morgan     = require('morgan');
const rateLimit  = require('express-rate-limit');
const logger     = require('./src/logger');
const db         = require('./src/db');
const bcrypt     = require('bcryptjs');

const salesRoutes  = require('./src/routes/sales');
const configRoutes = require('./src/routes/config');
const odooRoutes   = require('./src/routes/odoo');
const authRoutes   = require('./src/routes/auth');
const usersRoutes  = require('./src/routes/users');
const { requireAuth } = require('./src/middleware/auth');

const app  = express();
const PORT = process.env.PORT || 3000;

const limiter = rateLimit({
  windowMs: 15 * 60 * 1000,
  max: 500,
  standardHeaders: true,
  legacyHeaders: false,
});

app.use(morgan('combined', { stream: { write: msg => logger.info(msg.trim(), { source: 'http' }) } }));
app.use(limiter);
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ extended: false }));

// Static files (public HTML/CSS/JS – no auth required)
app.use(express.static(path.join(__dirname, 'public')));

// Auth routes (public)
app.use('/api/auth', authRoutes);

// Protected API routes
app.use('/api/sales',  requireAuth, salesRoutes);
app.use('/api/config', requireAuth, configRoutes);
app.use('/api/odoo',   requireAuth, odooRoutes);
app.use('/api/users',  usersRoutes);  // admin check is inside

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
      const hash = await bcrypt.hash('Admin@1234', 10);
      db.createUser({ username: 'admin', email: 'admin@oracle-crm.local', passwordHash: hash, role: 'admin', displayName: 'Administrator' });
      logger.info('Default admin user created (username: admin, password: Admin@1234) – CHANGE THIS IMMEDIATELY');
    }
  } catch (err) {
    logger.warn('Could not seed admin user', { err: err.message });
  }
}

app.listen(PORT, async () => {
  await seedAdminUser();
  logger.info(`Oracle CRM server listening on port ${PORT}`);
});
