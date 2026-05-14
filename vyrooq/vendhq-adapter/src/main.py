"""
VendHQ Adapter Main Application
FastAPI service for VendHQ integration
"""

import logging
import os
from contextlib import asynccontextmanager
from fastapi import FastAPI, HTTPException, Query
from fastapi.middleware.cors import CORSMiddleware
from datetime import datetime, timedelta
from typing import Optional

from client.vendhq_client import VendHQClient

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s - %(name)s - %(levelname)s - %(message)s",
)
logger = logging.getLogger(__name__)

# Configuration
VENDHQ_DOMAIN = os.getenv("VENDHQ_DOMAIN_PREFIX", "")
VENDHQ_TOKEN = os.getenv("VENDHQ_ACCESS_TOKEN", "")

# Global client instance
vendhq_client: Optional[VendHQClient] = None


@asynccontextmanager
async def lifespan(app: FastAPI):
    """Startup and shutdown events"""
    global vendhq_client

    # Startup
    logger.info("Starting VendHQ Adapter...")
    if not VENDHQ_DOMAIN or not VENDHQ_TOKEN:
        logger.warning("VendHQ credentials not configured")
    else:
        vendhq_client = VendHQClient(VENDHQ_DOMAIN, VENDHQ_TOKEN)
        logger.info("VendHQ client initialized")

    yield

    # Shutdown
    if vendhq_client:
        await vendhq_client.close()
    logger.info("VendHQ Adapter stopped")


app = FastAPI(
    title="VendHQ Adapter",
    description="REST API adapter for VendHQ POS system",
    version="1.0.0",
    lifespan=lifespan,
)

# CORS
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.get("/health")
async def health_check():
    """Health check endpoint"""
    return {
        "status": "healthy",
        "service": "vendhq-adapter",
        "timestamp": datetime.utcnow().isoformat(),
    }


@app.get("/ready")
async def readiness_check():
    """Readiness check"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    is_ready = await vendhq_client.health_check()
    if not is_ready:
        raise HTTPException(status_code=503, detail="VendHQ API not accessible")

    return {
        "status": "ready",
        "checks": {"vendhq": "ok"},
    }


@app.get("/sales")
async def get_sales(
    since: Optional[str] = Query(None, description="ISO timestamp to fetch sales after"),
    outlet_id: Optional[str] = Query(None, description="Filter by outlet ID"),
    days: Optional[int] = Query(7, description="Number of days to fetch if since not provided"),
):
    """
    Fetch sales from VendHQ

    Args:
        since: ISO timestamp (e.g., 2024-05-01T00:00:00Z)
        outlet_id: Specific outlet ID
        days: Days to look back if since not provided

    Returns:
        List of sales
    """
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        # Parse since timestamp or use days
        since_dt = None
        if since:
            since_dt = datetime.fromisoformat(since.replace("Z", "+00:00"))
        else:
            since_dt = datetime.utcnow() - timedelta(days=days)

        sales = await vendhq_client.get_sales(since=since_dt, outlet_id=outlet_id)

        return {
            "count": len(sales),
            "sales": sales,
            "since": since_dt.isoformat(),
        }
    except Exception as e:
        logger.error(f"Error fetching sales: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/sales/{sale_id}")
async def get_sale(sale_id: str):
    """Get specific sale by ID"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        sale = await vendhq_client.get_sale(sale_id)
        return sale
    except Exception as e:
        logger.error(f"Error fetching sale {sale_id}: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/products")
async def get_products(
    since: Optional[str] = Query(None, description="ISO timestamp"),
    days: Optional[int] = Query(None, description="Days to look back"),
):
    """Fetch products from VendHQ"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        since_dt = None
        if since:
            since_dt = datetime.fromisoformat(since.replace("Z", "+00:00"))
        elif days:
            since_dt = datetime.utcnow() - timedelta(days=days)

        products = await vendhq_client.get_products(since=since_dt)

        return {
            "count": len(products),
            "products": products,
        }
    except Exception as e:
        logger.error(f"Error fetching products: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/products/{product_id}")
async def get_product(product_id: str):
    """Get specific product by ID"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        product = await vendhq_client.get_product(product_id)
        return product
    except Exception as e:
        logger.error(f"Error fetching product {product_id}: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/customers")
async def get_customers(
    since: Optional[str] = Query(None, description="ISO timestamp"),
    days: Optional[int] = Query(None, description="Days to look back"),
):
    """Fetch customers from VendHQ"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        since_dt = None
        if since:
            since_dt = datetime.fromisoformat(since.replace("Z", "+00:00"))
        elif days:
            since_dt = datetime.utcnow() - timedelta(days=days)

        customers = await vendhq_client.get_customers(since=since_dt)

        return {
            "count": len(customers),
            "customers": customers,
        }
    except Exception as e:
        logger.error(f"Error fetching customers: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/outlets")
async def get_outlets():
    """Fetch all outlets"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        outlets = await vendhq_client.get_outlets()
        return {
            "count": len(outlets),
            "outlets": outlets,
        }
    except Exception as e:
        logger.error(f"Error fetching outlets: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/payment-types")
async def get_payment_types():
    """Fetch payment types"""
    if not vendhq_client:
        raise HTTPException(status_code=503, detail="VendHQ client not initialized")

    try:
        payment_types = await vendhq_client.get_payment_types()
        return {
            "count": len(payment_types),
            "payment_types": payment_types,
        }
    except Exception as e:
        logger.error(f"Error fetching payment types: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


if __name__ == "__main__":
    import uvicorn

    port = int(os.getenv("PORT", "8100"))
    uvicorn.run(app, host="0.0.0.0", port=port, log_level="info")
