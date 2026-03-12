
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.oracle.xmlns.adf.svc.types.AmountType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice package. 
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

    private final static QName _UnapplyReceiptResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "unapplyReceiptResult");
    private final static QName _ActivityApplicationResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "activityApplicationResult");
    private final static QName _ActivityApplication_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "activityApplication");
    private final static QName _ApplyReceiptResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "applyReceiptResult");
    private final static QName _ReverseReceiptResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "reverseReceiptResult");
    private final static QName _StandardReceiptResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "standardReceiptResult");
    private final static QName _ApplyReceipt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "applyReceipt");
    private final static QName _StandardReceipt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "standardReceipt");
    private final static QName _UnapplyOnAccountResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "unapplyOnAccountResult");
    private final static QName _ActivityUnapplication_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "activityUnapplication");
    private final static QName _ReverseReceipt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "reverseReceipt");
    private final static QName _ApplyOnAccountResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "applyOnAccountResult");
    private final static QName _UnapplyOnAccount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "unapplyOnAccount");
    private final static QName _ActivityUnapplicationResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "activityUnapplicationResult");
    private final static QName _UnapplyReceipt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "unapplyReceipt");
    private final static QName _ApplyOnAccount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "applyOnAccount");
    private final static QName _ReverseReceiptReversalReasonCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalReasonCode");
    private final static QName _ReverseReceiptReceiptNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceiptNumber");
    private final static QName _ReverseReceiptReversalCategoryName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalCategoryName");
    private final static QName _ReverseReceiptReversalGlDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalGlDate");
    private final static QName _ReverseReceiptReversalDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalDate");
    private final static QName _ReverseReceiptReversalReasonName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalReasonName");
    private final static QName _ReverseReceiptBusinessUnit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "BusinessUnit");
    private final static QName _ReverseReceiptReversalComments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalComments");
    private final static QName _ReverseReceiptReversalCategory_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReversalCategory");
    private final static QName _ActivityApplicationApplyGlDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ApplyGlDate");
    private final static QName _ActivityApplicationSecondaryApplicationReferenceType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "SecondaryApplicationReferenceType");
    private final static QName _ActivityApplicationReceivablesTrxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceivablesTrxId");
    private final static QName _ActivityApplicationLinkToCustomerTrxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "LinkToCustomerTrxId");
    private final static QName _ActivityApplicationRemitMessage_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "RemitMessage");
    private final static QName _ActivityApplicationPaymentReasonComments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PaymentReasonComments");
    private final static QName _ActivityApplicationPaymentReasonCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PaymentReasonCode");
    private final static QName _ActivityApplicationPartySiteId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PartySiteId");
    private final static QName _ActivityApplicationPaymentMethodCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PaymentMethodCode");
    private final static QName _ActivityApplicationApplyDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ApplyDate");
    private final static QName _ActivityApplicationValWriteoffLimits_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ValWriteoffLimits");
    private final static QName _ActivityApplicationPayAlone_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PayAlone");
    private final static QName _ActivityApplicationPaymentSetId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PaymentSetId");
    private final static QName _ActivityApplicationSecondaryApplicationReferenceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "SecondaryApplicationReferenceNumber");
    private final static QName _ActivityApplicationPayGroupLookupCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PayGroupLookupCode");
    private final static QName _ActivityApplicationAmountApplied_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "AmountApplied");
    private final static QName _ActivityApplicationComments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "Comments");
    private final static QName _ActivityApplicationDeliveryChannelCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "DeliveryChannelCode");
    private final static QName _ActivityApplicationAppliedPaymentScheduleId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "AppliedPaymentScheduleId");
    private final static QName _ActivityApplicationNettedCashReceiptId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "NettedCashReceiptId");
    private final static QName _ActivityApplicationCustomerReason_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerReason");
    private final static QName _ActivityApplicationNettedReceipt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "NettedReceipt");
    private final static QName _ActivityApplicationRemitingMessage_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "RemitingMessage");
    private final static QName _ActivityApplicationPartyId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PartyId");
    private final static QName _ActivityApplicationRemittanceMessage_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "RemittanceMessage");
    private final static QName _ActivityApplicationBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "BankAccountId");
    private final static QName _ActivityApplicationReceivableTrxName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceivableTrxName");
    private final static QName _ActivityApplicationUSSGLTransactionCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "USSGLTransactionCode");
    private final static QName _ActivityApplicationCustomerReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerReference");
    private final static QName _StandardReceiptExchangeRateType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ExchangeRateType");
    private final static QName _StandardReceiptPostmarkDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PostmarkDate");
    private final static QName _StandardReceiptAnticipatedClearingDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "AnticipatedClearingDate");
    private final static QName _StandardReceiptExchangeRate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ExchangeRate");
    private final static QName _StandardReceiptUserExchangeRateType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "UserExchangeRateType");
    private final static QName _StandardReceiptRemittanceBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "RemittanceBankAccountId");
    private final static QName _StandardReceiptFactorDiscountAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "FactorDiscountAmount");
    private final static QName _StandardReceiptIssuerName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "IssuerName");
    private final static QName _StandardReceiptDocumentSequenceValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "DocumentSequenceValue");
    private final static QName _StandardReceiptUserCurrencyCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "UserCurrencyCode");
    private final static QName _StandardReceiptGlDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "GlDate");
    private final static QName _StandardReceiptIssueDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "IssueDate");
    private final static QName _StandardReceiptExchangeDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ExchangeDate");
    private final static QName _StandardReceiptMaturityDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "MaturityDate");
    private final static QName _StandardReceiptCustomerId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerId");
    private final static QName _StandardReceiptDepositDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "DepositDate");
    private final static QName _StandardReceiptPaymentTransactionExtensionId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "PaymentTransactionExtensionId");
    private final static QName _StandardReceiptOverrideRemitAccountFlag_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "OverrideRemitAccountFlag");
    private final static QName _StandardReceiptInstallment_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "Installment");
    private final static QName _StandardReceiptLocation_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "Location");
    private final static QName _StandardReceiptDefaultSiteUse_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "DefaultSiteUse");
    private final static QName _StandardReceiptCustomerBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerBankAccountId");
    private final static QName _StandardReceiptCustomerSiteUseId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerSiteUseId");
    private final static QName _StandardReceiptCustomerReceiptReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerReceiptReference");
    private final static QName _StandardReceiptIssuerBankBranchId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "IssuerBankBranchId");
    private final static QName _UnapplyOnAccountReceivablesApplicationId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceivablesApplicationId");
    private final static QName _ApplyReceiptReceiptCurrency_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceiptCurrency");
    private final static QName _ApplyReceiptCustomerTrxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerTrxId");
    private final static QName _ApplyReceiptInstalmentId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "InstalmentId");
    private final static QName _ApplyReceiptTransactionSource_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "TransactionSource");
    private final static QName _ApplyReceiptDiscount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "Discount");
    private final static QName _ApplyReceiptTransactionNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "TransactionNumber");
    private final static QName _ApplyReceiptApplyClosedInvoices_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ApplyClosedInvoices");
    private final static QName _ApplyReceiptReceiptDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceiptDate");
    private final static QName _ApplyReceiptTransactionDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "TransactionDate");
    private final static QName _ApplyReceiptCustomerName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "CustomerName");
    private final static QName _ApplyReceiptReceiptAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceiptAmount");
    private final static QName _ApplyReceiptInstalment_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "Instalment");
    private final static QName _ApplyReceiptAmountReceiptCurrency_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "AmountReceiptCurrency");
    private final static QName _ApplyReceiptReceiptId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceiptId");
    private final static QName _ActivityUnapplicationReceivableApplicationId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ReceivableApplicationId");
    private final static QName _UnapplyReceiptTrxNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "TrxNumber");
    private final static QName _ApplyOnAccountApplicationReferenceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "ApplicationReferenceNumber");
    private final static QName _ApplyOnAccountSecondaryApplicationReferenceId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", "SecondaryApplicationReferenceId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActivityUnapplication }
     * 
     */
    public ActivityUnapplication createActivityUnapplication() {
        return new ActivityUnapplication();
    }

    /**
     * Create an instance of {@link ReverseReceiptResult }
     * 
     */
    public ReverseReceiptResult createReverseReceiptResult() {
        return new ReverseReceiptResult();
    }

    /**
     * Create an instance of {@link ApplyOnAccountResult }
     * 
     */
    public ApplyOnAccountResult createApplyOnAccountResult() {
        return new ApplyOnAccountResult();
    }

    /**
     * Create an instance of {@link ActivityUnapplicationResult }
     * 
     */
    public ActivityUnapplicationResult createActivityUnapplicationResult() {
        return new ActivityUnapplicationResult();
    }

    /**
     * Create an instance of {@link ReverseReceipt }
     * 
     */
    public ReverseReceipt createReverseReceipt() {
        return new ReverseReceipt();
    }

    /**
     * Create an instance of {@link UnapplyReceipt }
     * 
     */
    public UnapplyReceipt createUnapplyReceipt() {
        return new UnapplyReceipt();
    }

    /**
     * Create an instance of {@link ApplyReceipt }
     * 
     */
    public ApplyReceipt createApplyReceipt() {
        return new ApplyReceipt();
    }

    /**
     * Create an instance of {@link UnapplyReceiptResult }
     * 
     */
    public UnapplyReceiptResult createUnapplyReceiptResult() {
        return new UnapplyReceiptResult();
    }

    /**
     * Create an instance of {@link ApplyOnAccount }
     * 
     */
    public ApplyOnAccount createApplyOnAccount() {
        return new ApplyOnAccount();
    }

    /**
     * Create an instance of {@link ActivityApplication }
     * 
     */
    public ActivityApplication createActivityApplication() {
        return new ActivityApplication();
    }

    /**
     * Create an instance of {@link ApplyReceiptResult }
     * 
     */
    public ApplyReceiptResult createApplyReceiptResult() {
        return new ApplyReceiptResult();
    }

    /**
     * Create an instance of {@link ActivityApplicationResult }
     * 
     */
    public ActivityApplicationResult createActivityApplicationResult() {
        return new ActivityApplicationResult();
    }

    /**
     * Create an instance of {@link UnapplyOnAccount }
     * 
     */
    public UnapplyOnAccount createUnapplyOnAccount() {
        return new UnapplyOnAccount();
    }

    /**
     * Create an instance of {@link StandardReceipt }
     * 
     */
    public StandardReceipt createStandardReceipt() {
        return new StandardReceipt();
    }

    /**
     * Create an instance of {@link StandardReceiptResult }
     * 
     */
    public StandardReceiptResult createStandardReceiptResult() {
        return new StandardReceiptResult();
    }

    /**
     * Create an instance of {@link UnapplyOnAccountResult }
     * 
     */
    public UnapplyOnAccountResult createUnapplyOnAccountResult() {
        return new UnapplyOnAccountResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnapplyReceiptResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "unapplyReceiptResult")
    public JAXBElement<UnapplyReceiptResult> createUnapplyReceiptResult(UnapplyReceiptResult value) {
        return new JAXBElement<UnapplyReceiptResult>(_UnapplyReceiptResult_QNAME, UnapplyReceiptResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityApplicationResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "activityApplicationResult")
    public JAXBElement<ActivityApplicationResult> createActivityApplicationResult(ActivityApplicationResult value) {
        return new JAXBElement<ActivityApplicationResult>(_ActivityApplicationResult_QNAME, ActivityApplicationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "activityApplication")
    public JAXBElement<ActivityApplication> createActivityApplication(ActivityApplication value) {
        return new JAXBElement<ActivityApplication>(_ActivityApplication_QNAME, ActivityApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyReceiptResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "applyReceiptResult")
    public JAXBElement<ApplyReceiptResult> createApplyReceiptResult(ApplyReceiptResult value) {
        return new JAXBElement<ApplyReceiptResult>(_ApplyReceiptResult_QNAME, ApplyReceiptResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseReceiptResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "reverseReceiptResult")
    public JAXBElement<ReverseReceiptResult> createReverseReceiptResult(ReverseReceiptResult value) {
        return new JAXBElement<ReverseReceiptResult>(_ReverseReceiptResult_QNAME, ReverseReceiptResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StandardReceiptResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "standardReceiptResult")
    public JAXBElement<StandardReceiptResult> createStandardReceiptResult(StandardReceiptResult value) {
        return new JAXBElement<StandardReceiptResult>(_StandardReceiptResult_QNAME, StandardReceiptResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyReceipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "applyReceipt")
    public JAXBElement<ApplyReceipt> createApplyReceipt(ApplyReceipt value) {
        return new JAXBElement<ApplyReceipt>(_ApplyReceipt_QNAME, ApplyReceipt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StandardReceipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "standardReceipt")
    public JAXBElement<StandardReceipt> createStandardReceipt(StandardReceipt value) {
        return new JAXBElement<StandardReceipt>(_StandardReceipt_QNAME, StandardReceipt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnapplyOnAccountResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "unapplyOnAccountResult")
    public JAXBElement<UnapplyOnAccountResult> createUnapplyOnAccountResult(UnapplyOnAccountResult value) {
        return new JAXBElement<UnapplyOnAccountResult>(_UnapplyOnAccountResult_QNAME, UnapplyOnAccountResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityUnapplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "activityUnapplication")
    public JAXBElement<ActivityUnapplication> createActivityUnapplication(ActivityUnapplication value) {
        return new JAXBElement<ActivityUnapplication>(_ActivityUnapplication_QNAME, ActivityUnapplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseReceipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "reverseReceipt")
    public JAXBElement<ReverseReceipt> createReverseReceipt(ReverseReceipt value) {
        return new JAXBElement<ReverseReceipt>(_ReverseReceipt_QNAME, ReverseReceipt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyOnAccountResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "applyOnAccountResult")
    public JAXBElement<ApplyOnAccountResult> createApplyOnAccountResult(ApplyOnAccountResult value) {
        return new JAXBElement<ApplyOnAccountResult>(_ApplyOnAccountResult_QNAME, ApplyOnAccountResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnapplyOnAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "unapplyOnAccount")
    public JAXBElement<UnapplyOnAccount> createUnapplyOnAccount(UnapplyOnAccount value) {
        return new JAXBElement<UnapplyOnAccount>(_UnapplyOnAccount_QNAME, UnapplyOnAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityUnapplicationResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "activityUnapplicationResult")
    public JAXBElement<ActivityUnapplicationResult> createActivityUnapplicationResult(ActivityUnapplicationResult value) {
        return new JAXBElement<ActivityUnapplicationResult>(_ActivityUnapplicationResult_QNAME, ActivityUnapplicationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnapplyReceipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "unapplyReceipt")
    public JAXBElement<UnapplyReceipt> createUnapplyReceipt(UnapplyReceipt value) {
        return new JAXBElement<UnapplyReceipt>(_UnapplyReceipt_QNAME, UnapplyReceipt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyOnAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "applyOnAccount")
    public JAXBElement<ApplyOnAccount> createApplyOnAccount(ApplyOnAccount value) {
        return new JAXBElement<ApplyOnAccount>(_ApplyOnAccount_QNAME, ApplyOnAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalReasonCode", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptReversalReasonCode(String value) {
        return new JAXBElement<String>(_ReverseReceiptReversalReasonCode_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalCategoryName", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptReversalCategoryName(String value) {
        return new JAXBElement<String>(_ReverseReceiptReversalCategoryName_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalGlDate", scope = ReverseReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createReverseReceiptReversalGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ReverseReceiptReversalGlDate_QNAME, XMLGregorianCalendar.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalDate", scope = ReverseReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createReverseReceiptReversalDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ReverseReceiptReversalDate_QNAME, XMLGregorianCalendar.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalReasonName", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptReversalReasonName(String value) {
        return new JAXBElement<String>(_ReverseReceiptReversalReasonName_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BusinessUnit", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptBusinessUnit(String value) {
        return new JAXBElement<String>(_ReverseReceiptBusinessUnit_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalComments", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptReversalComments(String value) {
        return new JAXBElement<String>(_ReverseReceiptReversalComments_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalCategory", scope = ReverseReceipt.class)
    public JAXBElement<String> createReverseReceiptReversalCategory(String value) {
        return new JAXBElement<String>(_ReverseReceiptReversalCategory_QNAME, String.class, ReverseReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ApplyGlDate", scope = ActivityApplication.class)
    public JAXBElement<XMLGregorianCalendar> createActivityApplicationApplyGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ActivityApplicationApplyGlDate_QNAME, XMLGregorianCalendar.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "SecondaryApplicationReferenceType", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationSecondaryApplicationReferenceType(String value) {
        return new JAXBElement<String>(_ActivityApplicationSecondaryApplicationReferenceType_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceivablesTrxId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationReceivablesTrxId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationReceivablesTrxId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "LinkToCustomerTrxId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationLinkToCustomerTrxId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationLinkToCustomerTrxId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "RemitMessage", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationRemitMessage(String value) {
        return new JAXBElement<String>(_ActivityApplicationRemitMessage_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PaymentReasonComments", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationPaymentReasonComments(String value) {
        return new JAXBElement<String>(_ActivityApplicationPaymentReasonComments_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PaymentReasonCode", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationPaymentReasonCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationPaymentReasonCode_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PartySiteId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationPartySiteId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationPartySiteId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PaymentMethodCode", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationPaymentMethodCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationPaymentMethodCode_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ApplyDate", scope = ActivityApplication.class)
    public JAXBElement<XMLGregorianCalendar> createActivityApplicationApplyDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ActivityApplicationApplyDate_QNAME, XMLGregorianCalendar.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ValWriteoffLimits", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationValWriteoffLimits(String value) {
        return new JAXBElement<String>(_ActivityApplicationValWriteoffLimits_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PayAlone", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationPayAlone(String value) {
        return new JAXBElement<String>(_ActivityApplicationPayAlone_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PaymentSetId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationPaymentSetId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationPaymentSetId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "SecondaryApplicationReferenceNumber", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationSecondaryApplicationReferenceNumber(String value) {
        return new JAXBElement<String>(_ActivityApplicationSecondaryApplicationReferenceNumber_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PayGroupLookupCode", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationPayGroupLookupCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationPayGroupLookupCode_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "AmountApplied", scope = ActivityApplication.class)
    public JAXBElement<BigDecimal> createActivityApplicationAmountApplied(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ActivityApplicationAmountApplied_QNAME, BigDecimal.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Comments", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationComments(String value) {
        return new JAXBElement<String>(_ActivityApplicationComments_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "DeliveryChannelCode", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationDeliveryChannelCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationDeliveryChannelCode_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "AppliedPaymentScheduleId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationAppliedPaymentScheduleId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationAppliedPaymentScheduleId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "NettedCashReceiptId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationNettedCashReceiptId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationNettedCashReceiptId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerReason", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationCustomerReason(String value) {
        return new JAXBElement<String>(_ActivityApplicationCustomerReason_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "NettedReceipt", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationNettedReceipt(String value) {
        return new JAXBElement<String>(_ActivityApplicationNettedReceipt_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "RemitingMessage", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationRemitingMessage(String value) {
        return new JAXBElement<String>(_ActivityApplicationRemitingMessage_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PartyId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationPartyId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationPartyId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BusinessUnit", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationBusinessUnit(String value) {
        return new JAXBElement<String>(_ReverseReceiptBusinessUnit_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "RemittanceMessage", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationRemittanceMessage(String value) {
        return new JAXBElement<String>(_ActivityApplicationRemittanceMessage_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BankAccountId", scope = ActivityApplication.class)
    public JAXBElement<Long> createActivityApplicationBankAccountId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationBankAccountId_QNAME, Long.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceivableTrxName", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationReceivableTrxName(String value) {
        return new JAXBElement<String>(_ActivityApplicationReceivableTrxName_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "USSGLTransactionCode", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationUSSGLTransactionCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationUSSGLTransactionCode_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerReference", scope = ActivityApplication.class)
    public JAXBElement<String> createActivityApplicationCustomerReference(String value) {
        return new JAXBElement<String>(_ActivityApplicationCustomerReference_QNAME, String.class, ActivityApplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ExchangeRateType", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptExchangeRateType(String value) {
        return new JAXBElement<String>(_StandardReceiptExchangeRateType_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PostmarkDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptPostmarkDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptPostmarkDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "AnticipatedClearingDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptAnticipatedClearingDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptAnticipatedClearingDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ExchangeRate", scope = StandardReceipt.class)
    public JAXBElement<BigDecimal> createStandardReceiptExchangeRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_StandardReceiptExchangeRate_QNAME, BigDecimal.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "UserExchangeRateType", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptUserExchangeRateType(String value) {
        return new JAXBElement<String>(_StandardReceiptUserExchangeRateType_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "RemittanceBankAccountId", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptRemittanceBankAccountId(Long value) {
        return new JAXBElement<Long>(_StandardReceiptRemittanceBankAccountId_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "FactorDiscountAmount", scope = StandardReceipt.class)
    public JAXBElement<AmountType> createStandardReceiptFactorDiscountAmount(AmountType value) {
        return new JAXBElement<AmountType>(_StandardReceiptFactorDiscountAmount_QNAME, AmountType.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "IssuerName", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptIssuerName(String value) {
        return new JAXBElement<String>(_StandardReceiptIssuerName_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "DocumentSequenceValue", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptDocumentSequenceValue(Long value) {
        return new JAXBElement<Long>(_StandardReceiptDocumentSequenceValue_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "UserCurrencyCode", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptUserCurrencyCode(String value) {
        return new JAXBElement<String>(_StandardReceiptUserCurrencyCode_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "GlDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptGlDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "IssueDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptIssueDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptIssueDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ExchangeDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptExchangeDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptExchangeDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "MaturityDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptMaturityDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptMaturityDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerId", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptCustomerId(Long value) {
        return new JAXBElement<Long>(_StandardReceiptCustomerId_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "DepositDate", scope = StandardReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createStandardReceiptDepositDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StandardReceiptDepositDate_QNAME, XMLGregorianCalendar.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "PaymentTransactionExtensionId", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptPaymentTransactionExtensionId(Long value) {
        return new JAXBElement<Long>(_StandardReceiptPaymentTransactionExtensionId_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "OverrideRemitAccountFlag", scope = StandardReceipt.class)
    public JAXBElement<Boolean> createStandardReceiptOverrideRemitAccountFlag(Boolean value) {
        return new JAXBElement<Boolean>(_StandardReceiptOverrideRemitAccountFlag_QNAME, Boolean.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Comments", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptComments(String value) {
        return new JAXBElement<String>(_ActivityApplicationComments_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Installment", scope = StandardReceipt.class)
    public JAXBElement<Integer> createStandardReceiptInstallment(Integer value) {
        return new JAXBElement<Integer>(_StandardReceiptInstallment_QNAME, Integer.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Location", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptLocation(String value) {
        return new JAXBElement<String>(_StandardReceiptLocation_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "DefaultSiteUse", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptDefaultSiteUse(String value) {
        return new JAXBElement<String>(_StandardReceiptDefaultSiteUse_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerBankAccountId", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptCustomerBankAccountId(Long value) {
        return new JAXBElement<Long>(_StandardReceiptCustomerBankAccountId_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerSiteUseId", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptCustomerSiteUseId(Long value) {
        return new JAXBElement<Long>(_StandardReceiptCustomerSiteUseId_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerReceiptReference", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptCustomerReceiptReference(String value) {
        return new JAXBElement<String>(_StandardReceiptCustomerReceiptReference_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "IssuerBankBranchId", scope = StandardReceipt.class)
    public JAXBElement<Long> createStandardReceiptIssuerBankBranchId(Long value) {
        return new JAXBElement<Long>(_StandardReceiptIssuerBankBranchId_QNAME, Long.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "USSGLTransactionCode", scope = StandardReceipt.class)
    public JAXBElement<String> createStandardReceiptUSSGLTransactionCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationUSSGLTransactionCode_QNAME, String.class, StandardReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = UnapplyOnAccount.class)
    public JAXBElement<String> createUnapplyOnAccountReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, UnapplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceivablesApplicationId", scope = UnapplyOnAccount.class)
    public JAXBElement<Long> createUnapplyOnAccountReceivablesApplicationId(Long value) {
        return new JAXBElement<Long>(_UnapplyOnAccountReceivablesApplicationId_QNAME, Long.class, UnapplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalGlDate", scope = UnapplyOnAccount.class)
    public JAXBElement<XMLGregorianCalendar> createUnapplyOnAccountReversalGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ReverseReceiptReversalGlDate_QNAME, XMLGregorianCalendar.class, UnapplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BusinessUnit", scope = UnapplyOnAccount.class)
    public JAXBElement<String> createUnapplyOnAccountBusinessUnit(String value) {
        return new JAXBElement<String>(_ReverseReceiptBusinessUnit_QNAME, String.class, UnapplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptCurrency", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptReceiptCurrency(String value) {
        return new JAXBElement<String>(_ApplyReceiptReceiptCurrency_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerTrxId", scope = ApplyReceipt.class)
    public JAXBElement<Long> createApplyReceiptCustomerTrxId(Long value) {
        return new JAXBElement<Long>(_ApplyReceiptCustomerTrxId_QNAME, Long.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "InstalmentId", scope = ApplyReceipt.class)
    public JAXBElement<Long> createApplyReceiptInstalmentId(Long value) {
        return new JAXBElement<Long>(_ApplyReceiptInstalmentId_QNAME, Long.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "TransactionSource", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptTransactionSource(String value) {
        return new JAXBElement<String>(_ApplyReceiptTransactionSource_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Comments", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptComments(String value) {
        return new JAXBElement<String>(_ActivityApplicationComments_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ExchangeRate", scope = ApplyReceipt.class)
    public JAXBElement<BigDecimal> createApplyReceiptExchangeRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_StandardReceiptExchangeRate_QNAME, BigDecimal.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Discount", scope = ApplyReceipt.class)
    public JAXBElement<BigDecimal> createApplyReceiptDiscount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ApplyReceiptDiscount_QNAME, BigDecimal.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "TransactionNumber", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptTransactionNumber(String value) {
        return new JAXBElement<String>(_ApplyReceiptTransactionNumber_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ApplyClosedInvoices", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptApplyClosedInvoices(String value) {
        return new JAXBElement<String>(_ApplyReceiptApplyClosedInvoices_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptDate", scope = ApplyReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createApplyReceiptReceiptDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ApplyReceiptReceiptDate_QNAME, XMLGregorianCalendar.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "TransactionDate", scope = ApplyReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createApplyReceiptTransactionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ApplyReceiptTransactionDate_QNAME, XMLGregorianCalendar.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerName", scope = ApplyReceipt.class)
    public JAXBElement<String> createApplyReceiptCustomerName(String value) {
        return new JAXBElement<String>(_ApplyReceiptCustomerName_QNAME, String.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptAmount", scope = ApplyReceipt.class)
    public JAXBElement<AmountType> createApplyReceiptReceiptAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ApplyReceiptReceiptAmount_QNAME, AmountType.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Instalment", scope = ApplyReceipt.class)
    public JAXBElement<Long> createApplyReceiptInstalment(Long value) {
        return new JAXBElement<Long>(_ApplyReceiptInstalment_QNAME, Long.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "AmountReceiptCurrency", scope = ApplyReceipt.class)
    public JAXBElement<BigDecimal> createApplyReceiptAmountReceiptCurrency(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ApplyReceiptAmountReceiptCurrency_QNAME, BigDecimal.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptId", scope = ApplyReceipt.class)
    public JAXBElement<Long> createApplyReceiptReceiptId(Long value) {
        return new JAXBElement<Long>(_ApplyReceiptReceiptId_QNAME, Long.class, ApplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceivableApplicationId", scope = ActivityUnapplication.class)
    public JAXBElement<Long> createActivityUnapplicationReceivableApplicationId(Long value) {
        return new JAXBElement<Long>(_ActivityUnapplicationReceivableApplicationId_QNAME, Long.class, ActivityUnapplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = ActivityUnapplication.class)
    public JAXBElement<String> createActivityUnapplicationReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, ActivityUnapplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalGlDate", scope = ActivityUnapplication.class)
    public JAXBElement<XMLGregorianCalendar> createActivityUnapplicationReversalGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ReverseReceiptReversalGlDate_QNAME, XMLGregorianCalendar.class, ActivityUnapplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BusinessUnit", scope = ActivityUnapplication.class)
    public JAXBElement<String> createActivityUnapplicationBusinessUnit(String value) {
        return new JAXBElement<String>(_ReverseReceiptBusinessUnit_QNAME, String.class, ActivityUnapplication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceivableApplicationId", scope = UnapplyReceipt.class)
    public JAXBElement<Long> createUnapplyReceiptReceivableApplicationId(Long value) {
        return new JAXBElement<Long>(_ActivityUnapplicationReceivableApplicationId_QNAME, Long.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = UnapplyReceipt.class)
    public JAXBElement<String> createUnapplyReceiptReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerTrxId", scope = UnapplyReceipt.class)
    public JAXBElement<Long> createUnapplyReceiptCustomerTrxId(Long value) {
        return new JAXBElement<Long>(_ApplyReceiptCustomerTrxId_QNAME, Long.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReversalGlDate", scope = UnapplyReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createUnapplyReceiptReversalGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ReverseReceiptReversalGlDate_QNAME, XMLGregorianCalendar.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BusinessUnit", scope = UnapplyReceipt.class)
    public JAXBElement<String> createUnapplyReceiptBusinessUnit(String value) {
        return new JAXBElement<String>(_ReverseReceiptBusinessUnit_QNAME, String.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "TrxNumber", scope = UnapplyReceipt.class)
    public JAXBElement<String> createUnapplyReceiptTrxNumber(String value) {
        return new JAXBElement<String>(_UnapplyReceiptTrxNumber_QNAME, String.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "AppliedPaymentScheduleId", scope = UnapplyReceipt.class)
    public JAXBElement<Long> createUnapplyReceiptAppliedPaymentScheduleId(Long value) {
        return new JAXBElement<Long>(_ActivityApplicationAppliedPaymentScheduleId_QNAME, Long.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Installment", scope = UnapplyReceipt.class)
    public JAXBElement<Long> createUnapplyReceiptInstallment(Long value) {
        return new JAXBElement<Long>(_StandardReceiptInstallment_QNAME, Long.class, UnapplyReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerReason", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountCustomerReason(String value) {
        return new JAXBElement<String>(_ActivityApplicationCustomerReason_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ReceiptNumber", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountReceiptNumber(String value) {
        return new JAXBElement<String>(_ReverseReceiptReceiptNumber_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ApplyGlDate", scope = ApplyOnAccount.class)
    public JAXBElement<XMLGregorianCalendar> createApplyOnAccountApplyGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ActivityApplicationApplyGlDate_QNAME, XMLGregorianCalendar.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "SecondaryApplicationReferenceType", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountSecondaryApplicationReferenceType(String value) {
        return new JAXBElement<String>(_ActivityApplicationSecondaryApplicationReferenceType_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "ApplicationReferenceNumber", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountApplicationReferenceNumber(String value) {
        return new JAXBElement<String>(_ApplyOnAccountApplicationReferenceNumber_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "SecondaryApplicationReferenceNumber", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountSecondaryApplicationReferenceNumber(String value) {
        return new JAXBElement<String>(_ActivityApplicationSecondaryApplicationReferenceNumber_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "SecondaryApplicationReferenceId", scope = ApplyOnAccount.class)
    public JAXBElement<Long> createApplyOnAccountSecondaryApplicationReferenceId(Long value) {
        return new JAXBElement<Long>(_ApplyOnAccountSecondaryApplicationReferenceId_QNAME, Long.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "BusinessUnit", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountBusinessUnit(String value) {
        return new JAXBElement<String>(_ReverseReceiptBusinessUnit_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "Comments", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountComments(String value) {
        return new JAXBElement<String>(_ActivityApplicationComments_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "USSGLTransactionCode", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountUSSGLTransactionCode(String value) {
        return new JAXBElement<String>(_ActivityApplicationUSSGLTransactionCode_QNAME, String.class, ApplyOnAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", name = "CustomerReference", scope = ApplyOnAccount.class)
    public JAXBElement<String> createApplyOnAccountCustomerReference(String value) {
        return new JAXBElement<String>(_ActivityApplicationCustomerReference_QNAME, String.class, ApplyOnAccount.class, value);
    }

}
