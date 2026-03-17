# Calculations, Business Logic & CMS Environment Guide

> This document covers two things you asked about:
> 1. **Every calculation and business rule** the code performs before pushing data to Oracle Fusion
> 2. **How to build a separate CMS/API environment** so you can push data to Oracle without running the Java scheduler

---

## Table of Contents

1. [All Calculations Before Data Is Sent to Oracle](#1-all-calculations-before-data-is-sent-to-oracle)
   - [1.1 Timezone & Date Calculations](#11-timezone--date-calculations)
   - [1.2 Date Range / Day Window Calculations](#12-date-range--day-window-calculations)
   - [1.3 Invoice Grouping Key](#13-invoice-grouping-key)
   - [1.4 Invoice Line Calculations](#14-invoice-line-calculations)
   - [1.5 Inventory Transaction Calculations](#15-inventory-transaction-calculations)
   - [1.6 Receipt Amount Calculations](#16-receipt-amount-calculations)
   - [1.7 Journal Entry Charge Calculations](#17-journal-entry-charge-calculations)
   - [1.8 Deduplication / Duplicate Detection](#18-deduplication--duplicate-detection)
   - [1.9 Field Type Conversions](#19-field-type-conversions)
2. [Business Rules Summary](#2-business-rules-summary)
3. [Can You Create a CMS Environment?](#3-can-you-create-a-cms-environment)
4. [CMS Architecture Design](#4-cms-architecture-design)
5. [API Call Sequence (What the CMS Must Execute)](#5-api-call-sequence-what-the-cms-must-execute)
6. [CMS Form Field Reference](#6-cms-form-field-reference)
7. [Technology Options for the CMS](#7-technology-options-for-the-cms)
8. [End-to-End CMS Request Flow Example](#8-end-to-end-cms-request-flow-example)

---

## 1. All Calculations Before Data Is Sent to Oracle

### 1.1 Timezone & Date Calculations

**Where:** `FusionSOAPClient/src/innovate/tamergroup/fusion/soap/utils/MappingUtils.java` (line 14–20)
and `IntegrationJobs/src/innovate/tamergroup/vendhq/integrations/VendHQSalesToFusionInvRecIntBackup.java` (lines 84–86)

All sale dates stored in the database are in **UTC**. Before sending to Oracle Fusion, they are converted to the regional timezone so GL dates are correct.

**Step 1 – Extract whole hours from the timezone offset:**
```
Input:  timeZoneOffset = BigDecimal (e.g. 3.5 for UTC+3:30)
Output: hoursOffset    = timeZoneOffset.intValue()   → 3

File:   VendHQSalesToFusionInvRecIntBackup.java : line 84
```

**Step 2 – Extract fractional minutes from the timezone offset:**
```
Input:  minutesDecimal = timeZoneOffset.abs().floatValue()   → 3.5
Output: minutesOffset  = (int)((minutesDecimal * 100 % 100) * 60 / 100)

Worked example (UTC+3:30):
  minutesDecimal * 100        = 350.0
  350.0 % 100                 = 50.0      ← fractional hours as hundredths
  50.0  * 60 / 100            = 30        ← minutes

File:   VendHQSalesToFusionInvRecIntBackup.java : line 86
```

**Step 3 – Apply offset to the UTC date:**
```
calendar.setTime(utcDate)
calendar.add(Calendar.HOUR,   hoursOffset)    // add whole hours
calendar.add(Calendar.MINUTE, minutesOffset)  // add fractional minutes
result = calendar.getTime()

Example: 2024-01-15 07:00 UTC + 3h30m → 2024-01-15 10:30 regional time
This date is used as the Invoice/GL Date sent to Oracle Fusion.

File: MappingUtils.java : line 16–19
```

---

### 1.2 Date Range / Day Window Calculations

**Where:** `VendHQSalesToFusionInvRecIntBackup.java` (lines 88–98)

These calculations decide how many days of sales to process in a single scheduler run.

**Step 1 – Calculate days since last processed sale:**
```
diffLong = currentCalendar.getTimeInMillis() - lastSaleDate.getTime()   // milliseconds
diffDays = (int)(diffLong / (1000 * 60 * 60 * 24))                     // convert to days

Example:
  lastSaleDate  = 2024-01-10
  today         = 2024-01-15
  diffLong      = 5 days × 86,400,000 ms = 432,000,000 ms
  diffDays      = 432,000,000 / 86,400,000 = 5

File: VendHQSalesToFusionInvRecIntBackup.java : lines 94–95
```

**Step 2 – Choose days to process (manual vs automatic):**
```
daysToAdd = isManual ? (dateRange <= 0 ? 1 : dateRange) : diffDays

  Automatic mode:  uses the calculated diffDays (catch up from last run)
  Manual mode:     uses the user-supplied dateRange (minimum 1 day)

File: VendHQSalesToFusionInvRecIntBackup.java : line 97
```

**Step 3 – Apply 7-day cap:**
```
finalDaysAddition = daysToAdd <= 7 ? daysToAdd - 1 : 7

  If backlog is 3 days:   finalDaysAddition = 3 - 1 = 2   (processes days 0, 1, 2)
  If backlog is 10 days:  finalDaysAddition = 7            (processes only 7 days)

Note: -1 converts count to loop counter (while finalDaysAddition-- >= 0)

File: VendHQSalesToFusionInvRecIntBackup.java : line 98
```

---

### 1.3 Invoice Grouping Key

**Where:** `VendHQSalesToFusionInvRecTransBackup.java` (lines 101–110)

Sales from the same day, outlet, and customer type are **grouped into one invoice** in Oracle. The grouping key determines which invoice a sale line belongs to.

```
saleKey = "{DAY_OF_MONTH}-{MONTH}-{YEAR}{customerType}"

If any payment for this sale has type "Credit On Cust":
    saleKey = saleKey + "**Credit"

Examples:
  Normal sale on 15 Jan 2024:   "15-0-2024NORMAL"
  Credit sale on 15 Jan 2024:   "15-0-2024CREDIT**Credit"
  Hunger Station sale:          "15-0-2024HUNGERSTATION"

Note: MONTH is 0-indexed because Java's Calendar.MONTH starts at 0.
  January = 0, February = 1, … December = 11.
  So a sale on 15 January produces month value 0, giving the key "15-0-2024NORMAL".
  Implementers using other languages must subtract 1 from a 1-indexed month value.

File: VendHQSalesToFusionInvRecTransBackup.java : lines 101–110
```

---

### 1.4 Invoice Line Calculations

**Where:** `FusionInvoiceMapping.java` (lines 54–80)

**Calculation 1 – Unit Selling Price:**
```
sellingPrice     = lineItem.totalPrice  /  lineItem.quantity
unitSellingPrice = sellingPrice.abs()    ← always positive

Why abs()? Returns (e.g. refund lines) have negative totalPrice.
Oracle requires positive unit prices; the sign is handled by the
transaction type (Sales Issue vs RMA).

Example (sale):   totalPrice=1000, quantity=5  → 1000/5=200, abs=200
Example (return): totalPrice=-200, quantity=2  → -200/2=-100, abs=100

File: FusionInvoiceMapping.java : lines 76–77
```

**Calculation 2 – Discount Item Quantity Override:**
```
IF lineItem.itemName == "Discount Item" AND lineItem.totalPrice > 0:
    quantity = 1   ← force to 1 unit regardless of original quantity

Why? Oracle treats discount lines as a single adjustment, not
a per-unit quantity. A positive totalPrice means it is an
actual discount charge (not a return), so quantity = 1.

File: FusionInvoiceMapping.java : lines 64–65
```

**Calculation 3 – Conversion Rate Type:**
```
IF salesMetaData.rateIsCorporate == "1":
    conversionRateType = "Corporate"
ELSE:
    conversionRateType = "User"

This controls how Oracle Fusion handles multi-currency invoices.

File: FusionInvoiceMapping.java : line 50
```

**Calculation 4 – Line Number Auto-Increment:**
```
invoiceLine.lineNumber = invoiceHeader.getInvoiceLines().size() + 1

Ensures each line in Oracle gets a sequential unique number
within its invoice (1, 2, 3, ...).

File: FusionInvoiceMapping.java : line 55
```

---

### 1.5 Inventory Transaction Calculations

**Where:** `FusionInvTxnMapping.java` (lines 34–58)

**Calculation 1 – Quantity Sign (always negative for Oracle):**
```
transactionQuantity = lineItem.quantity.doubleValue() * -1

Oracle Inventory records stock reductions as negative quantities.
A sale of 5 units = -5 in the inventory transaction.

Example: quantity=3 → transactionQuantity=-3
Example: return of 2 units: quantity=-2 → transactionQuantity=+2 (RMA)

File: FusionInvTxnMapping.java : line 52
```

**Calculation 2 – Transaction Type (Sales Issue vs RMA):**
```
IF totalPrice == 0:
    IF quantity > 0 → type = "Vend Sales Issue"   (free giveaway)
    ELSE            → type = "Vend RMA"            (return at zero cost)
ELSE IF totalPrice > 0:
    type = "Vend Sales Issue"   (normal sale)
ELSE:
    type = "Vend RMA"           (paid return / credit note)

For non-NORMAL customers, the type names come from the
ServiceProviderJournalMapping table (costIssue, costRMA fields)
instead of the hardcoded defaults.

File: FusionInvTxnMapping.java : lines 53–58
```

**Calculation 3 – Organization Name Lookup (cached):**
```
Uses outletName → REST API call to Oracle Fusion → OrganizationName
Result is cached in HashMap to avoid redundant API calls.

File: FusionInvTxnMapping.java : lines 35–37
```

---

### 1.6 Receipt Amount Calculations

**Where:** `VendHQSalesToFusionInvRecTransBackup.java` (lines 197–255)

Each payment method creates its own receipt. Receipts are accumulated across
all sales for the same outlet on the same day.

**Calculation 1 – Standard Receipt Amount Accumulation:**
```
FOR each payment in sale (excluding "Cash Rounding"):
    standardReceiptRequest.receiptAmount += payment.amount

This sums all non-rounding payments for the same receipt method
into one daily receipt per method per outlet.

Example across 3 sales:
  Sale 1 Visa: 500 AED
  Sale 2 Visa: 300 AED
  Sale 3 Visa: 200 AED
  → One "Visa" receipt for 1000 AED

File: VendHQSalesToFusionInvRecTransBackup.java : lines 207, 221
```

**Calculation 2 – Region-Based Cash Account Selection:**
```
IF outletDetail.region == "KW":
    receiptMethodName = "Cash KW"
ELSE:
    receiptMethodName = "Cash"

File: VendHQSalesToFusionInvRecTransBackup.java : lines 211, 213
```

**Calculation 3 – Miscellaneous Receipt Charge (Bank Charges + Tax):**
```
IF paymentType == "Cash Rounding":
    miscCharges = payment.amount          ← direct rounding adjustment

ELSE:
    temp1       = payment.amount × receiptMethodMeta.receiptBankCharge
    temp2       = receiptMethodMeta.receiptMethodTax + 1
    miscCharges = temp1 × temp2

    Worked example:
      payment.amount          = 1000 AED
      receiptBankCharge       = 0.02  (2%)
      receiptMethodTax        = 0.05  (5%)
      temp1  = 1000 × 0.02   = 20 AED
      temp2  = 0.05 + 1      = 1.05
      miscCharges = 20 × 1.05 = 21 AED

File: VendHQSalesToFusionInvRecTransBackup.java : lines 238–242
```

**Calculation 4 – Debit Card Charge Cap (Oman only):**
```
IF paymentType == "Debit Card"
   AND outletDetail.region == "OM"
   AND miscCharges > 10:
       miscCharges = 10   ← capped at 10 OMR

File: VendHQSalesToFusionInvRecTransBackup.java : lines 244–245
```

**Calculation 5 – Net Miscellaneous Receipt Amount:**
```
miscReceiptRequest.receiptAmount = miscReceiptRequest.receiptAmount - miscCharges

The standard receipt amount starts equal to the payment amount.
Bank charges are then deducted to get the net amount actually
remitted after charges.

Example: payment=1000 AED, charges=21 AED → net receipt = 979 AED

File: VendHQSalesToFusionInvRecTransBackup.java : line 247
```

---

### 1.7 Journal Entry Charge Calculations

**Where:** `FusionJournalEntryMapping.java` (lines 67–75)

Journal entries are created only for **non-NORMAL** customers (e.g., Hunger Station, delivery aggregators).
Two journal lines are always created: one CREDIT and one DEBIT.

**Calculation 1 – Sale Charge Base:**
```
saleCharge = BigDecimal.valueOf(Double.valueOf(orderCharge))

Converts the raw string total (from BackupVendhqSales) to BigDecimal
for arithmetic. orderCharge is typically the invoice total.

File: FusionJournalEntryMapping.java : line 68
```

**Calculation 2 – Bank Charge Percentage:**
```
saleBankCharge = saleCharge × (creditJournalMapping.bankChargeRate OR 0)

Applies the configured bank charge percentage to the sale total.
If bankChargeRate is null, defaults to 0 (no charge).

Example: saleCharge=2000 AED, bankChargeRate=0.02 → saleBankCharge=40 AED

File: FusionJournalEntryMapping.java : line 69
```

**Calculation 3 – Final Charge (Fixed vs Percentage):**
```
IF fixedCharge == true:
    finalCharge = debitJournalMapping.fixedFreightCharge  (if configured)
                  OR saleBankCharge                        (fallback)
ELSE:
    finalCharge = saleBankCharge

fixedCharge=true means the journal entry uses a fixed freight amount
rather than a percentage of the sale (e.g. a flat 50 AED delivery fee).

File: FusionJournalEntryMapping.java : lines 70–72
```

**Calculation 4 – Credit vs Debit Line Assignment:**
```
IF creditDebit == "CREDIT":
    journalLine.enteredDrAmount = finalCharge    ← DEBIT side
    journalLine.accountedDr     = finalCharge
ELSE:
    journalLine.enteredCrAmount = finalCharge    ← CREDIT side
    journalLine.accountedCr     = finalCharge

Two lines are always written: one CREDIT, one DEBIT (balanced entry).
Currency conversion rate is hardcoded to 1.0 (same currency).

File: FusionJournalEntryMapping.java : lines 109–115
```

**Calculation 5 – Accounting Period Name:**
```
periodName = SimpleDateFormat("MMM-yy").format(saleDate)

Example: 2024-01-15 → "Jan-24"
Used as the GL period name when posting to Oracle Fusion GL.

File: FusionJournalEntryMapping.java : line 170 (getPeriodName method)
```

---

### 1.8 Deduplication / Duplicate Detection

The code has four duplicate-detection checks to prevent records being created twice in Oracle:

| Check | Key Used | Where |
|-------|----------|-------|
| Duplicate invoice line | `invoiceNumber + lineItemId` | Before adding line to invoice |
| Duplicate inventory transaction | `invoiceNumber + itemSku` | Before creating inv txn |
| Duplicate receipt | `salesOrder + saleDate` stored in `salesReceiptDoneStatus` HashSet | Before creating receipt |
| Duplicate journal line | `{FIXED\|BANK}***{txnNumber}***{customerType}***{salesOrder}` stored in `journalLineSaleMap` HashSet | Before adding journal line |

---

### 1.9 Field Type Conversions

These conversions happen inside `SalesFusionPersistence.java` before writing status back to the database:

```
// Oracle transaction ID (Long → BigDecimal for DB column)
customerTrxId = BigDecimal.valueOf(invoiceResult.getCustomerTransactionId())

// Transaction number (String → Long → BigDecimal)
transactionNumber = BigDecimal.valueOf(Long.valueOf(invoiceResult.getTransactionNumber()))

// Message truncation to 500 chars (DB column limit)
message = (message.length() >= 500) ? message.substring(0, 500) : message
```

---

## 2. Business Rules Summary

| # | Rule | Condition | Effect |
|---|------|-----------|--------|
| 1 | Credit On Customer | Payment type = "Credit On Cust" | Sale key gets `**Credit` suffix; separate invoice group |
| 2 | Discount Item quantity | itemName = "Discount Item" AND totalPrice > 0 | Force quantity = 1 |
| 3 | Skip zero-quantity lines | quantity == 0 | Skip line entirely; not sent to Oracle |
| 4 | Cash Rounding receipt | paymentType = "Cash Rounding" | Skip standard receipt; only create misc receipt |
| 5 | KW Cash account | region = "KW" | Use "Cash KW" receipt method instead of "Cash" |
| 6 | OM Debit Card cap | region = "OM" AND paymentType = "Debit Card" AND charge > 10 | Cap misc charge at 10 OMR |
| 7 | Journal entry creation | customerType ≠ "NORMAL" | Create both fixed service charge + bank service charge journal entries |
| 8 | Corporate conversion rate | rateIsCorporate = "1" | Set conversionRateType = "Corporate" on invoice |
| 9 | Free item transaction type | totalPrice = 0 AND quantity > 0 | Transaction type = "Vend Sales Issue" (not RMA) |
| 10 | Return transaction type | totalPrice < 0 | Transaction type = "Vend RMA" |
| 11 | UOM code caching | Same UOM seen twice | Reuse cached REST API result; no repeat API call |
| 12 | Org name caching | Same outlet seen twice | Reuse cached REST API result; no repeat API call |

---

## 3. Can You Create a CMS Environment?

**Yes — absolutely.** You can build a completely separate web-based environment (CMS, admin panel, or REST API gateway) that:

- Accepts sale data through a web form or REST endpoint
- Applies all the calculations listed above in your preferred language
- Calls Oracle Fusion REST APIs directly
- Stores results in the integration database

This works because **Oracle Fusion is fully accessible via REST APIs** using HTTP Basic Auth — the same credentials already in the codebase. You do not need Oracle WebLogic, ADF, or any Java EE infrastructure.

---

## 4. CMS Architecture Design

Here is the recommended architecture for a standalone CMS environment:

```
┌──────────────────────────────────────────────────────┐
│              CMS Web Interface                       │
│  (React / Vue / Angular / plain HTML form)           │
│                                                      │
│  ┌─────────────┐  ┌──────────────┐  ┌────────────┐  │
│  │ Sale Entry  │  │ Review/Approve│  │  Status    │  │
│  │ Form        │  │ Screen       │  │  Dashboard  │  │
│  └──────┬──────┘  └──────┬───────┘  └─────┬──────┘  │
└─────────┼────────────────┼────────────────┼──────────┘
          │                │                │
          ▼                ▼                ▼
┌──────────────────────────────────────────────────────┐
│            CMS Backend API (Node.js / Python / Java) │
│                                                      │
│  /api/sales/submit   → applies all calculations      │
│  /api/sales/preview  → shows computed values         │
│  /api/push/oracle    → sends to Oracle Fusion        │
│  /api/status/{id}    → returns push result           │
└──────────────────────┬───────────────────────────────┘
                       │  HTTP Basic Auth
          ┌────────────┼────────────┐
          ▼            ▼            ▼
   ┌─────────────┐ ┌───────┐ ┌──────────────┐
   │Oracle Fusion│ │Oracle │ │ Integration  │
   │REST APIs    │ │  GL   │ │   Database   │
   │(Receivables,│ │ REST  │ │ (status log) │
   │ Inventory)  │ │  API  │ │              │
   └─────────────┘ └───────┘ └──────────────┘
```

**What the CMS backend does:**
1. Receives sale data (header + lines + payments) via form or JSON
2. Runs all calculations (timezone, pricing, receipts, journals)
3. Builds the correct Oracle Fusion REST request bodies
4. Calls Oracle APIs in the correct sequence
5. Stores results and shows success/failure per record

---

## 5. API Call Sequence (What the CMS Must Execute)

The CMS must call Oracle Fusion APIs in this **exact order** for each sale group:

```
Step 1 ── GET /customers?q=CustomerNumber='{accountNumber}'
          Purpose: Retrieve CustomerId, OrgId for receipt creation
          Required before: Steps 3, 4

Step 2 ── GET /units?q=UnitOfMeasureName='{uomName}'       [per line item]
          Purpose: Get Oracle UomCode from VendHQ UOM name
          Cache result by UOM name to avoid repeat calls

Step 3 ── POST /receivablesInvoices
          Body: Invoice header + all line items
          Returns: TransactionNumber, CustomerTrxId
          Required before: Steps 4, 5, 6

Step 4 ── POST /receivablesReceipts  (Standard Receipt)
          Body: Receipt method, amount, customer, receipt number
          Returns: ReceiptId
          Required before: Step 5
          Skip if: all payments are "Cash Rounding"

Step 5 ── POST /receivablesReceipts/{ReceiptId}/child/applyReceiptOnAccount
          Body: TransactionNumber (from Step 3), AmountApplied
          Purpose: Links the receipt to the invoice
          Skip if: Step 4 was skipped

Step 6 ── POST /receivablesReceipts  (Miscellaneous Receipt)
          Body: Bank charges / cash rounding amounts
          Apply bank charge calculation (see Section 1.6) before this call
          Skip if: miscCharges == 0

Step 7 ── POST /inventoryTransactions
          Body: List of transaction lines (negative quantities)
          Apply transaction type logic (see Section 1.5) before this call
          Can be sent as a batch (multiple lines in one call)

Step 8 ── POST /journals   [only for non-NORMAL customer types]
          Body: Journal header + debit + credit lines
          Apply journal charge calculations (see Section 1.7) before this call
```

---

## 6. CMS Form Field Reference

### Section A – Sale Header

| Field | Type | Required | Maps To | Notes |
|-------|------|----------|---------|-------|
| Invoice Number | Text | ✓ | `BackupVendhqSales.invoiceNumber` | Used as SalesOrder in Oracle |
| Sale Date | Date picker | ✓ | `BackupVendhqSales.saleDate` | In UTC; timezone offset applied in backend |
| Customer Type | Dropdown | ✓ | `BackupVendhqSales.customerType` | NORMAL, CREDIT, HUNGERSTATION, etc. |
| Outlet | Dropdown | ✓ | `VendhqOutletsDB.outletName` | Determines region, currency, org |
| Region | Auto-fill | ✓ | `VendhqOutletsDB.region` | From outlet selection |
| Currency | Auto-fill | ✓ | `VendhqOutletsDB.currency` | From outlet selection |
| Timezone Offset | Number | ✓ | `timeZoneOffset` | Decimal (e.g. 3.5 for UTC+3:30) |
| Tax Code | Text | ✓ | `fusionTaxCode` | Applied to all lines |
| Total Price (incl. tax) | Calculated | – | `BackupVendhqSales.totalPriceInclTax` | Sum of line totals |

### Section B – Sale Line Items (repeating)

| Field | Type | Required | Maps To | Notes |
|-------|------|----------|---------|-------|
| Item Number | Text | ✓ | `BackupVendhqLineItems.itemNumber` | Oracle item code |
| Item Name | Text | ✓ | `BackupVendhqLineItems.itemName` | Used to detect "Discount Item" |
| Quantity | Number | ✓ | `BackupVendhqLineItems.quantity` | Skip if 0 |
| Total Price | Number | ✓ | `BackupVendhqLineItems.totalPrice` | Used to derive unit price |
| Tax Name | Text | ✓ | `BackupVendhqLineItems.taxName` | Oracle TaxClassificationCode |
| Line Number | Auto | – | `BackupVendhqLineItems.lineNumber` | Sequential; auto-assigned |
| **Unit Selling Price** | Calculated | – | `InvoiceLineModel.unitSellingPrice` | = ABS(totalPrice / quantity) |

### Section C – Payments (repeating)

| Field | Type | Required | Maps To | Notes |
|-------|------|----------|---------|-------|
| Payment Type | Dropdown | ✓ | `BackupVendhqPayments.paymentType` | Cash, Visa, Debit Card, Cash Rounding, Credit On Cust |
| Amount | Number | ✓ | `BackupVendhqPayments.amount` | Gross payment amount |
| **Bank Charge Rate** | Lookup | – | `receiptMethod.receiptBankCharge` | Loaded from DB config |
| **Method Tax** | Lookup | – | `receiptMethod.receiptMethodTax` | Loaded from DB config |
| **Misc Charges** | Calculated | – | `miscCharges` | = amount × bankRate × (tax+1) |
| **Net Receipt** | Calculated | – | `standardReceiptRequest.receiptAmount` | = amount − miscCharges |

---

## 7. Technology Options for the CMS

You can build the CMS using any modern web technology. Below are the three most practical choices:

### Option A – Node.js + Express (Recommended for Speed)

```
cms-oracle/
├── server.js                  ← Express API server
├── calculations/
│   ├── timezoneCalc.js        ← UTC → regional date
│   ├── invoiceCalc.js         ← unit price, grouping key, rate type
│   ├── receiptCalc.js         ← bank charges, cap, net amount
│   └── journalCalc.js         ← charge percentage, fixed vs bank
├── oracle/
│   ├── fusionClient.js        ← axios/fetch with Basic Auth
│   ├── invoiceApi.js          ← POST /receivablesInvoices
│   ├── receiptApi.js          ← POST /receivablesReceipts
│   ├── inventoryApi.js        ← POST /inventoryTransactions
│   └── journalApi.js          ← POST /journals
├── routes/
│   ├── salesRoutes.js         ← POST /api/sales/submit
│   └── statusRoutes.js        ← GET /api/status/:id
├── frontend/                  ← HTML form or React app
│   └── index.html
├── .env                       ← Oracle credentials (never commit)
└── package.json
```

**Sample `.env`:**
```
FUSION_BASE_URL=https://{your-instance-name}.fa.{region}.oraclecloud.com
FUSION_USERNAME={your-oracle-fusion-username}
FUSION_PASSWORD={retrieve-from-secrets-manager}
INTEGRATION_DB_URL=jdbc:oracle:thin:@{db-host}:{port}:{service}
```

**Sample Oracle API call (Node.js):**
```javascript
const axios = require('axios');

const fusionClient = axios.create({
  baseURL: process.env.FUSION_BASE_URL + '/fscmRestApi/resources/11.13.18.05',
  auth: {
    username: process.env.FUSION_USERNAME,
    password: process.env.FUSION_PASSWORD
  },
  headers: { 'Content-Type': 'application/json' }
});

async function createInvoice(invoicePayload) {
  const response = await fusionClient.post('/receivablesInvoices', invoicePayload);
  return response.data;
}
```

---

### Option B – Python + FastAPI

```
cms-oracle/
├── main.py                    ← FastAPI app
├── calculations.py            ← All 16 calculations (pure functions)
├── oracle_client.py           ← httpx client with Basic Auth
├── models.py                  ← Pydantic input/output models
├── routes/
│   ├── sales.py
│   └── status.py
├── templates/                 ← Jinja2 HTML templates
└── requirements.txt
```

**Sample calculation function (Python):**
```python
from decimal import Decimal

def calculate_misc_charges(payment_amount: Decimal, bank_charge_rate: Decimal,
                            method_tax: Decimal, payment_type: str, region: str) -> Decimal:
    if payment_type.lower() == "cash rounding":
        return payment_amount
    
    temp1 = payment_amount * bank_charge_rate
    temp2 = method_tax + Decimal("1")
    misc_charges = temp1 * temp2
    
    # Oman Debit Card cap
    if payment_type == "Debit Card" and region == "OM" and misc_charges > Decimal("10"):
        misc_charges = Decimal("10")
    
    return misc_charges

def calculate_unit_selling_price(total_price: Decimal, quantity: Decimal) -> Decimal:
    return abs(total_price / quantity)

def calculate_timezone_offset_date(utc_date, hours_offset: int, minutes_offset: int):
    from datetime import timedelta
    return utc_date + timedelta(hours=hours_offset, minutes=minutes_offset)
```

---

### Option C – Low-Code / No-Code (Fastest Setup)

If you want to avoid custom development entirely:

| Tool | What It Does | Oracle Fusion Support |
|------|-------------|----------------------|
| **Postman + Collection Runner** | Run the existing `Fusion_Endpoints_Postman_Collection.json` manually or in sequence | ✓ Already in repo |
| **Oracle Integration Cloud (OIC)** | Drag-and-drop flow designer; built-in Fusion adapter | ✓ Native |
| **MuleSoft Anypoint** | Enterprise integration platform; Fusion connector available | ✓ |
| **n8n (self-hosted)** | Open-source workflow automation; HTTP node for REST calls | Partial |
| **Power Automate** | Microsoft low-code; HTTP actions for Oracle REST | Partial |

**Using the existing Postman collection:**
The file `Fusion_Endpoints_Postman_Collection.json` already contains all Oracle Fusion API calls. You can:
1. Open it in Postman
2. Set environment variables (hostname, credentials) using `Fusion_Environment.json`
3. Run individual requests or the full collection in sequence
4. Use Postman's Collection Runner to iterate over multiple sales records

---

## 8. End-to-End CMS Request Flow Example

Here is a concrete example showing how the CMS would process one sale entry:

**Input (sale submitted via CMS form):**
```
Invoice Number:   AND001
Sale Date:        2024-01-15 07:00 UTC
Outlet:           Dubai Store (region=AE, currency=AED)
Customer Type:    NORMAL
Timezone Offset:  4.0 (UAE = UTC+4)
Payment:          Visa, 1050 AED
Line 1:           Item A, qty=3, totalPrice=900, tax=VAT5
Line 2:           Discount Item, qty=5, totalPrice=150, tax=ZERO
```

**CMS Backend Calculations:**

```
1. Timezone: 2024-01-15 07:00 UTC + 4h = 2024-01-15 11:00 GST
   → invoiceDate = 2024-01-15

2. Invoice grouping key: "15-0-2024NORMAL"

3. Line 1 unit price: ABS(900/3) = 300 AED
4. Line 2 quantity override: "Discount Item" + price>0 → quantity=1
5. Line 2 unit price: ABS(150/1) = 150 AED

6. Inventory Line 1: quantity = 3 * -1 = -3, type = "Vend Sales Issue"
7. Inventory Line 2: price>0 → type = "Vend Sales Issue", qty = 1 * -1 = -1

8. Visa bank charge rate = 0.02, method tax = 0.05
   temp1 = 1050 * 0.02 = 21
   temp2 = 0.05 + 1    = 1.05
   miscCharges = 21 * 1.05 = 22.05 AED
   net receipt = 1050 - 22.05 = 1027.95 AED

9. customerType = NORMAL → NO journal entry
```

**CMS API Calls to Oracle Fusion:**

```
→ POST /receivablesInvoices
  { BillToCustomerName: "...", TransactionDate: "2024-01-15",
    invoiceLines: [
      { LineNumber: 1, ItemNumber: "ITEM-A", Quantity: 3, UnitSellingPrice: 300 },
      { LineNumber: 2, MemoLineName: "Discount Item", Quantity: 1, UnitSellingPrice: 150 }
    ] }
  ← Returns: TransactionNumber="214350"

→ POST /receivablesReceipts
  { ReceiptNumber: "Visa-214350", Amount: 1027.95, ... }
  ← Returns: ReceiptId="55001"

→ POST /receivablesReceipts/55001/child/applyReceiptOnAccount
  { TransactionNumber: "214350", AmountApplied: 1027.95 }
  ← Returns: ApplicationId="88012", Status="APP"

→ POST /receivablesReceipts   (Misc – bank charges)
  { ReceiptNumber: "Visa-214350-MISC", Amount: 22.05, ... }

→ POST /inventoryTransactions
  { transactionLines: [
      { Item: "ITEM-A-SKU", TransactionQuantity: -3, TransactionType: "Vend Sales Issue" },
      { Item: "DISC-SKU",   TransactionQuantity: -1, TransactionType: "Vend Sales Issue" }
  ] }

(No journal entry – NORMAL customer)
```

---

## Security Note

When building the CMS, never store Oracle Fusion credentials in source code or commit them to Git.
Use environment variables or a secrets manager:

```bash
# .gitignore — add these entries
.env
config/secrets.json
*.credentials
```

```
# Required environment variables for CMS
FUSION_BASE_URL=https://yourhost.fa.ap2.oraclecloud.com
FUSION_USERNAME=integration.user@company.com
FUSION_PASSWORD=<from secrets manager>
```
