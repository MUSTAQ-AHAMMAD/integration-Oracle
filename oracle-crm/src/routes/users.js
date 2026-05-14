'use strict';

const express  = require('express');
const bcrypt   = require('bcryptjs');
const router   = express.Router();
const db       = require('../db');
const { requireAuth, requireAdmin, requireSuperAdmin, hasMinimumRole } = require('../middleware/auth');

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
  const validRoles = ['super_admin', 'admin', 'management', 'user', 'operator', 'viewer'];
  if (role && !validRoles.includes(role)) {
    return res.status(400).json({ error: `role must be one of: ${validRoles.join(', ')}` });
  }
  // Only super_admin can create super_admin users
  if (role === 'super_admin' && req.user.role !== 'super_admin') {
    return res.status(403).json({ error: 'Only super admin can create super admin users' });
  }
  // Admins cannot create users with higher privileges than themselves
  if (role && !hasMinimumRole(req.user.role, role)) {
    return res.status(403).json({ error: 'Cannot create users with higher privileges than your own' });
  }
  if (db.getUserByUsername(username)) {
    return res.status(409).json({ error: 'Username already exists' });
  }
  const hash = await bcrypt.hash(password, 10);
  const user = db.createUser({ username, email, passwordHash: hash, role: role || 'user', displayName: display_name });
  res.status(201).json({ id: user.id, username: user.username, email: user.email, role: user.role, display_name: user.display_name });
});

// PUT /api/users/:id
router.put('/:id', requireAdmin, async (req, res) => {
  const id = Number(req.params.id);
  const { email, role, display_name, password } = req.body || {};
  const target = db.getUserById(id);
  if (!target) return res.status(404).json({ error: 'User not found' });
  const validRoles = ['super_admin', 'admin', 'management', 'user', 'operator', 'viewer'];
  if (role && !validRoles.includes(role)) {
    return res.status(400).json({ error: `role must be one of: ${validRoles.join(', ')}` });
  }
  // Only super_admin can modify super_admin users
  if (target.role === 'super_admin' && req.user.role !== 'super_admin') {
    return res.status(403).json({ error: 'Only super admin can modify super admin users' });
  }
  // Only super_admin can promote to super_admin
  if (role === 'super_admin' && req.user.role !== 'super_admin') {
    return res.status(403).json({ error: 'Only super admin can promote users to super admin' });
  }
  // Cannot promote users to a role higher than your own
  if (role && !hasMinimumRole(req.user.role, role)) {
    return res.status(403).json({ error: 'Cannot promote users to a role higher than your own' });
  }
  if (role && role !== 'admin' && role !== 'super_admin' && target.role === 'admin' && db.countAdmins() <= 1) {
    return res.status(400).json({ error: 'Cannot demote the last admin' });
  }
  if (role && role !== 'super_admin' && target.role === 'super_admin' && db.countSuperAdmins() <= 1) {
    return res.status(400).json({ error: 'Cannot demote the last super admin' });
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
  // Only super_admin can delete super_admin users
  if (target.role === 'super_admin' && req.user.role !== 'super_admin') {
    return res.status(403).json({ error: 'Only super admin can delete super admin users' });
  }
  if (target.role === 'admin' && db.countAdmins() <= 1) {
    return res.status(400).json({ error: 'Cannot delete the last admin' });
  }
  if (target.role === 'super_admin' && db.countSuperAdmins() <= 1) {
    return res.status(400).json({ error: 'Cannot delete the last super admin' });
  }
  db.deleteUser(id);
  res.json({ ok: true });
});

module.exports = router;
