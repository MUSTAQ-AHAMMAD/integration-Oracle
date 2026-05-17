# Oracle CRM – Odoo/VendHQ to Oracle Fusion Integration Platform

A comprehensive Node.js web application with role-based access control that manages Oracle Fusion Cloud integration, supporting both Odoo and VendHQ data sources with real-time monitoring, reporting, and user management.

## 🚀 Quick Start

```bash
cd oracle-crm

# 1. Install dependencies
npm install

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Oracle Fusion URL, username, password

# 3. Start the server
npm start
# Open http://localhost:3000
```

## 🔐 Default Login Credentials

When the server starts for the first time, it automatically creates two default accounts:

### Super Administrator
| Field    | Value               |
|----------|---------------------|
| Username | `superadmin`        |
| Password | `SuperAdmin@1234`   |
| Role     | `super_admin`       |

### Administrator
| Field    | Value        |
|----------|--------------|
| Username | `admin`      |
| Password | `Admin@1234` |
| Role     | `admin`      |

> ⚠️ **SECURITY WARNING:** Change these passwords immediately after your first login via the Profile page or via **Admin → Users**. Default passwords are well-known and must not remain in production environments.

### Reset Credentials Utility

To generate new secure random passwords for admin accounts:

```bash
# For local development:
node reset-credentials.js

# For Docker deployment (see Docker section below):
docker exec -it oracle-crm node reset-credentials.js
```

The utility creates new secure 16-character passwords and saves them to `/tmp/oracle-crm-credentials.txt` for easy reference.

> **Windows users:** See the step-by-step [Windows Installation Guide](../WINDOWS_INSTALL.md) for full instructions.

---

## 👥 User Roles & Permissions

The system implements a hierarchical role-based access control (RBAC):

| Role | Level | Capabilities |
|------|-------|--------------|
| **Super Admin** | 5 | Full system access, manage all users including super admins, system configuration |
| **Admin** | 4 | User management (except super admins), configuration, reports |
| **Management** | 3 | View all reports, analytics, job history, export data |
| **User/Operator** | 2 | Push/fetch data, view own jobs, basic dashboard |
| **Viewer** | 1 | Read-only access to dashboard and sales data |

📖 **Detailed Documentation:** See [USER_MANAGEMENT_AND_REPORTING.md](./USER_MANAGEMENT_AND_REPORTING.md) for complete role descriptions, API endpoints, and security guidelines.

---

## 📊 Key Features

### 1. **Role-Based User Management**
- Hierarchical permission system
- Privilege escalation protection
- Multi-level access control
- User activity audit trails

### 2. **Comprehensive Reporting**
- **Dashboard Statistics:** Real-time overview of sales, migrations, and system health
- **Migration Reports:** Detailed tracking of Odoo/VendHQ to Oracle Fusion data transfers
- **Job History:** Complete audit trail of all sync operations
- **Analytics:** Time-series data with customizable grouping (day/week/month)
- **Store Performance:** Revenue, order volume, and success rates per store
- **CSV Export:** Download reports for external analysis

### 3. **Data Integration**
- Odoo POS sales synchronization
- VendHQ sales data integration
- Oracle Fusion ERP push operations
- Automated retry for failed records
- Multi-country and multi-store support

### 4. **Advanced Features**
- Multi-currency support (AED, SAR, KWD, OMR, BHD, QAR)
- Country-specific configurations
- Store-level Oracle metadata mapping
- Real-time job monitoring
- Failed record tracking and retry mechanisms

---

## 📱 Web Pages

| Page | URL | Purpose | Min. Role |
|------|-----|---------|-----------|
| Dashboard | `/` | Overview, connection status, API reference | Viewer |
| Odoo Sales | `/odoo-sales.html` | Fetch and push Odoo sales data | User |
| New Sale Push | `/new-sale.html` | Manual sale entry and push | User |
| Orders | `/orders.html` | View and manage orders | User |
| Sync History | `/sync-history.html` | Job history and troubleshooting | User |
| Reports | `/reports.html` | Comprehensive migration reports | Management |
| Configuration | `/config.html` | System and credential setup | Admin |
| Users Management | `/users.html` | User administration | Admin |
| Profile | `/profile.html` | Personal settings | All |
| Calculations Ref | `/calculations.html` | Interactive calculation demos | All |
| Benchmark | `/benchmark.html` | Performance testing | Admin |

---

## 🔌 API Endpoints

### Reports API

| Endpoint | Method | Auth | Description |
|----------|--------|------|-------------|
| `/api/reports/dashboard` | GET | All | Dashboard statistics |
| `/api/reports/migration/overview` | GET | Management+ | Migration overview with filters |
| `/api/reports/migration/jobs` | GET | Management+ | Detailed job history |
| `/api/reports/migration/failures` | GET | Management+ | Failed records report |
| `/api/reports/analytics/timeline` | GET | All | Time-series analytics |
| `/api/reports/audit/users` | GET | Management+ | User activity audit |
| `/api/reports/performance/stores` | GET | Management+ | Store performance metrics |
| `/api/reports/export/csv` | GET | Management+ | CSV export |

### User Management API

| Endpoint | Method | Auth | Description |
|----------|--------|------|-------------|
| `/api/users` | GET | Admin+ | List all users |
| `/api/users` | POST | Admin+ | Create new user |
| `/api/users/:id` | PUT | Admin+ | Update user |
| `/api/users/:id` | DELETE | Admin+ | Delete user |

### Authentication API

| Endpoint | Method | Auth | Description |
|----------|--------|------|-------------|
| `/api/auth/login` | POST | Public | User login |
| `/api/auth/me` | GET | All | Current user info |
| `/api/auth/profile` | PUT | All | Update profile |
| `/api/auth/change-password` | POST | All | Change password |

📖 **Complete API Documentation:** See [USER_MANAGEMENT_AND_REPORTING.md](./USER_MANAGEMENT_AND_REPORTING.md)

---

## What It Does

The CRM implements the same 8-step Oracle Fusion API sequence as the Java scheduler:

1. `GET /customers` – resolve CustomerId / OrgId  
2. `GET /units` – resolve Oracle UOM codes (cached)  
3. `POST /receivablesInvoices` – create AR invoice  
4. `POST /receivablesReceipts` – create standard receipt per payment method  
5. `POST applyReceiptOnAccount` – link receipt to invoice  
6. `POST /receivablesReceipts` (misc) – create bank charge receipt  
7. `POST /inventoryTransactions` – create stock movement records  
8. `POST /journals` – create GL journal (non-NORMAL customers only)  

## All 16 Calculations (ported from Java)

| # | Calculation | Formula |
|---|-------------|---------|
| 1 | Timezone hours | `Math.trunc(tzOffset)` |
| 2 | Timezone minutes | `((abs * 100) % 100) * 60 / 100` |
| 3 | Adjusted GL Date | `utcDate + hours + minutes` |
| 4 | Days since last sale | `(now - lastDate) / 86,400,000` |
| 5 | Day window cap | `daysToAdd <= 7 ? daysToAdd - 1 : 7` |
| 6 | Invoice grouping key | `{day}-{month}-{year}{customerType}[**Credit]` |
| 7 | Unit Selling Price | `ABS(totalPrice / quantity)` |
| 8 | Discount Item qty | Force to 1 if itemName="Discount Item" AND price > 0 |
| 9 | Conversion Rate Type | `rateIsCorporate=1 → "Corporate" else "User"` |
| 10 | Inventory qty | `quantity × -1` |
| 11 | Transaction Type | `price=0 → Issue/RMA by qty sign; price>0 → Issue; price<0 → RMA` |
| 12 | Cash account | `region=KW → "Cash KW" else "Cash"` |
| 13 | Bank charges | `amount × bankRate × (tax + 1)` (capped at 10 for OM Debit Card) |
| 14 | Journal charge | Fixed freight OR `saleTotal × bankChargeRate` |
| 15 | Period name | `format(date, "MMM-yy")` e.g. "Jan-24" |
| 16 | Message truncation | `message.substring(0, 500)` |

## Environment Variables

| Variable | Required | Description |
|----------|----------|-------------|
| `FUSION_BASE_URL` | ✓ | Oracle Fusion Cloud base URL |
| `FUSION_USERNAME` | ✓ | Oracle Fusion username |
| `FUSION_PASSWORD` | ✓ | Oracle Fusion password |
| `PORT` | – | Server port (default: 3000) |
| `REGIONS` | – | Comma-separated region codes (default: AE,KW,OM,SA,BH,QA) |

**Never commit `.env` to version control.**

## 🐳 Docker Deployment

### Building and Running with Docker Compose

```bash
# Build and start the container
docker-compose up -d --build

# View logs
docker-compose logs -f

# Stop the container
docker-compose down
```

### Important: Rebuilding After Code Updates

When you pull new code changes (e.g., after `git pull`), Docker doesn't automatically rebuild the image. You must rebuild to include the new files:

```bash
# Rebuild and restart
docker-compose up -d --build
```

**Without `--build`, Docker uses the cached image and new files won't be available inside the container.**

### Running the Credential Reset Utility

After building the Docker image with the latest code:

```bash
# Method 1: Run directly
docker exec -it oracle-crm node reset-credentials.js

# Method 2: Interactive shell first
docker exec -it oracle-crm sh
node reset-credentials.js
exit
```

The `reset-credentials.js` script generates secure random passwords for the superadmin and admin accounts. Use this when you need to reset credentials or create fresh login details.

### Common Docker Commands

```bash
# View running containers
docker ps

# Restart the container
docker-compose restart

# Rebuild without cache (force fresh build)
docker-compose build --no-cache
docker-compose up -d

# View container logs
docker logs oracle-crm

# Access container shell
docker exec -it oracle-crm sh

# Remove container and image (clean slate)
docker-compose down
docker rmi oracle-crm_oracle-crm
```

## Security

- Oracle credentials are stored only in the `.env` file (never in source code)
- HTTP Basic Auth is sent only to Oracle Fusion APIs over HTTPS
- The `.gitignore` excludes `.env` and `node_modules/`
- No credentials are logged or exposed in API responses
