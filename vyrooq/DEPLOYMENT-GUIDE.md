# 🎯 Vyrooq Platform - Deployment & Usage Guide

Complete step-by-step guide to deploy and use the Vyrooq Integration Platform.

## 📋 Table of Contents

1. [Quick Start](#quick-start)
2. [Detailed Setup](#detailed-setup)
3. [Admin Dashboard Usage](#admin-dashboard-usage)
4. [Service Management](#service-management)
5. [Troubleshooting](#troubleshooting)

---

## 🚀 Quick Start

### Step 1: Start All Services

```bash
cd /home/runner/work/integration-Oracle/integration-Oracle/vyrooq

# Start infrastructure and all microservices
docker-compose up -d

# Wait for services to initialize (30-60 seconds)
docker-compose ps
```

### Step 2: Verify Services Are Running

```bash
# Check all services are healthy
docker-compose ps | grep "Up"

# Should see 15+ services running including:
# - postgres, redis, rabbitmq, kafka, zookeeper
# - temporal, gateway-api, admin-dashboard
# - retry-engine, manual-control-engine, etc.
```

### Step 3: Access Admin Dashboard

1. Open browser: **http://localhost:4000**
2. You'll see the Vyrooq Admin Dashboard login screen
3. Default credentials (change in production):
   - Email: `admin@vyrooq.com`
   - Password: `admin123`

### Step 4: Monitor Your Services

Once logged in, you can:
- ✅ View real-time status of all 9 services
- ✅ Pause/resume queues
- ✅ Monitor transaction metrics
- ✅ View integration statistics
- ✅ Check system health

---

## 📖 Detailed Setup

### Prerequisites

**Required Software:**
- Docker Desktop 20.10+ ([Download](https://www.docker.com/products/docker-desktop))
- Docker Compose 2.0+ (included with Docker Desktop)
- 8GB+ RAM available
- 20GB+ disk space

**Optional (for development):**
- Node.js 22+ ([Download](https://nodejs.org/))
- Python 3.11+ ([Download](https://www.python.org/))

### Environment Configuration

#### 1. Admin Dashboard Configuration

```bash
# Navigate to admin dashboard
cd vyrooq/admin-dashboard

# Copy environment template
cp .env.example .env

# Edit .env file
nano .env
```

**Important settings in `.env`:**
```bash
PORT=4000
SESSION_SECRET=change-this-in-production-use-long-random-string

# Service URLs (defaults work for Docker Compose)
AUTH_SERVICE_URL=http://gateway-api:3000
RETRY_ENGINE_URL=http://retry-engine:3200
DEDUPLICATION_ENGINE_URL=http://dedup-engine:3300
MANUAL_CONTROL_ENGINE_URL=http://manual-control-engine:3001
```

#### 2. Gateway API Configuration

```bash
cd ../gateway-api
cp .env.example .env
nano .env
```

**Key settings:**
```bash
NODE_ENV=production
PORT=3000
DATABASE_URL=postgresql://postgres:vyrooq123@postgres:5432/vyrooq
REDIS_URL=redis://redis:6379
JWT_SECRET=change-this-long-random-secret-in-production
```

#### 3. Oracle Fusion Configuration (if using)

```bash
cd ../fusion-adapter
cp .env.example .env
nano .env
```

```bash
FUSION_CLOUD_URL=https://your-instance.fa.em2.oraclecloud.com
FUSION_USERNAME=your-username
FUSION_PASSWORD=your-password
```

#### 4. VendHQ Configuration (if using)

```bash
cd ../vendhq-adapter
cp .env.example .env
nano .env
```

```bash
VENDHQ_DOMAIN=yourdomain
VENDHQ_ACCESS_TOKEN=your-access-token
```

#### 5. Opencart Configuration (if using)

```bash
cd ../opencart-adapter
cp .env.example .env
nano .env
```

```bash
OPENCART_URL=https://your-store.com
OPENCART_API_KEY=your-api-key
```

### Starting Services

```bash
# From /vyrooq directory
cd /home/runner/work/integration-Oracle/integration-Oracle/vyrooq

# Start all services in detached mode
docker-compose up -d

# Follow logs for all services
docker-compose logs -f

# Or follow specific service logs
docker-compose logs -f admin-dashboard
docker-compose logs -f gateway-api
```

### Stopping Services

```bash
# Stop all services
docker-compose stop

# Stop and remove containers
docker-compose down

# Stop, remove containers, and delete volumes (CAUTION: deletes data)
docker-compose down -v
```

---

## 🖥️ Admin Dashboard Usage

### Main Dashboard (http://localhost:4000)

**Features:**
1. **Service Status Grid** - Shows health of all 9 services
   - Green = Healthy
   - Red = Unhealthy
   - Each card shows service name, status, and quick stats

2. **Quick Actions**
   - **Pause All Queues** - Emergency stop for all processing
   - **Resume All Queues** - Restart all processing
   - **View Metrics** - Open metrics dashboard
   - **Dedup Stats** - View deduplication statistics

3. **System Metrics Cards**
   - Queue Metrics: Active, waiting, failed job counts
   - Deduplication: Fingerprints, duplicate count
   - Integrations: Sync status, last run time

4. **Recent Activity Log** - Last 10 system events

### Queue Control Page (/pages/queues.html)

**Purpose:** Manage BullMQ job queues

**Features:**
1. **Queue Statistics Dashboard**
   - Total jobs across all queues
   - Active jobs currently processing
   - Waiting jobs in queue
   - Failed jobs requiring attention
   - Completed jobs

2. **Queue List Table**
   - Each queue shows: name, status, job counts
   - Actions per queue:
     - **Pause** - Stop processing new jobs
     - **Resume** - Start processing again
     - **Retry Failed** - Reprocess failed jobs

3. **Mass Operations**
   - Pause All Queues button
   - Resume All Queues button

**Use Cases:**
- Stop processing during maintenance: Click "Pause All Queues"
- Retry failed jobs: Click "Retry Failed" on specific queue
- Monitor queue depth: Check "Waiting" column

### Deduplication Page (/pages/deduplication.html)

**Purpose:** Monitor transaction deduplication engine

**Features:**
1. **Statistics Overview**
   - Total transactions processed
   - Unique transactions
   - Duplicates detected
   - Duplicate rate percentage
   - Last 24 hours count
   - Stored fingerprints

2. **Fingerprint Table**
   - Shows recent transaction fingerprints
   - Columns: Timestamp, Source, Transaction ID, Hash, Status, Count
   - Filter by status (unique/duplicate)
   - Filter by source (VendHQ/Opencart/Fusion)
   - Filter by date

3. **Duplicate Analysis**
   - Groups of duplicate transactions
   - Helps identify recurring issues

**Use Cases:**
- Check duplicate rate: View "Duplicate Rate" metric
- Find specific transaction: Filter by date and source
- Investigate duplicates: Look at duplicate transaction groups

### Integrations Page (/pages/integrations.html)

**Purpose:** Monitor third-party integrations

**Features:**
1. **Integration Cards** (3 cards: Fusion, VendHQ, Opencart)
   - Connection status indicator
   - Today's sync count
   - Success rate
   - Last sync time
   - Action buttons:
     - **Test** - Test connection to integration
     - **Sync Now** - Trigger manual sync
     - **Logs** - View sync logs

2. **Field Mappings Table**
   - Shows how data maps between systems
   - Example: VendHQ sale.total_price → Oracle Fusion Invoice.Amount

3. **Recent Sync Activity**
   - Last 10 sync operations
   - Color-coded: Green (success), Red (error)

**Use Cases:**
- Verify connection: Click "Test" on each integration
- Force sync: Click "Sync Now" to pull latest data
- Check sync history: Scroll to "Recent Sync Activity"

### Monitoring Page (/pages/monitoring.html)

**Purpose:** Real-time performance monitoring with charts

**Features:**
1. **Real-time Metrics**
   - CPU Usage
   - Memory Usage
   - Network I/O
   - Average Response Time
   - Success Rate
   - Active Users

2. **Performance Charts** (4 charts)
   - **Transaction Volume** - Line chart of transactions over time
   - **Queue Processing Rate** - Bar chart of processed vs failed
   - **Error Rate** - Line chart of errors over time
   - **Response Time Distribution** - Line chart of response times

3. **Service Health Pie Chart**
   - Shows healthy/warning/critical/offline services

4. **Time Range Selector**
   - Switch between 1h, 6h, 24h, 7d, 30d views

5. **System Alerts**
   - Recent warnings and errors

**Use Cases:**
- Check system performance: View CPU/Memory metrics
- Monitor error rate: Check error rate chart
- View trends: Switch time range to see patterns

---

## ⚙️ Service Management

### Checking Service Health

```bash
# Check all services
docker-compose ps

# Check specific service logs
docker-compose logs admin-dashboard
docker-compose logs gateway-api

# Check resource usage
docker stats

# Follow live logs
docker-compose logs -f admin-dashboard
```

### Restarting Services

```bash
# Restart specific service
docker-compose restart admin-dashboard

# Restart all services
docker-compose restart

# Rebuild and restart (after code changes)
docker-compose up -d --build admin-dashboard
```

### Scaling Services

```bash
# Scale retry engine to 3 instances
docker-compose up -d --scale retry-engine=3

# Scale back to 1 instance
docker-compose up -d --scale retry-engine=1
```

### Accessing Service Logs

```bash
# Last 100 lines of admin dashboard
docker-compose logs --tail=100 admin-dashboard

# Follow logs in real-time
docker-compose logs -f admin-dashboard

# All services logs
docker-compose logs

# Export logs to file
docker-compose logs > vyrooq-logs.txt
```

### Database Management

```bash
# Connect to PostgreSQL
docker-compose exec postgres psql -U postgres -d vyrooq

# Backup database
docker-compose exec postgres pg_dump -U postgres vyrooq > backup-$(date +%Y%m%d).sql

# Restore database
cat backup-20240514.sql | docker-compose exec -T postgres psql -U postgres vyrooq

# Check database size
docker-compose exec postgres psql -U postgres -d vyrooq -c "SELECT pg_size_pretty(pg_database_size('vyrooq'));"
```

### Redis Management

```bash
# Connect to Redis CLI
docker-compose exec redis redis-cli

# Check memory usage
docker-compose exec redis redis-cli INFO memory

# View all keys
docker-compose exec redis redis-cli KEYS "*"

# Clear all Redis data (CAUTION)
docker-compose exec redis redis-cli FLUSHALL
```

---

## 🐛 Troubleshooting

### Problem: Admin Dashboard Won't Load

**Symptoms:** Browser shows "Cannot connect" or timeout

**Solutions:**
```bash
# 1. Check if service is running
docker-compose ps admin-dashboard

# 2. Check logs for errors
docker-compose logs admin-dashboard

# 3. Restart the service
docker-compose restart admin-dashboard

# 4. Verify port is not in use
sudo lsof -i :4000  # Linux/Mac
netstat -ano | findstr :4000  # Windows

# 5. Check firewall
sudo ufw status  # Linux
```

### Problem: Login Fails

**Symptoms:** "Invalid credentials" or "Authentication failed"

**Solutions:**
```bash
# 1. Check auth service is running
docker-compose ps gateway-api

# 2. Check auth service logs
docker-compose logs gateway-api

# 3. Verify JWT_SECRET is set
docker-compose exec gateway-api env | grep JWT_SECRET

# 4. Create/reset admin user
docker-compose exec gateway-api npm run create-admin
```

### Problem: Services Show "Unhealthy"

**Symptoms:** Red status indicators in dashboard

**Solutions:**
```bash
# 1. Check which services are unhealthy
docker-compose ps

# 2. Check logs for the unhealthy service
docker-compose logs [service-name]

# 3. Restart unhealthy service
docker-compose restart [service-name]

# 4. Check dependencies (DB, Redis, etc.)
docker-compose ps postgres redis rabbitmq

# 5. Full restart if needed
docker-compose down
docker-compose up -d
```

### Problem: Queue Processing Stuck

**Symptoms:** Jobs stay in "waiting" state

**Solutions:**
```bash
# 1. Check retry-engine is running
docker-compose ps retry-engine

# 2. Check Redis is accessible
docker-compose exec redis redis-cli ping

# 3. Check queue logs
docker-compose logs retry-engine

# 4. Restart retry engine
docker-compose restart retry-engine

# 5. Use admin dashboard to pause/resume queue
# Navigate to Queue Control page → Pause → Resume
```

### Problem: High Memory Usage

**Symptoms:** System slow, services crashing

**Solutions:**
```bash
# 1. Check memory usage
docker stats

# 2. Identify memory hogs
docker stats --no-stream --format "table {{.Name}}\t{{.MemUsage}}"

# 3. Restart services with high memory
docker-compose restart [service-name]

# 4. Clear Redis cache
docker-compose exec redis redis-cli FLUSHALL

# 5. Scale down services
docker-compose up -d --scale retry-engine=1
```

### Problem: Database Connection Errors

**Symptoms:** "Cannot connect to database" errors

**Solutions:**
```bash
# 1. Check PostgreSQL is running
docker-compose ps postgres

# 2. Test database connection
docker-compose exec postgres psql -U postgres -d vyrooq -c "SELECT 1"

# 3. Check connection string
docker-compose exec gateway-api env | grep DATABASE_URL

# 4. Restart PostgreSQL
docker-compose restart postgres

# 5. Check PostgreSQL logs
docker-compose logs postgres
```

### Getting Help

If you continue to experience issues:

1. **Collect Logs**
   ```bash
   docker-compose logs > issue-logs.txt
   docker-compose ps > issue-status.txt
   ```

2. **Check System Resources**
   ```bash
   docker stats --no-stream > resource-usage.txt
   ```

3. **Create GitHub Issue**
   - Include logs and status files
   - Describe what you were trying to do
   - Share error messages

---

## 🔗 Quick Reference

### Service URLs

| Service | URL | Purpose |
|---------|-----|---------|
| Admin Dashboard | http://localhost:4000 | Web UI |
| Gateway API | http://localhost:3000 | API endpoint |
| Temporal UI | http://localhost:8233 | Workflow UI |
| RabbitMQ UI | http://localhost:15672 | Message queue |
| Grafana | http://localhost:3002 | Monitoring |
| Prometheus | http://localhost:9090 | Metrics |

### Default Credentials

| Service | Username | Password |
|---------|----------|----------|
| Admin Dashboard | admin@vyrooq.com | admin123 |
| RabbitMQ | vyrooq | vyrooq123 |
| Grafana | admin | vyrooq123 |
| PostgreSQL | postgres | vyrooq123 |

**⚠️ IMPORTANT: Change all passwords in production!**

### Common Commands

```bash
# Start everything
docker-compose up -d

# Stop everything
docker-compose down

# View logs
docker-compose logs -f

# Restart service
docker-compose restart [service-name]

# Rebuild service
docker-compose up -d --build [service-name]

# Check status
docker-compose ps

# View resource usage
docker stats
```

---

## 📞 Support

- **Documentation**: See main README.md for architecture details
- **Issues**: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
- **Email**: support@vyrooq.com

---

**Happy Integrating! 🎉**
