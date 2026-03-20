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

const JSONRPC_PATH = '/jsonrpc';

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
   */
  constructor(url, db, username, password, apiUrl) {
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

  // ── Internal JSONRPC helper ────────────────────────────────────────────────

  async _call(service, method, args) {
    const payload = {
      jsonrpc : '2.0',
      method  : 'call',
      id      : Date.now(),
      params  : { service, method, args },
    };

    const res = await this.http.post(JSONRPC_PATH, payload);

    if (res.data.error) {
      const { code, message, data: errData } = res.data.error;
      throw new Error(
        `Odoo JSONRPC error [${code}]: ${message}` +
        (errData ? ` – ${errData.message || JSON.stringify(errData)}` : '')
      );
    }
    return res.data.result;
  }

  // ── Public API ─────────────────────────────────────────────────────────────

  /**
   * Authenticate with Odoo and cache uid for subsequent calls.
   * @returns {number} uid
   */
  async authenticate() {
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
   * @param {string}   model   Odoo model name (e.g. 'sale.order')
   * @param {string}   method  Method name (e.g. 'search_read')
   * @param {Array}    args    Positional arguments
   * @param {object}   kwargs  Keyword arguments (limit, offset, fields, etc.)
   */
  async execute(model, method, args = [], kwargs = {}) {
    const uid = await this.ensureAuth();
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
    const res = await this.http.post('/web/database/list', { jsonrpc: '2.0', method: 'call', id: Date.now(), params: {} });
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
    const res = await this.http.post('/web/database/create', {
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
   * Build a standard domain for filtering by date range and optional store.
   *
   * @param {string}  dateFrom   YYYY-MM-DD
   * @param {string}  dateTo     YYYY-MM-DD (inclusive)
   * @param {number}  [storeId]  warehouse id
   * @param {string[]} [states]  default: ['sale','done']
   */
  static buildDomain(dateFrom, dateTo, storeId, states = ['sale', 'done']) {
    const d = [
      ['date_order', '>=', `${dateFrom} 00:00:00`],
      ['date_order', '<=', `${dateTo} 23:59:59`],
      ['state', 'in', states],
    ];
    if (storeId) d.push(['warehouse_id', '=', storeId]);
    return d;
  }
}

module.exports = OdooClient;
