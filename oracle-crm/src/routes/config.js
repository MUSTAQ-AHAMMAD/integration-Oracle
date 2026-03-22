'use strict';

/**
 * routes/config.js
 *
 * GET  /api/config/status                – Oracle credentials status (legacy)
 * GET  /api/config/regions               – supported regions list
 * GET  /api/config/full                  – complete Oracle + Odoo config with endpoint catalogue
 * POST /api/config/test-oracle           – live connectivity test against Oracle Fusion
 * POST /api/config/test-odoo             – live connectivity test against Odoo
 * POST /api/config/test-endpoint         – test an individual REST API endpoint with given credentials
 * GET  /api/config/middleware-credentials – read Oracle credentials from Java middleware files
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
const { readMiddlewareCredentials } = require('../middlewareCredentials');

// Mask applied to password fields in API responses
const PASSWORD_MASK = '••••••••';

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

// ── Odoo URL normalisation ────────────────────────────────────────────────────
// When users copy-paste a full REST API endpoint URL
// (e.g. https://www.ibqpos.com/api/vSales/Sale_detail) into the Odoo URL field
// the JSONRPC client will try to POST to /api/vSales/Sale_detail/jsonrpc, which
// returns HTTP 400 from the REST endpoint.  For JSONRPC auth we only need the
// base URL (protocol + host); for REST auth the OdooRestClient appends paths
// itself.  This helper strips any /api/… (or similar) sub-path so callers
// always work with just the base URL.
//
// Returns { url, wasNormalized, originalUrl, extractedPath }
// extractedPath is the full path before stripping (e.g. '/api/vSales/Sale_detail/jsonrpc')
// and can be used as the REST endpoint path override.
function normalizeOdooUrl(rawUrl) {
  if (!rawUrl) return { url: rawUrl, wasNormalized: false, originalUrl: rawUrl, extractedPath: null };
  const stripped = rawUrl.replace(/\/$/, '');
  try {
    const parsed = new URL(stripped);
    // Strip paths that look like REST API endpoints (start with /api/)
    if (/^\/api\//i.test(parsed.pathname)) {
      return {
        url          : parsed.origin,
        wasNormalized: true,
        originalUrl  : stripped,
        extractedPath: parsed.pathname,   // e.g. '/api/vSales/Sale_detail/jsonrpc'
      };
    }
  } catch (_) { /* invalid URL – return as-is */ }
  return { url: stripped, wasNormalized: false, originalUrl: stripped, extractedPath: null };
}

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
  const odooAuthType     = (creds.odoo.authType || 'jsonrpc').toLowerCase();
  // For REST auth (x-api-key / bearer) a database name is not needed
  const odooConfigured   = !!(creds.odoo.url && (
    (odooAuthType === 'x-api-key' || odooAuthType === 'bearer')
      ? creds.odoo.apiKey
      : (creds.odoo.username && creds.odoo.password)
  ));

  const OdooRestClient = require('../odooRestClient');
  const defaultPaths   = OdooRestClient.getDefaultPaths();
  // Use per-mode path overrides when set, falling back to defaults.
  // Note: credentials store these as saleDetailPath/orderLinePath/paymentPath,
  // while OdooRestClient uses keys saleDetail/posOrderLine/paymentLines.
  const restPaths = {
    saleDetail  : creds.odoo.saleDetailPath || defaultPaths.saleDetail,
    posOrderLine: creds.odoo.orderLinePath  || defaultPaths.posOrderLine,  // orderLine → posOrderLine (OdooRestClient key)
    paymentLines: creds.odoo.paymentPath    || defaultPaths.paymentLines,
  };

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
      authType    : odooAuthType,
      jsonrpcPath : '/jsonrpc',
      // REST endpoint paths – reflects actual configured paths, not just defaults
      restPaths,
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
// Tests the Odoo connection for the global or a specific country config.
//
// Body variants:
//   {}                         – test active saved credentials
//   { country: 'BH' }         – test a specific country's saved credentials
//   { url, apiKey, authType }  – inline REST test (no DB lookup; "test before save")
//   { url, username, password, odooDb?, apiUrl?, version? }
//                              – inline JSONRPC test (no DB lookup; "test before save")
//
// The inline mode is triggered when `url` is present in the request body.
// This lets the credential form test with unsaved values before committing them.
router.post('/test-odoo', async (req, res) => {
  const body = req.body || {};

  // ── Inline credentials mode (test before save) ────────────────────────────
  // Triggered when the caller passes `url` directly in the body instead of
  // relying on saved credentials.  Supports both REST and JSONRPC auth types.
  if (body.url) {
    const url      = String(body.url).trim().replace(/\/$/, '');
    const authType = (body.authType || 'jsonrpc').toLowerCase();

    if (authType === 'x-api-key' || authType === 'bearer') {
      const apiKey = body.apiKey ? String(body.apiKey).trim() : '';
      if (!apiKey) return res.status(400).json({ ok: false, error: 'apiKey is required for REST auth' });
      try {
        const OdooRestClient = require('../odooRestClient');
        // Normalize the URL so we always use the base URL as the axios baseURL.
        // The extracted path (e.g. '/api/vSales/Sale_detail/jsonrpc') becomes the
        // custom saleDetail path so the test hits exactly the endpoint the user entered.
        const { url: baseUrl, extractedPath } = normalizeOdooUrl(url);
        const customPaths = {};
        if (extractedPath)          customPaths.saleDetail   = extractedPath;
        if (body.saleDetailPath)    customPaths.saleDetail   = String(body.saleDetailPath).trim();
        if (body.orderLinePath)     customPaths.posOrderLine = String(body.orderLinePath).trim();
        if (body.paymentPath)       customPaths.paymentLines = String(body.paymentPath).trim();
        const client = new OdooRestClient(
          baseUrl, authType, apiKey,
          Object.keys(customPaths).length ? customPaths : undefined
        );
        // Use a parameter-free GET to avoid the HTTP 400 that servers like ibqpos.com
        // return when an empty domain=[] query-param is sent.  testPath() is a pure
        // connectivity check: any 2xx response confirms the path and API key are valid.
        const usedPath = customPaths.saleDetail || OdooRestClient.getDefaultPaths().saleDetail;
        await client.testPath(usedPath);
        res.json({ ok: true, message: `REST Odoo connection successful (${authType}, ${baseUrl}${usedPath})` });
      } catch (err) {
        res.status(200).json({ ok: false, error: err.message });
      }
      return;
    }

    // JSONRPC inline test – normalize the URL first (strip /api/… paths)
    const username = body.username ? String(body.username).trim() : '';
    const password = body.password ? String(body.password) : '';
    const apiUrl   = body.apiUrl   ? String(body.apiUrl).trim() : null;
    const version  = Number(body.version) || 0;

    const { url: normalizedUrl, wasNormalized, originalUrl } = normalizeOdooUrl(url);

    // db can be provided explicitly or auto-inferred from the URL subdomain
    const odooDb   = (body.odooDb || body.db)
      ? String(body.odooDb || body.db).trim()
      : (OdooClient.inferDbFromUrl(normalizedUrl) || '');

    if (!username) return res.status(400).json({ ok: false, error: 'username is required for JSONRPC auth' });
    if (!password) return res.status(400).json({ ok: false, error: 'password is required for JSONRPC auth' });

    // Detect the common mistake of entering a URL in the username field.
    if (/^https?:\/\//i.test(username)) {
      return res.status(200).json({
        ok   : false,
        error: `The username "${username}" looks like a URL, not a login username. ` +
               `For JSONRPC auth, set the username to your Odoo login email or username (e.g. "admin" or "user@example.com"). ` +
               `If this server uses a REST API instead, switch the auth type to "x-api-key" or "bearer" in the form above.`,
      });
    }

    // Build normalization hint once so both success and failure paths share the message.
    const normHintInline = wasNormalized
      ? ` Note: The URL "${originalUrl}" contains a REST API path; ` +
        `only the base URL "${normalizedUrl}" is used for JSONRPC. ` +
        `If this server uses a REST API (not standard Odoo JSONRPC), switch auth type to "x-api-key" / "bearer".`
      : '';

    try {
      const client = new OdooClient(normalizedUrl, odooDb, username, password, apiUrl, version);
      const uid    = await client.authenticate();
      const versionLabel = version === 0 ? 'legacy' : version;
      res.json({ ok: true, message: `Odoo connection successful (uid=${uid}, version=${versionLabel})${normHintInline}`, uid });
    } catch (err) {
      res.status(200).json({ ok: false, error: err.message + normHintInline });
    }
    return;
  }

  // ── Saved-credentials mode (existing behaviour) ───────────────────────────
  let creds;
  try {
    const country = body.country ? String(body.country).toUpperCase() : null;
    creds = country ? db.getCredentialsForCountry(country) : db.getActiveCredentials();
  } catch (err) {
    return res.status(200).json({ ok: false, error: `Failed to load saved credentials: ${err.message}` });
  }
  const authType = (creds.odoo.authType || 'jsonrpc').toLowerCase();

  if (authType === 'x-api-key' || authType === 'bearer') {
    // REST-based connectivity test
    const url    = creds.odoo.url;
    const apiKey = creds.odoo.apiKey;
    if (!url || !apiKey) {
      return res.status(400).json({
        ok   : false,
        error: 'REST Odoo credentials not configured. Set Odoo URL and API key in Server Credentials.',
      });
    }
    try {
      const OdooRestClient = require('../odooRestClient');
      // Use configured path overrides so the test hits exactly the right endpoint.
      const customPaths = {};
      if (creds.odoo.saleDetailPath) customPaths.saleDetail   = creds.odoo.saleDetailPath;
      if (creds.odoo.orderLinePath)  customPaths.posOrderLine = creds.odoo.orderLinePath;
      if (creds.odoo.paymentPath)    customPaths.paymentLines = creds.odoo.paymentPath;
      const client = new OdooRestClient(
        url, authType, apiKey,
        Object.keys(customPaths).length ? customPaths : undefined
      );
      // Use a parameter-free GET to avoid the HTTP 400 that servers like ibqpos.com
      // return when an empty domain=[] query-param is sent.  testPath() is a pure
      // connectivity check: any 2xx response confirms the path and API key are valid.
      const usedPath = customPaths.saleDetail || OdooRestClient.getDefaultPaths().saleDetail;
      await client.testPath(usedPath);
      res.json({ ok: true, message: `REST Odoo connection successful (${authType}, ${url}${usedPath})` });
    } catch (err) {
      res.status(200).json({ ok: false, error: err.message });
    }
    return;
  }

  // Standard JSONRPC path
  const rawUrl   = creds.odoo.url;
  const odooDb   = creds.odoo.db;
  const username = creds.odoo.username;
  const password = creds.odoo.password;
  const apiUrl   = creds.odoo.apiUrl || null;
  const version  = creds.odoo.version || 0;

  // Normalize the URL before any other checks so that a REST API path in the
  // saved URL is caught early and results in an actionable error message.
  const { url, wasNormalized, originalUrl } = normalizeOdooUrl(rawUrl || '');

  // If the saved URL contains a REST API path (/api/…) and auth type is JSONRPC,
  // JSONRPC authentication will never succeed.  Return an actionable error now
  // so the user knows exactly what to fix instead of seeing a generic HTTP 400.
  if (wasNormalized) {
    return res.status(200).json({
      ok   : false,
      error: `The saved Odoo URL "${originalUrl}" contains a REST API path (/api/…). ` +
             `This indicates a REST API server, not a standard Odoo JSONRPC server. ` +
             `To fix: open Server Credentials and either — ` +
             `(A) switch the auth type to "x-api-key" or "bearer" and enter your API key (recommended for REST servers), or ` +
             `(B) update the URL to just the base URL "${url}" if this server also supports standard Odoo JSONRPC.`,
    });
  }

  // DB is optional – OdooClient will infer it from *.odoo.com URLs or leave it
  // empty (the JSONRPC call will return a clear error if a DB name is required).
  if (!url || !username || !password) {
    return res.status(400).json({
      ok   : false,
      error: 'Odoo credentials not configured. ' +
             'Set credentials via the Configuration page (Server Credentials section).',
    });
  }

  // Detect the common misconfiguration where the Odoo URL was accidentally
  // saved in the username field (e.g. username = "https://www.ibqpos.com/").
  // Sending a URL as a username always causes the Odoo server to reject the
  // request with HTTP 400, surfacing a confusing raw-axios error message.
  // This can also happen when the user has a REST API server but the auth type
  // is still set to JSONRPC – in that case they should switch to x-api-key/bearer.
  if (/^https?:\/\//i.test(username)) {
    return res.status(200).json({
      ok   : false,
      error: `The saved Odoo username "${username}" looks like a URL, not a login username. ` +
             `Open Server Credentials and either — ` +
             `(A) switch the auth type to "x-api-key" or "bearer" and enter your API key if this server uses a REST API, or ` +
             `(B) set the username to your Odoo login email or username (e.g. "admin" or "user@example.com") for standard JSONRPC.`,
    });
  }

  try {
    const client = new OdooClient(url, odooDb, username, password, apiUrl, version);
    const uid    = await client.authenticate();
    res.json({ ok: true, message: `Odoo connection successful (uid=${uid}, ${creds.mode} server, version=${version === 0 ? 'legacy' : version})`, uid });
  } catch (err) {
    res.status(200).json({ ok: false, error: err.message });
  }
});

// ── POST /api/config/test-endpoint ────────────────────────────────────────────
// Test an individual REST API endpoint with optional credentials override.
// Body: {
//   url:      string  – base URL or full REST URL (required)
//   apiKey:   string  – API key / bearer token (required)
//   authType: string  – 'x-api-key' | 'bearer' (default: 'x-api-key')
//   path:     string  – API path to test (default: /api/vSales/Sale_detail)
//   country:  string  – optional; loads country creds if url/apiKey not provided
// }
router.post('/test-endpoint', async (req, res) => {
  const { country, path: endpointPath } = req.body || {};
  let { url, apiKey, authType } = req.body || {};

  // If url / apiKey not provided, load from country config (or global defaults)
  if (!url || !apiKey) {
    try {
      const creds = country
        ? db.getCredentialsForCountry(String(country).toUpperCase())
        : db.getActiveCredentials();
      url      = url      || creds.odoo.url;
      apiKey   = apiKey   || creds.odoo.apiKey;
      authType = authType || creds.odoo.authType;
    } catch (err) {
      return res.status(200).json({ ok: false, error: `Failed to load saved credentials: ${err.message}` });
    }
  }

  authType = (authType || 'x-api-key').toLowerCase();

  if (!url)    return res.status(400).json({ ok: false, error: 'url is required' });
  if (!apiKey) return res.status(400).json({ ok: false, error: 'apiKey is required' });

  const OdooRestClient = require('../odooRestClient');

  // Normalise the URL so that a full REST API URL
  // (e.g. https://www.ibqpos.com/api/vSales/Sale_detail/) is used correctly.
  // Without normalisation the extracted path would be appended to the full URL,
  // producing a double-path like /api/vSales/Sale_detail/api/vSales/Sale_detail/.
  // The extracted path becomes the effective test path when no explicit path was given.
  const { url: baseUrl, extractedPath } = normalizeOdooUrl(url);
  const effectivePath = endpointPath || extractedPath || OdooRestClient.getDefaultPaths().saleDetail;

  try {
    const client = new OdooRestClient(baseUrl, authType, apiKey);
    // Use the public testPath helper to probe any arbitrary endpoint path
    const rows = await client.testPath(effectivePath);
    res.json({
      ok     : true,
      message: `Endpoint reachable – received ${Array.isArray(rows) ? rows.length : '?'} record(s)`,
      url    : baseUrl,
      path   : effectivePath,
      count  : Array.isArray(rows) ? rows.length : null,
    });
  } catch (err) {
    res.status(200).json({ ok: false, error: err.message, url: baseUrl, path: effectivePath });
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
  const mask = (value) => (value ? PASSWORD_MASK : null);
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
        url           : db.getAppSetting(`odoo_${m}_url`)       || (m === 'production' ? process.env.ODOO_URL       || null : null),
        username      : db.getAppSetting(`odoo_${m}_username`)  || (m === 'production' ? process.env.ODOO_USERNAME   || null : null),
        password      : mask(db.getAppSetting(`odoo_${m}_password`) || (m === 'production' ? process.env.ODOO_PASSWORD : null)),
        authType      : db.getAppSetting(`odoo_${m}_auth_type`) || (m === 'production' ? process.env.ODOO_AUTH_TYPE  || 'jsonrpc' : 'jsonrpc'),
        apiKey        : mask(db.getAppSetting(`odoo_${m}_api_key`)  || (m === 'production' ? process.env.ODOO_API_KEY  : null)),
        apiUrl        : db.getAppSetting(`odoo_${m}_api_url`)   || (m === 'production' ? process.env.ODOO_API_URL   || null : null),
        version       : Number(db.getAppSetting(`odoo_${m}_version`) || (m === 'production' ? process.env.ODOO_VERSION || 0 : 0)),
        saleDetailPath: db.getAppSetting(`odoo_${m}_sale_detail_path`) || (m === 'production' ? process.env.ODOO_SALE_DETAIL_PATH || null : null),
        orderLinePath : db.getAppSetting(`odoo_${m}_order_line_path`)  || (m === 'production' ? process.env.ODOO_ORDER_LINE_PATH  || null : null),
        paymentPath   : db.getAppSetting(`odoo_${m}_payment_path`)     || (m === 'production' ? process.env.ODOO_PAYMENT_PATH     || null : null),
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
  // Normalize the Odoo URL: strip REST API path suffixes so the base URL is
  // always stored.  This prevents OdooClient from appending /jsonrpc to a
  // REST endpoint path (e.g. /api/vSales/Sale_detail) which causes HTTP 400.
  const odooNorm = (odoo && odoo.url !== undefined) ? normalizeOdooUrl(odoo.url) : null;

  // Auto-detect REST server: if the saved URL contained a REST API path (/api/…)
  // and the caller did not explicitly choose a REST auth type, automatically
  // switch auth type to 'x-api-key'.  This breaks the "repeating JSONRPC error"
  // cycle where the user enters a REST URL but auth type stays jsonrpc and every
  // connection test fails with the same mismatch error.
  const odooAuthTypeAutoSwitched =
    !!(odooNorm && odooNorm.wasNormalized &&
       (!odoo || !odoo.authType || odoo.authType === 'jsonrpc'));

  if (odoo) {
    persist(`odoo_${mode}_url`,       odooNorm ? odooNorm.url : odoo.url);
    persist(`odoo_${mode}_username`,  odoo.username);
    persist(`odoo_${mode}_password`,  odoo.password);
    persist(`odoo_${mode}_auth_type`, odooAuthTypeAutoSwitched ? 'x-api-key' : odoo.authType);
    persist(`odoo_${mode}_api_key`,   odoo.apiKey);
    persist(`odoo_${mode}_api_url`,   odoo.apiUrl);
    if (odoo.version !== undefined) {
      persist(`odoo_${mode}_version`, odoo.version != null ? String(Number(odoo.version)) : null);
    }
    // REST endpoint paths: explicit body values take highest priority.
    // When the URL was normalized and no explicit path is provided, auto-save
    // the extracted path (e.g. '/api/vSales/Sale_detail/jsonrpc') so that the
    // REST client calls exactly the endpoint the user entered.
    const autoPath = odooNorm?.extractedPath;
    persist(`odoo_${mode}_sale_detail_path`,
      odoo.saleDetailPath !== undefined ? odoo.saleDetailPath : autoPath);
    persist(`odoo_${mode}_order_line_path`,  odoo.orderLinePath);
    persist(`odoo_${mode}_payment_path`,     odoo.paymentPath);
  }

  res.json({
    ok  : true,
    mode,
    ...(odooNorm && odooNorm.wasNormalized && {
      warning: odooAuthTypeAutoSwitched
        ? `REST API URL detected: "${odooNorm.originalUrl}". ` +
          `URL normalized to base URL "${odooNorm.url}" and auth type automatically switched to "x-api-key". ` +
          `Enter your API key to complete the REST API configuration.`
        : `Odoo URL normalized to base URL "${odooNorm.url}" (REST API path stripped). ` +
          `If this server uses a REST API, update the auth type to x-api-key / bearer.`,
    }),
  });
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

// ── GET /api/config/country-configs ──────────────────────────────────────────
router.get('/country-configs', (req, res) => {
  const configs = db.listCountryConfigs();
  const safe = configs.map(c => ({
    ...c,
    odoo_password   : c.odoo_password    ? PASSWORD_MASK : null,
    odoo_api_key    : c.odoo_api_key     ? PASSWORD_MASK : null,
    oracle_password : c.oracle_password  ? PASSWORD_MASK : null,
  }));
  res.json(safe);
});

// ── PUT /api/config/country-configs/:code ─────────────────────────────────────
router.put('/country-configs/:code', (req, res) => {
  const countryCode = req.params.code.toUpperCase();
  const {
    country_name, odoo_url, odoo_api_url, odoo_username, odoo_password,
    odoo_auth_type, odoo_api_key, odoo_version,
    odoo_sale_detail_path, odoo_order_line_path, odoo_payment_path,
    oracle_base_url, oracle_username, oracle_password, enabled,
  } = req.body || {};

  if (!country_name) return res.status(400).json({ error: 'country_name is required' });

  const validAuthTypes = ['jsonrpc', 'x-api-key', 'bearer'];
  if (odoo_auth_type && !validAuthTypes.includes(odoo_auth_type)) {
    return res.status(400).json({ error: `odoo_auth_type must be one of: ${validAuthTypes.join(', ')}` });
  }

  // Validate odoo_version if provided
  const versionNum = odoo_version != null ? Number(odoo_version) : 0;
  if (isNaN(versionNum) || versionNum < 0) {
    return res.status(400).json({ error: 'odoo_version must be a non-negative number (e.g. 0, 15, 16, 17, 18)' });
  }

  // Normalize the Odoo URL to base URL and auto-detect REST auth type.
  // This prevents the "repeating JSONRPC error" cycle where a REST URL like
  // https://example.com/api/vSales/Sale_detail is saved with authType=jsonrpc.
  const odooNorm = odoo_url ? normalizeOdooUrl(odoo_url) : null;
  const normalizedOdooUrl = odooNorm ? odooNorm.url : (odoo_url || null);
  const ccAuthTypeAutoSwitched =
    !!(odooNorm && odooNorm.wasNormalized && (!odoo_auth_type || odoo_auth_type === 'jsonrpc'));
  const effectiveAuthType = ccAuthTypeAutoSwitched ? 'x-api-key' : (odoo_auth_type || 'jsonrpc');

  const existing = db.getCountryConfig(countryCode);
  const resolvePass = (incoming, field) => {
    if (incoming === PASSWORD_MASK) return existing ? existing[field] : null;
    return incoming || null;
  };

  db.upsertCountryConfig({
    countryCode,
    countryName       : country_name,
    odooUrl           : normalizedOdooUrl,
    odooApiUrl        : odoo_api_url         || null,
    odooUsername      : odoo_username        || null,
    odooPassword      : resolvePass(odoo_password, 'odoo_password'),
    odooAuthType      : effectiveAuthType,
    odooApiKey        : resolvePass(odoo_api_key,  'odoo_api_key'),
    odooVersion       : versionNum,
    odooSaleDetailPath: odoo_sale_detail_path || null,
    odooOrderLinePath : odoo_order_line_path  || null,
    odooPaymentPath   : odoo_payment_path     || null,
    oracleBaseUrl     : oracle_base_url       || null,
    oracleUsername    : oracle_username       || null,
    oraclePassword    : resolvePass(oracle_password, 'oracle_password'),
    enabled           : enabled !== undefined ? (enabled ? 1 : 0) : 1,
  });
  res.json({
    ok: true,
    countryCode,
    ...(odooNorm && odooNorm.wasNormalized && {
      warning: ccAuthTypeAutoSwitched
        ? `REST API URL detected: "${odooNorm.originalUrl}". ` +
          `URL normalized to "${odooNorm.url}" and auth type switched to "x-api-key". ` +
          `Enter the API key to complete REST configuration.`
        : `Odoo URL normalized to "${odooNorm.url}" (REST API path stripped).`,
    }),
  });
});

// ── DELETE /api/config/country-configs/:code ──────────────────────────────────
router.delete('/country-configs/:code', (req, res) => {
  const countryCode = req.params.code.toUpperCase();
  db.deleteCountryConfig(countryCode);
  res.json({ ok: true });
});

// ── GET /api/config/middleware-credentials ────────────────────────────────────
// Reads Oracle Fusion credentials from the Java middleware configuration files
// stored in the repository:
//   • Fusion_Environment.json     – Postman environment (base URL + username)
//   • Integration_Environment.json – Postman environment (base URL + username)
//   • FusionRESTClient/.../RestUtils.java            – hardcoded Basic-Auth pair
//   • FusionRESTClient/.../FusionAvailableQtyService.java – FusionAppParams instance
//
// Note: the original Java middleware integrated with VendHQ (not Odoo), so
// no Odoo credentials are present in those files.
router.get('/middleware-credentials', (req, res) => {
  const { oracle, sources, found } = readMiddlewareCredentials();
  res.json({ found, oracle: found ? oracle : null, sources });
});

// ── POST /api/config/import-middleware-credentials ────────────────────────────
// Reads Oracle credentials from Java middleware files and persists them to the
// DB for the specified modes.  Existing values are overwritten.
// Body (optional): { modes: ['test', 'production'] }  – defaults to both.
router.post('/import-middleware-credentials', (req, res) => {
  const modes  = (req.body && Array.isArray(req.body.modes))
    ? req.body.modes.filter(m => m === 'test' || m === 'production')
    : ['test', 'production'];

  if (modes.length === 0) {
    return res.status(400).json({ error: 'modes must include "test" and/or "production"' });
  }

  const { oracle, sources, found } = readMiddlewareCredentials();

  if (!found) {
    return res.status(404).json({ ok: false, error: 'No Oracle credentials found in middleware files' });
  }

  // Persist to DB for each requested mode
  for (const mode of modes) {
    if (oracle.baseUrl)  db.setAppSetting(`oracle_${mode}_base_url`,  oracle.baseUrl);
    if (oracle.username) db.setAppSetting(`oracle_${mode}_username`, oracle.username);
    if (oracle.password) db.setAppSetting(`oracle_${mode}_password`, oracle.password);
  }

  res.json({ ok: true, oracle, modes, sources });
});

module.exports = router;
