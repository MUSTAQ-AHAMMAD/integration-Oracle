/**
 * app.js – shared UI helpers
 */

// Mark active sidebar link based on current page
document.addEventListener('DOMContentLoaded', () => {
  const path = window.location.pathname;
  document.querySelectorAll('.sidebar-nav a').forEach(a => {
    const href = a.getAttribute('href');
    if (href && (path === href || (href !== '/' && path.startsWith(href)))) {
      a.classList.add('active');
    }
  });

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
