# Oracle CRM - Production Deployment Guide

## Overview

This guide provides step-by-step instructions for deploying Oracle CRM to production environments.

## Prerequisites

### System Requirements
- **Node.js**: >= 18.0.0
- **RAM**: Minimum 2GB, Recommended 4GB
- **Disk**: Minimum 10GB available
- **OS**: Linux (Ubuntu 20.04+ recommended), macOS, or Windows Server

### Required Software
- Docker 20.10+ (for containerized deployment)
- Docker Compose 2.0+ (optional, for orchestrated deployment)
- Git
- SSL certificates (for HTTPS)

### Environment Setup
- Access to Oracle Fusion ERP instance
- Odoo instance (if using Odoo integration)
- SMTP server (for email notifications)

## Deployment Methods

### Method 1: Docker Deployment (Recommended)

#### 1. Clone Repository
```bash
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/oracle-crm
```

#### 2. Configure Environment
```bash
cp .env.example .env
```

Edit `.env` file with production values:
```env
NODE_ENV=production
PORT=3000
JWT_SECRET=<your-strong-jwt-secret-here>
LOG_LEVEL=info

# Oracle Fusion Credentials
ORACLE_BASE_URL=https://your-oracle-instance.oraclecloud.com
ORACLE_USERNAME=your_username
ORACLE_PASSWORD=your_password

# Odoo Credentials (if applicable)
ODOO_URL=https://your-odoo-instance.com
ODOO_DB=your_database
ODOO_USERNAME=your_username
ODOO_PASSWORD=your_password

# Database
DB_PATH=/app/data/crm.db

# Email Configuration
SMTP_HOST=smtp.example.com
SMTP_PORT=587
SMTP_USER=notifications@example.com
SMTP_PASSWORD=your_smtp_password
```

#### 3. Build Docker Image
```bash
docker build -t oracle-crm:latest .
```

#### 4. Run Container
```bash
docker run -d \
  --name oracle-crm \
  -p 3000:3000 \
  --env-file .env \
  -v $(pwd)/data:/app/data \
  -v $(pwd)/logs:/app/logs \
  --restart unless-stopped \
  oracle-crm:latest
```

Or use Docker Compose:
```bash
docker-compose up -d
```

#### 5. Verify Deployment
```bash
# Check container status
docker ps

# Check logs
docker logs oracle-crm

# Test health endpoint
curl http://localhost:3000/api/health
```

### Method 2: Direct Node.js Deployment

#### 1. Install Dependencies
```bash
cd oracle-crm
npm ci --only=production
```

#### 2. Configure Environment
```bash
cp .env.example .env
# Edit .env with production values
```

#### 3. Start Application
```bash
# Using PM2 (recommended for production)
npm install -g pm2
pm2 start server.js --name oracle-crm

# Or using systemd
sudo systemctl start oracle-crm
```

## Post-Deployment Configuration

### 1. Change Default Credentials

**CRITICAL**: Change default admin passwords immediately after first login:

Default credentials:
- Username: `superadmin` / Password: `SuperAdmin@1234`
- Username: `admin` / Password: `Admin@1234`

Login and navigate to: **Users** → **Edit User** → **Change Password**

### 2. Configure SSL/TLS

#### Using Nginx Reverse Proxy

```nginx
server {
    listen 443 ssl http2;
    server_name your-domain.com;

    ssl_certificate /etc/ssl/certs/your-cert.crt;
    ssl_certificate_key /etc/ssl/private/your-key.key;

    ssl_protocols TLSv1.2 TLSv1.3;
    ssl_ciphers HIGH:!aNULL:!MD5;

    location / {
        proxy_pass http://localhost:3000;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection 'upgrade';
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}
```

### 3. Configure Backup Strategy

#### Database Backup
```bash
# Create backup script
cat > /opt/oracle-crm/backup.sh << 'EOF'
#!/bin/bash
BACKUP_DIR="/backups/oracle-crm"
DATE=$(date +%Y%m%d_%H%M%S)
mkdir -p $BACKUP_DIR

# Backup SQLite database
cp /app/data/crm.db "$BACKUP_DIR/crm_$DATE.db"

# Backup logs
tar -czf "$BACKUP_DIR/logs_$DATE.tar.gz" /app/logs/

# Keep only last 30 days of backups
find $BACKUP_DIR -type f -mtime +30 -delete

echo "Backup completed: $DATE"
EOF

chmod +x /opt/oracle-crm/backup.sh

# Schedule via cron
crontab -e
# Add: 0 2 * * * /opt/oracle-crm/backup.sh
```

### 4. Configure Monitoring

#### Health Check Monitoring
```bash
# Add to monitoring tool (e.g., Prometheus, Nagios)
curl -f http://localhost:3000/api/health || exit 1
```

#### Log Monitoring
```bash
# Monitor application logs
tail -f /app/logs/combined.log

# Set up log aggregation (ELK, Splunk, etc.)
```

## Production Checklist

### Security
- [ ] Changed default admin passwords
- [ ] Strong JWT_SECRET configured
- [ ] SSL/TLS enabled with valid certificates
- [ ] Rate limiting configured
- [ ] Security headers enabled (helmet)
- [ ] CORS properly configured
- [ ] Firewall rules configured
- [ ] Database file permissions restricted

### Performance
- [ ] Production NODE_ENV set
- [ ] Appropriate resource limits set
- [ ] Database indexes optimized
- [ ] Log rotation configured
- [ ] Static asset caching configured

### Reliability
- [ ] Health check endpoints tested
- [ ] Backup strategy implemented
- [ ] Monitoring configured
- [ ] Alerting rules set up
- [ ] Disaster recovery plan documented
- [ ] Auto-restart configured (systemd/PM2/Docker restart policy)

### Operations
- [ ] Access logs configured
- [ ] Error tracking set up
- [ ] Documentation reviewed
- [ ] Team trained on deployment
- [ ] Runbook created
- [ ] Incident response plan ready

## Kubernetes Deployment

### 1. Create Namespace
```bash
kubectl create namespace oracle-crm
```

### 2. Create ConfigMap
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: oracle-crm-config
  namespace: oracle-crm
data:
  NODE_ENV: "production"
  PORT: "3000"
  LOG_LEVEL: "info"
```

### 3. Create Secret
```bash
kubectl create secret generic oracle-crm-secrets \
  --from-literal=JWT_SECRET=your-jwt-secret \
  --from-literal=ORACLE_PASSWORD=your-password \
  --namespace=oracle-crm
```

### 4. Deploy Application
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: oracle-crm
  namespace: oracle-crm
spec:
  replicas: 3
  selector:
    matchLabels:
      app: oracle-crm
  template:
    metadata:
      labels:
        app: oracle-crm
    spec:
      containers:
      - name: oracle-crm
        image: oracle-crm:latest
        ports:
        - containerPort: 3000
        envFrom:
        - configMapRef:
            name: oracle-crm-config
        - secretRef:
            name: oracle-crm-secrets
        livenessProbe:
          httpGet:
            path: /api/live
            port: 3000
          initialDelaySeconds: 30
          periodSeconds: 10
        readinessProbe:
          httpGet:
            path: /api/ready
            port: 3000
          initialDelaySeconds: 10
          periodSeconds: 5
        resources:
          requests:
            memory: "512Mi"
            cpu: "250m"
          limits:
            memory: "2Gi"
            cpu: "1000m"
        volumeMounts:
        - name: data
          mountPath: /app/data
        - name: logs
          mountPath: /app/logs
      volumes:
      - name: data
        persistentVolumeClaim:
          claimName: oracle-crm-data-pvc
      - name: logs
        emptyDir: {}
---
apiVersion: v1
kind: Service
metadata:
  name: oracle-crm-service
  namespace: oracle-crm
spec:
  selector:
    app: oracle-crm
  ports:
  - protocol: TCP
    port: 80
    targetPort: 3000
  type: LoadBalancer
```

## Troubleshooting

### Application Won't Start

**Check logs:**
```bash
docker logs oracle-crm
# or
journalctl -u oracle-crm -f
```

**Common issues:**
- Missing environment variables
- Port already in use
- Database permissions
- Memory constraints

### Database Connection Errors

**Verify database:**
```bash
ls -la data/crm.db
sqlite3 data/crm.db "SELECT count(*) FROM users;"
```

**Fix permissions:**
```bash
chmod 644 data/crm.db
chown node:node data/crm.db  # if using Docker
```

### Performance Issues

**Check resource usage:**
```bash
docker stats oracle-crm
# or
top -p $(pgrep -f "node server.js")
```

**Monitor slow queries:**
```bash
grep "slow query" logs/combined.log
```

## Scaling

### Horizontal Scaling
- Use load balancer (Nginx, HAProxy, AWS ALB)
- Multiple application instances
- Shared database via NFS or database server
- Session management with Redis

### Vertical Scaling
- Increase container/VM resources
- Optimize Node.js memory limits
- Database tuning

## Support

For production support:
- Documentation: `/docs`
- GitHub Issues: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
- Email: support@your-domain.com

## See Also

- [PRODUCTION_READINESS_CHECKLIST.md](./PRODUCTION_READINESS_CHECKLIST.md)
- [OPERATIONAL_RUNBOOK.md](./OPERATIONAL_RUNBOOK.md)
- [BACKUP_RECOVERY.md](./BACKUP_RECOVERY.md)
