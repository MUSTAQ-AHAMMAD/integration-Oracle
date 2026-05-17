# Issue Resolution: "Cannot find module '/app/reset-credentials.js'"

## Problem Summary

After running `git pull` to get the latest code changes (including the new `reset-credentials.js` file), the user attempted to run the script inside the Docker container but received this error:

```
Error: Cannot find module '/app/reset-credentials.js'
```

## Root Cause

**Docker doesn't automatically rebuild images when code changes are pulled.**

When you run `docker-compose up -d` without the `--build` flag, Docker reuses the existing cached image. The new `reset-credentials.js` file exists on your host machine but not inside the container because the container is running an old image that was built before this file was added to the repository.

## Solution

**Rebuild the Docker image** to include the new files:

### Quick Fix (Recommended)
```bash
docker-compose up -d --build
```

Then run the script:
```bash
docker exec -it oracle-crm node reset-credentials.js
```

### Alternative: Use Helper Script
```bash
./docker-rebuild.sh --reset-credentials
```

This script automates the rebuild and can optionally run the credential reset utility.

### Complete Rebuild (if issues persist)
```bash
docker-compose down
docker-compose build --no-cache
docker-compose up -d
```

## Why This Happens

1. **Git pull updates host files** - The `reset-credentials.js` file is now in your local `oracle-crm/` directory
2. **Docker uses image snapshots** - The container runs from a Docker image built at a specific point in time
3. **Image not automatically updated** - Running `docker-compose up -d` alone doesn't rebuild the image
4. **File missing in container** - The old image doesn't include files added after it was built

## Prevention

**Always rebuild after pulling new code:**
```bash
git pull
docker-compose up -d --build  # Note the --build flag
```

Or use the provided helper script:
```bash
git pull
./docker-rebuild.sh
```

## Documentation Added

This issue has been documented in three places:

1. **README.md** - Added a "Docker Deployment" section with clear instructions
2. **DOCKER_TROUBLESHOOTING.md** - Comprehensive troubleshooting guide for common Docker issues
3. **docker-rebuild.sh** - Helper script that automates the rebuild process

## Key Takeaways

- 🔴 `docker-compose up -d` → Uses cached image (won't include new files)
- 🟢 `docker-compose up -d --build` → Rebuilds image with new files
- 📝 Always use `--build` after pulling code changes
- 🛠️ Use `docker-rebuild.sh` for convenience

## References

- Docker Deployment: See oracle-crm/README.md "🐳 Docker Deployment" section
- Troubleshooting: See oracle-crm/DOCKER_TROUBLESHOOTING.md
- Helper Script: Run `./docker-rebuild.sh --help`
