/**
 * Event Bus
 * Kafka producer/consumer service for event-driven architecture
 */

import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import { Kafka, Producer, Consumer, Admin, logLevel } from 'kafkajs';
import { z } from 'zod';

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

// Kafka client
const kafka = new Kafka({
  clientId: 'vyrooq-event-bus',
  brokers: (process.env.KAFKA_BROKERS || 'localhost:9092').split(','),
  logLevel: logLevel.INFO
});

let producer: Producer;
let consumers: Map<string, Consumer> = new Map();
let admin: Admin;

// Event schema
const EventSchema = z.object({
  topic: z.string(),
  key: z.string().optional(),
  value: z.record(z.any()),
  headers: z.record(z.string()).optional()
});

type Event = z.infer<typeof EventSchema>;

// Topic definitions
const TOPICS = {
  SALES_CREATED: 'vyrooq.sales.created',
  SALES_UPDATED: 'vyrooq.sales.updated',
  INVOICE_CREATED: 'vyrooq.invoices.created',
  INVOICE_FAILED: 'vyrooq.invoices.failed',
  RECEIPT_CREATED: 'vyrooq.receipts.created',
  RECEIPT_FAILED: 'vyrooq.receipts.failed',
  INVENTORY_UPDATED: 'vyrooq.inventory.updated',
  RECONCILIATION_COMPLETED: 'vyrooq.reconciliation.completed',
  RECONCILIATION_FAILED: 'vyrooq.reconciliation.failed',
  AUDIT_EVENT: 'vyrooq.audit.event',
  WORKFLOW_STARTED: 'vyrooq.workflow.started',
  WORKFLOW_COMPLETED: 'vyrooq.workflow.completed',
  WORKFLOW_FAILED: 'vyrooq.workflow.failed',
  RETRY_SCHEDULED: 'vyrooq.retry.scheduled',
  RETRY_EXHAUSTED: 'vyrooq.retry.exhausted'
};

/**
 * Initialize Kafka producer and admin
 */
async function initializeKafka() {
  // Create producer
  producer = kafka.producer({
    allowAutoTopicCreation: false,
    transactionTimeout: 30000
  });

  await producer.connect();
  fastify.log.info('Kafka producer connected');

  // Create admin client
  admin = kafka.admin();
  await admin.connect();
  fastify.log.info('Kafka admin connected');

  // Ensure all topics exist
  const existingTopics = await admin.listTopics();
  const topicsToCreate = Object.values(TOPICS).filter(
    topic => !existingTopics.includes(topic)
  );

  if (topicsToCreate.length > 0) {
    await admin.createTopics({
      topics: topicsToCreate.map(topic => ({
        topic,
        numPartitions: 3,
        replicationFactor: 1,
        configEntries: [
          { name: 'retention.ms', value: '604800000' }, // 7 days
          { name: 'compression.type', value: 'snappy' }
        ]
      }))
    });
    fastify.log.info(`Created ${topicsToCreate.length} Kafka topics`);
  }
}

/**
 * Publish event to Kafka
 */
async function publishEvent(event: Event): Promise<void> {
  try {
    await producer.send({
      topic: event.topic,
      messages: [{
        key: event.key,
        value: JSON.stringify(event.value),
        headers: event.headers
      }]
    });

    fastify.log.info(`Event published to ${event.topic}`);
  } catch (error) {
    fastify.log.error(`Failed to publish event: ${error}`);
    throw error;
  }
}

/**
 * Create consumer for topic
 */
async function createConsumer(
  topic: string,
  groupId: string,
  handler: (message: any) => Promise<void>
): Promise<Consumer> {
  const consumer = kafka.consumer({
    groupId,
    sessionTimeout: 30000,
    heartbeatInterval: 3000
  });

  await consumer.connect();
  await consumer.subscribe({ topic, fromBeginning: false });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      try {
        const value = JSON.parse(message.value?.toString() || '{}');
        fastify.log.info(`Received message from ${topic} partition ${partition}`);
        await handler(value);
      } catch (error) {
        fastify.log.error(`Error processing message: ${error}`);
      }
    }
  });

  consumers.set(`${groupId}:${topic}`, consumer);
  fastify.log.info(`Consumer created for topic ${topic} with group ${groupId}`);

  return consumer;
}

// Health check
fastify.get('/health', async () => {
  return { status: 'healthy', service: 'event-bus', version: '1.0.0' };
});

fastify.get('/ready', async () => {
  try {
    await admin.listTopics();
    return { status: 'ready' };
  } catch (error) {
    return { status: 'not ready', error };
  }
});

/**
 * Publish event endpoint
 */
fastify.post<{ Body: Event }>('/publish', async (request, reply) => {
  try {
    const event = EventSchema.parse(request.body);
    await publishEvent(event);
    return { success: true, message: 'Event published' };
  } catch (error) {
    fastify.log.error(error);
    return reply.code(400).send({ error: 'Invalid event data' });
  }
});

/**
 * Publish batch events
 */
fastify.post<{ Body: { events: Event[] } }>('/publish/batch', async (request, reply) => {
  try {
    const { events } = request.body;

    if (!Array.isArray(events) || events.length === 0) {
      return reply.code(400).send({ error: 'Events array is required' });
    }

    // Group events by topic
    const eventsByTopic = new Map<string, any[]>();
    for (const event of events) {
      const validated = EventSchema.parse(event);
      if (!eventsByTopic.has(validated.topic)) {
        eventsByTopic.set(validated.topic, []);
      }
      eventsByTopic.get(validated.topic)!.push({
        key: validated.key,
        value: JSON.stringify(validated.value),
        headers: validated.headers
      });
    }

    // Send to Kafka
    for (const [topic, messages] of eventsByTopic) {
      await producer.send({ topic, messages });
    }

    return {
      success: true,
      message: `Published ${events.length} events to ${eventsByTopic.size} topics`
    };
  } catch (error) {
    fastify.log.error(error);
    return reply.code(500).send({ error: 'Failed to publish batch events' });
  }
});

/**
 * Subscribe to topic (creates consumer)
 */
fastify.post<{
  Body: {
    topic: string;
    groupId: string;
    webhookUrl?: string;
  };
}>('/subscribe', async (request, reply) => {
  const { topic, groupId, webhookUrl } = request.body;

  if (!topic || !groupId) {
    return reply.code(400).send({ error: 'topic and groupId are required' });
  }

  const key = `${groupId}:${topic}`;
  if (consumers.has(key)) {
    return reply.code(409).send({ error: 'Consumer already exists for this topic and group' });
  }

  try {
    await createConsumer(topic, groupId, async (message) => {
      if (webhookUrl) {
        // Forward to webhook
        try {
          await fetch(webhookUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(message)
          });
        } catch (error) {
          fastify.log.error(`Webhook delivery failed: ${error}`);
        }
      }
      // Log message
      fastify.log.info(`Processed message: ${JSON.stringify(message)}`);
    });

    return { success: true, message: `Subscribed to ${topic}` };
  } catch (error) {
    fastify.log.error(error);
    return reply.code(500).send({ error: 'Failed to create consumer' });
  }
});

/**
 * List topics
 */
fastify.get('/topics', async () => {
  const topics = await admin.listTopics();
  return { topics, predefined: TOPICS };
});

/**
 * Get topic metadata
 */
fastify.get<{ Params: { topic: string } }>('/topics/:topic', async (request, reply) => {
  const { topic } = request.params;

  try {
    const metadata = await admin.fetchTopicMetadata({ topics: [topic] });
    return { topic, metadata };
  } catch (error) {
    return reply.code(404).send({ error: 'Topic not found' });
  }
});

/**
 * Get consumer group info
 */
fastify.get('/consumers', async () => {
  const groups = await admin.listGroups();
  return {
    groups,
    activeConsumers: Array.from(consumers.keys())
  };
});

/**
 * Get Kafka cluster info
 */
fastify.get('/cluster/info', async () => {
  const cluster = await admin.describeCluster();
  return cluster;
});

// Graceful shutdown
async function shutdown() {
  fastify.log.info('Shutting down event bus...');

  // Disconnect all consumers
  for (const [key, consumer] of consumers) {
    await consumer.disconnect();
    fastify.log.info(`Consumer ${key} disconnected`);
  }

  // Disconnect producer
  await producer.disconnect();
  fastify.log.info('Producer disconnected');

  // Disconnect admin
  await admin.disconnect();
  fastify.log.info('Admin disconnected');
}

process.on('SIGTERM', shutdown);
process.on('SIGINT', shutdown);

// Start server
const start = async () => {
  try {
    await initializeKafka();

    const port = parseInt(process.env.PORT || '3700', 10);
    await fastify.listen({ port, host: '0.0.0.0' });
    fastify.log.info(`Event Bus listening on port ${port}`);
  } catch (err) {
    fastify.log.error(err);
    process.exit(1);
  }
};

start();
