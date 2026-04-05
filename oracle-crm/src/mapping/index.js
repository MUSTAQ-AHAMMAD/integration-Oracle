'use strict';

/**
 * oracle-crm/src/mapping/index.js
 *
 * Barrel file – re-exports all Oracle Fusion mapping modules.
 */

module.exports = {
  FusionInvoiceMapping     : require('./fusionInvoiceMapping'),
  FusionStdReceiptMapping  : require('./fusionStdReceiptMapping'),
  FusionMiscReceiptMapping : require('./fusionMiscReceiptMapping'),
  FusionApplyReceiptMapping: require('./fusionApplyReceiptMapping'),
  FusionInvTxnMapping      : require('./fusionInvTxnMapping'),
  FusionJournalEntryMapping: require('./fusionJournalEntryMapping'),
};
