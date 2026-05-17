'use strict';

/**
 * Unit tests for odooToVendhqMapper module
 */

const odooMapper = require('../../src/odooToVendhqMapper');

describe('odooToVendhqMapper', () => {
  describe('mapSaleToVendhqSales', () => {
    it('should map basic Odoo sale to VendHQ SALES structure', () => {
      const odooSale = {
        id: 123,
        name: 'S001',
        date_order: '2024-05-17T14:00:00',
        warehouse_id: [1, 'Test Store'],
        pos_config_id: [10, 'Register 1'],
        amount_untaxed: 100.00,
        amount_tax: 5.00,
        amount_total: 105.00
      };

      const result = odooMapper.mapSaleToVendhqSales(odooSale, { region: 'AE' });

      expect(result.INVOICE_NUMBER).toBe('S001');
      expect(result.OUTLET_NAME).toBe('Test Store');
      expect(result.REGISTER_NAME).toBe('Register 1');
      expect(result.TOTAL_PRICE).toBe(100.00);
      expect(result.TOTAL_TAX).toBe(5.00);
      expect(result.TOTAL_PRICE_INCL_TAX).toBe(105.00);
      expect(result.REGION).toBe('AE');
      expect(result.VERSION).toBe(0);
    });

    it('should handle missing warehouse_id gracefully', () => {
      const odooSale = {
        id: 123,
        name: 'S002',
        date_order: '2024-05-17',
        partner_id: [500, 'Customer Store'],
        amount_untaxed: 50,
        amount_tax: 2.5,
        amount_total: 52.5
      };

      const result = odooMapper.mapSaleToVendhqSales(odooSale, { region: 'SA' });

      expect(result.OUTLET_NAME).toBe('Customer Store');
      expect(result.REGION).toBe('SA');
    });

    it('should apply customer type correctly', () => {
      const odooSale = {
        id: 123,
        name: 'S003',
        date_order: '2024-05-17',
        warehouse_id: [1, 'Store'],
        amount_untaxed: 100,
        amount_tax: 15,
        amount_total: 115
      };

      const result = odooMapper.mapSaleToVendhqSales(odooSale, {
        region: 'SA',
        customerType: 'HUNGERSTATION'
      });

      expect(result.CUSTOMER_TYPE).toBe('HUNGERSTATION');
    });
  });

  describe('mapLineToVendhqLineItems', () => {
    it('should map Odoo line to VendHQ LINE_ITEMS structure', () => {
      const odooLine = {
        id: 1001,
        product_id: [500, 'Coffee Latte'],
        product_code: 'PROD-001',
        product_uom_qty: 2.0,
        price_unit: 25.00,
        price_subtotal: 50.00,
        price_tax: 2.50,
        discount: 0,
        tax_id: [[1, 'VAT 5%']]
      };

      const result = odooMapper.mapLineToVendhqLineItems(odooLine, 'S001', {
        region: 'AE',
        saleDate: new Date('2024-05-17'),
        lineNumber: 1
      });

      expect(result.INVOICE_NUMBER).toBe('S001');
      expect(result.LINE_NUMBER).toBe(1);
      expect(result.ITEM_NUMBER).toBe('PROD-001');
      expect(result.ITEM_NAME).toBe('Coffee Latte');
      expect(result.QUANTITY).toBe(2.0);
      expect(result.TOTAL_PRICE).toBe(50.00);
      expect(result.TOTAL_TAX).toBe(2.50);
      expect(result.TAX_NAME).toBe('VAT 5%');
    });

    it('should calculate discount correctly', () => {
      const odooLine = {
        id: 1002,
        product_id: [501, 'Product B'],
        product_code: 'PROD-002',
        product_uom_qty: 1.0,
        price_unit: 100.00,
        price_subtotal: 90.00,
        price_tax: 4.50,
        discount: 10, // 10% discount
        tax_id: [[1, 'VAT 5%']]
      };

      const result = odooMapper.mapLineToVendhqLineItems(odooLine, 'S002', {
        region: 'AE',
        saleDate: new Date('2024-05-17')
      });

      // 10% of 100 = 10
      expect(result.LOYALTY_VALUE).toBe(10.00);
      expect(result.TOTAL_DISCOUNT).toBe(10.00);
    });
  });

  describe('mapPaymentToVendhqPayments', () => {
    it('should map Odoo payment to VendHQ PAYMENTS structure', () => {
      const odooPayment = {
        id: 2001,
        amount: 105.00,
        payment_method_code: 'Cash',
        currency_id: [1, 'AED'],
        date: '2024-05-17'
      };

      const result = odooMapper.mapPaymentToVendhqPayments(odooPayment, 'S001', {
        region: 'AE',
        outletName: 'Test Store',
        registerName: 'Register 1',
        saleDate: new Date('2024-05-17')
      });

      expect(result.INVOICE_NUMBER).toBe('S001');
      expect(result.AMOUNT).toBe(105.00);
      expect(result.CURRENCY).toBe('AED');
      expect(result.PAYMENT_TYPE).toBe('Cash');
      expect(result.OUTLET_NAME).toBe('Test Store');
      expect(result.DELETED_AT).toBeNull();
    });

    it('should handle journal_id for payment type', () => {
      const odooPayment = {
        id: 2002,
        amount: 50.00,
        journal_id: [5, 'Bank'],
        currency_id: [2, 'SAR'],
        date: '2024-05-17'
      };

      const result = odooMapper.mapPaymentToVendhqPayments(odooPayment, 'S002', {
        region: 'SA',
        outletName: 'Store',
        registerName: 'REG01',
        saleDate: new Date('2024-05-17')
      });

      expect(result.PAYMENT_TYPE).toBe('Bank');
    });
  });

  describe('classifyReceiptType', () => {
    it('should classify main payments as STANDARD', () => {
      expect(odooMapper.classifyReceiptType('Cash')).toBe('STANDARD');
      expect(odooMapper.classifyReceiptType('Card')).toBe('STANDARD');
      expect(odooMapper.classifyReceiptType('Bank Transfer')).toBe('STANDARD');
      expect(odooMapper.classifyReceiptType('Credit On Cust')).toBe('STANDARD');
    });

    it('should classify adjustments as MISC', () => {
      expect(odooMapper.classifyReceiptType('Cash Rounding')).toBe('MISC');
      expect(odooMapper.classifyReceiptType('Tip')).toBe('MISC');
      expect(odooMapper.classifyReceiptType('Service Charge')).toBe('MISC');
      expect(odooMapper.classifyReceiptType('Adjustment')).toBe('MISC');
    });
  });

  describe('requiresJournalEntry', () => {
    it('should return true for service providers', () => {
      expect(odooMapper.requiresJournalEntry('HUNGERSTATION')).toBe(true);
      expect(odooMapper.requiresJournalEntry('TALABAT')).toBe(true);
      expect(odooMapper.requiresJournalEntry('DELIVEROO')).toBe(true);
      expect(odooMapper.requiresJournalEntry('ZOMATO')).toBe(true);
    });

    it('should return false for normal customers', () => {
      expect(odooMapper.requiresJournalEntry('NORMAL')).toBe(false);
      expect(odooMapper.requiresJournalEntry('WALK-IN')).toBe(false);
      expect(odooMapper.requiresJournalEntry('')).toBe(false);
    });
  });

  describe('mapCompleteSale', () => {
    it('should map complete sale with lines and payments', () => {
      const odooSale = {
        id: 123,
        name: 'POS/2024/001',
        date_order: '2024-05-17T14:30:00',
        warehouse_id: [1, 'Dubai Store'],
        pos_config_id: [10, 'Register 01'],
        amount_untaxed: 100.00,
        amount_tax: 5.00,
        amount_total: 105.00
      };

      const odooLines = [
        {
          id: 1001,
          product_id: [500, 'Coffee'],
          product_code: 'PROD-001',
          product_uom_qty: 2,
          price_unit: 25,
          price_subtotal: 50,
          price_tax: 2.5,
          discount: 0,
          tax_id: [[1, 'VAT 5%']]
        },
        {
          id: 1002,
          product_id: [501, 'Croissant'],
          product_code: 'PROD-002',
          product_uom_qty: 2,
          price_unit: 25,
          price_subtotal: 50,
          price_tax: 2.5,
          discount: 0,
          tax_id: [[1, 'VAT 5%']]
        }
      ];

      const odooPayments = [
        {
          id: 2001,
          amount: 105.00,
          payment_method_code: 'Cash',
          currency_id: [1, 'AED'],
          date: '2024-05-17'
        }
      ];

      const result = odooMapper.mapCompleteSale(odooSale, odooLines, odooPayments, {
        region: 'AE',
        customerType: 'NORMAL'
      });

      expect(result.sale).toBeDefined();
      expect(result.lines).toHaveLength(2);
      expect(result.payments).toHaveLength(1);
      expect(result.metadata).toBeDefined();
      expect(result.metadata.invoiceNumber).toBe('POS/2024/001');
      expect(result.metadata.requiresJournal).toBe(false);
    });

    it('should detect journal entry requirement for service providers', () => {
      const odooSale = {
        id: 124,
        name: 'POS/2024/002',
        date_order: '2024-05-17',
        warehouse_id: [1, 'Store'],
        amount_untaxed: 200,
        amount_tax: 30,
        amount_total: 230
      };

      const result = odooMapper.mapCompleteSale(odooSale, [], [], {
        region: 'SA',
        customerType: 'HUNGERSTATION'
      });

      expect(result.metadata.requiresJournal).toBe(true);
      expect(result.sale.CUSTOMER_TYPE).toBe('HUNGERSTATION');
    });

    it('should verify totals match', () => {
      const odooSale = {
        id: 125,
        name: 'S003',
        date_order: '2024-05-17',
        warehouse_id: [1, 'Store'],
        amount_untaxed: 100,
        amount_tax: 5,
        amount_total: 105
      };

      const odooLines = [
        {
          product_id: [500, 'Item'],
          product_code: 'ITEM-001',
          product_uom_qty: 1,
          price_unit: 100,
          price_subtotal: 100,
          price_tax: 5,
          discount: 0,
          tax_id: [[1, 'VAT 5%']]
        }
      ];

      const odooPayments = [
        {
          amount: 105,
          payment_method_code: 'Card',
          currency_id: [1, 'AED'],
          date: '2024-05-17'
        }
      ];

      const result = odooMapper.mapCompleteSale(odooSale, odooLines, odooPayments, {
        region: 'AE'
      });

      const sumLines = result.lines.reduce((sum, line) => sum + line.TOTAL_PRICE, 0);
      const sumTax = result.lines.reduce((sum, line) => sum + line.TOTAL_TAX, 0);
      const sumPayments = result.payments.reduce((sum, p) => sum + p.AMOUNT, 0);

      expect(sumLines).toBe(result.sale.TOTAL_PRICE);
      expect(sumTax).toBe(result.sale.TOTAL_TAX);
      expect(sumPayments).toBe(result.sale.TOTAL_PRICE_INCL_TAX);
    });
  });
});
