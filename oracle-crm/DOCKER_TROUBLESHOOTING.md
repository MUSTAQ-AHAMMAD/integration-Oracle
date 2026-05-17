# Docker Troubleshooting Guide

## Common Issues and Solutions

### Issue: "Cannot find module" error when running scripts in Docker container

**Symptoms:**
```
$ docker exec -it oracle-crm node reset-credentials.js
Error: Cannot find module '/app/reset-credentials.js'
```

**Cause:**
When you pull new code from the repository (`git pull`), the files are updated on your host machine but not inside the Docker container. Docker containers use images that were built at a specific point in time. Simply running `docker-compose up -d` won't rebuild the image - it will reuse the cached image that doesn't contain the new files.

**Solution:**
Rebuild the Docker image to include the new files:

```bash
# Method 1: Using docker-compose with --build flag
docker-compose up -d --build

# Method 2: Using the helper script (recommended)
./docker-rebuild.sh

# Method 3: Force complete rebuild (if the above don't work)
docker-compose down
docker-compose build --no-cache
docker-compose up -d
```

**Explanation:**
- `--build` tells docker-compose to rebuild the image before starting the container
- `--no-cache` forces Docker to rebuild from scratch, ignoring any cached layers
- The helper script (`docker-rebuild.sh`) automates these steps

---

### Issue: Docker image still has old code after rebuild

**Symptoms:**
- Files appear to be missing even after running `docker-compose up -d --build`
- Old version of code is running

**Cause:**
Docker's build cache may be preventing a proper rebuild.

**Solution:**
```bash
# Stop and remove the container
docker-compose down

# Remove the image
docker rmi oracle-crm_oracle-crm

# Rebuild without cache
docker-compose build --no-cache

# Start the container
docker-compose up -d
```

---

### Issue: "version is obsolete" warning

**Symptoms:**
```
level=warning msg="docker-compose.yml: the attribute `version` is obsolete"
```

**Cause:**
Docker Compose V2 doesn't require the `version` field in docker-compose.yml files.

**Impact:**
This is just a warning and doesn't affect functionality. The container will work normally.

**Solution (optional):**
You can remove the `version: '3.8'` line from docker-compose.yml, or simply ignore the warning as it's harmless.

---

### Issue: Permission denied when running scripts

**Symptoms:**
```
sh: can't open 'reset-credentials.js': Permission denied
```

**Solution:**
Ensure scripts are executable:
```bash
# On host machine
chmod +x oracle-crm/reset-credentials.js

# Rebuild the image
docker-compose up -d --build
```

---

### Issue: Container not starting after rebuild

**Symptoms:**
- Container exits immediately after starting
- `docker ps` doesn't show the oracle-crm container

**Diagnosis:**
```bash
# View logs
docker-compose logs

# Or for more detail
docker logs oracle-crm
```

**Common causes:**
1. **Missing environment variables** - Ensure `.env` file exists with required variables
2. **Port conflict** - Port 3000 might be in use by another application
3. **Database corruption** - Try removing the data volume

**Solutions:**
```bash
# Check if port 3000 is in use
netstat -an | grep 3000
# or on Windows:
netstat -an | findstr 3000

# Remove volumes and restart
docker-compose down -v
docker-compose up -d --build
```

---

### Issue: File not found in container but exists on host

**Symptoms:**
- File exists in your local directory
- File not found when running commands inside container

**Cause:**
The file might be excluded by `.dockerignore`

**Solution:**
Check `.dockerignore` file to ensure your file isn't being excluded:
```bash
cat .dockerignore
```

Files that should NOT be in `.dockerignore`:
- `*.js` (application JavaScript files)
- `package.json`, `package-lock.json`
- Application source code directories

Files that SHOULD be in `.dockerignore`:
- `node_modules` (rebuilt inside container)
- `.env` (mounted as volume)
- `logs`, `data` (mounted as volumes)

---

### Quick Reference: Docker Rebuild Workflow

After pulling new code (`git pull`):

```bash
# Recommended: Use the helper script
./docker-rebuild.sh

# Or manually:
docker-compose up -d --build

# If issues persist:
docker-compose down
docker-compose build --no-cache
docker-compose up -d
```

---

### Verifying Files Inside Container

To check if a file exists inside the container:

```bash
# Access container shell
docker exec -it oracle-crm sh

# List files in /app directory
ls -la /app

# Check if specific file exists
ls -la /app/reset-credentials.js

# Exit shell
exit
```

---

### Helper Script Usage

The `docker-rebuild.sh` script simplifies common Docker operations:

```bash
# Basic rebuild
./docker-rebuild.sh

# Force rebuild without cache
./docker-rebuild.sh --no-cache

# Rebuild and reset credentials
./docker-rebuild.sh --reset-credentials

# Show help
./docker-rebuild.sh --help
```

---

## Best Practices

1. **Always rebuild after `git pull`** - Use `docker-compose up -d --build`
2. **Use the helper script** - It automates the rebuild process and checks
3. **Monitor logs** - Use `docker-compose logs -f` to watch for errors
4. **Clean up regularly** - Remove unused images and containers to free space
5. **Backup data** - The `./data` directory contains your database

---

## Getting Help

If you continue to experience issues:

1. Check the logs: `docker-compose logs`
2. Verify Docker is running: `docker info`
3. Check disk space: `df -h`
4. Review this troubleshooting guide
5. Try a complete rebuild: `docker-compose down && docker-compose build --no-cache && docker-compose up -d`
