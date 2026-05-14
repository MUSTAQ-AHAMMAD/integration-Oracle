# Vyrooq Operational Scripts

This directory contains operational scripts for managing the Vyrooq middleware platform.

## Available Scripts

### Health & Monitoring

#### `health-check.sh`
Checks the health of all 20 services in the Vyrooq platform.

```bash
./scripts/health-check.sh
```

**Output:**
- ✓ Service healthy
- ✗ Service unhealthy
- Summary with counts

**Exit codes:**
- 0: All services healthy
- 1: One or more services unhealthy

**Use cases:**
- Pre-deployment verification
- Post-deployment validation
- Continuous monitoring (cron job)
- Incident investigation

### Security

#### `security-validation.sh`
Validates security configuration before production deployment.

```bash
./scripts/security-validation.sh
```

**Checks:**
- Environment variable security
- Default password detection
- Secrets in code
- Network exposure
- SSL/TLS configuration
- Dependency vulnerabilities

**Exit codes:**
- 0: All critical checks passed
- 1: One or more critical checks failed

**Use cases:**
- Pre-deployment security audit
- CI/CD pipeline security gate
- Regular security reviews

#### `generate-secrets.sh`
Generates strong random secrets for production deployment.

```bash
./scripts/generate-secrets.sh > .env.production
```

**Generates:**
- JWT secret (64 bytes)
- Session secret (32 bytes)
- Database passwords
- Redis password
- RabbitMQ password
- Encryption keys

**Use cases:**
- Initial production setup
- Secret rotation
- New environment setup

### Database Management

#### `backup-database.sh`
Creates compressed backups of the PostgreSQL database.

```bash
# Manual backup
./scripts/backup-database.sh

# With custom configuration
BACKUP_DIR=/custom/path RETENTION_DAYS=30 ./scripts/backup-database.sh
```

**Configuration:**
- `BACKUP_DIR`: Backup directory (default: `/var/backups/vyrooq`)
- `RETENTION_DAYS`: Days to keep backups (default: 7)
- `POSTGRES_USER`: Database user (default: `postgres`)
- `POSTGRES_DB`: Database name (default: `vyrooq`)

**Features:**
- Compressed backups (.sql.gz)
- Automatic cleanup of old backups
- Timestamped filenames
- Verification of backup success

**Use cases:**
- Scheduled daily backups (via cron)
- Pre-deployment backup
- Manual backup before risky operations

**Cron example:**
```cron
# Daily backup at 2 AM
0 2 * * * cd /path/to/vyrooq && ./scripts/backup-database.sh >> /var/log/vyrooq-backup.log 2>&1
```

#### `restore-database.sh`
Restores PostgreSQL database from backup.

```bash
./scripts/restore-database.sh vyrooq_backup_20260514_120000.sql.gz
```

**Features:**
- Lists available backups if no file specified
- Creates pre-restore backup
- Confirms before destructive operation
- Provides rollback instructions

**Use cases:**
- Disaster recovery
- Restore to previous state
- Clone database to staging

**⚠️ WARNING:** This is a destructive operation. Always verify backup before restoring.

### Testing

#### `integration-tests.sh`
Runs integration tests for critical workflows.

```bash
./scripts/integration-tests.sh
```

**Tests:**
- Health checks (all services)
- Authentication endpoints
- API gateway endpoints
- Database connectivity
- Cache & queue infrastructure
- Monitoring stack
- Adapters
- Event bus

**Exit codes:**
- 0: All tests passed
- 1: One or more tests failed

**Use cases:**
- Post-deployment verification
- CI/CD pipeline validation
- Regular smoke tests
- Troubleshooting

#### `run-load-test.sh` + `load-test.js`
Runs load tests using k6.

```bash
# Check if k6 is installed and run tests
./scripts/run-load-test.sh

# With custom configuration
API_BASE=http://api.production.com ./scripts/run-load-test.sh
```

**Test profile:**
- Ramp up to 50 users (2 min)
- Ramp up to 100 users (5 min)
- Sustain 100 users (5 min)
- Peak at 200 users (2 min)
- Sustain 200 users (3 min)
- Ramp down (2 min)
- **Total duration:** ~19 minutes

**Thresholds:**
- P95 latency < 5 seconds
- Error rate < 5%

**Output:**
- Console summary
- `load-test-results.json` file

**Prerequisites:**
- k6 installed ([installation guide](https://k6.io/docs/getting-started/installation/))
- Services running and accessible

**Use cases:**
- Performance testing before production
- Capacity planning
- SLA validation
- Bottleneck identification

### Utilities

#### `windows-setup.ps1`
PowerShell script for Windows environment setup.

```powershell
.\scripts\windows-setup.ps1
```

**Features:**
- Installs required dependencies
- Configures development environment
- Sets up Docker Desktop

**Use cases:**
- Initial setup on Windows
- CI/CD agent configuration

## Usage Patterns

### Pre-Deployment Workflow

```bash
# 1. Run security validation
./scripts/security-validation.sh

# 2. Backup current database
./scripts/backup-database.sh

# 3. Deploy new version
docker compose up -d

# 4. Run health checks
./scripts/health-check.sh

# 5. Run integration tests
./scripts/integration-tests.sh

# 6. If issues, rollback
docker compose down
./scripts/restore-database.sh vyrooq_backup_YYYYMMDD_HHMMSS.sql.gz
docker compose up -d
```

### Daily Operations

```bash
# Morning: Check system health
./scripts/health-check.sh

# Review logs
docker compose logs --since=24h | grep ERROR

# Check backups
ls -lh /var/backups/vyrooq/
```

### Incident Response

```bash
# 1. Check service health
./scripts/health-check.sh

# 2. Review service logs
docker compose logs --tail=200 problematic-service

# 3. Run integration tests to identify issue
./scripts/integration-tests.sh

# 4. If database issue, restore from backup
./scripts/restore-database.sh latest-backup.sql.gz
```

### Weekly Maintenance

```bash
# 1. Verify backups
ls -lh /var/backups/vyrooq/

# 2. Test restore (in staging environment)
./scripts/restore-database.sh vyrooq_backup_YYYYMMDD.sql.gz

# 3. Run load tests (staging)
./scripts/run-load-test.sh

# 4. Review security
./scripts/security-validation.sh
```

## Automation

### Cron Jobs

Add to `/etc/crontab` or use `crontab -e`:

```cron
# Health check every 5 minutes
*/5 * * * * cd /path/to/vyrooq && ./scripts/health-check.sh >> /var/log/vyrooq-health.log 2>&1

# Daily backup at 2 AM
0 2 * * * cd /path/to/vyrooq && ./scripts/backup-database.sh >> /var/log/vyrooq-backup.log 2>&1

# Weekly integration tests (Sunday 3 AM)
0 3 * * 0 cd /path/to/vyrooq && ./scripts/integration-tests.sh >> /var/log/vyrooq-tests.log 2>&1

# Monthly security validation (1st of month, 4 AM)
0 4 1 * * cd /path/to/vyrooq && ./scripts/security-validation.sh >> /var/log/vyrooq-security.log 2>&1
```

### CI/CD Integration

Example GitHub Actions workflow:

```yaml
name: Production Deployment

on:
  push:
    branches: [main]

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v3

      - name: Security Validation
        run: ./scripts/security-validation.sh

      - name: Backup Database
        run: ./scripts/backup-database.sh

      - name: Deploy
        run: docker compose up -d

      - name: Health Check
        run: ./scripts/health-check.sh

      - name: Integration Tests
        run: ./scripts/integration-tests.sh
```

## Troubleshooting

### Script won't execute
```bash
# Make script executable
chmod +x scripts/script-name.sh
```

### Permission denied errors
```bash
# Run with sudo if needed (for system operations)
sudo ./scripts/backup-database.sh

# Or adjust permissions on backup directory
sudo chown -R $USER:$USER /var/backups/vyrooq
```

### Docker compose not found
```bash
# Install Docker Compose
# https://docs.docker.com/compose/install/

# Or use 'docker-compose' (with hyphen)
# Edit scripts and replace 'docker compose' with 'docker-compose'
```

### Services not accessible
```bash
# Check if services are running
docker compose ps

# Check if ports are correct
docker compose port gateway-api 3000

# Check firewall
sudo ufw status
```

## Best Practices

1. **Always backup before risky operations**
   ```bash
   ./scripts/backup-database.sh
   ```

2. **Run security validation before production deployment**
   ```bash
   ./scripts/security-validation.sh
   ```

3. **Verify health after any changes**
   ```bash
   ./scripts/health-check.sh
   ```

4. **Test in staging before production**
   - Run all scripts in staging first
   - Validate results
   - Then apply to production

5. **Keep logs of script execution**
   ```bash
   ./scripts/health-check.sh >> /var/log/vyrooq-health.log 2>&1
   ```

6. **Review script output**
   - Don't ignore warnings
   - Investigate failures immediately
   - Document resolutions

## Support

For issues with scripts:
1. Check script permissions (`ls -l scripts/`)
2. Review error messages carefully
3. Check prerequisites (Docker, curl, etc.)
4. Consult the main documentation in `/docs`
5. Refer to the operational runbook at `/docs/RUNBOOK.md`

---

**Last Updated**: 2026-05-14
**Version**: 1.0.0
**Maintainer**: Platform Engineering Team
