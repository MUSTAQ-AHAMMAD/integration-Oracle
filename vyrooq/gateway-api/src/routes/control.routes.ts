import { FastifyInstance, FastifyRequest, FastifyReply } from 'fastify';

export async function controlRoutes(server: FastifyInstance) {
  // Pause processing for a region
  server.post('/pause/:region', {
    schema: {
      tags: ['Control'],
      description: 'Pause all processing for a specific region',
      params: {
        type: 'object',
        properties: {
          region: { type: 'string' }
        }
      }
    }
  }, async (request: FastifyRequest<{ Params: { region: string } }>, reply: FastifyReply) => {
    const { region } = request.params;

    // TODO: Set pause flag in Redis
    // TODO: Signal Temporal workflows

    return {
      success: true,
      region,
      status: 'paused'
    };
  });

  // Resume processing for a region
  server.post('/resume/:region', {
    schema: {
      tags: ['Control'],
      description: 'Resume processing for a specific region',
      params: {
        type: 'object',
        properties: {
          region: { type: 'string' }
        }
      }
    }
  }, async (request: FastifyRequest<{ Params: { region: string } }>, reply: FastifyReply) => {
    const { region } = request.params;

    // TODO: Remove pause flag from Redis
    // TODO: Signal Temporal workflows

    return {
      success: true,
      region,
      status: 'resumed'
    };
  });

  // Replay failed transaction
  server.post('/replay/:invoiceNumber', {
    schema: {
      tags: ['Control'],
      description: 'Replay a failed transaction',
      params: {
        type: 'object',
        properties: {
          invoiceNumber: { type: 'string' }
        }
      }
    }
  }, async (request: FastifyRequest<{ Params: { invoiceNumber: string } }>, reply: FastifyReply) => {
    const { invoiceNumber } = request.params;

    // TODO: Fetch original transaction from DB
    // TODO: Start new Temporal workflow

    return {
      success: true,
      invoiceNumber,
      workflowId: `replay_${invoiceNumber}_${Date.now()}`,
      status: 'replaying'
    };
  });

  // Retry queue
  server.post('/retry-queue/:queueName', {
    schema: {
      tags: ['Control'],
      description: 'Retry all failed jobs in a queue',
      params: {
        type: 'object',
        properties: {
          queueName: { type: 'string' }
        }
      },
      body: {
        type: 'object',
        properties: {
          maxRetries: { type: 'number', default: 50 },
          delaySeconds: { type: 'number', default: 60 }
        }
      }
    }
  }, async (request: FastifyRequest<{
    Params: { queueName: string },
    Body: { maxRetries?: number, delaySeconds?: number }
  }>, reply: FastifyReply) => {
    const { queueName } = request.params;
    const { maxRetries = 50, delaySeconds = 60 } = request.body || {};

    // TODO: Get failed jobs from BullMQ
    // TODO: Requeue with delay

    return {
      success: true,
      queueName,
      requeuedCount: 0
    };
  });

  // Force sync for outlet
  server.post('/force-sync/:outletId', {
    schema: {
      tags: ['Control'],
      description: 'Force synchronization for a specific outlet',
      params: {
        type: 'object',
        properties: {
          outletId: { type: 'string' }
        }
      }
    }
  }, async (request: FastifyRequest<{ Params: { outletId: string } }>, reply: FastifyReply) => {
    const { outletId } = request.params;

    // TODO: Trigger immediate sync workflow

    return {
      success: true,
      outletId,
      status: 'syncing'
    };
  });
}
