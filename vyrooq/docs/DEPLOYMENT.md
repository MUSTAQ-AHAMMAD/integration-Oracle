# Vyrooq Deployment Guide

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Local Development Setup](#local-development-setup)
3. [Docker Deployment](#docker-deployment)
4. [Kubernetes Deployment](#kubernetes-deployment)
5. [Cloud Deployment](#cloud-deployment)
6. [Production Checklist](#production-checklist)

## Prerequisites

### Required Software

- **Operating System**: Windows 10/11, Windows Server 2019+, Linux, or macOS
- **Docker Desktop**: 24.0+ (Windows/Mac) or Docker Engine (Linux)
- **Node.js**: 22.0+ LTS
- **Python**: 3.13+
- **PostgreSQL**: 16+ (or Docker)
- **Redis**: 7+ (or Docker)

### Required Credentials

Before deployment, ensure you have:

- ✅ Oracle Fusion ERP credentials (username, password, hostname, region)
- ✅ VendHQ API token and domain
- ✅ Opencart API key (if applicable)
- ✅ Access to PostgreSQL database
- ✅ Access to Redis instance

## Local Development Setup

### Windows Installation

**Step 1: Clone Repository**

```powershell
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle\vyrooq
```

**Step 2: Run Setup Script (as Administrator)**

```powershell
# Right-click PowerShell, select "Run as Administrator"
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
.\scripts\windows-setup.ps1
```

The setup script will:
- Install all Node.js and Python dependencies
- Start Docker containers (PostgreSQL, Redis, RabbitMQ)
- Create database schema
- Generate environment configuration templates

**Step 3: Configure Environment Variables**

Edit `.env` files in each service directory:

```powershell
# Gateway API
notepad gateway-api\.env

# Workflow Engine
notepad workflow-engine\.env

# Fusion Adapter
notepad fusion-adapter\.env
```

Fill in your Oracle Fusion, VendHQ, and Opencart credentials.

**Step 4: Start Services**

```powershell
# Start all services
.\scripts\start-all-services.ps1

# Or start individually:
# Gateway API
cd gateway-api
npm run dev

# Workflow Engine
cd workflow-engine
python main.py

# Manual Control Engine
cd manual-control-engine
npm run dev
```

**Step 5: Verify Installation**

Open your browser and navigate to:

- API Documentation: http://localhost:3000/docs
- Health Check: http://localhost:3000/health
- Grafana Dashboard: http://localhost:3002 (user: admin, pass: vyrooq123)
- RabbitMQ Management: http://localhost:15672 (user: vyrooq, pass: vyrooq123)

### Linux/macOS Installation

```bash
# Clone repository
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/vyrooq

# Install Node.js dependencies
cd gateway-api && npm install && cd ..
cd retry-engine && npm install && cd ..
cd manual-control-engine && npm install && cd ..

# Install Python dependencies
cd workflow-engine && pip install -r requirements.txt && cd ..

# Start infrastructure with Docker
docker-compose up -d postgres redis rabbitmq kafka temporal

# Wait for services to be ready
sleep 10

# Initialize database
docker exec vyrooq-postgres psql -U postgres -d vyrooq -f /docker-entrypoint-initdb.d/001_initial_schema.sql

# Configure environment
cp .env.example .env
# Edit .env with your credentials

# Start application services
cd gateway-api && npm run dev &
cd workflow-engine && python main.py &
cd manual-control-engine && npm run dev &
```

## Docker Deployment

### Build All Images

```bash
docker-compose build
```

### Start Complete Stack

```bash
docker-compose up -d
```

### View Logs

```bash
# All services
docker-compose logs -f

# Specific service
docker-compose logs -f gateway-api
docker-compose logs -f workflow-engine
```

### Stop Services

```bash
docker-compose down
```

### Clean Up (Remove Volumes)

```bash
docker-compose down -v
```

## Kubernetes Deployment

### Prerequisites

- Kubernetes cluster (EKS, AKS, GKE, or local Minikube/Kind)
- kubectl configured and authenticated
- Helm 3+ installed

### Step 1: Create Namespace

```bash
kubectl create namespace vyrooq
kubectl config set-context --current --namespace=vyrooq
```

### Step 2: Create Secrets

```bash
# Create PostgreSQL secret
kubectl create secret generic postgres-credentials \
  --from-literal=username=postgres \
  --from-literal=password=vyrooq123 \
  --from-literal=database=vyrooq

# Create Fusion credentials secret
kubectl create secret generic fusion-credentials \
  --from-literal=base-url=https://your-instance.fa.region.oraclecloud.com \
  --from-literal=username=your-fusion-user \
  --from-literal=password=your-fusion-password

# Create VendHQ credentials secret
kubectl create secret generic vendhq-credentials \
  --from-literal=api-url=https://yourdomain.vendhq.com/api/2.0 \
  --from-literal=api-token=your-vendhq-token
```

### Step 3: Deploy Infrastructure

```bash
# Deploy PostgreSQL
kubectl apply -f k8s/postgres/

# Deploy Redis
kubectl apply -f k8s/redis/

# Deploy RabbitMQ
kubectl apply -f k8s/rabbitmq/

# Deploy Kafka
kubectl apply -f k8s/kafka/

# Deploy Temporal
kubectl apply -f k8s/temporal/
```

### Step 4: Deploy Application Services

```bash
# Deploy Gateway API
kubectl apply -f k8s/deployments/gateway-api.yaml

# Deploy Workflow Engine
kubectl apply -f k8s/deployments/workflow-engine.yaml

# Deploy Retry Engine
kubectl apply -f k8s/deployments/retry-engine.yaml

# Deploy Manual Control Engine
kubectl apply -f k8s/deployments/manual-control-engine.yaml
```

### Step 5: Deploy Ingress

```bash
kubectl apply -f k8s/ingress/ingress.yaml
```

### Step 6: Verify Deployment

```bash
# Check pod status
kubectl get pods

# Check services
kubectl get svc

# View logs
kubectl logs -f deployment/gateway-api
kubectl logs -f deployment/workflow-engine
```

## Cloud Deployment

### AWS EKS

```bash
# Create EKS cluster
eksctl create cluster \
  --name vyrooq-cluster \
  --region us-east-1 \
  --nodegroup-name standard-workers \
  --node-type t3.medium \
  --nodes 3 \
  --nodes-min 2 \
  --nodes-max 5

# Configure kubectl
aws eks update-kubeconfig --region us-east-1 --name vyrooq-cluster

# Follow Kubernetes deployment steps above
```

### Azure AKS

```bash
# Create resource group
az group create --name vyrooq-rg --location eastus

# Create AKS cluster
az aks create \
  --resource-group vyrooq-rg \
  --name vyrooq-cluster \
  --node-count 3 \
  --node-vm-size Standard_D2s_v3 \
  --enable-managed-identity

# Get credentials
az aks get-credentials --resource-group vyrooq-rg --name vyrooq-cluster

# Follow Kubernetes deployment steps above
```

### Google GKE

```bash
# Create GKE cluster
gcloud container clusters create vyrooq-cluster \
  --zone us-central1-a \
  --num-nodes 3 \
  --machine-type n1-standard-2

# Get credentials
gcloud container clusters get-credentials vyrooq-cluster --zone us-central1-a

# Follow Kubernetes deployment steps above
```

## Production Checklist

### Security

- [ ] Change all default passwords
- [ ] Use strong JWT secret (32+ characters)
- [ ] Enable TLS/SSL for all external endpoints
- [ ] Store credentials in secrets manager (AWS Secrets Manager, Azure Key Vault, etc.)
- [ ] Enable network policies in Kubernetes
- [ ] Configure firewall rules
- [ ] Enable pod security policies
- [ ] Implement RBAC for API access

### Database

- [ ] Enable automated backups (daily minimum)
- [ ] Configure point-in-time recovery
- [ ] Set up replication (read replicas)
- [ ] Enable connection pooling
- [ ] Configure table partitioning maintenance
- [ ] Set up monitoring and alerts

### High Availability

- [ ] Deploy multiple replicas of each service (minimum 2)
- [ ] Configure horizontal pod autoscaling
- [ ] Set up load balancing
- [ ] Configure health checks
- [ ] Implement circuit breakers
- [ ] Set up disaster recovery plan

### Monitoring & Observability

- [ ] Configure Prometheus metrics collection
- [ ] Set up Grafana dashboards
- [ ] Enable distributed tracing (OpenTelemetry)
- [ ] Configure log aggregation (ELK or Loki)
- [ ] Set up alerts for critical errors
- [ ] Configure uptime monitoring
- [ ] Enable performance profiling

### Performance

- [ ] Configure Redis clustering
- [ ] Enable Kafka partitioning
- [ ] Optimize database indexes
- [ ] Configure connection pooling
- [ ] Enable response caching
- [ ] Set up CDN for static assets (if applicable)
- [ ] Load test the system

### Compliance

- [ ] Enable audit logging
- [ ] Configure data retention policies
- [ ] Implement data encryption at rest
- [ ] Enable encryption in transit
- [ ] Document security procedures
- [ ] Perform security audit

## Troubleshooting

### Service Won't Start

```bash
# Check logs
docker-compose logs gateway-api

# Check environment variables
docker-compose exec gateway-api env

# Verify database connection
docker-compose exec postgres psql -U postgres -d vyrooq -c "SELECT 1"
```

### Database Connection Errors

```bash
# Verify PostgreSQL is running
docker-compose ps postgres

# Check connection from container
docker-compose exec gateway-api nc -zv postgres 5432

# Reset database
docker-compose down -v
docker-compose up -d postgres
sleep 5
docker-compose exec postgres psql -U postgres -d vyrooq -f /docker-entrypoint-initdb.d/001_initial_schema.sql
```

### Temporal Workflow Errors

```bash
# Check Temporal server status
docker-compose logs temporal

# View Temporal UI
# Open http://localhost:8233

# Reset workflows
docker-compose restart temporal
```

## Performance Tuning

### Database Optimization

```sql
-- Analyze query performance
EXPLAIN ANALYZE SELECT * FROM sales WHERE status = 'pending';

-- Rebuild indexes
REINDEX TABLE sales;

-- Vacuum database
VACUUM ANALYZE;
```

### Redis Optimization

```bash
# Check memory usage
docker-compose exec redis redis-cli INFO memory

# Set max memory
docker-compose exec redis redis-cli CONFIG SET maxmemory 2gb
docker-compose exec redis redis-cli CONFIG SET maxmemory-policy allkeys-lru
```

## Support

For issues and support:

- GitHub Issues: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
- Documentation: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/wiki
- Email: support@vyrooq.com
