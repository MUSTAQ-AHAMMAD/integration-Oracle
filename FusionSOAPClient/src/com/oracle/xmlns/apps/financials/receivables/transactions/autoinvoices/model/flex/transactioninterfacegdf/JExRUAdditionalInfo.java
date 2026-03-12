
package com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactioninterfacegdf;

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
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/}TransactionInterfaceGdf">
 *       &lt;sequence>
 *         &lt;element name="PreviousInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RevisedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RevisionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorrectedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TaxPointDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="Consignor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnSupplier" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnSupplierInv" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnCustomer" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ConfirmedbyThirdParties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfirmedbyThirdParties_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "previousInvoice",
    "revisedInvoice",
    "revisionNumber",
    "correctedInvoice",
    "taxPointDate",
    "consignor",
    "intermediaryTrxnSupplier",
    "intermediaryTrxnSupplierInv",
    "intermediaryTrxnCustomer",
    "confirmedbyThirdParties",
    "confirmedbyThirdPartiesDisplay"
})
public class JExRUAdditionalInfo
    extends TransactionInterfaceGdf
{

    @XmlElementRef(name = "PreviousInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> previousInvoice;
    @XmlElementRef(name = "RevisedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> revisedInvoice;
    @XmlElementRef(name = "RevisionNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> revisionNumber;
    @XmlElementRef(name = "CorrectedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedInvoice;
    @XmlElementRef(name = "TaxPointDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxPointDate;
    @XmlElementRef(name = "Consignor", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> consignor;
    @XmlElementRef(name = "IntermediaryTrxnSupplier", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> intermediaryTrxnSupplier;
    @XmlElementRef(name = "IntermediaryTrxnSupplierInv", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> intermediaryTrxnSupplierInv;
    @XmlElementRef(name = "IntermediaryTrxnCustomer", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> intermediaryTrxnCustomer;
    @XmlElementRef(name = "ConfirmedbyThirdParties", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> confirmedbyThirdParties;
    @XmlElementRef(name = "ConfirmedbyThirdParties_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> confirmedbyThirdPartiesDisplay;

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
     * Gets the value of the revisedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getRevisedInvoice() {
        return revisedInvoice;
    }

    /**
     * Sets the value of the revisedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setRevisedInvoice(JAXBElement<BigDecimal> value) {
        this.revisedInvoice = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRevisionNumber(JAXBElement<String> value) {
        this.revisionNumber = value;
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
     * Gets the value of the consignor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getConsignor() {
        return consignor;
    }

    /**
     * Sets the value of the consignor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setConsignor(JAXBElement<BigDecimal> value) {
        this.consignor = value;
    }

    /**
     * Gets the value of the intermediaryTrxnSupplier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIntermediaryTrxnSupplier() {
        return intermediaryTrxnSupplier;
    }

    /**
     * Sets the value of the intermediaryTrxnSupplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIntermediaryTrxnSupplier(JAXBElement<BigDecimal> value) {
        this.intermediaryTrxnSupplier = value;
    }

    /**
     * Gets the value of the intermediaryTrxnSupplierInv property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIntermediaryTrxnSupplierInv() {
        return intermediaryTrxnSupplierInv;
    }

    /**
     * Sets the value of the intermediaryTrxnSupplierInv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIntermediaryTrxnSupplierInv(JAXBElement<BigDecimal> value) {
        this.intermediaryTrxnSupplierInv = value;
    }

    /**
     * Gets the value of the intermediaryTrxnCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIntermediaryTrxnCustomer() {
        return intermediaryTrxnCustomer;
    }

    /**
     * Sets the value of the intermediaryTrxnCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIntermediaryTrxnCustomer(JAXBElement<BigDecimal> value) {
        this.intermediaryTrxnCustomer = value;
    }

    /**
     * Gets the value of the confirmedbyThirdParties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfirmedbyThirdParties() {
        return confirmedbyThirdParties;
    }

    /**
     * Sets the value of the confirmedbyThirdParties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfirmedbyThirdParties(JAXBElement<String> value) {
        this.confirmedbyThirdParties = value;
    }

    /**
     * Gets the value of the confirmedbyThirdPartiesDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfirmedbyThirdPartiesDisplay() {
        return confirmedbyThirdPartiesDisplay;
    }

    /**
     * Sets the value of the confirmedbyThirdPartiesDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfirmedbyThirdPartiesDisplay(JAXBElement<String> value) {
        this.confirmedbyThirdPartiesDisplay = value;
    }

}
