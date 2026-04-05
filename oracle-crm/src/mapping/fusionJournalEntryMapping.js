'use strict';

/**
 * fusionJournalEntryMapping.js
 *
 * JavaScript port of:
 *   IntegrationJobs/src/innovate/tamergroup/vendhq/mapping/FusionJournalEntryMapping.java
 *   - getJournalEntryHeader  : lines 46-52
 *   - addToJournalEntryLine  : lines 54-77
 *   - getJournalEntryList    : lines 128-130
 *   - generateJournalLine    : lines 79-126
 *   - populateJournalHeader  : lines 148-166
 *   - getJournalKey          : lines 132-138
 *   - getJournalLineKey      : lines 140-145
 */

const { accountingPeriodName } = require('../calculations');

class FusionJournalEntryMapping {
  /**
   * @param {object} outlet - { outletName, region }
   */
  constructor(outlet) {
    this._outlet           = outlet;
    this._journalEntryMap  = new Map();   // journalKey → JournalHeader
    this._journalLineSaleMap = new Set(); // deduplication set
  }

  // ── Public API ────────────────────────────────────────────────────────────

  /**
   * Return an existing JournalHeader or create a new one.
   *
   * Java ref: lines 46-52
   *
   * @param {boolean} isFixed
   * @param {object}  invoiceHeader
   * @param {string}  transactionNumber
   * @param {string}  customerType
   * @param {object}  journalMapping  - credit-side mapping (contains serviceProvider, ledgerId, etc.)
   * @returns {object} JournalHeader
   */
  getJournalEntryHeader(isFixed, invoiceHeader, transactionNumber, customerType, journalMapping) {
    const key = this._getJournalKey(isFixed, transactionNumber, customerType);
    if (!this._journalEntryMap.has(key)) {
      this._journalEntryMap.set(
        key,
        this._populateJournalHeader(isFixed, invoiceHeader, transactionNumber, journalMapping)
      );
    }
    return this._journalEntryMap.get(key);
  }

  /**
   * Add CREDIT + DEBIT journal lines to the appropriate header.
   *
   * Java ref: lines 54-77
   *
   * @param {boolean} isFixed
   * @param {object}  invoiceHeader
   * @param {object}  invoiceLine       - { salesOrder, ... }
   * @param {string}  transactionNumber
   * @param {string}  customerType
   * @param {number}  orderCharge       - pre-calculated charge amount
   * @param {boolean} isCash
   * @param {string}  costCenterCode
   * @param {object}  creditJournalMapping
   * @param {object}  debitJournalMapping
   */
  addToJournalEntryLine(isFixed, invoiceHeader, invoiceLine, transactionNumber,
                        customerType, orderCharge, isCash, costCenterCode,
                        creditJournalMapping, debitJournalMapping) {
    const journalHeader = this.getJournalEntryHeader(
      isFixed, invoiceHeader, transactionNumber, customerType, creditJournalMapping
    );

    // Java lines 63-65: deduplicate by line key
    const lineKey = this._getJournalLineKey(isFixed, transactionNumber, invoiceLine.salesOrder, customerType);
    if (this._journalLineSaleMap.has(lineKey)) return;
    this._journalLineSaleMap.add(lineKey);

    // Java lines 68-71: compute final charge
    const saleCharge    = Number(orderCharge);
    const bankChargeRate = creditJournalMapping.bankChargeRate != null
      ? creditJournalMapping.bankChargeRate : 0;
    const saleBankCharge = saleCharge * bankChargeRate;
    const finalCharge    = isFixed
      ? (debitJournalMapping.fixedFreightCharge != null
          ? debitJournalMapping.fixedFreightCharge
          : saleBankCharge)
      : saleBankCharge;

    journalHeader.journalLines.push(
      this._generateJournalLine('CREDIT', journalHeader, invoiceHeader, invoiceLine,
                                creditJournalMapping, finalCharge, costCenterCode)
    );
    journalHeader.journalLines.push(
      this._generateJournalLine('DEBIT', journalHeader, invoiceHeader, invoiceLine,
                                debitJournalMapping, finalCharge, costCenterCode)
    );
  }

  /**
   * Return all JournalHeader objects accumulated so far.
   *
   * Java ref: lines 128-130
   *
   * @returns {object[]}
   */
  getJournalEntryList() {
    return Array.from(this._journalEntryMap.values());
  }

  // ── Private helpers ───────────────────────────────────────────────────────

  /**
   * Generate a single journal line (CREDIT or DEBIT).
   *
   * Java ref: lines 79-126
   */
  _generateJournalLine(creditDebit, journalHeader, invoiceHeader, invoiceLine,
                       journalMapping, charge, costCenterCode) {
    const journalLine = {
      jeLineNum                  : journalHeader.journalLines.length + 1,
      periodName                 : accountingPeriodName(invoiceHeader.saleDate),
      accountingDate             : invoiceHeader.saleDate,
      currencyCode               : invoiceHeader.invoiceCurrencyCode,
      groupId                    : journalHeader.txnNumber,
      salesOrder                 : invoiceLine.salesOrder,
      ledgerId                   : journalMapping.ledgerId,
      chartOfAccountsId          : journalMapping.chartOfAccountsId,
      jeSourceName               : journalMapping.jeSource,
      jeCategoryName             : journalMapping.jeCategory,
      // Java lines 93-94: userJe* mirrors je*
      userJeSourceName           : journalMapping.jeSource,
      userJeCategoryName         : journalMapping.jeCategory,
      segment1                   : journalMapping.company,
      segment2                   : journalMapping.account,
      segment3                   : journalMapping.department,
      segment4                   : costCenterCode,
      segment5                   : '00',
      segment6                   : journalMapping.interCompany,
      segment7                   : journalMapping.futUsed,
      segment8                   : '00',
      segment9                   : '00',
      segment10                  : '00',
      transactionDate            : invoiceHeader.saleDate,
      userCurrencyConversionType : 'User',
      currencyConversionType     : 'Corporate',
      currencyConversionRate     : 1,
      currencyConversionDate     : invoiceHeader.saleDate,
      taxCode                    : 'N',
      averageJournalFlag         : false,
    };

    // Java lines 109-115: when creditDebit === 'CREDIT' set the Dr (debit) amounts;
    // when creditDebit === 'DEBIT' set the Cr (credit) amounts.
    // This deliberately inverts the naming to match the Java FusionJournalEntryMapping
    // lines 109-115, which uses the same reversed convention.
    if (creditDebit === 'CREDIT') {
      journalLine.enteredDrAmount = charge;
      journalLine.accountedDr     = charge;
    } else {
      journalLine.enteredCrAmount = charge;
      journalLine.accountedCr     = charge;
    }

    return journalLine;
  }

  /**
   * Build a new JournalHeader from invoice metadata.
   *
   * Java ref: lines 148-166
   */
  _populateJournalHeader(isFixed, invoiceHeader, transactionNumber, journalMapping) {
    const periodName = accountingPeriodName(invoiceHeader.saleDate);
    return {
      customerType         : journalMapping.serviceProvider,
      cashCredit           : isFixed ? 'CASH' : 'CREDIT',
      batchName            : `${periodName}: ${journalMapping.serviceProvider}`,
      batchDescription     : `Journal Import: ${transactionNumber}`,
      accountingPeriodName : periodName,
      accountingDate       : invoiceHeader.saleDate,
      ledgerId             : journalMapping.ledgerId,
      userSourceName       : journalMapping.jeSource,
      userCategoryName     : journalMapping.jeCategory,
      txnNumber            : Number(transactionNumber),
      errorToSuspenseFlag  : false,
      summaryFlag          : false,
      journalLines         : [],
    };
  }

  /**
   * Journal header deduplication key.
   * Java ref: lines 132-138
   */
  _getJournalKey(isFixed, transactionNumber, customerType) {
    return `${isFixed ? 'FIXED' : 'BANK'}***${transactionNumber}***${customerType}`;
  }

  /**
   * Journal line deduplication key.
   * Java ref: lines 140-145
   */
  _getJournalLineKey(isFixed, transactionNumber, salesOrder, customerType) {
    return `${this._getJournalKey(isFixed, transactionNumber, customerType)}***${salesOrder}`;
  }
}

module.exports = FusionJournalEntryMapping;
