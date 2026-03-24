'use strict';

/**
 * oracleClient.js
 *
 * Oracle Fusion REST API client.
 * Wraps every endpoint needed for the VendHQ → Oracle Fusion sales sync:
 *   1. GET  customers
 *   2. GET  units (UOM)
 *   3. POST receivablesInvoices
 *   4. POST receivablesReceipts  (standard)
 *   5. POST receivablesReceipts/{id}/child/applyReceiptOnAccount
 *   6. POST receivablesMiscellaneousReceipts  (bank charges / cash rounding)
 *   7. POST inventoryTransactions
 *   8. POST journals
 *
 * Auth: HTTP Basic (username + password from .env)
 */

const http  = require('http');
const https = require('https');
const axios = require('axios');

// Reuse TCP connections across all Oracle API calls (avoid per-request TLS handshake).
// maxSockets limits concurrency at the transport layer; set generously so the
// application-level ODOO_PUSH_CONCURRENCY env-var remains the effective ceiling.
const _httpAgent  = new http.Agent ({ keepAlive: true, maxSockets: 64 });
const _httpsAgent = new https.Agent({ keepAlive: true, maxSockets: 64 });

class OracleClient {
  constructor(baseUrl, username, password) {
    this.http = axios.create({
      baseURL: `${baseUrl}/fscmRestApi/resources/11.13.18.05`,
      auth: { username, password },
      headers: {
        'Content-Type': 'application/vnd.oracle.adf.resourceitem+json',
        'Accept': 'application/json',
      },
      timeout: 60000,
      httpAgent : _httpAgent,
      httpsAgent: _httpsAgent,
    });
  }

  /** 1. Fetch customer account details by account number */
  async getCustomer(accountNumber) {
    const res = await this.http.get('/customers', {
      params: {
        q: `CustomerNumber='${accountNumber}'`,
        fields: 'CustomerAccountId,CustomerNumber,CustomerName,AccountType,AccountStatus,PaymentTerms,CurrencyCode',
        limit: 1,
      },
    });
    return (res.data.items || [])[0] || null;
  }

  /** 2. Resolve Oracle UomCode from a UOM name */
  async getUomCode(uomName) {
    const res = await this.http.get('/units', {
      params: { q: `UnitOfMeasureName='${uomName}'`, fields: 'UomCode,UnitOfMeasureName', limit: 1 },
    });
    return ((res.data.items || [])[0] || {}).UomCode || null;
  }

  /** 3. Create an AR invoice */
  async createInvoice(payload) {
    const res = await this.http.post('/receivablesInvoices', payload);
    return res.data;
  }

  /** Check if invoice line already exists */
  async findInvoiceLine(transactionNumber, salesOrder) {
    try {
      const res = await this.http.get('/receivablesInvoices', {
        params: {
          q: `TransactionNumber='${transactionNumber}';SalesOrder='${salesOrder}'`,
          fields: 'TransactionNumber,CustomerTransactionId',
          limit: 1,
        },
      });
      return (res.data.items || [])[0] || null;
    } catch (_) {
      return null;
    }
  }

  /** 4. Create a standard receipt */
  async createReceipt(payload) {
    const res = await this.http.post('/receivablesReceipts', payload);
    return res.data;
  }

  /** 6. Create a miscellaneous receipt (bank charges / cash rounding) */
  async createMiscReceipt(payload) {
    const res = await this.http.post('/receivablesMiscellaneousReceipts', payload);
    return res.data;
  }

  /** 5. Apply a receipt to an invoice */
  async applyReceipt(receiptId, payload) {
    const res = await this.http.post(
      `/receivablesReceipts/${receiptId}/child/applyReceiptOnAccount`,
      payload
    );
    return res.data;
  }

  /** 7. Create inventory transaction lines */
  async createInventoryTransaction(payload) {
    const res = await this.http.post('/inventoryTransactions', payload);
    return res.data;
  }

  /** Check if inventory transaction already exists */
  async findInventoryTransaction(transactionSourceName, item) {
    try {
      const res = await this.http.get('/inventoryTransactions', {
        params: {
          q: `TransactionSourceName='${transactionSourceName}';Item='${item}'`,
          fields: 'TransactionId',
          limit: 1,
        },
      });
      return (res.data.items || [])[0] || null;
    } catch (_) {
      return null;
    }
  }

  /** 8. Import a GL journal batch */
  async createJournal(payload) {
    const res = await this.http.post('/journals', payload);
    return res.data;
  }

  /** Get external bank account ID by name (for receipt creation) */
  async getBankAccountId(bankAccountName) {
    const res = await this.http.get('/externalBankAccounts', {
      params: {
        q: `BankAccountName='${bankAccountName}'`,
        fields: 'BankAccountId,BankAccountName',
        limit: 1,
      },
    });
    return ((res.data.items || [])[0] || {}).BankAccountId || null;
  }
}

module.exports = OracleClient;
