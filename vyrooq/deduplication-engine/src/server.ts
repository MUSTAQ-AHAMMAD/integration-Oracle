import Fastify from 'fastify';
import cors from '@fastify/cors';
import { z } from 'zod';
import { config } from './config.js';
import { logger } from './utils/logger.js';
import { DeduplicationService } from './services/deduplication.service.js';
import { generateFingerprint, generateCorrelationId } from './utils/crypto.js';

const deduplicationService = new DeduplicationService();

async function buildServer() {
  const fastify = Fastify({
    logger: logger,
    requestIdHeader: 'x-request-id',
    requestIdLogLabel: 'requestId',
    genReqId: () => crypto.randomUUID(),
  });

  await fastify.register(cors, config.cors);

  /**
   * Health check
   */
  fastify.get('/health', async () => {
    return {
      status: 'healthy',
      service: 'deduplication-engine',
      timestamp: new Date().toISOString(),
      uptime: process.uptime(),
    };
  });

  /**
   * Readiness check
   */
  fastify.get('/ready', async () => {
    try {
      await deduplicationService.getStats();
      return {
        status: 'ready',
        checks: {
          redis: 'ok',
        },
      };
    } catch (error) {
      return {
        status: 'not ready',
        error: 'Service dependencies not available',
      };
    }
  });

  /**
   * Check if transaction is duplicate
   * POST /check
   */
  fastify.post('/check', async (request, reply) => {
    try {
      const { data, operation } = request.body as { data: any; operation: string };

      if (!data || !operation) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'data and operation are required',
        });
      }

      const result = await deduplicationService.checkAndProcess(data, operation);

      return reply.send({
        isDuplicate: result.isDuplicate,
        fingerprint: result.fingerprint,
        idempotencyKey: result.idempotencyKey,
        existingResult: result.existingResult,
      });
    } catch (error: any) {
      logger.error({ error }, 'Check duplicate error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Generate fingerprint for data
   * POST /fingerprint
   */
  fastify.post('/fingerprint', async (request, reply) => {
    try {
      const { data } = request.body as { data: any };

      if (!data) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'data is required',
        });
      }

      const fingerprint = generateFingerprint(data);

      return reply.send({
        fingerprint,
        timestamp: new Date().toISOString(),
      });
    } catch (error: any) {
      logger.error({ error }, 'Generate fingerprint error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Store idempotency result
   * POST /idempotency
   */
  fastify.post('/idempotency', async (request, reply) => {
    try {
      const { key, result, ttl } = request.body as {
        key: string;
        result: any;
        ttl?: number;
      };

      if (!key || !result) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'key and result are required',
        });
      }

      await deduplicationService.storeIdempotencyResult(key, result, ttl);

      return reply.send({
        success: true,
        key,
        ttl: ttl || config.idempotency.ttl,
      });
    } catch (error: any) {
      logger.error({ error }, 'Store idempotency error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Check idempotency key
   * GET /idempotency/:key
   */
  fastify.get('/idempotency/:key', async (request, reply) => {
    try {
      const { key } = request.params as { key: string };

      const result = await deduplicationService.checkIdempotencyKey(key);

      if (result.exists) {
        return reply.send({
          exists: true,
          result: result.result,
        });
      }

      return reply.code(404).send({
        exists: false,
        message: 'Idempotency key not found',
      });
    } catch (error: any) {
      logger.error({ error }, 'Check idempotency error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Acquire distributed lock
   * POST /lock
   */
  fastify.post('/lock', async (request, reply) => {
    try {
      const { resource, ttl } = request.body as { resource: string; ttl?: number };

      if (!resource) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'resource is required',
        });
      }

      const result = await deduplicationService.acquireLock(resource, ttl);

      if (result.acquired) {
        return reply.send({
          acquired: true,
          lockId: result.lockId,
          resource,
          ttl: ttl || config.idempotency.lockTTL,
        });
      }

      return reply.code(409).send({
        acquired: false,
        message: 'Resource is already locked',
        resource,
      });
    } catch (error: any) {
      logger.error({ error }, 'Acquire lock error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Release distributed lock
   * DELETE /lock
   */
  fastify.delete('/lock', async (request, reply) => {
    try {
      const { resource, lockId } = request.body as { resource: string; lockId: string };

      if (!resource || !lockId) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'resource and lockId are required',
        });
      }

      const released = await deduplicationService.releaseLock(resource, lockId);

      return reply.send({
        released,
        resource,
        lockId,
      });
    } catch (error: any) {
      logger.error({ error }, 'Release lock error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Store correlation
   * POST /correlation
   */
  fastify.post('/correlation', async (request, reply) => {
    try {
      const { correlationId, metadata } = request.body as {
        correlationId?: string;
        metadata: any;
      };

      const corrId = correlationId || generateCorrelationId();

      await deduplicationService.storeCorrelation(corrId, metadata);

      return reply.send({
        correlationId: corrId,
        success: true,
      });
    } catch (error: any) {
      logger.error({ error }, 'Store correlation error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Get correlation
   * GET /correlation/:correlationId
   */
  fastify.get('/correlation/:correlationId', async (request, reply) => {
    try {
      const { correlationId } = request.params as { correlationId: string };

      const metadata = await deduplicationService.getCorrelation(correlationId);

      if (metadata) {
        return reply.send({
          correlationId,
          metadata,
        });
      }

      return reply.code(404).send({
        error: 'Not found',
        message: 'Correlation ID not found',
      });
    } catch (error: any) {
      logger.error({ error }, 'Get correlation error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  /**
   * Get statistics
   * GET /stats
   */
  fastify.get('/stats', async (request, reply) => {
    try {
      const stats = await deduplicationService.getStats();

      return reply.send({
        stats,
        timestamp: new Date().toISOString(),
      });
    } catch (error: any) {
      logger.error({ error }, 'Get stats error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: error.message,
      });
    }
  });

  // Error handler
  fastify.setErrorHandler((error, request, reply) => {
    logger.error(
      {
        error,
        requestId: request.id,
        url: request.url,
        method: request.method,
      },
      'Request error'
    );

    reply.code(error.statusCode || 500).send({
      error: error.name || 'Internal Server Error',
      message: error.message || 'An unexpected error occurred',
      requestId: request.id,
    });
  });

  // Graceful shutdown
  fastify.addHook('onClose', async () => {
    await deduplicationService.close();
    logger.info('Server closed gracefully');
  });

  return fastify;
}

async function start() {
  try {
    const server = await buildServer();

    await server.listen({
      port: config.port,
      host: '0.0.0.0',
    });

    logger.info(`Deduplication engine listening on port ${config.port}`);
  } catch (error) {
    logger.error({ error }, 'Failed to start server');
    process.exit(1);
  }
}

// Handle process termination
process.on('SIGTERM', async () => {
  logger.info('SIGTERM received, shutting down gracefully');
  process.exit(0);
});

process.on('SIGINT', async () => {
  logger.info('SIGINT received, shutting down gracefully');
  process.exit(0);
});

// Start server
start();
