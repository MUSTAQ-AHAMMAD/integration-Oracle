import { Worker, Job } from 'bullmq';
import { config } from '../config.js';
import { logger } from '../utils/logger.js';
import { redisConnection } from '../queues/index.js';
import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();

interface InvoiceJobData {
  saleId: string;
  invoiceData: any;
  correlationId: string;
  attemptNumber?: number;
}

/**
 * Process invoice creation jobs
 */
export const invoiceWorker = new Worker(
  config.queues.invoice.name,
  async (job: Job<InvoiceJobData>) => {
    const { saleId, invoiceData, correlationId, attemptNumber = 1 } = job.data;

    logger.info(
      {
        jobId: job.id,
        saleId,
        correlationId,
        attemptNumber,
        attemptsLeft: job.attemptsMade,
      },
      'Processing invoice creation job'
    );

    try {
      // TODO: Call Fusion Adapter to create invoice
      // const result = await fusionClient.createInvoice(invoiceData);

      // Record success in database
      await prisma.fusionInvoice.create({
        data: {
          saleId,
          invoiceNumber: invoiceData.invoiceNumber,
          fusionInvoiceId: `FUSION-${Date.now()}`, // Replace with actual Fusion ID
          status: 'CREATED',
          amount: invoiceData.totalAmount,
          createdAt: new Date(),
        },
      });

      // Log audit event
      await prisma.auditEvent.create({
        data: {
          eventType: 'INVOICE_CREATED',
          entityType: 'INVOICE',
          entityId: saleId,
          correlationId,
          payload: invoiceData,
          status: 'SUCCESS',
          timestamp: new Date(),
        },
      });

      logger.info({ jobId: job.id, saleId }, 'Invoice created successfully');

      return {
        success: true,
        invoiceNumber: invoiceData.invoiceNumber,
        timestamp: new Date().toISOString(),
      };
    } catch (error: any) {
      logger.error(
        {
          jobId: job.id,
          saleId,
          error: error.message,
          attemptNumber,
        },
        'Invoice creation failed'
      );

      // Log failure audit event
      await prisma.auditEvent.create({
        data: {
          eventType: 'INVOICE_FAILED',
          entityType: 'INVOICE',
          entityId: saleId,
          correlationId,
          payload: { error: error.message, invoiceData },
          status: 'FAILED',
          timestamp: new Date(),
        },
      });

      // If max attempts reached, move to DLQ
      if (job.attemptsMade >= config.queues.invoice.attempts) {
        await prisma.dlqRecord.create({
          data: {
            queueName: config.queues.invoice.name,
            jobId: job.id || 'unknown',
            jobData: job.data as any,
            error: error.message,
            failedAt: new Date(),
          },
        });

        logger.error({ jobId: job.id, saleId }, 'Invoice job moved to DLQ');
      }

      throw error; // Re-throw to trigger BullMQ retry
    }
  },
  {
    connection: redisConnection,
    concurrency: config.queues.invoice.concurrency,
  }
);

// Worker event handlers
invoiceWorker.on('completed', (job) => {
  logger.info({ jobId: job.id }, 'Invoice worker completed job');
});

invoiceWorker.on('failed', (job, error) => {
  logger.error({ jobId: job?.id, error: error.message }, 'Invoice worker failed job');
});

invoiceWorker.on('error', (error) => {
  logger.error({ error }, 'Invoice worker error');
});

logger.info('Invoice worker initialized');
