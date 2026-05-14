# Auth Service

JWT Authentication and Role-Based Access Control (RBAC) service for Vyrooq Integration Platform.

## Features

- ✅ JWT authentication with access and refresh tokens
- ✅ Role-Based Access Control (RBAC)
- ✅ Permission-based authorization
- ✅ Password hashing with bcrypt
- ✅ Password strength validation
- ✅ Redis-based token storage
- ✅ Rate limiting
- ✅ CORS protection
- ✅ Request logging
- ✅ Health check endpoints

## User Roles

- **SUPER_ADMIN**: Full system access
- **ADMIN**: Manage operations, users, and configurations
- **MANAGER**: Process sales, manage workflows
- **OPERATOR**: Execute operations, read data
- **VIEWER**: Read-only access

## API Endpoints

### Authentication

- `POST /auth/register` - Register new user
- `POST /auth/login` - User login
- `POST /auth/logout` - User logout (requires auth)
- `POST /auth/refresh` - Refresh access token
- `POST /auth/validate` - Validate JWT token

### User Management

- `GET /auth/me` - Get current user info (requires auth)
- `POST /auth/change-password` - Change password (requires auth)

### Health Checks

- `GET /health` - Service health status
- `GET /ready` - Service readiness check

## Setup

1. Install dependencies:
```bash
npm install
```

2. Configure environment:
```bash
cp ../.env.example .env
```

3. Run migrations:
```bash
npx prisma migrate dev
```

4. Start service:
```bash
npm run dev
```

## Environment Variables

```env
PORT=3100
NODE_ENV=development
DATABASE_URL=postgresql://postgres:vyrooq123@localhost:5432/vyrooq
REDIS_URL=redis://localhost:6379
JWT_SECRET=your-secret-key-change-in-production
JWT_EXPIRES_IN=24h
JWT_REFRESH_EXPIRES_IN=7d
RATE_LIMIT_MAX=100
CORS_ORIGIN=*
```

## Usage Examples

### Register User

```bash
curl -X POST http://localhost:3100/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@vyrooq.com",
    "username": "admin",
    "password": "Admin123!@#",
    "role": "ADMIN"
  }'
```

### Login

```bash
curl -X POST http://localhost:3100/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@vyrooq.com",
    "password": "Admin123!@#"
  }'
```

### Get Current User

```bash
curl -X GET http://localhost:3100/auth/me \
  -H "Authorization: Bearer <access_token>"
```

## Docker

Build and run:

```bash
docker build -t vyrooq-auth-service .
docker run -p 3100:3100 --env-file .env vyrooq-auth-service
```

## License

MIT
