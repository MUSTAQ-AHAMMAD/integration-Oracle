'use strict';

/**
 * fusionMetadataSeed.js
 *
 * Parses FUSION_SALES_METADATA CSV exports (oracle-crm/*.csv) and seeds the
 * fusion_sales_metadata SQLite table.
 *
 * CSV column mapping:
 *   ROW_ID                → row_id
 *   BILL_TO_NAME          → bill_to_name
 *   BILL_TO_ACCOUNT       → bill_to_account
 *   SITE_NUMBER           → site_number
 *   BUSINESS_UNIT         → business_unit
 *   TXN_SOURCE            → txn_source
 *   TXN_TYPE              → txn_type
 *   RATE_IS_CORPORATE     → rate_is_corporate
 *   REC_ACTIVITY_NAME_BANK→ rec_activity_name_bank
 *   SUBINVENTORY          → subinventory  (lookup key #1)
 *   INTEGRATION_SOURCE    → integration_source
 *   DISTRIBUTION_ACC_ID   → distribution_acc_id
 *   REC_ACTIVITY_NAME_CASH→ rec_activity_name_cash
 *   REGION                → region
 *   CUSTOMER_TYPE         → customer_type (lookup key #2)
 *   COST_CENTER_CODE      → cost_center_code
 */

const fs     = require('fs');
const path   = require('path');
const logger = require('./logger').child('FusionMetaSeed');

// Directory that holds the CSV files (one level up from src/)
const CSV_DIR = path.join(__dirname, '..');

// Match all FUSION_SALES_METADATA_*.csv files
const CSV_PATTERN = /^FUSION_SALES_METADATA_.*\.csv$/i;

/**
 * Parse a single CSV string into an array of row objects.
 * Handles double-quoted fields and strips BOM.
 * @param {string} content  – raw CSV file content
 * @returns {object[]}
 */
function parseCsv(content) {
  // Strip BOM
  const text  = content.replace(/^\uFEFF/, '');
  const lines = text.split(/\r?\n/);
  if (lines.length < 2) return [];

  const headers = splitCsvLine(lines[0]).map(h => h.replace(/^"|"$/g, '').trim());

  const rows = [];
  for (let i = 1; i < lines.length; i++) {
    const line = lines[i].trim();
    if (!line) continue;
    const values = splitCsvLine(line);
    if (values.length < headers.length) continue;
    const obj = {};
    for (let j = 0; j < headers.length; j++) {
      obj[headers[j]] = values[j].replace(/^"|"$/g, '').trim();
    }
    rows.push(obj);
  }
  return rows;
}

/**
 * Split a single CSV line respecting double-quoted fields.
 */
function splitCsvLine(line) {
  const result = [];
  let cur      = '';
  let inQuote  = false;
  for (let i = 0; i < line.length; i++) {
    const ch = line[i];
    if (ch === '"') {
      if (inQuote && line[i + 1] === '"') {
        cur += '"';
        i++;
      } else {
        inQuote = !inQuote;
      }
    } else if (ch === ',' && !inQuote) {
      result.push(cur);
      cur = '';
    } else {
      cur += ch;
    }
  }
  result.push(cur);
  return result;
}

/**
 * Map a parsed CSV row object to the DB row shape expected by
 * db.bulkUpsertFusionSalesMetadata().
 */
function mapCsvRowToDb(row) {
  return {
    row_id                : row['ROW_ID']                 ? Number(row['ROW_ID'])   : null,
    subinventory          : (row['SUBINVENTORY']          || '').trim(),
    customer_type         : (row['CUSTOMER_TYPE']         || '').trim(),
    bill_to_name          : (row['BILL_TO_NAME']          || '').trim() || null,
    bill_to_account       : (row['BILL_TO_ACCOUNT']       || '').trim() || null,
    site_number           : (row['SITE_NUMBER']           || '').trim() || null,
    business_unit         : (row['BUSINESS_UNIT']         || '').trim() || null,
    txn_source            : (row['TXN_SOURCE']            || '').trim() || null,
    txn_type              : (row['TXN_TYPE']              || '').trim() || null,
    rate_is_corporate     : (row['RATE_IS_CORPORATE']     || '1').trim(),
    rec_activity_name_bank: (row['REC_ACTIVITY_NAME_BANK']|| '').trim() || null,
    rec_activity_name_cash: (row['REC_ACTIVITY_NAME_CASH']|| '').trim() || null,
    integration_source    : (row['INTEGRATION_SOURCE']    || '').trim() || null,
    distribution_acc_id   : (row['DISTRIBUTION_ACC_ID']   || '').trim() || null,
    region                : (row['REGION']                || '').trim() || null,
    cost_center_code      : (row['COST_CENTER_CODE']      || '').trim() || null,
  };
}

/**
 * Find all FUSION_SALES_METADATA CSV files in oracle-crm/ and return the most
 * recently modified one (by filename timestamp, falling back to mtime).
 * Returns null if none found.
 */
function findLatestCsvFile() {
  let files;
  try {
    files = fs.readdirSync(CSV_DIR).filter(f => CSV_PATTERN.test(f));
  } catch (_) {
    return null;
  }
  if (files.length === 0) return null;
  // Sort descending by filename (timestamps are embedded: *_YYYYMMDDHHSS.csv)
  files.sort((a, b) => b.localeCompare(a));
  return path.join(CSV_DIR, files[0]);
}

/**
 * Seed the fusion_sales_metadata table from the latest CSV file.
 *
 * @param {object} db          – the db module (required to avoid circular imports)
 * @param {object} [opts]
 * @param {string} [opts.csvPath]  – explicit CSV path (override auto-discovery)
 * @param {boolean}[opts.force]    – re-seed even if the table already has rows
 * @returns {{ seeded: number, source: string } | null}  null = nothing to do
 */
function seedFusionSalesMetadata(db, opts = {}) {
  const { force = false, csvPath: explicitPath } = opts;

  // Skip if already seeded (unless forced)
  if (!force && db.countFusionSalesMetadata() > 0) {
    logger.info('fusion_sales_metadata already seeded – skipping (pass force=true to re-seed)');
    return null;
  }

  const csvPath = explicitPath || findLatestCsvFile();
  if (!csvPath) {
    logger.warn(`No FUSION_SALES_METADATA CSV file found in ${CSV_DIR} – fusion metadata not seeded`);
    return null;
  }

  let content;
  try {
    content = fs.readFileSync(csvPath, 'utf8');
  } catch (err) {
    logger.warn(`Could not read fusion metadata CSV ${csvPath}: ${err.message}`);
    return null;
  }

  const csvRows = parseCsv(content);
  const dbRows  = csvRows
    .map(mapCsvRowToDb)
    .filter(r => r.subinventory && r.customer_type);  // skip blank/footer rows

  if (dbRows.length === 0) {
    logger.warn(`CSV ${csvPath} contained no valid rows – fusion metadata not seeded`);
    return null;
  }

  const seeded = db.bulkUpsertFusionSalesMetadata(dbRows);
  logger.info(`Seeded ${seeded} rows into fusion_sales_metadata from ${path.basename(csvPath)}`);
  return { seeded, source: csvPath };
}

module.exports = { seedFusionSalesMetadata, parseCsv, mapCsvRowToDb, findLatestCsvFile };
