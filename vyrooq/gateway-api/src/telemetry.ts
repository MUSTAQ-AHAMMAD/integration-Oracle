import { NodeSDK } from '@opentelemetry/sdk-node';
import { getNodeAutoInstrumentations } from '@opentelemetry/auto-instrumentations-node';
import { logger } from './utils/logger';

export function setupOpenTelemetry() {
  const sdk = new NodeSDK({
    serviceName: 'vyrooq-gateway-api',
    instrumentations: [
      getNodeAutoInstrumentations({
        '@opentelemetry/instrumentation-fs': {
          enabled: false
        }
      })
    ]
  });

  try {
    sdk.start();
    logger.info('OpenTelemetry initialized');
  } catch (error) {
    logger.error('Error initializing OpenTelemetry:', error);
  }

  process.on('SIGTERM', () => {
    sdk.shutdown()
      .then(() => logger.info('OpenTelemetry shut down'))
      .catch((error) => logger.error('Error shutting down OpenTelemetry', error))
      .finally(() => process.exit(0));
  });
}
