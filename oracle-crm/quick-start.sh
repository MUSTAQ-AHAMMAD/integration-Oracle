#!/bin/bash

# Quick Start Script for Odoo to Oracle Integration
# This script helps you get started quickly

set -e

echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "🚀 Odoo to Oracle Integration - Quick Start"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

cd oracle-crm

# Check if .env exists
if [ ! -f .env ]; then
    echo "❌ Error: .env file not found!"
    echo "   The .env file should have been created. Please check the directory."
    exit 1
fi

echo "✅ Found .env configuration file"
echo ""

# Check if node_modules exists
if [ ! -d node_modules ]; then
    echo "📦 Installing dependencies..."
    npm install
    echo "✅ Dependencies installed"
    echo ""
else
    echo "✅ Dependencies already installed"
    echo ""
fi

# Check Oracle credentials
echo "🔍 Checking configuration..."
if grep -q "your-oracle-fusion-username" .env; then
    echo ""
    echo "⚠️  WARNING: Oracle Fusion credentials not configured!"
    echo "   Please edit oracle-crm/.env and update:"
    echo "   - FUSION_BASE_URL"
    echo "   - FUSION_USERNAME"
    echo "   - FUSION_PASSWORD"
    echo ""
    echo "   Press Enter to continue with testing Odoo endpoints only..."
    read -r
fi

# Test Odoo endpoints
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "🧪 Testing Odoo REST API Endpoints"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

node test-endpoints.js

TEST_RESULT=$?

if [ $TEST_RESULT -eq 0 ]; then
    echo ""
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    echo "✅ All tests passed!"
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    echo ""
    echo "📚 Next Steps:"
    echo ""
    echo "1. Update Oracle credentials in .env (if not done already)"
    echo ""
    echo "2. Start the server:"
    echo "   npm start"
    echo ""
    echo "3. In another terminal, fetch data from Odoo:"
    echo "   curl -X POST http://localhost:3000/api/odoo/fetch \\"
    echo "     -H 'Content-Type: application/json' \\"
    echo "     -d '{\"dateFrom\": \"2026-02-01\", \"dateTo\": \"2026-02-02\"}'"
    echo ""
    echo "4. Check the job status (use jobId from step 3):"
    echo "   curl http://localhost:3000/api/odoo/jobs/{jobId}"
    echo ""
    echo "5. Once fetch completes, push to Oracle:"
    echo "   curl -X POST http://localhost:3000/api/odoo/push \\"
    echo "     -H 'Content-Type: application/json' \\"
    echo "     -d '{\"dateFrom\": \"2026-02-01\", \"dateTo\": \"2026-02-02\", \"mode\": \"ALL_STORES_DATE\"}'"
    echo ""
    echo "📖 For detailed documentation, see:"
    echo "   - CONFIGURATION_GUIDE.md (comprehensive setup guide)"
    echo "   - IMPLEMENTATION_SUMMARY.md (what was implemented)"
    echo ""
    echo "🎉 You're ready to go!"
else
    echo ""
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    echo "❌ Some tests failed!"
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    echo ""
    echo "Please check:"
    echo "1. Your .env file has the correct ODOO_URL and ODOO_API_KEY"
    echo "2. Your Odoo server is accessible"
    echo "3. The API endpoints are correct for your Odoo version"
    echo ""
    echo "For troubleshooting, see CONFIGURATION_GUIDE.md"
    exit 1
fi
