
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.standardreceiptdff.StandardReceiptFLEX;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.standardreceiptgdf.StandardReceiptGdf;


/**
 * <p>Java class for StandardReceipt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardReceipt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="AnticipatedClearingDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="CashReceiptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerBankAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CustomerReceiptReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerSiteUseId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DefaultSiteUse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepositDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentSequenceValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ExchangeDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ExchangeRateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FactorDiscountAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="GlDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="Installment" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IssueDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="IssuerBankBranchId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IssuerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaturityDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OverrideRemitAccountFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PaymentTransactionExtensionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PostmarkDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ReceiptDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ReceiptMethodId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RemittanceBankAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="UserExchangeRateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USSGLTransactionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StandardReceiptFLEXVA" type="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptDff/}StandardReceiptFLEX" minOccurs="0"/>
 *         &lt;element name="StandardReceiptGdfVA" type="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/}StandardReceiptGdf" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardReceipt", propOrder = {
    "amount",
    "anticipatedClearingDate",
    "cashReceiptId",
    "comments",
    "customerBankAccountId",
    "customerReceiptReference",
    "customerSiteUseId",
    "defaultSiteUse",
    "depositDate",
    "currencyCode",
    "documentSequenceValue",
    "exchangeDate",
    "exchangeRate",
    "exchangeRateType",
    "factorDiscountAmount",
    "glDate",
    "installment",
    "issueDate",
    "issuerBankBranchId",
    "issuerName",
    "location",
    "maturityDate",
    "orgId",
    "customerId",
    "overrideRemitAccountFlag",
    "paymentTransactionExtensionId",
    "postmarkDate",
    "receiptDate",
    "receiptMethodId",
    "receiptNumber",
    "remittanceBankAccountId",
    "userExchangeRateType",
    "ussglTransactionCode",
    "userCurrencyCode",
    "standardReceiptFLEXVA",
    "standardReceiptGdfVA"
})
public class StandardReceipt {

    @XmlElement(name = "Amount")
    protected AmountType amount;
    @XmlElementRef(name = "AnticipatedClearingDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> anticipatedClearingDate;
    @XmlElement(name = "CashReceiptId")
    protected Long cashReceiptId;
    @XmlElementRef(name = "Comments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "CustomerBankAccountId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> customerBankAccountId;
    @XmlElementRef(name = "CustomerReceiptReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerReceiptReference;
    @XmlElementRef(name = "CustomerSiteUseId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> customerSiteUseId;
    @XmlElementRef(name = "DefaultSiteUse", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultSiteUse;
    @XmlElementRef(name = "DepositDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> depositDate;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElementRef(name = "DocumentSequenceValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> documentSequenceValue;
    @XmlElementRef(name = "ExchangeDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> exchangeDate;
    @XmlElementRef(name = "ExchangeRate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> exchangeRate;
    @XmlElementRef(name = "ExchangeRateType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateType;
    @XmlElementRef(name = "FactorDiscountAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> factorDiscountAmount;
    @XmlElementRef(name = "GlDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> glDate;
    @XmlElementRef(name = "Installment", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> installment;
    @XmlElementRef(name = "IssueDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> issueDate;
    @XmlElementRef(name = "IssuerBankBranchId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> issuerBankBranchId;
    @XmlElementRef(name = "IssuerName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> issuerName;
    @XmlElementRef(name = "Location", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> location;
    @XmlElementRef(name = "MaturityDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> maturityDate;
    @XmlElement(name = "OrgId")
    protected Long orgId;
    @XmlElementRef(name = "CustomerId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> customerId;
    @XmlElementRef(name = "OverrideRemitAccountFlag", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> overrideRemitAccountFlag;
    @XmlElementRef(name = "PaymentTransactionExtensionId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> paymentTransactionExtensionId;
    @XmlElementRef(name = "PostmarkDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> postmarkDate;
    @XmlElement(name = "ReceiptDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar receiptDate;
    @XmlElement(name = "ReceiptMethodId")
    protected Long receiptMethodId;
    @XmlElementRef(name = "ReceiptNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptNumber;
    @XmlElementRef(name = "RemittanceBankAccountId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> remittanceBankAccountId;
    @XmlElementRef(name = "UserExchangeRateType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userExchangeRateType;
    @XmlElementRef(name = "USSGLTransactionCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ussglTransactionCode;
    @XmlElementRef(name = "UserCurrencyCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userCurrencyCode;
    @XmlElement(name = "StandardReceiptFLEXVA")
    protected StandardReceiptFLEX standardReceiptFLEXVA;
    @XmlElement(name = "StandardReceiptGdfVA")
    protected StandardReceiptGdf standardReceiptGdfVA;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Gets the value of the anticipatedClearingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getAnticipatedClearingDate() {
        return anticipatedClearingDate;
    }

    /**
     * Sets the value of the anticipatedClearingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setAnticipatedClearingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.anticipatedClearingDate = value;
    }

    /**
     * Gets the value of the cashReceiptId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashReceiptId() {
        return cashReceiptId;
    }

    /**
     * Sets the value of the cashReceiptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashReceiptId(Long value) {
        this.cashReceiptId = value;
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
     * Gets the value of the customerBankAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustomerBankAccountId() {
        return customerBankAccountId;
    }

    /**
     * Sets the value of the customerBankAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustomerBankAccountId(JAXBElement<Long> value) {
        this.customerBankAccountId = value;
    }

    /**
     * Gets the value of the customerReceiptReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerReceiptReference() {
        return customerReceiptReference;
    }

    /**
     * Sets the value of the customerReceiptReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerReceiptReference(JAXBElement<String> value) {
        this.customerReceiptReference = value;
    }

    /**
     * Gets the value of the customerSiteUseId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustomerSiteUseId() {
        return customerSiteUseId;
    }

    /**
     * Sets the value of the customerSiteUseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustomerSiteUseId(JAXBElement<Long> value) {
        this.customerSiteUseId = value;
    }

    /**
     * Gets the value of the defaultSiteUse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultSiteUse() {
        return defaultSiteUse;
    }

    /**
     * Sets the value of the defaultSiteUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultSiteUse(JAXBElement<String> value) {
        this.defaultSiteUse = value;
    }

    /**
     * Gets the value of the depositDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDepositDate() {
        return depositDate;
    }

    /**
     * Sets the value of the depositDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDepositDate(JAXBElement<XMLGregorianCalendar> value) {
        this.depositDate = value;
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
     * Gets the value of the documentSequenceValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDocumentSequenceValue() {
        return documentSequenceValue;
    }

    /**
     * Sets the value of the documentSequenceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDocumentSequenceValue(JAXBElement<Long> value) {
        this.documentSequenceValue = value;
    }

    /**
     * Gets the value of the exchangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExchangeDate() {
        return exchangeDate;
    }

    /**
     * Sets the value of the exchangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExchangeDate(JAXBElement<XMLGregorianCalendar> value) {
        this.exchangeDate = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setExchangeRate(JAXBElement<BigDecimal> value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the exchangeRateType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateType() {
        return exchangeRateType;
    }

    /**
     * Sets the value of the exchangeRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateType(JAXBElement<String> value) {
        this.exchangeRateType = value;
    }

    /**
     * Gets the value of the factorDiscountAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getFactorDiscountAmount() {
        return factorDiscountAmount;
    }

    /**
     * Sets the value of the factorDiscountAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setFactorDiscountAmount(JAXBElement<AmountType> value) {
        this.factorDiscountAmount = value;
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
     * Gets the value of the installment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getInstallment() {
        return installment;
    }

    /**
     * Sets the value of the installment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setInstallment(JAXBElement<Integer> value) {
        this.installment = value;
    }

    /**
     * Gets the value of the issueDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the value of the issueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setIssueDate(JAXBElement<XMLGregorianCalendar> value) {
        this.issueDate = value;
    }

    /**
     * Gets the value of the issuerBankBranchId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getIssuerBankBranchId() {
        return issuerBankBranchId;
    }

    /**
     * Sets the value of the issuerBankBranchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setIssuerBankBranchId(JAXBElement<Long> value) {
        this.issuerBankBranchId = value;
    }

    /**
     * Gets the value of the issuerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssuerName() {
        return issuerName;
    }

    /**
     * Sets the value of the issuerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssuerName(JAXBElement<String> value) {
        this.issuerName = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocation(JAXBElement<String> value) {
        this.location = value;
    }

    /**
     * Gets the value of the maturityDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getMaturityDate() {
        return maturityDate;
    }

    /**
     * Sets the value of the maturityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setMaturityDate(JAXBElement<XMLGregorianCalendar> value) {
        this.maturityDate = value;
    }

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
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustomerId(JAXBElement<Long> value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the overrideRemitAccountFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getOverrideRemitAccountFlag() {
        return overrideRemitAccountFlag;
    }

    /**
     * Sets the value of the overrideRemitAccountFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setOverrideRemitAccountFlag(JAXBElement<Boolean> value) {
        this.overrideRemitAccountFlag = value;
    }

    /**
     * Gets the value of the paymentTransactionExtensionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPaymentTransactionExtensionId() {
        return paymentTransactionExtensionId;
    }

    /**
     * Sets the value of the paymentTransactionExtensionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPaymentTransactionExtensionId(JAXBElement<Long> value) {
        this.paymentTransactionExtensionId = value;
    }

    /**
     * Gets the value of the postmarkDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getPostmarkDate() {
        return postmarkDate;
    }

    /**
     * Sets the value of the postmarkDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setPostmarkDate(JAXBElement<XMLGregorianCalendar> value) {
        this.postmarkDate = value;
    }

    /**
     * Gets the value of the receiptDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceiptDate() {
        return receiptDate;
    }

    /**
     * Sets the value of the receiptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceiptDate(XMLGregorianCalendar value) {
        this.receiptDate = value;
    }

    /**
     * Gets the value of the receiptMethodId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReceiptMethodId() {
        return receiptMethodId;
    }

    /**
     * Sets the value of the receiptMethodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReceiptMethodId(Long value) {
        this.receiptMethodId = value;
    }

    /**
     * Gets the value of the receiptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * Sets the value of the receiptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptNumber(JAXBElement<String> value) {
        this.receiptNumber = value;
    }

    /**
     * Gets the value of the remittanceBankAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRemittanceBankAccountId() {
        return remittanceBankAccountId;
    }

    /**
     * Sets the value of the remittanceBankAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRemittanceBankAccountId(JAXBElement<Long> value) {
        this.remittanceBankAccountId = value;
    }

    /**
     * Gets the value of the userExchangeRateType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserExchangeRateType() {
        return userExchangeRateType;
    }

    /**
     * Sets the value of the userExchangeRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserExchangeRateType(JAXBElement<String> value) {
        this.userExchangeRateType = value;
    }

    /**
     * Gets the value of the ussglTransactionCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUSSGLTransactionCode() {
        return ussglTransactionCode;
    }

    /**
     * Sets the value of the ussglTransactionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUSSGLTransactionCode(JAXBElement<String> value) {
        this.ussglTransactionCode = value;
    }

    /**
     * Gets the value of the userCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserCurrencyCode() {
        return userCurrencyCode;
    }

    /**
     * Sets the value of the userCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserCurrencyCode(JAXBElement<String> value) {
        this.userCurrencyCode = value;
    }

    /**
     * Gets the value of the standardReceiptFLEXVA property.
     * 
     * @return
     *     possible object is
     *     {@link StandardReceiptFLEX }
     *     
     */
    public StandardReceiptFLEX getStandardReceiptFLEXVA() {
        return standardReceiptFLEXVA;
    }

    /**
     * Sets the value of the standardReceiptFLEXVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardReceiptFLEX }
     *     
     */
    public void setStandardReceiptFLEXVA(StandardReceiptFLEX value) {
        this.standardReceiptFLEXVA = value;
    }

    /**
     * Gets the value of the standardReceiptGdfVA property.
     * 
     * @return
     *     possible object is
     *     {@link StandardReceiptGdf }
     *     
     */
    public StandardReceiptGdf getStandardReceiptGdfVA() {
        return standardReceiptGdfVA;
    }

    /**
     * Sets the value of the standardReceiptGdfVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardReceiptGdf }
     *     
     */
    public void setStandardReceiptGdfVA(StandardReceiptGdf value) {
        this.standardReceiptGdfVA = value;
    }

}
