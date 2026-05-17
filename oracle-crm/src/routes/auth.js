'use strict';

const express  = require('express');
const bcrypt   = require('bcryptjs');
const router   = express.Router();
const db       = require('../db');
const logger   = require('../logger').child('AuthRoutes');
const { signToken, requireAuth } = require('../middleware/auth');

const PASSWORD_MIN_LENGTH = 8;
const PASSWORD_MAX_LENGTH = 128;

/**
 * POST /api/auth/login
 * Authenticate user with username and password.
 */
router.post('/login', async (req, res) => {
  try {
    const { username, password } = req.body || {};
    
    if (!username || !password) {
      return res.status(400).json({ 
        error: 'Username and password are required',
        code: 'VALIDATION_ERROR',
        statusCode: 400
      });
    }

    // Validate input lengths to prevent DoS
    if (username.length > 255 || password.length > PASSWORD_MAX_LENGTH) {
      return res.status(400).json({ 
        error: 'Invalid username or password format',
        code: 'VALIDATION_ERROR',
        statusCode: 400
      });
    }

    const user = db.getUserByUsername(username);
    if (!user) {
      logger.warn('Login failed: user not found', { username, requestId: req.id });
      return res.status(401).json({ 
        error: 'Invalid credentials',
        code: 'AUTH_FAILED',
        statusCode: 401
      });
    }

    const match = await bcrypt.compare(password, user.password_hash);
    if (!match) {
      logger.warn('Login failed: invalid password', { username, requestId: req.id });
      return res.status(401).json({ 
        error: 'Invalid credentials',
        code: 'AUTH_FAILED',
        statusCode: 401
      });
    }

    db.updateUserLastLogin(user.id);
    const token = signToken(user);
    
    logger.info('User logged in successfully', { username, role: user.role, requestId: req.id });
    
    res.json({
      token,
      user: { 
        id: user.id, 
        username: user.username, 
        role: user.role, 
        display_name: user.display_name, 
        avatar_data: user.avatar_data 
      },
    });
  } catch (err) {
    logger.error('Login error', { error: err.message, stack: err.stack, requestId: req.id });
    res.status(500).json({ 
      error: 'Login failed',
      code: 'LOGIN_ERROR',
      statusCode: 500
    });
  }
});

/**
 * GET /api/auth/me
 * Get current authenticated user's profile.
 */
router.get('/me', requireAuth, (req, res) => {
  try {
    const user = db.getUserById(req.user.id);
    if (!user) {
      return res.status(404).json({ 
        error: 'User not found',
        code: 'NOT_FOUND',
        statusCode: 404
      });
    }

    res.json({ 
      id: user.id, 
      username: user.username, 
      email: user.email, 
      role: user.role, 
      display_name: user.display_name, 
      avatar_data: user.avatar_data, 
      last_login: user.last_login,
      created_at: user.created_at
    });
  } catch (err) {
    logger.error('Failed to fetch user profile', { error: err.message, requestId: req.id });
    res.status(500).json({ 
      error: 'Failed to fetch profile',
      code: 'PROFILE_ERROR',
      statusCode: 500
    });
  }
});

/**
 * PUT /api/auth/profile
 * Update user profile (display name and avatar).
 */
router.put('/profile', requireAuth, (req, res) => {
  try {
    const { display_name, avatar_data } = req.body || {};
    const fields = {};

    if (display_name !== undefined) {
      if (display_name && display_name.length > 255) {
        return res.status(400).json({ 
          error: 'Display name too long (max 255 characters)',
          code: 'VALIDATION_ERROR',
          statusCode: 400
        });
      }
      fields.display_name = display_name || null;
    }

    if (avatar_data !== undefined) {
      if (avatar_data && !avatar_data.startsWith('data:image/')) {
        return res.status(400).json({ 
          error: 'avatar_data must be a base64 image data URL',
          code: 'VALIDATION_ERROR',
          statusCode: 400
        });
      }
      // Limit avatar size to 1MB (data URI overhead ~33%)
      if (avatar_data && avatar_data.length > 1.5 * 1024 * 1024) {
        return res.status(400).json({ 
          error: 'Avatar data too large (max 1MB)',
          code: 'VALIDATION_ERROR',
          statusCode: 400
        });
      }
      fields.avatar_data = avatar_data || null;
    }

    db.updateUser(req.user.id, fields);
    logger.info('User profile updated', { username: req.user.username, requestId: req.id });
    res.json({ ok: true });
  } catch (err) {
    logger.error('Failed to update profile', { error: err.message, requestId: req.id });
    res.status(500).json({ 
      error: 'Failed to update profile',
      code: 'UPDATE_ERROR',
      statusCode: 500
    });
  }
});

/**
 * POST /api/auth/change-password
 * Change the authenticated user's password.
 */
router.post('/change-password', requireAuth, async (req, res) => {
  try {
    const { current_password, new_password } = req.body || {};

    if (!current_password || !new_password) {
      return res.status(400).json({ 
        error: 'current_password and new_password are required',
        code: 'VALIDATION_ERROR',
        statusCode: 400
      });
    }

    // Validate new password length
    if (new_password.length < PASSWORD_MIN_LENGTH) {
      return res.status(400).json({ 
        error: `New password must be at least ${PASSWORD_MIN_LENGTH} characters`,
        code: 'VALIDATION_ERROR',
        statusCode: 400
      });
    }

    if (new_password.length > PASSWORD_MAX_LENGTH) {
      return res.status(400).json({ 
        error: `New password must not exceed ${PASSWORD_MAX_LENGTH} characters`,
        code: 'VALIDATION_ERROR',
        statusCode: 400
      });
    }

    const user = db.getUserById(req.user.id);
    if (!user) {
      return res.status(404).json({ 
        error: 'User not found',
        code: 'NOT_FOUND',
        statusCode: 404
      });
    }

    const match = await bcrypt.compare(current_password, user.password_hash);
    if (!match) {
      logger.warn('Password change failed: incorrect current password', { 
        username: req.user.username,
        requestId: req.id 
      });
      return res.status(401).json({ 
        error: 'Current password is incorrect',
        code: 'AUTH_FAILED',
        statusCode: 401
      });
    }

    const hash = await bcrypt.hash(new_password, 10);
    db.updateUser(user.id, { password_hash: hash });
    
    logger.info('User password changed', { username: req.user.username, requestId: req.id });
    res.json({ ok: true });
  } catch (err) {
    logger.error('Failed to change password', { error: err.message, requestId: req.id });
    res.status(500).json({ 
      error: 'Failed to change password',
      code: 'PASSWORD_ERROR',
      statusCode: 500
    });
  }
});

/**
 * POST /api/auth/logout
 * Logout endpoint (stateless – JWT invalidation handled client-side).
 */
router.post('/logout', (req, res) => {
  try {
    logger.info('User logged out', { username: req.user?.username, requestId: req.id });
    res.json({ ok: true });
  } catch (err) {
    logger.error('Logout error', { error: err.message, requestId: req.id });
    res.status(500).json({ 
      error: 'Logout failed',
      code: 'LOGOUT_ERROR',
      statusCode: 500
    });
  }
});

module.exports = router;
