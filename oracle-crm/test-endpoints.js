#!/usr/bin/env node
'use strict';

/**
 * test-endpoints.js
 *
 * Test script to verify all Odoo REST API endpoints are configured correctly
 * and can fetch data successfully.
 */

require('dotenv').config();
const OdooRestClient = require('./src/odooRestClient');
const logger = require('./src/logger').child('TestEndpoints');

async function testEndpoints() {
  console.log('━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━');
  console.log('🧪 Testing Odoo REST API Endpoints');
  console.log('━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n');

  // Read configuration from .env
  const url = process.env.ODOO_URL;
  const authType = process.env.ODOO_AUTH_TYPE || 'x-api-key';
  const apiKey = process.env.ODOO_API_KEY;

  if (!url || !apiKey) {
    console.error('❌ Error: ODOO_URL and ODOO_API_KEY must be set in .env file');
    process.exit(1);
  }

  console.log('📋 Configuration:');
  console.log(`   URL: ${url}`);
  console.log(`   Auth Type: ${authType}`);
  console.log(`   API Key: ${apiKey.substring(0, 10)}...`);
  console.log('');

  // Build custom paths from env
  const paths = {};
  if (process.env.ODOO_POS_ORDER_PATH) paths.posOrder = process.env.ODOO_POS_ORDER_PATH;
  if (process.env.ODOO_SALE_DETAIL_PATH) paths.saleDetail = process.env.ODOO_SALE_DETAIL_PATH;
  if (process.env.ODOO_ORDER_LINE_PATH) paths.posOrderLine = process.env.ODOO_ORDER_LINE_PATH;
  if (process.env.ODOO_PAYMENT_PATH) paths.paymentLines = process.env.ODOO_PAYMENT_PATH;
  if (process.env.ODOO_PRODUCTS_PATH) paths.products = process.env.ODOO_PRODUCTS_PATH;
  if (process.env.ODOO_UOM_PATH) paths.uom = process.env.ODOO_UOM_PATH;
  if (process.env.ODOO_TAXES_PATH) paths.taxes = process.env.ODOO_TAXES_PATH;
  if (process.env.ODOO_BRANCHES_PATH) paths.branches = process.env.ODOO_BRANCHES_PATH;
  if (process.env.ODOO_COMPANIES_PATH) paths.companies = process.env.ODOO_COMPANIES_PATH;
  if (process.env.ODOO_POS_LIST_PATH) paths.posList = process.env.ODOO_POS_LIST_PATH;

  const odoo = new OdooRestClient(url, authType, apiKey, Object.keys(paths).length ? paths : undefined);

  console.log('📍 Testing Endpoints:');
  console.log('');

  const tests = [];

  // Test 1: POS Orders (unified endpoint if configured)
  if (odoo.paths.posOrder) {
    tests.push({
      name: 'POS Orders (Unified)',
      fn: async () => {
        const startDate = '2026-02-01 21:00:00';
        const endDate = '2026-02-02 20:59:59';
        const orders = await odoo.getPosOrders(startDate, endDate);
        return { count: orders.length, sample: orders[0] || null };
      }
    });
  }

  // Test 2: Products
  tests.push({
    name: 'Products',
    fn: async () => {
      const products = await odoo.getProducts();
      return { count: products.length, sample: products[0] || null };
    }
  });

  // Test 3: UOM
  tests.push({
    name: 'UOM (Unit of Measure)',
    fn: async () => {
      const uom = await odoo.getUomList();
      return { count: uom.length, sample: uom[0] || null };
    }
  });

  // Test 4: Taxes
  tests.push({
    name: 'Taxes',
    fn: async () => {
      const taxes = await odoo.getTaxes();
      return { count: taxes.length, sample: taxes[0] || null };
    }
  });

  // Test 5: Companies
  tests.push({
    name: 'Companies',
    fn: async () => {
      const companies = await odoo.getCompanies();
      return { count: companies.length, sample: companies[0] || null };
    }
  });

  // Test 6: Branches
  tests.push({
    name: 'Branches',
    fn: async () => {
      const branches = await odoo.getBranches();
      return { count: branches.length, sample: branches[0] || null };
    }
  });

  // Test 7: POS List
  tests.push({
    name: 'POS List',
    fn: async () => {
      const posList = await odoo.getPosList();
      return { count: posList.length, sample: posList[0] || null };
    }
  });

  // Run all tests
  let passed = 0;
  let failed = 0;

  for (const test of tests) {
    try {
      console.log(`🔍 Testing: ${test.name}...`);
      const result = await test.fn();
      console.log(`   ✅ Success! Found ${result.count} records`);
      if (result.sample) {
        console.log(`   📄 Sample record keys: ${Object.keys(result.sample).join(', ')}`);
      }
      passed++;
    } catch (err) {
      console.log(`   ❌ Failed: ${err.message}`);
      failed++;
    }
    console.log('');
  }

  console.log('━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━');
  console.log('📊 Test Results:');
  console.log(`   ✅ Passed: ${passed}`);
  console.log(`   ❌ Failed: ${failed}`);
  console.log(`   📈 Total: ${tests.length}`);
  console.log('━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━');

  if (failed === 0) {
    console.log('\n🎉 All tests passed! Your Odoo REST API configuration is working correctly.');
    process.exit(0);
  } else {
    console.log('\n⚠️  Some tests failed. Please check the error messages above.');
    process.exit(1);
  }
}

// Run tests
testEndpoints().catch(err => {
  console.error('❌ Fatal error:', err);
  process.exit(1);
});
