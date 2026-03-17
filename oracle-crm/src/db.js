'use strict';

/**
 * db.js
 *
 * SQLite database helper for the Odoo Sales module.
 *
 * Tables:
 *   odoo_sales       – Odoo sale order headers fetched from the Odoo API
 *   odoo_sale_lines  – Line items belonging to each Odoo sale order
 *   push_jobs        – Background push-to-Oracle job tracking
 *   job_logs         – Per-entry job log rows (replaces the JSON-blob log column
 *                      in push_jobs for O(1) appends at any data volume)
 *   failed_records   – Individual sales that failed to push, queued for retry
 *
 * Uses better-sqlite3 (synchronous, zero-dependency SQLite3 bindings for Node).
 * Because better-sqlite3 calls are synchronous they MUST NOT be called from the
 * main HTTP request/response cycle directly; always wrap in setImmediate or run
 * inside background workers.  For small batches (< 10 k rows) the latency is
 * negligible and Node's event-loop won't stall because SQLite I/O completes in
 * microseconds.
 *
 * Production-scale notes:
 *   • WAL mode + 64 MB page cache + 256 MB mmap comfortably handles millions of rows.
 *   • All multi-row writes use explicit transactions (one fsync per batch, not per row).
 *   • job_logs uses an indexed table so appends stay O(1) regardless of log length.
 *   • failed_records gives a durable, queryable retry queue – failures never block
 *     the main job and are never silently discarded.
 */

const path    = require('path');
const fs      = require('fs');
const Database = require('better-sqlite3');
const logger  = require('./logger').child('DB');

// ── DB file ───────────────────────────────────────────────────────────────────
const DB_DIR  = path.join(__dirname, '..', 'data');
const DB_FILE = path.join(DB_DIR, 'odoo_sales.db');

if (!fs.existsSync(DB_DIR)) fs.mkdirSync(DB_DIR, { recursive: true });

// ── Open / init ───────────────────────────────────────────────────────────────
let _db = null;

function getDb() {
  if (_db) return _db;
  _db = new Database(DB_FILE);
  _db.pragma('journal_mode = WAL');      // concurrent reads + single writer
  _db.pragma('foreign_keys = ON');
  _db.pragma('synchronous = NORMAL');    // safe + fast (WAL makes this sufficient)
  _db.pragma('cache_size = -65536');     // 64 MB page cache (negative = kibibytes)
  _db.pragma('temp_store = MEMORY');     // temp tables / sort buffers in RAM
  _db.pragma('mmap_size = 268435456');   // 256 MB memory-mapped I/O for reads
  applyMigrations(_db);
  logger.info('SQLite DB initialised', { file: DB_FILE });
  return _db;
}

// ── Schema migrations ─────────────────────────────────────────────────────────
function applyMigrations(db) {
  db.exec(`
    CREATE TABLE IF NOT EXISTS odoo_sales (
      id              INTEGER PRIMARY KEY AUTOINCREMENT,
      odoo_id         INTEGER NOT NULL,
      name            TEXT    NOT NULL,          -- SO number e.g. S00123
      store_id        INTEGER,
      store_name      TEXT,
      date_order      TEXT    NOT NULL,          -- ISO date (YYYY-MM-DD)
      partner_id      INTEGER,
      partner_name    TEXT,
      currency        TEXT    DEFAULT 'AED',
      amount_untaxed  REAL    DEFAULT 0,
      amount_tax      REAL    DEFAULT 0,
      amount_total    REAL    DEFAULT 0,
      state           TEXT,                      -- draft|sent|sale|done|cancel
      fetched_at      TEXT    NOT NULL,          -- ISO timestamp of fetch
      raw_json        TEXT,                      -- full Odoo JSON (for debugging)
      UNIQUE(odoo_id)
    );

    CREATE TABLE IF NOT EXISTS odoo_sale_lines (
      id              INTEGER PRIMARY KEY AUTOINCREMENT,
      sale_id         INTEGER NOT NULL REFERENCES odoo_sales(id) ON DELETE CASCADE,
      odoo_line_id    INTEGER NOT NULL,
      product_id      INTEGER,
      product_name    TEXT,
      qty_ordered     REAL    DEFAULT 0,
      qty_delivered   REAL    DEFAULT 0,
      price_unit      REAL    DEFAULT 0,
      price_subtotal  REAL    DEFAULT 0,
      tax_ids         TEXT,                      -- JSON array of tax IDs
      UNIQUE(odoo_line_id)
    );

    CREATE TABLE IF NOT EXISTS push_jobs (
      id            INTEGER PRIMARY KEY AUTOINCREMENT,
      job_id        TEXT    NOT NULL UNIQUE,     -- UUID
      mode          TEXT    NOT NULL,            -- BY_DATE | BY_STORE_DATE | ALL_STORES_DATE
      date_from     TEXT,                        -- YYYY-MM-DD
      date_to       TEXT,                        -- YYYY-MM-DD
      store_id      INTEGER,
      store_name    TEXT,
      status        TEXT    NOT NULL DEFAULT 'QUEUED',  -- QUEUED|RUNNING|DONE|FAILED
      total         INTEGER DEFAULT 0,
      processed     INTEGER DEFAULT 0,
      failed        INTEGER DEFAULT 0,
      started_at    TEXT,
      finished_at   TEXT,
      log           TEXT    DEFAULT '[]',        -- kept for backward compat; new logs go to job_logs table
      created_at    TEXT    NOT NULL
    );

    -- Structured per-entry log rows.  O(1) INSERT; no JSON blob rewriting.
    CREATE TABLE IF NOT EXISTS job_logs (
      id         INTEGER PRIMARY KEY AUTOINCREMENT,
      job_id     TEXT    NOT NULL,
      level      TEXT    NOT NULL DEFAULT 'info',   -- debug|info|warn|error
      message    TEXT    NOT NULL,
      meta_json  TEXT,                              -- optional JSON metadata
      created_at TEXT    NOT NULL
    );

    -- Individual records that failed to push to Oracle.
    -- They are never silently dropped; the main job continues unblocked.
    CREATE TABLE IF NOT EXISTS failed_records (
      id              INTEGER PRIMARY KEY AUTOINCREMENT,
      job_id          TEXT    NOT NULL,
      sale_name       TEXT,
      odoo_id         INTEGER,
      error_message   TEXT,
      error_detail    TEXT,                          -- full stack / API response
      retry_count     INTEGER NOT NULL DEFAULT 0,
      status          TEXT    NOT NULL DEFAULT 'PENDING',  -- PENDING|RESOLVED|SKIPPED
      created_at      TEXT    NOT NULL,
      last_attempt_at TEXT
    );

    CREATE INDEX IF NOT EXISTS idx_odoo_sales_date       ON odoo_sales(date_order);
    CREATE INDEX IF NOT EXISTS idx_odoo_sales_store      ON odoo_sales(store_id);
    CREATE INDEX IF NOT EXISTS idx_push_jobs_status      ON push_jobs(status);
    CREATE INDEX IF NOT EXISTS idx_job_logs_job_id       ON job_logs(job_id);
    CREATE INDEX IF NOT EXISTS idx_failed_records_job    ON failed_records(job_id);
    CREATE INDEX IF NOT EXISTS idx_failed_records_status ON failed_records(status);
  `);
}

// ── Odoo Sales helpers ────────────────────────────────────────────────────────

/**
 * Upsert a batch of sale headers.
 * @param {object[]} sales
 */
function upsertSales(sales) {
  const db = getDb();
  const stmt = db.prepare(`
    INSERT INTO odoo_sales
      (odoo_id, name, store_id, store_name, date_order, partner_id, partner_name,
       currency, amount_untaxed, amount_tax, amount_total, state, fetched_at, raw_json)
    VALUES
      (@odoo_id, @name, @store_id, @store_name, @date_order, @partner_id, @partner_name,
       @currency, @amount_untaxed, @amount_tax, @amount_total, @state, @fetched_at, @raw_json)
    ON CONFLICT(odoo_id) DO UPDATE SET
      name           = excluded.name,
      store_id       = excluded.store_id,
      store_name     = excluded.store_name,
      date_order     = excluded.date_order,
      partner_id     = excluded.partner_id,
      partner_name   = excluded.partner_name,
      currency       = excluded.currency,
      amount_untaxed = excluded.amount_untaxed,
      amount_tax     = excluded.amount_tax,
      amount_total   = excluded.amount_total,
      state          = excluded.state,
      fetched_at     = excluded.fetched_at,
      raw_json       = excluded.raw_json
  `);

  const run = db.transaction(rows => rows.forEach(r => stmt.run(r)));
  run(sales);
  logger.debug('Upserted odoo_sales', { count: sales.length });
}

/**
 * Upsert a batch of sale lines.
 * @param {object[]} lines
 */
function upsertSaleLines(lines) {
  const db = getDb();
  const stmt = db.prepare(`
    INSERT INTO odoo_sale_lines
      (sale_id, odoo_line_id, product_id, product_name,
       qty_ordered, qty_delivered, price_unit, price_subtotal, tax_ids)
    VALUES
      (@sale_id, @odoo_line_id, @product_id, @product_name,
       @qty_ordered, @qty_delivered, @price_unit, @price_subtotal, @tax_ids)
    ON CONFLICT(odoo_line_id) DO UPDATE SET
      product_id     = excluded.product_id,
      product_name   = excluded.product_name,
      qty_ordered    = excluded.qty_ordered,
      qty_delivered  = excluded.qty_delivered,
      price_unit     = excluded.price_unit,
      price_subtotal = excluded.price_subtotal,
      tax_ids        = excluded.tax_ids
  `);

  const run = db.transaction(rows => rows.forEach(r => stmt.run(r)));
  run(lines);
  logger.debug('Upserted odoo_sale_lines', { count: lines.length });
}

/**
 * Query stored sales with optional filters.
 * @param {object} filters
 * @param {string}  [filters.dateFrom]  YYYY-MM-DD
 * @param {string}  [filters.dateTo]    YYYY-MM-DD
 * @param {number}  [filters.storeId]
 * @param {number}  [filters.limit]     default 500
 * @param {number}  [filters.offset]    default 0
 */
function querySales({ dateFrom, dateTo, storeId, limit = 500, offset = 0 } = {}) {
  const db = getDb();
  const conditions = [];
  const params     = {};

  if (dateFrom) { conditions.push('date_order >= @dateFrom'); params.dateFrom = dateFrom; }
  if (dateTo)   { conditions.push('date_order <= @dateTo');   params.dateTo   = dateTo;   }
  if (storeId)  { conditions.push('store_id = @storeId');     params.storeId  = storeId;  }

  const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';
  params.limit  = limit;
  params.offset = offset;

  const rows = db.prepare(
    `SELECT * FROM odoo_sales ${where} ORDER BY date_order DESC, id DESC LIMIT @limit OFFSET @offset`
  ).all(params);

  const total = db.prepare(
    `SELECT COUNT(*) AS cnt FROM odoo_sales ${where}`
  ).get(params).cnt;

  return { rows, total };
}

/**
 * Get a single sale by its internal DB id with its lines.
 * @param {number} id
 */
function getSaleWithLines(id) {
  const db   = getDb();
  const sale = db.prepare('SELECT * FROM odoo_sales WHERE id = ?').get(id);
  if (!sale) return null;
  sale.lines = db.prepare('SELECT * FROM odoo_sale_lines WHERE sale_id = ?').all(id);
  return sale;
}

/**
 * Get internal DB id by Odoo ID.
 * @param {number} odooId
 */
function getSaleInternalId(odooId) {
  const db  = getDb();
  const row = db.prepare('SELECT id FROM odoo_sales WHERE odoo_id = ?').get(odooId);
  return row ? row.id : null;
}

// ── Push job helpers ──────────────────────────────────────────────────────────

function createJob(job) {
  const db = getDb();
  db.prepare(`
    INSERT INTO push_jobs (job_id, mode, date_from, date_to, store_id, store_name, status, log, created_at)
    VALUES (@job_id, @mode, @date_from, @date_to, @store_id, @store_name, 'QUEUED', '[]', @created_at)
  `).run({
    job_id     : job.jobId,
    mode       : job.mode,
    date_from  : job.dateFrom  || null,
    date_to    : job.dateTo    || null,
    store_id   : job.storeId   || null,
    store_name : job.storeName || null,
    created_at : new Date().toISOString(),
  });
}

function updateJob(jobId, fields) {
  const db = getDb();
  const allowed = ['status', 'total', 'processed', 'failed', 'started_at', 'finished_at'];
  const sets = Object.keys(fields)
    .filter(k => allowed.includes(k))
    .map(k => `${k} = @${k}`)
    .join(', ');
  if (!sets) return;
  db.prepare(`UPDATE push_jobs SET ${sets} WHERE job_id = @job_id`)
    .run({ ...fields, job_id: jobId });
}

/**
 * Append a structured log entry to the job_logs table.
 * O(1) per call regardless of how many entries already exist.
 *
 * @param {string} jobId
 * @param {{ level: string, message: string, [key: string]: any }} entry
 */
function appendJobLog(jobId, entry) {
  const db = getDb();
  const { level = 'info', message, ...rest } = entry;
  const metaJson = Object.keys(rest).length ? JSON.stringify(rest) : null;
  db.prepare(
    'INSERT INTO job_logs (job_id, level, message, meta_json, created_at) VALUES (?, ?, ?, ?, ?)'
  ).run(jobId, level, message, metaJson, new Date().toISOString());
}

/**
 * Retrieve log entries for a job with cursor-based pagination.
 *
 * @param {string} jobId
 * @param {object} opts
 * @param {number} [opts.limit=100]
 * @param {number} [opts.offset=0]
 * @returns {{ rows: object[], total: number }}
 */
function getJobLogs(jobId, { limit = 100, offset = 0 } = {}) {
  const db    = getDb();
  const rows  = db.prepare(
    'SELECT id, level, message, meta_json, created_at FROM job_logs WHERE job_id = ? ORDER BY id ASC LIMIT ? OFFSET ?'
  ).all(jobId, limit, offset);
  const total = db.prepare(
    'SELECT COUNT(*) AS cnt FROM job_logs WHERE job_id = ?'
  ).get(jobId).cnt;
  return { rows, total };
}

function getJob(jobId) {
  const db = getDb();
  const job = db.prepare(
    'SELECT id, job_id, mode, date_from, date_to, store_id, store_name, status, total, processed, failed, started_at, finished_at, created_at FROM push_jobs WHERE job_id = ?'
  ).get(jobId);
  return job || null;
}

function listJobs(limit = 50) {
  const db = getDb();
  return db.prepare(
    'SELECT id, job_id, mode, date_from, date_to, store_id, store_name, status, total, processed, failed, started_at, finished_at, created_at FROM push_jobs ORDER BY created_at DESC LIMIT ?'
  ).all(limit);
}

// ── Failed-record helpers ─────────────────────────────────────────────────────

/**
 * Insert a failed-record event.  The main job continues; this record is queued
 * for manual review or automatic retry.
 *
 * @param {object} fields
 * @param {string}  fields.jobId
 * @param {string}  [fields.saleName]
 * @param {number}  [fields.odooId]
 * @param {string}  [fields.errorMessage]
 * @param {string}  [fields.errorDetail]    full stack trace or API response body
 */
function insertFailedRecord({ jobId, saleName, odooId, errorMessage, errorDetail } = {}) {
  const db = getDb();
  db.prepare(`
    INSERT INTO failed_records (job_id, sale_name, odoo_id, error_message, error_detail, created_at)
    VALUES (?, ?, ?, ?, ?, ?)
  `).run(jobId, saleName || null, odooId || null, errorMessage || null, errorDetail || null, new Date().toISOString());
}

/**
 * List failed records with optional filters.
 *
 * @param {object} opts
 * @param {string}  [opts.jobId]
 * @param {string}  [opts.status]   PENDING | RESOLVED | SKIPPED
 * @param {number}  [opts.limit=100]
 * @param {number}  [opts.offset=0]
 * @returns {{ rows: object[], total: number }}
 */
function listFailedRecords({ jobId, status, limit = 100, offset = 0 } = {}) {
  const db         = getDb();
  const conditions = [];
  const params     = [];

  if (jobId)  { conditions.push('job_id = ?');  params.push(jobId);  }
  if (status) { conditions.push('status = ?');  params.push(status); }

  const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';

  const rows = db.prepare(
    `SELECT * FROM failed_records ${where} ORDER BY created_at DESC LIMIT ? OFFSET ?`
  ).all(...params, limit, offset);

  const total = db.prepare(
    `SELECT COUNT(*) AS cnt FROM failed_records ${where}`
  ).get(...params).cnt;

  return { rows, total };
}

/**
 * Mark a failed record with a new status (RESOLVED or SKIPPED) and bump retry_count.
 *
 * @param {number} id  – failed_records.id
 * @param {string} status  – 'RESOLVED' | 'SKIPPED'
 */
function updateFailedRecord(id, status) {
  const db = getDb();
  db.prepare(
    'UPDATE failed_records SET status = ?, retry_count = retry_count + 1, last_attempt_at = ? WHERE id = ?'
  ).run(status, new Date().toISOString(), id);
}

module.exports = {
  getDb,
  upsertSales,
  upsertSaleLines,
  querySales,
  getSaleWithLines,
  getSaleInternalId,
  createJob,
  updateJob,
  appendJobLog,
  getJobLogs,
  getJob,
  listJobs,
  insertFailedRecord,
  listFailedRecords,
  updateFailedRecord,
};
