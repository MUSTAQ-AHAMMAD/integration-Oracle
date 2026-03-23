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
const { startFetchJob, startPushJob, startRetryJob, getOdooStores } = require('../odooSync');
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
    // If Odoo is not configured, return an empty store list gracefully
    // instead of throwing a 500 error.
    const creds = db.getActiveCredentials();
    const odoo  = creds && creds.odoo ? creds.odoo : {};
    const isRest = odoo.authType === 'x-api-key' || odoo.authType === 'bearer';
    const configured = isRest
      ? !!(odoo.url && odoo.apiKey)
      : !!(odoo.url && odoo.db && odoo.username && odoo.password);
    if (!configured) {
      return res.json({ stores: [] });
    }
    const stores = await getOdooStores();
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

// ── GET /api/odoo/config ──────────────────────────────────────────────────────
router.get('/config', (req, res) => {
  const creds = db.getActiveCredentials();
  const odoo = creds && creds.odoo ? creds.odoo : {};
  const { url, db: odooDb, username, password, authType, apiKey } = odoo;
  // REST auth modes only require url + apiKey; JSONRPC requires url+db+username+password
  const isRest = authType === 'x-api-key' || authType === 'bearer';
  const configured = isRest
    ? !!(url && apiKey)
    : !!(url && odooDb && username && password);
  res.json({
    configured,
    url     : url      || null,
    db      : odooDb   || null,
    username: username || null,
  });
});

module.exports = router;
