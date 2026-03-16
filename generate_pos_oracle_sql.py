import requests
import json
import time
import os
from datetime import datetime

def fetch_all_pos_orders(api_key, base_url, start_date, end_date, company_id=1, batch_size=100):
    """
    Fetch ALL POS orders without filtering
    """
    headers = {
        "x-api-key": api_key,
        "Accept": "application/json"
    }
    
    all_orders = []
    page = 1
    total_expected = None
    seen_order_ids = set()  # Track unique order IDs globally
    
    print("=" * 70)
    print("🔍 FETCHING ALL POS ORDERS")
    print("=" * 70)
    print(f"📅 Date Range: {start_date} to {end_date}")
    print(f"🏢 Company ID: {company_id}")
    
    while True:
        offset = (page - 1) * batch_size
        url = f"{base_url}?company_id={company_id}&limit={batch_size}&start_date={start_date}&end_date={end_date}&offset={offset}"
        
        print(f"\n📥 Fetching page {page} (offset: {offset})...")
        
        try:
            response = requests.get(url, headers=headers)
            response.raise_for_status()
            data = response.json()
            
            if page == 1:
                total_expected = data.get('total', 0)
                print(f"📊 Total orders in system: {total_expected:,}")
            
            results = data.get('results', [])
            if not results:
                print("   ✓ No more results")
                break
                
            # Filter out duplicates at fetch time
            unique_results = []
            for order_data in results:
                order = order_data.get('order', {})
                order_id = order.get('order_id')
                
                if order_id and order_id not in seen_order_ids:
                    seen_order_ids.add(order_id)
                    unique_results.append(order_data)
                elif not order_id:
                    # If no order_id, still add but warn
                    print(f"⚠️ Warning: Order without ID found")
                    unique_results.append(order_data)
            
            print(f"   ✓ Got {len(results)} orders on this page, {len(unique_results)} unique")
            all_orders.extend(unique_results)
            
            # Check if we need to continue
            if len(results) < batch_size:
                print(f"\n✅ Last page reached")
                break
            if total_expected and offset + len(results) >= total_expected:
                print(f"\n✅ Fetched all {total_expected} orders")
                break
                
            page += 1
            time.sleep(0.5)  # Be nice to the API
            
        except Exception as e:
            print(f"❌ Error on page {page}: {e}")
            if hasattr(e, 'response') and e.response:
                print(f"   Response: {e.response.text[:200]}")
            break
    
    print(f"\n✅ Total orders fetched: {len(all_orders)} (after removing duplicates)")
    return all_orders

def filter_orders_by_pos(orders, target_pos_name):
    """
    Filter orders by POS name - with additional duplicate prevention
    """
    filtered = []
    seen_order_ids = set()  # Track unique order IDs
    pos_counts = {}  # For debugging
    
    for order_data in orders:
        order = order_data.get('order', {})
        pos_name = order.get('pos_name', '')
        order_id = order.get('order_id', '')
        
        # Count all POS names for debugging
        pos_name_str = str(pos_name) if pos_name else 'None'
        pos_counts[pos_name_str] = pos_counts.get(pos_name_str, 0) + 1
        
        # Check if this is a target POS and order_id is not already seen
        if pos_name and str(pos_name).strip() == target_pos_name:
            if order_id and order_id not in seen_order_ids:
                seen_order_ids.add(order_id)
                filtered.append(order_data)
            elif not order_id:
                # If no order_id, still add but warn
                print(f"⚠️ Warning: Order without ID found for POS {target_pos_name}")
                filtered.append(order_data)
    
    # Debug: Show all unique POS names found
    print("\n📊 POS Names found in data:")
    for pos, count in sorted(pos_counts.items())[:20]:  # Show first 20
        print(f"   - '{pos}': {count} orders")
    
    print(f"\n📊 Unique orders for '{target_pos_name}': {len(filtered)} (after filtering)")
    
    return filtered

def format_oracle_date(date_str):
    """Format date string to Oracle to_date function"""
    if not date_str:
        return 'NULL'
    try:
        # Parse the date string (assuming format like '2026-02-27 21:51:01')
        if 'T' in date_str:
            date_str = date_str.replace('T', ' ')
        if '.' in date_str:
            date_str = date_str.split('.')[0]
        
        dt = datetime.strptime(date_str, '%Y-%m-%d %H:%M:%S')
        # Format as to_date('27-02-26','DD-MM-RR')
        return f"to_date('{dt.strftime('%d-%m-%y')}','DD-MM-RR')"
    except:
        return f"to_date('{date_str}','DD-MM-RR')"

def format_oracle_value(value):
    """Format a value for Oracle SQL INSERT statement"""
    if value is None or value == '':
        return 'NULL'
    if value is False:
        return "'false'"
    if isinstance(value, (int, float)):
        return str(value)
    if isinstance(value, str) and value == 'false':
        return "'false'"
    # Escape single quotes for Oracle (use two single quotes)
    escaped = str(value).replace("'", "''")
    return f"'{escaped}'"

def generate_oracle_insert_sql(
    row_number, h_order_id, h_name_order, h_amount_paid, h_amount_tax, h_company_name,
    h_pos_name, h_branch_id, h_branch_name, h_date_order, h_customer_name, h_session_id,
    h_session_name, l_order_line_id, l_product_name, l_product_barcode, l_name_prd,
    l_price_subtotal_without_tax, l_price_subtotal_with_tax, l_price_unit, l_product_id, l_qty,
    p_id_payment, p_pos_order_id, p_pos_order, p_amount, p_currency, p_currency_id,
    p_payment_method, p_session_id, p_session_name, date_created, batch_id, status, message, h_receipt_number
):
    """Generate a single Oracle SQL INSERT statement"""
    
    # Format h_date_order as Oracle to_date if it's a date string
    if h_date_order and isinstance(h_date_order, str) and ' ' in h_date_order and 'to_date' not in h_date_order:
        h_date_order = format_oracle_date(h_date_order)
    
    sql = f"""INSERT INTO ODOO_ORDERS_RAW_DATA_MISSING (
    M_ROW_NUMBER, H_ORDER_ID, H_NAME_ORDER, H_AMOUNT_PAID, H_AMOUNT_TAX, H_COMPANY_NAME,
    H_POS_NAME, H_BRANCH_ID, H_BRANCH_NAME, H_DATE_ORDER, H_CUSTOMER_NAME, H_SESSION_ID,
    H_SESSION_NAME, L_ORDER_LINE_ID, L_PRODUCT_NAME, L_PRODUCT_BARCODE, L_NAME_PRD,
    L_PRICE_SUBTOTAL_WITHOUT_TAX, L_PRICE_SUBTOTAL_WITH_TAX, L_PRICE_UNIT, L_PRODUCT_ID, L_QTY,
    P_ID_PAYMENT, P_POS_ORDER_ID, P_POS_ORDER, P_AMOUNT, P_CURRENCY, P_CURRENCY_ID,
    P_PAYMENT_METHOD, DATE_CREATED, BATCH_ID, STATUS, MESSAGE, H_RECEIPT_NUMBER
) VALUES (
    {format_oracle_value(row_number)}, 
    {format_oracle_value(h_order_id)}, 
    {format_oracle_value(h_name_order)},
    {format_oracle_value(h_amount_paid)}, 
    {format_oracle_value(h_amount_tax)}, 
    {format_oracle_value(h_company_name)},
    {format_oracle_value(h_pos_name)}, 
    {format_oracle_value(h_branch_id)}, 
    {format_oracle_value(h_branch_name)},
    {h_date_order if h_date_order and 'to_date' in str(h_date_order) else format_oracle_value(h_date_order)}, 
    {format_oracle_value(h_customer_name)}, 
    {format_oracle_value(h_session_id)},
    {format_oracle_value(h_session_name)}, 
    {format_oracle_value(l_order_line_id)}, 
    {format_oracle_value(l_product_name)},
    {format_oracle_value(l_product_barcode)}, 
    {format_oracle_value(l_name_prd)}, 
    {format_oracle_value(l_price_subtotal_without_tax)},
    {format_oracle_value(l_price_subtotal_with_tax)}, 
    {format_oracle_value(l_price_unit)}, 
    {format_oracle_value(l_product_id)},
    {format_oracle_value(l_qty)}, 
    {format_oracle_value(p_id_payment)}, 
    {format_oracle_value(p_pos_order_id)},
    {format_oracle_value(p_pos_order)}, 
    {format_oracle_value(p_amount)}, 
    {format_oracle_value(p_currency)},
    {format_oracle_value(p_currency_id)}, 
    {format_oracle_value(p_payment_method)},
    {date_created if date_created and 'to_date' in str(date_created) else format_oracle_date(date_created)}, 
    {format_oracle_value(batch_id)}, 
    {format_oracle_value(status)},
    {format_oracle_value(message)}, 
    {format_oracle_value(h_receipt_number)}
);"""
    
    return sql

def generate_oracle_sql_for_pos(orders, target_pos_name, batch_id):
    """
    Generate Oracle SQL INSERT statements for filtered orders
    Each order gets a unique M_ROW_NUMBER that is used for all its rows
    """
    sql_statements = []
    row_number = 10000  # Start from 10000 like in your sample
    
    print(f"\n🔧 Generating SQL for {len(orders)} unique {target_pos_name} orders...")
    
    # Add REM INSERTING and SET DEFINE OFF at the beginning
    sql_statements.append("REM INSERTING into ODOO_ORDERS_RAW_DATA_MISSING")
    sql_statements.append("SET DEFINE OFF;")
    
    # Track processed orders to ensure we don't process duplicates
    processed_order_ids = set()
    # GLOBAL tracking sets for line items and payments across ALL orders
    processed_line_ids = set()
    processed_payment_ids = set()

    total_headers = 0
    total_lines = 0
    total_payments = 0
    skipped_duplicate_lines = 0
    skipped_duplicate_payments = 0
    
    for order_idx, order_data in enumerate(orders):
        order = order_data.get('order', {})
        
        # Extract order fields
        order_id = order.get('order_id', '')
        
        # Skip if no order_id or already processed
        if not order_id:
            print(f"⚠️ Warning: Skipping order with no ID at index {order_idx}")
            continue
        
        if order_id in processed_order_ids:
            print(f"⚠️ Warning: Duplicate order {order_id} skipped")
            continue
        
        processed_order_ids.add(order_id)
        
        # Convert order_id to string for string operations
        order_id_str = str(order_id)
        
        # Generate receipt number in the format from sample: 'طلب 30674-005-0122'
        session_id = order.get('session_id', '')
        receipt_number = order.get('receipt_number', '')
        
        # If receipt_number is not provided, generate one in the sample format
        if not receipt_number and order_id:
            # Get last 4 digits of order_id or use default
            order_suffix = order_id_str[-4:] if len(order_id_str) >= 4 else order_id_str.zfill(4)
            receipt_number = f"Order {session_id}-001-{order_suffix}"
        
        amount_paid = order.get('amount_paid', '')
        amount_tax = order.get('amount_tax', '')
        company_name = order.get('company_name', 'شركة ساره محمد الراجحي التجارية')
        pos_name = order.get('pos_name', target_pos_name)
        branch_id = order.get('branch_id', '')
        branch_name = order.get('branch_name', target_pos_name)
        date_order = order.get('date_order', '')
        customer_name = order.get('customer_name', None) if order.get('customer_name') else None
        session_id = order.get('session_id', '')
        session_name = order.get('session_name', f"POS/{session_id}")
        
        # Format date for Oracle
        formatted_date = format_oracle_date(date_order)
        current_date = format_oracle_date(datetime.now().strftime('%Y-%m-%d'))
        
        # Handle branch_name being false
        if branch_name is False or branch_name == 'false':
            branch_name = target_pos_name
        
        # Handle branch_id being false
        if branch_id is False or branch_id == 'false':
            branch_id = None
        
        # Format the order name
        formatted_order_name = f"{branch_name}/{order_id}" if branch_name else f"{target_pos_name}/{order_id}"
        
        # Calculate totals from lines if not provided
        if (not amount_paid or amount_paid == '') and order_data.get('order_lines'):
            total = 0.0
            for line in order_data.get('order_lines', []):
                try:
                    line_total = float(line.get('price_subtotal_with_tax', 0) or 0)
                    total += line_total
                except (ValueError, TypeError):
                    pass
            amount_paid = total
        
        # 1. Create HEADER row - Only H_* fields populated, L_* and P_* are NULL
        if order_id:
            header_sql = generate_oracle_insert_sql(
                row_number=row_number,  # Same for all rows in this order
                h_order_id=order_id,
                h_name_order=formatted_order_name,
                h_amount_paid=amount_paid,
                h_amount_tax=amount_tax,
                h_company_name=company_name,
                h_pos_name=pos_name,
                h_branch_id=branch_id,
                h_branch_name=branch_name,
                h_date_order=date_order,
                h_customer_name=customer_name,
                h_session_id=session_id,
                h_session_name=session_name,
                l_order_line_id=None,
                l_product_name=None,
                l_product_barcode=None,
                l_name_prd=None,
                l_price_subtotal_without_tax=None,
                l_price_subtotal_with_tax=None,
                l_price_unit=None,
                l_product_id=None,
                l_qty=None,
                p_id_payment=None,
                p_pos_order_id=order_id,
                p_pos_order=formatted_order_name,
                p_amount=None,
                p_currency=None,
                p_currency_id=None,
                p_payment_method=None,
                p_session_id=None,
                p_session_name=None,
                date_created=current_date,
                batch_id=batch_id,
                status="Success",
                message=None,
                h_receipt_number=receipt_number
            )
            sql_statements.append(header_sql)
            total_headers += 1
        
        # 2. Create LINE rows - Only L_* fields populated, H_* and P_* are NULL
        # Uses GLOBAL processed_line_ids to prevent duplicates across all orders
        for line in order_data.get('order_lines', []):
            order_line_id = line.get('order_line_id', '')
            
            # Skip if this line item has already been processed globally (duplicate prevention)
            if order_line_id:
                if order_line_id in processed_line_ids:
                    print(f"⚠️ Warning: Duplicate line item {order_line_id} - skipping")
                    skipped_duplicate_lines += 1
                    continue
                processed_line_ids.add(order_line_id)
            
            product_name = line.get('product_name', '')
            product_barcode = line.get('product_barcode', '')
            name_prd = line.get('name', f"{branch_name}/{line.get('product_id', '4534')}")
            price_without_tax = line.get('price_subtotal_without_tax', '')
            price_with_tax = line.get('price_subtotal_with_tax', '')
            price_unit = line.get('price_unit', price_without_tax)
            product_id = line.get('product_id', '')
            qty = line.get('qty', '1.0')
            
            # Handle discount items (negative amounts)
            try:
                if float(qty or 0) < 0 or float(price_with_tax or 0) < 0:
                    product_name = "100% on your order"
                    product_barcode = "false"
            except (ValueError, TypeError):
                pass
            
            line_sql = generate_oracle_insert_sql(
                row_number=row_number,  # Same as header row number
                h_order_id=None,  # NULL for line items
                h_name_order=None,
                h_amount_paid=None,
                h_amount_tax=None,
                h_company_name=None,
                h_pos_name=None,
                h_branch_id=None,
                h_branch_name=None,
                h_date_order=None,
                h_customer_name=None,
                h_session_id=None,
                h_session_name=None,
                l_order_line_id=order_line_id,
                l_product_name=product_name,
                l_product_barcode=product_barcode,
                l_name_prd=name_prd,
                l_price_subtotal_without_tax=price_without_tax,
                l_price_subtotal_with_tax=price_with_tax,
                l_price_unit=price_unit,
                l_product_id=product_id,
                l_qty=qty,
                p_id_payment=None,
                p_pos_order_id=None,
                p_pos_order=None,
                p_amount=None,
                p_currency=None,
                p_currency_id=None,
                p_payment_method=None,
                p_session_id=None,
                p_session_name=None,
                date_created=current_date,
                batch_id=batch_id,
                status="Success",
                message=None,
                h_receipt_number=receipt_number
            )
            sql_statements.append(line_sql)
            total_lines += 1
        
        # 3. Create PAYMENT rows - Only P_* fields populated, H_* and L_* are NULL
        # Uses GLOBAL processed_payment_ids to prevent duplicates across all orders
        for payment in order_data.get('order_payment_lines', []):
            payment_id = payment.get('id', '')
            
            # Skip if this payment has already been processed globally (duplicate prevention)
            if payment_id:
                if payment_id in processed_payment_ids:
                    print(f"⚠️ Warning: Duplicate payment {payment_id} - skipping")
                    skipped_duplicate_payments += 1
                    continue
                processed_payment_ids.add(payment_id)
            
            # Get payment details with defaults matching sample
            payment_amount = payment.get('amount', '')
            payment_currency = payment.get('currency', 'SAR')
            payment_currency_id = payment.get('currency_id', '150')
            payment_method = payment.get('payment_method', '')
            
            # Use session info from payment or fallback to order
            payment_session_id = payment.get('session_id', session_id)
            payment_session_name = payment.get('session_name', session_name)
            
            payment_sql = generate_oracle_insert_sql(
                row_number=row_number,  # Same as header row number
                h_order_id=None,  # NULL for payment rows
                h_name_order=None,
                h_amount_paid=None,
                h_amount_tax=None,
                h_company_name=None,
                h_pos_name=None,
                h_branch_id=None,
                h_branch_name=None,
                h_date_order=None,
                h_customer_name=None,
                h_session_id=None,
                h_session_name=None,
                l_order_line_id=None,
                l_product_name=None,
                l_product_barcode=None,
                l_name_prd=None,
                l_price_subtotal_without_tax=None,
                l_price_subtotal_with_tax=None,
                l_price_unit=None,
                l_product_id=None,
                l_qty=None,
                p_id_payment=payment_id,
                p_pos_order_id=order_id,
                p_pos_order=formatted_order_name,
                p_amount=payment_amount,
                p_currency=payment_currency,
                p_currency_id=payment_currency_id,
                p_payment_method=payment_method,
                p_session_id=payment_session_id,
                p_session_name=payment_session_name,
                date_created=current_date,
                batch_id=batch_id,
                status="Success",
                message=None,
                h_receipt_number=receipt_number
            )
            sql_statements.append(payment_sql)
            total_payments += 1
        
        row_number += 1
    
    print(f"\n📊 Generated SQL breakdown:")
    print(f"   Headers: {total_headers}")
    print(f"   Line Items: {total_lines} (skipped {skipped_duplicate_lines} duplicates)")
    print(f"   Payments: {total_payments} (skipped {skipped_duplicate_payments} duplicates)")
    print(f"   Total: {total_headers + total_lines + total_payments} rows (+2 for REM/SET DEFINE = {len(sql_statements)})")
    
    return sql_statements, total_headers + total_lines + total_payments

def write_oracle_sql_to_file(sql_statements, filename, target_pos, total_orders):
    """Write Oracle SQL statements to file with proper formatting"""
    with open(filename, 'w', encoding='utf-8') as f:
        f.write("-- ===================================================\n")
        f.write("-- GENERATED POS ORDERS - ORACLE SQL INSERT STATEMENTS\n")
        f.write("-- ===================================================\n")
        f.write(f"-- Generation Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n")
        f.write(f"-- Target POS: {target_pos}\n")
        f.write(f"-- Total Orders: {total_orders}\n")
        f.write(f"-- Total Rows: {len(sql_statements)-2}\n")  # Subtract header lines
        f.write("-- ===================================================\n\n")
        
        f.write("-- First, clear existing data for these orders (optional)\n")
        f.write(f"-- DELETE FROM ODOO_ORDERS_RAW_DATA_MISSING WHERE H_POS_NAME = '{target_pos}';\n\n")
        
        # Write statements
        for i, sql in enumerate(sql_statements):
            f.write(sql + "\n")
            
            # Add a separator between different orders (every ~10 statements)
            if (i + 1) % 10 == 0:
                f.write("-- ------------------------------------------------\n")
        
        f.write(f"\n-- Total rows inserted for {target_pos}: {len(sql_statements)-2}\n")
        f.write("-- COMMIT; -- Uncomment to commit the transaction\n")

# Configuration
API_KEY = "8c7a7a58a32e4a11313dd6d54046ce7f6bbed40f"
BASE_URL = "https://matchperfume.odoo.com/api/pos/order"
COMPANY_ID = 1
START_DATE = "2026-02-27T21:00:00"
END_DATE = "2026-02-28T20:59:59"
TARGET_POS = "HADARTAW3"  # Filter for this POS name only
BATCH_SIZE = 1000

if __name__ == "__main__":
    try:
        print("=" * 70)
        print("🚀 STARTING POS ORDERS PROCESSING")
        print("=" * 70)
        
        # Step 1: Fetch ALL orders with duplicate prevention at fetch time
        all_orders = fetch_all_pos_orders(
            API_KEY, BASE_URL, START_DATE, END_DATE, COMPANY_ID, BATCH_SIZE
        )
        
        if not all_orders:
            print("❌ No orders found")
            exit()
        
        # Step 2: Filter for target POS with additional duplicate prevention
        print(f"\n🔍 Filtering orders for POS: '{TARGET_POS}'")
        filtered_orders = filter_orders_by_pos(all_orders, TARGET_POS)
        
        if not filtered_orders:
            print(f"❌ No orders found for POS: '{TARGET_POS}'")
            exit()
        
        # Step 3: Generate batch ID
        batch_id = int(datetime.now().strftime("%Y%m%d"))
        
        # Step 4: Generate SQL statements with duplicate prevention
        sql_statements, total_rows = generate_oracle_sql_for_pos(filtered_orders, TARGET_POS, batch_id)
        
        print(f"\n✅ Generated {len(sql_statements)} SQL statements")
        print(f"   Total data rows: {total_rows}")
        
        # Step 5: Write to file
        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        filename = f"ODOO_ORDERS_RAW_DATA_MISSING_{TARGET_POS}_{timestamp}.sql"
        
        print(f"\n💾 Saving to {filename}...")
        write_oracle_sql_to_file(sql_statements, filename, TARGET_POS, len(filtered_orders))
        
        # Get file size
        file_size = os.path.getsize(filename) / 1024
        print(f"\n✅ Oracle SQL generation complete!")
        print(f"   File: {filename}")
        print(f"   Size: {file_size:.2f} KB")
        print(f"   Orders processed: {len(filtered_orders)}")
        print(f"   SQL statements: {len(sql_statements)}")
        
        # Show sample of generated SQL
        if len(sql_statements) > 5:
            print(f"\n📋 Sample of generated SQL:")
            print(sql_statements[0])  # REM INSERTING
            print(sql_statements[1])  # SET DEFINE OFF
            print(sql_statements[2])  # First header
            if len(sql_statements) > 3:
                print(sql_statements[3])  # First line item
        
        print("=" * 70)
        
    except Exception as e:
        print(f"\n❌ Error: {e}")
        import traceback
        traceback.print_exc()
