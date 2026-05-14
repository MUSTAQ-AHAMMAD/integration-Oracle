# Oracle CRM Database Schema Documentation

## Overview

This directory contains production-ready database schemas for the Oracle CRM middleware. The schemas are designed to be **robust, scalable, and maintainable** with proper normalization, indexing, and audit trails.

## Schema Files

| File | Database | Description |
|------|----------|-------------|
| `schema.sql` | PostgreSQL | Production-ready schema with advanced features (partitioning, JSONB, views) |
| `schema-mysql.sql` | MySQL/MariaDB | MySQL-optimized schema with InnoDB engine and UTF8MB4 support |
| (existing) `../src/db.js` | SQLite | Lightweight embedded database for development and small deployments |

## Design Principles

### 1. **Normalization (3NF)**
- Eliminates data redundancy
- Ensures data integrity through foreign key constraints
- Separates concerns (users, sales, payments, Oracle tracking)

### 2. **Performance Optimization**
- Strategic indexes on frequently queried columns
- Composite indexes for complex queries
- Partitioning support for large tables (PostgreSQL)
- Pre-aggregated stats tables for dashboard performance

### 3. **Scalability**
- Supports millions of records with proper indexing
- Partitioning-ready for time-series data
- Efficient batch processing with transaction support
- Cursor-based pagination for large result sets

### 4. **Data Integrity**
- Foreign key constraints ensure referential integrity
- Check constraints validate data ranges
- NOT NULL constraints prevent incomplete data
- Unique constraints prevent duplicates

### 5. **Audit Trails**
- `created_at` and `updated_at` timestamps on all tables
- Soft deletes with `deleted_at` column where appropriate
- User activity log for compliance and security
- Job logs for debugging and monitoring

### 6. **Security**
- Password hashing (bcrypt via application layer)
- Role-based access control (5-tier RBAC)
- Session management with token expiry
- Failed login tracking and account locking
- Encrypted field support (marked with `is_encrypted` flag)

## Database Schema Overview

### Core Tables (11 tables)

#### 1. User Management
- **users**: System users with roles (super_admin, admin, management, operator, viewer)
- **user_sessions**: Active user sessions for security tracking
- **user_activity_log**: Audit trail of all user actions

#### 2. Configuration
- **app_settings**: Key-value store for global settings
- **country_configs**: Per-country Odoo and Oracle credentials

#### 3. Oracle Fusion Metadata
- **store_oracle_metadata**: Per-store Oracle billing identities
- **fusion_sales_metadata**: Reference data from CSV exports
- **fusion_receipt_methods**: Payment method configurations

#### 4. Sales Data (Core Business Logic)
- **sales_orders**: Sale order headers from Odoo/VendHQ
- **sales_order_lines**: Line items with products, quantities, pricing
- **sales_payments**: Payment transactions

#### 5. Oracle Integration Tracking
- **oracle_invoices**: AR invoice headers
- **oracle_invoice_lines**: AR invoice line items
- **oracle_standard_receipts**: Standard receipts
- **oracle_misc_receipts**: Miscellaneous receipts (bank charges)
- **oracle_receipt_applications**: Receipt-to-invoice applications
- **oracle_inventory_transactions**: Inventory movements
- **oracle_journal_headers**: GL journal headers
- **oracle_journal_lines**: GL journal lines

#### 6. Job Management
- **sync_jobs**: Background job tracking (fetch, push, retry)
- **job_logs**: Structured logging per job
- **failed_records**: Failed records for retry processing

#### 7. Reporting
- **daily_stats**: Pre-aggregated daily metrics for fast dashboards

## Table Relationships

```
users
├── user_sessions (1:N)
├── user_activity_log (1:N)
├── sync_jobs (1:N created_by)
└── failed_records (1:N resolved_by)

country_configs (standalone)

sales_orders
├── sales_order_lines (1:N)
├── sales_payments (1:N)
├── oracle_invoices (1:1)
├── oracle_journal_headers (1:1)
└── failed_records (1:N)

oracle_invoices
├── oracle_invoice_lines (1:N)
└── oracle_receipt_applications (1:N)

oracle_standard_receipts
└── oracle_receipt_applications (1:N)

sync_jobs
├── job_logs (1:N)
└── failed_records (1:N)
```

## Key Indexes

### Performance-Critical Indexes

```sql
-- Sales queries by date range
idx_sales_orders_order_date (order_date DESC)

-- Sales by store
idx_sales_orders_store (store_id, order_date DESC)

-- Sales by country
idx_sales_orders_country (country_code, order_date DESC)

-- Push status tracking
idx_sales_orders_push_status (push_status, order_date DESC)

-- Job monitoring
idx_sync_jobs_status (status, created_at DESC)

-- Failed record retry processing
idx_failed_records_next_retry (next_retry_at)
```

## Data Types & Sizes

### Decimal Precision
- **Money amounts**: `DECIMAL(15,2)` - supports up to 9,999,999,999,999.99
- **Quantities**: `DECIMAL(15,3)` - supports up to 999,999,999,999.999
- **Unit prices**: `DECIMAL(15,4)` - precise pricing
- **Percentages**: `DECIMAL(5,2)` - 0.00 to 999.99%
- **Exchange rates**: `DECIMAL(15,6)` - high precision

### String Lengths
- **Names/Titles**: VARCHAR(200)
- **Codes/IDs**: VARCHAR(50)
- **Email**: VARCHAR(255)
- **URLs**: VARCHAR(500)
- **Long text**: TEXT or LONGTEXT
- **JSON data**: JSON/JSONB

## Migration from SQLite to PostgreSQL/MySQL

### Step 1: Export SQLite data

```bash
cd oracle-crm
sqlite3 data/odoo_sales.db .dump > data/sqlite_export.sql
```

### Step 2: Create PostgreSQL database

```bash
createdb oracle_crm_production
psql oracle_crm_production < database/schema.sql
```

### Step 3: Migrate data

```javascript
// Use a migration script or tool like:
// - pgloader (SQLite to PostgreSQL)
// - Custom Node.js script using both DB drivers
```

### Step 4: Update application config

```javascript
// In src/db.js or new src/db-postgres.js
const { Pool } = require('pg');
const pool = new Pool({
  host: process.env.DB_HOST,
  port: process.env.DB_PORT,
  database: process.env.DB_NAME,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  max: 20, // connection pool size
  idleTimeoutMillis: 30000,
});
```

## Partitioning Strategy (PostgreSQL)

For deployments handling millions of records:

### Partition by Date Range

```sql
-- Monthly partitions for sales_orders
CREATE TABLE sales_orders_2026_05 PARTITION OF sales_orders
    FOR VALUES FROM ('2026-05-01') TO ('2026-06-01');

CREATE TABLE sales_orders_2026_06 PARTITION OF sales_orders
    FOR VALUES FROM ('2026-06-01') TO ('2026-07-01');
```

### Benefits
- **Query performance**: Only scans relevant partitions
- **Maintenance**: Archive old partitions easily
- **Storage**: Move old partitions to slower/cheaper storage

## Backup & Recovery

### PostgreSQL

```bash
# Full backup
pg_dump oracle_crm_production > backup_$(date +%Y%m%d).sql

# Compressed backup
pg_dump oracle_crm_production | gzip > backup_$(date +%Y%m%d).sql.gz

# Restore
psql oracle_crm_production < backup_20260514.sql
```

### MySQL

```bash
# Full backup
mysqldump -u root -p oracle_crm_production > backup_$(date +%Y%m%d).sql

# Compressed backup
mysqldump -u root -p oracle_crm_production | gzip > backup_$(date +%Y%m%d).sql.gz

# Restore
mysql -u root -p oracle_crm_production < backup_20260514.sql
```

## Monitoring & Maintenance

### Key Metrics to Monitor

1. **Table sizes**
   ```sql
   -- PostgreSQL
   SELECT schemaname, tablename,
          pg_size_pretty(pg_total_relation_size(schemaname||'.'||tablename))
   FROM pg_tables
   WHERE schemaname = 'public'
   ORDER BY pg_total_relation_size(schemaname||'.'||tablename) DESC;
   ```

2. **Index usage**
   ```sql
   -- PostgreSQL
   SELECT schemaname, tablename, indexname, idx_scan, idx_tup_read, idx_tup_fetch
   FROM pg_stat_user_indexes
   ORDER BY idx_scan DESC;
   ```

3. **Slow queries** (enable query logging)

4. **Connection pool status**

### Regular Maintenance Tasks

```sql
-- PostgreSQL: Analyze tables for query planner
ANALYZE sales_orders;

-- PostgreSQL: Vacuum to reclaim space
VACUUM ANALYZE sales_orders;

-- MySQL: Optimize tables
OPTIMIZE TABLE sales_orders;
```

## Security Best Practices

1. **Database User Permissions**
   - Create separate users for app vs. admin
   - Grant minimal required permissions
   - Use SSL/TLS for connections

2. **Sensitive Data**
   - Store passwords hashed (bcrypt in application)
   - Mark encrypted fields in `app_settings`
   - Use environment variables for credentials

3. **Network Security**
   - Firewall rules to restrict database access
   - Use connection pooling with auth
   - Enable audit logging

## Performance Tuning

### PostgreSQL

```conf
# postgresql.conf
shared_buffers = 256MB
effective_cache_size = 1GB
work_mem = 16MB
maintenance_work_mem = 64MB
max_connections = 100
```

### MySQL

```conf
# my.cnf
innodb_buffer_pool_size = 1G
innodb_log_file_size = 256M
max_connections = 150
query_cache_size = 64M
```

## Schema Versioning

Track schema changes in `app_settings`:

```sql
SELECT * FROM app_settings WHERE key = 'schema_version';
-- Returns: 2.0.0
```

### Migration Path

1. **v1.x (SQLite)** → v2.0 (PostgreSQL/MySQL)
2. **v2.0** → v2.1 (add new features)
3. Use migration tools like:
   - Flyway
   - Liquibase
   - Knex.js migrations
   - Custom SQL scripts

## Comparison: SQLite vs. PostgreSQL vs. MySQL

| Feature | SQLite | PostgreSQL | MySQL |
|---------|--------|------------|-------|
| **Max DB Size** | 281 TB | Unlimited | Unlimited |
| **Concurrent Writes** | 1 | Many | Many |
| **Foreign Keys** | Yes | Yes | Yes (InnoDB) |
| **JSON Support** | Yes (basic) | Yes (JSONB) | Yes (JSON) |
| **Full Text Search** | Basic | Advanced | Good |
| **Partitioning** | No | Yes | Yes (5.7+) |
| **Replication** | No | Yes | Yes |
| **Best For** | Development, <100K records | Production, high concurrency | Production, read-heavy |

## Recommended Deployment Sizes

| Records/Month | Database | Configuration |
|---------------|----------|---------------|
| < 10,000 | SQLite | Default (current setup) |
| 10K - 100K | SQLite or MySQL | Consider upgrade |
| 100K - 1M | PostgreSQL or MySQL | Required |
| > 1M | PostgreSQL | With partitioning |

## Support & Documentation

- **PostgreSQL**: https://www.postgresql.org/docs/
- **MySQL**: https://dev.mysql.com/doc/
- **SQLite**: https://www.sqlite.org/docs.html

## Questions?

For database design questions, contact the development team or create an issue in the repository.

---

**Last Updated**: 2026-05-14
**Schema Version**: 2.0.0
**Maintainer**: Oracle CRM Development Team
