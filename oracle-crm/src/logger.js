'use strict';

/**
 * logger.js
 *
 * Structured application logger built on Winston.
 * – Console transport: colourised, human-readable
 * – File transports : logs/app.log (all levels) + logs/error.log (errors only)
 * – Non-blocking    : all I/O is handled by Winston's async transports
 *
 * Usage:
 *   const log = require('./logger');
 *   log.info('Server started', { port: 3000 });
 *   log.error('Oracle API failed', { step: 'createInvoice', err: err.message });
 */

const path    = require('path');
const fs      = require('fs');
const winston = require('winston');

// Ensure logs directory exists
const LOGS_DIR = path.join(__dirname, '..', 'logs');
if (!fs.existsSync(LOGS_DIR)) fs.mkdirSync(LOGS_DIR, { recursive: true });

const { combine, timestamp, printf, colorize, errors, splat } = winston.format;

// ── Custom log format ─────────────────────────────────────────────────────────
const logFormat = printf(({ level, message, timestamp: ts, stack, ...meta }) => {
  const metaStr = Object.keys(meta).length
    ? ' ' + JSON.stringify(meta, null, 0)
    : '';
  return `${ts} [${level.toUpperCase().padEnd(5)}] ${stack || message}${metaStr}`;
});

const fileFormat = combine(
  errors({ stack: true }),
  splat(),
  timestamp({ format: 'YYYY-MM-DD HH:mm:ss.SSS' }),
  logFormat
);

const consoleFormat = combine(
  colorize({ all: true }),
  errors({ stack: true }),
  splat(),
  timestamp({ format: 'HH:mm:ss.SSS' }),
  logFormat
);

// ── Transports ────────────────────────────────────────────────────────────────
const transports = [
  new winston.transports.Console({
    format: consoleFormat,
    handleExceptions: true,
  }),
  new winston.transports.File({
    filename : path.join(LOGS_DIR, 'error.log'),
    level    : 'error',
    format   : fileFormat,
    maxsize  : 5 * 1024 * 1024,   // 5 MB
    maxFiles : 5,
    tailable : true,
    handleExceptions: true,
  }),
  new winston.transports.File({
    filename : path.join(LOGS_DIR, 'app.log'),
    level    : 'debug',
    format   : fileFormat,
    maxsize  : 10 * 1024 * 1024,  // 10 MB
    maxFiles : 10,
    tailable : true,
  }),
];

// ── Logger instance ───────────────────────────────────────────────────────────
const logger = winston.createLogger({
  level            : process.env.LOG_LEVEL || 'info',
  transports,
  exitOnError      : false,
});

/**
 * Create a child logger scoped to a specific module / pipeline stage.
 * @param {string} module - e.g. 'OdooSync', 'OraclePush', 'OdooClient'
 */
logger.child = function createChild(module) {
  return {
    debug : (msg, meta) => logger.debug(msg, { module, ...meta }),
    info  : (msg, meta) => logger.info(msg,  { module, ...meta }),
    warn  : (msg, meta) => logger.warn(msg,  { module, ...meta }),
    error : (msg, meta) => logger.error(msg, { module, ...meta }),
  };
};

module.exports = logger;
