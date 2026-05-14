'use strict';

const express  = require('express');
const router   = express.Router();
const db       = require('../db');
const { requireAuth, requireManagement } = require('../middleware/auth');

/**
 * GET /api/reports/dashboard
 *
 * Returns comprehensive dashboard statistics for the entire middleware
 */
router.get('/dashboard', requireAuth, (req, res) => {
  try {
    const stats = {
      // Overall statistics
      totalSales: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM odoo_sales').get().cnt,
      totalPushed: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM odoo_sales WHERE oracle_txn_id IS NOT NULL').get().cnt,
      totalPending: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM odoo_sales WHERE oracle_txn_id IS NULL').get().cnt,

      // Financial summary
      totalRevenue: db.getDb().prepare('SELECT COALESCE(SUM(amount_total), 0) AS total FROM odoo_sales').get().total,
      pushedRevenue: db.getDb().prepare('SELECT COALESCE(SUM(amount_total), 0) AS total FROM odoo_sales WHERE oracle_txn_id IS NOT NULL').get().total,
      pendingRevenue: db.getDb().prepare('SELECT COALESCE(SUM(amount_total), 0) AS total FROM odoo_sales WHERE oracle_txn_id IS NULL').get().total,

      // Job statistics
      totalJobs: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM push_jobs').get().cnt,
      completedJobs: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM push_jobs WHERE status = 'DONE'").get().cnt,
      failedJobs: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM push_jobs WHERE status = 'FAILED'").get().cnt,
      runningJobs: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM push_jobs WHERE status = 'RUNNING'").get().cnt,

      // Failed records
      totalFailedRecords: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM failed_records').get().cnt,
      pendingRetries: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM failed_records WHERE status = 'PENDING'").get().cnt,

      // By country
      salesByCountry: db.getDb().prepare(`
        SELECT country,
               COUNT(*) AS total_sales,
               SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS pushed_sales,
               COALESCE(SUM(amount_total), 0) AS total_revenue
        FROM odoo_sales
        WHERE country IS NOT NULL
        GROUP BY country
        ORDER BY total_revenue DESC
      `).all(),

      // By store
      salesByStore: db.getDb().prepare(`
        SELECT store_id, store_name,
               COUNT(*) AS total_sales,
               SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS pushed_sales,
               COALESCE(SUM(amount_total), 0) AS total_revenue
        FROM odoo_sales
        WHERE store_id IS NOT NULL
        GROUP BY store_id, store_name
        ORDER BY total_revenue DESC
        LIMIT 20
      `).all(),

      // Recent activity
      lastPushInfo: db.getLastPushInfo(),
      lastFetchInfo: db.getLastFetchInfo(),

      // System info
      systemInfo: {
        usersTotal: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM users').get().cnt,
        superAdmins: db.countSuperAdmins(),
        admins: db.countAdmins(),
        countryConfigs: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM country_configs WHERE enabled = 1').get().cnt,
        storeMetadata: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM store_oracle_metadata').get().cnt,
      }
    };

    res.json(stats);
  } catch (err) {
    console.error('Dashboard error:', err);
    res.status(500).json({ error: 'Failed to generate dashboard statistics' });
  }
});

/**
 * GET /api/reports/migration/overview
 *
 * Detailed migration overview with date ranges and status
 */
router.get('/migration/overview', requireManagement, (req, res) => {
  try {
    const { dateFrom, dateTo, country, storeId } = req.query;

    const conditions = [];
    const params = [];

    if (dateFrom) { conditions.push('date_order >= ?'); params.push(dateFrom); }
    if (dateTo) { conditions.push('date_order <= ?'); params.push(dateTo); }
    if (country) { conditions.push('country = ?'); params.push(country); }
    if (storeId) { conditions.push('store_id = ?'); params.push(Number(storeId)); }

    const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';

    const overview = {
      summary: db.getDb().prepare(`
        SELECT
          COUNT(*) AS total_records,
          SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS migrated_records,
          SUM(CASE WHEN oracle_txn_id IS NULL THEN 1 ELSE 0 END) AS pending_records,
          MIN(date_order) AS earliest_date,
          MAX(date_order) AS latest_date,
          COALESCE(SUM(amount_total), 0) AS total_amount,
          COALESCE(SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN amount_total ELSE 0 END), 0) AS migrated_amount,
          COALESCE(SUM(CASE WHEN oracle_txn_id IS NULL THEN amount_total ELSE 0 END), 0) AS pending_amount
        FROM odoo_sales ${where}
      `).get(...params),

      byDate: db.getDb().prepare(`
        SELECT
          date_order,
          COUNT(*) AS total,
          SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS migrated,
          SUM(CASE WHEN oracle_txn_id IS NULL THEN 1 ELSE 0 END) AS pending,
          COALESCE(SUM(amount_total), 0) AS amount
        FROM odoo_sales ${where}
        GROUP BY date_order
        ORDER BY date_order DESC
        LIMIT 90
      `).all(...params),

      byCountry: db.getDb().prepare(`
        SELECT
          country,
          COUNT(*) AS total,
          SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS migrated,
          SUM(CASE WHEN oracle_txn_id IS NULL THEN 1 ELSE 0 END) AS pending,
          COALESCE(SUM(amount_total), 0) AS amount
        FROM odoo_sales ${where}
        GROUP BY country
        ORDER BY total DESC
      `).all(...params),

      byStore: db.getDb().prepare(`
        SELECT
          store_id, store_name,
          COUNT(*) AS total,
          SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS migrated,
          SUM(CASE WHEN oracle_txn_id IS NULL THEN 1 ELSE 0 END) AS pending,
          COALESCE(SUM(amount_total), 0) AS amount
        FROM odoo_sales ${where}
        GROUP BY store_id, store_name
        ORDER BY total DESC
      `).all(...params)
    };

    res.json(overview);
  } catch (err) {
    console.error('Migration overview error:', err);
    res.status(500).json({ error: 'Failed to generate migration overview' });
  }
});

/**
 * GET /api/reports/migration/jobs
 *
 * Detailed job history with filters
 */
router.get('/migration/jobs', requireManagement, (req, res) => {
  try {
    const { dateFrom, dateTo, status, jobType, limit = 50, offset = 0 } = req.query;

    const conditions = [];
    const params = [];

    if (dateFrom) { conditions.push('created_at >= ?'); params.push(dateFrom); }
    if (dateTo) { conditions.push('created_at <= ?'); params.push(dateTo); }
    if (status) { conditions.push('status = ?'); params.push(status); }
    if (jobType) { conditions.push('job_type = ?'); params.push(jobType); }

    const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';

    const jobs = db.getDb().prepare(`
      SELECT * FROM push_jobs ${where}
      ORDER BY created_at DESC
      LIMIT ? OFFSET ?
    `).all(...params, Number(limit), Number(offset));

    const total = db.getDb().prepare(`
      SELECT COUNT(*) AS cnt FROM push_jobs ${where}
    `).get(...params).cnt;

    res.json({ jobs, total, limit: Number(limit), offset: Number(offset) });
  } catch (err) {
    console.error('Migration jobs error:', err);
    res.status(500).json({ error: 'Failed to retrieve migration jobs' });
  }
});

/**
 * GET /api/reports/migration/failures
 *
 * Failed records report with retry information
 */
router.get('/migration/failures', requireManagement, (req, res) => {
  try {
    const { status, limit = 100, offset = 0 } = req.query;

    const result = db.listFailedRecords({ status, limit: Number(limit), offset: Number(offset) });

    // Add summary statistics
    const summary = {
      total: db.getDb().prepare('SELECT COUNT(*) AS cnt FROM failed_records').get().cnt,
      pending: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM failed_records WHERE status = 'PENDING'").get().cnt,
      resolved: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM failed_records WHERE status = 'RESOLVED'").get().cnt,
      skipped: db.getDb().prepare("SELECT COUNT(*) AS cnt FROM failed_records WHERE status = 'SKIPPED'").get().cnt,
    };

    res.json({ ...result, summary });
  } catch (err) {
    console.error('Migration failures error:', err);
    res.status(500).json({ error: 'Failed to retrieve failure records' });
  }
});

/**
 * GET /api/reports/analytics/timeline
 *
 * Time-series data for visualization
 */
router.get('/analytics/timeline', requireAuth, (req, res) => {
  try {
    const { dateFrom, dateTo, country, storeId, groupBy = 'day' } = req.query;

    const conditions = [];
    const params = [];

    if (dateFrom) { conditions.push('date_order >= ?'); params.push(dateFrom); }
    if (dateTo) { conditions.push('date_order <= ?'); params.push(dateTo); }
    if (country) { conditions.push('country = ?'); params.push(country); }
    if (storeId) { conditions.push('store_id = ?'); params.push(Number(storeId)); }

    const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';

    // Group by day, week, or month
    let dateFormat;
    switch (groupBy) {
      case 'week':
        dateFormat = "strftime('%Y-W%W', date_order)";
        break;
      case 'month':
        dateFormat = "strftime('%Y-%m', date_order)";
        break;
      default:
        dateFormat = 'date_order';
    }

    const timeline = db.getDb().prepare(`
      SELECT
        ${dateFormat} AS period,
        COUNT(*) AS total_sales,
        SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS migrated_sales,
        SUM(CASE WHEN oracle_txn_id IS NULL THEN 1 ELSE 0 END) AS pending_sales,
        COALESCE(SUM(amount_total), 0) AS total_revenue,
        COALESCE(AVG(amount_total), 0) AS avg_order_value
      FROM odoo_sales ${where}
      GROUP BY period
      ORDER BY period DESC
      LIMIT 365
    `).all(...params);

    res.json(timeline);
  } catch (err) {
    console.error('Analytics timeline error:', err);
    res.status(500).json({ error: 'Failed to generate timeline analytics' });
  }
});

/**
 * GET /api/reports/audit/users
 *
 * User activity audit trail
 */
router.get('/audit/users', requireManagement, (req, res) => {
  try {
    const users = db.listUsers();

    // Enhance with activity statistics
    const usersWithActivity = users.map(user => {
      const jobsCreated = db.getDb().prepare(`
        SELECT COUNT(*) AS cnt FROM push_jobs WHERE job_id IN (
          SELECT DISTINCT push_job_id FROM odoo_sales WHERE push_job_id IS NOT NULL
        )
      `).get().cnt;

      return {
        ...user,
        activity: {
          jobs_created: jobsCreated,
          last_active: user.last_login
        }
      };
    });

    res.json(usersWithActivity);
  } catch (err) {
    console.error('User audit error:', err);
    res.status(500).json({ error: 'Failed to retrieve user audit data' });
  }
});

/**
 * GET /api/reports/performance/stores
 *
 * Store performance metrics
 */
router.get('/performance/stores', requireManagement, (req, res) => {
  try {
    const { dateFrom, dateTo, limit = 50 } = req.query;

    const conditions = [];
    const params = [];

    if (dateFrom) { conditions.push('date_order >= ?'); params.push(dateFrom); }
    if (dateTo) { conditions.push('date_order <= ?'); params.push(dateTo); }

    const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';

    const storePerformance = db.getDb().prepare(`
      SELECT
        store_id,
        store_name,
        country,
        COUNT(*) AS total_orders,
        SUM(CASE WHEN oracle_txn_id IS NOT NULL THEN 1 ELSE 0 END) AS migrated_orders,
        COALESCE(SUM(amount_total), 0) AS total_revenue,
        COALESCE(AVG(amount_total), 0) AS avg_order_value,
        MIN(date_order) AS first_order_date,
        MAX(date_order) AS last_order_date,
        MAX(pushed_at) AS last_migration_date
      FROM odoo_sales ${where}
      GROUP BY store_id, store_name, country
      ORDER BY total_revenue DESC
      LIMIT ?
    `).all(...params, Number(limit));

    res.json(storePerformance);
  } catch (err) {
    console.error('Store performance error:', err);
    res.status(500).json({ error: 'Failed to retrieve store performance data' });
  }
});

/**
 * GET /api/reports/export/csv
 *
 * Export report data as CSV
 */
router.get('/export/csv', requireManagement, (req, res) => {
  try {
    const { type = 'sales', dateFrom, dateTo, country, storeId } = req.query;

    const conditions = [];
    const params = [];

    if (dateFrom) { conditions.push('date_order >= ?'); params.push(dateFrom); }
    if (dateTo) { conditions.push('date_order <= ?'); params.push(dateTo); }
    if (country) { conditions.push('country = ?'); params.push(country); }
    if (storeId) { conditions.push('store_id = ?'); params.push(Number(storeId)); }

    const where = conditions.length ? `WHERE ${conditions.join(' AND ')}` : '';

    let data, headers;

    if (type === 'sales') {
      data = db.getDb().prepare(`
        SELECT
          id, odoo_id, name, store_name, country, date_order,
          partner_name, currency, amount_total, state,
          oracle_txn_id, pushed_at
        FROM odoo_sales ${where}
        ORDER BY date_order DESC
        LIMIT 10000
      `).all(...params);

      headers = ['ID', 'Odoo ID', 'Sale Number', 'Store', 'Country', 'Date',
                 'Customer', 'Currency', 'Amount', 'State', 'Oracle TXN', 'Pushed At'];
    } else if (type === 'jobs') {
      data = db.listJobs(1000);
      headers = ['Job ID', 'Type', 'Mode', 'Date From', 'Date To', 'Store',
                 'Status', 'Total', 'Processed', 'Failed', 'Started', 'Finished'];
    }

    // Convert to CSV
    const csvRows = [headers.join(',')];
    data.forEach(row => {
      const values = Object.values(row).map(val => {
        const escaped = String(val == null ? '' : val).replace(/"/g, '""');
        return `"${escaped}"`;
      });
      csvRows.push(values.join(','));
    });

    const csv = csvRows.join('\n');

    res.setHeader('Content-Type', 'text/csv');
    res.setHeader('Content-Disposition', `attachment; filename="report-${type}-${Date.now()}.csv"`);
    res.send(csv);
  } catch (err) {
    console.error('CSV export error:', err);
    res.status(500).json({ error: 'Failed to export CSV' });
  }
});

module.exports = router;
