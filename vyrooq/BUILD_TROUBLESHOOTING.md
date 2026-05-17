# Docker Build Troubleshooting Guide

## Common Build Errors and Solutions

### 1. "tsc: not found" Error

**Error Message:**
```
sh: tsc: not found
ERROR: process "/bin/sh -c npm run build" did not complete successfully: exit code: 127
```

**Root Cause:**
TypeScript (tsc) was not installed because npm install failed or timed out during the Docker build process.

**Solution:**
This error is typically preceded by npm installation failures. See the npm timeout/network issues section below.

---

### 2. NPM Timeout / Network Connectivity Issues

**Error Messages:**
```
npm error code ETIMEDOUT
npm error errno ETIMEDOUT
npm error network request to https://registry.npmjs.org/... failed
npm error Exit handler never called!
```

**Root Cause:**
Docker build environment has network connectivity issues accessing the npm registry. This can happen due to:
- Firewall or proxy restrictions
- VPN interference
- Slow or unstable internet connection
- Docker network configuration issues
- Corporate network restrictions

**Solutions:**

#### Option 1: Configure Network Retries (Already Done)
The Dockerfiles have been updated with aggressive network retry configuration:
```dockerfile
RUN npm config set fetch-retries 10 && \
    npm config set fetch-retry-mintimeout 60000 && \
    npm config set fetch-retry-maxtimeout 120000 && \
    npm config set fetch-timeout 300000 && \
    npm ci || npm install
```

This helps but may not solve all network issues.

#### Option 2: Use NPM Cache or Offline Mode
If you have a working internet connection elsewhere:
1. On a machine with good connectivity, run:
   ```bash
   cd vyrooq/event-bus
   npm install
   ```
2. Copy the entire `node_modules` folder to your Docker build context
3. Modify the Dockerfile to copy the existing node_modules:
   ```dockerfile
   COPY node_modules ./node_modules
   ```

#### Option 3: Use a Different NPM Registry Mirror
Add to Dockerfile before npm install:
```dockerfile
RUN npm config set registry https://registry.npmmirror.com
```

Or use a corporate/local npm mirror if available.

#### Option 4: Build Outside Docker
Instead of building inside Docker:
1. Install dependencies locally:
   ```bash
   npm install
   npm run build
   ```
2. Modify Dockerfile to skip npm install and just copy the built artifacts

#### Option 5: Check Network Configuration

**For Windows Users (Docker Desktop):**
1. Check if VPN is interfering - try disconnecting VPN
2. In Docker Desktop settings:
   - Go to Resources → Network
   - Try changing DNS server to 8.8.8.8 or 1.1.1.1
   - Enable "Use kernel networking for UDP" if available

3. Check Windows Firewall:
   - Ensure Docker Desktop has network access
   - Temporarily disable firewall to test

4. Try resetting Docker Desktop networking:
   ```powershell
   # In PowerShell (Admin)
   docker system prune -a
   # Restart Docker Desktop
   ```

**For Linux Users:**
1. Check Docker daemon network settings in `/etc/docker/daemon.json`
2. Try adding DNS configuration:
   ```json
   {
     "dns": ["8.8.8.8", "8.8.4.4"]
   }
   ```
3. Restart Docker: `sudo systemctl restart docker`

#### Option 6: Use Docker BuildKit with  Network Mode
```bash
DOCKER_BUILDKIT=1 docker build --network=host -t event-bus ./vyrooq/event-bus
```

---

### 3. Building Specific Services

To build and test a single service:

```bash
cd vyrooq/event-bus
docker build -t test-event-bus .
```

To build all services:

```bash
cd vyrooq
docker-compose build
```

---

### 4. Recommended Approach for Development

**For local development:**
1. Install Node.js locally (v22.x)
2. Run `npm install` in each service directory locally (outside Docker)
3. Use `npm run dev` to run services in development mode
4. Only use Docker for production-like testing

**For production deployment:**
1. Ensure the build environment has stable internet connection
2. Use CI/CD pipelines with good network connectivity
3. Consider using a private npm registry or artifact caching
4. Pre-build Docker images in a controlled environment

---

### 5. Testing Network Connectivity

Test if npm registry is accessible from Docker:

```bash
docker run --rm node:22-alpine sh -c "npm config set fetch-timeout 30000 && npm install express"
```

If this fails with ETIMEDOUT, you have a Docker network issue.

---

### 6. Alternative: Use Pre-built Base Images

Consider creating a base image with all dependencies pre-installed:

```dockerfile
# base-builder.Dockerfile
FROM node:22-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
```

Build it once when you have good connectivity:
```bash
docker build -f base-builder.Dockerfile -t event-bus-base .
```

Then use it in your main Dockerfile:
```dockerfile
FROM event-bus-base AS builder
COPY . .
RUN npm run build
```

---

## Summary

The "tsc: not found" error is caused by npm failing to install dependencies due to network connectivity issues. The primary solutions are:

1. ✅ **Configured**: Aggressive network retry settings (already done)
2. 🔧 **Recommended**: Fix Docker network configuration (check VPN, DNS, firewall)
3. 🚀 **Workaround**: Build locally outside Docker, then copy artifacts
4. 🏢 **Enterprise**: Use private npm registry or mirror

For immediate relief, try disconnecting VPN and rebuilding, or build dependencies locally and copy them into the Docker context.
