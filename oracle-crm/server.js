'use strict';

require('dotenv').config();
const express   = require('express');
const morgan    = require('morgan');
const rateLimit = require('express-rate-limit');
const path      = require('path');

const logger       = require('./src/logger');
const salesRoutes  = require('./src/routes/sales');
const configRoutes = require('./src/routes/config');
const odooRoutes   = require('./src/routes/odoo');

const app  = express();
const PORT = process.env.PORT || 3000;

// ── Rate limiting ────────────────────────────────────────────────────────────
const limiter = rateLimit({
  windowMs: 15 * 60 * 1000, // 15 minutes
  max: 200,                  // max 200 requests per window per IP
  standardHeaders: true,
  legacyHeaders: false,
  message: { error: 'Too many requests, please try again later.' },
});

// ── Middleware ───────────────────────────────────────────────────────────────
// Use morgan with a stream piped to winston so all HTTP logs go through the
// single structured logger – keeps the CRM responsive even during pipelines.
app.use(morgan('combined', {
  stream: { write: msg => logger.info(msg.trim(), { source: 'http' }) },
}));
app.use(limiter);
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ extended: false }));

// ── Static frontend ──────────────────────────────────────────────────────────
app.use(express.static(path.join(__dirname, 'public')));

// ── API routes ───────────────────────────────────────────────────────────────
app.use('/api/sales',  salesRoutes);
app.use('/api/config', configRoutes);
app.use('/api/odoo',   odooRoutes);

// ── SPA fallback ─────────────────────────────────────────────────────────────
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// ── Global error handler ─────────────────────────────────────────────────────
// eslint-disable-next-line no-unused-vars
app.use((err, req, res, next) => {
  logger.error('Unhandled express error', { err: err.message, stack: err.stack });
  res.status(500).json({ error: 'Internal server error' });
});

// ── Start ─────────────────────────────────────────────────────────────────────
app.listen(PORT, () => {
  logger.info(`Oracle CRM running on http://localhost:${PORT}`);
  logger.info(`Oracle Fusion URL: ${process.env.FUSION_BASE_URL || '(not configured – set in .env)'}`);
  logger.info(`Odoo URL: ${process.env.ODOO_URL || '(not configured – set ODOO_URL in .env)'}`);
});
