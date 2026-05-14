import dotenv from 'dotenv';
dotenv.config();

export const config = {
  port: parseInt(process.env.PORT || '3200', 10),
  nodeEnv: process.env.NODE_ENV || 'development',

  // Redis Configuration
  redis: {
    host: process.env.REDIS_HOST || 'localhost',
    port: parseInt(process.env.REDIS_PORT || '6379', 10),
    password: process.env.REDIS_PASSWORD,
    db: parseInt(process.env.REDIS_DB || '0', 10),
  },

  // Database
  database: {
    url: process.env.DATABASE_URL || 'postgresql://postgres:vyrooq123@localhost:5432/vyrooq',
  },

  // Queue Configuration
  queues: {
    // Invoice processing queue
    invoice: {
      name: 'invoice-processing',
      concurrency: parseInt(process.env.INVOICE_CONCURRENCY || '5', 10),
      attempts: parseInt(process.env.INVOICE_MAX_ATTEMPTS || '5', 10),
      backoff: {
        type: 'exponential' as const,
        delay: 5000, // 5 seconds
      },
    },
    // Receipt processing queue
    receipt: {
      name: 'receipt-processing',
      concurrency: parseInt(process.env.RECEIPT_CONCURRENCY || '5', 10),
      attempts: parseInt(process.env.RECEIPT_MAX_ATTEMPTS || '50', 10), // 50 retries for rounding
      backoff: {
        type: 'exponential' as const,
        delay: 2000, // 2 seconds
      },
    },
    // Journal entry queue
    journal: {
      name: 'journal-processing',
      concurrency: parseInt(process.env.JOURNAL_CONCURRENCY || '3', 10),
      attempts: parseInt(process.env.JOURNAL_MAX_ATTEMPTS || '5', 10),
      backoff: {
        type: 'exponential' as const,
        delay: 3000,
      },
    },
    // Inventory transaction queue
    inventory: {
      name: 'inventory-processing',
      concurrency: parseInt(process.env.INVENTORY_CONCURRENCY || '5', 10),
      attempts: parseInt(process.env.INVENTORY_MAX_ATTEMPTS || '5', 10),
      backoff: {
        type: 'exponential' as const,
        delay: 4000,
      },
    },
    // VendHQ sync queue
    vendhq: {
      name: 'vendhq-sync',
      concurrency: parseInt(process.env.VENDHQ_CONCURRENCY || '3', 10),
      attempts: parseInt(process.env.VENDHQ_MAX_ATTEMPTS || '3', 10),
      backoff: {
        type: 'exponential' as const,
        delay: 10000, // 10 seconds
      },
    },
    // Dead Letter Queue
    dlq: {
      name: 'dead-letter-queue',
      concurrency: 1,
    },
  },

  // Monitoring
  monitoring: {
    metricsPort: parseInt(process.env.METRICS_PORT || '9200', 10),
  },
};
