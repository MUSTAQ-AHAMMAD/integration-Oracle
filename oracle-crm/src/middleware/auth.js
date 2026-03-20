'use strict';

const jwt = require('jsonwebtoken');
const db  = require('../db');

const JWT_SECRET  = process.env.JWT_SECRET || (() => {
  if (process.env.NODE_ENV === 'production') {
    throw new Error('JWT_SECRET environment variable must be set in production');
  }
  console.warn('[WARN] JWT_SECRET not set – using insecure default. Set JWT_SECRET in .env for production.');
  return 'oracle-crm-secret-change-in-production';
})();
const JWT_EXPIRES = '12h';

function signToken(user) {
  return jwt.sign(
    { id: user.id, username: user.username, role: user.role },
    JWT_SECRET,
    { expiresIn: JWT_EXPIRES }
  );
}

function verifyToken(token) {
  return jwt.verify(token, JWT_SECRET);
}

/**
 * Express middleware – requires a valid JWT.
 * Reads from Authorization: Bearer <token> header OR __auth cookie.
 */
function requireAuth(req, res, next) {
  let token = null;

  const authHeader = req.headers['authorization'];
  if (authHeader && authHeader.startsWith('Bearer ')) {
    token = authHeader.slice(7);
  } else if (req.headers['cookie']) {
    const match = req.headers['cookie'].match(/(?:^|;\s*)__auth=([^;]+)/);
    if (match) token = decodeURIComponent(match[1]);
  }

  if (!token) {
    return res.status(401).json({ error: 'Authentication required' });
  }

  try {
    const payload = verifyToken(token);
    req.user = payload;
    next();
  } catch (_) {
    return res.status(401).json({ error: 'Invalid or expired token' });
  }
}

/**
 * Middleware that requires admin role.
 */
function requireAdmin(req, res, next) {
  requireAuth(req, res, () => {
    if (req.user.role !== 'admin') {
      return res.status(403).json({ error: 'Admin access required' });
    }
    next();
  });
}

module.exports = { signToken, verifyToken, requireAuth, requireAdmin };
