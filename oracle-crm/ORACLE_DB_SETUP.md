# Oracle Database Integration Setup Guide

This guide explains how to enable Oracle Database integration in the oracle-crm application, including fixing the **NJS-533 Advanced Networking Option** error.

## Overview

The Oracle Database integration allows the middleware to:
- **Sync metadata** from Oracle database to local SQLite cache
- **Backup sales data** to Oracle BACKUP tables
- **Read fusion metadata** directly from Oracle database tables

## Prerequisites

### 1. Oracle Instant Client (Required for Thick Mode)

The oracle-crm application requires **node-oracledb in thick mode** to support:
- Advanced Networking Options (encryption/data integrity)
- Oracle Cloud Database connections
- Enterprise database security features

**Without Oracle Instant Client, you will see this error:**
```
NJS-533: Advanced Networking Option service negotiation failed.
Native Network Encryption and DataIntegrity only supported in node-oracledb thick mode.
Cause: ORA-12660
```

### 2. Installation Instructions by Platform

#### Linux (Ubuntu/Debian/CentOS/RHEL)

1. **Download Oracle Instant Client:**
   ```bash
   # For Oracle Linux/RHEL/CentOS
   sudo yum install oracle-instantclient-basic

   # OR download manually from Oracle:
   # https://www.oracle.com/database/technologies/instant-client/linux-x86-64-downloads.html
   ```

2. **Install manually (if downloaded):**
   ```bash
   # Extract to /opt/oracle
   sudo mkdir -p /opt/oracle
   cd /opt/oracle
   sudo unzip instantclient-basic-linux.x64-21.3.0.0.0.zip

   # Set up library path
   sudo sh -c "echo /opt/oracle/instantclient_21_3 > /etc/ld.so.conf.d/oracle-instantclient.conf"
   sudo ldconfig
   ```

3. **Set environment variables (optional):**
   ```bash
   # Add to ~/.bashrc or /etc/environment
   export ORACLE_HOME=/opt/oracle/instantclient_21_3
   export LD_LIBRARY_PATH=$ORACLE_HOME:$LD_LIBRARY_PATH
   export PATH=$ORACLE_HOME:$PATH
   ```

4. **Verify installation:**
   ```bash
   ls -la /opt/oracle/instantclient_21_3/
   # Should see libclntsh.so, libnnz21.so, etc.
   ```

#### Windows

1. **Download Oracle Instant Client:**
   - Visit: https://www.oracle.com/database/technologies/instant-client/winx64-64-downloads.html
   - Download "Basic Package" (e.g., instantclient-basic-windows.x64-21.3.0.0.0.zip)

2. **Extract to C:\oracle\instantclient_21_3**
   ```cmd
   # Create directory
   mkdir C:\oracle\instantclient_21_3

   # Extract downloaded ZIP to this directory
   ```

3. **Add to PATH environment variable:**
   - Open System Properties → Environment Variables
   - Edit "Path" variable
   - Add: `C:\oracle\instantclient_21_3`
   - Click OK

4. **OR set ORACLE_HOME:**
   ```cmd
   setx ORACLE_HOME "C:\oracle\instantclient_21_3"
   ```

5. **Restart the application** after setting environment variables

6. **Verify installation:**
   ```cmd
   dir C:\oracle\instantclient_21_3
   # Should see oci.dll, oraociei21.dll, etc.
   ```

#### macOS

1. **Download Oracle Instant Client:**
   - Visit: https://www.oracle.com/database/technologies/instant-client/macos-intel-x86-downloads.html
   - Download "Basic Package"

2. **Install:**
   ```bash
   # Extract to /opt/oracle
   sudo mkdir -p /opt/oracle
   cd /opt/oracle
   sudo unzip instantclient-basic-macos.x64-19.8.0.0.0dbru.zip

   # Create symbolic links
   cd instantclient_19_8
   ln -s libclntsh.dylib.19.1 libclntsh.dylib
   ```

3. **Set environment variables:**
   ```bash
   # Add to ~/.bash_profile or ~/.zshrc
   export ORACLE_HOME=/opt/oracle/instantclient_19_8
   export DYLD_LIBRARY_PATH=$ORACLE_HOME:$DYLD_LIBRARY_PATH
   export PATH=$ORACLE_HOME:$PATH
   ```

4. **Restart terminal** and verify:
   ```bash
   ls -la /opt/oracle/instantclient_19_8/
   # Should see libclntsh.dylib, etc.
   ```

#### Docker Deployment

For Docker containers, add Oracle Instant Client installation to your Dockerfile:

```dockerfile
# Example for Linux container
FROM node:18-slim

# Install Oracle Instant Client dependencies
RUN apt-get update && apt-get install -y \
    libaio1 \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Download and install Oracle Instant Client
RUN mkdir -p /opt/oracle && \
    cd /opt/oracle && \
    wget https://download.oracle.com/otn_software/linux/instantclient/213000/instantclient-basic-linux.x64-21.3.0.0.0.zip && \
    unzip instantclient-basic-linux.x64-21.3.0.0.0.zip && \
    rm instantclient-basic-linux.x64-21.3.0.0.0.zip && \
    echo /opt/oracle/instantclient_21_3 > /etc/ld.so.conf.d/oracle-instantclient.conf && \
    ldconfig

# Set environment variables
ENV ORACLE_HOME=/opt/oracle/instantclient_21_3
ENV LD_LIBRARY_PATH=$ORACLE_HOME:$LD_LIBRARY_PATH
ENV PATH=$ORACLE_HOME:$PATH

# Continue with your application setup
WORKDIR /app
COPY package*.json ./
RUN npm ci --only=production
COPY . .

CMD ["npm", "start"]
```

## Configuration

### 1. Enable Oracle Database Integration

Navigate to the web interface:
1. Login as admin/super_admin
2. Go to **Configuration** page
3. Scroll to **Oracle Database Integration** section
4. Fill in connection details:

| Field | Example | Description |
|-------|---------|-------------|
| **Host** | `193.122.68.27` | Oracle database server hostname or IP |
| **Port** | `1521` | Default Oracle port is 1521 |
| **Service Name** | `TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com` | Full service name or SID |
| **Username** | `SYS` | Database username with read access |
| **Password** | `********` | Database password (encrypted in storage) |
| **Role** | `SYSDBA` | Required for SYS user connections |
| **Table Name** | `FUSION_SALES_METADATA` | Optional: Override default table name |

### 2. Test Connection

Click **⚡ Test Connection** to verify:
- Network connectivity
- Authentication
- Thick mode initialization
- Database version

**Success response:**
```json
{
  "ok": true,
  "message": "Connection successful",
  "version": "Oracle Database 19c Enterprise Edition Release 19.0.0.0.0",
  "diagnostics": {
    "durationMs": 1523,
    "host": "193.122.68.27",
    "port": 1521,
    "serviceName": "TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com",
    "role": "SYSDBA"
  }
}
```

### 3. Sync Metadata

Once connected, sync metadata from Oracle to SQLite:

1. **Sync Fusion Sales Metadata:**
   - Click **🔄 Sync Fusion Sales Metadata**
   - Fetches from `FUSION_SALES_METADATA` table
   - Syncs to local SQLite cache

2. **Sync Store Metadata:**
   - Click **🔄 Sync Store Metadata**
   - Fetches from `STORE_ORACLE_METADATA` table
   - Syncs to local SQLite cache

## Troubleshooting

### Error: NJS-533 / ORA-12660

**Symptom:**
```
❌ Oracle DB connection failed after 3 attempts:
NJS-533: Advanced Networking Option service negotiation failed.
Native Network Encryption and DataIntegrity only supported in node-oracledb thick mode.
Cause: ORA-12660
```

**Solution:**
1. Install Oracle Instant Client (see platform-specific instructions above)
2. Set `ORACLE_HOME` or add to `PATH`/`LD_LIBRARY_PATH`
3. Restart the application
4. Test connection again

**Alternative (Oracle Server Configuration):**

If you control the Oracle server, you can disable encryption requirement:

Edit `$ORACLE_HOME/network/admin/sqlnet.ora`:
```
SQLNET.ENCRYPTION_SERVER=rejected
SQLNET.CRYPTO_CHECKSUM_SERVER=rejected
```

Then restart Oracle listener:
```bash
lsnrctl reload
```

### Error: DPI-1047

**Symptom:**
```
DPI-1047: Cannot locate a 64-bit Oracle Client library
```

**Solution:**
- Oracle Instant Client is not installed or not in PATH
- Follow installation instructions above for your platform
- Ensure 64-bit version matches your Node.js architecture

### Error: ORA-01017 / Invalid username/password

**Symptom:**
```
Oracle DB connection failed: Invalid username or password
```

**Solution:**
1. Verify credentials are correct
2. For SYS user, ensure **Role** is set to `SYSDBA`
3. Check if account is locked: `SELECT account_status FROM dba_users WHERE username='SYS';`

### Error: ORA-12154 / TNS:could not resolve

**Symptom:**
```
ORA-12154: TNS:could not resolve the connect identifier specified
```

**Solution:**
1. Verify service name is correct
2. Use full connection string format: `host:port/service_name`
3. Check tnsnames.ora if using TNS names

### Connection Timeout

**Symptom:**
```
ORA-12170: TNS:Connect timeout occurred
```

**Solution:**
1. Check firewall allows port 1521
2. Verify database server is reachable: `ping 193.122.68.27`
3. Check Oracle listener is running: `lsnrctl status`
4. Increase connectTimeout in configuration (default: 60 seconds)

## Database Schema Requirements

### FUSION_SALES_METADATA Table

Expected columns:
```sql
CREATE TABLE FUSION_SALES_METADATA (
  ROW_ID NUMBER PRIMARY KEY,
  SUBINVENTORY VARCHAR2(100),
  CUSTOMER_TYPE VARCHAR2(50),
  BILL_TO_NAME VARCHAR2(255),
  BILL_TO_ACCOUNT VARCHAR2(100),
  SITE_NUMBER VARCHAR2(50),
  BUSINESS_UNIT VARCHAR2(100),
  TXN_SOURCE VARCHAR2(100),
  TXN_TYPE VARCHAR2(100),
  RATE_IS_CORPORATE VARCHAR2(10),
  REC_ACTIVITY_NAME_BANK VARCHAR2(100),
  REC_ACTIVITY_NAME_CASH VARCHAR2(100),
  INTEGRATION_SOURCE VARCHAR2(100),
  DISTRIBUTION_ACC_ID NUMBER,
  REGION VARCHAR2(50),
  COST_CENTER_CODE VARCHAR2(50)
);
```

### STORE_ORACLE_METADATA Table

Expected columns:
```sql
CREATE TABLE STORE_ORACLE_METADATA (
  STORE_ID VARCHAR2(50) PRIMARY KEY,
  STORE_NAME VARCHAR2(255),
  BILL_TO_NAME VARCHAR2(255),
  BILL_TO_ACCOUNT VARCHAR2(100),
  SITE_NUMBER VARCHAR2(50),
  BUSINESS_UNIT VARCHAR2(100),
  TXN_SOURCE VARCHAR2(100),
  TXN_TYPE VARCHAR2(100),
  PAYMENT_TERMS_NAME VARCHAR2(100),
  RATE_IS_CORPORATE VARCHAR2(10),
  ORG_ID NUMBER,
  COST_CENTER_CODE VARCHAR2(50),
  CUSTOMER_TYPE VARCHAR2(50),
  REGION VARCHAR2(50),
  TZ_OFFSET NUMBER,
  CURRENCY VARCHAR2(10),
  OUTLET_NAME VARCHAR2(255),
  ORGANIZATION_NAME VARCHAR2(255),
  DEFAULT_PAYMENT_TYPE VARCHAR2(50),
  TAX_NAME VARCHAR2(100),
  RECEIPT_METHOD_META CLOB,
  JOURNAL_META CLOB,
  UOM_CODE_MAP CLOB,
  REC_ACTIVITY_NAME_BANK VARCHAR2(100),
  REC_ACTIVITY_NAME_CASH VARCHAR2(100)
);
```

### BACKUP_VENDHQ_SALES Table

For sales backup functionality:
```sql
CREATE TABLE BACKUP_VENDHQ_SALES (
  ROW_ID NUMBER PRIMARY KEY,
  INVOICE_NUMBER VARCHAR2(100) NOT NULL,
  OUTLET_NAME VARCHAR2(255),
  REGISTER_NAME VARCHAR2(255),
  SALE_DATE DATE NOT NULL,
  TOTAL_PRICE NUMBER(15,2),
  TOTAL_TAX NUMBER(15,2),
  TOTAL_LOYALTY NUMBER(15,2),
  TOTAL_PRICE_INCL_TAX NUMBER(15,2),
  VERSION NUMBER DEFAULT 1,
  REGION VARCHAR2(50),
  CUSTOMER_TYPE VARCHAR2(50)
);

CREATE SEQUENCE BACKUP_VENDHQ_SALES_SEQ_GEN START WITH 1 INCREMENT BY 1;
```

## Security Best Practices

1. **Use dedicated database user** with read-only access
2. **Avoid using SYS/SYSTEM** for application connections when possible
3. **Enable Oracle encryption** (requires thick mode)
4. **Rotate passwords regularly**
5. **Use Oracle Wallet** for credential management in production
6. **Restrict network access** to Oracle database (firewall rules)
7. **Monitor connection logs** for suspicious activity
8. **Use SSL/TLS** for database connections (requires certificate setup)

## Performance Tuning

### Connection Pooling

The application uses Oracle connection pooling automatically. Adjust pool size if needed:

```javascript
// In oracleDbClient.js (for advanced users)
const pool = await oracledb.createPool({
  user: config.username,
  password: config.password,
  connectionString: config.connectionString,
  poolMin: 2,
  poolMax: 10,
  poolIncrement: 1,
  poolTimeout: 60
});
```

### Query Optimization

For large metadata tables (>10,000 rows):
1. Create indexes on frequently queried columns
2. Use `maxRows` parameter to limit result sets
3. Add WHERE clauses to filter data on the Oracle side

## Additional Resources

- **Oracle Instant Client Downloads:** https://www.oracle.com/database/technologies/instant-client/downloads.html
- **node-oracledb Documentation:** https://node-oracledb.readthedocs.io/
- **Thick Mode Guide:** https://node-oracledb.readthedocs.io/en/latest/user_guide/initialization.html
- **Oracle Database Error Codes:** https://docs.oracle.com/error-help/
- **Oracle Cloud Database Setup:** https://docs.oracle.com/en-us/iaas/Content/Database/home.htm

## Support

For issues or questions:
1. Check application logs: `tail -f oracle-crm.log`
2. Review error messages in the web interface
3. Consult the troubleshooting section above
4. Open an issue on the GitHub repository

---

**Last Updated:** 2026-05-17
