#!/bin/bash

# Vyrooq Quick Start Script
# This script helps you set up and start Vyrooq quickly

set -e  # Exit on any error

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Print colored output
print_info() {
    echo -e "${BLUE}ℹ ${NC}$1"
}

print_success() {
    echo -e "${GREEN}✓${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}⚠${NC} $1"
}

print_error() {
    echo -e "${RED}✗${NC} $1"
}

print_header() {
    echo ""
    echo -e "${BLUE}═══════════════════════════════════════════${NC}"
    echo -e "${BLUE}  $1${NC}"
    echo -e "${BLUE}═══════════════════════════════════════════${NC}"
    echo ""
}

# Check if Docker is installed
check_docker() {
    print_header "Checking Prerequisites"

    if ! command -v docker &> /dev/null; then
        print_error "Docker is not installed"
        echo "Please install Docker from: https://docs.docker.com/get-docker/"
        exit 1
    fi
    print_success "Docker is installed: $(docker --version)"

    if ! command -v docker compose &> /dev/null && ! command -v docker-compose &> /dev/null; then
        print_error "Docker Compose is not installed"
        echo "Please install Docker Compose from: https://docs.docker.com/compose/install/"
        exit 1
    fi
    print_success "Docker Compose is installed"

    # Check if Docker is running
    if ! docker ps &> /dev/null; then
        print_error "Docker is not running"
        echo "Please start Docker and try again"
        exit 1
    fi
    print_success "Docker is running"
}

# Check environment file
check_env() {
    print_header "Checking Configuration"

    if [ ! -f ".env" ]; then
        print_warning ".env file not found"
        if [ -f ".env.example" ]; then
            print_info "Copying .env.example to .env"
            cp .env.example .env
            print_success "Created .env file"
        else
            print_error ".env.example not found"
            exit 1
        fi
    else
        print_success ".env file exists"
    fi

    # Check if critical variables are set
    if grep -q "FUSION_USERNAME=your-fusion-username" .env 2>/dev/null; then
        print_warning "Oracle Fusion credentials not configured"
        echo ""
        echo "Please edit the .env file and update these values:"
        echo "  - FUSION_BASE_URL"
        echo "  - FUSION_USERNAME"
        echo "  - FUSION_PASSWORD"
        echo ""
        read -p "Do you want to edit .env now? (y/n) " -n 1 -r
        echo
        if [[ $REPLY =~ ^[Yy]$ ]]; then
            ${EDITOR:-nano} .env
        else
            print_info "You can edit .env later with: nano .env"
        fi
    else
        print_success "Oracle Fusion credentials configured"
    fi
}

# Start infrastructure services
start_infrastructure() {
    print_header "Starting Infrastructure Services"
    print_info "Starting PostgreSQL, Redis, RabbitMQ, Kafka..."

    docker compose up -d postgres redis rabbitmq kafka zookeeper

    print_success "Infrastructure services started"
    print_info "Waiting for services to be ready (30 seconds)..."
    sleep 30

    # Check if services are healthy
    print_info "Checking service health..."
    docker compose ps
}

# Start application services
start_application() {
    print_header "Starting Application Services"
    print_info "Starting Gateway API, Fusion Adapter, Reconciliation Engine..."

    docker compose up -d gateway-api fusion-adapter reconciliation-engine audit-engine event-bus

    print_success "Application services started"
    print_info "Waiting for services to be ready (20 seconds)..."
    sleep 20
}

# Verify installation
verify_installation() {
    print_header "Verifying Installation"

    print_info "Checking Gateway API health..."
    if curl -s -f http://localhost:3000/health > /dev/null 2>&1; then
        print_success "Gateway API is healthy"
    else
        print_warning "Gateway API is not responding yet (this is normal, wait a bit)"
    fi

    print_info "Checking service status..."
    docker compose ps
}

# Show next steps
show_next_steps() {
    print_header "Installation Complete! 🎉"

    echo "Vyrooq is now running. Here's what you can do next:"
    echo ""
    echo "1. Check service health:"
    echo "   ${GREEN}curl http://localhost:3000/health${NC}"
    echo ""
    echo "2. View API documentation:"
    echo "   ${GREEN}Open in browser: http://localhost:3000/docs${NC}"
    echo ""
    echo "3. View service logs:"
    echo "   ${GREEN}docker compose logs -f${NC}"
    echo ""
    echo "4. Check specific service:"
    echo "   ${GREEN}docker compose logs -f gateway-api${NC}"
    echo ""
    echo "5. Stop all services:"
    echo "   ${GREEN}docker compose down${NC}"
    echo ""
    echo "6. View all services:"
    echo "   ${GREEN}docker compose ps${NC}"
    echo ""
    echo "Other useful URLs:"
    echo "  - RabbitMQ:  http://localhost:15672 (vyrooq / vyrooq123)"
    echo "  - Grafana:   http://localhost:3002 (admin / vyrooq123)"
    echo "  - Temporal:  http://localhost:8233"
    echo ""
    print_info "For more information, see INSTALLATION.md"
}

# Main execution
main() {
    clear
    echo ""
    echo -e "${BLUE}╔═══════════════════════════════════════════╗${NC}"
    echo -e "${BLUE}║                                           ║${NC}"
    echo -e "${BLUE}║         Vyrooq Quick Start Script         ║${NC}"
    echo -e "${BLUE}║                                           ║${NC}"
    echo -e "${BLUE}║   Enterprise Integration Middleware       ║${NC}"
    echo -e "${BLUE}║                                           ║${NC}"
    echo -e "${BLUE}╚═══════════════════════════════════════════╝${NC}"
    echo ""

    check_docker
    check_env

    print_header "Ready to Install"
    echo "This script will:"
    echo "  1. Start infrastructure services (PostgreSQL, Redis, Kafka, RabbitMQ)"
    echo "  2. Start application services (Gateway API, Fusion Adapter, etc.)"
    echo "  3. Verify the installation"
    echo ""
    read -p "Continue with installation? (y/n) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        print_info "Installation cancelled"
        exit 0
    fi

    start_infrastructure
    start_application
    verify_installation
    show_next_steps
}

# Run main function
main
