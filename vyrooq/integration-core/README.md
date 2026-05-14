# @vyrooq/integration-core

Centralized business logic library for Vyrooq middleware platform. Contains all 16 critical calculation functions from the legacy Oracle ADF/Java system.

## Installation

```bash
npm install @vyrooq/integration-core
```

## Features

- ✅ All 16 calculation functions from legacy Java system
- ✅ Pure, testable TypeScript functions
- ✅ Comprehensive JSDoc documentation
- ✅ Type-safe with full TypeScript support
- ✅ Zero dependencies (except Zod for validation)
- ✅ MIT Licensed

## Calculations Included

1. **Timezone Conversion** - UTC → Regional time with decimal offsets
2. **Date Range / Day Window** - 7-day cap calculation
3. **Invoice Grouping Key** - Unique key generation for invoice grouping
4. **Unit Selling Price** - Always positive price calculation
5. **Inventory Transaction Quantity** - Always negative for Oracle
6. **Transaction Type Logic** - Sales Issue vs RMA determination
7. **Bank Charge Calculation** - Payment processor fees
8. **Debit Card Cap** - Regional transaction limits (Oman: 10 OMR)
9. **Conversion Rate Type** - Corporate vs User rate
10. **Journal Entry Charges** - Fixed vs percentage charges
11. **Cash Account Selection** - Region-based account mapping
12. **Discount Item Quantity Override** - Force discount to quantity=1
13. **Receipt Amount Net** - Gross minus charges
14. **Period Name Formatting** - MMM-yy format for Oracle GL
15. **Message Truncation** - 500 character limit
16. **Rounding Retry Logic** - 50 attempts with -0.01 adjustment

## Usage Example

```typescript
import {
  convertToRegionalTime,
  generateInvoiceGroupingKey,
  calculateUnitSellingPrice,
  applyRoundingRetry
} from '@vyrooq/integration-core';

// Convert UTC to regional time (Oman: UTC+3:30)
const regionalDate = convertToRegionalTime(
  new Date('2024-01-15T07:00:00Z'),
  3.5
);
console.log(regionalDate); // 2024-01-15 10:30

// Generate invoice grouping key
const key = generateInvoiceGroupingKey(
  new Date('2024-01-15'),
  'NORMAL',
  false
);
console.log(key); // "15-0-2024NORMAL"

// Calculate unit price (always positive)
const unitPrice = calculateUnitSellingPrice(-200, 2);
console.log(unitPrice); // 100

// Apply rounding retry for Oracle Fusion
const adjusted = applyRoundingRetry(100.00, 3);
console.log(adjusted); // 99.97
```

## Configuration Types

```typescript
import { OutletConfig, RegionConfig } from '@vyrooq/integration-core';

const outlet: OutletConfig = {
  outletCode: 'STORE01',
  outletName: 'Main Store',
  region: 'OM',
  timezone: 3.5,
  cashAccount: '1010.000.0000.0000',
  organizationName: 'Oman Operations'
};

const region: RegionConfig = {
  regionCode: 'OM',
  regionName: 'Oman',
  defaultTimezone: 3.5,
  currency: 'OMR',
  debitCardCap: 10
};
```

## Testing

```bash
npm test
```

## Building

```bash
npm run build
```

## License

MIT
