# Production-ready Dockerfile for Oracle CRM
FROM node:18-alpine AS base

# Install system dependencies for better-sqlite3 and oracledb
RUN apk add --no-cache \
    python3 \
    make \
    g++ \
    libaio \
    libnsl \
    && ln -s /usr/lib/libnsl.so.2 /usr/lib/libnsl.so.1

WORKDIR /app

# Copy package files
COPY package*.json ./

# Install dependencies
RUN npm ci --only=production && npm cache clean --force

# Copy application code
COPY . .

# Create necessary directories
RUN mkdir -p data logs

# Set proper permissions
RUN chown -R node:node /app

# Use non-root user
USER node

# Expose port
EXPOSE 3000

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
  CMD node scripts/health-check.js || exit 1

# Start application
CMD ["node", "server.js"]
