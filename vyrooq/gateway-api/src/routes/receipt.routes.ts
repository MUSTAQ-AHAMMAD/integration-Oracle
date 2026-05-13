import { FastifyInstance, FastifyRequest, FastifyReply } from 'fastify';

export async function receiptRoutes(server: FastifyInstance) {
  // Get receipt details
  server.get('/:receiptNumber', {
    schema: {
      tags: ['Receipts'],
      description: 'Get receipt details by receipt number'
    }
  }, async (request: FastifyRequest<{ Params: { receiptNumber: string } }>, reply: FastifyReply) => {
    const { receiptNumber } = request.params;
    return { receiptNumber, status: 'applied' };
  });
}
