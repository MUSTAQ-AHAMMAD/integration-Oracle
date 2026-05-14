import http from 'http';
import { config } from './config.js';
import { logger } from './utils/logger.js';
import { queues } from './queues/index.js';

// Import all workers
import './processors/invoice.processor.js';
import './processors/receipt.processor.js';

/**
 * Health check HTTP server
 */
function startHealthServer() {
  const server = http.createServer(async (req, res) => {
    if (req.url === '/health') {
      res.writeHead(200, { 'Content-Type': 'application/json' });
      res.end(
        JSON.stringify({
          status: 'healthy',
          service: 'retry-engine',
          timestamp: new Date().toISOString(),
          uptime: process.uptime(),
        })
      );
    } else if (req.url === '/metrics') {
      try {
        const metrics = await getQueueMetrics();
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(metrics));
      } catch (error) {
        res.writeHead(500, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ error: 'Failed to get metrics' }));
      }
    } else if (req.url === '/ready') {
      try {
        // Check if queues are ready
        const queueStatuses = await Promise.all(
          Object.entries(queues).map(async ([name, queue]) => {
            try {
              await queue.client.ping();
              return { name, status: 'ready' };
            } catch (error) {
              return { name, status: 'not ready' };
            }
          })
        );

        const allReady = queueStatuses.every((q) => q.status === 'ready');

        res.writeHead(allReady ? 200 : 503, { 'Content-Type': 'application/json' });
        res.end(
          JSON.stringify({
            status: allReady ? 'ready' : 'not ready',
            queues: queueStatuses,
          })
        );
      } catch (error) {
        res.writeHead(503, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ status: 'not ready', error: 'Connection failed' }));
      }
    } else {
      res.writeHead(404, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify({ error: 'Not found' }));
    }
  });

  server.listen(config.port, () => {
    logger.info(`Retry engine health server listening on port ${config.port}`);
  });

  return server;
}

/**
 * Get metrics for all queues
 */
async function getQueueMetrics() {
  const metrics: any = {};

  for (const [name, queue] of Object.entries(queues)) {
    try {
      const [waiting, active, completed, failed, delayed] = await Promise.all([
        queue.getWaitingCount(),
        queue.getActiveCount(),
        queue.getCompletedCount(),
        queue.getFailedCount(),
        queue.getDelayedCount(),
      ]);

      metrics[name] = {
        waiting,
        active,
        completed,
        failed,
        delayed,
        total: waiting + active + completed + failed + delayed,
      };
    } catch (error) {
      logger.error({ queue: name, error }, 'Failed to get queue metrics');
      metrics[name] = { error: 'Failed to get metrics' };
    }
  }

  return {
    timestamp: new Date().toISOString(),
    queues: metrics,
  };
}

/**
 * Graceful shutdown
 */
async function shutdown() {
  logger.info('Shutting down retry engine gracefully...');

  try {
    // Close all workers (they're already listening on their queues)
    logger.info('Closing workers...');

    // Close all queues
    logger.info('Closing queues...');
    await Promise.all(Object.values(queues).map((queue) => queue.close()));

    logger.info('Retry engine shut down successfully');
    process.exit(0);
  } catch (error) {
    logger.error({ error }, 'Error during shutdown');
    process.exit(1);
  }
}

/**
 * Start retry engine
 */
async function start() {
  try {
    logger.info('Starting Vyrooq Retry Engine...');

    // Start health check server
    startHealthServer();

    // Log queue information
    logger.info(
      {
        queues: Object.keys(queues),
        redis: `${config.redis.host}:${config.redis.port}`,
      },
      'Retry engine started successfully'
    );

    logger.info('All workers are now processing jobs');
  } catch (error) {
    logger.error({ error }, 'Failed to start retry engine');
    process.exit(1);
  }
}

// Handle process termination
process.on('SIGTERM', shutdown);
process.on('SIGINT', shutdown);

// Handle uncaught errors
process.on('uncaughtException', (error) => {
  logger.error({ error }, 'Uncaught exception');
  shutdown();
});

process.on('unhandledRejection', (reason, promise) => {
  logger.error({ reason, promise }, 'Unhandled rejection');
});

// Start the engine
start();
