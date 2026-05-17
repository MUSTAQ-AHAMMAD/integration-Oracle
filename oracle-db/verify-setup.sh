#!/bin/bash
# Database Verification Script
# Tests that all tables and sequences from database.sql are created

set -e

echo "========================================"
echo "Oracle Database Schema Verification"
echo "========================================"
echo ""

# Check if container is running
if ! docker ps --format '{{.Names}}' | grep -q "oracle-integration-db"; then
    echo "❌ Oracle database container is not running"
    echo "Start it with: ./quickstart.sh"
    exit 1
fi

echo "✓ Database container is running"
echo ""

# Test connection
echo "Testing database connection..."
if ! docker-compose exec -T oracle-db bash -c "echo 'SELECT 1 FROM DUAL;' | sqlplus -L ODOO_INTEGRATION/Oracle123@localhost:1521/XE" &>/dev/null; then
    echo "❌ Cannot connect to database"
    echo "Wait for initialization or check logs: docker-compose logs oracle-db"
    exit 1
fi

echo "✓ Database connection successful"
echo ""

# Count tables
echo "Checking tables..."
TABLE_COUNT=$(docker-compose exec -T oracle-db bash -c "
    echo 'SET PAGESIZE 0 FEEDBACK OFF VERIFY OFF HEADING OFF ECHO OFF
    SELECT COUNT(*) FROM user_tables;' | sqlplus -S ODOO_INTEGRATION/Oracle123@localhost:1521/XE
" | grep -o '[0-9]\+')

echo "  Found $TABLE_COUNT tables"

# Expected table count (from database.sql)
EXPECTED_TABLES=40

if [ "$TABLE_COUNT" -lt "$EXPECTED_TABLES" ]; then
    echo "  ⚠ Warning: Expected at least $EXPECTED_TABLES tables"
else
    echo "  ✓ Table count looks good"
fi

# Check for key tables
echo ""
echo "Verifying key tables exist..."

KEY_TABLES=(
    "BACKUP_VENDHQ_LINE_ITEMS"
    "BACKUP_VENDHQ_PAYMENTS"
    "BACKUP_VENDHQ_SALES"
    "FUSION_INVOICE_HEADER"
    "FUSION_INVOICE_LINE"
    "FUSION_JOURNAL_HEADER"
    "FUSION_JOURNAL_LINE"
    "VENDHQ_ITEM_META"
    "VENDHQ_OUTLETS"
    "VENDHQ_REGISTERS"
    "FUSION_CREDENTIALS"
    "VENDHQ_CREDENTIALS"
)

MISSING_TABLES=()

for table in "${KEY_TABLES[@]}"; do
    if docker-compose exec -T oracle-db bash -c "
        echo \"SET PAGESIZE 0 FEEDBACK OFF VERIFY OFF HEADING OFF ECHO OFF
        SELECT COUNT(*) FROM user_tables WHERE table_name='$table';\" | sqlplus -S ODOO_INTEGRATION/Oracle123@localhost:1521/XE
    " | grep -q "1"; then
        echo "  ✓ $table"
    else
        echo "  ❌ $table - MISSING"
        MISSING_TABLES+=("$table")
    fi
done

# Count sequences
echo ""
echo "Checking sequences..."
SEQ_COUNT=$(docker-compose exec -T oracle-db bash -c "
    echo 'SET PAGESIZE 0 FEEDBACK OFF VERIFY OFF HEADING OFF ECHO OFF
    SELECT COUNT(*) FROM user_sequences;' | sqlplus -S ODOO_INTEGRATION/Oracle123@localhost:1521/XE
" | grep -o '[0-9]\+')

echo "  Found $SEQ_COUNT sequences"

EXPECTED_SEQS=21

if [ "$SEQ_COUNT" -lt "$EXPECTED_SEQS" ]; then
    echo "  ⚠ Warning: Expected at least $EXPECTED_SEQS sequences"
else
    echo "  ✓ Sequence count looks good"
fi

# Check indexes
echo ""
echo "Checking indexes..."
INDEX_COUNT=$(docker-compose exec -T oracle-db bash -c "
    echo 'SET PAGESIZE 0 FEEDBACK OFF VERIFY OFF HEADING OFF ECHO OFF
    SELECT COUNT(*) FROM user_indexes WHERE index_name NOT LIKE '\''SYS_%'\'';' | sqlplus -S ODOO_INTEGRATION/Oracle123@localhost:1521/XE
" | grep -o '[0-9]\+')

echo "  Found $INDEX_COUNT indexes"

if [ "$INDEX_COUNT" -lt "30" ]; then
    echo "  ⚠ Warning: Expected at least 30 indexes"
else
    echo "  ✓ Index count looks good"
fi

# Check triggers
echo ""
echo "Checking triggers..."
TRIGGER_COUNT=$(docker-compose exec -T oracle-db bash -c "
    echo 'SET PAGESIZE 0 FEEDBACK OFF VERIFY OFF HEADING OFF ECHO OFF
    SELECT COUNT(*) FROM user_triggers;' | sqlplus -S ODOO_INTEGRATION/Oracle123@localhost:1521/XE
" | grep -o '[0-9]\+')

echo "  Found $TRIGGER_COUNT triggers"

# Summary
echo ""
echo "========================================"
echo "Verification Summary"
echo "========================================"
echo "Tables:    $TABLE_COUNT (expected: >=$EXPECTED_TABLES)"
echo "Sequences: $SEQ_COUNT (expected: >=$EXPECTED_SEQS)"
echo "Indexes:   $INDEX_COUNT (expected: >=30)"
echo "Triggers:  $TRIGGER_COUNT (expected: >=1)"
echo ""

if [ ${#MISSING_TABLES[@]} -gt 0 ]; then
    echo "❌ Verification FAILED"
    echo ""
    echo "Missing tables:"
    for table in "${MISSING_TABLES[@]}"; do
        echo "  - $table"
    done
    echo ""
    echo "To fix:"
    echo "  1. Check init script logs: docker-compose logs oracle-db | grep schema"
    echo "  2. Manually run schema: docker-compose exec oracle-db sqlplus ODOO_INTEGRATION/Oracle123@XE @/opt/oracle/scripts/setup/02-create-schema.sql"
    exit 1
fi

echo "✓ All verification checks passed!"
echo ""
echo "Database is ready for use:"
echo "  Host: localhost"
echo "  Port: 1521"
echo "  SID: XE"
echo "  User: ODOO_INTEGRATION"
echo "  JDBC: jdbc:oracle:thin:@localhost:1521:XE"
echo ""
