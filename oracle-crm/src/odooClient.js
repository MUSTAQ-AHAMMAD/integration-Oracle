'use strict';

/**
 * odooClient.js
 *
 * Lightweight Odoo JSONRPC client.
 *
 * Supported operations:
 *   authenticate()                              → uid (number)
 *   searchSalesOrders(domain, fields, opts)     → sale.order[]
 *   getSaleOrderLines(orderIds, fields)         → sale.order.line[]
 *   getStores()                                 → res.partner[] (or stock.warehouse[])
 *
 * Authentication uses Odoo's standard JSONRPC /web/dataset/call_kw or
 * /jsonrpc endpoint with the "common" service for auth and "object" for
 * model calls.
 *
 * Environment variables used:
 *   ODOO_URL       – e.g. https://mycompany.odoo.com
 *   ODOO_DB        – Odoo database name
 *   ODOO_USERNAME  – login username / email
 *   ODOO_PASSWORD  – password or API key
 */

const http   = require('http');
const https  = require('https');
const axios  = require('axios');
const logger = require('./logger').child('OdooClient');

const JSONRPC_PATH        = '/jsonrpc';
const SESSION_AUTH_PATH   = '/web/session/authenticate';
const CALL_KW_PATH        = '/web/dataset/call_kw';

/**
 * Convert a low-level HTTP / JSON-parse error into a human-readable message.
 *
 * When Odoo (or a proxy in front of it) returns an HTML error page, axios will
 * either throw a SyntaxError during JSON parsing or, with silent-parse mode,
 * hand back the raw HTML string as `res.data`.  Both cases are detected here so
 * that callers receive a clear message instead of the raw
 * "Unexpected token '<', "<!DOCTYPE "... is not valid JSON" error.
 *
 * @param {Error}  err      Error thrown by axios (or re-thrown internally).
 * @param {string} context  Short description used as a prefix in the message.
 * @returns {Error}
 */
function _normalizeHttpError(err, context) {
  const prefix = context ? `${context}: ` : '';

  // axios error with an HTTP response (non-2xx status)
  if (err.response) {
    const status = err.response.status;
    const body   = err.response.data;
    if (typeof body === 'string' && body.trimStart().startsWith('<')) {
      return new Error(
        `${prefix}Odoo returned an HTML page (HTTP ${status}). ` +
        'The URL may be wrong or the server is redirecting to a login / error page.'
      );
    }
    // HTTP 4xx on the JSONRPC endpoint usually means the URL is wrong.
    // Common mistake 1: using a REST API endpoint URL (e.g. /api/vSales/Sale_detail)
    // instead of just the Odoo base URL (e.g. https://www.ibqpos.com).
    // Common mistake 2: the server is a REST-only API and does not support JSONRPC at all.
    if (status === 400 || status === 404 || status === 405) {
      const requestUrl = (err.config && err.config.url) || '';
      const baseUrl    = (err.config && err.config.baseURL) || '';
      const fullUrl    = baseUrl + requestUrl;
      if (/\/api\//i.test(fullUrl)) {
        return new Error(
          `${prefix}HTTP ${status}: The Odoo URL appears to contain a REST API path ` +
          `(e.g. /api/vSales/…). For JSONRPC authentication, use only the base URL ` +
          `(e.g. https://www.ibqpos.com) — or switch the auth type to x-api-key / bearer ` +
          `if this server uses a REST API. Full URL tried: ${fullUrl}`
        );
      }
      // The JSONRPC endpoint itself returned a 4xx – the server may be a REST-only API
      // (e.g. a custom POS/ERP that exposes /api/… endpoints but not /jsonrpc).
      return new Error(
        `${prefix}HTTP ${status}: The server rejected the JSONRPC request (${fullUrl}). ` +
        `If this server uses a REST API instead of standard Odoo JSONRPC, ` +
        `switch the auth type to "x-api-key" or "bearer" in the Server Credentials configuration.`
      );
    }
    return new Error(`${prefix}HTTP ${status}: ${err.message}`);
  }

  // SyntaxError from JSON.parse inside axios transformResponse
  if (err instanceof SyntaxError || (err.message && err.message.includes('is not valid JSON'))) {
    return new Error(
      `${prefix}Odoo returned a non-JSON response. ` +
      'The server may be down, returning an HTML error page, or the URL is incorrect. ' +
      `(${err.message})`
    );
  }

  // Fallback: catch axios errors that carry "status code NNN" in their message but
  // where err.response is not available (e.g. when an interceptor re-wraps the error).
  // Provide the same actionable hint rather than leaking the raw axios message.
  if (err.message && /status code \d+/i.test(err.message)) {
    const match  = err.message.match(/status code (\d+)/i);
    const status = match ? Number(match[1]) : 0;
    if (status === 400 || status === 404 || status === 405) {
      return new Error(
        `${prefix}HTTP ${status}: The server rejected the JSONRPC request. ` +
        `If this server uses a REST API instead of standard Odoo JSONRPC, ` +
        `switch the auth type to "x-api-key" or "bearer" in the Server Credentials configuration.`
      );
    }
    return new Error(`${prefix}${err.message}`);
  }

  return err;
}

// Persistent connections to Odoo – avoids repeated TLS negotiation during
// paginated fetches.  maxSockets is set generously; Odoo's thread pool is the
// real bottleneck, not the number of sockets on the client.
const _httpAgent  = new http.Agent ({ keepAlive: true, maxSockets: 16 });
const _httpsAgent = new https.Agent({ keepAlive: true, maxSockets: 16 });

class OdooClient {
  /**
   * @param {string} url        Base URL  (no trailing slash)
   * @param {string} db         Database name
   * @param {string} username   Username / email
   * @param {string} password   Password or API key
   * @param {string} [apiUrl]   Optional separate base URL used exclusively for JSONRPC
   *                            API calls.  When the Odoo web-facing URL and the JSONRPC
   *                            API endpoint are on different domains (e.g. the API is
   *                            exposed on api.mycompany.com while the UI lives on
   *                            www.mycompany.com) set this to the API base URL.
   *                            If omitted, `url` is used for both display and API calls.
   * @param {number} [version]  Odoo version number (e.g. 15, 16, 17, 18).  Versions ≥ 17
   *                            use `/web/session/authenticate` + `/web/dataset/call_kw`
   *                            instead of the legacy `/jsonrpc` endpoint.
   *                            0 or omitted → legacy `/jsonrpc` behaviour (Odoo ≤ 16).
   */
  constructor(url, db, username, password, apiUrl, version = 0) {
    this.url      = url.replace(/\/$/, '');
    // Auto-infer db from URL if not provided (e.g. https://mycompany.odoo.com → 'mycompany').
    // Falls back to empty string rather than null so downstream code that requires a string stays safe.
    this.db       = db || OdooClient.inferDbFromUrl(url) || '';
    this.username = username;
    this.password = password;
    this.uid      = null;
    // apiUrl overrides the HTTP base for all JSONRPC calls when the API is
    // hosted on a different domain than the main Odoo URL.
    this.apiUrl   = (apiUrl || url).replace(/\/$/, '');
    // Odoo version – drives which endpoint paths are used.
    // version >= 17  →  /web/session/authenticate  +  /web/dataset/call_kw
    // version <  17  →  /jsonrpc  (legacy, default)
    this.version  = Number(version) || 0;
    // Session cookie obtained after authenticating against /web/session/authenticate.
    // Used as the Authorization mechanism for all subsequent v17+ calls.
    this._sessionCookies = null;

    this.http = axios.create({
      baseURL    : this.apiUrl,
      timeout    : 60_000,
      headers    : {
        'Content-Type': 'application/json',
        'Accept'      : 'application/json',
      },
      httpAgent  : _httpAgent,
      httpsAgent : _httpsAgent,
    });
  }

  // ── Version helpers ────────────────────────────────────────────────────────

  /** @returns {boolean} true when this instance targets Odoo 17 or newer. */
  _isV17Plus() {
    return this.version >= 17;
  }

  // ── Internal JSONRPC helpers ───────────────────────────────────────────────

  /**
   * Legacy JSONRPC helper – used for Odoo ≤ 16.
   * Targets the `/jsonrpc` endpoint with explicit service routing.
   */
  async _call(service, method, args) {
    const payload = {
      jsonrpc : '2.0',
      method  : 'call',
      id      : Date.now(),
      params  : { service, method, args },
    };

    let res;
    try {
      res = await this.http.post(JSONRPC_PATH, payload);
    } catch (err) {
      throw _normalizeHttpError(err, 'Odoo JSONRPC');
    }

    // Guard: some proxy/CDN configs return HTML as the response body even when
    // the status code is 200 (e.g. a WAF login wall).
    if (typeof res.data === 'string' && res.data.trimStart().startsWith('<')) {
      throw new Error(
        'Odoo JSONRPC: endpoint returned HTML instead of JSON. ' +
        'The server may be redirecting to a login page or returning an error page. ' +
        'If you are using Odoo 17 or newer, set the Odoo Version to 17 or 18 in the configuration.'
      );
    }

    if (res.data.error) {
      const { code, message, data: errData } = res.data.error;
      throw new Error(
        `Odoo JSONRPC error [${code}]: ${message}` +
        (errData ? ` – ${errData.message || JSON.stringify(errData)}` : '')
      );
    }
    return res.data.result;
  }

  /**
   * Odoo 17/18 model-call helper.
   * Targets `/web/dataset/call_kw` and authenticates via the session cookie
   * that was stored during `_authenticateV17()`.
   *
   * @param {string} model
   * @param {string} method
   * @param {Array}  args
   * @param {object} kwargs
   */
  async _callV17(model, method, args, kwargs) {
    const payload = {
      jsonrpc : '2.0',
      method  : 'call',
      id      : Date.now(),
      params  : { model, method, args, kwargs },
    };

    let res;
    try {
      res = await this.http.post(CALL_KW_PATH, payload);
    } catch (err) {
      throw _normalizeHttpError(err, 'Odoo JSONRPC v17+');
    }

    if (typeof res.data === 'string' && res.data.trimStart().startsWith('<')) {
      throw new Error(
        'Odoo JSONRPC v17+: endpoint returned HTML instead of JSON. ' +
        'Check that the Odoo URL is correct and the session is valid.'
      );
    }

    if (res.data.error) {
      const { code, message, data: errData } = res.data.error;
      throw new Error(
        `Odoo JSONRPC v17+ error [${code}]: ${message}` +
        (errData ? ` – ${errData.message || JSON.stringify(errData)}` : '')
      );
    }
    return res.data.result;
  }

  /**
   * Authenticate against `/web/session/authenticate` (Odoo 17/18).
   * Stores the session cookie for subsequent model calls.
   * @returns {number} uid
   */
  async _authenticateV17() {
    logger.debug('Authenticating with Odoo 17/18', { url: this.url, db: this.db, user: this.username });
    const payload = {
      jsonrpc : '2.0',
      method  : 'call',
      id      : Date.now(),
      params  : { db: this.db, login: this.username, password: this.password },
    };

    let res;
    try {
      res = await this.http.post(SESSION_AUTH_PATH, payload);
    } catch (err) {
      throw _normalizeHttpError(err, 'Odoo session authenticate');
    }

    if (typeof res.data === 'string' && res.data.trimStart().startsWith('<')) {
      throw new Error(
        'Odoo session authenticate: endpoint returned HTML instead of JSON. ' +
        'Check the Odoo URL and credentials.'
      );
    }

    if (res.data.error) {
      const { code, message, data: errData } = res.data.error;
      throw new Error(
        `Odoo session authenticate error [${code}]: ${message}` +
        (errData ? ` – ${errData.message || JSON.stringify(errData)}` : '')
      );
    }

    const result = res.data.result || {};
    const uid    = result.uid;
    if (!uid) {
      throw new Error('Odoo 17/18 authentication failed – check ODOO_URL, ODOO_DB, ODOO_USERNAME, ODOO_PASSWORD');
    }

    // Persist session cookie so all subsequent calls to /web/dataset/call_kw
    // are authenticated without re-sending credentials.
    const setCookieRaw = res.headers['set-cookie'];
    if (setCookieRaw) {
      const cookieParts = (Array.isArray(setCookieRaw) ? setCookieRaw : [setCookieRaw])
        .map(c => c.split(';')[0]);  // keep only name=value, strip path/expiry/etc.
      this._sessionCookies = cookieParts.join('; ');
      this.http.defaults.headers.common['Cookie'] = this._sessionCookies;
    }

    this.uid = uid;
    logger.info('Odoo 17/18 authenticated', { uid, db: this.db });
    return uid;
  }

  // ── Public API ─────────────────────────────────────────────────────────────

  /**
   * Authenticate with Odoo and cache uid for subsequent calls.
   * Routes to the correct endpoint based on the configured Odoo version:
   *   version >= 17 → POST /web/session/authenticate (stores session cookie)
   *   version <  17 → POST /jsonrpc with service='common' (legacy)
   * @returns {number} uid
   */
  async authenticate() {
    if (this._isV17Plus()) {
      return this._authenticateV17();
    }
    logger.debug('Authenticating with Odoo', { url: this.url, db: this.db, user: this.username });
    const uid = await this._call('common', 'authenticate', [
      this.db, this.username, this.password, {},
    ]);
    if (!uid) throw new Error('Odoo authentication failed – check ODOO_URL, ODOO_DB, ODOO_USERNAME, ODOO_PASSWORD');
    this.uid = uid;
    logger.info('Odoo authenticated', { uid, db: this.db });
    return uid;
  }

  /**
   * Ensure authenticated (authenticate once per instance).
   */
  async ensureAuth() {
    if (!this.uid) await this.authenticate();
    return this.uid;
  }

  /**
   * Execute a model method via JSONRPC.
   * Routes to the correct endpoint based on the configured Odoo version:
   *   version >= 17 → POST /web/dataset/call_kw (session-cookie auth)
   *   version <  17 → POST /jsonrpc with service='object' (legacy)
   * @param {string}   model   Odoo model name (e.g. 'sale.order')
   * @param {string}   method  Method name (e.g. 'search_read')
   * @param {Array}    args    Positional arguments
   * @param {object}   kwargs  Keyword arguments (limit, offset, fields, etc.)
   */
  async execute(model, method, args = [], kwargs = {}) {
    const uid = await this.ensureAuth();
    if (this._isV17Plus()) {
      return this._callV17(model, method, args, kwargs);
    }
    return this._call('object', 'execute_kw', [
      this.db, uid, this.password, model, method, args, kwargs,
    ]);
  }

  /**
   * Fetch sale orders matching the given domain.
   *
   * @param {Array}    domain  Odoo domain filter, e.g. [['date_order','>=','2024-01-01']]
   * @param {string[]} fields  Fields to return  (default: standard set)
   * @param {object}   opts
   * @param {number}   opts.limit   (default: 1000)
   * @param {number}   opts.offset  (default: 0)
   * @returns {object[]}
   */
  async searchSalesOrders(domain = [], fields, opts = {}) {
    const defaultFields = [
      'id', 'name', 'date_order', 'state',
      'partner_id', 'currency_id',
      'amount_untaxed', 'amount_tax', 'amount_total',
      'order_line', 'invoice_ids',
      // warehouse / store – field name varies by Odoo version
      'warehouse_id', 'team_id',
    ];
    const { limit = 1000, offset = 0 } = opts;

    logger.debug('Fetching Odoo sales orders', { domain, limit, offset });

    const rows = await this.execute('sale.order', 'search_read', [domain], {
      fields : fields || defaultFields,
      limit,
      offset,
    });

    logger.info('Fetched Odoo sales orders', { count: rows.length });
    return rows;
  }

  /**
   * Fetch sale order line items for an array of order IDs.
   *
   * @param {number[]} orderIds
   * @param {string[]} fields
   */
  async getSaleOrderLines(orderIds, fields) {
    const defaultFields = [
      'id', 'order_id', 'product_id', 'name',
      'product_uom_qty', 'qty_delivered',
      'price_unit', 'price_subtotal', 'tax_id',
      'default_code', 'sequence', 'discount',
    ];

    if (!orderIds || orderIds.length === 0) return [];

    logger.debug('Fetching Odoo sale order lines', { orderCount: orderIds.length });

    const rows = await this.execute('sale.order.line', 'search_read',
      [[['order_id', 'in', orderIds]]],
      { fields: fields || defaultFields, limit: 0 }
    );

    logger.info('Fetched Odoo sale order lines', { count: rows.length });
    return rows;
  }

  /**
   * Fetch available warehouses (used as "stores").
   * Falls back to an empty array if the model is not available.
   */
  async getStores() {
    try {
      const rows = await this.execute('stock.warehouse', 'search_read', [[]], {
        fields: ['id', 'name', 'code', 'partner_id'],
        limit : 200,
      });
      logger.info('Fetched Odoo stores (warehouses)', { count: rows.length });
      return rows;
    } catch (err) {
      logger.warn('Could not fetch stock.warehouse – returning empty list', { err: err.message });
      return [];
    }
  }

  /**
   * Fetch payment records (account.payment) for a set of sale order invoice IDs.
   * This is the 3rd Odoo API endpoint (after sale.order and sale.order.line)
   * and mirrors the middleware's BackupVendhqPayments data.
   *
   * @param {number[]} invoiceIds  account.move IDs from sale.order.invoice_ids
   * @param {string[]} [fields]    fields to return
   * @returns {object[]}
   */
  async getOrderPayments(invoiceIds, fields) {
    if (!invoiceIds || invoiceIds.length === 0) return [];

    const defaultFields = [
      'id', 'name', 'payment_type', 'amount', 'date',
      'currency_id', 'journal_id', 'partner_id', 'state', 'move_id',
    ];

    logger.debug('Fetching Odoo payments (account.payment)', { invoiceCount: invoiceIds.length });

    // Fetch payments whose linked journal entry (move_id) is in the set of
    // invoice IDs we collected from the sale orders.
    const rows = await this.execute('account.payment', 'search_read',
      [[['move_id', 'in', invoiceIds], ['payment_type', '=', 'inbound']]],
      { fields: fields || defaultFields, limit: 0 }
    );

    logger.info('Fetched Odoo payments', { count: rows.length });
    return rows;
  }

  /**
   * List all databases available on this Odoo server.
   * Does NOT require authentication – uses the public /web/database/list endpoint.
   * @returns {string[]} list of database names
   */
  async listDatabases() {
    logger.debug('Listing Odoo databases', { url: this.url });
    let res;
    try {
      res = await this.http.post('/web/database/list', { jsonrpc: '2.0', method: 'call', id: Date.now(), params: {} });
    } catch (err) {
      throw _normalizeHttpError(err, 'Odoo listDatabases');
    }
    if (typeof res.data === 'string' && res.data.trimStart().startsWith('<')) {
      throw new Error('Odoo listDatabases: endpoint returned HTML instead of JSON.');
    }
    if (res.data && res.data.error) {
      const { code, message, data: errData } = res.data.error;
      throw new Error(
        `Odoo JSONRPC error [${code}]: ${message}` +
        (errData ? ` – ${errData.message || JSON.stringify(errData)}` : '')
      );
    }
    const dbs = res.data.result;
    logger.info('Listed Odoo databases', { count: Array.isArray(dbs) ? dbs.length : 0 });
    return Array.isArray(dbs) ? dbs : [];
  }

  /**
   * Create a new database on this Odoo server.
   * Requires the Odoo master password (set in odoo.conf or ODOO_MASTER_PASSWORD env var on the Odoo server).
   *
   * @param {string} masterPassword  Odoo master/administrator password
   * @param {string} dbName          Name of the database to create
   * @param {string} adminLogin      Admin login for the new database (default: 'admin')
   * @param {string} adminPassword   Admin password for the new database
   * @param {string} [lang]          Language code, e.g. 'en_US' (default: 'en_US')
   * @param {string} [countryCode]   ISO country code, e.g. 'AE' (optional)
   * @returns {boolean} true on success
   */
  async createDatabase(masterPassword, dbName, adminLogin = 'admin', adminPassword, lang = 'en_US', countryCode = '') {
    logger.info('Creating Odoo database', { url: this.url, dbName, lang });
    let res;
    try {
      res = await this.http.post('/web/database/create', {
        jsonrpc: '2.0',
        method : 'call',
        id     : Date.now(),
        params : {
          master_pwd   : masterPassword,
          name         : dbName,
          login        : adminLogin,
          password     : adminPassword,
          lang,
          country_code : countryCode,
          phone        : '',
        },
      });
    } catch (err) {
      throw _normalizeHttpError(err, 'Odoo createDatabase');
    }
    if (typeof res.data === 'string' && res.data.trimStart().startsWith('<')) {
      throw new Error('Odoo createDatabase: endpoint returned HTML instead of JSON.');
    }
    if (res.data && res.data.error) {
      const { code, message, data: errData } = res.data.error;
      throw new Error(
        `Odoo JSONRPC error [${code}]: ${message}` +
        (errData ? ` – ${errData.message || JSON.stringify(errData)}` : '')
      );
    }
    logger.info('Odoo database created', { dbName });
    return true;
  }

  /**
   * Infer the Odoo database name from the instance URL.
   * For odoo.com SaaS instances the subdomain IS the database name.
   * e.g. https://mycompany.odoo.com → 'mycompany'
   * Returns null if the URL doesn't match the odoo.com pattern.
   * @param {string} url
   * @returns {string|null}
   */
  static inferDbFromUrl(url) {
    if (!url) return null;
    try {
      const hostname = new URL(url).hostname; // e.g. mycompany.odoo.com
      if (hostname.endsWith('.odoo.com')) {
        return hostname.split('.')[0]; // 'mycompany'
      }
    } catch (_) { /* ignore parse errors */ }
    return null;
  }

  /**
   * Build a standard domain for filtering by date range and optional store/company.
   *
   * When tzOffset is provided the local day boundaries (00:00:00 and 23:59:59)
   * are shifted to UTC so that Odoo's UTC-stored date_order field is queried
   * correctly for a specific local-time calendar day.
   *
   * Example: dateFrom='2026-02-01', tzOffset=4 (UAE, UTC+4)
   *   → UTC start: '2026-01-31 20:00:00'  (midnight UAE = 20:00 UTC the day before)
   *   → UTC end  : '2026-02-01 19:59:59'  (23:59:59 UAE = 19:59:59 UTC)
   *
   * @param {string}  dateFrom    YYYY-MM-DD
   * @param {string}  dateTo      YYYY-MM-DD (inclusive)
   * @param {number}  [storeId]   warehouse id
   * @param {number}  [companyId] Odoo company id (for multi-company instances)
   * @param {number}  [tzOffset]  positive integer hours ahead of UTC (e.g. 4 for UAE, 3 for Kuwait)
   */
  static buildDomain(dateFrom, dateTo, storeId, companyId = null, tzOffset = 0) {
    let startUtc, endUtc;

    if (tzOffset && typeof tzOffset === 'number') {
      // Convert local day boundaries to UTC by treating the input as a local date
      // and subtracting the UTC offset.  Use Date.UTC() to avoid Node.js host-TZ
      // interference – all arithmetic is performed in UTC milliseconds.
      const shiftDatetime = (dateStr, hour, minute, second, offsetHours) => {
        const [y, m, d] = dateStr.split('-').map(Number);
        const utcMs = Date.UTC(y, m - 1, d, hour - offsetHours, minute, second);
        const dt    = new Date(utcMs);
        const pad   = n => String(n).padStart(2, '0');
        return `${dt.getUTCFullYear()}-${pad(dt.getUTCMonth() + 1)}-${pad(dt.getUTCDate())} ` +
               `${pad(dt.getUTCHours())}:${pad(dt.getUTCMinutes())}:${pad(dt.getUTCSeconds())}`;
      };
      startUtc = shiftDatetime(dateFrom, 0,  0,  0,  tzOffset);
      endUtc   = shiftDatetime(dateTo,   23, 59, 59, tzOffset);
    } else {
      startUtc = `${dateFrom} 00:00:00`;
      endUtc   = `${dateTo} 23:59:59`;
    }

    const d = [
      ['date_order', '>=', startUtc],
      ['date_order', '<=', endUtc],
    ];
    if (storeId)   d.push(['warehouse_id', '=', storeId]);
    if (companyId) d.push(['company_id', '=', companyId]);
    return d;
  }
}

module.exports = OdooClient;
