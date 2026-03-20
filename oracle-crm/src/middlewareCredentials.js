'use strict';

/**
 * middlewareCredentials.js
 *
 * Reads Oracle Fusion credentials from the Java middleware configuration files
 * bundled in the repository.  Used both at server startup (to auto-seed the DB)
 * and from the /api/config/middleware-credentials and
 * /api/config/import-middleware-credentials endpoints.
 *
 * Sources (in priority order):
 *   1. Fusion_Environment.json         – Postman environment (base URL + username)
 *   2. Integration_Environment.json    – Postman environment (base URL + username + password)
 *   3. FusionRESTClient/.../RestUtils.java            – hardcoded Basic-Auth pair
 *   4. FusionRESTClient/.../FusionAvailableQtyService.java – FusionAppParams hostname
 */

const fs   = require('fs');
const path = require('path');

// Repo root is two levels above oracle-crm/src/
const REPO_ROOT = path.resolve(__dirname, '..', '..');

// Regex to detect obvious placeholder passwords that should not be imported
const PLACEHOLDER_RE = /^(your|example|placeholder|test|change.?me)/i;

/**
 * Discover Oracle Fusion credentials from the Java middleware files.
 *
 * @returns {{ oracle: object, sources: string[], found: boolean }}
 *   oracle – plain object with baseUrl, username, password (whichever were found)
 *   sources – list of file names that contributed data
 *   found – true when at least one field was extracted
 */
function readMiddlewareCredentials() {
  const oracle  = {};
  const sources = [];

  // ── 1. Fusion_Environment.json ─────────────────────────────────────────────
  try {
    const envFile = path.join(REPO_ROOT, 'Fusion_Environment.json');
    const env     = JSON.parse(fs.readFileSync(envFile, 'utf8'));
    const vals    = {};
    (env.values || []).forEach(v => { vals[v.key] = v.value; });
    if (vals.fusion_base_url) oracle.baseUrl  = vals.fusion_base_url;
    if (vals.fusion_username) oracle.username = vals.fusion_username;
    if (vals.fusion_password) oracle.password = vals.fusion_password;
    sources.push('Fusion_Environment.json');
  } catch (_) { /* file absent or malformed – skip */ }

  // ── 2. Integration_Environment.json ──────────────────────────────────────
  try {
    const envFile = path.join(REPO_ROOT, 'Integration_Environment.json');
    const env     = JSON.parse(fs.readFileSync(envFile, 'utf8'));
    const vals    = {};
    (env.values || []).forEach(v => { vals[v.key] = v.value; });
    if (!oracle.baseUrl  && vals.fusion_base_url) oracle.baseUrl  = vals.fusion_base_url;
    if (!oracle.username && vals.fusion_username) oracle.username = vals.fusion_username;
    // Ignore template placeholder values (e.g. "YourFusionPassword", "example123")
    if (!oracle.password && vals.fusion_password && !PLACEHOLDER_RE.test(vals.fusion_password)) {
      oracle.password = vals.fusion_password;
    }
    sources.push('Integration_Environment.json');
  } catch (_) { /* file absent or malformed – skip */ }

  // ── 3. RestUtils.java – hardcoded Basic-Auth username:password ────────────
  try {
    const javaFile = path.join(
      REPO_ROOT,
      'FusionRESTClient', 'src', 'com', 'oracle', 'xmlns', 'utils', 'RestUtils.java'
    );
    const src = fs.readFileSync(javaFile, 'utf8');
    // Matches the Java Basic-Auth string construction pattern:
    //   String authString = "USERNAME" + ":" + "PASSWORD";
    const m = src.match(/"([^"]+)"\s*\+\s*":"\s*\+\s*"([^"]+)"/);
    if (m) {
      if (!oracle.username) oracle.username = m[1];
      if (!oracle.password) oracle.password = m[2];
      sources.push('RestUtils.java');
    }
  } catch (_) { /* file absent – skip */ }

  // ── 4. FusionAvailableQtyService.java – FusionAppParams(hostname, region) ─
  try {
    const javaFile = path.join(
      REPO_ROOT,
      'FusionRESTClient', 'src', 'innovate', 'tamergroup', 'fusion', 'rest',
      'services', 'FusionAvailableQtyService.java'
    );
    const src = fs.readFileSync(javaFile, 'utf8');
    // Matches:  new FusionAppParams("ehxk-test", "em2")
    const m = src.match(/new FusionAppParams\(\s*"([^"]+)"\s*,\s*"([^"]+)"\s*\)/);
    if (m && !oracle.baseUrl) {
      oracle.baseUrl = `https://${m[1]}.fa.${m[2]}.oraclecloud.com`;
      sources.push('FusionAvailableQtyService.java');
    }
  } catch (_) { /* file absent – skip */ }

  const found = !!(oracle.baseUrl || oracle.username || oracle.password);
  return { oracle, sources, found };
}

module.exports = { readMiddlewareCredentials };
