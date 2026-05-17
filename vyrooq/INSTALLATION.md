# Vyrooq Middleware - Complete Installation Guide

**Welcome to Vyrooq!** This guide will help you get the Vyrooq integration middleware platform up and running quickly and reliably.

## 📋 Table of Contents

1. [What is Vyrooq?](#what-is-vyrooq)
2. [Prerequisites](#prerequisites)
3. [Installation Methods](#installation-methods)
4. [Method 1: Docker Quick Start (Recommended)](#method-1-docker-quick-start-recommended)
5. [Method 2: Manual Installation](#method-2-manual-installation)
6. [Verification](#verification)
7. [Troubleshooting](#troubleshooting)
8. [Next Steps](#next-steps)

---

## What is Vyrooq?

Vyrooq is an **enterprise integration middleware platform** that connects:
- **Oracle Fusion ERP** (your enterprise resource planning system)
- **VendHQ POS** (your point-of-sale system)
- **OpenCart E-commerce** (your online store)

It automates the synchronization of:
- 📦 **Products** from Fusion to VendHQ/OpenCart
- 💰 **Sales** from VendHQ/OpenCart to Fusion (creating invoices & receipts)
- 📊 **Inventory** levels between all systems
- 🧾 **Financial transactions** for accounting

---

## Prerequisites

### Required Software

| Software | Minimum Version | Download Link | Purpose |
|----------|----------------|---------------|---------|
| **Docker Desktop** (Windows/Mac) <br>or **Docker Engine** (Linux) | 20.10+ | [Download Docker](https://docs.docker.com/get-docker/) | Container runtime |
| **Docker Compose** | v2.0+ | Included with Docker Desktop | Service orchestration |

### System Requirements

- **RAM:** 8GB minimum (16GB recommended)
- **Disk Space:** 50GB free space
- **CPU:** 4 cores recommended
- **OS:** Windows 10+, macOS 12+, or Linux (Ubuntu 20.04+, CentOS 8+, etc.)

### Required Credentials

You'll need credentials for the systems you want to integrate:

- ✅ **Oracle Fusion ERP** (Required)
  - Base URL (e.g., `https://your-instance.fa.your-region.oraclecloud.com`)
  - Username
  - Password

- ⚠️ **VendHQ POS** (Optional - only if using VendHQ)
  - API URL (e.g., `https://yourdomain.vendhq.com/api/2.0`)
  - API Token

- ⚠️ **OpenCart** (Optional - only if using OpenCart)
  - API URL
  - API Key

### Verify Docker Installation

```bash
# Check Docker version
docker --version
# Expected output: Docker version 20.10.x or higher

# Check Docker Compose version
docker compose version
# Expected output: Docker Compose version v2.x.x or higher

# Test Docker is running
docker run --rm hello-world
# Should print "Hello from Docker!"
```

✅ If all commands succeed, you're ready to proceed!

❌ If any command fails, please install Docker first: https://docs.docker.com/get-docker/

---

## Installation Methods

Choose the installation method that best fits your needs:

| Method | Best For | Time Required | Difficulty |
|--------|----------|---------------|------------|
| **Docker Quick Start** | Most users, quick setup | 5-10 minutes | ⭐ Easy |
| **Manual Installation** | Developers, customization | 30-60 minutes | ⭐⭐⭐ Advanced |

---

## Method 1: Docker Quick Start (Recommended)

This is the **fastest and easiest** way to get Vyrooq running.

### Step 1: Clone the Repository

```bash
# Clone the repository
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git

# Navigate to the vyrooq directory
cd integration-Oracle/vyrooq
```

### Step 2: Configure Environment Variables

The `.env` file contains all configuration settings. You need to update it with your credentials.

```bash
# Open the .env file in your favorite editor
# Windows:
notepad .env

# macOS:
open -e .env

# Linux:
nano .env
# or
vim .env
```

**Required Changes:**

Update these lines with your Oracle Fusion credentials:

```bash
# Oracle Fusion ERP Credentials (REQUIRED)
FUSION_BASE_URL=https://your-instance.fa.your-region.oraclecloud.com
FUSION_USERNAME=your-fusion-username
FUSION_PASSWORD=your-fusion-password
```

**Optional Changes (only if you use these systems):**

```bash
# VendHQ POS (Optional - only if using VendHQ)
VENDHQ_API_URL=https://yourdomain.vendhq.com/api/2.0
VENDHQ_API_TOKEN=your-vendhq-api-token

# OpenCart E-commerce (Optional - only if using OpenCart)
OPENCART_API_URL=https://your-opencart-domain.com/api
OPENCART_API_KEY=your-opencart-api-key
```

Save and close the file.

### Step 3: Start Infrastructure Services

Start the databases and message brokers first:

```bash
# Start infrastructure (databases, caches, message queues)
docker compose up -d postgres redis rabbitmq kafka zookeeper
```

**Wait for services to be ready** (30-60 seconds):

```bash
# Check if services are running
docker compose ps
```

You should see all services with status "Up" or "Up (healthy)".

### Step 4: Start Application Services

Now start the core application microservices:

```bash
# Start core services
docker compose up -d gateway-api fusion-adapter reconciliation-engine audit-engine event-bus
```

### Step 5: Verify Installation

```bash
# Check all services are running
docker compose ps

# Test the Gateway API
curl http://localhost:3000/health
```

**Expected response:**
```json
{"status":"ok","timestamp":"2024-05-17T12:00:00.000Z"}
```

✅ **Success!** If you see this response, Vyrooq is running correctly.

### Step 6: Access the Web Interface

Open your web browser and navigate to:

- **API Documentation:** http://localhost:3000/docs
- **Swagger UI:** Interactive API testing interface

---

## Method 2: Manual Installation

This method is for developers who want to run services locally without Docker.

### Step 1: Install Required Software

1. **Node.js 20+**
   - Download: https://nodejs.org/
   - Verify: `node --version` (should show v20.x or higher)

2. **Python 3.11+**
   - Download: https://www.python.org/downloads/
   - Verify: `python --version` (should show 3.11.x or higher)

3. **PostgreSQL 16**
   - Download: https://www.postgresql.org/download/
   - Create database: `createdb vyrooq`

4. **Redis 7+**
   - Download: https://redis.io/download/
   - Start: `redis-server`

### Step 2: Clone Repository

```bash
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/vyrooq
```

### Step 3: Install Node.js Services

For each Node.js service, run:

```bash
# Gateway API
cd gateway-api
npm install
npm run build
cd ..

# Reconciliation Engine
cd reconciliation-engine
npm install
npm run build
cd ..

# Audit Engine
cd audit-engine
npm install
npm run build
cd ..

# Event Bus
cd event-bus
npm install
npm run build
cd ..

# Retry Engine
cd retry-engine
npm install
npm run build
cd ..
```

### Step 4: Install Python Services

```bash
# Fusion Adapter
cd fusion-adapter
python -m venv venv

# Activate virtual environment
# Windows:
venv\Scripts\activate
# Linux/Mac:
source venv/bin/activate

pip install -r requirements.txt
cd ..
```

### Step 5: Configure Environment

Copy and edit `.env` file for each service:

```bash
# For each service directory, copy .env.example to .env
cp gateway-api/.env.example gateway-api/.env
cp fusion-adapter/.env.example fusion-adapter/.env
# ... repeat for other services

# Edit each .env file with your credentials
```

### Step 6: Start Services

Open separate terminal windows for each service:

**Terminal 1 - PostgreSQL & Redis:**
```bash
# Start PostgreSQL and Redis (if not already running)
# PostgreSQL: varies by OS
# Redis: redis-server
```

**Terminal 2 - Gateway API:**
```bash
cd gateway-api
npm start
```

**Terminal 3 - Fusion Adapter:**
```bash
cd fusion-adapter
source venv/bin/activate  # or venv\Scripts\activate on Windows
python main.py
```

**Terminal 4 - Reconciliation Engine:**
```bash
cd reconciliation-engine
npm start
```

Continue for other services...

### Step 7: Verify

```bash
curl http://localhost:3000/health
```

---

## Verification

### 1. Check All Services Are Running

```bash
# Docker users:
docker compose ps

# Manual installation users:
# Check each terminal window for running services
```

**Expected Output (Docker):**

All services should show "Up" or "Up (healthy)" status:
- postgres
- redis
- rabbitmq
- kafka
- zookeeper
- gateway-api
- fusion-adapter
- reconciliation-engine
- audit-engine
- event-bus

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

### 3. Access Web Interfaces

Open your browser and visit:

| Service | URL | Default Credentials |
|---------|-----|-------------------|
| API Documentation | http://localhost:3000/docs | N/A |
| RabbitMQ Management | http://localhost:15672 | vyrooq / vyrooq123 |
| Grafana Dashboards | http://localhost:3002 | admin / vyrooq123 |
| Temporal UI | http://localhost:8233 | N/A |
| Prometheus | http://localhost:9090 | N/A |

### 4. View Logs

```bash
# Docker - view all logs
docker compose logs -f

# Docker - view specific service
docker compose logs -f gateway-api

# Docker - view last 100 lines
docker compose logs --tail=100 gateway-api
```

---

## Troubleshooting

### Issue 1: Docker Build Fails

**Symptom:**
```
ERROR: failed to solve: process "/bin/sh -c npm run build" did not complete successfully
```

**Solution:**

1. **Check Internet Connection:**
   ```bash
   # Test npm registry access
   curl https://registry.npmjs.org/
   ```

2. **Disable VPN** (VPN can interfere with Docker networking)

3. **Rebuild with No Cache:**
   ```bash
   docker compose build --no-cache
   ```

4. **Check Docker has enough resources:**
   - Docker Desktop → Settings → Resources
   - Set Memory to at least 8GB
   - Set Disk to at least 50GB

### Issue 2: Port Already in Use

**Symptom:**
```
Error: bind: address already in use
```

**Solution:**

```bash
# Find what's using the port (example: port 3000)
# Windows:
netstat -ano | findstr :3000

# Linux/Mac:
lsof -i :3000

# Kill the process or change port in docker-compose.yml
```

### Issue 3: Services Keep Restarting

**Symptom:**
Services show "Restarting" status in `docker compose ps`

**Solution:**

```bash
# Check logs to see the error
docker compose logs -f gateway-api

# Common causes:
# 1. Missing environment variables (check .env file)
# 2. Database not ready (wait longer)
# 3. Invalid credentials (check FUSION_* variables)

# Fix the issue and restart
docker compose restart gateway-api
```

### Issue 4: Cannot Connect to PostgreSQL

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

### Issue 5: "Out of Memory" Error

**Solution:**

```bash
# Increase Docker memory
# Docker Desktop → Settings → Resources → Memory: 8GB minimum

# Or start only essential services:
docker compose up -d postgres redis gateway-api fusion-adapter
```

### Issue 6: Installation Takes Too Long

If `docker compose up` takes more than 10 minutes:

1. **Check your internet speed** (downloads ~2GB of images)
2. **Disable VPN**
3. **Use a wired connection** instead of WiFi
4. **Try a different time** (avoid peak hours)

### Issue 7: Services Won't Start on Windows

**Solution:**

```powershell
# Run PowerShell as Administrator
# Enable WSL 2 (required for Docker Desktop)
wsl --install

# Restart computer
# Install Docker Desktop
# Enable WSL 2 integration in Docker Desktop settings
```

### Still Having Issues?

1. **Read BUILD_TROUBLESHOOTING.md** in this directory for more detailed solutions
2. **Check logs:** `docker compose logs -f`
3. **Run diagnostics:** `./diagnose.sh` (if available)
4. **Open an issue:** https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
   - Include: OS, Docker version, full error message, output of `docker compose logs`

---

## Next Steps

### 1. Configure Your Integration

Edit `.env` file and configure:
- Oracle Fusion credentials (required)
- VendHQ API token (if using VendHQ)
- OpenCart API key (if using OpenCart)

### 2. Explore the API

Visit the interactive API documentation:
- http://localhost:3000/docs

Try the example endpoints:
- `GET /health` - Check system health
- `GET /api/status` - View integration status
- `POST /api/sales/process` - Process a test sale

### 3. Set Up Monitoring

1. **Grafana Dashboards:** http://localhost:3002
   - Login: admin / vyrooq123
   - Pre-configured dashboards for monitoring

2. **RabbitMQ Queue Monitoring:** http://localhost:15672
   - Login: vyrooq / vyrooq123
   - Monitor message queues

### 4. Review Documentation

- **Architecture Guide:** `docs/ARCHITECTURE.md` - Understanding the system design
- **API Reference:** http://localhost:3000/docs - All available endpoints
- **Deployment Guide:** `DEPLOYMENT-GUIDE.md` - Production deployment
- **Operations Manual:** `docs/OPERATIONS.md` - Day-to-day operations

### 5. Test the Integration

Process a sample transaction:

```bash
curl -X POST http://localhost:3000/api/sales/process \
  -H "Content-Type: application/json" \
  -d '{
    "invoiceNumber": "TEST001",
    "saleDate": "2024-05-17T10:00:00Z",
    "outletId": "OUTLET1",
    "region": "AE",
    "customerType": "NORMAL",
    "totalPrice": 1000.00,
    "lineItems": [
      {
        "itemNumber": "ITEM001",
        "itemName": "Test Product",
        "quantity": 1,
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

Check the result:

```bash
curl http://localhost:3000/api/sales/status/TEST001
```

### 6. Production Deployment

When ready for production, read:
- **PRODUCTION-DEPLOYMENT.md** - Production deployment guide
- **SECURITY.md** - Security best practices
- **PRODUCTION-READINESS-CHECKLIST.md** - Pre-launch checklist

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

## Minimal Installation (Testing Only)

If you just want to test the core functionality with minimal resources:

```bash
# Start only essential services
docker compose up -d postgres redis gateway-api fusion-adapter

# Wait 30 seconds
sleep 30

# Test
curl http://localhost:3000/health
```

This minimal setup requires only ~4GB RAM.

---

## Summary of Commands

```bash
# Quick start (all-in-one)
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/vyrooq
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

## Support

Need help? Here's how to get support:

1. **Documentation:** Check the `docs/` directory
2. **Troubleshooting:** Read `BUILD_TROUBLESHOOTING.md`
3. **GitHub Issues:** https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
4. **Email Support:** support@vyrooq.com (if available)

When reporting issues, please include:
- Your operating system (Windows/Mac/Linux)
- Docker version (`docker --version`)
- Full error message
- Output of `docker compose logs`

---

**Last Updated:** May 17, 2024
**Version:** 1.0.0
**Tested On:** Docker Desktop 4.30+, Windows 11, macOS Sonoma, Ubuntu 22.04

---

**🎉 Congratulations!** You've successfully installed Vyrooq middleware. Happy integrating!
