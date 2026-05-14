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
 * Role hierarchy levels (higher number = more privileges)
 * super_admin > admin > management > user > viewer
 */
const ROLE_HIERARCHY = {
  'viewer': 1,
  'user': 2,
  'operator': 2,  // alias for user
  'management': 3,
  'admin': 4,
  'super_admin': 5
};

/**
 * Check if a role has at least the specified minimum level
 */
function hasMinimumRole(userRole, minimumRole) {
  const userLevel = ROLE_HIERARCHY[userRole] || 0;
  const requiredLevel = ROLE_HIERARCHY[minimumRole] || 0;
  return userLevel >= requiredLevel;
}

/**
 * Middleware that requires admin role (admin or super_admin).
 */
function requireAdmin(req, res, next) {
  requireAuth(req, res, () => {
    if (!hasMinimumRole(req.user.role, 'admin')) {
      return res.status(403).json({ error: 'Admin access required' });
    }
    next();
  });
}

/**
 * Middleware that requires super_admin role.
 */
function requireSuperAdmin(req, res, next) {
  requireAuth(req, res, () => {
    if (req.user.role !== 'super_admin') {
      return res.status(403).json({ error: 'Super admin access required' });
    }
    next();
  });
}

/**
 * Middleware that requires management role or higher.
 */
function requireManagement(req, res, next) {
  requireAuth(req, res, () => {
    if (!hasMinimumRole(req.user.role, 'management')) {
      return res.status(403).json({ error: 'Management access required' });
    }
    next();
  });
}

/**
 * Middleware that requires user role or higher (excludes viewer).
 */
function requireUser(req, res, next) {
  requireAuth(req, res, () => {
    if (!hasMinimumRole(req.user.role, 'user')) {
      return res.status(403).json({ error: 'User access required' });
    }
    next();
  });
}

module.exports = {
  signToken,
  verifyToken,
  requireAuth,
  requireAdmin,
  requireSuperAdmin,
  requireManagement,
  requireUser,
  hasMinimumRole,
  ROLE_HIERARCHY
};
