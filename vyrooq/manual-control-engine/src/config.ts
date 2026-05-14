import dotenv from 'dotenv';
dotenv.config();

export const config = {
  port: parseInt(process.env.PORT || '3400', 10),
  nodeEnv: process.env.NODE_ENV || 'development',

  // JWT Configuration
  jwt: {
    secret: process.env.JWT_SECRET || 'vyrooq-jwt-secret-change-in-production',
  },

  // Redis Configuration (for BullMQ)
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

  // Temporal Configuration
  temporal: {
    address: process.env.TEMPORAL_HOST || 'localhost:7233',
    namespace: process.env.TEMPORAL_NAMESPACE || 'default',
  },

  // Queue Names (must match retry-engine)
  queues: {
    invoice: 'invoice-processing',
    receipt: 'receipt-processing',
    journal: 'journal-processing',
    inventory: 'inventory-processing',
    vendhq: 'vendhq-sync',
    dlq: 'dead-letter-queue',
  },

  // CORS
  cors: {
    origin: process.env.CORS_ORIGIN || '*',
    credentials: true,
  },
};
