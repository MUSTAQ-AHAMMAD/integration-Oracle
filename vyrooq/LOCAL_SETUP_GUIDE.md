# Vyrooq Platform - Complete Local Setup Guide

This guide will help you run the Vyrooq platform on your local machine. Follow these steps carefully.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Quick Start (Recommended)](#quick-start-recommended)
3. [Manual Setup](#manual-setup)
4. [Common Issues & Solutions](#common-issues--solutions)
5. [Verification Steps](#verification-steps)

---

## Prerequisites

### Required Software

1. **Docker Desktop** (for Windows/Mac) or **Docker Engine** (for Linux)
   - Windows: [Download Docker Desktop](https://www.docker.com/products/docker-desktop/)
   - Mac: [Download Docker Desktop](https://www.docker.com/products/docker-desktop/)
   - Linux: [Install Docker Engine](https://docs.docker.com/engine/install/)
   - **Minimum Requirements:**
     - 8GB RAM (16GB recommended)
     - 50GB free disk space
     - Docker version 20.10+ and Docker Compose v2.0+

2. **Verify Docker Installation:**
   ```bash
   docker --version
   # Should show: Docker version 20.10 or higher

   docker compose version
   # Should show: Docker Compose version v2.0 or higher
   ```

### Optional (for local development without Docker)

- **Node.js 20+**: [Download Node.js](https://nodejs.org/)
- **Python 3.11+**: [Download Python](https://www.python.org/downloads/)
- **PostgreSQL 16**: [Download PostgreSQL](https://www.postgresql.org/download/)

---

## Quick Start (Recommended)

This is the **easiest and fastest** way to get started. Follow these steps:

### Step 1: Clone the Repository

```bash
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/vyrooq
```

### Step 2: Configure Environment Variables

The `.env` file already exists with default values. You need to update Oracle Fusion credentials:

```bash
# Open .env file in your favorite editor
# Windows:
notepad .env

# Linux/Mac:
nano .env
# or
vim .env
```

**Minimum Required Changes:**
Update these lines in the `.env` file:
```bash
# Oracle Fusion ERP Credentials (REQUIRED)
FUSION_BASE_URL=https://your-instance.fa.your-region.oraclecloud.com
FUSION_USERNAME=your-fusion-username
FUSION_PASSWORD=your-fusion-password
```

**Optional (only if you have VendHQ or OpenCart):**
```bash
# VendHQ POS (Optional)
VENDHQ_API_URL=https://yourdomain.vendhq.com/api/2.0
VENDHQ_API_TOKEN=your-vendhq-api-token

# OpenCart E-commerce (Optional)
OPENCART_API_URL=https://your-opencart-domain.com/api
OPENCART_API_KEY=your-opencart-api-key
```

### Step 3: Start Infrastructure Services First

Start the databases and message queues first:

```bash
# Start only infrastructure (databases, caches, message brokers)
docker compose up -d postgres redis rabbitmq kafka zookeeper
```

Wait for services to be ready (about 30-60 seconds):
```bash
# Check if services are healthy
docker compose ps
```

You should see all infrastructure services with "healthy" status.

### Step 4: Start Application Services

Now start the application microservices:

```bash
# Start core application services
docker compose up -d gateway-api fusion-adapter reconciliation-engine audit-engine event-bus
```

### Step 5: Start Monitoring (Optional)

```bash
# Start monitoring services
docker compose up -d temporal prometheus grafana
```

### Step 6: Start Admin Dashboard (Optional)

```bash
# Start admin dashboard and control engines
docker compose up -d admin-dashboard manual-control-engine retry-engine
```

### Step 7: Verify Everything is Running

```bash
# Check all services
docker compose ps

# Test the Gateway API
curl http://localhost:3000/health

# If curl isn't installed, open in browser:
# http://localhost:3000/health
```

Expected response:
```json
{"status":"ok","timestamp":"2024-05-17T10:00:00.000Z"}
```

---

## Manual Setup (Alternative Method)

If you prefer to run services locally without Docker, follow this section.

### 1. Install Dependencies

#### For Node.js Services:
```bash
cd gateway-api
npm install
npm run build
cd ..

cd reconciliation-engine
npm install
npm run build
cd ..

# Repeat for other Node.js services...
```

#### For Python Services:
```bash
cd fusion-adapter
python -m venv venv

# Activate virtual environment
# Windows:
venv\Scripts\activate
# Linux/Mac:
source venv/bin/activate

pip install -r requirements.txt
cd ..

# Repeat for other Python services...
```

### 2. Start PostgreSQL & Redis

```bash
# Using Docker (easiest):
docker compose up -d postgres redis

# Or install locally:
# - PostgreSQL: https://www.postgresql.org/download/
# - Redis: https://redis.io/download/
```

### 3. Run Database Migrations

```bash
cd gateway-api
npm run db:migrate
cd ..
```

### 4. Start Services Manually

Open separate terminal windows for each service:

**Terminal 1 - Gateway API:**
```bash
cd gateway-api
npm run start
```

**Terminal 2 - Fusion Adapter:**
```bash
cd fusion-adapter
python main.py
```

**Terminal 3 - Reconciliation Engine:**
```bash
cd reconciliation-engine
npm run start
```

---

## Common Issues & Solutions

### Issue 1: Docker Build Fails with "tsc: not found"

**Cause:** Network timeout during npm install in Docker build.

**Solutions:**

**Option A: Build services locally first (Recommended)**
```bash
# For each Node.js service:
cd gateway-api
npm install
npm run build
cd ..

# Then rebuild Docker images:
docker compose build --no-cache gateway-api
```

**Option B: Use host network (Linux only)**
```bash
DOCKER_BUILDKIT=1 docker compose build --network=host
```

**Option C: Configure Docker DNS**
```bash
# Windows/Mac: Docker Desktop → Settings → Docker Engine
# Add this configuration:
{
  "dns": ["8.8.8.8", "8.8.4.4"]
}

# Restart Docker Desktop and try again
```

**Option D: Disable VPN**
```bash
# Disconnect VPN if you're using one
# VPN can interfere with Docker networking
```

### Issue 2: "Port Already in Use"

**Cause:** Another service is using the same port.

**Solution:**
```bash
# Find what's using the port (e.g., port 3000)
# Windows:
netstat -ano | findstr :3000

# Linux/Mac:
lsof -i :3000

# Kill the process or change the port in docker-compose.yml
```

### Issue 3: "Cannot Connect to PostgreSQL"

**Solution:**
```bash
# Stop all services
docker compose down

# Remove volumes (WARNING: This deletes all data)
docker compose down -v

# Start fresh
docker compose up -d postgres

# Wait 30 seconds, then test:
docker compose exec postgres psql -U postgres -d vyrooq -c "SELECT 1"
```

### Issue 4: Services Keep Restarting

**Solution:**
```bash
# Check logs to see what's failing
docker compose logs -f gateway-api

# Common causes:
# 1. Missing environment variables
# 2. Database not ready
# 3. Invalid credentials in .env file

# Fix the issue and restart:
docker compose restart gateway-api
```

### Issue 5: "Out of Memory" or Slow Performance

**Solution:**
```bash
# Increase Docker memory allocation
# Docker Desktop → Settings → Resources
# Set Memory to at least 8GB

# Or start only essential services:
docker compose up -d postgres redis gateway-api fusion-adapter
```

### Issue 6: Docker Compose Command Not Found

**On Windows:**
```powershell
# Use "docker compose" (with space) not "docker-compose"
docker compose up -d

# If that doesn't work, install Docker Desktop:
# https://www.docker.com/products/docker-desktop/
```

**On Linux:**
```bash
# Install Docker Compose plugin
sudo apt-get update
sudo apt-get install docker-compose-plugin

# Or use standalone docker-compose
sudo curl -L "https://github.com/docker/compose/releases/download/v2.20.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```

---

## Verification Steps

### 1. Check All Services are Running

```bash
docker compose ps

# All services should show "Up" or "Up (healthy)"
```

### 2. Test Individual Services

**Gateway API:**
```bash
curl http://localhost:3000/health
# Expected: {"status":"ok"}
```

**Fusion Adapter:**
```bash
curl http://localhost:8300/health
# Expected: {"status":"healthy"}
```

**Reconciliation Engine:**
```bash
curl http://localhost:3500/health
# Expected: {"status":"ok"}
```

**Audit Engine:**
```bash
curl http://localhost:3600/health
# Expected: {"status":"ok"}
```

**Event Bus:**
```bash
curl http://localhost:3700/health
# Expected: {"status":"ok"}
```

### 3. Test API Documentation

Open in your browser:
- **API Docs:** http://localhost:3000/docs
- **Grafana:** http://localhost:3002 (admin/vyrooq123)
- **RabbitMQ:** http://localhost:15672 (vyrooq/vyrooq123)
- **Temporal UI:** http://localhost:8233

### 4. Process a Test Transaction

```bash
curl -X POST http://localhost:3000/api/sales/process \
  -H "Content-Type: application/json" \
  -d '{
    "invoiceNumber": "TEST001",
    "saleDate": "2024-05-13T10:00:00Z",
    "outletId": "OUTLET1",
    "region": "AE",
    "customerType": "NORMAL",
    "totalPrice": 1000.00,
    "lineItems": [
      {
        "itemNumber": "ITEM001",
        "itemName": "Product 1",
        "quantity": 5,
        "totalPrice": 1000.00,
        "taxName": "VAT5"
      }
    ],
    "payments": [
      {
        "paymentType": "Cash",
        "amount": 1000.00
      }
    ]
  }'
```

### 5. Check Logs for Errors

```bash
# View all logs
docker compose logs -f

# Or specific service:
docker compose logs -f gateway-api
docker compose logs -f fusion-adapter
```

---

## Minimal Setup (For Testing Only)

If you just want to test the core functionality with minimal resources:

```bash
# Start only essential services
docker compose up -d postgres redis gateway-api fusion-adapter

# Wait 30 seconds
sleep 30

# Test
curl http://localhost:3000/health
```

This minimal setup uses:
- PostgreSQL (database)
- Redis (cache)
- Gateway API (REST API)
- Fusion Adapter (Oracle integration)

---

## Stopping Services

```bash
# Stop all services (keeps data)
docker compose stop

# Stop and remove containers (keeps data)
docker compose down

# Stop and remove everything including data (CAUTION!)
docker compose down -v
```

---

## Getting Help

If you're still having issues:

1. **Check the logs:**
   ```bash
   docker compose logs -f
   ```

2. **Check BUILD_TROUBLESHOOTING.md** in this directory

3. **Open an issue:**
   - GitHub: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
   - Include:
     - Your OS (Windows/Mac/Linux)
     - Docker version
     - Full error message
     - Output of `docker compose logs`

---

## Next Steps

Once everything is running:

1. ✅ Review the **API Documentation**: http://localhost:3000/docs
2. ✅ Configure your **Oracle Fusion credentials** in `.env`
3. ✅ Set up **Grafana dashboards**: http://localhost:3002
4. ✅ Read the **Architecture Guide**: `ARCHITECTURE.md`
5. ✅ Review **Production Deployment**: `PRODUCTION-DEPLOYMENT.md`

---

## Summary of Commands

```bash
# Quick start (all-in-one)
cd integration-Oracle/vyrooq
cp .env.example .env  # Only if .env doesn't exist
# Edit .env with your credentials
docker compose up -d postgres redis rabbitmq kafka zookeeper
sleep 30
docker compose up -d gateway-api fusion-adapter reconciliation-engine audit-engine event-bus
curl http://localhost:3000/health

# Stop everything
docker compose down

# Start fresh (WARNING: Deletes all data)
docker compose down -v
docker compose up -d
```

---

**Last Updated:** May 17, 2024
**Version:** 1.0.0
**Tested On:** Docker Desktop 4.30+, Docker Engine 25.0+, Windows 11, Ubuntu 22.04, macOS Sonoma
