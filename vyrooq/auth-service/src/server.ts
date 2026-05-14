import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import rateLimit from '@fastify/rate-limit';
import jwt from '@fastify/jwt';
import { PrismaClient } from '@prisma/client';
import { config } from './config.js';
import { logger } from './utils/logger.js';
import { redisClient } from './utils/redis.js';
import { authRoutes } from './routes/auth.routes.js';

// Extend Fastify instance
declare module 'fastify' {
  interface FastifyInstance {
    db: PrismaClient;
  }
}

async function buildServer() {
  const fastify = Fastify({
    logger: logger,
    requestIdHeader: 'x-request-id',
    requestIdLogLabel: 'requestId',
    genReqId: () => crypto.randomUUID(),
  });

  // Initialize Prisma Client
  const prisma = new PrismaClient();
  fastify.decorate('db', prisma);

  // Register plugins
  await fastify.register(helmet, {
    contentSecurityPolicy: false,
  });

  await fastify.register(cors, config.cors);

  await fastify.register(rateLimit, {
    max: config.rateLimit.max,
    timeWindow: config.rateLimit.timeWindow,
    redis: redisClient as any,
  });

  await fastify.register(jwt, {
    secret: config.jwt.secret,
  });

  // Health check endpoint
  fastify.get('/health', async () => {
    return {
      status: 'healthy',
      service: 'auth-service',
      timestamp: new Date().toISOString(),
      uptime: process.uptime(),
    };
  });

  // Readiness check
  fastify.get('/ready', async () => {
    try {
      // Check database connection
      await prisma.$queryRaw`SELECT 1`;

      return {
        status: 'ready',
        checks: {
          database: 'ok',
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

  // Register routes
  await fastify.register(authRoutes);

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
    await prisma.$disconnect();
    await redisClient.disconnect();
    logger.info('Server closed gracefully');
  });

  return fastify;
}

async function start() {
  try {
    // Connect to Redis
    await redisClient.connect();

    // Build and start server
    const server = await buildServer();

    await server.listen({
      port: config.port,
      host: '0.0.0.0',
    });

    logger.info(`Auth service listening on port ${config.port}`);
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
