'use strict';

/**
 * pushOracle.js
 *
 * Core Oracle Fusion push service.
 * Executes the 8-step API sequence in the correct order, applying all
 * business-rule calculations before each call.
 *
 * Step sequence:
 *   1. Compute all values (calculations.js)
 *   2. POST /receivablesInvoices
 *   3. POST /receivablesReceipts (standard, per payment method)
 *   4. POST applyReceiptOnAccount
 *   5. POST /receivablesReceipts (miscellaneous / bank charges)
 *   6. POST /inventoryTransactions
 *   7. POST /journals  (non-NORMAL customers only)
 */

const { computeSalePreview, applyTimezoneOffset, accountingPeriodName } = require('./calculations');
const OracleClient = require('./oracleClient');

class OraclePushService {
  constructor(baseUrl, username, password) {
    this.client = new OracleClient(baseUrl, username, password);
  }

  /**
   * Push a complete sale to Oracle Fusion.
   *
   * @param {object} sale         – sale payload (same shape as computeSalePreview)
   * @param {object} metadata     – FusionSalesMetadata fields
   * @param {object} outlet       – VendhqOutletsDB fields
   * @returns {object}            – { success, steps, errors, preview }
   */
  async pushSale(sale, metadata, outlet) {
    const log    = [];
    const errors = [];

    function step(name, status, data) {
      log.push({ step: name, status, data, ts: new Date().toISOString() });
    }

    try {
      // ── Compute all derived values ─────────────────────────────────────
      const preview = computeSalePreview(sale);
      step('calculations', 'ok', preview);

      const adjustedDate = new Date(preview.adjustedDate);
      const dateStr      = adjustedDate.toISOString().split('T')[0];

      // ── Step 2: Create Invoice ─────────────────────────────────────────
      const invoiceLines = preview.lines
        .filter(l => l.originalQty !== 0)
        .map(l => ({
          LineNumber          : l.lineNumber,
          ItemNumber          : l.itemNumber,
          MemoLineName        : l.itemName === 'Discount Item' ? 'Discount Item' : undefined,
          Description         : l.itemName,
          Quantity            : l.effectiveQty,
          UomCode             : sale.uomCodeMap ? (sale.uomCodeMap[l.itemNumber] || 'Ea') : 'Ea',
          CurrencyCode        : outlet.currency,
          UnitSellingPrice    : l.unitSellingPrice,
          SalesOrder          : sale.invoiceNumber,
          SalesOrderLine      : String(l.lineNumber),
          TaxClassificationCode: l.taxName,
        }));

      const invoicePayload = {
        BillToCustomerName  : metadata.billToName,
        BillToLocation      : metadata.siteNumber,
        BillToAccountNumber : String(metadata.billToAccount),
        BusinessUnit        : metadata.businessUnit,
        TransactionSource   : metadata.txnSource,
        TransactionType     : metadata.txnType,
        TransactionDate     : dateStr,
        GlDate              : dateStr,
        InvoiceCurrencyCode : outlet.currency,
        ConversionRateType  : preview.conversionRateType,
        invoiceLine         : invoiceLines,
      };

      const invoiceResult = await this.client.createInvoice(invoicePayload);
      step('createInvoice', 'ok', {
        transactionNumber: invoiceResult.TransactionNumber,
        customerTransactionId: invoiceResult.CustomerTransactionId,
      });

      const transactionNumber = invoiceResult.TransactionNumber;
      const customerId        = invoiceResult.CustomerAccountId;

      // ── Step 3+4: Standard Receipts per payment method ────────────────
      const standardPayments = (sale.payments || []).filter(
        p => (p.paymentType || '').toLowerCase() !== 'cash rounding'
      );

      // Group by payment type (one receipt per type per day)
      const receiptGroups = {};
      for (const p of standardPayments) {
        if (!receiptGroups[p.paymentType]) receiptGroups[p.paymentType] = 0;
        receiptGroups[p.paymentType] += Number(p.amount);
      }

      for (const [paymentType, grossAmount] of Object.entries(receiptGroups)) {
        const meta       = (sale.receiptMethodMeta || {})[paymentType] || {};
        const miscCharge = computeSalePreview({
          ...sale, payments: [{ paymentType, amount: grossAmount }]
        }).receiptSummary[0]?.miscCharges || 0;
        const netAmount  = grossAmount - miscCharge;

        const receiptPayload = {
          CurrencyCode           : outlet.currency,
          ReceiptDate            : dateStr,
          GlDate                 : dateStr,
          DepositDate            : dateStr,
          ReceiptMethodId        : meta.receiptMethodId,
          ReceiptNumber          : `${paymentType}-${transactionNumber}`,
          RemittanceBankAccountId: meta.bankAccountId,
          CustomerId             : customerId,
          Amount: { CurrencyCode: outlet.currency, Value: netAmount },
        };

        const receiptResult = await this.client.createReceipt(receiptPayload);
        step(`createReceipt:${paymentType}`, 'ok', { receiptId: receiptResult.ReceiptId });

        // Step 4: Apply receipt to invoice
        const applyPayload = {
          TransactionNumber  : transactionNumber,
          ReceiptNumber      : receiptResult.ReceiptNumber,
          AmountApplied      : netAmount,
          ReceiptCurrencyCode: outlet.currency,
          TransactionSource  : metadata.txnSource,
          ApplicationDate    : dateStr,
          AccountingDate     : dateStr,
        };
        const applyResult = await this.client.applyReceipt(receiptResult.ReceiptId, applyPayload);
        step(`applyReceipt:${paymentType}`, 'ok', { status: applyResult.Status });

        // Step 5: Miscellaneous receipt for bank charges (skip if zero)
        if (miscCharge > 0) {
          const miscPayload = {
            CurrencyCode    : outlet.currency,
            ReceiptDate     : dateStr,
            GlDate          : dateStr,
            DepositDate     : dateStr,
            ReceiptMethodId : meta.receiptMethodId,
            ReceiptNumber   : `${paymentType}-${transactionNumber}-MISC`,
            Amount          : { CurrencyCode: outlet.currency, Value: miscCharge },
          };
          const miscResult = await this.client.createReceipt(miscPayload);
          step(`createMiscReceipt:${paymentType}`, 'ok', { receiptId: miscResult.ReceiptId });
        }
      }

      // Cash rounding receipts
      const cashRoundingPayments = (sale.payments || []).filter(
        p => (p.paymentType || '').toLowerCase() === 'cash rounding'
      );
      for (const p of cashRoundingPayments) {
        const crPayload = {
          CurrencyCode : outlet.currency,
          ReceiptDate  : dateStr,
          GlDate       : dateStr,
          DepositDate  : dateStr,
          ReceiptNumber: `CashRounding-${transactionNumber}`,
          Amount       : { CurrencyCode: outlet.currency, Value: Number(p.amount) },
        };
        await this.client.createReceipt(crPayload);
        step('createCashRoundingReceipt', 'ok', {});
      }

      // ── Step 6: Inventory Transactions ────────────────────────────────
      const txnLines = preview.lines
        .filter(l => l.originalQty !== 0)
        .map(l => ({
          OrganizationName        : outlet.organizationName || outlet.outletName,
          Item                    : l.itemNumber,
          TransactionSourceName   : sale.invoiceNumber,
          Subinventory            : outlet.outletName,
          TransactionUnitOfMeasure: sale.uomCodeMap ? (sale.uomCodeMap[l.itemNumber] || 'Ea') : 'Ea',
          TransactionDate         : dateStr,
          TransactionQuantity     : l.inventoryQty,
          TransactionType         : l.transactionType,
        }));

      if (txnLines.length > 0) {
        await this.client.createInventoryTransaction({ transactionLines: txnLines });
        step('createInventoryTransactions', 'ok', { count: txnLines.length });
      }

      // ── Step 7: Journal Entry (non-NORMAL customers only) ─────────────
      if (preview.journalPreview) {
        const jp      = preview.journalPreview;
        const jm      = sale.journalMeta || {};
        const jLines  = [];

        // CREDIT line
        jLines.push({
          JeLineNum              : 1,
          PeriodName             : jp.periodName,
          AccountingDate         : dateStr,
          CurrencyCode           : outlet.currency,
          GroupId                : Number(transactionNumber),
          SalesOrder             : sale.invoiceNumber,
          LedgerId               : jm.ledgerId,
          ChartOfAccountsId      : jm.chartOfAccountsId,
          JeSourceName           : jm.jeSource,
          JeCategoryName         : jm.jeCategory,
          Segment1               : jm.company,
          Segment2               : jm.account,
          Segment3               : jm.department,
          Segment4               : metadata.costCenterCode || jm.costCenterCode,
          Segment5               : '00',
          Segment6               : jm.interCompany,
          Segment7               : jm.futUsed,
          Segment8               : '00', Segment9: '00', Segment10: '00',
          EnteredDrAmount        : jp.creditAmount,
          AccountedDr            : jp.creditAmount,
          UserCurrencyConversionType: 'User',
          CurrencyConversionType : 'Corporate',
          CurrencyConversionRate : 1,
          TaxCode                : 'N',
          AverageJournalFlag     : false,
        });

        // DEBIT line
        jLines.push({
          JeLineNum              : 2,
          PeriodName             : jp.periodName,
          AccountingDate         : dateStr,
          CurrencyCode           : outlet.currency,
          GroupId                : Number(transactionNumber),
          SalesOrder             : sale.invoiceNumber,
          LedgerId               : jm.ledgerId,
          ChartOfAccountsId      : jm.chartOfAccountsId,
          JeSourceName           : jm.jeSource,
          JeCategoryName         : jm.jeCategory,
          Segment1               : jm.company,
          Segment2               : jm.debitAccount || jm.account,
          Segment3               : jm.department,
          Segment4               : metadata.costCenterCode || jm.costCenterCode,
          Segment5               : '00',
          Segment6               : jm.interCompany,
          Segment7               : jm.futUsed,
          Segment8               : '00', Segment9: '00', Segment10: '00',
          EnteredCrAmount        : jp.debitAmount,
          AccountedCr            : jp.debitAmount,
          UserCurrencyConversionType: 'User',
          CurrencyConversionType : 'Corporate',
          CurrencyConversionRate : 1,
          TaxCode                : 'N',
          AverageJournalFlag     : false,
        });

        const journalPayload = {
          BatchName            : jp.batchName,
          BatchDescription     : `Journal Import: ${transactionNumber}`,
          AccountingPeriodName : jp.periodName,
          LedgerId             : jm.ledgerId,
          UserSourceName       : jm.jeSource,
          UserCategoryName     : jm.jeCategory,
          ErrorToSuspenseFlag  : false,
          SummaryFlag          : false,
          JournalLines         : jLines,
        };

        await this.client.createJournal(journalPayload);
        step('createJournal', 'ok', { batchName: jp.batchName });
      }

      return {
        success : true,
        steps   : log,
        errors  : [],
        preview,
        transactionNumber,
      };

    } catch (err) {
      const msg = err.response
        ? `Oracle API error ${err.response.status}: ${JSON.stringify(err.response.data)}`
        : err.message;
      errors.push(msg);
      step('ERROR', 'failed', { message: msg });

      return {
        success : false,
        steps   : log,
        errors,
        preview : null,
      };
    }
  }
}

module.exports = OraclePushService;
