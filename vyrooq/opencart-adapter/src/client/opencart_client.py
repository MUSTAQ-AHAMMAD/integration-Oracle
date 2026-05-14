"""
Opencart REST API Client
Handles all interactions with Opencart e-commerce platform
"""

import httpx
import logging
from typing import Optional, List, Dict, Any
from datetime import datetime

logger = logging.getLogger(__name__)


class OpencartClient:
    """Opencart REST API client"""

    def __init__(
        self,
        base_url: str,
        api_key: str,
        username: Optional[str] = None,
        timeout: int = 30,
    ):
        self.base_url = base_url.rstrip("/")
        self.api_key = api_key
        self.username = username or "admin"
        self.timeout = timeout
        self.client = httpx.AsyncClient(
            base_url=f"{self.base_url}/index.php?route=api",
            headers={
                "Content-Type": "application/json",
                "Accept": "application/json",
            },
            timeout=timeout,
        )
        self.session_id = None

    async def close(self):
        """Close HTTP client"""
        await self.client.aclose()

    async def _login(self):
        """Authenticate with Opencart API"""
        try:
            response = await self.client.post(
                "/login",
                data={
                    "username": self.username,
                    "key": self.api_key,
                },
            )
            response.raise_for_status()
            data = response.json()
            self.session_id = data.get("api_token") or data.get("session_id")
            logger.info("Opencart API session established")
        except Exception as e:
            logger.error(f"Opencart login failed: {str(e)}")
            raise

    async def _request(
        self,
        method: str,
        endpoint: str,
        params: Optional[Dict[str, Any]] = None,
        data: Optional[Dict[str, Any]] = None,
    ) -> Dict[str, Any]:
        """Make authenticated HTTP request"""
        if not self.session_id:
            await self._login()

        # Add session to params
        if params is None:
            params = {}
        params["api_token"] = self.session_id

        try:
            response = await self.client.request(
                method=method,
                url=endpoint,
                params=params,
                json=data,
            )
            response.raise_for_status()
            return response.json()
        except httpx.HTTPStatusError as e:
            if e.response.status_code == 401:
                # Session expired, re-login and retry
                await self._login()
                params["api_token"] = self.session_id
                response = await self.client.request(
                    method=method,
                    url=endpoint,
                    params=params,
                    json=data,
                )
                response.raise_for_status()
                return response.json()
            logger.error(f"Opencart API error: {e.response.status_code} - {e.response.text}")
            raise
        except Exception as e:
            logger.error(f"Opencart request failed: {str(e)}")
            raise

    async def get_orders(
        self,
        status_id: Optional[int] = None,
        customer_id: Optional[int] = None,
        date_from: Optional[datetime] = None,
        date_to: Optional[datetime] = None,
        limit: int = 100,
        page: int = 1,
    ) -> List[Dict[str, Any]]:
        """
        Fetch orders from Opencart

        Args:
            status_id: Filter by order status
            customer_id: Filter by customer
            date_from: Orders from this date
            date_to: Orders until this date
            limit: Results per page
            page: Page number

        Returns:
            List of orders
        """
        params = {
            "limit": limit,
            "page": page,
        }

        if status_id:
            params["filter_order_status_id"] = status_id
        if customer_id:
            params["filter_customer_id"] = customer_id
        if date_from:
            params["filter_date_added_from"] = date_from.strftime("%Y-%m-%d")
        if date_to:
            params["filter_date_added_to"] = date_to.strftime("%Y-%m-%d")

        data = await self._request("GET", "/order", params=params)
        return data.get("orders", [])

    async def get_order(self, order_id: int) -> Dict[str, Any]:
        """Get specific order by ID"""
        data = await self._request("GET", f"/order/{order_id}")
        return data.get("order", {})

    async def update_order_status(
        self,
        order_id: int,
        status_id: int,
        comment: Optional[str] = None,
        notify: bool = False,
    ) -> bool:
        """
        Update order status

        Args:
            order_id: Order ID
            status_id: New status ID
            comment: Optional comment
            notify: Send notification to customer

        Returns:
            Success boolean
        """
        payload = {
            "order_status_id": status_id,
            "notify": 1 if notify else 0,
        }

        if comment:
            payload["comment"] = comment

        try:
            await self._request("POST", f"/order/{order_id}/history", data=payload)
            return True
        except Exception as e:
            logger.error(f"Failed to update order status: {str(e)}")
            return False

    async def get_products(
        self,
        limit: int = 100,
        page: int = 1,
    ) -> List[Dict[str, Any]]:
        """Fetch products"""
        params = {
            "limit": limit,
            "page": page,
        }

        data = await self._request("GET", "/product", params=params)
        return data.get("products", [])

    async def get_product(self, product_id: int) -> Dict[str, Any]:
        """Get specific product by ID"""
        data = await self._request("GET", f"/product/{product_id}")
        return data.get("product", {})

    async def update_product_stock(
        self,
        product_id: int,
        quantity: int,
    ) -> bool:
        """
        Update product stock quantity

        Args:
            product_id: Product ID
            quantity: New stock quantity

        Returns:
            Success boolean
        """
        payload = {
            "quantity": quantity,
        }

        try:
            await self._request("PUT", f"/product/{product_id}", data=payload)
            return True
        except Exception as e:
            logger.error(f"Failed to update product stock: {str(e)}")
            return False

    async def get_customers(
        self,
        limit: int = 100,
        page: int = 1,
    ) -> List[Dict[str, Any]]:
        """Fetch customers"""
        params = {
            "limit": limit,
            "page": page,
        }

        data = await self._request("GET", "/customer", params=params)
        return data.get("customers", [])

    async def get_customer(self, customer_id: int) -> Dict[str, Any]:
        """Get specific customer by ID"""
        data = await self._request("GET", f"/customer/{customer_id}")
        return data.get("customer", {})

    async def get_order_statuses(self) -> List[Dict[str, Any]]:
        """Get all order statuses"""
        data = await self._request("GET", "/order/status")
        return data.get("order_statuses", [])

    async def health_check(self) -> bool:
        """Check if Opencart API is accessible"""
        try:
            await self._login()
            return True
        except Exception as e:
            logger.error(f"Opencart health check failed: {str(e)}")
            return False
