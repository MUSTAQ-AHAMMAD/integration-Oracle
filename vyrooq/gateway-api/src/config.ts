import * as dotenv from 'dotenv';

dotenv.config();

export const config = {
  env: process.env.NODE_ENV || 'development',
  server: {
    port: parseInt(process.env.PORT || '3000', 10),
    host: process.env.HOST || 'localhost'
  },
  database: {
    url: process.env.DATABASE_URL || 'postgresql://postgres:vyrooq123@localhost:5432/vyrooq'
  },
  redis: {
    url: process.env.REDIS_URL || 'redis://localhost:6379'
  },
  rabbitmq: {
    url: process.env.RABBITMQ_URL || 'amqp://vyrooq:vyrooq123@localhost:5672'
  },
  kafka: {
    brokers: (process.env.KAFKA_BROKERS || 'localhost:9092').split(',')
  },
  temporal: {
    host: process.env.TEMPORAL_HOST || 'localhost:7233'
  },
  jwt: {
    secret: process.env.JWT_SECRET || 'vyrooq-secret-change-in-production',
    expiresIn: process.env.JWT_EXPIRES_IN || '24h'
  },
  cors: {
    origin: process.env.CORS_ORIGIN || '*'
  },
  fusion: {
    baseUrl: process.env.FUSION_BASE_URL || '',
    username: process.env.FUSION_USERNAME || '',
    password: process.env.FUSION_PASSWORD || ''
  },
  vendhq: {
    apiUrl: process.env.VENDHQ_API_URL || '',
    apiToken: process.env.VENDHQ_API_TOKEN || ''
  },
  opencart: {
    apiUrl: process.env.OPENCART_API_URL || '',
    apiKey: process.env.OPENCART_API_KEY || ''
  }
};
