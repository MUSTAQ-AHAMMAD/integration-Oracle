
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

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
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
 *         &lt;element name="ExportDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDiffInvoManCreate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDiffInvoManCreate_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "exchangeRateDiffInvoManCreate",
    "exchangeRateDiffInvoManCreateDisplay"
})
public class JExTRAdditionalInfo
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "ExportDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> exportDate;
    @XmlElementRef(name = "ExchangeRateDiffInvoManCreate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDiffInvoManCreate;
    @XmlElementRef(name = "ExchangeRateDiffInvoManCreate_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDiffInvoManCreateDisplay;

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
     * Gets the value of the exchangeRateDiffInvoManCreate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDiffInvoManCreate() {
        return exchangeRateDiffInvoManCreate;
    }

    /**
     * Sets the value of the exchangeRateDiffInvoManCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDiffInvoManCreate(JAXBElement<String> value) {
        this.exchangeRateDiffInvoManCreate = value;
    }

    /**
     * Gets the value of the exchangeRateDiffInvoManCreateDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDiffInvoManCreateDisplay() {
        return exchangeRateDiffInvoManCreateDisplay;
    }

    /**
     * Sets the value of the exchangeRateDiffInvoManCreateDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDiffInvoManCreateDisplay(JAXBElement<String> value) {
        this.exchangeRateDiffInvoManCreateDisplay = value;
    }

}
