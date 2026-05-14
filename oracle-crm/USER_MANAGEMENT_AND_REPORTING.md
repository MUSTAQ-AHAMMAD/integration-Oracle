# User Management and Reporting System

## Overview

The Oracle CRM now includes a comprehensive user management system with role-based access control (RBAC) and detailed migration reporting capabilities. This document describes the role hierarchy, permissions, and available reports.

---

## Role Hierarchy

The system implements a hierarchical role-based access control system with the following roles (in descending order of privilege):

### 1. Super Admin (`super_admin`)
**Privilege Level: 5** - Highest authority

**Capabilities:**
- All admin capabilities, plus:
- Create, modify, and delete super_admin users
- Manage system-critical configurations
- Access all reports and audit logs
- Cannot be demoted or deleted if they are the last super_admin

**Use Case:** System owners, IT administrators

### 2. Admin (`admin`)
**Privilege Level: 4**

**Capabilities:**
- Create, modify, and delete users (except super_admins)
- Manage country configurations
- Configure store metadata
- Access management-level reports
- Manage Oracle and Odoo credentials
- Cannot modify or delete super_admins
- Cannot promote users to super_admin

**Use Case:** Senior managers, department heads

### 3. Management (`management`)
**Privilege Level: 3**

**Capabilities:**
- View comprehensive migration reports
- Access job history and analytics
- View failed records and retry information
- Export data as CSV
- View store and country performance metrics
- Cannot modify users or system configuration

**Use Case:** Middle management, operation managers

### 4. User (`user` or `operator`)
**Privilege Level: 2**

**Capabilities:**
- Push sales data to Oracle Fusion
- Fetch data from Odoo
- View basic dashboard statistics
- View their own jobs and sales data
- Update their own profile

**Use Case:** Data operators, daily users

### 5. Viewer (`viewer`)
**Privilege Level: 1** - Lowest privilege

**Capabilities:**
- View-only access to dashboard
- View sales data (read-only)
- View basic statistics
- Update their own profile

**Use Case:** Observers, stakeholders, reporting staff

---

## Authentication & Authorization

### Middleware Functions

```javascript
requireAuth         // Any authenticated user
requireUser         // User level or higher (excludes viewers)
requireManagement   // Management level or higher
requireAdmin        // Admin or super_admin
requireSuperAdmin   // Super_admin only
```

### JWT Token Structure

```json
{
  "id": 123,
  "username": "john_doe",
  "role": "management"
}
```

Tokens are valid for **12 hours** by default.

### Security Features

1. **Privilege Escalation Protection**
   - Users cannot create/promote users to roles higher than their own
   - Only super_admins can create other super_admins
   - Admins cannot modify super_admin accounts

2. **Last Admin/Super Admin Protection**
   - Cannot delete or demote the last admin
   - Cannot delete or demote the last super_admin
   - Users cannot delete their own accounts

3. **Password Requirements**
   - Minimum 8 characters
   - Hashed using bcrypt (10 rounds)

---

## Reports API

### 1. Dashboard Statistics
**Endpoint:** `GET /api/reports/dashboard`
**Auth:** Any authenticated user
**Description:** Comprehensive dashboard with overall statistics

**Response:**
```json
{
  "totalSales": 15234,
  "totalPushed": 14890,
  "totalPending": 344,
  "totalRevenue": 1234567.89,
  "pushedRevenue": 1200000.00,
  "pendingRevenue": 34567.89,
  "totalJobs": 256,
  "completedJobs": 248,
  "failedJobs": 3,
  "runningJobs": 5,
  "totalFailedRecords": 125,
  "pendingRetries": 45,
  "salesByCountry": [...],
  "salesByStore": [...],
  "lastPushInfo": {...},
  "lastFetchInfo": {...},
  "systemInfo": {...}
}
```

### 2. Migration Overview
**Endpoint:** `GET /api/reports/migration/overview`
**Auth:** Management or higher
**Query Params:** `dateFrom`, `dateTo`, `country`, `storeId`

**Description:** Detailed migration statistics with date ranges, grouped by date, country, and store

**Response:**
```json
{
  "summary": {
    "total_records": 15000,
    "migrated_records": 14500,
    "pending_records": 500,
    "earliest_date": "2024-01-01",
    "latest_date": "2024-12-31",
    "total_amount": 5000000.00,
    "migrated_amount": 4850000.00,
    "pending_amount": 150000.00
  },
  "byDate": [...],
  "byCountry": [...],
  "byStore": [...]
}
```

### 3. Migration Jobs
**Endpoint:** `GET /api/reports/migration/jobs`
**Auth:** Management or higher
**Query Params:** `dateFrom`, `dateTo`, `status`, `jobType`, `limit`, `offset`

**Description:** Detailed job history with pagination

**Response:**
```json
{
  "jobs": [
    {
      "job_id": "uuid",
      "job_type": "PUSH",
      "mode": "BY_DATE",
      "status": "DONE",
      "total": 1000,
      "processed": 995,
      "failed": 5,
      "started_at": "2024-05-14T10:00:00Z",
      "finished_at": "2024-05-14T10:15:00Z"
    }
  ],
  "total": 256,
  "limit": 50,
  "offset": 0
}
```

### 4. Migration Failures
**Endpoint:** `GET /api/reports/migration/failures`
**Auth:** Management or higher
**Query Params:** `status`, `limit`, `offset`

**Description:** Failed records with retry information

**Response:**
```json
{
  "rows": [...],
  "total": 125,
  "summary": {
    "total": 125,
    "pending": 45,
    "resolved": 70,
    "skipped": 10
  }
}
```

### 5. Analytics Timeline
**Endpoint:** `GET /api/reports/analytics/timeline`
**Auth:** Any authenticated user
**Query Params:** `dateFrom`, `dateTo`, `country`, `storeId`, `groupBy` (day/week/month)

**Description:** Time-series data for visualization

**Response:**
```json
[
  {
    "period": "2024-05-14",
    "total_sales": 150,
    "migrated_sales": 145,
    "pending_sales": 5,
    "total_revenue": 45000.00,
    "avg_order_value": 300.00
  }
]
```

### 6. User Audit Trail
**Endpoint:** `GET /api/reports/audit/users`
**Auth:** Management or higher

**Description:** User activity audit trail with job statistics

### 7. Store Performance
**Endpoint:** `GET /api/reports/performance/stores`
**Auth:** Management or higher
**Query Params:** `dateFrom`, `dateTo`, `limit`

**Description:** Store performance metrics including revenue, order volume, and migration status

**Response:**
```json
[
  {
    "store_id": 101,
    "store_name": "Dubai Mall",
    "country": "AE",
    "total_orders": 5234,
    "migrated_orders": 5200,
    "total_revenue": 1567890.00,
    "avg_order_value": 299.56,
    "first_order_date": "2024-01-01",
    "last_order_date": "2024-05-14",
    "last_migration_date": "2024-05-14T09:30:00Z"
  }
]
```

### 8. CSV Export
**Endpoint:** `GET /api/reports/export/csv`
**Auth:** Management or higher
**Query Params:** `type` (sales/jobs), `dateFrom`, `dateTo`, `country`, `storeId`

**Description:** Export report data as CSV file

**Response:** CSV file download

---

## Default Users

On first startup, the system creates two default users:

### Super Admin
- **Username:** `superadmin`
- **Password:** `SuperAdmin@1234`
- **Role:** `super_admin`
- **⚠️ CHANGE PASSWORD IMMEDIATELY**

### Admin
- **Username:** `admin`
- **Password:** `Admin@1234`
- **Role:** `admin`
- **⚠️ CHANGE PASSWORD IMMEDIATELY**

---

## API Endpoints Summary

### User Management
- `GET /api/users` - List all users (admin+)
- `POST /api/users` - Create user (admin+)
- `PUT /api/users/:id` - Update user (admin+)
- `DELETE /api/users/:id` - Delete user (admin+)

### Authentication
- `POST /api/auth/login` - User login
- `GET /api/auth/me` - Get current user info
- `PUT /api/auth/profile` - Update profile
- `POST /api/auth/change-password` - Change password
- `POST /api/auth/logout` - Logout

### Reports
- `GET /api/reports/dashboard` - Dashboard statistics (all)
- `GET /api/reports/migration/overview` - Migration overview (management+)
- `GET /api/reports/migration/jobs` - Job history (management+)
- `GET /api/reports/migration/failures` - Failed records (management+)
- `GET /api/reports/analytics/timeline` - Timeline analytics (all)
- `GET /api/reports/audit/users` - User audit trail (management+)
- `GET /api/reports/performance/stores` - Store performance (management+)
- `GET /api/reports/export/csv` - CSV export (management+)

---

## Database Schema Updates

### Users Table
The `users` table now supports the following roles:
- `super_admin`
- `admin`
- `management`
- `user`
- `operator` (alias for user)
- `viewer`

### Helper Functions
```javascript
// In src/db.js
db.countSuperAdmins()  // Count super_admin users
db.countAdmins()       // Count admin users

// In src/middleware/auth.js
hasMinimumRole(userRole, minimumRole)  // Check role hierarchy
ROLE_HIERARCHY  // Role level constants
```

---

## Usage Examples

### Creating a Management User (as admin)
```bash
curl -X POST http://localhost:3000/api/users \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "manager1",
    "email": "manager@company.com",
    "password": "SecurePass123",
    "role": "management",
    "display_name": "Sales Manager"
  }'
```

### Fetching Migration Overview
```bash
curl -X GET "http://localhost:3000/api/reports/migration/overview?dateFrom=2024-01-01&dateTo=2024-12-31&country=AE" \
  -H "Authorization: Bearer YOUR_TOKEN"
```

### Exporting Sales Data as CSV
```bash
curl -X GET "http://localhost:3000/api/reports/export/csv?type=sales&dateFrom=2024-05-01" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -o sales_export.csv
```

---

## Migration from Old System

If you have existing users with the old role system (`admin`, `operator`, `viewer`), they will continue to work:
- `admin` → remains `admin` (privilege level 4)
- `operator` → mapped to `user` (privilege level 2)
- `viewer` → remains `viewer` (privilege level 1)

New installations will use the expanded role system with `super_admin` and `management` roles.

---

## Best Practices

1. **Always change default passwords immediately**
2. **Use management role for report viewers who don't need admin access**
3. **Limit super_admin accounts to 2-3 trusted administrators**
4. **Regular audit of user permissions using the audit trail**
5. **Export critical reports regularly using CSV export**
6. **Monitor failed records and resolve them promptly**

---

## Security Considerations

1. **Password Security**
   - Enforce strong passwords (minimum 8 characters)
   - Consider implementing password complexity requirements
   - Rotate passwords regularly

2. **Token Management**
   - Tokens expire after 12 hours
   - Set JWT_SECRET environment variable in production
   - Use HTTPS in production to protect tokens

3. **Role Assignment**
   - Follow principle of least privilege
   - Review user roles quarterly
   - Remove inactive users promptly

4. **Audit Logging**
   - Monitor user activity through audit endpoints
   - Track failed login attempts
   - Review failed migration records

---

## Troubleshooting

### Cannot Login
- Verify username and password
- Check token expiration
- Ensure JWT_SECRET is set correctly

### Permission Denied
- Check user role assignment
- Verify endpoint permission requirements
- Check role hierarchy

### Reports Not Loading
- Ensure user has management or higher role
- Check date range parameters
- Verify database connectivity

---

## Future Enhancements

Planned features for future releases:
- Two-factor authentication (2FA)
- IP whitelisting
- Session management
- Advanced audit logging with detailed action tracking
- Email notifications for critical events
- Automated report scheduling
- Custom role creation
- Department-based access control
