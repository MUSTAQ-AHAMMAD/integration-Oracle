-- Vyrooq Integration Platform - PostgreSQL Schema
-- Version: 1.0.0
-- Database: PostgreSQL 16+

-- Enable required extensions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pg_partman";

-- ============================================================================
-- AUDIT AND EVENT SOURCING TABLES
-- ============================================================================

-- Audit events table (partitioned by created_at)
CREATE TABLE audit_events (
    event_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    aggregate_id TEXT NOT NULL,
    aggregate_type TEXT NOT NULL,
    event_type TEXT NOT NULL,
    event_payload JSONB NOT NULL,
    event_metadata JSONB,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    correlation_id UUID NOT NULL,
    causation_id UUID,
    user_id TEXT,
    INDEX idx_audit_agg (aggregate_id, created_at DESC),
    INDEX idx_audit_corr (correlation_id),
    INDEX idx_audit_type (aggregate_type, event_type),
    INDEX idx_audit_created (created_at DESC)
) PARTITION BY RANGE (created_at);

-- Create monthly partitions for audit_events
CREATE TABLE audit_events_2024_01 PARTITION OF audit_events
    FOR VALUES FROM ('2024-01-01') TO ('2024-02-01');
CREATE TABLE audit_events_2024_02 PARTITION OF audit_events
    FOR VALUES FROM ('2024-02-01') TO ('2024-03-01');
-- Additional partitions will be auto-created by pg_partman

-- ============================================================================
-- IDEMPOTENCY AND DEDUPLICATION
-- ============================================================================

CREATE TABLE idempotency_keys (
    idempotency_key TEXT PRIMARY KEY,
    request_hash TEXT NOT NULL,
    response_payload JSONB,
    status TEXT NOT NULL CHECK (status IN ('processing', 'completed', 'failed')),
    created_at TIMESTAMPTZ DEFAULT NOW(),
    expires_at TIMESTAMPTZ DEFAULT NOW() + INTERVAL '24 hours',
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_idem_exp (expires_at),
    INDEX idx_idem_status (status, created_at DESC)
);

-- Transaction fingerprints for duplicate detection
CREATE TABLE transaction_fingerprints (
    fingerprint TEXT PRIMARY KEY,
    transaction_id TEXT NOT NULL,
    transaction_type TEXT NOT NULL,
    source_system TEXT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_txn_fp_created (created_at DESC)
);

-- ============================================================================
-- SALES AND INVOICES (Partitioned by sale_date)
-- ============================================================================

CREATE TABLE sales (
    sale_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    invoice_number TEXT NOT NULL,
    sale_date TIMESTAMPTZ NOT NULL,
    outlet_id TEXT NOT NULL,
    region TEXT NOT NULL,
    customer_type TEXT NOT NULL,
    currency TEXT NOT NULL,
    total_price DECIMAL(15,2) NOT NULL,
    total_tax DECIMAL(15,2),
    status TEXT NOT NULL DEFAULT 'pending',
    workflow_id TEXT,
    correlation_id UUID NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    processed_at TIMESTAMPTZ,
    error_message TEXT,
    retry_count INTEGER DEFAULT 0,
    INDEX idx_sales_invoice (invoice_number, region),
    INDEX idx_sales_outlet (outlet_id, sale_date DESC),
    INDEX idx_sales_status (status, created_at DESC),
    INDEX idx_sales_correlation (correlation_id)
) PARTITION BY RANGE (sale_date);

-- Create monthly partitions
CREATE TABLE sales_2024_01 PARTITION OF sales
    FOR VALUES FROM ('2024-01-01') TO ('2024-02-01');
CREATE TABLE sales_2024_02 PARTITION OF sales
    FOR VALUES FROM ('2024-02-01') TO ('2024-03-01');

CREATE TABLE sale_line_items (
    line_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sale_id UUID NOT NULL REFERENCES sales(sale_id) ON DELETE CASCADE,
    line_number INTEGER NOT NULL,
    item_number TEXT NOT NULL,
    item_name TEXT NOT NULL,
    quantity DECIMAL(10,2) NOT NULL,
    unit_selling_price DECIMAL(15,2) NOT NULL,
    total_price DECIMAL(15,2) NOT NULL,
    total_tax DECIMAL(15,2),
    tax_name TEXT,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_line_sale (sale_id, line_number),
    INDEX idx_line_item (item_number)
);

CREATE TABLE sale_payments (
    payment_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sale_id UUID NOT NULL REFERENCES sales(sale_id) ON DELETE CASCADE,
    payment_type TEXT NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    currency TEXT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_payment_sale (sale_id)
);

-- ============================================================================
-- FUSION INTEGRATION TRACKING
-- ============================================================================

CREATE TABLE fusion_invoices (
    fusion_invoice_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sale_id UUID NOT NULL REFERENCES sales(sale_id),
    transaction_number TEXT,
    customer_trx_id BIGINT,
    invoice_date DATE NOT NULL,
    business_unit TEXT NOT NULL,
    bill_to_customer TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'pending',
    fusion_response JSONB,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_fusion_inv_sale (sale_id),
    INDEX idx_fusion_inv_txn (transaction_number),
    INDEX idx_fusion_inv_status (status, created_at DESC)
);

CREATE TABLE fusion_receipts (
    fusion_receipt_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sale_id UUID NOT NULL REFERENCES sales(sale_id),
    fusion_invoice_id UUID REFERENCES fusion_invoices(fusion_invoice_id),
    receipt_number TEXT NOT NULL,
    receipt_type TEXT NOT NULL CHECK (receipt_type IN ('standard', 'miscellaneous')),
    receipt_amount DECIMAL(15,2) NOT NULL,
    receipt_method TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'pending',
    fusion_response JSONB,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_fusion_rec_sale (sale_id),
    INDEX idx_fusion_rec_num (receipt_number),
    INDEX idx_fusion_rec_status (status)
);

CREATE TABLE fusion_inventory_transactions (
    inv_txn_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sale_id UUID NOT NULL REFERENCES sales(sale_id),
    item_number TEXT NOT NULL,
    transaction_type TEXT NOT NULL,
    transaction_quantity DECIMAL(10,2) NOT NULL,
    organization_name TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'pending',
    fusion_response JSONB,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_inv_txn_sale (sale_id),
    INDEX idx_inv_txn_item (item_number)
);

CREATE TABLE fusion_journal_entries (
    journal_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sale_id UUID NOT NULL REFERENCES sales(sale_id),
    journal_name TEXT NOT NULL,
    ledger_name TEXT NOT NULL,
    accounting_date DATE NOT NULL,
    status TEXT NOT NULL DEFAULT 'pending',
    fusion_response JSONB,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_journal_sale (sale_id),
    INDEX idx_journal_status (status)
);

-- ============================================================================
-- DEAD LETTER QUEUE
-- ============================================================================

CREATE TABLE dlq_records (
    dlq_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    original_message JSONB NOT NULL,
    error_message TEXT,
    error_stack TEXT,
    retry_count INTEGER DEFAULT 0,
    max_retries INTEGER DEFAULT 50,
    queue_name TEXT NOT NULL,
    failed_at TIMESTAMPTZ DEFAULT NOW(),
    last_retry_at TIMESTAMPTZ,
    resolved_at TIMESTAMPTZ,
    resolution_notes TEXT,
    INDEX idx_dlq_queue (queue_name, failed_at DESC),
    INDEX idx_dlq_retry (retry_count, max_retries)
);

-- ============================================================================
-- CONFIGURATION AND METADATA
-- ============================================================================

CREATE TABLE outlets (
    outlet_id TEXT PRIMARY KEY,
    outlet_name TEXT NOT NULL,
    region TEXT NOT NULL,
    currency TEXT NOT NULL,
    timezone_offset DECIMAL(4,2) NOT NULL,
    business_unit TEXT NOT NULL,
    enabled BOOLEAN DEFAULT true,
    metadata JSONB,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_outlet_region (region)
);

CREATE TABLE fusion_credentials (
    credential_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    base_url TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL, -- Encrypted in production
    hostname TEXT NOT NULL,
    region TEXT NOT NULL,
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE vendhq_credentials (
    credential_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    api_url TEXT NOT NULL,
    api_token TEXT NOT NULL, -- Encrypted in production
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE receipt_methods (
    receipt_method_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    method_name TEXT NOT NULL,
    method_id BIGINT NOT NULL,
    bank_charge_rate DECIMAL(5,4),
    method_tax DECIMAL(5,4),
    is_cash BOOLEAN DEFAULT false,
    region TEXT,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_receipt_method_name (method_name, region)
);

-- ============================================================================
-- WORKFLOW STATE TRACKING
-- ============================================================================

CREATE TABLE workflow_states (
    workflow_id TEXT PRIMARY KEY,
    workflow_type TEXT NOT NULL,
    aggregate_id TEXT NOT NULL,
    current_stage TEXT NOT NULL,
    status TEXT NOT NULL,
    input_data JSONB NOT NULL,
    output_data JSONB,
    error_data JSONB,
    started_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    completed_at TIMESTAMPTZ,
    INDEX idx_workflow_agg (aggregate_id),
    INDEX idx_workflow_status (status, started_at DESC)
);

-- ============================================================================
-- RECONCILIATION AND REPORTING
-- ============================================================================

CREATE TABLE reconciliation_reports (
    report_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    report_date DATE NOT NULL,
    region TEXT NOT NULL,
    outlet_id TEXT,
    total_sales INTEGER NOT NULL DEFAULT 0,
    total_invoices INTEGER NOT NULL DEFAULT 0,
    total_receipts INTEGER NOT NULL DEFAULT 0,
    discrepancies JSONB,
    status TEXT NOT NULL DEFAULT 'pending',
    created_at TIMESTAMPTZ DEFAULT NOW(),
    INDEX idx_recon_date (report_date DESC, region)
);

-- ============================================================================
-- FUNCTIONS AND TRIGGERS
-- ============================================================================

-- Function to update updated_at timestamp
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ language 'plpgsql';

-- Apply triggers to relevant tables
CREATE TRIGGER update_sales_updated_at BEFORE UPDATE ON sales
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_fusion_invoices_updated_at BEFORE UPDATE ON fusion_invoices
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_fusion_receipts_updated_at BEFORE UPDATE ON fusion_receipts
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- ============================================================================
-- INDEXES FOR PERFORMANCE
-- ============================================================================

-- Additional composite indexes for common queries
CREATE INDEX idx_sales_lookup ON sales (invoice_number, region, sale_date DESC);
CREATE INDEX idx_fusion_inv_complete ON fusion_invoices (sale_id, status, transaction_number);
CREATE INDEX idx_audit_aggregate_lookup ON audit_events (aggregate_id, aggregate_type, created_at DESC);

-- ============================================================================
-- VIEWS FOR REPORTING
-- ============================================================================

CREATE VIEW v_sales_processing_summary AS
SELECT
    s.sale_id,
    s.invoice_number,
    s.sale_date,
    s.outlet_id,
    s.region,
    s.status AS sale_status,
    fi.status AS invoice_status,
    fi.transaction_number,
    fr.status AS receipt_status,
    s.retry_count,
    s.error_message
FROM sales s
LEFT JOIN fusion_invoices fi ON s.sale_id = fi.sale_id
LEFT JOIN fusion_receipts fr ON s.sale_id = fr.sale_id;

-- ============================================================================
-- INITIAL DATA
-- ============================================================================

-- Insert sample fusion credentials (update with real values)
INSERT INTO fusion_credentials (base_url, username, password, hostname, region)
VALUES ('https://example.fa.region.oraclecloud.com', 'fusion_user', 'CHANGE_ME', 'example', 'region');

-- Insert sample receipt methods
INSERT INTO receipt_methods (method_name, method_id, bank_charge_rate, method_tax, is_cash)
VALUES
    ('Cash', 1001, 0.0, 0.0, true),
    ('Visa', 1002, 0.02, 0.05, false),
    ('Debit Card', 1003, 0.015, 0.05, false);

-- ============================================================================
-- COMMENTS
-- ============================================================================

COMMENT ON TABLE sales IS 'Main sales transaction table (partitioned by sale_date)';
COMMENT ON TABLE audit_events IS 'Event sourcing audit trail (partitioned by created_at)';
COMMENT ON TABLE idempotency_keys IS 'Idempotency keys for preventing duplicate processing';
COMMENT ON TABLE dlq_records IS 'Dead letter queue for failed transactions';
COMMENT ON TABLE workflow_states IS 'Temporal workflow state tracking';
