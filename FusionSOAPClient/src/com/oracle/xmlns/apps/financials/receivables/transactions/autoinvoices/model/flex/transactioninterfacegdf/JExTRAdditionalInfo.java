
package com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactioninterfacegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExTRAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExTRAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/}TransactionInterfaceGdf">
 *       &lt;sequence>
 *         &lt;element name="ExportDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDiffInvManCreate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDiffInvManCreate_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExTRAdditionalInfo", propOrder = {
    "exportDate",
    "exchangeRateDiffInvManCreate",
    "exchangeRateDiffInvManCreateDisplay"
})
public class JExTRAdditionalInfo
    extends TransactionInterfaceGdf
{

    @XmlElementRef(name = "ExportDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> exportDate;
    @XmlElementRef(name = "ExchangeRateDiffInvManCreate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDiffInvManCreate;
    @XmlElementRef(name = "ExchangeRateDiffInvManCreate_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDiffInvManCreateDisplay;

    /**
     * Gets the value of the exportDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExportDate() {
        return exportDate;
    }

    /**
     * Sets the value of the exportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExportDate(JAXBElement<XMLGregorianCalendar> value) {
        this.exportDate = value;
    }

    /**
     * Gets the value of the exchangeRateDiffInvManCreate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDiffInvManCreate() {
        return exchangeRateDiffInvManCreate;
    }

    /**
     * Sets the value of the exchangeRateDiffInvManCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDiffInvManCreate(JAXBElement<String> value) {
        this.exchangeRateDiffInvManCreate = value;
    }

    /**
     * Gets the value of the exchangeRateDiffInvManCreateDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDiffInvManCreateDisplay() {
        return exchangeRateDiffInvManCreateDisplay;
    }

    /**
     * Sets the value of the exchangeRateDiffInvManCreateDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDiffInvManCreateDisplay(JAXBElement<String> value) {
        this.exchangeRateDiffInvManCreateDisplay = value;
    }

}
