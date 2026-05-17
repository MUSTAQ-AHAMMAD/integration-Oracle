# Oracle Database Docker Setup

This directory contains the Docker configuration for running Oracle Database 21c Express Edition with the ODOO_INTEGRATION schema.

## Prerequisites

- Docker Engine 20.10 or higher
- Docker Compose 1.29 or higher
- At least 2GB of free RAM
- At least 10GB of free disk space

## Quick Start

1. **Copy the environment file:**
   ```bash
   cp .env.example .env
   ```

2. **Start the Oracle Database:**
   ```bash
   docker-compose up -d
   ```

3. **Wait for initialization (first time only):**
   The database will take 2-5 minutes to start on first run. Check the logs:
   ```bash
   docker-compose logs -f oracle-db
   ```

4. **Verify the database is ready:**
   ```bash
   docker-compose exec oracle-db bash -c "echo 'SELECT 1 FROM DUAL;' | sqlplus -L ODOO_INTEGRATION/Oracle123@localhost:1521/XE"
   ```

## Database Schema

The database includes all tables from `database.sql` with the following schema:

### User
- **Username:** ODOO_INTEGRATION
- **Password:** Oracle123 (change in production)
- **Schema:** ODOO_INTEGRATION

### Main Table Groups

1. **VendHQ Tables** - Sales, Line Items, Payments, Promotions
2. **Fusion Tables** - Invoices, Receipts, Journal Entries, Inventory Transactions
3. **Metadata Tables** - Credentials, Configuration, Outlets, Registers
4. **Notification Tables** - Email Recipients

### Sequences

All required sequences are automatically created:
- BACKUP_VENDHQ_*_SEQ_GEN
- FUSION_*_SEQ_GEN
- VENDHQ_*_SEQ_GEN
- REQUEST_SEQ_GEN

## Connection Information

### JDBC Connection String
```
jdbc:oracle:thin:@localhost:1521:XE
```

### SQL*Plus Connection
```bash
sqlplus ODOO_INTEGRATION/Oracle123@localhost:1521/XE
```

### For Java Middleware
```properties
db.url=jdbc:oracle:thin:@localhost:1521:XE
db.user=ODOO_INTEGRATION
db.password=Oracle123
db.driver=oracle.jdbc.OracleDriver
```

## Management Commands

### Start the database
```bash
docker-compose up -d
```

### Stop the database
```bash
docker-compose stop
```

### Restart the database
```bash
docker-compose restart
```

### View logs
```bash
docker-compose logs -f oracle-db
```

### Access SQL*Plus shell
```bash
docker-compose exec oracle-db sqlplus ODOO_INTEGRATION/Oracle123@XE
```

### Access as SYS user
```bash
docker-compose exec oracle-db sqlplus sys/Oracle123@XE as sysdba
```

### Backup database
```bash
docker-compose exec oracle-db bash -c "expdp ODOO_INTEGRATION/Oracle123@XE directory=DATA_PUMP_DIR dumpfile=backup_$(date +%Y%m%d).dmp logfile=backup_$(date +%Y%m%d).log"
```

### Restore database
```bash
docker-compose exec oracle-db bash -c "impdp ODOO_INTEGRATION/Oracle123@XE directory=DATA_PUMP_DIR dumpfile=backup.dmp logfile=restore.log"
```

## Data Persistence

Database data is stored in Docker volumes:
- `oracle-data` - Main database files
- `oracle-backup` - Backup files

To completely remove all data:
```bash
docker-compose down -v
```

## Ports

- **1521** - Oracle TNS Listener (database connections)
- **5500** - Oracle Enterprise Manager Express (web interface)

Access Enterprise Manager at: https://localhost:5500/em

## Environment Variables

Configure these in `.env` file:

| Variable | Default | Description |
|----------|---------|-------------|
| ORACLE_SID | XE | Oracle System Identifier |
| ORACLE_PDB | XEPDB1 | Pluggable Database Name |
| ORACLE_PWD | Oracle123 | SYS/SYSTEM password |
| ORACLE_CHARACTERSET | AL32UTF8 | Database character set |
| DB_USER | ODOO_INTEGRATION | Application user |
| DB_PASSWORD | Oracle123 | Application password |
| DB_HOST | localhost | Database host |
| DB_PORT | 1521 | Database port |

## Security Considerations

⚠️ **IMPORTANT:** The default passwords are for development only!

For production:
1. Change all passwords in `.env`
2. Use strong passwords (12+ characters, mixed case, numbers, symbols)
3. Restrict network access to database port
4. Enable Oracle encryption features
5. Regular security patches and updates

## Troubleshooting

### Database won't start
- Check available disk space: `df -h`
- Check available memory: `free -h`
- Check Docker logs: `docker-compose logs oracle-db`

### Connection refused
- Wait for database initialization (2-5 minutes on first start)
- Check if port 1521 is available: `netstat -an | grep 1521`
- Verify container is running: `docker-compose ps`

### Schema not created
- Check initialization logs: `docker-compose logs oracle-db | grep "create-schema"`
- Manually run schema script:
  ```bash
  docker-compose exec oracle-db bash -c "sqlplus ODOO_INTEGRATION/Oracle123@XE @/opt/oracle/scripts/setup/02-create-schema.sql"
  ```

### Performance issues
- Increase Docker memory limit (minimum 2GB recommended)
- Adjust SGA/PGA parameters in Oracle configuration
- Monitor with: `docker stats oracle-integration-db`

## Integration with Java Middleware

The database schema matches the Java entity mappings in:
- `IntegrationJobs/src/innovate/tamergroup/vendhq/persistence/`
- `IntegrationJobs/src/innovate/tamergroup/fusion/`

Connection configuration should be added to your Java application properties:
```properties
# Oracle Database Configuration
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=ODOO_INTEGRATION
spring.datasource.password=Oracle123
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# JPA/Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
spring.jpa.hibernate.ddl-auto=validate
```

## Additional Resources

- [Oracle Database Documentation](https://docs.oracle.com/en/database/)
- [Oracle XE Docker Hub](https://hub.docker.com/_/oracle-database-enterprise-edition)
- [SQL*Plus User's Guide](https://docs.oracle.com/en/database/oracle/oracle-database/21/sqpug/)

## Support

For issues related to:
- Database schema: Check `database.sql` in the repository root
- Java integration: Check the persistence layer in `IntegrationJobs/src/`
- Docker configuration: Review this README and `docker-compose.yml`
