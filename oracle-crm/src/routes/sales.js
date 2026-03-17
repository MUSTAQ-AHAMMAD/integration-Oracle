'use strict';

/**
 * routes/sales.js
 *
 * POST /api/sales/preview  – compute & return all calculated values (no Oracle call)
 * POST /api/sales/push     – run full Oracle Fusion push sequence
 */

const express    = require('express');
const router     = express.Router();
const { computeSalePreview } = require('../calculations');
const OraclePushService      = require('../pushOracle');

function getOracleService(req) {
  const baseUrl  = process.env.FUSION_BASE_URL;
  const username = process.env.FUSION_USERNAME;
  const password = process.env.FUSION_PASSWORD;

  if (!baseUrl || !username || !password) {
    throw new Error(
      'Oracle Fusion credentials not configured. ' +
      'Set FUSION_BASE_URL, FUSION_USERNAME, and FUSION_PASSWORD in .env'
    );
  }
  return new OraclePushService(baseUrl, username, password);
}

/**
 * POST /api/sales/preview
 * Body: { sale: { saleDate, customerType, region, tzOffset, lineItems[], payments[], receiptMethodMeta, rateIsCorporate } }
 * Returns the computed preview without making any Oracle API calls.
 */
router.post('/preview', (req, res) => {
  try {
    const { sale } = req.body;
    if (!sale) return res.status(400).json({ error: 'Missing sale object in request body' });
    const preview = computeSalePreview(sale);
    res.json({ ok: true, preview });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

/**
 * POST /api/sales/push
 * Body: { sale, metadata, outlet }
 * Runs the full 8-step Oracle Fusion push sequence.
 */
router.post('/push', async (req, res) => {
  try {
    const { sale, metadata, outlet } = req.body;
    if (!sale || !metadata || !outlet) {
      return res.status(400).json({ error: 'Request body must include sale, metadata, and outlet' });
    }

    const service = getOracleService(req);
    const result  = await service.pushSale(sale, metadata, outlet);

    res.json(result);
  } catch (err) {
    res.status(500).json({ success: false, error: err.message });
  }
});

module.exports = router;
