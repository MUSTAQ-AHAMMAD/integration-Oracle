'use strict';

/**
 * fusionInvTxnMapping.js
 *
 * JavaScript port of:
 *   IntegrationJobs/src/innovate/tamergroup/vendhq/mapping/FusionInvTxnMapping.java
 *   - mapToInvTransactionModel : lines 34-61
 */

const { inventoryTransactionType, inventoryTransactionQty } = require('../calculations');

/**
 * Build an Oracle Fusion inventory transaction line.
 *
 * @param {object} sale           - { invoiceNumber, saleDate (ISO string) }
 * @param {object} lineItem       - { itemNumber, quantity, totalPrice, uomCode }
 * @param {object} outletDetail   - { outletName, organizationName }
 * @param {string} customerType   - 'NORMAL' | 'HUNGERSTATION' | 'TAMARA' | etc.
 * @param {object} [journalMapping] - { costIssue, costRMA } for non-NORMAL types
 * @returns {object} transactionLine
 */
function mapToInvTransactionModel(sale, lineItem, outletDetail, customerType, journalMapping) {
  // Java lines 38-44: NORMAL uses hardcoded values; others use journalMapping
  let costIssue = 'Vend Sales Issue';
  let costRMA   = 'Vend RMA';
  if (customerType !== 'NORMAL' && journalMapping) {
    costIssue = journalMapping.costIssue;
    costRMA   = journalMapping.costRMA;
  }

  const quantity   = Number(lineItem.quantity);
  const totalPrice = Number(lineItem.totalPrice);

  return {
    organizationName         : outletDetail.organizationName || outletDetail.outletName,
    item                     : lineItem.itemNumber,
    transactionSourceName    : sale.invoiceNumber,
    subinventory             : outletDetail.outletName,
    transactionUnitOfMeasure : lineItem.uomCode || 'Ea',
    transactionDate          : sale.saleDate,
    transactionQuantity      : inventoryTransactionQty(quantity),
    transactionType          : inventoryTransactionType(totalPrice, quantity, costIssue, costRMA),
  };
}

module.exports = { mapToInvTransactionModel };
