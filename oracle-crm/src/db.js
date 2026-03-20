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
      country         TEXT,                      -- ISO-2 country code (AE, KW, SA …)
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

    CREATE TABLE IF NOT EXISTS odoo_sale_payments (
      id               INTEGER PRIMARY KEY AUTOINCREMENT,
      sale_id          INTEGER REFERENCES odoo_sales(id) ON DELETE CASCADE,
      invoice_number   TEXT    NOT NULL,          -- sale order name (e.g. S00123)
      odoo_payment_id  INTEGER NOT NULL,           -- account.payment id
      payment_type     TEXT,                       -- journal/payment method name (Cash, Visa, etc.)
      amount           REAL    DEFAULT 0,          -- payment amount
      currency         TEXT    DEFAULT 'AED',
      payment_date     TEXT,                       -- ISO date YYYY-MM-DD
      outlet_name      TEXT,                       -- warehouse/store name
      register_name    TEXT,                       -- sales team name
      region           TEXT,                       -- ISO-2 country code
      fetched_at       TEXT    NOT NULL,
      UNIQUE(odoo_payment_id)
    );

    CREATE INDEX IF NOT EXISTS idx_odoo_sale_payments_sale   ON odoo_sale_payments(sale_id);
    CREATE INDEX IF NOT EXISTS idx_odoo_sale_payments_inv    ON odoo_sale_payments(invoice_number);
    CREATE INDEX IF NOT EXISTS idx_odoo_sale_payments_date   ON odoo_sale_payments(payment_date);

    CREATE TABLE IF NOT EXISTS push_jobs (
      id            INTEGER PRIMARY KEY AUTOINCREMENT,
      job_id        TEXT    NOT NULL UNIQUE,     -- UUID
      job_type      TEXT    NOT NULL DEFAULT 'PUSH', -- FETCH | PUSH | RETRY
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

  // Additive migrations – safe to run on an existing DB.
  // SQLite's ALTER TABLE ADD COLUMN fails with "duplicate column name" when the
  // column already exists; we catch only that specific error so genuine schema
  // problems (table missing, disk full, etc.) still bubble up.
  const alterSafely = (sql) => {
    try {
      db.exec(sql);
    } catch (err) {
      if (!err.message || !err.message.includes('duplicate column name')) throw err;
    }
  };
  alterSafely('ALTER TABLE odoo_sales ADD COLUMN oracle_txn_id TEXT');
  alterSafely('ALTER TABLE odoo_sales ADD COLUMN pushed_at     TEXT');
  alterSafely('ALTER TABLE odoo_sales ADD COLUMN push_job_id   TEXT');
  alterSafely('ALTER TABLE odoo_sales ADD COLUMN country       TEXT');
  alterSafely("ALTER TABLE push_jobs  ADD COLUMN job_type TEXT NOT NULL DEFAULT 'PUSH'");
  alterSafely('ALTER TABLE odoo_sales ADD COLUMN customer_type TEXT');
  alterSafely('ALTER TABLE odoo_sales ADD COLUMN register_name TEXT');
  alterSafely('ALTER TABLE odoo_sale_lines ADD COLUMN item_number TEXT');
  alterSafely('ALTER TABLE odoo_sale_lines ADD COLUMN tax_name TEXT');
  alterSafely('ALTER TABLE odoo_sale_lines ADD COLUMN line_number INTEGER');
  alterSafely('ALTER TABLE odoo_sale_lines ADD COLUMN total_discount REAL DEFAULT 0');
  try {
    db.exec('CREATE INDEX IF NOT EXISTS idx_odoo_sales_txn      ON odoo_sales(oracle_txn_id)');
    db.exec('CREATE INDEX IF NOT EXISTS idx_odoo_sales_country  ON odoo_sales(country)');
    db.exec('CREATE INDEX IF NOT EXISTS idx_push_jobs_type      ON push_jobs(job_type)');
  } catch (_) { /* already exists */ }

  // app_settings – persistent key/value store for server-mode and credentials.
  // Values are never committed to source control; all writes go through setAppSetting().
  db.exec(`
    CREATE TABLE IF NOT EXISTS app_settings (
      key        TEXT PRIMARY KEY,
      value      TEXT,
      updated_at TEXT NOT NULL DEFAULT (datetime('now'))
    );
  `);

  db.prepare(`
    CREATE TABLE IF NOT EXISTS country_configs (
      id              INTEGER PRIMARY KEY AUTOINCREMENT,
      country_code    TEXT    NOT NULL UNIQUE,
      country_name    TEXT    NOT NULL,
      odoo_url        TEXT,
      odoo_db         TEXT,
      odoo_username   TEXT,
      odoo_password   TEXT,
      odoo_auth_type  TEXT    NOT NULL DEFAULT 'jsonrpc',
      odoo_api_key    TEXT,
      odoo_api_url    TEXT,
      oracle_base_url TEXT,
      oracle_username TEXT,
      oracle_password TEXT,
      enabled         INTEGER NOT NULL DEFAULT 1,
      created_at      TEXT    NOT NULL DEFAULT (datetime('now')),
      updated_at      TEXT    NOT NULL DEFAULT (datetime('now'))
    )
  `).run();

  // Additive migrations for country_configs (must run after CREATE TABLE above)
  alterSafely("ALTER TABLE country_configs ADD COLUMN odoo_auth_type TEXT NOT NULL DEFAULT 'jsonrpc'");
  alterSafely('ALTER TABLE country_configs ADD COLUMN odoo_api_key        TEXT');
  alterSafely('ALTER TABLE country_configs ADD COLUMN odoo_api_url        TEXT');
  // Per-country REST API endpoint paths (override the default paths in OdooRestClient)
  alterSafely('ALTER TABLE country_configs ADD COLUMN odoo_sale_detail_path TEXT');
  alterSafely('ALTER TABLE country_configs ADD COLUMN odoo_order_line_path  TEXT');
  alterSafely('ALTER TABLE country_configs ADD COLUMN odoo_payment_path     TEXT');

  db.prepare(`
    CREATE TABLE IF NOT EXISTS users (
      id           INTEGER PRIMARY KEY AUTOINCREMENT,
      username     TEXT    NOT NULL UNIQUE,
      email        TEXT    UNIQUE,
      password_hash TEXT   NOT NULL,
      role         TEXT    NOT NULL DEFAULT 'operator',
      display_name TEXT,
      avatar_data  TEXT,
      created_at   TEXT    NOT NULL DEFAULT (datetime('now')),
      updated_at   TEXT    NOT NULL DEFAULT (datetime('now')),
      last_login   TEXT
    )
  `).run();
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
      (odoo_id, name, store_id, store_name, country, date_order, partner_id, partner_name,
       currency, amount_untaxed, amount_tax, amount_total, state, customer_type, register_name, fetched_at, raw_json)
    VALUES
      (@odoo_id, @name, @store_id, @store_name, @country, @date_order, @partner_id, @partner_name,
       @currency, @amount_untaxed, @amount_tax, @amount_total, @state, @customer_type, @register_name, @fetched_at, @raw_json)
    ON CONFLICT(odoo_id) DO UPDATE SET
      name           = excluded.name,
      store_id       = excluded.store_id,
      store_name     = excluded.store_name,
      country        = excluded.country,
      date_order     = excluded.date_order,
      partner_id     = excluded.partner_id,
      partner_name   = excluded.partner_name,
      currency       = excluded.currency,
      amount_untaxed = excluded.amount_untaxed,
      amount_tax     = excluded.amount_tax,
      amount_total   = excluded.amount_total,
      state          = excluded.state,
      customer_type  = excluded.customer_type,
      register_name  = excluded.register_name,
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
      (sale_id, odoo_line_id, product_id, product_name, item_number, tax_name, line_number,
       qty_ordered, qty_delivered, price_unit, price_subtotal, total_discount, tax_ids)
    VALUES
      (@sale_id, @odoo_line_id, @product_id, @product_name, @item_number, @tax_name, @line_number,
       @qty_ordered, @qty_delivered, @price_unit, @price_subtotal, @total_discount, @tax_ids)
    ON CONFLICT(odoo_line_id) DO UPDATE SET
      product_id     = excluded.product_id,
      product_name   = excluded.product_name,
      item_number    = excluded.item_number,
      tax_name       = excluded.tax_name,
      line_number    = excluded.line_number,
      qty_ordered    = excluded.qty_ordered,
      qty_delivered  = excluded.qty_delivered,
      price_unit     = excluded.price_unit,
      price_subtotal = excluded.price_subtotal,
      total_discount = excluded.total_discount,
      tax_ids        = excluded.tax_ids
  `);

  const run = db.transaction(rows => rows.forEach(r => stmt.run(r)));
  run(lines);
  logger.debug('Upserted odoo_sale_lines', { count: lines.length });
}

/**
 * Upsert a batch of sale payment records.
 * Mirrors middleware BackupVendhqPayments.
 * @param {object[]} payments
 */
function upsertSalePayments(payments) {
  const db = getDb();
  const stmt = db.prepare(`
    INSERT INTO odoo_sale_payments
      (sale_id, invoice_number, odoo_payment_id, payment_type, amount, currency,
       payment_date, outlet_name, register_name, region, fetched_at)
    VALUES
      (@sale_id, @invoice_number, @odoo_payment_id, @payment_type, @amount, @currency,
       @payment_date, @outlet_name, @register_name, @region, @fetched_at)
    ON CONFLICT(odoo_payment_id) DO UPDATE SET
      sale_id        = excluded.sale_id,
      invoice_number = excluded.invoice_number,
      payment_type   = excluded.payment_type,
      amount         = excluded.amount,
      currency       = excluded.currency,
      payment_date   = excluded.payment_date,
      outlet_name    = excluded.outlet_name,
      register_name  = excluded.register_name,
      region         = excluded.region,
      fetched_at     = excluded.fetched_at
  `);

  const run = db.transaction(rows => rows.forEach(r => stmt.run(r)));
  run(payments);
  logger.debug('Upserted odoo_sale_payments', { count: payments.length });
}

/**
 * Query stored sale payments with optional filters.
 * @param {object} filters
 * @param {string}  [filters.invoiceNumber]
 * @param {string}  [filters.dateFrom]
 * @param {string}  [filters.dateTo]
 * @param {string}  [filters.region]
 * @param {number}  [filters.saleId]
 * @param {number}  [filters.limit=500]
 * @param {number}  [filters.offset=0]
 */
function querySalePayments({ invoiceNumber, dateFrom, dateTo, region, saleId, limit = 500, offset = 0 } = {}) {
  const db         = getDb();
  const conditions = [];
  const params     = {};

  if (invoiceNumber) { conditions.push('invoice_number = @invoiceNumber'); params.invoiceNumber = invoiceNumber; }
  if (dateFrom)      { conditions.push('payment_date >= @dateFrom');        params.dateFrom      = dateFrom; }
  if (dateTo)        { conditions.push('payment_date <= @dateTo');          params.dateTo        = dateTo;   }
  if (region)        { conditions.push('region = @region');                 params.region        = region;   }
  if (saleId)        { conditions.push('sale_id = @saleId');               params.saleId        = saleId;   }

  const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';
  params.limit  = limit;
  params.offset = offset;

  const rows = db.prepare(
    `SELECT * FROM odoo_sale_payments ${where} ORDER BY payment_date DESC, id DESC LIMIT @limit OFFSET @offset`
  ).all(params);

  const total = db.prepare(
    `SELECT COUNT(*) AS cnt FROM odoo_sale_payments ${where}`
  ).get(params).cnt;

  return { rows, total };
}

/**
 *
 * @param {number} id            – odoo_sales.id (internal)
 * @param {string} oracleTxnId  – Oracle TransactionNumber returned by createInvoice
 * @param {string} [jobId]      – push_job that performed the push
 */
function updateSalePushStatus(id, oracleTxnId, jobId) {
  const db = getDb();
  db.prepare(
    'UPDATE odoo_sales SET oracle_txn_id = ?, pushed_at = ?, push_job_id = ? WHERE id = ?'
  ).run(oracleTxnId, new Date().toISOString(), jobId || null, id);
}

/**
 * Query stored sales with optional filters.
 * @param {object} filters
 * @param {string}  [filters.dateFrom]       YYYY-MM-DD
 * @param {string}  [filters.dateTo]         YYYY-MM-DD
 * @param {number}  [filters.storeId]
 * @param {string}  [filters.country]        ISO-2 country code
 * @param {boolean} [filters.unpushedOnly]   When true, only return sales without oracle_txn_id
 * @param {number}  [filters.limit]          default 500
 * @param {number}  [filters.offset]         default 0
 */
function querySales({ dateFrom, dateTo, storeId, country, unpushedOnly, limit = 500, offset = 0 } = {}) {
  const db = getDb();
  const conditions = [];
  const params     = {};

  if (dateFrom) { conditions.push('date_order >= @dateFrom'); params.dateFrom = dateFrom; }
  if (dateTo)   { conditions.push('date_order <= @dateTo');   params.dateTo   = dateTo;   }
  if (storeId)  { conditions.push('store_id = @storeId');     params.storeId  = storeId;  }
  if (country)  { conditions.push('country = @country');      params.country  = country;  }
  if (unpushedOnly) { conditions.push('oracle_txn_id IS NULL'); }

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
  sale.lines    = db.prepare('SELECT * FROM odoo_sale_lines WHERE sale_id = ?').all(id);
  sale.payments = db.prepare('SELECT * FROM odoo_sale_payments WHERE sale_id = ?').all(id);
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

/**
 * Bulk-fetch internal DB ids for an array of Odoo IDs.
 * Returns a Map<odooId, internalId> for all IDs that exist in the DB.
 * Much more efficient than calling getSaleInternalId() per line.
 *
 * @param {number[]} odooIds
 * @returns {Map<number, number>}
 */
function getSaleInternalIdMap(odooIds) {
  if (!odooIds || odooIds.length === 0) return new Map();
  const db  = getDb();
  // SQLite supports up to 32 766 bind parameters; chunk defensively.
  const CHUNK = 500;
  const map   = new Map();
  for (let i = 0; i < odooIds.length; i += CHUNK) {
    const slice       = odooIds.slice(i, i + CHUNK);
    const placeholders = slice.map(() => '?').join(',');
    const rows = db.prepare(
      `SELECT id, odoo_id FROM odoo_sales WHERE odoo_id IN (${placeholders})`
    ).all(...slice);
    for (const row of rows) map.set(row.odoo_id, row.id);
  }
  return map;
}

// ── Push job helpers ──────────────────────────────────────────────────────────

function createJob(job) {
  const db = getDb();
  db.prepare(`
    INSERT INTO push_jobs (job_id, job_type, mode, date_from, date_to, store_id, store_name, status, log, created_at)
    VALUES (@job_id, @job_type, @mode, @date_from, @date_to, @store_id, @store_name, 'QUEUED', '[]', @created_at)
  `).run({
    job_id     : job.jobId,
    job_type   : job.jobType  || 'PUSH',
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

/**
 * Get the date of the most recently pushed sale (per country, store, or overall).
 * @returns {{ last_pushed_at: string|null, last_pushed_date: string|null, country: string|null, store_name: string|null }}
 */
function getLastPushInfo() {
  const db  = getDb();
  const row = db.prepare(
    `SELECT pushed_at, date_order, country, store_name FROM odoo_sales
     WHERE pushed_at IS NOT NULL ORDER BY pushed_at DESC LIMIT 1`
  ).get();
  if (!row) return { last_pushed_at: null, last_pushed_date: null, country: null, store_name: null };
  return {
    last_pushed_at  : row.pushed_at,
    last_pushed_date: row.date_order,
    country         : row.country,
    store_name      : row.store_name,
  };
}

/**
 * Push report: summarise all push jobs with their per-job statistics.
 * Groups by job, date range, store and country for a tabular report.
 *
 * @param {object} [opts]
 * @param {string}  [opts.dateFrom]
 * @param {string}  [opts.dateTo]
 * @param {string}  [opts.country]
 * @param {number}  [opts.storeId]
 * @param {number}  [opts.limit=100]
 * @param {number}  [opts.offset=0]
 * @returns {{ rows: object[], total: number }}
 */
function getPushReport({ dateFrom, dateTo, country, storeId, limit = 100, offset = 0 } = {}) {
  const db         = getDb();
  const conditions = [`j.job_type = 'PUSH'`];
  const params     = [];

  if (dateFrom) { conditions.push('j.date_from >= ?'); params.push(dateFrom); }
  if (dateTo)   { conditions.push('j.date_to   <= ?'); params.push(dateTo);   }
  if (storeId)  { conditions.push('j.store_id = ?');   params.push(storeId);  }

  const where = `WHERE ${conditions.join(' AND ')}`;

  // Join push_jobs with per-job country summary from odoo_sales
  const sql = `
    SELECT
      j.job_id,
      j.mode,
      j.date_from,
      j.date_to,
      j.store_id,
      j.store_name,
      j.status,
      j.total,
      j.processed,
      j.failed,
      j.started_at,
      j.finished_at,
      j.created_at,
      (SELECT GROUP_CONCAT(DISTINCT s.country) FROM odoo_sales s WHERE s.push_job_id = j.job_id) AS countries
    FROM push_jobs j
    ${where}
    ORDER BY j.created_at DESC
    LIMIT ? OFFSET ?
  `;

  const filtered = [...params, limit, offset];

  // Country filter: post-filter rows that have matching country (SQLite limitation with GROUP_CONCAT)
  let rows = db.prepare(sql).all(...filtered);
  if (country) {
    rows = rows.filter(r => r.countries && r.countries.split(',').includes(country));
  }

  const countSql = `SELECT COUNT(*) AS cnt FROM push_jobs j ${where}`;
  const total = db.prepare(countSql).get(...params).cnt;

  return { rows, total };
}

/**
 * Pull report: summarise all fetch jobs with per-job statistics.
 *
 * @param {object} [opts]
 * @param {string}  [opts.dateFrom]
 * @param {string}  [opts.dateTo]
 * @param {string}  [opts.country]
 * @param {number}  [opts.storeId]
 * @param {number}  [opts.limit=100]
 * @param {number}  [opts.offset=0]
 * @returns {{ rows: object[], total: number }}
 */
function getPullReport({ dateFrom, dateTo, country, storeId, limit = 100, offset = 0 } = {}) {
  const db         = getDb();
  const conditions = [`j.job_type = 'FETCH'`];
  const params     = [];

  if (dateFrom) { conditions.push('j.date_from >= ?'); params.push(dateFrom); }
  if (dateTo)   { conditions.push('j.date_to   <= ?'); params.push(dateTo);   }
  if (storeId)  { conditions.push('j.store_id = ?');   params.push(storeId);  }

  const where = `WHERE ${conditions.join(' AND ')}`;

  const sql = `
    SELECT
      j.job_id,
      j.mode,
      j.date_from,
      j.date_to,
      j.store_id,
      j.store_name,
      j.status,
      j.total,
      j.processed,
      j.failed,
      j.started_at,
      j.finished_at,
      j.created_at,
      (SELECT GROUP_CONCAT(DISTINCT s.country) FROM odoo_sales s WHERE s.fetched_at >= j.started_at AND (j.finished_at IS NULL OR s.fetched_at <= j.finished_at)) AS countries
    FROM push_jobs j
    ${where}
    ORDER BY j.created_at DESC
    LIMIT ? OFFSET ?
  `;

  const filtered = [...params, limit, offset];
  let rows = db.prepare(sql).all(...filtered);
  if (country) {
    rows = rows.filter(r => r.countries && r.countries.split(',').includes(country));
  }

  const countSql = `SELECT COUNT(*) AS cnt FROM push_jobs j ${where}`;
  const total = db.prepare(countSql).get(...params).cnt;

  return { rows, total };
}

/**
 * Summary of pushed orders grouped by date, country and store.
 * Used by the reports page to show "till which date orders have been pushed".
 *
 * @param {object} [opts]
 * @param {string}  [opts.country]
 * @param {number}  [opts.storeId]
 * @param {number}  [opts.limit=500]
 * @returns {object[]}
 */
function getPushDateSummary({ country, storeId, limit = 500 } = {}) {
  const db         = getDb();
  const conditions = ['oracle_txn_id IS NOT NULL'];
  const params     = [];

  if (country) { conditions.push('country = ?');  params.push(country); }
  if (storeId) { conditions.push('store_id = ?'); params.push(storeId); }

  const where = `WHERE ${conditions.join(' AND ')}`;

  const rows = db.prepare(`
    SELECT
      date_order,
      country,
      store_name,
      COUNT(*)             AS total_pushed,
      SUM(amount_total)    AS total_amount,
      MAX(pushed_at)       AS last_pushed_at
    FROM odoo_sales
    ${where}
    GROUP BY date_order, country, store_name
    ORDER BY date_order DESC, country, store_name
    LIMIT ?
  `).all(...params, limit);

  return rows;
}

// ── App Settings helpers ──────────────────────────────────────────────────────

/**
 * Retrieve a single application setting by key.
 * @param {string} key
 * @param {*}      [defaultVal=null]
 * @returns {string|*}
 */
function getAppSetting(key, defaultVal = null) {
  const db  = getDb();
  const row = db.prepare('SELECT value FROM app_settings WHERE key = ?').get(key);
  return row ? row.value : defaultVal;
}

/**
 * Persist an application setting.  Creates or replaces the row atomically.
 * @param {string} key
 * @param {string} value
 */
function setAppSetting(key, value) {
  const db = getDb();
  db.prepare(
    `INSERT INTO app_settings (key, value, updated_at)
     VALUES (?, ?, datetime('now'))
     ON CONFLICT(key) DO UPDATE SET value = excluded.value, updated_at = excluded.updated_at`
  ).run(key, value == null ? null : String(value));
}

/**
 * Return the currently active Oracle and Odoo credentials based on `server_mode`.
 * DB values take precedence over environment variables so that credentials
 * entered through the UI are always used when available.
 *
 * @returns {{
 *   mode: 'test'|'production',
 *   oracle: { baseUrl: string|null, username: string|null, password: string|null },
 *   odoo:   { url: string|null, db: string|null, username: string|null, password: string|null }
 * }}
 */
function getActiveCredentials() {
  const mode = getAppSetting('server_mode', 'production');

  const oracleBaseUrl  = getAppSetting(`oracle_${mode}_base_url`)  || (mode === 'production' ? process.env.FUSION_BASE_URL  || null : null);
  const oracleUsername = getAppSetting(`oracle_${mode}_username`)  || (mode === 'production' ? process.env.FUSION_USERNAME  || null : null);
  const oraclePassword = getAppSetting(`oracle_${mode}_password`)  || (mode === 'production' ? process.env.FUSION_PASSWORD  || null : null);

  const odooUrl      = getAppSetting(`odoo_${mode}_url`)      || (mode === 'production' ? process.env.ODOO_URL      || null : null);
  const odooDb       = getAppSetting(`odoo_${mode}_db`)       || (mode === 'production' ? process.env.ODOO_DB       || null : null);
  const odooUsername = getAppSetting(`odoo_${mode}_username`) || (mode === 'production' ? process.env.ODOO_USERNAME || null : null);
  const odooPassword = getAppSetting(`odoo_${mode}_password`) || (mode === 'production' ? process.env.ODOO_PASSWORD || null : null);
  const odooAuthType = getAppSetting(`odoo_${mode}_auth_type`) || (mode === 'production' ? process.env.ODOO_AUTH_TYPE || 'jsonrpc' : 'jsonrpc');
  const odooApiKey   = getAppSetting(`odoo_${mode}_api_key`)   || (mode === 'production' ? process.env.ODOO_API_KEY  || null : null);
  const odooApiUrl   = getAppSetting(`odoo_${mode}_api_url`)   || (mode === 'production' ? process.env.ODOO_API_URL  || null : null);

  return {
    mode,
    oracle: { baseUrl: oracleBaseUrl, username: oracleUsername, password: oraclePassword },
    odoo  : { url: odooUrl, db: odooDb, username: odooUsername, password: odooPassword, authType: odooAuthType, apiKey: odooApiKey, apiUrl: odooApiUrl },
  };
}

/**
 * Date/time of the most recently completed FETCH (pull) job.
 * @returns {{ last_pull_at: string|null, last_pull_date_from: string|null, last_pull_date_to: string|null }}
 */
function getLastFetchInfo() {
  const db  = getDb();
  const row = db.prepare(
    `SELECT finished_at, date_from, date_to FROM push_jobs
     WHERE job_type = 'FETCH' AND status = 'DONE' ORDER BY finished_at DESC LIMIT 1`
  ).get();
  if (!row) return { last_pull_at: null, last_pull_date_from: null, last_pull_date_to: null };
  return {
    last_pull_at        : row.finished_at,
    last_pull_date_from : row.date_from,
    last_pull_date_to   : row.date_to,
  };
}

// ── Country Config helpers ────────────────────────────────────────────────────

function listCountryConfigs() {
  return getDb().prepare('SELECT * FROM country_configs ORDER BY country_code').all();
}

function getCountryConfig(countryCode) {
  return getDb().prepare('SELECT * FROM country_configs WHERE country_code = ?').get(countryCode) || null;
}

function upsertCountryConfig({ countryCode, countryName, odooUrl, odooDb, odooUsername, odooPassword, odooAuthType, odooApiKey, odooApiUrl, odooSaleDetailPath, odooOrderLinePath, odooPaymentPath, oracleBaseUrl, oracleUsername, oraclePassword, enabled = 1 }) {
  getDb().prepare(`
    INSERT INTO country_configs (country_code, country_name, odoo_url, odoo_db, odoo_username, odoo_password, odoo_auth_type, odoo_api_key, odoo_api_url, odoo_sale_detail_path, odoo_order_line_path, odoo_payment_path, oracle_base_url, oracle_username, oracle_password, enabled, updated_at)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, datetime('now'))
    ON CONFLICT(country_code) DO UPDATE SET
      country_name          = excluded.country_name,
      odoo_url              = excluded.odoo_url,
      odoo_db               = excluded.odoo_db,
      odoo_username         = excluded.odoo_username,
      odoo_password         = excluded.odoo_password,
      odoo_auth_type        = excluded.odoo_auth_type,
      odoo_api_key          = excluded.odoo_api_key,
      odoo_api_url          = excluded.odoo_api_url,
      odoo_sale_detail_path = excluded.odoo_sale_detail_path,
      odoo_order_line_path  = excluded.odoo_order_line_path,
      odoo_payment_path     = excluded.odoo_payment_path,
      oracle_base_url       = excluded.oracle_base_url,
      oracle_username       = excluded.oracle_username,
      oracle_password       = excluded.oracle_password,
      enabled               = excluded.enabled,
      updated_at            = datetime('now')
  `).run(countryCode, countryName, odooUrl || null, odooDb || null, odooUsername || null, odooPassword || null, odooAuthType || 'jsonrpc', odooApiKey || null, odooApiUrl || null, odooSaleDetailPath || null, odooOrderLinePath || null, odooPaymentPath || null, oracleBaseUrl || null, oracleUsername || null, oraclePassword || null, enabled ? 1 : 0);
}

function deleteCountryConfig(countryCode) {
  getDb().prepare('DELETE FROM country_configs WHERE country_code = ?').run(countryCode);
}

function getCredentialsForCountry(countryCode) {
  const defaults = getActiveCredentials();
  if (!countryCode) return defaults;
  const cc = getCountryConfig(countryCode);
  if (!cc || !cc.enabled) return defaults;
  return {
    mode: defaults.mode,
    oracle: {
      baseUrl : cc.oracle_base_url || defaults.oracle.baseUrl,
      username: cc.oracle_username || defaults.oracle.username,
      password: cc.oracle_password || defaults.oracle.password,
    },
    odoo: {
      url           : cc.odoo_url             || defaults.odoo.url,
      db            : cc.odoo_db              || defaults.odoo.db,
      username      : cc.odoo_username        || defaults.odoo.username,
      password      : cc.odoo_password        || defaults.odoo.password,
      authType      : cc.odoo_auth_type       || 'jsonrpc',
      apiKey        : cc.odoo_api_key         || null,
      apiUrl        : cc.odoo_api_url         || defaults.odoo.apiUrl  || null,
      saleDetailPath: cc.odoo_sale_detail_path || null,
      orderLinePath : cc.odoo_order_line_path  || null,
      paymentPath   : cc.odoo_payment_path     || null,
    },
  };
}

// ── User helpers ──────────────────────────────────────────────────────────────

function createUser({ username, email, passwordHash, role = 'operator', displayName }) {
  const db = getDb();
  db.prepare(`
    INSERT INTO users (username, email, password_hash, role, display_name)
    VALUES (?, ?, ?, ?, ?)
  `).run(username, email || null, passwordHash, role, displayName || null);
  return db.prepare('SELECT * FROM users WHERE username = ?').get(username);
}

function getUserByUsername(username) {
  return getDb().prepare('SELECT * FROM users WHERE username = ?').get(username) || null;
}

function getUserById(id) {
  return getDb().prepare('SELECT * FROM users WHERE id = ?').get(id) || null;
}

function listUsers() {
  return getDb().prepare('SELECT id, username, email, role, display_name, created_at, last_login FROM users ORDER BY created_at').all();
}

function updateUser(id, fields) {
  const db = getDb();
  const allowed = ['email', 'role', 'display_name', 'avatar_data', 'password_hash'];
  const sets = Object.keys(fields).filter(k => allowed.includes(k)).map(k => `${k} = ?`).join(', ');
  if (!sets) return;
  const vals = Object.keys(fields).filter(k => allowed.includes(k)).map(k => fields[k]);
  db.prepare(`UPDATE users SET ${sets}, updated_at = datetime('now') WHERE id = ?`).run(...vals, id);
}

function updateUserLastLogin(id) {
  getDb().prepare("UPDATE users SET last_login = datetime('now') WHERE id = ?").run(id);
}

function deleteUser(id) {
  getDb().prepare('DELETE FROM users WHERE id = ?').run(id);
}

function countAdmins() {
  return getDb().prepare("SELECT COUNT(*) AS cnt FROM users WHERE role = 'admin'").get().cnt;
}

module.exports = {
  getDb,
  upsertSales,
  upsertSaleLines,
  upsertSalePayments,
  querySalePayments,
  querySales,
  getSaleWithLines,
  getSaleInternalId,
  getSaleInternalIdMap,
  updateSalePushStatus,
  createJob,
  updateJob,
  appendJobLog,
  getJobLogs,
  getJob,
  listJobs,
  insertFailedRecord,
  listFailedRecords,
  updateFailedRecord,
  getLastPushInfo,
  getPushReport,
  getPullReport,
  getPushDateSummary,
  getAppSetting,
  setAppSetting,
  getActiveCredentials,
  getLastFetchInfo,
  listCountryConfigs,
  getCountryConfig,
  upsertCountryConfig,
  deleteCountryConfig,
  getCredentialsForCountry,
  createUser,
  getUserByUsername,
  getUserById,
  listUsers,
  updateUser,
  updateUserLastLogin,
  deleteUser,
  countAdmins,
};
