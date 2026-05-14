-- ══════════════════════════════════════════════════════════════════════════════
-- ORACLE CRM - MYSQL/MARIADB DATABASE SCHEMA
-- Version: 2.0
-- Date: 2026-05-14
-- Description: MySQL-optimized production-ready schema
-- ══════════════════════════════════════════════════════════════════════════════
--
-- MySQL-specific optimizations:
-- - InnoDB engine for ACID compliance and foreign keys
-- - Optimized data types (BIGINT for auto-increment, VARCHAR lengths)
-- - UTF8MB4 for full Unicode support
-- - Partitioning hints for large tables
--
-- ══════════════════════════════════════════════════════════════════════════════

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ==============================================================================
-- 1. USER MANAGEMENT & AUTHENTICATION
-- ==============================================================================

CREATE TABLE `users` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `email` VARCHAR(255) DEFAULT NULL UNIQUE,
    `password_hash` VARCHAR(255) NOT NULL,
    `role` VARCHAR(20) NOT NULL DEFAULT 'operator',
    `display_name` VARCHAR(100) DEFAULT NULL,
    `avatar_data` LONGTEXT DEFAULT NULL,
    `is_active` BOOLEAN NOT NULL DEFAULT TRUE,
    `email_verified` BOOLEAN NOT NULL DEFAULT FALSE,
    `two_factor_enabled` BOOLEAN NOT NULL DEFAULT FALSE,
    `two_factor_secret` VARCHAR(100) DEFAULT NULL,
    `failed_login_attempts` INT NOT NULL DEFAULT 0,
    `locked_until` DATETIME DEFAULT NULL,
    `last_login` DATETIME DEFAULT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` DATETIME DEFAULT NULL,

    INDEX `idx_users_role` (`role`),
    INDEX `idx_users_email` (`email`),
    INDEX `idx_users_active` (`is_active`),
    INDEX `idx_users_deleted` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='System users with role-based access control';

CREATE TABLE `user_sessions` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `session_token` VARCHAR(255) NOT NULL UNIQUE,
    `ip_address` VARCHAR(45) DEFAULT NULL,
    `user_agent` TEXT DEFAULT NULL,
    `expires_at` DATETIME NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_activity_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    INDEX `idx_user_sessions_user` (`user_id`),
    INDEX `idx_user_sessions_token` (`session_token`),
    INDEX `idx_user_sessions_expires` (`expires_at`),

    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user_activity_log` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT UNSIGNED DEFAULT NULL,
    `action_type` VARCHAR(50) NOT NULL,
    `resource_type` VARCHAR(50) DEFAULT NULL,
    `resource_id` VARCHAR(100) DEFAULT NULL,
    `ip_address` VARCHAR(45) DEFAULT NULL,
    `user_agent` TEXT DEFAULT NULL,
    `request_method` VARCHAR(10) DEFAULT NULL,
    `request_path` VARCHAR(500) DEFAULT NULL,
    `response_status` INT DEFAULT NULL,
    `details` JSON DEFAULT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    INDEX `idx_user_activity_user` (`user_id`, `created_at` DESC),
    INDEX `idx_user_activity_action` (`action_type`, `created_at` DESC),
    INDEX `idx_user_activity_created` (`created_at` DESC),

    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ==============================================================================
-- 2. CONFIGURATION & SETTINGS
-- ==============================================================================

CREATE TABLE `app_settings` (
    `key` VARCHAR(100) NOT NULL PRIMARY KEY,
    `value` TEXT DEFAULT NULL,
    `value_type` VARCHAR(20) NOT NULL DEFAULT 'string',
    `description` TEXT DEFAULT NULL,
    `is_encrypted` BOOLEAN NOT NULL DEFAULT FALSE,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Global application configuration';

CREATE TABLE `country_configs` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `country_code` VARCHAR(5) NOT NULL UNIQUE,
    `country_name` VARCHAR(100) NOT NULL,
    `currency_code` VARCHAR(3) NOT NULL DEFAULT 'AED',
    `timezone_offset` DECIMAL(4,2) NOT NULL DEFAULT 0,

    `odoo_url` VARCHAR(500) DEFAULT NULL,
    `odoo_db` VARCHAR(100) DEFAULT NULL,
    `odoo_username` VARCHAR(100) DEFAULT NULL,
    `odoo_password` VARCHAR(255) DEFAULT NULL,
    `odoo_auth_type` VARCHAR(20) NOT NULL DEFAULT 'jsonrpc',
    `odoo_api_key` VARCHAR(255) DEFAULT NULL,
    `odoo_api_url` VARCHAR(500) DEFAULT NULL,
    `odoo_version` INT NOT NULL DEFAULT 0,
    `odoo_sale_detail_path` VARCHAR(200) DEFAULT NULL,
    `odoo_order_line_path` VARCHAR(200) DEFAULT NULL,
    `odoo_payment_path` VARCHAR(200) DEFAULT NULL,
    `odoo_pos_order_path` VARCHAR(200) DEFAULT NULL,

    `oracle_base_url` VARCHAR(500) DEFAULT NULL,
    `oracle_username` VARCHAR(100) DEFAULT NULL,
    `oracle_password` VARCHAR(255) DEFAULT NULL,

    `enabled` BOOLEAN NOT NULL DEFAULT TRUE,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    INDEX `idx_country_configs_enabled` (`enabled`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Per-country ERP and Oracle connection settings';

-- ==============================================================================
-- 3. SALES DATA (ODOO/VENDHQ)
-- ==============================================================================

CREATE TABLE `sales_orders` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `odoo_id` INT NOT NULL,
    `order_number` VARCHAR(100) NOT NULL,
    `store_id` INT DEFAULT NULL,
    `store_name` VARCHAR(200) DEFAULT NULL,
    `warehouse_id` INT DEFAULT NULL,
    `warehouse_name` VARCHAR(200) DEFAULT NULL,
    `country_code` VARCHAR(5) DEFAULT NULL,
    `region` VARCHAR(5) DEFAULT NULL,

    `customer_id` INT DEFAULT NULL,
    `customer_name` VARCHAR(200) DEFAULT NULL,
    `customer_type` VARCHAR(50) DEFAULT 'NORMAL',
    `partner_id` INT DEFAULT NULL,
    `partner_name` VARCHAR(200) DEFAULT NULL,

    `order_date` DATE NOT NULL,
    `order_datetime` DATETIME NOT NULL,
    `delivery_date` DATE DEFAULT NULL,
    `invoice_date` DATE DEFAULT NULL,

    `currency` VARCHAR(3) NOT NULL DEFAULT 'AED',
    `amount_untaxed` DECIMAL(15,2) DEFAULT 0,
    `amount_tax` DECIMAL(15,2) DEFAULT 0,
    `amount_discount` DECIMAL(15,2) DEFAULT 0,
    `amount_total` DECIMAL(15,2) DEFAULT 0,

    `state` VARCHAR(20) DEFAULT NULL,
    `payment_status` VARCHAR(20) DEFAULT NULL,
    `delivery_status` VARCHAR(20) DEFAULT NULL,

    `register_name` VARCHAR(100) DEFAULT NULL,
    `cashier_name` VARCHAR(100) DEFAULT NULL,
    `pos_session_id` INT DEFAULT NULL,

    `oracle_txn_id` VARCHAR(50) DEFAULT NULL,
    `oracle_invoice_id` BIGINT DEFAULT NULL,
    `oracle_customer_id` BIGINT DEFAULT NULL,
    `pushed_at` DATETIME DEFAULT NULL,
    `push_job_id` VARCHAR(100) DEFAULT NULL,
    `push_status` VARCHAR(20) DEFAULT 'PENDING',
    `push_error` TEXT DEFAULT NULL,
    `push_retry_count` INT DEFAULT 0,

    `source_system` VARCHAR(20) NOT NULL DEFAULT 'ODOO',
    `external_ref` VARCHAR(100) DEFAULT NULL,
    `raw_json` JSON DEFAULT NULL,

    `fetched_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` DATETIME DEFAULT NULL,

    UNIQUE KEY `uq_sales_orders_odoo` (`odoo_id`, `source_system`),
    INDEX `idx_sales_orders_order_date` (`order_date` DESC),
    INDEX `idx_sales_orders_store` (`store_id`, `order_date` DESC),
    INDEX `idx_sales_orders_country` (`country_code`, `order_date` DESC),
    INDEX `idx_sales_orders_oracle_txn` (`oracle_txn_id`),
    INDEX `idx_sales_orders_push_status` (`push_status`, `order_date` DESC),
    INDEX `idx_sales_orders_push_job` (`push_job_id`),
    INDEX `idx_sales_orders_customer` (`customer_id`, `order_date` DESC),
    INDEX `idx_sales_orders_deleted` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Sale order headers from Odoo/VendHQ POS systems';

CREATE TABLE `sales_order_lines` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sale_id` BIGINT UNSIGNED NOT NULL,
    `odoo_line_id` INT NOT NULL UNIQUE,
    `line_number` INT NOT NULL,

    `product_id` INT DEFAULT NULL,
    `product_name` VARCHAR(500) DEFAULT NULL,
    `item_number` VARCHAR(100) DEFAULT NULL,
    `sku` VARCHAR(100) DEFAULT NULL,
    `barcode` VARCHAR(100) DEFAULT NULL,

    `qty_ordered` DECIMAL(15,3) DEFAULT 0,
    `qty_delivered` DECIMAL(15,3) DEFAULT 0,
    `qty_invoiced` DECIMAL(15,3) DEFAULT 0,
    `uom` VARCHAR(20) DEFAULT NULL,
    `uom_code` VARCHAR(10) DEFAULT NULL,

    `price_unit` DECIMAL(15,4) DEFAULT 0,
    `price_subtotal` DECIMAL(15,2) DEFAULT 0,
    `price_total` DECIMAL(15,2) DEFAULT 0,
    `discount_amount` DECIMAL(15,2) DEFAULT 0,
    `discount_percent` DECIMAL(5,2) DEFAULT 0,

    `tax_ids` VARCHAR(200) DEFAULT NULL,
    `tax_name` VARCHAR(100) DEFAULT NULL,
    `tax_amount` DECIMAL(15,2) DEFAULT 0,
    `tax_rate` DECIMAL(5,2) DEFAULT 0,

    `loyalty_value` DECIMAL(15,2) DEFAULT 0,
    `loyalty_points` DECIMAL(15,2) DEFAULT 0,
    `promotion_id` VARCHAR(50) DEFAULT NULL,
    `promotion_name` VARCHAR(200) DEFAULT NULL,

    `oracle_line_id` BIGINT DEFAULT NULL,
    `pushed_at` DATETIME DEFAULT NULL,

    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    INDEX `idx_sales_order_lines_sale` (`sale_id`),
    INDEX `idx_sales_order_lines_product` (`product_id`),
    INDEX `idx_sales_order_lines_sku` (`item_number`),

    FOREIGN KEY (`sale_id`) REFERENCES `sales_orders`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Line items for each sale order';

CREATE TABLE `sales_payments` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sale_id` BIGINT UNSIGNED DEFAULT NULL,
    `invoice_number` VARCHAR(100) NOT NULL,
    `odoo_payment_id` INT NOT NULL UNIQUE,

    `payment_type` VARCHAR(100) DEFAULT NULL,
    `payment_method` VARCHAR(100) DEFAULT NULL,
    `amount` DECIMAL(15,2) NOT NULL DEFAULT 0,
    `currency` VARCHAR(3) DEFAULT 'AED',

    `payment_date` DATE DEFAULT NULL,
    `payment_datetime` DATETIME DEFAULT NULL,

    `outlet_name` VARCHAR(200) DEFAULT NULL,
    `register_name` VARCHAR(100) DEFAULT NULL,
    `region` VARCHAR(5) DEFAULT NULL,

    `oracle_receipt_id` BIGINT DEFAULT NULL,
    `receipt_number` VARCHAR(50) DEFAULT NULL,
    `receipt_method_id` INT DEFAULT NULL,
    `pushed_at` DATETIME DEFAULT NULL,

    `bank_name` VARCHAR(100) DEFAULT NULL,
    `card_type` VARCHAR(50) DEFAULT NULL,
    `card_last4` VARCHAR(4) DEFAULT NULL,
    `transaction_ref` VARCHAR(100) DEFAULT NULL,

    `fetched_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` DATETIME DEFAULT NULL,

    INDEX `idx_sales_payments_sale` (`sale_id`),
    INDEX `idx_sales_payments_invoice` (`invoice_number`),
    INDEX `idx_sales_payments_date` (`payment_date` DESC),
    INDEX `idx_sales_payments_type` (`payment_type`, `payment_date` DESC),
    INDEX `idx_sales_payments_region` (`region`, `payment_date` DESC),

    FOREIGN KEY (`sale_id`) REFERENCES `sales_orders`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Payment transactions for sales orders';

-- ==============================================================================
-- 4. SYNC JOBS & LOGGING
-- ==============================================================================

CREATE TABLE `sync_jobs` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `job_id` VARCHAR(100) NOT NULL UNIQUE,
    `job_type` VARCHAR(20) NOT NULL DEFAULT 'PUSH',
    `mode` VARCHAR(50) NOT NULL,

    `date_from` DATE DEFAULT NULL,
    `date_to` DATE DEFAULT NULL,
    `store_id` INT DEFAULT NULL,
    `store_name` VARCHAR(200) DEFAULT NULL,
    `country_code` VARCHAR(5) DEFAULT NULL,

    `status` VARCHAR(20) NOT NULL DEFAULT 'QUEUED',
    `priority` INT NOT NULL DEFAULT 5,

    `total_records` INT DEFAULT 0,
    `processed_records` INT DEFAULT 0,
    `success_records` INT DEFAULT 0,
    `failed_records` INT DEFAULT 0,
    `skipped_records` INT DEFAULT 0,

    `started_at` DATETIME DEFAULT NULL,
    `finished_at` DATETIME DEFAULT NULL,
    `duration_seconds` INT DEFAULT NULL,
    `records_per_second` DECIMAL(10,2) DEFAULT NULL,

    `error_message` TEXT DEFAULT NULL,
    `error_stack` TEXT DEFAULT NULL,

    `created_by_user_id` BIGINT UNSIGNED DEFAULT NULL,
    `scheduled_at` DATETIME DEFAULT NULL,
    `next_retry_at` DATETIME DEFAULT NULL,
    `retry_count` INT DEFAULT 0,
    `max_retries` INT DEFAULT 3,

    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    INDEX `idx_sync_jobs_status` (`status`, `created_at` DESC),
    INDEX `idx_sync_jobs_type` (`job_type`, `status`),
    INDEX `idx_sync_jobs_date_range` (`date_from`, `date_to`),
    INDEX `idx_sync_jobs_store` (`store_id`),
    INDEX `idx_sync_jobs_country` (`country_code`),
    INDEX `idx_sync_jobs_next_retry` (`next_retry_at`),

    FOREIGN KEY (`created_by_user_id`) REFERENCES `users`(`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Background jobs for data synchronization';

CREATE TABLE `job_logs` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `job_id` VARCHAR(100) NOT NULL,
    `level` VARCHAR(10) NOT NULL DEFAULT 'info',
    `message` TEXT NOT NULL,
    `meta_json` JSON DEFAULT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    INDEX `idx_job_logs_job` (`job_id`, `created_at` DESC),
    INDEX `idx_job_logs_level` (`level`, `created_at` DESC),
    INDEX `idx_job_logs_created` (`created_at` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `failed_records` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `job_id` VARCHAR(100) NOT NULL,
    `sale_id` BIGINT UNSIGNED DEFAULT NULL,
    `sale_name` VARCHAR(100) DEFAULT NULL,
    `odoo_id` INT DEFAULT NULL,
    `record_type` VARCHAR(50) NOT NULL,

    `error_message` TEXT DEFAULT NULL,
    `error_detail` TEXT DEFAULT NULL,
    `error_code` VARCHAR(50) DEFAULT NULL,
    `failure_stage` VARCHAR(50) DEFAULT NULL,

    `retry_count` INT NOT NULL DEFAULT 0,
    `max_retries` INT NOT NULL DEFAULT 3,
    `last_retry_at` DATETIME DEFAULT NULL,
    `next_retry_at` DATETIME DEFAULT NULL,

    `status` VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    `resolved_at` DATETIME DEFAULT NULL,
    `resolved_by_user_id` BIGINT UNSIGNED DEFAULT NULL,
    `resolution_note` TEXT DEFAULT NULL,

    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    INDEX `idx_failed_records_job` (`job_id`),
    INDEX `idx_failed_records_sale` (`sale_id`),
    INDEX `idx_failed_records_status` (`status`),
    INDEX `idx_failed_records_next_retry` (`next_retry_at`),

    FOREIGN KEY (`sale_id`) REFERENCES `sales_orders`(`id`) ON DELETE SET NULL,
    FOREIGN KEY (`resolved_by_user_id`) REFERENCES `users`(`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ==============================================================================
-- INITIAL DATA
-- ==============================================================================

INSERT INTO `app_settings` (`key`, `value`, `value_type`, `description`)
VALUES
    ('schema_version', '2.0.0', 'string', 'Database schema version'),
    ('schema_created_at', NOW(), 'string', 'Schema creation timestamp'),
    ('schema_description', 'Production-ready Oracle CRM MySQL database schema', 'string', 'Schema description');

SET FOREIGN_KEY_CHECKS = 1;

-- ==============================================================================
-- END OF MYSQL SCHEMA
-- ==============================================================================
