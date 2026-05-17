#!/bin/bash
#
# docker-rebuild.sh - Helper script for Docker operations
# This script helps rebuild the Docker image and restart the container

set -e

echo "════════════════════════════════════════════════════════════════"
echo "  Oracle-CRM Docker Rebuild Helper"
echo "════════════════════════════════════════════════════════════════"
echo ""

# Check if docker-compose is available
if ! command -v docker-compose &> /dev/null; then
    echo "❌ Error: docker-compose is not installed or not in PATH"
    exit 1
fi

# Check if Docker daemon is running
if ! docker info &> /dev/null; then
    echo "❌ Error: Docker daemon is not running"
    exit 1
fi

echo "✓ Docker is available"
echo ""

# Parse command line arguments
REBUILD=false
NO_CACHE=false
RESET_CREDS=false

while [[ $# -gt 0 ]]; do
    case $1 in
        --rebuild)
            REBUILD=true
            shift
            ;;
        --no-cache)
            NO_CACHE=true
            REBUILD=true
            shift
            ;;
        --reset-credentials)
            RESET_CREDS=true
            shift
            ;;
        --help)
            echo "Usage: $0 [OPTIONS]"
            echo ""
            echo "Options:"
            echo "  --rebuild              Rebuild the Docker image"
            echo "  --no-cache             Rebuild without using cache (implies --rebuild)"
            echo "  --reset-credentials    Run reset-credentials.js after starting"
            echo "  --help                 Show this help message"
            echo ""
            echo "Examples:"
            echo "  $0 --rebuild           # Rebuild and restart the container"
            echo "  $0 --no-cache          # Force fresh rebuild without cache"
            echo "  $0 --reset-credentials # Start container and reset credentials"
            exit 0
            ;;
        *)
            echo "❌ Unknown option: $1"
            echo "Run '$0 --help' for usage information"
            exit 1
            ;;
    esac
done

# If no arguments, default to rebuild
if [ "$REBUILD" = false ] && [ "$RESET_CREDS" = false ]; then
    REBUILD=true
fi

# Build and start
if [ "$REBUILD" = true ]; then
    echo "🔨 Rebuilding Docker image..."
    if [ "$NO_CACHE" = true ]; then
        echo "   (with --no-cache flag)"
        docker-compose build --no-cache
    else
        docker-compose build
    fi
    echo ""
fi

echo "🚀 Starting container..."
docker-compose up -d
echo ""

# Wait for container to be ready
echo "⏳ Waiting for container to be ready..."
sleep 3

# Check if container is running
if ! docker ps | grep -q oracle-crm; then
    echo "❌ Error: Container failed to start"
    echo ""
    echo "View logs with: docker-compose logs"
    exit 1
fi

echo "✓ Container is running"
echo ""

# Reset credentials if requested
if [ "$RESET_CREDS" = true ]; then
    echo "🔐 Running credential reset utility..."
    echo ""
    docker exec -it oracle-crm node reset-credentials.js
    echo ""
fi

echo "════════════════════════════════════════════════════════════════"
echo "✅ Oracle-CRM is ready!"
echo "════════════════════════════════════════════════════════════════"
echo ""
echo "Useful commands:"
echo "  docker-compose logs -f              # View live logs"
echo "  docker-compose down                 # Stop the container"
echo "  docker exec -it oracle-crm sh       # Access container shell"
echo "  docker exec -it oracle-crm node reset-credentials.js"
echo "                                      # Reset admin credentials"
echo ""
