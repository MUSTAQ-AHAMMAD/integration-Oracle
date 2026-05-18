'use strict';

/**
 * duplicateDetector.js
 *
 * Advanced duplicate detection and prevention for sales data.
 *
 * Features:
 *   • Content-based fingerprinting (SHA-256 hash)
 *   • Multi-field composite key detection
 *   • Fuzzy matching for near-duplicates
 *   • Time-window based deduplication
 *   • Configurable detection strategies
 *
 * Usage:
 *   const detector = require('./duplicateDetector');
 *   const isDuplicate = await detector.checkDuplicate(sale);
 *   const fingerprint = detector.generateFingerprint(sale);
 */

const crypto = require('crypto');
const db = require('./db');
const logger = require('./logger').child('DuplicateDetector');

// ── Fingerprint generation ────────────────────────────────────────────────────

/**
 * Generate a unique fingerprint for a sale record.
 * Uses content-based hashing to detect exact duplicates.
 */
function generateFingerprint(sale, options = {}) {
  const fields = options.fields || [
    'invoice_number',
    'sale_date',
    'outlet_name',
    'total_price_incl_tax',
    'register_name'
  ];

  const content = fields
    .map(field => {
      const value = sale[field];
      if (value === null || value === undefined) return '';
      return String(value).trim().toLowerCase();
    })
    .join('|');

  const hash = crypto.createHash('sha256').update(content).digest('hex');
  return hash;
}

/**
 * Generate a composite key for quick lookups.
 * Uses invoice number + sale date as the primary key.
 */
function generateCompositeKey(sale) {
  const invoiceNumber = String(sale.invoice_number || sale.name || '').trim();
  const saleDate = String(sale.sale_date || sale.date_order || '').split('T')[0];
  return `${invoiceNumber}:${saleDate}`;
}

// ── Database tracking ─────────────────────────────────────────────────────────

function ensureDeduplicationTable() {
  const instance = db.getDb();

  instance.exec(`
    CREATE TABLE IF NOT EXISTS sale_fingerprints (
      id                INTEGER PRIMARY KEY AUTOINCREMENT,
      fingerprint       TEXT NOT NULL UNIQUE,
      composite_key     TEXT NOT NULL,
      invoice_number    TEXT NOT NULL,
      sale_date         TEXT NOT NULL,
      outlet_name       TEXT,
      country           TEXT,
      total_amount      REAL,
      created_at        TEXT NOT NULL,
      synced_at         TEXT,
      INDEX idx_composite_key ON sale_fingerprints(composite_key),
      INDEX idx_invoice_date ON sale_fingerprints(invoice_number, sale_date)
    );

    CREATE INDEX IF NOT EXISTS idx_sale_fingerprints_composite ON sale_fingerprints(composite_key);
    CREATE INDEX IF NOT EXISTS idx_sale_fingerprints_invoice ON sale_fingerprints(invoice_number, sale_date);
    CREATE INDEX IF NOT EXISTS idx_sale_fingerprints_created ON sale_fingerprints(created_at);
  `);
}

/**
 * Check if a sale is a duplicate using multiple detection strategies.
 *
 * Detection strategies:
 *   1. Fingerprint match (exact duplicate)
 *   2. Composite key match (same invoice + date)
 *   3. Time-window fuzzy match (near-duplicate within time window)
 */
async function checkDuplicate(sale, options = {}) {
  ensureDeduplicationTable();
  const instance = db.getDb();

  const strategy = options.strategy || 'strict'; // strict | fuzzy | aggressive
  const timeWindowMinutes = options.timeWindowMinutes || 60;

  // Strategy 1: Exact fingerprint match
  const fingerprint = generateFingerprint(sale, options);
  const fingerprintMatch = instance.prepare(`
    SELECT * FROM sale_fingerprints WHERE fingerprint = ?
  `).get(fingerprint);

  if (fingerprintMatch) {
    logger.debug('Duplicate detected via fingerprint', {
      fingerprint,
      original: fingerprintMatch.id
    });
    return {
      isDuplicate: true,
      reason: 'fingerprint_match',
      original: fingerprintMatch
    };
  }

  // Strategy 2: Composite key match (invoice + date)
  if (strategy === 'strict' || strategy === 'fuzzy') {
    const compositeKey = generateCompositeKey(sale);
    const compositeMatch = instance.prepare(`
      SELECT * FROM sale_fingerprints WHERE composite_key = ?
    `).get(compositeKey);

    if (compositeMatch) {
      logger.debug('Duplicate detected via composite key', {
        compositeKey,
        original: compositeMatch.id
      });
      return {
        isDuplicate: true,
        reason: 'composite_key_match',
        original: compositeMatch
      };
    }
  }

  // Strategy 3: Fuzzy matching within time window (for aggressive detection)
  if (strategy === 'fuzzy' || strategy === 'aggressive') {
    const invoiceNumber = String(sale.invoice_number || sale.name || '').trim();
    const saleDate = String(sale.sale_date || sale.date_order || '').split('T')[0];
    const outletName = String(sale.outlet_name || sale.store_name || '').trim().toLowerCase();

    const timeWindow = new Date(Date.now() - timeWindowMinutes * 60 * 1000).toISOString();

    const fuzzyMatch = instance.prepare(`
      SELECT * FROM sale_fingerprints
      WHERE invoice_number = ?
        AND sale_date = ?
        AND LOWER(outlet_name) = ?
        AND created_at >= ?
      LIMIT 1
    `).get(invoiceNumber, saleDate, outletName, timeWindow);

    if (fuzzyMatch) {
      logger.debug('Duplicate detected via fuzzy match', {
        invoiceNumber,
        saleDate,
        outletName,
        original: fuzzyMatch.id
      });
      return {
        isDuplicate: true,
        reason: 'fuzzy_match',
        original: fuzzyMatch
      };
    }
  }

  return {
    isDuplicate: false,
    fingerprint
  };
}

/**
 * Record a sale fingerprint to prevent future duplicates.
 */
function recordFingerprint(sale, fingerprint) {
  ensureDeduplicationTable();
  const instance = db.getDb();

  const compositeKey = generateCompositeKey(sale);
  const now = new Date().toISOString();

  try {
    instance.prepare(`
      INSERT INTO sale_fingerprints (
        fingerprint, composite_key, invoice_number, sale_date,
        outlet_name, country, total_amount, created_at
      ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    `).run(
      fingerprint,
      compositeKey,
      sale.invoice_number || sale.name || '',
      (sale.sale_date || sale.date_order || '').split('T')[0],
      sale.outlet_name || sale.store_name || '',
      sale.country || '',
      sale.total_price_incl_tax || sale.amount_total || 0,
      now
    );

    logger.debug('Fingerprint recorded', { fingerprint, compositeKey });
    return true;
  } catch (error) {
    if (error.message.includes('UNIQUE constraint failed')) {
      logger.warn('Fingerprint already exists (race condition)', { fingerprint });
      return false;
    }
    throw error;
  }
}

/**
 * Mark a fingerprint as synced to Oracle.
 */
function markSynced(fingerprint) {
  ensureDeduplicationTable();
  const instance = db.getDb();

  instance.prepare(`
    UPDATE sale_fingerprints
    SET synced_at = ?
    WHERE fingerprint = ?
  `).run(new Date().toISOString(), fingerprint);
}

/**
 * Batch check duplicates for multiple sales.
 * Returns array of { sale, isDuplicate, reason }.
 */
async function batchCheckDuplicates(sales, options = {}) {
  const results = [];

  for (const sale of sales) {
    const check = await checkDuplicate(sale, options);
    results.push({
      sale,
      ...check
    });
  }

  return results;
}

/**
 * Clean up old fingerprints to prevent database bloat.
 * Removes fingerprints older than retentionDays (default: 90 days).
 */
function cleanupOldFingerprints(retentionDays = 90) {
  ensureDeduplicationTable();
  const instance = db.getDb();

  const cutoffDate = new Date(Date.now() - retentionDays * 24 * 60 * 60 * 1000).toISOString();

  const result = instance.prepare(`
    DELETE FROM sale_fingerprints
    WHERE created_at < ?
      AND synced_at IS NOT NULL
  `).run(cutoffDate);

  logger.info('Cleaned up old fingerprints', {
    retentionDays,
    deletedCount: result.changes
  });

  return result.changes;
}

/**
 * Get duplicate statistics.
 */
function getStats() {
  ensureDeduplicationTable();
  const instance = db.getDb();

  const total = instance.prepare('SELECT COUNT(*) as count FROM sale_fingerprints').get().count;
  const synced = instance.prepare('SELECT COUNT(*) as count FROM sale_fingerprints WHERE synced_at IS NOT NULL').get().count;
  const last24h = instance.prepare(`
    SELECT COUNT(*) as count FROM sale_fingerprints
    WHERE created_at >= datetime('now', '-1 day')
  `).get().count;

  return {
    total,
    synced,
    pending: total - synced,
    last24h
  };
}

// ── Exports ───────────────────────────────────────────────────────────────────

module.exports = {
  generateFingerprint,
  generateCompositeKey,
  checkDuplicate,
  recordFingerprint,
  markSynced,
  batchCheckDuplicates,
  cleanupOldFingerprints,
  getStats
};
