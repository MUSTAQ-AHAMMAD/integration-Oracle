# Oracle CRM Login Credentials

## Problem Resolution
The 401 Unauthorized error occurred because the system generates random passwords for default users on first startup. These passwords are not displayed to users, making login impossible.

## Solution
Run the `reset-credentials.js` script to generate new credentials with known passwords.

## Current Login Credentials

### Super Administrator
- **Username**: `superadmin`
- **Password**: `Zy*^Ytdz&LtSjgMn`
- **Role**: `super_admin`
- **Email**: `superadmin@oracle-crm.local`

### Administrator
- **Username**: `admin`
- **Password**: `X0oYZfGMB#z^gKis`
- **Role**: `admin`
- **Email**: `admin@oracle-crm.local`

## Login URL
```
http://localhost:3000/login.html
```

## Important Security Notes

⚠️ **CRITICAL**: These are temporary credentials generated for development/testing.

1. **Change passwords immediately** after first login via `/api/auth/change-password`
2. **Do not commit** this file to version control
3. **Store credentials** in a secure password manager
4. **Delete this file** after saving credentials securely

## Resetting Credentials

If you need to reset the credentials again, run:

```bash
cd oracle-crm
node reset-credentials.js
```

This will:
- Generate new secure random passwords
- Update existing users or create them if they don't exist
- Display the new credentials in the terminal
- Save credentials to `/tmp/oracle-crm-credentials.txt`

## Role Hierarchy

The system uses the following role hierarchy (highest to lowest):
1. `super_admin` - Full system access
2. `admin` - Administrative access
3. `management` - Management level access
4. `user` / `operator` - Standard user access
5. `viewer` - Read-only access

## Troubleshooting

### 401 Unauthorized Error
- Verify you're using the correct username and password
- Check that the database exists at `oracle-crm/data/odoo_sales.db`
- Run `reset-credentials.js` to generate new credentials

### JWT_SECRET Not Set
In production, ensure `JWT_SECRET` is set in `.env`:
```bash
JWT_SECRET=your-secure-random-jwt-secret-here-minimum-32-chars
```

For development, the system uses a default insecure secret with a warning.
