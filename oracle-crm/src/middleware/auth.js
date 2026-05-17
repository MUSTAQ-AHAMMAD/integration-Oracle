'use strict';

const jwt = require('jsonwebtoken');
const db  = require('../db');
const logger = require('../logger').child('Auth');

let JWT_SECRET = null;
let JWT_SECRET_INITIALIZED = false;

/**
 * Lazily initialize JWT_SECRET on first use.
 * This allows the server to start even if JWT_SECRET is not set;
 * it will fail gracefully when a request tries to authenticate.
 */
function initJwtSecret() {
  if (JWT_SECRET_INITIALIZED) return JWT_SECRET;
  
  JWT_SECRET_INITIALIZED = true;
  
  if (process.env.JWT_SECRET) {
    JWT_SECRET = process.env.JWT_SECRET;
    return JWT_SECRET;
  }

  if (process.env.NODE_ENV === 'production') {
    const err = new Error('JWT_SECRET environment variable must be set in production');
    logger.error('Critical: JWT_SECRET not set in production', { error: err.message });
    throw err;
  }

  logger.warn('JWT_SECRET not set – using insecure default. Set JWT_SECRET in .env for production.');
  JWT_SECRET = 'oracle-crm-secret-change-in-production';
  return JWT_SECRET;
}

const JWT_EXPIRES = '12h';

function signToken(user) {
  const secret = initJwtSecret();
  return jwt.sign(
    { id: user.id, username: user.username, role: user.role },
    secret,
    { expiresIn: JWT_EXPIRES }
  );
}

function verifyToken(token) {
  const secret = initJwtSecret();
  return jwt.verify(token, secret);
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
    logger.warn('Authentication required but no token provided', { 
      path: req.path, 
      method: req.method,
      requestId: req.id 
    });
    return res.status(401).json({ 
      error: 'Authentication required',
      code: 'AUTH_REQUIRED',
      statusCode: 401
    });
  }

  try {
    const payload = verifyToken(token);
    req.user = payload;
    next();
  } catch (err) {
    logger.warn('Invalid or expired token', { 
      error: err.message,
      path: req.path,
      requestId: req.id 
    });
    return res.status(401).json({ 
      error: 'Invalid or expired token',
      code: 'INVALID_TOKEN',
      statusCode: 401
    });
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
      logger.warn('Admin access denied for user', { 
        username: req.user.username,
        role: req.user.role,
        path: req.path,
        requestId: req.id 
      });
      return res.status(403).json({ 
        error: 'Admin access required',
        code: 'INSUFFICIENT_ROLE',
        statusCode: 403
      });
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
      logger.warn('Super admin access denied for user', { 
        username: req.user.username,
        role: req.user.role,
        path: req.path,
        requestId: req.id 
      });
      return res.status(403).json({ 
        error: 'Super admin access required',
        code: 'INSUFFICIENT_ROLE',
        statusCode: 403
      });
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
      logger.warn('Management access denied for user', { 
        username: req.user.username,
        role: req.user.role,
        path: req.path,
        requestId: req.id 
      });
      return res.status(403).json({ 
        error: 'Management access required',
        code: 'INSUFFICIENT_ROLE',
        statusCode: 403
      });
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
      logger.warn('User access denied', { 
        username: req.user.username,
        role: req.user.role,
        path: req.path,
        requestId: req.id 
      });
      return res.status(403).json({ 
        error: 'User access required',
        code: 'INSUFFICIENT_ROLE',
        statusCode: 403
      });
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
