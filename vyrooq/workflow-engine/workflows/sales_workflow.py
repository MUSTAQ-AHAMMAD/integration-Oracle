"""
Sales Processing Workflow
Main Temporal workflow for processing VendHQ sales to Oracle Fusion
"""

from datetime import timedelta
from temporalio import workflow
from temporalio.common import RetryPolicy
from dataclasses import dataclass
from typing import Dict, Any, List
import uuid


@dataclass
class SaleInput:
    """Input data for sales workflow"""
    invoice_number: str
    sale_date: str
    outlet_id: str
    region: str
    customer_type: str
    total_price: float
    line_items: List[Dict[str, Any]]
    payments: List[Dict[str, Any]]


@dataclass
class WorkflowResult:
    """Result of workflow execution"""
    status: str
    correlation_id: str
    transaction_number: str = None
    error_message: str = None


@workflow.defn
class SalesWorkflow:
    """
    Sales Processing Workflow

    Implements the 11-stage workflow:
    1. FETCH - Retrieve sale details
    2. VALIDATE - Verify data integrity
    3. TRANSFORM - Apply business logic
    4. ENRICH - Add metadata
    5. DEDUPLICATE - Check for duplicates
    6. QUEUE - Submit to processing queue
    7. PROCESS - Execute integration
    8. VERIFY - Confirm success
    9. RECONCILE - Validate amounts
    10. COMPLETE - Mark as successful
    11. ARCHIVE - Long-term storage
    """

    @workflow.run
    async def run(self, sale: SaleInput) -> WorkflowResult:
        """Execute the sales processing workflow"""

        correlation_id = str(uuid.uuid4())

        workflow.logger.info(f"Starting sales workflow for invoice {sale.invoice_number}")

        # Retry policy for all activities
        retry_policy = RetryPolicy(
            initial_interval=timedelta(seconds=1),
            maximum_interval=timedelta(seconds=60),
            backoff_coefficient=2.0,
            maximum_attempts=50
        )

        try:
            # Stage 1: FETCH
            workflow.logger.info("Stage 1: FETCH - Retrieving sale details")
            enriched_sale = await workflow.execute_activity(
                "fetch_vendhq_sale_details",
                sale.invoice_number,
                start_to_close_timeout=timedelta(seconds=30),
                retry_policy=retry_policy
            )

            # Persist audit event
            await workflow.execute_activity(
                "persist_audit_event",
                args=[correlation_id, "sale_fetched", enriched_sale],
                start_to_close_timeout=timedelta(seconds=10)
            )

            # Stage 2: VALIDATE
            workflow.logger.info("Stage 2: VALIDATE - Validating sale data")
            validation = await workflow.execute_activity(
                "validate_sale_data",
                enriched_sale,
                start_to_close_timeout=timedelta(seconds=10),
                retry_policy=retry_policy
            )

            if not validation["valid"]:
                return WorkflowResult(
                    status="failed",
                    correlation_id=correlation_id,
                    error_message=f"Validation failed: {validation['errors']}"
                )

            # Stage 3: TRANSFORM
            workflow.logger.info("Stage 3: TRANSFORM - Transforming to Fusion format")
            fusion_payload = await workflow.execute_activity(
                "transform_sale_to_fusion",
                enriched_sale,
                start_to_close_timeout=timedelta(seconds=30),
                retry_policy=retry_policy
            )

            # Stage 4: ENRICH
            workflow.logger.info("Stage 4: ENRICH - Enriching with metadata")
            enriched_payload = await workflow.execute_activity(
                "enrich_with_metadata",
                fusion_payload,
                start_to_close_timeout=timedelta(seconds=20),
                retry_policy=retry_policy
            )

            # Stage 5: DEDUPLICATE
            workflow.logger.info("Stage 5: DEDUPLICATE - Checking for duplicates")
            idempotency_key = f"invoice_{sale.invoice_number}_{sale.sale_date}_{sale.region}"
            existing = await workflow.execute_activity(
                "check_idempotency",
                idempotency_key,
                start_to_close_timeout=timedelta(seconds=10)
            )

            if existing:
                workflow.logger.warning(f"Duplicate transaction detected: {idempotency_key}")
                return WorkflowResult(
                    status="duplicate",
                    correlation_id=correlation_id,
                    error_message="Transaction already processed"
                )

            # Stage 6: QUEUE (handled by Temporal automatically)

            # Stage 7: PROCESS - Create invoice
            workflow.logger.info("Stage 7: PROCESS - Creating Fusion invoice")
            invoice_result = await workflow.execute_activity(
                "create_fusion_invoice",
                enriched_payload,
                start_to_close_timeout=timedelta(minutes=2),
                retry_policy=retry_policy
            )

            if not invoice_result["success"]:
                raise Exception(f"Invoice creation failed: {invoice_result.get('error')}")

            transaction_number = invoice_result["transaction_number"]
            workflow.logger.info(f"Invoice created: {transaction_number}")

            # Create receipts
            workflow.logger.info("Creating Fusion receipts")
            receipt_result = await workflow.execute_activity(
                "create_fusion_receipt",
                args=[enriched_payload, transaction_number],
                start_to_close_timeout=timedelta(minutes=1),
                retry_policy=retry_policy
            )

            # Apply receipt (with retry logic for rounding)
            workflow.logger.info("Applying receipt to invoice")
            apply_result = await workflow.execute_activity(
                "apply_fusion_receipt",
                args=[receipt_result, transaction_number],
                start_to_close_timeout=timedelta(minutes=2),
                retry_policy=retry_policy
            )

            # Create inventory transactions
            workflow.logger.info("Creating inventory transactions")
            await workflow.execute_activity(
                "create_inventory_transaction",
                enriched_payload,
                start_to_close_timeout=timedelta(minutes=1),
                retry_policy=retry_policy
            )

            # Create journal entries (if non-NORMAL customer)
            if sale.customer_type != "NORMAL":
                workflow.logger.info("Creating journal entries")
                await workflow.execute_activity(
                    "create_journal_entry",
                    enriched_payload,
                    start_to_close_timeout=timedelta(minutes=1),
                    retry_policy=retry_policy
                )

            # Stage 8: VERIFY
            workflow.logger.info("Stage 8: VERIFY - Verifying in Fusion")
            verification = await workflow.execute_activity(
                "verify_invoice_in_fusion",
                transaction_number,
                start_to_close_timeout=timedelta(seconds=30),
                retry_policy=retry_policy
            )

            # Stage 9: RECONCILE
            workflow.logger.info("Stage 9: RECONCILE - Reconciling amounts")
            await workflow.execute_activity(
                "reconcile_sale_amounts",
                args=[sale, invoice_result],
                start_to_close_timeout=timedelta(seconds=20)
            )

            # Stage 10: COMPLETE
            workflow.logger.info("Stage 10: COMPLETE - Marking as completed")
            await workflow.execute_activity(
                "mark_sale_completed",
                args=[correlation_id, invoice_result],
                start_to_close_timeout=timedelta(seconds=10)
            )

            # Stage 11: ARCHIVE
            workflow.logger.info("Stage 11: ARCHIVE - Archiving data")
            await workflow.execute_activity(
                "archive_sale_data",
                sale.invoice_number,
                start_to_close_timeout=timedelta(seconds=30)
            )

            workflow.logger.info(f"✓ Workflow completed successfully for {sale.invoice_number}")

            return WorkflowResult(
                status="completed",
                correlation_id=correlation_id,
                transaction_number=transaction_number
            )

        except Exception as e:
            workflow.logger.error(f"Workflow failed: {str(e)}")

            # Persist failure event
            await workflow.execute_activity(
                "persist_audit_event",
                args=[correlation_id, "workflow_failed", {"error": str(e)}],
                start_to_close_timeout=timedelta(seconds=10)
            )

            return WorkflowResult(
                status="failed",
                correlation_id=correlation_id,
                error_message=str(e)
            )
