
package com.oracle.xmlns.apps.financials.generalledger.accounts.codecombinations.publicflex.account;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tamledger complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tamledger"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/}Account"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="legalEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="business" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="costCenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="future" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tamledger", propOrder = { "legalEntity", "account", "business", "location", "costCenter", "future" })
public class Tamledger extends Account {

    @XmlElementRef(name = "legalEntity",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> legalEntity;
    @XmlElementRef(name = "account",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> account;
    @XmlElementRef(name = "business",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> business;
    @XmlElementRef(name = "location",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> location;
    @XmlElementRef(name = "costCenter",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> costCenter;
    @XmlElementRef(name = "future",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> future;

    /**
     * Gets the value of the legalEntity property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getLegalEntity() {
        return legalEntity;
    }

    /**
     * Sets the value of the legalEntity property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setLegalEntity(JAXBElement<String> value) {
        this.legalEntity = value;
    }

    /**
     * Gets the value of the account property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAccount(JAXBElement<String> value) {
        this.account = value;
    }

    /**
     * Gets the value of the business property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setBusiness(JAXBElement<String> value) {
        this.business = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setLocation(JAXBElement<String> value) {
        this.location = value;
    }

    /**
     * Gets the value of the costCenter property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getCostCenter() {
        return costCenter;
    }

    /**
     * Sets the value of the costCenter property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setCostCenter(JAXBElement<String> value) {
        this.costCenter = value;
    }

    /**
     * Gets the value of the future property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getFuture() {
        return future;
    }

    /**
     * Sets the value of the future property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setFuture(JAXBElement<String> value) {
        this.future = value;
    }

}
