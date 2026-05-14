"""
VendHQ REST API Client
Handles all interactions with VendHQ POS system
"""

import httpx
import logging
from typing import Optional, List, Dict, Any
from datetime import datetime, timedelta
from .models import Sale, Product, Customer

logger = logging.getLogger(__name__)


class VendHQClient:
    """VendHQ REST API client"""

    def __init__(
        self,
        domain_prefix: str,
        access_token: str,
        timeout: int = 30,
    ):
        self.base_url = f"https://{domain_prefix}.vendhq.com/api/2.0"
        self.access_token = access_token
        self.timeout = timeout
        self.client = httpx.AsyncClient(
            base_url=self.base_url,
            headers={
                "Authorization": f"Bearer {access_token}",
                "Content-Type": "application/json",
                "Accept": "application/json",
            },
            timeout=timeout,
        )

    async def close(self):
        """Close HTTP client"""
        await self.client.aclose()

    async def _request(
        self,
        method: str,
        endpoint: str,
        params: Optional[Dict[str, Any]] = None,
        json: Optional[Dict[str, Any]] = None,
    ) -> Dict[str, Any]:
        """Make HTTP request to VendHQ API"""
        try:
            response = await self.client.request(
                method=method,
                url=endpoint,
                params=params,
                json=json,
            )
            response.raise_for_status()
            return response.json()
        except httpx.HTTPStatusError as e:
            logger.error(f"VendHQ API error: {e.response.status_code} - {e.response.text}")
            raise
        except Exception as e:
            logger.error(f"VendHQ request failed: {str(e)}")
            raise

    async def get_sales(
        self,
        since: Optional[datetime] = None,
        outlet_id: Optional[str] = None,
        page_size: int = 200,
    ) -> List[Dict[str, Any]]:
        """
        Fetch sales from VendHQ

        Args:
            since: Get sales after this timestamp
            outlet_id: Filter by specific outlet
            page_size: Number of results per page (max 200)

        Returns:
            List of sales
        """
        params = {
            "page_size": min(page_size, 200),
        }

        if since:
            # VendHQ expects ISO 8601 format with timezone
            params["after"] = since.isoformat()

        if outlet_id:
            params["outlet_id"] = outlet_id

        all_sales = []
        version = None

        while True:
            if version:
                params["after"] = version

            data = await self._request("GET", "/sales", params=params)

            sales = data.get("data", [])
            all_sales.extend(sales)

            # Check for pagination
            version = data.get("version", {}).get("max")
            if not version or len(sales) < page_size:
                break

            logger.info(f"Fetched {len(sales)} sales, continuing pagination...")

        logger.info(f"Total sales fetched: {len(all_sales)}")
        return all_sales

    async def get_sale(self, sale_id: str) -> Dict[str, Any]:
        """Get specific sale by ID"""
        data = await self._request("GET", f"/sales/{sale_id}")
        return data.get("data", {})

    async def get_products(
        self,
        since: Optional[datetime] = None,
        page_size: int = 200,
    ) -> List[Dict[str, Any]]:
        """
        Fetch products from VendHQ

        Args:
            since: Get products updated after this timestamp
            page_size: Number of results per page

        Returns:
            List of products
        """
        params = {
            "page_size": min(page_size, 200),
        }

        if since:
            params["after"] = since.isoformat()

        all_products = []
        version = None

        while True:
            if version:
                params["after"] = version

            data = await self._request("GET", "/products", params=params)

            products = data.get("data", [])
            all_products.extend(products)

            version = data.get("version", {}).get("max")
            if not version or len(products) < page_size:
                break

        logger.info(f"Total products fetched: {len(all_products)}")
        return all_products

    async def get_product(self, product_id: str) -> Dict[str, Any]:
        """Get specific product by ID"""
        data = await self._request("GET", f"/products/{product_id}")
        return data.get("data", {})

    async def get_customers(
        self,
        since: Optional[datetime] = None,
        page_size: int = 200,
    ) -> List[Dict[str, Any]]:
        """Fetch customers from VendHQ"""
        params = {
            "page_size": min(page_size, 200),
        }

        if since:
            params["after"] = since.isoformat()

        all_customers = []
        version = None

        while True:
            if version:
                params["after"] = version

            data = await self._request("GET", "/customers", params=params)

            customers = data.get("data", [])
            all_customers.extend(customers)

            version = data.get("version", {}).get("max")
            if not version or len(customers) < page_size:
                break

        logger.info(f"Total customers fetched: {len(all_customers)}")
        return all_customers

    async def get_outlets(self) -> List[Dict[str, Any]]:
        """Fetch all outlets (stores)"""
        data = await self._request("GET", "/outlets")
        return data.get("data", [])

    async def get_registers(self, outlet_id: Optional[str] = None) -> List[Dict[str, Any]]:
        """Fetch registers (cash registers/POS terminals)"""
        params = {}
        if outlet_id:
            params["outlet_id"] = outlet_id

        data = await self._request("GET", "/registers", params=params)
        return data.get("data", [])

    async def get_payment_types(self) -> List[Dict[str, Any]]:
        """Fetch payment types configured in VendHQ"""
        data = await self._request("GET", "/payment_types")
        return data.get("data", [])

    async def search_products(
        self,
        query: str,
        page_size: int = 50,
    ) -> List[Dict[str, Any]]:
        """
        Search products by name or SKU

        Args:
            query: Search query
            page_size: Number of results

        Returns:
            List of matching products
        """
        params = {
            "query": query,
            "page_size": min(page_size, 200),
        }

        data = await self._request("GET", "/search", params=params)
        return data.get("data", [])

    async def webhook_register(
        self,
        webhook_url: str,
        events: List[str],
        active: bool = True,
    ) -> Dict[str, Any]:
        """
        Register webhook for VendHQ events

        Args:
            webhook_url: URL to receive webhooks
            events: List of event types (e.g., 'sale.update', 'product.update')
            active: Whether webhook is active

        Returns:
            Webhook registration details
        """
        payload = {
            "url": webhook_url,
            "events": events,
            "active": active,
        }

        data = await self._request("POST", "/webhooks", json=payload)
        return data.get("data", {})

    async def webhook_list(self) -> List[Dict[str, Any]]:
        """List all registered webhooks"""
        data = await self._request("GET", "/webhooks")
        return data.get("data", [])

    async def webhook_delete(self, webhook_id: str) -> bool:
        """Delete webhook"""
        try:
            await self._request("DELETE", f"/webhooks/{webhook_id}")
            return True
        except Exception as e:
            logger.error(f"Failed to delete webhook: {str(e)}")
            return False

    async def get_inventory(
        self,
        outlet_id: Optional[str] = None,
        product_id: Optional[str] = None,
    ) -> List[Dict[str, Any]]:
        """
        Get inventory levels

        Args:
            outlet_id: Filter by outlet
            product_id: Filter by product

        Returns:
            List of inventory records
        """
        params = {}
        if outlet_id:
            params["outlet_id"] = outlet_id
        if product_id:
            params["product_id"] = product_id

        data = await self._request("GET", "/consignments/products", params=params)
        return data.get("data", [])

    async def health_check(self) -> bool:
        """Check if VendHQ API is accessible"""
        try:
            await self._request("GET", "/outlets")
            return True
        except Exception as e:
            logger.error(f"VendHQ health check failed: {str(e)}")
            return False
