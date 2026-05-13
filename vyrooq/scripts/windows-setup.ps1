# Vyrooq Windows Setup Script
# Run this script as Administrator

Write-Host "=================================================" -ForegroundColor Cyan
Write-Host "   Vyrooq Integration Platform - Windows Setup  " -ForegroundColor Cyan
Write-Host "=================================================" -ForegroundColor Cyan
Write-Host ""

# Check if running as Administrator
$currentUser = New-Object Security.Principal.WindowsPrincipal([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)) {
    Write-Host "ERROR: This script must be run as Administrator!" -ForegroundColor Red
    Write-Host "Please right-click PowerShell and select 'Run as Administrator'" -ForegroundColor Yellow
    exit 1
}

Write-Host "[1/10] Checking prerequisites..." -ForegroundColor Green

# Check Node.js
try {
    $nodeVersion = node --version
    Write-Host "✓ Node.js installed: $nodeVersion" -ForegroundColor Green
} catch {
    Write-Host "✗ Node.js not found. Please install Node.js 22+ from https://nodejs.org/" -ForegroundColor Red
    exit 1
}

# Check Python
try {
    $pythonVersion = python --version
    Write-Host "✓ Python installed: $pythonVersion" -ForegroundColor Green
} catch {
    Write-Host "✗ Python not found. Please install Python 3.13+ from https://www.python.org/" -ForegroundColor Red
    exit 1
}

# Check Docker
try {
    $dockerVersion = docker --version
    Write-Host "✓ Docker installed: $dockerVersion" -ForegroundColor Green
} catch {
    Write-Host "⚠ Docker not found. Installing Docker Desktop is recommended." -ForegroundColor Yellow
    Write-Host "  Download from: https://www.docker.com/products/docker-desktop" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "[2/10] Creating directory structure..." -ForegroundColor Green

# Create service directories
$services = @(
    "gateway-api",
    "auth-service",
    "integration-core",
    "workflow-engine",
    "retry-engine",
    "deduplication-engine",
    "manual-control-engine",
    "audit-engine",
    "reconciliation-engine",
    "reporting-engine",
    "fusion-adapter",
    "vendhq-adapter",
    "opencart-adapter",
    "event-bus",
    "admin-dashboard-api",
    "database",
    "docker",
    "k8s",
    "docs",
    "tests"
)

foreach ($service in $services) {
    $path = ".\$service"
    if (-not (Test-Path $path)) {
        New-Item -ItemType Directory -Path $path -Force | Out-Null
        Write-Host "  Created: $service" -ForegroundColor Gray
    }
}

Write-Host ""
Write-Host "[3/10] Installing Node.js dependencies..." -ForegroundColor Green

# Gateway API
Set-Location gateway-api
if (Test-Path "package.json") {
    npm install
} else {
    Write-Host "  Skipping gateway-api (package.json not found)" -ForegroundColor Yellow
}
Set-Location ..

# Other Node.js services
$nodeServices = @("auth-service", "retry-engine", "manual-control-engine", "admin-dashboard-api", "event-bus")
foreach ($service in $nodeServices) {
    Set-Location $service
    if (Test-Path "package.json") {
        npm install
    }
    Set-Location ..
}

Write-Host ""
Write-Host "[4/10] Installing Python dependencies..." -ForegroundColor Green

# Workflow Engine
Set-Location workflow-engine
if (Test-Path "requirements.txt") {
    python -m pip install -r requirements.txt
} else {
    Write-Host "  Skipping workflow-engine (requirements.txt not found)" -ForegroundColor Yellow
}
Set-Location ..

# Other Python services
$pythonServices = @("reporting-engine", "reconciliation-engine")
foreach ($service in $pythonServices) {
    Set-Location $service
    if (Test-Path "requirements.txt") {
        python -m pip install -r requirements.txt
    }
    Set-Location ..
}

Write-Host ""
Write-Host "[5/10] Starting Docker services..." -ForegroundColor Green

try {
    # Check if Docker is running
    docker info | Out-Null

    Write-Host "  Starting PostgreSQL..." -ForegroundColor Gray
    docker run -d --name vyrooq-postgres `
        -e POSTGRES_PASSWORD=vyrooq123 `
        -e POSTGRES_DB=vyrooq `
        -p 5432:5432 `
        postgres:16-alpine 2>$null

    Write-Host "  Starting Redis..." -ForegroundColor Gray
    docker run -d --name vyrooq-redis `
        -p 6379:6379 `
        redis:7-alpine 2>$null

    Write-Host "  Starting RabbitMQ..." -ForegroundColor Gray
    docker run -d --name vyrooq-rabbitmq `
        -e RABBITMQ_DEFAULT_USER=vyrooq `
        -e RABBITMQ_DEFAULT_PASS=vyrooq123 `
        -p 5672:5672 `
        -p 15672:15672 `
        rabbitmq:3-management-alpine 2>$null

    Write-Host "  Docker services started successfully" -ForegroundColor Green
} catch {
    Write-Host "  ⚠ Docker not available. Services need to be installed manually." -ForegroundColor Yellow
}

Write-Host ""
Write-Host "[6/10] Setting up PostgreSQL database..." -ForegroundColor Green

Start-Sleep -Seconds 5  # Wait for PostgreSQL to start

try {
    docker exec vyrooq-postgres psql -U postgres -d vyrooq -c "SELECT 1" | Out-Null

    # Run database migrations
    if (Test-Path "database\migrations\001_initial_schema.sql") {
        Write-Host "  Running database migrations..." -ForegroundColor Gray
        docker exec -i vyrooq-postgres psql -U postgres -d vyrooq < database\migrations\001_initial_schema.sql
    }

    Write-Host "  Database setup complete" -ForegroundColor Green
} catch {
    Write-Host "  ⚠ Could not connect to PostgreSQL" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "[7/10] Creating environment configuration files..." -ForegroundColor Green

# Create .env files for each service
$envTemplate = @"
# Vyrooq Environment Configuration
# Copy this to .env and fill in your credentials

# Database
DATABASE_URL=postgresql://postgres:vyrooq123@localhost:5432/vyrooq

# Redis
REDIS_URL=redis://localhost:6379

# RabbitMQ
RABBITMQ_URL=amqp://vyrooq:vyrooq123@localhost:5672

# Kafka
KAFKA_BROKERS=localhost:9092

# Oracle Fusion
FUSION_BASE_URL=https://your-instance.fa.your-region.oraclecloud.com
FUSION_USERNAME=your-fusion-username
FUSION_PASSWORD=your-fusion-password

# VendHQ
VENDHQ_API_URL=https://yourdomain.vendhq.com/api/2.0
VENDHQ_API_TOKEN=your-vendhq-token

# Opencart
OPENCART_API_URL=https://your-opencart-domain.com/api
OPENCART_API_KEY=your-opencart-key

# JWT Secret
JWT_SECRET=your-secret-key-change-this-in-production

# Environment
NODE_ENV=development
PORT=3000
"@

foreach ($service in @("gateway-api", "auth-service", "fusion-adapter", "vendhq-adapter", "opencart-adapter")) {
    $envPath = "$service\.env.example"
    if (-not (Test-Path $envPath)) {
        $envTemplate | Out-File -FilePath $envPath -Encoding UTF8
        Write-Host "  Created: $service\.env.example" -ForegroundColor Gray
    }
}

Write-Host ""
Write-Host "[8/10] Building TypeScript services..." -ForegroundColor Green

$tsServices = @("gateway-api", "auth-service", "integration-core")
foreach ($service in $tsServices) {
    Set-Location $service
    if (Test-Path "tsconfig.json") {
        Write-Host "  Building $service..." -ForegroundColor Gray
        npm run build 2>$null
    }
    Set-Location ..
}

Write-Host ""
Write-Host "[9/10] Generating Prisma client..." -ForegroundColor Green

Set-Location gateway-api
if (Test-Path "prisma\schema.prisma") {
    npx prisma generate 2>$null
}
Set-Location ..

Write-Host ""
Write-Host "[10/10] Creating startup scripts..." -ForegroundColor Green

# Create start-all-services.ps1
$startScript = @"
# Start All Vyrooq Services
Write-Host "Starting Vyrooq services..." -ForegroundColor Cyan

# Start Gateway API
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd gateway-api; npm run dev" -WindowStyle Normal

# Start Workflow Engine
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd workflow-engine; python main.py" -WindowStyle Normal

# Start Manual Control Engine
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd manual-control-engine; npm run dev" -WindowStyle Normal

Write-Host "All services started! Check individual windows for logs." -ForegroundColor Green
"@

$startScript | Out-File -FilePath "scripts\start-all-services.ps1" -Encoding UTF8

Write-Host ""
Write-Host "=================================================" -ForegroundColor Green
Write-Host "   Setup Complete!                              " -ForegroundColor Green
Write-Host "=================================================" -ForegroundColor Green
Write-Host ""
Write-Host "Next steps:" -ForegroundColor Yellow
Write-Host "1. Configure environment files (*.env) in each service directory" -ForegroundColor White
Write-Host "2. Run: .\scripts\start-all-services.ps1" -ForegroundColor White
Write-Host "3. Access API documentation: http://localhost:3000/docs" -ForegroundColor White
Write-Host ""
Write-Host "Docker Services:" -ForegroundColor Yellow
Write-Host "  PostgreSQL: localhost:5432" -ForegroundColor White
Write-Host "  Redis: localhost:6379" -ForegroundColor White
Write-Host "  RabbitMQ: localhost:15672 (user: vyrooq, pass: vyrooq123)" -ForegroundColor White
Write-Host ""
Write-Host "For help, visit: https://github.com/MUSTAQ-AHAMMAD/integration-Oracle/wiki" -ForegroundColor Cyan
