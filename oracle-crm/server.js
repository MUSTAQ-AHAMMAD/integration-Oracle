'use strict';

require('dotenv').config();
const express   = require('express');
const morgan    = require('morgan');
const rateLimit = require('express-rate-limit');
const path      = require('path');

const salesRoutes  = require('./src/routes/sales');
const configRoutes = require('./src/routes/config');

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
app.use(morgan('dev'));
app.use(limiter);
app.use(express.json({ limit: '5mb' }));
app.use(express.urlencoded({ extended: false }));

// ── Static frontend ──────────────────────────────────────────────────────────
app.use(express.static(path.join(__dirname, 'public')));

// ── API routes ───────────────────────────────────────────────────────────────
app.use('/api/sales',  salesRoutes);
app.use('/api/config', configRoutes);

// ── SPA fallback ─────────────────────────────────────────────────────────────
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// ── Start ─────────────────────────────────────────────────────────────────────
app.listen(PORT, () => {
  console.log(`Oracle CRM running on http://localhost:${PORT}`);
  console.log(`Oracle Fusion URL: ${process.env.FUSION_BASE_URL || '(not configured – set in .env)'}`);
});
