
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionsalescreditinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceLineFLEXFOS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceLineFLEXFOS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="_FOS__Flow__Instance__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Agreement__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Event__Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Event__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Primary__Trade__Relationship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Financial__Trade__Relationship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Event__Header__Number__" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Ship__From__Location__" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Order__Type__" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Profit__Center__Business__Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceLineFLEXFOS", propOrder = {
    "fosFlowInstanceID",
    "agreementNumber",
    "eventType",
    "eventID",
    "primaryTradeRelationship",
    "financialTradeRelationship",
    "eventHeaderNumber",
    "shipFromLocation",
    "orderType",
    "profitCenterBusinessUnit"
})
public class TransactionInterfaceLineFLEXFOS
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "_FOS__Flow__Instance__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fosFlowInstanceID;
    @XmlElementRef(name = "_Agreement__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> agreementNumber;
    @XmlElementRef(name = "_Event__Type", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eventType;
    @XmlElementRef(name = "_Event__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eventID;
    @XmlElementRef(name = "_Primary__Trade__Relationship", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> primaryTradeRelationship;
    @XmlElementRef(name = "_Financial__Trade__Relationship", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> financialTradeRelationship;
    @XmlElementRef(name = "_Event__Header__Number__", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eventHeaderNumber;
    @XmlElementRef(name = "_Ship__From__Location__", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shipFromLocation;
    @XmlElementRef(name = "_Order__Type__", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderType;
    @XmlElementRef(name = "_Profit__Center__Business__Unit", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profitCenterBusinessUnit;

    /**
     * Gets the value of the fosFlowInstanceID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFOSFlowInstanceID() {
        return fosFlowInstanceID;
    }

    /**
     * Sets the value of the fosFlowInstanceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFOSFlowInstanceID(JAXBElement<String> value) {
        this.fosFlowInstanceID = value;
    }

    /**
     * Gets the value of the agreementNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAgreementNumber() {
        return agreementNumber;
    }

    /**
     * Sets the value of the agreementNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAgreementNumber(JAXBElement<String> value) {
        this.agreementNumber = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEventType(JAXBElement<String> value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the eventID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEventID() {
        return eventID;
    }

    /**
     * Sets the value of the eventID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEventID(JAXBElement<String> value) {
        this.eventID = value;
    }

    /**
     * Gets the value of the primaryTradeRelationship property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrimaryTradeRelationship() {
        return primaryTradeRelationship;
    }

    /**
     * Sets the value of the primaryTradeRelationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrimaryTradeRelationship(JAXBElement<String> value) {
        this.primaryTradeRelationship = value;
    }

    /**
     * Gets the value of the financialTradeRelationship property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFinancialTradeRelationship() {
        return financialTradeRelationship;
    }

    /**
     * Sets the value of the financialTradeRelationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFinancialTradeRelationship(JAXBElement<String> value) {
        this.financialTradeRelationship = value;
    }

    /**
     * Gets the value of the eventHeaderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEventHeaderNumber() {
        return eventHeaderNumber;
    }

    /**
     * Sets the value of the eventHeaderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEventHeaderNumber(JAXBElement<String> value) {
        this.eventHeaderNumber = value;
    }

    /**
     * Gets the value of the shipFromLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipFromLocation() {
        return shipFromLocation;
    }

    /**
     * Sets the value of the shipFromLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipFromLocation(JAXBElement<String> value) {
        this.shipFromLocation = value;
    }

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderType(JAXBElement<String> value) {
        this.orderType = value;
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

}
