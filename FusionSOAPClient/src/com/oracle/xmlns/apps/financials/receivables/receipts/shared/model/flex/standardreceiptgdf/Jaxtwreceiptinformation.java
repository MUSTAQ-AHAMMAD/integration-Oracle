
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.standardreceiptgdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Jaxtwreceiptinformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Jaxtwreceiptinformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/}StandardReceiptGdf">
 *       &lt;sequence>
 *         &lt;element name="invoiceFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wineAndCigarette" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wineAndCigarette_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Jaxtwreceiptinformation", propOrder = {
    "invoiceFormat",
    "wineAndCigarette",
    "wineAndCigaretteDisplay"
})
public class Jaxtwreceiptinformation
    extends StandardReceiptGdf
{

    @XmlElementRef(name = "invoiceFormat", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoiceFormat;
    @XmlElementRef(name = "wineAndCigarette", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wineAndCigarette;
    @XmlElementRef(name = "wineAndCigarette_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wineAndCigaretteDisplay;

    /**
     * Gets the value of the invoiceFormat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceFormat() {
        return invoiceFormat;
    }

    /**
     * Sets the value of the invoiceFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceFormat(JAXBElement<String> value) {
        this.invoiceFormat = value;
    }

    /**
     * Gets the value of the wineAndCigarette property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWineAndCigarette() {
        return wineAndCigarette;
    }

    /**
     * Sets the value of the wineAndCigarette property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWineAndCigarette(JAXBElement<String> value) {
        this.wineAndCigarette = value;
    }

    /**
     * Gets the value of the wineAndCigaretteDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWineAndCigaretteDisplay() {
        return wineAndCigaretteDisplay;
    }

    /**
     * Sets the value of the wineAndCigaretteDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWineAndCigaretteDisplay(JAXBElement<String> value) {
        this.wineAndCigaretteDisplay = value;
    }

}
