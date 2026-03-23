'use strict';

/**
 * odooRestClient.js
 *
 * REST-based Odoo data client for deployments that expose a custom HTTP REST
 * API instead of (or in addition to) the standard JSONRPC endpoint.
 *
 * Supported authentication types:
 *   'x-api-key'  – API key sent in the  X-Api-Key  request header
 *   'bearer'     – Token sent as  Authorization: Bearer <token>
 *
 * Endpoint convention (configurable per country):
 *   Sale headers   :  GET <baseUrl>/api/vSales/Sale_detail?domain=[...]
 *   Order lines    :  GET <baseUrl>/api/vSales/PosOrderLine?domain=[...]
 *   Payment lines  :  GET <baseUrl>/api/vSales/payment_lines?domain=[...]
 *
 * The returned rows are normalised to match the field names that OdooClient
 * (JSONRPC) produces so that odooSync._runFetchJob() can use either client
 * transparently.
 *
 * Environment / config variables used (per-country overrides take precedence):
 *   ODOO_URL       – base URL  (e.g. https://www.ibqpos.com)
 *   ODOO_API_KEY   – key value when auth type is x-api-key or bearer
 */

const http   = require('http');
const https  = require('https');
const axios  = require('axios');
const logger = require('./logger').child('OdooRestClient');

// Persistent keep-alive agents (same pattern as OdooClient)
const _httpAgent  = new http.Agent ({ keepAlive: true, maxSockets: 16 });
const _httpsAgent = new https.Agent({ keepAlive: true, maxSockets: 16 });

// REST endpoint paths (relative to base URL)
const PATHS = {
  saleDetail   : '/api/vSales/Sale_detail',
  posOrderLine : '/api/vSales/PosOrderLine',
  paymentLines : '/api/vSales/payment_lines',
};

/**
 * Convert an Odoo-style JS domain array into the Python-tuple-notation string
 * expected by the vSales REST API.
 *
 * Example input  : [['date_order','>=','2026-02-01 21:00:00'],['company_id','=',1]]
 * Example output : [('date_order','>=','2026-02-01 21:00:00'),('company_id','=',1)]
 *
 * Array values (used with the 'in' operator) are serialised as Python lists:
 * Example input  : [['state','in',['sale','done']]]
 * Example output : [('state','in',['sale','done'])]
 */
function domainToString(domain) {
  if (!Array.isArray(domain) || domain.length === 0) return '[]';
  const parts = domain.map(clause => {
    if (!Array.isArray(clause) || clause.length !== 3) return String(clause);
    const [field, op, value] = clause;
    // Escape backslashes first, then single quotes inside string values
    // to prevent broken Python notation (e.g. O\'Brien → O\\'Brien)
    const escStr = s => String(s).replace(/\\/g, '\\\\').replace(/'/g, "\\'");
    let valStr;
    if (typeof value === 'string') {
      valStr = `'${escStr(value)}'`;
    } else if (Array.isArray(value)) {
      const items = value.map(v => (typeof v === 'string' ? `'${escStr(v)}'` : String(v))).join(',');
      valStr = `[${items}]`;
    } else {
      valStr = String(value);
    }
    return `('${field}','${op}',${valStr})`;
  });
  return `[${parts.join(',')}]`;
}

class OdooRestClient {
  /**
   * @param {string} url       Base URL, e.g. https://www.ibqpos.com  (no trailing slash)
   * @param {string} authType  'x-api-key' | 'bearer'
   * @param {string} apiKey    The API key / bearer token value
   * @param {object} [paths]   Optional custom endpoint paths to override defaults.
   *                           { saleDetail, posOrderLine, paymentLines }
   *                           e.g. { saleDetail: '/api/custom/Sales', posOrderLine: '/api/custom/Lines' }
   */
  constructor(url, authType, apiKey, paths) {
    this.url      = (url || '').replace(/\/$/, '');
    this.authType = (authType || 'x-api-key').toLowerCase();
    this.apiKey   = apiKey || '';

    // Merge custom paths over the defaults so callers can override individual
    // endpoints without having to specify all three.
    this.paths = {
      saleDetail  : (paths && paths.saleDetail)   || PATHS.saleDetail,
      posOrderLine: (paths && paths.posOrderLine)  || PATHS.posOrderLine,
      paymentLines: (paths && paths.paymentLines)  || PATHS.paymentLines,
    };

    const authHeader = this.authType === 'bearer'
      ? { Authorization: `Bearer ${this.apiKey}` }
      : { 'X-Api-Key': this.apiKey };

    this.http = axios.create({
      baseURL    : this.url,
      timeout    : 60_000,
      headers    : {
        'Content-Type': 'application/json',
        'Accept'      : 'application/json',
        ...authHeader,
      },
      httpAgent  : _httpAgent,
      httpsAgent : _httpsAgent,
    });
  }

  // ── Internal helpers ──────────────────────────────────────────────────────

  /**
   * Convert a low-level HTTP / JSON-parse error from axios into a readable
   * message.  When the server returns an HTML page (login wall, CDN error page,
   * etc.) instead of JSON, this replaces the raw SyntaxError with a descriptive
   * message that includes the endpoint path and HTTP status.
   */
  _normalizeHttpError(err, path) {
    const prefix = `Odoo REST GET ${path}: `;
    if (err.response) {
      const status = err.response.status;
      const body   = err.response.data;
      if (typeof body === 'string' && body.trimStart().startsWith('<')) {
        return new Error(
          `${prefix}server returned an HTML page (HTTP ${status}). ` +
          `Check the endpoint URL and API key. URL: ${this.url}${path}`
        );
      }
      if (status === 400) {
        // Extract a human-readable detail from the response body when available.
        let detail = '';
        if (body && typeof body === 'object') {
          detail = body.message || body.error || body.detail ||
            (Object.keys(body).length ? JSON.stringify(body).substring(0, 300) : '');
        } else if (typeof body === 'string') {
          detail = body.substring(0, 300);
        }
        return new Error(
          `${prefix}HTTP 400 (Bad Request). ` +
          (detail ? `Server said: "${detail}". ` : '') +
          `Tried URL: ${this.url}${path}. ` +
          `Check that the endpoint path and API key are correct. ` +
          `You can override the path in "REST Endpoint Paths" inside Server Credentials.`
        );
      }
      if (status === 401 || status === 403) {
        return new Error(
          `${prefix}HTTP ${status} (Authentication failed). ` +
          `Check the API key for URL: ${this.url}${path}`
        );
      }
      return new Error(`${prefix}HTTP ${status}: ${err.message}. URL: ${this.url}${path}`);
    }
    if (err instanceof SyntaxError || (err.message && err.message.includes('is not valid JSON'))) {
      return new Error(
        `${prefix}non-JSON response received. ` +
        `The server may be down or returning an HTML error page. ` +
        `URL: ${this.url}${path}. (${err.message})`
      );
    }
    return err;
  }

  /**
   * Extract a row array from a REST API response body.
   *
   * Handles the common response envelope formats used by Odoo REST APIs:
   *   - Plain array                          [ {...}, ... ]
   *   - JSONRPC result array                 { result: [ ... ] }
   *   - Paginated wrapper                    { results: [ ... ] }
   *   - Data wrapper                         { data: [ ... ] }
   *   - Records wrapper                      { records: [ ... ] }
   *   - Odoo 17 JSONRPC + nested records     { result: { records: [ ... ] } }
   *   - Odoo 17 JSONRPC + nested results     { result: { results: [ ... ] } }
   *   - Odoo 17 JSONRPC + nested data        { result: { data: [ ... ] } }
   */
  _extractRows(body) {
    if (Array.isArray(body))                                        return body;
    if (body && Array.isArray(body.result))                         return body.result;
    if (body && Array.isArray(body.results))                        return body.results;
    if (body && Array.isArray(body.data))                           return body.data;
    if (body && Array.isArray(body.records))                        return body.records;
    // Odoo 17 native REST: JSONRPC envelope wrapping a paginated object
    if (body && body.result && Array.isArray(body.result.records))  return body.result.records;
    if (body && body.result && Array.isArray(body.result.results))  return body.result.results;
    if (body && body.result && Array.isArray(body.result.data))     return body.result.data;
    return [];
  }

  async _get(path, params = {}) {
    let res;
    try {
      res = await this.http.get(path, { params });
    } catch (err) {
      throw this._normalizeHttpError(err, path);
    }

    // The vSales API may return either an array directly or a wrapper like
    // { result: [...] } / { data: [...] }.  Handle both transparently.
    const body = res.data;

    // Guard: some proxy/CDN configs return HTML (e.g. a WAF login wall) with a
    // 200 status code, causing axios to return the raw HTML string as res.data.
    if (typeof body === 'string' && body.trimStart().startsWith('<')) {
      throw new Error(
        `Odoo REST endpoint returned HTML instead of JSON. ` +
        `Check the endpoint URL and API key. URL: ${this.url}${path}`
      );
    }

    return this._extractRows(body);
  }

  // ── Public interface (mirrors OdooClient) ─────────────────────────────────

  /**
   * No-op for REST APIs – there is no session to authenticate.
   * Returns 1 (a truthy uid placeholder) so callers that check for uid work.
   */
  async authenticate() {
    logger.debug('REST client: no authentication required', { url: this.url });
    return 1;
  }

  /** Alias for authenticate() – keeps parity with OdooClient.ensureAuth(). */
  async ensureAuth() {
    return 1;
  }

  /**
   * Fetch POS sale headers that match the given domain.
   *
   * Normalises the REST response to match the field names that
   * odooSync._runFetchJob() expects from OdooClient.searchSalesOrders().
   *
   * @param {Array}  domain  Odoo-style domain, e.g. [['date_order','>=','...']]
   * @param {Array}  [fields]  ignored (REST API returns its own fields)
   * @param {object} [opts]
   * @param {number} [opts.limit]   forwarded as ?limit= query parameter to the REST API
   * @param {number} [opts.offset]  forwarded as ?offset= query parameter for pagination
   * @returns {object[]} normalised sale-order rows
   */
  async searchSalesOrders(domain = [], fields, opts = {}) {
    logger.debug('REST: fetching sale headers', { domain });
    const params = { domain: domainToString(domain) };
    if (opts.limit  != null) params.limit  = opts.limit;
    if (opts.offset != null) params.offset = opts.offset;
    const rows = await this._get(this.paths.saleDetail, params);
    logger.info('REST: fetched sale headers', { count: rows.length });
    return rows.map(r => this._normaliseSaleOrder(r));
  }

  /**
   * Fetch POS order lines for the given order IDs.
   *
   * @param {number[]} orderIds  Internal POS order IDs
   * @param {Array}    [fields]  ignored
   * @returns {object[]} normalised order-line rows
   */
  async getSaleOrderLines(orderIds, fields) {
    if (!orderIds || orderIds.length === 0) return [];
    logger.debug('REST: fetching order lines', { orderCount: orderIds.length });
    const domain = [['order_id', 'in', orderIds]];
    const rows   = await this._get(this.paths.posOrderLine, { domain: domainToString(domain) });
    logger.info('REST: fetched order lines', { count: rows.length });
    return rows.map(r => this._normaliseOrderLine(r));
  }

  /**
   * Fetch payment lines for the given date range / filters.
   * For the REST API, invoice IDs don't map directly; we delegate to a
   * domain-based query on payment_lines instead.
   *
   * @param {number[]} invoiceIds  Unused for REST path (domain-level filtering
   *                               is handled by the caller via execute())
   * @returns {object[]} normalised payment rows
   */
  async getOrderPayments(invoiceIds, fields) {
    // For the REST endpoint, payments are fetched via execute() using a date
    // domain built by the fetch job.  Returning empty here keeps the JSONRPC
    // payment-via-invoice-ids path from running on REST configs.
    return [];
  }

  /**
   * Fetch payment records from the payment_lines REST endpoint using a
   * date-based domain.  Mirrors the Java middleware's BackupVendhqPayments
   * table which is populated using sale_date / payment_date as the filter key
   * (not invoice IDs, which are a JSONRPC-only concept).
   *
   * This method is called by odooSync._runFetchJob() for REST-auth configs
   * instead of the invoice-ID path used by the JSONRPC client.
   *
   * @param {Array} domain  Odoo-style domain, e.g.
   *                        [['date','>=','2026-02-01 21:00:00'],
   *                         ['date','<=','2026-02-02 20:59:59']]
   * @returns {object[]} normalised payment rows
   */
  async getPaymentsByDateDomain(domain) {
    if (!domain || domain.length === 0) return [];
    logger.debug('REST: fetching payments by date domain', { domain });
    const rows = await this._get(this.paths.paymentLines, { domain: domainToString(domain) });
    logger.info('REST: fetched payments by date domain', { count: rows.length });
    return rows.map(r => this._normalisePayment(r));
  }

  /**
   * Generic model-method execution.
   * Only a small set of operations used by odooSync.js are mapped to REST paths.
   * Everything else returns an empty array so the sync job can continue safely.
   *
   * Mapped operations:
   *   model='pos.order' / method='search_read'  → Sale_detail
   *   model='pos.order.line' / method='search_read' → PosOrderLine
   *   model='pos.payment' / method='search_read'  → payment_lines
   *   model='sale.order' / method='read'  → Sale_detail (for invoice_ids compat)
   *
   * @param {string} model
   * @param {string} method
   * @param {Array}  args    First element is typically the domain or ID list.
   * @param {object} kwargs
   */
  async execute(model, method, args = [], kwargs = {}) {
    logger.debug('REST execute()', { model, method });

    // invoice_ids lookup used in the fetch-job payment step – not applicable
    // for POS REST configs, return empty to skip the payment-via-invoice path.
    if (model === 'sale.order' && method === 'read') {
      return (args[0] || []).map(id => ({
        id,
        name        : '',
        invoice_ids : [],
        warehouse_id: false,
        team_id     : false,
        currency_id : false,
      }));
    }

    // POS payment search via domain
    if (
      (model === 'pos.payment' || model === 'account.payment') &&
      method === 'search_read'
    ) {
      const domain = args[0] || [];
      const rows   = await this._get(this.paths.paymentLines, { domain: domainToString(domain) });
      return rows.map(r => this._normalisePayment(r));
    }

    // POS order line search
    if (model === 'pos.order.line' && method === 'search_read') {
      const domain = args[0] || [];
      const rows   = await this._get(this.paths.posOrderLine, { domain: domainToString(domain) });
      return rows.map(r => this._normaliseOrderLine(r));
    }

    // POS order / sale order search
    if ((model === 'pos.order' || model === 'sale.order') && method === 'search_read') {
      const domain = args[0] || [];
      const rows   = await this._get(this.paths.saleDetail, { domain: domainToString(domain) });
      return rows.map(r => this._normaliseSaleOrder(r));
    }

    logger.debug('REST execute(): unsupported operation – returning []', { model, method });
    return [];
  }

  // ── Field normalisers ─────────────────────────────────────────────────────

  /**
   * Normalise a REST sale-header row to match OdooClient.searchSalesOrders() output.
   * Field names follow ibqpos.com/api/vSales/Sale_detail observed response.
   */
  _normaliseSaleOrder(r) {
    // Accept both camelCase and snake_case variants from the REST API
    const id          = r.id          ?? r.pos_order_id ?? 0;
    const name        = r.name        ?? r.pos_reference ?? r.ref ?? `POS-${id}`;
    const dateOrder   = r.date_order  ?? r.create_date   ?? r.order_date ?? '';
    const state       = r.state       ?? r.status        ?? 'done';
    // amount_paid is the POS custom REST API field; fall back to amount_total then total
    const amtTotal    = Number(r.amount_total   ?? r.amount_paid ?? r.total    ?? 0);
    const amtTax      = Number(r.amount_tax     ?? r.taxes    ?? 0);
    const amtUntaxed  = Number(r.amount_untaxed ?? (amtTotal - amtTax));
    // warehouse_id / store: accept [id, name] or plain name string.
    // branch_id and config_id are POS-specific alternatives for the store/terminal.
    const warehouseId = r.warehouse_id ?? r.branch_id ?? r.config_id ?? r.location_id ?? false;
    // team_id / register: pos_name is the POS terminal name used as the register label
    const teamId      = r.team_id ?? r.sales_team_id ?? (r.pos_name ? [null, r.pos_name] : false);
    const partnerId   = r.partner_id   ?? r.customer_id   ?? false;
    const currencyId  = r.currency_id  ?? false;

    return {
      id,
      name,
      date_order  : dateOrder,
      state,
      amount_total   : amtTotal,
      amount_tax     : amtTax,
      amount_untaxed : amtUntaxed,
      warehouse_id: warehouseId,
      team_id     : teamId,
      partner_id  : partnerId,
      currency_id : currencyId,
      // Payments / invoice_ids are handled by the REST payment endpoint
      invoice_ids : [],
      order_line  : r.order_line ?? r.lines ?? [],
      _raw        : r,
    };
  }

  /**
   * Normalise a REST order-line row to match OdooClient.getSaleOrderLines() output.
   */
  _normaliseOrderLine(r) {
    const id       = r.id         ?? r.line_id ?? 0;
    const orderId  = r.order_id   ?? r.pos_order_id ?? 0;
    const productId = r.product_id ?? false;

    return {
      id,
      order_id       : Array.isArray(orderId) ? orderId : [orderId, ''],
      product_id     : Array.isArray(productId) ? productId : [productId, r.product_name ?? r.full_product_name ?? ''],
      name           : r.name ?? r.full_product_name ?? r.product_name ?? '',
      product_uom_qty: Number(r.product_uom_qty ?? r.qty    ?? r.quantity ?? 0),
      qty_delivered  : Number(r.qty_delivered   ?? r.qty    ?? r.quantity ?? 0),
      price_unit     : Number(r.price_unit      ?? r.price  ?? 0),
      price_subtotal : Number(r.price_subtotal  ?? r.subtotal ?? 0),
      tax_id         : r.tax_id ?? r.tax_ids ?? [],
      default_code   : r.default_code ?? r.sku ?? null,
      sequence       : r.sequence ?? r.line_number ?? null,
      discount       : Number(r.discount ?? 0),
      _raw           : r,
    };
  }

  /**
   * Normalise a REST payment-line row to match OdooClient.getOrderPayments() output.
   */
  _normalisePayment(r) {
    const id        = r.id           ?? r.payment_id ?? 0;
    const journalId = r.journal_id   ?? r.payment_method_id ?? false;
    const moveId    = r.move_id      ?? r.invoice_id ?? r.session_id ?? false;
    const partnerId = r.partner_id   ?? r.customer_id ?? false;
    const currencyId = r.currency_id ?? false;

    return {
      id,
      name        : r.name         ?? r.payment_ref ?? `PMT-${id}`,
      payment_type: r.payment_type ?? 'inbound',
      amount      : Number(r.amount ?? 0),
      date        : r.date         ?? r.payment_date ?? r.create_date ?? '',
      currency_id : Array.isArray(currencyId) ? currencyId : [currencyId, r.currency ?? 'AED'],
      journal_id  : Array.isArray(journalId) ? journalId : [journalId, r.payment_method ?? r.journal_name ?? 'Cash'],
      partner_id  : partnerId,
      state       : r.state ?? 'posted',
      move_id     : Array.isArray(moveId) ? moveId : [moveId, ''],
      _raw        : r,
    };
  }

  // ── Static helpers (kept for parity with OdooClient) ─────────────────────

  static buildDomain(dateFrom, dateTo, storeId) {
    // Delegate to OdooClient's static method for consistent domain building
    const OdooClient = require('./odooClient');
    return OdooClient.buildDomain(dateFrom, dateTo, storeId);
  }

  /** Return the module-level default endpoint paths. */
  static getDefaultPaths() {
    return { ...PATHS };
  }

  /**
   * Lightweight connectivity test – fetches an arbitrary path with no filters.
   * Returns an object with both the parsed rows array and the raw response body
   * so callers can surface diagnostic information when row count is 0.
   *
   * @param {string} path  API path to test, e.g. '/api/vSales/Sale_detail'
   * @returns {Promise<{ rows: object[], rawBody: any }>}
   */
  async testPath(path) {
    let res;
    try {
      res = await this.http.get(path, { params: {} });
    } catch (err) {
      throw this._normalizeHttpError(err, path);
    }
    const rawBody = res.data;
    if (typeof rawBody === 'string' && rawBody.trimStart().startsWith('<')) {
      throw new Error(
        `Odoo REST endpoint returned HTML instead of JSON. ` +
        `Check the endpoint URL and API key. URL: ${this.url}${path}`
      );
    }
    const rows = this._extractRows(rawBody);
    return { rows, rawBody };
  }
}

module.exports = OdooRestClient;
