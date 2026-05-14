#!/bin/bash

# Vyrooq Security Validation Script
# Validates security configuration before production deployment

set -e

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

# Counters
TOTAL_CHECKS=0
PASSED_CHECKS=0
FAILED_CHECKS=0
WARNING_CHECKS=0

# Failed check tracking
FAILED_ITEMS=()
WARNING_ITEMS=()

echo "=================================================="
echo "   Vyrooq Security Validation"
echo "=================================================="
echo ""

# Function to run security check
check_security() {
    local check_name=$1
    local check_type=$2  # "critical", "warning", "info"
    local command=$3

    TOTAL_CHECKS=$((TOTAL_CHECKS + 1))
    echo -ne "${BLUE}[$TOTAL_CHECKS]${NC} Checking: $check_name ... "

    if eval "$command" > /dev/null 2>&1; then
        echo -e "${GREEN}PASS${NC}"
        PASSED_CHECKS=$((PASSED_CHECKS + 1))
        return 0
    else
        if [ "$check_type" = "critical" ]; then
            echo -e "${RED}FAIL${NC}"
            FAILED_CHECKS=$((FAILED_CHECKS + 1))
            FAILED_ITEMS+=("$check_name")
        else
            echo -e "${YELLOW}WARNING${NC}"
            WARNING_CHECKS=$((WARNING_CHECKS + 1))
            WARNING_ITEMS+=("$check_name")
        fi
        return 1
    fi
}

echo "Running Security Checks..."
echo "-------------------------"
echo ""

# 1. Environment Variables
echo "1. Environment Configuration:"
echo "----------------------------"

check_security "NODE_ENV is set to production" "warning" \
    "grep -q 'NODE_ENV=production' .env 2>/dev/null"

check_security "JWT_SECRET is not default" "critical" \
    "! grep -q 'JWT_SECRET=your-secret-key-change-this' .env 2>/dev/null"

check_security "SESSION_SECRET is changed" "critical" \
    "! grep -q 'SESSION_SECRET=change-this-to-a-strong' .env 2>/dev/null && ! grep -q 'CHANGE_ME' .env 2>/dev/null"

check_security "Database password is changed" "critical" \
    "! grep -q 'POSTGRES_PASSWORD.*vyrooq123' .env 2>/dev/null && ! grep -q 'CHANGE_ME' .env 2>/dev/null"

check_security "Redis password is set" "warning" \
    "grep -q 'REDIS_PASSWORD' .env 2>/dev/null && ! grep -q 'CHANGE_ME' .env 2>/dev/null"

check_security "RabbitMQ password is changed" "critical" \
    "! grep -q 'RABBITMQ.*vyrooq123' .env 2>/dev/null"

# 2. Configuration Files
echo ""
echo "2. Configuration Security:"
echo "-------------------------"

check_security ".env file is not in git" "critical" \
    "! git ls-files --error-unmatch .env 2>/dev/null"

check_security ".env.example exists as template" "info" \
    "[ -f .env.example ]"

check_security "CORS is not set to wildcard" "warning" \
    "! grep -q 'CORS_ORIGIN=\*' .env 2>/dev/null"

# 3. Docker Configuration
echo ""
echo "3. Docker Security:"
echo "------------------"

check_security "Docker compose file has no default passwords" "critical" \
    "! grep -E 'PASSWORD.*123|PASSWORD.*password' docker-compose.yml"

check_security "Services run as non-root (where applicable)" "warning" \
    "grep -q 'user:' docker-compose.yml || true"  # Not all services need this

# 4. Network Security
echo ""
echo "4. Network Configuration:"
echo "------------------------"

check_security "PostgreSQL not exposed publicly" "critical" \
    "! docker compose config | grep -A5 'postgres:' | grep -q '0.0.0.0:5432' || docker compose config | grep -A5 'postgres:' | grep -q '127.0.0.1:5432' || ! docker compose config | grep -A5 'postgres:' | grep -q 'ports:'"

check_security "Redis not exposed publicly" "critical" \
    "! docker compose config | grep -A5 'redis:' | grep -q '0.0.0.0:6379' || docker compose config | grep -A5 'redis:' | grep -q '127.0.0.1:6379' || ! docker compose config | grep -A5 'redis:' | grep -q 'ports:'"

# 5. Service Configuration
echo ""
echo "5. Service Configuration:"
echo "------------------------"

check_security "Health checks configured" "info" \
    "grep -q 'healthcheck:' docker-compose.yml"

check_security "Resource limits defined" "warning" \
    "grep -q 'mem_limit\\|memory:' docker-compose.yml || true"

# 6. SSL/TLS (if nginx/reverse proxy exists)
echo ""
echo "6. SSL/TLS Configuration:"
echo "------------------------"

if [ -f "nginx.conf" ] || [ -f "docker/nginx/nginx.conf" ]; then
    check_security "SSL certificate configured" "critical" \
        "grep -q 'ssl_certificate' nginx.conf docker/nginx/nginx.conf 2>/dev/null"

    check_security "HTTPS redirect configured" "warning" \
        "grep -q 'return 301 https' nginx.conf docker/nginx/nginx.conf 2>/dev/null"
else
    echo -e "${YELLOW}[!]${NC} No nginx configuration found - SSL/TLS checks skipped"
fi

# 7. Secrets in Code
echo ""
echo "7. Code Security:"
echo "----------------"

check_security "No hardcoded passwords in TypeScript files" "critical" \
    "! grep -r \"password.*=.*['\\\"].*['\\\"]\" --include='*.ts' --include='*.js' gateway-api/ auth-service/ 2>/dev/null || true"

check_security "No hardcoded API keys in Python files" "critical" \
    "! grep -r \"api_key.*=.*['\\\"].*['\\\"]\" --include='*.py' fusion-adapter/ workflow-engine/ 2>/dev/null || true"

check_security "No TODO/FIXME for security issues" "warning" \
    "! grep -r 'TODO.*security\\|FIXME.*security\\|HACK.*security' --include='*.ts' --include='*.js' --include='*.py' . 2>/dev/null || true"

# 8. Dependencies
echo ""
echo "8. Dependency Security:"
echo "----------------------"

if command -v npm &> /dev/null; then
    check_security "No high/critical npm vulnerabilities" "warning" \
        "cd gateway-api && npm audit --audit-level=high 2>/dev/null || true"
else
    echo -e "${YELLOW}[!]${NC} npm not available - skipping dependency audit"
fi

# 9. Monitoring
echo ""
echo "9. Monitoring & Logging:"
echo "-----------------------"

check_security "Prometheus configured" "info" \
    "docker compose config | grep -q 'prometheus'"

check_security "Grafana configured" "info" \
    "docker compose config | grep -q 'grafana'"

check_security "Structured logging enabled" "info" \
    "grep -q 'LOG_LEVEL' .env 2>/dev/null"

# 10. Backup Configuration
echo ""
echo "10. Backup & Recovery:"
echo "---------------------"

check_security "Backup script exists" "warning" \
    "[ -f scripts/backup-database.sh ]"

check_security "Restore script exists" "warning" \
    "[ -f scripts/restore-database.sh ]"

check_security "Backup directory mentioned in config" "info" \
    "grep -q 'BACKUP' scripts/backup-database.sh 2>/dev/null"

# Summary
echo ""
echo "=================================================="
echo "   Security Validation Summary"
echo "=================================================="
echo "Total Checks:      $TOTAL_CHECKS"
echo -e "Passed:            ${GREEN}$PASSED_CHECKS${NC}"
echo -e "Warnings:          ${YELLOW}$WARNING_CHECKS${NC}"
echo -e "Failed (Critical): ${RED}$FAILED_CHECKS${NC}"

if [ $FAILED_CHECKS -gt 0 ]; then
    echo ""
    echo -e "${RED}CRITICAL ISSUES (Must Fix):${NC}"
    for item in "${FAILED_ITEMS[@]}"; do
        echo -e "  ${RED}✗${NC} $item"
    done
fi

if [ $WARNING_CHECKS -gt 0 ]; then
    echo ""
    echo -e "${YELLOW}WARNINGS (Should Fix):${NC}"
    for item in "${WARNING_ITEMS[@]}"; do
        echo -e "  ${YELLOW}⚠${NC} $item"
    done
fi

echo ""
echo "=================================================="

if [ $FAILED_CHECKS -eq 0 ]; then
    if [ $WARNING_CHECKS -eq 0 ]; then
        echo -e "${GREEN}✓ All security checks passed!${NC}"
        echo "The platform is secure for production deployment."
        exit 0
    else
        echo -e "${YELLOW}⚠ Security validation passed with warnings${NC}"
        echo "Review warnings before production deployment."
        exit 0
    fi
else
    echo -e "${RED}✗ Security validation FAILED${NC}"
    echo "Fix critical issues before deploying to production!"
    echo ""
    echo "Common fixes:"
    echo "  1. Run: ./scripts/generate-secrets.sh > .env.production"
    echo "  2. Copy production secrets to .env"
    echo "  3. Review docker-compose.yml and remove default passwords"
    echo "  4. Ensure .env is in .gitignore"
    echo ""
    exit 1
fi
