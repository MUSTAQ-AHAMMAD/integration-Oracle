
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioncontingencyinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceLineFLEXDOO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceLineFLEXDOO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="_Source__Order__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Source__Order__System" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_DOO__Order__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Fulfillment__Line__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Price__Adjustment__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Delivery__Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_WayBill__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Bill__of__Lading__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Customer__Item" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Fulfill__Line__Split__Reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Source__Schedule__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Fulfillment__Line__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Profit__Center__Business__Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceLineFLEXDOO", propOrder = {
    "sourceOrderNumber",
    "sourceOrderSystem",
    "dooOrderNumber",
    "fulfillmentLineID",
    "priceAdjustmentID",
    "deliveryName",
    "wayBillNumber",
    "billOfLadingNumber",
    "customerItem",
    "fulfillLineSplitReference",
    "sourceScheduleNumber",
    "fulfillmentLineNumber",
    "profitCenterBusinessUnit",
    "period"
})
public class TransactionInterfaceLineFLEXDOO
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "_Source__Order__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceOrderNumber;
    @XmlElementRef(name = "_Source__Order__System", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceOrderSystem;
    @XmlElementRef(name = "_DOO__Order__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dooOrderNumber;
    @XmlElementRef(name = "_Fulfillment__Line__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fulfillmentLineID;
    @XmlElementRef(name = "_Price__Adjustment__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> priceAdjustmentID;
    @XmlElementRef(name = "_Delivery__Name", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryName;
    @XmlElementRef(name = "_WayBill__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wayBillNumber;
    @XmlElementRef(name = "_Bill__of__Lading__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billOfLadingNumber;
    @XmlElementRef(name = "_Customer__Item", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerItem;
    @XmlElementRef(name = "_Fulfill__Line__Split__Reference", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fulfillLineSplitReference;
    @XmlElementRef(name = "_Source__Schedule__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceScheduleNumber;
    @XmlElementRef(name = "_Fulfillment__Line__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fulfillmentLineNumber;
    @XmlElementRef(name = "_Profit__Center__Business__Unit", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profitCenterBusinessUnit;
    @XmlElementRef(name = "period", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> period;

    /**
     * Gets the value of the sourceOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceOrderNumber() {
        return sourceOrderNumber;
    }

    /**
     * Sets the value of the sourceOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceOrderNumber(JAXBElement<String> value) {
        this.sourceOrderNumber = value;
    }

    /**
     * Gets the value of the sourceOrderSystem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceOrderSystem() {
        return sourceOrderSystem;
    }

    /**
     * Sets the value of the sourceOrderSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceOrderSystem(JAXBElement<String> value) {
        this.sourceOrderSystem = value;
    }

    /**
     * Gets the value of the dooOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDOOOrderNumber() {
        return dooOrderNumber;
    }

    /**
     * Sets the value of the dooOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDOOOrderNumber(JAXBElement<String> value) {
        this.dooOrderNumber = value;
    }

    /**
     * Gets the value of the fulfillmentLineID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFulfillmentLineID() {
        return fulfillmentLineID;
    }

    /**
     * Sets the value of the fulfillmentLineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFulfillmentLineID(JAXBElement<String> value) {
        this.fulfillmentLineID = value;
    }

    /**
     * Gets the value of the priceAdjustmentID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPriceAdjustmentID() {
        return priceAdjustmentID;
    }

    /**
     * Sets the value of the priceAdjustmentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPriceAdjustmentID(JAXBElement<String> value) {
        this.priceAdjustmentID = value;
    }

    /**
     * Gets the value of the deliveryName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryName() {
        return deliveryName;
    }

    /**
     * Sets the value of the deliveryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryName(JAXBElement<String> value) {
        this.deliveryName = value;
    }

    /**
     * Gets the value of the wayBillNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWayBillNumber() {
        return wayBillNumber;
    }

    /**
     * Sets the value of the wayBillNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWayBillNumber(JAXBElement<String> value) {
        this.wayBillNumber = value;
    }

    /**
     * Gets the value of the billOfLadingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillOfLadingNumber() {
        return billOfLadingNumber;
    }

    /**
     * Sets the value of the billOfLadingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillOfLadingNumber(JAXBElement<String> value) {
        this.billOfLadingNumber = value;
    }

    /**
     * Gets the value of the customerItem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerItem() {
        return customerItem;
    }

    /**
     * Sets the value of the customerItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerItem(JAXBElement<String> value) {
        this.customerItem = value;
    }

    /**
     * Gets the value of the fulfillLineSplitReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFulfillLineSplitReference() {
        return fulfillLineSplitReference;
    }

    /**
     * Sets the value of the fulfillLineSplitReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFulfillLineSplitReference(JAXBElement<String> value) {
        this.fulfillLineSplitReference = value;
    }

    /**
     * Gets the value of the sourceScheduleNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceScheduleNumber() {
        return sourceScheduleNumber;
    }

    /**
     * Sets the value of the sourceScheduleNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceScheduleNumber(JAXBElement<String> value) {
        this.sourceScheduleNumber = value;
    }

    /**
     * Gets the value of the fulfillmentLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFulfillmentLineNumber() {
        return fulfillmentLineNumber;
    }

    /**
     * Sets the value of the fulfillmentLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFulfillmentLineNumber(JAXBElement<String> value) {
        this.fulfillmentLineNumber = value;
    }

    /**
     * Gets the value of the profitCenterBusinessUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfitCenterBusinessUnit() {
        return profitCenterBusinessUnit;
    }

    /**
     * Sets the value of the profitCenterBusinessUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfitCenterBusinessUnit(JAXBElement<String> value) {
        this.profitCenterBusinessUnit = value;
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

}
