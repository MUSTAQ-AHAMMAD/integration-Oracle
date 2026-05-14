-- ══════════════════════════════════════════════════════════════════════════════
-- ORACLE CRM - COMPREHENSIVE DATABASE SCHEMA
-- Version: 2.0
-- Date: 2026-05-14
-- Description: Production-ready, scalable database schema for Oracle Fusion CRM
-- ══════════════════════════════════════════════════════════════════════════════
--
-- This schema is designed for PostgreSQL/MySQL/Oracle compatibility
-- For SQLite, use schema-sqlite.sql instead
--
-- Design Principles:
-- 1. Normalization (3NF) for data integrity
-- 2. Proper indexing for query performance
-- 3. Foreign key constraints for referential integrity
-- 4. Audit trails with created_at/updated_at timestamps
-- 5. Soft deletes where appropriate
-- 6. Partitioning-ready for large tables
--
-- ══════════════════════════════════════════════════════════════════════════════

-- ==============================================================================
-- 1. USER MANAGEMENT & AUTHENTICATION
-- ==============================================================================

CREATE TABLE users (
    id                SERIAL PRIMARY KEY,
    username          VARCHAR(50) NOT NULL UNIQUE,
    email             VARCHAR(255) UNIQUE,
    password_hash     VARCHAR(255) NOT NULL,
    role              VARCHAR(20) NOT NULL DEFAULT 'operator',
    display_name      VARCHAR(100),
    avatar_data       TEXT,
    is_active         BOOLEAN NOT NULL DEFAULT TRUE,
    email_verified    BOOLEAN NOT NULL DEFAULT FALSE,
    two_factor_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    two_factor_secret VARCHAR(100),
    failed_login_attempts INT NOT NULL DEFAULT 0,
    locked_until      TIMESTAMP,
    last_login        TIMESTAMP,
    created_at        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at        TIMESTAMP,

    CONSTRAINT chk_role CHECK (role IN ('super_admin', 'admin', 'management', 'operator', 'viewer'))
);

CREATE INDEX idx_users_role ON users(role);
CREATE INDEX idx_users_email ON users(email) WHERE email IS NOT NULL;
CREATE INDEX idx_users_active ON users(is_active) WHERE is_active = TRUE;
CREATE INDEX idx_users_deleted ON users(deleted_at) WHERE deleted_at IS NULL;

COMMENT ON TABLE users IS 'System users with role-based access control';
COMMENT ON COLUMN users.role IS 'super_admin(5), admin(4), management(3), operator(2), viewer(1)';

-- User sessions for security tracking
CREATE TABLE user_sessions (
    id                SERIAL PRIMARY KEY,
    user_id           INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    session_token     VARCHAR(255) NOT NULL UNIQUE,
    ip_address        VARCHAR(45),
    user_agent        TEXT,
    expires_at        TIMESTAMP NOT NULL,
    created_at        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_activity_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_user_sessions_user ON user_sessions(user_id);
CREATE INDEX idx_user_sessions_token ON user_sessions(session_token);
CREATE INDEX idx_user_sessions_expires ON user_sessions(expires_at);

-- User activity audit log
CREATE TABLE user_activity_log (
    id                BIGSERIAL PRIMARY KEY,
    user_id           INT REFERENCES users(id) ON DELETE SET NULL,
    action_type       VARCHAR(50) NOT NULL,
    resource_type     VARCHAR(50),
    resource_id       VARCHAR(100),
    ip_address        VARCHAR(45),
    user_agent        TEXT,
    request_method    VARCHAR(10),
    request_path      VARCHAR(500),
    response_status   INT,
    details           JSONB,
    created_at        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_user_activity_user ON user_activity_log(user_id, created_at DESC);
CREATE INDEX idx_user_activity_action ON user_activity_log(action_type, created_at DESC);
CREATE INDEX idx_user_activity_created ON user_activity_log(created_at DESC);

-- ==============================================================================
-- 2. CONFIGURATION & SETTINGS
-- ==============================================================================

-- Application settings (key-value store)
CREATE TABLE app_settings (
    key                VARCHAR(100) PRIMARY KEY,
    value              TEXT,
    value_type         VARCHAR(20) NOT NULL DEFAULT 'string',
    description        TEXT,
    is_encrypted       BOOLEAN NOT NULL DEFAULT FALSE,
    created_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_value_type CHECK (value_type IN ('string', 'number', 'boolean', 'json'))
);

COMMENT ON TABLE app_settings IS 'Global application configuration';

-- Country-specific configurations
CREATE TABLE country_configs (
    id                    SERIAL PRIMARY KEY,
    country_code          VARCHAR(5) NOT NULL UNIQUE,
    country_name          VARCHAR(100) NOT NULL,
    currency_code         VARCHAR(3) NOT NULL DEFAULT 'AED',
    timezone_offset       DECIMAL(4,2) NOT NULL DEFAULT 0,

    -- Odoo ERP Configuration
    odoo_url              VARCHAR(500),
    odoo_db               VARCHAR(100),
    odoo_username         VARCHAR(100),
    odoo_password         VARCHAR(255),
    odoo_auth_type        VARCHAR(20) NOT NULL DEFAULT 'jsonrpc',
    odoo_api_key          VARCHAR(255),
    odoo_api_url          VARCHAR(500),
    odoo_version          INT NOT NULL DEFAULT 0,
    odoo_sale_detail_path VARCHAR(200),
    odoo_order_line_path  VARCHAR(200),
    odoo_payment_path     VARCHAR(200),
    odoo_pos_order_path   VARCHAR(200),

    -- Oracle Fusion Configuration
    oracle_base_url       VARCHAR(500),
    oracle_username       VARCHAR(100),
    oracle_password       VARCHAR(255),

    enabled               BOOLEAN NOT NULL DEFAULT TRUE,
    created_at            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_odoo_auth CHECK (odoo_auth_type IN ('jsonrpc', 'rest', 'api_key'))
);

CREATE INDEX idx_country_configs_enabled ON country_configs(enabled) WHERE enabled = TRUE;

COMMENT ON TABLE country_configs IS 'Per-country ERP and Oracle connection settings';

-- ==============================================================================
-- 3. ORACLE FUSION METADATA & REFERENCE DATA
-- ==============================================================================

-- Store/Outlet Oracle metadata mapping
CREATE TABLE store_oracle_metadata (
    id                      SERIAL PRIMARY KEY,
    store_id                INT NOT NULL UNIQUE,
    store_name              VARCHAR(200),
    outlet_name             VARCHAR(200),

    -- Oracle Fusion Invoice Fields
    bill_to_name            VARCHAR(200),
    bill_to_account         VARCHAR(50),
    site_number             VARCHAR(50),
    business_unit           VARCHAR(100),
    txn_source              VARCHAR(50) NOT NULL DEFAULT 'ODOO_SALES',
    txn_type                VARCHAR(50) NOT NULL DEFAULT 'Invoice',
    payment_terms_name      VARCHAR(50),

    -- Oracle Fusion Organization
    org_id                  INT,
    organization_name       VARCHAR(200),

    -- Conversion & Accounting
    rate_is_corporate       CHAR(1) NOT NULL DEFAULT '0',
    cost_center_code        VARCHAR(20),
    customer_type           VARCHAR(50) NOT NULL DEFAULT 'NORMAL',
    region                  VARCHAR(5) NOT NULL DEFAULT 'AE',
    currency                VARCHAR(3),
    timezone_offset         DECIMAL(4,2) DEFAULT 0,

    -- Receivables Activity Names
    rec_activity_name_bank  VARCHAR(50),
    rec_activity_name_cash  VARCHAR(50),

    -- Payment & Tax Configuration (JSON)
    default_payment_type    VARCHAR(50) DEFAULT 'Cash',
    tax_name                VARCHAR(50),
    receipt_method_meta     JSONB,
    journal_meta            JSONB,
    uom_code_map            JSONB,

    is_active               BOOLEAN NOT NULL DEFAULT TRUE,
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_rate_is_corporate CHECK (rate_is_corporate IN ('0', '1'))
);

CREATE INDEX idx_store_oracle_store_name ON store_oracle_metadata(store_name);
CREATE INDEX idx_store_oracle_region ON store_oracle_metadata(region);
CREATE INDEX idx_store_oracle_customer_type ON store_oracle_metadata(customer_type);
CREATE INDEX idx_store_oracle_active ON store_oracle_metadata(is_active) WHERE is_active = TRUE;

COMMENT ON TABLE store_oracle_metadata IS 'Per-store Oracle Fusion configuration and billing identities';

-- Fusion sales metadata (reference data from CSV)
CREATE TABLE fusion_sales_metadata (
    id                      SERIAL PRIMARY KEY,
    row_id                  INT,
    subinventory            VARCHAR(50) NOT NULL,
    customer_type           VARCHAR(50) NOT NULL,

    bill_to_name            VARCHAR(200),
    bill_to_account         VARCHAR(50),
    site_number             VARCHAR(50),
    business_unit           VARCHAR(100),
    txn_source              VARCHAR(50),
    txn_type                VARCHAR(50),
    rate_is_corporate       CHAR(1) DEFAULT '1',

    rec_activity_name_bank  VARCHAR(50),
    rec_activity_name_cash  VARCHAR(50),
    integration_source      VARCHAR(50),
    distribution_acc_id     VARCHAR(50),
    region                  VARCHAR(5),
    cost_center_code        VARCHAR(20),

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_fusion_meta_key UNIQUE (subinventory, customer_type)
);

CREATE INDEX idx_fusion_meta_lookup ON fusion_sales_metadata(subinventory, customer_type);
CREATE INDEX idx_fusion_meta_region ON fusion_sales_metadata(region);

COMMENT ON TABLE fusion_sales_metadata IS 'Oracle Fusion billing identity reference data (seeded from CSV)';

-- Fusion receipt payment methods
CREATE TABLE fusion_receipt_methods (
    id                      SERIAL PRIMARY KEY,
    receipt_method_id       INT NOT NULL,
    receipt_method_name     VARCHAR(50) NOT NULL,
    region                  VARCHAR(5) NOT NULL,

    receipt_is_cash         CHAR(1) NOT NULL DEFAULT '0',
    receipt_bank_charge     DECIMAL(10,4) DEFAULT 0,
    receipt_method_tax      DECIMAL(10,4) DEFAULT 0,

    is_active               BOOLEAN NOT NULL DEFAULT TRUE,
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_receipt_method UNIQUE (receipt_method_id, receipt_method_name, region),
    CONSTRAINT chk_receipt_is_cash CHECK (receipt_is_cash IN ('0', '1'))
);

CREATE INDEX idx_receipt_methods_region ON fusion_receipt_methods(region, receipt_method_name);

-- ==============================================================================
-- 4. SALES DATA (ODOO/VENDHQ)
-- ==============================================================================

-- Sale order headers
CREATE TABLE sales_orders (
    id                  BIGSERIAL PRIMARY KEY,
    odoo_id             INT NOT NULL,

    -- Order Information
    order_number        VARCHAR(100) NOT NULL,
    store_id            INT,
    store_name          VARCHAR(200),
    warehouse_id        INT,
    warehouse_name      VARCHAR(200),
    country_code        VARCHAR(5),
    region              VARCHAR(5),

    -- Customer Information
    customer_id         INT,
    customer_name       VARCHAR(200),
    customer_type       VARCHAR(50) DEFAULT 'NORMAL',
    partner_id          INT,
    partner_name        VARCHAR(200),

    -- Order Dates
    order_date          DATE NOT NULL,
    order_datetime      TIMESTAMP NOT NULL,
    delivery_date       DATE,
    invoice_date        DATE,

    -- Financial Data
    currency            VARCHAR(3) NOT NULL DEFAULT 'AED',
    amount_untaxed      DECIMAL(15,2) DEFAULT 0,
    amount_tax          DECIMAL(15,2) DEFAULT 0,
    amount_discount     DECIMAL(15,2) DEFAULT 0,
    amount_total        DECIMAL(15,2) DEFAULT 0,

    -- Order Status
    state               VARCHAR(20),
    payment_status      VARCHAR(20),
    delivery_status     VARCHAR(20),

    -- Register/POS Information
    register_name       VARCHAR(100),
    cashier_name        VARCHAR(100),
    pos_session_id      INT,

    -- Oracle Push Status
    oracle_txn_id       VARCHAR(50),
    oracle_invoice_id   BIGINT,
    oracle_customer_id  BIGINT,
    pushed_at           TIMESTAMP,
    push_job_id         VARCHAR(100),
    push_status         VARCHAR(20) DEFAULT 'PENDING',
    push_error          TEXT,
    push_retry_count    INT DEFAULT 0,

    -- Source & Tracking
    source_system       VARCHAR(20) NOT NULL DEFAULT 'ODOO',
    external_ref        VARCHAR(100),
    raw_json            JSONB,

    -- Audit Trail
    fetched_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at          TIMESTAMP,

    CONSTRAINT uq_sales_orders_odoo UNIQUE (odoo_id, source_system),
    CONSTRAINT chk_push_status CHECK (push_status IN ('PENDING', 'PROCESSING', 'SUCCESS', 'FAILED', 'RETRY'))
);

-- Indexes for sales_orders
CREATE INDEX idx_sales_orders_order_date ON sales_orders(order_date DESC);
CREATE INDEX idx_sales_orders_store ON sales_orders(store_id, order_date DESC);
CREATE INDEX idx_sales_orders_country ON sales_orders(country_code, order_date DESC);
CREATE INDEX idx_sales_orders_oracle_txn ON sales_orders(oracle_txn_id) WHERE oracle_txn_id IS NOT NULL;
CREATE INDEX idx_sales_orders_push_status ON sales_orders(push_status, order_date DESC);
CREATE INDEX idx_sales_orders_push_job ON sales_orders(push_job_id) WHERE push_job_id IS NOT NULL;
CREATE INDEX idx_sales_orders_customer ON sales_orders(customer_id, order_date DESC);
CREATE INDEX idx_sales_orders_deleted ON sales_orders(deleted_at) WHERE deleted_at IS NULL;

COMMENT ON TABLE sales_orders IS 'Sale order headers from Odoo/VendHQ POS systems';

-- Sale order line items
CREATE TABLE sales_order_lines (
    id                  BIGSERIAL PRIMARY KEY,
    sale_id             BIGINT NOT NULL REFERENCES sales_orders(id) ON DELETE CASCADE,
    odoo_line_id        INT NOT NULL,
    line_number         INT NOT NULL,

    -- Product Information
    product_id          INT,
    product_name        VARCHAR(500),
    item_number         VARCHAR(100),
    sku                 VARCHAR(100),
    barcode             VARCHAR(100),

    -- Quantity & UOM
    qty_ordered         DECIMAL(15,3) DEFAULT 0,
    qty_delivered       DECIMAL(15,3) DEFAULT 0,
    qty_invoiced        DECIMAL(15,3) DEFAULT 0,
    uom                 VARCHAR(20),
    uom_code            VARCHAR(10),

    -- Pricing
    price_unit          DECIMAL(15,4) DEFAULT 0,
    price_subtotal      DECIMAL(15,2) DEFAULT 0,
    price_total         DECIMAL(15,2) DEFAULT 0,
    discount_amount     DECIMAL(15,2) DEFAULT 0,
    discount_percent    DECIMAL(5,2) DEFAULT 0,

    -- Tax Information
    tax_ids             VARCHAR(200),
    tax_name            VARCHAR(100),
    tax_amount          DECIMAL(15,2) DEFAULT 0,
    tax_rate            DECIMAL(5,2) DEFAULT 0,

    -- Loyalty & Promotions
    loyalty_value       DECIMAL(15,2) DEFAULT 0,
    loyalty_points      DECIMAL(15,2) DEFAULT 0,
    promotion_id        VARCHAR(50),
    promotion_name      VARCHAR(200),

    -- Oracle Push Status
    oracle_line_id      BIGINT,
    pushed_at           TIMESTAMP,

    -- Audit Trail
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_sales_order_lines_odoo UNIQUE (odoo_line_id)
);

CREATE INDEX idx_sales_order_lines_sale ON sales_order_lines(sale_id);
CREATE INDEX idx_sales_order_lines_product ON sales_order_lines(product_id);
CREATE INDEX idx_sales_order_lines_sku ON sales_order_lines(item_number);

COMMENT ON TABLE sales_order_lines IS 'Line items for each sale order';

-- Sale payments
CREATE TABLE sales_payments (
    id                  BIGSERIAL PRIMARY KEY,
    sale_id             BIGINT REFERENCES sales_orders(id) ON DELETE CASCADE,
    invoice_number      VARCHAR(100) NOT NULL,
    odoo_payment_id     INT NOT NULL,

    -- Payment Information
    payment_type        VARCHAR(100),
    payment_method      VARCHAR(100),
    amount              DECIMAL(15,2) NOT NULL DEFAULT 0,
    currency            VARCHAR(3) DEFAULT 'AED',

    -- Payment Dates
    payment_date        DATE,
    payment_datetime    TIMESTAMP,

    -- Location Information
    outlet_name         VARCHAR(200),
    register_name       VARCHAR(100),
    region              VARCHAR(5),

    -- Oracle Receipt Information
    oracle_receipt_id   BIGINT,
    receipt_number      VARCHAR(50),
    receipt_method_id   INT,
    pushed_at           TIMESTAMP,

    -- Bank & Card Details
    bank_name           VARCHAR(100),
    card_type           VARCHAR(50),
    card_last4          VARCHAR(4),
    transaction_ref     VARCHAR(100),

    -- Audit Trail
    fetched_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at          TIMESTAMP,

    CONSTRAINT uq_sales_payments_odoo UNIQUE (odoo_payment_id)
);

CREATE INDEX idx_sales_payments_sale ON sales_payments(sale_id);
CREATE INDEX idx_sales_payments_invoice ON sales_payments(invoice_number);
CREATE INDEX idx_sales_payments_date ON sales_payments(payment_date DESC);
CREATE INDEX idx_sales_payments_type ON sales_payments(payment_type, payment_date DESC);
CREATE INDEX idx_sales_payments_region ON sales_payments(region, payment_date DESC);

COMMENT ON TABLE sales_payments IS 'Payment transactions for sales orders';

-- ==============================================================================
-- 5. ORACLE FUSION INTEGRATION TRACKING
-- ==============================================================================

-- Oracle Invoice Headers
CREATE TABLE oracle_invoices (
    id                      BIGSERIAL PRIMARY KEY,
    sale_id                 BIGINT REFERENCES sales_orders(id) ON DELETE SET NULL,
    request_id              BIGINT NOT NULL,

    -- Oracle Invoice Details
    oracle_txn_id           BIGINT,
    customer_txn_id         BIGINT,
    invoice_number          VARCHAR(100),

    -- Customer Information
    bill_to_customer_name   VARCHAR(200),
    bill_to_location        VARCHAR(200),
    bill_to_account         VARCHAR(50),
    customer_id             BIGINT,
    org_id                  BIGINT,

    -- Invoice Details
    business_unit           VARCHAR(100),
    payment_terms_name      VARCHAR(50),
    txn_source              VARCHAR(100),
    txn_type                VARCHAR(100),
    txn_date                DATE NOT NULL,
    gl_date                 DATE NOT NULL,

    -- Amounts
    currency_code           VARCHAR(3) NOT NULL,
    invoice_amount          DECIMAL(15,2),
    tax_amount              DECIMAL(15,2),
    total_amount            DECIMAL(15,2),

    -- Status
    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_oracle_invoice_status CHECK (status IN ('PENDING', 'SUCCESS', 'FAILED', 'RETRY'))
);

CREATE INDEX idx_oracle_invoices_sale ON oracle_invoices(sale_id);
CREATE INDEX idx_oracle_invoices_txn ON oracle_invoices(oracle_txn_id);
CREATE INDEX idx_oracle_invoices_request ON oracle_invoices(request_id, status);
CREATE INDEX idx_oracle_invoices_region ON oracle_invoices(region, txn_date DESC);

-- Oracle Invoice Lines
CREATE TABLE oracle_invoice_lines (
    id                      BIGSERIAL PRIMARY KEY,
    invoice_id              BIGINT REFERENCES oracle_invoices(id) ON DELETE CASCADE,
    sale_line_id            BIGINT REFERENCES sales_order_lines(id) ON DELETE SET NULL,
    request_id              BIGINT NOT NULL,

    invoice_number          VARCHAR(100),
    line_number             INT NOT NULL,

    -- Product Details
    item_number             VARCHAR(100),
    description             VARCHAR(500),
    uom                     VARCHAR(20),

    -- Quantity & Pricing
    quantity                DECIMAL(15,3),
    unit_selling_price      DECIMAL(15,4),
    line_amount             DECIMAL(15,2),

    -- Tax & Accounting
    currency_code           VARCHAR(3),
    tax_code                VARCHAR(50),

    -- Order Reference
    sales_order             VARCHAR(100),
    sales_order_line        INT,

    -- Status
    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    version                 INT DEFAULT 1,
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_invoice_lines_invoice ON oracle_invoice_lines(invoice_id);
CREATE INDEX idx_oracle_invoice_lines_sale_line ON oracle_invoice_lines(sale_line_id);
CREATE INDEX idx_oracle_invoice_lines_request ON oracle_invoice_lines(request_id, status);

-- Oracle Standard Receipts
CREATE TABLE oracle_standard_receipts (
    id                      BIGSERIAL PRIMARY KEY,
    payment_id              BIGINT REFERENCES sales_payments(id) ON DELETE SET NULL,
    request_id              BIGINT NOT NULL,

    -- Receipt Details
    receipt_number          VARCHAR(50),
    receipt_method_id       INT,
    receipt_date            DATE NOT NULL,
    gl_date                 DATE NOT NULL,
    deposit_date            DATE,

    -- Customer & Bank
    customer_id             BIGINT,
    org_id                  BIGINT,
    remittance_bank_acc_id  VARCHAR(50),

    -- Amount & Currency
    amount                  DECIMAL(15,2) NOT NULL,
    currency_code           VARCHAR(3) NOT NULL,
    exchange_date           DATE,
    exchange_rate_type      VARCHAR(50),
    exchange_rate           DECIMAL(15,6),

    -- Status
    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    integration_mode        VARCHAR(20) DEFAULT 'STANDARD',
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_receipts_payment ON oracle_standard_receipts(payment_id);
CREATE INDEX idx_oracle_receipts_request ON oracle_standard_receipts(request_id, status);
CREATE INDEX idx_oracle_receipts_region ON oracle_standard_receipts(region, receipt_date DESC);

-- Oracle Miscellaneous Receipts (bank charges)
CREATE TABLE oracle_misc_receipts (
    id                      BIGSERIAL PRIMARY KEY,
    request_id              BIGINT NOT NULL,

    receipt_number          VARCHAR(50),
    receipt_method_name     VARCHAR(50),
    receipt_date            DATE NOT NULL,
    gl_date                 DATE NOT NULL,

    bank_account_number     VARCHAR(100),
    rec_activity_name       VARCHAR(50),

    amount                  DECIMAL(15,2) NOT NULL,
    currency_code           VARCHAR(3) NOT NULL,
    exchange_date           DATE,
    exchange_rate_type      VARCHAR(50),

    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    integration_mode        VARCHAR(20) DEFAULT 'MISC',
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_misc_receipts_request ON oracle_misc_receipts(request_id, status);
CREATE INDEX idx_oracle_misc_receipts_region ON oracle_misc_receipts(region, receipt_date DESC);

-- Oracle Receipt Applications (link receipts to invoices)
CREATE TABLE oracle_receipt_applications (
    id                      BIGSERIAL PRIMARY KEY,
    receipt_id              BIGINT REFERENCES oracle_standard_receipts(id) ON DELETE CASCADE,
    invoice_id              BIGINT REFERENCES oracle_invoices(id) ON DELETE CASCADE,
    request_id              BIGINT NOT NULL,

    oracle_txn_id           BIGINT,
    receipt_number          VARCHAR(50),
    application_date        DATE NOT NULL,
    accounting_date         DATE NOT NULL,

    amount_applied          DECIMAL(15,2) NOT NULL,
    currency_code           VARCHAR(3) NOT NULL,

    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    txn_source              VARCHAR(50),
    integration_mode        VARCHAR(20) DEFAULT 'APPLY',
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_receipt_apps_receipt ON oracle_receipt_applications(receipt_id);
CREATE INDEX idx_oracle_receipt_apps_invoice ON oracle_receipt_applications(invoice_id);
CREATE INDEX idx_oracle_receipt_apps_request ON oracle_receipt_applications(request_id, status);

-- Oracle Inventory Transactions
CREATE TABLE oracle_inventory_transactions (
    id                      BIGSERIAL PRIMARY KEY,
    sale_line_id            BIGINT REFERENCES sales_order_lines(id) ON DELETE SET NULL,
    request_id              BIGINT NOT NULL,

    organization_name       VARCHAR(100),
    item_number             VARCHAR(100),
    txn_source_name         VARCHAR(100),
    subinventory            VARCHAR(50),

    txn_uom                 VARCHAR(20),
    txn_date                DATE NOT NULL,
    txn_qty                 DECIMAL(15,3) NOT NULL,
    txn_type                VARCHAR(50),

    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    integration_mode        VARCHAR(20) DEFAULT 'INV_TXN',
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_inv_txn_sale_line ON oracle_inventory_transactions(sale_line_id);
CREATE INDEX idx_oracle_inv_txn_request ON oracle_inventory_transactions(request_id, status);
CREATE INDEX idx_oracle_inv_txn_region ON oracle_inventory_transactions(region, txn_date DESC);

-- Oracle Journal Entries (for service providers)
CREATE TABLE oracle_journal_headers (
    id                      BIGSERIAL PRIMARY KEY,
    sale_id                 BIGINT REFERENCES sales_orders(id) ON DELETE SET NULL,
    request_id              BIGINT NOT NULL,

    je_header_id            BIGINT,
    ledger_id               BIGINT,
    batch_name              VARCHAR(100),
    batch_description       VARCHAR(500),

    accounting_period_name  VARCHAR(100),
    user_source_name        VARCHAR(100),
    user_category_name      VARCHAR(100),
    accounting_date         DATE NOT NULL,

    oracle_txn_id           BIGINT,
    customer_type           VARCHAR(50),
    cash_credit             VARCHAR(20),

    error_to_suspense_flag  CHAR(1) DEFAULT '0',
    summary_flag            CHAR(1) DEFAULT '0',

    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    integration_mode        VARCHAR(20) DEFAULT 'JOURNAL',
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_journal_hdrs_sale ON oracle_journal_headers(sale_id);
CREATE INDEX idx_oracle_journal_hdrs_request ON oracle_journal_headers(request_id, status);
CREATE INDEX idx_oracle_journal_hdrs_region ON oracle_journal_headers(region, accounting_date DESC);

-- Oracle Journal Lines
CREATE TABLE oracle_journal_lines (
    id                      BIGSERIAL PRIMARY KEY,
    journal_header_id       BIGINT REFERENCES oracle_journal_headers(id) ON DELETE CASCADE,
    request_id              BIGINT NOT NULL,

    je_line_num             INT NOT NULL,
    ledger_id               BIGINT,
    chart_of_accounts_id    BIGINT,

    -- Debit/Credit Amounts
    entered_dr_amount       DECIMAL(15,2) DEFAULT 0,
    entered_cr_amount       DECIMAL(15,2) DEFAULT 0,
    accounted_dr            DECIMAL(15,2) DEFAULT 0,
    accounted_cr            DECIMAL(15,2) DEFAULT 0,

    -- Currency & Conversion
    currency_code           VARCHAR(3),
    currency_conversion_rate DECIMAL(15,6),
    currency_conversion_type VARCHAR(50),
    currency_conversion_date DATE,

    -- Account Segments (flexible for different chart structures)
    segment1                VARCHAR(50),
    segment2                VARCHAR(50),
    segment3                VARCHAR(50),
    segment4                VARCHAR(50),
    segment5                VARCHAR(50),
    segment6                VARCHAR(50),
    segment7                VARCHAR(50),
    segment8                VARCHAR(50),
    segment9                VARCHAR(50),
    segment10               VARCHAR(50),

    -- Accounting Period
    period_name             VARCHAR(50),
    accounting_period_name  VARCHAR(100),
    accounting_date         DATE,
    transaction_date        DATE,

    -- References
    sales_order             VARCHAR(100),
    oracle_txn_id           BIGINT,

    status                  VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    error_message           TEXT,

    region                  VARCHAR(5),
    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_oracle_journal_lines_header ON oracle_journal_lines(journal_header_id);
CREATE INDEX idx_oracle_journal_lines_request ON oracle_journal_lines(request_id, status);

-- ==============================================================================
-- 6. JOB & SYNC MANAGEMENT
-- ==============================================================================

-- Sync jobs (fetch from Odoo, push to Oracle, retry failures)
CREATE TABLE sync_jobs (
    id                  BIGSERIAL PRIMARY KEY,
    job_id              VARCHAR(100) NOT NULL UNIQUE,
    job_type            VARCHAR(20) NOT NULL DEFAULT 'PUSH',
    mode                VARCHAR(50) NOT NULL,

    -- Date Range
    date_from           DATE,
    date_to             DATE,

    -- Store/Country Filter
    store_id            INT,
    store_name          VARCHAR(200),
    country_code        VARCHAR(5),

    -- Job Status
    status              VARCHAR(20) NOT NULL DEFAULT 'QUEUED',
    priority            INT NOT NULL DEFAULT 5,

    -- Progress Tracking
    total_records       INT DEFAULT 0,
    processed_records   INT DEFAULT 0,
    success_records     INT DEFAULT 0,
    failed_records      INT DEFAULT 0,
    skipped_records     INT DEFAULT 0,

    -- Performance Metrics
    started_at          TIMESTAMP,
    finished_at         TIMESTAMP,
    duration_seconds    INT,
    records_per_second  DECIMAL(10,2),

    -- Error Information
    error_message       TEXT,
    error_stack         TEXT,

    -- User & Scheduling
    created_by_user_id  INT REFERENCES users(id) ON DELETE SET NULL,
    scheduled_at        TIMESTAMP,
    next_retry_at       TIMESTAMP,
    retry_count         INT DEFAULT 0,
    max_retries         INT DEFAULT 3,

    -- Audit Trail
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_job_type CHECK (job_type IN ('FETCH', 'PUSH', 'RETRY', 'SYNC')),
    CONSTRAINT chk_job_status CHECK (status IN ('QUEUED', 'RUNNING', 'DONE', 'FAILED', 'CANCELLED', 'RETRY'))
);

CREATE INDEX idx_sync_jobs_status ON sync_jobs(status, created_at DESC);
CREATE INDEX idx_sync_jobs_type ON sync_jobs(job_type, status);
CREATE INDEX idx_sync_jobs_date_range ON sync_jobs(date_from, date_to);
CREATE INDEX idx_sync_jobs_store ON sync_jobs(store_id);
CREATE INDEX idx_sync_jobs_country ON sync_jobs(country_code);
CREATE INDEX idx_sync_jobs_next_retry ON sync_jobs(next_retry_at) WHERE next_retry_at IS NOT NULL;

COMMENT ON TABLE sync_jobs IS 'Background jobs for data synchronization';

-- Job logs (structured logging per job)
CREATE TABLE job_logs (
    id                  BIGSERIAL PRIMARY KEY,
    job_id              VARCHAR(100) NOT NULL,
    level               VARCHAR(10) NOT NULL DEFAULT 'info',
    message             TEXT NOT NULL,
    meta_json           JSONB,
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_log_level CHECK (level IN ('debug', 'info', 'warn', 'error'))
);

CREATE INDEX idx_job_logs_job ON job_logs(job_id, created_at DESC);
CREATE INDEX idx_job_logs_level ON job_logs(level, created_at DESC);
CREATE INDEX idx_job_logs_created ON job_logs(created_at DESC);

-- Failed records (for retry processing)
CREATE TABLE failed_records (
    id                  BIGSERIAL PRIMARY KEY,
    job_id              VARCHAR(100) NOT NULL,

    -- Record Identification
    sale_id             BIGINT REFERENCES sales_orders(id) ON DELETE SET NULL,
    sale_name           VARCHAR(100),
    odoo_id             INT,
    record_type         VARCHAR(50) NOT NULL,

    -- Failure Details
    error_message       TEXT,
    error_detail        TEXT,
    error_code          VARCHAR(50),
    failure_stage       VARCHAR(50),

    -- Retry Information
    retry_count         INT NOT NULL DEFAULT 0,
    max_retries         INT NOT NULL DEFAULT 3,
    last_retry_at       TIMESTAMP,
    next_retry_at       TIMESTAMP,

    -- Status
    status              VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    resolved_at         TIMESTAMP,
    resolved_by_user_id INT REFERENCES users(id) ON DELETE SET NULL,
    resolution_note     TEXT,

    -- Audit Trail
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_failed_status CHECK (status IN ('PENDING', 'RETRY', 'RESOLVED', 'SKIPPED', 'ABANDONED'))
);

CREATE INDEX idx_failed_records_job ON failed_records(job_id);
CREATE INDEX idx_failed_records_sale ON failed_records(sale_id);
CREATE INDEX idx_failed_records_status ON failed_records(status);
CREATE INDEX idx_failed_records_next_retry ON failed_records(next_retry_at) WHERE next_retry_at IS NOT NULL;

-- ==============================================================================
-- 7. REPORTING & ANALYTICS
-- ==============================================================================

-- Pre-aggregated daily statistics for fast dashboards
CREATE TABLE daily_stats (
    id                      BIGSERIAL PRIMARY KEY,
    stat_date               DATE NOT NULL,
    country_code            VARCHAR(5),
    region                  VARCHAR(5),
    store_id                INT,

    -- Sales Metrics
    total_orders            INT DEFAULT 0,
    total_order_lines       INT DEFAULT 0,
    total_amount_untaxed    DECIMAL(15,2) DEFAULT 0,
    total_amount_tax        DECIMAL(15,2) DEFAULT 0,
    total_amount_total      DECIMAL(15,2) DEFAULT 0,
    avg_order_value         DECIMAL(15,2) DEFAULT 0,

    -- Oracle Push Metrics
    orders_pushed           INT DEFAULT 0,
    orders_pending          INT DEFAULT 0,
    orders_failed           INT DEFAULT 0,
    push_success_rate       DECIMAL(5,2) DEFAULT 0,

    -- Payment Metrics
    total_payments          INT DEFAULT 0,
    total_payment_amount    DECIMAL(15,2) DEFAULT 0,

    created_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_daily_stats UNIQUE (stat_date, country_code, store_id)
);

CREATE INDEX idx_daily_stats_date ON daily_stats(stat_date DESC);
CREATE INDEX idx_daily_stats_country ON daily_stats(country_code, stat_date DESC);
CREATE INDEX idx_daily_stats_store ON daily_stats(store_id, stat_date DESC);

COMMENT ON TABLE daily_stats IS 'Pre-aggregated daily metrics for dashboard performance';

-- ==============================================================================
-- 8. TRIGGERS & FUNCTIONS
-- ==============================================================================

-- Trigger function for updated_at timestamp
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Apply updated_at trigger to all tables with that column
CREATE TRIGGER update_users_updated_at BEFORE UPDATE ON users FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_app_settings_updated_at BEFORE UPDATE ON app_settings FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_country_configs_updated_at BEFORE UPDATE ON country_configs FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_store_oracle_metadata_updated_at BEFORE UPDATE ON store_oracle_metadata FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_fusion_sales_metadata_updated_at BEFORE UPDATE ON fusion_sales_metadata FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_sales_orders_updated_at BEFORE UPDATE ON sales_orders FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_sales_order_lines_updated_at BEFORE UPDATE ON sales_order_lines FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_sales_payments_updated_at BEFORE UPDATE ON sales_payments FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_sync_jobs_updated_at BEFORE UPDATE ON sync_jobs FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_failed_records_updated_at BEFORE UPDATE ON failed_records FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_daily_stats_updated_at BEFORE UPDATE ON daily_stats FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- ==============================================================================
-- 9. VIEWS FOR COMMON QUERIES
-- ==============================================================================

-- Recent sales with push status
CREATE OR REPLACE VIEW v_recent_sales_summary AS
SELECT
    s.id,
    s.order_number,
    s.order_date,
    s.store_name,
    s.country_code,
    s.customer_name,
    s.amount_total,
    s.currency,
    s.push_status,
    s.oracle_txn_id,
    s.pushed_at,
    COUNT(l.id) as line_count,
    COUNT(p.id) as payment_count
FROM sales_orders s
LEFT JOIN sales_order_lines l ON s.id = l.sale_id
LEFT JOIN sales_payments p ON s.id = p.sale_id
WHERE s.deleted_at IS NULL
GROUP BY s.id, s.order_number, s.order_date, s.store_name, s.country_code,
         s.customer_name, s.amount_total, s.currency, s.push_status,
         s.oracle_txn_id, s.pushed_at
ORDER BY s.order_date DESC, s.id DESC;

-- Job status summary
CREATE OR REPLACE VIEW v_job_status_summary AS
SELECT
    job_type,
    status,
    COUNT(*) as job_count,
    SUM(total_records) as total_records,
    SUM(processed_records) as processed_records,
    SUM(failed_records) as failed_records,
    AVG(duration_seconds) as avg_duration_seconds,
    MAX(created_at) as last_job_at
FROM sync_jobs
GROUP BY job_type, status;

-- ==============================================================================
-- 10. PARTITIONING SETUP (OPTIONAL - FOR LARGE DATASETS)
-- ==============================================================================

-- For PostgreSQL 11+, partition sales_orders by order_date for better performance
-- Uncomment the following to enable partitioning:

/*
-- Drop existing sales_orders table and recreate as partitioned
ALTER TABLE sales_orders RENAME TO sales_orders_old;

CREATE TABLE sales_orders (
    -- ... same columns as above ...
) PARTITION BY RANGE (order_date);

-- Create monthly partitions (example for 2026)
CREATE TABLE sales_orders_2026_01 PARTITION OF sales_orders
    FOR VALUES FROM ('2026-01-01') TO ('2026-02-01');
CREATE TABLE sales_orders_2026_02 PARTITION OF sales_orders
    FOR VALUES FROM ('2026-02-01') TO ('2026-03-01');
-- ... create more partitions as needed ...

-- Migrate data from old table
INSERT INTO sales_orders SELECT * FROM sales_orders_old;
DROP TABLE sales_orders_old;
*/

-- ==============================================================================
-- SCHEMA VERSION & METADATA
-- ==============================================================================

INSERT INTO app_settings (key, value, value_type, description)
VALUES
    ('schema_version', '2.0.0', 'string', 'Database schema version'),
    ('schema_created_at', CURRENT_TIMESTAMP::TEXT, 'string', 'Schema creation timestamp'),
    ('schema_description', 'Production-ready Oracle CRM database schema', 'string', 'Schema description')
ON CONFLICT (key) DO UPDATE SET value = EXCLUDED.value, updated_at = CURRENT_TIMESTAMP;

-- ==============================================================================
-- END OF SCHEMA
-- ==============================================================================
