# integration-Oracle

A production-grade **Enterprise Integration Platform** built on Oracle ADF 12.x that synchronises data between **Oracle Fusion ERP**, **VendHQ POS**, and **Opencart E-commerce** through a layered middleware architecture.

---

## Table of Contents

1. [Architecture Overview](#architecture-overview)
2. [Technology Stack](#technology-stack)
3. [Project Structure](#project-structure)
4. [Middleware Layer – SharedResources](#middleware-layer--sharedresources)
   - [BackgroundTaskExecutor](#1-backgroundtaskexecutor)
   - [ExecutionListener](#2-executionlistener)
   - [Constants](#3-constants)
   - [Credential](#4-credential)
   - [RESTUtils](#5-restutils)
   - [SOAPUtils](#6-soaputils)
   - [FusionAppDomain](#7-fusionappdomain)
   - [FusionAppParams](#8-fusionappparams)
5. [Scheduler Layer – VendHQIntegrationScheduler](#scheduler-layer--vendhqintegrationscheduler)
6. [Integration Processing Layer](#integration-processing-layer)
7. [Data Flow: End-to-End Example](#data-flow-end-to-end-example)
8. [Database Layer](#database-layer)
9. [Error Handling and Notifications](#error-handling-and-notifications)
10. [Configuration](#configuration)

---

## Architecture Overview

```
┌──────────────────────────────────────────┐
│           Oracle ADF UI (JSF)            │  ← IntegrationSchedulerBean
└────────────────────┬─────────────────────┘
                     │ start / stop / manual trigger
                     ▼
┌──────────────────────────────────────────┐
│         Quartz Scheduler (4 jobs)        │  ← VendHQIntegrationScheduler
└────────────────────┬─────────────────────┘
                     │ fires job
                     ▼
┌──────────────────────────────────────────┐
│       BackgroundTaskExecutor             │  ← 4-thread fixed pool
│       (SharedResources middleware)       │
└────────────────────┬─────────────────────┘
                     │ submits Runnable
                     ▼
┌──────────────────────────────────────────┐
│       Integration Processors             │
│  ├─ FusionItemsToVendHQItemsIntegration  │
│  ├─ VendHQSalesToFusionInvRecIntParallel │
│  ├─ FusionInvToVendHQInvIntegration      │
│  └─ FusionOnHandQtyFetch                 │
└────────┬──────────────────┬──────────────┘
         │ REST calls        │ SOAP calls
         ▼                   ▼
┌──────────────┐   ┌──────────────────────┐
│ REST Clients │   │ SOAP Clients         │
│ ├─ VendHQ    │   │ ├─ InvoiceService    │
│ ├─ Opencart  │   │ ├─ ReceiptService    │
│ └─ FusionREST│   │ ├─ JournalService    │
└──────┬───────┘   │ └─ ItemService       │
       │           └────────┬─────────────┘
       │                    │
       ▼                    ▼
┌──────────────┐   ┌──────────────────────┐
│  VendHQ POS  │   │  Oracle Fusion ERP   │
│  API         │   │  (REST + SOAP)       │
└──────────────┘   └──────────────────────┘
       │
       ▼
┌──────────────────────────────────────────┐
│  Oracle Database (JPA / EJB)             │
│  ├─ Integration status tracking          │
│  ├─ Sync metadata                        │
│  └─ Backup tables                        │
└──────────────────────────────────────────┘
```

---

## Technology Stack

| Component | Technology |
|-----------|-----------|
| UI Framework | Oracle ADF 12.x (JSF / ADF Faces) |
| Scheduler | Quartz 2.x |
| Persistence | JPA 2.1 + EJB 3.x (Stateless Session Bean) |
| SOAP / Web Services | JAX-WS (auto-generated from Fusion WSDL) |
| HTTP Client | OkHttpClient 3.x |
| JSON | Gson |
| Application Server | Oracle WebLogic Server 12.x |
| Database | Oracle Database |
| Language | Java SE 8+ |

---

## Project Structure

```
integration-Oracle/
├── SharedResources/          # Core middleware utilities (REST, SOAP, async)
├── IntegrationJobs/          # Quartz jobs, processors, email alerts, UI bean
├── JPAProject/               # JPA entities + EJB session bean
├── FusionRESTClient/         # Oracle Fusion REST API clients
├── FusionSOAPClient/         # Oracle Fusion SOAP/JAX-WS generated stubs
├── VendHQRESTClient/         # VendHQ POS REST API clients
├── OpencartRESTClient/       # Opencart e-commerce REST API clients
├── ViewController/           # Oracle ADF UI pages (JSF / JSPX)
├── Model/                    # Oracle ADF BC4J model components
├── EJBClient/                # EJB JNDI lookup utilities
├── ServletClient/            # Servlet wrapper
├── Conf/                     # Application configuration files
├── resources/                # Application resource files
└── resourcebundles/          # i18n / localisation message bundles
```

---

## Middleware Layer – SharedResources

The `SharedResources` module (package `innovate.tamergroup.shared.utils`) is the foundation of the integration platform.  It provides the building blocks used by every other module.

### 1. BackgroundTaskExecutor

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/BackgroundTaskExecutor.java`

A **Singleton** thread-pool manager that runs integration tasks asynchronously, preventing long-running jobs from blocking the UI thread.

#### How it works – step by step

1. **Obtain the singleton**  
   Call `BackgroundTaskExecutor.getInstance()`.  The method is `synchronized` so only one instance is ever created, even under concurrent access.

2. **Prepare the task**  
   Create a `Runnable` containing the integration logic (e.g. an instance of `VendHQSalesToFusionInvRecIntParallel`).

3. **Implement the completion callback (optional)**  
   Implement the `ExecutionListener` interface to be notified when the task finishes (e.g. to update a UI progress indicator).

4. **Submit the task**  
   Call `executor.execute(myRunnable, myListener)`.  Internally this calls `ExecutorService.submit()` which places the task in the 4-thread fixed pool.

5. **Completion detection**  
   `completionDetector()` calls `Future.get()` which blocks until the task finishes, then fires `ExecutionListener.onExecutionComplete()`.

6. **Error handling**  
   If the task throws an exception, `ExecutionException` is caught and logged to standard output.

```java
// Example usage
BackgroundTaskExecutor executor = BackgroundTaskExecutor.getInstance();
executor.execute(
    () -> { /* integration logic here */ },
    () -> System.out.println("Task completed!")
);
```

---

### 2. ExecutionListener

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/ExecutionListener.java`

A **callback interface** with a single method, fired by `BackgroundTaskExecutor` when a background task completes successfully.

#### Step-by-step usage

1. Implement the interface in your controller or scheduler class.
2. Provide the body of `onExecutionComplete()` – typically update a status field or refresh the UI.
3. Pass the implementation as the second argument to `BackgroundTaskExecutor.execute()`.

```java
ExecutionListener listener = () -> {
    schedulerBean.setStatus(Constants.IDLE);
};
BackgroundTaskExecutor.getInstance().execute(integrationTask, listener);
```

---

### 3. Constants

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/Constants.java`

Centralises all string literals used across the integration platform.

| Constant | Value | Purpose |
|----------|-------|---------|
| `RUNNING` | `"RUNNING"` | Job is actively executing |
| `IDLE` | `"IDLE"` | No job is executing |
| `AUTOMATIC` | `"AUTOMATIC"` | Scheduler triggered by Quartz cron |
| `MANUAL` | `"MANUAL"` | Scheduler triggered by user via UI |
| `NONE` | `"NONE"` | Scheduler not yet started |

#### Step-by-step usage

1. Import the class: `import innovate.tamergroup.shared.utils.Constants;`
2. Use constants instead of string literals:  
   ```java
   if (status.equals(Constants.RUNNING)) { ... }
   sessionBean.setIntegrationMode(Constants.AUTOMATIC);
   ```

---

### 4. Credential

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/Credential.java`

Encapsulates API authentication credentials and produces the encoded string needed for HTTP `Authorization` headers.

#### Two credential modes

| Mode | Constructor | `toString()` output |
|------|-------------|---------------------|
| Basic Auth | `new Credential(username, password)` | Base64-encoded `"username:password"` |
| Token / Bearer | `new Credential(token)` | Raw token string |

#### Step-by-step usage (Basic Auth for Oracle Fusion)

1. Load credentials from the database:
   ```java
   FusionCredentials dbCreds = session.getFusionCredential();
   Credential cred = new Credential(dbCreds.getUsername(), dbCreds.getPassword());
   ```
2. For REST calls, add to the request header:
   ```java
   request.addHeader("Authorization", "Basic " + cred.toString());
   ```
3. For SOAP calls, pass to `SOAPUtils.setCredentials()`:
   ```java
   SOAPUtils.setCredentials((BindingProvider) servicePort, cred);
   ```

#### Step-by-step usage (Token Auth for VendHQ)

1. Load the VendHQ API key from the database:
   ```java
   VendhqCredentials vCreds = session.getVendHQCredential();
   Credential cred = new Credential(vCreds.getApiToken());
   ```
2. Add to the REST request header:
   ```java
   request.addHeader("Authorization", "Bearer " + cred.toString());
   ```

---

### 5. RESTUtils

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/RESTUtils.java`

Provides utility methods for configuring the `OkHttpClient` used by all REST API modules.

> ⚠ **Warning:** `configureToIgnoreCertificate()` disables TLS certificate and hostname validation.  Use it **only** in test / sandbox environments, never in production.

#### Step-by-step usage

1. Create an `OkHttpClient.Builder`:
   ```java
   OkHttpClient.Builder builder = new OkHttpClient.Builder();
   ```
2. In test environments, apply the ignore-certificate configuration:
   ```java
   builder = RESTUtils.configureToIgnoreCertificate(builder);
   ```
3. Add other settings (timeouts, interceptors):
   ```java
   builder.connectTimeout(30, TimeUnit.SECONDS);
   ```
4. Build the client:
   ```java
   OkHttpClient client = builder.build();
   ```
5. Use the client for all HTTP calls in that module.

#### How `configureToIgnoreCertificate` works internally

1. Creates an `X509TrustManager` whose `checkClientTrusted` and `checkServerTrusted` methods are intentionally empty (accept all certificates).
2. Initialises an `SSLContext` with that trust manager and extracts its `SSLSocketFactory`.
3. Installs the factory on the builder via `builder.sslSocketFactory()`.
4. Sets a `HostnameVerifier` that always returns `true` (accepts any hostname).
5. Returns the modified builder.

---

### 6. SOAPUtils

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/SOAPUtils.java`

Configures Oracle Fusion JAX-WS port stubs with Basic Authentication credentials.

#### Step-by-step usage

1. Obtain or generate the JAX-WS port stub for the target Fusion service.
2. Create a `Credential` with the Fusion username and password:
   ```java
   Credential cred = new Credential(username, password);
   ```
3. Cast the stub to `BindingProvider` and call `setCredentials`:
   ```java
   SOAPUtils.setCredentials((BindingProvider) invoiceServicePort, cred);
   ```
4. JAX-WS will now attach the credentials as HTTP Basic Authentication headers on every subsequent SOAP call made through that port.
5. Invoke the desired SOAP operation:
   ```java
   invoiceServicePort.createInvoice(...);
   ```

---

### 7. FusionAppDomain

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/FusionAppDomain.java`

An enum that maps Oracle Fusion functional areas to their REST URL path segments.

| Constant | Path segment | Used for |
|----------|-------------|---------|
| `SCM` | `"scm"` | Supply Chain / Inventory REST APIs |
| `FIN` | `"fin"` | Financials / AR REST APIs |

#### Step-by-step usage

1. Select the enum value matching the target functional area:
   ```java
   FusionAppDomain domain = FusionAppDomain.FIN;
   ```
2. Retrieve the path segment and embed it in the URL:
   ```java
   String baseUrl = "https://" + hostname + "/" + domain.getAppDomain() + "/restApi/version/...";
   ```

---

### 8. FusionAppParams

**File:** `SharedResources/src/innovate/tamergroup/shared/utils/FusionAppParams.java`

Holds the Oracle Fusion Cloud connection parameters (hostname and region/server code) loaded from the database.

#### Step-by-step usage

1. Read the values from the `FusionCredentials` JPA entity:
   ```java
   FusionCredentials dbCreds = session.getFusionCredential();
   FusionAppParams params = new FusionAppParams(
       dbCreds.getHostName(),   // e.g. "ehxk-test"
       dbCreds.getServer()      // e.g. "fa"
   );
   ```
2. Pass `params` to the REST or SOAP client that needs to build the target URL.
3. The client constructs the full URL:
   ```java
   String url = "https://" + params.getHostname() + params.getRegion() + ".oraclecloud.com";
   ```

---

## Scheduler Layer – VendHQIntegrationScheduler

**File:** `IntegrationJobs/src/innovate/tamergroup/vendhq/jobs/VendHQIntegrationScheduler.java`

Orchestrates all four Quartz integration jobs.

#### Step-by-step initialisation

1. The constructor calls `prepareSchedule()` which:
   a. Looks up the EJB session bean via JNDI.
   b. Reads `FusionCredentials` from the database.
   c. Builds four `JobDetail` instances, each with Fusion credentials injected as `JobDataMap` entries.
   d. Builds four `Trigger` instances with their respective cron expressions.
   e. Creates a `StdSchedulerFactory` Quartz scheduler.

2. Scheduled jobs and their triggers:

| Job | Trigger | Schedule |
|-----|---------|----------|
| `FusionItemsToVendHQItemsJob` | `CronTrigger` | Every 6 hours (`0 0 0/6 1/1 * ? *`) |
| `VendHQSalesToFusionInvRecJob` | `CronTrigger` | Daily at 03:00 (`0 0 3 1/1 * ? *`) |
| `VendHQSalesBackupJob` | `SimpleTrigger` | Every 10 minutes |
| `FusionOnHandQtyJob` | `SimpleTrigger` | Every 4 hours (currently commented out) |

3. To start the scheduler, call `start()` (invoked from the ADF UI bean).
4. To stop the scheduler, call `shutdown()`.

---

## Integration Processing Layer

Each integration class follows the same pattern:

1. **Fetch** data from the source system (VendHQ REST or Fusion REST/SOAP).
2. **Transform** the data using a mapping class (e.g. `FusionInvoiceMapping`).
3. **Persist** the transformed data to the target system (Fusion SOAP or VendHQ REST).
4. **Track** the result in the Oracle Database via the EJB session bean.
5. **Alert** on failure via `ExceptionAlerter` / `SendEmailNotification`.

### Core processors

| Class | Direction | Description |
|-------|-----------|-------------|
| `VendHQSalesToFusionInvRecIntParallel` | VendHQ → Fusion | Parallel processing of POS sales into Fusion Invoices, Receipts, and Journals |
| `FusionItemsToVendHQItemsIntegration` | Fusion → VendHQ | Syncs product catalogue from Fusion SCM to VendHQ |
| `FusionInvToVendHQInvIntegration` | Fusion → VendHQ | Syncs inventory quantities from Fusion to VendHQ outlets |
| `FusionOnHandQtyFetch` | Fusion → DB | Fetches on-hand quantities from Fusion and stores locally |

---

## Data Flow: End-to-End Example

### VendHQ Sales → Oracle Fusion (nightly at 03:00)

```
1. Quartz fires VendHQSalesToFusionInvRecJob at 03:00
   │
2. Job calls BackgroundTaskExecutor.execute(integrationTask, listener)
   │
3. Worker thread runs VendHQSalesToFusionInvRecIntParallel.integrate()
   │
4. Fetch pending VendHQ sales via REST API
   │   GET https://api.vendhq.com/api/2.0/sales?...
   │   Headers: Authorization: Bearer <token>
   │
5. For each outlet – in parallel (ExecutorService):
   │
   ├─ 5a. Transform sale to Fusion Invoice model (FusionInvoiceMapping)
   │
   ├─ 5b. Create Fusion Invoice (SOAP InvoiceService)
   │       SOAPUtils.setCredentials(port, cred)
   │       port.createInvoice(invoicePayload)
   │
   ├─ 5c. Create Fusion Receipt (SOAP ReceiptService)
   │       port.applyReceipt(receiptPayload)
   │
   ├─ 5d. Post Journal Entry (SOAP JournalService)
   │       port.createJournal(journalPayload)
   │
   └─ 5e. Mark sale as integrated in Oracle DB
           sessionEJB.updateSalesStatus(saleId, Constants.IDLE)
   │
6. ExecutionListener.onExecutionComplete() fires
   │
7. UI progress indicator is updated
```

---

## Database Layer

The `JPAProject` module exposes all database operations through a single **Stateless EJB**:

- **`SessionEJBBean`** – provides CRUD operations for all JPA entities.
- **`SessionEJB`** – remote interface.
- **`SessionEJBLocal`** – local interface.

Key entity groups:

| Group | Entities | Purpose |
|-------|----------|---------|
| Fusion | `FusionInvoiceHeader`, `FusionInvoiceLine`, `FusionJournalHeader`, `FusionMiscReceipt`, `FusionCredentials`, … | Store Fusion integration data and credentials |
| VendHQ | `VendhqCredentials`, `VendhqOutletsDB`, `VendhqItemMeta`, … | Store VendHQ configuration and metadata |
| Tracking | `SalesIntegrationStatus`, `OutletsIntegrationConfig`, … | Track sync status per outlet |
| Backup | `BackupVendhqSales`, `BackupVendhqLineItems`, `BackupVendhqPayments`, … | Backup copies of raw VendHQ data |

---

## Error Handling and Notifications

| Class | Location | Purpose |
|-------|----------|---------|
| `ExceptionAlerter` | `IntegrationJobs` | Catches exceptions during integration and triggers notifications |
| `SendEmailNotification` | `IntegrationJobs` | Sends email alerts to configured recipients on failure |
| `LoggerHelper` | `IntegrationJobs` | Wraps `java.util.logging.Logger` with consistent formatting |

Recipients for email alerts are stored in the `NotificationEmailRecipients` JPA entity and managed via the database.

---

## Configuration

Connection parameters are stored in the Oracle Database and loaded at runtime via JPA entities:

| Entity | Stored in | Contains |
|--------|-----------|----------|
| `FusionCredentials` | Oracle DB | Fusion hostname, server/region, username, password |
| `VendhqCredentials` | Oracle DB | VendHQ API base URL and API token |
| `OutletsIntegrationConfig` | Oracle DB | Per-outlet integration settings (enabled/disabled, cron expressions) |

To change a connection parameter:
1. Update the corresponding row in the Oracle Database.
2. Restart the Quartz scheduler via the ADF UI (Stop → Start) so the new values are reloaded.
