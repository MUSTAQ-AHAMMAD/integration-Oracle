
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactiondistributioninterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OraFixedAssets complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OraFixedAssets">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="shippingReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingLineReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OraFixedAssets", propOrder = {
    "shippingReference",
    "shippingLineReference"
})
public class OraFixedAssets
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "shippingReference", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shippingReference;
    @XmlElementRef(name = "shippingLineReference", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shippingLineReference;

    /**
     * Gets the value of the shippingReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingReference() {
        return shippingReference;
    }

    /**
     * Sets the value of the shippingReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingReference(JAXBElement<String> value) {
        this.shippingReference = value;
    }

    /**
     * Gets the value of the shippingLineReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingLineReference() {
        return shippingLineReference;
    }

    /**
     * Sets the value of the shippingLineReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingLineReference(JAXBElement<String> value) {
        this.shippingLineReference = value;
    }

}
