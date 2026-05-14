"""
Opencart Adapter Main Application
FastAPI service for Opencart integration
"""

import logging
import os
from contextlib import asynccontextmanager
from fastapi import FastAPI, HTTPException, Query
from fastapi.middleware.cors import CORSMiddleware
from datetime import datetime, timedelta
from typing import Optional

from client.opencart_client import OpencartClient

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s - %(name)s - %(levelname)s - %(message)s",
)
logger = logging.getLogger(__name__)

# Configuration
OPENCART_URL = os.getenv("OPENCART_URL", "")
OPENCART_API_KEY = os.getenv("OPENCART_API_KEY", "")
OPENCART_USERNAME = os.getenv("OPENCART_USERNAME", "admin")

opencart_client: Optional[OpencartClient] = None


@asynccontextmanager
async def lifespan(app: FastAPI):
    """Startup and shutdown events"""
    global opencart_client

    logger.info("Starting Opencart Adapter...")
    if not OPENCART_URL or not OPENCART_API_KEY:
        logger.warning("Opencart credentials not configured")
    else:
        opencart_client = OpencartClient(OPENCART_URL, OPENCART_API_KEY, OPENCART_USERNAME)
        logger.info("Opencart client initialized")

    yield

    if opencart_client:
        await opencart_client.close()
    logger.info("Opencart Adapter stopped")


app = FastAPI(
    title="Opencart Adapter",
    description="REST API adapter for Opencart e-commerce platform",
    version="1.0.0",
    lifespan=lifespan,
)

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.get("/health")
async def health_check():
    """Health check"""
    return {
        "status": "healthy",
        "service": "opencart-adapter",
        "timestamp": datetime.utcnow().isoformat(),
    }


@app.get("/ready")
async def readiness_check():
    """Readiness check"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    is_ready = await opencart_client.health_check()
    if not is_ready:
        raise HTTPException(status_code=503, detail="Opencart API not accessible")

    return {"status": "ready", "checks": {"opencart": "ok"}}


@app.get("/orders")
async def get_orders(
    status_id: Optional[int] = Query(None),
    customer_id: Optional[int] = Query(None),
    days: Optional[int] = Query(7),
    limit: int = Query(100),
    page: int = Query(1),
):
    """Fetch orders from Opencart"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        date_from = datetime.utcnow() - timedelta(days=days) if days else None
        orders = await opencart_client.get_orders(
            status_id=status_id,
            customer_id=customer_id,
            date_from=date_from,
            limit=limit,
            page=page,
        )

        return {"count": len(orders), "orders": orders, "page": page, "limit": limit}
    except Exception as e:
        logger.error(f"Error fetching orders: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/orders/{order_id}")
async def get_order(order_id: int):
    """Get specific order"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        order = await opencart_client.get_order(order_id)
        return order
    except Exception as e:
        logger.error(f"Error fetching order {order_id}: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.post("/orders/{order_id}/status")
async def update_order_status(
    order_id: int,
    status_id: int,
    comment: Optional[str] = None,
    notify: bool = False,
):
    """Update order status"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        success = await opencart_client.update_order_status(
            order_id, status_id, comment, notify
        )
        return {"success": success, "order_id": order_id, "status_id": status_id}
    except Exception as e:
        logger.error(f"Error updating order status: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/products")
async def get_products(limit: int = Query(100), page: int = Query(1)):
    """Fetch products"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        products = await opencart_client.get_products(limit=limit, page=page)
        return {"count": len(products), "products": products, "page": page, "limit": limit}
    except Exception as e:
        logger.error(f"Error fetching products: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/products/{product_id}")
async def get_product(product_id: int):
    """Get specific product"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        product = await opencart_client.get_product(product_id)
        return product
    except Exception as e:
        logger.error(f"Error fetching product {product_id}: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.put("/products/{product_id}/stock")
async def update_product_stock(product_id: int, quantity: int):
    """Update product stock"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        success = await opencart_client.update_product_stock(product_id, quantity)
        return {"success": success, "product_id": product_id, "quantity": quantity}
    except Exception as e:
        logger.error(f"Error updating product stock: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/customers")
async def get_customers(limit: int = Query(100), page: int = Query(1)):
    """Fetch customers"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        customers = await opencart_client.get_customers(limit=limit, page=page)
        return {"count": len(customers), "customers": customers, "page": page, "limit": limit}
    except Exception as e:
        logger.error(f"Error fetching customers: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/customers/{customer_id}")
async def get_customer(customer_id: int):
    """Get specific customer"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        customer = await opencart_client.get_customer(customer_id)
        return customer
    except Exception as e:
        logger.error(f"Error fetching customer {customer_id}: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/order-statuses")
async def get_order_statuses():
    """Get all order statuses"""
    if not opencart_client:
        raise HTTPException(status_code=503, detail="Opencart client not initialized")

    try:
        statuses = await opencart_client.get_order_statuses()
        return {"count": len(statuses), "statuses": statuses}
    except Exception as e:
        logger.error(f"Error fetching order statuses: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


if __name__ == "__main__":
    import uvicorn

    port = int(os.getenv("PORT", "8200"))
    uvicorn.run(app, host="0.0.0.0", port=port, log_level="info")
