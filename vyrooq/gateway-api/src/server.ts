import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import rateLimit from '@fastify/rate-limit';
import swagger from '@fastify/swagger';
import swaggerUi from '@fastify/swagger-ui';
import { setupRoutes } from './routes';
import { setupOpenTelemetry } from './telemetry';
import { logger } from './utils/logger';
import { config } from './config';

// Initialize OpenTelemetry
setupOpenTelemetry();

// Create Fastify instance
const server = Fastify({
  trustProxy: true,
  requestIdHeader: 'x-correlation-id',
  requestIdLogLabel: 'correlationId'
});

async function start() {
  try {
    // Register CORS
    await server.register(cors, {
      origin: config.cors.origin,
      credentials: true
    });

    // Register Helmet for security headers
    await server.register(helmet, {
      contentSecurityPolicy: false // Disable for Swagger UI
    });

    // Register Rate Limiting
    await server.register(rateLimit, {
      max: 100,
      timeWindow: '1 minute',
      redis: config.redis.url
    });

    // Register Swagger
    await server.register(swagger, {
      swagger: {
        info: {
          title: 'Vyrooq Integration Platform API',
          description: 'Enterprise middleware for Oracle Fusion, VendHQ, and Opencart integrations',
          version: '1.0.0',
          contact: {
            name: 'Vyrooq Support',
            email: 'support@vyrooq.com'
          }
        },
        host: config.server.host,
        schemes: ['http', 'https'],
        consumes: ['application/json'],
        produces: ['application/json'],
        tags: [
          { name: 'Health', description: 'Health check endpoints' },
          { name: 'Sales', description: 'Sales integration endpoints' },
          { name: 'Invoices', description: 'Invoice management endpoints' },
          { name: 'Receipts', description: 'Receipt management endpoints' },
          { name: 'Control', description: 'Manual control endpoints' },
          { name: 'Audit', description: 'Audit trail endpoints' }
        ],
        securityDefinitions: {
          Bearer: {
            type: 'apiKey',
            name: 'Authorization',
            in: 'header',
            description: 'Enter JWT token as: Bearer {token}'
          }
        }
      }
    });

    // Register Swagger UI
    await server.register(swaggerUi, {
      routePrefix: '/docs',
      uiConfig: {
        docExpansion: 'list',
        deepLinking: true
      },
      staticCSP: true,
      transformStaticCSP: (header) => header
    });

    // Setup routes
    setupRoutes(server);

    // Health check endpoint
    server.get('/health', {
      schema: {
        tags: ['Health'],
        description: 'Health check endpoint',
        response: {
          200: {
            type: 'object',
            properties: {
              status: { type: 'string' },
              timestamp: { type: 'string' },
              uptime: { type: 'number' },
              environment: { type: 'string' }
            }
          }
        }
      }
    }, async () => {
      return {
        status: 'healthy',
        timestamp: new Date().toISOString(),
        uptime: process.uptime(),
        environment: config.env
      };
    });

    // Readiness check endpoint
    server.get('/ready', {
      schema: {
        tags: ['Health'],
        description: 'Readiness check endpoint'
      }
    }, async () => {
      // Check database connection
      // Check Redis connection
      // Check external services
      return { status: 'ready' };
    });

    // Start server
    await server.listen({
      port: config.server.port,
      host: '0.0.0.0'
    });

    logger.info(`🚀 Vyrooq Gateway API listening on ${config.server.port}`);
    logger.info(`📚 API Documentation: http://localhost:${config.server.port}/docs`);

  } catch (error) {
    logger.error(error);
    process.exit(1);
  }
}

// Graceful shutdown
process.on('SIGINT', async () => {
  logger.info('Received SIGINT, shutting down gracefully...');
  await server.close();
  process.exit(0);
});

process.on('SIGTERM', async () => {
  logger.info('Received SIGTERM, shutting down gracefully...');
  await server.close();
  process.exit(0);
});

// Start the server
start();
