# Build stage
FROM node:20-alpine AS builder

WORKDIR /app

# Copy package files
COPY package*.json ./

# npm install seems to hang after 80s but may still create node_modules
# Try npm ci, ignore errors, then check if we need to retry
RUN (timeout 300 npm ci 2>&1 || true) && \
    if [ ! -d "node_modules" ] || [ ! -f "node_modules/.bin/tsc" ]; then \
        echo "npm ci didn't complete, trying npm install..." && \
        (timeout 300 npm install --prefer-offline --no-audit --no-fund 2>&1 || true); \
    fi && \
    if [ ! -f "node_modules/.bin/tsc" ]; then \
        echo "TypeScript still missing, installing it separately..." && \
        npm install typescript@^5.6.0 --no-save --legacy-peer-deps; \
    fi

# Copy source code
COPY . .

# Build TypeScript
RUN npm run build

# Remove devDependencies after build
RUN npm prune --omit=dev

# Production stage
FROM node:20-alpine

WORKDIR /app

# Copy package files
COPY --from=builder /app/package*.json ./

# Copy production node_modules from builder
COPY --from=builder /app/node_modules ./node_modules

# Copy built artifacts from builder stage
COPY --from=builder /app/dist ./dist

# Expose port
EXPOSE 3700

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
  CMD node -e "require('http').get('http://localhost:3700/health', (r) => {process.exit(r.statusCode === 200 ? 0 : 1)})"

# Run the application
CMD ["npm", "start"]
