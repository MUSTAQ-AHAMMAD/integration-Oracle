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
    const allOrderIdSet = new Set();      // deduplicate IDs across pages

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

      for (const o of page) allOrderIdSet.add(o.id);
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

    const allOrderIds = [...allOrderIdSet];
    jobLog(jobId, 'info', `All ${totalFetched} sale headers stored in local DB (${allOrderIds.length} unique IDs)`);

    if (totalFetched === 0) {
      db.updateJob(jobId, { status: 'DONE', finished_at: new Date().toISOString() });
      jobLog(jobId, 'info', 'No orders found – job complete');
      return;
    }

    // ── Fetch + persist lines (parallel chunks, bulk ID lookup) ──────────────
    jobLog(jobId, 'info', 'Fetching sale order lines…', { orderCount: allOrderIds.length });

    // Split all order IDs into chunks for Odoo calls.
    const LINE_FETCH_CHUNK = 200;
    const idChunks = [];
    for (let i = 0; i < allOrderIds.length; i += LINE_FETCH_CHUNK) {
      idChunks.push(allOrderIds.slice(i, i + LINE_FETCH_CHUNK));
    }

    // Fetch lines for all chunks with bounded concurrency, then do a single
    // bulk internal-ID map lookup per chunk (no N+1 queries).
    let totalLines     = 0;
    let lineChunksDone = 0;
    let lineChunkErrs  = 0;
    const fetchBatches = chunkArray(idChunks, LINE_FETCH_CONCURRENCY);
    for (const group of fetchBatches) {
      // Wrap each chunk in a try/catch so one failure doesn't abort the entire
      // line-fetch phase.  Failed chunks are logged and counted.
      const chunkResults = await Promise.all(
        group.map(idChunk =>
          odoo.getSaleOrderLines(idChunk).catch(err => {
            lineChunkErrs++;
            jobLog(jobId, 'warn', `Line fetch chunk failed (${idChunk.length} orders): ${err.message}`);
            return [];   // return empty so remaining chunks still process
          })
        )
      );

      for (let g = 0; g < group.length; g++) {
        const idChunk  = group[g];
        const rawLines = chunkResults[g];

        if (rawLines.length === 0) { lineChunksDone++; continue; }

        // One bulk query instead of one SELECT per line
        const internalIdMap = db.getSaleInternalIdMap(idChunk);

        const lineRows = rawLines.map((l, idx) => {
          const orderId = Array.isArray(l.order_id) ? l.order_id[0] : l.order_id;
          // tax_name: first tax name from tax_id array (Odoo returns [id, name] tuples or IDs only)
          const firstTax   = Array.isArray(l.tax_id) && l.tax_id.length > 0 ? l.tax_id[0] : null;
          const taxName    = Array.isArray(firstTax) ? firstTax[1] : null;
          return {
            sale_id        : internalIdMap.get(orderId) || null,
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

    // ── Fetch + persist payments (3rd endpoint: account.payment / payment_lines) ─
    // Mirrors middleware BackupVendhqPayments table populated from the same fetch.
    //
    // Two strategies depending on client type:
    //   JSONRPC (OdooClient):    re-read sale.order.invoice_ids → fetch account.payment
    //   REST  (OdooRestClient):  query payment_lines by order IDs so each payment
    //                            is directly tied to its parent sale order
    jobLog(jobId, 'info', 'Fetching sale payments from Odoo (account.payment)…');
    let totalPayments = 0;
    let totalPaymentsLinked = 0;
    try {
      let paymentRows = [];
      const now = new Date().toISOString();

      // Build the odooId → internalId mapping once; reused for both direct
      // linking (REST path) and the post-process fallback.
      const internalIdMap = db.getSaleInternalIdMap(allOrderIds);

      if (odoo instanceof OdooRestClient) {
        // ── REST path: fetch payments by order IDs ────────────────────────
        // Query payment_lines filtered by pos_order_id so payments are
        // directly linked to the fetched orders (not a date range which may
        // include unrelated payments or miss some).
        jobLog(jobId, 'info', 'REST: querying payment_lines by order IDs', { orderCount: allOrderIds.length });

        // Chunk order IDs to avoid overly-long query strings (same chunk
        // size used for line fetches).  Wrap each chunk in try/catch so one
        // failure doesn't abort the entire payment fetch (matches line-fetch
        // error handling pattern).
        const PAY_CHUNK = 200;
        const rawPayments = [];
        let payChunkErrs = 0;
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
        if (payChunkErrs > 0) {
          jobLog(jobId, 'warn', `${payChunkErrs} payment chunk(s) failed – partial payment data`);
        }

        paymentRows = rawPayments.map(p => {
          const journalLabel = Array.isArray(p.journal_id) ? p.journal_id[1] : (p.journal_id || 'Unknown');
          const posOrderId   = p.pos_order_id || null;
          // Directly link to the sale via the pos_order_id → internal ID map
          const saleId       = posOrderId != null ? (internalIdMap.get(posOrderId) ?? null) : null;
          return {
            sale_id        : saleId,
            invoice_number : p.name || '',
            odoo_payment_id: p.id,
            payment_type   : journalLabel,
            amount         : Number(p.amount)   || 0,
            currency       : Array.isArray(p.currency_id) ? p.currency_id[1] : DEFAULT_CURRENCY,
            payment_date   : extractDate(p.date) || null,
            outlet_name    : Array.isArray(p.partner_id) ? p.partner_id[1] : null,
            register_name  : null,
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

    const oracle    = buildOracleService(country);
    let processed   = 0;
    let failed      = 0;
    let dbOffset    = 0;

    // ── Paginated push – PUSH_BATCH_SIZE rows at a time ───────────────────────
    // Memory stays flat at O(PUSH_BATCH_SIZE) regardless of total order count.
    while (dbOffset < total) {
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
        await Promise.all(chunk.map(async sale => {
          try {
            const saleWithLines = db.getSaleWithLines(sale.id);
            const salePayload   = buildOracleSalePayload(saleWithLines, metadata, outlet);

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

    const finalStatus = processed === 0 && failed > 0 ? 'FAILED' : 'DONE';
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Push job finished – ${processed} pushed, ${failed} failed`);
    if (failed > 0) {
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

    const oracle = buildOracleService();

    // Paginate to avoid loading all failures into memory at once
    while (true) {
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
        await Promise.all(chunk.map(async record => {
          try {
            const internalId = db.getSaleInternalId(record.odoo_id);
            if (!internalId) {
              db.updateFailedRecord(record.id, 'SKIPPED');
              jobLog(jobId, 'warn', `Skipping ${record.sale_name} – not found in local DB`);
              failed++;
              return;
            }

            const saleWithLines = db.getSaleWithLines(internalId);
            const salePayload   = buildOracleSalePayload(saleWithLines, metadata, outlet);

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

    const finalStatus = processed === 0 && failed > 0 ? 'FAILED' : 'DONE';
    db.updateJob(jobId, {
      status      : finalStatus,
      processed,
      failed,
      finished_at : new Date().toISOString(),
    });
    jobLog(jobId, 'info', `Retry job finished – ${processed} resolved, ${failed} still failing`);

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

  const outletObj = jobOutlet || {
    currency        : sale.currency       || DEFAULT_CURRENCY,
    outletName      : sale.store_name     || 'Odoo Store',
    organizationName: sale.store_name     || 'Odoo Store',
  };

  return { sale: saleObj, metadata: metaObj, outlet: outletObj };
}

// ── Utilities ─────────────────────────────────────────────────────────────────

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

module.exports = {
  startFetchJob,
  startPushJob,
  startRetryJob,
  getOdooStores,
  buildOracleSalePayload,
};
