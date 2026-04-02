'use strict';

/**
 * routes/odoo.js
 *
 * REST endpoints for the Odoo Sales module.
 *
 * POST /api/odoo/fetch
 *   Trigger a background job to pull sales from Odoo and store in SQLite.
 *   Body: { dateFrom, dateTo, storeId? }
 *   Returns: { jobId, status: 'QUEUED' }
 *
 * POST /api/odoo/push
 *   Trigger a background job to push stored sales to Oracle Fusion.
 *   Push modes (set via "mode" in body):
 *     BY_DATE         – all stores, date range
 *     BY_STORE_DATE   – specific store + date range
 *     ALL_STORES_DATE – same as BY_DATE (explicit all-stores)
 *   Body: { mode, dateFrom, dateTo, storeId?, metadata?, outlet? }
 *   Returns: { jobId, status: 'QUEUED' }
 *
 * POST /api/odoo/retry-failed
 *   Re-attempt all PENDING failed_records for a given source job.
 *   Body: { sourceJobId, metadata?, outlet? }
 *   Returns: { jobId, status: 'QUEUED' }
 *
 * GET /api/odoo/jobs/:jobId
 *   Poll job status + recent log entries (last 100).
 *   Returns: push_jobs row with recent_logs array.
 *
 * GET /api/odoo/jobs/:jobId/logs
 *   Paginated job log entries.
 *   Query: ?limit=100&offset=0
 *
 * GET /api/odoo/jobs
 *   List recent jobs (no inline logs).
 *   Query: ?limit=50
 *
 * GET /api/odoo/failed-records
 *   List failed records with optional filters.
 *   Query: ?jobId=&status=PENDING|RESOLVED|SKIPPED&limit=100&offset=0
 *
 * GET /api/odoo/sales
 *   List stored Odoo sales from SQLite.
 *   Query: ?dateFrom=YYYY-MM-DD&dateTo=YYYY-MM-DD&storeId=&limit=&offset=
 *
 * GET /api/odoo/stores
 *   List warehouses from Odoo (live).
 *
 * GET /api/odoo/payments
 *   List stored Odoo payment records (fetched from account.payment).
 *   Query: ?invoiceNumber=&dateFrom=&dateTo=&region=&saleId=&limit=&offset=
 *
 * GET /api/odoo/config
 *   Returns whether Odoo connection is configured.
 */

const express       = require('express');
const router        = express.Router();
const { startFetchJob, startPushJob, startRetryJob, getOdooStores, buildOracleSalePayload, fetchPaymentsForSale, buildOdooClient } = require('../odooSync');
const OdooRestClient = require('../odooRestClient');
const { computeSalePreview } = require('../calculations');
const db            = require('../db');
const logger        = require('../logger').child('OdooRoutes');

// ── Helpers ───────────────────────────────────────────────────────────────────

function validateDate(str) {
  return /^\d{4}-\d{2}-\d{2}$/.test(str) && !isNaN(new Date(str).getTime());
}

function badRequest(res, msg) {
  return res.status(400).json({ error: msg });
}

const VALID_COUNTRIES = ['AE','KW','OM','SA','BH','QA'];

// ── POST /api/odoo/fetch ──────────────────────────────────────────────────────
router.post('/fetch', (req, res) => {
  const { dateFrom, dateTo, storeId, storeName, country, companyId, tzOffset } = req.body || {};

  if (!dateFrom || !validateDate(dateFrom)) return badRequest(res, 'dateFrom is required (YYYY-MM-DD)');
  if (!dateTo   || !validateDate(dateTo))   return badRequest(res, 'dateTo is required (YYYY-MM-DD)');
  if (new Date(dateFrom) > new Date(dateTo)) return badRequest(res, 'dateFrom must be <= dateTo');
  if (country && !VALID_COUNTRIES.includes(country)) {
    return badRequest(res, `country must be one of: ${VALID_COUNTRIES.join(', ')}`);
  }
  if (companyId !== undefined && companyId !== null && companyId !== '') {
    const cid = Number(companyId);
    if (!Number.isInteger(cid) || cid < 1) return badRequest(res, 'companyId must be a positive integer');
  }
  // tzOffset: decimal hours ahead of UTC (e.g. 3 for UTC+3, 5.5 for UTC+5:30).
  // When provided it overrides the country-derived offset so dates are queried
  // as the correct UTC range in Odoo (which always stores date_order in UTC).
  let parsedTzOffset;
  if (tzOffset !== undefined && tzOffset !== null && tzOffset !== '') {
    parsedTzOffset = parseFloat(tzOffset);
    if (isNaN(parsedTzOffset) || parsedTzOffset < -12 || parsedTzOffset > 14) {
      return badRequest(res, 'tzOffset must be a number between -12 and 14');
    }
  }

  try {
    const jobId = startFetchJob({
      dateFrom,
      dateTo,
      storeId  : storeId   ? Number(storeId)   : undefined,
      storeName: storeName || undefined,
      country  : country   || undefined,
      companyId: companyId ? Number(companyId) : undefined,
      tzOffset : parsedTzOffset,
    });

    logger.info('Fetch job queued via API', { jobId, dateFrom, dateTo, storeId, country, companyId, tzOffset: parsedTzOffset });
    res.json({ jobId, status: 'QUEUED', message: 'Fetch job started in background' });
  } catch (err) {
    logger.error('Failed to start fetch job', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── POST /api/odoo/push ───────────────────────────────────────────────────────
router.post('/push', (req, res) => {
  const {
    mode = 'BY_DATE',
    dateFrom, dateTo,
    storeId, storeName,
    country,
    metadata, outlet,
    skipAlreadyPushed,
  } = req.body || {};

  const validModes = ['BY_DATE', 'BY_STORE_DATE', 'ALL_STORES_DATE'];
  if (!validModes.includes(mode)) {
    return badRequest(res, `mode must be one of: ${validModes.join(', ')}`);
  }
  if (!dateFrom || !validateDate(dateFrom)) return badRequest(res, 'dateFrom is required (YYYY-MM-DD)');
  if (!dateTo   || !validateDate(dateTo))   return badRequest(res, 'dateTo is required (YYYY-MM-DD)');
  if (new Date(dateFrom) > new Date(dateTo)) return badRequest(res, 'dateFrom must be <= dateTo');
  if (country && !VALID_COUNTRIES.includes(country)) {
    return badRequest(res, `country must be one of: ${VALID_COUNTRIES.join(', ')}`);
  }

  if (mode === 'BY_STORE_DATE' && !storeId) {
    return badRequest(res, 'storeId is required for BY_STORE_DATE mode');
  }

  try {
    const jobId = startPushJob({
      mode,
      dateFrom,
      dateTo,
      storeId  : storeId  ? Number(storeId)  : undefined,
      storeName: storeName || undefined,
      country  : country   || undefined,
      metadata : metadata  || undefined,
      outlet   : outlet    || undefined,
      skipAlreadyPushed: skipAlreadyPushed !== undefined ? !!skipAlreadyPushed : undefined,
    });

    logger.info('Push job queued via API', { jobId, mode, dateFrom, dateTo, storeId, country });
    res.json({ jobId, status: 'QUEUED', message: 'Push job started in background' });
  } catch (err) {
    logger.error('Failed to start push job', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── POST /api/odoo/retry-failed ───────────────────────────────────────────────
router.post('/retry-failed', (req, res) => {
  const { sourceJobId, metadata, outlet } = req.body || {};

  if (!sourceJobId) return badRequest(res, 'sourceJobId is required');

  const sourceJob = db.getJob(sourceJobId);
  if (!sourceJob) return res.status(404).json({ error: 'Source job not found' });

  try {
    const jobId = startRetryJob({
      sourceJobId,
      metadata,
      outlet,
    });

    logger.info('Retry job queued via API', { jobId, sourceJobId });
    res.json({ jobId, status: 'QUEUED', message: 'Retry job started in background' });
  } catch (err) {
    logger.error('Failed to start retry job', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/jobs/:jobId ─────────────────────────────────────────────────
router.get('/jobs/:jobId', (req, res) => {
  const job = db.getJob(req.params.jobId);
  if (!job) return res.status(404).json({ error: 'Job not found' });

  // Include the most recent 100 log entries so a simple poll still works
  const { rows: recentLogs, total: logTotal } = db.getJobLogs(job.job_id, { limit: 100, offset: 0 });
  job.recent_logs = recentLogs;
  job.log_total   = logTotal;
  res.json(job);
});

// ── GET /api/odoo/jobs/:jobId/logs ────────────────────────────────────────────
router.get('/jobs/:jobId/logs', (req, res) => {
  const job = db.getJob(req.params.jobId);
  if (!job) return res.status(404).json({ error: 'Job not found' });

  const limit  = Math.min(Number(req.query.limit)  || 100, 1000);
  const offset = Math.max(Number(req.query.offset) || 0, 0);

  const { rows, total } = db.getJobLogs(job.job_id, { limit, offset });
  res.json({ jobId: job.job_id, logs: rows, total, limit, offset });
});

// ── GET /api/odoo/jobs ────────────────────────────────────────────────────────
router.get('/jobs', (req, res) => {
  const limit = Math.min(Number(req.query.limit) || 50, 200);
  const jobs  = db.listJobs(limit);
  res.json({ jobs, count: jobs.length });
});

// ── GET /api/odoo/sales ───────────────────────────────────────────────────────
router.get('/sales', (req, res) => {
  const { dateFrom, dateTo, storeId, country, unpushedOnly, limit = 100, offset = 0 } = req.query;
  const { rows, total } = db.querySales({
    dateFrom     : dateFrom     || undefined,
    dateTo       : dateTo       || undefined,
    storeId      : storeId      ? Number(storeId) : undefined,
    country      : country      || undefined,
    unpushedOnly : unpushedOnly === 'true' || unpushedOnly === '1',
    limit        : Math.min(Number(limit)  || 100, 500),
    offset       : Number(offset) || 0,
  });
  res.json({ sales: rows, total, count: rows.length });
});

// ── DELETE /api/odoo/sales ────────────────────────────────────────────────────
// Delete fetched sales data (and cascaded lines + payments).
// Optional query filters: dateFrom, dateTo, country.
// Without filters, ALL fetched data is deleted.
router.delete('/sales', (req, res) => {
  const { dateFrom, dateTo, country } = req.query;

  if (dateFrom && !validateDate(dateFrom)) return badRequest(res, 'dateFrom must be YYYY-MM-DD');
  if (dateTo   && !validateDate(dateTo))   return badRequest(res, 'dateTo must be YYYY-MM-DD');
  if (country  && !VALID_COUNTRIES.includes(country)) {
    return badRequest(res, `country must be one of: ${VALID_COUNTRIES.join(', ')}`);
  }

  try {
    const result = db.clearSalesData({
      dateFrom: dateFrom || undefined,
      dateTo  : dateTo   || undefined,
      country : country  || undefined,
    });
    logger.info('Fetched sales data cleared via API', { ...result, dateFrom, dateTo, country });
    res.json({
      success: true,
      deleted: result.deleted,
      message: `Deleted ${result.deleted} sale record(s) and their associated lines and payments.`,
    });
  } catch (err) {
    logger.error('Failed to clear sales data', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/failed-records ──────────────────────────────────────────────
router.get('/failed-records', (req, res) => {
  const { jobId, status } = req.query;
  const limit  = Math.min(Number(req.query.limit)  || 100, 1000);
  const offset = Math.max(Number(req.query.offset) || 0, 0);

  const validStatuses = ['PENDING', 'RESOLVED', 'SKIPPED'];
  if (status && !validStatuses.includes(status)) {
    return badRequest(res, `status must be one of: ${validStatuses.join(', ')}`);
  }

  const { rows, total } = db.listFailedRecords({
    jobId : jobId  || undefined,
    status: status || undefined,
    limit,
    offset,
  });
  res.json({ records: rows, total, count: rows.length, limit, offset });
});

// ── GET /api/odoo/stores ──────────────────────────────────────────────────────
router.get('/stores', async (req, res) => {
  try {
    // Try fetching stores from Odoo API first (JSONRPC only; REST returns [])
    let stores = [];
    const creds = db.getActiveCredentials();
    const odoo  = creds && creds.odoo ? creds.odoo : {};
    const isRest = odoo.authType === 'x-api-key' || odoo.authType === 'bearer';
    const configured = isRest
      ? !!(odoo.url && odoo.apiKey)
      : !!(odoo.url && odoo.username && odoo.password);
    if (configured) {
      try { stores = await getOdooStores(); } catch (e) { logger.debug('Odoo store fetch skipped', { err: e.message }); }
    }

    // Merge with stores found in locally-stored sales data so the dropdown is
    // useful even when the Odoo API doesn't expose stock.warehouse (REST mode).
    const localStores = db.getLocalStores();
    const seen = new Set(stores.map(s => Number(s.id)));
    for (const ls of localStores) {
      if (!seen.has(Number(ls.id))) {
        stores.push(ls);
        seen.add(Number(ls.id));
      }
    }

    res.json({ stores });
  } catch (err) {
    logger.error('Failed to fetch Odoo stores', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/push-stats ──────────────────────────────────────────────────
// Returns counts of pushed vs pending sales for a given date range.
router.get('/push-stats', (req, res) => {
  const { dateFrom, dateTo, storeId, country } = req.query;
  const baseFilters = {
    dateFrom: dateFrom || undefined,
    dateTo  : dateTo   || undefined,
    storeId : storeId  ? Number(storeId) : undefined,
    country : country  || undefined,
  };
  const { total }           = db.querySales({ ...baseFilters, limit: 1, offset: 0 });
  const { total: unpushed } = db.querySales({ ...baseFilters, unpushedOnly: true, limit: 1, offset: 0 });
  res.json({ total, pushed: total - unpushed, pending: unpushed });
});

// ── GET /api/odoo/last-push ───────────────────────────────────────────────────
// Returns information about the most recently pushed order.
router.get('/last-push', (req, res) => {
  const info = db.getLastPushInfo();
  res.json(info);
});

// ── GET /api/odoo/push-date-summary ──────────────────────────────────────────
// Returns a per-date/country/store summary of pushed orders.
router.get('/push-date-summary', (req, res) => {
  const { country, storeId } = req.query;
  const limit = Math.min(Number(req.query.limit) || 500, 2000);
  const rows = db.getPushDateSummary({
    country: country || undefined,
    storeId: storeId ? Number(storeId) : undefined,
    limit,
  });
  res.json({ rows, count: rows.length });
});

// ── GET /api/odoo/reports/pushes ──────────────────────────────────────────────
// Returns detailed push-job reports.
router.get('/reports/pushes', (req, res) => {
  const { dateFrom, dateTo, country, storeId } = req.query;
  const limit  = Math.min(Number(req.query.limit)  || 100, 500);
  const offset = Math.max(Number(req.query.offset) || 0, 0);
  const { rows, total } = db.getPushReport({
    dateFrom: dateFrom || undefined,
    dateTo  : dateTo   || undefined,
    country : country  || undefined,
    storeId : storeId  ? Number(storeId) : undefined,
    limit,
    offset,
  });
  res.json({ reports: rows, total, count: rows.length, limit, offset });
});

// ── GET /api/odoo/reports/pulls ───────────────────────────────────────────────
// Returns detailed fetch-job (pull-from-Odoo) reports.
router.get('/reports/pulls', (req, res) => {
  const { dateFrom, dateTo, country, storeId } = req.query;
  const limit  = Math.min(Number(req.query.limit)  || 100, 500);
  const offset = Math.max(Number(req.query.offset) || 0, 0);
  const { rows, total } = db.getPullReport({
    dateFrom: dateFrom || undefined,
    dateTo  : dateTo   || undefined,
    country : country  || undefined,
    storeId : storeId  ? Number(storeId) : undefined,
    limit,
    offset,
  });
  res.json({ reports: rows, total, count: rows.length, limit, offset });
});

// ── GET /api/odoo/payments ────────────────────────────────────────────────────
// List stored payment records. Mirrors middleware BackupVendhqPayments.
// Query: ?invoiceNumber=&dateFrom=&dateTo=&region=&saleId=&limit=100&offset=0
router.get('/payments', (req, res) => {
  const { invoiceNumber, dateFrom, dateTo, region, saleId } = req.query;
  const limit  = Math.min(Number(req.query.limit)  || 100, 500);
  const offset = Math.max(Number(req.query.offset) || 0, 0);

  try {
    const { rows, total } = db.querySalePayments({
      invoiceNumber: invoiceNumber || undefined,
      dateFrom     : dateFrom      || undefined,
      dateTo       : dateTo        || undefined,
      region       : region        || undefined,
      saleId       : saleId        ? Number(saleId) : undefined,
      limit,
      offset,
    });
    res.json({ payments: rows, total, count: rows.length, limit, offset });
  } catch (err) {
    logger.error('Failed to query sale payments', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/sale-lines ──────────────────────────────────────────────────
// List stored sale order lines (from PosOrderLine endpoint).
// Query: ?saleId=&dateFrom=&dateTo=&storeId=&country=&limit=100&offset=0
router.get('/sale-lines', (req, res) => {
  const { saleId, dateFrom, dateTo, storeId, country } = req.query;
  const limit  = Math.min(Number(req.query.limit)  || 100, 500);
  const offset = Math.max(Number(req.query.offset) || 0, 0);

  try {
    const { rows, total } = db.querySaleLines({
      saleId  : saleId   ? Number(saleId) : undefined,
      dateFrom: dateFrom  || undefined,
      dateTo  : dateTo    || undefined,
      storeId : storeId   ? Number(storeId) : undefined,
      country : country   || undefined,
      limit,
      offset,
    });
    res.json({ lines: rows, total, count: rows.length, limit, offset });
  } catch (err) {
    logger.error('Failed to query sale lines', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/sales/:id/preview ───────────────────────────────────────────
// Return a complete sale detail with lines, payments, and Oracle payload preview.
// Used by the data verification modal in the UI.
//
// When the sale has no locally-stored payments, the endpoint automatically calls
// the Odoo payment API (payment_lines / account.payment) using the sale's order
// ID to fetch and persist the payment details.  Pass ?fetchPayments=true to force
// a live refresh even when local payments already exist.
router.get('/sales/:id/preview', async (req, res) => {
  const id = Number(req.params.id);
  if (!id || isNaN(id)) return badRequest(res, 'Invalid sale id');

  try {
    const sale = db.getSaleWithLines(id);
    if (!sale) return res.status(404).json({ error: 'Sale not found' });

    // ── Live-fetch payments from Odoo when local DB has none ────────────────
    const forceFetch = req.query.fetchPayments === 'true';
    const hasLocalPayments = Array.isArray(sale.payments) && sale.payments.length > 0;

    if ((forceFetch || !hasLocalPayments) && sale.odoo_id) {
      try {
        const fetched = await fetchPaymentsForSale(sale);
        if (fetched.length > 0) {
          sale.payments = fetched;
        }
      } catch (payErr) {
        logger.warn('Live payment fetch failed for sale %d: %s', id, payErr.message);
        // Continue with whatever local payments exist (may be empty)
      }
    }

    // Build Oracle payload preview using optional metadata from query params
    let oraclePreview = null;
    try {
      const salePayload = buildOracleSalePayload(sale, req.query.metadata ? JSON.parse(req.query.metadata) : {}, req.query.outlet ? JSON.parse(req.query.outlet) : undefined);
      const preview     = computeSalePreview(salePayload.sale);
      oraclePreview = {
        sale    : salePayload.sale,
        metadata: salePayload.metadata,
        outlet  : salePayload.outlet,
        preview,
      };
    } catch (previewErr) {
      oraclePreview = { error: previewErr.message };
    }

    res.json({
      sale: {
        id             : sale.id,
        odoo_id        : sale.odoo_id,
        name           : sale.name,
        store_id       : sale.store_id,
        store_name     : sale.store_name,
        country        : sale.country,
        date_order     : sale.date_order,
        partner_id     : sale.partner_id,
        partner_name   : sale.partner_name,
        currency       : sale.currency,
        amount_untaxed : sale.amount_untaxed,
        amount_tax     : sale.amount_tax,
        amount_total   : sale.amount_total,
        state          : sale.state,
        customer_type  : sale.customer_type,
        register_name  : sale.register_name,
        oracle_txn_id  : sale.oracle_txn_id,
        pushed_at      : sale.pushed_at,
      },
      lines       : sale.lines    || [],
      payments    : sale.payments || [],
      lineCount   : (sale.lines    || []).length,
      paymentCount: (sale.payments || []).length,
      oraclePreview,
    });
  } catch (err) {
    logger.error('Failed to get sale preview', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/config ──────────────────────────────────────────────────────
router.get('/config', (req, res) => {
  const creds = db.getActiveCredentials();
  const odoo = creds && creds.odoo ? creds.odoo : {};
  const { url, db: odooDb, username, password, authType, apiKey } = odoo;
  // REST auth modes only require url + apiKey; JSONRPC requires url+db+username+password
  const isRest = authType === 'x-api-key' || authType === 'bearer';
  const configured = isRest
    ? !!(url && apiKey)
    : !!(url && username && password);
  res.json({
    configured,
    url     : url      || null,
    db      : odooDb   || null,
    username: username || null,
  });
});

// ── Reference Data endpoints (diagnostics & auto-population) ──────────────────
//
// These endpoints expose the Odoo reference data used by the Java middleware
// (VendhqItemMeta, VendhqOutletsDB, FusionUomService) for diagnostics and
// to allow auto-population of store Oracle metadata.

/** GET /api/odoo/ref/products – fetch the product catalogue from Odoo */
router.get('/ref/products', async (req, res) => {
  try {
    const odoo = buildOdooClient(req.query.country || null);
    if (!(odoo instanceof OdooRestClient)) {
      return res.status(400).json({ error: 'Product catalogue is only available for REST-based Odoo connections' });
    }
    await odoo.authenticate();
    const rows = await odoo.getProducts();
    res.json({ count: rows.length, products: rows });
  } catch (err) {
    logger.error('Failed to fetch products', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

/** GET /api/odoo/ref/uom – fetch the UOM list from Odoo */
router.get('/ref/uom', async (req, res) => {
  try {
    const odoo = buildOdooClient(req.query.country || null);
    if (!(odoo instanceof OdooRestClient)) {
      return res.status(400).json({ error: 'UOM list is only available for REST-based Odoo connections' });
    }
    await odoo.authenticate();
    const rows = await odoo.getUomList();
    res.json({ count: rows.length, uomList: rows });
  } catch (err) {
    logger.error('Failed to fetch UOM list', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

/** GET /api/odoo/ref/branches – fetch branches / outlets from Odoo */
router.get('/ref/branches', async (req, res) => {
  try {
    const odoo = buildOdooClient(req.query.country || null);
    if (!(odoo instanceof OdooRestClient)) {
      return res.status(400).json({ error: 'Branch list is only available for REST-based Odoo connections' });
    }
    await odoo.authenticate();
    const rows = await odoo.getBranches();
    res.json({ count: rows.length, branches: rows });
  } catch (err) {
    logger.error('Failed to fetch branches', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

/** GET /api/odoo/ref/companies – fetch companies from Odoo */
router.get('/ref/companies', async (req, res) => {
  try {
    const odoo = buildOdooClient(req.query.country || null);
    if (!(odoo instanceof OdooRestClient)) {
      return res.status(400).json({ error: 'Company list is only available for REST-based Odoo connections' });
    }
    await odoo.authenticate();
    const rows = await odoo.getCompanies();
    res.json({ count: rows.length, companies: rows });
  } catch (err) {
    logger.error('Failed to fetch companies', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

/** GET /api/odoo/ref/poslist – fetch POS configuration list from Odoo */
router.get('/ref/poslist', async (req, res) => {
  try {
    const odoo = buildOdooClient(req.query.country || null);
    if (!(odoo instanceof OdooRestClient)) {
      return res.status(400).json({ error: 'POS list is only available for REST-based Odoo connections' });
    }
    await odoo.authenticate();
    const domain = req.query.domain ? JSON.parse(req.query.domain) : undefined;
    const rows = await odoo.getPosList(domain);
    res.json({ count: rows.length, posList: rows });
  } catch (err) {
    logger.error('Failed to fetch POS list', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── Store Oracle Metadata endpoints ───────────────────────────────────────────

/** GET /api/odoo/store-metadata – list all store Oracle metadata configs */
router.get('/store-metadata', (req, res) => {
  try {
    const rows = db.listStoreOracleMetadata();
    // Parse JSON fields for the API consumer
    const parsed = rows.map(r => ({
      ...r,
      receipt_method_meta: r.receipt_method_meta ? JSON.parse(r.receipt_method_meta) : null,
      journal_meta       : r.journal_meta        ? JSON.parse(r.journal_meta)        : null,
      uom_code_map       : r.uom_code_map        ? JSON.parse(r.uom_code_map)        : null,
    }));
    res.json(parsed);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/** GET /api/odoo/store-metadata/:storeId – get metadata for one store */
router.get('/store-metadata/:storeId', (req, res) => {
  try {
    const row = db.getStoreOracleMetadata(req.params.storeId);
    if (!row) return res.status(404).json({ error: 'No metadata configured for this store' });
    res.json({
      ...row,
      receipt_method_meta: row.receipt_method_meta ? JSON.parse(row.receipt_method_meta) : null,
      journal_meta       : row.journal_meta        ? JSON.parse(row.journal_meta)        : null,
      uom_code_map       : row.uom_code_map        ? JSON.parse(row.uom_code_map)        : null,
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/** PUT /api/odoo/store-metadata/:storeId – create or update store metadata */
router.put('/store-metadata/:storeId', (req, res) => {
  const storeId = Number(req.params.storeId);
  if (!storeId || isNaN(storeId)) return badRequest(res, 'storeId must be a valid number');

  try {
    db.upsertStoreOracleMetadata({ storeId, ...req.body });
    const saved = db.getStoreOracleMetadata(storeId);
    res.json({
      ...saved,
      receipt_method_meta: saved.receipt_method_meta ? JSON.parse(saved.receipt_method_meta) : null,
      journal_meta       : saved.journal_meta        ? JSON.parse(saved.journal_meta)        : null,
      uom_code_map       : saved.uom_code_map        ? JSON.parse(saved.uom_code_map)        : null,
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/** DELETE /api/odoo/store-metadata/:storeId – remove store metadata */
router.delete('/store-metadata/:storeId', (req, res) => {
  try {
    db.deleteStoreOracleMetadata(req.params.storeId);
    res.json({ deleted: true });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// ── Fusion Sales Metadata endpoints ──────────────────────────────────────────
//
// Reference data seeded from FUSION_SALES_METADATA CSV exports.
// Provides Oracle billing identity keyed by (subinventory, customer_type).
// Used as lowest-priority fallback during push when store_oracle_metadata has
// no billing information configured for a store.

const { seedFusionSalesMetadata } = require('../fusionMetadataSeed');

/** GET /api/odoo/fusion-metadata – list all fusion sales metadata rows */
router.get('/fusion-metadata', (req, res) => {
  try {
    const rows = db.listFusionSalesMetadata();
    res.json({ count: rows.length, rows });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/** GET /api/odoo/fusion-metadata/:subinventory/:customerType – lookup by key */
router.get('/fusion-metadata/:subinventory/:customerType', (req, res) => {
  try {
    const row = db.getFusionSalesMetadataByKey(
      req.params.subinventory,
      req.params.customerType
    );
    if (!row) return res.status(404).json({ error: 'No fusion metadata found for this key' });
    res.json(row);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/**
 * POST /api/odoo/fusion-metadata/seed
 * Re-seed fusion_sales_metadata from the FUSION_SALES_METADATA CSV files.
 * Body: { force?: boolean, csvPath?: string }
 */
router.post('/fusion-metadata/seed', (req, res) => {
  try {
    const { force = true, csvPath } = req.body || {};
    const result = seedFusionSalesMetadata(db, { force, csvPath });
    if (!result) {
      return res.json({ seeded: 0, message: 'Already seeded or no CSV file found' });
    }
    res.json({ seeded: result.seeded, source: result.source });
  } catch (err) {
    logger.error('Failed to seed fusion metadata', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

/** DELETE /api/odoo/fusion-metadata – clear all fusion metadata rows */
router.delete('/fusion-metadata', (req, res) => {
  try {
    db.clearFusionSalesMetadata();
    res.json({ deleted: true });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;
