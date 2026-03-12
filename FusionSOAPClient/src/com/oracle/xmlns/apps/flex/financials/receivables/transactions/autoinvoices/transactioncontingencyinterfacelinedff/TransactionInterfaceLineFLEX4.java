
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioncontingencyinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceLineFLEXINTERCOMPANY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceLineFLEXINTERCOMPANY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="_Order__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Order__Line__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Shipping__Warehouse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Selling__Operating__Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Shipping__Operating__Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Order__Line__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Order__Org__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Create__AP__Invoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Price__Adjustment__ID_2FOrder__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceLineFLEXINTERCOMPANY", propOrder = {
    "orderNumber",
    "orderLineNumber",
    "reference",
    "shippingWarehouse",
    "sellingOperatingUnit",
    "shippingOperatingUnit",
    "orderLineID",
    "orderOrgID",
    "createAPInvoice",
    "priceAdjustmentID2FOrderID"
})
public class TransactionInterfaceLineFLEX4
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "_Order__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderNumber;
    @XmlElementRef(name = "_Order__Line__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderLineNumber;
    @XmlElementRef(name = "_Reference", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "_Shipping__Warehouse", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shippingWarehouse;
    @XmlElementRef(name = "_Selling__Operating__Unit", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sellingOperatingUnit;
    @XmlElementRef(name = "_Shipping__Operating__Unit", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shippingOperatingUnit;
    @XmlElementRef(name = "_Order__Line__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderLineID;
    @XmlElementRef(name = "_Order__Org__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderOrgID;
    @XmlElementRef(name = "_Create__AP__Invoice", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> createAPInvoice;
    @XmlElementRef(name = "_Price__Adjustment__ID_2FOrder__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> priceAdjustmentID2FOrderID;

    /**
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNumber(JAXBElement<String> value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the orderLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderLineNumber() {
        return orderLineNumber;
    }

    /**
     * Sets the value of the orderLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderLineNumber(JAXBElement<String> value) {
        this.orderLineNumber = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReference(JAXBElement<String> value) {
        this.reference = value;
    }

    /**
     * Gets the value of the shippingWarehouse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingWarehouse() {
        return shippingWarehouse;
    }

    /**
     * Sets the value of the shippingWarehouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingWarehouse(JAXBElement<String> value) {
        this.shippingWarehouse = value;
    }

    /**
     * Gets the value of the sellingOperatingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSellingOperatingUnit() {
        return sellingOperatingUnit;
    }

    /**
     * Sets the value of the sellingOperatingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSellingOperatingUnit(JAXBElement<String> value) {
        this.sellingOperatingUnit = value;
    }

    /**
     * Gets the value of the shippingOperatingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingOperatingUnit() {
        return shippingOperatingUnit;
    }

    /**
     * Sets the value of the shippingOperatingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingOperatingUnit(JAXBElement<String> value) {
        this.shippingOperatingUnit = value;
    }

    /**
     * Gets the value of the orderLineID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderLineID() {
        return orderLineID;
    }

    /**
     * Sets the value of the orderLineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderLineID(JAXBElement<String> value) {
        this.orderLineID = value;
    }

    /**
     * Gets the value of the orderOrgID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderOrgID() {
        return orderOrgID;
    }

    /**
     * Sets the value of the orderOrgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderOrgID(JAXBElement<String> value) {
        this.orderOrgID = value;
    }

    /**
     * Gets the value of the createAPInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreateAPInvoice() {
        return createAPInvoice;
    }

    /**
     * Sets the value of the createAPInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreateAPInvoice(JAXBElement<String> value) {
        this.createAPInvoice = value;
    }

    /**
     * Gets the value of the priceAdjustmentID2FOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPriceAdjustmentID2FOrderID() {
        return priceAdjustmentID2FOrderID;
    }

    /**
     * Sets the value of the priceAdjustmentID2FOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPriceAdjustmentID2FOrderID(JAXBElement<String> value) {
        this.priceAdjustmentID2FOrderID = value;
    }

}
