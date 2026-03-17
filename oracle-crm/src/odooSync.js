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
 * Performance / production-scale notes:
 *   • Odoo fetch is paginated (ODOO_FETCH_PAGE_SIZE, default 500).  No data is
 *     missed even when millions of orders exist in a date range.
 *   • SQLite push is paginated (PUSH_BATCH_SIZE, default 500).  Memory stays flat.
 *   • Oracle API calls are sequential per order (Fusion doesn't support bulk POST).
 *   • Failed individual records are written to the failed_records table and NEVER
 *     halt the job – the job continues to the next record.  Failed records can be
 *     retried via startRetryJob() or the /api/odoo/retry-failed endpoint.
 *   • All DB writes are batched in transactions (no per-row fsync).
 *   • The event-loop is never blocked; background work uses setImmediate scheduling.
 */

const { randomUUID }  = require('crypto');
const OdooClient      = require('./odooClient');
const OraclePushService = require('./pushOracle');
const db              = require('./db');
const logger          = require('./logger').child('OdooSync');

// Max concurrent Oracle pushes per job chunk (keep CRM responsive)
const MAX_CONCURRENT    = Number(process.env.ODOO_PUSH_CONCURRENCY)  || 3;
// How many orders to fetch from Odoo per page
const FETCH_PAGE_SIZE   = Number(process.env.ODOO_FETCH_PAGE_SIZE)   || 500;
// How many records to process per SQLite batch in push jobs
const PUSH_BATCH_SIZE   = Number(process.env.PUSH_BATCH_SIZE)        || 500;

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

    // ── Paginated fetch from Odoo ─────────────────────────────────────────────
    // Odoo may have millions of orders; we page through them to avoid loading
    // everything into memory and to ensure no records are missed.
    let offset       = 0;
    let totalFetched = 0;
    let allOrderIds  = [];

    jobLog(jobId, 'info', 'Fetching sales orders from Odoo (paginated)…', {
      pageSize: FETCH_PAGE_SIZE, domain,
    });

    while (true) {
      const page = await odoo.searchSalesOrders(domain, null, {
        limit : FETCH_PAGE_SIZE,
        offset,
      });

      if (page.length === 0) break;

      // ── Persist headers for this page ───────────────────────────────────
      const now  = new Date().toISOString();
      const rows = page.map(o => ({
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

      const pageOrderIds = page.map(o => o.id);
      allOrderIds = allOrderIds.concat(pageOrderIds);
      totalFetched += page.length;
      offset       += page.length;

      jobLog(jobId, 'info', `Fetched & stored page of ${page.length} orders`, {
        totalFetchedSoFar: totalFetched,
      });
      db.updateJob(jobId, { total: totalFetched });

      // Yield to the event loop between pages to keep the server responsive
      await new Promise(resolve => setImmediate(resolve));

      if (page.length < FETCH_PAGE_SIZE) break; // last page
    }

    jobLog(jobId, 'info', `All ${totalFetched} sale headers stored in local DB`);

    if (totalFetched === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders found – job complete');
      return;
    }

    // ── Fetch + persist lines (paginated by order IDs) ────────────────────────
    jobLog(jobId, 'info', 'Fetching sale order lines…', { orderCount: allOrderIds.length });

    // Fetch lines in chunks to avoid Odoo's domain-length / payload limits
    const LINE_FETCH_CHUNK = 200;
    let totalLines = 0;
    for (let i = 0; i < allOrderIds.length; i += LINE_FETCH_CHUNK) {
      const idChunk  = allOrderIds.slice(i, i + LINE_FETCH_CHUNK);
      const rawLines = await odoo.getSaleOrderLines(idChunk);

      const lineRows = rawLines.map(l => {
        const orderId = Array.isArray(l.order_id) ? l.order_id[0] : l.order_id;
        return {
          sale_id        : db.getSaleInternalId(orderId),
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
      totalLines += lineRows.length;

      await new Promise(resolve => setImmediate(resolve));
    }

    jobLog(jobId, 'info', `Stored ${totalLines} sale lines in local DB`);

    db.updateJob(jobId, {
      status      : 'DONE',
      processed   : totalFetched,
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
    const filters = { dateFrom, dateTo };
    if (mode === 'BY_STORE_DATE') filters.storeId = storeId;

    // Resolve total first so progress can be tracked accurately
    const { total } = db.querySales({ ...filters, limit: 1, offset: 0 });
    jobLog(jobId, 'info', `Found ${total} orders matching filters`, { filters });
    db.updateJob(jobId, { total });

    if (total === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders to push – job complete');
      return;
    }

    const oracle    = buildOracleService();
    let processed   = 0;
    let failed      = 0;
    let dbOffset    = 0;

    // ── Paginated push – PUSH_BATCH_SIZE rows at a time ───────────────────────
    // Memory stays flat at O(PUSH_BATCH_SIZE) regardless of total order count.
    while (dbOffset < total) {
      const { rows: batch } = db.querySales({
        ...filters,
        limit  : PUSH_BATCH_SIZE,
        offset : dbOffset,
      });
      if (batch.length === 0) break;

      jobLog(jobId, 'info', `Processing batch of ${batch.length} orders`, {
        offset: dbOffset, total,
      });

      // ── Limited-concurrency fan-out within the batch ──────────────────────
      const chunks = chunkArray(batch, MAX_CONCURRENT);
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
              const errMsg = (result.errors || []).join('; ');
              jobLog(jobId, 'warn', `✗ Push failed for sale ${sale.name}`, {
                errors: result.errors,
              });
              // Record the failure as a durable event for later review / retry
              db.insertFailedRecord({
                jobId,
                saleName    : sale.name,
                odooId      : sale.odoo_id,
                errorMessage: errMsg,
                errorDetail : JSON.stringify(result.errors),
              });
            }
          } catch (err) {
            failed++;
            const detail = err.response
              ? `HTTP ${err.response.status}: ${JSON.stringify(err.response.data)}`
              : err.stack || err.message;
            jobLog(jobId, 'error', `✗ Exception pushing sale ${sale.name}: ${err.message}`);
            // Failure is durable – the job itself continues to the next record
            db.insertFailedRecord({
              jobId,
              saleName    : sale.name,
              odooId      : sale.odoo_id,
              errorMessage: err.message,
              errorDetail : detail,
            });
          }
          db.updateJob(jobId, { processed, failed });
        }));
      }

      dbOffset += batch.length;
      // Yield to the event loop between batches
      await new Promise(resolve => setImmediate(resolve));
    }

    const finalStatus = processed === 0 && failed > 0 ? 'FAILED' : 'DONE';
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Push job finished – ${processed} pushed, ${failed} failed`);
    if (failed > 0) {
      jobLog(jobId, 'warn', `${failed} failed records saved for retry. Use GET /api/odoo/failed-records?jobId=${jobId} to view them.`);
    }

  } catch (err) {
    logger.error('Push job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Push job failed: ${err.message}`);
  }
}

// ── 3. Retry failed records ───────────────────────────────────────────────────

/**
 * Start a background job that re-attempts all PENDING failed_records
 * belonging to a previous push job.
 *
 * @param {object} options
 * @param {string}  options.sourceJobId  – original push job whose failures to retry
 * @param {object}  [options.metadata]   – Oracle Fusion metadata override
 * @param {object}  [options.outlet]     – Oracle outlet config override
 * @returns {string} jobId of the retry job
 */
function startRetryJob(options) {
  const { sourceJobId } = options;
  const jobId = randomUUID();

  db.createJob({
    jobId,
    mode      : 'RETRY',
    dateFrom  : null,
    dateTo    : null,
    storeId   : null,
    storeName : null,
  });
  logger.info('Retry job created', { jobId, sourceJobId });

  setImmediate(() => _runRetryJob(jobId, options));

  return jobId;
}

async function _runRetryJob(jobId, { sourceJobId, metadata, outlet }) {
  db.updateJob(jobId, { status: 'RUNNING', started_at: new Date().toISOString() });
  jobLog(jobId, 'info', 'Retry job started', { sourceJobId });

  try {
    let frOffset  = 0;
    let processed = 0;
    let failed    = 0;
    let totalPending = 0;

    // Count first so we can report total accurately
    const { total: initialTotal } = db.listFailedRecords({
      jobId : sourceJobId,
      status: 'PENDING',
      limit : 1,
    });
    totalPending = initialTotal;
    jobLog(jobId, 'info', `Found ${totalPending} PENDING failed records to retry`);
    db.updateJob(jobId, { total: totalPending });

    if (totalPending === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No pending failures – retry job complete');
      return;
    }

    const oracle = buildOracleService();

    // Paginate to avoid loading all failures into memory at once
    while (true) {
      const { rows: pending } = db.listFailedRecords({
        jobId : sourceJobId,
        status: 'PENDING',
        limit : PUSH_BATCH_SIZE,
        offset: frOffset,
      });
      if (pending.length === 0) break;

      for (const record of pending) {
        try {
          const internalId = db.getSaleInternalId(record.odoo_id);
          if (!internalId) {
            db.updateFailedRecord(record.id, 'SKIPPED');
            jobLog(jobId, 'warn', `Skipping ${record.sale_name} – not found in local DB`);
            failed++;
            db.updateJob(jobId, { processed, failed });
            continue;
          }

          const saleWithLines = db.getSaleWithLines(internalId);
          const salePayload   = buildOracleSalePayload(saleWithLines, metadata, outlet);

          const result = await oracle.pushSale(
            salePayload.sale,
            salePayload.metadata,
            salePayload.outlet
          );

          if (result.success) {
            db.updateFailedRecord(record.id, 'RESOLVED');
            processed++;
            jobLog(jobId, 'info', `✓ Retry succeeded for ${record.sale_name}`, {
              transactionNumber: result.transactionNumber,
            });
          } else {
            db.updateFailedRecord(record.id, 'PENDING');
            failed++;
            jobLog(jobId, 'warn', `✗ Retry failed for ${record.sale_name}`, {
              errors: result.errors,
            });
          }
        } catch (err) {
          db.updateFailedRecord(record.id, 'PENDING');
          failed++;
          jobLog(jobId, 'error', `✗ Exception retrying ${record.sale_name}: ${err.message}`);
        }
        db.updateJob(jobId, { processed, failed });
        await new Promise(resolve => setImmediate(resolve));
      }

      frOffset += pending.length;
      await new Promise(resolve => setImmediate(resolve));
    }

    const finalStatus = processed === 0 && failed > 0 ? 'FAILED' : 'DONE';
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Retry job finished – ${processed} resolved, ${failed} still failing`);

  } catch (err) {
    logger.error('Retry job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Retry job failed: ${err.message}`);
  }
}

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
  startRetryJob,
  getOdooStores,
};
