'use strict';

/**
 * routes/scheduler.js
 *
 * REST API endpoints for automated sync schedule management.
 *
 * Endpoints:
 *   GET    /api/scheduler/status          - Get scheduler service status
 *   GET    /api/scheduler/schedules       - List all schedules
 *   POST   /api/scheduler/schedules       - Create new schedule
 *   GET    /api/scheduler/schedules/:id   - Get schedule by ID
 *   PATCH  /api/scheduler/schedules/:id   - Update schedule
 *   DELETE /api/scheduler/schedules/:id   - Delete schedule
 *   POST   /api/scheduler/schedules/:id/execute - Manually trigger schedule execution
 *   POST   /api/scheduler/schedules/:id/enable  - Enable schedule
 *   POST   /api/scheduler/schedules/:id/disable - Disable schedule
 *   GET    /api/scheduler/executions      - List schedule executions
 *   POST   /api/scheduler/test-notification - Send test notification
 */

const express = require('express');
const router = express.Router();
const scheduler = require('../scheduler');
const notifier = require('../notifier');
const logger = require('../logger').child('SchedulerRoutes');

// ── GET /api/scheduler/status ─────────────────────────────────────────────────
router.get('/status', (req, res) => {
  try {
    const status = scheduler.getStatus();
    res.json({ success: true, status });
  } catch (error) {
    logger.error('Failed to get scheduler status', { error: error.message });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── GET /api/scheduler/schedules ──────────────────────────────────────────────
router.get('/schedules', (req, res) => {
  try {
    const filters = {};
    if (req.query.enabled !== undefined) {
      filters.enabled = req.query.enabled === 'true' || req.query.enabled === '1';
    }
    if (req.query.country) {
      filters.country = req.query.country;
    }

    const schedules = scheduler.listSchedules(filters);
    res.json({ success: true, schedules });
  } catch (error) {
    logger.error('Failed to list schedules', { error: error.message });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── POST /api/scheduler/schedules ─────────────────────────────────────────────
router.post('/schedules', (req, res) => {
  try {
    const config = req.body;

    // Validate required fields
    if (!config.name) {
      return res.status(400).json({ success: false, error: 'name is required' });
    }
    if (!config.cronExpression) {
      return res.status(400).json({ success: false, error: 'cronExpression is required' });
    }
    if (!config.country) {
      return res.status(400).json({ success: false, error: 'country is required' });
    }

    const scheduleId = scheduler.createSchedule(config);

    // Start schedule if enabled
    if (config.enabled !== false) {
      const schedule = scheduler.getSchedule(scheduleId);
      scheduler.startSchedule(schedule);
    }

    res.json({
      success: true,
      message: 'Schedule created successfully',
      scheduleId
    });
  } catch (error) {
    logger.error('Failed to create schedule', { error: error.message });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── GET /api/scheduler/schedules/:id ──────────────────────────────────────────
router.get('/schedules/:id', (req, res) => {
  try {
    const schedule = scheduler.getSchedule(req.params.id);
    if (!schedule) {
      return res.status(404).json({ success: false, error: 'Schedule not found' });
    }
    res.json({ success: true, schedule });
  } catch (error) {
    logger.error('Failed to get schedule', { error: error.message, scheduleId: req.params.id });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── PATCH /api/scheduler/schedules/:id ────────────────────────────────────────
router.patch('/schedules/:id', (req, res) => {
  try {
    const schedule = scheduler.getSchedule(req.params.id);
    if (!schedule) {
      return res.status(404).json({ success: false, error: 'Schedule not found' });
    }

    scheduler.updateSchedule(req.params.id, req.body);

    res.json({
      success: true,
      message: 'Schedule updated successfully'
    });
  } catch (error) {
    logger.error('Failed to update schedule', { error: error.message, scheduleId: req.params.id });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── DELETE /api/scheduler/schedules/:id ───────────────────────────────────────
router.delete('/schedules/:id', (req, res) => {
  try {
    const schedule = scheduler.getSchedule(req.params.id);
    if (!schedule) {
      return res.status(404).json({ success: false, error: 'Schedule not found' });
    }

    scheduler.deleteSchedule(req.params.id);

    res.json({
      success: true,
      message: 'Schedule deleted successfully'
    });
  } catch (error) {
    logger.error('Failed to delete schedule', { error: error.message, scheduleId: req.params.id });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── POST /api/scheduler/schedules/:id/execute ─────────────────────────────────
router.post('/schedules/:id/execute', async (req, res) => {
  try {
    const schedule = scheduler.getSchedule(req.params.id);
    if (!schedule) {
      return res.status(404).json({ success: false, error: 'Schedule not found' });
    }

    // Execute in background
    scheduler.executeSchedule(schedule).catch(error => {
      logger.error('Manual schedule execution failed', {
        scheduleId: req.params.id,
        error: error.message
      });
    });

    res.json({
      success: true,
      message: 'Schedule execution triggered',
      scheduleId: req.params.id
    });
  } catch (error) {
    logger.error('Failed to execute schedule', { error: error.message, scheduleId: req.params.id });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── POST /api/scheduler/schedules/:id/enable ──────────────────────────────────
router.post('/schedules/:id/enable', (req, res) => {
  try {
    const schedule = scheduler.getSchedule(req.params.id);
    if (!schedule) {
      return res.status(404).json({ success: false, error: 'Schedule not found' });
    }

    scheduler.updateSchedule(req.params.id, { enabled: true });

    res.json({
      success: true,
      message: 'Schedule enabled successfully'
    });
  } catch (error) {
    logger.error('Failed to enable schedule', { error: error.message, scheduleId: req.params.id });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── POST /api/scheduler/schedules/:id/disable ─────────────────────────────────
router.post('/schedules/:id/disable', (req, res) => {
  try {
    const schedule = scheduler.getSchedule(req.params.id);
    if (!schedule) {
      return res.status(404).json({ success: false, error: 'Schedule not found' });
    }

    scheduler.updateSchedule(req.params.id, { enabled: false });

    res.json({
      success: true,
      message: 'Schedule disabled successfully'
    });
  } catch (error) {
    logger.error('Failed to disable schedule', { error: error.message, scheduleId: req.params.id });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── GET /api/scheduler/executions ─────────────────────────────────────────────
router.get('/executions', (req, res) => {
  try {
    const db = require('../db').getDb();
    let query = 'SELECT * FROM schedule_executions WHERE 1=1';
    const params = [];

    if (req.query.scheduleId) {
      query += ' AND schedule_id = ?';
      params.push(req.query.scheduleId);
    }
    if (req.query.status) {
      query += ' AND status = ?';
      params.push(req.query.status);
    }

    const limit = parseInt(req.query.limit, 10) || 50;
    const offset = parseInt(req.query.offset, 10) || 0;

    query += ' ORDER BY started_at DESC LIMIT ? OFFSET ?';
    params.push(limit, offset);

    const stmt = db.prepare(query);
    const executions = stmt.all(...params);

    // Get total count
    let countQuery = 'SELECT COUNT(*) as total FROM schedule_executions WHERE 1=1';
    const countParams = [];

    if (req.query.scheduleId) {
      countQuery += ' AND schedule_id = ?';
      countParams.push(req.query.scheduleId);
    }
    if (req.query.status) {
      countQuery += ' AND status = ?';
      countParams.push(req.query.status);
    }

    const countStmt = db.prepare(countQuery);
    const { total } = countStmt.get(...countParams);

    res.json({
      success: true,
      executions,
      pagination: {
        total,
        limit,
        offset,
        hasMore: offset + executions.length < total
      }
    });
  } catch (error) {
    logger.error('Failed to list executions', { error: error.message });
    res.status(500).json({ success: false, error: error.message });
  }
});

// ── POST /api/scheduler/test-notification ─────────────────────────────────────
router.post('/test-notification', async (req, res) => {
  try {
    const { email } = req.body;

    if (!email) {
      return res.status(400).json({ success: false, error: 'email is required' });
    }

    const result = await notifier.sendTestNotification(email);

    if (result.success) {
      res.json({ success: true, message: 'Test notification sent successfully' });
    } else {
      res.status(500).json({ success: false, error: result.message });
    }
  } catch (error) {
    logger.error('Failed to send test notification', { error: error.message });
    res.status(500).json({ success: false, error: error.message });
  }
});

module.exports = router;
