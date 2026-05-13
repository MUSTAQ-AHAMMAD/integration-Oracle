# Vyrooq - Quick Start Guide

Get Vyrooq running in 5 minutes!

## Windows Quick Start

```powershell
# 1. Clone repository
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle\vyrooq

# 2. Run setup (as Administrator)
.\scripts\windows-setup.ps1

# 3. Configure credentials
notepad .env

# 4. Start services
.\scripts\start-all-services.ps1

# 5. Open browser
start http://localhost:3000/docs
```

## Docker Quick Start

```bash
# 1. Clone repository
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle/vyrooq

# 2. Configure environment
cp .env.example .env
# Edit .env with your credentials

# 3. Start everything
docker-compose up -d

# 4. Wait for services to be ready (30 seconds)
sleep 30

# 5. Verify
curl http://localhost:3000/health
```

## Test the Integration

### Process a Sample Sale

```bash
curl -X POST http://localhost:3000/api/sales/process \
  -H "Content-Type: application/json" \
  -d '{
    "invoiceNumber": "TEST001",
    "saleDate": "2024-05-13T10:00:00Z",
    "outletId": "OUTLET1",
    "region": "AE",
    "customerType": "NORMAL",
    "totalPrice": 1000.00,
    "lineItems": [
      {
        "itemNumber": "ITEM001",
        "itemName": "Product 1",
        "quantity": 5,
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

### Check Sale Status

```bash
curl http://localhost:3000/api/sales/status/TEST001
```

## Access Services

| Service | URL | Credentials |
|---------|-----|-------------|
| API Documentation | http://localhost:3000/docs | - |
| Grafana Dashboards | http://localhost:3002 | admin / vyrooq123 |
| RabbitMQ Management | http://localhost:15672 | vyrooq / vyrooq123 |
| Temporal UI | http://localhost:8233 | - |
| Prometheus | http://localhost:9090 | - |

## Next Steps

1. Configure your Oracle Fusion credentials in `.env`
2. Configure your VendHQ API token in `.env`
3. Review the [Deployment Guide](docs/DEPLOYMENT.md)
4. Explore the [API Documentation](http://localhost:3000/docs)
5. Set up monitoring dashboards in Grafana

## Troubleshooting

**Services won't start:**
```bash
docker-compose down -v
docker-compose up -d
```

**Database errors:**
```bash
docker-compose exec postgres psql -U postgres -d vyrooq -c "SELECT 1"
```

**View logs:**
```bash
docker-compose logs -f gateway-api
```

## Support

- GitHub: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/issues
- Docs: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/wiki
