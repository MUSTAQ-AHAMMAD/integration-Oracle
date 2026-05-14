/**
 * @vyrooq/integration-core
 *
 * Centralized business logic library containing all 16 critical calculations
 * from the legacy Oracle ADF/Java system, now in TypeScript.
 *
 * All functions are pure, testable, and documented with examples.
 */

/**
 * Calculation 1: Timezone Conversion (UTC → Regional)
 * Converts a UTC date to regional time using timezone offset
 *
 * @param utcDate - Date in UTC
 * @param timeZoneOffset - Timezone offset as decimal (e.g., 3.5 for UTC+3:30)
 * @returns Date adjusted to regional timezone
 *
 * @example
 * convertToRegionalTime(new Date('2024-01-15T07:00:00Z'), 3.5)
 * // Returns: 2024-01-15 10:30 (3h 30m added)
 */
export function convertToRegionalTime(utcDate: Date, timeZoneOffset: number): Date {
  const hoursOffset = Math.trunc(timeZoneOffset);
  const minutesDecimal = Math.abs(timeZoneOffset);
  const minutesOffset = Math.trunc(((minutesDecimal * 100) % 100) * 60 / 100);

  const result = new Date(utcDate);
  result.setHours(result.getHours() + hoursOffset);
  result.setMinutes(result.getMinutes() + minutesOffset);

  return result;
}

/**
 * Calculation 2: Date Range / Day Window (7-day cap)
 * Calculates how many days to process with a 7-day maximum
 *
 * @param lastSaleDate - Last processed sale date
 * @param currentDate - Current date
 * @param isManual - Manual mode flag
 * @param dateRange - User-supplied date range (for manual mode)
 * @returns Number of days to process (0-7)
 *
 * @example
 * calculateDaysToProcess(new Date('2024-01-10'), new Date('2024-01-15'), false, 0)
 * // Returns: 5 (automatic catch-up)
 *
 * calculateDaysToProcess(new Date('2024-01-01'), new Date('2024-01-15'), false, 0)
 * // Returns: 7 (capped at 7 days)
 */
export function calculateDaysToProcess(
  lastSaleDate: Date,
  currentDate: Date,
  isManual: boolean,
  dateRange: number
): number {
  const diffMillis = currentDate.getTime() - lastSaleDate.getTime();
  const diffDays = Math.floor(diffMillis / (1000 * 60 * 60 * 24));

  const daysToAdd = isManual ? (dateRange <= 0 ? 1 : dateRange) : diffDays;
  const finalDaysAddition = daysToAdd <= 7 ? daysToAdd : 7;

  return Math.max(0, finalDaysAddition);
}

/**
 * Calculation 3: Invoice Grouping Key
 * Generates unique key for grouping sales into single invoice
 *
 * @param saleDate - Sale date
 * @param customerType - Customer type (NORMAL, CREDIT, HUNGERSTATION, etc.)
 * @param hasCreditPayment - Whether sale has "Credit On Cust" payment
 * @returns Grouping key string
 *
 * @example
 * generateInvoiceGroupingKey(new Date('2024-01-15'), 'NORMAL', false)
 * // Returns: "15-0-2024NORMAL"
 *
 * generateInvoiceGroupingKey(new Date('2024-01-15'), 'CREDIT', true)
 * // Returns: "15-0-2024CREDIT**Credit"
 */
export function generateInvoiceGroupingKey(
  saleDate: Date,
  customerType: string,
  hasCreditPayment: boolean
): string {
  const day = saleDate.getDate();
  const month = saleDate.getMonth(); // 0-indexed (Jan=0)
  const year = saleDate.getFullYear();

  let key = `${day}-${month}-${year}${customerType}`;

  if (hasCreditPayment) {
    key += '**Credit';
  }

  return key;
}

/**
 * Calculation 4: Unit Selling Price (always positive)
 * Calculates unit price and ensures it's positive
 *
 * @param totalPrice - Line item total price
 * @param quantity - Line item quantity
 * @returns Absolute value of unit price
 *
 * @example
 * calculateUnitSellingPrice(1000, 5)
 * // Returns: 200
 *
 * calculateUnitSellingPrice(-200, 2) // refund
 * // Returns: 100 (absolute value)
 */
export function calculateUnitSellingPrice(totalPrice: number, quantity: number): number {
  if (quantity === 0) return 0;
  const sellingPrice = totalPrice / quantity;
  return Math.abs(sellingPrice);
}

/**
 * Calculation 5: Inventory Transaction Quantity (always negative)
 * Converts sale quantity to Oracle inventory format
 *
 * @param quantity - Sale line item quantity
 * @returns Negative quantity for Oracle inventory
 *
 * @example
 * calculateInventoryTransactionQuantity(5)
 * // Returns: -5 (stock reduction)
 *
 * calculateInventoryTransactionQuantity(-2) // return
 * // Returns: 2 (stock increase)
 */
export function calculateInventoryTransactionQuantity(quantity: number): number {
  return quantity * -1;
}

/**
 * Calculation 6: Transaction Type Logic (Sales Issue vs RMA)
 * Determines inventory transaction type based on price and quantity
 *
 * @param totalPrice - Line item total price
 * @param quantity - Line item quantity
 * @param isServiceProvider - Whether customer is service provider (uses custom mapping)
 * @param customIssueType - Custom issue type from ServiceProviderJournalMapping
 * @param customRMAType - Custom RMA type from ServiceProviderJournalMapping
 * @returns Transaction type string
 *
 * @example
 * determineTransactionType(100, 5, false, null, null)
 * // Returns: "Vend Sales Issue"
 *
 * determineTransactionType(-50, 2, false, null, null)
 * // Returns: "Vend RMA"
 */
export function determineTransactionType(
  totalPrice: number,
  quantity: number,
  isServiceProvider: boolean,
  customIssueType: string | null = null,
  customRMAType: string | null = null
): string {
  const issueType = isServiceProvider && customIssueType ? customIssueType : 'Vend Sales Issue';
  const rmaType = isServiceProvider && customRMAType ? customRMAType : 'Vend RMA';

  if (totalPrice === 0) {
    return quantity > 0 ? issueType : rmaType;
  } else if (totalPrice > 0) {
    return issueType;
  } else {
    return rmaType;
  }
}

/**
 * Calculation 7: Bank Charge Calculation
 * Calculates bank/payment processor charges
 *
 * @param paymentAmount - Payment amount
 * @param chargeRate - Charge rate as decimal (e.g., 0.025 for 2.5%)
 * @param fixedCharge - Fixed charge amount
 * @returns Bank charge amount
 *
 * @example
 * calculateBankCharge(1000, 0.025, 5)
 * // Returns: 30 (1000 * 0.025 + 5)
 */
export function calculateBankCharge(
  paymentAmount: number,
  chargeRate: number,
  fixedCharge: number = 0
): number {
  return (paymentAmount * chargeRate) + fixedCharge;
}

/**
 * Calculation 8: Debit Card Cap (Oman: 10 OMR)
 * Applies regional debit card transaction limits
 *
 * @param amount - Transaction amount
 * @param region - Region code (e.g., 'OM' for Oman)
 * @param cardType - Card type (e.g., 'DEBIT')
 * @returns Capped amount
 *
 * @example
 * applyDebitCardCap(15, 'OM', 'DEBIT')
 * // Returns: 10 (Oman debit cap)
 *
 * applyDebitCardCap(15, 'OM', 'CREDIT')
 * // Returns: 15 (no cap for credit)
 */
export function applyDebitCardCap(
  amount: number,
  region: string,
  cardType: string
): number {
  if (region === 'OM' && cardType === 'DEBIT') {
    return Math.min(amount, 10);
  }
  return amount;
}

/**
 * Calculation 9: Conversion Rate Type (Corporate vs User)
 * Determines currency conversion rate type
 *
 * @param rateIsCorporate - Flag indicating corporate rate
 * @returns Rate type string
 *
 * @example
 * getConversionRateType('1')
 * // Returns: "Corporate"
 *
 * getConversionRateType('0')
 * // Returns: "User"
 */
export function getConversionRateType(rateIsCorporate: string): string {
  return rateIsCorporate === '1' ? 'Corporate' : 'User';
}

/**
 * Calculation 10: Journal Entry Charges (fixed vs percentage)
 * Calculates journal entry charge based on type
 *
 * @param amount - Base amount
 * @param chargeType - Charge type ('FIXED' or 'PERCENTAGE')
 * @param chargeValue - Charge value (fixed amount or percentage as decimal)
 * @returns Calculated charge
 *
 * @example
 * calculateJournalCharge(1000, 'PERCENTAGE', 0.02)
 * // Returns: 20 (2% of 1000)
 *
 * calculateJournalCharge(1000, 'FIXED', 15)
 * // Returns: 15
 */
export function calculateJournalCharge(
  amount: number,
  chargeType: 'FIXED' | 'PERCENTAGE',
  chargeValue: number
): number {
  if (chargeType === 'FIXED') {
    return chargeValue;
  }
  return amount * chargeValue;
}

/**
 * Calculation 11: Cash Account Selection (region-based)
 * Selects appropriate cash account based on region and outlet
 *
 * @param region - Region code (e.g., 'OM', 'SA', 'UAE')
 * @param outletCode - Outlet code
 * @param accountMappings - Map of region/outlet to account codes
 * @returns Cash account code
 *
 * @example
 * selectCashAccount('OM', 'STORE01', mappings)
 * // Returns: "1010.000.0000.0000" (Oman cash account)
 */
export function selectCashAccount(
  region: string,
  outletCode: string,
  accountMappings: Record<string, string>
): string {
  const key = `${region}_${outletCode}`;
  return accountMappings[key] || accountMappings[region] || accountMappings['DEFAULT'];
}

/**
 * Calculation 12: Discount Item Quantity Override
 * Forces discount items to quantity=1 if positive price
 *
 * @param itemName - Item name
 * @param totalPrice - Total price
 * @param originalQuantity - Original quantity
 * @returns Adjusted quantity
 *
 * @example
 * adjustDiscountQuantity('Discount Item', 50, 3)
 * // Returns: 1 (forced to 1)
 *
 * adjustDiscountQuantity('Regular Item', 50, 3)
 * // Returns: 3 (unchanged)
 */
export function adjustDiscountQuantity(
  itemName: string,
  totalPrice: number,
  originalQuantity: number
): number {
  if (itemName === 'Discount Item' && totalPrice > 0) {
    return 1;
  }
  return originalQuantity;
}

/**
 * Calculation 13: Receipt Amount Net Calculation
 * Calculates net receipt amount after bank charges
 *
 * @param grossAmount - Gross payment amount
 * @param bankCharges - Bank charges
 * @returns Net receipt amount
 *
 * @example
 * calculateReceiptAmountNet(1000, 30)
 * // Returns: 970
 */
export function calculateReceiptAmountNet(
  grossAmount: number,
  bankCharges: number
): number {
  return grossAmount - bankCharges;
}

/**
 * Calculation 14: Period Name Formatting (MMM-yy)
 * Formats date to Oracle GL period name
 *
 * @param date - Date to format
 * @returns Period name in MMM-yy format
 *
 * @example
 * formatPeriodName(new Date('2024-01-15'))
 * // Returns: "Jan-24"
 */
export function formatPeriodName(date: Date): string {
  const months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                  'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
  const month = months[date.getMonth()];
  const year = date.getFullYear().toString().slice(-2);
  return `${month}-${year}`;
}

/**
 * Calculation 15: Message Truncation (500 chars)
 * Truncates messages to Oracle field limits
 *
 * @param message - Message to truncate
 * @param maxLength - Maximum length (default 500)
 * @returns Truncated message
 *
 * @example
 * truncateMessage('Very long message...', 500)
 * // Returns: truncated to 500 characters
 */
export function truncateMessage(message: string, maxLength: number = 500): string {
  if (message.length <= maxLength) {
    return message;
  }
  return message.substring(0, maxLength);
}

/**
 * Calculation 16: Rounding Retry Logic (50 attempts with -0.01)
 * Applies progressive rounding adjustment for Oracle Fusion retry
 *
 * @param amount - Original amount
 * @param retryCount - Current retry attempt (0-49)
 * @returns Adjusted amount with rounding correction
 *
 * @example
 * applyRoundingRetry(100.00, 0)
 * // Returns: 100.00 (first attempt, no adjustment)
 *
 * applyRoundingRetry(100.00, 1)
 * // Returns: 99.99 (second attempt, -0.01)
 *
 * applyRoundingRetry(100.00, 5)
 * // Returns: 99.95 (sixth attempt, -0.05)
 */
export function applyRoundingRetry(amount: number, retryCount: number): number {
  if (retryCount === 0) {
    return amount;
  }
  const adjustment = -0.01 * retryCount;
  return Number((amount + adjustment).toFixed(2));
}

/**
 * Region/Outlet Mapping Utilities
 */

export interface OutletConfig {
  outletCode: string;
  outletName: string;
  region: string;
  timezone: number;
  cashAccount: string;
  organizationName: string;
}

export interface RegionConfig {
  regionCode: string;
  regionName: string;
  defaultTimezone: number;
  currency: string;
  debitCardCap?: number;
}

/**
 * Validates and normalizes outlet configuration
 */
export function validateOutletConfig(config: Partial<OutletConfig>): OutletConfig {
  if (!config.outletCode || !config.region) {
    throw new Error('Outlet code and region are required');
  }

  return {
    outletCode: config.outletCode,
    outletName: config.outletName || config.outletCode,
    region: config.region,
    timezone: config.timezone || 0,
    cashAccount: config.cashAccount || '',
    organizationName: config.organizationName || config.outletName || config.outletCode
  };
}

/**
 * Validates and normalizes region configuration
 */
export function validateRegionConfig(config: Partial<RegionConfig>): RegionConfig {
  if (!config.regionCode) {
    throw new Error('Region code is required');
  }

  return {
    regionCode: config.regionCode,
    regionName: config.regionName || config.regionCode,
    defaultTimezone: config.defaultTimezone || 0,
    currency: config.currency || 'USD',
    debitCardCap: config.debitCardCap
  };
}
