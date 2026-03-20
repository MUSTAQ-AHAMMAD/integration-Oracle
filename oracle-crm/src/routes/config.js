'use strict';

/**
 * routes/config.js
 *
 * GET  /api/config/status       – Oracle credentials status (legacy)
 * GET  /api/config/regions      – supported regions list
 * GET  /api/config/full         – complete Oracle + Odoo config with endpoint catalogue
 * POST /api/config/test-oracle  – live connectivity test against Oracle Fusion
 * POST /api/config/test-odoo    – live connectivity test against Odoo
 *
 * The endpoint catalogues (ORACLE_ENDPOINTS, ODOO_ENDPOINTS) are derived
 * directly from the middleware Java classes so that the CRM UI reflects
 * exactly which API paths are exercised when a push job runs:
 *
 *   Java source → Node.js equivalent
 *   ─────────────────────────────────────────────────────────────────────
 *   FusionInvoiceClient             → oracleClient.createInvoice()
 *   FusionReceiptClient (std)       → oracleClient.createReceipt()
 *   FusionReceiptClient (apply)     → oracleClient.applyReceipt()
 *   FusionMiscReceiptMapping        → oracleClient.createReceipt() (misc)
 *   FusionInvTxnService             → oracleClient.createInventoryTransaction()
 *   FusionJournalClient             → oracleClient.createJournal()
 *   FusionUomService                → oracleClient.getUomCode()
 *   FusionCustomerProfileClient     → oracleClient.getCustomer()
 *   VendHQSalesToFusionInvRecIntBackup.doIntegration() → odooSync._runPushJob()
 *   VendHQSalesToFusionInvRecTransBackup (calculations) → calculations.js
 */

const express      = require('express');
const router       = express.Router();
const OdooClient   = require('../odooClient');
const OracleClient = require('../oracleClient');
const db           = require('../db');

// ── Oracle Fusion REST endpoint catalogue ─────────────────────────────────────
// Derived from the Java middleware SOAP/REST service calls.
// API version 11.13.18.05 matches the path used in oracleClient.js constructor.
const ORACLE_ENDPOINTS = [
  {
    name       : 'GET Customer Profile',
    path       : '/fscmRestApi/resources/11.13.18.05/customers',
    method     : 'GET',
    javaSource : 'FusionCustomerProfileClient.getCustomerAccountId() / getPaymentTerms()',
    description: 'Retrieve bill-to customer account ID and payment terms by account number.',
  },
  {
    name       : 'GET UOM Code',
    path       : '/fscmRestApi/resources/11.13.18.05/units',
    method     : 'GET',
    javaSource : 'FusionUomService.getUomCode(uomName)',
    description: 'Resolve Oracle Unit-of-Measure code from a UOM name for each invoice line.',
  },
  {
    name       : 'GET External Bank Accounts',
    path       : '/fscmRestApi/resources/11.13.18.05/externalBankAccounts',
    method     : 'GET',
    javaSource : 'FusionStdReceiptMapping – registerDetails.getBankAccount()',
    description: 'Fetch remittance bank account IDs used when building receipt payloads.',
  },
  {
    name       : 'POST Create AR Invoice',
    path       : '/fscmRestApi/resources/11.13.18.05/receivablesInvoices',
    method     : 'POST',
    javaSource : 'FusionInvoiceClient.createInvoice() – FusionInvoiceMapping.mapToInvoiceHeader/Line()',
    description: 'Create an Accounts Receivable invoice with all computed line items. ' +
                 'Applies unitSellingPrice, effectiveQuantity, conversionRateType from calculations.js.',
  },
  {
    name       : 'POST Create Standard Receipt',
    path       : '/fscmRestApi/resources/11.13.18.05/receivablesReceipts',
    method     : 'POST',
    javaSource : 'FusionReceiptClient.createStandardReceipt() – FusionStdReceiptMapping',
    description: 'Create one standard receipt per payment method. ' +
                 'Amount = grossAmount − miscCharges (netReceiptAmount from calculations.js).',
  },
  {
    name       : 'POST Apply Receipt on Account',
    path       : '/fscmRestApi/resources/11.13.18.05/receivablesReceipts/{receiptId}/child/applyReceiptOnAccount',
    method     : 'POST',
    javaSource : 'FusionReceiptClient.applyReceiptOnInvoice() – FusionApplyReceiptMapping',
    description: 'Link each standard receipt to the invoice to clear the AR open balance.',
  },
  {
    name       : 'POST Create Miscellaneous Receipt',
    path       : '/fscmRestApi/resources/11.13.18.05/receivablesReceipts',
    method     : 'POST',
    javaSource : 'FusionReceiptClient.createMiscReceipt() – FusionMiscReceiptMapping',
    description: 'Bank charge / cash-rounding misc receipt. ' +
                 'Amount = miscCharges computed by calculateMiscCharges() in calculations.js.',
  },
  {
    name       : 'POST Inventory Transaction',
    path       : '/fscmRestApi/resources/11.13.18.05/inventoryTransactions',
    method     : 'POST',
    javaSource : 'FusionInvTxnService.createInventoryTransaction() – FusionInvTxnMapping',
    description: 'Deduct inventory. TransactionQuantity = qty × −1 (inventoryTransactionQty). ' +
                 'TransactionType = "Vend Sales Issue" or "Vend RMA" per inventoryTransactionType().',
  },
  {
    name       : 'POST Import GL Journal',
    path       : '/fscmRestApi/resources/11.13.18.05/journals',
    method     : 'POST',
    javaSource : 'FusionJournalClient.importJournal() – FusionJournalEntryMapping',
    description: 'Import journal entry for non-NORMAL customers only. ' +
                 'Credit/Debit amounts from calculateJournalCharge() in calculations.js.',
  },
];

// ── Odoo JSONRPC endpoint catalogue ──────────────────────────────────────────
// All Odoo calls share a single HTTP path (/jsonrpc); the service + method
// + model arguments encode the operation.  Derived from odooClient.js which
// replaces the VendHQ REST API used by the Java middleware.
const ODOO_ENDPOINTS = [
  {
    name       : 'Authenticate',
    path       : '/jsonrpc',
    service    : 'common',
    method     : 'authenticate',
    model      : null,
    odooMethod : null,
    description: 'Authenticate with Odoo and obtain the uid required for all ' +
                 'subsequent object calls. Equivalent to logging in via /web/session/authenticate.',
  },
  {
    name       : 'Search Sale Orders',
    path       : '/jsonrpc',
    service    : 'object',
    method     : 'execute_kw',
    model      : 'sale.order',
    odooMethod : 'search_read',
    description: 'Fetch confirmed/done sale orders filtered by date_order range ' +
                 'and optionally by warehouse_id. Paginated at ODOO_FETCH_PAGE_SIZE (default 500).',
  },
  {
    name       : 'Get Sale Order Lines',
    path       : '/jsonrpc',
    service    : 'object',
    method     : 'execute_kw',
    model      : 'sale.order.line',
    odooMethod : 'search_read',
    description: 'Fetch line items (product_id, product_uom_qty, price_unit, ' +
                 'price_subtotal, tax_id) for all fetched order IDs. Chunked in batches of 200.',
  },
  {
    name       : 'Get Warehouses / Stores',
    path       : '/jsonrpc',
    service    : 'object',
    method     : 'execute_kw',
    model      : 'stock.warehouse',
    odooMethod : 'search_read',
    description: 'List all Odoo warehouses. Each warehouse is treated as a ' +
                 '"store" in BY_STORE_DATE push mode. Used to populate the store dropdown.',
  },
];

// ── GET /api/config/status ────────────────────────────────────────────────────
router.get('/status', (req, res) => {
  const creds      = db.getActiveCredentials();
  const configured = !!(creds.oracle.baseUrl && creds.oracle.username && creds.oracle.password);
  res.json({
    configured,
    baseUrl : configured ? creds.oracle.baseUrl    : null,
    username: configured ? creds.oracle.username   : null,
    mode    : creds.mode,
    regions : (process.env.REGIONS || 'AE,KW,OM,SA,BH,QA').split(','),
  });
});

// ── GET /api/config/regions ───────────────────────────────────────────────────
router.get('/regions', (req, res) => {
  const regions = (process.env.REGIONS || 'AE,KW,OM,SA,BH,QA').split(',');
  res.json({ regions });
});

// ── GET /api/config/full ──────────────────────────────────────────────────────
// Returns complete configuration: Oracle + Odoo status, all endpoints, regions.
router.get('/full', (req, res) => {
  const creds          = db.getActiveCredentials();
  const oracleConfigured = !!(creds.oracle.baseUrl && creds.oracle.username && creds.oracle.password);
  const odooConfigured   = !!(creds.odoo.url && creds.odoo.db && creds.odoo.username && creds.odoo.password);

  res.json({
    mode  : creds.mode,
    oracle: {
      configured : oracleConfigured,
      baseUrl    : oracleConfigured ? creds.oracle.baseUrl    : null,
      username   : oracleConfigured ? creds.oracle.username   : null,
      apiVersion : '11.13.18.05',
      endpoints  : ORACLE_ENDPOINTS,
    },
    odoo: {
      configured  : odooConfigured,
      url         : odooConfigured ? creds.odoo.url       : null,
      db          : odooConfigured ? creds.odoo.db        : null,
      username    : odooConfigured ? creds.odoo.username  : null,
      jsonrpcPath : '/jsonrpc',
      endpoints   : ODOO_ENDPOINTS,
    },
    regions: (process.env.REGIONS || 'AE,KW,OM,SA,BH,QA').split(','),
  });
});

// ── POST /api/config/test-oracle ──────────────────────────────────────────────
// Makes a lightweight GET /customers call to verify Oracle Fusion credentials.
router.post('/test-oracle', async (req, res) => {
  const creds   = db.getActiveCredentials();
  const baseUrl  = creds.oracle.baseUrl;
  const username = creds.oracle.username;
  const password = creds.oracle.password;

  if (!baseUrl || !username || !password) {
    return res.status(400).json({
      ok   : false,
      error: 'Oracle Fusion credentials not configured. ' +
             'Set credentials via the Configuration page (Server Credentials section).',
    });
  }

  try {
    const client = new OracleClient(baseUrl, username, password);
    // A GET /customers with a non-existent account number is the lightest
    // possible call: it never creates data and always returns quickly.
    // HTTP 200 (empty items) or 404 both confirm the credentials are accepted.
    await client.getCustomer('__connectivity_test__');
    res.json({ ok: true, message: `Oracle Fusion connection successful (${creds.mode} server)` });
  } catch (err) {
    const status = err.response ? err.response.status : null;
    // 200 with empty items → credentials good, record not found (expected)
    // 404 → endpoint found, auth accepted
    if (status === 404) {
      return res.json({ ok: true, message: `Oracle Fusion connection successful – credentials accepted (${creds.mode} server)` });
    }
    if (status === 401 || status === 403) {
      return res.status(401).json({
        ok   : false,
        error: 'Oracle Fusion authentication failed – check username and password for the active server.',
      });
    }
    res.status(500).json({ ok: false, error: err.message });
  }
});

// ── POST /api/config/test-odoo ────────────────────────────────────────────────
// Authenticates with Odoo and returns the uid to confirm credentials work.
router.post('/test-odoo', async (req, res) => {
  const creds    = db.getActiveCredentials();
  const url      = creds.odoo.url;
  const odooDb   = creds.odoo.db;
  const username = creds.odoo.username;
  const password = creds.odoo.password;

  if (!url || !odooDb || !username || !password) {
    return res.status(400).json({
      ok   : false,
      error: 'Odoo credentials not configured. ' +
             'Set credentials via the Configuration page (Server Credentials section).',
    });
  }

  try {
    const client = new OdooClient(url, odooDb, username, password);
    const uid    = await client.authenticate();
    res.json({ ok: true, message: `Odoo connection successful (uid=${uid}, ${creds.mode} server)`, uid });
  } catch (err) {
    res.status(500).json({ ok: false, error: err.message });
  }
});

// ── GET /api/config/server-mode ───────────────────────────────────────────────
// Returns the current server mode (test | production).
router.get('/server-mode', (req, res) => {
  const mode       = db.getAppSetting('server_mode', 'production');
  const switchedAt = db.getAppSetting('server_mode_switched_at', null);
  res.json({ mode, switchedAt });
});

// ── PUT /api/config/server-mode ───────────────────────────────────────────────
// Switch server mode.  Body: { mode: 'test' | 'production' }
router.put('/server-mode', (req, res) => {
  const { mode } = req.body || {};
  if (mode !== 'test' && mode !== 'production') {
    return res.status(400).json({ error: 'mode must be "test" or "production"' });
  }
  db.setAppSetting('server_mode', mode);
  db.setAppSetting('server_mode_switched_at', new Date().toISOString());
  res.json({ ok: true, mode });
});

// ── GET /api/config/credentials ───────────────────────────────────────────────
// Returns all stored credentials for both modes.
// Passwords are masked; pass ?reveal=1 to receive the raw values (admin use only).
router.get('/credentials', (req, res) => {
  const mask = (value) => (value ? '••••••••' : null);
  const modes = ['test', 'production'];

  const result = {};
  for (const m of modes) {
    result[m] = {
      oracle: {
        baseUrl : db.getAppSetting(`oracle_${m}_base_url`)  || (m === 'production' ? process.env.FUSION_BASE_URL  || null : null),
        username: db.getAppSetting(`oracle_${m}_username`)  || (m === 'production' ? process.env.FUSION_USERNAME  || null : null),
        password: mask(db.getAppSetting(`oracle_${m}_password`) || (m === 'production' ? process.env.FUSION_PASSWORD : null)),
      },
      odoo: {
        url     : db.getAppSetting(`odoo_${m}_url`)      || (m === 'production' ? process.env.ODOO_URL      || null : null),
        db      : db.getAppSetting(`odoo_${m}_db`)       || (m === 'production' ? process.env.ODOO_DB       || null : null),
        username: db.getAppSetting(`odoo_${m}_username`) || (m === 'production' ? process.env.ODOO_USERNAME  || null : null),
        password: mask(db.getAppSetting(`odoo_${m}_password`) || (m === 'production' ? process.env.ODOO_PASSWORD : null)),
      },
    };
  }

  res.json(result);
});

// ── PUT /api/config/credentials ───────────────────────────────────────────────
// Save credentials for a specific mode.
// Body: { mode: 'test'|'production', oracle?: {...}, odoo?: {...} }
// Empty-string values are ignored (keeps existing value); null explicitly clears.
router.put('/credentials', (req, res) => {
  const { mode, oracle, odoo } = req.body || {};
  if (mode !== 'test' && mode !== 'production') {
    return res.status(400).json({ error: 'mode must be "test" or "production"' });
  }

  const persist = (key, value) => {
    if (value === undefined) return; // field not sent → leave unchanged
    if (value === null || value === '') {
      db.setAppSetting(key, null);
    } else {
      db.setAppSetting(key, value);
    }
  };

  if (oracle) {
    persist(`oracle_${mode}_base_url`,  oracle.baseUrl);
    persist(`oracle_${mode}_username`,  oracle.username);
    persist(`oracle_${mode}_password`,  oracle.password);
  }
  if (odoo) {
    persist(`odoo_${mode}_url`,      odoo.url);
    persist(`odoo_${mode}_db`,       odoo.db);
    persist(`odoo_${mode}_username`, odoo.username);
    persist(`odoo_${mode}_password`, odoo.password);
  }

  res.json({ ok: true, mode });
});

// ── GET /api/config/activity-summary ─────────────────────────────────────────
// Returns last push (Oracle) and last pull (Odoo fetch) timestamps.
router.get('/activity-summary', (req, res) => {
  const push  = db.getLastPushInfo();
  const fetch = db.getLastFetchInfo();
  res.json({
    lastPush : {
      at       : push.last_pushed_at,
      date     : push.last_pushed_date,
      country  : push.country,
      storeName: push.store_name,
    },
    lastPull : {
      at      : fetch.last_pull_at,
      dateFrom: fetch.last_pull_date_from,
      dateTo  : fetch.last_pull_date_to,
    },
  });
});

module.exports = router;
