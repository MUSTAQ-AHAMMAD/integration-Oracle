/**
 * Reconciliation Engine
 * Validates data integrity between VendHQ, local database, and Oracle Fusion
 */

import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import { PrismaClient } from '@prisma/client';
import { Queue, Worker } from 'bullmq';
import Redis from 'ioredis';

const prisma = new PrismaClient();
const redis = new Redis(process.env.REDIS_URL || 'redis://localhost:6379');

// Create reconciliation queue
const reconciliationQueue = new Queue('reconciliation', {
  connection: redis
});

const fastify = Fastify({
  logger: {
    level: process.env.LOG_LEVEL || 'info',
    transport: {
      target: 'pino-pretty',
      options: {
        colorize: true,
        translateTime: 'HH:MM:ss Z',
        ignore: 'pid,hostname'
      }
    }
  }
});

// Register plugins
fastify.register(cors);
fastify.register(helmet);

/**
 * Reconciliation types
 */
interface ReconciliationResult {
  status: 'MATCHED' | 'MISMATCHED' | 'MISSING' | 'ERROR';
  entity: string;
  entityId: string;
  issues: string[];
  details: Record<string, any>;
}

/**
 * Invoice reconciliation
 */
async function reconcileInvoice(saleId: string): Promise<ReconciliationResult> {
  const issues: string[] = [];

  try {
    // Get sale from database
    const sale = await prisma.sales.findUnique({
      where: { id: saleId },
      include: {
        sale_line_items: true,
        fusion_invoices: true
      }
    });

    if (!sale) {
      return {
        status: 'MISSING',
        entity: 'invoice',
        entityId: saleId,
        issues: ['Sale not found in local database'],
        details: {}
      };
    }

    const fusionInvoice = sale.fusion_invoices?.[0];
    if (!fusionInvoice) {
      return {
        status: 'MISSING',
        entity: 'invoice',
        entityId: saleId,
        issues: ['Invoice not found in Oracle Fusion'],
        details: { localSale: sale }
      };
    }

    // Validate amounts
    const localTotal = parseFloat(sale.total_price);
    const fusionTotal = parseFloat(fusionInvoice.invoice_amount);
    const tolerance = 0.05; // 5 cent tolerance for rounding

    if (Math.abs(localTotal - fusionTotal) > tolerance) {
      issues.push(`Amount mismatch: Local=${localTotal}, Fusion=${fusionTotal}`);
    }

    // Validate line item count
    const localLineCount = sale.sale_line_items.length;
    const fusionLineCount = fusionInvoice.line_count || 0;

    if (localLineCount !== fusionLineCount) {
      issues.push(`Line count mismatch: Local=${localLineCount}, Fusion=${fusionLineCount}`);
    }

    // Validate status
    if (fusionInvoice.status !== 'VALIDATED') {
      issues.push(`Invoice status: ${fusionInvoice.status}`);
    }

    return {
      status: issues.length === 0 ? 'MATCHED' : 'MISMATCHED',
      entity: 'invoice',
      entityId: saleId,
      issues,
      details: {
        localTotal,
        fusionTotal,
        localLineCount,
        fusionLineCount,
        fusionInvoiceNumber: fusionInvoice.invoice_number
      }
    };
  } catch (error) {
    return {
      status: 'ERROR',
      entity: 'invoice',
      entityId: saleId,
      issues: [error instanceof Error ? error.message : 'Unknown error'],
      details: { error }
    };
  }
}

/**
 * Receipt reconciliation
 */
async function reconcileReceipt(saleId: string): Promise<ReconciliationResult> {
  const issues: string[] = [];

  try {
    const sale = await prisma.sales.findUnique({
      where: { id: saleId },
      include: {
        sale_payments: true,
        fusion_receipts: true
      }
    });

    if (!sale) {
      return {
        status: 'MISSING',
        entity: 'receipt',
        entityId: saleId,
        issues: ['Sale not found'],
        details: {}
      };
    }

    const fusionReceipts = sale.fusion_receipts || [];
    const localPayments = sale.sale_payments || [];

    // Check receipt count
    if (fusionReceipts.length !== localPayments.length) {
      issues.push(`Receipt count mismatch: Local=${localPayments.length}, Fusion=${fusionReceipts.length}`);
    }

    // Validate total amounts
    const localTotal = localPayments.reduce((sum, p) => sum + parseFloat(p.amount), 0);
    const fusionTotal = fusionReceipts.reduce((sum, r) => sum + parseFloat(r.receipt_amount), 0);

    if (Math.abs(localTotal - fusionTotal) > 0.05) {
      issues.push(`Amount mismatch: Local=${localTotal}, Fusion=${fusionTotal}`);
    }

    return {
      status: issues.length === 0 ? 'MATCHED' : 'MISMATCHED',
      entity: 'receipt',
      entityId: saleId,
      issues,
      details: {
        localTotal,
        fusionTotal,
        localPaymentCount: localPayments.length,
        fusionReceiptCount: fusionReceipts.length
      }
    };
  } catch (error) {
    return {
      status: 'ERROR',
      entity: 'receipt',
      entityId: saleId,
      issues: [error instanceof Error ? error.message : 'Unknown error'],
      details: { error }
    };
  }
}

/**
 * Inventory reconciliation
 */
async function reconcileInventory(saleId: string): Promise<ReconciliationResult> {
  const issues: string[] = [];

  try {
    const sale = await prisma.sales.findUnique({
      where: { id: saleId },
      include: {
        sale_line_items: true,
        fusion_inventory_transactions: true
      }
    });

    if (!sale) {
      return {
        status: 'MISSING',
        entity: 'inventory',
        entityId: saleId,
        issues: ['Sale not found'],
        details: {}
      };
    }

    const lineItems = sale.sale_line_items || [];
    const inventoryTxns = sale.fusion_inventory_transactions || [];

    // Each line item should have corresponding inventory transaction
    if (lineItems.length !== inventoryTxns.length) {
      issues.push(`Transaction count mismatch: Lines=${lineItems.length}, Txns=${inventoryTxns.length}`);
    }

    // Validate quantities
    for (const lineItem of lineItems) {
      const txn = inventoryTxns.find(t => t.item_code === lineItem.product_sku);
      if (!txn) {
        issues.push(`Missing inventory transaction for item ${lineItem.product_sku}`);
        continue;
      }

      const expectedQty = -parseFloat(lineItem.quantity); // Should be negative
      const actualQty = parseFloat(txn.transaction_quantity);

      if (Math.abs(expectedQty - actualQty) > 0.001) {
        issues.push(`Quantity mismatch for ${lineItem.product_sku}: Expected=${expectedQty}, Actual=${actualQty}`);
      }
    }

    return {
      status: issues.length === 0 ? 'MATCHED' : 'MISMATCHED',
      entity: 'inventory',
      entityId: saleId,
      issues,
      details: {
        lineItemCount: lineItems.length,
        transactionCount: inventoryTxns.length
      }
    };
  } catch (error) {
    return {
      status: 'ERROR',
      entity: 'inventory',
      entityId: saleId,
      issues: [error instanceof Error ? error.message : 'Unknown error'],
      details: { error }
    };
  }
}

/**
 * Full reconciliation (all entities)
 */
async function reconcileSale(saleId: string): Promise<ReconciliationResult[]> {
  return Promise.all([
    reconcileInvoice(saleId),
    reconcileReceipt(saleId),
    reconcileInventory(saleId)
  ]);
}

// API Routes
fastify.get('/health', async () => {
  return { status: 'healthy', service: 'reconciliation-engine', version: '1.0.0' };
});

fastify.get('/ready', async () => {
  try {
    await prisma.$queryRaw`SELECT 1`;
    await redis.ping();
    return { status: 'ready' };
  } catch (error) {
    return { status: 'not ready', error };
  }
});

/**
 * Reconcile single sale
 */
fastify.post<{ Body: { saleId: string } }>('/reconcile/sale', async (request, reply) => {
  const { saleId } = request.body;

  if (!saleId) {
    return reply.code(400).send({ error: 'saleId is required' });
  }

  const results = await reconcileSale(saleId);
  const hasIssues = results.some(r => r.status !== 'MATCHED');

  return {
    saleId,
    status: hasIssues ? 'HAS_ISSUES' : 'OK',
    results
  };
});

/**
 * Reconcile date range
 */
fastify.post<{ Body: { startDate: string; endDate: string } }>('/reconcile/range', async (request, reply) => {
  const { startDate, endDate } = request.body;

  if (!startDate || !endDate) {
    return reply.code(400).send({ error: 'startDate and endDate are required' });
  }

  // Queue reconciliation jobs
  const sales = await prisma.sales.findMany({
    where: {
      sale_date: {
        gte: new Date(startDate),
        lte: new Date(endDate)
      }
    },
    select: { id: true }
  });

  for (const sale of sales) {
    await reconciliationQueue.add('reconcile-sale', { saleId: sale.id });
  }

  return {
    message: 'Reconciliation jobs queued',
    count: sales.length
  };
});

/**
 * Get reconciliation report
 */
fastify.get('/reports/daily', async () => {
  const today = new Date();
  today.setHours(0, 0, 0, 0);

  const reports = await prisma.reconciliation_reports.findMany({
    where: {
      report_date: {
        gte: today
      }
    },
    orderBy: { report_date: 'desc' }
  });

  return { reports };
});

/**
 * Get mismatch summary
 */
fastify.get('/reports/mismatches', async () => {
  const mismatches = await prisma.reconciliation_reports.findMany({
    where: {
      status: 'MISMATCHED'
    },
    orderBy: { report_date: 'desc' },
    take: 100
  });

  return { mismatches, count: mismatches.length };
});

// Worker for processing reconciliation jobs
const worker = new Worker(
  'reconciliation',
  async (job) => {
    const { saleId } = job.data;
    fastify.log.info(`Processing reconciliation for sale ${saleId}`);

    const results = await reconcileSale(saleId);

    // Store results in database
    for (const result of results) {
      await prisma.reconciliation_reports.create({
        data: {
          entity_type: result.entity,
          entity_id: result.entityId,
          status: result.status,
          issues: JSON.stringify(result.issues),
          details: JSON.stringify(result.details),
          report_date: new Date()
        }
      });
    }

    return results;
  },
  { connection: redis }
);

worker.on('completed', (job) => {
  fastify.log.info(`Reconciliation job ${job.id} completed`);
});

worker.on('failed', (job, err) => {
  fastify.log.error(`Reconciliation job ${job?.id} failed: ${err.message}`);
});

// Start server
const start = async () => {
  try {
    const port = parseInt(process.env.PORT || '3500', 10);
    await fastify.listen({ port, host: '0.0.0.0' });
    fastify.log.info(`Reconciliation Engine listening on port ${port}`);
  } catch (err) {
    fastify.log.error(err);
    process.exit(1);
  }
};

start();
