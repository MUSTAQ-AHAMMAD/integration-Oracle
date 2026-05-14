import { FastifyInstance } from 'fastify';
import { z } from 'zod';
import { v4 as uuidv4 } from 'uuid';
import {
  loginSchema,
  registerSchema,
  changePasswordSchema,
  UserRole,
  ROLE_PERMISSIONS,
  type TokenResponse,
  type JWTPayload,
} from '../models/auth.models.js';
import { PasswordService } from '../utils/password.js';
import { redisClient } from '../utils/redis.js';
import { logger } from '../utils/logger.js';
import { authenticate } from '../middleware/auth.middleware.js';
import { config } from '../config.js';

export async function authRoutes(fastify: FastifyInstance) {
  /**
   * POST /auth/register - Register new user
   */
  fastify.post('/auth/register', async (request, reply) => {
    try {
      const body = registerSchema.parse(request.body);

      // Validate password strength
      const passwordValidation = PasswordService.validateStrength(body.password);
      if (!passwordValidation.valid) {
        return reply.code(400).send({
          error: 'Invalid password',
          message: 'Password does not meet requirements',
          errors: passwordValidation.errors,
        });
      }

      // Check if user already exists
      const existingUser = await fastify.db.user.findFirst({
        where: {
          OR: [{ email: body.email }, { username: body.username }],
        },
      });

      if (existingUser) {
        return reply.code(409).send({
          error: 'User already exists',
          message: 'Email or username is already taken',
        });
      }

      // Hash password
      const passwordHash = await PasswordService.hash(body.password);

      // Create user
      const user = await fastify.db.user.create({
        data: {
          id: uuidv4(),
          email: body.email,
          username: body.username,
          passwordHash,
          role: body.role || UserRole.VIEWER,
          isActive: true,
        },
      });

      logger.info({ userId: user.id, email: user.email }, 'User registered successfully');

      return reply.code(201).send({
        message: 'User registered successfully',
        user: {
          id: user.id,
          email: user.email,
          username: user.username,
          role: user.role,
        },
      });
    } catch (error) {
      if (error instanceof z.ZodError) {
        return reply.code(400).send({
          error: 'Validation error',
          message: 'Invalid request data',
          errors: error.errors,
        });
      }
      logger.error({ error }, 'Registration error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: 'Failed to register user',
      });
    }
  });

  /**
   * POST /auth/login - User login
   */
  fastify.post<{ Body: z.infer<typeof loginSchema> }>('/auth/login', async (request, reply) => {
    try {
      const { email, password } = loginSchema.parse(request.body);

      // Find user
      const user = await fastify.db.user.findUnique({
        where: { email },
      });

      if (!user || !user.isActive) {
        return reply.code(401).send({
          error: 'Authentication failed',
          message: 'Invalid email or password',
        });
      }

      // Verify password
      const isValidPassword = await PasswordService.compare(password, user.passwordHash);
      if (!isValidPassword) {
        return reply.code(401).send({
          error: 'Authentication failed',
          message: 'Invalid email or password',
        });
      }

      // Get user permissions based on role
      const permissions = ROLE_PERMISSIONS[user.role as UserRole] || [];

      // Create JWT payload
      const payload: JWTPayload = {
        userId: user.id,
        email: user.email,
        username: user.username,
        role: user.role as UserRole,
        permissions,
      };

      // Generate tokens
      const accessToken = fastify.jwt.sign(payload, {
        expiresIn: config.jwt.expiresIn,
      });

      const refreshToken = fastify.jwt.sign(payload, {
        expiresIn: config.jwt.refreshExpiresIn,
      });

      // Store refresh token in Redis
      await redisClient.set(
        `refresh_token:${user.id}`,
        refreshToken,
        7 * 24 * 60 * 60 // 7 days
      );

      // Update last login
      await fastify.db.user.update({
        where: { id: user.id },
        data: { lastLoginAt: new Date() },
      });

      logger.info({ userId: user.id, email: user.email }, 'User logged in successfully');

      const response: TokenResponse = {
        accessToken,
        refreshToken,
        expiresIn: 24 * 60 * 60, // 24 hours in seconds
        tokenType: 'Bearer',
      };

      return reply.send(response);
    } catch (error) {
      if (error instanceof z.ZodError) {
        return reply.code(400).send({
          error: 'Validation error',
          message: 'Invalid request data',
          errors: error.errors,
        });
      }
      logger.error({ error }, 'Login error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: 'Failed to login',
      });
    }
  });

  /**
   * POST /auth/refresh - Refresh access token
   */
  fastify.post('/auth/refresh', async (request, reply) => {
    try {
      const { refreshToken } = request.body as { refreshToken: string };

      if (!refreshToken) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'Refresh token is required',
        });
      }

      // Verify refresh token
      const decoded = fastify.jwt.verify(refreshToken) as JWTPayload;

      // Check if refresh token exists in Redis
      const storedToken = await redisClient.get(`refresh_token:${decoded.userId}`);
      if (storedToken !== refreshToken) {
        return reply.code(401).send({
          error: 'Invalid token',
          message: 'Refresh token is invalid or expired',
        });
      }

      // Generate new access token
      const newPayload: JWTPayload = {
        userId: decoded.userId,
        email: decoded.email,
        username: decoded.username,
        role: decoded.role,
        permissions: decoded.permissions,
      };

      const accessToken = fastify.jwt.sign(newPayload, {
        expiresIn: config.jwt.expiresIn,
      });

      logger.info({ userId: decoded.userId }, 'Token refreshed successfully');

      return reply.send({
        accessToken,
        expiresIn: 24 * 60 * 60,
        tokenType: 'Bearer',
      });
    } catch (error) {
      logger.error({ error }, 'Token refresh error');
      return reply.code(401).send({
        error: 'Invalid token',
        message: 'Failed to refresh token',
      });
    }
  });

  /**
   * POST /auth/logout - User logout
   */
  fastify.post('/auth/logout', { preHandler: authenticate }, async (request, reply) => {
    try {
      const user = request.user as JWTPayload;

      // Remove refresh token from Redis
      await redisClient.del(`refresh_token:${user.userId}`);

      logger.info({ userId: user.userId }, 'User logged out successfully');

      return reply.send({
        message: 'Logged out successfully',
      });
    } catch (error) {
      logger.error({ error }, 'Logout error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: 'Failed to logout',
      });
    }
  });

  /**
   * GET /auth/me - Get current user info
   */
  fastify.get('/auth/me', { preHandler: authenticate }, async (request, reply) => {
    const user = request.user as JWTPayload;

    try {
      const userRecord = await fastify.db.user.findUnique({
        where: { id: user.userId },
        select: {
          id: true,
          email: true,
          username: true,
          role: true,
          isActive: true,
          createdAt: true,
          lastLoginAt: true,
        },
      });

      if (!userRecord) {
        return reply.code(404).send({
          error: 'Not found',
          message: 'User not found',
        });
      }

      return reply.send({
        user: userRecord,
        permissions: user.permissions,
      });
    } catch (error) {
      logger.error({ error }, 'Get current user error');
      return reply.code(500).send({
        error: 'Internal server error',
        message: 'Failed to get user info',
      });
    }
  });

  /**
   * POST /auth/change-password - Change user password
   */
  fastify.post(
    '/auth/change-password',
    { preHandler: authenticate },
    async (request, reply) => {
      try {
        const user = request.user as JWTPayload;
        const body = changePasswordSchema.parse(request.body);

        // Get user from database
        const userRecord = await fastify.db.user.findUnique({
          where: { id: user.userId },
        });

        if (!userRecord) {
          return reply.code(404).send({
            error: 'Not found',
            message: 'User not found',
          });
        }

        // Verify current password
        const isValidPassword = await PasswordService.compare(
          body.currentPassword,
          userRecord.passwordHash
        );

        if (!isValidPassword) {
          return reply.code(401).send({
            error: 'Authentication failed',
            message: 'Current password is incorrect',
          });
        }

        // Validate new password strength
        const passwordValidation = PasswordService.validateStrength(body.newPassword);
        if (!passwordValidation.valid) {
          return reply.code(400).send({
            error: 'Invalid password',
            message: 'New password does not meet requirements',
            errors: passwordValidation.errors,
          });
        }

        // Hash new password
        const newPasswordHash = await PasswordService.hash(body.newPassword);

        // Update password
        await fastify.db.user.update({
          where: { id: user.userId },
          data: { passwordHash: newPasswordHash },
        });

        // Invalidate all refresh tokens
        await redisClient.del(`refresh_token:${user.userId}`);

        logger.info({ userId: user.userId }, 'Password changed successfully');

        return reply.send({
          message: 'Password changed successfully',
        });
      } catch (error) {
        if (error instanceof z.ZodError) {
          return reply.code(400).send({
            error: 'Validation error',
            message: 'Invalid request data',
            errors: error.errors,
          });
        }
        logger.error({ error }, 'Change password error');
        return reply.code(500).send({
          error: 'Internal server error',
          message: 'Failed to change password',
        });
      }
    }
  );

  /**
   * POST /auth/validate - Validate JWT token
   */
  fastify.post('/auth/validate', async (request, reply) => {
    try {
      const { token } = request.body as { token: string };

      if (!token) {
        return reply.code(400).send({
          error: 'Bad request',
          message: 'Token is required',
        });
      }

      // Verify token
      const decoded = fastify.jwt.verify(token) as JWTPayload;

      return reply.send({
        valid: true,
        user: {
          userId: decoded.userId,
          email: decoded.email,
          username: decoded.username,
          role: decoded.role,
          permissions: decoded.permissions,
        },
      });
    } catch (error) {
      return reply.send({
        valid: false,
        error: 'Invalid or expired token',
      });
    }
  });
}
