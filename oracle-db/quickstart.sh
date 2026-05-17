#!/bin/bash
# Quick setup script for Oracle Database

set -e

echo "=================================="
echo "Oracle Database Quick Setup"
echo "=================================="
echo ""

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    echo "❌ Docker is not installed. Please install Docker first."
    exit 1
fi

# Check if Docker Compose is installed
if ! command -v docker-compose &> /dev/null; then
    echo "❌ Docker Compose is not installed. Please install Docker Compose first."
    exit 1
fi

echo "✓ Docker and Docker Compose are installed"
echo ""

# Create .env file if it doesn't exist
if [ ! -f .env ]; then
    echo "Creating .env file from template..."
    cp .env.example .env
    echo "✓ .env file created"
    echo ""
    echo "⚠ WARNING: Using default passwords. Please update .env for production!"
    echo ""
fi

# Pull Oracle image (this may take a while)
echo "Pulling Oracle Database image (this may take several minutes)..."
docker-compose pull || {
    echo ""
    echo "Note: If the image pull fails, you may need to:"
    echo "1. Accept Oracle's terms at: https://container-registry.oracle.com"
    echo "2. Login to Oracle Container Registry:"
    echo "   docker login container-registry.oracle.com"
    echo ""
    read -p "Press Enter to continue or Ctrl+C to exit..."
}

# Start the database
echo ""
echo "Starting Oracle Database container..."
docker-compose up -d

echo ""
echo "Waiting for database to initialize (this may take 2-5 minutes on first run)..."
echo ""

# Wait for database to be ready
max_attempts=60
attempt=1

while [ $attempt -le $max_attempts ]; do
    if docker-compose exec -T oracle-db bash -c "echo 'SELECT 1 FROM DUAL;' | sqlplus -L sys/Oracle123@localhost:1521/XE as sysdba" &>/dev/null; then
        echo ""
        echo "✓ Database is ready!"
        break
    fi

    echo -n "."
    sleep 5
    attempt=$((attempt + 1))

    if [ $attempt -gt $max_attempts ]; then
        echo ""
        echo "❌ Database failed to start. Check logs with: docker-compose logs oracle-db"
        exit 1
    fi
done

echo ""
echo "=================================="
echo "✓ Setup Complete!"
echo "=================================="
echo ""
echo "Database Connection Information:"
echo "  Host: localhost"
echo "  Port: 1521"
echo "  SID: XE"
echo "  User: ODOO_INTEGRATION"
echo "  Password: Oracle123"
echo ""
echo "JDBC URL:"
echo "  jdbc:oracle:thin:@localhost:1521:XE"
echo ""
echo "SQL*Plus Connection:"
echo "  sqlplus ODOO_INTEGRATION/Oracle123@localhost:1521/XE"
echo ""
echo "Management Commands:"
echo "  ./db-manage.sh status    - Check database status"
echo "  ./db-manage.sh shell     - Open SQL*Plus shell"
echo "  ./db-manage.sh logs      - View database logs"
echo "  ./db-manage.sh help      - Show all commands"
echo ""
echo "Enterprise Manager (Web UI):"
echo "  https://localhost:5500/em"
echo ""
echo "⚠ Remember to change default passwords for production use!"
echo ""
