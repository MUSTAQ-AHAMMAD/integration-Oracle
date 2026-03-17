'use strict';

/**
 * routes/config.js
 *
 * GET  /api/config/status  – returns whether Oracle credentials are configured
 * GET  /api/config/regions – returns supported regions list
 */

const express = require('express');
const router  = express.Router();

router.get('/status', (req, res) => {
  const configured = !!(
    process.env.FUSION_BASE_URL &&
    process.env.FUSION_USERNAME &&
    process.env.FUSION_PASSWORD
  );
  res.json({
    configured,
    baseUrl : configured ? process.env.FUSION_BASE_URL : null,
    username: configured ? process.env.FUSION_USERNAME : null,
    regions : (process.env.REGIONS || 'AE,KW,OM,SA,BH,QA').split(','),
  });
});

router.get('/regions', (req, res) => {
  const regions = (process.env.REGIONS || 'AE,KW,OM,SA,BH,QA').split(',');
  res.json({ regions });
});

module.exports = router;
