
package com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofilegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JExTRAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExTRAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/}CustomerProfileGdf">
 *       &lt;sequence>
 *         &lt;element name="BaBsTerritoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaBsTerritoryCode_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDifferenceCreation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDifferenceCreation_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDifferenceOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateDifferenceOption_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "baBsTerritoryCode",
    "baBsTerritoryCodeDisplay",
    "exchangeRateDifferenceCreation",
    "exchangeRateDifferenceCreationDisplay",
    "exchangeRateDifferenceOption",
    "exchangeRateDifferenceOptionDisplay"
})
public class JExTRAdditionalInfo
    extends CustomerProfileGdf
{

    @XmlElementRef(name = "BaBsTerritoryCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baBsTerritoryCode;
    @XmlElementRef(name = "BaBsTerritoryCode_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baBsTerritoryCodeDisplay;
    @XmlElementRef(name = "ExchangeRateDifferenceCreation", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDifferenceCreation;
    @XmlElementRef(name = "ExchangeRateDifferenceCreation_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDifferenceCreationDisplay;
    @XmlElementRef(name = "ExchangeRateDifferenceOption", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDifferenceOption;
    @XmlElementRef(name = "ExchangeRateDifferenceOption_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateDifferenceOptionDisplay;

    /**
     * Gets the value of the baBsTerritoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaBsTerritoryCode() {
        return baBsTerritoryCode;
    }

    /**
     * Sets the value of the baBsTerritoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaBsTerritoryCode(JAXBElement<String> value) {
        this.baBsTerritoryCode = value;
    }

    /**
     * Gets the value of the baBsTerritoryCodeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaBsTerritoryCodeDisplay() {
        return baBsTerritoryCodeDisplay;
    }

    /**
     * Sets the value of the baBsTerritoryCodeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaBsTerritoryCodeDisplay(JAXBElement<String> value) {
        this.baBsTerritoryCodeDisplay = value;
    }

    /**
     * Gets the value of the exchangeRateDifferenceCreation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDifferenceCreation() {
        return exchangeRateDifferenceCreation;
    }

    /**
     * Sets the value of the exchangeRateDifferenceCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDifferenceCreation(JAXBElement<String> value) {
        this.exchangeRateDifferenceCreation = value;
    }

    /**
     * Gets the value of the exchangeRateDifferenceCreationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDifferenceCreationDisplay() {
        return exchangeRateDifferenceCreationDisplay;
    }

    /**
     * Sets the value of the exchangeRateDifferenceCreationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDifferenceCreationDisplay(JAXBElement<String> value) {
        this.exchangeRateDifferenceCreationDisplay = value;
    }

    /**
     * Gets the value of the exchangeRateDifferenceOption property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDifferenceOption() {
        return exchangeRateDifferenceOption;
    }

    /**
     * Sets the value of the exchangeRateDifferenceOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDifferenceOption(JAXBElement<String> value) {
        this.exchangeRateDifferenceOption = value;
    }

    /**
     * Gets the value of the exchangeRateDifferenceOptionDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateDifferenceOptionDisplay() {
        return exchangeRateDifferenceOptionDisplay;
    }

    /**
     * Sets the value of the exchangeRateDifferenceOptionDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateDifferenceOptionDisplay(JAXBElement<String> value) {
        this.exchangeRateDifferenceOptionDisplay = value;
    }

}
