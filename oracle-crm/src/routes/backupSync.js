'use strict';

/**
 * routes/backupSync.js
 *
 * Direct Oracle BACKUP table sync routes
 * Implements exact Java middleware functionality
 */

const express = require('express');
const router = express.Router();
const oracleDbClient = require('../oracleDbClient');
const { startFetchJob } = require('../odooSync');
const db = require('../db');
const logger = require('../logger').child('BackupSyncRoutes');

/**
 * POST /api/backup-sync/sync-to-oracle
 * Sync fetched Odoo sales directly to Oracle BACKUP tables
 * Matches Java: backupSales(String domainName, Credential vendHqCredential)
 */
router.post('/sync-to-oracle', async (req, res) => {
  const { dateFrom, dateTo, storeId, country, region = 'SA' } = req.body || {};

  if (!dateFrom || !dateTo) {
    return res.status(400).json({ error: 'dateFrom and dateTo are required' });
  }

  try {
    // Get Oracle DB config
    const creds = db.getActiveCredentials();
    const oracleConfig = creds?.oracleDb;

    if (!oracleConfig || !oracleConfig.host || !oracleConfig.user || !oracleConfig.password) {
      return res.status(400).json({
        error: 'Oracle database not configured. Please configure in Settings > Credentials.'
      });
    }

    // Query fetched sales from SQLite
    const { rows: sales } = db.querySales({
      dateFrom,
      dateTo,
      storeId: storeId ? Number(storeId) : undefined,
      country,
      limit: 10000
    });

    if (sales.length === 0) {
      return res.json({
        success: true,
        message: 'No sales found for the specified criteria',
        synced: 0,
        total: 0
      });
    }

    // Prepare sales data with lines and payments
    const salesData = sales.map(sale => {
      const fullSale = db.getSaleWithLines(sale.id);
      return {
        sale: fullSale,
        lines: fullSale.lines || [],
        payments: fullSale.payments || []
      };
    });

    // Sync to Oracle
    logger.info('Starting Oracle backup sync', {
      dateFrom,
      dateTo,
      storeId,
      country,
      region,
      totalSales: salesData.length
    });

    const result = await oracleDbClient.syncSalesToOracle(oracleConfig, salesData, region);

    logger.info('Oracle backup sync completed', result);

    res.json({
      success: true,
      message: `Synced ${result.synced} sales to Oracle BACKUP tables`,
      ...result
    });

  } catch (err) {
    logger.error('Oracle backup sync failed', { error: err.message });
    res.status(500).json({
      error: err.message,
      details: 'Failed to sync to Oracle BACKUP tables'
    });
  }
});

/**
 * POST /api/backup-sync/fetch-and-sync
 * Combined operation: Fetch from Odoo and sync to Oracle BACKUP tables
 * Matches full Java workflow
 */
router.post('/fetch-and-sync', async (req, res) => {
  const { dateFrom, dateTo, storeId, country, region = 'SA', storeName, companyId, tzOffset } = req.body || {};

  if (!dateFrom || !dateTo) {
    return res.status(400).json({ error: 'dateFrom and dateTo are required' });
  }

  try {
    // Step 1: Fetch from Odoo
    logger.info('Starting fetch from Odoo', { dateFrom, dateTo, storeId, country });

    const fetchJobId = startFetchJob({
      dateFrom,
      dateTo,
      storeId: storeId ? Number(storeId) : undefined,
      storeName,
      country,
      companyId: companyId ? Number(companyId) : undefined,
      tzOffset
    });

    // Wait for fetch to complete (poll job status)
    await waitForJobCompletion(fetchJobId, 300000); // 5 minute timeout

    // Step 2: Get fetched sales
    const { rows: sales } = db.querySales({
      dateFrom,
      dateTo,
      storeId: storeId ? Number(storeId) : undefined,
      country,
      limit: 10000
    });

    if (sales.length === 0) {
      return res.json({
        success: true,
        message: 'No sales fetched from Odoo',
        fetchJobId,
        synced: 0,
        total: 0
      });
    }

    // Step 3: Sync to Oracle
    const creds = db.getActiveCredentials();
    const oracleConfig = creds?.oracleDb;

    if (!oracleConfig || !oracleConfig.host) {
      return res.status(400).json({
        error: 'Oracle database not configured'
      });
    }

    const salesData = sales.map(sale => {
      const fullSale = db.getSaleWithLines(sale.id);
      return {
        sale: fullSale,
        lines: fullSale.lines || [],
        payments: fullSale.payments || []
      };
    });

    logger.info('Syncing to Oracle BACKUP tables', {
      totalSales: salesData.length,
      region
    });

    const result = await oracleDbClient.syncSalesToOracle(oracleConfig, salesData, region);

    res.json({
      success: true,
      message: `Fetched ${sales.length} sales and synced ${result.synced} to Oracle`,
      fetchJobId,
      ...result
    });

  } catch (err) {
    logger.error('Fetch and sync failed', { error: err.message });
    res.status(500).json({
      error: err.message,
      details: 'Failed to fetch from Odoo or sync to Oracle'
    });
  }
});

/**
 * GET /api/backup-sync/status
 * Get Oracle DB connection status
 */
router.get('/status', async (req, res) => {
  try {
    const creds = db.getActiveCredentials();
    const oracleConfig = creds?.oracleDb;

    if (!oracleConfig || !oracleConfig.host) {
      return res.json({
        configured: false,
        connected: false,
        message: 'Oracle database not configured'
      });
    }

    const testResult = await oracleDbClient.testConnection(oracleConfig);

    res.json({
      configured: true,
      connected: testResult.ok,
      ...testResult
    });

  } catch (err) {
    res.json({
      configured: true,
      connected: false,
      error: err.message
    });
  }
});

/**
 * Helper: Wait for job to complete
 */
async function waitForJobCompletion(jobId, timeoutMs = 300000) {
  const startTime = Date.now();
  const pollInterval = 2000; // 2 seconds

  while (Date.now() - startTime < timeoutMs) {
    const job = db.getJob(jobId);

    if (!job) {
      throw new Error(`Job ${jobId} not found`);
    }

    if (job.status === 'COMPLETED') {
      return job;
    }

    if (job.status === 'FAILED') {
      throw new Error(`Job ${jobId} failed: ${job.error_message || 'Unknown error'}`);
    }

    // Wait before next poll
    await new Promise(resolve => setTimeout(resolve, pollInterval));
  }

  throw new Error(`Job ${jobId} timed out after ${timeoutMs}ms`);
}

module.exports = router;
