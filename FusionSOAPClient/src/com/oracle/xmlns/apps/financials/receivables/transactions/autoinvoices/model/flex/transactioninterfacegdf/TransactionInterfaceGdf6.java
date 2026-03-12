
package com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactioninterfacegdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TransactionInterfaceGdfJE_5FES_5FMODELO349 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceGdfJE_5FES_5FMODELO349">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/}TransactionInterfaceGdf">
 *       &lt;sequence>
 *         &lt;element name="_Correction__Year" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Correction__Period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Transaction__Deadline" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Transaction__Date" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="TransactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateLastUpdated" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceGdfJE_5FES_5FMODELO349", propOrder = {
    "correctionYear",
    "correctionPeriod",
    "transactionDeadline",
    "transactionDate",
    "transactionStatus",
    "transactionStatusDisplay",
    "taxAuthorityStatus",
    "taxAuthorityStatusDisplay",
    "messageCode",
    "messageDescription",
    "dateLastUpdated"
})
public class TransactionInterfaceGdf6
    extends TransactionInterfaceGdf
{

    @XmlElementRef(name = "_Correction__Year", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correctionYear;
    @XmlElementRef(name = "_Correction__Period", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correctionPeriod;
    @XmlElementRef(name = "_Transaction__Deadline", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> transactionDeadline;
    @XmlElementRef(name = "_Transaction__Date", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> transactionDate;
    @XmlElementRef(name = "TransactionStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatus;
    @XmlElementRef(name = "TransactionStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatusDisplay;
    @XmlElementRef(name = "TaxAuthorityStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatus;
    @XmlElementRef(name = "TaxAuthorityStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatusDisplay;
    @XmlElementRef(name = "MessageCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageCode;
    @XmlElementRef(name = "MessageDescription", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageDescription;
    @XmlElementRef(name = "DateLastUpdated", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateLastUpdated;

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
     * Gets the value of the transactionDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTransactionDeadline() {
        return transactionDeadline;
    }

    /**
     * Sets the value of the transactionDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTransactionDeadline(JAXBElement<BigDecimal> value) {
        this.transactionDeadline = value;
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

}
