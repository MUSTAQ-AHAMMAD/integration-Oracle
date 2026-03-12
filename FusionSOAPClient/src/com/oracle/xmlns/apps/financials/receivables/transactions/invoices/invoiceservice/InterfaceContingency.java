
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioncontingencyinterfacelinedff.TransactionInterfaceLineFLEX;


/**
 * <p>Java class for InterfaceContingency complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterfaceContingency">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContingencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpirationDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ExpirationDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ExpirationEventDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ContingencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Completed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContingencyInterfaceLineDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/}TransactionInterfaceLineFLEX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterfaceContingency", propOrder = {
    "contingencyCode",
    "expirationDate",
    "expirationDays",
    "expirationEventDate",
    "contingencyId",
    "orgId",
    "completed",
    "contingencyInterfaceLineDff"
})
public class InterfaceContingency {

    @XmlElementRef(name = "ContingencyCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contingencyCode;
    @XmlElementRef(name = "ExpirationDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> expirationDate;
    @XmlElementRef(name = "ExpirationDays", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> expirationDays;
    @XmlElementRef(name = "ExpirationEventDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> expirationEventDate;
    @XmlElement(name = "ContingencyId")
    protected Long contingencyId;
    @XmlElement(name = "OrgId")
    protected Long orgId;
    @XmlElementRef(name = "Completed", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> completed;
    @XmlElement(name = "ContingencyInterfaceLineDff")
    protected TransactionInterfaceLineFLEX contingencyInterfaceLineDff;

    /**
     * Gets the value of the contingencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContingencyCode() {
        return contingencyCode;
    }

    /**
     * Sets the value of the contingencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContingencyCode(JAXBElement<String> value) {
        this.contingencyCode = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpirationDate(JAXBElement<XMLGregorianCalendar> value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the expirationDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getExpirationDays() {
        return expirationDays;
    }

    /**
     * Sets the value of the expirationDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setExpirationDays(JAXBElement<BigDecimal> value) {
        this.expirationDays = value;
    }

    /**
     * Gets the value of the expirationEventDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpirationEventDate() {
        return expirationEventDate;
    }

    /**
     * Sets the value of the expirationEventDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpirationEventDate(JAXBElement<XMLGregorianCalendar> value) {
        this.expirationEventDate = value;
    }

    /**
     * Gets the value of the contingencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContingencyId() {
        return contingencyId;
    }

    /**
     * Sets the value of the contingencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContingencyId(Long value) {
        this.contingencyId = value;
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
     * Gets the value of the completed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompleted() {
        return completed;
    }

    /**
     * Sets the value of the completed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompleted(JAXBElement<String> value) {
        this.completed = value;
    }

    /**
     * Gets the value of the contingencyInterfaceLineDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public TransactionInterfaceLineFLEX getContingencyInterfaceLineDff() {
        return contingencyInterfaceLineDff;
    }

    /**
     * Sets the value of the contingencyInterfaceLineDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public void setContingencyInterfaceLineDff(TransactionInterfaceLineFLEX value) {
        this.contingencyInterfaceLineDff = value;
    }

}
