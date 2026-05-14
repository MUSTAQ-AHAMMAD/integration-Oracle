import pino from 'pino';
import { config } from '../config';

export const logger = pino({
  level: config.env === 'production' ? 'info' : 'debug',
  transport: config.env === 'development' ? {
    target: 'pino-pretty',
    options: {
      colorize: true,
      translateTime: 'SYS:standard',
      ignore: 'pid,hostname'
    }
  } : undefined,
  formatters: {
    level: (label) => {
      return { level: label.toUpperCase() };
    }
  },
  serializers: {
    req: (request: any) => ({
      method: request.method,
      url: request.url,
      correlationId: request.headers['x-correlation-id'],
      userAgent: request.headers['user-agent']
    }),
    res: (response: any) => ({
      statusCode: response.statusCode
    }),
    err: pino.stdSerializers.err
  }
});
