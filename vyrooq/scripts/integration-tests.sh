#!/bin/bash

# Vyrooq Integration Test Suite
# Tests critical workflows end-to-end

set -e

# Configuration
API_BASE="${API_BASE:-http://localhost:3000}"
AUTH_BASE="${AUTH_BASE:-http://localhost:3100}"
RECONCILIATION_BASE="${RECONCILIATION_BASE:-http://localhost:3500}"
AUDIT_BASE="${AUDIT_BASE:-http://localhost:3600}"

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

# Test counters
TOTAL_TESTS=0
PASSED_TESTS=0
FAILED_TESTS=0

# Test result tracking
FAILED_TEST_NAMES=()

echo "=================================================="
echo "   Vyrooq Integration Test Suite"
echo "=================================================="
echo ""

# Function to run a test
run_test() {
    local test_name=$1
    local command=$2

    TOTAL_TESTS=$((TOTAL_TESTS + 1))
    echo -ne "${BLUE}[$TOTAL_TESTS]${NC} Testing: $test_name ... "

    if eval "$command" > /dev/null 2>&1; then
        echo -e "${GREEN}PASS${NC}"
        PASSED_TESTS=$((PASSED_TESTS + 1))
        return 0
    else
        echo -e "${RED}FAIL${NC}"
        FAILED_TESTS=$((FAILED_TESTS + 1))
        FAILED_TEST_NAMES+=("$test_name")
        return 1
    fi
}

# Wait for services to be ready
echo "Waiting for services to be ready..."
sleep 5

echo ""
echo "Running Integration Tests..."
echo "-----------------------------"

# Test 1: Health Checks
run_test "Gateway API health check" \
    "curl -f -s -m 5 $API_BASE/health"

run_test "Auth Service health check" \
    "curl -f -s -m 5 $AUTH_BASE/health"

run_test "Reconciliation Engine health check" \
    "curl -f -s -m 5 $RECONCILIATION_BASE/health"

run_test "Audit Engine health check" \
    "curl -f -s -m 5 $AUDIT_BASE/health"

# Test 2: Authentication Flow
echo ""
echo "Authentication Tests:"
echo "--------------------"

# Try to authenticate (will fail with test credentials, but tests endpoint works)
run_test "Auth endpoint accessibility" \
    "curl -f -s -m 5 -X POST $AUTH_BASE/auth/login \
        -H 'Content-Type: application/json' \
        -d '{\"username\":\"test\",\"password\":\"test\"}' -w '%{http_code}' -o /dev/null | grep -E '^(200|401|400)$'"

# Test 3: API Gateway Endpoints
echo ""
echo "API Gateway Tests:"
echo "------------------"

run_test "Gateway API root endpoint" \
    "curl -f -s -m 5 $API_BASE/"

run_test "Gateway API docs endpoint" \
    "curl -f -s -m 5 $API_BASE/docs || curl -f -s -m 5 $API_BASE/api-docs"

# Test 4: Database Connectivity
echo ""
echo "Database Tests:"
echo "---------------"

run_test "PostgreSQL connectivity" \
    "docker compose exec -T postgres pg_isready -U postgres"

run_test "PostgreSQL database exists" \
    "docker compose exec -T postgres psql -U postgres -lqt | grep -qw vyrooq"

# Test 5: Cache & Queue Infrastructure
echo ""
echo "Infrastructure Tests:"
echo "--------------------"

run_test "Redis connectivity" \
    "docker compose exec -T redis redis-cli ping | grep -q PONG"

run_test "RabbitMQ accessibility" \
    "curl -f -s -m 5 http://localhost:15672"

run_test "Kafka broker available" \
    "docker compose exec -T kafka kafka-topics --bootstrap-server localhost:9092 --list"

# Test 6: Monitoring Stack
echo ""
echo "Monitoring Tests:"
echo "----------------"

run_test "Prometheus accessible" \
    "curl -f -s -m 5 http://localhost:9090/-/healthy"

run_test "Grafana accessible" \
    "curl -f -s -m 5 http://localhost:3002/api/health"

# Test 7: Adapters
echo ""
echo "Adapter Tests:"
echo "--------------"

run_test "Fusion Adapter health" \
    "curl -f -s -m 5 http://localhost:8300/health"

run_test "VendHQ Adapter health" \
    "curl -f -s -m 5 http://localhost:8100/health"

run_test "Opencart Adapter health" \
    "curl -f -s -m 5 http://localhost:8200/health"

# Test 8: Event Bus
echo ""
echo "Event Bus Tests:"
echo "---------------"

run_test "Event Bus health" \
    "curl -f -s -m 5 http://localhost:3700/health"

run_test "Event Bus topics endpoint" \
    "curl -f -s -m 5 http://localhost:3700/topics"

# Summary
echo ""
echo "=================================================="
echo "   Test Summary"
echo "=================================================="
echo "Total Tests:       $TOTAL_TESTS"
echo -e "Passed:            ${GREEN}$PASSED_TESTS${NC}"
echo -e "Failed:            ${RED}$FAILED_TESTS${NC}"

if [ $FAILED_TESTS -gt 0 ]; then
    echo ""
    echo "Failed Tests:"
    for test in "${FAILED_TEST_NAMES[@]}"; do
        echo -e "  ${RED}✗${NC} $test"
    done
fi

echo ""
if [ $FAILED_TESTS -eq 0 ]; then
    echo -e "${GREEN}✓ All integration tests passed!${NC}"
    exit 0
else
    SUCCESS_RATE=$((PASSED_TESTS * 100 / TOTAL_TESTS))
    echo -e "${YELLOW}⚠ Some tests failed (Success rate: ${SUCCESS_RATE}%)${NC}"
    exit 1
fi
