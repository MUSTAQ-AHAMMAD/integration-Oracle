import { FastifyInstance } from 'fastify';
import { salesRoutes } from './sales.routes';
import { invoiceRoutes } from './invoice.routes';
import { receiptRoutes } from './receipt.routes';
import { controlRoutes } from './control.routes';
import { auditRoutes } from './audit.routes';

export function setupRoutes(server: FastifyInstance) {
  // Register all route modules
  server.register(salesRoutes, { prefix: '/api/sales' });
  server.register(invoiceRoutes, { prefix: '/api/invoices' });
  server.register(receiptRoutes, { prefix: '/api/receipts' });
  server.register(controlRoutes, { prefix: '/api/control' });
  server.register(auditRoutes, { prefix: '/api/audit' });
}
