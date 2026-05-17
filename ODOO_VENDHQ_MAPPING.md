# Odoo to VendHQ Backup Tables - Field Mapping Documentation

This document provides complete field-by-field mappings from Odoo API responses to VendHQ backup table structures defined in `database.sql`.

## Overview

The integration receives data from **3 Odoo API endpoints**:

1. **`sale.order`** - Sales order headers
2. **`sale.order.line`** - Sales order line items
3. **`account.payment`** - Payment records

These are mapped to **3 VendHQ backup tables** in the ODOO_INTEGRATION schema:

1. **`BACKUP_VENDHQ_SALES`** - Sale headers
2. **`BACKUP_VENDHQ_LINE_ITEMS`** - Line items
3. **`BACKUP_VENDHQ_PAYMENTS`** - Payments

## Mapping Reference

The mappings follow the patterns established in the Java middleware:
- `FusionInvoiceMapping.java` - Invoice header/line logic
- `FusionStdReceiptMapping.java` - Standard receipt logic
- `FusionMiscReceiptMapping.java` - Misc receipt logic
- `FusionApplyReceiptMapping.java` - Apply receipt logic
- `FusionJournalEntryMapping.java` - Journal entry logic

---

## 1. sale.order → BACKUP_VENDHQ_SALES

### Table Schema

```sql
CREATE TABLE "ODOO_INTEGRATION"."BACKUP_VENDHQ_SALES" (
  "ROW_ID" NUMBER,                      -- Primary Key (auto-generated)
  "INVOICE_NUMBER" VARCHAR2(300),       -- Sale order reference
  "OUTLET_NAME" VARCHAR2(100),          -- Store/warehouse name
  "REGISTER_NAME" VARCHAR2(100),        -- POS register name
  "SALE_DATE" DATE,                     -- Order date
  "TOTAL_PRICE" NUMBER,                 -- Subtotal (excl. tax)
  "TOTAL_TAX" NUMBER,                   -- Total tax amount
  "TOTAL_LOYALTY" NUMBER,               -- Discount/loyalty amount
  "TOTAL_PRICE_INCL_TAX" NUMBER,        -- Grand total (incl. tax)
  "VERSION" NUMBER,                     -- Version (always 0 for Odoo)
  "REGION" VARCHAR2(5),                 -- Country/region code
  "CUSTOMER_TYPE" VARCHAR2(100),        -- Customer type classification
  CONSTRAINT "BACKUP_VENDHQ_SALES_PK" PRIMARY KEY ("ROW_ID")
);
```

### Field Mappings

| VendHQ Column | Odoo Field | Transformation | Example |
|---------------|------------|----------------|---------|
| `ROW_ID` | N/A | Auto-generated sequence | `1001` |
| `INVOICE_NUMBER` | `name` | Direct mapping (order reference) | `POS/2024/001` |
| `OUTLET_NAME` | `warehouse_id[1]` or `partner_id[1]` | Extract name from many2one field | `Dubai Mall Store` |
| `REGISTER_NAME` | `pos_config_id[1]` or `session_id[1]` | Extract POS config/session name | `Register 01` |
| `SALE_DATE` | `date_order` | Parse ISO datetime to DATE | `2024-05-17` |
| `TOTAL_PRICE` | `amount_untaxed` | Direct mapping (subtotal) | `100.00` |
| `TOTAL_TAX` | `amount_tax` | Direct mapping | `5.00` |
| `TOTAL_LOYALTY` | `amount_discount` | Discount treated as loyalty | `10.00` |
| `TOTAL_PRICE_INCL_TAX` | `amount_total` | Direct mapping (grand total) | `95.00` |
| `VERSION` | N/A | Always `0` for Odoo integration | `0` |
| `REGION` | Configuration | From store metadata or API param | `AE`, `SA`, `KW` |
| `CUSTOMER_TYPE` | Derived | Based on partner or order tags | `NORMAL`, `HUNGERSTATION`, `TALABAT` |

### Calculation Examples

**Java Reference**: `FusionInvoiceMapping.java:38-54`

```javascript
// Total price (subtotal excluding tax)
TOTAL_PRICE = odooSale.amount_untaxed

// Total tax
TOTAL_TAX = odooSale.amount_tax

// Grand total
TOTAL_PRICE_INCL_TAX = odooSale.amount_total

// Loyalty/discount (if discount field exists)
TOTAL_LOYALTY = odooSale.amount_discount || 0

// Verification
TOTAL_PRICE + TOTAL_TAX = TOTAL_PRICE_INCL_TAX (approximately)
```

---

## 2. sale.order.line → BACKUP_VENDHQ_LINE_ITEMS

### Table Schema

```sql
CREATE TABLE "ODOO_INTEGRATION"."BACKUP_VENDHQ_LINE_ITEMS" (
  "ROW_ID" NUMBER,                      -- Primary Key (auto-generated)
  "INVOICE_NUMBER" VARCHAR2(300),       -- FK to BACKUP_VENDHQ_SALES
  "LINE_NUMBER" NUMBER,                 -- Line sequence number
  "ITEM_NUMBER" VARCHAR2(50),           -- Product SKU/reference
  "ITEM_NAME" VARCHAR2(250),            -- Product name
  "QUANTITY" NUMBER,                    -- Quantity ordered
  "LOYALTY_VALUE" NUMBER,               -- Line discount amount
  "TOTAL_PRICE" NUMBER,                 -- Line subtotal
  "TOTAL_TAX" NUMBER,                   -- Line tax amount
  "TOTAL_DISCOUNT" NUMBER,              -- Line discount (same as LOYALTY_VALUE)
  "TOTAL_LOYALTY" NUMBER,               -- Line loyalty points
  "REGION" VARCHAR2(5),                 -- Region (from parent sale)
  "SALE_DATE" DATE,                     -- Sale date (from parent sale)
  "TAX_NAME" VARCHAR2(100),             -- Tax classification code
  CONSTRAINT "BACKUP_VENDHQ_LINE_ITEMS_PK" PRIMARY KEY ("ROW_ID")
);
```

### Field Mappings

| VendHQ Column | Odoo Field | Transformation | Example |
|---------------|------------|----------------|---------|
| `ROW_ID` | N/A | Auto-generated sequence | `5001` |
| `INVOICE_NUMBER` | Parent `sale.order.name` | Links to parent order | `POS/2024/001` |
| `LINE_NUMBER` | `sequence` or `id` | Line sequence (1-indexed) | `1`, `2`, `3` |
| `ITEM_NUMBER` | `product_code` or `default_code` | Product internal reference/SKU | `PROD-001` |
| `ITEM_NAME` | `product_id[1]` or `name` | Product display name | `Coffee Latte` |
| `QUANTITY` | `product_uom_qty` or `qty` | Ordered quantity | `2.0` |
| `LOYALTY_VALUE` | Calculated | `(price_unit * qty * discount%) / 100` | `5.00` |
| `TOTAL_PRICE` | `price_subtotal` | Line subtotal (after discount) | `45.00` |
| `TOTAL_TAX` | `price_tax` | Line tax amount | `2.25` |
| `TOTAL_DISCOUNT` | Same as `LOYALTY_VALUE` | Line discount amount | `5.00` |
| `TOTAL_LOYALTY` | N/A | Usually `0` (not tracked at line level) | `0` |
| `REGION` | From parent sale | Inherited from sale header | `AE` |
| `SALE_DATE` | From parent sale | Inherited from sale header | `2024-05-17` |
| `TAX_NAME` | `tax_id[0][1]` | First tax name/code | `VAT 5%` |

### Calculation Examples

**Java Reference**: `FusionInvoiceMapping.java:57-85`

```javascript
// Line quantity
QUANTITY = odooLine.product_uom_qty || odooLine.qty

// Line subtotal (price after discount, before tax)
TOTAL_PRICE = odooLine.price_subtotal

// Line tax
TOTAL_TAX = odooLine.price_tax

// Discount amount (Odoo stores discount as percentage)
discount_percent = odooLine.discount || 0
LOYALTY_VALUE = (odooLine.price_unit * QUANTITY * discount_percent) / 100
TOTAL_DISCOUNT = LOYALTY_VALUE

// Unit price before discount (for Oracle)
unit_price = odooLine.price_unit
unit_selling_price = TOTAL_PRICE / QUANTITY  // After discount

// Verification
TOTAL_PRICE + TOTAL_TAX = price_total (line total including tax)
```

---

## 3. account.payment → BACKUP_VENDHQ_PAYMENTS

### Table Schema

```sql
CREATE TABLE "ODOO_INTEGRATION"."BACKUP_VENDHQ_PAYMENTS" (
  "ROW_ID" NUMBER,                      -- Primary Key (auto-generated)
  "INVOICE_NUMBER" VARCHAR2(300),       -- FK to BACKUP_VENDHQ_SALES
  "OUTLET_NAME" VARCHAR2(100),          -- Store name
  "REGISTER_NAME" VARCHAR2(100),        -- Register name
  "AMOUNT" NUMBER,                      -- Payment amount
  "CURRENCY" VARCHAR2(5),               -- Currency code
  "PAYMENT_TYPE" VARCHAR2(100),         -- Payment method type
  "PAYMENT_DATE" DATE,                  -- Payment date
  "DELETED_AT" DATE,                    -- Soft delete (NULL = active)
  "REGION" VARCHAR2(5),                 -- Region code
  "SALE_DATE" DATE,                     -- Original sale date
  CONSTRAINT "BACKUP_VENDHQ_PAYMENTS_PK" PRIMARY KEY ("ROW_ID")
);
```

### Field Mappings

| VendHQ Column | Odoo Field | Transformation | Example |
|---------------|------------|----------------|---------|
| `ROW_ID` | N/A | Auto-generated sequence | `8001` |
| `INVOICE_NUMBER` | Related `sale.order.name` | Order reference via invoice link | `POS/2024/001` |
| `OUTLET_NAME` | From parent sale | Store/outlet name | `Dubai Mall Store` |
| `REGISTER_NAME` | From parent sale | Register name | `Register 01` |
| `AMOUNT` | `amount` | Payment amount | `95.00` |
| `CURRENCY` | `currency_id[1]` | Currency code from many2one | `AED` |
| `PAYMENT_TYPE` | `payment_method_code` or `journal_id[1]` | Payment method name | `Cash`, `Card`, `Bank` |
| `PAYMENT_DATE` | `date` or `payment_date` | Payment timestamp | `2024-05-17` |
| `DELETED_AT` | N/A | Always `NULL` (active) | `NULL` |
| `REGION` | From parent sale | Region code | `AE` |
| `SALE_DATE` | From parent sale | Original sale date | `2024-05-17` |

### Payment Type Classification

**Java Reference**: `FusionStdReceiptMapping.java`, `FusionMiscReceiptMapping.java`

Payments are classified into two categories for Oracle operations:

#### Standard Receipt (Main Payments)
- `Cash` - Cash payments
- `Card` - Credit/debit card payments
- `Bank Transfer` - Bank transfers
- `Credit On Cust` - Customer credit accounts
- Any other primary payment method

**Maps to**: `StandardReceiptRequest` in Oracle

#### Misc Receipt (Adjustments)
- `Cash Rounding` - Rounding adjustments
- `Tip` - Gratuity/tips
- `Service Charge` - Service fees
- `Adjustment` - Manual adjustments

**Maps to**: `MiscellaneousReceipt` in Oracle

```javascript
// Classification logic
function classifyPayment(paymentType) {
  const lower = paymentType.toLowerCase();

  if (lower.includes('rounding') ||
      lower.includes('tip') ||
      lower.includes('service') ||
      lower.includes('adjustment')) {
    return 'MISC_RECEIPT';
  }

  return 'STANDARD_RECEIPT';
}
```

---

## Customer Type Classification

**Java Reference**: `FusionJournalEntryMapping.java:46-52`

Customer types determine whether a journal entry is required for service provider charges:

| Customer Type | Description | Journal Entry Required | Commission Rate |
|---------------|-------------|------------------------|-----------------|
| `NORMAL` | Walk-in customers | No | N/A |
| `HUNGERSTATION` | HungerStation delivery orders | Yes | Variable % |
| `TALABAT` | Talabat delivery orders | Yes | Variable % |
| `DELIVEROO` | Deliveroo delivery orders | Yes | Variable % |
| `ZOMATO` | Zomato delivery orders | Yes | Variable % |
| `NOON` | Noon Food delivery orders | Yes | Variable % |
| `CAREEM` | Careem delivery orders | Yes | Variable % |
| `UBER` | Uber Eats delivery orders | Yes | Variable % |

---

## Region Codes

Region codes map to Oracle business units and tax configurations:

| Code | Country | Example Stores |
|------|---------|----------------|
| `AE` | United Arab Emirates | Dubai, Abu Dhabi |
| `SA` | Saudi Arabia | Riyadh, Jeddah |
| `KW` | Kuwait | Kuwait City |
| `OM` | Oman | Muscat |
| `BH` | Bahrain | Manama |
| `QA` | Qatar | Doha |

---

## Data Flow Summary

```
┌─────────────────────────────────────────────────────────────────┐
│                        Odoo APIs                                 │
├─────────────────────────────────────────────────────────────────┤
│  1. sale.order          → Order headers                         │
│  2. sale.order.line     → Line items                            │
│  3. account.payment     → Payment records                       │
└────────────────────┬────────────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────────────┐
│              odooToVendhqMapper.js                              │
│              Field-by-field transformation                       │
└────────────────────┬────────────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────────────┐
│                  VendHQ Backup Tables                           │
├─────────────────────────────────────────────────────────────────┤
│  1. BACKUP_VENDHQ_SALES       → Sale headers                    │
│  2. BACKUP_VENDHQ_LINE_ITEMS  → Line items                      │
│  3. BACKUP_VENDHQ_PAYMENTS    → Payments                        │
└────────────────────┬────────────────────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────────────────────┐
│              Oracle Fusion Operations                           │
│              (See ORACLE_OPERATIONS_MAPPING.md)                 │
├─────────────────────────────────────────────────────────────────┤
│  1. AR Invoice          → From SALES + LINE_ITEMS               │
│  2. Standard Receipt    → From PAYMENTS (main)                  │
│  3. Misc Receipt        → From PAYMENTS (adjustments)           │
│  4. Apply Receipt       → Link receipts to invoices             │
│  5. Journal Entry       → Service provider charges              │
└─────────────────────────────────────────────────────────────────┘
```

---

## Implementation Notes

### 1. Sequence Numbers

- `ROW_ID` fields are auto-generated by Oracle sequences
- `LINE_NUMBER` is manually assigned (1-indexed) from array position
- `VERSION` is always `0` for Odoo integration (distinguishes from VendHQ data)

### 2. Currency Handling

- All amounts are stored as `NUMBER` (Oracle's decimal type)
- Currency codes follow ISO 4217 (3-letter codes: AED, SAR, KWD, etc.)
- Currency conversion handled by Oracle Fusion based on `CONVERSION_RATE_TYPE`

### 3. Tax Handling

- `TAX_NAME` stores the tax classification code (e.g., "VAT 5%", "VAT 15%")
- Oracle looks up the actual tax configuration using this code
- Tax amounts are pre-calculated by Odoo and stored directly

### 4. Discount Handling

- Odoo stores discounts as percentages at line level
- Converted to amounts for VendHQ: `(price_unit × qty × discount%) / 100`
- Stored in both `LOYALTY_VALUE` and `TOTAL_DISCOUNT` columns (legacy structure)

### 5. Date Handling

- Odoo returns ISO 8601 datetime strings
- Converted to JavaScript `Date` objects
- Stored as Oracle `DATE` type (includes time component)
- Timezone adjustments applied based on region configuration

---

## Testing & Validation

### Sample Data Verification

```javascript
// Example: Verify a mapped sale
const mapped = mapCompleteSale(odooSale, lines, payments, { region: 'AE' });

// Check totals match
const sumLines = mapped.lines.reduce((sum, line) => sum + line.TOTAL_PRICE, 0);
const sumTax = mapped.lines.reduce((sum, line) => sum + line.TOTAL_TAX, 0);
const sumPayments = mapped.payments.reduce((sum, p) => sum + p.AMOUNT, 0);

assert(Math.abs(sumLines - mapped.sale.TOTAL_PRICE) < 0.01);
assert(Math.abs(sumTax - mapped.sale.TOTAL_TAX) < 0.01);
assert(Math.abs(sumPayments - mapped.sale.TOTAL_PRICE_INCL_TAX) < 0.01);
```

### Common Issues

1. **Missing warehouse_id**: Fallback to `partner_id` or default outlet
2. **Multiple taxes**: Take first tax from `tax_id` array
3. **Discount calculation**: Ensure percentage vs. amount distinction
4. **Region inference**: Use store metadata or configuration default

---

## See Also

- [ORACLE_OPERATIONS_MAPPING.md](./ORACLE_OPERATIONS_MAPPING.md) - Oracle Fusion push operations
- [database.sql](./database.sql) - Complete table schemas
- [oracle-crm/src/odooToVendhqMapper.js](./oracle-crm/src/odooToVendhqMapper.js) - Implementation
- [oracle-crm/src/calculations.js](./oracle-crm/src/calculations.js) - Calculation functions
