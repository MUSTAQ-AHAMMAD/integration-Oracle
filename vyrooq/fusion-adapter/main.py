"""
Oracle Fusion Adapter - FastAPI Microservice
Provides REST API endpoints for Oracle Fusion SOAP/REST operations
"""

from fastapi import FastAPI, HTTPException, status
from fastapi.responses import JSONResponse
from pydantic import BaseModel, Field
from typing import Dict, Any, Optional, List
import uvicorn
from loguru import logger
import sys
import os

from fusion_client import FusionAdapter

# Configure logging
logger.remove()
logger.add(sys.stderr, level=os.getenv("LOG_LEVEL", "INFO"))

# Create FastAPI app
app = FastAPI(
    title="Fusion Adapter API",
    description="Oracle Fusion ERP SOAP/REST Adapter",
    version="1.0.0"
)

# Initialize Fusion client
fusion_client: Optional[FusionAdapter] = None


# Pydantic models
class InvoiceRequest(BaseModel):
    sales_order: str = Field(..., description="Sales order number")
    customer_name: str = Field(..., description="Customer name")
    invoice_date: str = Field(..., description="Invoice date (YYYY-MM-DD)")
    lines: List[Dict[str, Any]] = Field(..., description="Invoice lines")
    total_amount: float = Field(..., description="Total invoice amount")


class ReceiptRequest(BaseModel):
    receipt_number: str = Field(..., description="Receipt number")
    customer_name: str = Field(..., description="Customer name")
    receipt_date: str = Field(..., description="Receipt date (YYYY-MM-DD)")
    amount: float = Field(..., description="Receipt amount")
    payment_method: str = Field(..., description="Payment method")


class JournalRequest(BaseModel):
    journal_name: str = Field(..., description="Journal entry name")
    journal_date: str = Field(..., description="Journal date (YYYY-MM-DD)")
    lines: List[Dict[str, Any]] = Field(..., description="Journal lines")


class InventoryRequest(BaseModel):
    transaction_type: str = Field(..., description="Transaction type")
    item_code: str = Field(..., description="Item code")
    quantity: float = Field(..., description="Quantity")
    organization: str = Field(..., description="Organization name")


@app.on_event("startup")
async def startup_event():
    """Initialize Fusion client on startup"""
    global fusion_client

    base_url = os.getenv("FUSION_BASE_URL")
    username = os.getenv("FUSION_USERNAME")
    password = os.getenv("FUSION_PASSWORD")

    if not all([base_url, username, password]):
        logger.error("Missing Oracle Fusion credentials")
        raise RuntimeError("FUSION_BASE_URL, FUSION_USERNAME, and FUSION_PASSWORD must be set")

    fusion_client = FusionAdapter(base_url, username, password)
    logger.info(f"Fusion Adapter initialized for {base_url}")


@app.get("/health")
async def health_check():
    """Health check endpoint"""
    return {"status": "healthy", "service": "fusion-adapter", "version": "1.0.0"}


@app.get("/ready")
async def readiness_check():
    """Readiness check endpoint"""
    if fusion_client is None:
        raise HTTPException(status_code=503, detail="Fusion client not initialized")
    return {"status": "ready", "service": "fusion-adapter"}


@app.post("/invoices", status_code=status.HTTP_201_CREATED)
async def create_invoice(invoice: InvoiceRequest):
    """
    Create invoice in Oracle Fusion
    """
    try:
        result = await fusion_client.create_invoice(invoice.dict())
        return {
            "success": True,
            "invoice_number": result.get("invoice_number"),
            "fusion_id": result.get("fusion_id"),
            "message": "Invoice created successfully"
        }
    except Exception as e:
        logger.error(f"Failed to create invoice: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.post("/receipts", status_code=status.HTTP_201_CREATED)
async def create_receipt(receipt: ReceiptRequest):
    """
    Create receipt in Oracle Fusion
    """
    try:
        result = await fusion_client.create_receipt(receipt.dict())
        return {
            "success": True,
            "receipt_number": result.get("receipt_number"),
            "fusion_id": result.get("fusion_id"),
            "message": "Receipt created successfully"
        }
    except Exception as e:
        logger.error(f"Failed to create receipt: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.post("/journals", status_code=status.HTTP_201_CREATED)
async def create_journal(journal: JournalRequest):
    """
    Create journal entry in Oracle Fusion
    """
    try:
        result = await fusion_client.create_journal(journal.dict())
        return {
            "success": True,
            "journal_name": result.get("journal_name"),
            "fusion_id": result.get("fusion_id"),
            "message": "Journal entry created successfully"
        }
    except Exception as e:
        logger.error(f"Failed to create journal: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.post("/inventory/transactions", status_code=status.HTTP_201_CREATED)
async def create_inventory_transaction(transaction: InventoryRequest):
    """
    Create inventory transaction in Oracle Fusion
    """
    try:
        result = await fusion_client.create_inventory_transaction(transaction.dict())
        return {
            "success": True,
            "transaction_id": result.get("transaction_id"),
            "message": "Inventory transaction created successfully"
        }
    except Exception as e:
        logger.error(f"Failed to create inventory transaction: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/customers/{customer_name}")
async def get_customer(customer_name: str):
    """
    Get customer from Oracle Fusion REST API
    """
    try:
        result = await fusion_client.get_customer(customer_name)
        return result
    except Exception as e:
        logger.error(f"Failed to get customer: {str(e)}")
        raise HTTPException(status_code=404, detail=str(e))


@app.get("/items/{item_code}")
async def get_item(item_code: str):
    """
    Get item from Oracle Fusion REST API
    """
    try:
        result = await fusion_client.get_item(item_code)
        return result
    except Exception as e:
        logger.error(f"Failed to get item: {str(e)}")
        raise HTTPException(status_code=404, detail=str(e))


if __name__ == "__main__":
    port = int(os.getenv("PORT", 8300))
    uvicorn.run(
        "main:app",
        host="0.0.0.0",
        port=port,
        log_level="info",
        access_log=True
    )
