import { FastifyInstance, FastifyRequest, FastifyReply } from 'fastify';
import { z } from 'zod';

// Schema definitions
const processSaleSchema = z.object({
  invoiceNumber: z.string(),
  saleDate: z.string().datetime(),
  outletId: z.string(),
  region: z.string(),
  customerType: z.string(),
  totalPrice: z.number(),
  lineItems: z.array(z.object({
    itemNumber: z.string(),
    itemName: z.string(),
    quantity: z.number(),
    totalPrice: z.number(),
    taxName: z.string()
  })),
  payments: z.array(z.object({
    paymentType: z.string(),
    amount: z.number()
  }))
});

export async function salesRoutes(server: FastifyInstance) {
  // Process sale endpoint
  server.post('/process', {
    schema: {
      tags: ['Sales'],
      description: 'Process a VendHQ sale through the integration workflow',
      body: {
        type: 'object',
        required: ['invoiceNumber', 'saleDate', 'outletId'],
        properties: {
          invoiceNumber: { type: 'string' },
          saleDate: { type: 'string' },
          outletId: { type: 'string' },
          region: { type: 'string' },
          customerType: { type: 'string' },
          totalPrice: { type: 'number' },
          lineItems: {
            type: 'array',
            items: {
              type: 'object',
              properties: {
                itemNumber: { type: 'string' },
                itemName: { type: 'string' },
                quantity: { type: 'number' },
                totalPrice: { type: 'number' },
                taxName: { type: 'string' }
              }
            }
          },
          payments: {
            type: 'array',
            items: {
              type: 'object',
              properties: {
                paymentType: { type: 'string' },
                amount: { type: 'number' }
              }
            }
          }
        }
      },
      response: {
        200: {
          type: 'object',
          properties: {
            success: { type: 'boolean' },
            workflowId: { type: 'string' },
            correlationId: { type: 'string' },
            message: { type: 'string' }
          }
        }
      }
    }
  }, async (request: FastifyRequest, reply: FastifyReply) => {
    const saleData = processSaleSchema.parse(request.body);

    // Generate correlation ID
    const correlationId = request.id;

    // TODO: Start Temporal workflow
    // TODO: Queue in BullMQ
    // TODO: Check idempotency

    return {
      success: true,
      workflowId: `wf_${Date.now()}`,
      correlationId,
      message: 'Sale queued for processing'
    };
  });

  // Get sale status
  server.get('/status/:invoiceNumber', {
    schema: {
      tags: ['Sales'],
      description: 'Get processing status of a sale',
      params: {
        type: 'object',
        properties: {
          invoiceNumber: { type: 'string' }
        }
      },
      response: {
        200: {
          type: 'object',
          properties: {
            invoiceNumber: { type: 'string' },
            status: { type: 'string' },
            stage: { type: 'string' },
            lastUpdated: { type: 'string' }
          }
        }
      }
    }
  }, async (request: FastifyRequest<{ Params: { invoiceNumber: string } }>, reply: FastifyReply) => {
    const { invoiceNumber } = request.params;

    // TODO: Query from database

    return {
      invoiceNumber,
      status: 'processing',
      stage: 'TRANSFORM',
      lastUpdated: new Date().toISOString()
    };
  });

  // Batch process sales
  server.post('/batch', {
    schema: {
      tags: ['Sales'],
      description: 'Process multiple sales in a batch',
      body: {
        type: 'object',
        properties: {
          sales: {
            type: 'array',
            items: { type: 'object' }
          }
        }
      }
    }
  }, async (request: FastifyRequest, reply: FastifyReply) => {
    // TODO: Batch processing logic
    return { success: true, batchId: `batch_${Date.now()}` };
  });
}
