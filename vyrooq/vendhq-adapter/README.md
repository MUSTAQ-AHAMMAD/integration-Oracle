# VendHQ Adapter

REST API adapter for VendHQ POS system integration in Vyrooq Platform.

## Features

- ✅ Fetch sales with pagination and filtering
- ✅ Fetch products and inventory
- ✅ Fetch customers
- ✅ Fetch outlets and registers
- ✅ Payment type management
- ✅ Product search
- ✅ Webhook support (register/list/delete)
- ✅ Automatic pagination handling
- ✅ Rate limit handling
- ✅ Health checks

## API Endpoints

### Sales

**GET /sales**
Fetch sales from VendHQ with optional filtering.

Query Parameters:
- `since`: ISO timestamp (e.g., `2024-05-01T00:00:00Z`)
- `outlet_id`: Filter by specific outlet
- `days`: Number of days to look back (default: 7)

Response:
```json
{
  "count": 150,
  "sales": [...],
  "since": "2024-05-01T00:00:00Z"
}
```

**GET /sales/{sale_id}**
Get specific sale by ID.

### Products

**GET /products**
Fetch all products.

Query Parameters:
- `since`: ISO timestamp
- `days`: Days to look back

**GET /products/{product_id}**
Get specific product by ID.

### Customers

**GET /customers**
Fetch all customers.

Query Parameters:
- `since`: ISO timestamp
- `days`: Days to look back

### Outlets

**GET /outlets**
Fetch all outlets (stores).

**GET /payment-types**
Fetch configured payment types.

### Health Checks

**GET /health** - Service health status
**GET /ready** - Readiness check (includes VendHQ API connectivity)

## Setup

1. Install dependencies:
```bash
pip install -r requirements.txt
```

2. Configure environment:
```bash
export VENDHQ_DOMAIN_PREFIX=your-domain
export VENDHQ_ACCESS_TOKEN=your-token
export PORT=8100
```

3. Start service:
```bash
python src/main.py
```

## Environment Variables

```env
VENDHQ_DOMAIN_PREFIX=your-domain      # VendHQ domain (e.g., mystore)
VENDHQ_ACCESS_TOKEN=your-token        # VendHQ API token
PORT=8100                              # Service port
```

## Getting VendHQ Credentials

1. Log in to VendHQ admin panel
2. Navigate to Setup → API Access
3. Generate new Personal Access Token
4. Note your domain prefix from the URL (e.g., `mystore` from `mystore.vendhq.com`)

## Usage Examples

### Fetch Recent Sales

```bash
# Last 7 days (default)
curl http://localhost:8100/sales

# Last 30 days
curl "http://localhost:8100/sales?days=30"

# Since specific date
curl "http://localhost:8100/sales?since=2024-05-01T00:00:00Z"

# Specific outlet
curl "http://localhost:8100/sales?outlet_id=abc-123"
```

### Get Specific Sale

```bash
curl http://localhost:8100/sales/sale-id-123
```

### Fetch Products

```bash
# All products updated in last 7 days
curl "http://localhost:8100/products?days=7"

# All products
curl http://localhost:8100/products
```

### Fetch Customers

```bash
curl http://localhost:8100/customers
```

### Fetch Outlets

```bash
curl http://localhost:8100/outlets
```

## Integration with Workflow Engine

```python
import httpx

async def fetch_sales_for_processing():
    async with httpx.AsyncClient() as client:
        # Fetch sales from last day
        response = await client.get(
            "http://vendhq-adapter:8100/sales",
            params={"days": 1}
        )
        data = response.json()

        # Process each sale
        for sale in data["sales"]:
            await process_sale(sale)
```

## Pagination

The adapter automatically handles VendHQ's pagination:
- Fetches up to 200 records per request (VendHQ limit)
- Continues pagination until all records retrieved
- Uses `version` tokens for cursor-based pagination

## Rate Limiting

VendHQ API has rate limits:
- Standard: 1000 requests per minute
- The client includes built-in retry logic
- Exponential backoff on rate limit errors

## Error Handling

All errors return standard HTTP status codes:
- `400`: Bad request (invalid parameters)
- `401`: Unauthorized (invalid token)
- `404`: Resource not found
- `429`: Rate limit exceeded
- `500`: Internal server error
- `503`: Service unavailable (VendHQ not accessible)

## Development

### Run with auto-reload

```bash
uvicorn src.main:app --reload --port 8100
```

### Run tests

```bash
pytest tests/
```

### Lint code

```bash
pylint src/
black src/
```

## Docker

Build and run:

```bash
docker build -t vyrooq-vendhq-adapter .
docker run -p 8100:8100 \
  -e VENDHQ_DOMAIN_PREFIX=mystore \
  -e VENDHQ_ACCESS_TOKEN=token \
  vyrooq-vendhq-adapter
```

## Performance

- Typical API response time: 200-500ms
- Pagination: Automatically handles large datasets
- Concurrent requests: FastAPI async support
- Memory efficient: Streaming responses

## License

MIT
