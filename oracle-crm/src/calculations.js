'use strict';

/**
 * calculations.js
 *
 * JavaScript port of every calculation performed in the Java codebase before
 * data is sent to Oracle Fusion.  All arithmetic uses plain JS Number for
 * values that come from the UI; the functions return plain Number/String
 * values ready to be dropped into Oracle REST request bodies.
 *
 * Source references (Java):
 *   - VendHQSalesToFusionInvRecIntBackup.java  : lines 84-98
 *   - FusionInvoiceMapping.java                : lines 50-80
 *   - FusionInvTxnMapping.java                 : lines 52-58
 *   - VendHQSalesToFusionInvRecTransBackup.java: lines 101-247
 *   - FusionJournalEntryMapping.java           : lines 68-170
 *   - MappingUtils.java                        : lines 14-20
 */

// ── 1. Timezone / Date helpers ──────────────────────────────────────────────

/**
 * Extract whole-hours part from a decimal timezone offset.
 * Java: timeZoneOffset.intValue()
 * Example: 3.5 → 3
 */
function hoursFromOffset(tzOffset) {
  return Math.trunc(tzOffset);
}

/**
 * Extract fractional minutes from a decimal timezone offset.
 * Java: (int)((minutesDecimal * 100 % 100) * 60 / 100)
 * Example: 3.5 → 30 minutes
 */
function minutesFromOffset(tzOffset) {
  const abs = Math.abs(tzOffset);
  return Math.trunc(((abs * 100) % 100) * 60 / 100);
}

/**
 * Apply timezone offset to a UTC Date object.
 * Java: MappingUtils.getTimeZoneOffsetDate(utcDate, hoursOffset, minutesOffset)
 * Returns a new Date adjusted by the given hours + minutes.
 */
function applyTimezoneOffset(utcDate, tzOffset) {
  const h = hoursFromOffset(tzOffset);
  const m = minutesFromOffset(tzOffset);
  const d = new Date(utcDate.getTime());
  d.setTime(d.getTime() + h * 3600000 + m * 60000);
  return d;
}

// ── 2. Date-range / day-window helpers ──────────────────────────────────────

/**
 * Days between two dates (truncated to integer).
 * Java: (int)((currentTime - lastSaleTime) / 86_400_000)
 */
function daysBetween(dateA, dateB) {
  return Math.trunc(Math.abs(dateA.getTime() - dateB.getTime()) / 86400000);
}

/**
 * Determine how many days to process.
 * Java lines 97-98.
 *   isManual=false → use calculated diff
 *   isManual=true  → use supplied dateRange (min 1)
 *   Hard cap at 7
 *
 * Returns { daysToAdd, finalDaysAddition }
 */
function calculateDayWindow(isManual, dateRange, diffDays) {
  const daysToAdd = isManual
    ? (dateRange <= 0 ? 1 : dateRange)
    : diffDays;
  const finalDaysAddition = daysToAdd <= 7 ? daysToAdd - 1 : 7;
  return { daysToAdd, finalDaysAddition };
}

// ── 3. Invoice grouping key ──────────────────────────────────────────────────

/**
 * Build the sale-group key used to aggregate sales into one daily invoice.
 * Java lines 101-110.
 *
 * NOTE: Java's Calendar.MONTH is 0-indexed (January = 0).
 * The key therefore uses the 0-indexed month to stay consistent with the
 * existing system.
 *
 * @param {Date}   saleDate      – regional (timezone-adjusted) sale date
 * @param {string} customerType  – e.g. "NORMAL", "HUNGERSTATION"
 * @param {boolean} hasCreditOnCust – true if any payment is "Credit On Cust"
 */
function buildSaleKey(saleDate, customerType, hasCreditOnCust) {
  const day   = saleDate.getDate();                // 1-31
  const month = saleDate.getMonth();               // 0-indexed  (Jan=0)
  const year  = saleDate.getFullYear();
  let key = `${day}-${month}-${year}${customerType}`;
  if (hasCreditOnCust) key += '**Credit';
  return key;
}

// ── 4. Invoice line calculations ────────────────────────────────────────────

/**
 * Unit selling price.
 * Java: sellingPrice.abs()  where sellingPrice = totalPrice / quantity
 * Always positive.
 */
function unitSellingPrice(totalPrice, quantity) {
  if (!quantity || quantity === 0) return 0;
  return Math.abs(totalPrice / quantity);
}

/**
 * Quantity override for Discount Items.
 * Java lines 64-65.
 * If itemName === "Discount Item" AND totalPrice > 0, force quantity to 1.
 */
function effectiveQuantity(itemName, totalPrice, quantity) {
  if (itemName === 'Discount Item' && totalPrice > 0) return 1;
  return quantity;
}

/**
 * Conversion rate type for invoice header.
 * Java line 50: "1" → "Corporate", else "User"
 */
function conversionRateType(rateIsCorporate) {
  return rateIsCorporate === '1' ? 'Corporate' : 'User';
}

// ── 5. Inventory transaction calculations ───────────────────────────────────

/**
 * Transaction quantity – always negative for Oracle Inventory.
 * Java line 52: lineItem.getQuantity().doubleValue() * -1
 */
function inventoryTransactionQty(quantity) {
  return quantity * -1;
}

/**
 * Inventory transaction type.
 * Java lines 53-58.
 * For NORMAL customers: "Vend Sales Issue" / "Vend RMA"
 * For others: use costIssue / costRMA from ServiceProviderJournalMapping
 */
function inventoryTransactionType(totalPrice, quantity, costIssue, costRMA) {
  const issue = costIssue || 'Vend Sales Issue';
  const rma   = costRMA   || 'Vend RMA';

  if (totalPrice === 0) {
    return quantity > 0 ? issue : rma;
  }
  return totalPrice > 0 ? issue : rma;
}

// ── 6. Receipt amount calculations ──────────────────────────────────────────

/**
 * Cash account name by region.
 * Java lines 211, 213.
 */
function cashAccountName(region) {
  return region === 'KW' ? 'Cash KW' : 'Cash';
}

/**
 * Miscellaneous receipt charge (bank charge + tax, or cash rounding).
 * Java lines 238-245.
 *
 * @param {number} paymentAmount
 * @param {string} paymentType
 * @param {number} bankChargeRate  – e.g. 0.02 for 2%
 * @param {number} methodTax       – e.g. 0.05 for 5%
 * @param {string} region
 * @returns {number} miscCharges
 */
function calculateMiscCharges(paymentAmount, paymentType, bankChargeRate, methodTax, region) {
  const type = (paymentType || '').toLowerCase();
  let miscCharges;

  if (type === 'cash rounding') {
    miscCharges = paymentAmount;
  } else {
    const temp1 = paymentAmount * bankChargeRate;
    const temp2 = methodTax + 1;
    miscCharges = temp1 * temp2;

    // Oman Debit Card cap (Java line 244)
    if (paymentType === 'Debit Card' && region === 'OM' && miscCharges > 10) {
      miscCharges = 10;
    }
  }

  return miscCharges;
}

/**
 * Net receipt amount = gross receipt - misc charges.
 * Java line 247.
 */
function netReceiptAmount(grossAmount, miscCharges) {
  return grossAmount - miscCharges;
}

// ── 7. Journal entry calculations ───────────────────────────────────────────

/**
 * Journal entry charge (bank charge percentage or fixed freight).
 * Java lines 68-72.
 *
 * @param {number}       saleTotal         – total invoice amount
 * @param {number|null}  bankChargeRate     – e.g. 0.02
 * @param {boolean}      isFixed           – use fixed freight?
 * @param {number|null}  fixedFreightCharge – configured fixed amount
 * @returns {number} finalCharge
 */
function calculateJournalCharge(saleTotal, bankChargeRate, isFixed, fixedFreightCharge) {
  const saleBankCharge = saleTotal * (bankChargeRate || 0);

  if (isFixed) {
    return fixedFreightCharge != null ? fixedFreightCharge : saleBankCharge;
  }
  return saleBankCharge;
}

/**
 * Accounting period name from a date.
 * Java: SimpleDateFormat("MMM-yy").format(saleDate)
 * Example: 2024-01-15 → "Jan-24"
 */
function accountingPeriodName(date) {
  const months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  const yy = String(date.getFullYear()).slice(-2);
  return `${months[date.getMonth()]}-${yy}`;
}

/**
 * Journal batch name.
 * Java: getPeriodName(date) + ": " + serviceProvider
 */
function journalBatchName(date, serviceProvider) {
  return `${accountingPeriodName(date)}: ${serviceProvider}`;
}

// ── 8. Deduplication keys ────────────────────────────────────────────────────

function journalLineKey(isFixed, transactionNumber, salesOrder, customerType) {
  const prefix = isFixed ? 'FIXED' : 'BANK';
  return `${prefix}***${transactionNumber}***${customerType}***${salesOrder}`;
}

// ── 9. Compute a full sale preview ──────────────────────────────────────────

/**
 * Given raw sale input (as you would get from the CRM form), run all
 * calculations and return the computed values for preview before pushing.
 *
 * @param {object} sale
 * @param {Array}  sale.lineItems     – [{itemName, itemNumber, quantity, totalPrice, taxName}]
 * @param {Array}  sale.payments      – [{paymentType, amount}]
 * @param {string} sale.saleDate      – ISO date string (UTC)
 * @param {string} sale.customerType
 * @param {string} sale.region
 * @param {number} sale.tzOffset      – e.g. 4 for UAE
 * @param {object} sale.receiptMethodMeta  – {[paymentType]: {bankChargeRate, methodTax}}
 * @returns {object} computed
 */
function computeSalePreview(sale) {
  const utcDate   = new Date(sale.saleDate);
  const localDate = applyTimezoneOffset(utcDate, sale.tzOffset || 0);

  const hasCreditOnCust = (sale.payments || []).some(
    p => (p.paymentType || '').toLowerCase() === 'credit on cust'
  );
  const saleKey = buildSaleKey(localDate, sale.customerType, hasCreditOnCust);

  // Invoice lines
  // Java FusionInvTxnMapping: non-NORMAL customers use costIssue/costRMA from
  // ServiceProviderJournalMapping instead of hardcoded "Vend Sales Issue"/"Vend RMA".
  const costIssue = (sale.customerType !== 'NORMAL' && sale.journalMeta)
    ? sale.journalMeta.costIssue : undefined;
  const costRMA   = (sale.customerType !== 'NORMAL' && sale.journalMeta)
    ? sale.journalMeta.costRMA   : undefined;

  const lines = (sale.lineItems || [])
    .filter(l => Number(l.quantity) !== 0)
    .map((l, idx) => {
      const origQty = Number(l.quantity);
      const qty  = effectiveQuantity(l.itemName, Number(l.totalPrice), origQty);
      // Java: sellingPrice = totalPrice.divide(lineItem.getQuantity()).abs()
      // Always use original quantity for USP, matching Java middleware exactly.
      const usp  = unitSellingPrice(Number(l.totalPrice), origQty);
      const invQty = inventoryTransactionQty(origQty);
      const txnType = inventoryTransactionType(Number(l.totalPrice), origQty, costIssue, costRMA);
      return {
        lineNumber      : l.lineNumber || (idx + 1),
        itemName        : l.itemName,
        itemNumber      : l.itemNumber,
        originalQty     : origQty,
        effectiveQty    : qty,
        totalPrice      : Number(l.totalPrice),
        unitSellingPrice: usp,
        taxName         : l.taxName,
        inventoryQty    : invQty,
        transactionType : txnType,
      };
    });

  // Receipts
  const receiptSummary = [];
  let totalMiscCharges  = 0;
  let totalNetReceipt   = 0;

  (sale.payments || []).forEach(p => {
    const amount = Number(p.amount);
    const meta   = (sale.receiptMethodMeta || {})[p.paymentType] || { bankChargeRate: 0, methodTax: 0 };
    const misc   = calculateMiscCharges(amount, p.paymentType, meta.bankChargeRate, meta.methodTax, sale.region);
    const net    = netReceiptAmount(amount, misc);
    totalMiscCharges += misc;
    totalNetReceipt  += net;

    receiptSummary.push({
      paymentType      : p.paymentType,
      grossAmount      : amount,
      bankChargeRate   : meta.bankChargeRate,
      methodTax        : meta.methodTax,
      miscCharges      : misc,
      netReceiptAmount : net,
      isCashRounding   : (p.paymentType || '').toLowerCase() === 'cash rounding',
      cashAccountName  : cashAccountName(sale.region),
    });
  });

  // Journal (non-NORMAL only)
  let journalPreview = null;
  if (sale.customerType !== 'NORMAL') {
    const saleTotal    = lines.reduce((s, l) => s + l.totalPrice, 0);
    const bankRate     = (sale.journalMeta || {}).bankChargeRate || 0;
    const fixedCharge  = (sale.journalMeta || {}).isFixed || false;
    const fixedAmount  = (sale.journalMeta || {}).fixedFreightCharge || null;
    const charge       = calculateJournalCharge(saleTotal, bankRate, fixedCharge, fixedAmount);

    journalPreview = {
      customerType     : sale.customerType,
      saleTotal,
      bankChargeRate   : bankRate,
      isFixed          : fixedCharge,
      fixedFreightCharge: fixedAmount,
      finalCharge      : charge,
      periodName       : accountingPeriodName(localDate),
      batchName        : journalBatchName(localDate, sale.customerType),
      creditAmount     : charge,
      debitAmount      : charge,
    };
  }

  return {
    originalDate  : utcDate.toISOString(),
    adjustedDate  : localDate.toISOString(),
    saleKey,
    conversionRateType: conversionRateType((sale.rateIsCorporate || '0')),
    periodName    : accountingPeriodName(localDate),
    lines,
    receiptSummary,
    totalMiscCharges,
    totalNetReceipt,
    journalPreview,
  };
}

module.exports = {
  hoursFromOffset,
  minutesFromOffset,
  applyTimezoneOffset,
  daysBetween,
  calculateDayWindow,
  buildSaleKey,
  unitSellingPrice,
  effectiveQuantity,
  conversionRateType,
  inventoryTransactionQty,
  inventoryTransactionType,
  cashAccountName,
  calculateMiscCharges,
  netReceiptAmount,
  calculateJournalCharge,
  accountingPeriodName,
  journalBatchName,
  journalLineKey,
  computeSalePreview,
};
