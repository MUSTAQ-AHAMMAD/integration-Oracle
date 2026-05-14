import { Queue } from 'bullmq';
import IORedis from 'ioredis';
import { config } from '../config.js';
import { logger } from '../utils/logger.js';
import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();

// Redis connection for BullMQ
const redisConnection = new IORedis({
  host: config.redis.host,
  port: config.redis.port,
  password: config.redis.password,
  db: config.redis.db,
  maxRetriesPerRequest: null,
});

// Initialize all queues
const queues = {
  invoice: new Queue(config.queues.invoice, { connection: redisConnection }),
  receipt: new Queue(config.queues.receipt, { connection: redisConnection }),
  journal: new Queue(config.queues.journal, { connection: redisConnection }),
  inventory: new Queue(config.queues.inventory, { connection: redisConnection }),
  vendhq: new Queue(config.queues.vendhq, { connection: redisConnection }),
  dlq: new Queue(config.queues.dlq, { connection: redisConnection }),
};

export class ControlService {
  /**
   * Pause processing for specific queue
   */
  async pauseQueue(queueName: string): Promise<void> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    await queue.pause();

    // Log to database
    await prisma.controlEvent.create({
      data: {
        eventType: 'QUEUE_PAUSED',
        queueName,
        timestamp: new Date(),
      },
    });

    logger.info({ queueName }, 'Queue paused');
  }

  /**
   * Resume processing for specific queue
   */
  async resumeQueue(queueName: string): Promise<void> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    await queue.resume();

    // Log to database
    await prisma.controlEvent.create({
      data: {
        eventType: 'QUEUE_RESUMED',
        queueName,
        timestamp: new Date(),
      },
    });

    logger.info({ queueName }, 'Queue resumed');
  }

  /**
   * Get queue status
   */
  async getQueueStatus(queueName: string): Promise<any> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const [isPaused, waiting, active, completed, failed, delayed] = await Promise.all([
      queue.isPaused(),
      queue.getWaitingCount(),
      queue.getActiveCount(),
      queue.getCompletedCount(),
      queue.getFailedCount(),
      queue.getDelayedCount(),
    ]);

    return {
      name: queueName,
      isPaused,
      counts: {
        waiting,
        active,
        completed,
        failed,
        delayed,
        total: waiting + active + completed + failed + delayed,
      },
    };
  }

  /**
   * Get all queues status
   */
  async getAllQueuesStatus(): Promise<any[]> {
    const statuses = await Promise.all(
      Object.keys(queues).map((queueName) => this.getQueueStatus(queueName))
    );
    return statuses;
  }

  /**
   * Retry failed jobs in queue
   */
  async retryFailedJobs(queueName: string, limit: number = 10): Promise<number> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const failedJobs = await queue.getFailed(0, limit - 1);

    let retriedCount = 0;
    for (const job of failedJobs) {
      await job.retry();
      retriedCount++;
    }

    // Log to database
    await prisma.controlEvent.create({
      data: {
        eventType: 'JOBS_RETRIED',
        queueName,
        metadata: { count: retriedCount },
        timestamp: new Date(),
      },
    });

    logger.info({ queueName, retriedCount }, 'Failed jobs retried');
    return retriedCount;
  }

  /**
   * Retry specific job by ID
   */
  async retryJob(queueName: string, jobId: string): Promise<void> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const job = await queue.getJob(jobId);
    if (!job) {
      throw new Error(`Job ${jobId} not found in queue ${queueName}`);
    }

    await job.retry();

    logger.info({ queueName, jobId }, 'Job retried');
  }

  /**
   * Remove failed job
   */
  async removeJob(queueName: string, jobId: string): Promise<void> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const job = await queue.getJob(jobId);
    if (!job) {
      throw new Error(`Job ${jobId} not found in queue ${queueName}`);
    }

    await job.remove();

    logger.info({ queueName, jobId }, 'Job removed');
  }

  /**
   * Clean completed jobs
   */
  async cleanQueue(
    queueName: string,
    grace: number = 3600000, // 1 hour
    limit: number = 1000
  ): Promise<string[]> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const jobs = await queue.clean(grace, limit, 'completed');

    logger.info({ queueName, cleaned: jobs.length }, 'Queue cleaned');
    return jobs;
  }

  /**
   * Get failed jobs for manual review
   */
  async getFailedJobs(queueName: string, limit: number = 50): Promise<any[]> {
    const queue = queues[queueName as keyof typeof queues];
    if (!queue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const failedJobs = await queue.getFailed(0, limit - 1);

    return failedJobs.map((job) => ({
      id: job.id,
      name: job.name,
      data: job.data,
      failedReason: job.failedReason,
      attemptsMade: job.attemptsMade,
      timestamp: job.timestamp,
      processedOn: job.processedOn,
      finishedOn: job.finishedOn,
    }));
  }

  /**
   * Move failed job to DLQ
   */
  async moveToDLQ(queueName: string, jobId: string): Promise<void> {
    const sourceQueue = queues[queueName as keyof typeof queues];
    if (!sourceQueue) {
      throw new Error(`Queue ${queueName} not found`);
    }

    const job = await sourceQueue.getJob(jobId);
    if (!job) {
      throw new Error(`Job ${jobId} not found in queue ${queueName}`);
    }

    // Add to DLQ
    await queues.dlq.add('failed-job', {
      originalQueue: queueName,
      originalJobId: jobId,
      jobData: job.data,
      failedReason: job.failedReason,
      attemptsMade: job.attemptsMade,
      movedAt: new Date().toISOString(),
    });

    // Remove from original queue
    await job.remove();

    // Log to database
    await prisma.dlqRecord.create({
      data: {
        queueName,
        jobId,
        jobData: job.data as any,
        error: job.failedReason || 'Unknown error',
        failedAt: new Date(),
      },
    });

    logger.info({ queueName, jobId }, 'Job moved to DLQ');
  }

  /**
   * Force sync specific sale/transaction
   */
  async forceSync(saleId: string): Promise<void> {
    // Add job to invoice queue with high priority
    await queues.invoice.add(
      'force-sync',
      {
        saleId,
        forceSync: true,
        correlationId: `force-sync-${Date.now()}`,
      },
      {
        priority: 1, // Highest priority
      }
    );

    // Log to database
    await prisma.controlEvent.create({
      data: {
        eventType: 'FORCE_SYNC',
        entityId: saleId,
        metadata: { type: 'sale' },
        timestamp: new Date(),
      },
    });

    logger.info({ saleId }, 'Force sync initiated');
  }

  /**
   * Replay transaction from audit log
   */
  async replayTransaction(auditEventId: string): Promise<void> {
    // Get audit event
    const auditEvent = await prisma.auditEvent.findUnique({
      where: { id: auditEventId },
    });

    if (!auditEvent) {
      throw new Error(`Audit event ${auditEventId} not found`);
    }

    // Determine queue based on event type
    let queueName: string;
    if (auditEvent.eventType.includes('INVOICE')) {
      queueName = 'invoice';
    } else if (auditEvent.eventType.includes('RECEIPT')) {
      queueName = 'receipt';
    } else if (auditEvent.eventType.includes('JOURNAL')) {
      queueName = 'journal';
    } else {
      throw new Error(`Cannot replay event type: ${auditEvent.eventType}`);
    }

    const queue = queues[queueName as keyof typeof queues];

    // Add replay job
    await queue.add(
      'replay',
      {
        ...auditEvent.payload,
        isReplay: true,
        originalEventId: auditEventId,
        correlationId: `replay-${Date.now()}`,
      },
      {
        priority: 2,
      }
    );

    logger.info({ auditEventId, queueName }, 'Transaction replayed');
  }

  /**
   * Get control events history
   */
  async getControlHistory(limit: number = 100): Promise<any[]> {
    const events = await prisma.controlEvent.findMany({
      take: limit,
      orderBy: { timestamp: 'desc' },
    });

    return events;
  }

  /**
   * Pause all queues
   */
  async pauseAll(): Promise<void> {
    await Promise.all(
      Object.keys(queues).map((queueName) => this.pauseQueue(queueName))
    );

    logger.info('All queues paused');
  }

  /**
   * Resume all queues
   */
  async resumeAll(): Promise<void> {
    await Promise.all(
      Object.keys(queues).map((queueName) => this.resumeQueue(queueName))
    );

    logger.info('All queues resumed');
  }

  /**
   * Get DLQ records
   */
  async getDLQRecords(limit: number = 50): Promise<any[]> {
    const records = await prisma.dlqRecord.findMany({
      take: limit,
      orderBy: { failedAt: 'desc' },
    });

    return records;
  }

  /**
   * Cleanup
   */
  async close(): Promise<void> {
    await Promise.all(Object.values(queues).map((queue) => queue.close()));
    await redisConnection.quit();
    await prisma.$disconnect();
    logger.info('Control service closed');
  }
}
