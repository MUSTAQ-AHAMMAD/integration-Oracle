# Vyrooq Operations Runbook

## Table of Contents

1. [Service Overview](#service-overview)
2. [Common Operations](#common-operations)
3. [Incident Response](#incident-response)
4. [Troubleshooting Guide](#troubleshooting-guide)
5. [Maintenance Procedures](#maintenance-procedures)
6. [Monitoring & Alerts](#monitoring--alerts)
7. [Emergency Contacts](#emergency-contacts)

## Service Overview

### Architecture
- **Application Services**: 13 microservices
- **Infrastructure**: PostgreSQL, Redis, RabbitMQ, Kafka, Temporal
- **Monitoring**: Prometheus, Grafana
- **Total Services**: 20 components

### Service Dependencies

```
Gateway API (3000)
├── PostgreSQL (5432)
├── Redis (6379)
├── RabbitMQ (5672)
└── Kafka (9092)

Auth Service (3100)
├── PostgreSQL (5432)
└── Redis (6379)

Workflow Engine
├── Temporal (7233)
└── Kafka (9092)
```

### Critical Services
1. **PostgreSQL** - Primary data store (if down, system is inoperable)
2. **Gateway API** - Main entry point
3. **Temporal** - Workflow orchestration
4. **Redis** - Caching and queuing

## Common Operations

### Starting Services

```bash
# Start all services
cd /path/to/vyrooq
docker compose up -d

# Start specific service
docker compose up -d gateway-api

# Start in stages
docker compose up -d postgres redis rabbitmq kafka
sleep 30
docker compose up -d gateway-api auth-service
```

### Stopping Services

```bash
# Stop all services
docker compose down

# Stop specific service
docker compose stop gateway-api

# Stop and remove volumes (⚠️ DESTRUCTIVE)
docker compose down -v
```

### Checking Service Status

```bash
# Check all services
docker compose ps

# Check specific service
docker compose ps gateway-api

# Run health check script
./scripts/health-check.sh

# Check service logs
docker compose logs gateway-api
docker compose logs -f gateway-api  # Follow logs
docker compose logs --tail=100 gateway-api  # Last 100 lines
```

### Scaling Services

```bash
# Scale horizontally
docker compose up -d --scale gateway-api=3

# In Kubernetes
kubectl scale deployment gateway-api --replicas=5 -n vyrooq-production
```

### Viewing Logs

```bash
# All services
docker compose logs -f

# Specific service
docker compose logs -f gateway-api

# Last N lines
docker compose logs --tail=100 gateway-api

# Search logs
docker compose logs gateway-api | grep ERROR

# Export logs
docker compose logs --no-color > logs-$(date +%Y%m%d).txt
```

## Incident Response

### Severity Levels

**P0 - Critical**: System down, data loss imminent
- Response time: Immediate
- All hands on deck

**P1 - High**: Major functionality broken
- Response time: 15 minutes
- Senior engineer required

**P2 - Medium**: Degraded performance
- Response time: 1 hour
- Regular engineer

**P3 - Low**: Minor issue, workaround available
- Response time: Next business day
- Can be handled during regular hours

### Incident Response Checklist

1. **Acknowledge** the incident in monitoring system
2. **Assess** severity and impact
3. **Notify** stakeholders (use severity matrix)
4. **Investigate** root cause
5. **Mitigate** immediate impact
6. **Fix** the underlying issue
7. **Verify** resolution
8. **Document** in post-mortem
9. **Follow up** with preventive measures

### Emergency Procedures

#### Database Down

```bash
# Check PostgreSQL status
docker compose ps postgres
docker compose logs postgres

# Restart PostgreSQL
docker compose restart postgres

# If corrupt, restore from backup
./scripts/restore-database.sh vyrooq_backup_YYYYMMDD_HHMMSS.sql.gz
```

#### Service Crash Loop

```bash
# Check why service is crashing
docker compose logs --tail=200 service-name

# Check resource constraints
docker stats

# Restart service
docker compose restart service-name

# If persistent, check for:
# - Configuration errors (.env)
# - Database connectivity
# - Missing dependencies
```

#### High Memory Usage

```bash
# Check memory usage
docker stats

# Check which service
docker stats --no-stream --format "table {{.Name}}\t{{.MemUsage}}"

# Restart high-memory service
docker compose restart service-name

# If Redis is high
docker compose exec redis redis-cli FLUSHDB  # ⚠️ Clears cache
```

#### Kafka Issues

```bash
# Check Kafka status
docker compose exec kafka kafka-topics --bootstrap-server localhost:9092 --list

# Check consumer lag
docker compose exec kafka kafka-consumer-groups --bootstrap-server localhost:9092 --list

# Recreate topics if needed
docker compose exec kafka kafka-topics --bootstrap-server localhost:9092 --create --topic vyrooq.sales.created --partitions 3 --replication-factor 1
```

#### Authentication Failures

```bash
# Check Auth Service logs
docker compose logs auth-service | grep ERROR

# Verify JWT secret is set
docker compose exec auth-service env | grep JWT_SECRET

# Check Redis connectivity (sessions)
docker compose exec redis redis-cli ping

# Restart auth service
docker compose restart auth-service
```

## Troubleshooting Guide

### Symptom: Slow Response Times

**Possible Causes:**
1. Database connection pool exhausted
2. High queue backlog
3. Memory pressure
4. Network latency

**Diagnosis:**
```bash
# Check database connections
docker compose exec postgres psql -U postgres -c "SELECT count(*) FROM pg_stat_activity;"

# Check queue depths
curl http://localhost:3200/queues  # Retry engine

# Check memory
docker stats

# Check network
ping localhost
```

**Resolution:**
- Increase database connection pool
- Scale services horizontally
- Clear old queue jobs
- Add more resources

### Symptom: Failed Transactions

**Possible Causes:**
1. Oracle Fusion connectivity issues
2. Validation failures
3. Authentication expired
4. Rate limiting

**Diagnosis:**
```bash
# Check adapter logs
docker compose logs fusion-adapter | grep ERROR

# Check retry queue
curl http://localhost:3200/queues/failed

# Check audit logs
curl http://localhost:3600/events/errors?limit=50
```

**Resolution:**
- Verify Fusion credentials
- Check network connectivity to Fusion
- Review failed transaction details
- Manually retry if needed

### Symptom: Data Inconsistency

**Possible Causes:**
1. Failed reconciliation
2. Race conditions
3. Partial transaction failure

**Diagnosis:**
```bash
# Run reconciliation report
curl http://localhost:3500/reports/mismatches

# Check audit trail
curl "http://localhost:3600/events/sale/SALE-ID"

# Verify data in database
docker compose exec postgres psql -U postgres vyrooq -c "SELECT * FROM sales WHERE id = 'SALE-ID';"
```

**Resolution:**
- Run manual reconciliation
- Review audit trail
- Fix data manually if needed
- Update reconciliation rules

## Maintenance Procedures

### Daily Tasks

```bash
# 1. Check service health
./scripts/health-check.sh

# 2. Review error logs
docker compose logs --since 24h | grep ERROR

# 3. Check queue depths
# Visit admin dashboard: http://localhost:4000

# 4. Monitor resource usage
docker stats --no-stream
```

### Weekly Tasks

```bash
# 1. Backup database
./scripts/backup-database.sh

# 2. Review metrics in Grafana
# Visit: http://localhost:3002

# 3. Check for stuck workflows
# Visit Temporal UI: http://localhost:8233

# 4. Review reconciliation reports
curl http://localhost:3500/reports/weekly
```

### Monthly Tasks

```bash
# 1. Update dependencies
cd vyrooq/gateway-api && npm audit
cd vyrooq/fusion-adapter && pip list --outdated

# 2. Review and clean old logs
# Configure log rotation

# 3. Database maintenance
docker compose exec postgres psql -U postgres vyrooq -c "VACUUM ANALYZE;"

# 4. Review and update documentation
```

### Database Backup

```bash
# Manual backup
./scripts/backup-database.sh

# Automated backup (add to cron)
0 2 * * * /path/to/vyrooq/scripts/backup-database.sh

# Verify backup
ls -lh /var/backups/vyrooq/

# Test restore (in staging)
./scripts/restore-database.sh vyrooq_backup_YYYYMMDD_HHMMSS.sql.gz
```

### Certificate Renewal

```bash
# Using Let's Encrypt with certbot
certbot renew --dry-run

# Update certificates in reverse proxy
# Restart proxy to apply new certificates
```

### Dependency Updates

```bash
# Check for updates
cd vyrooq/gateway-api
npm outdated

# Update dependencies
npm update

# Run tests
npm test

# Security audit
npm audit
npm audit fix
```

## Monitoring & Alerts

### Key Metrics to Monitor

1. **Throughput**
   - Target: >10,000 transactions/hour
   - Alert: <1,000 transactions/hour

2. **Latency**
   - Target: <5s average
   - Alert: >10s average

3. **Error Rate**
   - Target: <2%
   - Alert: >5%

4. **Queue Depth**
   - Target: <100 jobs
   - Alert: >1,000 jobs

5. **Database Connections**
   - Target: <80% of pool
   - Alert: >90% of pool

6. **Memory Usage**
   - Target: <80%
   - Alert: >90%

### Grafana Dashboards

Access: http://localhost:3002
- **System Overview**: Overall health
- **Service Metrics**: Per-service performance
- **Database**: Connection pools, query time
- **Queue Metrics**: BullMQ depths and processing rates

### Alert Configuration

Configure alerts in Prometheus/Grafana:

```yaml
# prometheus-alerts.yml
groups:
  - name: vyrooq
    interval: 30s
    rules:
      - alert: HighErrorRate
        expr: rate(http_requests_total{status=~"5.."}[5m]) > 0.05
        for: 5m
        labels:
          severity: critical
        annotations:
          summary: "High error rate detected"

      - alert: ServiceDown
        expr: up == 0
        for: 2m
        labels:
          severity: critical
        annotations:
          summary: "Service {{ $labels.instance }} is down"
```

### Log Aggregation

View logs in:
- **Grafana Loki** (if configured)
- **ELK Stack** (if configured)
- **Docker logs**: `docker compose logs`

## Emergency Contacts

### On-Call Rotation

| Role | Primary | Secondary |
|------|---------|-----------|
| Platform Engineer | [Name] | [Name] |
| Database Admin | [Name] | [Name] |
| DevOps Engineer | [Name] | [Name] |
| Product Manager | [Name] | - |

### Escalation Path

1. **L1**: On-call engineer (responds within 15 min)
2. **L2**: Senior engineer (if not resolved in 30 min)
3. **L3**: Engineering manager (if P0/P1 and not resolved in 1 hour)
4. **L4**: CTO (if major incident)

### Communication Channels

- **Slack**: #vyrooq-incidents (immediate)
- **Email**: vyrooq-oncall@company.com
- **Phone**: [Emergency number]
- **Status Page**: status.vyrooq.com

### External Vendors

- **Oracle Support**: [Support portal URL]
- **VendHQ Support**: support@vendhq.com
- **AWS Support**: [Support case URL]
- **Cloud Provider**: [Support number]

## Appendix

### Useful Commands

```bash
# Quick service restart
docker compose restart gateway-api

# View service configuration
docker compose config

# Scale service
docker compose up -d --scale gateway-api=3

# Remove stopped containers
docker compose rm

# View resource usage
docker compose top

# Execute command in container
docker compose exec gateway-api npm run health-check
```

### File Locations

- **Logs**: `/var/log/vyrooq/` or Docker logs
- **Backups**: `/var/backups/vyrooq/`
- **Configuration**: `vyrooq/.env`
- **Docker Compose**: `vyrooq/docker-compose.yml`
- **Scripts**: `vyrooq/scripts/`

### Important URLs

- Gateway API: http://localhost:3000
- Admin Dashboard: http://localhost:4000
- Grafana: http://localhost:3002
- Prometheus: http://localhost:9090
- Temporal UI: http://localhost:8233
- RabbitMQ: http://localhost:15672

---

**Last Updated**: 2026-05-14
**Version**: 1.0.0
**Owner**: Platform Engineering Team
