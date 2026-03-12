
package com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactionlineinterfacegdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JExRUAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExRUAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/}TransactionLineInterfaceGdf">
 *       &lt;sequence>
 *         &lt;element name="CorrectedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CorrectedLine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CustomsDeclarationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginCountry_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExRUAdditionalInfo", propOrder = {
    "correctedInvoice",
    "correctedLine",
    "customsDeclarationNumber",
    "originCountry",
    "originCountryDisplay"
})
public class JExRUAdditionalInfo
    extends TransactionLineInterfaceGdf
{

    @XmlElementRef(name = "CorrectedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedInvoice;
    @XmlElementRef(name = "CorrectedLine", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedLine;
    @XmlElementRef(name = "CustomsDeclarationNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customsDeclarationNumber;
    @XmlElementRef(name = "OriginCountry", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originCountry;
    @XmlElementRef(name = "OriginCountry_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originCountryDisplay;

    /**
     * Gets the value of the correctedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCorrectedInvoice() {
        return correctedInvoice;
    }

    /**
     * Sets the value of the correctedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCorrectedInvoice(JAXBElement<BigDecimal> value) {
        this.correctedInvoice = value;
    }

    /**
     * Gets the value of the correctedLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCorrectedLine() {
        return correctedLine;
    }

    /**
     * Sets the value of the correctedLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCorrectedLine(JAXBElement<BigDecimal> value) {
        this.correctedLine = value;
    }

    /**
     * Gets the value of the customsDeclarationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomsDeclarationNumber() {
        return customsDeclarationNumber;
    }

    /**
     * Sets the value of the customsDeclarationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomsDeclarationNumber(JAXBElement<String> value) {
        this.customsDeclarationNumber = value;
    }

    /**
     * Gets the value of the originCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginCountry() {
        return originCountry;
    }

    /**
     * Sets the value of the originCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginCountry(JAXBElement<String> value) {
        this.originCountry = value;
    }

    /**
     * Gets the value of the originCountryDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginCountryDisplay() {
        return originCountryDisplay;
    }

    /**
     * Sets the value of the originCountryDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginCountryDisplay(JAXBElement<String> value) {
        this.originCountryDisplay = value;
    }

}
