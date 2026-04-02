# Odoo to Oracle Integration - Configuration and Testing Guide

## Overview

This guide explains how to configure the Odoo REST API integration to fetch POS orders, taxes, UOM, companies, and products, then push them to Oracle Fusion Cloud.

## Prerequisites

- Node.js 14+ installed
- Access to Odoo instance with REST API
- Oracle Fusion Cloud credentials
- API key for Odoo authentication

## Configuration Steps

### 1. Environment Configuration

Copy the `.env` file in the `oracle-crm` directory with your actual credentials:

```bash
cd oracle-crm
# The .env file has been pre-configured with the endpoints from your curl commands
```

Update the following critical values in `.env`:

```bash
# Odoo Configuration
ODOO_URL=https://ibrahimalquraishieu-26-2-26-29083802.dev.odoo.com
ODOO_AUTH_TYPE=x-api-key
ODOO_API_KEY=7a7bc3fdf48a67619ae828069cc82a64b345e868
ODOO_SESSION_ID=827cbcbb5520fc98015e0e385efdc8bcd62e33bc

# Oracle Fusion Configuration (UPDATE THESE!)
FUSION_BASE_URL=https://your-instance.fa.region.oraclecloud.com
FUSION_USERNAME=your-oracle-username
FUSION_PASSWORD=your-oracle-password
```

### 2. Install Dependencies

```bash
cd oracle-crm
npm install
```

### 3. Test the Configuration

Run the endpoint test script to verify all Odoo endpoints are working:

```bash
node test-endpoints.js
```

This will test:
- ✅ POS Orders (unified endpoint)
- ✅ Products
- ✅ UOM (Unit of Measure)
- ✅ Taxes
- ✅ Companies
- ✅ Branches
- ✅ POS List

Expected output:
```
🧪 Testing Odoo REST API Endpoints
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📋 Configuration:
   URL: https://ibrahimalquraishieu-26-2-26-29083802.dev.odoo.com
   Auth Type: x-api-key
   API Key: 7a7bc3fdf4...

📍 Testing Endpoints:

🔍 Testing: Products...
   ✅ Success! Found 150 records

...

📊 Test Results:
   ✅ Passed: 7
   ❌ Failed: 0
   📈 Total: 7
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🎉 All tests passed! Your Odoo REST API configuration is working correctly.
```

### 4. Start the Server

```bash
npm start
```

The server will start on port 3000 (or the port specified in `PORT` env variable).

## Available Endpoints

### Reference Data Endpoints

These endpoints fetch reference data from Odoo for configuration and diagnostics:

1. **GET /api/odoo/ref/products** - Fetch product catalogue
2. **GET /api/odoo/ref/uom** - Fetch UOM list
3. **GET /api/odoo/ref/taxes** - Fetch tax configuration
4. **GET /api/odoo/ref/companies** - Fetch companies
5. **GET /api/odoo/ref/branches** - Fetch branches/outlets
6. **GET /api/odoo/ref/poslist** - Fetch POS configuration list

### Data Synchronization Endpoints

1. **POST /api/odoo/fetch** - Fetch POS orders from Odoo and store in local DB
   ```json
   {
     "dateFrom": "2026-02-01",
     "dateTo": "2026-02-02",
     "companyId": 1
   }
   ```

2. **POST /api/odoo/push** - Push stored orders to Oracle Fusion
   ```json
   {
     "dateFrom": "2026-02-01",
     "dateTo": "2026-02-02",
     "mode": "ALL_STORES_DATE"
   }
   ```

3. **GET /api/odoo/jobs/:jobId** - Check job status and logs

## Complete Data Flow

### Step 1: Fetch Data from Odoo

```bash
curl -X POST http://localhost:3000/api/odoo/fetch \
  -H "Content-Type: application/json" \
  -d '{
    "dateFrom": "2026-02-01",
    "dateTo": "2026-02-02"
  }'
```

Response:
```json
{
  "jobId": "abc-123-def-456",
  "message": "Fetch job started"
}
```

### Step 2: Monitor Fetch Job

```bash
curl http://localhost:3000/api/odoo/jobs/abc-123-def-456
```

Response shows progress:
```json
{
  "jobId": "abc-123-def-456",
  "jobType": "FETCH",
  "status": "RUNNING",
  "total": 1500,
  "processed": 750,
  "logs": [
    {"level": "info", "message": "Fetched 500 orders..."},
    {"level": "info", "message": "Fetched 1000 orders..."}
  ]
}
```

### Step 3: Push Data to Oracle

Once fetch is complete:

```bash
curl -X POST http://localhost:3000/api/odoo/push \
  -H "Content-Type: application/json" \
  -d '{
    "dateFrom": "2026-02-01",
    "dateTo": "2026-02-02",
    "mode": "ALL_STORES_DATE",
    "metadata": {
      "businessUnit": "YOUR_BU",
      "orgId": 300000001234567,
      "customerId": 300000001234568
    }
  }'
```

### Step 4: Monitor Push Job

```bash
curl http://localhost:3000/api/odoo/jobs/def-456-ghi-789
```

## Troubleshooting

### Issue: "Authentication failed" or HTTP 401/403

**Solution:** Verify your API key in `.env`:
```bash
ODOO_API_KEY=your-correct-api-key-here
```

### Issue: "Endpoint returned HTML instead of JSON"

**Solution:** Check the endpoint paths in `.env`. Ensure they match your Odoo instance's API structure.

### Issue: No data returned from endpoints

**Solution:**
1. Verify the date range includes actual orders
2. Check company_id filter if using multi-company setup
3. Review logs: `LOG_LEVEL=debug npm start`

### Issue: Oracle push fails

**Solution:**
1. Verify Oracle credentials in `.env`
2. Ensure required metadata fields are provided (businessUnit, orgId, customerId)
3. Check Oracle connectivity: `curl -u username:password https://your-fusion-url/fscmRestApi/resources/11.13.18.05/invoiceLines`

## Data Mapping

### POS Order → Oracle Invoice

| Odoo Field | Oracle Field | Notes |
|------------|--------------|-------|
| `name` | `InvoiceNumber` | POS order reference |
| `date_order` | `TransactionDate` | Order date |
| `amount_total` | `InvoiceAmount` | Total amount |
| `partner_id` | `BillToCustomerId` | Customer ID |
| `warehouse_id` | Business Unit mapping | Via store metadata |

### Order Line → Oracle Invoice Line

| Odoo Field | Oracle Field | Notes |
|------------|--------------|-------|
| `product_id` | `ItemNumber` | Product SKU |
| `qty_delivered` | `InvoicedQuantity` | Quantity |
| `price_unit` | `UnitSellingPrice` | Unit price |
| `tax_id` | `TaxClassificationCode` | Tax mapping |

### Payment → Oracle Receipt

| Odoo Field | Oracle Field | Notes |
|------------|--------------|-------|
| `amount` | `Amount` | Payment amount |
| `journal_id` | `ReceiptMethod` | Payment method |
| `date` | `ReceiptDate` | Payment date |

## Advanced Configuration

### Using Unified POS Order Endpoint

If your Odoo instance supports the unified `/api/pos/order` endpoint (returns orders with embedded lines and payments):

```bash
# Already configured in .env:
ODOO_POS_ORDER_PATH=/api/pos/order
```

This provides better performance as it reduces API calls from 3 endpoints to 1.

### Configuring Store Metadata

Store metadata maps Odoo stores to Oracle business units:

```bash
curl -X PUT http://localhost:3000/api/odoo/store-metadata/123 \
  -H "Content-Type: application/json" \
  -d '{
    "businessUnit": "AE_BU",
    "subinventory": "AE_STORE_123",
    "orgId": 300000001234567,
    "customerId": 300000001234568,
    "customerType": "NORMAL"
  }'
```

## Monitoring and Logs

### Enable Debug Logging

```bash
LOG_LEVEL=debug npm start
```

### View Job History

```bash
curl http://localhost:3000/api/odoo/jobs
```

### Check Failed Records

```bash
curl http://localhost:3000/api/odoo/failed-records
```

Failed records can be retried:

```bash
curl -X POST http://localhost:3000/api/odoo/retry-failed
```

## Performance Tuning

### Concurrent Oracle Push

Adjust the number of concurrent Oracle API calls:

```bash
# In .env
ODOO_PUSH_CONCURRENCY=20  # Increase for faster pushes (10-20 recommended)
```

### Fetch Page Size

Adjust how many orders are fetched per page from Odoo:

```bash
# In .env
ODOO_FETCH_PAGE_SIZE=500  # Reduce if Odoo times out on large ranges
```

### Batch Size

Adjust SQLite batch processing size:

```bash
# In .env
PUSH_BATCH_SIZE=500  # Keeps memory usage flat
```

## Security Best Practices

1. **Never commit .env to git** - It contains sensitive credentials
2. **Rotate API keys regularly** - Update `ODOO_API_KEY` periodically
3. **Use environment-specific configs** - Separate dev/staging/prod credentials
4. **Enable HTTPS** - Use SSL for production deployments
5. **Restrict API access** - Use firewall rules to limit access to the CRM server

## Support and Documentation

- Main README: `/README.md`
- Calculations Guide: `/CALCULATIONS_AND_CMS_GUIDE.md`
- Oracle Migration Guide: `/ORACLE_MIGRATION_GUIDE.md`
- API Collection: `/API_Endpoints_Postman_Collection.json`

## Testing Checklist

Before going live, verify:

- [x] .env file configured with correct credentials
- [ ] All reference data endpoints return data (run `node test-endpoints.js`)
- [ ] Fetch job successfully retrieves orders
- [ ] Fetched orders are stored in SQLite database
- [ ] Push job successfully sends orders to Oracle
- [ ] No failed records (or failed records are investigated)
- [ ] Store metadata configured for all stores
- [ ] Oracle Fusion receives and processes invoices
- [ ] End-to-end test from Odoo → CRM → Oracle complete

## Next Steps

1. Run the test script: `node test-endpoints.js`
2. Start the server: `npm start`
3. Test fetch operation with a small date range
4. Verify data in SQLite: `sqlite3 data/odoo-crm.db "SELECT COUNT(*) FROM odoo_sales;"`
5. Test push operation to Oracle
6. Monitor job logs for any errors
7. Configure store metadata for all your stores
8. Run full production sync

## Common curl Commands for Testing

### Fetch orders for a specific date range
```bash
curl -X POST http://localhost:3000/api/odoo/fetch \
  -H "Content-Type: application/json" \
  -d '{"dateFrom": "2026-02-01", "dateTo": "2026-02-02"}'
```

### Check job status
```bash
curl http://localhost:3000/api/odoo/jobs/{jobId}
```

### Push to Oracle
```bash
curl -X POST http://localhost:3000/api/odoo/push \
  -H "Content-Type: application/json" \
  -d '{
    "dateFrom": "2026-02-01",
    "dateTo": "2026-02-02",
    "mode": "ALL_STORES_DATE"
  }'
```

### Get reference data
```bash
# Products
curl http://localhost:3000/api/odoo/ref/products

# Taxes
curl http://localhost:3000/api/odoo/ref/taxes

# UOM
curl http://localhost:3000/api/odoo/ref/uom

# Companies
curl http://localhost:3000/api/odoo/ref/companies
```

---

**Need Help?** Check the logs in the console or set `LOG_LEVEL=debug` for detailed information.
