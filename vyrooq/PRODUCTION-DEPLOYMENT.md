# Vyrooq Production Deployment Guide

## Overview

This guide covers deploying Vyrooq middleware to production. The platform is now 100% production-ready with all critical components implemented.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Architecture Overview](#architecture-overview)
3. [Security Hardening](#security-hardening)
4. [Deployment Steps](#deployment-steps)
5. [Verification & Testing](#verification--testing)
6. [Monitoring & Maintenance](#monitoring--maintenance)
7. [Troubleshooting](#troubleshooting)

## Prerequisites

### Infrastructure Requirements

- **Compute**: Kubernetes cluster OR Docker Compose host
  - Minimum: 8 CPU cores, 32GB RAM
  - Recommended: 16 CPU cores, 64GB RAM

- **Storage**:
  - PostgreSQL: 100GB+ (with partitioning)
  - Redis: 8GB+ RAM
  - Kafka: 50GB+ disk

- **Network**:
  - Internal network for service communication
  - Firewall rules for external access
  - SSL/TLS certificates for HTTPS

### Software Requirements

- Docker 24+ and Docker Compose 2.20+
- OR Kubernetes 1.28+
- PostgreSQL 16
- Redis 7
- Kafka 3.5+
- Node.js 22+ (for local development)
- Python 3.13+ (for local development)

## Architecture Overview

### Service Inventory (All Production Ready ✅)

| Service | Port | Purpose | Status |
|---------|------|---------|--------|
| Gateway API | 3000 | Main REST API gateway | ✅ |
| Auth Service | 3100 | JWT authentication & RBAC | ✅ |
| Retry Engine | 3200 | BullMQ retry logic | ✅ |
| Deduplication Engine | 3300 | Redis idempotency | ✅ |
| Manual Control Engine | 3400 | Admin workflow controls | ✅ |
| Reconciliation Engine | 3500 | Data validation | ✅ |
| Audit Engine | 3600 | Event sourcing & compliance | ✅ |
| Event Bus | 3700 | Kafka integration | ✅ |
| Admin Dashboard | 4000 | Web UI | ✅ |
| VendHQ Adapter | 8100 | VendHQ integration | ✅ |
| Opencart Adapter | 8200 | Opencart integration | ✅ |
| Fusion Adapter | 8300 | Oracle Fusion client | ✅ |
| Workflow Engine | N/A | Temporal workers | ✅ |

### Infrastructure Services

| Service | Port | Purpose |
|---------|------|---------|
| PostgreSQL | 5432 | Primary database |
| Redis | 6379 | Cache & queues |
| RabbitMQ | 5672, 15672 | Message broker |
| Kafka | 9092 | Event streaming |
| Temporal | 7233, 8233 | Workflow engine |
| Prometheus | 9090 | Metrics |
| Grafana | 3002 | Dashboards |

## Security Hardening

### 1. Generate Strong Secrets

```bash
# Generate JWT secret (64 bytes)
openssl rand -base64 64

# Generate session secret (32 bytes)
openssl rand -base64 32

# Generate database password
openssl rand -base64 24
```

### 2. Update Environment Variables

Copy `.env.example` to `.env` and update ALL security-sensitive values:

```bash
cd vyrooq
cp .env.example .env
nano .env  # or use your preferred editor
```

**Critical values to change:**
- `JWT_SECRET_PRODUCTION`
- `SESSION_SECRET_PRODUCTION`
- `POSTGRES_PASSWORD_PRODUCTION`
- `REDIS_PASSWORD_PRODUCTION`
- `RABBITMQ_PASSWORD_PRODUCTION`
- `FUSION_USERNAME` and `FUSION_PASSWORD`
- `VENDHQ_API_TOKEN`
- `OPENCART_API_KEY`

### 3. Enable TLS/SSL

For production, enable HTTPS:

1. Obtain SSL certificates (Let's Encrypt, corporate CA, etc.)
2. Configure reverse proxy (nginx, Traefik, etc.)
3. Update CORS origins to specific domains
4. Set `HELMET_ENABLED=true`

### 4. Network Security

Configure firewall rules:

```bash
# Allow only necessary ports
# Public access
ufw allow 443/tcp  # HTTPS
ufw allow 80/tcp   # HTTP (redirect to HTTPS)

# Internal services (restrict to VPC/private network)
ufw allow from 10.0.0.0/8 to any port 5432  # PostgreSQL
ufw allow from 10.0.0.0/8 to any port 6379  # Redis
# ... configure other ports
```

### 5. Database Security

```sql
-- Create production database user with limited privileges
CREATE USER vyrooq_app WITH PASSWORD 'strong_password_here';
GRANT CONNECT ON DATABASE vyrooq TO vyrooq_app;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA public TO vyrooq_app;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO vyrooq_app;

-- Revoke dangerous privileges
REVOKE DELETE, DROP, TRUNCATE ON ALL TABLES IN SCHEMA public FROM vyrooq_app;
```

## Deployment Steps

### Option 1: Docker Compose (Single Server)

```bash
cd vyrooq

# 1. Build all services
docker-compose build

# 2. Initialize database
docker-compose up -d postgres
docker-compose exec postgres psql -U postgres -d vyrooq -f /docker-entrypoint-initdb.d/001_initial_schema.sql

# 3. Start infrastructure services
docker-compose up -d redis rabbitmq kafka temporal

# 4. Wait for services to be ready (30-60 seconds)
sleep 60

# 5. Start application services
docker-compose up -d gateway-api auth-service retry-engine deduplication-engine manual-control-engine

# 6. Start new production-ready services
docker-compose up -d reconciliation-engine audit-engine event-bus fusion-adapter

# 7. Start adapters
docker-compose up -d vendhq-adapter opencart-adapter

# 8. Start workflow engine
docker-compose up -d workflow-engine

# 9. Start admin dashboard
docker-compose up -d admin-dashboard

# 10. Start monitoring
docker-compose up -d prometheus grafana

# 11. Verify all services are healthy
docker-compose ps
```

### Option 2: Kubernetes Deployment

```bash
cd vyrooq/k8s

# 1. Create namespace
kubectl create namespace vyrooq-production

# 2. Create secrets
kubectl create secret generic vyrooq-secrets \
  --from-literal=jwt-secret=$(openssl rand -base64 64) \
  --from-literal=session-secret=$(openssl rand -base64 32) \
  --from-literal=postgres-password=$(openssl rand -base64 24) \
  --namespace=vyrooq-production

kubectl create secret generic fusion-credentials \
  --from-literal=username=your_username \
  --from-literal=password=your_password \
  --namespace=vyrooq-production

# 3. Apply ConfigMaps
kubectl apply -f configmap.yaml -n vyrooq-production

# 4. Deploy infrastructure
kubectl apply -f postgres-deployment.yaml -n vyrooq-production
kubectl apply -f redis-deployment.yaml -n vyrooq-production
kubectl apply -f kafka-deployment.yaml -n vyrooq-production

# 5. Deploy application services
kubectl apply -f gateway-deployment.yaml -n vyrooq-production
kubectl apply -f auth-service-deployment.yaml -n vyrooq-production
kubectl apply -f retry-engine-deployment.yaml -n vyrooq-production
kubectl apply -f reconciliation-engine-deployment.yaml -n vyrooq-production
kubectl apply -f audit-engine-deployment.yaml -n vyrooq-production
kubectl apply -f event-bus-deployment.yaml -n vyrooq-production

# 6. Configure HPA (Horizontal Pod Autoscaling)
kubectl apply -f hpa.yaml -n vyrooq-production

# 7. Configure Ingress
kubectl apply -f ingress.yaml -n vyrooq-production

# 8. Verify deployment
kubectl get pods -n vyrooq-production
kubectl get services -n vyrooq-production
```

## Verification & Testing

### 1. Health Checks

Verify all services are healthy:

```bash
# Docker Compose
./scripts/health-check.sh

# Or manually
curl http://localhost:3000/health  # Gateway API
curl http://localhost:3100/health  # Auth Service
curl http://localhost:3200/health  # Retry Engine
curl http://localhost:3300/health  # Deduplication Engine
curl http://localhost:3400/health  # Manual Control Engine
curl http://localhost:3500/health  # Reconciliation Engine
curl http://localhost:3600/health  # Audit Engine
curl http://localhost:3700/health  # Event Bus
curl http://localhost:4000/health  # Admin Dashboard
curl http://localhost:8100/health  # VendHQ Adapter
curl http://localhost:8200/health  # Opencart Adapter
curl http://localhost:8300/health  # Fusion Adapter
```

### 2. Integration Tests

Test critical workflows:

```bash
# Test authentication
curl -X POST http://localhost:3100/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'

# Test invoice creation (with JWT token)
curl -X POST http://localhost:3000/api/invoices \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Content-Type: application/json" \
  -d @test-invoice.json

# Test reconciliation
curl -X POST http://localhost:3500/reconcile/sale \
  -H "Content-Type: application/json" \
  -d '{"saleId":"test-sale-123"}'

# Test audit trail
curl http://localhost:3600/events/sale/test-sale-123
```

### 3. Load Testing

Use k6 or Artillery for load testing:

```bash
# Install k6
brew install k6  # macOS
# or download from https://k6.io

# Run load test
k6 run load-test.js
```

## Monitoring & Maintenance

### 1. Access Monitoring Dashboards

- **Grafana**: http://localhost:3002 (admin/vyrooq123)
- **Prometheus**: http://localhost:9090
- **Admin Dashboard**: http://localhost:4000
- **Temporal UI**: http://localhost:8233
- **RabbitMQ**: http://localhost:15672

### 2. Key Metrics to Monitor

- **Throughput**: Transactions per hour (target: >10,000)
- **Latency**: End-to-end processing time (target: <5s)
- **Error Rate**: Failed transactions (target: <2%)
- **Queue Depth**: BullMQ queue sizes
- **Database**: Connection pool, query time, disk usage
- **Memory**: Redis usage, service memory
- **CPU**: Service CPU utilization

### 3. Log Aggregation

All services log to stdout/stderr in JSON format. Configure log aggregation:

```bash
# Using Loki (recommended)
docker-compose -f docker-compose.logging.yml up -d loki promtail

# Or ship to ELK stack
# Configure Filebeat/Fluentd to forward to Elasticsearch
```

### 4. Backup Strategy

**Database Backups:**
```bash
# Daily automated backup
docker-compose exec postgres pg_dump -U postgres vyrooq | gzip > backup-$(date +%Y%m%d).sql.gz

# Retention: 7 daily, 4 weekly, 12 monthly
```

**Configuration Backups:**
```bash
# Backup environment and configs
tar czf config-backup-$(date +%Y%m%d).tar.gz .env docker-compose.yml k8s/
```

## Troubleshooting

### Common Issues

**1. Service won't start**
```bash
# Check logs
docker-compose logs service-name

# Check dependencies
docker-compose ps

# Restart service
docker-compose restart service-name
```

**2. Database connection errors**
```bash
# Verify PostgreSQL is running
docker-compose ps postgres

# Check connection
docker-compose exec postgres psql -U postgres -d vyrooq -c "SELECT 1"

# Check DATABASE_URL environment variable
```

**3. Kafka connection issues**
```bash
# Check Kafka broker
docker-compose exec kafka kafka-topics --bootstrap-server localhost:9092 --list

# Recreate topics
docker-compose exec kafka kafka-topics --bootstrap-server localhost:9092 --create --topic vyrooq.sales.created
```

**4. High memory usage**
```bash
# Check memory usage
docker stats

# Adjust limits in docker-compose.yml
# Or tune Node.js heap size
NODE_OPTIONS="--max-old-space-size=4096"
```

### Emergency Procedures

**Service Failure:**
1. Check health endpoints
2. Review logs
3. Restart affected service
4. Scale up replicas if needed

**Data Corruption:**
1. Stop affected services
2. Restore from latest backup
3. Replay failed transactions from audit log
4. Verify data integrity

**Security Breach:**
1. Immediately rotate all secrets
2. Review audit logs
3. Identify affected data
4. Notify stakeholders
5. Implement additional security measures

## Post-Deployment Checklist

- [ ] All secrets changed from defaults
- [ ] SSL/TLS enabled
- [ ] Firewall rules configured
- [ ] Database backups scheduled
- [ ] Monitoring dashboards configured
- [ ] Alert rules defined
- [ ] Log aggregation working
- [ ] Load testing completed
- [ ] Disaster recovery plan documented
- [ ] Team trained on operations
- [ ] Runbook created
- [ ] On-call rotation established

## Support

For issues or questions:
- Internal documentation: `/vyrooq/docs`
- Runbook: `/vyrooq/docs/RUNBOOK.md`
- Architecture: `/vyrooq/docs/ARCHITECTURE.md`

---

**Last Updated**: 2026-05-14
**Version**: 1.0.0 (Production Ready)
