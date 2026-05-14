"""
Pydantic models for VendHQ entities
"""

from typing import Optional, List, Dict, Any
from datetime import datetime
from pydantic import BaseModel, Field


class SaleLineItem(BaseModel):
    """Sale line item (product sold)"""

    id: str
    product_id: str
    quantity: float
    price: float
    tax: float
    discount: float
    cost: float
    loyalty_value: float = 0
    note: Optional[str] = None
    status: str  # CONFIRMED, ONHOLD, LAYBY, etc.


class SalePayment(BaseModel):
    """Payment made on sale"""

    id: str
    retailer_payment_type_id: str
    payment_type_id: str
    name: str  # Cash, Credit Card, etc.
    amount: float
    payment_date: datetime


class Sale(BaseModel):
    """VendHQ Sale"""

    id: str
    source_id: Optional[str] = None
    register_id: str
    outlet_id: str
    customer_id: Optional[str] = None
    sale_date: datetime
    created_at: datetime
    updated_at: datetime
    status: str  # CLOSED, OPEN, LAYBY, etc.
    note: Optional[str] = None
    short_code: str
    return_for: Optional[str] = None  # Original sale ID if this is a return
    total_price: float
    total_tax: float
    total_loyalty: float
    total_discount: float
    line_items: List[SaleLineItem] = []
    payments: List[SalePayment] = []


class Product(BaseModel):
    """VendHQ Product"""

    id: str
    name: str
    sku: Optional[str] = None
    handle: Optional[str] = None
    description: Optional[str] = None
    variant_parent_id: Optional[str] = None
    supply_price: float = 0
    retail_price: float = 0
    tags: List[str] = []
    brand_name: Optional[str] = None
    supplier_name: Optional[str] = None
    active: bool = True
    created_at: datetime
    updated_at: datetime


class Customer(BaseModel):
    """VendHQ Customer"""

    id: str
    customer_code: Optional[str] = None
    first_name: Optional[str] = None
    last_name: Optional[str] = None
    email: Optional[str] = None
    phone: Optional[str] = None
    mobile: Optional[str] = None
    company_name: Optional[str] = None
    physical_address1: Optional[str] = None
    physical_city: Optional[str] = None
    physical_country_id: Optional[str] = None
    created_at: datetime
    updated_at: datetime


class Outlet(BaseModel):
    """VendHQ Outlet (Store)"""

    id: str
    name: str
    outlet_code: Optional[str] = None
    physical_address1: Optional[str] = None
    physical_city: Optional[str] = None
    physical_country_id: Optional[str] = None
    time_zone: str
    created_at: datetime
    updated_at: datetime
