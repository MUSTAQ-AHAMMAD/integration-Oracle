import { Worker, Job } from 'bullmq';
import { config } from '../config.js';
import { logger } from '../utils/logger.js';
import { redisConnection } from '../queues/index.js';
import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();

interface ReceiptJobData {
  saleId: string;
  invoiceId: string;
  receiptData: any;
  correlationId: string;
  attemptNumber?: number;
  roundingAdjustment?: number;
}

/**
 * Process receipt creation and application with 50-retry rounding logic
 */
export const receiptWorker = new Worker(
  config.queues.receipt.name,
  async (job: Job<ReceiptJobData>) => {
    const {
      saleId,
      invoiceId,
      receiptData,
      correlationId,
      attemptNumber = 1,
      roundingAdjustment = 0,
    } = job.data;

    logger.info(
      {
        jobId: job.id,
        saleId,
        invoiceId,
        correlationId,
        attemptNumber,
        roundingAdjustment,
      },
      'Processing receipt application job'
    );

    try {
      // Calculate adjusted amount (for rounding retry logic)
      const adjustedAmount = receiptData.amount + roundingAdjustment;

      // TODO: Call Fusion Adapter to create and apply receipt
      // const result = await fusionClient.createReceipt({
      //   ...receiptData,
      //   amount: adjustedAmount,
      // });

      // Record success in database
      await prisma.fusionReceipt.create({
        data: {
          saleId,
          invoiceId,
          receiptNumber: receiptData.receiptNumber,
          fusionReceiptId: `FUSION-RCPT-${Date.now()}`,
          status: 'APPLIED',
          amount: adjustedAmount,
          roundingAdjustment,
          appliedAt: new Date(),
        },
      });

      // Log audit event
      await prisma.auditEvent.create({
        data: {
          eventType: 'RECEIPT_APPLIED',
          entityType: 'RECEIPT',
          entityId: saleId,
          correlationId,
          payload: {
            ...receiptData,
            adjustedAmount,
            roundingAdjustment,
            attemptNumber,
          },
          status: 'SUCCESS',
          timestamp: new Date(),
        },
      });

      logger.info(
        {
          jobId: job.id,
          saleId,
          roundingAdjustment,
          attemptNumber,
        },
        'Receipt applied successfully'
      );

      return {
        success: true,
        receiptNumber: receiptData.receiptNumber,
        adjustedAmount,
        roundingAdjustment,
        timestamp: new Date().toISOString(),
      };
    } catch (error: any) {
      logger.error(
        {
          jobId: job.id,
          saleId,
          error: error.message,
          attemptNumber,
          roundingAdjustment,
        },
        'Receipt application failed'
      );

      // Check if it's a rounding error
      const isRoundingError = error.message?.toLowerCase().includes('rounding') ||
                              error.message?.toLowerCase().includes('amount mismatch');

      if (isRoundingError && attemptNumber < config.queues.receipt.attempts) {
        // Apply -0.01 adjustment for next retry
        const newRoundingAdjustment = roundingAdjustment - 0.01;

        logger.info(
          {
            jobId: job.id,
            saleId,
            attemptNumber: attemptNumber + 1,
            newRoundingAdjustment,
          },
          'Applying rounding adjustment for retry'
        );

        // Update job data for next attempt
        job.data.roundingAdjustment = newRoundingAdjustment;
        job.data.attemptNumber = attemptNumber + 1;
      }

      // Log failure audit event
      await prisma.auditEvent.create({
        data: {
          eventType: 'RECEIPT_FAILED',
          entityType: 'RECEIPT',
          entityId: saleId,
          correlationId,
          payload: {
            error: error.message,
            receiptData,
            roundingAdjustment,
            attemptNumber,
          },
          status: 'FAILED',
          timestamp: new Date(),
        },
      });

      // If max attempts reached, move to DLQ
      if (job.attemptsMade >= config.queues.receipt.attempts) {
        await prisma.dlqRecord.create({
          data: {
            queueName: config.queues.receipt.name,
            jobId: job.id || 'unknown',
            jobData: job.data as any,
            error: error.message,
            failedAt: new Date(),
          },
        });

        logger.error(
          {
            jobId: job.id,
            saleId,
            totalAttempts: attemptNumber,
            finalRoundingAdjustment: roundingAdjustment,
          },
          'Receipt job moved to DLQ after 50 retries'
        );
      }

      throw error; // Re-throw to trigger BullMQ retry
    }
  },
  {
    connection: redisConnection,
    concurrency: config.queues.receipt.concurrency,
  }
);

// Worker event handlers
receiptWorker.on('completed', (job) => {
  logger.info({ jobId: job.id }, 'Receipt worker completed job');
});

receiptWorker.on('failed', (job, error) => {
  logger.error({ jobId: job?.id, error: error.message }, 'Receipt worker failed job');
});

receiptWorker.on('error', (error) => {
  logger.error({ error }, 'Receipt worker error');
});

logger.info('Receipt worker initialized with 50-retry rounding logic');
