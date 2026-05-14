# Oracle CRM Middleware - Complete UI Screenshots

This directory contains comprehensive screenshots of all pages and functionalities of the Oracle CRM middleware application with the new authentication middleware system.

## 📸 Screenshot Index

### Authentication & Security

#### 1. Login Page (`01-login-page.png`)
- **URL:** `/login.html`
- **Description:** Initial login page with clean, modern interface
- **Features:**
  - Username and password fields
  - Login button
  - Role-based access control entry point
  - JWT-based authentication
- **Access:** Public (unauthenticated)

#### 2. Login Page - Filled (`02-login-filled.png`)
- **URL:** `/login.html`
- **Description:** Login form with credentials entered
- **Features:**
  - Shows form validation states
  - Demonstrates superadmin login
- **Default Credentials:**
  - Username: `superadmin`
  - Password: `SuperAdmin@1234` (change immediately in production)

---

### Main Dashboard

#### 3. Dashboard / Home Page (`03-dashboard.png`)
- **URL:** `/` or `/index.html`
- **Description:** Main dashboard showing system overview
- **Features:**
  - Real-time statistics
  - Sales summary
  - Connection status indicators
  - Quick navigation menu
  - API endpoints reference
  - Recent activity summary
- **Required Role:** Viewer or higher (all authenticated users)
- **Key Metrics:**
  - Total sales count
  - Pushed/pending orders
  - Revenue statistics
  - Job statuses

---

### Data Operations

#### 4. Odoo Sales Page (`04-odoo-sales.png`)
- **URL:** `/odoo-sales.html`
- **Description:** Primary interface for Odoo data operations
- **Features:**
  - Fetch Odoo sales data by date range
  - Push data to Oracle Fusion
  - Store selection and filtering
  - Date range picker
  - Metadata configuration
  - Job progress monitoring
  - Real-time status updates
- **Required Role:** User or higher
- **Operations:**
  - Fetch orders from Odoo
  - Push to Oracle Fusion
  - View fetched data
  - Monitor job progress

#### 5. New Sale Page (`05-new-sale.png`)
- **URL:** `/new-sale.html`
- **Description:** Manual sale entry and push interface
- **Features:**
  - Manual order creation form
  - Customer information entry
  - Line items management
  - Payment method selection
  - Direct push to Oracle
  - Form validation
- **Required Role:** User or higher
- **Use Cases:**
  - Manual corrections
  - Missing data entry
  - Testing individual orders

#### 6. Orders Page (`06-orders.png`)
- **URL:** `/orders.html`
- **Description:** View and manage all orders
- **Features:**
  - Orders listing table
  - Search and filter capabilities
  - Status indicators
  - Order details view
  - Pagination
  - Export functionality
- **Required Role:** User or higher
- **Data Shown:**
  - Order ID
  - Date
  - Customer
  - Amount
  - Status (pushed/pending/failed)
  - Store information

#### 7. Sync History Page (`07-sync-history.png`)
- **URL:** `/sync-history.html`
- **Description:** Complete job history and troubleshooting
- **Features:**
  - Job history table
  - Status tracking (running/done/failed)
  - Timing information
  - Success/failure metrics
  - Retry capabilities
  - Job details view
  - Filter by date, status, type
- **Required Role:** User or higher
- **Job Information:**
  - Job ID
  - Type (fetch/push)
  - Start/end times
  - Records processed
  - Success/failure counts
  - Error messages

---

### Reporting & Analytics

#### 8. Reports Page (`08-reports.png`)
- **URL:** `/reports.html`
- **Description:** Comprehensive reporting dashboard
- **Features:**
  - Migration overview statistics
  - Time-series analytics
  - Store performance metrics
  - Failed records tracking
  - User audit trail
  - CSV export functionality
  - Custom date ranges
  - Country and store filtering
- **Required Role:** Management or higher
- **Report Types:**
  - Dashboard statistics
  - Migration overview
  - Job history
  - Failure analysis
  - Timeline analytics
  - Store performance
  - User activity audit
- **Visualizations:**
  - Charts and graphs
  - Trend analysis
  - Performance metrics

---

### System Administration

#### 9. Configuration Page (`09-config.png`)
- **URL:** `/config.html`
- **Description:** System configuration and settings
- **Features:**
  - Oracle Fusion credentials management
  - Odoo connection settings
  - Country configurations
  - Store metadata mapping
  - Oracle business unit mapping
  - Customer ID configuration
  - Test connection functionality
  - Environment variables display
- **Required Role:** Admin or higher
- **Sections:**
  - Oracle Fusion settings
  - Odoo settings
  - Country management
  - Store metadata
  - System parameters

#### 10. Users Management Page (`10-users.png`)
- **URL:** `/users.html`
- **Description:** User management and access control
- **Features:**
  - User list with roles
  - Create new user
  - Edit user details
  - Delete user (with protections)
  - Role assignment
  - Password management
  - Privilege escalation protection
  - Last admin protection
- **Required Role:** Admin or higher (cannot manage super_admins unless you are one)
- **User Roles:**
  - Super Admin (level 5)
  - Admin (level 4)
  - Management (level 3)
  - User/Operator (level 2)
  - Viewer (level 1)
- **Security Features:**
  - Cannot create users with higher roles than your own
  - Cannot delete/demote last admin
  - Cannot delete/demote last super_admin
  - Cannot delete own account

#### 11. Profile Page (`11-profile.png`)
- **URL:** `/profile.html`
- **Description:** Personal profile and password management
- **Features:**
  - View current user information
  - Change password
  - Update display name
  - Update email
  - View role and permissions
  - Session information
- **Required Role:** All authenticated users
- **Security:**
  - Password strength validation
  - Current password confirmation
  - bcrypt password hashing

---

### Developer Tools & Reference

#### 12. Calculations Reference Page (`12-calculations.png`)
- **URL:** `/calculations.html`
- **Description:** Interactive demonstration of all 16 Oracle calculations
- **Features:**
  - Live calculation examples
  - Input/output demonstrations
  - Formula explanations
  - Test data entry
  - Real-time calculations
  - Comprehensive documentation
- **Required Role:** All authenticated users
- **Calculations Shown:**
  1. Timezone hours conversion
  2. Timezone minutes conversion
  3. Adjusted GL Date
  4. Days since last sale
  5. Day window cap
  6. Invoice grouping key
  7. Unit Selling Price
  8. Discount Item quantity
  9. Conversion Rate Type
  10. Inventory quantity
  11. Transaction Type
  12. Cash account selection
  13. Bank charges calculation
  14. Journal charge
  15. Period name formatting
  16. Message truncation

#### 13. Benchmark Page (`13-benchmark.png`)
- **URL:** `/benchmark.html`
- **Description:** Performance testing and benchmarking tools
- **Features:**
  - API response time testing
  - Load testing tools
  - Performance metrics
  - Database query benchmarks
  - Throughput testing
  - System health checks
- **Required Role:** Admin or higher
- **Tests:**
  - API endpoint latency
  - Database operations speed
  - Concurrent request handling
  - Memory usage
  - CPU performance

#### 14. API Test Page (`14-api-test.png`)
- **URL:** `/api-test.html`
- **Description:** Interactive API testing interface
- **Features:**
  - Test all API endpoints
  - Request/response viewer
  - Authentication testing
  - Parameter customization
  - Status code display
  - Error handling demonstration
- **Required Role:** All authenticated users
- **Endpoints Tested:**
  - Authentication APIs
  - User management APIs
  - Reports APIs
  - Odoo integration APIs
  - Oracle push APIs

#### 15. Odoo Endpoints Page (`15-odoo-endpoints.png`)
- **URL:** `/odoo-endpoints.html`
- **Description:** Odoo REST API endpoint reference
- **Features:**
  - Complete endpoint documentation
  - Request/response examples
  - Authentication methods
  - Parameter descriptions
  - Test functionality
  - cURL examples
- **Required Role:** All authenticated users
- **Documented Endpoints:**
  - `/api/pos/order` - POS orders
  - `/api/product/get` - Products
  - `/api/uom` - Units of measure
  - `/api/taxes` - Tax configuration
  - `/api/companies` - Companies
  - `/api/vOutlets/Bracnhes` - Branches
  - `/api/vOutlets/poslist` - POS configuration

---

## 🔐 Authentication & Middleware System

All pages (except login) are protected by the JWT authentication middleware located in `src/middleware/auth.js`.

### Middleware Functions

1. **`requireAuth`** - Any authenticated user
2. **`requireUser`** - User level or higher (excludes viewers)
3. **`requireManagement`** - Management level or higher
4. **`requireAdmin`** - Admin or super_admin only
5. **`requireSuperAdmin`** - Super admin only

### Token Handling

- Tokens are stored in `__auth` cookie
- Tokens expire after 12 hours
- Tokens include: `id`, `username`, `role`
- Uses JWT with bcrypt password hashing

### Security Features

- Privilege escalation protection
- Last admin/super admin protection
- Password strength requirements
- Role-based access control (RBAC)
- HTTP-only cookies
- HTTPS recommended for production

---

## 📊 Page Access Matrix

| Page | URL | Min. Role | Key Features |
|------|-----|-----------|--------------|
| Login | `/login.html` | Public | Authentication |
| Dashboard | `/` | Viewer | Overview, stats |
| Odoo Sales | `/odoo-sales.html` | User | Fetch/Push data |
| New Sale | `/new-sale.html` | User | Manual entry |
| Orders | `/orders.html` | User | View orders |
| Sync History | `/sync-history.html` | User | Job monitoring |
| Reports | `/reports.html` | Management | Analytics |
| Configuration | `/config.html` | Admin | System settings |
| Users | `/users.html` | Admin | User management |
| Profile | `/profile.html` | All | Personal settings |
| Calculations | `/calculations.html` | All | Reference |
| Benchmark | `/benchmark.html` | Admin | Performance |
| API Test | `/api-test.html` | All | Testing |
| Odoo Endpoints | `/odoo-endpoints.html` | All | Documentation |

---

## 🎨 UI Design Features

### Modern Design Elements
- Clean, professional interface
- Responsive layout
- Consistent color scheme
- Intuitive navigation
- Loading indicators
- Status badges
- Error/success messages
- Form validation feedback

### Navigation
- Top navigation bar with role-appropriate links
- User info display
- Logout button
- Breadcrumb navigation
- Quick access shortcuts

### Data Presentation
- Sortable tables
- Pagination controls
- Search and filter capabilities
- Export functionality
- Real-time updates
- Status indicators

---

## 📖 Documentation References

- **Main README:** `/oracle-crm/README.md`
- **User Management Guide:** `/oracle-crm/USER_MANAGEMENT_AND_REPORTING.md`
- **Configuration Guide:** `/oracle-crm/CONFIGURATION_GUIDE.md`
- **Implementation Summary:** `/oracle-crm/IMPLEMENTATION_SUMMARY.md`
- **Calculations Guide:** `/CALCULATIONS_AND_CMS_GUIDE.md`

---

## 🚀 Getting Started

### Default Login Credentials

**Super Administrator:**
- Username: `superadmin`
- Password: `SuperAdmin@1234`
- Role: `super_admin` (level 5)

**Administrator:**
- Username: `admin`
- Password: `Admin@1234`
- Role: `admin` (level 4)

⚠️ **IMPORTANT:** Change these default passwords immediately after first login!

### First Steps

1. Login with default credentials
2. Navigate to Profile page and change your password
3. Go to Users page to create additional users
4. Configure system settings in Configuration page
5. Test Odoo connection
6. Configure store metadata
7. Start fetching and pushing data

---

## 📝 Notes

- All screenshots captured at 1920x1080 resolution
- Screenshots show the application in a clean state
- Some pages may show placeholder data
- Role-based features visible based on super_admin access
- Full-page screenshots capture entire page content
- Timestamp: May 14, 2026

---

## 🔧 Technical Information

- **Framework:** Vanilla JavaScript, Express.js backend
- **Authentication:** JWT with bcrypt password hashing
- **Database:** SQLite (for local data cache)
- **Styling:** Custom CSS, responsive design
- **API:** RESTful endpoints
- **Integration:** Oracle Fusion Cloud, Odoo ERP

---

## 📞 Support

For questions or issues:
- Check the documentation in `/oracle-crm/README.md`
- Review API documentation in Postman collections
- Consult troubleshooting guides

---

*Generated: May 14, 2026*
*Version: 1.0.0*
*Oracle CRM Middleware with Enhanced Authentication System*
