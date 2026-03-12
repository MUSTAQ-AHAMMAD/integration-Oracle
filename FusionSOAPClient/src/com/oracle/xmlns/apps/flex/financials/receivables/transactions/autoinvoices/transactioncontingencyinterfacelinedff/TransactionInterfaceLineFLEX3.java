
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioncontingencyinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceLineFLEXGLOBAL_5FPROCUREMENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceLineFLEXGLOBAL_5FPROCUREMENT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="_PO__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_PO__Line__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Receiving__Inventory__Org" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Purchasing__Operating__Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Receiving__Operating__Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_PO__Line__Location__ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Create__AP__Invoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceLineFLEXGLOBAL_5FPROCUREMENT", propOrder = {
    "poNumber",
    "poLineNumber",
    "receivingInventoryOrg",
    "purchasingOperatingUnit",
    "receivingOperatingUnit",
    "poLineLocationID",
    "reference",
    "createAPInvoice"
})
public class TransactionInterfaceLineFLEX3
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "_PO__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> poNumber;
    @XmlElementRef(name = "_PO__Line__Number", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> poLineNumber;
    @XmlElementRef(name = "_Receiving__Inventory__Org", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receivingInventoryOrg;
    @XmlElementRef(name = "_Purchasing__Operating__Unit", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchasingOperatingUnit;
    @XmlElementRef(name = "_Receiving__Operating__Unit", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receivingOperatingUnit;
    @XmlElementRef(name = "_PO__Line__Location__ID", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> poLineLocationID;
    @XmlElementRef(name = "_Reference", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "_Create__AP__Invoice", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> createAPInvoice;

    /**
     * Gets the value of the poNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPONumber() {
        return poNumber;
    }

    /**
     * Sets the value of the poNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPONumber(JAXBElement<String> value) {
        this.poNumber = value;
    }

    /**
     * Gets the value of the poLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPOLineNumber() {
        return poLineNumber;
    }

    /**
     * Sets the value of the poLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPOLineNumber(JAXBElement<String> value) {
        this.poLineNumber = value;
    }

    /**
     * Gets the value of the receivingInventoryOrg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceivingInventoryOrg() {
        return receivingInventoryOrg;
    }

    /**
     * Sets the value of the receivingInventoryOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceivingInventoryOrg(JAXBElement<String> value) {
        this.receivingInventoryOrg = value;
    }

    /**
     * Gets the value of the purchasingOperatingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchasingOperatingUnit() {
        return purchasingOperatingUnit;
    }

    /**
     * Sets the value of the purchasingOperatingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchasingOperatingUnit(JAXBElement<String> value) {
        this.purchasingOperatingUnit = value;
    }

    /**
     * Gets the value of the receivingOperatingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceivingOperatingUnit() {
        return receivingOperatingUnit;
    }

    /**
     * Sets the value of the receivingOperatingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceivingOperatingUnit(JAXBElement<String> value) {
        this.receivingOperatingUnit = value;
    }

    /**
     * Gets the value of the poLineLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPOLineLocationID() {
        return poLineLocationID;
    }

    /**
     * Sets the value of the poLineLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPOLineLocationID(JAXBElement<String> value) {
        this.poLineLocationID = value;
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

}
