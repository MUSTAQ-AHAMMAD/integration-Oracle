'use strict';

/**
 * odooSync.js
 *
 * Odoo ↔ Oracle CRM synchronisation service.
 *
 * Responsibilities:
 *   1. fetchAndStore(options)  – Pull sales from Odoo → persist to SQLite (non-blocking job)
 *   2. pushToOracle(options)   – Push stored SQLite sales → Oracle Fusion (non-blocking job)
 *
 * Both operations run as background jobs.  The caller receives a jobId immediately
 * and can poll /api/odoo/jobs/:jobId for status + incremental log.
 *
 * Push modes:
 *   BY_DATE           – push all stores, filter by date range
 *   BY_STORE_DATE     – push a specific store, filter by date range
 *   ALL_STORES_DATE   – alias for BY_DATE (explicit "all stores")
 *
 * Performance / production-scale notes:
 *   • Odoo fetch is paginated (ODOO_FETCH_PAGE_SIZE, default 500).  No data is
 *     missed even when millions of orders exist in a date range.
 *   • SQLite push is paginated (PUSH_BATCH_SIZE, default 500).  Memory stays flat.
 *   • Oracle API calls are sequential per order (Fusion doesn't support bulk POST).
 *   • Failed individual records are written to the failed_records table and NEVER
 *     halt the job – the job continues to the next record.  Failed records can be
 *     retried via startRetryJob() or the /api/odoo/retry-failed endpoint.
 *   • All DB writes are batched in transactions (no per-row fsync).
 *   • The event-loop is never blocked; background work uses setImmediate scheduling.
 */

const { randomUUID }  = require('crypto');
const OdooClient      = require('./odooClient');
const OdooRestClient  = require('./odooRestClient');
const OraclePushService = require('./pushOracle');
const db              = require('./db');
const logger          = require('./logger').child('OdooSync');

// Max concurrent Oracle pushes per job chunk (keep CRM responsive)
const MAX_CONCURRENT    = Number(process.env.ODOO_PUSH_CONCURRENCY)  || 10;
// How many orders to fetch from Odoo per page
const FETCH_PAGE_SIZE   = Number(process.env.ODOO_FETCH_PAGE_SIZE)   || 500;
// How many records to process per SQLite batch in push jobs
const PUSH_BATCH_SIZE   = Number(process.env.PUSH_BATCH_SIZE)        || 500;
// Max concurrent Odoo line-chunk fetches (paginated in parallel)
const LINE_FETCH_CONCURRENCY = Number(process.env.ODOO_LINE_FETCH_CONCURRENCY) || 5;
// Default currency used when Odoo does not return one
const DEFAULT_CURRENCY  = process.env.ODOO_DEFAULT_CURRENCY || 'AED';

// ── Factory helpers ───────────────────────────────────────────────────────────

function buildOdooClient(country) {
  const creds    = db.getCredentialsForCountry(country);
  const authType = (creds.odoo.authType || 'jsonrpc').toLowerCase();

  // REST-based client (x-api-key or bearer token authentication)
  if (authType === 'x-api-key' || authType === 'bearer') {
    const url    = creds.odoo.url;
    const apiKey = creds.odoo.apiKey;
    if (!url || !apiKey) {
      throw new Error(
        `Odoo REST connection not configured for ${creds.mode} server. ` +
        `Set Odoo URL and API key via the Configuration → Server Credentials page.`
      );
    }
    // Build optional custom paths object – only include a key if the country
    // config explicitly overrides that particular endpoint path.
    const customPaths = {};
    if (creds.odoo.saleDetailPath) customPaths.saleDetail   = creds.odoo.saleDetailPath;
    if (creds.odoo.orderLinePath)  customPaths.posOrderLine = creds.odoo.orderLinePath;
    if (creds.odoo.paymentPath)    customPaths.paymentLines = creds.odoo.paymentPath;
    return new OdooRestClient(url, authType, apiKey, Object.keys(customPaths).length ? customPaths : undefined);
  }

  // Default: standard JSONRPC client
  const url      = creds.odoo.url;
  const username = creds.odoo.username;
  const password = creds.odoo.password;
  // DB is optional for odoo.com SaaS – inferred from subdomain if not set.
  const odoo_db  = creds.odoo.db || OdooClient.inferDbFromUrl(url) || '';
  // apiUrl allows the JSONRPC API to be hosted on a different domain than
  // the main Odoo web URL (e.g. api.mycompany.com vs www.mycompany.com).
  const apiUrl   = creds.odoo.apiUrl || null;
  // version drives which JSONRPC endpoint paths are used:
  //   0 / <17  →  legacy /jsonrpc
  //   17/18    →  /web/session/authenticate + /web/dataset/call_kw
  const version  = creds.odoo.version || 0;
  if (!url || !username || !password) {
    throw new Error(
      `Odoo connection not configured for ${creds.mode} server. Set credentials via the Configuration page.`
    );
  }
  return new OdooClient(url, odoo_db, username, password, apiUrl, version);
}

function buildOracleService(country) {
  const creds = db.getCredentialsForCountry(country);
  const baseUrl  = creds.oracle.baseUrl;
  const username = creds.oracle.username;
  const password = creds.oracle.password;
  if (!baseUrl || !username || !password) {
    throw new Error(
      `Oracle Fusion credentials not configured for ${creds.mode} server. Set credentials via the Configuration page.`
    );
  }
  return new OraclePushService(baseUrl, username, password);
}

// ── Job helpers ───────────────────────────────────────────────────────────────

function jobLog(jobId, level, message, meta = {}) {
  logger[level](message, { jobId, ...meta });
  db.appendJobLog(jobId, { level, message, ...meta });
}

// ── 1. Fetch & Store ──────────────────────────────────────────────────────────

/**
 * Start a background fetch-from-Odoo job.
 *
 * @param {object} options
 * @param {string}  options.dateFrom    YYYY-MM-DD (required)
 * @param {string}  options.dateTo      YYYY-MM-DD (required, can equal dateFrom)
 * @param {number}  [options.storeId]   filter by warehouse_id
 * @param {string}  [options.storeName]
 * @param {string}  [options.mode]      'BY_DATE' | 'BY_STORE_DATE' | 'ALL_STORES_DATE'
 * @param {number}  [options.companyId] filter by Odoo company_id (multi-company)
 * @param {number}  [options.tzOffset]  explicit UTC offset in hours (e.g. 3 for UTC+3).
 *                                      Overrides the country-derived offset when provided.
 *                                      Required when Odoo stores dates in UTC and you want
 *                                      to fetch a specific local-calendar day correctly.
 * @returns {string} jobId
 */
function startFetchJob(options) {
  const { dateFrom, dateTo, storeId, storeName, country, companyId } = options;
  const mode  = storeId ? 'BY_STORE_DATE' : 'ALL_STORES_DATE';
  const jobId = randomUUID();

  db.createJob({ jobId, jobType: 'FETCH', mode, dateFrom, dateTo, storeId, storeName });
  logger.info('Fetch job created', { jobId, mode, dateFrom, dateTo, storeId, country, companyId });

  // Run in background – do NOT await
  setImmediate(() => _runFetchJob(jobId, options));

  return jobId;
}

async function _runFetchJob(jobId, { dateFrom, dateTo, storeId, country, companyId, tzOffset: explicitTzOffset }) {
  db.updateJob(jobId, { status: 'RUNNING', started_at: new Date().toISOString() });
  jobLog(jobId, 'info', 'Fetch job started', { dateFrom, dateTo, storeId, country, companyId });

  try {
    // When a country is specified, use the per-country Odoo credentials stored in
    // country_configs (URL, auth type, API key, and all three REST endpoint path
    // overrides: Sale_detail, PosOrderLine, payment_lines).
    // If no country is given, or no country config row exists, falls back to the
    // globally-configured Odoo credentials.
    const odoo = buildOdooClient(country || null);

    // tzOffset converts local calendar-day boundaries to UTC before querying Odoo,
    // which always stores date_order in UTC.
    // Priority: explicit per-request value > global app_settings default > 0.
    let globalTzOffset = 0;
    try { globalTzOffset = db.getActiveCredentials().odoo.tzOffset || 0; } catch (_) { /* ignore */ }
    const tzOffset = (explicitTzOffset !== null && explicitTzOffset !== undefined && typeof explicitTzOffset === 'number')
      ? explicitTzOffset
      : globalTzOffset;
    if (tzOffset) {
      const tzMsg = country
        ? `UTC date conversion active: ${country} (UTC+${tzOffset})`
        : `UTC date conversion active (UTC+${tzOffset})`;
      jobLog(jobId, 'info', tzMsg, { tzOffset });
    }
    const domain = OdooClient.buildDomain(dateFrom, dateTo, storeId, companyId ? Number(companyId) : null, tzOffset);

    jobLog(jobId, 'info', 'Connecting to Odoo…');
    await odoo.authenticate();

    // ── Paginated fetch from Odoo ─────────────────────────────────────────────
    // Odoo may have millions of orders; we page through them to avoid loading
    // everything into memory and to ensure no records are missed.
    let offset       = 0;
    let totalFetched = 0;
    const allOrderIdSet   = new Set();      // deduplicate IDs across pages
    const allLineIdSet    = new Set();      // line IDs from sale headers (REST `lines` field)
    const allPaymentIdSet = new Set();      // payment IDs from sale headers (REST `payment_ids` field)
    // Map payment ID → Odoo order ID for direct linking when fetching by payment ID
    const paymentIdToOrderId = new Map();
    // Map Odoo order ID → date_order for payment_date fallback (REST payment_lines may lack date)
    const orderDateMap = new Map();

    jobLog(jobId, 'info', 'Fetching sales orders from Odoo (paginated)…', {
      pageSize: FETCH_PAGE_SIZE, domain,
    });

    while (true) {
      const page = await odoo.searchSalesOrders(domain, null, {
        limit : FETCH_PAGE_SIZE,
        offset,
      });

      if (page.length === 0) break;

      // ── Safeguard: detect when the API ignores limit/offset ─────────────
      // If a single page returns > 10× the requested page size, the endpoint is
      // likely returning ALL records regardless of limit/offset.  Store the page,
      // log a warning, and stop paginating to avoid infinite loops.
      const isOversizedPage = page.length > FETCH_PAGE_SIZE * 10;
      if (isOversizedPage) {
        jobLog(jobId, 'warn',
          `Oversized page detected: received ${page.length} records when limit=${FETCH_PAGE_SIZE}. ` +
          `The REST API may not support limit/offset pagination. Stopping pagination after this page.`,
          { pageLength: page.length, limit: FETCH_PAGE_SIZE }
        );
      }

      // ── Persist headers for this page ───────────────────────────────────
      const now  = new Date().toISOString();
      const rows = page.map(o => ({
        odoo_id        : o.id,
        name           : o.name,
        store_id       : Array.isArray(o.warehouse_id) ? o.warehouse_id[0] : (o.warehouse_id || null),
        store_name     : Array.isArray(o.warehouse_id) ? o.warehouse_id[1] : null,
        country        : country || null,
        date_order     : extractDate(o.date_order),
        partner_id     : Array.isArray(o.partner_id) ? o.partner_id[0] : null,
        partner_name   : Array.isArray(o.partner_id) ? o.partner_id[1] : null,
        currency       : Array.isArray(o.currency_id) ? o.currency_id[1] : DEFAULT_CURRENCY,
        amount_untaxed : Number(o.amount_untaxed) || 0,
        amount_tax     : Number(o.amount_tax)     || 0,
        amount_total   : Number(o.amount_total)   || 0,
        state          : o.state || '',
        customer_type  : 'NORMAL',   // placeholder; partner category fetch not yet implemented
        register_name  : Array.isArray(o.team_id) ? o.team_id[1] : null,
        fetched_at     : now,
        raw_json       : JSON.stringify(o),
      }));
      db.upsertSales(rows);

      for (const o of page) {
        allOrderIdSet.add(o.id);
        // Track order date for payment_date fallback (REST payment_lines may lack date)
        orderDateMap.set(o.id, extractDate(o.date_order));
        // Collect line IDs and payment IDs provided by Sale_detail response
        if (Array.isArray(o.order_line)) {
          for (const lid of o.order_line) { if (typeof lid === 'number') allLineIdSet.add(lid); }
        }
        if (Array.isArray(o.payment_ids)) {
          for (const pid of o.payment_ids) {
            if (typeof pid === 'number') {
              allPaymentIdSet.add(pid);
              paymentIdToOrderId.set(pid, o.id);
            }
          }
        }
      }
      totalFetched += page.length;
      offset       += page.length;

      jobLog(jobId, 'info', `Fetched & stored page of ${page.length} orders`, {
        totalFetchedSoFar: totalFetched,
        uniqueOrderIds   : allOrderIdSet.size,
      });
      db.updateJob(jobId, { total: totalFetched });

      // Yield to the event loop between pages to keep the server responsive
      await new Promise(resolve => setImmediate(resolve));

      // Stop paginating if we received an oversized page (API ignores limit)
      if (isOversizedPage) break;
      if (page.length < FETCH_PAGE_SIZE) break; // last page
    }

    const allOrderIds   = [...allOrderIdSet];
    const allLineIds    = [...allLineIdSet];
    const allPaymentIds = [...allPaymentIdSet];
    jobLog(jobId, 'info', `All ${totalFetched} sale headers stored in local DB (${allOrderIds.length} unique IDs)`, {
      lineIdsFromHeaders   : allLineIds.length,
      paymentIdsFromHeaders: allPaymentIds.length,
    });

    if (totalFetched === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders found – job complete');
      return;
    }

    // ── Fetch + persist lines (parallel chunks, bulk ID lookup) ──────────────
    //
    // Two strategies depending on client type and available data:
    //   REST  + line IDs from Sale_detail:  query PosOrderLine by line IDs
    //   Otherwise (JSONRPC / no IDs):       query by parent order IDs
    jobLog(jobId, 'info', 'Fetching sale order lines…', { orderCount: allOrderIds.length });

    const LINE_FETCH_CHUNK = 200;
    let totalLines     = 0;
    let lineChunksDone = 0;
    let lineChunkErrs  = 0;

    // When the Sale_detail response provides line IDs directly, use them for
    // a more reliable fetch.  Build a single internal-ID map for all orders
    // (not per-chunk) since line-ID chunks don't align to order-ID chunks.
    const useLineIds = (odoo instanceof OdooRestClient) && allLineIds.length > 0;

    if (useLineIds) {
      jobLog(jobId, 'info', 'REST: fetching order lines by line IDs from sale headers', { lineIdCount: allLineIds.length });
    }

    const lineSourceIds = useLineIds ? allLineIds : allOrderIds;
    const idChunks = [];
    for (let i = 0; i < lineSourceIds.length; i += LINE_FETCH_CHUNK) {
      idChunks.push(lineSourceIds.slice(i, i + LINE_FETCH_CHUNK));
    }

    // Build internal-ID map once for all orders (used by both strategies)
    const fullInternalIdMap = db.getSaleInternalIdMap(allOrderIds);

    // Fetch lines for all chunks with bounded concurrency, then do a single
    // bulk internal-ID map lookup per chunk (no N+1 queries).
    const fetchBatches = chunkArray(idChunks, LINE_FETCH_CONCURRENCY);
    for (const group of fetchBatches) {
      // Wrap each chunk in a try/catch so one failure doesn't abort the entire
      // line-fetch phase.  Failed chunks are logged and counted.
      const chunkResults = await Promise.all(
        group.map(idChunk => {
          const promise = useLineIds
            ? odoo.getLinesByIds(idChunk)
            : odoo.getSaleOrderLines(idChunk);
          return promise.catch(err => {
            lineChunkErrs++;
            const label = useLineIds ? 'lines' : 'orders';
            jobLog(jobId, 'warn', `Line fetch chunk failed (${idChunk.length} ${label}): ${err.message}`);
            return [];   // return empty so remaining chunks still process
          });
        })
      );

      for (let g = 0; g < group.length; g++) {
        const rawLines = chunkResults[g];

        if (rawLines.length === 0) { lineChunksDone++; continue; }

        const lineRows = rawLines.map((l, idx) => {
          const orderId = Array.isArray(l.order_id) ? l.order_id[0] : l.order_id;
          // tax_name: first tax name from tax_id array (Odoo returns [id, name] tuples or IDs only)
          const firstTax   = Array.isArray(l.tax_id) && l.tax_id.length > 0 ? l.tax_id[0] : null;
          const taxName    = Array.isArray(firstTax) ? firstTax[1] : null;
          return {
            sale_id        : fullInternalIdMap.get(orderId) || null,
            odoo_line_id   : l.id,
            product_id     : Array.isArray(l.product_id) ? l.product_id[0] : null,
            product_name   : Array.isArray(l.product_id) ? l.product_id[1] : (l.name || ''),
            item_number    : l.default_code || null,   // Odoo product.default_code = SKU; maps to middleware item_number
            tax_name       : taxName,
            line_number    : l.sequence != null ? l.sequence : idx + 1,
            qty_ordered    : Number(l.product_uom_qty) || 0,
            qty_delivered  : Number(l.qty_delivered)   || 0,
            price_unit     : Number(l.price_unit)       || 0,
            price_subtotal : Number(l.price_subtotal)   || 0,
            total_discount : Number(l.discount)         || 0,
            tax_ids        : JSON.stringify(l.tax_id    || []),
          };
        }).filter(l => l.sale_id !== null);

        db.upsertSaleLines(lineRows);
        totalLines += lineRows.length;
        lineChunksDone++;
      }

      // Update progress so the UI shows incremental line-fetch progress
      jobLog(jobId, 'debug', `Line fetch progress: ${lineChunksDone}/${idChunks.length} chunks, ${totalLines} lines stored`);
      await new Promise(resolve => setImmediate(resolve));
    }

    jobLog(jobId, 'info', `Stored ${totalLines} sale lines in local DB` +
      (lineChunkErrs > 0 ? ` (${lineChunkErrs} chunks failed – partial data)` : ''));

    // ── Enrich line items with product reference data (REST only) ──────────
    // Java middleware: VendhqItemMeta provides SKU (default_code) and UOM for
    // each product.  The PosOrderLine endpoint typically returns product_id as
    // [id, name] but may not include default_code.  Fetch the product catalogue
    // from /api/vItems/Productlist and use it to fill in missing item_number
    // (SKU) and build a product-to-UOM mapping for the uomCodeMap.
    //
    // Also fetches UOM data from /api/vuom_id/UOM/ to resolve UOM names to the
    // short UOM codes that Oracle Fusion expects.
    if (odoo instanceof OdooRestClient && totalLines > 0) {
      try {
        jobLog(jobId, 'info', 'Fetching product catalogue and UOM data for line enrichment…');

        // Fetch product list and UOM list in parallel
        const [products, uomList] = await Promise.all([
          odoo.getProducts().catch(err => {
            jobLog(jobId, 'warn', `Product catalogue fetch failed: ${err.message}`);
            return [];
          }),
          odoo.getUomList().catch(err => {
            jobLog(jobId, 'warn', `UOM list fetch failed: ${err.message}`);
            return [];
          }),
        ]);

        if (products.length > 0 || uomList.length > 0) {
          // Build product ID → {default_code, uom_id, uom_name} lookup map
          // Products may have: id, default_code (SKU), name, uom_id (as [id, name] or plain ID)
          const productMap = new Map();
          for (const p of products) {
            const pid = p.id ?? p.product_id;
            if (pid == null) continue;
            const uomId   = Array.isArray(p.uom_id)   ? p.uom_id[0] : (p.uom_id ?? null);
            const uomName = Array.isArray(p.uom_id)   ? p.uom_id[1] : (p.uom_name ?? p.uom ?? null);
            productMap.set(Number(pid), {
              default_code: p.default_code ?? p.barcode ?? p.sku ?? null,
              uom_id      : uomId,
              uom_name    : uomName,
            });
          }

          // Build UOM ID → code and UOM name → code lookup maps
          // UOM records may have: id, name, uom_type, category_id
          const uomIdToCode   = new Map();
          const uomNameToCode = new Map();
          for (const u of uomList) {
            const uid  = u.id ?? u.uom_id;
            const code = u.name ?? u.uom_code ?? u.code ?? null;
            if (uid != null && code) uomIdToCode.set(Number(uid), code);
            if (code) uomNameToCode.set(code, code);        // name IS the code for Odoo UOMs
            if (u.uom_code && u.name) uomNameToCode.set(u.name, u.uom_code);
          }

          jobLog(jobId, 'info', 'Reference data loaded', {
            products: productMap.size,
            uomMappings: uomIdToCode.size,
          });

          // Enrich stored line items that have missing item_number
          // and build per-store UOM code maps
          const storeUomMaps   = new Map(); // store_id → { itemNumber: uomCode }
          const storeIdsToSave = new Set();
          let enriched = 0;

          // Retrieve all stored lines for the fetched sales and check for missing item_number
          for (const odooId of allOrderIds) {
            const internalId = fullInternalIdMap.get(odooId);
            if (!internalId) continue;

            const saleWithLines = db.getSaleWithLines(internalId);
            if (!saleWithLines || !saleWithLines.lines) continue;

            const storeId = saleWithLines.store_id;

            for (const line of saleWithLines.lines) {
              const prodId = line.product_id;
              const prodInfo = prodId != null ? productMap.get(Number(prodId)) : null;

              // Enrich item_number from product catalogue if missing
              if (!line.item_number && prodInfo && prodInfo.default_code) {
                db.updateSaleLineItemNumber(line.odoo_line_id, prodInfo.default_code);
                enriched++;
              }

              // Build UOM code map for the store
              const itemNum = line.item_number || (prodInfo && prodInfo.default_code) || null;
              if (itemNum && prodInfo) {
                let uomCode = null;
                // Try UOM ID lookup first, then name lookup
                if (prodInfo.uom_id != null) {
                  uomCode = uomIdToCode.get(Number(prodInfo.uom_id));
                }
                if (!uomCode && prodInfo.uom_name) {
                  uomCode = uomNameToCode.get(prodInfo.uom_name) || prodInfo.uom_name;
                }
                if (uomCode && storeId) {
                  if (!storeUomMaps.has(storeId)) storeUomMaps.set(storeId, {});
                  storeUomMaps.get(storeId)[itemNum] = uomCode;
                  storeIdsToSave.add(storeId);
                }
              }
            }
          }

          if (enriched > 0) {
            jobLog(jobId, 'info', `Enriched ${enriched} line items with item_number from product catalogue`);
          }

          // Auto-save UOM code maps to store_oracle_metadata
          for (const sid of storeIdsToSave) {
            const existing = db.getStoreOracleMetadata(sid);
            const existingUom = existing && existing.uom_code_map
              ? (typeof existing.uom_code_map === 'string' ? JSON.parse(existing.uom_code_map) : existing.uom_code_map)
              : {};
            // Merge: existing manual entries take precedence over auto-detected
            const merged = { ...storeUomMaps.get(sid), ...existingUom };
            db.upsertStoreOracleMetadata({
              storeId  : sid,
              uomCodeMap: merged,
            });
          }
          if (storeIdsToSave.size > 0) {
            jobLog(jobId, 'info', `Auto-saved UOM code maps for ${storeIdsToSave.size} store(s)`);
          }
        }
      } catch (enrichErr) {
        // Product enrichment is non-fatal – log and continue
        jobLog(jobId, 'warn', `Product/UOM enrichment failed: ${enrichErr.message}. Line items will use existing item_number values.`);
      }
    }

    // ── Fetch + persist payments (3rd endpoint: account.payment / payment_lines) ─
    // Mirrors middleware BackupVendhqPayments table populated from the same fetch.
    //
    // Three strategies depending on client type and available data:
    //   REST + payment_ids from Sale_detail:  query payment_lines by payment IDs
    //   REST (fallback):                      query payment_lines by order IDs
    //   JSONRPC (OdooClient):                 re-read sale.order.invoice_ids → fetch account.payment
    jobLog(jobId, 'info', 'Fetching sale payments from Odoo (account.payment)…');
    let totalPayments = 0;
    let totalPaymentsLinked = 0;
    try {
      let paymentRows = [];
      const now = new Date().toISOString();

      // Build the odooId → internalId mapping once; reused for both direct
      // linking (REST path) and the post-process fallback.
      // (Re-use fullInternalIdMap if already built for line fetch, else build now)
      const internalIdMap = fullInternalIdMap || db.getSaleInternalIdMap(allOrderIds);

      if (odoo instanceof OdooRestClient) {
        // ── REST path: prefer payment IDs from Sale_detail headers ─────────
        // The Sale_detail response includes payment_ids: [id1, id2, …] for
        // each order.  Fetch by these IDs directly for accurate results.
        // Falls back to pos_order_id filtering if no payment IDs are available.
        const usePaymentIds = allPaymentIds.length > 0;
        const PAY_CHUNK = 200;
        const rawPayments = [];
        let payChunkErrs = 0;

        if (usePaymentIds) {
          jobLog(jobId, 'info', 'REST: querying payment_lines by payment IDs from sale headers', { paymentIdCount: allPaymentIds.length });
          for (let i = 0; i < allPaymentIds.length; i += PAY_CHUNK) {
            const chunk = allPaymentIds.slice(i, i + PAY_CHUNK);
            try {
              const chunkPayments = await odoo.getPaymentsByPaymentIds(chunk);
              rawPayments.push(...chunkPayments);
            } catch (chunkErr) {
              payChunkErrs++;
              jobLog(jobId, 'warn', `Payment fetch chunk failed (${chunk.length} payment IDs): ${chunkErr.message}`);
            }
          }
        } else {
          jobLog(jobId, 'info', 'REST: querying payment_lines by order IDs (no payment_ids in headers)', { orderCount: allOrderIds.length });
          for (let i = 0; i < allOrderIds.length; i += PAY_CHUNK) {
            const chunk = allOrderIds.slice(i, i + PAY_CHUNK);
            try {
              const chunkPayments = await odoo.getPaymentsByOrderIds(chunk);
              rawPayments.push(...chunkPayments);
            } catch (chunkErr) {
              payChunkErrs++;
              jobLog(jobId, 'warn', `Payment fetch chunk failed (${chunk.length} orders): ${chunkErr.message}`);
            }
          }
        }
        if (payChunkErrs > 0) {
          jobLog(jobId, 'warn', `${payChunkErrs} payment chunk(s) failed – partial payment data`);
        }

        paymentRows = rawPayments.map(p => {
          const journalLabel = Array.isArray(p.journal_id) ? p.journal_id[1] : (p.journal_id || 'Unknown');
          // Link payment to sale: prefer the paymentId→orderId map (built from
          // sale headers), then fall back to pos_order_id from the payment row.
          const orderIdFromHeader = paymentIdToOrderId.get(p.id) || null;
          const posOrderId = orderIdFromHeader || p.pos_order_id || null;
          const saleId     = posOrderId != null ? (internalIdMap.get(posOrderId) ?? null) : null;
          // payment_date: prefer the payment's own date; fall back to the linked
          // sale's date_order (REST payment_lines may not include a date field).
          const paymentDate = extractDate(p.date)
            || (posOrderId != null ? orderDateMap.get(posOrderId) : null)
            || null;
          // outlet_name: prefer partner_id name, then company_name from normalisation
          const outletName = (Array.isArray(p.partner_id) ? p.partner_id[1] : null)
            || p.company_name || null;
          return {
            sale_id        : saleId,
            invoice_number : p.name || '',
            odoo_payment_id: p.id,
            payment_type   : journalLabel,
            amount         : Number(p.amount)   || 0,
            currency       : Array.isArray(p.currency_id) ? p.currency_id[1] : DEFAULT_CURRENCY,
            payment_date   : paymentDate,
            outlet_name    : outletName,
            register_name  : p.session_name || null,
            region         : country || null,
            fetched_at     : now,
          };
        });
      } else {
        // ── JSONRPC path: invoice-IDs lookup ──────────────────────────────────
        const allInvoiceIds = [];
        const invoiceToSaleMap = new Map(); // invoiceId → { saleId, invoiceNumber, storeName, teamName, currency, country }

        // Re-read sale headers to collect invoice_ids
        for (let i = 0; i < allOrderIds.length; i += 500) {
          const idChunk  = allOrderIds.slice(i, i + 500);
          const orderPage = await odoo.execute('sale.order', 'read', [idChunk], {
            fields: ['id', 'name', 'invoice_ids', 'warehouse_id', 'team_id', 'currency_id'],
          });
          for (const o of orderPage) {
            const invIds = Array.isArray(o.invoice_ids) ? o.invoice_ids : [];
            const storeName  = Array.isArray(o.warehouse_id) ? o.warehouse_id[1] : (o.warehouse_id || null);
            const teamName   = Array.isArray(o.team_id) ? o.team_id[1] : (o.team_id || null);
            const currency   = Array.isArray(o.currency_id) ? o.currency_id[1] : DEFAULT_CURRENCY;
            for (const invId of invIds) {
              allInvoiceIds.push(invId);
              invoiceToSaleMap.set(invId, {
                saleId       : db.getSaleInternalId(o.id),
                invoiceNumber: o.name,
                storeName,
                teamName,
                currency,
                countryCode  : country || null,
              });
            }
          }
          await new Promise(resolve => setImmediate(resolve));
        }

        if (allInvoiceIds.length > 0) {
          const rawPayments = await odoo.getOrderPayments(allInvoiceIds);
          paymentRows = rawPayments.map(p => {
            const moveId = Array.isArray(p.move_id) ? p.move_id[0] : p.move_id;
            const meta   = invoiceToSaleMap.get(moveId) || {};
            return {
              sale_id        : meta.saleId        || null,
              invoice_number : meta.invoiceNumber  || '',
              odoo_payment_id: p.id,
              payment_type   : Array.isArray(p.journal_id) ? p.journal_id[1] : (p.journal_id || 'Unknown'),
              amount         : Number(p.amount)    || 0,
              currency       : Array.isArray(p.currency_id) ? p.currency_id[1] : (meta.currency || DEFAULT_CURRENCY),
              payment_date   : extractDate(p.date) || null,
              outlet_name    : meta.storeName      || null,
              register_name  : meta.teamName       || null,
              region         : meta.countryCode    || null,
              fetched_at     : now,
            };
          });
        } else {
          jobLog(jobId, 'warn', 'No invoices linked to fetched orders – payment fetch skipped. Payments will fall back to amount_total during push.');
        }
      }

      // ── Post-process: link any remaining unlinked payments to sales ────
      // JSONRPC payments are already linked via invoiceToSaleMap above.
      // REST payments are now linked directly via pos_order_id → internal ID
      // mapping.  This fallback catches any stragglers from either path by
      // matching invoice_number → sale.name.
      if (paymentRows.length > 0) {
        let linked = 0;
        const unlinked = paymentRows.filter(p => p.sale_id === null);
        if (unlinked.length > 0) {
          // Build name → internalId map for fallback linking using the
          // already-populated internalIdMap (avoids redundant DB queries).
          const nameMap     = new Map();  // sale.name   → internalId
          const idToNameMap = new Map();  // internalId  → sale.name
          for (const [, internalId] of internalIdMap) {
            const sale = db.getSaleWithLines(internalId);
            if (sale) {
              nameMap.set(sale.name, internalId);
              idToNameMap.set(internalId, sale.name);
            }
          }
          for (const p of unlinked) {
            let internalId = null;

            // Fallback: match invoice_number to sale.name
            if (p.invoice_number) {
              internalId = nameMap.get(p.invoice_number) ?? null;
            }

            if (internalId != null) {
              p.sale_id = internalId;
              const saleName = idToNameMap.get(internalId);
              if (saleName) p.invoice_number = saleName;
              linked++;
            }
          }
          if (linked > 0) {
            jobLog(jobId, 'info', `Linked ${linked}/${unlinked.length} payments to sales by invoice_number`);
          }
          if (unlinked.length - linked > 0) {
            jobLog(jobId, 'warn', `${unlinked.length - linked} payments could not be linked to any fetched sale (stored with sale_id=null)`);
          }
        }

        db.upsertSalePayments(paymentRows);
        totalPayments = paymentRows.length;
        totalPaymentsLinked = paymentRows.filter(p => p.sale_id !== null).length;
        jobLog(jobId, 'info', `Stored ${totalPayments} payment records in local DB (${totalPaymentsLinked} linked to sales)`);
      } else {
        jobLog(jobId, 'warn', 'No payments found for fetched sale orders – receipts will fall back to amount_total during push');
      }
    } catch (payErr) {
      // Payment fetch failure is non-fatal – log and continue, but make it visible
      jobLog(jobId, 'warn', `Payment fetch failed: ${payErr.message}. Orders will push without payment breakdown (amount_total fallback).`);
    }

    db.updateJob(jobId, {
      status      : 'DONE',
      processed   : totalFetched,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', 'Fetch job completed successfully', {
      totalOrders  : totalFetched,
      totalLines,
      lineErrors   : lineChunkErrs,
      totalPayments,
      paymentsLinked: totalPaymentsLinked,
    });

  } catch (err) {
    logger.error('Fetch job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Fetch job failed: ${err.message}`);
  }
}

// ── 2. Push to Oracle ─────────────────────────────────────────────────────────

/**
 * Start a background push-to-Oracle job.
 *
 * Push modes:
 *   BY_DATE         – all stores, date range
 *   BY_STORE_DATE   – specific store + date range
 *   ALL_STORES_DATE – all stores (same as BY_DATE)
 *
 * @param {object} options
 * @param {string}  options.mode              'BY_DATE' | 'BY_STORE_DATE' | 'ALL_STORES_DATE'
 * @param {string}  options.dateFrom          YYYY-MM-DD
 * @param {string}  options.dateTo            YYYY-MM-DD
 * @param {number}  [options.storeId]         required for BY_STORE_DATE
 * @param {string}  [options.storeName]
 * @param {object}  [options.metadata]        Oracle Fusion metadata (businessUnit, billToName…)
 *                                            Also carries calculation settings:
 *                                              defaultPaymentType  – payment type name when Odoo has no
 *                                                                    explicit payment breakdown (default 'Cash')
 *                                              receiptMethodMeta   – map of paymentType → {receiptMethodId,
 *                                                                    bankAccountId, bankChargeRate, methodTax}
 *                                              journalMeta         – journal entry config (required for
 *                                                                    non-NORMAL customers)
 *                                              customerType        – 'NORMAL' | 'HUNGERSTATION' | etc.
 *                                              region              – 'AE' | 'KW' | 'OM' | …
 *                                              tzOffset            – decimal timezone offset (e.g. 4 for UAE)
 *                                              rateIsCorporate     – '1' for Corporate rate, else 'User'
 *                                              taxName             – default tax classification code
 *                                              uomCodeMap          – { [itemNumber]: 'Ea' } overrides
 * @param {object}  [options.outlet]          Oracle outlet config
 * @param {boolean} [options.skipAlreadyPushed=true]  Skip orders that already have oracle_txn_id set.
 *                                            Set to false to force re-push of all orders in range.
 * @returns {string} jobId
 */
function startPushJob(options) {
  const { mode = 'BY_DATE', dateFrom, dateTo, storeId, storeName } = options;
  const jobId = randomUUID();

  db.createJob({ jobId, jobType: 'PUSH', mode, dateFrom, dateTo, storeId, storeName });
  logger.info('Push job created', { jobId, mode, dateFrom, dateTo, storeId });

  setImmediate(() => _runPushJob(jobId, options));

  return jobId;
}

async function _runPushJob(jobId, options) {
  const { mode, dateFrom, dateTo, storeId, country, metadata, outlet } = options;
  // Default: skip orders already successfully pushed (idempotent re-runs).
  const skipAlreadyPushed = options.skipAlreadyPushed !== false;

  db.updateJob(jobId, { status: 'RUNNING', started_at: new Date().toISOString() });
  jobLog(jobId, 'info', 'Push job started', { mode, dateFrom, dateTo, storeId, skipAlreadyPushed });

  try {
    const filters = { dateFrom, dateTo };
    if (mode === 'BY_STORE_DATE') filters.storeId = storeId;
    if (skipAlreadyPushed) filters.unpushedOnly = true;

    // Resolve total first so progress can be tracked accurately
    const { total } = db.querySales({ ...filters, limit: 1, offset: 0 });
    jobLog(jobId, 'info', `Found ${total} orders matching filters${skipAlreadyPushed ? ' (unpushed only)' : ''}`, { filters });
    db.updateJob(jobId, { total });

    if (total === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders to push – job complete');
      return;
    }

    // ── Pre-load store Oracle metadata for auto-mapping ─────────────────────
    // Cache keyed by store_id so we don't re-read the DB on every sale.
    const resolveStoreMetadata = createStoreMetaResolver();

    const oracle    = buildOracleService(country);
    let processed   = 0;
    let failed      = 0;
    let dbOffset    = 0;
    let authFailed  = false;   // set when Oracle returns 401/403

    // ── Paginated push – PUSH_BATCH_SIZE rows at a time ───────────────────────
    // Memory stays flat at O(PUSH_BATCH_SIZE) regardless of total order count.
    while (dbOffset < total && !authFailed) {
      const { rows: batch } = db.querySales({
        ...filters,
        limit  : PUSH_BATCH_SIZE,
        offset : dbOffset,
      });
      if (batch.length === 0) break;

      jobLog(jobId, 'info', `Processing batch of ${batch.length} orders`, {
        offset: dbOffset, total,
      });

      // ── Limited-concurrency fan-out within the batch ──────────────────────
      const chunks = chunkArray(batch, MAX_CONCURRENT);
      for (const chunk of chunks) {
        if (authFailed) break;
        await Promise.all(chunk.map(async sale => {
          if (authFailed) return;   // another sale in the chunk already detected auth failure
          try {
            const saleWithLines = db.getSaleWithLines(sale.id);

            // ── Auto-resolve per-store Oracle metadata ────────────────────────
            // If the caller provided explicit metadata from the UI, use it.
            // Otherwise, look up the stored per-store configuration (mirrors
            // Java's FusionSalesMetadata query by subInventory/store).
            // As a lowest-priority baseline, fall back to the fusion_sales_metadata
            // reference table (seeded from FUSION_SALES_METADATA CSV exports) keyed
            // by outlet/subinventory code + customer_type.
            const storeMeta  = resolveStoreMetadata(sale.store_id);
            const subinventory = (storeMeta && storeMeta.outlet_name)
              || sale.store_name || '';
            // Configured customer type from UI override or per-store config.
            const configuredCustomerType = (metadata && metadata.customerType)
              || (storeMeta && storeMeta.customer_type)
              || 'NORMAL';
            // For service-provider payments (TABBY, TAMARA, MRSOOL, HUNGERSTATION, …)
            // the payment type IS the customer_type key in fusion_sales_metadata.
            // Try the primary payment type first; if no matching row exists (e.g. for
            // 'Mada', 'Cash', 'Visa') fall back to the configured customer type.
            const primaryPaymentType = (saleWithLines.payments && saleWithLines.payments.length > 0)
              ? (saleWithLines.payments[0].payment_type || '').toUpperCase()
              : '';
            const fusionMeta = subinventory
              ? (primaryPaymentType && db.getFusionSalesMetadataByKey(subinventory, primaryPaymentType))
                  || db.getFusionSalesMetadataByKey(subinventory, configuredCustomerType)
              : null;
            const effectiveMeta   = mergeStoreMetadata(storeMeta, metadata, fusionMeta);
            const effectiveOutlet = mergeStoreOutlet(storeMeta, outlet);

            const salePayload   = buildOracleSalePayload(saleWithLines, effectiveMeta, effectiveOutlet);

            jobLog(jobId, 'debug', `Pushing sale ${sale.name} (odoo_id=${sale.odoo_id})`, {
              storeId: sale.store_id, storeName: sale.store_name,
              lineCount: salePayload.sale.lineItems.length,
              paymentCount: salePayload.sale.payments.length,
              paymentTypes: salePayload.sale.payments.map(p => p.paymentType).join(', '),
            });

            const result = await oracle.pushSale(
              salePayload.sale,
              salePayload.metadata,
              salePayload.outlet
            );

            if (result.success) {
              processed++;
              // Record the Oracle transaction number so this order is skipped
              // on future push jobs (idempotent re-runs).
              db.updateSalePushStatus(sale.id, result.transactionNumber, jobId);
              jobLog(jobId, 'info', `✓ Pushed sale ${sale.name}`, {
                transactionNumber: result.transactionNumber,
                steps: result.steps.length,
              });
            } else {
              failed++;
              const errMsg = (result.errors || []).join('; ');
              jobLog(jobId, 'warn', `✗ Push failed for sale ${sale.name}`, {
                errors: result.errors,
              });
              // Record the failure as a durable event for later review / retry
              db.insertFailedRecord({
                jobId,
                saleName    : sale.name,
                odooId      : sale.odoo_id,
                errorMessage: errMsg,
                errorDetail : JSON.stringify(result.errors),
              });

              // If Oracle rejected due to auth, abort remaining sales
              if (result.authFailed) {
                authFailed = true;
                jobLog(jobId, 'error',
                  'Oracle authentication failed – aborting remaining orders. ' +
                  'Check credentials on the Configuration page.');
              }
            }
          } catch (err) {
            failed++;
            const detail = err.response
              ? `HTTP ${err.response.status}: ${JSON.stringify(err.response.data)}`
              : err.stack || err.message;
            jobLog(jobId, 'error', `✗ Exception pushing sale ${sale.name}: ${err.message}`);
            // Failure is durable – the job itself continues to the next record
            db.insertFailedRecord({
              jobId,
              saleName    : sale.name,
              odooId      : sale.odoo_id,
              errorMessage: err.message,
              errorDetail : detail,
            });
          }
        }));
        // Update progress once per concurrent chunk, not once per order,
        // to avoid redundant SQLite writes under high concurrency.
        db.updateJob(jobId, { processed, failed });
      }

      dbOffset += batch.length;
      // Yield to the event loop between batches
      await new Promise(resolve => setImmediate(resolve));
    }

    const finalStatus = (processed === 0 && failed > 0) || authFailed ? 'FAILED' : 'DONE';
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Push job finished – ${processed} pushed, ${failed} failed`);
    if (authFailed) {
      jobLog(jobId, 'error', 'Job aborted due to Oracle authentication failure.');
    } else if (failed > 0) {
      jobLog(jobId, 'warn', `${failed} failed records saved for retry. Use GET /api/odoo/failed-records?jobId=${jobId} to view them.`);
    }

  } catch (err) {
    logger.error('Push job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Push job failed: ${err.message}`);
  }
}

// ── 3. Retry failed records ───────────────────────────────────────────────────

/**
 * Start a background job that re-attempts all PENDING failed_records
 * belonging to a previous push job.
 *
 * @param {object} options
 * @param {string}  options.sourceJobId  – original push job whose failures to retry
 * @param {object}  [options.metadata]   – Oracle Fusion metadata override
 * @param {object}  [options.outlet]     – Oracle outlet config override
 * @returns {string} jobId of the retry job
 */
function startRetryJob(options) {
  const { sourceJobId } = options;
  const jobId = randomUUID();

  db.createJob({
    jobId,
    jobType   : 'RETRY',
    mode      : 'RETRY',
    dateFrom  : null,
    dateTo    : null,
    storeId   : null,
    storeName : null,
  });
  logger.info('Retry job created', { jobId, sourceJobId });

  setImmediate(() => _runRetryJob(jobId, options));

  return jobId;
}

async function _runRetryJob(jobId, { sourceJobId, metadata, outlet }) {
  db.updateJob(jobId, { status: 'RUNNING', started_at: new Date().toISOString() });
  jobLog(jobId, 'info', 'Retry job started', { sourceJobId });

  try {
    let frOffset  = 0;
    let processed = 0;
    let failed    = 0;
    let totalPending = 0;

    // Count first so we can report total accurately
    const { total: initialTotal } = db.listFailedRecords({
      jobId : sourceJobId,
      status: 'PENDING',
      limit : 1,
    });
    totalPending = initialTotal;
    jobLog(jobId, 'info', `Found ${totalPending} PENDING failed records to retry`);
    db.updateJob(jobId, { total: totalPending });

    if (totalPending === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No pending failures – retry job complete');
      return;
    }

    // ── Pre-load store Oracle metadata cache (same as _runPushJob) ─────────
    const resolveStoreMetadata = createStoreMetaResolver();

    const oracle = buildOracleService();
    let authFailed = false;

    // Paginate to avoid loading all failures into memory at once
    while (!authFailed) {
      const { rows: pending } = db.listFailedRecords({
        jobId : sourceJobId,
        status: 'PENDING',
        limit : PUSH_BATCH_SIZE,
        offset: frOffset,
      });
      if (pending.length === 0) break;

      // Process pending records with the same bounded concurrency as the main push job.
      const chunks = chunkArray(pending, MAX_CONCURRENT);
      for (const chunk of chunks) {
        if (authFailed) break;
        await Promise.all(chunk.map(async record => {
          if (authFailed) return;
          try {
            const internalId = db.getSaleInternalId(record.odoo_id);
            if (!internalId) {
              db.updateFailedRecord(record.id, 'SKIPPED');
              jobLog(jobId, 'warn', `Skipping ${record.sale_name} – not found in local DB`);
              failed++;
              return;
            }

            const saleWithLines = db.getSaleWithLines(internalId);

            // ── Auto-resolve per-store metadata (same as _runPushJob) ─────────
            const storeMeta  = resolveStoreMetadata(saleWithLines.store_id);
            const subinventory = (storeMeta && storeMeta.outlet_name)
              || saleWithLines.store_name || '';
            const configuredCustomerType = (metadata && metadata.customerType)
              || (storeMeta && storeMeta.customer_type)
              || 'NORMAL';
            const primaryPaymentType = (saleWithLines.payments && saleWithLines.payments.length > 0)
              ? (saleWithLines.payments[0].payment_type || '').toUpperCase()
              : '';
            const fusionMeta = subinventory
              ? (primaryPaymentType && db.getFusionSalesMetadataByKey(subinventory, primaryPaymentType))
                  || db.getFusionSalesMetadataByKey(subinventory, configuredCustomerType)
              : null;
            const effectiveMeta   = mergeStoreMetadata(storeMeta, metadata, fusionMeta);
            const effectiveOutlet = mergeStoreOutlet(storeMeta, outlet);

            const salePayload   = buildOracleSalePayload(saleWithLines, effectiveMeta, effectiveOutlet);

            const result = await oracle.pushSale(
              salePayload.sale,
              salePayload.metadata,
              salePayload.outlet
            );

            if (result.success) {
              db.updateFailedRecord(record.id, 'RESOLVED');
              // Also stamp the oracle_txn_id on the sale so future push jobs skip it.
              db.updateSalePushStatus(internalId, result.transactionNumber, jobId);
              processed++;
              jobLog(jobId, 'info', `✓ Retry succeeded for ${record.sale_name}`, {
                transactionNumber: result.transactionNumber,
              });
            } else {
              db.updateFailedRecord(record.id, 'PENDING');
              failed++;
              jobLog(jobId, 'warn', `✗ Retry failed for ${record.sale_name}`, {
                errors: result.errors,
              });

              if (result.authFailed) {
                authFailed = true;
                jobLog(jobId, 'error',
                  'Oracle authentication failed – aborting remaining retries. ' +
                  'Check credentials on the Configuration page.');
              }
            }
          } catch (err) {
            db.updateFailedRecord(record.id, 'PENDING');
            failed++;
            jobLog(jobId, 'error', `✗ Exception retrying ${record.sale_name}: ${err.message}`);
          }
        }));
        // Update progress once per concurrent chunk
        db.updateJob(jobId, { processed, failed });
        await new Promise(resolve => setImmediate(resolve));
      }

      frOffset += pending.length;
      await new Promise(resolve => setImmediate(resolve));
    }

    const finalStatus = (processed === 0 && failed > 0) || authFailed ? 'FAILED' : 'DONE';
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Retry job finished – ${processed} resolved, ${failed} still failing`);
    if (authFailed) {
      jobLog(jobId, 'error', 'Retry job aborted due to Oracle authentication failure.');
    }

  } catch (err) {
    logger.error('Retry job failed', { jobId, err: err.message, stack: err.stack });
    db.updateJob(jobId, { status: 'FAILED', finished_at: new Date().toISOString() });
    jobLog(jobId, 'error', `Retry job failed: ${err.message}`);
  }
}

/**
 * Map an Odoo sale (from SQLite) to the format expected by pushOracle.js.
 *
 * Every calculation in calculations.js (timezone adjustment, invoice lines,
 * receipt amounts, bank charges, misc charges, journal entries) is driven by
 * the sale payload built here.  The function applies the same business rules
 * as the original Java VendHQ middleware so Oracle Fusion receives identical
 * derived values regardless of whether the source is VendHQ or Odoo.
 *
 * Calculation settings are passed in via jobMeta (the "metadata" field of the
 * push job body), in addition to the standard Oracle invoice fields:
 *
 *   jobMeta.defaultPaymentType   {string}  Payment type name when Odoo has no
 *                                          payment breakdown (default: 'Cash').
 *                                          amount_total is used as the payment
 *                                          amount so that all receipt / bank-
 *                                          charge calculations still execute.
 *   jobMeta.payments             {Array}   Explicit [{paymentType, amount}] list.
 *                                          Overrides defaultPaymentType when set.
 *   jobMeta.receiptMethodMeta    {object}  { [paymentType]: { receiptMethodId,
 *                                            bankAccountId, bankChargeRate,
 *                                            methodTax } }
 *   jobMeta.journalMeta          {object}  Journal-entry config (ledgerId,
 *                                          chartOfAccountsId, jeSource, …).
 *                                          Required for non-NORMAL customers.
 *   jobMeta.customerType         {string}  'NORMAL' | 'HUNGERSTATION' | …
 *   jobMeta.region               {string}  'AE' | 'KW' | 'OM' | …
 *   jobMeta.tzOffset             {number}  Decimal timezone offset (e.g. 4 for UAE)
 *   jobMeta.rateIsCorporate      {string}  '1' → Corporate rate, else User
 *   jobMeta.taxName              {string}  Default TaxClassificationCode for lines
 *   jobMeta.uomCodeMap           {object}  { [itemNumber]: 'Ea' } UOM overrides
 */

/**
 * Merge stored per-store Oracle metadata (from store_oracle_metadata table) with
 * optional UI-provided metadata and an optional fusion-reference-data fallback.
 *
 * Priority (highest → lowest):
 *   1. uiMeta    – values provided by the caller (push form / API body)
 *   2. storeMeta – per-store row from store_oracle_metadata table
 *   3. fusionMeta– row from fusion_sales_metadata (keyed by subinventory + customerType)
 *
 * This mirrors the Java middleware's FusionSalesMetadata lookup by subInventory/store.
 *
 * @param {object|null} storeMeta  – DB row from store_oracle_metadata (may be null)
 * @param {object|null} uiMeta    – metadata provided by the caller (push form / API body)
 * @param {object|null} [fusionMeta] – row from fusion_sales_metadata (lowest priority)
 * @returns {object|null} merged metadata, or null if no source exists
 */
function mergeStoreMetadata(storeMeta, uiMeta, fusionMeta) {
  if (!storeMeta && !uiMeta && !fusionMeta) return null;

  // Build lowest-priority baseline from fusion_sales_metadata (CSV reference data)
  const fromFusion = fusionMeta ? {
    billToName          : fusionMeta.bill_to_name           || undefined,
    billToAccount       : fusionMeta.bill_to_account        || undefined,
    siteNumber          : fusionMeta.site_number            || undefined,
    businessUnit        : fusionMeta.business_unit          || undefined,
    txnSource           : fusionMeta.txn_source             || undefined,
    txnType             : fusionMeta.txn_type               || undefined,
    rateIsCorporate     : fusionMeta.rate_is_corporate      || undefined,
    recActivityNameBank : fusionMeta.rec_activity_name_bank || undefined,
    recActivityNameCash : fusionMeta.rec_activity_name_cash || undefined,
    region              : fusionMeta.region                 || undefined,
    customerType        : fusionMeta.customer_type          || undefined,
    costCenterCode      : fusionMeta.cost_center_code       || undefined,
  } : {};
  Object.keys(fromFusion).forEach(k => { if (fromFusion[k] === undefined) delete fromFusion[k]; });

  if (!storeMeta) {
    // No per-store config – merge UI on top of fusion baseline
    if (!uiMeta) return Object.keys(fromFusion).length ? fromFusion : null;
    return { ...fromFusion, ...uiMeta };
  }

  // Convert DB column names to the camelCase keys expected by buildOracleSalePayload
  const fromDb = {
    billToName          : storeMeta.bill_to_name         || undefined,
    billToAccount       : storeMeta.bill_to_account      || undefined,
    siteNumber          : storeMeta.site_number          || undefined,
    businessUnit        : storeMeta.business_unit        || undefined,
    txnSource           : storeMeta.txn_source           || undefined,
    txnType             : storeMeta.txn_type             || undefined,
    paymentTermsName    : storeMeta.payment_terms_name   || undefined,
    rateIsCorporate     : storeMeta.rate_is_corporate    || undefined,
    orgId               : storeMeta.org_id               || undefined,
    costCenterCode      : storeMeta.cost_center_code     || undefined,
    customerType        : storeMeta.customer_type        || undefined,
    region              : storeMeta.region               || undefined,
    tzOffset            : storeMeta.tz_offset != null    ? storeMeta.tz_offset : undefined,
    defaultPaymentType  : storeMeta.default_payment_type || undefined,
    taxName             : storeMeta.tax_name             || undefined,
    recActivityNameBank : storeMeta.rec_activity_name_bank || undefined,
    recActivityNameCash : storeMeta.rec_activity_name_cash || undefined,
    receiptMethodMeta   : storeMeta.receipt_method_meta
                            ? (typeof storeMeta.receipt_method_meta === 'string'
                                 ? JSON.parse(storeMeta.receipt_method_meta)
                                 : storeMeta.receipt_method_meta)
                            : undefined,
    journalMeta         : storeMeta.journal_meta
                            ? (typeof storeMeta.journal_meta === 'string'
                                 ? JSON.parse(storeMeta.journal_meta)
                                 : storeMeta.journal_meta)
                            : undefined,
    uomCodeMap          : storeMeta.uom_code_map
                            ? (typeof storeMeta.uom_code_map === 'string'
                                 ? JSON.parse(storeMeta.uom_code_map)
                                 : storeMeta.uom_code_map)
                            : undefined,
  };

  // Remove undefined keys so they don't overwrite lower-priority values
  Object.keys(fromDb).forEach(k => { if (fromDb[k] === undefined) delete fromDb[k]; });

  if (!uiMeta) return { ...fromFusion, ...fromDb };

  // UI-provided values win; DB-stored values fill the gaps; fusion provides the baseline
  return { ...fromFusion, ...fromDb, ...uiMeta };
}

/**
 * Merge stored per-store outlet config with optional UI-provided outlet.
 * @param {object|null} storeMeta – DB row from store_oracle_metadata
 * @param {object|null} uiOutlet  – outlet provided by the caller
 * @returns {object|undefined}
 */
function mergeStoreOutlet(storeMeta, uiOutlet) {
  if (!storeMeta && !uiOutlet) return undefined;
  if (!storeMeta) return uiOutlet;

  const fromDb = {};
  if (storeMeta.currency)          fromDb.currency         = storeMeta.currency;
  if (storeMeta.outlet_name)       fromDb.outletName       = storeMeta.outlet_name;
  if (storeMeta.organization_name) fromDb.organizationName = storeMeta.organization_name;

  if (!uiOutlet) return Object.keys(fromDb).length ? fromDb : undefined;

  return { ...fromDb, ...uiOutlet };
}

function buildOracleSalePayload(sale, jobMeta, jobOutlet) {
  const lines = (sale.lines || []).map((l, idx) => ({
    lineNumber  : l.line_number || (idx + 1),
    itemNumber  : l.item_number || String(l.product_id || `PROD-${l.odoo_line_id}`),
    itemName    : l.product_name || 'Odoo Product',
    // computeSalePreview (calculations.js) reads `quantity`, not `originalQty`.
    // qty_ordered is the confirmed ordered quantity on the Odoo sale.order line.
    quantity    : l.qty_ordered,
    totalPrice  : l.price_subtotal,
    taxName     : l.tax_name || (jobMeta && jobMeta.taxName) || null,
  }));

  // ── Payments ───────────────────────────────────────────────────────────────
  // Odoo sale.order records aggregate all payment methods into amount_total.
  // When the push job provides an explicit payments list (e.g. retrieved from
  // Odoo's account.payment records), use it directly.  Otherwise fall back to
  // a single payment entry using amount_total so that all receipt, bank-charge
  // and miscellaneous-charge calculations (calculateMiscCharges,
  // netReceiptAmount) execute identically to the VendHQ middleware path.
  const explicitPayments = (jobMeta && Array.isArray(jobMeta.payments) && jobMeta.payments.length > 0)
    ? jobMeta.payments
    : null;

  // Use stored payment records from the local DB (fetched via account.payment – 3rd Odoo endpoint)
  // when no explicit override is provided. This mirrors the middleware's BackupVendhqPayments path.
  const storedPayments = Array.isArray(sale.payments) && sale.payments.length > 0
    ? sale.payments.map(p => ({ paymentType: p.payment_type || 'Cash', amount: p.amount || 0 }))
    : null;

  const payments = explicitPayments || storedPayments || [{
    paymentType : (jobMeta && jobMeta.defaultPaymentType) || 'Cash',
    amount      : sale.amount_total || 0,
  }];

  // Warn when falling back to amount_total instead of real payment records
  if (!explicitPayments && !storedPayments) {
    logger.warn('No stored payments for sale %s – using amount_total (%s) as fallback payment', sale.name, sale.amount_total);
  }

  const saleObj = {
    invoiceNumber    : sale.name,
    saleDate         : sale.date_order,
    customerType     : (jobMeta && jobMeta.customerType)     || 'NORMAL',
    region           : (jobMeta && jobMeta.region)           || 'AE',
    tzOffset         : (jobMeta && jobMeta.tzOffset != null)
                         ? Number(jobMeta.tzOffset) : 0,
    lineItems        : lines,
    payments,
    receiptMethodMeta: (jobMeta && jobMeta.receiptMethodMeta) || {},
    rateIsCorporate  : (jobMeta && jobMeta.rateIsCorporate)  || '0',
    uomCodeMap       : (jobMeta && jobMeta.uomCodeMap)       || {},
    journalMeta      : (jobMeta && jobMeta.journalMeta)      || undefined,
  };

  const metaObj = (jobMeta && jobMeta.billToName) ? {
    billToName      : jobMeta.billToName,
    siteNumber      : jobMeta.siteNumber   || null,
    billToAccount   : jobMeta.billToAccount || 1000,
    businessUnit    : jobMeta.businessUnit || 'DEFAULT_BU',
    txnSource       : jobMeta.txnSource    || 'ODOO_SALES',
    txnType         : jobMeta.txnType      || 'Invoice',
    region          : (jobMeta && jobMeta.region) || 'AE',
    customerType    : (jobMeta && jobMeta.customerType) || 'NORMAL',
    costCenterCode  : jobMeta.costCenterCode || null,
    paymentTermsName: jobMeta.paymentTermsName || null,
    orgId           : jobMeta.orgId || null,
  } : {
    billToName      : sale.partner_name || 'Odoo Customer',
    siteNumber      : null,
    billToAccount   : 1000,
    businessUnit    : 'DEFAULT_BU',
    txnSource       : 'ODOO_SALES',
    txnType         : 'Invoice',
    region          : (jobMeta && jobMeta.region) || 'AE',
    customerType    : (jobMeta && jobMeta.customerType) || 'NORMAL',
    costCenterCode  : null,
    paymentTermsName: (jobMeta && jobMeta.paymentTermsName) || null,
    orgId           : (jobMeta && jobMeta.orgId) || null,
  };

  // Warn when using fallback defaults – these are almost certainly wrong for
  // a real Oracle Fusion instance and will cause 400 errors.
  if (!jobMeta || !jobMeta.billToName) {
    logger.warn(
      'Sale %s (store_id=%s): No Oracle metadata configured – using defaults. ' +
      'Configure store metadata via PUT /api/odoo/store-metadata/:storeId or the UI. ' +
      'Defaults: billToName=%s, businessUnit=%s, billToAccount=%s',
      sale.name, sale.store_id, metaObj.billToName, metaObj.businessUnit, metaObj.billToAccount
    );
  }

  const outletObj = jobOutlet || {
    currency        : sale.currency       || DEFAULT_CURRENCY,
    outletName      : sale.store_name     || 'Odoo Store',
    organizationName: sale.store_name     || 'Odoo Store',
  };

  return { sale: saleObj, metadata: metaObj, outlet: outletObj };
}

// ── Utilities ─────────────────────────────────────────────────────────────────

/**
 * Create a caching store-metadata resolver.
 * Each call returns a function that looks up store_oracle_metadata by store_id
 * and caches the result so the DB is hit at most once per store_id per job.
 */
function createStoreMetaResolver() {
  const cache = {};
  return function resolveStoreMetadata(saleStoreId) {
    if (cache[saleStoreId] !== undefined) return cache[saleStoreId];
    const row = saleStoreId ? db.getStoreOracleMetadata(saleStoreId) : null;
    cache[saleStoreId] = row || null;
    return cache[saleStoreId];
  };
}

/**
 * Extract a clean YYYY-MM-DD date from a date/datetime string.
 * Handles common formats returned by Odoo JSONRPC and REST APIs:
 *   '2026-03-01 12:30:00'        → '2026-03-01'   (space-separated)
 *   '2026-03-01T12:30:00Z'       → '2026-03-01'   (ISO format)
 *   '2026-03-01T12:30:00+04:00'  → '2026-03-01'   (ISO with tz offset)
 *   '2026-03-01'                 → '2026-03-01'   (date only)
 */
function extractDate(val) {
  if (!val) return '';
  const s = String(val);
  // Match YYYY-MM-DD at the start (handles both T-separated and space-separated)
  const m = s.match(/^(\d{4}-\d{2}-\d{2})/);
  return m ? m[1] : '';
}

function chunkArray(arr, size) {
  const chunks = [];
  for (let i = 0; i < arr.length; i += size) {
    chunks.push(arr.slice(i, i + size));
  }
  return chunks;
}

// ── Stores cache ──────────────────────────────────────────────────────────────

/**
 * Fetch list of stores directly from Odoo (warehouses).
 * Used by the frontend dropdown.
 */
async function getOdooStores() {
  const odoo = buildOdooClient();
  await odoo.authenticate();
  return odoo.getStores();
}

// ── On-demand payment fetch for a single sale ────────────────────────────────

/**
 * Fetch payment details from Odoo for a single sale and persist them locally.
 *
 * Used by the sale preview endpoint (`GET /api/odoo/sales/:id/preview`) when
 * no locally-stored payments exist, or when the caller explicitly requests a
 * live refresh.  The function builds an Odoo client appropriate for the sale's
 * country, authenticates, fetches payments via the same API endpoints used by
 * the batch fetch job, and upserts them into `odoo_sale_payments`.
 *
 * @param {object} sale  Sale record from the local DB – must include at least
 *                       `id`, `odoo_id`, `name`, and optionally `country`,
 *                       `store_name`, `register_name`, `raw_json`.
 * @returns {object[]}   The fetched payment rows (in DB column format).
 */
async function fetchPaymentsForSale(sale) {
  if (!sale || !sale.odoo_id) return [];

  const odoo = buildOdooClient(sale.country || null);
  await odoo.authenticate();

  const now = new Date().toISOString();
  let paymentRows = [];

  if (odoo instanceof OdooRestClient) {
    // REST path: prefer payment_ids from the stored sale header.
    // The Sale_detail response includes payment_ids: [id1, id2, …] which
    // directly identify the payment records.  Fall back to pos_order_id
    // filtering if no payment IDs are available (e.g. older fetched data).
    let paymentIds = [];
    try {
      const raw = sale.raw_json ? JSON.parse(sale.raw_json) : {};
      paymentIds = Array.isArray(raw.payment_ids) ? raw.payment_ids : [];
      // Backward compatibility: check _raw for older normalised data
      if (paymentIds.length === 0 && raw._raw && Array.isArray(raw._raw.payment_ids)) {
        paymentIds = raw._raw.payment_ids;
      }
    } catch (_) { /* ignore JSON parse errors */ }

    const rawPayments = paymentIds.length > 0
      ? await odoo.getPaymentsByPaymentIds(paymentIds)
      : await odoo.getPaymentsByOrderIds([sale.odoo_id]);

    paymentRows = rawPayments.map(p => {
      const journalLabel = Array.isArray(p.journal_id) ? p.journal_id[1] : (p.journal_id || 'Unknown');
      // outlet_name: prefer partner_id name, then company_name from normalisation, then sale store
      const outletName = (Array.isArray(p.partner_id) ? p.partner_id[1] : null)
        || p.company_name || sale.store_name || null;
      return {
        sale_id        : sale.id,
        invoice_number : p.name || sale.name || '',
        odoo_payment_id: p.id,
        payment_type   : journalLabel,
        amount         : Number(p.amount) || 0,
        currency       : Array.isArray(p.currency_id) ? p.currency_id[1] : DEFAULT_CURRENCY,
        payment_date   : extractDate(p.date) || sale.date_order || null,
        outlet_name    : outletName,
        register_name  : p.session_name || sale.register_name || null,
        region         : sale.country || null,
        fetched_at     : now,
      };
    });
  } else {
    // JSONRPC path: extract invoice_ids from the stored raw Odoo response,
    // then fetch account.payment records linked to those invoices.
    let invoiceIds = [];
    try {
      const raw = sale.raw_json ? JSON.parse(sale.raw_json) : {};
      invoiceIds = Array.isArray(raw.invoice_ids) ? raw.invoice_ids : [];
    } catch (_) { /* ignore JSON parse errors */ }

    if (invoiceIds.length > 0) {
      const rawPayments = await odoo.getOrderPayments(invoiceIds);
      paymentRows = rawPayments.map(p => ({
        sale_id        : sale.id,
        invoice_number : sale.name || '',
        odoo_payment_id: p.id,
        payment_type   : Array.isArray(p.journal_id) ? p.journal_id[1] : (p.journal_id || 'Unknown'),
        amount         : Number(p.amount) || 0,
        currency       : Array.isArray(p.currency_id) ? p.currency_id[1] : DEFAULT_CURRENCY,
        payment_date   : extractDate(p.date) || null,
        outlet_name    : sale.store_name || null,
        register_name  : sale.register_name || null,
        region         : sale.country || null,
        fetched_at     : now,
      }));
    }
  }

  if (paymentRows.length > 0) {
    db.upsertSalePayments(paymentRows);
  }

  return paymentRows;
}

module.exports = {
  startFetchJob,
  startPushJob,
  startRetryJob,
  getOdooStores,
  buildOracleSalePayload,
  fetchPaymentsForSale,
  buildOdooClient,
};
