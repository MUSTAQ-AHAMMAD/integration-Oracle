"""
Vyrooq Workflow Engine - Main Entry Point
Temporal.io workflow worker and FastAPI status server
"""

import asyncio
from concurrent.futures import ThreadPoolExecutor
from temporalio.client import Client
from temporalio.worker import Worker
from workflows.sales_workflow import SalesWorkflow
from activities import sales_activities
from config import settings
from loguru import logger
import sys

# Configure logger
logger.remove()
logger.add(
    sys.stdout,
    format="<green>{time:YYYY-MM-DD HH:mm:ss}</green> | <level>{level: <8}</level> | <cyan>{name}</cyan>:<cyan>{function}</cyan> - <level>{message}</level>",
    level="INFO"
)


async def main():
    """Main entry point for workflow engine"""
    logger.info("🚀 Starting Vyrooq Workflow Engine")
    logger.info(f"Temporal Server: {settings.temporal_host}")
    logger.info(f"Task Queue: {settings.temporal_task_queue}")

    # Connect to Temporal server
    client = await Client.connect(settings.temporal_host)
    logger.info("✓ Connected to Temporal server")

    # Create worker
    worker = Worker(
        client,
        task_queue=settings.temporal_task_queue,
        workflows=[SalesWorkflow],
        activities=[
            sales_activities.fetch_vendhq_sale_details,
            sales_activities.validate_sale_data,
            sales_activities.transform_sale_to_fusion,
            sales_activities.enrich_with_metadata,
            sales_activities.check_idempotency,
            sales_activities.create_fusion_invoice,
            sales_activities.create_fusion_receipt,
            sales_activities.apply_fusion_receipt,
            sales_activities.create_inventory_transaction,
            sales_activities.create_journal_entry,
            sales_activities.verify_invoice_in_fusion,
            sales_activities.reconcile_sale_amounts,
            sales_activities.mark_sale_completed,
            sales_activities.archive_sale_data,
            sales_activities.persist_audit_event
        ],
        max_concurrent_activities=100,
    )

    logger.info("✓ Worker configured with workflows and activities")
    logger.info("🔄 Starting workflow worker...")

    # Run worker
    await worker.run()


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        logger.info("Shutting down workflow engine...")
    except Exception as e:
        logger.error(f"Fatal error: {e}")
        sys.exit(1)
