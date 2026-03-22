'use strict';

/**
 * benchmark.js
 *
 * Performance benchmark for the Odoo → Oracle Fusion data pipeline.
 *
 * Measures two things:
 *   1. Odoo Pull speed  – how long it takes to pull N records from Odoo and
 *      persist them to SQLite.  The SQLite write speed is actually measured
 *      using a temporary in-memory database; the Odoo API latency is modelled
 *      mathematically because no live Odoo connection is available in the
 *      benchmark environment.
 *
 *   2. Oracle Push speed – how long it takes to push those same records from
 *      SQLite to Oracle Fusion.  The SQLite read + payload-build speed is
 *      actually measured; the Oracle API latency is modelled.
 *
 * All parameters are configurable via the options object so users can plug in
 * their measured real-world API latencies to get accurate projections.
 *
 * Defaults match the question: 8 000 records/day × 30 days = 240 000 records.
 */

const Database = require('better-sqlite3');

// ── Constants matching odooSync.js production defaults ────────────────────────
const DEFAULT_FETCH_PAGE_SIZE       = 500;   // ODOO_FETCH_PAGE_SIZE
const DEFAULT_PUSH_BATCH_SIZE       = 500;   // PUSH_BATCH_SIZE
const DEFAULT_MAX_CONCURRENT        = 10;    // ODOO_PUSH_CONCURRENCY
const DEFAULT_LINE_CHUNK_SIZE       = 200;   // LINE_FETCH_CHUNK in odooSync._runFetchJob
const DEFAULT_LINE_FETCH_CONCURRENCY = 5;   // ODOO_LINE_FETCH_CONCURRENCY

/**
 * Run the full performance benchmark.
 *
 * @param {object}  opts
 * @param {number}  [opts.recordsPerDay=8000]        Odoo sale orders per day
 * @param {number}  [opts.days=30]                   Number of days in the date range
 * @param {number}  [opts.linesPerOrder=3]           Average sale order lines per order
 * @param {number}  [opts.paymentsPerOrder=1.5]      Average payment records per order
 * @param {number}  [opts.odooHeaderLatencyMs=300]   Avg Odoo JSONRPC round-trip for one page (ms)
 * @param {number}  [opts.odooLineLatencyMs=200]     Avg Odoo JSONRPC round-trip for one line-chunk (ms)
 * @param {number}  [opts.odooPaymentLatencyMs=150]  Avg Odoo JSONRPC round-trip for one payment-chunk (ms)
 * @param {number}  [opts.oracleApiCallLatencyMs=400] Avg Oracle Fusion API call latency (ms)
 * @param {number}  [opts.oracleApiCallsPerOrder=5]  # Oracle API calls needed per order (invoice + receipts + inv-txn)
 * @param {number}  [opts.fetchPageSize=500]         ODOO_FETCH_PAGE_SIZE
 * @param {number}  [opts.pushBatchSize=500]         PUSH_BATCH_SIZE
 * @param {number}  [opts.maxConcurrent=10]          ODOO_PUSH_CONCURRENCY
 * @param {number}  [opts.lineFetchConcurrency=5]    ODOO_LINE_FETCH_CONCURRENCY
 * @param {number}  [opts.lineChunkSize=200]         orders per line-fetch chunk
 * @returns {object} Detailed benchmark report
 */
async function runBenchmark(opts = {}) {
  const {
    recordsPerDay          = 8000,
    days                   = 30,
    linesPerOrder          = 3,
    paymentsPerOrder       = 1.5,
    odooHeaderLatencyMs    = 300,
    odooLineLatencyMs      = 200,
    odooPaymentLatencyMs   = 150,
    oracleApiCallLatencyMs = 400,
    oracleApiCallsPerOrder = 5,
    fetchPageSize          = DEFAULT_FETCH_PAGE_SIZE,
    pushBatchSize          = DEFAULT_PUSH_BATCH_SIZE,
    maxConcurrent          = DEFAULT_MAX_CONCURRENT,
    lineFetchConcurrency   = DEFAULT_LINE_FETCH_CONCURRENCY,
    lineChunkSize          = DEFAULT_LINE_CHUNK_SIZE,
  } = opts;

  const totalOrders   = recordsPerDay * days;
  const totalLines    = Math.round(totalOrders * linesPerOrder);
  const totalPayments = Math.round(totalOrders * paymentsPerOrder);

  // ── 1. SQLite write benchmark (actually measured) ─────────────────────────
  const sqliteWrite = await measureSqliteWrite(totalOrders, totalLines);

  // ── 2. Odoo pull timing model ─────────────────────────────────────────────
  const odooPull = modelOdooPull({
    totalOrders,
    totalLines,
    totalPayments,
    fetchPageSize,
    lineChunkSize,
    lineFetchConcurrency,
    odooHeaderLatencyMs,
    odooLineLatencyMs,
    odooPaymentLatencyMs,
    sqliteWriteMs: sqliteWrite.writeMs,
  });

  // ── 3. SQLite read benchmark (actually measured) ──────────────────────────
  const sqliteRead = await measureSqliteRead(totalOrders);

  // ── 4. Oracle push timing model ───────────────────────────────────────────
  const oraclePush = modelOraclePush({
    totalOrders,
    maxConcurrent,
    pushBatchSize,
    oracleApiCallLatencyMs,
    oracleApiCallsPerOrder,
    sqliteReadMs: sqliteRead.readMs,
  });

  return buildReport({
    params: {
      recordsPerDay,
      days,
      linesPerOrder,
      paymentsPerOrder,
      odooHeaderLatencyMs,
      odooLineLatencyMs,
      odooPaymentLatencyMs,
      oracleApiCallLatencyMs,
      oracleApiCallsPerOrder,
      fetchPageSize,
      pushBatchSize,
      maxConcurrent,
      lineFetchConcurrency,
      lineChunkSize,
    },
    totals: { totalOrders, totalLines, totalPayments },
    sqliteWrite,
    odooPull,
    sqliteRead,
    oraclePush,
  });
}

// ── SQLite write measurement ──────────────────────────────────────────────────

/**
 * Actually inserts a batch of synthetic sale headers + lines into an in-memory
 * SQLite database and measures the elapsed time.  Uses the same schema and
 * upsert approach as the production db.js so the timing is representative.
 *
 * To avoid making the benchmark slow (it runs synchronously), we insert a
 * representative 2 000-order sample and scale the result to totalOrders.
 */
function measureSqliteWrite(totalOrders, totalLines) {
  return new Promise(resolve => {
    const SAMPLE = Math.min(totalOrders, 2000);
    const sampleLines = Math.round((totalLines / totalOrders) * SAMPLE);

    const db = new Database(':memory:');
    db.pragma('journal_mode = WAL');
    db.pragma('synchronous = NORMAL');
    db.pragma('cache_size = -65536');
    db.pragma('temp_store = MEMORY');

    db.exec(`
      CREATE TABLE odoo_sales (
        id            INTEGER PRIMARY KEY AUTOINCREMENT,
        odoo_id       INTEGER NOT NULL UNIQUE,
        name          TEXT NOT NULL,
        store_id      INTEGER,
        store_name    TEXT,
        country       TEXT,
        date_order    TEXT NOT NULL,
        partner_id    INTEGER,
        partner_name  TEXT,
        currency      TEXT DEFAULT 'AED',
        amount_untaxed REAL DEFAULT 0,
        amount_tax    REAL DEFAULT 0,
        amount_total  REAL DEFAULT 0,
        state         TEXT,
        fetched_at    TEXT NOT NULL
      );
      CREATE TABLE odoo_sale_lines (
        id            INTEGER PRIMARY KEY AUTOINCREMENT,
        sale_id       INTEGER NOT NULL,
        odoo_line_id  INTEGER NOT NULL UNIQUE,
        product_name  TEXT,
        qty_ordered   REAL DEFAULT 0,
        price_unit    REAL DEFAULT 0,
        price_subtotal REAL DEFAULT 0
      );
    `);

    const insertSale = db.prepare(`
      INSERT OR REPLACE INTO odoo_sales
        (odoo_id, name, store_id, store_name, country, date_order,
         partner_id, partner_name, currency, amount_untaxed,
         amount_tax, amount_total, state, fetched_at)
      VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
    `);
    const insertLine = db.prepare(`
      INSERT OR REPLACE INTO odoo_sale_lines
        (sale_id, odoo_line_id, product_name, qty_ordered, price_unit, price_subtotal)
      VALUES (?,?,?,?,?,?)
    `);

    const now = new Date().toISOString();
    const t0  = Date.now();

    // Write sales in one transaction
    const insertManySales = db.transaction(rows => {
      for (const r of rows) insertSale.run(r);
    });
    const saleRows = [];
    for (let i = 0; i < SAMPLE; i++) {
      saleRows.push([
        i + 1,                           // odoo_id
        `S${String(i + 1).padStart(6, '0')}`,  // name
        1,                               // store_id
        'Main Store',                    // store_name
        'AE',                            // country
        '2024-01-01',                    // date_order
        100 + (i % 500),                 // partner_id
        `Customer ${i % 500}`,           // partner_name
        'AED',                           // currency
        100 + (i % 1000),                // amount_untaxed
        5 + (i % 50),                    // amount_tax
        105 + (i % 1050),                // amount_total
        'sale',                          // state
        now,                             // fetched_at
      ]);
    }
    insertManySales(saleRows);

    // Write lines in one transaction
    const insertManyLines = db.transaction(rows => {
      for (const r of rows) insertLine.run(r);
    });
    const lineRows = [];
    for (let i = 0; i < sampleLines; i++) {
      lineRows.push([
        (i % SAMPLE) + 1,            // sale_id (1-based)
        i + 1,                       // odoo_line_id
        `Product ${i % 200}`,        // product_name
        1 + (i % 5),                 // qty_ordered
        10 + (i % 100),              // price_unit
        10 + (i % 100),              // price_subtotal
      ]);
    }
    insertManyLines(lineRows);

    const sampleMs = Date.now() - t0;

    db.close();

    // Scale to full dataset
    const scaleFactor = totalOrders / SAMPLE;
    const writeMs     = Math.round(sampleMs * scaleFactor);

    resolve({
      sampleOrders    : SAMPLE,
      sampleLines,
      sampleWriteMs   : sampleMs,
      writeMs,                           // projected for full dataset
      writeSec        : writeMs / 1000,
      throughputPerSec: Math.round((SAMPLE / sampleMs) * 1000),
    });
  });
}

// ── SQLite read measurement ───────────────────────────────────────────────────

function measureSqliteRead(totalOrders) {
  return new Promise(resolve => {
    const SAMPLE = Math.min(totalOrders, 2000);
    const db     = new Database(':memory:');

    db.exec(`
      CREATE TABLE odoo_sales (
        id        INTEGER PRIMARY KEY,
        odoo_id   INTEGER,
        name      TEXT,
        date_order TEXT,
        amount_total REAL,
        oracle_txn_id TEXT,
        pushed_at TEXT
      );
    `);

    const insert = db.prepare(
      'INSERT INTO odoo_sales (odoo_id,name,date_order,amount_total) VALUES (?,?,?,?)'
    );
    const insertMany = db.transaction(rows => {
      for (const r of rows) insert.run(r);
    });
    const rows = [];
    for (let i = 0; i < SAMPLE; i++) {
      rows.push([i + 1, `S${i + 1}`, '2024-01-01', 100 + i]);
    }
    insertMany(rows);

    const query  = db.prepare('SELECT * FROM odoo_sales WHERE oracle_txn_id IS NULL ORDER BY id LIMIT ? OFFSET ?');
    const t0     = Date.now();
    let   offset = 0;
    const PAGE   = 500;
    let   total  = 0;

    while (offset < SAMPLE) {
      const page = query.all(PAGE, offset);
      total  += page.length;
      offset += page.length;
      if (page.length < PAGE) break;
    }

    const sampleMs  = Date.now() - t0;
    db.close();

    const scaleFactor = totalOrders / SAMPLE;
    const readMs      = Math.round(sampleMs * scaleFactor);

    resolve({
      sampleOrders    : SAMPLE,
      sampleReadMs    : sampleMs,
      readMs,
      readSec         : readMs / 1000,
      throughputPerSec: Math.round((SAMPLE / Math.max(sampleMs, 1)) * 1000),
    });
  });
}

// ── Odoo pull timing model ────────────────────────────────────────────────────

function modelOdooPull({
  totalOrders,
  totalLines,
  totalPayments,
  fetchPageSize,
  lineChunkSize,
  lineFetchConcurrency,
  odooHeaderLatencyMs,
  odooLineLatencyMs,
  odooPaymentLatencyMs,
  sqliteWriteMs,
}) {
  // ── Header fetch (paginated) ─────────────────────────────────────────────
  const headerPages        = Math.ceil(totalOrders / fetchPageSize);
  const headerFetchMs      = headerPages * odooHeaderLatencyMs;

  // ── Line fetch (chunked + concurrent) ───────────────────────────────────
  // Line-chunks are groups of lineChunkSize order IDs, fetched with
  // LINE_FETCH_CONCURRENCY concurrent requests per round.
  const lineChunks         = Math.ceil(totalOrders / lineChunkSize);
  const lineFetchRounds    = Math.ceil(lineChunks / lineFetchConcurrency);
  const lineFetchMs        = lineFetchRounds * odooLineLatencyMs;

  // ── Payment fetch (one batch call per day using date domain) ────────────
  // REST path: one API call per 500-record page.
  // JSONRPC path: one call per order for invoice_ids, then one per invoice.
  // We model the REST path (most efficient) as the reference.
  const paymentPages       = Math.ceil(totalPayments / fetchPageSize);
  const paymentFetchMs     = paymentPages * odooPaymentLatencyMs;

  // ── SQLite writes (proportional: already measured for headers+lines) ────
  // The measured sqliteWriteMs covers both sales + lines.
  const sqliteMs           = sqliteWriteMs;

  // ── Total ────────────────────────────────────────────────────────────────
  const totalMs            = headerFetchMs + lineFetchMs + paymentFetchMs + sqliteMs;

  return {
    totalOrders,
    totalLines,
    totalPayments,
    // Header fetch
    headerPages,
    headerFetchMs,
    headerFetchSec   : headerFetchMs / 1000,
    // Line fetch
    lineChunks,
    lineFetchRounds,
    lineFetchMs,
    lineFetchSec     : lineFetchMs / 1000,
    // Payment fetch
    paymentPages,
    paymentFetchMs,
    paymentFetchSec  : paymentFetchMs / 1000,
    // SQLite write
    sqliteMs,
    sqliteSec        : sqliteMs / 1000,
    // Totals
    totalMs,
    totalSec         : totalMs / 1000,
    totalMin         : totalMs / 60000,
    totalHours       : totalMs / 3600000,
    humanDuration    : humanTime(totalMs),
  };
}

// ── Oracle push timing model ──────────────────────────────────────────────────

function modelOraclePush({
  totalOrders,
  maxConcurrent,
  pushBatchSize,
  oracleApiCallLatencyMs,
  oracleApiCallsPerOrder,
  sqliteReadMs,
}) {
  // Oracle API calls are sequential within each order (Fusion doesn't support
  // bulk POST).  Orders are processed in parallel batches of maxConcurrent.
  const timePerOrderMs     = oracleApiCallsPerOrder * oracleApiCallLatencyMs;

  // Number of rounds to process all orders
  const pushRounds         = Math.ceil(totalOrders / maxConcurrent);

  // Oracle API time = rounds × time per order (since the round finishes when
  // the slowest of the maxConcurrent orders finishes – they all take similar
  // time so this is effectively pushRounds × timePerOrderMs)
  const oracleApiMs        = pushRounds * timePerOrderMs;

  // SQLite read time (already measured)
  const sqliteMs           = sqliteReadMs;

  // Total push time
  const totalMs            = oracleApiMs + sqliteMs;

  return {
    totalOrders,
    oracleApiCallsPerOrder,
    timePerOrderMs,
    pushRounds,
    oracleApiMs,
    oracleApiSec     : oracleApiMs / 1000,
    sqliteMs,
    sqliteSec        : sqliteMs / 1000,
    totalMs,
    totalSec         : totalMs / 1000,
    totalMin         : totalMs / 60000,
    totalHours       : totalMs / 3600000,
    humanDuration    : humanTime(totalMs),
    ordersPerMinute  : Math.round((totalOrders / (totalMs / 60000)) * 10) / 10,
    ordersPerHour    : Math.round(totalOrders / (totalMs / 3600000)),
  };
}

// ── Report builder ────────────────────────────────────────────────────────────

function buildReport({ params, totals, sqliteWrite, odooPull, sqliteRead, oraclePush }) {
  const combinedTotalMs  = odooPull.totalMs + oraclePush.totalMs;
  const combinedHuman    = humanTime(combinedTotalMs);

  return {
    generatedAt  : new Date().toISOString(),
    params,
    totals,
    sqliteWrite,
    sqliteRead,
    odooPull,
    oraclePush,
    combined: {
      totalMs     : combinedTotalMs,
      totalSec    : combinedTotalMs / 1000,
      totalMin    : combinedTotalMs / 60000,
      totalHours  : combinedTotalMs / 3600000,
      humanDuration: combinedHuman,
    },
    summary: buildSummaryText({ params, totals, odooPull, oraclePush, combinedHuman }),
  };
}

function buildSummaryText({ params, totals, odooPull, oraclePush, combinedHuman }) {
  return [
    `=== Performance Benchmark Report ===`,
    `Generated: ${new Date().toUTCString()}`,
    ``,
    `── Parameters ───────────────────────────────────────────────────────────────`,
    `  Records/day          : ${params.recordsPerDay.toLocaleString()}`,
    `  Days                 : ${params.days}`,
    `  Total orders         : ${totals.totalOrders.toLocaleString()}`,
    `  Total lines          : ${totals.totalLines.toLocaleString()}`,
    `  Total payments       : ${totals.totalPayments.toLocaleString()}`,
    `  Odoo JSONRPC latency : ${params.odooHeaderLatencyMs} ms/page`,
    `  Oracle API latency   : ${params.oracleApiCallLatencyMs} ms/call`,
    `  Oracle calls/order   : ${params.oracleApiCallsPerOrder}`,
    `  Push concurrency     : ${params.maxConcurrent} orders in parallel`,
    ``,
    `── Odoo Pull Estimate ────────────────────────────────────────────────────────`,
    `  Header pages         : ${odooPull.headerPages.toLocaleString()} × ${params.odooHeaderLatencyMs} ms`,
    `  Header fetch time    : ${humanTime(odooPull.headerFetchMs)}`,
    `  Line-fetch rounds    : ${odooPull.lineFetchRounds.toLocaleString()} × ${params.odooLineLatencyMs} ms`,
    `  Line fetch time      : ${humanTime(odooPull.lineFetchMs)}`,
    `  Payment pages        : ${odooPull.paymentPages.toLocaleString()} × ${params.odooPaymentLatencyMs} ms`,
    `  Payment fetch time   : ${humanTime(odooPull.paymentFetchMs)}`,
    `  SQLite write time    : ${humanTime(odooPull.sqliteMs)} (measured)`,
    `  ──────────────────────────────────────────────────────────────────────────`,
    `  TOTAL PULL TIME      : ${odooPull.humanDuration}`,
    ``,
    `── Oracle Push Estimate ──────────────────────────────────────────────────────`,
    `  Push rounds          : ${oraclePush.pushRounds.toLocaleString()} (${params.maxConcurrent} parallel)`,
    `  Time/order           : ${oraclePush.timePerOrderMs} ms (${params.oracleApiCallsPerOrder} calls × ${params.oracleApiCallLatencyMs} ms)`,
    `  Oracle API time      : ${humanTime(oraclePush.oracleApiMs)}`,
    `  SQLite read time     : ${humanTime(oraclePush.sqliteMs)} (measured)`,
    `  Throughput           : ${oraclePush.ordersPerMinute} orders/min, ${oraclePush.ordersPerHour.toLocaleString()} orders/hr`,
    `  ──────────────────────────────────────────────────────────────────────────`,
    `  TOTAL PUSH TIME      : ${oraclePush.humanDuration}`,
    ``,
    `── Combined ──────────────────────────────────────────────────────────────────`,
    `  PULL + PUSH TOTAL    : ${combinedHuman}`,
    ``,
    `Note: Odoo JSONRPC and Oracle API call times are estimated based on the`,
    `latency values you configured.  SQLite write/read times are measured on`,
    `this machine using an in-memory database.  Actual performance depends on`,
    `network latency, server load, and data complexity.`,
  ].join('\n');
}

// ── Utility ───────────────────────────────────────────────────────────────────

function humanTime(ms) {
  if (ms < 1000)   return `${ms} ms`;
  if (ms < 60000)  return `${(ms / 1000).toFixed(1)} sec`;
  if (ms < 3600000) {
    const m = Math.floor(ms / 60000);
    const s = Math.round((ms % 60000) / 1000);
    return s > 0 ? `${m} min ${s} sec` : `${m} min`;
  }
  const h = Math.floor(ms / 3600000);
  const m = Math.round((ms % 3600000) / 60000);
  return m > 0 ? `${h} hr ${m} min` : `${h} hr`;
}

module.exports = { runBenchmark };
