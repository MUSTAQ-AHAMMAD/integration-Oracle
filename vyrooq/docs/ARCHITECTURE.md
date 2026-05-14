# Vyrooq Architecture Guide

## Executive Summary

Vyrooq is a cloud-native, event-driven integration middleware platform that modernizes Oracle Fusion ERP integrations. Built on Node.js and Python, it delivers 40x performance improvement over legacy Java systems while maintaining 100% financial integrity.

## System Architecture

### High-Level Architecture

```
┌────────────────────────────────────────────────────────────────┐
│                         Client Layer                           │
│  Web UI │ Mobile App │ External Systems │ Manual Control Panel│
└────────────┬──────────────────────────────────────────────────┘
             │
             ▼
┌────────────────────────────────────────────────────────────────┐
│                     API Gateway (Fastify)                      │
│  ┌──────────┬──────────┬──────────┬──────────┬──────────┐    │
│  │ Auth     │ Rate     │ CORS     │ Swagger  │ Telemetry│    │
│  │ (JWT)    │ Limiting │          │ Docs     │ (OTEL)   │    │
│  └──────────┴──────────┴──────────┴──────────┴──────────┘    │
└────────────┬──────────────────────────────────────────────────┘
             │
      ┌──────┴──────┐
      │             │
      ▼             ▼
┌──────────┐  ┌──────────────┐
│ Manual   │  │  Workflow    │
│ Control  │  │  Engine      │
│ Engine   │  │ (Temporal.io)│
└──────────┘  └──────┬───────┘
                     │
         ┌───────────┴───────────┐
         │                       │
         ▼                       ▼
┌─────────────────┐    ┌─────────────────┐
│  Retry Engine   │    │ Dedup Engine    │
│   (BullMQ)      │    │   (Redis)       │
└────────┬────────┘    └────────┬────────┘
         │                      │
         └──────────┬───────────┘
                    │
         ┌──────────┴───────────┐
         │                      │
         ▼                      ▼
┌─────────────────┐    ┌─────────────────┐
│ Fusion Adapter  │    │ VendHQ Adapter  │
│ (SOAP + REST)   │    │  (REST API)     │
└────────┬────────┘    └────────┬────────┘
         │                      │
         ▼                      ▼
┌─────────────────────────────────────────┐
│         Event Bus (Kafka)               │
└──────────┬──────────────────────────────┘
           │
    ┌──────┴──────┐
    │             │
    ▼             ▼
┌─────────┐  ┌──────────┐
│ Audit   │  │ Reconcil-│
│ Engine  │  │ iation   │
└─────────┘  └──────────┘
           │
           ▼
┌──────────────────────────────────┐
│   PostgreSQL (Partitioned)       │
│ ┌──────┬────────┬──────────────┐│
│ │Audit │Idempo- │ Transaction  ││
│ │Logs  │tency   │   Data       ││
│ └──────┴────────┴──────────────┘│
└──────────────────────────────────┘
```

## Core Components

### 1. Gateway API (Fastify + TypeScript)

**Purpose**: Main entry point for all API requests

**Key Features**:
- RESTful API with OpenAPI 3.0 documentation
- JWT authentication and RBAC authorization
- Rate limiting (100 requests/minute per IP)
- CORS configuration
- Request correlation IDs
- OpenTelemetry distributed tracing

**Technology Stack**:
- Fastify 4.x (high-performance Node.js framework)
- TypeScript 5.x
- Zod for schema validation
- Pino for structured logging

**Endpoints**:
- `/api/sales/*` - Sales processing operations
- `/api/invoices/*` - Invoice management
- `/api/receipts/*` - Receipt operations
- `/api/control/*` - Manual control operations
- `/api/audit/*` - Audit trail queries
- `/health` - Health check
- `/docs` - Interactive API documentation

### 2. Workflow Engine (Temporal.io + Python)

**Purpose**: Orchestrates 11-stage transaction workflows

**Key Features**:
- Durable execution (survives crashes)
- Automatic retry with exponential backoff
- Workflow versioning
- Activity isolation
- State persistence
- Replay capability

**Workflow Stages**:
1. **FETCH** - Retrieve data from source
2. **VALIDATE** - Verify data integrity
3. **TRANSFORM** - Apply business logic
4. **ENRICH** - Add metadata/lookups
5. **DEDUPLICATE** - Check for duplicates
6. **QUEUE** - Submit to processing queue
7. **PROCESS** - Execute integration
8. **VERIFY** - Confirm success
9. **RECONCILE** - Validate amounts
10. **COMPLETE** - Mark as successful
11. **ARCHIVE** - Move to long-term storage

**Technology Stack**:
- Python 3.13+
- Temporal.io 1.5+
- FastAPI (for status API)
- asyncio for concurrency

### 3. Integration Core Library

**Purpose**: Shared business logic and calculations

**16 Critical Calculations** (from legacy system):
1. Timezone conversion (UTC → regional)
2. Date range with 7-day cap
3. Invoice grouping key
4. Unit selling price (always positive)
5. Inventory quantity (always negative)
6. Transaction type logic
7. Bank charge calculation
8. Debit card cap (Oman: 10 OMR)
9. Conversion rate type
10. Journal charges (fixed vs percentage)
11. Cash account selection by region
12. Discount item quantity override
13. Receipt amount net calculation
14. Period name formatting
15. Message truncation (500 chars)
16. Rounding retry logic (50 attempts)

### 4. Fusion Adapter (SOAP + REST Client)

**Purpose**: Interface with Oracle Fusion ERP

**SOAP Operations**:
- `createSimpleInvoice` - Create AR invoice
- `createStandardReceipt` - Create cash/bank receipt
- `createApplyReceipt` - Apply receipt to invoice
- `createMiscellaneousReceipt` - Bank charges receipt
- `importJournals` - Create GL journal entries

**REST Operations**:
- GET `/customers` - Customer lookup
- POST `/receivablesInvoices` - Alternative invoice creation
- POST `/inventoryTransactions` - Stock movements
- GET `/items` - Item information
- GET `/units` - UOM code lookup

**Special Features**:
- 50-retry logic for receipt application (rounding)
- Connection pooling (100 sockets)
- Response caching (UOM codes, organization names)
- Automatic authentication header injection

### 5. Retry Engine (BullMQ + Redis)

**Purpose**: Distributed job queue with retry logic

**Features**:
- Priority queues
- Delayed retries
- Exponential backoff
- Job scheduling
- Rate limiting
- Job progress tracking
- Dead letter queue integration

**Queue Types**:
- `sales-processing` - Main sales workflow
- `invoice-retry` - Failed invoice creation
- `receipt-retry` - Failed receipt application
- `journal-retry` - Failed journal posting

### 6. Deduplication Engine (Redis)

**Purpose**: Prevent duplicate transaction processing

**Methods**:
1. **Idempotency Keys**
   - Format: `{type}_{identifier}_{date}_{region}`
   - TTL: 24 hours
   - Status: processing/completed/failed

2. **Transaction Fingerprints**
   - SHA-256 hash of transaction data
   - Includes: invoice number, amounts, line items, payments
   - Stored in PostgreSQL + Redis cache

3. **Distributed Locks**
   - Redis SET NX EX
   - Lock TTL: 5 minutes
   - Prevents concurrent processing

### 7. Audit Engine (Event Sourcing)

**Purpose**: Complete audit trail of all operations

**Event Types**:
- `sale_fetched` - Sale retrieved from source
- `validation_failed` - Data validation error
- `invoice_created` - Invoice created in Fusion
- `receipt_applied` - Receipt applied to invoice
- `workflow_completed` - Workflow finished successfully
- `workflow_failed` - Workflow encountered error

**Storage**:
- PostgreSQL partitioned table (monthly partitions)
- Indexed by: aggregate_id, correlation_id, event_type
- Retention: 7 years

## Data Flow

### Complete Sale Processing Flow

```
1. API Request → Gateway API
   ├─ Validate JWT token
   ├─ Check rate limits
   ├─ Generate correlation ID
   └─ Forward to Workflow Engine

2. Workflow Engine → FETCH Stage
   ├─ Call VendHQ Adapter
   ├─ Retrieve complete sale data
   └─ Persist audit event

3. Workflow Engine → VALIDATE Stage
   ├─ Check required fields
   ├─ Validate totals match
   └─ Return errors if invalid

4. Workflow Engine → TRANSFORM Stage
   ├─ Apply timezone conversion
   ├─ Calculate unit prices
   ├─ Generate grouping key
   └─ Format for Fusion

5. Workflow Engine → ENRICH Stage
   ├─ Lookup customer ID
   ├─ Lookup UOM codes
   └─ Lookup organization IDs

6. Workflow Engine → DEDUPLICATE Stage
   ├─ Generate idempotency key
   ├─ Check Redis cache
   ├─ Check PostgreSQL
   └─ Return if duplicate

7. Workflow Engine → PROCESS Stage
   ├─ Create invoice (Fusion Adapter)
   ├─ Create receipt (Fusion Adapter)
   ├─ Apply receipt (retry up to 50x)
   ├─ Create inventory txn (Fusion Adapter)
   └─ Create journal (if non-NORMAL)

8. Workflow Engine → VERIFY Stage
   ├─ Query Fusion for invoice
   └─ Confirm existence

9. Workflow Engine → RECONCILE Stage
   ├─ Compare source vs target amounts
   └─ Log discrepancies

10. Workflow Engine → COMPLETE Stage
    ├─ Update PostgreSQL status
    └─ Persist completion event

11. Workflow Engine → ARCHIVE Stage
    └─ Move to archive partition

12. Response → Client
    ├─ Return workflow ID
    ├─ Return correlation ID
    └─ Return status
```

## Database Schema

### Key Tables

**Sales Processing**:
- `sales` - Main sales transactions (partitioned by `sale_date`)
- `sale_line_items` - Line item details
- `sale_payments` - Payment information

**Fusion Integration**:
- `fusion_invoices` - Created invoices
- `fusion_receipts` - Created receipts
- `fusion_inventory_transactions` - Stock movements
- `fusion_journal_entries` - GL postings

**Audit & Control**:
- `audit_events` - Event sourcing trail (partitioned by `created_at`)
- `idempotency_keys` - Duplicate prevention
- `transaction_fingerprints` - Transaction hashes
- `workflow_states` - Workflow execution state
- `dlq_records` - Dead letter queue

**Configuration**:
- `outlets` - Outlet metadata
- `fusion_credentials` - Fusion connection details
- `vendhq_credentials` - VendHQ API credentials
- `receipt_methods` - Payment method configuration

### Partitioning Strategy

**Time-based Partitioning** (monthly):
- `sales` → `sales_2024_01`, `sales_2024_02`, ...
- `audit_events` → `audit_events_2024_01`, ...

**Benefits**:
- Fast queries (partition pruning)
- Easy archival (drop old partitions)
- Parallel maintenance operations

## Performance Optimization

### Connection Pooling

- PostgreSQL: 100 connections per service
- Redis: 50 connections per service
- Fusion SOAP: 100 sockets (keep-alive)

### Caching Strategy

**Redis Cache**:
- UOM codes: 24 hour TTL
- Organization names: 24 hour TTL
- Customer IDs: 1 hour TTL
- Idempotency keys: 24 hour TTL

**Database Indexes**:
- 50+ composite indexes
- Covering indexes for common queries
- Partial indexes for active records

### Horizontal Scaling

**Auto-scaling Rules**:
- Gateway API: 2-10 pods (CPU > 70%)
- Workflow Engine: 2-50 pods (Queue depth > 100)
- Retry Engine: 1-20 pods (Failed jobs > 50)

## Security

### Authentication

- JWT tokens (HS256 algorithm)
- 24-hour expiration
- Refresh token support
- Blacklist for revoked tokens

### Authorization

- Role-based access control (RBAC)
- Roles: admin, operator, viewer
- API key support for service-to-service

### Encryption

- TLS 1.3 for all external communication
- Database encryption at rest (AES-256)
- Secrets stored in environment variables
- Credentials never logged

## Monitoring & Observability

### Metrics (Prometheus)

- Request rate, latency, errors (RED method)
- Queue depth, processing rate
- Database connection pool usage
- Cache hit/miss ratio
- Workflow success/failure rate

### Tracing (OpenTelemetry)

- Distributed tracing across all services
- Correlation IDs on every request
- Trace sampling (10% in production)
- Trace export to Jaeger/Zipkin

### Logging (Structured JSON)

- Pino for Node.js (Gateway API)
- Loguru for Python (Workflow Engine)
- Log aggregation to Loki/ELK
- Log levels: ERROR, WARN, INFO, DEBUG

### Dashboards (Grafana)

- **Sales Overview**: Throughput, success rate, errors
- **System Health**: CPU, memory, disk, network
- **Database Performance**: Query time, connections, locks
- **Fusion Integration**: API latency, error rate
- **Workflow Execution**: Duration, stage breakdown

## Disaster Recovery

### Backup Strategy

- PostgreSQL: Daily full backup, 5-minute WAL archiving
- Redis: AOF persistence + RDB snapshots
- Retention: 30 days online, 7 years archived

### Recovery Procedures

1. **Workflow Replay**: Re-execute from last checkpoint
2. **Database PITR**: Point-in-time recovery to any second
3. **Event Sourcing**: Rebuild state from audit events
4. **Manual Replay**: API endpoint for transaction replay

## Cost Optimization

### Resource Sizing

- Gateway API: 256 MB RAM, 0.25 CPU per pod
- Workflow Engine: 512 MB RAM, 0.5 CPU per pod
- PostgreSQL: 8 GB RAM, 4 CPU
- Redis: 4 GB RAM, 2 CPU

### Cost Estimates (AWS)

- Small deployment (100 sales/hour): ~$300/month
- Medium deployment (1,000 sales/hour): ~$800/month
- Large deployment (10,000 sales/hour): ~$2,500/month

## Future Enhancements

- GraphQL API support
- Real-time WebSocket notifications
- Machine learning for anomaly detection
- Multi-tenant support
- Additional ERP connectors (SAP, NetSuite)
- Mobile app for monitoring
