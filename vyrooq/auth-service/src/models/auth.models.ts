import { z } from 'zod';

// User role enum
export enum UserRole {
  SUPER_ADMIN = 'SUPER_ADMIN',
  ADMIN = 'ADMIN',
  MANAGER = 'MANAGER',
  OPERATOR = 'OPERATOR',
  VIEWER = 'VIEWER',
}

// Permission enum
export enum Permission {
  // Sales permissions
  SALES_READ = 'sales:read',
  SALES_WRITE = 'sales:write',
  SALES_PROCESS = 'sales:process',
  SALES_DELETE = 'sales:delete',

  // Invoice permissions
  INVOICE_READ = 'invoice:read',
  INVOICE_WRITE = 'invoice:write',
  INVOICE_DELETE = 'invoice:delete',

  // Receipt permissions
  RECEIPT_READ = 'receipt:read',
  RECEIPT_WRITE = 'receipt:write',
  RECEIPT_DELETE = 'receipt:delete',

  // Control permissions
  CONTROL_PAUSE = 'control:pause',
  CONTROL_RESUME = 'control:resume',
  CONTROL_REPLAY = 'control:replay',
  CONTROL_RETRY = 'control:retry',
  CONTROL_FORCE_SYNC = 'control:force_sync',

  // Audit permissions
  AUDIT_READ = 'audit:read',
  AUDIT_EXPORT = 'audit:export',

  // User management
  USER_READ = 'user:read',
  USER_WRITE = 'user:write',
  USER_DELETE = 'user:delete',
  USER_ASSIGN_ROLE = 'user:assign_role',

  // System permissions
  SYSTEM_CONFIG = 'system:config',
  SYSTEM_MONITOR = 'system:monitor',
}

// Role-Permission mapping
export const ROLE_PERMISSIONS: Record<UserRole, Permission[]> = {
  [UserRole.SUPER_ADMIN]: Object.values(Permission),
  [UserRole.ADMIN]: [
    Permission.SALES_READ,
    Permission.SALES_WRITE,
    Permission.SALES_PROCESS,
    Permission.INVOICE_READ,
    Permission.INVOICE_WRITE,
    Permission.RECEIPT_READ,
    Permission.RECEIPT_WRITE,
    Permission.CONTROL_PAUSE,
    Permission.CONTROL_RESUME,
    Permission.CONTROL_REPLAY,
    Permission.CONTROL_RETRY,
    Permission.CONTROL_FORCE_SYNC,
    Permission.AUDIT_READ,
    Permission.AUDIT_EXPORT,
    Permission.USER_READ,
    Permission.SYSTEM_MONITOR,
  ],
  [UserRole.MANAGER]: [
    Permission.SALES_READ,
    Permission.SALES_WRITE,
    Permission.SALES_PROCESS,
    Permission.INVOICE_READ,
    Permission.RECEIPT_READ,
    Permission.CONTROL_REPLAY,
    Permission.CONTROL_RETRY,
    Permission.AUDIT_READ,
  ],
  [UserRole.OPERATOR]: [
    Permission.SALES_READ,
    Permission.SALES_PROCESS,
    Permission.INVOICE_READ,
    Permission.RECEIPT_READ,
    Permission.AUDIT_READ,
  ],
  [UserRole.VIEWER]: [
    Permission.SALES_READ,
    Permission.INVOICE_READ,
    Permission.RECEIPT_READ,
    Permission.AUDIT_READ,
  ],
};

// User model type
export interface User {
  id: string;
  email: string;
  username: string;
  passwordHash: string;
  role: UserRole;
  isActive: boolean;
  createdAt: Date;
  updatedAt: Date;
  lastLoginAt: Date | null;
}

// Validation schemas
export const loginSchema = z.object({
  email: z.string().email('Invalid email format'),
  password: z.string().min(1, 'Password is required'),
});

export const registerSchema = z.object({
  email: z.string().email('Invalid email format'),
  username: z.string().min(3, 'Username must be at least 3 characters').max(50),
  password: z.string().min(8, 'Password must be at least 8 characters'),
  role: z.nativeEnum(UserRole).optional().default(UserRole.VIEWER),
});

export const updateUserSchema = z.object({
  email: z.string().email().optional(),
  username: z.string().min(3).max(50).optional(),
  role: z.nativeEnum(UserRole).optional(),
  isActive: z.boolean().optional(),
});

export const changePasswordSchema = z.object({
  currentPassword: z.string().min(1),
  newPassword: z.string().min(8),
});

// JWT payload type
export interface JWTPayload {
  userId: string;
  email: string;
  username: string;
  role: UserRole;
  permissions: Permission[];
  iat?: number;
  exp?: number;
}

// Token response type
export interface TokenResponse {
  accessToken: string;
  refreshToken: string;
  expiresIn: number;
  tokenType: string;
}
