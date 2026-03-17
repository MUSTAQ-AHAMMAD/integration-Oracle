'use strict';

/**
 * odooSync.js
 *
 * Odoo ↔ Oracle CRM synchronisation service.
 *
 * Responsibilities:
 *   1. fetchAndStore(options)  – Pull sales from Odoo → persist to SQLite (non-blocking job)
 *   2. pushToOracle(options)   – Push stored SQLite sales → Oracle Fusion (non-blocking job)
 *
 * Both operations run as background jobs.  The caller receives a jobId immediately
 * and can poll /api/odoo/jobs/:jobId for status + incremental log.
 *
 * Push modes:
 *   BY_DATE           – push all stores, filter by date range
 *   BY_STORE_DATE     – push a specific store, filter by date range
 *   ALL_STORES_DATE   – alias for BY_DATE (explicit "all stores")
 *
 * Performance considerations:
 *   • SQLite writes are batched in transactions (no per-row commits)
 *   • Oracle API calls are sequential per order (Fusion doesn't support bulk invoice POST)
 *   • The event-loop is never blocked; background work uses setImmediate scheduling
 *   • Rate limiting is handled by a simple token-bucket (configurable concurrency)
 */

const { randomUUID }  = require('crypto');
const OdooClient      = require('./odooClient');
const OraclePushService = require('./pushOracle');
const db              = require('./db');
const logger          = require('./logger').child('OdooSync');

// Max concurrent Oracle pushes per job (keep CRM responsive)
const MAX_CONCURRENT = Number(process.env.ODOO_PUSH_CONCURRENCY) || 3;

// ── Factory helpers ───────────────────────────────────────────────────────────

function buildOdooClient() {
  const url      = process.env.ODOO_URL;
  const odoo_db  = process.env.ODOO_DB;
  const username = process.env.ODOO_USERNAME;
  const password = process.env.ODOO_PASSWORD;
  if (!url || !odoo_db || !username || !password) {
    throw new Error(
      'Odoo connection not configured. Set ODOO_URL, ODOO_DB, ODOO_USERNAME, ODOO_PASSWORD in .env'
    );
  }
  return new OdooClient(url, odoo_db, username, password);
}

function buildOracleService() {
  const baseUrl  = process.env.FUSION_BASE_URL;
  const username = process.env.FUSION_USERNAME;
  const password = process.env.FUSION_PASSWORD;
  if (!baseUrl || !username || !password) {
    throw new Error(
      'Oracle Fusion credentials not configured. Set FUSION_BASE_URL, FUSION_USERNAME, FUSION_PASSWORD in .env'
    );
  }
  return new OraclePushService(baseUrl, username, password);
}

// ── Job helpers ───────────────────────────────────────────────────────────────

function jobLog(jobId, level, message, meta = {}) {
  logger[level](message, { jobId, ...meta });
  db.appendJobLog(jobId, { level, message, ...meta });
}

// ── 1. Fetch & Store ──────────────────────────────────────────────────────────

/**
 * Start a background fetch-from-Odoo job.
 *
 * @param {object} options
 * @param {string}  options.dateFrom   YYYY-MM-DD (required)
 * @param {string}  options.dateTo     YYYY-MM-DD (required, can equal dateFrom)
 * @param {number}  [options.storeId]  filter by warehouse_id
 * @param {string}  [options.storeName]
 * @param {string}  [options.mode]     'BY_DATE' | 'BY_STORE_DATE' | 'ALL_STORES_DATE'
 * @returns {string} jobId
 */
function startFetchJob(options) {
  const { dateFrom, dateTo, storeId, storeName } = options;
  const mode  = storeId ? 'BY_STORE_DATE' : 'ALL_STORES_DATE';
  const jobId = randomUUID();

  db.createJob({ jobId, mode, dateFrom, dateTo, storeId, storeName });
  logger.info('Fetch job created', { jobId, mode, dateFrom, dateTo, storeId });

  // Run in background – do NOT await
  setImmediate(() => _runFetchJob(jobId, options));

  return jobId;
}

async function _runFetchJob(jobId, { dateFrom, dateTo, storeId }) {
  db.updateJob(jobId, { status: 'RUNNING', started_at: new Date().toISOString() });
  jobLog(jobId, 'info', 'Fetch job started', { dateFrom, dateTo, storeId });

  try {
    const odoo   = buildOdooClient();
    const domain = OdooClient.buildDomain(dateFrom, dateTo, storeId);

    jobLog(jobId, 'info', 'Connecting to Odoo…');
    await odoo.authenticate();

    jobLog(jobId, 'info', 'Fetching sales orders from Odoo…', { domain });
    const orders = await odoo.searchSalesOrders(domain);
    jobLog(jobId, 'info', `Fetched ${orders.length} sale orders from Odoo`);
    db.updateJob(jobId, { total: orders.length });

    if (orders.length === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders found – job complete');
      return;
    }

    // ── Persist headers ──────────────────────────────────────────────────────
    const now   = new Date().toISOString();
    const rows  = orders.map(o => ({
      odoo_id        : o.id,
      name           : o.name,
      store_id       : Array.isArray(o.warehouse_id) ? o.warehouse_id[0] : (o.warehouse_id || null),
      store_name     : Array.isArray(o.warehouse_id) ? o.warehouse_id[1] : null,
      date_order     : (o.date_order || '').split(' ')[0],
      partner_id     : Array.isArray(o.partner_id) ? o.partner_id[0] : null,
      partner_name   : Array.isArray(o.partner_id) ? o.partner_id[1] : null,
      currency       : Array.isArray(o.currency_id) ? o.currency_id[1] : 'AED',
      amount_untaxed : Number(o.amount_untaxed) || 0,
      amount_tax     : Number(o.amount_tax)     || 0,
      amount_total   : Number(o.amount_total)   || 0,
      state          : o.state || '',
      fetched_at     : now,
      raw_json       : JSON.stringify(o),
    }));
    db.upsertSales(rows);
    jobLog(jobId, 'info', `Stored ${rows.length} sale headers in local DB`);

    // ── Fetch + persist lines ─────────────────────────────────────────────────
    const orderIds = orders.map(o => o.id);
    jobLog(jobId, 'info', 'Fetching sale order lines…');
    const rawLines = await odoo.getSaleOrderLines(orderIds);

    const lineRows = rawLines.map(l => {
      const orderId = Array.isArray(l.order_id) ? l.order_id[0] : l.order_id;
      const saleInternalId = db.getSaleInternalId(orderId);
      return {
        sale_id        : saleInternalId,
        odoo_line_id   : l.id,
        product_id     : Array.isArray(l.product_id) ? l.product_id[0] : null,
        product_name   : Array.isArray(l.product_id) ? l.product_id[1] : (l.name || ''),
        qty_ordered    : Number(l.product_uom_qty) || 0,
        qty_delivered  : Number(l.qty_delivered)   || 0,
        price_unit     : Number(l.price_unit)       || 0,
        price_subtotal : Number(l.price_subtotal)   || 0,
        tax_ids        : JSON.stringify(l.tax_id    || []),
      };
    }).filter(l => l.sale_id !== null);
    db.upsertSaleLines(lineRows);
    jobLog(jobId, 'info', `Stored ${lineRows.length} sale lines in local DB`);

    db.updateJob(jobId, {
      status      : 'DONE',
      processed   : rows.length,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', 'Fetch job completed successfully');

  } catch (err) {
    logger.error('Fetch job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Fetch job failed: ${err.message}`);
  }
}

// ── 2. Push to Oracle ─────────────────────────────────────────────────────────

/**
 * Start a background push-to-Oracle job.
 *
 * Push modes:
 *   BY_DATE         – all stores, date range
 *   BY_STORE_DATE   – specific store + date range
 *   ALL_STORES_DATE – all stores (same as BY_DATE)
 *
 * @param {object} options
 * @param {string}  options.mode       'BY_DATE' | 'BY_STORE_DATE' | 'ALL_STORES_DATE'
 * @param {string}  options.dateFrom   YYYY-MM-DD
 * @param {string}  options.dateTo     YYYY-MM-DD
 * @param {number}  [options.storeId]  required for BY_STORE_DATE
 * @param {string}  [options.storeName]
 * @param {object}  [options.metadata] Oracle Fusion metadata (businessUnit, etc.)
 * @param {object}  [options.outlet]   Oracle outlet config
 * @returns {string} jobId
 */
function startPushJob(options) {
  const { mode = 'BY_DATE', dateFrom, dateTo, storeId, storeName } = options;
  const jobId = randomUUID();

  db.createJob({ jobId, mode, dateFrom, dateTo, storeId, storeName });
  logger.info('Push job created', { jobId, mode, dateFrom, dateTo, storeId });

  setImmediate(() => _runPushJob(jobId, options));

  return jobId;
}

async function _runPushJob(jobId, options) {
  const { mode, dateFrom, dateTo, storeId, metadata, outlet } = options;

  db.updateJob(jobId, { status: 'RUNNING', started_at: new Date().toISOString() });
  jobLog(jobId, 'info', 'Push job started', { mode, dateFrom, dateTo, storeId });

  try {
    // ── Query local DB for sales to push ────────────────────────────────────
    const filters = { dateFrom, dateTo };
    if (mode === 'BY_STORE_DATE') filters.storeId = storeId;

    const { rows: sales, total } = db.querySales({ ...filters, limit: 10000 });
    jobLog(jobId, 'info', `Found ${total} orders matching filters`, { filters });
    db.updateJob(jobId, { total });

    if (sales.length === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders to push – job complete');
      return;
    }

    const oracle = buildOracleService();
    let processed = 0;
    let failed    = 0;

    // ── Process with limited concurrency ────────────────────────────────────
    const chunks = chunkArray(sales, MAX_CONCURRENT);

    for (const chunk of chunks) {
      await Promise.all(chunk.map(async sale => {
        try {
          const saleWithLines = db.getSaleWithLines(sale.id);
          const salePayload   = buildOracleSalePayload(saleWithLines, metadata, outlet);

          jobLog(jobId, 'debug', `Pushing sale ${sale.name} (odoo_id=${sale.odoo_id})`, {
            storeId: sale.store_id, storeName: sale.store_name,
          });

          const result = await oracle.pushSale(
            salePayload.sale,
            salePayload.metadata,
            salePayload.outlet
          );

          if (result.success) {
            processed++;
            jobLog(jobId, 'info', `✓ Pushed sale ${sale.name}`, {
              transactionNumber: result.transactionNumber,
              steps: result.steps.length,
            });
          } else {
            failed++;
            jobLog(jobId, 'warn', `✗ Push failed for sale ${sale.name}`, {
              errors: result.errors,
            });
          }
        } catch (err) {
          failed++;
          jobLog(jobId, 'error', `✗ Exception pushing sale ${sale.name}: ${err.message}`);
        }
        db.updateJob(jobId, { processed, failed });
      }));
    }

    const finalStatus = failed === 0 ? 'DONE' : (processed === 0 ? 'FAILED' : 'DONE');
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Push job finished – ${processed} pushed, ${failed} failed`);

  } catch (err) {
    logger.error('Push job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Push job failed: ${err.message}`);
  }
}

// ── Payload builder ───────────────────────────────────────────────────────────

/**
 * Map an Odoo sale (from SQLite) to the format expected by pushOracle.js.
 * When metadata/outlet are not provided as job options, reasonable defaults
 * are derived from the Odoo record.
 */
function buildOracleSalePayload(sale, jobMeta, jobOutlet) {
  const lines = (sale.lines || []).map((l, idx) => ({
    lineNumber    : idx + 1,
    itemNumber    : String(l.product_id || `PROD-${l.odoo_line_id}`),
    itemName      : l.product_name || 'Odoo Product',
    originalQty   : l.qty_ordered,
    totalPrice    : l.price_subtotal,
    taxName       : null,
  }));

  const saleObj = {
    invoiceNumber  : sale.name,
    saleDate       : sale.date_order,
    customerType   : (jobMeta && jobMeta.customerType) || 'NORMAL',
    region         : (jobMeta && jobMeta.region)        || 'AE',
    tzOffset       : (jobMeta && jobMeta.tzOffset)      || 0,
    lineItems      : lines,
    payments       : [],
    receiptMethodMeta: {},
    rateIsCorporate: false,
    uomCodeMap     : {},
  };

  const metaObj = jobMeta || {
    billToName    : sale.partner_name || 'Odoo Customer',
    siteNumber    : null,
    billToAccount : 1000,
    businessUnit  : 'DEFAULT_BU',
    txnSource     : 'ODOO_SALES',
    txnType       : 'Invoice',
    region        : 'AE',
    customerType  : 'NORMAL',
  };

  const outletObj = jobOutlet || {
    currency         : sale.currency || 'AED',
    outletName       : sale.store_name || 'Odoo Store',
    organizationName : sale.store_name || 'Odoo Store',
  };

  return { sale: saleObj, metadata: metaObj, outlet: outletObj };
}

// ── Utilities ─────────────────────────────────────────────────────────────────

function chunkArray(arr, size) {
  const chunks = [];
  for (let i = 0; i < arr.length; i += size) {
    chunks.push(arr.slice(i, i + size));
  }
  return chunks;
}

// ── Stores cache ──────────────────────────────────────────────────────────────

/**
 * Fetch list of stores directly from Odoo (warehouses).
 * Used by the frontend dropdown.
 */
async function getOdooStores() {
  const odoo = buildOdooClient();
  await odoo.authenticate();
  return odoo.getStores();
}

module.exports = {
  startFetchJob,
  startPushJob,
  getOdooStores,
};
