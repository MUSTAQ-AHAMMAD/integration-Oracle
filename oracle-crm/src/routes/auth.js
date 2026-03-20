'use strict';

const express  = require('express');
const bcrypt   = require('bcryptjs');
const router   = express.Router();
const db       = require('../db');
const { signToken, requireAuth } = require('../middleware/auth');

// POST /api/auth/login
router.post('/login', async (req, res) => {
  const { username, password } = req.body || {};
  if (!username || !password) {
    return res.status(400).json({ error: 'Username and password are required' });
  }
  const user = db.getUserByUsername(username);
  if (!user) {
    return res.status(401).json({ error: 'Invalid credentials' });
  }
  const match = await bcrypt.compare(password, user.password_hash);
  if (!match) {
    return res.status(401).json({ error: 'Invalid credentials' });
  }
  db.updateUserLastLogin(user.id);
  const token = signToken(user);
  res.json({
    token,
    user: { id: user.id, username: user.username, role: user.role, display_name: user.display_name, avatar_data: user.avatar_data },
  });
});

// GET /api/auth/me
router.get('/me', requireAuth, (req, res) => {
  const user = db.getUserById(req.user.id);
  if (!user) return res.status(404).json({ error: 'User not found' });
  res.json({ id: user.id, username: user.username, email: user.email, role: user.role, display_name: user.display_name, avatar_data: user.avatar_data, last_login: user.last_login });
});

// PUT /api/auth/profile
router.put('/profile', requireAuth, (req, res) => {
  const { display_name, avatar_data } = req.body || {};
  const fields = {};
  if (display_name !== undefined) fields.display_name = display_name;
  if (avatar_data  !== undefined) {
    if (avatar_data && !avatar_data.startsWith('data:image/')) {
      return res.status(400).json({ error: 'avatar_data must be a base64 image data URL' });
    }
    fields.avatar_data = avatar_data || null;
  }
  db.updateUser(req.user.id, fields);
  res.json({ ok: true });
});

// POST /api/auth/change-password
router.post('/change-password', requireAuth, async (req, res) => {
  const { current_password, new_password } = req.body || {};
  if (!current_password || !new_password) {
    return res.status(400).json({ error: 'current_password and new_password are required' });
  }
  if (new_password.length < 8) {
    return res.status(400).json({ error: 'New password must be at least 8 characters' });
  }
  const user = db.getUserById(req.user.id);
  if (!user) return res.status(404).json({ error: 'User not found' });
  const match = await bcrypt.compare(current_password, user.password_hash);
  if (!match) return res.status(401).json({ error: 'Current password is incorrect' });
  const hash = await bcrypt.hash(new_password, 10);
  db.updateUser(user.id, { password_hash: hash });
  res.json({ ok: true });
});

// POST /api/auth/logout
router.post('/logout', (req, res) => {
  res.json({ ok: true });
});

module.exports = router;
