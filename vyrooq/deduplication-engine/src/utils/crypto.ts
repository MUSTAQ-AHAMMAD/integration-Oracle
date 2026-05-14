import crypto from 'crypto';

/**
 * Generate SHA-256 hash for transaction fingerprinting
 */
export function generateFingerprint(data: any): string {
  const normalized = normalizeForFingerprint(data);
  const json = JSON.stringify(normalized);
  return crypto.createHash('sha256').update(json).digest('hex');
}

/**
 * Normalize data for consistent fingerprinting
 * Removes timestamps, IDs, and other volatile fields
 */
function normalizeForFingerprint(data: any): any {
  if (Array.isArray(data)) {
    return data.map(normalizeForFingerprint).sort();
  }

  if (data !== null && typeof data === 'object') {
    const normalized: any = {};

    // Fields to exclude from fingerprint
    const excludeFields = [
      'id',
      'createdAt',
      'updatedAt',
      'timestamp',
      'requestId',
      'correlationId',
      'processedAt',
      'attemptNumber',
    ];

    for (const key of Object.keys(data).sort()) {
      if (!excludeFields.includes(key)) {
        normalized[key] = normalizeForFingerprint(data[key]);
      }
    }

    return normalized;
  }

  return data;
}

/**
 * Generate idempotency key from request data
 */
export function generateIdempotencyKey(
  operation: string,
  entityId: string,
  additionalData?: any
): string {
  const parts = [operation, entityId];

  if (additionalData) {
    const hash = generateFingerprint(additionalData);
    parts.push(hash.substring(0, 16)); // Use first 16 chars of hash
  }

  return parts.join(':');
}

/**
 * Generate correlation ID
 */
export function generateCorrelationId(): string {
  return `corr-${Date.now()}-${crypto.randomBytes(8).toString('hex')}`;
}

/**
 * Validate UUID format
 */
export function isValidUUID(uuid: string): boolean {
  const uuidRegex =
    /^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$/i;
  return uuidRegex.test(uuid);
}
