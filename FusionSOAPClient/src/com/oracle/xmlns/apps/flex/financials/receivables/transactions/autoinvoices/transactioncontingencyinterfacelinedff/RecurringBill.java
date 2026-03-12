
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioncontingencyinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecurringBill complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecurringBill">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="billPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lineNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurringBill", propOrder = {
    "billPlanName",
    "period",
    "lineNumber"
})
public class RecurringBill
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "billPlanName", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billPlanName;
    @XmlElementRef(name = "period", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> period;
    @XmlElementRef(name = "lineNumber", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lineNumber;

    /**
     * Gets the value of the billPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillPlanName() {
        return billPlanName;
    }

    /**
     * Sets the value of the billPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillPlanName(JAXBElement<String> value) {
        this.billPlanName = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPeriod(JAXBElement<String> value) {
        this.period = value;
    }

    /**
     * Gets the value of the lineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineNumber(JAXBElement<String> value) {
        this.lineNumber = value;
    }

}
