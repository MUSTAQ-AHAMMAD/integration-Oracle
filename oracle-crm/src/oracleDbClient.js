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

// Oracle client configuration
oracledb.outFormat = oracledb.OUT_FORMAT_OBJECT;
oracledb.fetchAsString = [oracledb.CLOB];

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
 * @returns {Promise<Connection>}
 */
async function createConnection(config) {
  const { host, port, serviceName, username, password, role } = config;

  if (!host || !port || !serviceName || !username || !password) {
    throw new Error('Oracle DB connection config incomplete: host, port, serviceName, username, and password are required');
  }

  const connectString = `${host}:${port}/${serviceName}`;

  const connectionOptions = {
    user         : username,
    password     : password,
    connectionString: connectString,
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

  try {
    const connection = await oracledb.getConnection(connectionOptions);
    logger.info('Oracle DB connection established', { host, port, serviceName, user: username, role: role || 'NORMAL' });
    return connection;
  } catch (err) {
    logger.error('Oracle DB connection failed', { host, port, serviceName, user: username, role: role || 'NORMAL', error: err.message });
    throw new Error(`Oracle DB connection failed: ${err.message}`);
  }
}

/**
 * Test Oracle database connectivity.
 *
 * @param {object} config - same shape as createConnection
 * @returns {Promise<{ok: boolean, message: string, version?: string}>}
 */
async function testConnection(config) {
  let connection;
  try {
    connection = await createConnection(config);
    const result = await connection.execute('SELECT * FROM v$version WHERE banner LIKE \'Oracle%\'');
    const version = result.rows && result.rows.length > 0 ? result.rows[0].BANNER : 'Unknown';
    return { ok: true, message: 'Connection successful', version };
  } catch (err) {
    return { ok: false, message: err.message };
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

module.exports = {
  createConnection,
  testConnection,
  fetchFusionSalesMetadata,
  fetchStoreOracleMetadata,
};
