'use strict';

/**
 * pushOracle.js
 *
 * Core Oracle Fusion push service.
 * Executes the 8-step API sequence in the correct order, applying all
 * business-rule calculations before each call.
 *
 * Step sequence (matches Java middleware VendHQSalesToFusionInvRecIntBackup):
 *   1. Compute all values (calculations.js)
 *   2. POST /receivablesInvoices
 *   3. POST /receivablesReceipts (standard, per payment method)
 *   4. POST applyReceiptOnAccount  (with retry logic – up to 50 retries)
 *   5. POST /receivablesMiscellaneousReceipts (bank charges / cash rounding)
 *   6. POST /inventoryTransactions
 *   7. POST /journals  (non-NORMAL customers only)
 */

const { computeSalePreview, applyTimezoneOffset, accountingPeriodName } = require('./calculations');
const OracleClient = require('./oracleClient');

/** Maximum retries for apply-receipt (Java: lines 296-321) */
const APPLY_RECEIPT_MAX_RETRIES = 50;
/** Amount to decrement on each retry (Java: BigDecimal.valueOf(0.01)) */
const APPLY_RECEIPT_DECREMENT   = 0.01;

/**
 * Remove keys whose values are null or undefined from an object.
 * Oracle Fusion REST API rejects payloads containing null-valued fields
 * that it does not expect.
 */
function stripNulls(obj) {
  if (obj == null || typeof obj !== 'object') return obj;
  if (Array.isArray(obj)) return obj.map(stripNulls);
  const clean = {};
  for (const [k, v] of Object.entries(obj)) {
    if (v == null) continue;                 // skip null / undefined
    clean[k] = typeof v === 'object' ? stripNulls(v) : v;
  }
  return clean;
}

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
        .map(l => {
          const line = {
            LineNumber          : l.lineNumber,
            ItemNumber          : l.itemNumber,
            Description         : l.itemName,
            Quantity            : l.effectiveQty,
            UomCode             : sale.uomCodeMap ? (sale.uomCodeMap[l.itemNumber] || 'Ea') : 'Ea',
            CurrencyCode        : outlet.currency,
            UnitSellingPrice    : l.unitSellingPrice,
            SalesOrder          : sale.invoiceNumber,
            SalesOrderLine      : String(l.lineNumber),
          };
          // Java: if (lineItem.getItemName().equals("Discount Item")) invoiceLine.setMemoLineName("Discount Item");
          if (l.itemName === 'Discount Item') line.MemoLineName = 'Discount Item';
          // Java: invoiceLine.setTaxClassificationCode(lineItem.getTaxName());
          if (l.taxName) line.TaxClassificationCode = l.taxName;
          return line;
        });

      // Resolve PaymentTermsName: metadata override → Oracle customer lookup → default.
      // Java: FusionCustomerProfileClient.getPaymentTerms(billToAccountNumber)
      let paymentTermsName = metadata.paymentTermsName || null;
      if (!paymentTermsName) {
        try {
          const cust = await this.client.getCustomer(metadata.billToAccount);
          paymentTermsName = (cust && cust.PaymentTerms) || 'Immediate';
        } catch (lookupErr) {
          step('lookupPaymentTerms', 'warn', {
            message: `Customer lookup failed, defaulting PaymentTermsName to Immediate: ${lookupErr.message}`,
          });
          paymentTermsName = 'Immediate';
        }
      }

      const invoicePayload = stripNulls({
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
        PaymentTermsName    : paymentTermsName,
        invoiceLine         : invoiceLines,
      });

      // Validate that the invoice has at least one line – Oracle rejects empty invoices
      if (!invoiceLines || invoiceLines.length === 0) {
        const msg = `Invoice has no line items (${preview.lines.length} lines computed, all filtered out). Check that sale order lines were fetched from Odoo (PosOrderLine endpoint).`;
        step('createInvoice', 'failed', { message: msg, invoicePayload });
        errors.push(msg);
        return { success: false, steps: log, errors, preview: null };
      }

      // Log the payload being sent for diagnostic purposes
      step('invoicePayload', 'debug', {
        lineCount: invoiceLines.length,
        billToName: metadata.billToName,
        businessUnit: metadata.businessUnit,
        currency: outlet.currency,
        paymentTermsName,
        date: dateStr,
      });

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
      // Java: standardReceiptRequest.setReceiptAmount(standardReceiptRequest.getReceiptAmount().add(payment.getAmount()))
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

        // Skip receipts with zero or negative amounts (Java: lines 237-240)
        if (netAmount <= 0) continue;

        const receiptPayload = stripNulls({
          CurrencyCode           : outlet.currency,
          ReceiptDate            : dateStr,
          GlDate                 : dateStr,
          DepositDate            : dateStr,
          ReceiptMethodId        : meta.receiptMethodId,
          ReceiptNumber          : `${paymentType}-${transactionNumber}`,
          RemittanceBankAccountId: meta.bankAccountId,
          CustomerId             : customerId,
          OrgId                  : meta.orgId || metadata.orgId,
          Amount: { CurrencyCode: outlet.currency, Value: netAmount },
        });

        const receiptResult = await this.client.createReceipt(receiptPayload);
        step(`createReceipt:${paymentType}`, 'ok', { receiptId: receiptResult.ReceiptId });

        // Step 4: Apply receipt to invoice – with retry logic (Java: lines 296-321)
        // On failure, decrement AmountApplied by 0.01 and retry up to 50 times.
        let applyAmount = netAmount;
        let applySuccess = false;
        for (let attempt = 0; attempt <= APPLY_RECEIPT_MAX_RETRIES; attempt++) {
          try {
            const applyPayload = stripNulls({
              TransactionNumber  : transactionNumber,
              ReceiptNumber      : receiptResult.ReceiptNumber,
              AmountApplied      : applyAmount,
              ReceiptCurrencyCode: outlet.currency,
              TransactionSource  : metadata.txnSource,
              ApplicationDate    : dateStr,
              AccountingDate     : dateStr,
            });
            const applyResult = await this.client.applyReceipt(receiptResult.ReceiptId, applyPayload);
            step(`applyReceipt:${paymentType}`, 'ok', { status: applyResult.Status, attempt });
            applySuccess = true;
            break;
          } catch (applyErr) {
            if (attempt < APPLY_RECEIPT_MAX_RETRIES) {
              // Round after decrement to avoid floating-point drift over 50 iterations
              applyAmount = Math.round((applyAmount - APPLY_RECEIPT_DECREMENT) * 100) / 100;
            } else {
              // Final attempt failed – log and continue
              const applyMsg = applyErr.response
                ? `Apply receipt failed after ${APPLY_RECEIPT_MAX_RETRIES} retries: Oracle API error ${applyErr.response.status}: ${JSON.stringify(applyErr.response.data)}`
                : `Apply receipt failed after ${APPLY_RECEIPT_MAX_RETRIES} retries: ${applyErr.message}`;
              step(`applyReceipt:${paymentType}`, 'failed', { message: applyMsg, attempt });
              errors.push(applyMsg);
            }
          }
        }

        if (!applySuccess) {
          step(`applyReceipt:${paymentType}`, 'warn', {
            message: 'Apply receipt was not successful; proceeding with remaining steps',
          });
        }

        // Step 5: Miscellaneous receipt for bank charges (skip if zero)
        // Java: miscReceiptRequest.setReceiptAmount(miscReceiptRequest.getReceiptAmount().subtract(miscCharges))
        // REST endpoint: POST /receivablesMiscellaneousReceipts (not /receivablesReceipts)
        if (miscCharge > 0) {
          const miscPayload = stripNulls({
            CurrencyCode              : outlet.currency,
            ReceiptDate               : dateStr,
            GlDate                    : dateStr,
            ReceiptMethodId           : meta.receiptMethodId,
            ReceiptMethodName         : meta.receiptMethodName || paymentType,
            ReceiptNumber             : `${paymentType}-${transactionNumber}-MISC`,
            RemittanceBankAccountName : meta.bankAccountName,
            ReceivableActivityName    : meta.receivableActivityName,
            OrgId                     : meta.orgId || metadata.orgId,
            Amount                    : { CurrencyCode: outlet.currency, Value: miscCharge },
          });
          const miscResult = await this.client.createMiscReceipt(miscPayload);
          step(`createMiscReceipt:${paymentType}`, 'ok', { receiptId: miscResult.MiscReceiptId });
        }
      }

      // Cash rounding receipts – these are miscellaneous receipts
      // Java: if (payment.getPaymentType().toLowerCase().equals("cash rounding")) miscCharges = payment.getAmount()
      // REST endpoint: POST /receivablesMiscellaneousReceipts (not /receivablesReceipts)
      const cashRoundingPayments = (sale.payments || []).filter(
        p => (p.paymentType || '').toLowerCase() === 'cash rounding'
      );
      for (const p of cashRoundingPayments) {
        const methodMeta = sale.receiptMethodMeta || {};
        const crMeta = methodMeta['cash rounding'] || methodMeta['Cash Rounding'] || {};
        const crPayload = stripNulls({
          CurrencyCode              : outlet.currency,
          ReceiptDate               : dateStr,
          GlDate                    : dateStr,
          ReceiptMethodId           : crMeta.receiptMethodId,
          ReceiptMethodName         : crMeta.receiptMethodName || 'Cash Rounding',
          ReceiptNumber             : `CashRounding-${transactionNumber}`,
          RemittanceBankAccountName : crMeta.bankAccountName,
          ReceivableActivityName    : crMeta.receivableActivityName || 'Cash Rounding',
          OrgId                     : crMeta.orgId || metadata.orgId,
          Amount                    : { CurrencyCode: outlet.currency, Value: Number(p.amount) },
        });
        await this.client.createMiscReceipt(crPayload);
        step('createCashRoundingReceipt', 'ok', {});
      }

      // ── Step 6: Inventory Transactions ────────────────────────────────
      // Java middleware: FusionInvTxnMapping.mapToInvTransactionModel
      // Java serialises TransactionDate as full ISO-8601 datetime with offset
      // (Gson: "yyyy-MM-dd'T'HH:mm:ssXXX").  adjustedDate is already
      // timezone-shifted via applyTimezoneOffset, so the UTC values encode
      // the local wall-clock time – matching the Java middleware behaviour.
      const invDateStr = adjustedDate.toISOString().replace(/\.\d{3}Z$/, '+00:00');
      const txnLines = preview.lines
        .filter(l => l.originalQty !== 0)
        .map(l => ({
          OrganizationName        : outlet.organizationName || outlet.outletName,
          Item                    : l.itemNumber,
          TransactionSourceName   : sale.invoiceNumber,
          Subinventory            : outlet.outletName,
          TransactionUnitOfMeasure: sale.uomCodeMap ? (sale.uomCodeMap[l.itemNumber] || 'Ea') : 'Ea',
          TransactionDate         : invDateStr,
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

        // CREDIT line (Java: generateJournalLine("CREDIT", ...))
        // Java sets both JeSourceName and UserJeSourceName to the same value
        // (FusionJournalEntryMapping lines 331-333); Oracle requires both.
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
          UserJeSourceName       : jm.jeSource,
          UserJeCategoryName     : jm.jeCategory,
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
          CurrencyConversionDate : dateStr,
          TaxCode                : 'N',
          TransactionDate        : dateStr,
          AverageJournalFlag     : false,
        });

        // DEBIT line (Java: generateJournalLine("DEBIT", ...))
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
          UserJeSourceName       : jm.jeSource,
          UserJeCategoryName     : jm.jeCategory,
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
          CurrencyConversionDate : dateStr,
          TaxCode                : 'N',
          TransactionDate        : dateStr,
          AverageJournalFlag     : false,
        });

        const journalPayload = stripNulls({
          BatchName            : jp.batchName,
          BatchDescription     : `Journal Import: ${transactionNumber}`,
          AccountingPeriodName : jp.periodName,
          AccountingDate       : dateStr,
          LedgerId             : jm.ledgerId,
          UserSourceName       : jm.jeSource,
          UserCategoryName     : jm.jeCategory,
          ErrorToSuspenseFlag  : false,
          SummaryFlag          : false,
          JournalLine          : jLines,
        });

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
      const lastOkStep = log.filter(s => s.status === 'ok').pop();
      const failedAfter = lastOkStep ? lastOkStep.step : '(before first API call)';

      // Build a detailed message including request details when Oracle returns
      // an empty body (common with 400 errors for missing/invalid fields).
      let msg;
      if (err.response) {
        const respBody = err.response.data;
        const bodyStr = respBody && typeof respBody === 'object'
          ? JSON.stringify(respBody)
          : JSON.stringify(respBody);
        const reqUrl   = err.config ? err.config.url : 'unknown';
        const reqData  = err.config && err.config.data
          ? (typeof err.config.data === 'string' ? err.config.data.substring(0, 500) : JSON.stringify(err.config.data).substring(0, 500))
          : '';
        const emptyHint = (!respBody || respBody === '')
          ? '. Empty response body typically means a required field is missing or has an invalid value. Check BillToCustomerName, BillToAccountNumber, BusinessUnit, TransactionSource, TransactionType, PaymentTermsName, InvoiceCurrencyCode, and invoice line items.'
          : '';
        msg = `Oracle API error ${err.response.status} (after ${failedAfter}): ${bodyStr}${emptyHint}`;
        step('ERROR', 'failed', { message: msg, requestUrl: reqUrl, requestPayload: reqData });
      } else {
        msg = `${err.message} (after ${failedAfter})`;
        step('ERROR', 'failed', { message: msg });
      }
      errors.push(msg);

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
