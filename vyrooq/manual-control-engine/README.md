# Manual Control Engine

Admin APIs for workflow management and manual control in Vyrooq Integration Platform.

## Features

- ✅ Pause/resume processing (per queue or all)
- ✅ Retry failed jobs (batch or individual)
- ✅ Force sync specific transactions
- ✅ Replay transactions from audit log
- ✅ Move jobs to Dead Letter Queue
- ✅ Clean completed jobs
- ✅ View failed jobs for manual review
- ✅ Control event history
- ✅ JWT authentication
- ✅ Comprehensive queue statistics

## API Endpoints

### Queue Management

**GET /queues**
Get status of all queues.

Response:
```json
{
  "queues": [
    {
      "name": "invoice-processing",
      "isPaused": false,
      "counts": {
        "waiting": 5,
        "active": 2,
        "completed": 1500,
        "failed": 3,
        "delayed": 0,
        "total": 1510
      }
    }
  ]
}
```

**GET /queues/:name**
Get status of specific queue.

**POST /queues/:name/pause**
Pause processing for queue.

**POST /queues/:name/resume**
Resume processing for queue.

**POST /queues/pause-all**
Pause all queues immediately.

**POST /queues/resume-all**
Resume all queues.

### Job Control

**POST /queues/:name/retry**
Retry failed jobs in queue.

Request:
```json
{
  "limit": 10
}
```

**POST /queues/:name/jobs/:jobId/retry**
Retry specific job by ID.

**DELETE /queues/:name/jobs/:jobId**
Remove job from queue.

**GET /queues/:name/failed**
Get failed jobs for manual review.

Query params: `?limit=50`

**POST /queues/:name/jobs/:jobId/move-to-dlq**
Move failed job to Dead Letter Queue.

### Transaction Control

**POST /force-sync**
Force immediate sync for specific sale.

Request:
```json
{
  "saleId": "SALE-001"
}
```

**POST /replay**
Replay transaction from audit log.

Request:
```json
{
  "auditEventId": "evt-12345"
}
```

### Monitoring

**GET /history**
Get control event history.

Query params: `?limit=100`

**GET /dlq**
Get Dead Letter Queue records.

Query params: `?limit=50`

**POST /queues/:name/clean**
Clean completed jobs from queue.

Request:
```json
{
  "grace": 3600000,
  "limit": 1000
}
```

### Health Checks

**GET /health** - Service health status

## Authentication

All endpoints (except `/health`) require JWT authentication:

```bash
curl -H "Authorization: Bearer <token>" \
  http://localhost:3400/queues
```

Get token from auth-service at `/auth/login`.

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
PORT=3400
NODE_ENV=development
JWT_SECRET=your-jwt-secret
REDIS_HOST=localhost
REDIS_PORT=6379
REDIS_PASSWORD=
DATABASE_URL=postgresql://postgres:vyrooq123@localhost:5432/vyrooq
TEMPORAL_HOST=localhost:7233
```

## Usage Examples

### Pause Processing During Maintenance

```bash
# Pause all queues
curl -X POST http://localhost:3400/queues/pause-all \
  -H "Authorization: Bearer <token>"

# Perform maintenance...

# Resume all queues
curl -X POST http://localhost:3400/queues/resume-all \
  -H "Authorization: Bearer <token>"
```

### Retry Failed Jobs

```bash
# Get failed jobs
curl -X GET http://localhost:3400/queues/invoice-processing/failed \
  -H "Authorization: Bearer <token>"

# Retry all failed jobs (up to 10)
curl -X POST http://localhost:3400/queues/invoice-processing/retry \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{"limit": 10}'

# Retry specific job
curl -X POST http://localhost:3400/queues/invoice-processing/jobs/12345/retry \
  -H "Authorization: Bearer <token>"
```

### Force Sync Transaction

```bash
curl -X POST http://localhost:3400/force-sync \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{"saleId": "SALE-001"}'
```

### Replay Failed Transaction

```bash
# Get audit event ID from logs/database
curl -X POST http://localhost:3400/replay \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{"auditEventId": "evt-12345"}'
```

### View Control History

```bash
curl -X GET "http://localhost:3400/history?limit=50" \
  -H "Authorization: Bearer <token>"
```

### Review Dead Letter Queue

```bash
curl -X GET "http://localhost:3400/dlq?limit=50" \
  -H "Authorization: Bearer <token>"
```

## Use Cases

### 1. Emergency Stop
Immediately pause all processing during critical issues:
```bash
POST /queues/pause-all
```

### 2. Maintenance Window
Pause processing, perform updates, then resume:
```bash
POST /queues/pause-all
# ... perform maintenance ...
POST /queues/resume-all
```

### 3. Batch Retry
Retry all failed jobs after fixing underlying issue:
```bash
POST /queues/invoice-processing/retry
POST /queues/receipt-processing/retry
```

### 4. Manual Correction
Force re-sync after manual data correction in Fusion:
```bash
POST /force-sync {"saleId": "SALE-123"}
```

### 5. Audit Trail Replay
Replay historical transaction from audit log:
```bash
POST /replay {"auditEventId": "evt-abc"}
```

## Security

- JWT authentication required for all control operations
- Role-based access control (requires ADMIN or SUPER_ADMIN role)
- All actions logged to database with timestamps
- Audit trail for compliance

## Performance

- Queue status queries: ~5-10ms
- Pause/resume operations: ~10-20ms
- Retry operations: ~50-100ms per job
- Batch operations: Configurable limits to prevent overload

## Docker

Build and run:

```bash
docker build -t vyrooq-manual-control-engine .
docker run -p 3400:3400 --env-file .env vyrooq-manual-control-engine
```

## License

MIT
