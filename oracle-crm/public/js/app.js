/**
 * app.js – shared UI helpers
 */

// ── Auth helpers ──────────────────────────────────────────────────────────────

function requireLogin() {
  const token = localStorage.getItem('crm_token');
  if (!token) {
    window.location.href = '/login.html?redirect=' + encodeURIComponent(window.location.pathname);
    return false;
  }
  return true;
}

function getStoredUser() {
  try { return JSON.parse(localStorage.getItem('crm_user') || 'null'); }
  catch(_) { return null; }
}

function logout() {
  fetch('/api/auth/logout', { method: 'POST' }).catch(() => {});
  localStorage.removeItem('crm_token');
  localStorage.removeItem('crm_user');
  window.location.href = '/login.html';
}

// Intercept all fetch calls to add Authorization header and handle 401s
(function() {
  const _origFetch = window.fetch;
  window.fetch = function(url, opts) {
    opts = opts || {};
    const token = localStorage.getItem('crm_token');
    if (token && typeof url === 'string' && url.startsWith('/api/')) {
      opts.headers = Object.assign({}, opts.headers || {}, { 'Authorization': 'Bearer ' + token });
    }
    return _origFetch.call(this, url, opts).then(function(res) {
      if (res.status === 401) {
        localStorage.removeItem('crm_token');
        localStorage.removeItem('crm_user');
        window.location.href = '/login.html?redirect=' + encodeURIComponent(window.location.pathname);
      }
      return res;
    });
  };
})();

// ── Server mode – apply immediately from localStorage to avoid flash ──────────
const SERVER_MODE_TEST       = 'test';
const SERVER_MODE_PRODUCTION = 'production';
const SERVER_MODE_DEFAULT    = SERVER_MODE_PRODUCTION;
const SERVER_MODE_KEY        = 'crm_server_mode';

function _serverModeBannerText(mode) {
  return mode === SERVER_MODE_TEST
    ? '🔵 TEST MODE – you are connected to the test server'
    : '';
}

(function _applyStoredMode() {
  const stored = localStorage.getItem(SERVER_MODE_KEY);
  if (stored === SERVER_MODE_TEST || stored === SERVER_MODE_PRODUCTION) {
    document.documentElement.setAttribute('data-server-mode', stored);
    if (document.body) document.body.setAttribute('data-server-mode', stored);
  }
})();

// ── Topbar meta: server switcher + last push/pull dates ───────────────────────

function _fmtDate(isoString) {
  if (!isoString) return null;
  try {
    return new Date(isoString).toLocaleString('en', { dateStyle: 'medium', timeStyle: 'short' });
  } catch (_) { return isoString; }
}

async function _loadTopbarMeta() {
  const topbar = document.querySelector('.topbar');
  if (!topbar) return;

  // Build container
  const meta = document.createElement('div');
  meta.id        = 'topbar-meta';
  meta.className = 'topbar-meta';
  topbar.appendChild(meta);

  // ── Server mode switcher ──────────────────────────────────────────────────
  const switcher = document.createElement('div');
  switcher.className = 'server-switcher';
  switcher.innerHTML =
    '<button id="sw-test" onclick="switchServerMode(\'test\')">🔵 Test</button>' +
    '<button id="sw-prod" onclick="switchServerMode(\'production\')">🟢 Production</button>';
  meta.appendChild(switcher);

  // ── Activity pills ────────────────────────────────────────────────────────
  const pushPill = document.createElement('span');
  pushPill.id        = 'tb-push-pill';
  pushPill.className = 'activity-pill push';
  pushPill.innerHTML =
    '<svg width="11" height="11" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2.5"><path d="M5 12h14M12 5l7 7-7 7"/></svg> ' +
    'Last Push: <strong id="tb-push-date">–</strong>';

  const pullPill = document.createElement('span');
  pullPill.id        = 'tb-pull-pill';
  pullPill.className = 'activity-pill pull';
  pullPill.innerHTML =
    '<svg width="11" height="11" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2.5"><path d="M19 12H5M12 19l-7-7 7-7"/></svg> ' +
    'Last Pull: <strong id="tb-pull-date">–</strong>';

  meta.appendChild(pushPill);
  meta.appendChild(pullPill);

  // ── Load data ─────────────────────────────────────────────────────────────
  try {
    const [modeRes, actRes] = await Promise.all([
      fetch('/api/config/server-mode').then(r => r.json()),
      fetch('/api/config/activity-summary').then(r => r.json()),
    ]);

    // Update switcher state
    const mode = modeRes.mode || SERVER_MODE_DEFAULT;
    _applyServerModeUI(mode);

    // Update activity pills
    const pushDate = _fmtDate(actRes.lastPush && actRes.lastPush.at);
    const pullDate = _fmtDate(actRes.lastPull && actRes.lastPull.at);
    document.getElementById('tb-push-date').textContent = pushDate || '–';
    document.getElementById('tb-pull-date').textContent = pullDate || '–';
  } catch (_) { /* non-critical – keep defaults */ }
}

function _applyServerModeUI(mode) {
  const swTest = document.getElementById('sw-test');
  const swProd = document.getElementById('sw-prod');
  if (!swTest || !swProd) return;

  swTest.className = (mode === SERVER_MODE_TEST)       ? 'active-test' : '';
  swProd.className = (mode === SERVER_MODE_PRODUCTION) ? 'active-prod' : '';

  // Apply global mode class to both documentElement and body so CSS rules take
  // effect even before <body> is fully parsed (set on <html> above).
  document.documentElement.setAttribute('data-server-mode', mode);
  document.body.setAttribute('data-server-mode', mode);

  // Persist selection so next page load can apply it before the API responds
  localStorage.setItem(SERVER_MODE_KEY, mode);

  // Update mode banner text
  const banner = document.getElementById('env-mode-banner');
  if (banner) {
    banner.textContent = _serverModeBannerText(mode);
  }

  // Update sidebar env badge text
  const badge = document.getElementById('sidebar-env-badge');
  if (badge) {
    badge.textContent = mode === SERVER_MODE_TEST ? 'Test' : 'Production';
  }

  // Notify page-specific scripts that the mode has changed
  window.dispatchEvent(new CustomEvent('servermodechange', { detail: { mode } }));
}

async function switchServerMode(mode) {
  try {
    await fetch('/api/config/server-mode', {
      method : 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body   : JSON.stringify({ mode }),
    });
    _applyServerModeUI(mode);
    // Reload mode-sensitive data displayed on the current page
    if (typeof window.onServerModeChanged === 'function') {
      window.onServerModeChanged(mode);
    }
  } catch (err) {
    console.warn('Failed to switch server mode:', err);
  }
}

// Mark active sidebar link based on current page
document.addEventListener('DOMContentLoaded', () => {
  const path = window.location.pathname;
  document.querySelectorAll('.sidebar-nav a').forEach(a => {
    const href = a.getAttribute('href');
    if (href && (path === href || (href !== '/' && path.startsWith(href)))) {
      a.classList.add('active');
    }
  });

  // ── Inject environment badge into sidebar logo ──────────────────────────
  const sidebarLogo = document.querySelector('.sidebar-logo');
  if (sidebarLogo && !document.getElementById('sidebar-env-badge')) {
    const badge = document.createElement('span');
    badge.id        = 'sidebar-env-badge';
    badge.className = 'sidebar-env-badge';
    badge.textContent = localStorage.getItem(SERVER_MODE_KEY) === SERVER_MODE_TEST ? 'Test' : 'Production';
    sidebarLogo.appendChild(badge);
  }

  // ── Inject env-mode-banner after topbar ─────────────────────────────────
  const topbar = document.querySelector('.topbar');
  if (topbar && !document.getElementById('env-mode-banner')) {
    const banner = document.createElement('div');
    banner.id = 'env-mode-banner';
    banner.textContent = _serverModeBannerText(localStorage.getItem(SERVER_MODE_KEY) || SERVER_MODE_DEFAULT);
    topbar.insertAdjacentElement('afterend', banner);
  }

  // Populate sidebar user info
  const u = getStoredUser();
  if (u) {
    const av = document.getElementById('sidebar-avatar');
    const un = document.getElementById('sidebar-username');
    const rl = document.getElementById('sidebar-role');
    if (av) {
      if (u.avatar_data) {
        av.innerHTML = `<img src="${u.avatar_data}" alt="avatar" style="width:100%;height:100%;object-fit:cover;border-radius:50%">`;
      } else {
        av.textContent = ((u.display_name || u.username || '').trim() || '?')[0].toUpperCase();
      }
    }
    if (un) un.textContent = u.display_name || u.username;
    if (rl) rl.textContent = u.role || '';
  }

  // Fetch Oracle config status and update sidebar dot
  fetch('/api/config/status')
    .then(r => r.json())
    .then(data => {
      const dot = document.getElementById('status-dot');
      const lbl = document.getElementById('status-label');
      if (dot && lbl) {
        if (data.configured) {
          dot.classList.add('ok');
          lbl.textContent = 'Oracle connected';
        } else {
          lbl.textContent = 'Not configured';
        }
      }
    })
    .catch(() => {});

  // Inject server-switcher and activity dates into topbar
  _loadTopbarMeta().catch(() => {});
});

// Format a number as currency
function fmtMoney(n, decimals = 2) {
  return Number(n).toLocaleString('en', { minimumFractionDigits: decimals, maximumFractionDigits: decimals });
}

// Render a pretty JSON preview into an element
function renderPreview(el, obj) {
  if (!el || !obj) return;
  const json = JSON.stringify(obj, null, 2);
  el.textContent = json;
}

// Show/hide alert banner
function showAlert(el, type, msg) {
  if (!el) return;
  el.className = `alert alert-${type}`;
  el.textContent = msg;
  el.classList.remove('hidden');
}
function hideAlert(el) {
  if (el) el.classList.add('hidden');
}

// Escape HTML special characters to prevent XSS in template literals
function escHtml(str) {
  return String(str ?? '')
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
    .replace(/'/g, '&#39;');
}
