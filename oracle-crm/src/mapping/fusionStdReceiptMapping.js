'use strict';

/**
 * fusionStdReceiptMapping.js
 *
 * JavaScript port of:
 *   IntegrationJobs/src/innovate/tamergroup/vendhq/mapping/FusionStdReceiptMapping.java
 *   - mapToStandardReceipt : lines 25-39
 */

/**
 * Build an Oracle Fusion standard receipt request.
 *
 * @param {string} paymentType         - e.g. 'Cash', 'Visa'
 * @param {object} invoiceHeader       - built by fusionInvoiceMapping.mapToInvoiceHeader
 * @param {object} outletDetail        - { orgId, ... }
 * @param {object} receiptMethodMeta   - { receiptMethodId, receiptIsCash,
 *                                         cashAccountId, bankAccountId }
 * @param {string} transactionNumber   - Oracle invoice TransactionNumber
 * @returns {object} standardReceipt
 */
function mapToStandardReceipt(paymentType, invoiceHeader, outletDetail, receiptMethodMeta, transactionNumber) {
  // Java lines 33-35: use cashAccountId when receiptIsCash === '1', else bankAccountId
  const remittanceBankAccountId = receiptMethodMeta.receiptIsCash === '1'
    ? receiptMethodMeta.cashAccountId
    : receiptMethodMeta.bankAccountId;

  return {
    currencyCode           : invoiceHeader.invoiceCurrencyCode,
    saleDate               : invoiceHeader.saleDate,
    receiptMethodId        : receiptMethodMeta.receiptMethodId,
    receiptNumber          : `${paymentType}-${transactionNumber}`,
    remittanceBankAccountId,
    accountValue           : invoiceHeader.billToAccountNumber,
    orgId                  : outletDetail.orgId,
    receiptAmount          : 0,
  };
}

module.exports = { mapToStandardReceipt };
