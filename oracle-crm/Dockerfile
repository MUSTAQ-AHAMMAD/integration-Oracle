# Production-ready Dockerfile for Oracle CRM
FROM node:18-slim AS base

# Install system dependencies for better-sqlite3, oracledb, and Oracle Instant Client
RUN apt-get update && apt-get install -y \
    python3 \
    make \
    g++ \
    libaio1 \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Download and install Oracle Instant Client
# This is required for node-oracledb thick mode to support Advanced Networking Options (NJS-533 fix)
RUN mkdir -p /opt/oracle && \
    cd /opt/oracle && \
    wget https://download.oracle.com/otn_software/linux/instantclient/2113000/instantclient-basic-linux.x64-21.13.0.0.0dbru.zip && \
    unzip instantclient-basic-linux.x64-21.13.0.0.0dbru.zip && \
    rm instantclient-basic-linux.x64-21.13.0.0.0dbru.zip && \
    echo /opt/oracle/instantclient_21_13 > /etc/ld.so.conf.d/oracle-instantclient.conf && \
    ldconfig

# Set environment variables for Oracle Instant Client
ENV ORACLE_HOME=/opt/oracle/instantclient_21_13
ENV LD_LIBRARY_PATH=$ORACLE_HOME:$LD_LIBRARY_PATH
ENV PATH=$ORACLE_HOME:$PATH

WORKDIR /app

# Copy package files
COPY package*.json ./

# Install dependencies
RUN npm install --omit=dev && npm cache clean --force

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
