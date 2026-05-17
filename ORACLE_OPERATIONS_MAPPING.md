# Oracle Fusion Operations - VendHQ Data Mapping

This document describes how data from VendHQ backup tables is mapped to the 5 Oracle Fusion ERP operations.

## Overview

After Odoo data is mapped to VendHQ backup tables (see [ODOO_VENDHQ_MAPPING.md](./ODOO_VENDHQ_MAPPING.md)), it is pushed to Oracle Fusion using these operations:

1. **AR Invoice** - Accounts Receivable Invoice (sales transaction)
2. **Standard Receipt** - Customer payment receipt (main payments)
3. **Misc Receipt** - Miscellaneous receipt (adjustments, rounding)
4. **Apply Receipt** - Link receipt to invoice (payment application)
5. **Journal Entry** - Service provider commission charges

---

## Operation 1: AR Invoice

**Purpose**: Create the sales invoice in Oracle AR (Accounts Receivable)

**Source Tables**:
- `BACKUP_VENDHQ_SALES` (header)
- `BACKUP_VENDHQ_LINE_ITEMS` (lines)

**Oracle Endpoint**: `/fscmRestApi/resources/11.13.18.05/receivablesInvoices`

**Java Reference**: `FusionInvoiceMapping.java`

### Invoice Header Mapping

**Target**: `InvoiceHeader` object → Oracle `receivablesInvoices`

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `BusinessUnit` | Metadata | Lookup by region from `fusion_business_unit_id_map` | `SA_BU_1` |
| `TransactionSource` | Metadata | From `fusion_sales_metadata.txn_source` | `MANUAL` |
| `TransactionType` | Metadata | From `fusion_sales_metadata.txn_type` | `Invoice` |
| `TransactionNumber` | Generated | Format: `{OUTLET}-{DATE}-{SEQ}` | `DXB01-20240517-001` |
| `TransactionDate` | `SALE_DATE` | Apply timezone offset (region-specific) | `2024-05-17T14:30:00` |
| `BillToCustomerName` | Metadata | From `fusion_sales_metadata.bill_to_name` | `Walk-In Customer` |
| `BillToCustomerNumber` | Metadata | From `fusion_sales_metadata.bill_to_account` | `10001` |
| `BillToSite` | Metadata | From `fusion_sales_metadata.site_number` | `SITE-001` |
| `InvoiceCurrencyCode` | `vendhq_outlets_db.currency` | Outlet currency | `AED` |
| `ConversionRateType` | Metadata | `Corporate` or `User` based on flag | `Corporate` |
| `Comments` | `INVOICE_NUMBER` | Reference to POS order | `POS/2024/001` |

**Calculation Example**:
```javascript
// Java: FusionInvoiceMapping.java:38-54
invoiceHeader.setBusinessUnit(salesMetadata.getBusinessUnit());
invoiceHeader.setTransactionSource(salesMetadata.getTxnSource());
invoiceHeader.setTransactionType(salesMetadata.getTxnType());
invoiceHeader.setBillToCustomerName(salesMetadata.getBillToName());
invoiceHeader.setSaleDate(applyTimezoneOffset(sale.getSaleDate(), hoursOffset, minutesOffset));
invoiceHeader.setInvoiceCurrencyCode(outletDetail.getCurrency());
```

### Invoice Lines Mapping

**Target**: `InvoiceLineModel` array → Oracle `receivablesInvoiceLines`

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `LineNumber` | `LINE_NUMBER` | Sequential line number | `1`, `2`, `3` |
| `ItemNumber` | `ITEM_NUMBER` | Product SKU/reference | `PROD-001` |
| `Description` | `ITEM_NAME` or metadata | Product description from `vendhq_item_meta` | `Coffee Latte` |
| `Quantity` | `QUANTITY` | Order quantity | `2.0` |
| `UnitSellingPrice` | Calculated | `TOTAL_PRICE / QUANTITY` (absolute value) | `22.50` |
| `UOMCode` | Metadata | From `vendhq_item_meta.uom_name` → Oracle UOM | `Ea` (Each) |
| `TaxClassificationCode` | `TAX_NAME` | Tax code for Oracle tax engine | `VAT_5_PCT` |
| `SalesOrder` | `INVOICE_NUMBER` | POS order reference | `POS/2024/001` |
| `SalesOrderLine` | `LINE_NUMBER` | Line reference | `1` |
| `MemoLineName` | Special case | "Discount Item" for discount lines | `Discount Item` |

**Special Handling**:

1. **Discount Items**:
   ```javascript
   // Java: FusionInvoiceMapping.java:62-67
   if (lineItem.getItemName().equals("Discount Item")) {
     invoiceLine.setMemoLineName("Discount Item");
     if (lineItem.getTotalPrice() > 0) {
       invoiceLine.setQuantity(BigDecimal.valueOf(1));
     }
   }
   ```

2. **Unit Price Calculation**:
   ```javascript
   // Java: FusionInvoiceMapping.java:77-78
   BigDecimal sellingPrice = lineItem.getTotalPrice().divide(lineItem.getQuantity());
   invoiceLine.setUnitSellingPrice(sellingPrice.abs());
   ```

3. **UOM Lookup**:
   ```javascript
   // Java: FusionInvoiceMapping.java:71-73
   if (!uomCodeMapping.containsKey(itemMeta.getUomName())) {
     uomCodeMapping.put(itemMeta.getUomName(),
       fusionUomService.getUomCode(itemMeta.getUomName()));
   }
   ```

---

## Operation 2: Standard Receipt

**Purpose**: Record customer payment in Oracle AR

**Source Table**: `BACKUP_VENDHQ_PAYMENTS` (where `PAYMENT_TYPE` is Cash/Card/Bank)

**Oracle Endpoint**: `/fscmRestApi/resources/11.13.18.05/standardReceipts`

**Java Reference**: `FusionStdReceiptMapping.java`

### Standard Receipt Mapping

**Target**: `StandardReceiptRequest` → Oracle `standardReceipts`

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `ReceiptNumber` | Generated | `{PAYMENT_TYPE}-{TXN_NUMBER}` | `Cash-DXB01-20240517-001` |
| `ReceiptDate` | `PAYMENT_DATE` or `SALE_DATE` | Payment or sale date | `2024-05-17` |
| `ReceiptAmount` | `AMOUNT` | Payment amount | `95.00` |
| `CurrencyCode` | `CURRENCY` | Payment currency | `AED` |
| `ReceiptMethodId` | Metadata | From `fusion_receipt_method.receipt_method_id` | `101` |
| `RemittanceBankAccountId` | Register metadata | Cash or Bank account ID from `vendhq_registers` | `5001` |
| `CustomerAccountNumber` | Invoice header | From related invoice's bill-to account | `10001` |
| `BusinessUnitId` | Region lookup | From `fusion_business_unit_id_map` | `300000001234567` |

**Bank Account Selection**:
```javascript
// Java: FusionStdReceiptMapping.java:33-35
standardReceipt.setRemittanceBankAccountId(
  receiptMethodMeta.getReceiptIsCash().equals("1")
    ? registerDetails.getCashAccountId().longValue()
    : registerDetails.getBankAccountId().longValue()
);
```

**Classification Logic**:
```javascript
// Only create standard receipt for main payment types
function isStandardReceipt(paymentType) {
  const main = ['Cash', 'Card', 'Bank Transfer', 'Credit On Cust'];
  return main.some(type => paymentType.includes(type));
}
```

---

## Operation 3: Misc Receipt

**Purpose**: Record miscellaneous receipts (rounding, tips, adjustments)

**Source Table**: `BACKUP_VENDHQ_PAYMENTS` (where `PAYMENT_TYPE` is Rounding/Tip/Service)

**Oracle Endpoint**: `/fscmRestApi/resources/11.13.18.05/miscellaneousReceipts`

**Java Reference**: `FusionMiscReceiptMapping.java`

### Misc Receipt Mapping

**Target**: `MiscReceiptRequest` → Oracle `miscellaneousReceipts`

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `ReceiptNumber` | Generated | `{PAYMENT_TYPE}-{TXN_NUMBER}-MISC` | `Cash Rounding-DXB01-001-MISC` |
| `ReceiptDate` | `SALE_DATE` | Sale date from invoice | `2024-05-17` |
| `ReceiptAmount` | `AMOUNT` | Payment amount | `0.05` |
| `CurrencyCode` | `CURRENCY` | From invoice header | `AED` |
| `ReceiptMethodId` | Metadata | From `fusion_receipt_method` | `102` |
| `ReceiptMethodName` | `PAYMENT_TYPE` | Payment type (or "Cash" for rounding) | `Cash` |
| `BankAccountName` | Register metadata | Cash or bank account name | `CASH-DRAWER-01` |
| `ReceivableActivityName` | Metadata mapping | Activity code from `meta_mappings` | `ROUNDING` |
| `BusinessUnitId` | Region lookup | From `fusion_business_unit_id_map` | `300000001234567` |

**Bank Account Selection**:
```javascript
// Java: FusionMiscReceiptMapping.java:38-39
miscReceiptRequest.setBankAccountName(
  payment.getPaymentType().toLowerCase().contains("rounding")
    ? registerDetails.getCashAccount()
    : registerDetails.getBankAccount()
);
```

**Activity Name Selection**:
```javascript
// Java: FusionMiscReceiptMapping.java:40
miscReceiptRequest.setReceivableActivityName(
  payment.getPaymentType().toLowerCase().equals("cash rounding")
    ? metaMappings[1]  // Rounding activity
    : metaMappings[2]  // Other misc activity
);
```

---

## Operation 4: Apply Receipt

**Purpose**: Link receipts to invoices (apply payment to AR invoice)

**Source**: Result from Standard Receipt + Invoice operations

**Oracle Endpoint**: `/fscmRestApi/resources/11.13.18.05/receiptApplications`

**Java Reference**: `FusionApplyReceiptMapping.java`

### Apply Receipt Mapping

**Target**: `ApplyReceiptRequest` → Oracle `receiptApplications`

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `ReceiptNumber` | Standard Receipt | Receipt number from step 2 | `Cash-DXB01-20240517-001` |
| `ReceiptDate` | `PAYMENT_DATE` | Payment date | `2024-05-17` |
| `TransactionNumber` | Invoice Result | Invoice TRX_NUMBER from Oracle response | `DXB01-20240517-001` |
| `AmountApplied` | `AMOUNT` | Full payment amount | `95.00` |
| `ReceiptCurrency` | `CURRENCY` | Payment currency | `AED` |
| `TransactionSource` | Metadata | Same as invoice source | `MANUAL` |

**Application Logic**:
```javascript
// Java: FusionApplyReceiptMapping.java:21-29
applyReceiptRequest.setReceiptDate(standardReceiptRequest.getSaleDate());
applyReceiptRequest.setTransactionNumber(receiptInvoiceResultMapping.get(standardReceiptRequest));
applyReceiptRequest.setReceiptNumber(standardReceiptRequest.getReceiptNumber());
applyReceiptRequest.setAmountApplied(standardReceiptRequest.getReceiptAmount());
```

**Flow**:
1. Create AR Invoice → Get `TransactionNumber`
2. Create Standard Receipt → Get `ReceiptNumber`
3. Apply Receipt → Link them together

---

## Operation 5: Journal Entry

**Purpose**: Record service provider commission charges (HUNGERSTATION, TALABAT, etc.)

**Source**: Derived from `BACKUP_VENDHQ_SALES` + `BACKUP_VENDHQ_LINE_ITEMS`

**Oracle Endpoint**: `/fscmRestApi/resources/11.13.18.05/journalEntries`

**Java Reference**: `FusionJournalEntryMapping.java`

**Condition**: Only when `CUSTOMER_TYPE` is a service provider (HUNGERSTATION, TALABAT, etc.)

### Journal Header Mapping

**Target**: `JournalHeader` → Oracle `journalEntries`

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `LedgerName` | Metadata | From `service_provider_journal_mapping.ledger_id` | `Primary Ledger` |
| `JournalBatchName` | Generated | Batch identifier | `BATCH-SA-20240517` |
| `JournalName` | Generated | Journal name | `JE-HUNGERSTATION-001` |
| `AccountingDate` | `SALE_DATE` | Sale date | `2024-05-17` |
| `CurrencyCode` | `CURRENCY` | Transaction currency | `AED` |
| `JournalSource` | Metadata | From `service_provider_journal_mapping.je_source` | `Manual` |
| `JournalCategory` | Metadata | From `service_provider_journal_mapping.je_category` | `Sales` |

### Journal Lines Mapping

**Target**: `JournalLine` array → Oracle `journalLines`

Each sale creates **2 lines** (DEBIT + CREDIT):

#### CREDIT Line (Service Provider Revenue)

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `JeLineNum` | Sequential | Line number | `1` |
| `Segment1` | Metadata | Company code | `100` |
| `Segment2` | Metadata | Account code (CREDIT) | `41000` (Revenue) |
| `Segment3` | Metadata | Department | `001` |
| `Segment4` | Cost Center | From invoice/store | `CC001` |
| `EnteredDr` | `null` | No debit amount | `null` |
| `EnteredCr` | Calculated | Commission charge | `5.00` |
| `AccountingDate` | `SALE_DATE` | Sale date | `2024-05-17` |
| `SalesOrder` | `INVOICE_NUMBER` | Order reference | `POS/2024/001` |

#### DEBIT Line (Expense/Fee)

| Oracle Field | Source | Mapping Logic | Example |
|--------------|--------|---------------|---------|
| `JeLineNum` | Sequential | Line number | `2` |
| `Segment1` | Metadata | Company code | `100` |
| `Segment2` | Metadata | Account code (DEBIT) | `51000` (Expense) |
| `Segment3` | Metadata | Department | `001` |
| `Segment4` | Cost Center | From invoice/store | `CC001` |
| `EnteredDr` | Calculated | Commission charge | `5.00` |
| `EnteredCr` | `null` | No credit amount | `null` |
| `AccountingDate` | `SALE_DATE` | Sale date | `2024-05-17` |
| `SalesOrder` | `INVOICE_NUMBER` | Order reference | `POS/2024/001` |

**Charge Calculation**:
```javascript
// Java: FusionJournalEntryMapping.java:68-71
BigDecimal saleCharge = BigDecimal.valueOf(Double.valueOf(orderCharge));
BigDecimal saleBankCharge = saleCharge.multiply(
  creditJournalMapping.getBankChargeRate() != null
    ? creditJournalMapping.getBankChargeRate()
    : BigDecimal.valueOf(0)
);
BigDecimal finalCharge = fixedCharge
  ? (debitJournalMapping.getFixedFrieghtCharge() != null
      ? debitJournalMapping.getFixedFrieghtCharge()
      : saleBankCharge)
  : saleBankCharge;
```

**Types of Charges**:
1. **Percentage-based**: `order_total × commission_rate`
   - Example: 15% commission on 100 AED = 15 AED
2. **Fixed-charge**: Flat fee per order
   - Example: 5 AED delivery fee per order

---

## Operation Sequence

The operations must be executed in this order:

```
1. CREATE AR INVOICE
   ↓ (returns TransactionNumber)
   ↓
2. CREATE STANDARD RECEIPTS (parallel for each payment)
   ↓ (returns ReceiptNumber for each)
   ↓
3. CREATE MISC RECEIPTS (parallel for rounding/adjustments)
   ↓
4. APPLY RECEIPTS TO INVOICE (parallel, links each receipt)
   ↓
5. CREATE JOURNAL ENTRIES (if service provider)
```

### Error Handling

**Failed Operations**:
- Each operation failure is logged to `failed_records` table
- Job continues processing remaining records
- Failed records can be retried via `/api/odoo/retry-failed`

**Validation**:
```javascript
// Before pushing to Oracle
validateSale(mappedSale) {
  assert(mappedSale.TOTAL_PRICE >= 0);
  assert(mappedSale.TOTAL_TAX >= 0);
  assert(mappedSale.lines.length > 0);
  assert(mappedSale.payments.length > 0);

  const sumLines = sum(lines.TOTAL_PRICE);
  const sumPayments = sum(payments.AMOUNT);
  assert(Math.abs(sumPayments - mappedSale.TOTAL_PRICE_INCL_TAX) < 0.01);
}
```

---

## Configuration Requirements

### Required Metadata Tables

1. **`fusion_sales_metadata`**
   - `business_unit`, `txn_source`, `txn_type`
   - `bill_to_name`, `bill_to_account`, `site_number`
   - Keyed by: `(subinventory, customer_type)`

2. **`fusion_receipt_method`**
   - `receipt_method_id`, `receipt_is_cash`
   - Keyed by: `(region, payment_type)`

3. **`vendhq_outlets_db`**
   - `outlet_name`, `currency`, `region`
   - `subinventory` (for metadata lookup)

4. **`vendhq_registers`**
   - `cash_account_id`, `bank_account_id`
   - `cash_account`, `bank_account` (names)

5. **`vendhq_item_meta`**
   - `item_number`, `description`, `uom_name`

6. **`service_provider_journal_mapping`**
   - CREDIT/DEBIT account mappings
   - `bank_charge_rate`, `fixed_freight_charge`
   - Keyed by: `(customer_type, credit_debit, region)`

### Store Oracle Metadata API

The integration uses the **Store Oracle Metadata** feature to configure per-store settings:

**Endpoint**: `PUT /api/odoo/store-metadata/:storeId`

**Fields**:
- `receipt_method_meta`: Receipt method mappings per payment type
- `journal_meta`: Journal entry configuration
- `uom_code_map`: UOM code mappings

---

## Complete Example

### Input: Odoo Sale Order

```json
{
  "id": 12345,
  "name": "POS/2024/001",
  "date_order": "2024-05-17 14:30:00",
  "warehouse_id": [1, "Dubai Mall Store"],
  "pos_config_id": [10, "Register 01"],
  "amount_untaxed": 100.00,
  "amount_tax": 5.00,
  "amount_total": 105.00,
  "lines": [
    {
      "product_id": [500, "Coffee Latte"],
      "product_code": "PROD-001",
      "quantity": 2.0,
      "price_unit": 25.00,
      "price_subtotal": 50.00,
      "price_tax": 2.50,
      "tax_id": [[1, "VAT 5%"]]
    },
    {
      "product_id": [501, "Croissant"],
      "product_code": "PROD-002",
      "quantity": 2.0,
      "price_unit": 25.00,
      "price_subtotal": 50.00,
      "price_tax": 2.50,
      "tax_id": [[1, "VAT 5%"]]
    }
  ],
  "payments": [
    {
      "amount": 105.00,
      "payment_method_code": "Cash",
      "currency_id": [1, "AED"],
      "date": "2024-05-17"
    }
  ]
}
```

### Output: Oracle Operations

#### 1. AR Invoice
```json
{
  "BusinessUnit": "AE_BU_1",
  "TransactionSource": "MANUAL",
  "TransactionType": "Invoice",
  "TransactionNumber": "DXB01-20240517-001",
  "BillToCustomerNumber": "10001",
  "InvoiceCurrencyCode": "AED",
  "InvoiceLines": [
    {
      "LineNumber": 1,
      "ItemNumber": "PROD-001",
      "Quantity": 2.0,
      "UnitSellingPrice": 25.00,
      "TaxClassificationCode": "VAT_5_PCT"
    },
    {
      "LineNumber": 2,
      "ItemNumber": "PROD-002",
      "Quantity": 2.0,
      "UnitSellingPrice": 25.00,
      "TaxClassificationCode": "VAT_5_PCT"
    }
  ]
}
```

#### 2. Standard Receipt
```json
{
  "ReceiptNumber": "Cash-DXB01-20240517-001",
  "ReceiptAmount": 105.00,
  "CurrencyCode": "AED",
  "ReceiptMethodId": 101,
  "CustomerAccountNumber": "10001"
}
```

#### 3. Apply Receipt
```json
{
  "ReceiptNumber": "Cash-DXB01-20240517-001",
  "TransactionNumber": "DXB01-20240517-001",
  "AmountApplied": 105.00
}
```

---

## See Also

- [ODOO_VENDHQ_MAPPING.md](./ODOO_VENDHQ_MAPPING.md) - Odoo → VendHQ mapping
- [database.sql](./database.sql) - Table schemas
- [oracle-crm/src/pushOracle.js](./oracle-crm/src/pushOracle.js) - Oracle push service
- [oracle-crm/src/calculations.js](./oracle-crm/src/calculations.js) - Calculation functions
