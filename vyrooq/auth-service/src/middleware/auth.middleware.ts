import { FastifyRequest, FastifyReply } from 'fastify';
import { logger } from '../utils/logger.js';
import { JWTPayload, Permission } from '../models/auth.models.js';

// Extend FastifyRequest to include user
declare module 'fastify' {
  interface FastifyRequest {
    user?: JWTPayload;
  }
}

/**
 * Authenticate middleware - Verifies JWT token
 */
export async function authenticate(
  request: FastifyRequest,
  reply: FastifyReply
): Promise<void> {
  try {
    // JWT verification is handled by @fastify/jwt plugin
    await request.jwtVerify();

    // User payload is automatically attached to request.user
    if (!request.user) {
      return reply.code(401).send({
        error: 'Unauthorized',
        message: 'Invalid or missing authentication token',
      });
    }
  } catch (error) {
    logger.error({ error }, 'Authentication error');
    return reply.code(401).send({
      error: 'Unauthorized',
      message: 'Invalid or expired authentication token',
    });
  }
}

/**
 * Authorize middleware factory - Checks if user has required permissions
 */
export function authorize(...requiredPermissions: Permission[]) {
  return async (request: FastifyRequest, reply: FastifyReply): Promise<void> => {
    const user = request.user as JWTPayload;

    if (!user) {
      return reply.code(401).send({
        error: 'Unauthorized',
        message: 'Authentication required',
      });
    }

    // Check if user has all required permissions
    const hasPermissions = requiredPermissions.every((permission) =>
      user.permissions.includes(permission)
    );

    if (!hasPermissions) {
      logger.warn(
        {
          userId: user.userId,
          requiredPermissions,
          userPermissions: user.permissions,
        },
        'Authorization failed - insufficient permissions'
      );

      return reply.code(403).send({
        error: 'Forbidden',
        message: 'Insufficient permissions to access this resource',
        required: requiredPermissions,
      });
    }
  };
}

/**
 * Require role middleware factory - Checks if user has specific role
 */
export function requireRole(...allowedRoles: string[]) {
  return async (request: FastifyRequest, reply: FastifyReply): Promise<void> => {
    const user = request.user as JWTPayload;

    if (!user) {
      return reply.code(401).send({
        error: 'Unauthorized',
        message: 'Authentication required',
      });
    }

    if (!allowedRoles.includes(user.role)) {
      logger.warn(
        {
          userId: user.userId,
          userRole: user.role,
          allowedRoles,
        },
        'Authorization failed - insufficient role'
      );

      return reply.code(403).send({
        error: 'Forbidden',
        message: 'Insufficient role to access this resource',
        required: allowedRoles,
      });
    }
  };
}
