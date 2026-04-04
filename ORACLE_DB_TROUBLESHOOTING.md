# Oracle Database Connection Troubleshooting Guide

This guide helps you troubleshoot Oracle Database connection issues, especially when using Oracle Instant Client on Windows.

## Common Error: NJS-500 / NJS-521

**Error Message:**
```
NJS-500: connection to the Oracle Database was broken
NJS-521: connection to host X.X.X.X port 1521 received end-of-file on communication channel
```

This error indicates that the Oracle client attempted to connect to the database but the connection was unexpectedly terminated.

### Root Causes and Solutions

#### 1. Oracle Instant Client Not Properly Configured (Windows)

**Symptoms:**
- Connection fails immediately
- Error message mentions "end-of-file on communication channel"

**Solution:**

##### Option A: Set ORACLE_HOME Environment Variable (Recommended)

1. Download Oracle Instant Client:
   - Visit: https://www.oracle.com/database/technologies/instant-client/winx64-64-downloads.html
   - Download "Basic" or "Basic Light" package (e.g., `instantclient-basic-windows.x64-21.3.0.0.0.zip`)

2. Extract to a permanent location:
   ```
   C:\oracle\instantclient_21_3
   ```

3. Set ORACLE_HOME environment variable:
   - Press `Win + X` and select "System"
   - Click "Advanced system settings"
   - Click "Environment Variables"
   - Under "System variables", click "New"
   - Variable name: `ORACLE_HOME`
   - Variable value: `C:\oracle\instantclient_21_3`
   - Click OK

4. Add to PATH (also in Environment Variables):
   - Under "System variables", select `Path` and click "Edit"
   - Click "New" and add: `C:\oracle\instantclient_21_3`
   - Click OK

5. **Restart your application** (close and reopen Command Prompt/PowerShell)

##### Option B: Add to PATH Only

If you prefer not to set ORACLE_HOME:

1. Follow steps 1-2 from Option A
2. Add Oracle Instant Client to PATH:
   - Open Environment Variables
   - Under "System variables", select `Path` and click "Edit"
   - Click "New" and add: `C:\oracle\instantclient_21_3`
   - Click OK
3. **Restart your application**

#### 2. Network/Firewall Issues

**Symptoms:**
- Connection hangs before timeout
- Same error occurs from different applications

**Solution:**

1. **Test network connectivity:**
   ```cmd
   ping 193.122.68.27
   ```
   If ping fails, there's a network routing issue.

2. **Test port connectivity:**
   ```cmd
   telnet 193.122.68.27 1521
   ```
   Or using PowerShell:
   ```powershell
   Test-NetConnection -ComputerName 193.122.68.27 -Port 1521
   ```

3. **Check Windows Firewall:**
   - Open "Windows Defender Firewall"
   - Click "Advanced settings"
   - Check "Outbound Rules" for any rules blocking Oracle connections
   - If needed, create a new outbound rule to allow TCP traffic to port 1521

4. **Check corporate firewall/VPN:**
   - If connecting to a remote database, ensure your VPN is active
   - Contact your network administrator to verify port 1521 is allowed

#### 3. Incorrect Connection String

**Symptoms:**
- Error occurs immediately
- Other applications can connect to the database

**Solution:**

Verify your connection details:

```javascript
Host: 193.122.68.27
Port: 1521
Service Name: TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com
```

**Common mistakes:**
- Using SID instead of Service Name (use Service Name for Oracle Cloud)
- Wrong port number
- Typo in service name

**Test the connection string format:**
```
host:port/service_name
193.122.68.27:1521/TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com
```

#### 4. Database Server Not Accepting Connections

**Symptoms:**
- Network connectivity test succeeds (ping/telnet)
- Connection still fails

**Possible causes:**
- Database listener is not running
- Database is in restricted mode
- Maximum connections reached
- Listener is configured for different service names

**Solution:**

Contact your DBA to verify:
1. Database listener is running
2. Service name is registered with the listener
3. Database is accepting connections
4. Your IP address is allowed in the database access control list

#### 5. Authentication Issues

**Error Message:**
```
ORA-01017: invalid username/password; logon denied
```

**Solution:**

1. Verify credentials are correct
2. If using SYSDBA role, ensure the account has those privileges:
   ```
   Username: SYS
   Password: [your-password]
   Role: SYSDBA
   ```
3. Check if the account is locked:
   - Have your DBA run: `SELECT username, account_status FROM dba_users WHERE username = 'SYS';`

## Configuration in the Application

### Via UI (Recommended)

1. Navigate to `http://localhost:3000/config.html`
2. Scroll to "Oracle Database Configuration"
3. Fill in the connection details:
   - **Host**: 193.122.68.27
   - **Port**: 1521
   - **Service Name**: TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com
   - **Username**: SYS
   - **Password**: [your-password]
   - **Role**: SYSDBA (if applicable)
4. Click "Test Connection" to verify
5. Click "Save" if successful

### Via Environment Variables

Add to `.env` file in the `oracle-crm` directory:

```env
ORACLE_DB_HOST=193.122.68.27
ORACLE_DB_PORT=1521
ORACLE_DB_SERVICE_NAME=TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com
ORACLE_DB_USERNAME=SYS
ORACLE_DB_PASSWORD=your_password_here
ORACLE_DB_ROLE=SYSDBA
ORACLE_DB_ENABLED=true
```

## Testing the Connection

### Option 1: Via the Web UI

1. Navigate to `http://localhost:3000/config.html`
2. Scroll to "Oracle Database Configuration"
3. Click "Test Connection"
4. Review the detailed diagnostics and troubleshooting suggestions

### Option 2: Via API

```bash
curl -X POST http://localhost:3000/api/config/test-oracle-db \
  -H "Content-Type: application/json" \
  -d '{
    "host": "193.122.68.27",
    "port": 1521,
    "serviceName": "TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com",
    "username": "SYS",
    "password": "your_password",
    "role": "SYSDBA"
  }'
```

### Option 3: Via SQL*Plus (to verify credentials)

If you have SQL*Plus installed:

```cmd
sqlplus SYS/your_password@193.122.68.27:1521/TestDB_jed1sw.dbsubnet.testvcn.oraclevcn.com as SYSDBA
```

If this works, your credentials and network are fine - the issue is with the Node.js Oracle client configuration.

## Advanced Troubleshooting

### Enable Debug Logging

Set the log level to `debug` in `.env`:

```env
LOG_LEVEL=debug
```

Restart the application and check the console output for detailed connection logs.

### Check Oracle Client Version

Verify which Oracle Client is being used:

```cmd
where oci.dll
```

Or check the version:
```cmd
cd C:\oracle\instantclient_21_3
sqlplus -V
```

### Verify Library Loading

On Windows, you can use Process Explorer (from Sysinternals) to see which DLLs are loaded by the Node.js process and verify the Oracle Client libraries are being loaded from the correct location.

## Connection Best Practices

1. **Use connection pooling** for production environments
2. **Set appropriate timeouts** (default: 60 seconds)
3. **Enable retry logic** (default: 3 attempts with exponential backoff)
4. **Monitor connection health** periodically
5. **Close connections** when done to avoid exhausting database resources

## Still Having Issues?

If you've tried all the above and still can't connect:

1. Check the application logs for detailed error messages
2. Verify the exact error code (e.g., ORA-12170, NJS-500, etc.)
3. Check if the same credentials work with other Oracle client tools (SQL*Plus, SQL Developer)
4. Contact your database administrator to verify server-side configuration
5. Create an issue on GitHub with:
   - Complete error message
   - Your Oracle Client version
   - Connection details (without password!)
   - Network topology (local network, VPN, cloud, etc.)

## Quick Checklist

- [ ] Oracle Instant Client installed
- [ ] ORACLE_HOME or PATH environment variable set
- [ ] Application restarted after environment variable changes
- [ ] Network connectivity verified (ping + telnet/Test-NetConnection)
- [ ] Firewall allows outbound connections to port 1521
- [ ] Connection string format verified: `host:port/service_name`
- [ ] Credentials tested with SQL*Plus or SQL Developer
- [ ] Database listener is running and accepting connections
- [ ] Service name is correctly registered with the listener
