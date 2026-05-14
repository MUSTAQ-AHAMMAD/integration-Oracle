import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import jwt from '@fastify/jwt';
import { config } from './config.js';
import { logger } from './utils/logger.js';
import { ControlService } from './services/control.service.js';

const controlService = new ControlService();

async function buildServer() {
  const fastify = Fastify({
    logger: logger,
    requestIdHeader: 'x-request-id',
    requestIdLogLabel: 'requestId',
    genReqId: () => crypto.randomUUID(),
  });

  await fastify.register(helmet);
  await fastify.register(cors, config.cors);
  await fastify.register(jwt, { secret: config.jwt.secret });

  // Auth middleware
  const authenticate = async (request: any, reply: any) => {
    try {
      await request.jwtVerify();
    } catch (err) {
      reply.code(401).send({ error: 'Unauthorized' });
    }
  };

  /**
   * Health check
   */
  fastify.get('/health', async () => {
    return {
      status: 'healthy',
      service: 'manual-control-engine',
      timestamp: new Date().toISOString(),
      uptime: process.uptime(),
    };
  });

  /**
   * Get all queues status
   */
  fastify.get('/queues', { preHandler: authenticate }, async () => {
    const statuses = await controlService.getAllQueuesStatus();
    return { queues: statuses };
  });

  /**
   * Get specific queue status
   */
  fastify.get('/queues/:name', { preHandler: authenticate }, async (request) => {
    const { name } = request.params as { name: string };
    const status = await controlService.getQueueStatus(name);
    return status;
  });

  /**
   * Pause queue
   */
  fastify.post('/queues/:name/pause', { preHandler: authenticate }, async (request, reply) => {
    try {
      const { name } = request.params as { name: string };
      await controlService.pauseQueue(name);
      return { success: true, message: `Queue ${name} paused` };
    } catch (error: any) {
      return reply.code(400).send({ error: error.message });
    }
  });

  /**
   * Resume queue
   */
  fastify.post('/queues/:name/resume', { preHandler: authenticate }, async (request, reply) => {
    try {
      const { name } = request.params as { name: string };
      await controlService.resumeQueue(name);
      return { success: true, message: `Queue ${name} resumed` };
    } catch (error: any) {
      return reply.code(400).send({ error: error.message });
    }
  });

  /**
   * Pause all queues
   */
  fastify.post('/queues/pause-all', { preHandler: authenticate }, async () => {
    await controlService.pauseAll();
    return { success: true, message: 'All queues paused' };
  });

  /**
   * Resume all queues
   */
  fastify.post('/queues/resume-all', { preHandler: authenticate }, async () => {
    await controlService.resumeAll();
    return { success: true, message: 'All queues resumed' };
  });

  /**
   * Retry failed jobs
   */
  fastify.post('/queues/:name/retry', { preHandler: authenticate }, async (request, reply) => {
    try {
      const { name } = request.params as { name: string };
      const { limit } = request.body as { limit?: number };
      const count = await controlService.retryFailedJobs(name, limit);
      return { success: true, retriedCount: count };
    } catch (error: any) {
      return reply.code(400).send({ error: error.message });
    }
  });

  /**
   * Retry specific job
   */
  fastify.post(
    '/queues/:name/jobs/:jobId/retry',
    { preHandler: authenticate },
    async (request, reply) => {
      try {
        const { name, jobId } = request.params as { name: string; jobId: string };
        await controlService.retryJob(name, jobId);
        return { success: true, message: `Job ${jobId} retried` };
      } catch (error: any) {
        return reply.code(400).send({ error: error.message });
      }
    }
  );

  /**
   * Remove job
   */
  fastify.delete(
    '/queues/:name/jobs/:jobId',
    { preHandler: authenticate },
    async (request, reply) => {
      try {
        const { name, jobId } = request.params as { name: string; jobId: string };
        await controlService.removeJob(name, jobId);
        return { success: true, message: `Job ${jobId} removed` };
      } catch (error: any) {
        return reply.code(400).send({ error: error.message });
      }
    }
  );

  /**
   * Get failed jobs
   */
  fastify.get('/queues/:name/failed', { preHandler: authenticate }, async (request) => {
    const { name } = request.params as { name: string };
    const { limit } = request.query as { limit?: string };
    const jobs = await controlService.getFailedJobs(name, limit ? parseInt(limit) : 50);
    return { jobs };
  });

  /**
   * Move job to DLQ
   */
  fastify.post(
    '/queues/:name/jobs/:jobId/move-to-dlq',
    { preHandler: authenticate },
    async (request, reply) => {
      try {
        const { name, jobId } = request.params as { name: string; jobId: string };
        await controlService.moveToDLQ(name, jobId);
        return { success: true, message: `Job ${jobId} moved to DLQ` };
      } catch (error: any) {
        return reply.code(400).send({ error: error.message });
      }
    }
  );

  /**
   * Force sync sale
   */
  fastify.post('/force-sync', { preHandler: authenticate }, async (request, reply) => {
    try {
      const { saleId } = request.body as { saleId: string };
      if (!saleId) {
        return reply.code(400).send({ error: 'saleId is required' });
      }
      await controlService.forceSync(saleId);
      return { success: true, message: `Force sync initiated for sale ${saleId}` };
    } catch (error: any) {
      return reply.code(400).send({ error: error.message });
    }
  });

  /**
   * Replay transaction
   */
  fastify.post('/replay', { preHandler: authenticate }, async (request, reply) => {
    try {
      const { auditEventId } = request.body as { auditEventId: string };
      if (!auditEventId) {
        return reply.code(400).send({ error: 'auditEventId is required' });
      }
      await controlService.replayTransaction(auditEventId);
      return { success: true, message: `Transaction replay initiated` };
    } catch (error: any) {
      return reply.code(400).send({ error: error.message });
    }
  });

  /**
   * Get control history
   */
  fastify.get('/history', { preHandler: authenticate }, async (request) => {
    const { limit } = request.query as { limit?: string };
    const events = await controlService.getControlHistory(limit ? parseInt(limit) : 100);
    return { events };
  });

  /**
   * Get DLQ records
   */
  fastify.get('/dlq', { preHandler: authenticate }, async (request) => {
    const { limit } = request.query as { limit?: string };
    const records = await controlService.getDLQRecords(limit ? parseInt(limit) : 50);
    return { records };
  });

  /**
   * Clean queue
   */
  fastify.post('/queues/:name/clean', { preHandler: authenticate }, async (request, reply) => {
    try {
      const { name } = request.params as { name: string };
      const { grace, limit } = request.body as { grace?: number; limit?: number };
      const cleaned = await controlService.cleanQueue(name, grace, limit);
      return { success: true, cleaned: cleaned.length };
    } catch (error: any) {
      return reply.code(400).send({ error: error.message });
    }
  });

  // Error handler
  fastify.setErrorHandler((error, request, reply) => {
    logger.error({ error, requestId: request.id }, 'Request error');
    reply.code(error.statusCode || 500).send({
      error: error.name || 'Internal Server Error',
      message: error.message,
      requestId: request.id,
    });
  });

  // Graceful shutdown
  fastify.addHook('onClose', async () => {
    await controlService.close();
    logger.info('Server closed gracefully');
  });

  return fastify;
}

async function start() {
  try {
    const server = await buildServer();
    await server.listen({ port: config.port, host: '0.0.0.0' });
    logger.info(`Manual control engine listening on port ${config.port}`);
  } catch (error) {
    logger.error({ error }, 'Failed to start server');
    process.exit(1);
  }
}

// Handle process termination
process.on('SIGTERM', () => {
  logger.info('SIGTERM received, shutting down gracefully');
  process.exit(0);
});

process.on('SIGINT', () => {
  logger.info('SIGINT received, shutting down gracefully');
  process.exit(0);
});

start();
