#!/bin/bash

# Vyrooq Health Check Script
# Checks the health of all 20 services in the platform

set -e

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Counter for healthy/unhealthy services
HEALTHY=0
UNHEALTHY=0
TOTAL=0

echo "=================================================="
echo "   Vyrooq Platform Health Check"
echo "=================================================="
echo ""

# Function to check service health
check_service() {
    local service_name=$1
    local url=$2
    local timeout=${3:-5}

    TOTAL=$((TOTAL + 1))

    if curl -f -s -m $timeout "$url" > /dev/null 2>&1; then
        echo -e "${GREEN}✓${NC} $service_name - HEALTHY"
        HEALTHY=$((HEALTHY + 1))
        return 0
    else
        echo -e "${RED}✗${NC} $service_name - UNHEALTHY"
        UNHEALTHY=$((UNHEALTHY + 1))
        return 1
    fi
}

# Application Services
echo "Application Services:"
echo "--------------------"
check_service "Gateway API           (3000)" "http://localhost:3000/health"
check_service "Auth Service          (3100)" "http://localhost:3100/health"
check_service "Retry Engine          (3200)" "http://localhost:3200/health"
check_service "Deduplication Engine  (3300)" "http://localhost:3300/health"
check_service "Manual Control Engine (3400)" "http://localhost:3400/health"
check_service "Reconciliation Engine (3500)" "http://localhost:3500/health"
check_service "Audit Engine          (3600)" "http://localhost:3600/health"
check_service "Event Bus             (3700)" "http://localhost:3700/health"
check_service "Admin Dashboard       (4000)" "http://localhost:4000/health"
check_service "VendHQ Adapter        (8100)" "http://localhost:8100/health"
check_service "Opencart Adapter      (8200)" "http://localhost:8200/health"
check_service "Fusion Adapter        (8300)" "http://localhost:8300/health"

echo ""
echo "Infrastructure Services:"
echo "------------------------"

# PostgreSQL
if docker compose exec -T postgres pg_isready -U postgres > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} PostgreSQL            (5432) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} PostgreSQL            (5432) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# Redis
if docker compose exec -T redis redis-cli ping > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} Redis                 (6379) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} Redis                 (6379) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# RabbitMQ
if curl -f -s -m 5 "http://localhost:15672" > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} RabbitMQ              (5672/15672) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} RabbitMQ              (5672/15672) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# Kafka
if docker compose exec -T kafka kafka-topics --bootstrap-server localhost:9092 --list > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} Kafka                 (9092) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} Kafka                 (9092) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# Temporal
if curl -f -s -m 5 "http://localhost:8233" > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} Temporal              (7233/8233) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} Temporal              (7233/8233) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# Prometheus
if curl -f -s -m 5 "http://localhost:9090/-/healthy" > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} Prometheus            (9090) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} Prometheus            (9090) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# Grafana
if curl -f -s -m 5 "http://localhost:3002/api/health" > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC} Grafana               (3002) - HEALTHY"
    HEALTHY=$((HEALTHY + 1))
else
    echo -e "${RED}✗${NC} Grafana               (3002) - UNHEALTHY"
    UNHEALTHY=$((UNHEALTHY + 1))
fi
TOTAL=$((TOTAL + 1))

# Summary
echo ""
echo "=================================================="
echo "   Summary"
echo "=================================================="
echo "Total Services:    $TOTAL"
echo -e "Healthy:           ${GREEN}$HEALTHY${NC}"
echo -e "Unhealthy:         ${RED}$UNHEALTHY${NC}"

if [ $UNHEALTHY -eq 0 ]; then
    echo ""
    echo -e "${GREEN}✓ All services are healthy!${NC}"
    exit 0
else
    echo ""
    echo -e "${YELLOW}⚠ Some services are unhealthy. Check logs for details.${NC}"
    exit 1
fi
