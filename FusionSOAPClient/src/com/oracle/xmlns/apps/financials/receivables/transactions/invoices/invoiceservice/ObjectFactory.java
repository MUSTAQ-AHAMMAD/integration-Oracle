
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InterfaceContingency_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "interfaceContingency");
    private final static QName _InvoiceLine_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "invoiceLine");
    private final static QName _InterfaceLine_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "interfaceLine");
    private final static QName _InvoiceDistribution_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "invoiceDistribution");
    private final static QName _UpdateCCTokenResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "updateCCTokenResult");
    private final static QName _Invoice_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "invoice");
    private final static QName _InterfaceSalesCredit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "interfaceSalesCredit");
    private final static QName _UpdateCCToken_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "updateCCToken");
    private final static QName _InterfaceDistribution_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "interfaceDistribution");
    private final static QName _InvoiceResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "invoiceResult");
    private final static QName _InterfaceDistributionInterimTaxCcid_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "InterimTaxCcid");
    private final static QName _InterfaceDistributionPercent_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Percent");
    private final static QName _InterfaceDistributionAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Amount");
    private final static QName _InterfaceDistributionCodeCombinationId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CodeCombinationId");
    private final static QName _InterfaceDistributionAcctdAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AcctdAmount");
    private final static QName _InvoiceLineMemoLineName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "MemoLineName");
    private final static QName _InvoiceLineItemNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ItemNumber");
    private final static QName _InvoiceLineDescription_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Description");
    private final static QName _InvoiceLineTaxClassificationCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxClassificationCode");
    private final static QName _InvoiceLineQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Quantity");
    private final static QName _InvoiceLineSalesOrderLine_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesOrderLine");
    private final static QName _InvoiceLineUnitSellingPrice_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "UnitSellingPrice");
    private final static QName _InvoiceLineSalesOrder_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesOrder");
    private final static QName _InvoiceConversionRate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ConversionRate");
    private final static QName _InvoiceBusinessUnit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BusinessUnit");
    private final static QName _InvoicePurchaseOrder_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PurchaseOrder");
    private final static QName _InvoiceBillToContact_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillToContact");
    private final static QName _InvoiceBillToLocation_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillToLocation");
    private final static QName _InvoiceConversionDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ConversionDate");
    private final static QName _InvoiceTrxNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TrxNumber");
    private final static QName _InvoiceBillToCustomerName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillToCustomerName");
    private final static QName _InvoiceTransactionType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TransactionType");
    private final static QName _InvoiceSoldToCustomerName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SoldToCustomerName");
    private final static QName _InvoiceTransactionSource_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TransactionSource");
    private final static QName _InvoicePaymentTermsName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PaymentTermsName");
    private final static QName _InvoiceGlDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "GlDate");
    private final static QName _InvoiceBillToAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillToAccountNumber");
    private final static QName _InvoiceConversionRateType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ConversionRateType");
    private final static QName _InvoiceDistributionDistLineNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "DistLineNumber");
    private final static QName _InvoiceDistributionConcatSegment_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ConcatSegment");
    private final static QName _InterfaceContingencyExpirationDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ExpirationDate");
    private final static QName _InterfaceContingencyContingencyCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContingencyCode");
    private final static QName _InterfaceContingencyCompleted_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Completed");
    private final static QName _InterfaceContingencyExpirationEventDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ExpirationEventDate");
    private final static QName _InterfaceContingencyExpirationDays_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ExpirationDays");
    private final static QName _InvoiceResultTransactionNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TransactionNumber");
    private final static QName _InvoiceResultServiceStatus_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ServiceStatus");
    private final static QName _InvoiceResultCustomerTrxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CustomerTrxId");
    private final static QName _InterfaceLineAuthorizationComplete_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AuthorizationComplete");
    private final static QName _InterfaceLineLegalEntityId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "LegalEntityId");
    private final static QName _InterfaceLineFirstOverrideQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FirstOverrideQuantity");
    private final static QName _InterfaceLinePrimarySalesrepNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PrimarySalesrepNumber");
    private final static QName _InterfaceLineReceiptMethodName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ReceiptMethodName");
    private final static QName _InterfaceLineSalesOrderDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesOrderDate");
    private final static QName _InterfaceLineAddressVerificationCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AddressVerificationCode");
    private final static QName _InterfaceLineOrigSystemBillContactId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBillContactId");
    private final static QName _InterfaceLineContractStartDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractStartDate");
    private final static QName _InterfaceLineTaxExemptReasonCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxExemptReasonCode");
    private final static QName _InterfaceLineTaxInvoiceDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxInvoiceDate");
    private final static QName _InterfaceLineOrigSystemShipPartySiteReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipPartySiteReference");
    private final static QName _InterfaceLineCustomerTrxTypeSequenceId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CustomerTrxTypeSequenceId");
    private final static QName _InterfaceLineInvoicingRuleName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "InvoicingRuleName");
    private final static QName _InterfaceLineBillingDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillingDate");
    private final static QName _InterfaceLineSourceTrxLineType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceTrxLineType");
    private final static QName _InterfaceLineOrigSystemBillCustomerId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBillCustomerId");
    private final static QName _InterfaceLineOrigSystemShipCustomerReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipCustomerReference");
    private final static QName _InterfaceLineTaxExempt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxExempt");
    private final static QName _InterfaceLineTrxBusinessCategory_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TrxBusinessCategory");
    private final static QName _InterfaceLineFifthOverrideAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FifthOverrideAmount");
    private final static QName _InterfaceLineOrigSystemShipPtyContactId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipPtyContactId");
    private final static QName _InterfaceLineProductFiscClassification_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ProductFiscClassification");
    private final static QName _InterfaceLineAccountingRuleId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AccountingRuleId");
    private final static QName _InterfaceLinePurchaseOrderDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PurchaseOrderDate");
    private final static QName _InterfaceLineQuantityOrdered_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "QuantityOrdered");
    private final static QName _InterfaceLineOrigSystemShipPartyId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipPartyId");
    private final static QName _InterfaceLineSourceEntityCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceEntityCode");
    private final static QName _InterfaceLineContractLineAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractLineAmount");
    private final static QName _InterfaceLinePaymentTrxnExtensionId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PaymentTrxnExtensionId");
    private final static QName _InterfaceLineSecondOverrideAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SecondOverrideAmount");
    private final static QName _InterfaceLineFourthOverrideQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FourthOverrideQuantity");
    private final static QName _InterfaceLineSourceTrxDetailTaxLineId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceTrxDetailTaxLineId");
    private final static QName _InterfaceLineSecondBillingPeriodStartDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SecondBillingPeriodStartDate");
    private final static QName _InterfaceLineContractEndDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractEndDate");
    private final static QName _InterfaceLineTaxableAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxableAmount");
    private final static QName _InterfaceLineSetOfBooksId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SetOfBooksId");
    private final static QName _InterfaceLineTaxRateCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxRateCode");
    private final static QName _InterfaceLineRuleStartDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "RuleStartDate");
    private final static QName _InterfaceLineInternalNotes_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "InternalNotes");
    private final static QName _InterfaceLineWarehouseId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "WarehouseId");
    private final static QName _InterfaceLineDocumentNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "DocumentNumber");
    private final static QName _InterfaceLineSourceEventClassCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceEventClassCode");
    private final static QName _InterfaceLineEnforceSequenceDateCorrelation_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "EnforceSequenceDateCorrelation");
    private final static QName _InterfaceLineSecondInvoiceDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SecondInvoiceDate");
    private final static QName _InterfaceLineOrigSystemShipCustomerId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipCustomerId");
    private final static QName _InterfaceLineLastPeriodToCredit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "LastPeriodToCredit");
    private final static QName _InterfaceLineOrigSystemSoldPartyId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemSoldPartyId");
    private final static QName _InterfaceLineOrigSystemShipAddressReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipAddressReference");
    private final static QName _InterfaceLineUOMCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "UOMCode");
    private final static QName _InterfaceLineOrigSystemBatchName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBatchName");
    private final static QName _InterfaceLineReasonCodeMeaning_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ReasonCodeMeaning");
    private final static QName _InterfaceLineThirdPtyRegId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ThirdPtyRegId");
    private final static QName _InterfaceLineSalesTaxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesTaxId");
    private final static QName _InterfaceLineTaxExemptNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxExemptNumber");
    private final static QName _InterfaceLineShipVia_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ShipVia");
    private final static QName _InterfaceLineOrigSystemShipPtyContactReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipPtyContactReference");
    private final static QName _InterfaceLineWarehouseCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "WarehouseCode");
    private final static QName _InterfaceLineBillCustomerAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillCustomerAccountNumber");
    private final static QName _InterfaceLineDefaultTaxationCountry_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "DefaultTaxationCountry");
    private final static QName _InterfaceLineTaxJurisdictionCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxJurisdictionCode");
    private final static QName _InterfaceLineOrigSystemShipAddressId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipAddressId");
    private final static QName _InterfaceLineConsBillingNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ConsBillingNumber");
    private final static QName _InterfaceLineSourceTrxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceTrxId");
    private final static QName _InterfaceLineSecondOverrideQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SecondOverrideQuantity");
    private final static QName _InterfaceLineApplicationId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ApplicationId");
    private final static QName _InterfaceLineExemptionId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ExemptionId");
    private final static QName _InterfaceLineFourthOverrideAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FourthOverrideAmount");
    private final static QName _InterfaceLineContractLineUnitPrice_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractLineUnitPrice");
    private final static QName _InterfaceLineCreditMethodForAccountRule_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditMethodForAccountRule");
    private final static QName _InterfaceLineThirdOverrideQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ThirdOverrideQuantity");
    private final static QName _InterfaceLineFifthOverrideQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FifthOverrideQuantity");
    private final static QName _InterfaceLineCreditMethodForInstallments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditMethodForInstallments");
    private final static QName _InterfaceLineOrigSystemBillAddressId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBillAddressId");
    private final static QName _InterfaceLineFinalDischargeLocationCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FinalDischargeLocationCode");
    private final static QName _InterfaceLineLastTrxDebitAuth_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "LastTrxDebitAuth");
    private final static QName _InterfaceLineInventoryItemId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "InventoryItemId");
    private final static QName _InterfaceLineOrigSystemBillCustomerReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBillCustomerReference");
    private final static QName _InterfaceLineProductType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ProductType");
    private final static QName _InterfaceLinePaymentTermsId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PaymentTermsId");
    private final static QName _InterfaceLineDeferralExclusion_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "DeferralExclusion");
    private final static QName _InterfaceLineTaxPrecedence_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxPrecedence");
    private final static QName _InterfaceLineAmountIncludesTax_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AmountIncludesTax");
    private final static QName _InterfaceLineDocumentSubType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "DocumentSubType");
    private final static QName _InterfaceLineOrigSystemShipPartySiteId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipPartySiteId");
    private final static QName _InterfaceLineAccountingRuleName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AccountingRuleName");
    private final static QName _InterfaceLineTaxExemptReasonCodeMeaning_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxExemptReasonCodeMeaning");
    private final static QName _InterfaceLineCustomerBankAccountName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CustomerBankAccountName");
    private final static QName _InterfaceLineTaxCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxCode");
    private final static QName _InterfaceLineContractedPeriods_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractedPeriods");
    private final static QName _InterfaceLineOrigSystemBillAddressReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBillAddressReference");
    private final static QName _InterfaceLineRelatedBatchSourceName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "RelatedBatchSourceName");
    private final static QName _InterfaceLineSourceApplicationId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceApplicationId");
    private final static QName _InterfaceLineFifthOverridePeriod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FifthOverridePeriod");
    private final static QName _InterfaceLineAccountingRuleDuration_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AccountingRuleDuration");
    private final static QName _InterfaceLineTaxRate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxRate");
    private final static QName _InterfaceLineRecurringBill_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "RecurringBill");
    private final static QName _InterfaceLineReferenceLineId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ReferenceLineId");
    private final static QName _InterfaceLineUnitStandardPrice_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "UnitStandardPrice");
    private final static QName _InterfaceLineFirstPtyRegNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FirstPtyRegNumber");
    private final static QName _InterfaceLineLineIntendedUse_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "LineIntendedUse");
    private final static QName _InterfaceLineWaybillNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "WaybillNumber");
    private final static QName _InterfaceLineAuthorizationNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AuthorizationNumber");
    private final static QName _InterfaceLineOrigSystemSoldPartyReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemSoldPartyReference");
    private final static QName _InterfaceLineOverrideAutoAccounting_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OverrideAutoAccounting");
    private final static QName _InterfaceLineBillContactPartyNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillContactPartyNumber");
    private final static QName _InterfaceLineThirdOverridePeriod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ThirdOverridePeriod");
    private final static QName _InterfaceLineFourthOverridePeriod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FourthOverridePeriod");
    private final static QName _InterfaceLineOrigSystemShipPartyReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipPartyReference");
    private final static QName _InterfaceLineOrigSystemShipContactReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipContactReference");
    private final static QName _InterfaceLineOrigSystemBillContactReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemBillContactReference");
    private final static QName _InterfaceLineInvoicedLineAcctgLevel_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "InvoicedLineAcctgLevel");
    private final static QName _InterfaceLineProdFcCategId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ProdFcCategId");
    private final static QName _InterfaceLineBillCustomerSiteNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "BillCustomerSiteNumber");
    private final static QName _InterfaceLinePaymentAttributes_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PaymentAttributes");
    private final static QName _InterfaceLineFirstOverridePeriod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FirstOverridePeriod");
    private final static QName _InterfaceLineReceiptMethodId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ReceiptMethodId");
    private final static QName _InterfaceLineTaxStatusCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxStatusCode");
    private final static QName _InterfaceLineShipContactPartyNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ShipContactPartyNumber");
    private final static QName _InterfaceLineInvoicingRuleId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "InvoicingRuleId");
    private final static QName _InterfaceLineComments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Comments");
    private final static QName _InterfaceLineShipCustomerSiteNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ShipCustomerSiteNumber");
    private final static QName _InterfaceLineContractId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractId");
    private final static QName _InterfaceLineFinalDischargeLocationId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FinalDischargeLocationId");
    private final static QName _InterfaceLineFirstPtyRegId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FirstPtyRegId");
    private final static QName _InterfaceLinePaymentServerOrderNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PaymentServerOrderNumber");
    private final static QName _InterfaceLineApprovalCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ApprovalCode");
    private final static QName _InterfaceLineIntendedUseClassifId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "IntendedUseClassifId");
    private final static QName _InterfaceLineUserDefinedFiscClass_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "UserDefinedFiscClass");
    private final static QName _InterfaceLineRelatedTrxNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "RelatedTrxNumber");
    private final static QName _InterfaceLineTranslatedDescription_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TranslatedDescription");
    private final static QName _InterfaceLineSoldCustomerAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SoldCustomerAccountNumber");
    private final static QName _InterfaceLineTaxRegimeCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxRegimeCode");
    private final static QName _InterfaceLineThirdOverrideAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ThirdOverrideAmount");
    private final static QName _InterfaceLineOrigSystemSoldCustomerId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemSoldCustomerId");
    private final static QName _InterfaceLineRuleEndDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "RuleEndDate");
    private final static QName _InterfaceLineThirdPtyRegNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ThirdPtyRegNumber");
    private final static QName _InterfaceLineCustomerTrxTypeName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CustomerTrxTypeName");
    private final static QName _InterfaceLineMemoLineSequenceId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "MemoLineSequenceId");
    private final static QName _InterfaceLineContractLineId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractLineId");
    private final static QName _InterfaceLineSourceTrxLineId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SourceTrxLineId");
    private final static QName _InterfaceLineOrigSystemSoldCustomerReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemSoldCustomerReference");
    private final static QName _InterfaceLineTax_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Tax");
    private final static QName _InterfaceLineResourceSalesrepId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ResourceSalesrepId");
    private final static QName _InterfaceLineContractLineQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ContractLineQuantity");
    private final static QName _InterfaceLineFirstOverrideAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FirstOverrideAmount");
    private final static QName _InterfaceLineSalesOrderRevision_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesOrderRevision");
    private final static QName _InterfaceLineProductCategory_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ProductCategory");
    private final static QName _InterfaceLineAssessableValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "AssessableValue");
    private final static QName _InterfaceLineOrigSystemShipContactId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "OrigSystemShipContactId");
    private final static QName _InterfaceLineUOMName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "UOMName");
    private final static QName _InterfaceLinePrintingOption_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PrintingOption");
    private final static QName _InterfaceLineTaxable_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Taxable");
    private final static QName _InterfaceLinePurchaseOrderRevision_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PurchaseOrderRevision");
    private final static QName _InterfaceLineVATTaxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "VATTaxId");
    private final static QName _InterfaceLineSecondOverridePeriod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SecondOverridePeriod");
    private final static QName _InterfaceLineShipCustomerAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ShipCustomerAccountNumber");
    private final static QName _InterfaceLineTrxDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TrxDate");
    private final static QName _InterfaceLinePeriodicity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "Periodicity");
    private final static QName _InterfaceLineShipDateActual_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ShipDateActual");
    private final static QName _InterfaceLineTaxInvoiceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "TaxInvoiceNumber");
    private final static QName _InterfaceLinePaymentSetId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "PaymentSetId");
    private final static QName _InterfaceLineExceptionId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ExceptionId");
    private final static QName _InterfaceLineReasonCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ReasonCode");
    private final static QName _InterfaceLineSalesOrderSource_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesOrderSource");
    private final static QName _InterfaceLineFOBPoint_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "FOBPoint");
    private final static QName _InterfaceLineResetTrxDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "ResetTrxDate");
    private final static QName _InterfaceSalesCreditSalesrepNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesrepNumber");
    private final static QName _InterfaceSalesCreditSalesCreditPercentSplit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesCreditPercentSplit");
    private final static QName _InterfaceSalesCreditSalesCreditAmountSplit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesCreditAmountSplit");
    private final static QName _InterfaceSalesCreditSalesCreditTypeId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesCreditTypeId");
    private final static QName _InterfaceSalesCreditSalesgroupId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesgroupId");
    private final static QName _InterfaceSalesCreditSalesCreditTypeName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "SalesCreditTypeName");
    private final static QName _UpdateCCTokenCreditCardVoiceAuthorizationCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditCardVoiceAuthorizationCode");
    private final static QName _UpdateCCTokenCreditCardExpirationDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditCardExpirationDate");
    private final static QName _UpdateCCTokenCardHolderLastName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CardHolderLastName");
    private final static QName _UpdateCCTokenMaskedCreditCardNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "MaskedCreditCardNumber");
    private final static QName _UpdateCCTokenCreditCardAuthorizationRequestIdentifier_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditCardAuthorizationRequestIdentifier");
    private final static QName _UpdateCCTokenCardHolderFirstName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CardHolderFirstName");
    private final static QName _UpdateCCTokenCreditCardIssuerCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditCardIssuerCode");
    private final static QName _UpdateCCTokenCreditCardTokenNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", "CreditCardTokenNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InterfaceContingency }
     * 
     */
    public InterfaceContingency createInterfaceContingency() {
        return new InterfaceContingency();
    }

    /**
     * Create an instance of {@link InterfaceDistribution }
     * 
     */
    public InterfaceDistribution createInterfaceDistribution() {
        return new InterfaceDistribution();
    }

    /**
     * Create an instance of {@link InterfaceSalesCredit }
     * 
     */
    public InterfaceSalesCredit createInterfaceSalesCredit() {
        return new InterfaceSalesCredit();
    }

    /**
     * Create an instance of {@link InvoiceResult }
     * 
     */
    public InvoiceResult createInvoiceResult() {
        return new InvoiceResult();
    }

    /**
     * Create an instance of {@link InterfaceLine }
     * 
     */
    public InterfaceLine createInterfaceLine() {
        return new InterfaceLine();
    }

    /**
     * Create an instance of {@link UpdateCCTokenResult }
     * 
     */
    public UpdateCCTokenResult createUpdateCCTokenResult() {
        return new UpdateCCTokenResult();
    }

    /**
     * Create an instance of {@link UpdateCCToken }
     * 
     */
    public UpdateCCToken createUpdateCCToken() {
        return new UpdateCCToken();
    }

    /**
     * Create an instance of {@link Invoice }
     * 
     */
    public Invoice createInvoice() {
        return new Invoice();
    }

    /**
     * Create an instance of {@link InvoiceDistribution }
     * 
     */
    public InvoiceDistribution createInvoiceDistribution() {
        return new InvoiceDistribution();
    }

    /**
     * Create an instance of {@link InvoiceLine }
     * 
     */
    public InvoiceLine createInvoiceLine() {
        return new InvoiceLine();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterfaceContingency }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "interfaceContingency")
    public JAXBElement<InterfaceContingency> createInterfaceContingency(InterfaceContingency value) {
        return new JAXBElement<InterfaceContingency>(_InterfaceContingency_QNAME, InterfaceContingency.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "invoiceLine")
    public JAXBElement<InvoiceLine> createInvoiceLine(InvoiceLine value) {
        return new JAXBElement<InvoiceLine>(_InvoiceLine_QNAME, InvoiceLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterfaceLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "interfaceLine")
    public JAXBElement<InterfaceLine> createInterfaceLine(InterfaceLine value) {
        return new JAXBElement<InterfaceLine>(_InterfaceLine_QNAME, InterfaceLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceDistribution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "invoiceDistribution")
    public JAXBElement<InvoiceDistribution> createInvoiceDistribution(InvoiceDistribution value) {
        return new JAXBElement<InvoiceDistribution>(_InvoiceDistribution_QNAME, InvoiceDistribution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCCTokenResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "updateCCTokenResult")
    public JAXBElement<UpdateCCTokenResult> createUpdateCCTokenResult(UpdateCCTokenResult value) {
        return new JAXBElement<UpdateCCTokenResult>(_UpdateCCTokenResult_QNAME, UpdateCCTokenResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invoice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "invoice")
    public JAXBElement<Invoice> createInvoice(Invoice value) {
        return new JAXBElement<Invoice>(_Invoice_QNAME, Invoice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterfaceSalesCredit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "interfaceSalesCredit")
    public JAXBElement<InterfaceSalesCredit> createInterfaceSalesCredit(InterfaceSalesCredit value) {
        return new JAXBElement<InterfaceSalesCredit>(_InterfaceSalesCredit_QNAME, InterfaceSalesCredit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCCToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "updateCCToken")
    public JAXBElement<UpdateCCToken> createUpdateCCToken(UpdateCCToken value) {
        return new JAXBElement<UpdateCCToken>(_UpdateCCToken_QNAME, UpdateCCToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterfaceDistribution }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "interfaceDistribution")
    public JAXBElement<InterfaceDistribution> createInterfaceDistribution(InterfaceDistribution value) {
        return new JAXBElement<InterfaceDistribution>(_InterfaceDistribution_QNAME, InterfaceDistribution.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "invoiceResult")
    public JAXBElement<InvoiceResult> createInvoiceResult(InvoiceResult value) {
        return new JAXBElement<InvoiceResult>(_InvoiceResult_QNAME, InvoiceResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "InterimTaxCcid", scope = InterfaceDistribution.class)
    public JAXBElement<Long> createInterfaceDistributionInterimTaxCcid(Long value) {
        return new JAXBElement<Long>(_InterfaceDistributionInterimTaxCcid_QNAME, Long.class, InterfaceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Percent", scope = InterfaceDistribution.class)
    public JAXBElement<BigDecimal> createInterfaceDistributionPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceDistributionPercent_QNAME, BigDecimal.class, InterfaceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Amount", scope = InterfaceDistribution.class)
    public JAXBElement<AmountType> createInterfaceDistributionAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceDistributionAmount_QNAME, AmountType.class, InterfaceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CodeCombinationId", scope = InterfaceDistribution.class)
    public JAXBElement<Long> createInterfaceDistributionCodeCombinationId(Long value) {
        return new JAXBElement<Long>(_InterfaceDistributionCodeCombinationId_QNAME, Long.class, InterfaceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AcctdAmount", scope = InterfaceDistribution.class)
    public JAXBElement<AmountType> createInterfaceDistributionAcctdAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceDistributionAcctdAmount_QNAME, AmountType.class, InterfaceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "MemoLineName", scope = InvoiceLine.class)
    public JAXBElement<String> createInvoiceLineMemoLineName(String value) {
        return new JAXBElement<String>(_InvoiceLineMemoLineName_QNAME, String.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ItemNumber", scope = InvoiceLine.class)
    public JAXBElement<String> createInvoiceLineItemNumber(String value) {
        return new JAXBElement<String>(_InvoiceLineItemNumber_QNAME, String.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Description", scope = InvoiceLine.class)
    public JAXBElement<String> createInvoiceLineDescription(String value) {
        return new JAXBElement<String>(_InvoiceLineDescription_QNAME, String.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxClassificationCode", scope = InvoiceLine.class)
    public JAXBElement<String> createInvoiceLineTaxClassificationCode(String value) {
        return new JAXBElement<String>(_InvoiceLineTaxClassificationCode_QNAME, String.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Quantity", scope = InvoiceLine.class)
    public JAXBElement<MeasureType> createInvoiceLineQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InvoiceLineQuantity_QNAME, MeasureType.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrderLine", scope = InvoiceLine.class)
    public JAXBElement<String> createInvoiceLineSalesOrderLine(String value) {
        return new JAXBElement<String>(_InvoiceLineSalesOrderLine_QNAME, String.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "UnitSellingPrice", scope = InvoiceLine.class)
    public JAXBElement<AmountType> createInvoiceLineUnitSellingPrice(AmountType value) {
        return new JAXBElement<AmountType>(_InvoiceLineUnitSellingPrice_QNAME, AmountType.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrder", scope = InvoiceLine.class)
    public JAXBElement<String> createInvoiceLineSalesOrder(String value) {
        return new JAXBElement<String>(_InvoiceLineSalesOrder_QNAME, String.class, InvoiceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConversionRate", scope = Invoice.class)
    public JAXBElement<BigDecimal> createInvoiceConversionRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InvoiceConversionRate_QNAME, BigDecimal.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BusinessUnit", scope = Invoice.class)
    public JAXBElement<String> createInvoiceBusinessUnit(String value) {
        return new JAXBElement<String>(_InvoiceBusinessUnit_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PurchaseOrder", scope = Invoice.class)
    public JAXBElement<String> createInvoicePurchaseOrder(String value) {
        return new JAXBElement<String>(_InvoicePurchaseOrder_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillToContact", scope = Invoice.class)
    public JAXBElement<String> createInvoiceBillToContact(String value) {
        return new JAXBElement<String>(_InvoiceBillToContact_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillToLocation", scope = Invoice.class)
    public JAXBElement<String> createInvoiceBillToLocation(String value) {
        return new JAXBElement<String>(_InvoiceBillToLocation_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConversionDate", scope = Invoice.class)
    public JAXBElement<XMLGregorianCalendar> createInvoiceConversionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InvoiceConversionDate_QNAME, XMLGregorianCalendar.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TrxNumber", scope = Invoice.class)
    public JAXBElement<String> createInvoiceTrxNumber(String value) {
        return new JAXBElement<String>(_InvoiceTrxNumber_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillToCustomerName", scope = Invoice.class)
    public JAXBElement<String> createInvoiceBillToCustomerName(String value) {
        return new JAXBElement<String>(_InvoiceBillToCustomerName_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TransactionType", scope = Invoice.class)
    public JAXBElement<String> createInvoiceTransactionType(String value) {
        return new JAXBElement<String>(_InvoiceTransactionType_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SoldToCustomerName", scope = Invoice.class)
    public JAXBElement<String> createInvoiceSoldToCustomerName(String value) {
        return new JAXBElement<String>(_InvoiceSoldToCustomerName_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TransactionSource", scope = Invoice.class)
    public JAXBElement<String> createInvoiceTransactionSource(String value) {
        return new JAXBElement<String>(_InvoiceTransactionSource_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentTermsName", scope = Invoice.class)
    public JAXBElement<String> createInvoicePaymentTermsName(String value) {
        return new JAXBElement<String>(_InvoicePaymentTermsName_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "GlDate", scope = Invoice.class)
    public JAXBElement<XMLGregorianCalendar> createInvoiceGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InvoiceGlDate_QNAME, XMLGregorianCalendar.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillToAccountNumber", scope = Invoice.class)
    public JAXBElement<String> createInvoiceBillToAccountNumber(String value) {
        return new JAXBElement<String>(_InvoiceBillToAccountNumber_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConversionRateType", scope = Invoice.class)
    public JAXBElement<String> createInvoiceConversionRateType(String value) {
        return new JAXBElement<String>(_InvoiceConversionRateType_QNAME, String.class, Invoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Percent", scope = InvoiceDistribution.class)
    public JAXBElement<BigDecimal> createInvoiceDistributionPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceDistributionPercent_QNAME, BigDecimal.class, InvoiceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Amount", scope = InvoiceDistribution.class)
    public JAXBElement<AmountType> createInvoiceDistributionAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceDistributionAmount_QNAME, AmountType.class, InvoiceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "DistLineNumber", scope = InvoiceDistribution.class)
    public JAXBElement<Integer> createInvoiceDistributionDistLineNumber(Integer value) {
        return new JAXBElement<Integer>(_InvoiceDistributionDistLineNumber_QNAME, Integer.class, InvoiceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConcatSegment", scope = InvoiceDistribution.class)
    public JAXBElement<String> createInvoiceDistributionConcatSegment(String value) {
        return new JAXBElement<String>(_InvoiceDistributionConcatSegment_QNAME, String.class, InvoiceDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ExpirationDate", scope = InterfaceContingency.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceContingencyExpirationDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceContingencyExpirationDate_QNAME, XMLGregorianCalendar.class, InterfaceContingency.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContingencyCode", scope = InterfaceContingency.class)
    public JAXBElement<String> createInterfaceContingencyContingencyCode(String value) {
        return new JAXBElement<String>(_InterfaceContingencyContingencyCode_QNAME, String.class, InterfaceContingency.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Completed", scope = InterfaceContingency.class)
    public JAXBElement<String> createInterfaceContingencyCompleted(String value) {
        return new JAXBElement<String>(_InterfaceContingencyCompleted_QNAME, String.class, InterfaceContingency.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ExpirationEventDate", scope = InterfaceContingency.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceContingencyExpirationEventDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceContingencyExpirationEventDate_QNAME, XMLGregorianCalendar.class, InterfaceContingency.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ExpirationDays", scope = InterfaceContingency.class)
    public JAXBElement<BigDecimal> createInterfaceContingencyExpirationDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceContingencyExpirationDays_QNAME, BigDecimal.class, InterfaceContingency.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TransactionNumber", scope = InvoiceResult.class)
    public JAXBElement<String> createInvoiceResultTransactionNumber(String value) {
        return new JAXBElement<String>(_InvoiceResultTransactionNumber_QNAME, String.class, InvoiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ServiceStatus", scope = InvoiceResult.class)
    public JAXBElement<String> createInvoiceResultServiceStatus(String value) {
        return new JAXBElement<String>(_InvoiceResultServiceStatus_QNAME, String.class, InvoiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CustomerTrxId", scope = InvoiceResult.class)
    public JAXBElement<Long> createInvoiceResultCustomerTrxId(Long value) {
        return new JAXBElement<Long>(_InvoiceResultCustomerTrxId_QNAME, Long.class, InvoiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AuthorizationComplete", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineAuthorizationComplete(String value) {
        return new JAXBElement<String>(_InterfaceLineAuthorizationComplete_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "MemoLineName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineMemoLineName(String value) {
        return new JAXBElement<String>(_InvoiceLineMemoLineName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "LegalEntityId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineLegalEntityId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineLegalEntityId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FirstOverrideQuantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineFirstOverrideQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InterfaceLineFirstOverrideQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PrimarySalesrepNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePrimarySalesrepNumber(String value) {
        return new JAXBElement<String>(_InterfaceLinePrimarySalesrepNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ReceiptMethodName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineReceiptMethodName(String value) {
        return new JAXBElement<String>(_InterfaceLineReceiptMethodName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrderDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineSalesOrderDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineSalesOrderDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AddressVerificationCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineAddressVerificationCode(String value) {
        return new JAXBElement<String>(_InterfaceLineAddressVerificationCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBillContactId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemBillContactId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemBillContactId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractStartDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineContractStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineContractStartDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxExemptReasonCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxExemptReasonCode(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxExemptReasonCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxInvoiceDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineTaxInvoiceDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineTaxInvoiceDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipPartySiteReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemShipPartySiteReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemShipPartySiteReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CustomerTrxTypeSequenceId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineCustomerTrxTypeSequenceId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineCustomerTrxTypeSequenceId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "InvoicingRuleName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineInvoicingRuleName(String value) {
        return new JAXBElement<String>(_InterfaceLineInvoicingRuleName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillingDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineBillingDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineBillingDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceTrxLineType", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSourceTrxLineType(String value) {
        return new JAXBElement<String>(_InterfaceLineSourceTrxLineType_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBillCustomerId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemBillCustomerId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemBillCustomerId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipCustomerReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemShipCustomerReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemShipCustomerReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxExempt", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxExempt(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxExempt_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TrxBusinessCategory", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTrxBusinessCategory(String value) {
        return new JAXBElement<String>(_InterfaceLineTrxBusinessCategory_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FifthOverrideAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineFifthOverrideAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineFifthOverrideAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipPtyContactId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemShipPtyContactId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemShipPtyContactId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConversionRate", scope = InterfaceLine.class)
    public JAXBElement<BigDecimal> createInterfaceLineConversionRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InvoiceConversionRate_QNAME, BigDecimal.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ProductFiscClassification", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineProductFiscClassification(String value) {
        return new JAXBElement<String>(_InterfaceLineProductFiscClassification_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AccountingRuleId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineAccountingRuleId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineAccountingRuleId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PurchaseOrderDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLinePurchaseOrderDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLinePurchaseOrderDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "QuantityOrdered", scope = InterfaceLine.class)
    public JAXBElement<BigDecimal> createInterfaceLineQuantityOrdered(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceLineQuantityOrdered_QNAME, BigDecimal.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PurchaseOrder", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePurchaseOrder(String value) {
        return new JAXBElement<String>(_InvoicePurchaseOrder_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipPartyId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemShipPartyId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemShipPartyId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceEntityCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSourceEntityCode(String value) {
        return new JAXBElement<String>(_InterfaceLineSourceEntityCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractLineAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineContractLineAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineContractLineAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentTrxnExtensionId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLinePaymentTrxnExtensionId(Long value) {
        return new JAXBElement<Long>(_InterfaceLinePaymentTrxnExtensionId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SecondOverrideAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineSecondOverrideAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineSecondOverrideAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FourthOverrideQuantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineFourthOverrideQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InterfaceLineFourthOverrideQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceTrxDetailTaxLineId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSourceTrxDetailTaxLineId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSourceTrxDetailTaxLineId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SecondBillingPeriodStartDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineSecondBillingPeriodStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineSecondBillingPeriodStartDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractEndDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineContractEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineContractEndDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxableAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineTaxableAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineTaxableAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Amount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceDistributionAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SetOfBooksId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSetOfBooksId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSetOfBooksId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxRateCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxRateCode(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxRateCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "GlDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InvoiceGlDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "RuleStartDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineRuleStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineRuleStartDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "InternalNotes", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineInternalNotes(String value) {
        return new JAXBElement<String>(_InterfaceLineInternalNotes_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "WarehouseId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineWarehouseId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineWarehouseId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "DocumentNumber", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineDocumentNumber(Long value) {
        return new JAXBElement<Long>(_InterfaceLineDocumentNumber_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceEventClassCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSourceEventClassCode(String value) {
        return new JAXBElement<String>(_InterfaceLineSourceEventClassCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "EnforceSequenceDateCorrelation", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineEnforceSequenceDateCorrelation(String value) {
        return new JAXBElement<String>(_InterfaceLineEnforceSequenceDateCorrelation_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SecondInvoiceDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineSecondInvoiceDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineSecondInvoiceDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipCustomerId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemShipCustomerId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemShipCustomerId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "LastPeriodToCredit", scope = InterfaceLine.class)
    public JAXBElement<Integer> createInterfaceLineLastPeriodToCredit(Integer value) {
        return new JAXBElement<Integer>(_InterfaceLineLastPeriodToCredit_QNAME, Integer.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemSoldPartyId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemSoldPartyId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemSoldPartyId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrderLine", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSalesOrderLine(String value) {
        return new JAXBElement<String>(_InvoiceLineSalesOrderLine_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipAddressReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemShipAddressReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemShipAddressReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "UOMCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineUOMCode(String value) {
        return new JAXBElement<String>(_InterfaceLineUOMCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBatchName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemBatchName(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemBatchName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ReasonCodeMeaning", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineReasonCodeMeaning(String value) {
        return new JAXBElement<String>(_InterfaceLineReasonCodeMeaning_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ThirdPtyRegId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineThirdPtyRegId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineThirdPtyRegId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesTaxId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSalesTaxId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSalesTaxId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxExemptNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxExemptNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxExemptNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ShipVia", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineShipVia(String value) {
        return new JAXBElement<String>(_InterfaceLineShipVia_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipPtyContactReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemShipPtyContactReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemShipPtyContactReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "WarehouseCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineWarehouseCode(String value) {
        return new JAXBElement<String>(_InterfaceLineWarehouseCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillCustomerAccountNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineBillCustomerAccountNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineBillCustomerAccountNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "DefaultTaxationCountry", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineDefaultTaxationCountry(String value) {
        return new JAXBElement<String>(_InterfaceLineDefaultTaxationCountry_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxJurisdictionCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxJurisdictionCode(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxJurisdictionCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipAddressId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemShipAddressId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemShipAddressId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConsBillingNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineConsBillingNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineConsBillingNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceTrxId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSourceTrxId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSourceTrxId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SecondOverrideQuantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineSecondOverrideQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InterfaceLineSecondOverrideQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ApplicationId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineApplicationId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineApplicationId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ExemptionId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineExemptionId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineExemptionId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FourthOverrideAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineFourthOverrideAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineFourthOverrideAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ConversionDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineConversionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InvoiceConversionDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractLineUnitPrice", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineContractLineUnitPrice(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineContractLineUnitPrice_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditMethodForAccountRule", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineCreditMethodForAccountRule(String value) {
        return new JAXBElement<String>(_InterfaceLineCreditMethodForAccountRule_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ThirdOverrideQuantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineThirdOverrideQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InterfaceLineThirdOverrideQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FifthOverrideQuantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineFifthOverrideQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InterfaceLineFifthOverrideQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditMethodForInstallments", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineCreditMethodForInstallments(String value) {
        return new JAXBElement<String>(_InterfaceLineCreditMethodForInstallments_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBillAddressId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemBillAddressId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemBillAddressId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FinalDischargeLocationCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineFinalDischargeLocationCode(String value) {
        return new JAXBElement<String>(_InterfaceLineFinalDischargeLocationCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "LastTrxDebitAuth", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineLastTrxDebitAuth(String value) {
        return new JAXBElement<String>(_InterfaceLineLastTrxDebitAuth_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "InventoryItemId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineInventoryItemId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineInventoryItemId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBillCustomerReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemBillCustomerReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemBillCustomerReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ProductType", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineProductType(String value) {
        return new JAXBElement<String>(_InterfaceLineProductType_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentTermsId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLinePaymentTermsId(Long value) {
        return new JAXBElement<Long>(_InterfaceLinePaymentTermsId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentTermsName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePaymentTermsName(String value) {
        return new JAXBElement<String>(_InvoicePaymentTermsName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "DeferralExclusion", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineDeferralExclusion(String value) {
        return new JAXBElement<String>(_InterfaceLineDeferralExclusion_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxPrecedence", scope = InterfaceLine.class)
    public JAXBElement<BigDecimal> createInterfaceLineTaxPrecedence(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceLineTaxPrecedence_QNAME, BigDecimal.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AmountIncludesTax", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineAmountIncludesTax(String value) {
        return new JAXBElement<String>(_InterfaceLineAmountIncludesTax_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "DocumentSubType", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineDocumentSubType(String value) {
        return new JAXBElement<String>(_InterfaceLineDocumentSubType_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipPartySiteId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemShipPartySiteId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemShipPartySiteId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AccountingRuleName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineAccountingRuleName(String value) {
        return new JAXBElement<String>(_InterfaceLineAccountingRuleName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxExemptReasonCodeMeaning", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxExemptReasonCodeMeaning(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxExemptReasonCodeMeaning_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ItemNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineItemNumber(String value) {
        return new JAXBElement<String>(_InvoiceLineItemNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CustomerBankAccountName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineCustomerBankAccountName(String value) {
        return new JAXBElement<String>(_InterfaceLineCustomerBankAccountName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxCode(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractedPeriods", scope = InterfaceLine.class)
    public JAXBElement<Integer> createInterfaceLineContractedPeriods(Integer value) {
        return new JAXBElement<Integer>(_InterfaceLineContractedPeriods_QNAME, Integer.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBillAddressReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemBillAddressReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemBillAddressReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "RelatedBatchSourceName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineRelatedBatchSourceName(String value) {
        return new JAXBElement<String>(_InterfaceLineRelatedBatchSourceName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceApplicationId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSourceApplicationId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSourceApplicationId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FifthOverridePeriod", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineFifthOverridePeriod(Long value) {
        return new JAXBElement<Long>(_InterfaceLineFifthOverridePeriod_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AccountingRuleDuration", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineAccountingRuleDuration(Long value) {
        return new JAXBElement<Long>(_InterfaceLineAccountingRuleDuration_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxRate", scope = InterfaceLine.class)
    public JAXBElement<BigDecimal> createInterfaceLineTaxRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceLineTaxRate_QNAME, BigDecimal.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "RecurringBill", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineRecurringBill(String value) {
        return new JAXBElement<String>(_InterfaceLineRecurringBill_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ReferenceLineId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineReferenceLineId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineReferenceLineId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "UnitStandardPrice", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineUnitStandardPrice(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineUnitStandardPrice_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FirstPtyRegNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineFirstPtyRegNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineFirstPtyRegNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "LineIntendedUse", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineLineIntendedUse(String value) {
        return new JAXBElement<String>(_InterfaceLineLineIntendedUse_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "WaybillNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineWaybillNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineWaybillNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AuthorizationNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineAuthorizationNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineAuthorizationNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemSoldPartyReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemSoldPartyReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemSoldPartyReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OverrideAutoAccounting", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOverrideAutoAccounting(String value) {
        return new JAXBElement<String>(_InterfaceLineOverrideAutoAccounting_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillContactPartyNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineBillContactPartyNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineBillContactPartyNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ThirdOverridePeriod", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineThirdOverridePeriod(Long value) {
        return new JAXBElement<Long>(_InterfaceLineThirdOverridePeriod_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FourthOverridePeriod", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineFourthOverridePeriod(Long value) {
        return new JAXBElement<Long>(_InterfaceLineFourthOverridePeriod_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipPartyReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemShipPartyReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemShipPartyReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipContactReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemShipContactReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemShipContactReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemBillContactReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemBillContactReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemBillContactReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "InvoicedLineAcctgLevel", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineInvoicedLineAcctgLevel(String value) {
        return new JAXBElement<String>(_InterfaceLineInvoicedLineAcctgLevel_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ProdFcCategId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineProdFcCategId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineProdFcCategId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "BillCustomerSiteNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineBillCustomerSiteNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineBillCustomerSiteNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentAttributes", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePaymentAttributes(String value) {
        return new JAXBElement<String>(_InterfaceLinePaymentAttributes_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FirstOverridePeriod", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineFirstOverridePeriod(Long value) {
        return new JAXBElement<Long>(_InterfaceLineFirstOverridePeriod_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ReceiptMethodId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineReceiptMethodId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineReceiptMethodId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxStatusCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxStatusCode(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxStatusCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "UnitSellingPrice", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineUnitSellingPrice(AmountType value) {
        return new JAXBElement<AmountType>(_InvoiceLineUnitSellingPrice_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TrxNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTrxNumber(String value) {
        return new JAXBElement<String>(_InvoiceTrxNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ShipContactPartyNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineShipContactPartyNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineShipContactPartyNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "InvoicingRuleId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineInvoicingRuleId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineInvoicingRuleId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Comments", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineComments(String value) {
        return new JAXBElement<String>(_InterfaceLineComments_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ShipCustomerSiteNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineShipCustomerSiteNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineShipCustomerSiteNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Quantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InvoiceLineQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineContractId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineContractId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FinalDischargeLocationId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineFinalDischargeLocationId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineFinalDischargeLocationId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FirstPtyRegId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineFirstPtyRegId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineFirstPtyRegId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentServerOrderNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePaymentServerOrderNumber(String value) {
        return new JAXBElement<String>(_InterfaceLinePaymentServerOrderNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ApprovalCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineApprovalCode(String value) {
        return new JAXBElement<String>(_InterfaceLineApprovalCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "IntendedUseClassifId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineIntendedUseClassifId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineIntendedUseClassifId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "UserDefinedFiscClass", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineUserDefinedFiscClass(String value) {
        return new JAXBElement<String>(_InterfaceLineUserDefinedFiscClass_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "RelatedTrxNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineRelatedTrxNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineRelatedTrxNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TranslatedDescription", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTranslatedDescription(String value) {
        return new JAXBElement<String>(_InterfaceLineTranslatedDescription_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SoldCustomerAccountNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSoldCustomerAccountNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineSoldCustomerAccountNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxRegimeCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxRegimeCode(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxRegimeCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ThirdOverrideAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineThirdOverrideAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineThirdOverrideAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrder", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSalesOrder(String value) {
        return new JAXBElement<String>(_InvoiceLineSalesOrder_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemSoldCustomerId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemSoldCustomerId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemSoldCustomerId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "RuleEndDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineRuleEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineRuleEndDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ThirdPtyRegNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineThirdPtyRegNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineThirdPtyRegNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CustomerTrxTypeName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineCustomerTrxTypeName(String value) {
        return new JAXBElement<String>(_InterfaceLineCustomerTrxTypeName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "MemoLineSequenceId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineMemoLineSequenceId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineMemoLineSequenceId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractLineId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineContractLineId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineContractLineId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SourceTrxLineId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSourceTrxLineId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSourceTrxLineId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemSoldCustomerReference", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineOrigSystemSoldCustomerReference(String value) {
        return new JAXBElement<String>(_InterfaceLineOrigSystemSoldCustomerReference_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Tax", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTax(String value) {
        return new JAXBElement<String>(_InterfaceLineTax_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ResourceSalesrepId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineResourceSalesrepId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineResourceSalesrepId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ContractLineQuantity", scope = InterfaceLine.class)
    public JAXBElement<MeasureType> createInterfaceLineContractLineQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_InterfaceLineContractLineQuantity_QNAME, MeasureType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FirstOverrideAmount", scope = InterfaceLine.class)
    public JAXBElement<AmountType> createInterfaceLineFirstOverrideAmount(AmountType value) {
        return new JAXBElement<AmountType>(_InterfaceLineFirstOverrideAmount_QNAME, AmountType.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrderRevision", scope = InterfaceLine.class)
    public JAXBElement<BigDecimal> createInterfaceLineSalesOrderRevision(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceLineSalesOrderRevision_QNAME, BigDecimal.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ProductCategory", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineProductCategory(String value) {
        return new JAXBElement<String>(_InterfaceLineProductCategory_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "AssessableValue", scope = InterfaceLine.class)
    public JAXBElement<BigDecimal> createInterfaceLineAssessableValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceLineAssessableValue_QNAME, BigDecimal.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "OrigSystemShipContactId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineOrigSystemShipContactId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineOrigSystemShipContactId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "UOMName", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineUOMName(String value) {
        return new JAXBElement<String>(_InterfaceLineUOMName_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PrintingOption", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePrintingOption(String value) {
        return new JAXBElement<String>(_InterfaceLinePrintingOption_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Taxable", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxable(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxable_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PurchaseOrderRevision", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePurchaseOrderRevision(String value) {
        return new JAXBElement<String>(_InterfaceLinePurchaseOrderRevision_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "VATTaxId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineVATTaxId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineVATTaxId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SecondOverridePeriod", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineSecondOverridePeriod(Long value) {
        return new JAXBElement<Long>(_InterfaceLineSecondOverridePeriod_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ShipCustomerAccountNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineShipCustomerAccountNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineShipCustomerAccountNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TrxDate", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineTrxDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineTrxDate_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "Periodicity", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLinePeriodicity(String value) {
        return new JAXBElement<String>(_InterfaceLinePeriodicity_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ShipDateActual", scope = InterfaceLine.class)
    public JAXBElement<XMLGregorianCalendar> createInterfaceLineShipDateActual(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_InterfaceLineShipDateActual_QNAME, XMLGregorianCalendar.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TaxInvoiceNumber", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineTaxInvoiceNumber(String value) {
        return new JAXBElement<String>(_InterfaceLineTaxInvoiceNumber_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "PaymentSetId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLinePaymentSetId(Long value) {
        return new JAXBElement<Long>(_InterfaceLinePaymentSetId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ExceptionId", scope = InterfaceLine.class)
    public JAXBElement<Long> createInterfaceLineExceptionId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineExceptionId_QNAME, Long.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ReasonCode", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineReasonCode(String value) {
        return new JAXBElement<String>(_InterfaceLineReasonCode_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesOrderSource", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineSalesOrderSource(String value) {
        return new JAXBElement<String>(_InterfaceLineSalesOrderSource_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "FOBPoint", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineFOBPoint(String value) {
        return new JAXBElement<String>(_InterfaceLineFOBPoint_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ResetTrxDate", scope = InterfaceLine.class)
    public JAXBElement<String> createInterfaceLineResetTrxDate(String value) {
        return new JAXBElement<String>(_InterfaceLineResetTrxDate_QNAME, String.class, InterfaceLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesrepNumber", scope = InterfaceSalesCredit.class)
    public JAXBElement<String> createInterfaceSalesCreditSalesrepNumber(String value) {
        return new JAXBElement<String>(_InterfaceSalesCreditSalesrepNumber_QNAME, String.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesCreditPercentSplit", scope = InterfaceSalesCredit.class)
    public JAXBElement<BigDecimal> createInterfaceSalesCreditSalesCreditPercentSplit(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceSalesCreditSalesCreditPercentSplit_QNAME, BigDecimal.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesCreditAmountSplit", scope = InterfaceSalesCredit.class)
    public JAXBElement<BigDecimal> createInterfaceSalesCreditSalesCreditAmountSplit(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterfaceSalesCreditSalesCreditAmountSplit_QNAME, BigDecimal.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesCreditTypeId", scope = InterfaceSalesCredit.class)
    public JAXBElement<Long> createInterfaceSalesCreditSalesCreditTypeId(Long value) {
        return new JAXBElement<Long>(_InterfaceSalesCreditSalesCreditTypeId_QNAME, Long.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "ResourceSalesrepId", scope = InterfaceSalesCredit.class)
    public JAXBElement<Long> createInterfaceSalesCreditResourceSalesrepId(Long value) {
        return new JAXBElement<Long>(_InterfaceLineResourceSalesrepId_QNAME, Long.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesgroupId", scope = InterfaceSalesCredit.class)
    public JAXBElement<Long> createInterfaceSalesCreditSalesgroupId(Long value) {
        return new JAXBElement<Long>(_InterfaceSalesCreditSalesgroupId_QNAME, Long.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "SalesCreditTypeName", scope = InterfaceSalesCredit.class)
    public JAXBElement<String> createInterfaceSalesCreditSalesCreditTypeName(String value) {
        return new JAXBElement<String>(_InterfaceSalesCreditSalesCreditTypeName_QNAME, String.class, InterfaceSalesCredit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditCardVoiceAuthorizationCode", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenCreditCardVoiceAuthorizationCode(String value) {
        return new JAXBElement<String>(_UpdateCCTokenCreditCardVoiceAuthorizationCode_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditCardExpirationDate", scope = UpdateCCToken.class)
    public JAXBElement<XMLGregorianCalendar> createUpdateCCTokenCreditCardExpirationDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UpdateCCTokenCreditCardExpirationDate_QNAME, XMLGregorianCalendar.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "TransactionSource", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenTransactionSource(String value) {
        return new JAXBElement<String>(_InvoiceTransactionSource_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CardHolderLastName", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenCardHolderLastName(String value) {
        return new JAXBElement<String>(_UpdateCCTokenCardHolderLastName_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "MaskedCreditCardNumber", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenMaskedCreditCardNumber(String value) {
        return new JAXBElement<String>(_UpdateCCTokenMaskedCreditCardNumber_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditCardAuthorizationRequestIdentifier", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenCreditCardAuthorizationRequestIdentifier(String value) {
        return new JAXBElement<String>(_UpdateCCTokenCreditCardAuthorizationRequestIdentifier_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CardHolderFirstName", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenCardHolderFirstName(String value) {
        return new JAXBElement<String>(_UpdateCCTokenCardHolderFirstName_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditCardIssuerCode", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenCreditCardIssuerCode(String value) {
        return new JAXBElement<String>(_UpdateCCTokenCreditCardIssuerCode_QNAME, String.class, UpdateCCToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", name = "CreditCardTokenNumber", scope = UpdateCCToken.class)
    public JAXBElement<String> createUpdateCCTokenCreditCardTokenNumber(String value) {
        return new JAXBElement<String>(_UpdateCCTokenCreditCardTokenNumber_QNAME, String.class, UpdateCCToken.class, value);
    }

}
