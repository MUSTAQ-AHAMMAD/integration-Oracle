'use strict';

/**
 * fusionInvoiceMapping.js
 *
 * JavaScript port of:
 *   IntegrationJobs/src/innovate/tamergroup/vendhq/mapping/FusionInvoiceMapping.java
 *   - mapToInvoiceHeader : lines 38-55
 *   - mapToInvoiceLine   : lines 57-85
 */

const { applyTimezoneOffset, effectiveQuantity, unitSellingPrice } = require('../calculations');

/**
 * Build an Oracle Fusion invoice header from sale metadata.
 *
 * @param {object} sale          - { saleDate (ISO string), invoiceNumber, ... }
 * @param {object} salesMetaData - { billToName, siteNumber, billToAccount,
 *                                   businessUnit, txnSource, txnType, rateIsCorporate }
 * @param {object} outletDetail  - { outletName, currency }
 * @param {number} tzOffset      - decimal hours, e.g. 3.5 for GST+3:30
 * @returns {object} invoiceHeader
 */
function mapToInvoiceHeader(sale, salesMetaData, outletDetail, tzOffset) {
  const saleDate = applyTimezoneOffset(new Date(sale.saleDate), tzOffset);

  return {
    billToCustomerName  : salesMetaData.billToName,
    billToLocation      : salesMetaData.siteNumber,
    billToAccountNumber : String(salesMetaData.billToAccount),
    businessUnit        : salesMetaData.businessUnit,
    outletName          : outletDetail.outletName,
    saleDate,
    transactionSource   : salesMetaData.txnSource,
    transactionType     : salesMetaData.txnType,
    invoiceCurrencyCode : outletDetail.currency,
    conversionRateType  : salesMetaData.rateIsCorporate === '1' ? 'Corporate' : 'User',
    invoiceLines        : [],
  };
}

/**
 * Build an Oracle Fusion invoice line.
 *
 * @param {object} invoiceHeader - the header built by mapToInvoiceHeader
 * @param {object} sale          - { invoiceNumber }
 * @param {object} lineItem      - { lineNumber, itemNumber, itemName, quantity,
 *                                   totalPrice, taxName, uomCode, description }
 * @returns {object} invoiceLine
 */
function mapToInvoiceLine(invoiceHeader, sale, lineItem) {
  const origQty      = Number(lineItem.quantity);
  const effectiveQty = effectiveQuantity(lineItem.itemName, Number(lineItem.totalPrice), origQty);
  // Java line 77: sellingPrice = totalPrice.divide(lineItem.getQuantity()).abs()
  // Uses original quantity, not effective quantity.
  const unitPrice    = unitSellingPrice(Number(lineItem.totalPrice), origQty);

  const invoiceLine = {
    lineNumber           : invoiceHeader.invoiceLines.length + 1,
    itemNumber           : lineItem.itemNumber,
    quantity             : effectiveQty,
    description          : lineItem.description || lineItem.itemName,
    uomCode              : lineItem.uomCode || 'Ea',
    currencyCode         : invoiceHeader.invoiceCurrencyCode,
    unitSellingPrice     : unitPrice,
    salesOrder           : sale.invoiceNumber,
    salesOrderLine       : String(lineItem.lineNumber),
    taxClassificationCode: lineItem.taxName,
  };

  // Java lines 62-63: set memoLineName only when itemName === 'Discount Item'
  if (lineItem.itemName === 'Discount Item') {
    invoiceLine.memoLineName = 'Discount Item';
  }

  return invoiceLine;
}

module.exports = { mapToInvoiceHeader, mapToInvoiceLine };
