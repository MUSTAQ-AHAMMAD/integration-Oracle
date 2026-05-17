#!/bin/bash

# Vyrooq Platform Diagnostic Script
# This script checks your local environment and diagnoses common issues

echo "========================================"
echo "Vyrooq Platform Diagnostic Tool"
echo "========================================"
echo ""

# Color codes for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Track overall status
ISSUES_FOUND=0

# Function to print success
success() {
    echo -e "${GREEN}✓${NC} $1"
}

# Function to print error
error() {
    echo -e "${RED}✗${NC} $1"
    ISSUES_FOUND=$((ISSUES_FOUND + 1))
}

# Function to print warning
warning() {
    echo -e "${YELLOW}⚠${NC} $1"
}

# Function to print info
info() {
    echo -e "ℹ  $1"
}

echo "1. Checking Docker Installation..."
echo "-----------------------------------"

# Check if Docker is installed
if command -v docker &> /dev/null; then
    DOCKER_VERSION=$(docker --version)
    success "Docker is installed: $DOCKER_VERSION"
else
    error "Docker is not installed"
    echo "   Install from: https://www.docker.com/products/docker-desktop/"
fi

# Check if Docker Compose is installed
if command -v docker compose version &> /dev/null; then
    COMPOSE_VERSION=$(docker compose version)
    success "Docker Compose is installed: $COMPOSE_VERSION"
elif command -v docker-compose &> /dev/null; then
    COMPOSE_VERSION=$(docker-compose --version)
    warning "Legacy docker-compose found: $COMPOSE_VERSION"
    info "    Consider upgrading to Docker Compose V2"
else
    error "Docker Compose is not installed"
fi

# Check if Docker daemon is running
if docker info &> /dev/null; then
    success "Docker daemon is running"
else
    error "Docker daemon is not running"
    echo "   Start Docker Desktop (Windows/Mac) or run: sudo systemctl start docker (Linux)"
fi

echo ""
echo "2. Checking System Resources..."
echo "-----------------------------------"

# Check available disk space
AVAILABLE_SPACE=$(df -h . | awk 'NR==2 {print $4}')
success "Available disk space: $AVAILABLE_SPACE"

# Check Docker resources
if docker info &> /dev/null; then
    DOCKER_MEM=$(docker info 2>/dev/null | grep "Total Memory" | awk '{print $3 $4}')
    if [ ! -z "$DOCKER_MEM" ]; then
        success "Docker memory: $DOCKER_MEM"
    fi
fi

echo ""
echo "3. Checking Required Files..."
echo "-----------------------------------"

# Check if we're in the vyrooq directory
if [ -f "docker-compose.yml" ]; then
    success "Found docker-compose.yml"
else
    error "docker-compose.yml not found"
    echo "   Make sure you're in the vyrooq/ directory"
fi

if [ -f ".env" ]; then
    success "Found .env file"

    # Check if critical environment variables are set
    if grep -q "FUSION_BASE_URL=https://your-instance" .env; then
        warning "FUSION_BASE_URL not configured in .env"
        echo "   Edit .env and set your Oracle Fusion credentials"
    else
        success "FUSION_BASE_URL is configured"
    fi
else
    error ".env file not found"
    echo "   The .env file should already exist. If missing, copy from .env.example"
fi

# Check for essential service directories
SERVICES=("gateway-api" "fusion-adapter" "reconciliation-engine")
for service in "${SERVICES[@]}"; do
    if [ -d "$service" ]; then
        success "Found $service directory"
    else
        error "$service directory not found"
    fi
done

echo ""
echo "4. Checking Docker Containers..."
echo "-----------------------------------"

# Check if any Vyrooq containers are running
RUNNING_CONTAINERS=$(docker ps -a --filter "name=vyrooq" --format "{{.Names}} ({{.Status}})")

if [ -z "$RUNNING_CONTAINERS" ]; then
    info "No Vyrooq containers are running"
    echo "   Run: docker compose up -d postgres redis"
else
    echo "Running containers:"
    echo "$RUNNING_CONTAINERS" | while read -r container; do
        if echo "$container" | grep -q "Up"; then
            success "$container"
        else
            error "$container"
        fi
    done
fi

echo ""
echo "5. Checking Ports..."
echo "-----------------------------------"

# Check if required ports are available or used by Vyrooq
PORTS=(3000 5432 6379 8300 3500 3600 3700)
PORT_NAMES=("Gateway API" "PostgreSQL" "Redis" "Fusion Adapter" "Reconciliation" "Audit" "Event Bus")

for i in "${!PORTS[@]}"; do
    PORT=${PORTS[$i]}
    NAME=${PORT_NAMES[$i]}

    if command -v lsof &> /dev/null; then
        PORT_CHECK=$(lsof -i :$PORT -sTCP:LISTEN 2>/dev/null)
        if [ ! -z "$PORT_CHECK" ]; then
            if echo "$PORT_CHECK" | grep -q "docker"; then
                success "Port $PORT ($NAME) - Used by Docker"
            else
                warning "Port $PORT ($NAME) - Used by another process"
                echo "   $(echo "$PORT_CHECK" | tail -1 | awk '{print $1, $2}')"
            fi
        else
            info "Port $PORT ($NAME) - Available"
        fi
    elif command -v netstat &> /dev/null; then
        # For systems without lsof
        if netstat -tuln 2>/dev/null | grep -q ":$PORT "; then
            warning "Port $PORT ($NAME) - In use"
        else
            info "Port $PORT ($NAME) - Available"
        fi
    fi
done

echo ""
echo "6. Testing Service Connectivity..."
echo "-----------------------------------"

# Test if services are accessible
ENDPOINTS=(
    "http://localhost:3000/health:Gateway API"
    "http://localhost:8300/health:Fusion Adapter"
    "http://localhost:3500/health:Reconciliation Engine"
    "http://localhost:3600/health:Audit Engine"
    "http://localhost:3700/health:Event Bus"
)

for endpoint in "${ENDPOINTS[@]}"; do
    URL="${endpoint%%:*}"
    NAME="${endpoint##*:}"

    if command -v curl &> /dev/null; then
        if curl -s -f -m 2 "$URL" > /dev/null 2>&1; then
            success "$NAME is responding at $URL"
        else
            info "$NAME is not running (expected if services aren't started)"
        fi
    fi
done

echo ""
echo "7. Checking Docker Networks..."
echo "-----------------------------------"

if docker network ls | grep -q "vyrooq"; then
    success "Vyrooq Docker network exists"
else
    info "Vyrooq Docker network not created yet"
    echo "   Will be created automatically on first run"
fi

echo ""
echo "8. Checking Docker Volumes..."
echo "-----------------------------------"

VOLUMES=$(docker volume ls --filter "name=vyrooq" --format "{{.Name}}")
if [ ! -z "$VOLUMES" ]; then
    success "Found Vyrooq data volumes:"
    echo "$VOLUMES" | while read -r volume; do
        echo "   - $volume"
    done
else
    info "No Vyrooq volumes found yet"
    echo "   Will be created automatically on first run"
fi

echo ""
echo "========================================"
echo "Summary"
echo "========================================"

if [ $ISSUES_FOUND -eq 0 ]; then
    success "No critical issues found! Your environment looks good."
    echo ""
    echo "Next steps:"
    echo "1. Configure Oracle Fusion credentials in .env file"
    echo "2. Run: docker compose up -d postgres redis"
    echo "3. Run: docker compose up -d gateway-api fusion-adapter"
    echo "4. Test: curl http://localhost:3000/health"
else
    error "Found $ISSUES_FOUND issue(s) that need attention"
    echo ""
    echo "Please fix the issues above before proceeding."
    echo "For more help, see: LOCAL_SETUP_GUIDE.md"
fi

echo ""
echo "For detailed setup instructions, see:"
echo "- LOCAL_SETUP_GUIDE.md"
echo "- BUILD_TROUBLESHOOTING.md"
echo ""
