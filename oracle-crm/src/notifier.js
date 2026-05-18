'use strict';

/**
 * notifier.js
 *
 * Notification service for sending alerts on job failures, errors, and important events.
 *
 * Supported notification channels:
 *   • Email (via nodemailer)
 *   • Webhook (HTTP POST to custom endpoint)
 *   • Console/log (for development)
 *
 * Configuration via environment variables or per-schedule notification_config.
 */

const nodemailer = require('nodemailer');
const axios = require('axios');
const logger = require('./logger').child('Notifier');

// ── Email transporter ─────────────────────────────────────────────────────────

let emailTransporter = null;

function getEmailTransporter() {
  if (emailTransporter) return emailTransporter;

  const host = process.env.SMTP_HOST;
  const port = process.env.SMTP_PORT || 587;
  const secure = process.env.SMTP_SECURE === 'true'; // true for 465, false for other ports
  const user = process.env.SMTP_USER;
  const pass = process.env.SMTP_PASS;

  if (!host || !user || !pass) {
    logger.warn('Email notifications not configured. Set SMTP_* environment variables.');
    return null;
  }

  emailTransporter = nodemailer.createTransporter({
    host,
    port: parseInt(port, 10),
    secure,
    auth: { user, pass }
  });

  logger.info('Email transporter initialized', { host, port, secure });
  return emailTransporter;
}

// ── Notification functions ────────────────────────────────────────────────────

async function sendEmail(to, subject, body, html) {
  const transporter = getEmailTransporter();
  if (!transporter) {
    logger.warn('Email transporter not available, skipping email notification');
    return;
  }

  try {
    const mailOptions = {
      from: process.env.SMTP_FROM || process.env.SMTP_USER,
      to: Array.isArray(to) ? to.join(', ') : to,
      subject,
      text: body,
      html: html || body
    };

    const info = await transporter.sendMail(mailOptions);
    logger.info('Email sent successfully', { messageId: info.messageId, to });
    return info;
  } catch (error) {
    logger.error('Failed to send email', { error: error.message, to, subject });
    throw error;
  }
}

async function sendWebhook(url, payload, headers = {}) {
  try {
    const response = await axios.post(url, payload, {
      headers: {
        'Content-Type': 'application/json',
        ...headers
      },
      timeout: 10000 // 10 seconds
    });

    logger.info('Webhook sent successfully', { url, status: response.status });
    return response.data;
  } catch (error) {
    logger.error('Failed to send webhook', {
      error: error.message,
      url,
      status: error.response?.status
    });
    throw error;
  }
}

// ── Failure notification ──────────────────────────────────────────────────────

async function sendFailureNotification(options) {
  const {
    scheduleName,
    scheduleId,
    executionId,
    jobId,
    error,
    config
  } = options;

  const timestamp = new Date().toISOString();
  const notificationConfig = config || {};

  // Build notification content
  const subject = `❌ Oracle-CRM Sync Failed: ${scheduleName}`;
  const textBody = `
Oracle-CRM Automated Sync Failure Alert

Schedule: ${scheduleName}
Schedule ID: ${scheduleId}
Execution ID: ${executionId}
Job ID: ${jobId || 'N/A'}
Timestamp: ${timestamp}

Error:
${error}

Please check the Oracle-CRM dashboard for more details:
${process.env.APP_URL || 'http://localhost:3000'}/sync-history.html

---
This is an automated notification from Oracle-CRM Scheduler.
  `.trim();

  const htmlBody = `
<!DOCTYPE html>
<html>
<head>
  <style>
    body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }
    .container { max-width: 600px; margin: 0 auto; padding: 20px; }
    .header { background: #dc3545; color: white; padding: 20px; border-radius: 5px 5px 0 0; }
    .header h1 { margin: 0; font-size: 20px; }
    .content { background: #f8f9fa; padding: 20px; border: 1px solid #dee2e6; border-top: none; }
    .info-row { margin: 10px 0; }
    .label { font-weight: bold; color: #495057; }
    .value { color: #212529; }
    .error-box { background: #fff; border-left: 4px solid #dc3545; padding: 15px; margin: 15px 0; font-family: monospace; }
    .footer { background: #e9ecef; padding: 15px; border-radius: 0 0 5px 5px; text-align: center; font-size: 12px; color: #6c757d; }
    .button { display: inline-block; padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; margin: 15px 0; }
  </style>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>❌ Oracle-CRM Sync Failed</h1>
    </div>
    <div class="content">
      <div class="info-row">
        <span class="label">Schedule:</span>
        <span class="value">${scheduleName}</span>
      </div>
      <div class="info-row">
        <span class="label">Schedule ID:</span>
        <span class="value">${scheduleId}</span>
      </div>
      <div class="info-row">
        <span class="label">Execution ID:</span>
        <span class="value">${executionId}</span>
      </div>
      <div class="info-row">
        <span class="label">Job ID:</span>
        <span class="value">${jobId || 'N/A'}</span>
      </div>
      <div class="info-row">
        <span class="label">Timestamp:</span>
        <span class="value">${timestamp}</span>
      </div>

      <div class="error-box">
        <strong>Error:</strong><br>
        ${error}
      </div>

      <a href="${process.env.APP_URL || 'http://localhost:3000'}/sync-history.html" class="button">
        View Details in Dashboard
      </a>
    </div>
    <div class="footer">
      This is an automated notification from Oracle-CRM Scheduler.
    </div>
  </div>
</body>
</html>
  `.trim();

  // Send email notification
  if (notificationConfig.emailEnabled !== false && notificationConfig.emailTo) {
    try {
      await sendEmail(notificationConfig.emailTo, subject, textBody, htmlBody);
      logger.info('Failure notification email sent', { scheduleId, executionId });
    } catch (emailError) {
      logger.error('Failed to send failure notification email', {
        error: emailError.message,
        scheduleId,
        executionId
      });
    }
  } else if (process.env.NOTIFICATION_EMAIL) {
    // Fallback to global notification email
    try {
      await sendEmail(process.env.NOTIFICATION_EMAIL, subject, textBody, htmlBody);
      logger.info('Failure notification email sent to global address', { scheduleId, executionId });
    } catch (emailError) {
      logger.error('Failed to send failure notification email', {
        error: emailError.message,
        scheduleId,
        executionId
      });
    }
  }

  // Send webhook notification
  if (notificationConfig.webhookEnabled && notificationConfig.webhookUrl) {
    try {
      const webhookPayload = {
        type: 'sync_failure',
        scheduleName,
        scheduleId,
        executionId,
        jobId,
        error,
        timestamp,
        dashboardUrl: `${process.env.APP_URL || 'http://localhost:3000'}/sync-history.html`
      };

      const webhookHeaders = notificationConfig.webhookHeaders || {};
      await sendWebhook(notificationConfig.webhookUrl, webhookPayload, webhookHeaders);
      logger.info('Failure notification webhook sent', { scheduleId, executionId });
    } catch (webhookError) {
      logger.error('Failed to send failure notification webhook', {
        error: webhookError.message,
        scheduleId,
        executionId
      });
    }
  } else if (process.env.NOTIFICATION_WEBHOOK_URL) {
    // Fallback to global webhook URL
    try {
      const webhookPayload = {
        type: 'sync_failure',
        scheduleName,
        scheduleId,
        executionId,
        jobId,
        error,
        timestamp,
        dashboardUrl: `${process.env.APP_URL || 'http://localhost:3000'}/sync-history.html`
      };

      await sendWebhook(process.env.NOTIFICATION_WEBHOOK_URL, webhookPayload);
      logger.info('Failure notification webhook sent to global URL', { scheduleId, executionId });
    } catch (webhookError) {
      logger.error('Failed to send failure notification webhook', {
        error: webhookError.message,
        scheduleId,
        executionId
      });
    }
  }

  // Console notification (always log)
  logger.error('Sync failure notification', {
    scheduleName,
    scheduleId,
    executionId,
    jobId,
    error
  });
}

async function sendSuccessNotification(options) {
  const {
    scheduleName,
    scheduleId,
    executionId,
    jobId,
    recordsSynced,
    recordsFailed,
    durationMs,
    config
  } = options;

  const timestamp = new Date().toISOString();
  const notificationConfig = config || {};

  // Only send success notifications if explicitly enabled
  if (!notificationConfig.successEnabled && !process.env.NOTIFICATION_SUCCESS_ENABLED) {
    return;
  }

  const subject = `✅ Oracle-CRM Sync Completed: ${scheduleName}`;
  const textBody = `
Oracle-CRM Automated Sync Success

Schedule: ${scheduleName}
Schedule ID: ${scheduleId}
Execution ID: ${executionId}
Job ID: ${jobId}
Timestamp: ${timestamp}

Results:
- Records Synced: ${recordsSynced}
- Records Failed: ${recordsFailed}
- Duration: ${(durationMs / 1000).toFixed(2)}s

View details: ${process.env.APP_URL || 'http://localhost:3000'}/sync-history.html

---
This is an automated notification from Oracle-CRM Scheduler.
  `.trim();

  // Send email if configured
  if (notificationConfig.emailEnabled && notificationConfig.emailTo) {
    try {
      await sendEmail(notificationConfig.emailTo, subject, textBody);
      logger.info('Success notification email sent', { scheduleId, executionId });
    } catch (error) {
      logger.error('Failed to send success notification email', { error: error.message });
    }
  }

  // Send webhook if configured
  if (notificationConfig.webhookEnabled && notificationConfig.webhookUrl) {
    try {
      const webhookPayload = {
        type: 'sync_success',
        scheduleName,
        scheduleId,
        executionId,
        jobId,
        recordsSynced,
        recordsFailed,
        durationMs,
        timestamp
      };

      await sendWebhook(notificationConfig.webhookUrl, webhookPayload, notificationConfig.webhookHeaders);
      logger.info('Success notification webhook sent', { scheduleId, executionId });
    } catch (error) {
      logger.error('Failed to send success notification webhook', { error: error.message });
    }
  }
}

// ── Test notification ─────────────────────────────────────────────────────────

async function sendTestNotification(recipient) {
  const subject = '🧪 Oracle-CRM Test Notification';
  const body = `
This is a test notification from Oracle-CRM.

If you received this email, your notification settings are configured correctly!

Timestamp: ${new Date().toISOString()}

---
Sent from Oracle-CRM Notification Service
  `.trim();

  try {
    await sendEmail(recipient, subject, body);
    logger.info('Test notification sent successfully', { recipient });
    return { success: true, message: 'Test notification sent successfully' };
  } catch (error) {
    logger.error('Failed to send test notification', { error: error.message, recipient });
    return { success: false, message: error.message };
  }
}

// ── Exports ───────────────────────────────────────────────────────────────────

module.exports = {
  sendEmail,
  sendWebhook,
  sendFailureNotification,
  sendSuccessNotification,
  sendTestNotification
};
