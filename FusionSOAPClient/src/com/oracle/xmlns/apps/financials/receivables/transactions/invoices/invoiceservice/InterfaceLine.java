
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;
import com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactioninterfacegdf.TransactionInterfaceGdf;
import com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactionlineinterfacegdf.TransactionLineInterfaceGdf;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioninterfaceheaderdff.TransactionInterfaceHeaderFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioninterfacelinktodff.InterfaceLineLinkToFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioninterfacereferencedff.InterfaceLineReferenceFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionlinedff.TransactionLineFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionlineinterfacelinedff.TransactionInterfaceLineFLEX;


/**
 * <p>Java class for InterfaceLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterfaceLine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AccountingRuleDuration" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AccountingRuleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AccountingRuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressVerificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="AmountIncludesTax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AssessableValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ApprovalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationComplete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesOrderSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerTrxTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillContactPartyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillCustomerAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillCustomerSiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsBillingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContractId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ContractLineId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SalesOrder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesOrderDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="SalesOrderLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesOrderRevision" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TrxDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConversionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConversionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CreditMethodForAccountRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditMethodForInstallments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerTrxTypeSequenceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CustomerBankAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultTaxationCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeferralExclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DocumentSubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExceptionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ExemptionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FinalDischargeLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FinalDischargeLocationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FirstPtyRegId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FirstPtyRegNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FOBPoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GlDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="IntendedUseClassifId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InternalNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InventoryItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InvoicedLineAcctgLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoicingRuleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InvoicingRuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastPeriodToCredit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LastTrxDebitAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegalEntityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LineIntendedUse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LineType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemoLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemoLineSequenceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipPartyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipPartyReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipPartySiteId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipPartySiteReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipPtyContactId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipPtyContactReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemSoldPartyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemSoldPartyReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemBatchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemBillAddressId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemBillAddressReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemBillContactId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemBillContactReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemBillCustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemBillCustomerReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipAddressId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipAddressReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipContactId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipContactReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipCustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemShipCustomerReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigSystemSoldCustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrigSystemSoldCustomerReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OverrideAutoAccounting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentAttributes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentServerOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentSetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PaymentTrxnExtensionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PrimarySalesrepNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrintingOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProdFcCategId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProductCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductFiscClassification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaseOrder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaseOrderDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="PurchaseOrderRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="QuantityOrdered" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReasonCodeMeaning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptMethodId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReceiptMethodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceLineId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="RelatedBatchSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelatedTrxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResetTrxDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResourceSalesrepId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ContractStartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ContractEndDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="RuleEndDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="RuleStartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="SalesTaxId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SetOfBooksId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ShipContactPartyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipCustomerAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipCustomerSiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipDateActual" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ShipVia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SoldCustomerAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceApplicationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SourceEntityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceEventClassCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceTrxDetailTaxLineId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SourceTrxId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SourceTrxLineId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SourceTrxLineType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxExempt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxExemptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxExemptReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxExemptReasonCodeMeaning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxInvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="TaxInvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxJurisdictionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxPrecedence" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TaxRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TaxRateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxRegimeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxableAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="Taxable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentTermsId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PaymentTermsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ThirdPtyRegId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ThirdPtyRegNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TranslatedDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrxBusinessCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitSellingPrice" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="UnitStandardPrice" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="UOMCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UOMName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserDefinedFiscClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VATTaxId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="WarehouseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WarehouseId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="WaybillNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecurringBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Periodicity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondInvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ContractedPeriods" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FirstOverridePeriod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FirstOverrideAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="FirstOverrideQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="SecondOverridePeriod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SecondOverrideAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="SecondOverrideQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="ThirdOverridePeriod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ThirdOverrideAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="ThirdOverrideQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="FourthOverridePeriod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FourthOverrideAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="FourthOverrideQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="FifthOverridePeriod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FifthOverrideAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="FifthOverrideQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="SecondBillingPeriodStartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ContractLineAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="ContractLineQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="ContractLineUnitPrice" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="EnforceSequenceDateCorrelation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceGdf" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/}TransactionInterfaceGdf" minOccurs="0"/>
 *         &lt;element name="TransactionLineInterfaceGdf" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/}TransactionLineInterfaceGdf" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceLineDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/}TransactionInterfaceLineFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceLinkToDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceLinkToDff/}InterfaceLineLinkToFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceReferenceDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceReferenceDff/}InterfaceLineReferenceFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionLineDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineDff/}TransactionLineFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceHeaderDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/}TransactionInterfaceHeaderFLEX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterfaceLine", propOrder = {
    "orgId",
    "accountingRuleDuration",
    "accountingRuleId",
    "accountingRuleName",
    "addressVerificationCode",
    "amount",
    "amountIncludesTax",
    "applicationId",
    "assessableValue",
    "approvalCode",
    "authorizationComplete",
    "authorizationNumber",
    "salesOrderSource",
    "batchSourceName",
    "customerTrxTypeName",
    "billContactPartyNumber",
    "billCustomerAccountNumber",
    "billCustomerSiteNumber",
    "billingDate",
    "comments",
    "consBillingNumber",
    "contractId",
    "contractLineId",
    "salesOrder",
    "salesOrderDate",
    "salesOrderLine",
    "salesOrderRevision",
    "trxDate",
    "currencyCode",
    "conversionType",
    "conversionDate",
    "conversionRate",
    "creditMethodForAccountRule",
    "creditMethodForInstallments",
    "customerTrxTypeSequenceId",
    "customerBankAccountName",
    "defaultTaxationCountry",
    "deferralExclusion",
    "description",
    "documentNumber",
    "documentSubType",
    "exceptionId",
    "exemptionId",
    "finalDischargeLocationCode",
    "finalDischargeLocationId",
    "firstPtyRegId",
    "firstPtyRegNumber",
    "fobPoint",
    "glDate",
    "intendedUseClassifId",
    "internalNotes",
    "itemNumber",
    "inventoryItemId",
    "invoicedLineAcctgLevel",
    "invoicingRuleId",
    "invoicingRuleName",
    "lastPeriodToCredit",
    "lastTrxDebitAuth",
    "legalEntityId",
    "lineIntendedUse",
    "lineType",
    "memoLineName",
    "memoLineSequenceId",
    "origSystemShipPartyId",
    "origSystemShipPartyReference",
    "origSystemShipPartySiteId",
    "origSystemShipPartySiteReference",
    "origSystemShipPtyContactId",
    "origSystemShipPtyContactReference",
    "origSystemSoldPartyId",
    "origSystemSoldPartyReference",
    "origSystemBatchName",
    "origSystemBillAddressId",
    "origSystemBillAddressReference",
    "origSystemBillContactId",
    "origSystemBillContactReference",
    "origSystemBillCustomerId",
    "origSystemBillCustomerReference",
    "origSystemShipAddressId",
    "origSystemShipAddressReference",
    "origSystemShipContactId",
    "origSystemShipContactReference",
    "origSystemShipCustomerId",
    "origSystemShipCustomerReference",
    "origSystemSoldCustomerId",
    "origSystemSoldCustomerReference",
    "overrideAutoAccounting",
    "paymentAttributes",
    "paymentServerOrderNumber",
    "paymentSetId",
    "paymentTrxnExtensionId",
    "primarySalesrepNumber",
    "printingOption",
    "prodFcCategId",
    "productCategory",
    "productFiscClassification",
    "productType",
    "purchaseOrder",
    "purchaseOrderDate",
    "purchaseOrderRevision",
    "quantity",
    "quantityOrdered",
    "reasonCode",
    "reasonCodeMeaning",
    "receiptMethodId",
    "receiptMethodName",
    "referenceLineId",
    "relatedBatchSourceName",
    "relatedTrxNumber",
    "resetTrxDate",
    "resourceSalesrepId",
    "contractStartDate",
    "contractEndDate",
    "ruleEndDate",
    "ruleStartDate",
    "salesTaxId",
    "setOfBooksId",
    "shipContactPartyNumber",
    "shipCustomerAccountNumber",
    "shipCustomerSiteNumber",
    "shipDateActual",
    "shipVia",
    "soldCustomerAccountNumber",
    "sourceApplicationId",
    "sourceEntityCode",
    "sourceEventClassCode",
    "sourceTrxDetailTaxLineId",
    "sourceTrxId",
    "sourceTrxLineId",
    "sourceTrxLineType",
    "tax",
    "taxCode",
    "taxExempt",
    "taxExemptNumber",
    "taxExemptReasonCode",
    "taxExemptReasonCodeMeaning",
    "taxInvoiceDate",
    "taxInvoiceNumber",
    "taxJurisdictionCode",
    "taxPrecedence",
    "taxRate",
    "taxRateCode",
    "taxRegimeCode",
    "taxStatusCode",
    "taxableAmount",
    "taxable",
    "paymentTermsId",
    "paymentTermsName",
    "thirdPtyRegId",
    "thirdPtyRegNumber",
    "translatedDescription",
    "trxBusinessCategory",
    "trxNumber",
    "unitSellingPrice",
    "unitStandardPrice",
    "uomCode",
    "uomName",
    "userDefinedFiscClass",
    "vatTaxId",
    "warehouseCode",
    "warehouseId",
    "waybillNumber",
    "recurringBill",
    "periodicity",
    "secondInvoiceDate",
    "contractedPeriods",
    "firstOverridePeriod",
    "firstOverrideAmount",
    "firstOverrideQuantity",
    "secondOverridePeriod",
    "secondOverrideAmount",
    "secondOverrideQuantity",
    "thirdOverridePeriod",
    "thirdOverrideAmount",
    "thirdOverrideQuantity",
    "fourthOverridePeriod",
    "fourthOverrideAmount",
    "fourthOverrideQuantity",
    "fifthOverridePeriod",
    "fifthOverrideAmount",
    "fifthOverrideQuantity",
    "secondBillingPeriodStartDate",
    "contractLineAmount",
    "contractLineQuantity",
    "contractLineUnitPrice",
    "enforceSequenceDateCorrelation",
    "transactionInterfaceGdf",
    "transactionLineInterfaceGdf",
    "transactionInterfaceLineDff",
    "transactionInterfaceLinkToDff",
    "transactionInterfaceReferenceDff",
    "transactionLineDff",
    "transactionInterfaceHeaderDff"
})
public class InterfaceLine {

    @XmlElement(name = "OrgId")
    protected Long orgId;
    @XmlElementRef(name = "AccountingRuleDuration", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> accountingRuleDuration;
    @XmlElementRef(name = "AccountingRuleId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> accountingRuleId;
    @XmlElementRef(name = "AccountingRuleName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountingRuleName;
    @XmlElementRef(name = "AddressVerificationCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressVerificationCode;
    @XmlElementRef(name = "Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> amount;
    @XmlElementRef(name = "AmountIncludesTax", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> amountIncludesTax;
    @XmlElementRef(name = "ApplicationId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> applicationId;
    @XmlElementRef(name = "AssessableValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> assessableValue;
    @XmlElementRef(name = "ApprovalCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> approvalCode;
    @XmlElementRef(name = "AuthorizationComplete", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> authorizationComplete;
    @XmlElementRef(name = "AuthorizationNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> authorizationNumber;
    @XmlElementRef(name = "SalesOrderSource", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesOrderSource;
    @XmlElement(name = "BatchSourceName")
    protected String batchSourceName;
    @XmlElementRef(name = "CustomerTrxTypeName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerTrxTypeName;
    @XmlElementRef(name = "BillContactPartyNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billContactPartyNumber;
    @XmlElementRef(name = "BillCustomerAccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billCustomerAccountNumber;
    @XmlElementRef(name = "BillCustomerSiteNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billCustomerSiteNumber;
    @XmlElementRef(name = "BillingDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> billingDate;
    @XmlElementRef(name = "Comments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "ConsBillingNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consBillingNumber;
    @XmlElementRef(name = "ContractId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> contractId;
    @XmlElementRef(name = "ContractLineId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> contractLineId;
    @XmlElementRef(name = "SalesOrder", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesOrder;
    @XmlElementRef(name = "SalesOrderDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> salesOrderDate;
    @XmlElementRef(name = "SalesOrderLine", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesOrderLine;
    @XmlElementRef(name = "SalesOrderRevision", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> salesOrderRevision;
    @XmlElementRef(name = "TrxDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> trxDate;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "ConversionType")
    protected String conversionType;
    @XmlElementRef(name = "ConversionDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> conversionDate;
    @XmlElementRef(name = "ConversionRate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> conversionRate;
    @XmlElementRef(name = "CreditMethodForAccountRule", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditMethodForAccountRule;
    @XmlElementRef(name = "CreditMethodForInstallments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditMethodForInstallments;
    @XmlElementRef(name = "CustomerTrxTypeSequenceId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> customerTrxTypeSequenceId;
    @XmlElementRef(name = "CustomerBankAccountName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerBankAccountName;
    @XmlElementRef(name = "DefaultTaxationCountry", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultTaxationCountry;
    @XmlElementRef(name = "DeferralExclusion", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deferralExclusion;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElementRef(name = "DocumentNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> documentNumber;
    @XmlElementRef(name = "DocumentSubType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentSubType;
    @XmlElementRef(name = "ExceptionId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> exceptionId;
    @XmlElementRef(name = "ExemptionId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> exemptionId;
    @XmlElementRef(name = "FinalDischargeLocationCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> finalDischargeLocationCode;
    @XmlElementRef(name = "FinalDischargeLocationId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> finalDischargeLocationId;
    @XmlElementRef(name = "FirstPtyRegId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> firstPtyRegId;
    @XmlElementRef(name = "FirstPtyRegNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstPtyRegNumber;
    @XmlElementRef(name = "FOBPoint", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fobPoint;
    @XmlElementRef(name = "GlDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> glDate;
    @XmlElementRef(name = "IntendedUseClassifId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> intendedUseClassifId;
    @XmlElementRef(name = "InternalNotes", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> internalNotes;
    @XmlElementRef(name = "ItemNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemNumber;
    @XmlElementRef(name = "InventoryItemId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> inventoryItemId;
    @XmlElementRef(name = "InvoicedLineAcctgLevel", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoicedLineAcctgLevel;
    @XmlElementRef(name = "InvoicingRuleId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> invoicingRuleId;
    @XmlElementRef(name = "InvoicingRuleName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoicingRuleName;
    @XmlElementRef(name = "LastPeriodToCredit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> lastPeriodToCredit;
    @XmlElementRef(name = "LastTrxDebitAuth", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastTrxDebitAuth;
    @XmlElementRef(name = "LegalEntityId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> legalEntityId;
    @XmlElementRef(name = "LineIntendedUse", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lineIntendedUse;
    @XmlElement(name = "LineType")
    protected String lineType;
    @XmlElementRef(name = "MemoLineName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> memoLineName;
    @XmlElementRef(name = "MemoLineSequenceId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> memoLineSequenceId;
    @XmlElementRef(name = "OrigSystemShipPartyId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemShipPartyId;
    @XmlElementRef(name = "OrigSystemShipPartyReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemShipPartyReference;
    @XmlElementRef(name = "OrigSystemShipPartySiteId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemShipPartySiteId;
    @XmlElementRef(name = "OrigSystemShipPartySiteReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemShipPartySiteReference;
    @XmlElementRef(name = "OrigSystemShipPtyContactId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemShipPtyContactId;
    @XmlElementRef(name = "OrigSystemShipPtyContactReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemShipPtyContactReference;
    @XmlElementRef(name = "OrigSystemSoldPartyId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemSoldPartyId;
    @XmlElementRef(name = "OrigSystemSoldPartyReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemSoldPartyReference;
    @XmlElementRef(name = "OrigSystemBatchName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemBatchName;
    @XmlElementRef(name = "OrigSystemBillAddressId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemBillAddressId;
    @XmlElementRef(name = "OrigSystemBillAddressReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemBillAddressReference;
    @XmlElementRef(name = "OrigSystemBillContactId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemBillContactId;
    @XmlElementRef(name = "OrigSystemBillContactReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemBillContactReference;
    @XmlElementRef(name = "OrigSystemBillCustomerId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemBillCustomerId;
    @XmlElementRef(name = "OrigSystemBillCustomerReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemBillCustomerReference;
    @XmlElementRef(name = "OrigSystemShipAddressId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemShipAddressId;
    @XmlElementRef(name = "OrigSystemShipAddressReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemShipAddressReference;
    @XmlElementRef(name = "OrigSystemShipContactId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemShipContactId;
    @XmlElementRef(name = "OrigSystemShipContactReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemShipContactReference;
    @XmlElementRef(name = "OrigSystemShipCustomerId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemShipCustomerId;
    @XmlElementRef(name = "OrigSystemShipCustomerReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemShipCustomerReference;
    @XmlElementRef(name = "OrigSystemSoldCustomerId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> origSystemSoldCustomerId;
    @XmlElementRef(name = "OrigSystemSoldCustomerReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origSystemSoldCustomerReference;
    @XmlElementRef(name = "OverrideAutoAccounting", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> overrideAutoAccounting;
    @XmlElementRef(name = "PaymentAttributes", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentAttributes;
    @XmlElementRef(name = "PaymentServerOrderNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentServerOrderNumber;
    @XmlElementRef(name = "PaymentSetId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> paymentSetId;
    @XmlElementRef(name = "PaymentTrxnExtensionId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> paymentTrxnExtensionId;
    @XmlElementRef(name = "PrimarySalesrepNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> primarySalesrepNumber;
    @XmlElementRef(name = "PrintingOption", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> printingOption;
    @XmlElementRef(name = "ProdFcCategId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> prodFcCategId;
    @XmlElementRef(name = "ProductCategory", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> productCategory;
    @XmlElementRef(name = "ProductFiscClassification", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> productFiscClassification;
    @XmlElementRef(name = "ProductType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> productType;
    @XmlElementRef(name = "PurchaseOrder", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaseOrder;
    @XmlElementRef(name = "PurchaseOrderDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> purchaseOrderDate;
    @XmlElementRef(name = "PurchaseOrderRevision", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaseOrderRevision;
    @XmlElementRef(name = "Quantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> quantity;
    @XmlElementRef(name = "QuantityOrdered", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> quantityOrdered;
    @XmlElementRef(name = "ReasonCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reasonCode;
    @XmlElementRef(name = "ReasonCodeMeaning", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reasonCodeMeaning;
    @XmlElementRef(name = "ReceiptMethodId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> receiptMethodId;
    @XmlElementRef(name = "ReceiptMethodName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptMethodName;
    @XmlElementRef(name = "ReferenceLineId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> referenceLineId;
    @XmlElementRef(name = "RelatedBatchSourceName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relatedBatchSourceName;
    @XmlElementRef(name = "RelatedTrxNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> relatedTrxNumber;
    @XmlElementRef(name = "ResetTrxDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resetTrxDate;
    @XmlElementRef(name = "ResourceSalesrepId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> resourceSalesrepId;
    @XmlElementRef(name = "ContractStartDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> contractStartDate;
    @XmlElementRef(name = "ContractEndDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> contractEndDate;
    @XmlElementRef(name = "RuleEndDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> ruleEndDate;
    @XmlElementRef(name = "RuleStartDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> ruleStartDate;
    @XmlElementRef(name = "SalesTaxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> salesTaxId;
    @XmlElementRef(name = "SetOfBooksId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> setOfBooksId;
    @XmlElementRef(name = "ShipContactPartyNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shipContactPartyNumber;
    @XmlElementRef(name = "ShipCustomerAccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shipCustomerAccountNumber;
    @XmlElementRef(name = "ShipCustomerSiteNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shipCustomerSiteNumber;
    @XmlElementRef(name = "ShipDateActual", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> shipDateActual;
    @XmlElementRef(name = "ShipVia", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shipVia;
    @XmlElementRef(name = "SoldCustomerAccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> soldCustomerAccountNumber;
    @XmlElementRef(name = "SourceApplicationId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> sourceApplicationId;
    @XmlElementRef(name = "SourceEntityCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceEntityCode;
    @XmlElementRef(name = "SourceEventClassCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceEventClassCode;
    @XmlElementRef(name = "SourceTrxDetailTaxLineId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> sourceTrxDetailTaxLineId;
    @XmlElementRef(name = "SourceTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> sourceTrxId;
    @XmlElementRef(name = "SourceTrxLineId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> sourceTrxLineId;
    @XmlElementRef(name = "SourceTrxLineType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceTrxLineType;
    @XmlElementRef(name = "Tax", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tax;
    @XmlElementRef(name = "TaxCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxCode;
    @XmlElementRef(name = "TaxExempt", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxExempt;
    @XmlElementRef(name = "TaxExemptNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxExemptNumber;
    @XmlElementRef(name = "TaxExemptReasonCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxExemptReasonCode;
    @XmlElementRef(name = "TaxExemptReasonCodeMeaning", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxExemptReasonCodeMeaning;
    @XmlElementRef(name = "TaxInvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxInvoiceDate;
    @XmlElementRef(name = "TaxInvoiceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxInvoiceNumber;
    @XmlElementRef(name = "TaxJurisdictionCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxJurisdictionCode;
    @XmlElementRef(name = "TaxPrecedence", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> taxPrecedence;
    @XmlElementRef(name = "TaxRate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> taxRate;
    @XmlElementRef(name = "TaxRateCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxRateCode;
    @XmlElementRef(name = "TaxRegimeCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxRegimeCode;
    @XmlElementRef(name = "TaxStatusCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxStatusCode;
    @XmlElementRef(name = "TaxableAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> taxableAmount;
    @XmlElementRef(name = "Taxable", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxable;
    @XmlElementRef(name = "PaymentTermsId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> paymentTermsId;
    @XmlElementRef(name = "PaymentTermsName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentTermsName;
    @XmlElementRef(name = "ThirdPtyRegId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> thirdPtyRegId;
    @XmlElementRef(name = "ThirdPtyRegNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thirdPtyRegNumber;
    @XmlElementRef(name = "TranslatedDescription", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> translatedDescription;
    @XmlElementRef(name = "TrxBusinessCategory", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trxBusinessCategory;
    @XmlElementRef(name = "TrxNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trxNumber;
    @XmlElementRef(name = "UnitSellingPrice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> unitSellingPrice;
    @XmlElementRef(name = "UnitStandardPrice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> unitStandardPrice;
    @XmlElementRef(name = "UOMCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uomCode;
    @XmlElementRef(name = "UOMName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uomName;
    @XmlElementRef(name = "UserDefinedFiscClass", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userDefinedFiscClass;
    @XmlElementRef(name = "VATTaxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> vatTaxId;
    @XmlElementRef(name = "WarehouseCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> warehouseCode;
    @XmlElementRef(name = "WarehouseId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> warehouseId;
    @XmlElementRef(name = "WaybillNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> waybillNumber;
    @XmlElementRef(name = "RecurringBill", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recurringBill;
    @XmlElementRef(name = "Periodicity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> periodicity;
    @XmlElementRef(name = "SecondInvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> secondInvoiceDate;
    @XmlElementRef(name = "ContractedPeriods", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> contractedPeriods;
    @XmlElementRef(name = "FirstOverridePeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> firstOverridePeriod;
    @XmlElementRef(name = "FirstOverrideAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> firstOverrideAmount;
    @XmlElementRef(name = "FirstOverrideQuantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> firstOverrideQuantity;
    @XmlElementRef(name = "SecondOverridePeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> secondOverridePeriod;
    @XmlElementRef(name = "SecondOverrideAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> secondOverrideAmount;
    @XmlElementRef(name = "SecondOverrideQuantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> secondOverrideQuantity;
    @XmlElementRef(name = "ThirdOverridePeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> thirdOverridePeriod;
    @XmlElementRef(name = "ThirdOverrideAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> thirdOverrideAmount;
    @XmlElementRef(name = "ThirdOverrideQuantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> thirdOverrideQuantity;
    @XmlElementRef(name = "FourthOverridePeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> fourthOverridePeriod;
    @XmlElementRef(name = "FourthOverrideAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> fourthOverrideAmount;
    @XmlElementRef(name = "FourthOverrideQuantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> fourthOverrideQuantity;
    @XmlElementRef(name = "FifthOverridePeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> fifthOverridePeriod;
    @XmlElementRef(name = "FifthOverrideAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> fifthOverrideAmount;
    @XmlElementRef(name = "FifthOverrideQuantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> fifthOverrideQuantity;
    @XmlElementRef(name = "SecondBillingPeriodStartDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> secondBillingPeriodStartDate;
    @XmlElementRef(name = "ContractLineAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> contractLineAmount;
    @XmlElementRef(name = "ContractLineQuantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> contractLineQuantity;
    @XmlElementRef(name = "ContractLineUnitPrice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> contractLineUnitPrice;
    @XmlElementRef(name = "EnforceSequenceDateCorrelation", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> enforceSequenceDateCorrelation;
    @XmlElement(name = "TransactionInterfaceGdf")
    protected TransactionInterfaceGdf transactionInterfaceGdf;
    @XmlElement(name = "TransactionLineInterfaceGdf")
    protected TransactionLineInterfaceGdf transactionLineInterfaceGdf;
    @XmlElement(name = "TransactionInterfaceLineDff")
    protected TransactionInterfaceLineFLEX transactionInterfaceLineDff;
    @XmlElement(name = "TransactionInterfaceLinkToDff")
    protected InterfaceLineLinkToFLEX transactionInterfaceLinkToDff;
    @XmlElement(name = "TransactionInterfaceReferenceDff")
    protected InterfaceLineReferenceFLEX transactionInterfaceReferenceDff;
    @XmlElement(name = "TransactionLineDff")
    protected TransactionLineFLEX transactionLineDff;
    @XmlElement(name = "TransactionInterfaceHeaderDff")
    protected TransactionInterfaceHeaderFLEX transactionInterfaceHeaderDff;

    /**
     * Gets the value of the orgId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgId(Long value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the accountingRuleDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAccountingRuleDuration() {
        return accountingRuleDuration;
    }

    /**
     * Sets the value of the accountingRuleDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAccountingRuleDuration(JAXBElement<Long> value) {
        this.accountingRuleDuration = value;
    }

    /**
     * Gets the value of the accountingRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAccountingRuleId() {
        return accountingRuleId;
    }

    /**
     * Sets the value of the accountingRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAccountingRuleId(JAXBElement<Long> value) {
        this.accountingRuleId = value;
    }

    /**
     * Gets the value of the accountingRuleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountingRuleName() {
        return accountingRuleName;
    }

    /**
     * Sets the value of the accountingRuleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountingRuleName(JAXBElement<String> value) {
        this.accountingRuleName = value;
    }

    /**
     * Gets the value of the addressVerificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressVerificationCode() {
        return addressVerificationCode;
    }

    /**
     * Sets the value of the addressVerificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressVerificationCode(JAXBElement<String> value) {
        this.addressVerificationCode = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setAmount(JAXBElement<AmountType> value) {
        this.amount = value;
    }

    /**
     * Gets the value of the amountIncludesTax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAmountIncludesTax() {
        return amountIncludesTax;
    }

    /**
     * Sets the value of the amountIncludesTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAmountIncludesTax(JAXBElement<String> value) {
        this.amountIncludesTax = value;
    }

    /**
     * Gets the value of the applicationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the value of the applicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setApplicationId(JAXBElement<Long> value) {
        this.applicationId = value;
    }

    /**
     * Gets the value of the assessableValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAssessableValue() {
        return assessableValue;
    }

    /**
     * Sets the value of the assessableValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAssessableValue(JAXBElement<BigDecimal> value) {
        this.assessableValue = value;
    }

    /**
     * Gets the value of the approvalCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApprovalCode(JAXBElement<String> value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the authorizationComplete property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthorizationComplete() {
        return authorizationComplete;
    }

    /**
     * Sets the value of the authorizationComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthorizationComplete(JAXBElement<String> value) {
        this.authorizationComplete = value;
    }

    /**
     * Gets the value of the authorizationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthorizationNumber() {
        return authorizationNumber;
    }

    /**
     * Sets the value of the authorizationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthorizationNumber(JAXBElement<String> value) {
        this.authorizationNumber = value;
    }

    /**
     * Gets the value of the salesOrderSource property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesOrderSource() {
        return salesOrderSource;
    }

    /**
     * Sets the value of the salesOrderSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesOrderSource(JAXBElement<String> value) {
        this.salesOrderSource = value;
    }

    /**
     * Gets the value of the batchSourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchSourceName() {
        return batchSourceName;
    }

    /**
     * Sets the value of the batchSourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchSourceName(String value) {
        this.batchSourceName = value;
    }

    /**
     * Gets the value of the customerTrxTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerTrxTypeName() {
        return customerTrxTypeName;
    }

    /**
     * Sets the value of the customerTrxTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerTrxTypeName(JAXBElement<String> value) {
        this.customerTrxTypeName = value;
    }

    /**
     * Gets the value of the billContactPartyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillContactPartyNumber() {
        return billContactPartyNumber;
    }

    /**
     * Sets the value of the billContactPartyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillContactPartyNumber(JAXBElement<String> value) {
        this.billContactPartyNumber = value;
    }

    /**
     * Gets the value of the billCustomerAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillCustomerAccountNumber() {
        return billCustomerAccountNumber;
    }

    /**
     * Sets the value of the billCustomerAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillCustomerAccountNumber(JAXBElement<String> value) {
        this.billCustomerAccountNumber = value;
    }

    /**
     * Gets the value of the billCustomerSiteNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillCustomerSiteNumber() {
        return billCustomerSiteNumber;
    }

    /**
     * Sets the value of the billCustomerSiteNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillCustomerSiteNumber(JAXBElement<String> value) {
        this.billCustomerSiteNumber = value;
    }

    /**
     * Gets the value of the billingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getBillingDate() {
        return billingDate;
    }

    /**
     * Sets the value of the billingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setBillingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.billingDate = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComments(JAXBElement<String> value) {
        this.comments = value;
    }

    /**
     * Gets the value of the consBillingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsBillingNumber() {
        return consBillingNumber;
    }

    /**
     * Sets the value of the consBillingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsBillingNumber(JAXBElement<String> value) {
        this.consBillingNumber = value;
    }

    /**
     * Gets the value of the contractId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getContractId() {
        return contractId;
    }

    /**
     * Sets the value of the contractId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setContractId(JAXBElement<Long> value) {
        this.contractId = value;
    }

    /**
     * Gets the value of the contractLineId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getContractLineId() {
        return contractLineId;
    }

    /**
     * Sets the value of the contractLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setContractLineId(JAXBElement<Long> value) {
        this.contractLineId = value;
    }

    /**
     * Gets the value of the salesOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesOrder() {
        return salesOrder;
    }

    /**
     * Sets the value of the salesOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesOrder(JAXBElement<String> value) {
        this.salesOrder = value;
    }

    /**
     * Gets the value of the salesOrderDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSalesOrderDate() {
        return salesOrderDate;
    }

    /**
     * Sets the value of the salesOrderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSalesOrderDate(JAXBElement<XMLGregorianCalendar> value) {
        this.salesOrderDate = value;
    }

    /**
     * Gets the value of the salesOrderLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesOrderLine() {
        return salesOrderLine;
    }

    /**
     * Sets the value of the salesOrderLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesOrderLine(JAXBElement<String> value) {
        this.salesOrderLine = value;
    }

    /**
     * Gets the value of the salesOrderRevision property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSalesOrderRevision() {
        return salesOrderRevision;
    }

    /**
     * Sets the value of the salesOrderRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSalesOrderRevision(JAXBElement<BigDecimal> value) {
        this.salesOrderRevision = value;
    }

    /**
     * Gets the value of the trxDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTrxDate() {
        return trxDate;
    }

    /**
     * Sets the value of the trxDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTrxDate(JAXBElement<XMLGregorianCalendar> value) {
        this.trxDate = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the conversionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversionType() {
        return conversionType;
    }

    /**
     * Sets the value of the conversionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversionType(String value) {
        this.conversionType = value;
    }

    /**
     * Gets the value of the conversionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getConversionDate() {
        return conversionDate;
    }

    /**
     * Sets the value of the conversionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setConversionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.conversionDate = value;
    }

    /**
     * Gets the value of the conversionRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getConversionRate() {
        return conversionRate;
    }

    /**
     * Sets the value of the conversionRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setConversionRate(JAXBElement<BigDecimal> value) {
        this.conversionRate = value;
    }

    /**
     * Gets the value of the creditMethodForAccountRule property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditMethodForAccountRule() {
        return creditMethodForAccountRule;
    }

    /**
     * Sets the value of the creditMethodForAccountRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditMethodForAccountRule(JAXBElement<String> value) {
        this.creditMethodForAccountRule = value;
    }

    /**
     * Gets the value of the creditMethodForInstallments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditMethodForInstallments() {
        return creditMethodForInstallments;
    }

    /**
     * Sets the value of the creditMethodForInstallments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditMethodForInstallments(JAXBElement<String> value) {
        this.creditMethodForInstallments = value;
    }

    /**
     * Gets the value of the customerTrxTypeSequenceId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustomerTrxTypeSequenceId() {
        return customerTrxTypeSequenceId;
    }

    /**
     * Sets the value of the customerTrxTypeSequenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustomerTrxTypeSequenceId(JAXBElement<Long> value) {
        this.customerTrxTypeSequenceId = value;
    }

    /**
     * Gets the value of the customerBankAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerBankAccountName() {
        return customerBankAccountName;
    }

    /**
     * Sets the value of the customerBankAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerBankAccountName(JAXBElement<String> value) {
        this.customerBankAccountName = value;
    }

    /**
     * Gets the value of the defaultTaxationCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultTaxationCountry() {
        return defaultTaxationCountry;
    }

    /**
     * Sets the value of the defaultTaxationCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultTaxationCountry(JAXBElement<String> value) {
        this.defaultTaxationCountry = value;
    }

    /**
     * Gets the value of the deferralExclusion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeferralExclusion() {
        return deferralExclusion;
    }

    /**
     * Sets the value of the deferralExclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeferralExclusion(JAXBElement<String> value) {
        this.deferralExclusion = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the documentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Sets the value of the documentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDocumentNumber(JAXBElement<Long> value) {
        this.documentNumber = value;
    }

    /**
     * Gets the value of the documentSubType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentSubType() {
        return documentSubType;
    }

    /**
     * Sets the value of the documentSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentSubType(JAXBElement<String> value) {
        this.documentSubType = value;
    }

    /**
     * Gets the value of the exceptionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExceptionId() {
        return exceptionId;
    }

    /**
     * Sets the value of the exceptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExceptionId(JAXBElement<Long> value) {
        this.exceptionId = value;
    }

    /**
     * Gets the value of the exemptionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExemptionId() {
        return exemptionId;
    }

    /**
     * Sets the value of the exemptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExemptionId(JAXBElement<Long> value) {
        this.exemptionId = value;
    }

    /**
     * Gets the value of the finalDischargeLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFinalDischargeLocationCode() {
        return finalDischargeLocationCode;
    }

    /**
     * Sets the value of the finalDischargeLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFinalDischargeLocationCode(JAXBElement<String> value) {
        this.finalDischargeLocationCode = value;
    }

    /**
     * Gets the value of the finalDischargeLocationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFinalDischargeLocationId() {
        return finalDischargeLocationId;
    }

    /**
     * Sets the value of the finalDischargeLocationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFinalDischargeLocationId(JAXBElement<Long> value) {
        this.finalDischargeLocationId = value;
    }

    /**
     * Gets the value of the firstPtyRegId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFirstPtyRegId() {
        return firstPtyRegId;
    }

    /**
     * Sets the value of the firstPtyRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFirstPtyRegId(JAXBElement<Long> value) {
        this.firstPtyRegId = value;
    }

    /**
     * Gets the value of the firstPtyRegNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstPtyRegNumber() {
        return firstPtyRegNumber;
    }

    /**
     * Sets the value of the firstPtyRegNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstPtyRegNumber(JAXBElement<String> value) {
        this.firstPtyRegNumber = value;
    }

    /**
     * Gets the value of the fobPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFOBPoint() {
        return fobPoint;
    }

    /**
     * Sets the value of the fobPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFOBPoint(JAXBElement<String> value) {
        this.fobPoint = value;
    }

    /**
     * Gets the value of the glDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getGlDate() {
        return glDate;
    }

    /**
     * Sets the value of the glDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setGlDate(JAXBElement<XMLGregorianCalendar> value) {
        this.glDate = value;
    }

    /**
     * Gets the value of the intendedUseClassifId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getIntendedUseClassifId() {
        return intendedUseClassifId;
    }

    /**
     * Sets the value of the intendedUseClassifId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setIntendedUseClassifId(JAXBElement<Long> value) {
        this.intendedUseClassifId = value;
    }

    /**
     * Gets the value of the internalNotes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInternalNotes() {
        return internalNotes;
    }

    /**
     * Sets the value of the internalNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInternalNotes(JAXBElement<String> value) {
        this.internalNotes = value;
    }

    /**
     * Gets the value of the itemNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the value of the itemNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemNumber(JAXBElement<String> value) {
        this.itemNumber = value;
    }

    /**
     * Gets the value of the inventoryItemId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInventoryItemId() {
        return inventoryItemId;
    }

    /**
     * Sets the value of the inventoryItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInventoryItemId(JAXBElement<Long> value) {
        this.inventoryItemId = value;
    }

    /**
     * Gets the value of the invoicedLineAcctgLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoicedLineAcctgLevel() {
        return invoicedLineAcctgLevel;
    }

    /**
     * Sets the value of the invoicedLineAcctgLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoicedLineAcctgLevel(JAXBElement<String> value) {
        this.invoicedLineAcctgLevel = value;
    }

    /**
     * Gets the value of the invoicingRuleId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInvoicingRuleId() {
        return invoicingRuleId;
    }

    /**
     * Sets the value of the invoicingRuleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInvoicingRuleId(JAXBElement<Long> value) {
        this.invoicingRuleId = value;
    }

    /**
     * Gets the value of the invoicingRuleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoicingRuleName() {
        return invoicingRuleName;
    }

    /**
     * Sets the value of the invoicingRuleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoicingRuleName(JAXBElement<String> value) {
        this.invoicingRuleName = value;
    }

    /**
     * Gets the value of the lastPeriodToCredit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getLastPeriodToCredit() {
        return lastPeriodToCredit;
    }

    /**
     * Sets the value of the lastPeriodToCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setLastPeriodToCredit(JAXBElement<Integer> value) {
        this.lastPeriodToCredit = value;
    }

    /**
     * Gets the value of the lastTrxDebitAuth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastTrxDebitAuth() {
        return lastTrxDebitAuth;
    }

    /**
     * Sets the value of the lastTrxDebitAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastTrxDebitAuth(JAXBElement<String> value) {
        this.lastTrxDebitAuth = value;
    }

    /**
     * Gets the value of the legalEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getLegalEntityId() {
        return legalEntityId;
    }

    /**
     * Sets the value of the legalEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setLegalEntityId(JAXBElement<Long> value) {
        this.legalEntityId = value;
    }

    /**
     * Gets the value of the lineIntendedUse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLineIntendedUse() {
        return lineIntendedUse;
    }

    /**
     * Sets the value of the lineIntendedUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineIntendedUse(JAXBElement<String> value) {
        this.lineIntendedUse = value;
    }

    /**
     * Gets the value of the lineType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineType() {
        return lineType;
    }

    /**
     * Sets the value of the lineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineType(String value) {
        this.lineType = value;
    }

    /**
     * Gets the value of the memoLineName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemoLineName() {
        return memoLineName;
    }

    /**
     * Sets the value of the memoLineName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemoLineName(JAXBElement<String> value) {
        this.memoLineName = value;
    }

    /**
     * Gets the value of the memoLineSequenceId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getMemoLineSequenceId() {
        return memoLineSequenceId;
    }

    /**
     * Sets the value of the memoLineSequenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setMemoLineSequenceId(JAXBElement<Long> value) {
        this.memoLineSequenceId = value;
    }

    /**
     * Gets the value of the origSystemShipPartyId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemShipPartyId() {
        return origSystemShipPartyId;
    }

    /**
     * Sets the value of the origSystemShipPartyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemShipPartyId(JAXBElement<Long> value) {
        this.origSystemShipPartyId = value;
    }

    /**
     * Gets the value of the origSystemShipPartyReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemShipPartyReference() {
        return origSystemShipPartyReference;
    }

    /**
     * Sets the value of the origSystemShipPartyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemShipPartyReference(JAXBElement<String> value) {
        this.origSystemShipPartyReference = value;
    }

    /**
     * Gets the value of the origSystemShipPartySiteId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemShipPartySiteId() {
        return origSystemShipPartySiteId;
    }

    /**
     * Sets the value of the origSystemShipPartySiteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemShipPartySiteId(JAXBElement<Long> value) {
        this.origSystemShipPartySiteId = value;
    }

    /**
     * Gets the value of the origSystemShipPartySiteReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemShipPartySiteReference() {
        return origSystemShipPartySiteReference;
    }

    /**
     * Sets the value of the origSystemShipPartySiteReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemShipPartySiteReference(JAXBElement<String> value) {
        this.origSystemShipPartySiteReference = value;
    }

    /**
     * Gets the value of the origSystemShipPtyContactId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemShipPtyContactId() {
        return origSystemShipPtyContactId;
    }

    /**
     * Sets the value of the origSystemShipPtyContactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemShipPtyContactId(JAXBElement<Long> value) {
        this.origSystemShipPtyContactId = value;
    }

    /**
     * Gets the value of the origSystemShipPtyContactReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemShipPtyContactReference() {
        return origSystemShipPtyContactReference;
    }

    /**
     * Sets the value of the origSystemShipPtyContactReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemShipPtyContactReference(JAXBElement<String> value) {
        this.origSystemShipPtyContactReference = value;
    }

    /**
     * Gets the value of the origSystemSoldPartyId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemSoldPartyId() {
        return origSystemSoldPartyId;
    }

    /**
     * Sets the value of the origSystemSoldPartyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemSoldPartyId(JAXBElement<Long> value) {
        this.origSystemSoldPartyId = value;
    }

    /**
     * Gets the value of the origSystemSoldPartyReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemSoldPartyReference() {
        return origSystemSoldPartyReference;
    }

    /**
     * Sets the value of the origSystemSoldPartyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemSoldPartyReference(JAXBElement<String> value) {
        this.origSystemSoldPartyReference = value;
    }

    /**
     * Gets the value of the origSystemBatchName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemBatchName() {
        return origSystemBatchName;
    }

    /**
     * Sets the value of the origSystemBatchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemBatchName(JAXBElement<String> value) {
        this.origSystemBatchName = value;
    }

    /**
     * Gets the value of the origSystemBillAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemBillAddressId() {
        return origSystemBillAddressId;
    }

    /**
     * Sets the value of the origSystemBillAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemBillAddressId(JAXBElement<Long> value) {
        this.origSystemBillAddressId = value;
    }

    /**
     * Gets the value of the origSystemBillAddressReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemBillAddressReference() {
        return origSystemBillAddressReference;
    }

    /**
     * Sets the value of the origSystemBillAddressReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemBillAddressReference(JAXBElement<String> value) {
        this.origSystemBillAddressReference = value;
    }

    /**
     * Gets the value of the origSystemBillContactId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemBillContactId() {
        return origSystemBillContactId;
    }

    /**
     * Sets the value of the origSystemBillContactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemBillContactId(JAXBElement<Long> value) {
        this.origSystemBillContactId = value;
    }

    /**
     * Gets the value of the origSystemBillContactReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemBillContactReference() {
        return origSystemBillContactReference;
    }

    /**
     * Sets the value of the origSystemBillContactReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemBillContactReference(JAXBElement<String> value) {
        this.origSystemBillContactReference = value;
    }

    /**
     * Gets the value of the origSystemBillCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemBillCustomerId() {
        return origSystemBillCustomerId;
    }

    /**
     * Sets the value of the origSystemBillCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemBillCustomerId(JAXBElement<Long> value) {
        this.origSystemBillCustomerId = value;
    }

    /**
     * Gets the value of the origSystemBillCustomerReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemBillCustomerReference() {
        return origSystemBillCustomerReference;
    }

    /**
     * Sets the value of the origSystemBillCustomerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemBillCustomerReference(JAXBElement<String> value) {
        this.origSystemBillCustomerReference = value;
    }

    /**
     * Gets the value of the origSystemShipAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemShipAddressId() {
        return origSystemShipAddressId;
    }

    /**
     * Sets the value of the origSystemShipAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemShipAddressId(JAXBElement<Long> value) {
        this.origSystemShipAddressId = value;
    }

    /**
     * Gets the value of the origSystemShipAddressReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemShipAddressReference() {
        return origSystemShipAddressReference;
    }

    /**
     * Sets the value of the origSystemShipAddressReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemShipAddressReference(JAXBElement<String> value) {
        this.origSystemShipAddressReference = value;
    }

    /**
     * Gets the value of the origSystemShipContactId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemShipContactId() {
        return origSystemShipContactId;
    }

    /**
     * Sets the value of the origSystemShipContactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemShipContactId(JAXBElement<Long> value) {
        this.origSystemShipContactId = value;
    }

    /**
     * Gets the value of the origSystemShipContactReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemShipContactReference() {
        return origSystemShipContactReference;
    }

    /**
     * Sets the value of the origSystemShipContactReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemShipContactReference(JAXBElement<String> value) {
        this.origSystemShipContactReference = value;
    }

    /**
     * Gets the value of the origSystemShipCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemShipCustomerId() {
        return origSystemShipCustomerId;
    }

    /**
     * Sets the value of the origSystemShipCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemShipCustomerId(JAXBElement<Long> value) {
        this.origSystemShipCustomerId = value;
    }

    /**
     * Gets the value of the origSystemShipCustomerReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemShipCustomerReference() {
        return origSystemShipCustomerReference;
    }

    /**
     * Sets the value of the origSystemShipCustomerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemShipCustomerReference(JAXBElement<String> value) {
        this.origSystemShipCustomerReference = value;
    }

    /**
     * Gets the value of the origSystemSoldCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getOrigSystemSoldCustomerId() {
        return origSystemSoldCustomerId;
    }

    /**
     * Sets the value of the origSystemSoldCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setOrigSystemSoldCustomerId(JAXBElement<Long> value) {
        this.origSystemSoldCustomerId = value;
    }

    /**
     * Gets the value of the origSystemSoldCustomerReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigSystemSoldCustomerReference() {
        return origSystemSoldCustomerReference;
    }

    /**
     * Sets the value of the origSystemSoldCustomerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigSystemSoldCustomerReference(JAXBElement<String> value) {
        this.origSystemSoldCustomerReference = value;
    }

    /**
     * Gets the value of the overrideAutoAccounting property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOverrideAutoAccounting() {
        return overrideAutoAccounting;
    }

    /**
     * Sets the value of the overrideAutoAccounting property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOverrideAutoAccounting(JAXBElement<String> value) {
        this.overrideAutoAccounting = value;
    }

    /**
     * Gets the value of the paymentAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentAttributes() {
        return paymentAttributes;
    }

    /**
     * Sets the value of the paymentAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentAttributes(JAXBElement<String> value) {
        this.paymentAttributes = value;
    }

    /**
     * Gets the value of the paymentServerOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentServerOrderNumber() {
        return paymentServerOrderNumber;
    }

    /**
     * Sets the value of the paymentServerOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentServerOrderNumber(JAXBElement<String> value) {
        this.paymentServerOrderNumber = value;
    }

    /**
     * Gets the value of the paymentSetId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPaymentSetId() {
        return paymentSetId;
    }

    /**
     * Sets the value of the paymentSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPaymentSetId(JAXBElement<Long> value) {
        this.paymentSetId = value;
    }

    /**
     * Gets the value of the paymentTrxnExtensionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPaymentTrxnExtensionId() {
        return paymentTrxnExtensionId;
    }

    /**
     * Sets the value of the paymentTrxnExtensionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPaymentTrxnExtensionId(JAXBElement<Long> value) {
        this.paymentTrxnExtensionId = value;
    }

    /**
     * Gets the value of the primarySalesrepNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrimarySalesrepNumber() {
        return primarySalesrepNumber;
    }

    /**
     * Sets the value of the primarySalesrepNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrimarySalesrepNumber(JAXBElement<String> value) {
        this.primarySalesrepNumber = value;
    }

    /**
     * Gets the value of the printingOption property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrintingOption() {
        return printingOption;
    }

    /**
     * Sets the value of the printingOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrintingOption(JAXBElement<String> value) {
        this.printingOption = value;
    }

    /**
     * Gets the value of the prodFcCategId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getProdFcCategId() {
        return prodFcCategId;
    }

    /**
     * Sets the value of the prodFcCategId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setProdFcCategId(JAXBElement<Long> value) {
        this.prodFcCategId = value;
    }

    /**
     * Gets the value of the productCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductCategory() {
        return productCategory;
    }

    /**
     * Sets the value of the productCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductCategory(JAXBElement<String> value) {
        this.productCategory = value;
    }

    /**
     * Gets the value of the productFiscClassification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductFiscClassification() {
        return productFiscClassification;
    }

    /**
     * Sets the value of the productFiscClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductFiscClassification(JAXBElement<String> value) {
        this.productFiscClassification = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductType(JAXBElement<String> value) {
        this.productType = value;
    }

    /**
     * Gets the value of the purchaseOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * Sets the value of the purchaseOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseOrder(JAXBElement<String> value) {
        this.purchaseOrder = value;
    }

    /**
     * Gets the value of the purchaseOrderDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    /**
     * Sets the value of the purchaseOrderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setPurchaseOrderDate(JAXBElement<XMLGregorianCalendar> value) {
        this.purchaseOrderDate = value;
    }

    /**
     * Gets the value of the purchaseOrderRevision property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseOrderRevision() {
        return purchaseOrderRevision;
    }

    /**
     * Sets the value of the purchaseOrderRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseOrderRevision(JAXBElement<String> value) {
        this.purchaseOrderRevision = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setQuantity(JAXBElement<MeasureType> value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the quantityOrdered property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Sets the value of the quantityOrdered property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setQuantityOrdered(JAXBElement<BigDecimal> value) {
        this.quantityOrdered = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReasonCode(JAXBElement<String> value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the reasonCodeMeaning property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReasonCodeMeaning() {
        return reasonCodeMeaning;
    }

    /**
     * Sets the value of the reasonCodeMeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReasonCodeMeaning(JAXBElement<String> value) {
        this.reasonCodeMeaning = value;
    }

    /**
     * Gets the value of the receiptMethodId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getReceiptMethodId() {
        return receiptMethodId;
    }

    /**
     * Sets the value of the receiptMethodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setReceiptMethodId(JAXBElement<Long> value) {
        this.receiptMethodId = value;
    }

    /**
     * Gets the value of the receiptMethodName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptMethodName() {
        return receiptMethodName;
    }

    /**
     * Sets the value of the receiptMethodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptMethodName(JAXBElement<String> value) {
        this.receiptMethodName = value;
    }

    /**
     * Gets the value of the referenceLineId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getReferenceLineId() {
        return referenceLineId;
    }

    /**
     * Sets the value of the referenceLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setReferenceLineId(JAXBElement<Long> value) {
        this.referenceLineId = value;
    }

    /**
     * Gets the value of the relatedBatchSourceName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelatedBatchSourceName() {
        return relatedBatchSourceName;
    }

    /**
     * Sets the value of the relatedBatchSourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelatedBatchSourceName(JAXBElement<String> value) {
        this.relatedBatchSourceName = value;
    }

    /**
     * Gets the value of the relatedTrxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRelatedTrxNumber() {
        return relatedTrxNumber;
    }

    /**
     * Sets the value of the relatedTrxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRelatedTrxNumber(JAXBElement<String> value) {
        this.relatedTrxNumber = value;
    }

    /**
     * Gets the value of the resetTrxDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResetTrxDate() {
        return resetTrxDate;
    }

    /**
     * Sets the value of the resetTrxDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResetTrxDate(JAXBElement<String> value) {
        this.resetTrxDate = value;
    }

    /**
     * Gets the value of the resourceSalesrepId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getResourceSalesrepId() {
        return resourceSalesrepId;
    }

    /**
     * Sets the value of the resourceSalesrepId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setResourceSalesrepId(JAXBElement<Long> value) {
        this.resourceSalesrepId = value;
    }

    /**
     * Gets the value of the contractStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getContractStartDate() {
        return contractStartDate;
    }

    /**
     * Sets the value of the contractStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setContractStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.contractStartDate = value;
    }

    /**
     * Gets the value of the contractEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getContractEndDate() {
        return contractEndDate;
    }

    /**
     * Sets the value of the contractEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setContractEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.contractEndDate = value;
    }

    /**
     * Gets the value of the ruleEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getRuleEndDate() {
        return ruleEndDate;
    }

    /**
     * Sets the value of the ruleEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setRuleEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.ruleEndDate = value;
    }

    /**
     * Gets the value of the ruleStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getRuleStartDate() {
        return ruleStartDate;
    }

    /**
     * Sets the value of the ruleStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setRuleStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.ruleStartDate = value;
    }

    /**
     * Gets the value of the salesTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSalesTaxId() {
        return salesTaxId;
    }

    /**
     * Sets the value of the salesTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSalesTaxId(JAXBElement<Long> value) {
        this.salesTaxId = value;
    }

    /**
     * Gets the value of the setOfBooksId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSetOfBooksId() {
        return setOfBooksId;
    }

    /**
     * Sets the value of the setOfBooksId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSetOfBooksId(JAXBElement<Long> value) {
        this.setOfBooksId = value;
    }

    /**
     * Gets the value of the shipContactPartyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipContactPartyNumber() {
        return shipContactPartyNumber;
    }

    /**
     * Sets the value of the shipContactPartyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipContactPartyNumber(JAXBElement<String> value) {
        this.shipContactPartyNumber = value;
    }

    /**
     * Gets the value of the shipCustomerAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipCustomerAccountNumber() {
        return shipCustomerAccountNumber;
    }

    /**
     * Sets the value of the shipCustomerAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipCustomerAccountNumber(JAXBElement<String> value) {
        this.shipCustomerAccountNumber = value;
    }

    /**
     * Gets the value of the shipCustomerSiteNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipCustomerSiteNumber() {
        return shipCustomerSiteNumber;
    }

    /**
     * Sets the value of the shipCustomerSiteNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipCustomerSiteNumber(JAXBElement<String> value) {
        this.shipCustomerSiteNumber = value;
    }

    /**
     * Gets the value of the shipDateActual property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getShipDateActual() {
        return shipDateActual;
    }

    /**
     * Sets the value of the shipDateActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setShipDateActual(JAXBElement<XMLGregorianCalendar> value) {
        this.shipDateActual = value;
    }

    /**
     * Gets the value of the shipVia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipVia() {
        return shipVia;
    }

    /**
     * Sets the value of the shipVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipVia(JAXBElement<String> value) {
        this.shipVia = value;
    }

    /**
     * Gets the value of the soldCustomerAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSoldCustomerAccountNumber() {
        return soldCustomerAccountNumber;
    }

    /**
     * Sets the value of the soldCustomerAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSoldCustomerAccountNumber(JAXBElement<String> value) {
        this.soldCustomerAccountNumber = value;
    }

    /**
     * Gets the value of the sourceApplicationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSourceApplicationId() {
        return sourceApplicationId;
    }

    /**
     * Sets the value of the sourceApplicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSourceApplicationId(JAXBElement<Long> value) {
        this.sourceApplicationId = value;
    }

    /**
     * Gets the value of the sourceEntityCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceEntityCode() {
        return sourceEntityCode;
    }

    /**
     * Sets the value of the sourceEntityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceEntityCode(JAXBElement<String> value) {
        this.sourceEntityCode = value;
    }

    /**
     * Gets the value of the sourceEventClassCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceEventClassCode() {
        return sourceEventClassCode;
    }

    /**
     * Sets the value of the sourceEventClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceEventClassCode(JAXBElement<String> value) {
        this.sourceEventClassCode = value;
    }

    /**
     * Gets the value of the sourceTrxDetailTaxLineId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSourceTrxDetailTaxLineId() {
        return sourceTrxDetailTaxLineId;
    }

    /**
     * Sets the value of the sourceTrxDetailTaxLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSourceTrxDetailTaxLineId(JAXBElement<Long> value) {
        this.sourceTrxDetailTaxLineId = value;
    }

    /**
     * Gets the value of the sourceTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSourceTrxId() {
        return sourceTrxId;
    }

    /**
     * Sets the value of the sourceTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSourceTrxId(JAXBElement<Long> value) {
        this.sourceTrxId = value;
    }

    /**
     * Gets the value of the sourceTrxLineId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSourceTrxLineId() {
        return sourceTrxLineId;
    }

    /**
     * Sets the value of the sourceTrxLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSourceTrxLineId(JAXBElement<Long> value) {
        this.sourceTrxLineId = value;
    }

    /**
     * Gets the value of the sourceTrxLineType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceTrxLineType() {
        return sourceTrxLineType;
    }

    /**
     * Sets the value of the sourceTrxLineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceTrxLineType(JAXBElement<String> value) {
        this.sourceTrxLineType = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTax(JAXBElement<String> value) {
        this.tax = value;
    }

    /**
     * Gets the value of the taxCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of the taxCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxCode(JAXBElement<String> value) {
        this.taxCode = value;
    }

    /**
     * Gets the value of the taxExempt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxExempt() {
        return taxExempt;
    }

    /**
     * Sets the value of the taxExempt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxExempt(JAXBElement<String> value) {
        this.taxExempt = value;
    }

    /**
     * Gets the value of the taxExemptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxExemptNumber() {
        return taxExemptNumber;
    }

    /**
     * Sets the value of the taxExemptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxExemptNumber(JAXBElement<String> value) {
        this.taxExemptNumber = value;
    }

    /**
     * Gets the value of the taxExemptReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxExemptReasonCode() {
        return taxExemptReasonCode;
    }

    /**
     * Sets the value of the taxExemptReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxExemptReasonCode(JAXBElement<String> value) {
        this.taxExemptReasonCode = value;
    }

    /**
     * Gets the value of the taxExemptReasonCodeMeaning property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxExemptReasonCodeMeaning() {
        return taxExemptReasonCodeMeaning;
    }

    /**
     * Sets the value of the taxExemptReasonCodeMeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxExemptReasonCodeMeaning(JAXBElement<String> value) {
        this.taxExemptReasonCodeMeaning = value;
    }

    /**
     * Gets the value of the taxInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTaxInvoiceDate() {
        return taxInvoiceDate;
    }

    /**
     * Sets the value of the taxInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTaxInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.taxInvoiceDate = value;
    }

    /**
     * Gets the value of the taxInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxInvoiceNumber() {
        return taxInvoiceNumber;
    }

    /**
     * Sets the value of the taxInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxInvoiceNumber(JAXBElement<String> value) {
        this.taxInvoiceNumber = value;
    }

    /**
     * Gets the value of the taxJurisdictionCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxJurisdictionCode() {
        return taxJurisdictionCode;
    }

    /**
     * Sets the value of the taxJurisdictionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxJurisdictionCode(JAXBElement<String> value) {
        this.taxJurisdictionCode = value;
    }

    /**
     * Gets the value of the taxPrecedence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTaxPrecedence() {
        return taxPrecedence;
    }

    /**
     * Sets the value of the taxPrecedence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTaxPrecedence(JAXBElement<BigDecimal> value) {
        this.taxPrecedence = value;
    }

    /**
     * Gets the value of the taxRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTaxRate() {
        return taxRate;
    }

    /**
     * Sets the value of the taxRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTaxRate(JAXBElement<BigDecimal> value) {
        this.taxRate = value;
    }

    /**
     * Gets the value of the taxRateCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxRateCode() {
        return taxRateCode;
    }

    /**
     * Sets the value of the taxRateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxRateCode(JAXBElement<String> value) {
        this.taxRateCode = value;
    }

    /**
     * Gets the value of the taxRegimeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxRegimeCode() {
        return taxRegimeCode;
    }

    /**
     * Sets the value of the taxRegimeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxRegimeCode(JAXBElement<String> value) {
        this.taxRegimeCode = value;
    }

    /**
     * Gets the value of the taxStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxStatusCode() {
        return taxStatusCode;
    }

    /**
     * Sets the value of the taxStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxStatusCode(JAXBElement<String> value) {
        this.taxStatusCode = value;
    }

    /**
     * Gets the value of the taxableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getTaxableAmount() {
        return taxableAmount;
    }

    /**
     * Sets the value of the taxableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setTaxableAmount(JAXBElement<AmountType> value) {
        this.taxableAmount = value;
    }

    /**
     * Gets the value of the taxable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxable() {
        return taxable;
    }

    /**
     * Sets the value of the taxable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxable(JAXBElement<String> value) {
        this.taxable = value;
    }

    /**
     * Gets the value of the paymentTermsId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPaymentTermsId() {
        return paymentTermsId;
    }

    /**
     * Sets the value of the paymentTermsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPaymentTermsId(JAXBElement<Long> value) {
        this.paymentTermsId = value;
    }

    /**
     * Gets the value of the paymentTermsName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentTermsName() {
        return paymentTermsName;
    }

    /**
     * Sets the value of the paymentTermsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTermsName(JAXBElement<String> value) {
        this.paymentTermsName = value;
    }

    /**
     * Gets the value of the thirdPtyRegId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getThirdPtyRegId() {
        return thirdPtyRegId;
    }

    /**
     * Sets the value of the thirdPtyRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setThirdPtyRegId(JAXBElement<Long> value) {
        this.thirdPtyRegId = value;
    }

    /**
     * Gets the value of the thirdPtyRegNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThirdPtyRegNumber() {
        return thirdPtyRegNumber;
    }

    /**
     * Sets the value of the thirdPtyRegNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThirdPtyRegNumber(JAXBElement<String> value) {
        this.thirdPtyRegNumber = value;
    }

    /**
     * Gets the value of the translatedDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTranslatedDescription() {
        return translatedDescription;
    }

    /**
     * Sets the value of the translatedDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTranslatedDescription(JAXBElement<String> value) {
        this.translatedDescription = value;
    }

    /**
     * Gets the value of the trxBusinessCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrxBusinessCategory() {
        return trxBusinessCategory;
    }

    /**
     * Sets the value of the trxBusinessCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrxBusinessCategory(JAXBElement<String> value) {
        this.trxBusinessCategory = value;
    }

    /**
     * Gets the value of the trxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrxNumber() {
        return trxNumber;
    }

    /**
     * Sets the value of the trxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrxNumber(JAXBElement<String> value) {
        this.trxNumber = value;
    }

    /**
     * Gets the value of the unitSellingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getUnitSellingPrice() {
        return unitSellingPrice;
    }

    /**
     * Sets the value of the unitSellingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setUnitSellingPrice(JAXBElement<AmountType> value) {
        this.unitSellingPrice = value;
    }

    /**
     * Gets the value of the unitStandardPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getUnitStandardPrice() {
        return unitStandardPrice;
    }

    /**
     * Sets the value of the unitStandardPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setUnitStandardPrice(JAXBElement<AmountType> value) {
        this.unitStandardPrice = value;
    }

    /**
     * Gets the value of the uomCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUOMCode() {
        return uomCode;
    }

    /**
     * Sets the value of the uomCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUOMCode(JAXBElement<String> value) {
        this.uomCode = value;
    }

    /**
     * Gets the value of the uomName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUOMName() {
        return uomName;
    }

    /**
     * Sets the value of the uomName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUOMName(JAXBElement<String> value) {
        this.uomName = value;
    }

    /**
     * Gets the value of the userDefinedFiscClass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserDefinedFiscClass() {
        return userDefinedFiscClass;
    }

    /**
     * Sets the value of the userDefinedFiscClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserDefinedFiscClass(JAXBElement<String> value) {
        this.userDefinedFiscClass = value;
    }

    /**
     * Gets the value of the vatTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getVATTaxId() {
        return vatTaxId;
    }

    /**
     * Sets the value of the vatTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setVATTaxId(JAXBElement<Long> value) {
        this.vatTaxId = value;
    }

    /**
     * Gets the value of the warehouseCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarehouseCode() {
        return warehouseCode;
    }

    /**
     * Sets the value of the warehouseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarehouseCode(JAXBElement<String> value) {
        this.warehouseCode = value;
    }

    /**
     * Gets the value of the warehouseId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getWarehouseId() {
        return warehouseId;
    }

    /**
     * Sets the value of the warehouseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setWarehouseId(JAXBElement<Long> value) {
        this.warehouseId = value;
    }

    /**
     * Gets the value of the waybillNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWaybillNumber() {
        return waybillNumber;
    }

    /**
     * Sets the value of the waybillNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWaybillNumber(JAXBElement<String> value) {
        this.waybillNumber = value;
    }

    /**
     * Gets the value of the recurringBill property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecurringBill() {
        return recurringBill;
    }

    /**
     * Sets the value of the recurringBill property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecurringBill(JAXBElement<String> value) {
        this.recurringBill = value;
    }

    /**
     * Gets the value of the periodicity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPeriodicity() {
        return periodicity;
    }

    /**
     * Sets the value of the periodicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPeriodicity(JAXBElement<String> value) {
        this.periodicity = value;
    }

    /**
     * Gets the value of the secondInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSecondInvoiceDate() {
        return secondInvoiceDate;
    }

    /**
     * Sets the value of the secondInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSecondInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.secondInvoiceDate = value;
    }

    /**
     * Gets the value of the contractedPeriods property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getContractedPeriods() {
        return contractedPeriods;
    }

    /**
     * Sets the value of the contractedPeriods property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setContractedPeriods(JAXBElement<Integer> value) {
        this.contractedPeriods = value;
    }

    /**
     * Gets the value of the firstOverridePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFirstOverridePeriod() {
        return firstOverridePeriod;
    }

    /**
     * Sets the value of the firstOverridePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFirstOverridePeriod(JAXBElement<Long> value) {
        this.firstOverridePeriod = value;
    }

    /**
     * Gets the value of the firstOverrideAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getFirstOverrideAmount() {
        return firstOverrideAmount;
    }

    /**
     * Sets the value of the firstOverrideAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setFirstOverrideAmount(JAXBElement<AmountType> value) {
        this.firstOverrideAmount = value;
    }

    /**
     * Gets the value of the firstOverrideQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getFirstOverrideQuantity() {
        return firstOverrideQuantity;
    }

    /**
     * Sets the value of the firstOverrideQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setFirstOverrideQuantity(JAXBElement<MeasureType> value) {
        this.firstOverrideQuantity = value;
    }

    /**
     * Gets the value of the secondOverridePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSecondOverridePeriod() {
        return secondOverridePeriod;
    }

    /**
     * Sets the value of the secondOverridePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSecondOverridePeriod(JAXBElement<Long> value) {
        this.secondOverridePeriod = value;
    }

    /**
     * Gets the value of the secondOverrideAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getSecondOverrideAmount() {
        return secondOverrideAmount;
    }

    /**
     * Sets the value of the secondOverrideAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setSecondOverrideAmount(JAXBElement<AmountType> value) {
        this.secondOverrideAmount = value;
    }

    /**
     * Gets the value of the secondOverrideQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getSecondOverrideQuantity() {
        return secondOverrideQuantity;
    }

    /**
     * Sets the value of the secondOverrideQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setSecondOverrideQuantity(JAXBElement<MeasureType> value) {
        this.secondOverrideQuantity = value;
    }

    /**
     * Gets the value of the thirdOverridePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getThirdOverridePeriod() {
        return thirdOverridePeriod;
    }

    /**
     * Sets the value of the thirdOverridePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setThirdOverridePeriod(JAXBElement<Long> value) {
        this.thirdOverridePeriod = value;
    }

    /**
     * Gets the value of the thirdOverrideAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getThirdOverrideAmount() {
        return thirdOverrideAmount;
    }

    /**
     * Sets the value of the thirdOverrideAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setThirdOverrideAmount(JAXBElement<AmountType> value) {
        this.thirdOverrideAmount = value;
    }

    /**
     * Gets the value of the thirdOverrideQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getThirdOverrideQuantity() {
        return thirdOverrideQuantity;
    }

    /**
     * Sets the value of the thirdOverrideQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setThirdOverrideQuantity(JAXBElement<MeasureType> value) {
        this.thirdOverrideQuantity = value;
    }

    /**
     * Gets the value of the fourthOverridePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFourthOverridePeriod() {
        return fourthOverridePeriod;
    }

    /**
     * Sets the value of the fourthOverridePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFourthOverridePeriod(JAXBElement<Long> value) {
        this.fourthOverridePeriod = value;
    }

    /**
     * Gets the value of the fourthOverrideAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getFourthOverrideAmount() {
        return fourthOverrideAmount;
    }

    /**
     * Sets the value of the fourthOverrideAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setFourthOverrideAmount(JAXBElement<AmountType> value) {
        this.fourthOverrideAmount = value;
    }

    /**
     * Gets the value of the fourthOverrideQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getFourthOverrideQuantity() {
        return fourthOverrideQuantity;
    }

    /**
     * Sets the value of the fourthOverrideQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setFourthOverrideQuantity(JAXBElement<MeasureType> value) {
        this.fourthOverrideQuantity = value;
    }

    /**
     * Gets the value of the fifthOverridePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFifthOverridePeriod() {
        return fifthOverridePeriod;
    }

    /**
     * Sets the value of the fifthOverridePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFifthOverridePeriod(JAXBElement<Long> value) {
        this.fifthOverridePeriod = value;
    }

    /**
     * Gets the value of the fifthOverrideAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getFifthOverrideAmount() {
        return fifthOverrideAmount;
    }

    /**
     * Sets the value of the fifthOverrideAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setFifthOverrideAmount(JAXBElement<AmountType> value) {
        this.fifthOverrideAmount = value;
    }

    /**
     * Gets the value of the fifthOverrideQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getFifthOverrideQuantity() {
        return fifthOverrideQuantity;
    }

    /**
     * Sets the value of the fifthOverrideQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setFifthOverrideQuantity(JAXBElement<MeasureType> value) {
        this.fifthOverrideQuantity = value;
    }

    /**
     * Gets the value of the secondBillingPeriodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSecondBillingPeriodStartDate() {
        return secondBillingPeriodStartDate;
    }

    /**
     * Sets the value of the secondBillingPeriodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSecondBillingPeriodStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.secondBillingPeriodStartDate = value;
    }

    /**
     * Gets the value of the contractLineAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getContractLineAmount() {
        return contractLineAmount;
    }

    /**
     * Sets the value of the contractLineAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setContractLineAmount(JAXBElement<AmountType> value) {
        this.contractLineAmount = value;
    }

    /**
     * Gets the value of the contractLineQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getContractLineQuantity() {
        return contractLineQuantity;
    }

    /**
     * Sets the value of the contractLineQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setContractLineQuantity(JAXBElement<MeasureType> value) {
        this.contractLineQuantity = value;
    }

    /**
     * Gets the value of the contractLineUnitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getContractLineUnitPrice() {
        return contractLineUnitPrice;
    }

    /**
     * Sets the value of the contractLineUnitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setContractLineUnitPrice(JAXBElement<AmountType> value) {
        this.contractLineUnitPrice = value;
    }

    /**
     * Gets the value of the enforceSequenceDateCorrelation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEnforceSequenceDateCorrelation() {
        return enforceSequenceDateCorrelation;
    }

    /**
     * Sets the value of the enforceSequenceDateCorrelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEnforceSequenceDateCorrelation(JAXBElement<String> value) {
        this.enforceSequenceDateCorrelation = value;
    }

    /**
     * Gets the value of the transactionInterfaceGdf property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceGdf }
     *     
     */
    public TransactionInterfaceGdf getTransactionInterfaceGdf() {
        return transactionInterfaceGdf;
    }

    /**
     * Sets the value of the transactionInterfaceGdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceGdf }
     *     
     */
    public void setTransactionInterfaceGdf(TransactionInterfaceGdf value) {
        this.transactionInterfaceGdf = value;
    }

    /**
     * Gets the value of the transactionLineInterfaceGdf property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionLineInterfaceGdf }
     *     
     */
    public TransactionLineInterfaceGdf getTransactionLineInterfaceGdf() {
        return transactionLineInterfaceGdf;
    }

    /**
     * Sets the value of the transactionLineInterfaceGdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionLineInterfaceGdf }
     *     
     */
    public void setTransactionLineInterfaceGdf(TransactionLineInterfaceGdf value) {
        this.transactionLineInterfaceGdf = value;
    }

    /**
     * Gets the value of the transactionInterfaceLineDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public TransactionInterfaceLineFLEX getTransactionInterfaceLineDff() {
        return transactionInterfaceLineDff;
    }

    /**
     * Sets the value of the transactionInterfaceLineDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public void setTransactionInterfaceLineDff(TransactionInterfaceLineFLEX value) {
        this.transactionInterfaceLineDff = value;
    }

    /**
     * Gets the value of the transactionInterfaceLinkToDff property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceLineLinkToFLEX }
     *     
     */
    public InterfaceLineLinkToFLEX getTransactionInterfaceLinkToDff() {
        return transactionInterfaceLinkToDff;
    }

    /**
     * Sets the value of the transactionInterfaceLinkToDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceLineLinkToFLEX }
     *     
     */
    public void setTransactionInterfaceLinkToDff(InterfaceLineLinkToFLEX value) {
        this.transactionInterfaceLinkToDff = value;
    }

    /**
     * Gets the value of the transactionInterfaceReferenceDff property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceLineReferenceFLEX }
     *     
     */
    public InterfaceLineReferenceFLEX getTransactionInterfaceReferenceDff() {
        return transactionInterfaceReferenceDff;
    }

    /**
     * Sets the value of the transactionInterfaceReferenceDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceLineReferenceFLEX }
     *     
     */
    public void setTransactionInterfaceReferenceDff(InterfaceLineReferenceFLEX value) {
        this.transactionInterfaceReferenceDff = value;
    }

    /**
     * Gets the value of the transactionLineDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionLineFLEX }
     *     
     */
    public TransactionLineFLEX getTransactionLineDff() {
        return transactionLineDff;
    }

    /**
     * Sets the value of the transactionLineDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionLineFLEX }
     *     
     */
    public void setTransactionLineDff(TransactionLineFLEX value) {
        this.transactionLineDff = value;
    }

    /**
     * Gets the value of the transactionInterfaceHeaderDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceHeaderFLEX }
     *     
     */
    public TransactionInterfaceHeaderFLEX getTransactionInterfaceHeaderDff() {
        return transactionInterfaceHeaderDff;
    }

    /**
     * Sets the value of the transactionInterfaceHeaderDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceHeaderFLEX }
     *     
     */
    public void setTransactionInterfaceHeaderDff(TransactionInterfaceHeaderFLEX value) {
        this.transactionInterfaceHeaderDff = value;
    }

}
