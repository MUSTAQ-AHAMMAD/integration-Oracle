/**
 * Audit Engine
 * Event sourcing and comprehensive audit trail system
 */

import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import { PrismaClient } from '@prisma/client';
import Redis from 'ioredis';
import { z } from 'zod';

const prisma = new PrismaClient();
const redis = new Redis(process.env.REDIS_URL || 'redis://localhost:6379');

const fastify = Fastify({
  logger: {
    level: process.env.LOG_LEVEL || 'info',
    transport: {
      target: 'pino-pretty',
      options: {
        colorize: true,
        translateTime: 'HH:MM:ss Z',
        ignore: 'pid,hostname'
      }
    }
  }
});

// Register plugins
fastify.register(cors);
fastify.register(helmet);

/**
 * Audit event schema
 */
const AuditEventSchema = z.object({
  eventType: z.string(),
  entityType: z.string(),
  entityId: z.string(),
  action: z.enum(['CREATE', 'UPDATE', 'DELETE', 'RETRY', 'VALIDATE', 'ERROR']),
  userId: z.string().optional(),
  metadata: z.record(z.any()).optional(),
  changes: z.record(z.any()).optional()
});

type AuditEvent = z.infer<typeof AuditEventSchema>;

/**
 * Log audit event
 */
async function logAuditEvent(event: AuditEvent): Promise<void> {
  const auditRecord = await prisma.audit_events.create({
    data: {
      event_type: event.eventType,
      entity_type: event.entityType,
      entity_id: event.entityId,
      action: event.action,
      user_id: event.userId || 'system',
      metadata: JSON.stringify(event.metadata || {}),
      changes: JSON.stringify(event.changes || {}),
      timestamp: new Date()
    }
  });

  // Cache recent events in Redis
  const cacheKey = `audit:recent:${event.entityType}:${event.entityId}`;
  await redis.lpush(cacheKey, JSON.stringify(auditRecord));
  await redis.ltrim(cacheKey, 0, 99); // Keep last 100 events
  await redis.expire(cacheKey, 86400); // 24 hour expiry

  fastify.log.info(`Audit event logged: ${event.eventType} for ${event.entityType}:${event.entityId}`);
}

/**
 * Get audit trail for entity
 */
async function getAuditTrail(
  entityType: string,
  entityId: string,
  limit: number = 100
): Promise<any[]> {
  // Try cache first
  const cacheKey = `audit:recent:${entityType}:${entityId}`;
  const cached = await redis.lrange(cacheKey, 0, limit - 1);

  if (cached.length > 0) {
    return cached.map(c => JSON.parse(c));
  }

  // Fallback to database
  const events = await prisma.audit_events.findMany({
    where: {
      entity_type: entityType,
      entity_id: entityId
    },
    orderBy: { timestamp: 'desc' },
    take: limit
  });

  return events;
}

// Health check
fastify.get('/health', async () => {
  return { status: 'healthy', service: 'audit-engine', version: '1.0.0' };
});

fastify.get('/ready', async () => {
  try {
    await prisma.$queryRaw`SELECT 1`;
    await redis.ping();
    return { status: 'ready' };
  } catch (error) {
    return { status: 'not ready', error };
  }
});

/**
 * Create audit event
 */
fastify.post<{ Body: AuditEvent }>('/events', async (request, reply) => {
  try {
    const event = AuditEventSchema.parse(request.body);
    await logAuditEvent(event);
    return { success: true, message: 'Audit event logged' };
  } catch (error) {
    fastify.log.error(error);
    return reply.code(400).send({ error: 'Invalid audit event data' });
  }
});

/**
 * Get audit trail for entity
 */
fastify.get<{
  Params: { entityType: string; entityId: string };
  Querystring: { limit?: string };
}>('/events/:entityType/:entityId', async (request) => {
  const { entityType, entityId } = request.params;
  const limit = parseInt(request.query.limit || '100', 10);

  const trail = await getAuditTrail(entityType, entityId, limit);

  return {
    entityType,
    entityId,
    count: trail.length,
    events: trail
  };
});

/**
 * Search audit events
 */
fastify.post<{
  Body: {
    eventType?: string;
    entityType?: string;
    action?: string;
    userId?: string;
    startDate?: string;
    endDate?: string;
    limit?: number;
  };
}>('/events/search', async (request) => {
  const {
    eventType,
    entityType,
    action,
    userId,
    startDate,
    endDate,
    limit = 100
  } = request.body;

  const where: any = {};

  if (eventType) where.event_type = eventType;
  if (entityType) where.entity_type = entityType;
  if (action) where.action = action;
  if (userId) where.user_id = userId;

  if (startDate || endDate) {
    where.timestamp = {};
    if (startDate) where.timestamp.gte = new Date(startDate);
    if (endDate) where.timestamp.lte = new Date(endDate);
  }

  const events = await prisma.audit_events.findMany({
    where,
    orderBy: { timestamp: 'desc' },
    take: limit
  });

  return {
    count: events.length,
    events
  };
});

/**
 * Get audit statistics
 */
fastify.get('/stats', async () => {
  const [totalEvents, eventsByType, eventsByAction] = await Promise.all([
    prisma.audit_events.count(),
    prisma.$queryRaw`
      SELECT event_type, COUNT(*)::int as count
      FROM audit_events
      WHERE timestamp > NOW() - INTERVAL '24 hours'
      GROUP BY event_type
      ORDER BY count DESC
      LIMIT 10
    `,
    prisma.$queryRaw`
      SELECT action, COUNT(*)::int as count
      FROM audit_events
      WHERE timestamp > NOW() - INTERVAL '24 hours'
      GROUP BY action
      ORDER BY count DESC
    `
  ]);

  return {
    totalEvents,
    last24Hours: {
      byType: eventsByType,
      byAction: eventsByAction
    }
  };
});

/**
 * Get recent errors
 */
fastify.get('/errors', async (request) => {
  const errors = await prisma.audit_events.findMany({
    where: {
      action: 'ERROR',
      timestamp: {
        gte: new Date(Date.now() - 24 * 60 * 60 * 1000) // Last 24 hours
      }
    },
    orderBy: { timestamp: 'desc' },
    take: 100
  });

  return {
    count: errors.length,
    errors
  };
});

/**
 * Export audit data
 */
fastify.post<{
  Body: {
    startDate: string;
    endDate: string;
    entityType?: string;
    format?: 'json' | 'csv';
  };
}>('/export', async (request, reply) => {
  const { startDate, endDate, entityType, format = 'json' } = request.body;

  if (!startDate || !endDate) {
    return reply.code(400).send({ error: 'startDate and endDate are required' });
  }

  const where: any = {
    timestamp: {
      gte: new Date(startDate),
      lte: new Date(endDate)
    }
  };

  if (entityType) {
    where.entity_type = entityType;
  }

  const events = await prisma.audit_events.findMany({
    where,
    orderBy: { timestamp: 'asc' }
  });

  if (format === 'csv') {
    // Generate CSV
    const headers = ['timestamp', 'event_type', 'entity_type', 'entity_id', 'action', 'user_id'];
    const csv = [
      headers.join(','),
      ...events.map(e =>
        [
          e.timestamp.toISOString(),
          e.event_type,
          e.entity_type,
          e.entity_id,
          e.action,
          e.user_id
        ].join(',')
      )
    ].join('\n');

    reply.header('Content-Type', 'text/csv');
    reply.header('Content-Disposition', `attachment; filename="audit-export-${Date.now()}.csv"`);
    return csv;
  }

  return {
    startDate,
    endDate,
    count: events.length,
    events
  };
});

/**
 * Get compliance report
 */
fastify.get('/compliance/report', async () => {
  const thirtyDaysAgo = new Date(Date.now() - 30 * 24 * 60 * 60 * 1000);

  const [
    totalTransactions,
    failedTransactions,
    retriedTransactions,
    dataModifications
  ] = await Promise.all([
    prisma.audit_events.count({
      where: {
        event_type: 'TRANSACTION',
        timestamp: { gte: thirtyDaysAgo }
      }
    }),
    prisma.audit_events.count({
      where: {
        action: 'ERROR',
        timestamp: { gte: thirtyDaysAgo }
      }
    }),
    prisma.audit_events.count({
      where: {
        action: 'RETRY',
        timestamp: { gte: thirtyDaysAgo }
      }
    }),
    prisma.audit_events.count({
      where: {
        action: { in: ['UPDATE', 'DELETE'] },
        timestamp: { gte: thirtyDaysAgo }
      }
    })
  ]);

  const successRate = totalTransactions > 0
    ? ((totalTransactions - failedTransactions) / totalTransactions * 100).toFixed(2)
    : '100.00';

  return {
    period: 'Last 30 Days',
    summary: {
      totalTransactions,
      failedTransactions,
      retriedTransactions,
      dataModifications,
      successRate: `${successRate}%`
    },
    reportDate: new Date().toISOString()
  };
});

// Start server
const start = async () => {
  try {
    const port = parseInt(process.env.PORT || '3600', 10);
    await fastify.listen({ port, host: '0.0.0.0' });
    fastify.log.info(`Audit Engine listening on port ${port}`);
  } catch (err) {
    fastify.log.error(err);
    process.exit(1);
  }
};

start();
