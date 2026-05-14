import dotenv from 'dotenv';
dotenv.config();

export const config = {
  port: parseInt(process.env.PORT || '3300', 10),
  nodeEnv: process.env.NODE_ENV || 'development',

  // Redis Configuration
  redis: {
    host: process.env.REDIS_HOST || 'localhost',
    port: parseInt(process.env.REDIS_PORT || '6379', 10),
    password: process.env.REDIS_PASSWORD,
    db: parseInt(process.env.REDIS_DB || '1', 10), // Use DB 1 for deduplication
  },

  // Database
  database: {
    url: process.env.DATABASE_URL || 'postgresql://postgres:vyrooq123@localhost:5432/vyrooq',
  },

  // Idempotency Configuration
  idempotency: {
    // How long to keep idempotency keys (24 hours)
    ttl: parseInt(process.env.IDEMPOTENCY_TTL || '86400', 10),

    // Prefix for Redis keys
    keyPrefix: process.env.IDEMPOTENCY_KEY_PREFIX || 'idempotency:',

    // Fingerprint prefix
    fingerprintPrefix: process.env.FINGERPRINT_PREFIX || 'fingerprint:',

    // Correlation ID prefix
    correlationPrefix: process.env.CORRELATION_PREFIX || 'correlation:',

    // Lock TTL for distributed locking (30 seconds)
    lockTTL: parseInt(process.env.LOCK_TTL || '30', 10),
  },

  // CORS
  cors: {
    origin: process.env.CORS_ORIGIN || '*',
    credentials: true,
  },
};
