import { Queue, QueueOptions } from 'bullmq';
import IORedis from 'ioredis';
import { config } from '../config.js';
import { logger } from '../utils/logger.js';

// Create Redis connection
export const redisConnection = new IORedis({
  host: config.redis.host,
  port: config.redis.port,
  password: config.redis.password,
  db: config.redis.db,
  maxRetriesPerRequest: null,
});

// Base queue options
const baseQueueOptions: QueueOptions = {
  connection: redisConnection,
  defaultJobOptions: {
    removeOnComplete: {
      count: 1000, // Keep last 1000 completed jobs
      age: 24 * 3600, // Keep for 24 hours
    },
    removeOnFail: {
      count: 5000, // Keep last 5000 failed jobs
      age: 7 * 24 * 3600, // Keep for 7 days
    },
  },
};

/**
 * Invoice Processing Queue
 * Handles creation and submission of invoices to Oracle Fusion
 */
export const invoiceQueue = new Queue(config.queues.invoice.name, {
  ...baseQueueOptions,
  defaultJobOptions: {
    ...baseQueueOptions.defaultJobOptions,
    attempts: config.queues.invoice.attempts,
    backoff: config.queues.invoice.backoff,
  },
});

/**
 * Receipt Processing Queue
 * Handles receipt creation and application with special rounding retry logic
 */
export const receiptQueue = new Queue(config.queues.receipt.name, {
  ...baseQueueOptions,
  defaultJobOptions: {
    ...baseQueueOptions.defaultJobOptions,
    attempts: config.queues.receipt.attempts, // 50 attempts for rounding
    backoff: config.queues.receipt.backoff,
  },
});

/**
 * Journal Entry Queue
 * Handles journal entry creation for bank charges and discounts
 */
export const journalQueue = new Queue(config.queues.journal.name, {
  ...baseQueueOptions,
  defaultJobOptions: {
    ...baseQueueOptions.defaultJobOptions,
    attempts: config.queues.journal.attempts,
    backoff: config.queues.journal.backoff,
  },
});

/**
 * Inventory Transaction Queue
 * Handles inventory movements and stock adjustments
 */
export const inventoryQueue = new Queue(config.queues.inventory.name, {
  ...baseQueueOptions,
  defaultJobOptions: {
    ...baseQueueOptions.defaultJobOptions,
    attempts: config.queues.inventory.attempts,
    backoff: config.queues.inventory.backoff,
  },
});

/**
 * VendHQ Sync Queue
 * Handles synchronization with VendHQ POS system
 */
export const vendhqQueue = new Queue(config.queues.vendhq.name, {
  ...baseQueueOptions,
  defaultJobOptions: {
    ...baseQueueOptions.defaultJobOptions,
    attempts: config.queues.vendhq.attempts,
    backoff: config.queues.vendhq.backoff,
  },
});

/**
 * Dead Letter Queue
 * Stores permanently failed jobs for manual review
 */
export const dlqQueue = new Queue(config.queues.dlq.name, {
  ...baseQueueOptions,
  defaultJobOptions: {
    ...baseQueueOptions.defaultJobOptions,
    attempts: 1, // No retries in DLQ
    removeOnComplete: false, // Keep all completed
    removeOnFail: false, // Keep all failed
  },
});

// Queue registry for easy access
export const queues = {
  invoice: invoiceQueue,
  receipt: receiptQueue,
  journal: journalQueue,
  inventory: inventoryQueue,
  vendhq: vendhqQueue,
  dlq: dlqQueue,
};

// Log queue events
Object.entries(queues).forEach(([name, queue]) => {
  queue.on('error', (error) => {
    logger.error({ queue: name, error }, 'Queue error');
  });

  queue.on('waiting', (jobId) => {
    logger.debug({ queue: name, jobId }, 'Job waiting');
  });

  queue.on('active', (job) => {
    logger.debug({ queue: name, jobId: job.id }, 'Job active');
  });

  queue.on('completed', (job) => {
    logger.info({ queue: name, jobId: job.id }, 'Job completed');
  });

  queue.on('failed', (job, error) => {
    logger.error({ queue: name, jobId: job?.id, error }, 'Job failed');
  });
});

logger.info('All queues initialized successfully');
