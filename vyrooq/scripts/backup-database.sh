#!/bin/bash

# Vyrooq Database Backup Script
# Creates compressed backups of PostgreSQL database

set -e

# Configuration
BACKUP_DIR="${BACKUP_DIR:-/var/backups/vyrooq}"
RETENTION_DAYS="${RETENTION_DAYS:-7}"
POSTGRES_USER="${POSTGRES_USER:-postgres}"
POSTGRES_DB="${POSTGRES_DB:-vyrooq}"
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
BACKUP_FILE="vyrooq_backup_${TIMESTAMP}.sql.gz"

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

echo "=================================================="
echo "   Vyrooq Database Backup"
echo "=================================================="
echo ""

# Create backup directory if it doesn't exist
mkdir -p "$BACKUP_DIR"

# Check if PostgreSQL is accessible
if ! docker compose exec -T postgres pg_isready -U "$POSTGRES_USER" > /dev/null 2>&1; then
    echo -e "${RED}Error: PostgreSQL is not accessible${NC}"
    exit 1
fi

echo "Starting backup..."
echo "Database: $POSTGRES_DB"
echo "Backup file: $BACKUP_FILE"
echo ""

# Create backup
if docker compose exec -T postgres pg_dump -U "$POSTGRES_USER" "$POSTGRES_DB" | gzip > "${BACKUP_DIR}/${BACKUP_FILE}"; then
    BACKUP_SIZE=$(du -h "${BACKUP_DIR}/${BACKUP_FILE}" | cut -f1)
    echo -e "${GREEN}✓ Backup completed successfully${NC}"
    echo "Size: $BACKUP_SIZE"
    echo "Location: ${BACKUP_DIR}/${BACKUP_FILE}"
else
    echo -e "${RED}✗ Backup failed${NC}"
    exit 1
fi

# Cleanup old backups
echo ""
echo "Cleaning up backups older than $RETENTION_DAYS days..."
DELETED=$(find "$BACKUP_DIR" -name "vyrooq_backup_*.sql.gz" -type f -mtime +$RETENTION_DAYS -delete -print | wc -l)
echo "Deleted $DELETED old backup(s)"

# List remaining backups
echo ""
echo "Current backups:"
ls -lh "$BACKUP_DIR"/vyrooq_backup_*.sql.gz 2>/dev/null || echo "No backups found"

echo ""
echo -e "${GREEN}✓ Backup process completed${NC}"
