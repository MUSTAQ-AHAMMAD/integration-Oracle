
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JLxMXReceivablesInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JLxMXReceivablesInformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
 *         &lt;element name="CFDIUniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFDCBBSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFDCBBInvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JLxMXReceivablesInformation", propOrder = {
    "cfdiUniqueIdentifier",
    "cfdcbbSerialNumber",
    "cfdcbbInvoiceNumber"
})
public class JLxMXReceivablesInformation
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "CFDIUniqueIdentifier", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cfdiUniqueIdentifier;
    @XmlElementRef(name = "CFDCBBSerialNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cfdcbbSerialNumber;
    @XmlElementRef(name = "CFDCBBInvoiceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cfdcbbInvoiceNumber;

    /**
     * Gets the value of the cfdiUniqueIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCFDIUniqueIdentifier() {
        return cfdiUniqueIdentifier;
    }

    /**
     * Sets the value of the cfdiUniqueIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCFDIUniqueIdentifier(JAXBElement<String> value) {
        this.cfdiUniqueIdentifier = value;
    }

    /**
     * Gets the value of the cfdcbbSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCFDCBBSerialNumber() {
        return cfdcbbSerialNumber;
    }

    /**
     * Sets the value of the cfdcbbSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCFDCBBSerialNumber(JAXBElement<String> value) {
        this.cfdcbbSerialNumber = value;
    }

    /**
     * Gets the value of the cfdcbbInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCFDCBBInvoiceNumber() {
        return cfdcbbInvoiceNumber;
    }

    /**
     * Sets the value of the cfdcbbInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCFDCBBInvoiceNumber(JAXBElement<String> value) {
        this.cfdcbbInvoiceNumber = value;
    }

}
