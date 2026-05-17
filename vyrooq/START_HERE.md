# 🚀 Vyrooq Integration Platform - START HERE

## Welcome! 👋

You've reached the **Vyrooq** middleware platform. If you're frustrated with installation or confused about setup, **you're in the right place**. This guide will get you up and running quickly.

---

## ⚡ Quick Installation (5 Minutes)

**Don't want to read documentation? Run this:**

```bash
# 1. Clone the repository
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/vyrooq

# 2. Run the automated setup script
./quick-start.sh
```

The script will:
- ✅ Check if Docker is installed
- ✅ Configure your environment
- ✅ Start all services
- ✅ Verify the installation

**That's it!** Open http://localhost:3000/docs when done.

---

## 📖 Prefer Step-by-Step Instructions?

**Read the complete installation guide:**

### **👉 [INSTALLATION.md](./INSTALLATION.md) ← START HERE**

This guide includes:
- ✅ Prerequisites and system requirements
- ✅ Docker installation (recommended)
- ✅ Manual installation (for developers)
- ✅ Troubleshooting common issues
- ✅ Verification steps
- ✅ Next steps after installation

**Takes 10-15 minutes to complete.**

---

## 🎯 What is Vyrooq?

Vyrooq is an **enterprise integration middleware** that connects:

- **Oracle Fusion ERP** (your business system)
- **VendHQ POS** (your point-of-sale)
- **OpenCart** (your e-commerce store)

It automatically synchronizes:
- 📦 Products
- 💰 Sales transactions
- 📊 Inventory levels
- 🧾 Financial records

**No more manual data entry!**

---

## 📋 Prerequisites

Before installing, you need:

| Requirement | Minimum Version | Download |
|------------|----------------|----------|
| **Docker** | 20.10+ | [Get Docker](https://docs.docker.com/get-docker/) |
| **RAM** | 8GB | (16GB recommended) |
| **Disk Space** | 50GB | Free space required |

**Check if you have Docker:**
```bash
docker --version
docker compose version
```

If these commands work, you're ready to install!

---

## 🗺️ Documentation Navigation

**Confused about which document to read?** Here's the guide:

### 1. Installation & Setup
- **[INSTALLATION.md](./INSTALLATION.md)** - Complete installation guide (START HERE)
- **[quick-start.sh](./quick-start.sh)** - Automated installation script
- **[LOCAL_SETUP_GUIDE.md](./LOCAL_SETUP_GUIDE.md)** - Detailed local setup
- **[QUICKSTART.md](./QUICKSTART.md)** - Quick reference (for experts)

### 2. Troubleshooting
- **[BUILD_TROUBLESHOOTING.md](./BUILD_TROUBLESHOOTING.md)** - Docker build issues
- Check logs: `docker compose logs -f`
- Run diagnostics: `./diagnose.sh`

### 3. Understanding the System
- **[README.md](./README.md)** - Architecture overview
- **[docs/ARCHITECTURE.md](./docs/ARCHITECTURE.md)** - Detailed system design
- **[docs/API.md](./docs/API.md)** - API reference

### 4. Production Deployment
- **[PRODUCTION-DEPLOYMENT.md](./PRODUCTION-DEPLOYMENT.md)** - Production setup
- **[PRODUCTION-READINESS-CHECKLIST.md](./PRODUCTION-READINESS-CHECKLIST.md)** - Pre-launch checklist
- **[SECURITY.md](./SECURITY.md)** - Security best practices

---

## 🆘 Having Problems?

### Common Issues & Quick Fixes

**Problem: "Docker is not installed"**
- **Solution:** Install Docker Desktop: https://docs.docker.com/get-docker/

**Problem: "Port already in use"**
- **Solution:** Stop the conflicting service or change ports in `docker-compose.yml`

**Problem: "Services won't start"**
- **Solution:** Check Docker is running: `docker ps`
- Try: `docker compose down && docker compose up -d`

**Problem: "Build fails with npm errors"**
- **Solution:** See [BUILD_TROUBLESHOOTING.md](./BUILD_TROUBLESHOOTING.md)
- Quick fix: Disable VPN and try again

**Problem: "Out of memory"**
- **Solution:** Increase Docker memory to 8GB in Docker Desktop settings

**Problem: "Can't connect to PostgreSQL"**
- **Solution:** `docker compose down -v && docker compose up -d postgres`
- Wait 30 seconds and try again

### Still Stuck?

1. **Check logs:** `docker compose logs -f gateway-api`
2. **Read troubleshooting:** [BUILD_TROUBLESHOOTING.md](./BUILD_TROUBLESHOOTING.md)
3. **Open an issue:** https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues

---

## ✅ Verify Installation

After installation, verify everything works:

```bash
# Check all services are running
docker compose ps

# Test the API
curl http://localhost:3000/health

# Should return: {"status":"ok"}
```

**Access the web interfaces:**
- **API Docs:** http://localhost:3000/docs
- **RabbitMQ:** http://localhost:15672 (vyrooq / vyrooq123)
- **Grafana:** http://localhost:3002 (admin / vyrooq123)

---

## 📚 Next Steps

Once installed:

1. **Configure your credentials** - Edit `.env` file with your Oracle Fusion login
2. **Explore the API** - Visit http://localhost:3000/docs
3. **Process a test transaction** - Try the examples in INSTALLATION.md
4. **Set up monitoring** - Configure Grafana dashboards
5. **Read the architecture** - Understand how it works: [README.md](./README.md)

---

## 🎓 Learning Path

**Complete beginner?** Follow this order:

1. ✅ **Install:** [INSTALLATION.md](./INSTALLATION.md) or run `./quick-start.sh`
2. ✅ **Explore API:** http://localhost:3000/docs
3. ✅ **Understand system:** [README.md](./README.md)
4. ✅ **Production setup:** [PRODUCTION-DEPLOYMENT.md](./PRODUCTION-DEPLOYMENT.md)

---

## 📞 Get Help

- **Documentation:** See files in this directory
- **GitHub Issues:** https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
- **Logs:** `docker compose logs -f`

When reporting issues, include:
- Your OS (Windows/Mac/Linux)
- Docker version
- Error message
- Output of `docker compose logs`

---

## 🎉 Ready to Install?

**Choose your path:**

### Path 1: Automated (Easiest)
```bash
./quick-start.sh
```

### Path 2: Manual (Full Control)
Read: **[INSTALLATION.md](./INSTALLATION.md)**

---

**Last Updated:** May 17, 2024

**Questions?** Open an issue on GitHub: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
