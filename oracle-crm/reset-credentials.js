#!/usr/bin/env node
'use strict';

/**
 * reset-credentials.js
 *
 * Resets the passwords for superadmin and admin users to new secure credentials.
 * Run this script to generate fresh login credentials for the Oracle-CRM system.
 *
 * Usage:
 *   node reset-credentials.js
 */

const bcrypt = require('bcryptjs');
const db = require('./src/db');
const crypto = require('crypto');

// Generate secure random passwords
function generateSecurePassword(length = 16) {
  const charset = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*';
  let password = '';
  const randomBytes = crypto.randomBytes(length);

  for (let i = 0; i < length; i++) {
    password += charset[randomBytes[i] % charset.length];
  }

  return password;
}

async function resetCredentials() {
  console.log('\n╔════════════════════════════════════════════════════════════════════╗');
  console.log('║         Oracle-CRM Credential Reset Utility                       ║');
  console.log('╚════════════════════════════════════════════════════════════════════╝\n');

  try {
    // Generate new secure passwords
    const newSuperAdminPassword = generateSecurePassword(16);
    const newAdminPassword = generateSecurePassword(16);

    // Hash the passwords
    const superAdminHash = await bcrypt.hash(newSuperAdminPassword, 10);
    const adminHash = await bcrypt.hash(newAdminPassword, 10);

    // Check if users exist
    const superadmin = db.getUserByUsername('superadmin');
    const admin = db.getUserByUsername('admin');

    if (superadmin) {
      // Update existing superadmin
      db.updateUser(superadmin.id, { password_hash: superAdminHash });
      console.log('✓ Super Administrator password has been reset');
    } else {
      // Create new superadmin
      db.createUser({
        username: 'superadmin',
        email: 'superadmin@oracle-crm.local',
        passwordHash: superAdminHash,
        role: 'super_admin',
        displayName: 'Super Administrator'
      });
      console.log('✓ Super Administrator account created');
    }

    if (admin) {
      // Update existing admin
      db.updateUser(admin.id, { password_hash: adminHash });
      console.log('✓ Administrator password has been reset');
    } else {
      // Create new admin
      db.createUser({
        username: 'admin',
        email: 'admin@oracle-crm.local',
        passwordHash: adminHash,
        role: 'admin',
        displayName: 'Administrator'
      });
      console.log('✓ Administrator account created');
    }

    console.log('\n╔════════════════════════════════════════════════════════════════════╗');
    console.log('║                    NEW LOGIN CREDENTIALS                          ║');
    console.log('╠════════════════════════════════════════════════════════════════════╣');
    console.log('║                                                                    ║');
    console.log('║  Super Administrator:                                              ║');
    console.log('║  ─────────────────────                                             ║');
    console.log(`║  Username: superadmin                                              ║`);
    console.log(`║  Password: ${newSuperAdminPassword.padEnd(50)}║`);
    console.log('║  Role:     super_admin                                             ║');
    console.log('║                                                                    ║');
    console.log('║  ────────────────────────────────────────────────────────────────  ║');
    console.log('║                                                                    ║');
    console.log('║  Administrator:                                                    ║');
    console.log('║  ──────────────                                                    ║');
    console.log(`║  Username: admin                                                   ║`);
    console.log(`║  Password: ${newAdminPassword.padEnd(50)}║`);
    console.log('║  Role:     admin                                                   ║');
    console.log('║                                                                    ║');
    console.log('╚════════════════════════════════════════════════════════════════════╝');

    console.log('\n⚠️  IMPORTANT SECURITY NOTES:\n');
    console.log('   • Save these credentials in a secure password manager');
    console.log('   • Do not share these credentials via email or chat');
    console.log('   • Change these passwords after your first login');
    console.log('   • Delete this script output from your terminal history\n');

    console.log('✓ Credentials have been successfully reset!\n');

    // Save credentials to a secure file (optional)
    const fs = require('fs');
    const credFile = '/tmp/oracle-crm-credentials.txt';
    const credContent = `
Oracle-CRM Login Credentials (Generated: ${new Date().toISOString()})
═══════════════════════════════════════════════════════════════

Super Administrator
───────────────────
Username: superadmin
Password: ${newSuperAdminPassword}
Role: super_admin

Administrator
─────────────
Username: admin
Password: ${newAdminPassword}
Role: admin

⚠️  SECURITY WARNING: Delete this file after copying the credentials to a secure location.
`;

    fs.writeFileSync(credFile, credContent, { mode: 0o600 });
    console.log(`📄 Credentials also saved to: ${credFile}`);
    console.log('   (File permissions set to 600 - owner read/write only)\n');

  } catch (error) {
    console.error('\n❌ Error resetting credentials:', error.message);
    console.error(error.stack);
    process.exit(1);
  }
}

// Run the reset
resetCredentials().catch(err => {
  console.error('Fatal error:', err);
  process.exit(1);
});
