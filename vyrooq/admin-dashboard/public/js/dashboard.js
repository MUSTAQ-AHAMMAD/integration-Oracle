// Global state
let authToken = localStorage.getItem('authToken');
let currentUser = null;

// API Base URL
const API_BASE = '/api';

// Initialize dashboard
document.addEventListener('DOMContentLoaded', () => {
    checkAuth();
    loadServicesStatus();
    loadMetrics();
    startAutoRefresh();

    // Event listeners
    document.getElementById('login-form')?.addEventListener('submit', handleLogin);
    document.getElementById('logout-btn')?.addEventListener('click', handleLogout);
    document.getElementById('refresh-btn')?.addEventListener('click', refreshAll);
});

// Authentication
function checkAuth() {
    if (!authToken) {
        showLoginModal();
    } else {
        hideLoginModal();
        updateUserInfo();
    }
}

function showLoginModal() {
    const modal = document.getElementById('login-modal');
    modal.classList.add('active');
}

function hideLoginModal() {
    const modal = document.getElementById('login-modal');
    modal.classList.remove('active');
}

function updateUserInfo() {
    if (authToken) {
        // Decode JWT to get user info (basic decoding, not secure validation)
        try {
            const payload = JSON.parse(atob(authToken.split('.')[1]));
            currentUser = payload;
            document.getElementById('user-info').textContent =
                `${payload.username} (${payload.role})`;
            document.getElementById('logout-btn').style.display = 'block';
        } catch (e) {
            console.error('Failed to decode token', e);
        }
    }
}

async function handleLogin(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const errorDiv = document.getElementById('login-error');

    try {
        const response = await fetch(`${API_BASE}/auth/login`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
        });

        const data = await response.json();

        if (response.ok && data.accessToken) {
            authToken = data.accessToken;
            localStorage.setItem('authToken', authToken);
            hideLoginModal();
            updateUserInfo();
            showToast('Login successful!', 'success');
            refreshAll();
        } else {
            errorDiv.textContent = data.message || 'Login failed';
            errorDiv.style.display = 'block';
        }
    } catch (error) {
        errorDiv.textContent = 'Network error: ' + error.message;
        errorDiv.style.display = 'block';
    }
}

function handleLogout() {
    authToken = null;
    currentUser = null;
    localStorage.removeItem('authToken');
    document.getElementById('user-info').textContent = 'Not Logged In';
    document.getElementById('logout-btn').style.display = 'none';
    showLoginModal();
    showToast('Logged out successfully', 'info');
}

// Load services status
async function loadServicesStatus() {
    const grid = document.getElementById('services-grid');
    grid.innerHTML = '<div class="service-card loading"><div class="spinner"></div></div>';

    try {
        const response = await fetch(`${API_BASE}/services/status`);
        const data = await response.json();

        grid.innerHTML = '';
        data.services.forEach(service => {
            const card = createServiceCard(service);
            grid.appendChild(card);
        });
    } catch (error) {
        grid.innerHTML = `<div class="service-card"><p class="error-message">Failed to load services: ${error.message}</p></div>`;
    }
}

function createServiceCard(service) {
    const card = document.createElement('div');
    card.className = `service-card ${service.status}`;

    const statusIcon = service.status === 'healthy' ? 'check-circle' : 'exclamation-circle';

    card.innerHTML = `
        <div class="service-header">
            <h3>${formatServiceName(service.name)}</h3>
            <div class="service-status ${service.status}">
                <span class="service-status-dot"></span>
                ${service.status}
            </div>
        </div>
        <div class="service-info">
            <p><strong>URL:</strong> ${service.url}</p>
            ${service.data ? `
                <p><strong>Uptime:</strong> ${formatUptime(service.data.uptime)}</p>
                <p><strong>Status:</strong> ${service.data.status}</p>
            ` : `
                <p class="text-muted">${service.error || 'Service unavailable'}</p>
            `}
        </div>
    `;

    return card;
}

function formatServiceName(name) {
    const names = {
        auth: 'Auth Service',
        retry: 'Retry Engine',
        dedup: 'Deduplication Engine',
        control: 'Manual Control',
        gateway: 'Gateway API',
        vendhq: 'VendHQ Adapter',
        opencart: 'Opencart Adapter',
    };
    return names[name] || name;
}

function formatUptime(seconds) {
    const hours = Math.floor(seconds / 3600);
    const minutes = Math.floor((seconds % 3600) / 60);
    return `${hours}h ${minutes}m`;
}

// Load metrics
async function loadMetrics() {
    await Promise.all([
        loadQueueMetrics(),
        loadDedupMetrics(),
        loadIntegrationMetrics(),
    ]);
}

async function loadQueueMetrics() {
    const container = document.getElementById('queue-metrics');

    try {
        const response = await fetch(`${API_BASE}/retry/metrics`);
        const data = await response.json();

        if (data.queues) {
            let html = '';
            for (const [name, stats] of Object.entries(data.queues)) {
                html += `
                    <div class="metric-row">
                        <span class="metric-label">${name}:</span>
                        <span class="metric-value">${stats.total || 0}</span>
                    </div>
                `;
            }
            container.innerHTML = html;
        } else {
            container.innerHTML = '<p class="text-muted">No data available</p>';
        }
    } catch (error) {
        container.innerHTML = `<p class="text-muted">Error: ${error.message}</p>`;
    }
}

async function loadDedupMetrics() {
    const container = document.getElementById('dedup-metrics');

    try {
        const response = await fetch(`${API_BASE}/dedup/stats`);
        const data = await response.json();

        if (data.stats) {
            container.innerHTML = `
                <div class="metric-row">
                    <span class="metric-label">Fingerprints:</span>
                    <span class="metric-value">${data.stats.fingerprints || 0}</span>
                </div>
                <div class="metric-row">
                    <span class="metric-label">Idempotency Keys:</span>
                    <span class="metric-value">${data.stats.idempotencyKeys || 0}</span>
                </div>
                <div class="metric-row">
                    <span class="metric-label">Correlations:</span>
                    <span class="metric-value">${data.stats.correlations || 0}</span>
                </div>
            `;
        } else {
            container.innerHTML = '<p class="text-muted">No data available</p>';
        }
    } catch (error) {
        container.innerHTML = `<p class="text-muted">Error: ${error.message}</p>`;
    }
}

async function loadIntegrationMetrics() {
    const container = document.getElementById('integration-metrics');

    try {
        // Load VendHQ and Opencart stats in parallel
        const [vendHqResp, opencartResp] = await Promise.all([
            fetch(`${API_BASE}/vendhq/sales`).catch(() => ({ ok: false })),
            fetch(`${API_BASE}/opencart/orders`).catch(() => ({ ok: false })),
        ]);

        let html = '';

        if (vendHqResp.ok) {
            const vendHqData = await vendHqResp.json();
            html += `
                <div class="metric-row">
                    <span class="metric-label">VendHQ Sales:</span>
                    <span class="metric-value">${vendHqData.count || 0}</span>
                </div>
            `;
        }

        if (opencartResp.ok) {
            const opencartData = await opencartResp.json();
            html += `
                <div class="metric-row">
                    <span class="metric-label">Opencart Orders:</span>
                    <span class="metric-value">${opencartData.count || 0}</span>
                </div>
            `;
        }

        container.innerHTML = html || '<p class="text-muted">No data available</p>';
    } catch (error) {
        container.innerHTML = `<p class="text-muted">Error: ${error.message}</p>`;
    }
}

// Quick Actions
async function pauseAllQueues() {
    if (!authToken) {
        showToast('Please login first', 'error');
        return;
    }

    if (!confirm('Are you sure you want to pause ALL queues? This will stop all processing.')) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE}/control/queues/pause-all`, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${authToken}`,
            },
        });

        const data = await response.json();

        if (response.ok) {
            showToast('All queues paused successfully', 'success');
            refreshAll();
        } else {
            showToast(data.message || 'Failed to pause queues', 'error');
        }
    } catch (error) {
        showToast('Error: ' + error.message, 'error');
    }
}

async function resumeAllQueues() {
    if (!authToken) {
        showToast('Please login first', 'error');
        return;
    }

    if (!confirm('Resume all queues and restart processing?')) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE}/control/queues/resume-all`, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${authToken}`,
            },
        });

        const data = await response.json();

        if (response.ok) {
            showToast('All queues resumed successfully', 'success');
            refreshAll();
        } else {
            showToast(data.message || 'Failed to resume queues', 'error');
        }
    } catch (error) {
        showToast('Error: ' + error.message, 'error');
    }
}

function viewMetrics() {
    window.location.href = '/pages/queues.html';
}

function viewDedupStats() {
    window.location.href = '/pages/deduplication.html';
}

// Refresh all data
function refreshAll() {
    loadServicesStatus();
    loadMetrics();
    showToast('Dashboard refreshed', 'info');
}

// Auto-refresh every 30 seconds
function startAutoRefresh() {
    setInterval(() => {
        loadServicesStatus();
        loadMetrics();
    }, 30000);
}

// Toast notifications
function showToast(message, type = 'info') {
    const container = document.getElementById('toast-container');
    const toast = document.createElement('div');
    toast.className = `toast ${type}`;

    const icon = type === 'success' ? 'check-circle' :
                 type === 'error' ? 'exclamation-circle' :
                 'info-circle';

    toast.innerHTML = `
        <i class="fas fa-${icon}"></i>
        <span>${message}</span>
    `;

    container.appendChild(toast);

    setTimeout(() => {
        toast.style.animation = 'slideIn 0.3s ease-out reverse';
        setTimeout(() => toast.remove(), 300);
    }, 3000);
}

// Utility functions
function formatTimestamp(timestamp) {
    return new Date(timestamp).toLocaleString();
}

function formatNumber(num) {
    return new Intl.NumberFormat().format(num);
}
