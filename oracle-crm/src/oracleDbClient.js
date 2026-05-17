'use strict';

/**
 * oracleDbClient.js
 *
 * Oracle database client for reading fusion metadata directly from Oracle database.
 * This allows the middleware to query sales metadata and store mappings from the
 * same Oracle database where the original data resides, instead of relying solely
 * on CSV exports.
 *
 * Connection configuration is stored in app_settings:
 *   - oracle_db_host
 *   - oracle_db_port
 *   - oracle_db_service_name
 *   - oracle_db_username
 *   - oracle_db_password
 *   - oracle_db_role (optional: SYSDBA, SYSOPER for privileged connections)
 *   - oracle_db_enabled
 *
 * Example configuration for connecting as SYS with SYSDBA role:
 *   Host: 193.122.68.27
 *   Port: 1521
 *   Service Name: TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com
 *   Username: SYS
 *   Password: <your-password>
 *   Role: SYSDBA
 */

const oracledb = require('oracledb');
const logger   = require('./logger').child('OracleDB');
const os       = require('os');
const path     = require('path');

// Oracle client configuration
oracledb.outFormat = oracledb.OUT_FORMAT_OBJECT;
oracledb.fetchAsString = [oracledb.CLOB];

// Initialize Oracle Client for Windows
// This is required when using Oracle Instant Client on Windows
try {
  // Only initialize if not already initialized and on Windows
  if (os.platform() === 'win32') {
    // Check common Oracle Client installation paths on Windows
    const commonPaths = [
      process.env.ORACLE_HOME,
      'C:\\oracle\\instantclient_21_3',
      'C:\\oracle\\instantclient_19_3',
      'C:\\oracle\\instantclient',
      'C:\\Oracle\\instantclient_21_3',
      'C:\\Oracle\\instantclient_19_3',
      'C:\\Oracle\\instantclient',
    ].filter(Boolean);

    // Try to initialize with available paths
    let initialized = false;
    for (const clientPath of commonPaths) {
      try {
        if (require('fs').existsSync(clientPath)) {
          oracledb.initOracleClient({ libDir: clientPath });
          logger.info('Oracle Client initialized', { libDir: clientPath });
          initialized = true;
          break;
        }
      } catch (err) {
        // Continue to next path if this one fails
        if (err.message.includes('DPI-1047')) {
          // Already initialized, which is fine
          initialized = true;
          break;
        }
      }
    }

    if (!initialized) {
      logger.warn('Oracle Client not initialized. Using system-wide installation. If you encounter connection issues, set ORACLE_HOME environment variable.');
    }
  }
} catch (err) {
  // Initialization errors are non-fatal - the system may have Oracle Client configured globally
  if (!err.message.includes('DPI-1047')) {
    logger.warn('Oracle Client initialization failed', { error: err.message });
  }
}

/**
 * Create an Oracle database connection using the provided configuration.
 *
 * @param {object} config
 * @param {string} config.host
 * @param {number} config.port
 * @param {string} config.serviceName
 * @param {string} config.username
 * @param {string} config.password
 * @param {string} [config.role] - Optional Oracle role (SYSDBA, SYSOPER, etc.)
 * @param {number} [config.connectTimeout] - Connection timeout in seconds (default: 60)
 * @param {number} [config.retries] - Number of retry attempts (default: 3)
 * @returns {Promise<Connection>}
 */
async function createConnection(config) {
  const { host, port, serviceName, username, password, role } = config;
  const connectTimeout = config.connectTimeout || 60;
  const maxRetries = config.retries || 3;

  if (!host || !port || !serviceName || !username || !password) {
    throw new Error('Oracle DB connection config incomplete: host, port, serviceName, username, and password are required');
  }

  const connectString = `${host}:${port}/${serviceName}`;

  const connectionOptions = {
    user            : username,
    password        : password,
    connectionString: connectString,
    connectTimeout  : connectTimeout,  // Timeout in seconds for establishing connection
  };

  // Add privilege parameter if role is specified
  if (role) {
    const roleUpper = role.toUpperCase();
    if (roleUpper === 'SYSDBA') {
      connectionOptions.privilege = oracledb.SYSDBA;
    } else if (roleUpper === 'SYSOPER') {
      connectionOptions.privilege = oracledb.SYSOPER;
    }
  }

  let lastError;
  for (let attempt = 1; attempt <= maxRetries; attempt++) {
    try {
      logger.info(`Oracle DB connection attempt ${attempt}/${maxRetries}`, {
        host, port, serviceName, user: username, role: role || 'NORMAL', connectTimeout
      });

      const connection = await oracledb.getConnection(connectionOptions);

      logger.info('Oracle DB connection established', {
        host, port, serviceName, user: username, role: role || 'NORMAL', attempt
      });

      return connection;
    } catch (err) {
      lastError = err;
      logger.warn(`Oracle DB connection attempt ${attempt}/${maxRetries} failed`, {
        host, port, serviceName, user: username, role: role || 'NORMAL',
        error: err.message, errorCode: err.errorNum
      });

      // Don't retry for authentication errors
      if (err.errorNum === 1017 || err.errorNum === 28000) {
        logger.error('Oracle DB authentication failed - invalid credentials', {
          host, port, serviceName, user: username
        });
        throw new Error(`Oracle DB connection failed: Invalid username or password (${err.message})`);
      }

      // Wait before retrying (exponential backoff)
      if (attempt < maxRetries) {
        const waitTime = Math.min(1000 * Math.pow(2, attempt - 1), 5000); // Max 5 seconds
        logger.info(`Waiting ${waitTime}ms before retry`, { attempt, maxRetries });
        await new Promise(resolve => setTimeout(resolve, waitTime));
      }
    }
  }

  // All retries exhausted
  logger.error('Oracle DB connection failed after all retries', {
    host, port, serviceName, user: username, role: role || 'NORMAL',
    maxRetries, error: lastError.message
  });

  throw new Error(`Oracle DB connection failed after ${maxRetries} attempts: ${lastError.message}`);
}

/**
 * Test Oracle database connectivity.
 *
 * @param {object} config - same shape as createConnection
 * @returns {Promise<{ok: boolean, message: string, version?: string, diagnostics?: object}>}
 */
async function testConnection(config) {
  let connection;
  const startTime = Date.now();

  try {
    connection = await createConnection(config);
    const result = await connection.execute('SELECT * FROM v$version WHERE banner LIKE \'Oracle%\'');
    const version = result.rows && result.rows.length > 0 ? result.rows[0].BANNER : 'Unknown';
    const duration = Date.now() - startTime;

    return {
      ok: true,
      message: 'Connection successful',
      version,
      diagnostics: {
        durationMs: duration,
        host: config.host,
        port: config.port,
        serviceName: config.serviceName,
        role: config.role || 'NORMAL'
      }
    };
  } catch (err) {
    const duration = Date.now() - startTime;

    // Provide more detailed error messages based on error codes
    let detailedMessage = err.message;
    let troubleshooting = [];

    // NJS-500 / NJS-521: Connection broken / end-of-file
    if (err.message.includes('NJS-500') || err.message.includes('NJS-521')) {
      troubleshooting.push('Network connection issue detected.');
      troubleshooting.push('1. Verify the database server is running and accessible from this machine');
      troubleshooting.push('2. Check firewall settings on both client and server');
      troubleshooting.push('3. Verify the host, port, and service name are correct');
      troubleshooting.push('4. Test network connectivity: ping ' + config.host);
      troubleshooting.push('5. Ensure Oracle Client is properly installed (check ORACLE_HOME or PATH)');
      troubleshooting.push('6. On Windows, ensure Oracle Instant Client DLLs are in PATH or use ORACLE_HOME');
    }

    // ORA-12154: TNS:could not resolve service name
    if (err.message.includes('ORA-12154') || err.message.includes('TNS:could not resolve')) {
      troubleshooting.push('Service name resolution failed.');
      troubleshooting.push('1. Verify the service name: ' + config.serviceName);
      troubleshooting.push('2. Check if tnsnames.ora is configured correctly (if using TNS names)');
      troubleshooting.push('3. Try using the full connection string format: host:port/service_name');
    }

    // ORA-12170: TNS:Connect timeout occurred
    if (err.message.includes('ORA-12170') || err.message.includes('timeout')) {
      troubleshooting.push('Connection timeout occurred.');
      troubleshooting.push('1. Check network connectivity between client and server');
      troubleshooting.push('2. Verify firewall allows traffic on port ' + config.port);
      troubleshooting.push('3. Increase connectTimeout in configuration if network is slow');
    }

    // Authentication errors
    if (err.errorNum === 1017 || err.errorNum === 28000 || err.message.includes('invalid username/password')) {
      troubleshooting.push('Authentication failed.');
      troubleshooting.push('1. Verify username and password are correct');
      troubleshooting.push('2. Check if the account is locked or expired');
      troubleshooting.push('3. Verify the user has appropriate privileges');
      if (config.role) {
        troubleshooting.push('4. Ensure the user has ' + config.role + ' privilege');
      }
    }

    // DPI errors (Oracle Client issues)
    if (err.message.includes('DPI-')) {
      troubleshooting.push('Oracle Client library issue detected.');
      troubleshooting.push('1. Ensure Oracle Instant Client is installed');
      troubleshooting.push('2. On Windows: Add Oracle Instant Client path to PATH environment variable');
      troubleshooting.push('3. Or set ORACLE_HOME environment variable to Oracle Client directory');
      troubleshooting.push('4. Restart the application after changing environment variables');
      troubleshooting.push('5. Download Oracle Instant Client from: https://www.oracle.com/database/technologies/instant-client/downloads.html');
    }

    return {
      ok: false,
      message: detailedMessage,
      diagnostics: {
        durationMs: duration,
        host: config.host,
        port: config.port,
        serviceName: config.serviceName,
        role: config.role || 'NORMAL',
        errorCode: err.errorNum,
        troubleshooting: troubleshooting.length > 0 ? troubleshooting : undefined
      }
    };
  } finally {
    if (connection) {
      try {
        await connection.close();
      } catch (_) { /* ignore */ }
    }
  }
}

/**
 * Fetch fusion sales metadata from Oracle database.
 * Maps Oracle table columns to the internal fusion_sales_metadata schema.
 *
 * Expected Oracle table structure (adjust table/column names as needed):
 *   FUSION_SALES_METADATA table with columns:
 *     - ROW_ID, SUBINVENTORY, CUSTOMER_TYPE, BILL_TO_NAME, BILL_TO_ACCOUNT,
 *       SITE_NUMBER, BUSINESS_UNIT, TXN_SOURCE, TXN_TYPE, RATE_IS_CORPORATE,
 *       REC_ACTIVITY_NAME_BANK, REC_ACTIVITY_NAME_CASH, INTEGRATION_SOURCE,
 *       DISTRIBUTION_ACC_ID, REGION, COST_CENTER_CODE
 *
 * @param {object} config - Oracle connection config
 * @param {object} [opts]
 * @param {string} [opts.tableName='FUSION_SALES_METADATA'] - Oracle table name
 * @returns {Promise<object[]>} - array of metadata rows
 */
async function fetchFusionSalesMetadata(config, opts = {}) {
  const tableName = opts.tableName || 'FUSION_SALES_METADATA';
  let connection;

  try {
    connection = await createConnection(config);

    const sql = `
      SELECT
        ROW_ID,
        SUBINVENTORY,
        CUSTOMER_TYPE,
        BILL_TO_NAME,
        BILL_TO_ACCOUNT,
        SITE_NUMBER,
        BUSINESS_UNIT,
        TXN_SOURCE,
        TXN_TYPE,
        RATE_IS_CORPORATE,
        REC_ACTIVITY_NAME_BANK,
        REC_ACTIVITY_NAME_CASH,
        INTEGRATION_SOURCE,
        DISTRIBUTION_ACC_ID,
        REGION,
        COST_CENTER_CODE
      FROM ${tableName}
      ORDER BY SUBINVENTORY, CUSTOMER_TYPE
    `;

    const result = await connection.execute(sql, [], { maxRows: 10000 });

    // Map Oracle column names to internal schema (lowercase with underscores)
    const rows = result.rows.map(row => ({
      row_id                : row.ROW_ID,
      subinventory          : row.SUBINVENTORY,
      customer_type         : row.CUSTOMER_TYPE,
      bill_to_name          : row.BILL_TO_NAME,
      bill_to_account       : row.BILL_TO_ACCOUNT,
      site_number           : row.SITE_NUMBER,
      business_unit         : row.BUSINESS_UNIT,
      txn_source            : row.TXN_SOURCE,
      txn_type              : row.TXN_TYPE,
      rate_is_corporate     : row.RATE_IS_CORPORATE,
      rec_activity_name_bank: row.REC_ACTIVITY_NAME_BANK,
      rec_activity_name_cash: row.REC_ACTIVITY_NAME_CASH,
      integration_source    : row.INTEGRATION_SOURCE,
      distribution_acc_id   : row.DISTRIBUTION_ACC_ID,
      region                : row.REGION,
      cost_center_code      : row.COST_CENTER_CODE,
    }));

    logger.info(`Fetched ${rows.length} rows from Oracle ${tableName}`);
    return rows;
  } catch (err) {
    logger.error(`Failed to fetch fusion metadata from Oracle: ${err.message}`);
    throw err;
  } finally {
    if (connection) {
      try {
        await connection.close();
      } catch (_) { /* ignore */ }
    }
  }
}

/**
 * Fetch store Oracle metadata from Oracle database.
 * Maps Oracle table columns to the internal store_oracle_metadata schema.
 *
 * Expected Oracle table structure (adjust table/column names as needed):
 *   STORE_ORACLE_METADATA table with columns matching store_oracle_metadata SQLite table
 *
 * @param {object} config - Oracle connection config
 * @param {object} [opts]
 * @param {string} [opts.tableName='STORE_ORACLE_METADATA'] - Oracle table name
 * @returns {Promise<object[]>} - array of store metadata rows
 */
async function fetchStoreOracleMetadata(config, opts = {}) {
  const tableName = opts.tableName || 'STORE_ORACLE_METADATA';
  let connection;

  try {
    connection = await createConnection(config);

    const sql = `
      SELECT
        STORE_ID,
        STORE_NAME,
        BILL_TO_NAME,
        BILL_TO_ACCOUNT,
        SITE_NUMBER,
        BUSINESS_UNIT,
        TXN_SOURCE,
        TXN_TYPE,
        PAYMENT_TERMS_NAME,
        RATE_IS_CORPORATE,
        ORG_ID,
        COST_CENTER_CODE,
        CUSTOMER_TYPE,
        REGION,
        TZ_OFFSET,
        CURRENCY,
        OUTLET_NAME,
        ORGANIZATION_NAME,
        DEFAULT_PAYMENT_TYPE,
        TAX_NAME,
        RECEIPT_METHOD_META,
        JOURNAL_META,
        UOM_CODE_MAP,
        REC_ACTIVITY_NAME_BANK,
        REC_ACTIVITY_NAME_CASH
      FROM ${tableName}
      ORDER BY STORE_ID
    `;

    const result = await connection.execute(sql, [], { maxRows: 10000 });

    // Map Oracle column names to internal schema
    const rows = result.rows.map(row => ({
      storeId              : row.STORE_ID,
      storeName            : row.STORE_NAME,
      billToName           : row.BILL_TO_NAME,
      billToAccount        : row.BILL_TO_ACCOUNT,
      siteNumber           : row.SITE_NUMBER,
      businessUnit         : row.BUSINESS_UNIT,
      txnSource            : row.TXN_SOURCE,
      txnType              : row.TXN_TYPE,
      paymentTermsName     : row.PAYMENT_TERMS_NAME,
      rateIsCorporate      : row.RATE_IS_CORPORATE,
      orgId                : row.ORG_ID,
      costCenterCode       : row.COST_CENTER_CODE,
      customerType         : row.CUSTOMER_TYPE,
      region               : row.REGION,
      tzOffset             : row.TZ_OFFSET,
      currency             : row.CURRENCY,
      outletName           : row.OUTLET_NAME,
      organizationName     : row.ORGANIZATION_NAME,
      defaultPaymentType   : row.DEFAULT_PAYMENT_TYPE,
      taxName              : row.TAX_NAME,
      receiptMethodMeta    : row.RECEIPT_METHOD_META,
      journalMeta          : row.JOURNAL_META,
      uomCodeMap           : row.UOM_CODE_MAP,
      recActivityNameBank  : row.REC_ACTIVITY_NAME_BANK,
      recActivityNameCash  : row.REC_ACTIVITY_NAME_CASH,
    }));

    logger.info(`Fetched ${rows.length} store metadata rows from Oracle ${tableName}`);
    return rows;
  } catch (err) {
    logger.error(`Failed to fetch store metadata from Oracle: ${err.message}`);
    throw err;
  } finally {
    if (connection) {
      try {
        await connection.close();
      } catch (_) { /* ignore */ }
    }
  }
}

/**
 * Check if sale already exists in BACKUP_VENDHQ_SALES
 * Matches Java: session.getIsSalesExists(sale.getInvoiceNumber(), sale.getSaleDate())
 */
async function checkSaleExists(connection, invoiceNumber, saleDate) {
  const result = await connection.execute(
    `SELECT COUNT(*) as CNT FROM BACKUP_VENDHQ_SALES
     WHERE INVOICE_NUMBER = :invoiceNumber
     AND TRUNC(SALE_DATE) = TRUNC(TO_DATE(:saleDate, 'YYYY-MM-DD'))`,
    { invoiceNumber, saleDate },
    { outFormat: oracledb.OUT_FORMAT_OBJECT }
  );
  return result.rows[0].CNT > 0;
}

/**
 * Transform Odoo sale to BACKUP_VENDHQ_SALES format
 * Matches Java: transform(Sale sale, VendhqServiceProviders serviceProvider)
 */
function transformSaleHeader(sale, region) {
  return {
    INVOICE_NUMBER: sale.name,
    OUTLET_NAME: sale.store_name || 'DEFAULT',
    REGISTER_NAME: sale.register_name || 'DEFAULT',
    SALE_DATE: sale.date_order,
    TOTAL_PRICE: sale.amount_untaxed || 0,
    TOTAL_TAX: sale.amount_tax || 0,
    TOTAL_LOYALTY: sale.total_loyalty || null,
    TOTAL_PRICE_INCL_TAX: sale.amount_total || 0,
    VERSION: 1,
    REGION: region || sale.country || 'SA',
    CUSTOMER_TYPE: sale.customer_type || 'NORMAL'
  };
}

/**
 * Transform Odoo sale lines to BACKUP_VENDHQ_LINE_ITEMS format
 * Matches Java: transform(Sale sale, LineItem lineItem, String taxName)
 */
function transformSaleLines(sale, lines, region) {
  return lines.map((line, index) => ({
    INVOICE_NUMBER: sale.name,
    SALE_DATE: sale.date_order,
    LINE_NUMBER: index + 1,
    ITEM_NUMBER: line.product_code || line.product_name || 'UNKNOWN',
    ITEM_NAME: line.product_name || 'Unknown Product',
    QUANTITY: line.qty || 0,
    LOYALTY_VALUE: line.loyalty_value || null,
    TOTAL_PRICE: line.price_subtotal || 0,
    TOTAL_TAX: line.price_tax || 0,
    TOTAL_DISCOUNT: line.discount_amount || null,
    TOTAL_LOYALTY: null,
    REGION: region || sale.country || 'SA',
    TAX_NAME: line.tax_name || 'VAT'
  }));
}

/**
 * Transform Odoo payments to BACKUP_VENDHQ_PAYMENTS format
 * Matches Java: transform(Sale sale, Payment payment)
 */
function transformSalePayments(sale, payments, region) {
  return payments.map(payment => ({
    INVOICE_NUMBER: sale.name,
    OUTLET_NAME: sale.store_name || 'DEFAULT',
    REGISTER_NAME: sale.register_name || 'DEFAULT',
    AMOUNT: payment.amount || 0,
    CURRENCY: sale.currency || 'USD',
    PAYMENT_TYPE: payment.payment_method_name || 'CASH',
    PAYMENT_DATE: payment.payment_date || sale.date_order,
    DELETED_AT: null,
    REGION: region || sale.country || 'SA',
    SALE_DATE: sale.date_order
  }));
}

/**
 * Insert sale header into BACKUP_VENDHQ_SALES
 * Matches Java: session.mergeBackupVendhqSales(transform(sale, serviceProvider))
 */
async function insertSaleHeader(connection, saleData) {
  await connection.execute(
    `INSERT INTO BACKUP_VENDHQ_SALES
     (ROW_ID, INVOICE_NUMBER, OUTLET_NAME, REGISTER_NAME, SALE_DATE,
      TOTAL_PRICE, TOTAL_TAX, TOTAL_LOYALTY, TOTAL_PRICE_INCL_TAX,
      VERSION, REGION, CUSTOMER_TYPE)
     VALUES
     (BACKUP_VENDHQ_SALES_SEQ_GEN.NEXTVAL, :INVOICE_NUMBER, :OUTLET_NAME,
      :REGISTER_NAME, TO_DATE(:SALE_DATE, 'YYYY-MM-DD'),
      :TOTAL_PRICE, :TOTAL_TAX, :TOTAL_LOYALTY, :TOTAL_PRICE_INCL_TAX,
      :VERSION, :REGION, :CUSTOMER_TYPE)`,
    saleData
  );
}

/**
 * Insert line item into BACKUP_VENDHQ_LINE_ITEMS
 * Matches Java: session.mergeBackupVendhqLineItems(transform(sale, lineItem, taxName))
 */
async function insertLineItem(connection, lineData) {
  await connection.execute(
    `INSERT INTO BACKUP_VENDHQ_LINE_ITEMS
     (ROW_ID, INVOICE_NUMBER, LINE_NUMBER, ITEM_NUMBER, ITEM_NAME,
      QUANTITY, LOYALTY_VALUE, TOTAL_PRICE, TOTAL_TAX, TOTAL_DISCOUNT,
      TOTAL_LOYALTY, REGION, SALE_DATE, TAX_NAME)
     VALUES
     (BACKUP_VENDHQ_LINE_SEQ_GEN.NEXTVAL, :INVOICE_NUMBER, :LINE_NUMBER,
      :ITEM_NUMBER, :ITEM_NAME, :QUANTITY, :LOYALTY_VALUE, :TOTAL_PRICE,
      :TOTAL_TAX, :TOTAL_DISCOUNT, :TOTAL_LOYALTY, :REGION,
      TO_DATE(:SALE_DATE, 'YYYY-MM-DD'), :TAX_NAME)`,
    lineData
  );
}

/**
 * Insert payment into BACKUP_VENDHQ_PAYMENTS
 * Matches Java: session.mergeBackupVendhqPayments(transform(sale, payment))
 */
async function insertPayment(connection, paymentData) {
  await connection.execute(
    `INSERT INTO BACKUP_VENDHQ_PAYMENTS
     (ROW_ID, INVOICE_NUMBER, OUTLET_NAME, REGISTER_NAME, AMOUNT,
      CURRENCY, PAYMENT_TYPE, PAYMENT_DATE, DELETED_AT, REGION, SALE_DATE)
     VALUES
     (BACKUP_VENDHQ_PAY_SEQ_GEN.NEXTVAL, :INVOICE_NUMBER, :OUTLET_NAME,
      :REGISTER_NAME, :AMOUNT, :CURRENCY, :PAYMENT_TYPE,
      TO_DATE(:PAYMENT_DATE, 'YYYY-MM-DD'), :DELETED_AT, :REGION,
      TO_DATE(:SALE_DATE, 'YYYY-MM-DD'))`,
    paymentData
  );
}

/**
 * Sync single sale to Oracle BACKUP tables
 * Matches Java: syncSales(Sale sale) from BackupSalesVendHqPersistence.java
 */
async function syncSale(connection, sale, lines, payments, region) {
  // Check if sale already exists
  const exists = await checkSaleExists(connection, sale.name, sale.date_order);
  if (exists) {
    logger.debug('Sale already exists, skipping', { invoiceNumber: sale.name });
    return { skipped: true, reason: 'ALREADY_EXISTS' };
  }

  // Transform data
  const saleHeader = transformSaleHeader(sale, region);
  const saleLines = transformSaleLines(sale, lines, region);
  const salePayments = transformSalePayments(sale, payments, region);

  // Insert header
  await insertSaleHeader(connection, saleHeader);
  logger.debug('Inserted sale header', { invoiceNumber: sale.name });

  // Insert lines
  for (const line of saleLines) {
    await insertLineItem(connection, line);
  }
  logger.debug('Inserted line items', {
    invoiceNumber: sale.name,
    lineCount: saleLines.length
  });

  // Insert payments
  for (const payment of salePayments) {
    await insertPayment(connection, payment);
  }
  logger.debug('Inserted payments', {
    invoiceNumber: sale.name,
    paymentCount: salePayments.length
  });

  return {
    success: true,
    invoiceNumber: sale.name,
    linesInserted: saleLines.length,
    paymentsInserted: salePayments.length
  };
}

/**
 * Batch sync multiple sales to Oracle
 * Main function matching Java: backupSales(String domainName, Credential vendHqCredential)
 */
async function syncSalesToOracle(config, salesData, region = 'SA') {
  let connection;
  const results = {
    total: salesData.length,
    synced: 0,
    skipped: 0,
    failed: 0,
    errors: []
  };

  try {
    connection = await createConnection(config);

    for (const saleData of salesData) {
      try {
        const { sale, lines, payments } = saleData;

        // Sync to Oracle
        const result = await syncSale(connection, sale, lines, payments, region);

        if (result.skipped) {
          results.skipped++;
        } else if (result.success) {
          results.synced++;
        }

      } catch (err) {
        results.failed++;
        results.errors.push({
          invoiceNumber: saleData.sale?.name || 'UNKNOWN',
          error: err.message
        });
        logger.error('Failed to sync sale', {
          invoiceNumber: saleData.sale?.name,
          error: err.message
        });
      }
    }

    // Commit all changes
    await connection.commit();
    logger.info('Batch sync completed', results);

  } catch (err) {
    if (connection) {
      try {
        await connection.rollback();
      } catch (rollbackErr) {
        logger.error('Rollback failed', { error: rollbackErr.message });
      }
    }
    logger.error('Batch sync failed', { error: err.message });
    throw err;
  } finally {
    if (connection) {
      try {
        await connection.close();
      } catch (closeErr) {
        logger.error('Connection close failed', { error: closeErr.message });
      }
    }
  }

  return results;
}

module.exports = {
  createConnection,
  testConnection,
  fetchFusionSalesMetadata,
  fetchStoreOracleMetadata,
  syncSalesToOracle,
  syncSale,
  checkSaleExists,
  transformSaleHeader,
  transformSaleLines,
  transformSalePayments
};
