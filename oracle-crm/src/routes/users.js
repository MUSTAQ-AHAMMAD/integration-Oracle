'use strict';

const express  = require('express');
const bcrypt   = require('bcryptjs');
const router   = express.Router();
const db       = require('../db');
const { requireAuth, requireAdmin } = require('../middleware/auth');

// GET /api/users
router.get('/', requireAdmin, (req, res) => {
  res.json(db.listUsers());
});

// POST /api/users
router.post('/', requireAdmin, async (req, res) => {
  const { username, email, password, role, display_name } = req.body || {};
  if (!username || !password) {
    return res.status(400).json({ error: 'username and password are required' });
  }
  if (password.length < 8) {
    return res.status(400).json({ error: 'Password must be at least 8 characters' });
  }
  const validRoles = ['admin', 'operator', 'viewer'];
  if (role && !validRoles.includes(role)) {
    return res.status(400).json({ error: `role must be one of: ${validRoles.join(', ')}` });
  }
  if (db.getUserByUsername(username)) {
    return res.status(409).json({ error: 'Username already exists' });
  }
  const hash = await bcrypt.hash(password, 10);
  const user = db.createUser({ username, email, passwordHash: hash, role: role || 'operator', displayName: display_name });
  res.status(201).json({ id: user.id, username: user.username, email: user.email, role: user.role, display_name: user.display_name });
});

// PUT /api/users/:id
router.put('/:id', requireAdmin, async (req, res) => {
  const id = Number(req.params.id);
  const target = db.getUserById(id);
  if (!target) return res.status(404).json({ error: 'User not found' });
  const validRoles = ['admin', 'operator', 'viewer'];
  if (role && !validRoles.includes(role)) {
    return res.status(400).json({ error: `role must be one of: ${validRoles.join(', ')}` });
  }
  if (role && role !== 'admin' && target.role === 'admin' && db.countAdmins() <= 1) {
    return res.status(400).json({ error: 'Cannot demote the last admin' });
  }
  const fields = {};
  if (email        !== undefined) fields.email        = email;
  if (role         !== undefined) fields.role         = role;
  if (display_name !== undefined) fields.display_name = display_name;
  if (password) {
    if (password.length < 8) return res.status(400).json({ error: 'Password must be at least 8 characters' });
    fields.password_hash = await bcrypt.hash(password, 10);
  }
  db.updateUser(id, fields);
  res.json({ ok: true });
});

// DELETE /api/users/:id
router.delete('/:id', requireAdmin, (req, res) => {
  const id = Number(req.params.id);
  if (id === req.user.id) {
    return res.status(400).json({ error: 'Cannot delete your own account' });
  }
  const target = db.getUserById(id);
  if (!target) return res.status(404).json({ error: 'User not found' });
  if (target.role === 'admin' && db.countAdmins() <= 1) {
    return res.status(400).json({ error: 'Cannot delete the last admin' });
  }
  db.deleteUser(id);
  res.json({ ok: true });
});

module.exports = router;
