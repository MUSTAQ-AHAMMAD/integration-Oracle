#!/bin/bash

# Vyrooq Production Secrets Generator
# Generates strong secrets for production deployment

set -e

echo "=================================================="
echo "   Vyrooq Production Secrets Generator"
echo "=================================================="
echo ""
echo "This script generates strong random secrets for production deployment."
echo "Save these values in your .env file or secrets manager."
echo ""

# Check if openssl is available
if ! command -v openssl &> /dev/null; then
    echo "Error: openssl is required but not installed."
    exit 1
fi

echo "# Generated on: $(date)"
echo ""

echo "# JWT Secret (64 bytes base64)"
echo "JWT_SECRET=$(openssl rand -base64 64 | tr -d '\n')"
echo ""

echo "# Session Secret (32 bytes base64)"
echo "SESSION_SECRET=$(openssl rand -base64 32 | tr -d '\n')"
echo ""

echo "# Database Password (24 bytes base64)"
echo "POSTGRES_PASSWORD=$(openssl rand -base64 24 | tr -d '\n')"
echo ""

echo "# Redis Password (24 bytes base64)"
echo "REDIS_PASSWORD=$(openssl rand -base64 24 | tr -d '\n')"
echo ""

echo "# RabbitMQ Password (24 bytes base64)"
echo "RABBITMQ_PASSWORD=$(openssl rand -base64 24 | tr -d '\n')"
echo ""

echo "# Encryption Key (32 bytes base64)"
echo "ENCRYPTION_KEY=$(openssl rand -base64 32 | tr -d '\n')"
echo ""

echo ""
echo "=================================================="
echo "   IMPORTANT SECURITY NOTES"
echo "=================================================="
echo ""
echo "1. Store these secrets securely (e.g., AWS Secrets Manager, HashiCorp Vault)"
echo "2. Never commit these to version control"
echo "3. Rotate secrets regularly (every 90 days recommended)"
echo "4. Use different secrets for each environment (dev, staging, prod)"
echo "5. Restrict access to production secrets"
echo ""
