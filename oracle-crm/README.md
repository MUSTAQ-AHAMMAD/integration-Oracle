# Oracle CRM – VendHQ to Oracle Fusion Sync Tool

A standalone Node.js web application that lets you manually push VendHQ sales
data to Oracle Fusion Cloud without running the Java scheduler.

## Quick Start

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

## Default Login Credentials

When the server starts for the first time with no existing users, it automatically
creates a default admin account:

| Field    | Value        |
|----------|--------------|
| Username | `admin`      |
| Password | `Admin@1234` |

> ⚠️ **Change this password immediately** after your first login via the Profile page
> or via **Admin → Users**. The default password is well-known and must not remain in
> a production environment.

> **Windows users:** See the step-by-step [Windows Installation Guide](../WINDOWS_INSTALL.md) for full instructions including Node.js setup, environment configuration, and troubleshooting.

## Pages

| Page | URL | Purpose |
|------|-----|---------|
| Dashboard | `/` | Overview, connection status, API sequence reference |
| New Sale Push | `/new-sale.html` | Enter sale data and push to Oracle Fusion |
| Sync History | `/sync-history.html` | Session push history + troubleshooting guide |
| Configuration | `/config.html` | Credential setup instructions + region reference |
| Calculations Ref | `/calculations.html` | All 16 calculations with live interactive demos |

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

## Security

- Oracle credentials are stored only in the `.env` file (never in source code)  
- HTTP Basic Auth is sent only to Oracle Fusion APIs over HTTPS  
- The `.gitignore` excludes `.env` and `node_modules/`  
- No credentials are logged or exposed in API responses  
