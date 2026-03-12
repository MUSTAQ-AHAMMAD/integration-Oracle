
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice;

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
 * generated in the com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice package. 
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

    private final static QName _MiscellaneousReceiptResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "miscellaneousReceiptResult");
    private final static QName _MiscellaneousReceipt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "miscellaneousReceipt");
    private final static QName _MiscellaneousReceiptReferenceType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReferenceType");
    private final static QName _MiscellaneousReceiptExchangeRateType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ExchangeRateType");
    private final static QName _MiscellaneousReceiptReceivablesTransactionId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReceivablesTransactionId");
    private final static QName _MiscellaneousReceiptAnticipatedClearingDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "AnticipatedClearingDate");
    private final static QName _MiscellaneousReceiptExchangeRate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ExchangeRate");
    private final static QName _MiscellaneousReceiptUserExchangeRateType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "UserExchangeRateType");
    private final static QName _MiscellaneousReceiptReceiptNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReceiptNumber");
    private final static QName _MiscellaneousReceiptReceiptMethodName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReceiptMethodName");
    private final static QName _MiscellaneousReceiptRemittanceBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "RemittanceBankAccountId");
    private final static QName _MiscellaneousReceiptTaxRate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "TaxRate");
    private final static QName _MiscellaneousReceiptReferenceId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReferenceId");
    private final static QName _MiscellaneousReceiptTaxCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "TaxCode");
    private final static QName _MiscellaneousReceiptReceivableActivityName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReceivableActivityName");
    private final static QName _MiscellaneousReceiptTaxAmount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "TaxAmount");
    private final static QName _MiscellaneousReceiptDocumentSequenceValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "DocumentSequenceValue");
    private final static QName _MiscellaneousReceiptUserCurrencyCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "UserCurrencyCode");
    private final static QName _MiscellaneousReceiptExchangeDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ExchangeDate");
    private final static QName _MiscellaneousReceiptGlDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "GlDate");
    private final static QName _MiscellaneousReceiptComments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "Comments");
    private final static QName _MiscellaneousReceiptReferenceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "ReferenceNumber");
    private final static QName _MiscellaneousReceiptDepositDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "DepositDate");
    private final static QName _MiscellaneousReceiptPaymentTransactionExtensionId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "PaymentTransactionExtensionId");
    private final static QName _MiscellaneousReceiptVATTaxId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "VATTaxId");
    private final static QName _MiscellaneousReceiptMiscellaneousPaymentSource_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "MiscellaneousPaymentSource");
    private final static QName _MiscellaneousReceiptBankAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "BankAccountNumber");
    private final static QName _MiscellaneousReceiptUSSGLTransactionCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "USSGLTransactionCode");
    private final static QName _MiscellaneousReceiptBankAccountName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", "BankAccountName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MiscellaneousReceiptResult }
     * 
     */
    public MiscellaneousReceiptResult createMiscellaneousReceiptResult() {
        return new MiscellaneousReceiptResult();
    }

    /**
     * Create an instance of {@link MiscellaneousReceipt }
     * 
     */
    public MiscellaneousReceipt createMiscellaneousReceipt() {
        return new MiscellaneousReceipt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MiscellaneousReceiptResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "miscellaneousReceiptResult")
    public JAXBElement<MiscellaneousReceiptResult> createMiscellaneousReceiptResult(MiscellaneousReceiptResult value) {
        return new JAXBElement<MiscellaneousReceiptResult>(_MiscellaneousReceiptResult_QNAME, MiscellaneousReceiptResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MiscellaneousReceipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "miscellaneousReceipt")
    public JAXBElement<MiscellaneousReceipt> createMiscellaneousReceipt(MiscellaneousReceipt value) {
        return new JAXBElement<MiscellaneousReceipt>(_MiscellaneousReceipt_QNAME, MiscellaneousReceipt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReferenceType", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptReferenceType(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptReferenceType_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ExchangeRateType", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptExchangeRateType(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptExchangeRateType_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReceivablesTransactionId", scope = MiscellaneousReceipt.class)
    public JAXBElement<Long> createMiscellaneousReceiptReceivablesTransactionId(Long value) {
        return new JAXBElement<Long>(_MiscellaneousReceiptReceivablesTransactionId_QNAME, Long.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "AnticipatedClearingDate", scope = MiscellaneousReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createMiscellaneousReceiptAnticipatedClearingDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MiscellaneousReceiptAnticipatedClearingDate_QNAME, XMLGregorianCalendar.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ExchangeRate", scope = MiscellaneousReceipt.class)
    public JAXBElement<BigDecimal> createMiscellaneousReceiptExchangeRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MiscellaneousReceiptExchangeRate_QNAME, BigDecimal.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "UserExchangeRateType", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptUserExchangeRateType(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptUserExchangeRateType_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReceiptNumber", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptReceiptNumber(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptReceiptNumber_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReceiptMethodName", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptReceiptMethodName(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptReceiptMethodName_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "RemittanceBankAccountId", scope = MiscellaneousReceipt.class)
    public JAXBElement<Long> createMiscellaneousReceiptRemittanceBankAccountId(Long value) {
        return new JAXBElement<Long>(_MiscellaneousReceiptRemittanceBankAccountId_QNAME, Long.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "TaxRate", scope = MiscellaneousReceipt.class)
    public JAXBElement<BigDecimal> createMiscellaneousReceiptTaxRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MiscellaneousReceiptTaxRate_QNAME, BigDecimal.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReferenceId", scope = MiscellaneousReceipt.class)
    public JAXBElement<Long> createMiscellaneousReceiptReferenceId(Long value) {
        return new JAXBElement<Long>(_MiscellaneousReceiptReferenceId_QNAME, Long.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "TaxCode", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptTaxCode(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptTaxCode_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReceivableActivityName", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptReceivableActivityName(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptReceivableActivityName_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "TaxAmount", scope = MiscellaneousReceipt.class)
    public JAXBElement<AmountType> createMiscellaneousReceiptTaxAmount(AmountType value) {
        return new JAXBElement<AmountType>(_MiscellaneousReceiptTaxAmount_QNAME, AmountType.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "DocumentSequenceValue", scope = MiscellaneousReceipt.class)
    public JAXBElement<Long> createMiscellaneousReceiptDocumentSequenceValue(Long value) {
        return new JAXBElement<Long>(_MiscellaneousReceiptDocumentSequenceValue_QNAME, Long.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "UserCurrencyCode", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptUserCurrencyCode(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptUserCurrencyCode_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ExchangeDate", scope = MiscellaneousReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createMiscellaneousReceiptExchangeDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MiscellaneousReceiptExchangeDate_QNAME, XMLGregorianCalendar.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "GlDate", scope = MiscellaneousReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createMiscellaneousReceiptGlDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MiscellaneousReceiptGlDate_QNAME, XMLGregorianCalendar.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "Comments", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptComments(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptComments_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "ReferenceNumber", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptReferenceNumber(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptReferenceNumber_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "DepositDate", scope = MiscellaneousReceipt.class)
    public JAXBElement<XMLGregorianCalendar> createMiscellaneousReceiptDepositDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MiscellaneousReceiptDepositDate_QNAME, XMLGregorianCalendar.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "PaymentTransactionExtensionId", scope = MiscellaneousReceipt.class)
    public JAXBElement<Long> createMiscellaneousReceiptPaymentTransactionExtensionId(Long value) {
        return new JAXBElement<Long>(_MiscellaneousReceiptPaymentTransactionExtensionId_QNAME, Long.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "VATTaxId", scope = MiscellaneousReceipt.class)
    public JAXBElement<Long> createMiscellaneousReceiptVATTaxId(Long value) {
        return new JAXBElement<Long>(_MiscellaneousReceiptVATTaxId_QNAME, Long.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "MiscellaneousPaymentSource", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptMiscellaneousPaymentSource(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptMiscellaneousPaymentSource_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "BankAccountNumber", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptBankAccountNumber(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptBankAccountNumber_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "USSGLTransactionCode", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptUSSGLTransactionCode(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptUSSGLTransactionCode_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/", name = "BankAccountName", scope = MiscellaneousReceipt.class)
    public JAXBElement<String> createMiscellaneousReceiptBankAccountName(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptBankAccountName_QNAME, String.class, MiscellaneousReceipt.class, value);
    }

}
