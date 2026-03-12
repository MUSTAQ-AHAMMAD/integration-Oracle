
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinegdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExPLAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExPLAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/}TransactionLineGdf">
 *       &lt;sequence>
 *         &lt;element name="FLEX_PARAM_HeaderCorrectedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_InvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_BillToSiteUseId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_CustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BasePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PreviousInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PreviousInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreviousInvoiceLineNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PreviousInvoiceLineNumber_Display" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReversalLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prepaymentInvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prepaymentInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxPointDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
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
@XmlType(name = "JExPLAdditionalInfo", propOrder = {
    "flexparamHeaderCorrectedInvoice",
    "flexparamInvoiceDate",
    "flexparamBillToSiteUseId",
    "flexparamCustomerTrxId",
    "basePrice",
    "discount",
    "previousInvoice",
    "previousInvoiceDisplay",
    "previousInvoiceLineNumber",
    "previousInvoiceLineNumberDisplay",
    "reversalLine",
    "prepaymentInvoice",
    "prepaymentInvoiceDisplay",
    "taxPointDate",
    "taxPointDateHistory"
})
public class JExPLAdditionalInfo
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
    @XmlElementRef(name = "BasePrice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> basePrice;
    @XmlElementRef(name = "Discount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> discount;
    @XmlElementRef(name = "PreviousInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> previousInvoice;
    @XmlElementRef(name = "PreviousInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> previousInvoiceDisplay;
    @XmlElementRef(name = "PreviousInvoiceLineNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> previousInvoiceLineNumber;
    @XmlElementRef(name = "PreviousInvoiceLineNumber_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> previousInvoiceLineNumberDisplay;
    @XmlElementRef(name = "ReversalLine", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reversalLine;
    @XmlElementRef(name = "prepaymentInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> prepaymentInvoice;
    @XmlElementRef(name = "prepaymentInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> prepaymentInvoiceDisplay;
    @XmlElementRef(name = "TaxPointDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxPointDate;
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
     * Gets the value of the basePrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the value of the basePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setBasePrice(JAXBElement<BigDecimal> value) {
        this.basePrice = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDiscount(JAXBElement<BigDecimal> value) {
        this.discount = value;
    }

    /**
     * Gets the value of the previousInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPreviousInvoice() {
        return previousInvoice;
    }

    /**
     * Sets the value of the previousInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPreviousInvoice(JAXBElement<BigDecimal> value) {
        this.previousInvoice = value;
    }

    /**
     * Gets the value of the previousInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreviousInvoiceDisplay() {
        return previousInvoiceDisplay;
    }

    /**
     * Sets the value of the previousInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreviousInvoiceDisplay(JAXBElement<String> value) {
        this.previousInvoiceDisplay = value;
    }

    /**
     * Gets the value of the previousInvoiceLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPreviousInvoiceLineNumber() {
        return previousInvoiceLineNumber;
    }

    /**
     * Sets the value of the previousInvoiceLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPreviousInvoiceLineNumber(JAXBElement<BigDecimal> value) {
        this.previousInvoiceLineNumber = value;
    }

    /**
     * Gets the value of the previousInvoiceLineNumberDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPreviousInvoiceLineNumberDisplay() {
        return previousInvoiceLineNumberDisplay;
    }

    /**
     * Sets the value of the previousInvoiceLineNumberDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPreviousInvoiceLineNumberDisplay(JAXBElement<BigDecimal> value) {
        this.previousInvoiceLineNumberDisplay = value;
    }

    /**
     * Gets the value of the reversalLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReversalLine() {
        return reversalLine;
    }

    /**
     * Sets the value of the reversalLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReversalLine(JAXBElement<String> value) {
        this.reversalLine = value;
    }

    /**
     * Gets the value of the prepaymentInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrepaymentInvoice() {
        return prepaymentInvoice;
    }

    /**
     * Sets the value of the prepaymentInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrepaymentInvoice(JAXBElement<String> value) {
        this.prepaymentInvoice = value;
    }

    /**
     * Gets the value of the prepaymentInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrepaymentInvoiceDisplay() {
        return prepaymentInvoiceDisplay;
    }

    /**
     * Sets the value of the prepaymentInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrepaymentInvoiceDisplay(JAXBElement<String> value) {
        this.prepaymentInvoiceDisplay = value;
    }

    /**
     * Gets the value of the taxPointDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * Sets the value of the taxPointDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTaxPointDate(JAXBElement<XMLGregorianCalendar> value) {
        this.taxPointDate = value;
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
