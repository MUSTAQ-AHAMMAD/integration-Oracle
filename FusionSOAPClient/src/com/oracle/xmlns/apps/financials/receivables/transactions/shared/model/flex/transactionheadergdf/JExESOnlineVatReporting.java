
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExESOnlineVatReporting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExESOnlineVatReporting">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
 *         &lt;element name="FLEX_PARAM_InvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_BillToSiteUseId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_CustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TransactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegisterType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegisterType_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateLastUpdated" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ThirdPartyInvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ThirdPartyInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntraEUDeclaredKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntraEUDeclaredKey_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntraEUSubtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntraEUSubtype_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialRegime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialRegime_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalInvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="OriginalInvoiceNumber_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateTransactionPerformed" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="TransactiontransactionDeadline" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TransactionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="YearOfAmountReceivedInCash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PropertyLocation" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PropertyLocation_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransmissionOfPropertySubjectT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransmissionOfPropertySubjectT_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorrectionYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorrectionPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentTypeOverride" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentTypeOverride_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceRecordingDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="LastDocumentNumberOfSummaryInv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExESOnlineVatReporting", propOrder = {
    "flexparamInvoiceDate",
    "flexparamBillToSiteUseId",
    "flexparamCustomerTrxId",
    "transactionStatus",
    "transactionStatusDisplay",
    "taxAuthorityStatus",
    "taxAuthorityStatusDisplay",
    "registerType",
    "registerTypeDisplay",
    "messageCode",
    "messageDescription",
    "dateLastUpdated",
    "thirdPartyInvoice",
    "thirdPartyInvoiceDisplay",
    "intraEUDeclaredKey",
    "intraEUDeclaredKeyDisplay",
    "intraEUSubtype",
    "intraEUSubtypeDisplay",
    "specialRegime",
    "specialRegimeDisplay",
    "originalInvoiceNumber",
    "originalInvoiceNumberDisplay",
    "dateTransactionPerformed",
    "transactiontransactionDeadline",
    "transactionDate",
    "yearOfAmountReceivedInCash",
    "propertyLocation",
    "propertyLocationDisplay",
    "transmissionOfPropertySubjectT",
    "transmissionOfPropertySubjectTDisplay",
    "correctionYear",
    "correctionPeriod",
    "documentTypeOverride",
    "documentTypeOverrideDisplay",
    "invoiceRecordingDate",
    "lastDocumentNumberOfSummaryInv"
})
public class JExESOnlineVatReporting
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "FLEX_PARAM_InvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> flexparamInvoiceDate;
    @XmlElementRef(name = "FLEX_PARAM_BillToSiteUseId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamBillToSiteUseId;
    @XmlElementRef(name = "FLEX_PARAM_CustomerTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamCustomerTrxId;
    @XmlElementRef(name = "TransactionStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatus;
    @XmlElementRef(name = "TransactionStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatusDisplay;
    @XmlElementRef(name = "TaxAuthorityStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatus;
    @XmlElementRef(name = "TaxAuthorityStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatusDisplay;
    @XmlElementRef(name = "RegisterType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> registerType;
    @XmlElementRef(name = "RegisterType_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> registerTypeDisplay;
    @XmlElementRef(name = "MessageCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageCode;
    @XmlElementRef(name = "MessageDescription", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageDescription;
    @XmlElementRef(name = "DateLastUpdated", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateLastUpdated;
    @XmlElementRef(name = "ThirdPartyInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thirdPartyInvoice;
    @XmlElementRef(name = "ThirdPartyInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thirdPartyInvoiceDisplay;
    @XmlElementRef(name = "IntraEUDeclaredKey", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intraEUDeclaredKey;
    @XmlElementRef(name = "IntraEUDeclaredKey_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intraEUDeclaredKeyDisplay;
    @XmlElementRef(name = "IntraEUSubtype", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intraEUSubtype;
    @XmlElementRef(name = "IntraEUSubtype_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intraEUSubtypeDisplay;
    @XmlElementRef(name = "SpecialRegime", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specialRegime;
    @XmlElementRef(name = "SpecialRegime_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specialRegimeDisplay;
    @XmlElementRef(name = "OriginalInvoiceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> originalInvoiceNumber;
    @XmlElementRef(name = "OriginalInvoiceNumber_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originalInvoiceNumberDisplay;
    @XmlElementRef(name = "DateTransactionPerformed", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateTransactionPerformed;
    @XmlElementRef(name = "TransactiontransactionDeadline", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> transactiontransactionDeadline;
    @XmlElementRef(name = "TransactionDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> transactionDate;
    @XmlElementRef(name = "YearOfAmountReceivedInCash", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> yearOfAmountReceivedInCash;
    @XmlElementRef(name = "PropertyLocation", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> propertyLocation;
    @XmlElementRef(name = "PropertyLocation_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> propertyLocationDisplay;
    @XmlElementRef(name = "TransmissionOfPropertySubjectT", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transmissionOfPropertySubjectT;
    @XmlElementRef(name = "TransmissionOfPropertySubjectT_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transmissionOfPropertySubjectTDisplay;
    @XmlElementRef(name = "CorrectionYear", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correctionYear;
    @XmlElementRef(name = "CorrectionPeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correctionPeriod;
    @XmlElementRef(name = "DocumentTypeOverride", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentTypeOverride;
    @XmlElementRef(name = "DocumentTypeOverride_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentTypeOverrideDisplay;
    @XmlElementRef(name = "InvoiceRecordingDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> invoiceRecordingDate;
    @XmlElementRef(name = "LastDocumentNumberOfSummaryInv", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastDocumentNumberOfSummaryInv;

    /**
     * Gets the value of the flexparamInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFLEXPARAMInvoiceDate() {
        return flexparamInvoiceDate;
    }

    /**
     * Sets the value of the flexparamInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFLEXPARAMInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.flexparamInvoiceDate = value;
    }

    /**
     * Gets the value of the flexparamBillToSiteUseId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMBillToSiteUseId() {
        return flexparamBillToSiteUseId;
    }

    /**
     * Sets the value of the flexparamBillToSiteUseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMBillToSiteUseId(JAXBElement<BigDecimal> value) {
        this.flexparamBillToSiteUseId = value;
    }

    /**
     * Gets the value of the flexparamCustomerTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMCustomerTrxId() {
        return flexparamCustomerTrxId;
    }

    /**
     * Sets the value of the flexparamCustomerTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMCustomerTrxId(JAXBElement<BigDecimal> value) {
        this.flexparamCustomerTrxId = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionStatus(JAXBElement<String> value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the transactionStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionStatusDisplay() {
        return transactionStatusDisplay;
    }

    /**
     * Sets the value of the transactionStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionStatusDisplay(JAXBElement<String> value) {
        this.transactionStatusDisplay = value;
    }

    /**
     * Gets the value of the taxAuthorityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxAuthorityStatus() {
        return taxAuthorityStatus;
    }

    /**
     * Sets the value of the taxAuthorityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxAuthorityStatus(JAXBElement<String> value) {
        this.taxAuthorityStatus = value;
    }

    /**
     * Gets the value of the taxAuthorityStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxAuthorityStatusDisplay() {
        return taxAuthorityStatusDisplay;
    }

    /**
     * Sets the value of the taxAuthorityStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxAuthorityStatusDisplay(JAXBElement<String> value) {
        this.taxAuthorityStatusDisplay = value;
    }

    /**
     * Gets the value of the registerType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegisterType() {
        return registerType;
    }

    /**
     * Sets the value of the registerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegisterType(JAXBElement<String> value) {
        this.registerType = value;
    }

    /**
     * Gets the value of the registerTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegisterTypeDisplay() {
        return registerTypeDisplay;
    }

    /**
     * Sets the value of the registerTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegisterTypeDisplay(JAXBElement<String> value) {
        this.registerTypeDisplay = value;
    }

    /**
     * Gets the value of the messageCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageCode() {
        return messageCode;
    }

    /**
     * Sets the value of the messageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageCode(JAXBElement<String> value) {
        this.messageCode = value;
    }

    /**
     * Gets the value of the messageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageDescription() {
        return messageDescription;
    }

    /**
     * Sets the value of the messageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageDescription(JAXBElement<String> value) {
        this.messageDescription = value;
    }

    /**
     * Gets the value of the dateLastUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateLastUpdated() {
        return dateLastUpdated;
    }

    /**
     * Sets the value of the dateLastUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateLastUpdated(JAXBElement<XMLGregorianCalendar> value) {
        this.dateLastUpdated = value;
    }

    /**
     * Gets the value of the thirdPartyInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThirdPartyInvoice() {
        return thirdPartyInvoice;
    }

    /**
     * Sets the value of the thirdPartyInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThirdPartyInvoice(JAXBElement<String> value) {
        this.thirdPartyInvoice = value;
    }

    /**
     * Gets the value of the thirdPartyInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThirdPartyInvoiceDisplay() {
        return thirdPartyInvoiceDisplay;
    }

    /**
     * Sets the value of the thirdPartyInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThirdPartyInvoiceDisplay(JAXBElement<String> value) {
        this.thirdPartyInvoiceDisplay = value;
    }

    /**
     * Gets the value of the intraEUDeclaredKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntraEUDeclaredKey() {
        return intraEUDeclaredKey;
    }

    /**
     * Sets the value of the intraEUDeclaredKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntraEUDeclaredKey(JAXBElement<String> value) {
        this.intraEUDeclaredKey = value;
    }

    /**
     * Gets the value of the intraEUDeclaredKeyDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntraEUDeclaredKeyDisplay() {
        return intraEUDeclaredKeyDisplay;
    }

    /**
     * Sets the value of the intraEUDeclaredKeyDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntraEUDeclaredKeyDisplay(JAXBElement<String> value) {
        this.intraEUDeclaredKeyDisplay = value;
    }

    /**
     * Gets the value of the intraEUSubtype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntraEUSubtype() {
        return intraEUSubtype;
    }

    /**
     * Sets the value of the intraEUSubtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntraEUSubtype(JAXBElement<String> value) {
        this.intraEUSubtype = value;
    }

    /**
     * Gets the value of the intraEUSubtypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntraEUSubtypeDisplay() {
        return intraEUSubtypeDisplay;
    }

    /**
     * Sets the value of the intraEUSubtypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntraEUSubtypeDisplay(JAXBElement<String> value) {
        this.intraEUSubtypeDisplay = value;
    }

    /**
     * Gets the value of the specialRegime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecialRegime() {
        return specialRegime;
    }

    /**
     * Sets the value of the specialRegime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecialRegime(JAXBElement<String> value) {
        this.specialRegime = value;
    }

    /**
     * Gets the value of the specialRegimeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecialRegimeDisplay() {
        return specialRegimeDisplay;
    }

    /**
     * Sets the value of the specialRegimeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecialRegimeDisplay(JAXBElement<String> value) {
        this.specialRegimeDisplay = value;
    }

    /**
     * Gets the value of the originalInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOriginalInvoiceNumber() {
        return originalInvoiceNumber;
    }

    /**
     * Sets the value of the originalInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOriginalInvoiceNumber(JAXBElement<BigDecimal> value) {
        this.originalInvoiceNumber = value;
    }

    /**
     * Gets the value of the originalInvoiceNumberDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginalInvoiceNumberDisplay() {
        return originalInvoiceNumberDisplay;
    }

    /**
     * Sets the value of the originalInvoiceNumberDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginalInvoiceNumberDisplay(JAXBElement<String> value) {
        this.originalInvoiceNumberDisplay = value;
    }

    /**
     * Gets the value of the dateTransactionPerformed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateTransactionPerformed() {
        return dateTransactionPerformed;
    }

    /**
     * Sets the value of the dateTransactionPerformed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateTransactionPerformed(JAXBElement<XMLGregorianCalendar> value) {
        this.dateTransactionPerformed = value;
    }

    /**
     * Gets the value of the transactiontransactionDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTransactiontransactionDeadline() {
        return transactiontransactionDeadline;
    }

    /**
     * Sets the value of the transactiontransactionDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTransactiontransactionDeadline(JAXBElement<BigDecimal> value) {
        this.transactiontransactionDeadline = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTransactionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the yearOfAmountReceivedInCash property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getYearOfAmountReceivedInCash() {
        return yearOfAmountReceivedInCash;
    }

    /**
     * Sets the value of the yearOfAmountReceivedInCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setYearOfAmountReceivedInCash(JAXBElement<String> value) {
        this.yearOfAmountReceivedInCash = value;
    }

    /**
     * Gets the value of the propertyLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPropertyLocation() {
        return propertyLocation;
    }

    /**
     * Sets the value of the propertyLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPropertyLocation(JAXBElement<BigDecimal> value) {
        this.propertyLocation = value;
    }

    /**
     * Gets the value of the propertyLocationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPropertyLocationDisplay() {
        return propertyLocationDisplay;
    }

    /**
     * Sets the value of the propertyLocationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPropertyLocationDisplay(JAXBElement<String> value) {
        this.propertyLocationDisplay = value;
    }

    /**
     * Gets the value of the transmissionOfPropertySubjectT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransmissionOfPropertySubjectT() {
        return transmissionOfPropertySubjectT;
    }

    /**
     * Sets the value of the transmissionOfPropertySubjectT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransmissionOfPropertySubjectT(JAXBElement<String> value) {
        this.transmissionOfPropertySubjectT = value;
    }

    /**
     * Gets the value of the transmissionOfPropertySubjectTDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransmissionOfPropertySubjectTDisplay() {
        return transmissionOfPropertySubjectTDisplay;
    }

    /**
     * Sets the value of the transmissionOfPropertySubjectTDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransmissionOfPropertySubjectTDisplay(JAXBElement<String> value) {
        this.transmissionOfPropertySubjectTDisplay = value;
    }

    /**
     * Gets the value of the correctionYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorrectionYear() {
        return correctionYear;
    }

    /**
     * Sets the value of the correctionYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorrectionYear(JAXBElement<String> value) {
        this.correctionYear = value;
    }

    /**
     * Gets the value of the correctionPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorrectionPeriod() {
        return correctionPeriod;
    }

    /**
     * Sets the value of the correctionPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorrectionPeriod(JAXBElement<String> value) {
        this.correctionPeriod = value;
    }

    /**
     * Gets the value of the documentTypeOverride property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentTypeOverride() {
        return documentTypeOverride;
    }

    /**
     * Sets the value of the documentTypeOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentTypeOverride(JAXBElement<String> value) {
        this.documentTypeOverride = value;
    }

    /**
     * Gets the value of the documentTypeOverrideDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentTypeOverrideDisplay() {
        return documentTypeOverrideDisplay;
    }

    /**
     * Sets the value of the documentTypeOverrideDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentTypeOverrideDisplay(JAXBElement<String> value) {
        this.documentTypeOverrideDisplay = value;
    }

    /**
     * Gets the value of the invoiceRecordingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getInvoiceRecordingDate() {
        return invoiceRecordingDate;
    }

    /**
     * Sets the value of the invoiceRecordingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setInvoiceRecordingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.invoiceRecordingDate = value;
    }

    /**
     * Gets the value of the lastDocumentNumberOfSummaryInv property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastDocumentNumberOfSummaryInv() {
        return lastDocumentNumberOfSummaryInv;
    }

    /**
     * Sets the value of the lastDocumentNumberOfSummaryInv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastDocumentNumberOfSummaryInv(JAXBElement<String> value) {
        this.lastDocumentNumberOfSummaryInv = value;
    }

}
