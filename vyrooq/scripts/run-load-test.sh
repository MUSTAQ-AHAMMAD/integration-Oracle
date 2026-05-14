#!/bin/bash

# Vyrooq Load Test Runner
# Wrapper script to run k6 load tests

set -e

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

echo "=================================================="
echo "   Vyrooq Load Test"
echo "=================================================="
echo ""

# Check if k6 is installed
if ! command -v k6 &> /dev/null; then
    echo -e "${YELLOW}k6 is not installed.${NC}"
    echo ""
    echo "To install k6:"
    echo "  macOS:   brew install k6"
    echo "  Linux:   sudo gpg -k"
    echo "           sudo gpg --no-default-keyring --keyring /usr/share/keyrings/k6-archive-keyring.gpg --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys C5AD17C747E3415A3642D57D77C6C491D6AC1D69"
    echo "           echo 'deb [signed-by=/usr/share/keyrings/k6-archive-keyring.gpg] https://dl.k6.io/deb stable main' | sudo tee /etc/apt/sources.list.d/k6.list"
    echo "           sudo apt-get update"
    echo "           sudo apt-get install k6"
    echo "  Windows: choco install k6"
    echo ""
    echo "Or visit: https://k6.io/docs/getting-started/installation/"
    exit 1
fi

# Configuration
API_BASE="${API_BASE:-http://localhost:3000}"
AUTH_BASE="${AUTH_BASE:-http://localhost:3100}"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Configuration:"
echo "  API Base: $API_BASE"
echo "  Auth Base: $AUTH_BASE"
echo ""

# Check if services are accessible
echo "Checking if services are accessible..."
if ! curl -f -s -m 5 "$API_BASE/health" > /dev/null 2>&1; then
    echo -e "${RED}Error: API Gateway is not accessible at $API_BASE${NC}"
    echo "Make sure services are running: docker compose up -d"
    exit 1
fi
echo -e "${GREEN}✓ Services are accessible${NC}"
echo ""

# Run load test
echo "Starting load test..."
echo "This will take approximately 19 minutes"
echo ""

export API_BASE
export AUTH_BASE

if k6 run "$SCRIPT_DIR/load-test.js"; then
    echo ""
    echo -e "${GREEN}✓ Load test completed successfully${NC}"
    echo ""
    echo "Results saved to: load-test-results.json"
    exit 0
else
    echo ""
    echo -e "${RED}✗ Load test failed or did not meet thresholds${NC}"
    exit 1
fi
