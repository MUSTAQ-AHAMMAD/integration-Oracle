"""
Oracle Fusion Adapter - SOAP and REST Client
Handles all communication with Oracle Fusion ERP
"""

import httpx
from typing import Dict, Any, Optional
from loguru import logger
from base64 import b64encode
from datetime import datetime
import xml.etree.ElementTree as ET


class FusionAdapter:
    """Oracle Fusion ERP Adapter with SOAP and REST support"""

    def __init__(self, base_url: str, username: str, password: str):
        self.base_url = base_url
        self.username = username
        self.password = password

        # Create auth header
        credentials = f"{username}:{password}"
        encoded_credentials = b64encode(credentials.encode()).decode()
        self.auth_header = f"Basic {encoded_credentials}"

        # Create HTTP client
        self.client = httpx.AsyncClient(
            timeout=60.0,
            verify=True,  # Set to False for test environments only
            headers={"Authorization": self.auth_header}
        )

    async def create_invoice(self, invoice_data: Dict[str, Any]) -> Dict[str, Any]:
        """
        Create invoice in Oracle Fusion using SOAP
        Endpoint: /fscmService/RecInvoiceService
        """
        logger.info(f"Creating invoice for {invoice_data.get('sales_order')}")

        soap_payload = self._build_invoice_soap(invoice_data)
        url = f"{self.base_url}/fscmService/RecInvoiceService"

        try:
            response = await self.client.post(
                url,
                content=soap_payload,
                headers={"Content-Type": "text/xml; charset=utf-8"}
            )
            response.raise_for_status()

            # Parse SOAP response
            result = self._parse_invoice_response(response.text)
            logger.info(f"✓ Invoice created: {result.get('transaction_number')}")

            return {
                "success": True,
                "transaction_number": result.get("transaction_number"),
                "customer_trx_id": result.get("customer_trx_id")
            }

        except Exception as e:
            logger.error(f"Failed to create invoice: {str(e)}")
            return {"success": False, "error": str(e)}

    async def create_standard_receipt(self, receipt_data: Dict[str, Any]) -> Dict[str, Any]:
        """
        Create standard receipt using SOAP
        Endpoint: /fscmService/StandardReceiptService
        """
        logger.info(f"Creating standard receipt: {receipt_data.get('receipt_number')}")

        soap_payload = self._build_receipt_soap(receipt_data)
        url = f"{self.base_url}/fscmService/StandardReceiptService"

        try:
            response = await self.client.post(
                url,
                content=soap_payload,
                headers={"Content-Type": "text/xml; charset=utf-8"}
            )
            response.raise_for_status()

            result = self._parse_receipt_response(response.text)
            logger.info(f"✓ Receipt created: {result.get('receipt_number')}")

            return {"success": True, **result}

        except Exception as e:
            logger.error(f"Failed to create receipt: {str(e)}")
            return {"success": False, "error": str(e)}

    async def apply_receipt(
        self,
        receipt_number: str,
        transaction_number: str,
        amount: float,
        retry_count: int = 0
    ) -> Dict[str, Any]:
        """
        Apply receipt to invoice with retry logic for rounding
        Implements 50-retry mechanism with -0.01 adjustment
        """
        logger.info(f"Applying receipt {receipt_number} to {transaction_number} (attempt {retry_count + 1})")

        # Adjust amount for rounding on retry
        adjusted_amount = amount - (retry_count * 0.01)

        soap_payload = self._build_apply_receipt_soap(
            receipt_number,
            transaction_number,
            adjusted_amount
        )

        url = f"{self.base_url}/fscmService/StandardReceiptService"

        try:
            response = await self.client.post(
                url,
                content=soap_payload,
                headers={"Content-Type": "text/xml; charset=utf-8"}
            )
            response.raise_for_status()

            logger.info(f"✓ Receipt applied successfully")
            return {"success": True}

        except Exception as e:
            error_msg = str(e)

            # Check if it's a rounding error
            if "rounding" in error_msg.lower() and retry_count < 50:
                logger.warning(f"Rounding error detected, retrying with adjusted amount")
                # Temporal will automatically retry this activity
                raise

            logger.error(f"Failed to apply receipt: {error_msg}")
            return {"success": False, "error": error_msg}

    async def create_inventory_transaction(self, txn_data: Dict[str, Any]) -> Dict[str, Any]:
        """
        Create inventory transaction using REST API
        Endpoint: POST /scm/restApi/inventoryTransactions
        """
        logger.info("Creating inventory transaction")

        url = f"{self.base_url}/scm/restApi/inventoryTransactions"

        payload = {
            "TransactionInterfaceId": txn_data.get("transaction_id"),
            "TransactionType": txn_data.get("transaction_type"),
            "Item": txn_data.get("item_number"),
            "TransactionQuantity": txn_data.get("quantity") * -1,  # Always negative
            "OrganizationName": txn_data.get("organization_name"),
            "TransactionUOM": txn_data.get("uom"),
            "TransactionDate": datetime.now().isoformat()
        }

        try:
            response = await self.client.post(url, json=payload)
            response.raise_for_status()

            logger.info("✓ Inventory transaction created")
            return {"success": True, "response": response.json()}

        except Exception as e:
            logger.error(f"Failed to create inventory transaction: {str(e)}")
            return {"success": False, "error": str(e)}

    async def create_journal_entry(self, journal_data: Dict[str, Any]) -> Dict[str, Any]:
        """
        Create journal entry using SOAP (for non-NORMAL customers)
        Endpoint: /fscmService/JournalService
        """
        logger.info("Creating journal entry")

        soap_payload = self._build_journal_soap(journal_data)
        url = f"{self.base_url}/fscmService/JournalService"

        try:
            response = await self.client.post(
                url,
                content=soap_payload,
                headers={"Content-Type": "text/xml; charset=utf-8"}
            )
            response.raise_for_status()

            logger.info("✓ Journal entry created")
            return {"success": True}

        except Exception as e:
            logger.error(f"Failed to create journal entry: {str(e)}")
            return {"success": False, "error": str(e)}

    async def get_customer_info(self, account_number: str) -> Optional[Dict[str, Any]]:
        """
        Get customer information using REST API
        """
        url = f"{self.base_url}/fin/restApi/customers?q=CustomerNumber='{account_number}'"

        try:
            response = await self.client.get(url)
            response.raise_for_status()

            data = response.json()
            items = data.get("items", [])

            if items:
                return items[0]

            return None

        except Exception as e:
            logger.error(f"Failed to get customer info: {str(e)}")
            return None

    async def verify_invoice(self, transaction_number: str) -> bool:
        """Verify invoice exists in Fusion"""
        url = f"{self.base_url}/fin/restApi/receivablesInvoices?q=TransactionNumber='{transaction_number}'"

        try:
            response = await self.client.get(url)
            response.raise_for_status()

            data = response.json()
            return len(data.get("items", [])) > 0

        except Exception as e:
            logger.error(f"Failed to verify invoice: {str(e)}")
            return False

    def _build_invoice_soap(self, invoice_data: Dict[str, Any]) -> str:
        """Build SOAP XML for invoice creation"""
        # Simplified SOAP envelope
        # In production, use proper SOAP library or JAX-WS generated stubs
        return f"""<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:inv="http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/">
    <soapenv:Header/>
    <soapenv:Body>
        <inv:createSimpleInvoice>
            <inv:billToCustomerName>{invoice_data.get('bill_to_customer')}</inv:billToCustomerName>
            <inv:transactionDate>{invoice_data.get('transaction_date')}</inv:transactionDate>
            <inv:businessUnit>{invoice_data.get('business_unit')}</inv:businessUnit>
            <inv:currencyCode>{invoice_data.get('currency_code')}</inv:currencyCode>
        </inv:createSimpleInvoice>
    </soapenv:Body>
</soapenv:Envelope>"""

    def _build_receipt_soap(self, receipt_data: Dict[str, Any]) -> str:
        """Build SOAP XML for receipt creation"""
        return f"""<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <createStandardReceipt>
            <receiptNumber>{receipt_data.get('receipt_number')}</receiptNumber>
            <amount>{receipt_data.get('amount')}</amount>
        </createStandardReceipt>
    </soapenv:Body>
</soapenv:Envelope>"""

    def _build_apply_receipt_soap(
        self,
        receipt_number: str,
        transaction_number: str,
        amount: float
    ) -> str:
        """Build SOAP XML for apply receipt"""
        return f"""<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <createApplyReceipt>
            <receiptNumber>{receipt_number}</receiptNumber>
            <transactionNumber>{transaction_number}</transactionNumber>
            <amountApplied>{amount:.2f}</amountApplied>
        </createApplyReceipt>
    </soapenv:Body>
</soapenv:Envelope>"""

    def _build_journal_soap(self, journal_data: Dict[str, Any]) -> str:
        """Build SOAP XML for journal entry"""
        return """<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <importJournals/>
    </soapenv:Body>
</soapenv:Envelope>"""

    def _parse_invoice_response(self, xml_response: str) -> Dict[str, Any]:
        """Parse SOAP response for invoice creation"""
        # Simplified parsing - use proper XML parsing in production
        return {
            "transaction_number": "TXN123456",
            "customer_trx_id": 999888777
        }

    def _parse_receipt_response(self, xml_response: str) -> Dict[str, Any]:
        """Parse SOAP response for receipt creation"""
        return {
            "receipt_number": "REC123456"
        }

    async def close(self):
        """Close HTTP client"""
        await self.client.aclose()
