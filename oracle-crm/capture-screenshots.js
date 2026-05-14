const playwright = require('playwright');
const fs = require('fs');
const path = require('path');

const baseUrl = 'http://localhost:3000';
const screenshotsDir = '/home/runner/work/integration-Oracle/integration-Oracle/oracle-crm/screenshots';

// Ensure screenshots directory exists
if (!fs.existsSync(screenshotsDir)) {
  fs.mkdirSync(screenshotsDir, { recursive: true });
}

async function captureScreenshots() {
  const browser = await playwright.chromium.launch({ headless: true });
  const context = await browser.newContext({
    viewport: { width: 1920, height: 1080 },
    deviceScaleFactor: 1
  });
  const page = await context.newPage();

  try {
    console.log('Starting screenshot capture...');

    // 1. Login Page (Before login)
    console.log('Capturing: Login page');
    await page.goto(`${baseUrl}/login.html`);
    await page.waitForLoadState('networkidle');
    await page.screenshot({ path: path.join(screenshotsDir, '01-login-page.png'), fullPage: true });

    // Login as superadmin
    await page.fill('input[name="username"]', 'superadmin');
    await page.fill('input[name="password"]', 'SuperAdmin@1234');
    await page.screenshot({ path: path.join(screenshotsDir, '02-login-filled.png'), fullPage: true });
    
    await page.click('button[type="submit"]');
    await page.waitForTimeout(2000);

    // 2. Dashboard / Home Page
    console.log('Capturing: Dashboard');
    await page.goto(`${baseUrl}/`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '03-dashboard.png'), fullPage: true });

    // 3. Odoo Sales Page
    console.log('Capturing: Odoo Sales page');
    await page.goto(`${baseUrl}/odoo-sales.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '04-odoo-sales.png'), fullPage: true });

    // 4. New Sale Page
    console.log('Capturing: New Sale page');
    await page.goto(`${baseUrl}/new-sale.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '05-new-sale.png'), fullPage: true });

    // 5. Orders Page
    console.log('Capturing: Orders page');
    await page.goto(`${baseUrl}/orders.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '06-orders.png'), fullPage: true });

    // 6. Sync History Page
    console.log('Capturing: Sync History page');
    await page.goto(`${baseUrl}/sync-history.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '07-sync-history.png'), fullPage: true });

    // 7. Reports Page
    console.log('Capturing: Reports page');
    await page.goto(`${baseUrl}/reports.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '08-reports.png'), fullPage: true });

    // 8. Configuration Page
    console.log('Capturing: Configuration page');
    await page.goto(`${baseUrl}/config.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '09-config.png'), fullPage: true });

    // 9. Users Management Page
    console.log('Capturing: Users Management page');
    await page.goto(`${baseUrl}/users.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '10-users.png'), fullPage: true });

    // 10. Profile Page
    console.log('Capturing: Profile page');
    await page.goto(`${baseUrl}/profile.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '11-profile.png'), fullPage: true });

    // 11. Calculations Page
    console.log('Capturing: Calculations page');
    await page.goto(`${baseUrl}/calculations.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '12-calculations.png'), fullPage: true });

    // 12. Benchmark Page
    console.log('Capturing: Benchmark page');
    await page.goto(`${baseUrl}/benchmark.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '13-benchmark.png'), fullPage: true });

    // 13. API Test Page
    console.log('Capturing: API Test page');
    await page.goto(`${baseUrl}/api-test.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '14-api-test.png'), fullPage: true });

    // 14. Odoo Endpoints Page
    console.log('Capturing: Odoo Endpoints page');
    await page.goto(`${baseUrl}/odoo-endpoints.html`);
    await page.waitForLoadState('networkidle');
    await page.waitForTimeout(2000);
    await page.screenshot({ path: path.join(screenshotsDir, '15-odoo-endpoints.png'), fullPage: true });

    console.log('All screenshots captured successfully!');
  } catch (error) {
    console.error('Error capturing screenshots:', error);
  } finally {
    await browser.close();
  }
}

captureScreenshots();
