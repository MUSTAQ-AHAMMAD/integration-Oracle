# Retry Engine

BullMQ-based retry engine with exponential backoff and intelligent rounding retry logic for Vyrooq Integration Platform.

## Features

- ✅ Multiple specialized queues (Invoice, Receipt, Journal, Inventory, VendHQ)
- ✅ Exponential backoff retry strategy
- ✅ Special 50-retry logic for receipt rounding errors (-0.01 adjustment)
- ✅ Dead Letter Queue (DLQ) for permanently failed jobs
- ✅ Configurable concurrency per queue
- ✅ Comprehensive job monitoring and metrics
- ✅ Automatic job cleanup (completed/failed)
- ✅ Health check and readiness endpoints
- ✅ Structured logging with correlation IDs
- ✅ Audit trail integration

## Queues

### Invoice Queue
- **Purpose**: Process invoice creation in Oracle Fusion
- **Concurrency**: 5 workers
- **Max Attempts**: 5
- **Backoff**: Exponential (5s base delay)

### Receipt Queue
- **Purpose**: Process receipt creation and application
- **Concurrency**: 5 workers
- **Max Attempts**: 50 (for rounding retry logic)
- **Backoff**: Exponential (2s base delay)
- **Special Feature**: Automatic -0.01 adjustment on rounding errors

### Journal Queue
- **Purpose**: Process journal entries for bank charges
- **Concurrency**: 3 workers
- **Max Attempts**: 5
- **Backoff**: Exponential (3s base delay)

### Inventory Queue
- **Purpose**: Process inventory transactions
- **Concurrency**: 5 workers
- **Max Attempts**: 5
- **Backoff**: Exponential (4s base delay)

### VendHQ Queue
- **Purpose**: Sync data with VendHQ POS
- **Concurrency**: 3 workers
- **Max Attempts**: 3
- **Backoff**: Exponential (10s base delay)

### Dead Letter Queue (DLQ)
- **Purpose**: Store permanently failed jobs
- **Retention**: Unlimited
- **Manual Review**: Required for recovery

## Setup

1. Install dependencies:
```bash
npm install
```

2. Configure environment:
```bash
cp ../.env.example .env
```

3. Start service:
```bash
npm run dev
```

## Environment Variables

```env
PORT=3200
NODE_ENV=development
REDIS_HOST=localhost
REDIS_PORT=6379
REDIS_PASSWORD=
DATABASE_URL=postgresql://postgres:vyrooq123@localhost:5432/vyrooq

# Queue Concurrency
INVOICE_CONCURRENCY=5
RECEIPT_CONCURRENCY=5
JOURNAL_CONCURRENCY=3
INVENTORY_CONCURRENCY=5
VENDHQ_CONCURRENCY=3

# Retry Configuration
INVOICE_MAX_ATTEMPTS=5
RECEIPT_MAX_ATTEMPTS=50
JOURNAL_MAX_ATTEMPTS=5
INVENTORY_MAX_ATTEMPTS=5
VENDHQ_MAX_ATTEMPTS=3
```

## API Endpoints

### Health Checks
- `GET /health` - Service health status
- `GET /ready` - Service readiness check
- `GET /metrics` - Queue metrics and statistics

## Usage Example

### Add Job to Queue (from another service)

```typescript
import { Queue } from 'bullmq';

const invoiceQueue = new Queue('invoice-processing', {
  connection: { host: 'localhost', port: 6379 }
});

await invoiceQueue.add('create-invoice', {
  saleId: 'SALE-001',
  invoiceData: {
    invoiceNumber: 'INV-001',
    totalAmount: 1000.00,
    // ... invoice details
  },
  correlationId: 'corr-12345'
});
```

### Monitor Queue Status

```bash
curl http://localhost:3200/metrics
```

Response:
```json
{
  "timestamp": "2024-05-13T10:00:00.000Z",
  "queues": {
    "invoice": {
      "waiting": 5,
      "active": 2,
      "completed": 1000,
      "failed": 10,
      "delayed": 0,
      "total": 1017
    },
    "receipt": {
      "waiting": 3,
      "active": 1,
      "completed": 950,
      "failed": 5,
      "delayed": 0,
      "total": 959
    }
  }
}
```

## Rounding Retry Logic

The receipt processor implements special 50-retry logic for Oracle Fusion rounding errors:

1. Attempt 1: Apply receipt with original amount
2. If rounding error occurs: Apply -0.01 adjustment
3. Attempt 2: Apply with amount - 0.01
4. If still fails: Apply -0.01 again (amount - 0.02)
5. Continue up to 50 attempts
6. Each attempt adjusts by -0.01 until receipt applies successfully

This matches the legacy Java system's behavior for handling rounding discrepancies in Oracle Fusion.

## Monitoring

View real-time queue status:

```bash
# Using BullMQ Board (optional)
npm install -g bull-board
bull-board
```

Or use Redis CLI:

```bash
redis-cli
KEYS bull:*
```

## Docker

Build and run:

```bash
docker build -t vyrooq-retry-engine .
docker run -p 3200:3200 --env-file .env vyrooq-retry-engine
```

## License

MIT
