#!/bin/bash

# Vyrooq Database Restore Script
# Restores PostgreSQL database from backup

set -e

# Configuration
BACKUP_DIR="${BACKUP_DIR:-/var/backups/vyrooq}"
POSTGRES_USER="${POSTGRES_USER:-postgres}"
POSTGRES_DB="${POSTGRES_DB:-vyrooq}"

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

echo "=================================================="
echo "   Vyrooq Database Restore"
echo "=================================================="
echo ""

# Check if backup file is provided
if [ -z "$1" ]; then
    echo "Available backups:"
    ls -lh "$BACKUP_DIR"/vyrooq_backup_*.sql.gz 2>/dev/null || echo "No backups found"
    echo ""
    echo "Usage: $0 <backup_file>"
    echo "Example: $0 vyrooq_backup_20260514_120000.sql.gz"
    exit 1
fi

BACKUP_FILE="$1"

# Check if backup file exists
if [ ! -f "${BACKUP_DIR}/${BACKUP_FILE}" ]; then
    echo -e "${RED}Error: Backup file not found: ${BACKUP_DIR}/${BACKUP_FILE}${NC}"
    exit 1
fi

# Check if PostgreSQL is accessible
if ! docker compose exec -T postgres pg_isready -U "$POSTGRES_USER" > /dev/null 2>&1; then
    echo -e "${RED}Error: PostgreSQL is not accessible${NC}"
    exit 1
fi

echo -e "${YELLOW}WARNING: This will replace the current database!${NC}"
echo "Database: $POSTGRES_DB"
echo "Backup file: $BACKUP_FILE"
echo ""
read -p "Are you sure you want to continue? (yes/no): " CONFIRM

if [ "$CONFIRM" != "yes" ]; then
    echo "Restore cancelled"
    exit 0
fi

echo ""
echo "Creating backup of current database before restore..."
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
PRE_RESTORE_BACKUP="vyrooq_pre_restore_${TIMESTAMP}.sql.gz"
docker compose exec -T postgres pg_dump -U "$POSTGRES_USER" "$POSTGRES_DB" | gzip > "${BACKUP_DIR}/${PRE_RESTORE_BACKUP}"
echo -e "${GREEN}✓ Pre-restore backup created: $PRE_RESTORE_BACKUP${NC}"

echo ""
echo "Restoring database..."

# Drop and recreate database
docker compose exec -T postgres psql -U "$POSTGRES_USER" -c "DROP DATABASE IF EXISTS ${POSTGRES_DB};" postgres
docker compose exec -T postgres psql -U "$POSTGRES_USER" -c "CREATE DATABASE ${POSTGRES_DB};" postgres

# Restore from backup
if gunzip < "${BACKUP_DIR}/${BACKUP_FILE}" | docker compose exec -T postgres psql -U "$POSTGRES_USER" "$POSTGRES_DB" > /dev/null; then
    echo -e "${GREEN}✓ Database restored successfully${NC}"
else
    echo -e "${RED}✗ Restore failed${NC}"
    echo ""
    echo "To rollback, run:"
    echo "$0 $PRE_RESTORE_BACKUP"
    exit 1
fi

echo ""
echo -e "${GREEN}✓ Restore completed${NC}"
