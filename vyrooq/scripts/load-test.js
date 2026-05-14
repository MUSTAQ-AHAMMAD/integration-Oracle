import http from 'k6/http';
import { check, sleep } from 'k6';
import { Rate } from 'k6/metrics';

// Custom metrics
const errorRate = new Rate('errors');

// Load test configuration
export const options = {
  stages: [
    { duration: '2m', target: 50 },   // Ramp up to 50 users
    { duration: '5m', target: 100 },  // Ramp up to 100 users
    { duration: '5m', target: 100 },  // Stay at 100 users
    { duration: '2m', target: 200 },  // Peak at 200 users
    { duration: '3m', target: 200 },  // Stay at peak
    { duration: '2m', target: 0 },    // Ramp down to 0 users
  ],
  thresholds: {
    http_req_duration: ['p(95)<5000'], // 95% of requests should be below 5s
    http_req_failed: ['rate<0.05'],    // Error rate should be below 5%
    errors: ['rate<0.05'],             // Custom error rate below 5%
  },
};

// Base URLs
const API_BASE = __ENV.API_BASE || 'http://localhost:3000';
const AUTH_BASE = __ENV.AUTH_BASE || 'http://localhost:3100';

// Test data
const testSale = {
  saleId: `sale-${Date.now()}-${Math.random()}`,
  storeId: 'store-001',
  saleDate: new Date().toISOString(),
  totalAmount: 150.00,
  currency: 'USD',
  lineItems: [
    {
      itemCode: 'ITEM-001',
      quantity: 2,
      unitPrice: 50.00,
      totalPrice: 100.00,
    },
    {
      itemCode: 'ITEM-002',
      quantity: 1,
      unitPrice: 50.00,
      totalPrice: 50.00,
    },
  ],
};

export default function () {
  // Test 1: Health Check
  let healthRes = http.get(`${API_BASE}/health`);
  check(healthRes, {
    'health check status is 200': (r) => r.status === 200,
  }) || errorRate.add(1);

  sleep(1);

  // Test 2: Get API Documentation
  let docsRes = http.get(`${API_BASE}/docs`, {
    tags: { name: 'docs' },
  });
  check(docsRes, {
    'docs accessible': (r) => r.status === 200 || r.status === 404,
  }) || errorRate.add(1);

  sleep(1);

  // Test 3: Authentication Endpoint (expect 401 or 400)
  let authRes = http.post(
    `${AUTH_BASE}/auth/login`,
    JSON.stringify({
      username: 'testuser',
      password: 'testpass',
    }),
    {
      headers: { 'Content-Type': 'application/json' },
      tags: { name: 'auth' },
    }
  );
  check(authRes, {
    'auth endpoint responds': (r) => r.status === 401 || r.status === 400 || r.status === 200,
  }) || errorRate.add(1);

  sleep(1);

  // Test 4: API Gateway root
  let rootRes = http.get(`${API_BASE}/`, {
    tags: { name: 'root' },
  });
  check(rootRes, {
    'root endpoint accessible': (r) => r.status === 200 || r.status === 404,
  }) || errorRate.add(1);

  sleep(2);
}

export function handleSummary(data) {
  return {
    'load-test-results.json': JSON.stringify(data),
    stdout: textSummary(data),
  };
}

function textSummary(data) {
  const summary = {
    'Total Requests': data.metrics.http_reqs.values.count,
    'Request Rate': `${data.metrics.http_reqs.values.rate.toFixed(2)}/s`,
    'Failed Requests': data.metrics.http_req_failed.values.passes,
    'Error Rate': `${(data.metrics.errors?.values.rate * 100 || 0).toFixed(2)}%`,
    'Average Duration': `${data.metrics.http_req_duration.values.avg.toFixed(2)}ms`,
    'P95 Duration': `${data.metrics.http_req_duration.values['p(95)'].toFixed(2)}ms`,
    'P99 Duration': `${data.metrics.http_req_duration.values['p(99)'].toFixed(2)}ms`,
  };

  let output = '\n===========================================\n';
  output += '   Load Test Results\n';
  output += '===========================================\n\n';

  for (const [key, value] of Object.entries(summary)) {
    output += `${key.padEnd(20)}: ${value}\n`;
  }

  output += '\n===========================================\n';

  return output;
}
