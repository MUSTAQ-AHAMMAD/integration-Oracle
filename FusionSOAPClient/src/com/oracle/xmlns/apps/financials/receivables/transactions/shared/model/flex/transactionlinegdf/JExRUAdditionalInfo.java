
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinegdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExRUAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExRUAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/}TransactionLineGdf">
 *       &lt;sequence>
 *         &lt;element name="FLEX_PARAM_HeaderCorrectedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_InvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_BillToSiteUseId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_CustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CorrectedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CorrectedInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorrectedLine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CorrectedLine_Display" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CustomsDeclarationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginCountry_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxpointdate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="taxPointDateHistory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExRUAdditionalInfo", propOrder = {
    "flexparamHeaderCorrectedInvoice",
    "flexparamInvoiceDate",
    "flexparamBillToSiteUseId",
    "flexparamCustomerTrxId",
    "correctedInvoice",
    "correctedInvoiceDisplay",
    "correctedLine",
    "correctedLineDisplay",
    "customsDeclarationNumber",
    "originCountry",
    "originCountryDisplay",
    "taxpointdate",
    "taxPointDateHistory"
})
public class JExRUAdditionalInfo
    extends TransactionLineGdf
{

    @XmlElementRef(name = "FLEX_PARAM_HeaderCorrectedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamHeaderCorrectedInvoice;
    @XmlElementRef(name = "FLEX_PARAM_InvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> flexparamInvoiceDate;
    @XmlElementRef(name = "FLEX_PARAM_BillToSiteUseId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamBillToSiteUseId;
    @XmlElementRef(name = "FLEX_PARAM_CustomerTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamCustomerTrxId;
    @XmlElementRef(name = "CorrectedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedInvoice;
    @XmlElementRef(name = "CorrectedInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correctedInvoiceDisplay;
    @XmlElementRef(name = "CorrectedLine", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedLine;
    @XmlElementRef(name = "CorrectedLine_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedLineDisplay;
    @XmlElementRef(name = "CustomsDeclarationNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customsDeclarationNumber;
    @XmlElementRef(name = "OriginCountry", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originCountry;
    @XmlElementRef(name = "OriginCountry_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originCountryDisplay;
    @XmlElementRef(name = "taxpointdate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxpointdate;
    @XmlElementRef(name = "taxPointDateHistory", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxPointDateHistory;

    /**
     * Gets the value of the flexparamHeaderCorrectedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMHeaderCorrectedInvoice() {
        return flexparamHeaderCorrectedInvoice;
    }

    /**
     * Sets the value of the flexparamHeaderCorrectedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMHeaderCorrectedInvoice(JAXBElement<BigDecimal> value) {
        this.flexparamHeaderCorrectedInvoice = value;
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
     * Gets the value of the correctedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCorrectedInvoice() {
        return correctedInvoice;
    }

    /**
     * Sets the value of the correctedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCorrectedInvoice(JAXBElement<BigDecimal> value) {
        this.correctedInvoice = value;
    }

    /**
     * Gets the value of the correctedInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorrectedInvoiceDisplay() {
        return correctedInvoiceDisplay;
    }

    /**
     * Sets the value of the correctedInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorrectedInvoiceDisplay(JAXBElement<String> value) {
        this.correctedInvoiceDisplay = value;
    }

    /**
     * Gets the value of the correctedLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCorrectedLine() {
        return correctedLine;
    }

    /**
     * Sets the value of the correctedLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCorrectedLine(JAXBElement<BigDecimal> value) {
        this.correctedLine = value;
    }

    /**
     * Gets the value of the correctedLineDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCorrectedLineDisplay() {
        return correctedLineDisplay;
    }

    /**
     * Sets the value of the correctedLineDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCorrectedLineDisplay(JAXBElement<BigDecimal> value) {
        this.correctedLineDisplay = value;
    }

    /**
     * Gets the value of the customsDeclarationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomsDeclarationNumber() {
        return customsDeclarationNumber;
    }

    /**
     * Sets the value of the customsDeclarationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomsDeclarationNumber(JAXBElement<String> value) {
        this.customsDeclarationNumber = value;
    }

    /**
     * Gets the value of the originCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginCountry() {
        return originCountry;
    }

    /**
     * Sets the value of the originCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginCountry(JAXBElement<String> value) {
        this.originCountry = value;
    }

    /**
     * Gets the value of the originCountryDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginCountryDisplay() {
        return originCountryDisplay;
    }

    /**
     * Sets the value of the originCountryDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginCountryDisplay(JAXBElement<String> value) {
        this.originCountryDisplay = value;
    }

    /**
     * Gets the value of the taxpointdate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTaxpointdate() {
        return taxpointdate;
    }

    /**
     * Sets the value of the taxpointdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTaxpointdate(JAXBElement<XMLGregorianCalendar> value) {
        this.taxpointdate = value;
    }

    /**
     * Gets the value of the taxPointDateHistory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxPointDateHistory() {
        return taxPointDateHistory;
    }

    /**
     * Sets the value of the taxPointDateHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxPointDateHistory(JAXBElement<String> value) {
        this.taxPointDateHistory = value;
    }

}
