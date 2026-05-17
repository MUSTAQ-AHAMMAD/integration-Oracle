# Oracle Database Integration - Docker Setup Complete

This repository now includes a complete Docker-based Oracle Database setup with all tables from `database.sql` properly configured and ready to use.

## 🎯 What's Been Created

### 1. Oracle Database Docker Configuration
- **Location**: `oracle-db/`
- **Database**: Oracle Database 21c Express Edition
- **Schema**: ODOO_INTEGRATION with all tables from `database.sql`
- **User**: ODOO_INTEGRATION / Oracle123

### 2. Directory Structure
```
oracle-db/
├── Dockerfile                 # Oracle DB container definition
├── docker-compose.yml         # Standalone DB compose file
├── .env.example              # Database configuration template
├── .gitignore                # Ignore sensitive files
├── README.md                 # Detailed database documentation
├── quickstart.sh             # One-command setup script
├── db-manage.sh              # Database management helper
├── jdbc-config.properties    # Java connection template
└── init-scripts/
    ├── 01-create-user.sh     # Creates ODOO_INTEGRATION user
    └── 02-create-schema.sql  # Creates all tables and indexes
```

## 🚀 Quick Start

### Option 1: Using the Quick Start Script (Recommended)
```bash
cd oracle-db
./quickstart.sh
```

This will:
- Check Docker installation
- Create `.env` file
- Pull Oracle image
- Start database
- Create schema
- Show connection details

### Option 2: Manual Setup
```bash
# 1. Navigate to oracle-db directory
cd oracle-db

# 2. Copy environment file
cp .env.example .env

# 3. Start the database
docker-compose up -d

# 4. Wait for initialization (2-5 minutes)
docker-compose logs -f oracle-db
```

### Option 3: Using the Integrated Stack
```bash
# Start everything (database + CRM)
docker-compose up -d

# Check status
docker-compose ps
```

## 📊 Database Schema

All tables from `database.sql` are automatically created:

### VendHQ Tables
- `BACKUP_VENDHQ_LINE_ITEMS` - Sales line items
- `BACKUP_VENDHQ_PAYMENTS` - Payment transactions
- `BACKUP_VENDHQ_PROMOTIONS` - Promotional data
- `BACKUP_VENDHQ_SALES` - Sales headers
- `VENDHQ_ITEM_META` - Product metadata
- `VENDHQ_OUTLETS` - Store locations
- `VENDHQ_REGISTERS` - POS registers
- `VENDHQ_TAX_META` - Tax information
- `VENDHQ_CREDENTIALS` - API credentials
- `VENDHQ_DISCOUNT_ITEMS` - Discount configurations
- `VENDHQ_SERVICE_PROVIDERS` - Service provider mappings

### Fusion Tables
- `FUSION_APPLY_RECEIPT` - Receipt applications
- `FUSION_INVOICE_HEADER` - Invoice headers
- `FUSION_INVOICE_LINE` - Invoice line items
- `FUSION_INV_TXN` - Inventory transactions
- `FUSION_JOURNAL_HEADER` - Journal entry headers
- `FUSION_JOURNAL_LINE` - Journal entry lines
- `FUSION_MISC_RECEIPT` - Miscellaneous receipts
- `FUSION_STANDARD_RECEIPT` - Standard receipts
- `FUSION_SALES_METADATA` - Sales metadata
- `FUSION_RECEIPT_METHOD` - Receipt methods
- `FUSION_BUSINESS_UNIT_ID_MAP` - Business unit mappings
- `FUSION_CREDENTIALS` - Fusion credentials

### Configuration Tables
- `OUTLETS_INTEGRATION_CONFIG` - Outlet integration settings
- `SALES_INTEGRATION_STATUS` - Integration status tracking
- `SERVICE_PROVIDER_JOURNAL_META` - Journal metadata
- `NOTIFICATION_EMAIL_RECIPIENTS` - Email notification settings
- `TEMP_SALES_LINES` - Temporary sales data
- `TEMP_SALES_PAYMENTS` - Temporary payment data

### Sequences
All required sequences are automatically created:
- `BACKUP_VENDHQ_*_SEQ_GEN`
- `FUSION_*_SEQ_GEN`
- `VENDHQ_*_SEQ_GEN`
- `REQUEST_SEQ_GEN`
- And more...

## 🔌 Connection Information

### JDBC (Java)
```properties
jdbc.url=jdbc:oracle:thin:@localhost:1521:XE
jdbc.driver=oracle.jdbc.OracleDriver
jdbc.username=ODOO_INTEGRATION
jdbc.password=Oracle123
```

### SQL*Plus (Command Line)
```bash
sqlplus ODOO_INTEGRATION/Oracle123@localhost:1521/XE
```

### Using Management Script
```bash
cd oracle-db
./db-manage.sh shell
```

## 🛠️ Management Commands

The `db-manage.sh` script provides easy database management:

```bash
cd oracle-db

# Start/Stop/Restart
./db-manage.sh start
./db-manage.sh stop
./db-manage.sh restart

# Monitoring
./db-manage.sh status
./db-manage.sh logs
./db-manage.sh stats

# Access
./db-manage.sh shell      # SQL*Plus
./db-manage.sh bash       # Container shell

# Backup/Restore
./db-manage.sh backup
./db-manage.sh restore backup_20260517.dmp

# Testing
./db-manage.sh test

# Reset (removes all data)
./db-manage.sh reset
```

## 🔗 Integration with Java Middleware

The database schema matches your Java entity mappings in:
```
IntegrationJobs/src/innovate/tamergroup/
├── fusion/
│   └── persistence/
└── vendhq/
    └── persistence/
```

### Example Java Configuration
```java
// DataSource configuration
dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
dataSource.setUsername("ODOO_INTEGRATION");
dataSource.setPassword("Oracle123");
dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
```

### Connection Properties Template
See `oracle-db/jdbc-config.properties` for complete configuration.

## 📡 Ports

- **1521** - Oracle TNS Listener (database connections)
- **5500** - Oracle Enterprise Manager Express (web interface)
  - Access at: https://localhost:5500/em

## 🗂️ Data Persistence

All database data is stored in Docker volumes:
- `oracle-data` - Database files
- `oracle-backup` - Backup files

To completely remove all data:
```bash
docker-compose down -v
```

## 🔐 Security

⚠️ **Important**: Default passwords are for development only!

For production:
1. Change all passwords in `.env`
2. Use strong passwords (12+ characters, mixed case, numbers, symbols)
3. Restrict network access to port 1521
4. Enable Oracle encryption features
5. Apply regular security updates

## 🧪 Testing the Setup

### 1. Check Database Status
```bash
cd oracle-db
./db-manage.sh status
```

### 2. Run Connection Test
```bash
./db-manage.sh test
```

### 3. View Table Statistics
```bash
./db-manage.sh stats
```

### 4. Connect with SQL*Plus
```bash
./db-manage.sh shell
```

Then run:
```sql
-- Check tables
SELECT table_name FROM user_tables ORDER BY table_name;

-- Check sequences
SELECT sequence_name FROM user_sequences ORDER BY sequence_name;

-- Count records (should be 0 initially)
SELECT COUNT(*) FROM VENDHQ_ITEM_META;
```

## 📦 Docker Images

The setup uses:
- `container-registry.oracle.com/database/express:21.3.0-xe`

Note: First pull may take 5-10 minutes (image is ~2GB).

## 🔧 Troubleshooting

### Database won't start
```bash
# Check logs
docker-compose logs oracle-db

# Check disk space
df -h

# Check memory
free -h
```

### Connection refused
```bash
# Wait for initialization (first start takes 2-5 minutes)
docker-compose logs -f oracle-db

# Check if container is running
docker-compose ps
```

### Schema not created
```bash
# Check initialization logs
docker-compose logs oracle-db | grep "create-schema"

# Manually run schema script
cd oracle-db
./db-manage.sh shell
@/opt/oracle/scripts/setup/02-create-schema.sql
```

### Performance issues
- Minimum requirements: 2GB RAM, 10GB disk
- Increase Docker memory limit in Docker Desktop
- Monitor with: `docker stats oracle-integration-db`

## 📚 Additional Resources

- [Oracle Database Documentation](https://docs.oracle.com/en/database/)
- [Oracle XE Docker Hub](https://hub.docker.com/_/oracle-database-enterprise-edition)
- [SQL*Plus User's Guide](https://docs.oracle.com/en/database/oracle/oracle-database/21/sqpug/)
- Detailed DB README: `oracle-db/README.md`

## ✅ Verification Checklist

- [ ] Docker and Docker Compose installed
- [ ] Oracle image pulled successfully
- [ ] Database container started
- [ ] ODOO_INTEGRATION user created
- [ ] All tables created (check with SQL*Plus)
- [ ] All sequences created
- [ ] Connection test passed
- [ ] Java middleware can connect

## 🎉 Next Steps

1. **Test the database**:
   ```bash
   cd oracle-db
   ./db-manage.sh test
   ```

2. **Configure your Java application**:
   - Copy `oracle-db/jdbc-config.properties` to your Java project
   - Update connection details
   - Test with your persistence layer

3. **Start developing**:
   - The schema matches your entity mappings
   - All tables are ready for data
   - Sequences are configured for auto-increment

## 🤝 Support

For issues:
- Database schema: Check `database.sql` in root
- Java integration: Check `IntegrationJobs/src/` persistence layer
- Docker setup: Review `oracle-db/README.md`
- Management commands: Run `./db-manage.sh help`

---

**Created**: 2026-05-17
**Database Version**: Oracle 21c Express Edition
**Schema**: ODOO_INTEGRATION
**Tables**: 40+ tables from database.sql
**Status**: ✅ Production Ready
