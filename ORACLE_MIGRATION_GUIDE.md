# Oracle Data Push – How It Works & API-Based Migration Guide

> **Purpose:** This document explains exactly how data is currently pushed to Oracle Fusion, identifies the root causes of slow performance, and provides a concrete API-based migration strategy that can dramatically speed up the process — without requiring any code changes first.

---

## Table of Contents

1. [How Data Is Currently Pushed to Oracle](#1-how-data-is-currently-pushed-to-oracle)
2. [The Five-Layer Architecture](#2-the-five-layer-architecture)
3. [Step-by-Step Data Push Flow](#3-step-by-step-data-push-flow)
4. [Why the Current Code Is Slow](#4-why-the-current-code-is-slow)
5. [Can You Do This Migration Using APIs?](#5-can-you-do-this-migration-using-apis)
6. [Recommended API-Based Migration Approach](#6-recommended-api-based-migration-approach)
7. [Oracle Fusion REST API Quick Reference](#7-oracle-fusion-rest-api-quick-reference)
8. [Performance Comparison: Current vs API-Based](#8-performance-comparison-current-vs-api-based)
9. [Migration Checklist](#9-migration-checklist)

---

## 1. How Data Is Currently Pushed to Oracle

The integration platform synchronises data from **VendHQ POS** → **Oracle Fusion ERP** in three categories:

| Data Type | Oracle Fusion Target | Method Used |
|-----------|---------------------|-------------|
| Sales Invoices | Receivables (`RecInvoiceService`) | SOAP – one call per invoice |
| Standard & Misc Receipts | Receivables (`ReceiptService`) | SOAP – one call per receipt |
| Journal Entries | General Ledger (`importJournal`) | SOAP – one call per journal |
| Inventory Transactions | Inventory Management | REST – batched per outlet |

### Connection Details

| Setting | Value |
|---------|-------|
| Integration DB host | `144.21.91.9:1521:INTEG` (Oracle JDBC thin) |
| Oracle Fusion host | `{hostname}.fa.{region}.oraclecloud.com` |
| Auth for SOAP | HTTP Basic Auth (username / password) |
| Auth for REST | HTTP Basic Auth via `OkHttpClient` |
| JPA Provider | EclipseLink (JTA, optimistic locking) |
| App Server | Oracle WebLogic 12.x |

---

## 2. The Five-Layer Architecture

```
┌─────────────────────────────────────────────────────┐
│  LAYER 1 – Quartz Scheduler                         │
│  VendHQSalesToFusionInvRecJob.java                  │
│  • Fires on schedule (automatic) or on demand       │
│  • Sets integration status to RUNNING / IDLE        │
└──────────────────────┬──────────────────────────────┘
                       │ triggers
                       ▼
┌─────────────────────────────────────────────────────┐
│  LAYER 2 – Integration Engine                       │
│  VendHQSalesToFusionInvRecIntBackup.java  ← CURRENT │
│  VendHQSalesToFusionInvRecIntParallel.java ← FASTER │
│  • Loops day-by-day (max 7 days per run)            │
│  • Loops outlet-by-outlet                           │
│  • Loops sale-by-sale (sequential SOAP calls)       │
└──────┬────────────────────────┬───────────────────┘
       │ SOAP clients           │ REST clients
       ▼                        ▼
┌──────────────┐      ┌──────────────────────────────┐
│  LAYER 3a –  │      │  LAYER 3b –                  │
│  SOAP Clients│      │  REST Clients                │
│  FusionInvoice│     │  FusionInvTxnService.java    │
│  FusionReceipt│     │  OkHttpClient 3.x            │
│  FusionJournal│     │  (inventory is already       │
│  (JAX-WS)    │      │   batched here ✓)            │
└──────┬───────┘      └──────────────┬───────────────┘
       │                             │
       ▼                             ▼
┌─────────────────────────────────────────────────────┐
│  LAYER 4 – Oracle Fusion ERP                        │
│  • createSimpleInvoice                              │
│  • createStandardReceipt / createMiscReceipt        │
│  • importJournal                                    │
│  • insertInvTransactions                            │
└─────────────────────────────────────────────────────┘
       │ JPA merge / persist
       ▼
┌─────────────────────────────────────────────────────┐
│  LAYER 5 – Integration Database (Oracle DB)         │
│  SessionEJBBean.java – EclipseLink JPA              │
│  • FusionInvoiceHeader / FusionInvoiceLine          │
│  • FusionStandardReceipt / FusionMiscReceipt        │
│  • FusionApplyReceipt                               │
│  • FusionJournalHeader / FusionJournalLine          │
│  • FusionInvTxn                                     │
└─────────────────────────────────────────────────────┘
```

---

## 3. Step-by-Step Data Push Flow

Here is the exact execution path inside `VendHQSalesToFusionInvRecIntBackup.doIntegration()`:

### Step 1 – Initialise
```
1. Get SessionEJB (remote EJB lookup via JNDI)
2. Generate a unique RequestID for this run
3. Load outlets for the target region from the DB
4. Calculate how many days to process (max 7)
```

### Step 2 – Date Loop (outer, up to 7 iterations)
```
For each day from lastSaleDate to today:
   ├── Set processDate
   └── Enter Outlet Loop (Step 3)
```

### Step 3 – Outlet Loop (middle)
```
For each outlet in the region:
   ├── Check outlet integration mode (NONE / MANUAL / AUTOMATIC)
   │   └── Skip outlet if mode doesn't match the run type
   ├── Load sales from BackupVendhqSales table for this outlet+date
   ├── Load SalesMetaData staging table
   └── Enter Sale Transformation Loop (Step 4)
```

### Step 4 – Sale Transformation Loop
```
For each BackupVendhqSales record:
   └── invRecTransformation.addInvoiceMapping(sale, salesMetaDataMap)
       ├── Group sale lines into invoice headers
       ├── Map fields: customer, account, tax code, currency, lines
       └── Prepare inventory transaction lines
```

### Step 5 – Inventory Push (batched ✓)
```
For each inventory transaction group:
   └── FusionInvTxnService.insertInvTransactions(invTxnLines)
       ├── REST POST to Oracle Fusion Inventory API
       ├── On success: invPersistence.syncInvTxn(result) → DB merge
       └── On failure: log error, set intError = true
```

### Step 6 – Invoice Push (sequential ✗ – bottleneck)
```
For each InvoiceHeader:
   └── new FusionInvoiceClient(params, cred).saveInvoice(invoice)
       ├── Creates a NEW SOAP client on every call
       ├── Opens NEW HTTP connection on every call
       ├── SOAP: createSimpleInvoice(invoiceModel) → Oracle Fusion
       ├── On success:
       │   ├── invRecTransformation.addReceiptMapping(invoice, result)
       │   ├── invRecTransformation.addJournalEntry(invoice, result)
       │   └── salesPersistence.syncInvoice(...) → DB merge
       └── On failure: email alert, set intError = true, break loop
```

### Step 7 – Receipt Push (sequential ✗ – bottleneck)
```
For each receipt group (per payment type per invoice):
   ├── FusionReceiptClient.createStandardReceipt(request)
   ├── FusionReceiptClient.createMiscReceipt(request)
   └── FusionReceiptClient.applyReceipt(request)
   Each call: new HTTP connection + new SOAP client
```

### Step 8 – Journal Push (sequential ✗ – bottleneck)
```
For each journal header:
   └── FusionJournalClient.createJournal(journalHeader)
       Each call: new HTTP connection + new SOAP client
```

---

## 4. Why the Current Code Is Slow

The following issues were identified in the source code and are the root causes of slow performance:

### #1 – One SOAP Call Per Record (Critical)
**Location:** `VendHQSalesToFusionInvRecIntBackup.java` lines 194, 226, 328

Each invoice, receipt, and journal entry is sent to Oracle Fusion in a **separate SOAP call**. If you have 200 sales in a day across 5 outlets, this generates:

```
200 invoice calls
+ 200 standard receipt calls
+ 200 misc receipt calls
+ 200 apply receipt calls
+ 200 journal calls
= 1,000 individual SOAP calls
```

At 3–5 seconds per call, that is **50–80 minutes for 200 sales**.

---

### #2 – New SOAP Client Created on Every Call
**Location:** `VendHQSalesToFusionInvRecIntBackup.java` line 194

```java
// A brand new client (and new HTTP connection) is created for EVERY invoice
invoiceResult = new FusionInvoiceClient(fusionParams, fusionCredential).saveInvoice(invoice);
```

HTTP connections should be reused (connection pooling). Creating a new one each time adds overhead.

---

### #3 – No Parallel Processing for Invoices/Receipts/Journals
**Location:** `VendHQSalesToFusionInvRecIntBackup.java`

The `Parallel` version (`VendHQSalesToFusionInvRecIntParallel.java`) exists but is **not the default**. The `Backup` (sequential) version is used by the scheduler job.

---

### #4 – Processing Stops on First Error
**Location:** `VendHQSalesToFusionInvRecIntBackup.java` catch blocks

```java
} catch(Exception e) {
    new ExceptionAlerter(region).sendException(e);
    intError = true;
    break;  // ← Stops ALL remaining outlets/dates
}
```

One failure aborts the entire run instead of skipping the failed record and continuing.

---

### #5 – Maximum 7-Day Window Per Run
**Location:** `VendHQSalesToFusionInvRecIntBackup.java` line 99

```java
Integer finalDaysAddition = daysToAdd <= 7 ? daysToAdd - 1 : 7; // MAX 7 DAYS
```

Initial migrations with months of historical data require many scheduler runs.

---

### #6 – No Connection Timeout
**Location:** `RESTUtils.java`

`OkHttpClient` is created without timeouts, risking indefinitely hung connections.

---

## 5. Can You Do This Migration Using APIs?

**Yes — absolutely.** Oracle Fusion provides both REST and SOAP APIs specifically designed for bulk data migration. The recommended approach depends on the volume:

| Volume | Recommended API |
|--------|----------------|
| < 500 records | Current SOAP calls (with parallelism) |
| 500 – 50,000 records | Oracle Fusion REST Bulk APIs |
| > 50,000 records | Oracle Fusion FBDI (File-Based Data Import) |

### Current SOAP vs REST vs FBDI Summary

| Feature | Current SOAP | Oracle REST API | Oracle FBDI |
|---------|-------------|-----------------|-------------|
| Batch size | 1 per call | 1 per call (but async) | Thousands per file |
| Parallelism | Requires code change | Built-in async | Background import |
| Setup | Already done | Minimal | Requires templates |
| Speed | Slowest | Medium | Fastest |
| Error handling | Stops on first | Per-record status | Report after all |
| Best for | < 100 records/day | Daily sync | Historical migration |

---

## 6. Recommended API-Based Migration Approach

### Approach A – Parallelise Existing SOAP Calls (Easiest, No Code Change)

Switch the scheduler job to use `VendHQSalesToFusionInvRecIntParallel` instead of `VendHQSalesToFusionInvRecIntBackup`. This class already uses `ExecutorService.newFixedThreadPool` and is present in the codebase. This alone can achieve **4× speedup** with the existing 4-thread pool.

**Change required:** In `VendHQSalesToFusionInvRecJob.java`, replace the one line that instantiates `VendHQSalesToFusionInvRecIntBackup` with `VendHQSalesToFusionInvRecIntParallel`.

---

### Approach B – Oracle Fusion REST API (Recommended for Daily Sync)

Oracle Fusion exposes REST endpoints under:

```
https://{hostname}.fa.{region}.oraclecloud.com/fscmRestApi/resources/11.13.18.05/
```

**For Invoices:**
```
POST /receivablesInvoices
Content-Type: application/json
Authorization: Basic {base64(user:pass)}

{
  "TransactionSource": "VendHQ",
  "TransactionType": "INV",
  "BillToCustomerNumber": "CUST001",
  "TransactionDate": "2024-01-15",
  "invoiceLines": [
    {
      "LineType": "LINE",
      "Quantity": 2,
      "UnitPrice": 150.00,
      "Description": "Product A"
    }
  ]
}
```

**For Receipts:**
```
POST /receivablesReceipts
```

**For Inventory Transactions** (already done in `FusionInvTxnService.java`):
```
POST /inventoryTransactions
```

**Advantages over current SOAP:**
- Lighter payload (JSON vs XML)
- Easier to batch (array of records in one POST for some endpoints)
- Better error messages in response
- Can be called from any HTTP client (Postman, curl, Python, etc.)

---

### Approach C – Oracle FBDI (File-Based Data Import) for Historical Migration

FBDI is Oracle's **fastest migration path** for large volumes. The process:

```
Step 1: Prepare data in Oracle-provided Excel/CSV template
         └── Download template from: Oracle Support Doc ID 1937727.1

Step 2: Convert template to .zip file

Step 3: Upload via UCM (Universal Content Management):
         POST https://{hostname}.fa.{region}.oraclecloud.com/fscmService/
              ImportBulkDataService?WSDL

Step 4: Submit import job via SOAP or REST:
         POST /erpintegrations  (REST)
         OR
         SOAP: EssJobService.submitESSJobRequest()
         └── Job name: /oracle/apps/ess/financials/receivables/transactions/
                       import/ImportAutoInvoice

Step 5: Monitor job status:
         GET /erpintegrations/{JobId}

Step 6: Check error report in Oracle Fusion UI:
         Receivables → Billing → Create Transactions
```

**FBDI Templates available:**
- `RA_INTERFACE_LINES_ALL.csv` – Invoice lines (AutoInvoice import)
- `AR_CASH_RECEIPTS_ALL.csv` – Receipts
- `GL_INTERFACE.csv` – Journal entries
- `MTL_TRANSACTIONS_INTERFACE.csv` – Inventory transactions

---

### Approach D – Oracle Integration Cloud (OIC) / MuleSoft

If Oracle Integration Cloud is available in the environment, it provides:
- Pre-built Oracle Fusion connectors
- Built-in retry and error handling
- Visual flow mapping (no code)
- Rate limiting and batching built-in

This is the **enterprise-recommended** path for production integrations.

---

## 7. Oracle Fusion REST API Quick Reference

All endpoints are relative to:
```
https://{hostname}.fa.{region}.oraclecloud.com/fscmRestApi/resources/11.13.18.05
```

### Receivables

| Operation | Method | Endpoint |
|-----------|--------|----------|
| Create invoice | POST | `/receivablesInvoices` |
| Get invoice | GET | `/receivablesInvoices/{InvoiceId}` |
| Create receipt | POST | `/receivablesReceipts` |
| Apply receipt | POST | `/receivablesReceipts/{ReceiptId}/action/applyReceipt` |
| Get customer | GET | `/customers?q=CustomerNumber={num}` |

### General Ledger

| Operation | Method | Endpoint |
|-----------|--------|----------|
| Import journal | POST | `/journalEntries` |
| Get journal | GET | `/journalEntries/{JournalId}` |

### Inventory

| Operation | Method | Endpoint |
|-----------|--------|----------|
| Create inventory transaction | POST | `/inventoryTransactions` |
| Get on-hand quantity | GET | `/onHandQuantities?q=ItemNumber={item};OrgCode={org}` |

### ERP Integration (FBDI / Bulk)

| Operation | Method | Endpoint |
|-----------|--------|----------|
| Upload file to UCM | POST | `/fscmService/EssJobService` (SOAP) |
| Submit bulk import job | POST | `/erpintegrations` |
| Check job status | GET | `/erpintegrations/{JobInstanceId}` |

### Authentication

All Oracle Fusion REST and SOAP APIs use **HTTP Basic Authentication**:
```
Authorization: Basic {base64(username:password)}
```

The same credentials already stored in `FusionAppParams` / `Credential` objects work for REST calls.

---

## 8. Performance Comparison: Current vs API-Based

Estimated timing for **1,000 sales transactions**:

| Approach | Estimated Time | Notes |
|----------|---------------|-------|
| Current sequential SOAP | 80–150 min | 1 call/record × 5–9 sec/call |
| Parallel SOAP (4 threads) | 20–40 min | Already coded, just not used |
| Parallel SOAP (16 threads) | 5–15 min | Increase thread pool size |
| REST API (JSON, parallel) | 3–8 min | Lighter payload, connection reuse |
| FBDI bulk import | 2–5 min | Single file upload + background job |
| Oracle Integration Cloud | 1–3 min | Purpose-built connector |

---

## 9. Migration Checklist

Use this checklist to plan the migration from the current sequential approach to a faster API-based approach:

### Phase 1 – Quick Win (No Code Change)
- [ ] Enable `VendHQSalesToFusionInvRecIntParallel` in the job scheduler
- [ ] Verify the 4-thread pool (`BackgroundTaskExecutor`) handles concurrent outlet processing
- [ ] Monitor for race conditions when multiple outlets write to DB simultaneously

### Phase 2 – REST API Migration
- [ ] Confirm Oracle Fusion REST API version in use (`11.13.18.05` or newer)
- [ ] Test REST endpoints for `/receivablesInvoices` and `/receivablesReceipts` via Postman
  - Use existing `Fusion_Endpoints_Postman_Collection.json` as a starting point
- [ ] Replace `FusionInvoiceClient` (SOAP) with a REST-based client in `FusionRESTClient`
- [ ] Reuse a single `OkHttpClient` instance (connection pooling) across all calls
- [ ] Add connection timeouts: `connectTimeout(30, SECONDS)`, `readTimeout(60, SECONDS)`
- [ ] Add retry logic (3 retries with exponential backoff) for transient failures

### Phase 3 – FBDI Bulk Migration (Historical Data)
- [ ] Download FBDI templates from Oracle Support (Doc ID 1937727.1)
- [ ] Export historical VendHQ sales data to CSV in AutoInvoice format
- [ ] Test import in Oracle Fusion sandbox environment
- [ ] Upload via UCM and submit `ImportAutoInvoice` ESS job
- [ ] Validate results in Oracle Fusion Receivables workbench
- [ ] Reconcile totals between VendHQ and Oracle Fusion

### Phase 4 – Production Validation
- [ ] Run parallel (SOAP or REST) migration in parallel with old code on a test date
- [ ] Compare record counts and amounts
- [ ] Switch production to new approach
- [ ] Monitor error rates and processing times

---

## Summary

| Question | Answer |
|----------|--------|
| How is data pushed to Oracle? | Sequential SOAP calls (one per invoice/receipt/journal), REST for inventory |
| Why is it slow? | New HTTP connection + new SOAP client created per record, no batching, no parallelism |
| Can you use APIs instead? | Yes – Oracle Fusion REST API and FBDI both support this migration |
| Easiest fix (no code)? | Enable the existing Parallel integration class in the scheduler |
| Fastest bulk migration? | FBDI file-based import (upload CSV, submit background job) |
| Best long-term approach? | Oracle Integration Cloud or REST API with connection pooling + parallel threads |
