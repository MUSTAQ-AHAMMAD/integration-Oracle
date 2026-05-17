'use strict';

// Redirect if already logged in
if (localStorage.getItem('crm_token')) {
  const params = new URLSearchParams(window.location.search);
  window.location.replace(params.get('redirect') || '/');
}

// Toggle password visibility
document.getElementById('toggle-pass').addEventListener('click', function() {
  const pw = document.getElementById('password');
  if (pw.type === 'password') {
    pw.type = 'text';
    this.textContent = '🙈';
  } else {
    pw.type = 'password';
    this.textContent = '👁';
  }
});

// Handle login form submission
document.getElementById('login-form').addEventListener('submit', async function(e) {
  e.preventDefault();
  const alert  = document.getElementById('alert');
  const btn    = document.getElementById('btn-login');
  const uname  = document.getElementById('username').value.trim();
  const passwd = document.getElementById('password').value;

  alert.classList.remove('show');
  btn.disabled = true;
  btn.textContent = 'Signing in…';

  try {
    const res  = await fetch('/api/auth/login', {
      method : 'POST',
      headers: { 'Content-Type': 'application/json' },
      body   : JSON.stringify({ username: uname, password: passwd }),
    });
    const data = await res.json();
    if (!res.ok) {
      document.getElementById('alert-msg').textContent = data.error || 'Login failed';
      alert.classList.add('show');
      btn.disabled = false;
      btn.textContent = 'Sign In';
      return;
    }
    localStorage.setItem('crm_token', data.token);
    localStorage.setItem('crm_user',  JSON.stringify(data.user));
    const params = new URLSearchParams(window.location.search);
    window.location.replace(params.get('redirect') || '/');
  } catch (err) {
    document.getElementById('alert-msg').textContent = 'Network error – please try again';
    alert.classList.add('show');
    btn.disabled = false;
    btn.textContent = 'Sign In';
  }
});
