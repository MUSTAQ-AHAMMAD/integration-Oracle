'use strict';

/**
 * fusionApplyReceiptMapping.js
 *
 * JavaScript port of:
 *   IntegrationJobs/src/innovate/tamergroup/vendhq/mapping/FusionApplyReceiptMapping.java
 *   - mapToApplyReceiptModel : lines 21-30
 */

/**
 * Build an Oracle Fusion apply-receipt request.
 *
 * @param {object} standardReceipt   - { saleDate, receiptNumber, receiptAmount, currencyCode }
 * @param {string} transactionNumber - Oracle invoice TransactionNumber
 * @param {string} transactionSource - e.g. 'ODOO_SALES'
 * @returns {object} applyReceiptRequest
 */
function mapToApplyReceiptModel(standardReceipt, transactionNumber, transactionSource) {
  return {
    receiptDate      : standardReceipt.saleDate,
    transactionNumber,
    receiptNumber    : standardReceipt.receiptNumber,
    amountApplied    : standardReceipt.receiptAmount,
    receiptCurrency  : standardReceipt.currencyCode,
    transactionSource,
  };
}

module.exports = { mapToApplyReceiptModel };
