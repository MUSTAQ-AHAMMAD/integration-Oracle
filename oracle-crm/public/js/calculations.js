/**
 * calculations.js  (browser-side)
 *
 * Mirrors src/calculations.js so the CRM form can show live calculation
 * previews without a round-trip to the server.
 */

const Calc = (() => {
  function hoursFromOffset(tz)  { return Math.trunc(tz); }
  function minutesFromOffset(tz) {
    const abs = Math.abs(tz);
    return Math.trunc(((abs * 100) % 100) * 60 / 100);
  }
  function applyTimezoneOffset(utcDate, tz) {
    const h = hoursFromOffset(tz);
    const m = minutesFromOffset(tz);
    return new Date(utcDate.getTime() + h * 3600000 + m * 60000);
  }
  function buildSaleKey(d, customerType, hasCreditOnCust) {
    let key = `${d.getDate()}-${d.getMonth()}-${d.getFullYear()}${customerType}`;
    if (hasCreditOnCust) key += '**Credit';
    return key;
  }
  function unitSellingPrice(totalPrice, qty) {
    if (!qty || qty === 0) return 0;
    return Math.abs(totalPrice / qty);
  }
  function effectiveQty(itemName, totalPrice, qty) {
    if (itemName === 'Discount Item' && totalPrice > 0) return 1;
    return qty;
  }
  function calcMiscCharges(amount, paymentType, bankRate, tax, region) {
    const type = (paymentType || '').toLowerCase();
    if (type === 'cash rounding') return amount;
    let misc = amount * bankRate * (tax + 1);
    if (paymentType === 'Debit Card' && region === 'OM' && misc > 10) misc = 10;
    return misc;
  }
  function netReceipt(gross, misc) { return gross - misc; }
  function journalCharge(total, bankRate, isFixed, fixedAmt) {
    const pct = total * (bankRate || 0);
    if (isFixed) return fixedAmt != null ? fixedAmt : pct;
    return pct;
  }
  function periodName(date) {
    const M = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    return `${M[date.getMonth()]}-${String(date.getFullYear()).slice(-2)}`;
  }

  function computePreview(sale) {
    const utcDate   = new Date(sale.saleDate);
    const localDate = applyTimezoneOffset(utcDate, sale.tzOffset || 0);
    const hasCred   = (sale.payments || []).some(p => (p.paymentType||'').toLowerCase() === 'credit on cust');
    const saleKey   = buildSaleKey(localDate, sale.customerType, hasCred);

    const lines = (sale.lineItems || [])
      .filter(l => Number(l.quantity) !== 0)
      .map((l, i) => {
        const tp  = Number(l.totalPrice);
        const q   = Number(l.quantity);
        const eq  = effectiveQty(l.itemName, tp, q);
        const usp = unitSellingPrice(tp, eq);
        return {
          no: i + 1, itemName: l.itemName, itemNumber: l.itemNumber,
          originalQty: q, effectiveQty: eq, totalPrice: tp,
          unitSellingPrice: usp, taxName: l.taxName,
          inventoryQty: q * -1,
        };
      });

    const receipts = (sale.payments || []).map(p => {
      const amt  = Number(p.amount);
      const meta = (sale.receiptMethodMeta || {})[p.paymentType] || { bankChargeRate: 0, methodTax: 0 };
      const misc = calcMiscCharges(amt, p.paymentType, meta.bankChargeRate || 0, meta.methodTax || 0, sale.region);
      return {
        paymentType: p.paymentType, grossAmount: amt,
        miscCharges: misc, netAmount: netReceipt(amt, misc),
        bankChargeRate: meta.bankChargeRate, methodTax: meta.methodTax,
      };
    });

    let journal = null;
    if (sale.customerType && sale.customerType !== 'NORMAL') {
      const total  = lines.reduce((s, l) => s + l.totalPrice, 0);
      const jm     = sale.journalMeta || {};
      const charge = journalCharge(total, jm.bankChargeRate, jm.isFixed, jm.fixedFreightCharge);
      journal = {
        saleTotal: total, charge,
        periodName: periodName(localDate),
        batchName : `${periodName(localDate)}: ${sale.customerType}`,
      };
    }

    return { saleKey, adjustedDate: localDate, lines, receipts, journal,
             periodName: periodName(localDate) };
  }

  return { computePreview, calcMiscCharges, unitSellingPrice, effectiveQty, periodName, applyTimezoneOffset };
})();
