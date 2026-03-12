
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExPTAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExPTAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
 *         &lt;element name="FLEX_PARAM_OrgId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_InvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_BillToSiteUseId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_CustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PrintStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrintStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HashControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CertificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HashValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemEntryDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ExternalTransactionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ExternalTransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalTransactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalHashKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalReferenceKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefferenceApplType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefferenceApplType_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceReference" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InvoiceReference_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MultipleInvReferences" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExPTAdditionalInfo", propOrder = {
    "flexparamOrgId",
    "flexparamInvoiceDate",
    "flexparamBillToSiteUseId",
    "flexparamCustomerTrxId",
    "printStatus",
    "printStatusDisplay",
    "hashControlValue",
    "certificationNumber",
    "hashValue",
    "systemEntryDate",
    "externalTransactionDate",
    "externalTransactionNumber",
    "externalTransactionAmount",
    "externalHashKey",
    "externalReferenceKey",
    "sourceSystemID",
    "invoiceStatus",
    "invoiceStatusDisplay",
    "refferenceApplType",
    "refferenceApplTypeDisplay",
    "invoiceReference",
    "invoiceReferenceDisplay",
    "multipleInvReferences"
})
public class JExPTAdditionalInfo
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "FLEX_PARAM_OrgId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamOrgId;
    @XmlElementRef(name = "FLEX_PARAM_InvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> flexparamInvoiceDate;
    @XmlElementRef(name = "FLEX_PARAM_BillToSiteUseId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamBillToSiteUseId;
    @XmlElementRef(name = "FLEX_PARAM_CustomerTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamCustomerTrxId;
    @XmlElementRef(name = "PrintStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> printStatus;
    @XmlElementRef(name = "PrintStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> printStatusDisplay;
    @XmlElementRef(name = "HashControlValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hashControlValue;
    @XmlElementRef(name = "CertificationNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> certificationNumber;
    @XmlElementRef(name = "HashValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hashValue;
    @XmlElementRef(name = "SystemEntryDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> systemEntryDate;
    @XmlElementRef(name = "ExternalTransactionDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> externalTransactionDate;
    @XmlElementRef(name = "ExternalTransactionNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalTransactionNumber;
    @XmlElementRef(name = "ExternalTransactionAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalTransactionAmount;
    @XmlElementRef(name = "ExternalHashKey", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalHashKey;
    @XmlElementRef(name = "ExternalReferenceKey", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalReferenceKey;
    @XmlElementRef(name = "SourceSystemID", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceSystemID;
    @XmlElementRef(name = "InvoiceStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoiceStatus;
    @XmlElementRef(name = "InvoiceStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoiceStatusDisplay;
    @XmlElementRef(name = "RefferenceApplType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> refferenceApplType;
    @XmlElementRef(name = "RefferenceApplType_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> refferenceApplTypeDisplay;
    @XmlElementRef(name = "InvoiceReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> invoiceReference;
    @XmlElementRef(name = "InvoiceReference_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoiceReferenceDisplay;
    @XmlElementRef(name = "MultipleInvReferences", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> multipleInvReferences;

    /**
     * Gets the value of the flexparamOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMOrgId() {
        return flexparamOrgId;
    }

    /**
     * Sets the value of the flexparamOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMOrgId(JAXBElement<BigDecimal> value) {
        this.flexparamOrgId = value;
    }

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
     * Gets the value of the printStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrintStatus() {
        return printStatus;
    }

    /**
     * Sets the value of the printStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrintStatus(JAXBElement<String> value) {
        this.printStatus = value;
    }

    /**
     * Gets the value of the printStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrintStatusDisplay() {
        return printStatusDisplay;
    }

    /**
     * Sets the value of the printStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrintStatusDisplay(JAXBElement<String> value) {
        this.printStatusDisplay = value;
    }

    /**
     * Gets the value of the hashControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHashControlValue() {
        return hashControlValue;
    }

    /**
     * Sets the value of the hashControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHashControlValue(JAXBElement<String> value) {
        this.hashControlValue = value;
    }

    /**
     * Gets the value of the certificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCertificationNumber() {
        return certificationNumber;
    }

    /**
     * Sets the value of the certificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCertificationNumber(JAXBElement<String> value) {
        this.certificationNumber = value;
    }

    /**
     * Gets the value of the hashValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHashValue() {
        return hashValue;
    }

    /**
     * Sets the value of the hashValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHashValue(JAXBElement<String> value) {
        this.hashValue = value;
    }

    /**
     * Gets the value of the systemEntryDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSystemEntryDate() {
        return systemEntryDate;
    }

    /**
     * Sets the value of the systemEntryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSystemEntryDate(JAXBElement<XMLGregorianCalendar> value) {
        this.systemEntryDate = value;
    }

    /**
     * Gets the value of the externalTransactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExternalTransactionDate() {
        return externalTransactionDate;
    }

    /**
     * Sets the value of the externalTransactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExternalTransactionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.externalTransactionDate = value;
    }

    /**
     * Gets the value of the externalTransactionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalTransactionNumber() {
        return externalTransactionNumber;
    }

    /**
     * Sets the value of the externalTransactionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalTransactionNumber(JAXBElement<String> value) {
        this.externalTransactionNumber = value;
    }

    /**
     * Gets the value of the externalTransactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalTransactionAmount() {
        return externalTransactionAmount;
    }

    /**
     * Sets the value of the externalTransactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalTransactionAmount(JAXBElement<String> value) {
        this.externalTransactionAmount = value;
    }

    /**
     * Gets the value of the externalHashKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalHashKey() {
        return externalHashKey;
    }

    /**
     * Sets the value of the externalHashKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalHashKey(JAXBElement<String> value) {
        this.externalHashKey = value;
    }

    /**
     * Gets the value of the externalReferenceKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalReferenceKey() {
        return externalReferenceKey;
    }

    /**
     * Sets the value of the externalReferenceKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalReferenceKey(JAXBElement<String> value) {
        this.externalReferenceKey = value;
    }

    /**
     * Gets the value of the sourceSystemID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceSystemID() {
        return sourceSystemID;
    }

    /**
     * Sets the value of the sourceSystemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceSystemID(JAXBElement<String> value) {
        this.sourceSystemID = value;
    }

    /**
     * Gets the value of the invoiceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * Sets the value of the invoiceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceStatus(JAXBElement<String> value) {
        this.invoiceStatus = value;
    }

    /**
     * Gets the value of the invoiceStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceStatusDisplay() {
        return invoiceStatusDisplay;
    }

    /**
     * Sets the value of the invoiceStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceStatusDisplay(JAXBElement<String> value) {
        this.invoiceStatusDisplay = value;
    }

    /**
     * Gets the value of the refferenceApplType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRefferenceApplType() {
        return refferenceApplType;
    }

    /**
     * Sets the value of the refferenceApplType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRefferenceApplType(JAXBElement<String> value) {
        this.refferenceApplType = value;
    }

    /**
     * Gets the value of the refferenceApplTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRefferenceApplTypeDisplay() {
        return refferenceApplTypeDisplay;
    }

    /**
     * Sets the value of the refferenceApplTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRefferenceApplTypeDisplay(JAXBElement<String> value) {
        this.refferenceApplTypeDisplay = value;
    }

    /**
     * Gets the value of the invoiceReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInvoiceReference() {
        return invoiceReference;
    }

    /**
     * Sets the value of the invoiceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInvoiceReference(JAXBElement<BigDecimal> value) {
        this.invoiceReference = value;
    }

    /**
     * Gets the value of the invoiceReferenceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceReferenceDisplay() {
        return invoiceReferenceDisplay;
    }

    /**
     * Sets the value of the invoiceReferenceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceReferenceDisplay(JAXBElement<String> value) {
        this.invoiceReferenceDisplay = value;
    }

    /**
     * Gets the value of the multipleInvReferences property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMultipleInvReferences() {
        return multipleInvReferences;
    }

    /**
     * Sets the value of the multipleInvReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMultipleInvReferences(JAXBElement<String> value) {
        this.multipleInvReferences = value;
    }

}
