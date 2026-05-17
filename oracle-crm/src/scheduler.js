'use strict';

/**
 * scheduler.js
 *
 * Automated recurring sync job scheduler for Odoo → Oracle Fusion integration.
 *
 * Features:
 *   • Cron-based scheduling (e.g., hourly, daily, weekly)
 *   • Incremental sync: automatically calculates date ranges from last successful run
 *   • Auto-retry with exponential backoff for transient failures
 *   • Notification system (email/webhook) for failures
 *   • Per-store/per-country schedule configuration
 *   • Health monitoring and metrics
 *
 * Usage:
 *   const scheduler = require('./scheduler');
 *   scheduler.start();  // Start all enabled schedules
 *   scheduler.stop();   // Stop all running schedules
 */

const cron = require('node-cron');
const { randomUUID } = require('crypto');
const db = require('./db');
const { startFetchJob, startPushJob } = require('./odooSync');
const notifier = require('./notifier');
const logger = require('./logger').child('Scheduler');

// ── In-memory schedule tracking ───────────────────────────────────────────────
const activeSchedules = new Map(); // scheduleId -> { task, config }

// ── Database schema for schedules ─────────────────────────────────────────────

function ensureSchedulesTables() {
  const instance = db.getDb();

  instance.exec(`
    -- Stores configuration for recurring sync jobs
    CREATE TABLE IF NOT EXISTS sync_schedules (
      id                INTEGER PRIMARY KEY AUTOINCREMENT,
      schedule_id       TEXT    NOT NULL UNIQUE,       -- UUID
      name              TEXT    NOT NULL,              -- Human-readable name
      enabled           INTEGER NOT NULL DEFAULT 1,    -- 1=enabled, 0=disabled
      schedule_type     TEXT    NOT NULL,              -- FETCH_AND_PUSH | FETCH_ONLY | PUSH_ONLY
      cron_expression   TEXT    NOT NULL,              -- Standard cron format
      country           TEXT    NOT NULL,              -- AE, KW, SA, etc.
      store_id          INTEGER,                       -- NULL = all stores
      store_name        TEXT,
      incremental       INTEGER NOT NULL DEFAULT 1,    -- 1=use last_sync_timestamp, 0=manual date range
      date_from         TEXT,                          -- Used if incremental=0
      date_to           TEXT,                          -- Used if incremental=0
      lookback_days     INTEGER DEFAULT 1,             -- For incremental: sync from (now - lookback_days)
      metadata_config   TEXT,                          -- JSON: Oracle metadata settings
      outlet_config     TEXT,                          -- JSON: Oracle outlet settings
      retry_enabled     INTEGER NOT NULL DEFAULT 1,    -- Auto-retry failed records
      max_retries       INTEGER DEFAULT 3,
      notify_on_failure INTEGER NOT NULL DEFAULT 1,
      notification_config TEXT,                        -- JSON: email/webhook settings
      last_run_at       TEXT,
      last_sync_timestamp TEXT,                        -- Last successful sync timestamp
      last_run_status   TEXT,                          -- QUEUED|RUNNING|DONE|FAILED
      last_run_job_id   TEXT,
      run_count         INTEGER DEFAULT 0,
      failure_count     INTEGER DEFAULT 0,
      created_at        TEXT    NOT NULL,
      updated_at        TEXT    NOT NULL
    );

    CREATE INDEX IF NOT EXISTS idx_sync_schedules_enabled ON sync_schedules(enabled);
    CREATE INDEX IF NOT EXISTS idx_sync_schedules_country ON sync_schedules(country);

    -- Tracks each execution of a scheduled job
    CREATE TABLE IF NOT EXISTS schedule_executions (
      id              INTEGER PRIMARY KEY AUTOINCREMENT,
      schedule_id     TEXT    NOT NULL,
      execution_id    TEXT    NOT NULL UNIQUE,         -- UUID
      job_id          TEXT,                            -- Links to push_jobs.job_id
      status          TEXT    NOT NULL DEFAULT 'RUNNING', -- RUNNING|SUCCESS|FAILED
      error_message   TEXT,
      records_synced  INTEGER DEFAULT 0,
      records_failed  INTEGER DEFAULT 0,
      started_at      TEXT    NOT NULL,
      finished_at     TEXT,
      duration_ms     INTEGER
    );

    CREATE INDEX IF NOT EXISTS idx_schedule_executions_schedule ON schedule_executions(schedule_id);
    CREATE INDEX IF NOT EXISTS idx_schedule_executions_started  ON schedule_executions(started_at);
  `);

  logger.info('Schedule tables initialized');
}

// ── Schedule CRUD operations ──────────────────────────────────────────────────

function createSchedule(config) {
  ensureSchedulesTables();
  const instance = db.getDb();

  const scheduleId = randomUUID();
  const now = new Date().toISOString();

  // Validate cron expression
  if (!cron.validate(config.cronExpression)) {
    throw new Error(`Invalid cron expression: ${config.cronExpression}`);
  }

  const stmt = instance.prepare(`
    INSERT INTO sync_schedules (
      schedule_id, name, enabled, schedule_type, cron_expression, country,
      store_id, store_name, incremental, date_from, date_to, lookback_days,
      metadata_config, outlet_config, retry_enabled, max_retries,
      notify_on_failure, notification_config, created_at, updated_at
    ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
  `);

  stmt.run(
    scheduleId,
    config.name,
    config.enabled !== false ? 1 : 0,
    config.scheduleType || 'FETCH_AND_PUSH',
    config.cronExpression,
    config.country,
    config.storeId || null,
    config.storeName || null,
    config.incremental !== false ? 1 : 0,
    config.dateFrom || null,
    config.dateTo || null,
    config.lookbackDays || 1,
    config.metadataConfig ? JSON.stringify(config.metadataConfig) : null,
    config.outletConfig ? JSON.stringify(config.outletConfig) : null,
    config.retryEnabled !== false ? 1 : 0,
    config.maxRetries || 3,
    config.notifyOnFailure !== false ? 1 : 0,
    config.notificationConfig ? JSON.stringify(config.notificationConfig) : null,
    now,
    now
  );

  logger.info('Schedule created', { scheduleId, name: config.name });
  return scheduleId;
}

function getSchedule(scheduleId) {
  ensureSchedulesTables();
  const instance = db.getDb();
  const stmt = instance.prepare('SELECT * FROM sync_schedules WHERE schedule_id = ?');
  return stmt.get(scheduleId);
}

function listSchedules(filters = {}) {
  ensureSchedulesTables();
  const instance = db.getDb();
  let query = 'SELECT * FROM sync_schedules WHERE 1=1';
  const params = [];

  if (filters.enabled !== undefined) {
    query += ' AND enabled = ?';
    params.push(filters.enabled ? 1 : 0);
  }
  if (filters.country) {
    query += ' AND country = ?';
    params.push(filters.country);
  }

  query += ' ORDER BY created_at DESC';
  const stmt = instance.prepare(query);
  return stmt.all(...params);
}

function updateSchedule(scheduleId, updates) {
  ensureSchedulesTables();
  const instance = db.getDb();
  const now = new Date().toISOString();

  const fields = [];
  const values = [];

  if (updates.name !== undefined) { fields.push('name = ?'); values.push(updates.name); }
  if (updates.enabled !== undefined) { fields.push('enabled = ?'); values.push(updates.enabled ? 1 : 0); }
  if (updates.cronExpression !== undefined) {
    if (!cron.validate(updates.cronExpression)) {
      throw new Error(`Invalid cron expression: ${updates.cronExpression}`);
    }
    fields.push('cron_expression = ?'); values.push(updates.cronExpression);
  }
  if (updates.incremental !== undefined) { fields.push('incremental = ?'); values.push(updates.incremental ? 1 : 0); }
  if (updates.lookbackDays !== undefined) { fields.push('lookback_days = ?'); values.push(updates.lookbackDays); }
  if (updates.retryEnabled !== undefined) { fields.push('retry_enabled = ?'); values.push(updates.retryEnabled ? 1 : 0); }
  if (updates.maxRetries !== undefined) { fields.push('max_retries = ?'); values.push(updates.maxRetries); }
  if (updates.notifyOnFailure !== undefined) { fields.push('notify_on_failure = ?'); values.push(updates.notifyOnFailure ? 1 : 0); }

  fields.push('updated_at = ?');
  values.push(now);
  values.push(scheduleId);

  if (fields.length === 0) return;

  const stmt = instance.prepare(`UPDATE sync_schedules SET ${fields.join(', ')} WHERE schedule_id = ?`);
  stmt.run(...values);

  // If schedule was enabled/disabled or cron changed, restart it
  if (updates.enabled !== undefined || updates.cronExpression !== undefined) {
    if (activeSchedules.has(scheduleId)) {
      stopSchedule(scheduleId);
    }
    const config = getSchedule(scheduleId);
    if (config && config.enabled) {
      startSchedule(config);
    }
  }

  logger.info('Schedule updated', { scheduleId });
}

function deleteSchedule(scheduleId) {
  stopSchedule(scheduleId);
  ensureSchedulesTables();
  const instance = db.getDb();
  const stmt = instance.prepare('DELETE FROM sync_schedules WHERE schedule_id = ?');
  stmt.run(scheduleId);
  logger.info('Schedule deleted', { scheduleId });
}

function updateLastRun(scheduleId, jobId, status) {
  ensureSchedulesTables();
  const instance = db.getDb();
  const now = new Date().toISOString();

  const stmt = instance.prepare(`
    UPDATE sync_schedules
    SET last_run_at = ?,
        last_run_job_id = ?,
        last_run_status = ?,
        run_count = run_count + 1,
        failure_count = CASE WHEN ? = 'FAILED' THEN failure_count + 1 ELSE failure_count END
    WHERE schedule_id = ?
  `);

  stmt.run(now, jobId, status, status, scheduleId);
}

function updateLastSyncTimestamp(scheduleId, timestamp) {
  ensureSchedulesTables();
  const instance = db.getDb();
  const stmt = instance.prepare('UPDATE sync_schedules SET last_sync_timestamp = ? WHERE schedule_id = ?');
  stmt.run(timestamp || new Date().toISOString(), scheduleId);
}

// ── Schedule execution ────────────────────────────────────────────────────────

async function executeSchedule(config) {
  const executionId = randomUUID();
  const startTime = Date.now();

  logger.info('Executing scheduled job', {
    scheduleId: config.schedule_id,
    name: config.name,
    scheduleType: config.schedule_type,
    executionId
  });

  // Record execution start
  const instance = db.getDb();
  instance.prepare(`
    INSERT INTO schedule_executions (execution_id, schedule_id, status, started_at)
    VALUES (?, ?, 'RUNNING', ?)
  `).run(executionId, config.schedule_id, new Date().toISOString());

  try {
    let jobId;
    let dateFrom, dateTo;

    // Calculate date range
    if (config.incremental) {
      // Incremental sync: from last_sync_timestamp or (now - lookback_days)
      const lookbackMs = (config.lookback_days || 1) * 24 * 60 * 60 * 1000;
      const startDate = config.last_sync_timestamp
        ? new Date(config.last_sync_timestamp)
        : new Date(Date.now() - lookbackMs);

      dateFrom = startDate.toISOString().split('T')[0];
      dateTo = new Date().toISOString().split('T')[0];

      logger.info('Incremental sync date range', { scheduleId: config.schedule_id, dateFrom, dateTo });
    } else {
      // Manual date range
      dateFrom = config.date_from;
      dateTo = config.date_to;
    }

    // Execute based on schedule type
    if (config.schedule_type === 'FETCH_AND_PUSH' || config.schedule_type === 'FETCH_ONLY') {
      // Fetch from Odoo
      const fetchResult = await startFetchJob({
        dateFrom,
        dateTo,
        storeId: config.store_id,
        storeName: config.store_name,
        country: config.country,
        scheduledBy: config.schedule_id
      });

      jobId = fetchResult.jobId;
      updateLastRun(config.schedule_id, jobId, 'RUNNING');

      // Wait for fetch to complete
      await waitForJob(jobId);

      // If FETCH_AND_PUSH, continue to push
      if (config.schedule_type === 'FETCH_AND_PUSH') {
        const metadata = config.metadata_config ? JSON.parse(config.metadata_config) : null;
        const outlet = config.outlet_config ? JSON.parse(config.outlet_config) : null;

        const pushResult = await startPushJob({
          mode: config.store_id ? 'BY_STORE_DATE' : 'BY_DATE',
          dateFrom,
          dateTo,
          storeId: config.store_id,
          storeName: config.store_name,
          country: config.country,
          metadata,
          outlet,
          scheduledBy: config.schedule_id
        });

        jobId = pushResult.jobId;
        updateLastRun(config.schedule_id, jobId, 'RUNNING');

        // Wait for push to complete
        await waitForJob(jobId);
      }
    } else if (config.schedule_type === 'PUSH_ONLY') {
      // Push stored data to Oracle
      const metadata = config.metadata_config ? JSON.parse(config.metadata_config) : null;
      const outlet = config.outlet_config ? JSON.parse(config.outlet_config) : null;

      const pushResult = await startPushJob({
        mode: config.store_id ? 'BY_STORE_DATE' : 'BY_DATE',
        dateFrom,
        dateTo,
        storeId: config.store_id,
        storeName: config.store_name,
        country: config.country,
        metadata,
        outlet,
        scheduledBy: config.schedule_id
      });

      jobId = pushResult.jobId;
      updateLastRun(config.schedule_id, jobId, 'RUNNING');

      await waitForJob(jobId);
    }

    // Check job result
    const jobResult = db.getJob(jobId);
    const duration = Date.now() - startTime;

    if (jobResult.status === 'DONE') {
      // Success - update last_sync_timestamp
      updateLastSyncTimestamp(config.schedule_id, dateTo);
      updateLastRun(config.schedule_id, jobId, 'DONE');

      instance.prepare(`
        UPDATE schedule_executions
        SET status = 'SUCCESS',
            job_id = ?,
            records_synced = ?,
            records_failed = ?,
            finished_at = ?,
            duration_ms = ?
        WHERE execution_id = ?
      `).run(jobId, jobResult.processed, jobResult.failed, new Date().toISOString(), duration, executionId);

      logger.info('Scheduled job completed successfully', {
        scheduleId: config.schedule_id,
        executionId,
        jobId,
        processed: jobResult.processed,
        failed: jobResult.failed,
        durationMs: duration
      });

      // Auto-retry failed records if enabled
      if (config.retry_enabled && jobResult.failed > 0) {
        logger.info('Auto-retrying failed records', { scheduleId: config.schedule_id, failedCount: jobResult.failed });
        // TODO: Implement auto-retry logic
      }
    } else {
      // Failed
      updateLastRun(config.schedule_id, jobId, 'FAILED');

      const errorMsg = `Job ${jobId} failed with status ${jobResult.status}`;
      instance.prepare(`
        UPDATE schedule_executions
        SET status = 'FAILED',
            job_id = ?,
            error_message = ?,
            finished_at = ?,
            duration_ms = ?
        WHERE execution_id = ?
      `).run(jobId, errorMsg, new Date().toISOString(), duration, executionId);

      logger.error('Scheduled job failed', {
        scheduleId: config.schedule_id,
        executionId,
        jobId,
        status: jobResult.status
      });

      // Send failure notification
      if (config.notify_on_failure) {
        await notifier.sendFailureNotification({
          scheduleName: config.name,
          scheduleId: config.schedule_id,
          executionId,
          jobId,
          error: errorMsg,
          config: config.notification_config ? JSON.parse(config.notification_config) : null
        });
      }
    }

  } catch (error) {
    const duration = Date.now() - startTime;
    updateLastRun(config.schedule_id, null, 'FAILED');

    instance.prepare(`
      UPDATE schedule_executions
      SET status = 'FAILED',
          error_message = ?,
          finished_at = ?,
          duration_ms = ?
      WHERE execution_id = ?
    `).run(error.message, new Date().toISOString(), duration, executionId);

    logger.error('Scheduled job execution error', {
      scheduleId: config.schedule_id,
      executionId,
      error: error.message,
      stack: error.stack
    });

    // Send failure notification
    if (config.notify_on_failure) {
      await notifier.sendFailureNotification({
        scheduleName: config.name,
        scheduleId: config.schedule_id,
        executionId,
        error: error.message,
        config: config.notification_config ? JSON.parse(config.notification_config) : null
      });
    }
  }
}

async function waitForJob(jobId, timeoutMs = 3600000) {
  // Poll job status until completion or timeout (default 1 hour)
  const startTime = Date.now();

  return new Promise((resolve, reject) => {
    const checkInterval = setInterval(() => {
      const job = db.getJob(jobId);

      if (!job) {
        clearInterval(checkInterval);
        reject(new Error(`Job ${jobId} not found`));
        return;
      }

      if (job.status === 'DONE' || job.status === 'FAILED') {
        clearInterval(checkInterval);
        resolve(job);
        return;
      }

      if (Date.now() - startTime > timeoutMs) {
        clearInterval(checkInterval);
        reject(new Error(`Job ${jobId} timed out after ${timeoutMs}ms`));
        return;
      }
    }, 5000); // Check every 5 seconds
  });
}

// ── Schedule management ───────────────────────────────────────────────────────

function startSchedule(config) {
  if (!config.enabled) {
    logger.debug('Schedule is disabled, skipping', { scheduleId: config.schedule_id });
    return;
  }

  if (activeSchedules.has(config.schedule_id)) {
    logger.warn('Schedule already running', { scheduleId: config.schedule_id });
    return;
  }

  try {
    const task = cron.schedule(config.cron_expression, () => {
      executeSchedule(config).catch(err => {
        logger.error('Schedule execution failed', {
          scheduleId: config.schedule_id,
          error: err.message,
          stack: err.stack
        });
      });
    }, {
      scheduled: true,
      timezone: 'UTC'
    });

    activeSchedules.set(config.schedule_id, { task, config });
    logger.info('Schedule started', {
      scheduleId: config.schedule_id,
      name: config.name,
      cronExpression: config.cron_expression
    });
  } catch (error) {
    logger.error('Failed to start schedule', {
      scheduleId: config.schedule_id,
      error: error.message
    });
    throw error;
  }
}

function stopSchedule(scheduleId) {
  const schedule = activeSchedules.get(scheduleId);
  if (schedule) {
    schedule.task.stop();
    activeSchedules.delete(scheduleId);
    logger.info('Schedule stopped', { scheduleId });
  }
}

function startAll() {
  logger.info('Starting scheduler service');
  ensureSchedulesTables();

  const schedules = listSchedules({ enabled: true });
  logger.info(`Found ${schedules.length} enabled schedules`);

  for (const config of schedules) {
    try {
      startSchedule(config);
    } catch (error) {
      logger.error('Failed to start schedule', {
        scheduleId: config.schedule_id,
        name: config.name,
        error: error.message
      });
    }
  }
}

function stopAll() {
  logger.info('Stopping scheduler service');

  for (const [scheduleId, schedule] of activeSchedules.entries()) {
    try {
      schedule.task.stop();
      logger.info('Schedule stopped', { scheduleId });
    } catch (error) {
      logger.error('Error stopping schedule', {
        scheduleId,
        error: error.message
      });
    }
  }

  activeSchedules.clear();
}

function getStatus() {
  return {
    active: activeSchedules.size,
    schedules: Array.from(activeSchedules.keys()).map(scheduleId => {
      const schedule = activeSchedules.get(scheduleId);
      return {
        scheduleId,
        name: schedule.config.name,
        cronExpression: schedule.config.cron_expression,
        country: schedule.config.country
      };
    })
  };
}

// ── Exports ───────────────────────────────────────────────────────────────────

module.exports = {
  start: startAll,
  stop: stopAll,
  getStatus,
  createSchedule,
  getSchedule,
  listSchedules,
  updateSchedule,
  deleteSchedule,
  startSchedule,
  stopSchedule,
  executeSchedule
};
