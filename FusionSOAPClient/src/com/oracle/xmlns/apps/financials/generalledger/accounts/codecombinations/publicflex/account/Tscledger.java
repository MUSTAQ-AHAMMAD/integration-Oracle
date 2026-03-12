
package com.oracle.xmlns.apps.financials.generalledger.accounts.codecombinations.publicflex.account;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tscledger complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tscledger"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/}Account"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="legalEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="business" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="costCenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intercompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="future1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="future2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tscledger", propOrder = {
         "legalEntity", "account", "business", "costCenter", "productLine", "location", "customerGroup", "intercompany",
         "future1", "future2"
    })
public class Tscledger extends Account {

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
    @XmlElementRef(name = "costCenter",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> costCenter;
    @XmlElementRef(name = "productLine",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> productLine;
    @XmlElementRef(name = "location",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> location;
    @XmlElementRef(name = "customerGroup",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerGroup;
    @XmlElementRef(name = "intercompany",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> intercompany;
    @XmlElementRef(name = "future1",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> future1;
    @XmlElementRef(name = "future2",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> future2;

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
     * Gets the value of the productLine property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getProductLine() {
        return productLine;
    }

    /**
     * Sets the value of the productLine property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setProductLine(JAXBElement<String> value) {
        this.productLine = value;
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
     * Gets the value of the customerGroup property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getCustomerGroup() {
        return customerGroup;
    }

    /**
     * Sets the value of the customerGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setCustomerGroup(JAXBElement<String> value) {
        this.customerGroup = value;
    }

    /**
     * Gets the value of the intercompany property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getIntercompany() {
        return intercompany;
    }

    /**
     * Sets the value of the intercompany property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setIntercompany(JAXBElement<String> value) {
        this.intercompany = value;
    }

    /**
     * Gets the value of the future1 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getFuture1() {
        return future1;
    }

    /**
     * Sets the value of the future1 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setFuture1(JAXBElement<String> value) {
        this.future1 = value;
    }

    /**
     * Gets the value of the future2 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getFuture2() {
        return future2;
    }

    /**
     * Sets the value of the future2 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setFuture2(JAXBElement<String> value) {
        this.future2 = value;
    }

}
