'use strict';

/**
 * routes/benchmark.js
 *
 * REST endpoints for the data-pipeline speed benchmark.
 *
 * POST /api/benchmark/run
 *   Run the full benchmark simulation with the supplied parameters.
 *   Body: {
 *     recordsPerDay          ?: number   (default 8000)
 *     days                   ?: number   (default 30)
 *     linesPerOrder          ?: number   (default 3)
 *     paymentsPerOrder       ?: number   (default 1.5)
 *     odooHeaderLatencyMs    ?: number   (default 300)
 *     odooLineLatencyMs      ?: number   (default 200)
 *     odooPaymentLatencyMs   ?: number   (default 150)
 *     oracleApiCallLatencyMs ?: number   (default 400)
 *     oracleApiCallsPerOrder ?: number   (default 5)
 *     fetchPageSize          ?: number   (default 500)
 *     pushBatchSize          ?: number   (default 500)
 *     maxConcurrent          ?: number   (default 10)
 *     lineFetchConcurrency   ?: number   (default 5)
 *     lineChunkSize          ?: number   (default 200)
 *   }
 *   Returns: full benchmark report JSON
 *
 * GET /api/benchmark/defaults
 *   Returns the default parameter values used when no body is supplied.
 */

const express        = require('express');
const router         = express.Router();
const { runBenchmark } = require('../benchmark');
const logger         = require('../logger').child('BenchmarkRoutes');

// Default values (mirrors benchmark.js defaults)
const DEFAULTS = {
  recordsPerDay          : 8000,
  days                   : 30,
  linesPerOrder          : 3,
  paymentsPerOrder       : 1.5,
  odooHeaderLatencyMs    : 300,
  odooLineLatencyMs      : 200,
  odooPaymentLatencyMs   : 150,
  oracleApiCallLatencyMs : 400,
  oracleApiCallsPerOrder : 5,
  fetchPageSize          : 500,
  pushBatchSize          : 500,
  maxConcurrent          : 10,
  lineFetchConcurrency   : 5,
  lineChunkSize          : 200,
};

// ── GET /api/benchmark/defaults ───────────────────────────────────────────────
router.get('/defaults', (_req, res) => {
  res.json(DEFAULTS);
});

// ── POST /api/benchmark/run ───────────────────────────────────────────────────
router.post('/run', async (req, res) => {
  const body = req.body || {};

  // Build validated params, falling back to defaults for each field
  const params = {};
  for (const [key, def] of Object.entries(DEFAULTS)) {
    const raw = body[key];
    if (raw === undefined || raw === null || raw === '') {
      params[key] = def;
    } else {
      const n = Number(raw);
      if (!isFinite(n) || n <= 0) {
        return res.status(400).json({ error: `${key} must be a positive number` });
      }
      params[key] = n;
    }
  }

  // Guard against absurdly large inputs that would stall the server
  if (params.recordsPerDay > 1_000_000) {
    return res.status(400).json({ error: 'recordsPerDay must be ≤ 1,000,000' });
  }
  if (params.days > 3650) {
    return res.status(400).json({ error: 'days must be ≤ 3,650 (10 years)' });
  }

  try {
    logger.info('Benchmark run started', params);
    const report = await runBenchmark(params);
    logger.info('Benchmark run complete', {
      totalOrders  : report.totals.totalOrders,
      pullDuration : report.odooPull.humanDuration,
      pushDuration : report.oraclePush.humanDuration,
    });
    res.json(report);
  } catch (err) {
    logger.error('Benchmark run failed', { err: err.message });
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;
