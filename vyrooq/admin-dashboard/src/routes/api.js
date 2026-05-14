const express = require('express');
const axios = require('axios');
const router = express.Router();

// Service URLs from environment
const SERVICES = {
  auth: process.env.AUTH_SERVICE_URL || 'http://localhost:3100',
  retry: process.env.RETRY_ENGINE_URL || 'http://localhost:3200',
  dedup: process.env.DEDUPLICATION_ENGINE_URL || 'http://localhost:3300',
  control: process.env.MANUAL_CONTROL_ENGINE_URL || 'http://localhost:3400',
  gateway: process.env.GATEWAY_API_URL || 'http://localhost:3000',
  vendhq: process.env.VENDHQ_ADAPTER_URL || 'http://localhost:8100',
  opencart: process.env.OPENCART_ADAPTER_URL || 'http://localhost:8200',
};

// Helper function to check service health
async function checkServiceHealth(url) {
  try {
    const response = await axios.get(`${url}/health`, { timeout: 3000 });
    return { status: 'healthy', data: response.data };
  } catch (error) {
    return { status: 'unhealthy', error: error.message };
  }
}

// Get all services status
router.get('/services/status', async (req, res) => {
  try {
    const statusPromises = Object.entries(SERVICES).map(async ([name, url]) => {
      const health = await checkServiceHealth(url);
      return { name, url, ...health };
    });

    const statuses = await Promise.all(statusPromises);
    res.json({ services: statuses });
  } catch (error) {
    res.status(500).json({ error: 'Failed to check services', message: error.message });
  }
});

// Proxy requests to services with authentication
async function proxyRequest(serviceUrl, path, method = 'GET', data = null, token = null) {
  const headers = {};
  if (token) {
    headers['Authorization'] = `Bearer ${token}`;
  }

  const config = {
    method,
    url: `${serviceUrl}${path}`,
    headers,
    timeout: 10000,
  };

  if (data && (method === 'POST' || method === 'PUT' || method === 'PATCH')) {
    config.data = data;
  }

  return axios(config);
}

// Auth service proxy
router.post('/auth/login', async (req, res) => {
  try {
    const response = await proxyRequest(SERVICES.auth, '/auth/login', 'POST', req.body);
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Login failed',
      message: error.response?.data?.message || error.message,
    });
  }
});

// Retry engine - get metrics
router.get('/retry/metrics', async (req, res) => {
  try {
    const response = await proxyRequest(SERVICES.retry, '/metrics');
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to get retry metrics',
      message: error.message,
    });
  }
});

// Manual control - get queues status
router.get('/control/queues', async (req, res) => {
  try {
    const token = req.headers.authorization?.replace('Bearer ', '');
    const response = await proxyRequest(SERVICES.control, '/queues', 'GET', null, token);
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to get queues',
      message: error.message,
    });
  }
});

// Manual control - pause queue
router.post('/control/queues/:name/pause', async (req, res) => {
  try {
    const token = req.headers.authorization?.replace('Bearer ', '');
    const response = await proxyRequest(
      SERVICES.control,
      `/queues/${req.params.name}/pause`,
      'POST',
      null,
      token
    );
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to pause queue',
      message: error.message,
    });
  }
});

// Manual control - resume queue
router.post('/control/queues/:name/resume', async (req, res) => {
  try {
    const token = req.headers.authorization?.replace('Bearer ', '');
    const response = await proxyRequest(
      SERVICES.control,
      `/queues/${req.params.name}/resume`,
      'POST',
      null,
      token
    );
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to resume queue',
      message: error.message,
    });
  }
});

// Manual control - retry failed jobs
router.post('/control/queues/:name/retry', async (req, res) => {
  try {
    const token = req.headers.authorization?.replace('Bearer ', '');
    const response = await proxyRequest(
      SERVICES.control,
      `/queues/${req.params.name}/retry`,
      'POST',
      req.body,
      token
    );
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to retry jobs',
      message: error.message,
    });
  }
});

// Deduplication - get stats
router.get('/dedup/stats', async (req, res) => {
  try {
    const response = await proxyRequest(SERVICES.dedup, '/stats');
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to get deduplication stats',
      message: error.message,
    });
  }
});

// VendHQ - get sales
router.get('/vendhq/sales', async (req, res) => {
  try {
    const response = await proxyRequest(SERVICES.vendhq, '/sales', 'GET');
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to get VendHQ sales',
      message: error.message,
    });
  }
});

// Opencart - get orders
router.get('/opencart/orders', async (req, res) => {
  try {
    const response = await proxyRequest(SERVICES.opencart, '/orders', 'GET');
    res.json(response.data);
  } catch (error) {
    res.status(error.response?.status || 500).json({
      error: 'Failed to get Opencart orders',
      message: error.message,
    });
  }
});

module.exports = router;
