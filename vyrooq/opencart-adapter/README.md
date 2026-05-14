# Opencart Adapter

REST API adapter for Opencart e-commerce platform integration in Vyrooq Platform.

## Features

- ✅ Fetch orders with filtering
- ✅ Update order status
- ✅ Fetch products and inventory
- ✅ Update product stock
- ✅ Fetch customers
- ✅ Session management with auto-renewal
- ✅ Health checks

## API Endpoints

### Orders

**GET /orders**
Fetch orders from Opencart.

Query Parameters:
- `status_id`: Filter by order status ID
- `customer_id`: Filter by customer ID
- `days`: Days to look back (default: 7)
- `limit`: Results per page (default: 100)
- `page`: Page number (default: 1)

**GET /orders/{order_id}**
Get specific order.

**POST /orders/{order_id}/status**
Update order status.

Request Body:
```json
{
  "status_id": 5,
  "comment": "Order shipped",
  "notify": true
}
```

### Products

**GET /products**
Fetch products.

Query Parameters:
- `limit`: Results per page
- `page`: Page number

**GET /products/{product_id}**
Get specific product.

**PUT /products/{product_id}/stock**
Update product stock.

Request Body:
```json
{
  "quantity": 100
}
```

### Customers

**GET /customers**
Fetch customers.

**GET /customers/{customer_id}**
Get specific customer.

### Configuration

**GET /order-statuses**
Get all order statuses.

### Health Checks

**GET /health** - Service health status
**GET /ready** - Readiness check

## Setup

1. Install dependencies:
```bash
pip install -r requirements.txt
```

2. Configure environment:
```bash
export OPENCART_URL=https://your-store.com
export OPENCART_API_KEY=your-api-key
export OPENCART_USERNAME=admin
export PORT=8200
```

3. Start service:
```bash
python src/main.py
```

## Environment Variables

```env
OPENCART_URL=https://your-store.com    # Opencart store URL
OPENCART_API_KEY=your-api-key          # API key
OPENCART_USERNAME=admin                 # API username
PORT=8200                               # Service port
```

## Getting Opencart API Credentials

1. Log in to Opencart admin panel
2. Navigate to System → Users → API
3. Create new API user or edit existing
4. Generate API key
5. Note the API username and key

## Usage Examples

### Fetch Recent Orders

```bash
# Last 7 days
curl "http://localhost:8200/orders"

# Last 30 days
curl "http://localhost:8200/orders?days=30"

# By status
curl "http://localhost:8200/orders?status_id=5"

# Pagination
curl "http://localhost:8200/orders?page=2&limit=50"
```

### Get Specific Order

```bash
curl http://localhost:8200/orders/123
```

### Update Order Status

```bash
curl -X POST http://localhost:8200/orders/123/status \
  -H "Content-Type: application/json" \
  -d '{
    "status_id": 5,
    "comment": "Order shipped via FedEx",
    "notify": true
  }'
```

### Fetch Products

```bash
curl "http://localhost:8200/products?limit=50&page=1"
```

### Update Product Stock

```bash
curl -X PUT http://localhost:8200/products/456/stock \
  -H "Content-Type: application/json" \
  -d '{"quantity": 100}'
```

### Fetch Customers

```bash
curl "http://localhost:8200/customers?limit=100"
```

## Integration Example

```python
import httpx

async def sync_order_status(order_id: int, status_id: int):
    async with httpx.AsyncClient() as client:
        response = await client.post(
            f"http://opencart-adapter:8200/orders/{order_id}/status",
            json={
                "status_id": status_id,
                "comment": "Updated from Oracle Fusion",
                "notify": True
            }
        )
        return response.json()
```

## Common Order Status IDs

| ID | Status |
|----|--------|
| 1  | Pending |
| 2  | Processing |
| 3  | Shipped |
| 5  | Complete |
| 7  | Canceled |
| 8  | Denied |
| 9  | Canceled Reversal |
| 10 | Failed |
| 11 | Refunded |
| 12 | Reversed |
| 13 | Chargeback |
| 14 | Expired |
| 15 | Processed |
| 16 | Voided |

## Error Handling

Standard HTTP status codes:
- `400`: Bad request
- `401`: Unauthorized (invalid API key)
- `404`: Resource not found
- `500`: Internal server error
- `503`: Service unavailable

## Docker

Build and run:

```bash
docker build -t vyrooq-opencart-adapter .
docker run -p 8200:8200 \
  -e OPENCART_URL=https://your-store.com \
  -e OPENCART_API_KEY=your-key \
  vyrooq-opencart-adapter
```

## License

MIT
