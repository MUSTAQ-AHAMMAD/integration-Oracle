# Oracle CRM – Windows Local Installation Guide

This guide walks you through installing and running the **Oracle CRM** (VendHQ → Oracle Fusion Sync Tool) on a local Windows computer from scratch.

---

## Table of Contents

1. [Prerequisites](#1-prerequisites)
2. [Install Node.js on Windows](#2-install-nodejs-on-windows)
3. [Install Git on Windows (optional)](#3-install-git-on-windows-optional)
4. [Get the Repository](#4-get-the-repository)
5. [Install Project Dependencies](#5-install-project-dependencies)
6. [Configure Environment Variables](#6-configure-environment-variables)
7. [Start the CRM Server](#7-start-the-crm-server)
8. [Open the CRM in Your Browser](#8-open-the-crm-in-your-browser)
9. [Verify the Setup](#9-verify-the-setup)
10. [Stopping and Restarting the Server](#10-stopping-and-restarting-the-server)
11. [Troubleshooting](#11-troubleshooting)

---

## 1. Prerequisites

Before you begin, make sure your Windows PC meets the following requirements:

| Requirement | Minimum Version | Notes |
|-------------|----------------|-------|
| Windows | 10 (64-bit) or 11 | Windows Server 2019+ also works |
| Node.js | 18.x or later | **Required** – the CRM will not start on older versions |
| npm | 9.x or later | Installed automatically with Node.js |
| Free disk space | ~200 MB | For Node.js, dependencies, and the SQLite database |
| Internet access | Required for setup | Needed during `npm install` to download packages |

You do **not** need Java, Oracle JDeveloper, or WebLogic to run the CRM — it is a standalone Node.js application.

---

## 2. Install Node.js on Windows

### Step 1 – Download the Node.js installer

1. Open your browser and navigate to **https://nodejs.org/en/download**
2. Under **"LTS"** (Long Term Support), click **"Windows Installer (.msi)"** for the 64-bit version

   > **Tip:** The LTS version is recommended for stability. As of writing, Node.js 20.x LTS or 22.x LTS both satisfy the `>=18.0.0` requirement.

### Step 2 – Run the installer

1. Double-click the downloaded `.msi` file (e.g., `node-v20.x.x-x64.msi`)
2. Click **Next** to accept the license agreement
3. Keep the default install path (`C:\Program Files\nodejs\`) and click **Next**
4. On the **Custom Setup** screen, keep all defaults selected
5. On the **Tools for Native Modules** screen, leave the checkbox **unchecked** unless you know you need it
6. Click **Install** and allow the UAC prompt
7. Click **Finish** once the installer completes

### Step 3 – Verify the installation

Open **Command Prompt** or **PowerShell** and run:

```cmd
node --version
npm --version
```

You should see output similar to:

```
v20.11.0
10.2.4
```

If you see `'node' is not recognized`, try opening a **new** terminal window — the PATH variable is only refreshed in new sessions.

---

## 3. Install Git on Windows (optional)

Git is only required if you want to clone the repository from GitHub. If you are downloading a ZIP file, skip this section.

1. Navigate to **https://git-scm.com/download/win**
2. Download and run the **64-bit Git for Windows Setup** installer
3. Accept all default options during the installation wizard
4. When prompted to choose a default editor, you can select **Notepad** or **Visual Studio Code** if you have it installed
5. Click **Install**, then **Finish**

Verify by opening a new **Git Bash** or **Command Prompt** window:

```cmd
git --version
```

Expected output: `git version 2.x.x.windows.x`

---

## 4. Get the Repository

### Option A – Clone with Git (recommended)

Open **Command Prompt**, **PowerShell**, or **Git Bash** and run:

```cmd
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git
cd integration-Oracle
```

### Option B – Download as a ZIP file

1. Go to **https://github.com/MUSTAQ-AHAMMAD/integration-Oracle**
2. Click the green **Code** button → **Download ZIP**
3. Extract the ZIP to a folder, for example `C:\Projects\integration-Oracle`
4. Open **Command Prompt** and navigate to the extracted folder:

```cmd
cd C:\Projects\integration-Oracle
```

---

## 5. Install Project Dependencies

The CRM application lives inside the `oracle-crm` sub-folder. Navigate there and install the Node.js packages:

```cmd
cd oracle-crm
npm install
```

> **What this does:** npm reads `package.json` and downloads all required packages (`express`, `axios`, `better-sqlite3`, `dotenv`, `winston`, etc.) into a local `node_modules` folder. This requires an internet connection and may take 1–2 minutes.

Expected output (last few lines):

```
added 120 packages, and audited 121 packages in 45s
found 0 vulnerabilities
```

---

## 6. Configure Environment Variables

The CRM reads its credentials and settings from a `.env` file. You must create this file before starting the server.

### Step 1 – Copy the example file

In Command Prompt, while inside the `oracle-crm` folder:

```cmd
copy .env.example .env
```

> **PowerShell alternative:**
> ```powershell
> Copy-Item .env.example .env
> ```

### Step 2 – Open the `.env` file in a text editor

```cmd
notepad .env
```

Or right-click `.env` in Windows Explorer and choose **Open with → Notepad** (or Visual Studio Code).

### Step 3 – Fill in your credentials

Edit the `.env` file with your actual values. The file looks like this:

```dotenv
# ── Oracle Fusion Cloud ──────────────────────────────────────────────────────
FUSION_BASE_URL=https://{your-instance}.fa.{region}.oraclecloud.com
FUSION_USERNAME={your-oracle-fusion-username}
FUSION_PASSWORD={your-oracle-fusion-password}

# ── Odoo ERP Connection (optional) ──────────────────────────────────────────
ODOO_URL=https://{your-odoo-instance}.odoo.com
ODOO_DB={your-odoo-db-name}
ODOO_USERNAME={your-odoo-username}
ODOO_PASSWORD={your-odoo-password-or-api-key}

# ── CRM Server ───────────────────────────────────────────────────────────────
PORT=3000
LOG_LEVEL=info

# ── Region defaults ──────────────────────────────────────────────────────────
REGIONS=AE,KW,OM,SA,BH,QA
```

**Replace every `{...}` placeholder with your real values.** For example:

```dotenv
FUSION_BASE_URL=https://mycompany-test.fa.em2.oraclecloud.com
FUSION_USERNAME=john.doe@mycompany.com
FUSION_PASSWORD=MySecretPassword123
```

> **Security note:** Never share the `.env` file or commit it to version control. It is already listed in `.gitignore`.

### Environment variable reference

| Variable | Required | Description |
|----------|----------|-------------|
| `FUSION_BASE_URL` | ✓ | Full Oracle Fusion Cloud base URL (no trailing slash) |
| `FUSION_USERNAME` | ✓ | Oracle Fusion login username |
| `FUSION_PASSWORD` | ✓ | Oracle Fusion login password |
| `ODOO_URL` | ✗ | Odoo server URL (only if using Odoo Sales push) |
| `ODOO_DB` | ✗ | Odoo database name |
| `ODOO_USERNAME` | ✗ | Odoo login username |
| `ODOO_PASSWORD` | ✗ | Odoo login password or API key |
| `ODOO_PUSH_CONCURRENCY` | ✗ | Max parallel Oracle API calls during Odoo push (default: 10) |
| `ODOO_FETCH_PAGE_SIZE` | ✗ | Records fetched per page from Odoo (default: 500) |
| `PUSH_BATCH_SIZE` | ✗ | SQLite batch size during a push job (default: 500) |
| `PORT` | ✗ | Web server port (default: 3000) |
| `LOG_LEVEL` | ✗ | Logging verbosity: `error`, `warn`, `info`, `debug` (default: `info`) |
| `REGIONS` | ✗ | Comma-separated region codes (default: `AE,KW,OM,SA,BH,QA`) |

---

## 7. Start the CRM Server

Make sure you are inside the `oracle-crm` folder, then run:

```cmd
npm start
```

You should see output similar to:

```
info: Oracle CRM running on http://localhost:3000
info: Oracle Fusion URL: https://mycompany-test.fa.em2.oraclecloud.com
info: Odoo URL: (not configured – set ODOO_URL in .env)
```

> **Keep this window open.** The server runs in the foreground. Closing the window stops the CRM.

---

## 8. Open the CRM in Your Browser

Open any modern browser (Chrome, Edge, Firefox) and navigate to:

```
http://localhost:3000
```

The CRM dashboard will load. Use the navigation to access:

| Page | URL | Purpose |
|------|-----|---------|
| Dashboard | `http://localhost:3000/` | Overview and connection status |
| New Sale Push | `http://localhost:3000/new-sale.html` | Push a VendHQ sale to Oracle Fusion |
| Sync History | `http://localhost:3000/sync-history.html` | View past push history |
| Configuration | `http://localhost:3000/config.html` | Credential setup reference |
| Calculations Reference | `http://localhost:3000/calculations.html` | All 16 business-logic calculations |
| Odoo Sales | `http://localhost:3000/odoo-sales.html` | Push Odoo sales to Oracle Fusion |

---

## 9. Verify the Setup

On the dashboard (`http://localhost:3000`), you should see the Oracle Fusion connection status. If your credentials in `.env` are correct, the status will show **Connected**. If not, you will see a connection error — double-check your `FUSION_BASE_URL`, `FUSION_USERNAME`, and `FUSION_PASSWORD`.

You can also test the API directly from Command Prompt (while the server is running):

```cmd
curl http://localhost:3000/api/config/status
```

A successful response looks like:

```json
{"fusionUrl":"https://mycompany-test.fa.em2.oraclecloud.com","status":"configured"}
```

> **Note:** `curl` is available by default in Windows 10 (version 1803+) and Windows 11.

---

## 10. Stopping and Restarting the Server

### Stop the server

In the Command Prompt window where the server is running, press:

```
Ctrl + C
```

Then confirm with `Y` if prompted.

### Restart the server

Navigate back to the `oracle-crm` folder and run `npm start` again:

```cmd
cd C:\Projects\integration-Oracle\oracle-crm
npm start
```

### Run the server in the background (optional)

If you want the server to keep running after you close the terminal, you can use the Windows Task Scheduler or a process manager. A simple approach using `start`:

```cmd
start /B npm start > crm.log 2>&1
```

Or install the cross-platform process manager `pm2`:

```cmd
npm install -g pm2
pm2 start server.js --name oracle-crm
pm2 save
pm2 startup
```

---

## 11. Troubleshooting

### `'node' is not recognized as an internal or external command`

**Cause:** Node.js is not installed or its install path is not on the Windows `PATH`.

**Fix:**
1. Confirm Node.js is installed by checking `C:\Program Files\nodejs\node.exe`
2. Open **System Properties → Advanced → Environment Variables**
3. Under **System variables**, select `Path` and click **Edit**
4. Confirm `C:\Program Files\nodejs\` is in the list; add it if missing
5. Click **OK** and open a **new** Command Prompt window

---

### `npm install` fails with `EACCES` or `permission denied`

**Cause:** Insufficient permissions on the target folder.

**Fix:** Right-click **Command Prompt** or **PowerShell** and choose **Run as Administrator**, then retry `npm install`.

---

### `npm install` fails with `node-gyp` / `build error` for `better-sqlite3`

**Cause:** `better-sqlite3` is a native add-on that requires build tools.

**Fix:**
1. Install **Visual Studio Build Tools** (the recommended approach):
   - Download from https://visualstudio.microsoft.com/visual-cpp-build-tools/
   - Run the installer and select **"Desktop development with C++"**
   - Click **Install** and wait for the installation to complete
2. Then retry `npm install` in the `oracle-crm` folder.

---

### Port 3000 is already in use

**Cause:** Another application (or a previous CRM instance) is listening on port 3000.

**Fix – Option 1:** Change the port in your `.env` file:

```dotenv
PORT=3001
```

Then restart with `npm start` and open `http://localhost:3001` instead.

**Fix – Option 2:** Find and stop the process using port 3000:

```cmd
netstat -ano | findstr :3000
```

This prints a line like `TCP  0.0.0.0:3000  ...  LISTENING  12345` — note the PID (e.g., `12345`), then:

```cmd
taskkill /PID 12345 /F
```

---

### The browser shows `This site can't be reached`

**Cause:** The CRM server is not running, or it crashed on startup.

**Fix:**
1. Check the Command Prompt window where you ran `npm start` for error messages
2. Common errors and their fixes are listed in the sections above
3. If the error mentions a missing `.env` variable, add it to `.env` and restart

---

### `Error: Cannot find module '...'`

**Cause:** `npm install` was not run, or the `node_modules` folder is missing.

**Fix:** Run `npm install` inside the `oracle-crm` folder:

```cmd
cd C:\Projects\integration-Oracle\oracle-crm
npm install
```

---

### Oracle Fusion connection test fails (wrong credentials)

**Cause:** The `FUSION_BASE_URL`, `FUSION_USERNAME`, or `FUSION_PASSWORD` in `.env` is incorrect.

**Fix:**
1. Open `.env` in Notepad
2. Verify the URL matches exactly what you see in the Oracle Fusion browser address bar (no trailing slash)
3. Test your credentials by logging in to Oracle Fusion directly in your browser
4. Save `.env` and restart the server

---

### Windows Firewall blocks the server

**Cause:** Windows Firewall may block Node.js from accepting connections on the configured port.

**Fix:**
1. When Windows shows a **Windows Security Alert** asking to allow Node.js, click **Allow access**
2. If the prompt doesn't appear, manually add a firewall rule:
   - Open **Windows Defender Firewall → Advanced Settings → Inbound Rules → New Rule**
   - Select **Port → TCP → Specific local ports: 3000 → Allow the connection**
   - Apply to all profiles and name it `Oracle CRM`

---

## Quick Reference: Full Setup Command Sequence

Copy and run these commands in Command Prompt after installing Node.js:

```cmd
REM 1. Clone the repository (skip if you downloaded the ZIP)
git clone https://github.com/MUSTAQ-AHAMMAD/integration-Oracle.git

REM 2. Navigate to the CRM folder
cd integration-Oracle\oracle-crm

REM 3. Install dependencies
npm install

REM 4. Create the .env configuration file
copy .env.example .env

REM 5. Open .env in Notepad and fill in your Oracle Fusion credentials
notepad .env

REM 6. Start the server
npm start
```

Then open **http://localhost:3000** in your browser.

---

*For further details about the CRM features and API reference, see [`oracle-crm/README.md`](./oracle-crm/README.md).*
