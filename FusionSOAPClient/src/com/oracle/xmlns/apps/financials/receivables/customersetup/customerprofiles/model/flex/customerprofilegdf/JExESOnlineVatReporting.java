
package com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofilegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JExESOnlineVatReporting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExESOnlineVatReporting">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/}CustomerProfileGdf">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Code_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptReportedStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptReportedStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialRegime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialRegime_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExcludeFromOnlineVATReporting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExcludeFromOnlineVATReporting_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExESOnlineVatReporting", propOrder = {
    "code",
    "codeDisplay",
    "receiptReportedStatus",
    "receiptReportedStatusDisplay",
    "taxAuthorityStatus",
    "taxAuthorityStatusDisplay",
    "messageCode",
    "messageDescription",
    "specialRegime",
    "specialRegimeDisplay",
    "excludeFromOnlineVATReporting",
    "excludeFromOnlineVATReportingDisplay"
})
public class JExESOnlineVatReporting
    extends CustomerProfileGdf
{

    @XmlElementRef(name = "Code", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> code;
    @XmlElementRef(name = "Code_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codeDisplay;
    @XmlElementRef(name = "ReceiptReportedStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptReportedStatus;
    @XmlElementRef(name = "ReceiptReportedStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptReportedStatusDisplay;
    @XmlElementRef(name = "TaxAuthorityStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatus;
    @XmlElementRef(name = "TaxAuthorityStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatusDisplay;
    @XmlElementRef(name = "MessageCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageCode;
    @XmlElementRef(name = "MessageDescription", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageDescription;
    @XmlElementRef(name = "SpecialRegime", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specialRegime;
    @XmlElementRef(name = "SpecialRegime_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specialRegimeDisplay;
    @XmlElementRef(name = "ExcludeFromOnlineVATReporting", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> excludeFromOnlineVATReporting;
    @XmlElementRef(name = "ExcludeFromOnlineVATReporting_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> excludeFromOnlineVATReportingDisplay;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCode(JAXBElement<String> value) {
        this.code = value;
    }

    /**
     * Gets the value of the codeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodeDisplay() {
        return codeDisplay;
    }

    /**
     * Sets the value of the codeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodeDisplay(JAXBElement<String> value) {
        this.codeDisplay = value;
    }

    /**
     * Gets the value of the receiptReportedStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptReportedStatus() {
        return receiptReportedStatus;
    }

    /**
     * Sets the value of the receiptReportedStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptReportedStatus(JAXBElement<String> value) {
        this.receiptReportedStatus = value;
    }

    /**
     * Gets the value of the receiptReportedStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptReportedStatusDisplay() {
        return receiptReportedStatusDisplay;
    }

    /**
     * Sets the value of the receiptReportedStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptReportedStatusDisplay(JAXBElement<String> value) {
        this.receiptReportedStatusDisplay = value;
    }

    /**
     * Gets the value of the taxAuthorityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxAuthorityStatus() {
        return taxAuthorityStatus;
    }

    /**
     * Sets the value of the taxAuthorityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxAuthorityStatus(JAXBElement<String> value) {
        this.taxAuthorityStatus = value;
    }

    /**
     * Gets the value of the taxAuthorityStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxAuthorityStatusDisplay() {
        return taxAuthorityStatusDisplay;
    }

    /**
     * Sets the value of the taxAuthorityStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxAuthorityStatusDisplay(JAXBElement<String> value) {
        this.taxAuthorityStatusDisplay = value;
    }

    /**
     * Gets the value of the messageCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageCode() {
        return messageCode;
    }

    /**
     * Sets the value of the messageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageCode(JAXBElement<String> value) {
        this.messageCode = value;
    }

    /**
     * Gets the value of the messageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageDescription() {
        return messageDescription;
    }

    /**
     * Sets the value of the messageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageDescription(JAXBElement<String> value) {
        this.messageDescription = value;
    }

    /**
     * Gets the value of the specialRegime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecialRegime() {
        return specialRegime;
    }

    /**
     * Sets the value of the specialRegime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecialRegime(JAXBElement<String> value) {
        this.specialRegime = value;
    }

    /**
     * Gets the value of the specialRegimeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecialRegimeDisplay() {
        return specialRegimeDisplay;
    }

    /**
     * Sets the value of the specialRegimeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecialRegimeDisplay(JAXBElement<String> value) {
        this.specialRegimeDisplay = value;
    }

    /**
     * Gets the value of the excludeFromOnlineVATReporting property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExcludeFromOnlineVATReporting() {
        return excludeFromOnlineVATReporting;
    }

    /**
     * Sets the value of the excludeFromOnlineVATReporting property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExcludeFromOnlineVATReporting(JAXBElement<String> value) {
        this.excludeFromOnlineVATReporting = value;
    }

    /**
     * Gets the value of the excludeFromOnlineVATReportingDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExcludeFromOnlineVATReportingDisplay() {
        return excludeFromOnlineVATReportingDisplay;
    }

    /**
     * Sets the value of the excludeFromOnlineVATReportingDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExcludeFromOnlineVATReportingDisplay(JAXBElement<String> value) {
        this.excludeFromOnlineVATReportingDisplay = value;
    }

}
