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
 * GET /api/odoo/jobs/:jobId
 *   Poll job status + incremental log.
 *   Returns: push_jobs row with parsed log array.
 *
 * GET /api/odoo/jobs
 *   List recent jobs.
 *   Query: ?limit=50
 *
 * GET /api/odoo/sales
 *   List stored Odoo sales from SQLite.
 *   Query: ?dateFrom=YYYY-MM-DD&dateTo=YYYY-MM-DD&storeId=&limit=&offset=
 *
 * GET /api/odoo/stores
 *   List warehouses from Odoo (live).
 *
 * GET /api/odoo/config
 *   Returns whether Odoo connection is configured.
 */

const express       = require('express');
const router        = express.Router();
const { startFetchJob, startPushJob, getOdooStores } = require('../odooSync');
const db            = require('../db');
const logger        = require('../logger').child('OdooRoutes');

// ── Helpers ───────────────────────────────────────────────────────────────────

function validateDate(str) {
  return /^\d{4}-\d{2}-\d{2}$/.test(str) && !isNaN(new Date(str).getTime());
}

function badRequest(res, msg) {
  return res.status(400).json({ error: msg });
}

// ── POST /api/odoo/fetch ──────────────────────────────────────────────────────
router.post('/fetch', (req, res) => {
  const { dateFrom, dateTo, storeId, storeName } = req.body || {};

  if (!dateFrom || !validateDate(dateFrom)) return badRequest(res, 'dateFrom is required (YYYY-MM-DD)');
  if (!dateTo   || !validateDate(dateTo))   return badRequest(res, 'dateTo is required (YYYY-MM-DD)');
  if (new Date(dateFrom) > new Date(dateTo)) return badRequest(res, 'dateFrom must be <= dateTo');

  try {
    const jobId = startFetchJob({
      dateFrom,
      dateTo,
      storeId  : storeId  ? Number(storeId)  : undefined,
      storeName: storeName || undefined,
    });

    logger.info('Fetch job queued via API', { jobId, dateFrom, dateTo, storeId });
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
    metadata, outlet,
  } = req.body || {};

  const validModes = ['BY_DATE', 'BY_STORE_DATE', 'ALL_STORES_DATE'];
  if (!validModes.includes(mode)) {
    return badRequest(res, `mode must be one of: ${validModes.join(', ')}`);
  }
  if (!dateFrom || !validateDate(dateFrom)) return badRequest(res, 'dateFrom is required (YYYY-MM-DD)');
  if (!dateTo   || !validateDate(dateTo))   return badRequest(res, 'dateTo is required (YYYY-MM-DD)');
  if (new Date(dateFrom) > new Date(dateTo)) return badRequest(res, 'dateFrom must be <= dateTo');

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
      metadata : metadata  || undefined,
      outlet   : outlet    || undefined,
    });

    logger.info('Push job queued via API', { jobId, mode, dateFrom, dateTo, storeId });
    res.json({ jobId, status: 'QUEUED', message: 'Push job started in background' });
  } catch (err) {
    logger.error('Failed to start push job', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/jobs/:jobId ─────────────────────────────────────────────────
router.get('/jobs/:jobId', (req, res) => {
  const job = db.getJob(req.params.jobId);
  if (!job) return res.status(404).json({ error: 'Job not found' });

  // Parse log JSON for the response
  try { job.log = JSON.parse(job.log || '[]'); } catch (_) { job.log = []; }
  res.json(job);
});

// ── GET /api/odoo/jobs ────────────────────────────────────────────────────────
router.get('/jobs', (req, res) => {
  const limit = Math.min(Number(req.query.limit) || 50, 200);
  const jobs  = db.listJobs(limit).map(j => {
    try { j.log = JSON.parse(j.log || '[]'); } catch (_) { j.log = []; }
    return j;
  });
  res.json({ jobs, count: jobs.length });
});

// ── GET /api/odoo/sales ───────────────────────────────────────────────────────
router.get('/sales', (req, res) => {
  const { dateFrom, dateTo, storeId, limit = 100, offset = 0 } = req.query;
  const { rows, total } = db.querySales({
    dateFrom : dateFrom || undefined,
    dateTo   : dateTo   || undefined,
    storeId  : storeId  ? Number(storeId) : undefined,
    limit    : Math.min(Number(limit)  || 100, 500),
    offset   : Number(offset) || 0,
  });
  res.json({ sales: rows, total, count: rows.length });
});

// ── GET /api/odoo/stores ──────────────────────────────────────────────────────
router.get('/stores', async (req, res) => {
  try {
    const stores = await getOdooStores();
    res.json({ stores });
  } catch (err) {
    logger.error('Failed to fetch Odoo stores', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

// ── GET /api/odoo/config ──────────────────────────────────────────────────────
router.get('/config', (req, res) => {
  const configured = !!(
    process.env.ODOO_URL &&
    process.env.ODOO_DB  &&
    process.env.ODOO_USERNAME &&
    process.env.ODOO_PASSWORD
  );
  res.json({
    configured,
    url     : configured ? process.env.ODOO_URL      : null,
    db      : configured ? process.env.ODOO_DB        : null,
    username: configured ? process.env.ODOO_USERNAME  : null,
  });
});

module.exports = router;
