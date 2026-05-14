import Redis from 'ioredis';
import { config } from '../config.js';
import { logger } from '../utils/logger.js';
import { generateFingerprint, generateIdempotencyKey } from '../utils/crypto.js';

export class DeduplicationService {
  private redis: Redis;

  constructor() {
    this.redis = new Redis({
      host: config.redis.host,
      port: config.redis.port,
      password: config.redis.password,
      db: config.redis.db,
    });

    this.redis.on('connect', () => {
      logger.info('Deduplication service connected to Redis');
    });

    this.redis.on('error', (err) => {
      logger.error({ err }, 'Redis connection error');
    });
  }

  /**
   * Check if a transaction is duplicate based on fingerprint
   */
  async isDuplicate(fingerprint: string): Promise<boolean> {
    const key = `${config.idempotency.fingerprintPrefix}${fingerprint}`;
    const exists = await this.redis.exists(key);
    return exists === 1;
  }

  /**
   * Mark transaction as processed with fingerprint
   */
  async markProcessed(
    fingerprint: string,
    metadata: any
  ): Promise<void> {
    const key = `${config.idempotency.fingerprintPrefix}${fingerprint}`;
    await this.redis.setex(
      key,
      config.idempotency.ttl,
      JSON.stringify({
        fingerprint,
        processedAt: new Date().toISOString(),
        ...metadata,
      })
    );

    logger.info({ fingerprint, key }, 'Transaction marked as processed');
  }

  /**
   * Check idempotency key
   */
  async checkIdempotencyKey(key: string): Promise<{
    exists: boolean;
    result?: any;
  }> {
    const redisKey = `${config.idempotency.keyPrefix}${key}`;
    const data = await this.redis.get(redisKey);

    if (data) {
      logger.info({ key }, 'Idempotency key found - returning cached result');
      return {
        exists: true,
        result: JSON.parse(data),
      };
    }

    return { exists: false };
  }

  /**
   * Store idempotency result
   */
  async storeIdempotencyResult(
    key: string,
    result: any,
    ttl?: number
  ): Promise<void> {
    const redisKey = `${config.idempotency.keyPrefix}${key}`;
    const ttlSeconds = ttl || config.idempotency.ttl;

    await this.redis.setex(redisKey, ttlSeconds, JSON.stringify(result));

    logger.info({ key, ttl: ttlSeconds }, 'Idempotency result stored');
  }

  /**
   * Acquire distributed lock
   */
  async acquireLock(
    resource: string,
    ttl?: number
  ): Promise<{ acquired: boolean; lockId?: string }> {
    const lockKey = `lock:${resource}`;
    const lockId = `${Date.now()}-${Math.random()}`;
    const lockTTL = ttl || config.idempotency.lockTTL;

    // SET NX (set if not exists) with expiry
    const result = await this.redis.set(
      lockKey,
      lockId,
      'EX',
      lockTTL,
      'NX'
    );

    if (result === 'OK') {
      logger.debug({ resource, lockId }, 'Lock acquired');
      return { acquired: true, lockId };
    }

    logger.debug({ resource }, 'Failed to acquire lock');
    return { acquired: false };
  }

  /**
   * Release distributed lock
   */
  async releaseLock(resource: string, lockId: string): Promise<boolean> {
    const lockKey = `lock:${resource}`;

    // Use Lua script to ensure atomic check-and-delete
    const script = `
      if redis.call("get", KEYS[1]) == ARGV[1] then
        return redis.call("del", KEYS[1])
      else
        return 0
      end
    `;

    const result = await this.redis.eval(script, 1, lockKey, lockId);

    if (result === 1) {
      logger.debug({ resource, lockId }, 'Lock released');
      return true;
    }

    logger.warn({ resource, lockId }, 'Failed to release lock - already expired or wrong owner');
    return false;
  }

  /**
   * Store correlation ID mapping
   */
  async storeCorrelation(
    correlationId: string,
    metadata: any
  ): Promise<void> {
    const key = `${config.idempotency.correlationPrefix}${correlationId}`;
    await this.redis.setex(
      key,
      config.idempotency.ttl,
      JSON.stringify(metadata)
    );

    logger.debug({ correlationId }, 'Correlation stored');
  }

  /**
   * Get correlation metadata
   */
  async getCorrelation(correlationId: string): Promise<any | null> {
    const key = `${config.idempotency.correlationPrefix}${correlationId}`;
    const data = await this.redis.get(key);

    if (data) {
      return JSON.parse(data);
    }

    return null;
  }

  /**
   * Check and process transaction atomically
   */
  async checkAndProcess(
    data: any,
    operation: string
  ): Promise<{
    isDuplicate: boolean;
    fingerprint: string;
    idempotencyKey?: string;
    existingResult?: any;
  }> {
    const fingerprint = generateFingerprint(data);
    const isDuplicate = await this.isDuplicate(fingerprint);

    if (isDuplicate) {
      logger.warn({ fingerprint, operation }, 'Duplicate transaction detected');
      return { isDuplicate: true, fingerprint };
    }

    // Generate idempotency key
    const idempotencyKey = generateIdempotencyKey(
      operation,
      data.saleId || data.id || 'unknown',
      data
    );

    // Check if we have a cached result
    const cached = await this.checkIdempotencyKey(idempotencyKey);
    if (cached.exists) {
      return {
        isDuplicate: true,
        fingerprint,
        idempotencyKey,
        existingResult: cached.result,
      };
    }

    // Mark as processing to prevent concurrent duplicates
    await this.markProcessed(fingerprint, {
      operation,
      status: 'processing',
      idempotencyKey,
    });

    return {
      isDuplicate: false,
      fingerprint,
      idempotencyKey,
    };
  }

  /**
   * Get statistics
   */
  async getStats(): Promise<any> {
    const fingerprintPattern = `${config.idempotency.fingerprintPrefix}*`;
    const idempotencyPattern = `${config.idempotency.keyPrefix}*`;
    const correlationPattern = `${config.idempotency.correlationPrefix}*`;

    const [fingerprintKeys, idempotencyKeys, correlationKeys] = await Promise.all([
      this.scanKeys(fingerprintPattern),
      this.scanKeys(idempotencyPattern),
      this.scanKeys(correlationPattern),
    ]);

    return {
      fingerprints: fingerprintKeys.length,
      idempotencyKeys: idempotencyKeys.length,
      correlations: correlationKeys.length,
      total: fingerprintKeys.length + idempotencyKeys.length + correlationKeys.length,
    };
  }

  /**
   * Scan Redis keys (efficient for large datasets)
   */
  private async scanKeys(pattern: string): Promise<string[]> {
    const keys: string[] = [];
    let cursor = '0';

    do {
      const result = await this.redis.scan(cursor, 'MATCH', pattern, 'COUNT', 100);
      cursor = result[0];
      keys.push(...result[1]);
    } while (cursor !== '0');

    return keys;
  }

  /**
   * Close Redis connection
   */
  async close(): Promise<void> {
    await this.redis.quit();
    logger.info('Deduplication service disconnected from Redis');
  }
}
