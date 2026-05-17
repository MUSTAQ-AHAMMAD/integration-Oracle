#!/bin/bash
# Oracle Database Management Helper Script

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Configuration
COMPOSE_FILE="docker-compose.yml"
CONTAINER_NAME="oracle-integration-db"

# Helper functions
print_success() {
    echo -e "${GREEN}✓ $1${NC}"
}

print_error() {
    echo -e "${RED}✗ $1${NC}"
}

print_warning() {
    echo -e "${YELLOW}⚠ $1${NC}"
}

print_info() {
    echo -e "${NC}ℹ $1${NC}"
}

# Check if container is running
check_container() {
    if docker ps --format '{{.Names}}' | grep -q "^${CONTAINER_NAME}$"; then
        return 0
    else
        return 1
    fi
}

# Wait for database to be ready
wait_for_db() {
    print_info "Waiting for database to be ready..."
    local max_attempts=60
    local attempt=1

    while [ $attempt -le $max_attempts ]; do
        if docker-compose exec -T oracle-db bash -c "echo 'SELECT 1 FROM DUAL;' | sqlplus -L ODOO_INTEGRATION/\${DB_PASSWORD}@localhost:1521/XE" &>/dev/null; then
            print_success "Database is ready!"
            return 0
        fi

        echo -n "."
        sleep 5
        attempt=$((attempt + 1))
    done

    print_error "Database failed to become ready after $max_attempts attempts"
    return 1
}

# Command functions
cmd_start() {
    print_info "Starting Oracle Database..."
    docker-compose up -d
    wait_for_db
    print_success "Oracle Database started successfully"
    print_info "Connection: jdbc:oracle:thin:@localhost:1521:XE"
    print_info "User: ODOO_INTEGRATION / Password: Oracle123"
}

cmd_stop() {
    print_info "Stopping Oracle Database..."
    docker-compose stop
    print_success "Oracle Database stopped"
}

cmd_restart() {
    print_info "Restarting Oracle Database..."
    docker-compose restart
    wait_for_db
    print_success "Oracle Database restarted successfully"
}

cmd_status() {
    if check_container; then
        print_success "Oracle Database is running"
        docker-compose ps
    else
        print_warning "Oracle Database is not running"
    fi
}

cmd_logs() {
    docker-compose logs -f oracle-db
}

cmd_shell() {
    if ! check_container; then
        print_error "Container is not running. Start it first with: $0 start"
        exit 1
    fi

    print_info "Connecting to SQL*Plus shell..."
    docker-compose exec oracle-db sqlplus ODOO_INTEGRATION/Oracle123@XE
}

cmd_bash() {
    if ! check_container; then
        print_error "Container is not running. Start it first with: $0 start"
        exit 1
    fi

    print_info "Opening bash shell in container..."
    docker-compose exec oracle-db bash
}

cmd_backup() {
    if ! check_container; then
        print_error "Container is not running. Start it first with: $0 start"
        exit 1
    fi

    local backup_name="backup_$(date +%Y%m%d_%H%M%S)"
    print_info "Creating backup: ${backup_name}"

    docker-compose exec -T oracle-db bash -c "
        mkdir -p /opt/oracle/backup
        expdp ODOO_INTEGRATION/Oracle123@XE \
            directory=DATA_PUMP_DIR \
            dumpfile=${backup_name}.dmp \
            logfile=${backup_name}.log \
            schemas=ODOO_INTEGRATION
    "

    print_success "Backup created: ${backup_name}.dmp"
}

cmd_restore() {
    if [ -z "$1" ]; then
        print_error "Please specify backup file name"
        print_info "Usage: $0 restore <backup_file.dmp>"
        exit 1
    fi

    if ! check_container; then
        print_error "Container is not running. Start it first with: $0 start"
        exit 1
    fi

    local backup_file="$1"
    print_warning "This will restore database from: ${backup_file}"
    read -p "Are you sure? (yes/no): " confirm

    if [ "$confirm" != "yes" ]; then
        print_info "Restore cancelled"
        exit 0
    fi

    print_info "Restoring database..."
    docker-compose exec -T oracle-db bash -c "
        impdp ODOO_INTEGRATION/Oracle123@XE \
            directory=DATA_PUMP_DIR \
            dumpfile=${backup_file} \
            logfile=restore_$(date +%Y%m%d_%H%M%S).log \
            schemas=ODOO_INTEGRATION \
            table_exists_action=replace
    "

    print_success "Database restored successfully"
}

cmd_reset() {
    print_warning "This will completely reset the database and remove all data!"
    read -p "Are you sure? (yes/no): " confirm

    if [ "$confirm" != "yes" ]; then
        print_info "Reset cancelled"
        exit 0
    fi

    print_info "Stopping and removing containers..."
    docker-compose down -v

    print_info "Starting fresh database..."
    cmd_start

    print_success "Database reset complete"
}

cmd_test() {
    if ! check_container; then
        print_error "Container is not running. Start it first with: $0 start"
        exit 1
    fi

    print_info "Testing database connection..."

    if docker-compose exec -T oracle-db bash -c "echo 'SELECT COUNT(*) FROM USER_TABLES;' | sqlplus -L ODOO_INTEGRATION/Oracle123@XE"; then
        print_success "Database connection test passed"
    else
        print_error "Database connection test failed"
        exit 1
    fi
}

cmd_stats() {
    if ! check_container; then
        print_error "Container is not running"
        exit 1
    fi

    print_info "Database Statistics:"
    docker-compose exec -T oracle-db bash -c "
        echo \"
        SET LINESIZE 200
        SET PAGESIZE 50
        COLUMN table_name FORMAT A40
        COLUMN num_rows FORMAT 999,999,999

        SELECT table_name, num_rows
        FROM user_tables
        WHERE num_rows IS NOT NULL
        ORDER BY num_rows DESC;
        \" | sqlplus -S ODOO_INTEGRATION/Oracle123@XE
    "
}

cmd_help() {
    cat << EOF
Oracle Database Management Script

Usage: $0 <command> [arguments]

Commands:
    start       Start the Oracle Database container
    stop        Stop the Oracle Database container
    restart     Restart the Oracle Database container
    status      Check if database is running
    logs        View database logs (follow mode)
    shell       Open SQL*Plus shell
    bash        Open bash shell in container
    backup      Create a database backup
    restore     Restore from backup file
    reset       Reset database (removes all data)
    test        Test database connection
    stats       Show database table statistics
    help        Show this help message

Examples:
    $0 start
    $0 backup
    $0 restore backup_20260517_120000.dmp
    $0 shell

For more information, see README.md
EOF
}

# Main script logic
case "${1:-help}" in
    start)
        cmd_start
        ;;
    stop)
        cmd_stop
        ;;
    restart)
        cmd_restart
        ;;
    status)
        cmd_status
        ;;
    logs)
        cmd_logs
        ;;
    shell|sql)
        cmd_shell
        ;;
    bash)
        cmd_bash
        ;;
    backup)
        cmd_backup
        ;;
    restore)
        cmd_restore "$2"
        ;;
    reset)
        cmd_reset
        ;;
    test)
        cmd_test
        ;;
    stats)
        cmd_stats
        ;;
    help|--help|-h)
        cmd_help
        ;;
    *)
        print_error "Unknown command: $1"
        echo ""
        cmd_help
        exit 1
        ;;
esac
