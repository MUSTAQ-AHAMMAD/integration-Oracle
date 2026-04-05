'use strict';

/**
 * fusionMiscReceiptMapping.js
 *
 * JavaScript port of:
 *   IntegrationJobs/src/innovate/tamergroup/vendhq/mapping/FusionMiscReceiptMapping.java
 *   - mapToMiscReceipt : lines 28-45
 */

/**
 * Build an Oracle Fusion miscellaneous receipt request.
 *
 * @param {object}   payment           - { paymentType, amount }
 * @param {object}   invoiceHeader     - { invoiceCurrencyCode, saleDate }
 * @param {object}   receiptMethodMeta - { receiptMethodId }
 * @param {object}   outletDetail      - { orgId }
 * @param {object}   registerDetails   - { cashAccount, bankAccount }
 * @param {string[]} metaMappings      - [0]=unused, [1]=cashRoundingActivity, [2]=bankChargeActivity
 * @param {string}   transactionNumber
 * @returns {object} miscReceipt
 */
function mapToMiscReceipt(payment, invoiceHeader, receiptMethodMeta, outletDetail,
                          registerDetails, metaMappings, transactionNumber) {
  const paymentType = payment.paymentType;
  const lowerType   = paymentType.toLowerCase();

  // Java line 36: !paymentType.contains("Cash") → paymentType; else → "Cash"
  // Note: the original Java also uses un-lowercased paymentType for this check
  // (matching capital-C "Cash") which is intentionally preserved here.
  const receiptMethodName = !paymentType.includes('Cash') ? paymentType : 'Cash';

  // Java line 38-39: rounding → cashAccount, else bankAccount
  const bankAccountName = lowerType.includes('rounding')
    ? registerDetails.cashAccount
    : registerDetails.bankAccount;

  // Java line 40: 'cash rounding' → metaMappings[1], else metaMappings[2]
  const receivableActivityName = lowerType === 'cash rounding'
    ? metaMappings[1]
    : metaMappings[2];

  return {
    currencyCode           : invoiceHeader.invoiceCurrencyCode,
    saleDate               : invoiceHeader.saleDate,
    receiptMethodId        : receiptMethodMeta.receiptMethodId,
    receiptMethodName,
    receiptNumber          : `${paymentType}-${transactionNumber}-MISC`,
    bankAccountName,
    receivableActivityName,
    orgId                  : outletDetail.orgId,
    receiptAmount          : 0,
  };
}

module.exports = { mapToMiscReceipt };
