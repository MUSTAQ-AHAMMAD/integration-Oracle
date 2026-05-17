'use strict';

/**
 * odooMapperExample.js
 *
 * Example usage of the Odoo to VendHQ mapper module.
 * Demonstrates how to map Odoo API data to VendHQ backup table structure.
 *
 * This file can be used as a reference for Oracle DB integration or testing.
 */

const odooMapper = require('./odooToVendhqMapper');

// ── Example 1: Map a complete sale with lines and payments ────────────────────

function exampleCompleteSale() {
  console.log('\n=== Example 1: Complete Sale Mapping ===\n');

  // Sample Odoo sale.order data (from API)
  const odooSale = {
    id: 12345,
    name: 'POS/2024/001',
    date_order: '2024-05-17T14:30:00',
    warehouse_id: [1, 'Dubai Mall Store'],
    pos_config_id: [10, 'Register 01'],
    partner_id: [500, 'Walk-In Customer'],
    currency_id: [1, 'AED'],
    amount_untaxed: 100.00,
    amount_tax: 5.00,
    amount_total: 105.00,
    amount_discount: 0,
    state: 'sale'
  };

  // Sample sale.order.line data
  const odooLines = [
    {
      id: 1001,
      product_id: [500, 'Coffee Latte'],
      product_code: 'PROD-001',
      default_code: 'PROD-001',
      sequence: 1,
      product_uom_qty: 2.0,
      price_unit: 25.00,
      price_subtotal: 50.00,
      price_tax: 2.50,
      discount: 0,
      tax_id: [[1, 'VAT 5%']]
    },
    {
      id: 1002,
      product_id: [501, 'Croissant'],
      product_code: 'PROD-002',
      default_code: 'PROD-002',
      sequence: 2,
      product_uom_qty: 2.0,
      price_unit: 25.00,
      price_subtotal: 50.00,
      price_tax: 2.50,
      discount: 0,
      tax_id: [[1, 'VAT 5%']]
    }
  ];

  // Sample account.payment data
  const odooPayments = [
    {
      id: 2001,
      amount: 105.00,
      payment_method_code: 'Cash',
      journal_id: [5, 'Cash'],
      currency_id: [1, 'AED'],
      date: '2024-05-17'
    }
  ];

  // Map the complete sale
  const mapped = odooMapper.mapCompleteSale(odooSale, odooLines, odooPayments, {
    region: 'AE',
    outletName: null,  // Will use warehouse_id name
    registerName: null, // Will use pos_config_id name
    customerType: 'NORMAL'
  });

  console.log('Mapped Sale Header (BACKUP_VENDHQ_SALES):');
  console.log(JSON.stringify(mapped.sale, null, 2));

  console.log('\nMapped Line Items (BACKUP_VENDHQ_LINE_ITEMS):');
  console.log(JSON.stringify(mapped.lines, null, 2));

  console.log('\nMapped Payments (BACKUP_VENDHQ_PAYMENTS):');
  console.log(JSON.stringify(mapped.payments, null, 2));

  console.log('\nMetadata:');
  console.log(JSON.stringify(mapped.metadata, null, 2));

  // Verify totals
  const sumLines = mapped.lines.reduce((sum, line) => sum + line.TOTAL_PRICE, 0);
  const sumTax = mapped.lines.reduce((sum, line) => sum + line.TOTAL_TAX, 0);
  const sumPayments = mapped.payments.reduce((sum, p) => sum + p.AMOUNT, 0);

  console.log('\n--- Verification ---');
  console.log(`Sum of line prices: ${sumLines.toFixed(2)} (expected: ${mapped.sale.TOTAL_PRICE.toFixed(2)})`);
  console.log(`Sum of line tax: ${sumTax.toFixed(2)} (expected: ${mapped.sale.TOTAL_TAX.toFixed(2)})`);
  console.log(`Sum of payments: ${sumPayments.toFixed(2)} (expected: ${mapped.sale.TOTAL_PRICE_INCL_TAX.toFixed(2)})`);

  return mapped;
}

// ── Example 2: Service Provider Sale (requires journal entry) ─────────────────

function exampleServiceProviderSale() {
  console.log('\n=== Example 2: Service Provider Sale (HUNGERSTATION) ===\n');

  const odooSale = {
    id: 12346,
    name: 'POS/2024/002',
    date_order: '2024-05-17T15:00:00',
    warehouse_id: [1, 'Dubai Mall Store'],
    pos_config_id: [10, 'Register 01'],
    partner_id: [600, 'HungerStation'],
    currency_id: [2, 'SAR'],
    amount_untaxed: 200.00,
    amount_tax: 30.00,
    amount_total: 230.00,
    state: 'sale'
  };

  const odooLines = [
    {
      id: 1003,
      product_id: [502, 'Burger Meal'],
      product_code: 'PROD-003',
      sequence: 1,
      product_uom_qty: 1.0,
      price_unit: 200.00,
      price_subtotal: 200.00,
      price_tax: 30.00,
      discount: 0,
      tax_id: [[2, 'VAT 15%']]
    }
  ];

  const odooPayments = [
    {
      id: 2002,
      amount: 230.00,
      payment_method_code: 'Credit On Cust',
      journal_id: [6, 'Bank'],
      currency_id: [2, 'SAR'],
      date: '2024-05-17'
    }
  ];

  // Map with HUNGERSTATION customer type
  const mapped = odooMapper.mapCompleteSale(odooSale, odooLines, odooPayments, {
    region: 'SA',
    customerType: 'HUNGERSTATION'
  });

  console.log('Customer Type:', mapped.sale.CUSTOMER_TYPE);
  console.log('Requires Journal Entry:', mapped.metadata.requiresJournal);

  console.log('\nMapped Sale:');
  console.log(JSON.stringify(mapped.sale, null, 2));

  return mapped;
}

// ── Example 3: Individual mappers ─────────────────────────────────────────────

function exampleIndividualMappers() {
  console.log('\n=== Example 3: Using Individual Mappers ===\n');

  // Map sale header only
  const sale = odooMapper.mapSaleToVendhqSales({
    id: 100,
    name: 'S00100',
    date_order: '2024-05-17',
    warehouse_id: [1, 'Store 1'],
    amount_untaxed: 50,
    amount_tax: 2.5,
    amount_total: 52.5
  }, { region: 'AE', customerType: 'NORMAL' });

  console.log('Sale Header:');
  console.log(JSON.stringify(sale, null, 2));

  // Map single line item
  const line = odooMapper.mapLineToVendhqLineItems({
    product_id: [1, 'Product A'],
    product_code: 'A001',
    product_uom_qty: 1,
    price_unit: 50,
    price_subtotal: 50,
    price_tax: 2.5,
    discount: 0,
    tax_id: [[1, 'VAT 5%']]
  }, 'S00100', { region: 'AE', saleDate: new Date(), lineNumber: 1 });

  console.log('\nLine Item:');
  console.log(JSON.stringify(line, null, 2));

  // Map single payment
  const payment = odooMapper.mapPaymentToVendhqPayments({
    id: 1,
    amount: 52.5,
    payment_method_code: 'Card',
    currency_id: [1, 'AED'],
    date: '2024-05-17'
  }, 'S00100', { region: 'AE', outletName: 'Store 1', registerName: 'REG01', saleDate: new Date() });

  console.log('\nPayment:');
  console.log(JSON.stringify(payment, null, 2));
}

// ── Example 4: Payment classification ─────────────────────────────────────────

function examplePaymentClassification() {
  console.log('\n=== Example 4: Payment Type Classification ===\n');

  const paymentTypes = [
    'Cash',
    'Card',
    'Bank Transfer',
    'Cash Rounding',
    'Tip',
    'Service Charge',
    'Credit On Cust'
  ];

  paymentTypes.forEach(type => {
    const classification = odooMapper.classifyReceiptType(type);
    console.log(`${type.padEnd(20)} → ${classification}`);
  });
}

// ── Run examples ───────────────────────────────────────────────────────────────

if (require.main === module) {
  try {
    exampleCompleteSale();
    exampleServiceProviderSale();
    exampleIndividualMappers();
    examplePaymentClassification();

    console.log('\n✓ All examples completed successfully!\n');
    console.log('For Oracle DB integration:');
    console.log('  1. Insert mapped.sale into BACKUP_VENDHQ_SALES');
    console.log('  2. Insert mapped.lines into BACKUP_VENDHQ_LINE_ITEMS');
    console.log('  3. Insert mapped.payments into BACKUP_VENDHQ_PAYMENTS');
    console.log('\nFor Oracle Fusion push:');
    console.log('  See ORACLE_OPERATIONS_MAPPING.md for the 5 operations');
  } catch (err) {
    console.error('Example failed:', err);
    process.exit(1);
  }
}

module.exports = {
  exampleCompleteSale,
  exampleServiceProviderSale,
  exampleIndividualMappers,
  examplePaymentClassification
};
