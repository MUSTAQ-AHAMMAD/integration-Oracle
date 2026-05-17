#!/usr/bin/env node
'use strict';

/**
 * Health check script for Oracle CRM
 * Used by Docker healthcheck and monitoring systems
 */

const http = require('http');

const PORT = process.env.PORT || 3000;
const HOST = process.env.HOST || 'localhost';
const TIMEOUT = 5000; // 5 seconds

const options = {
  host: HOST,
  port: PORT,
  path: '/api/health',
  method: 'GET',
  timeout: TIMEOUT
};

const healthCheck = http.request(options, (res) => {
  console.log(`Health check status: ${res.statusCode}`);

  if (res.statusCode === 200) {
    process.exit(0);
  } else {
    process.exit(1);
  }
});

healthCheck.on('error', (err) => {
  console.error('Health check failed:', err.message);
  process.exit(1);
});

healthCheck.on('timeout', () => {
  console.error('Health check timed out');
  healthCheck.destroy();
  process.exit(1);
});

healthCheck.end();
