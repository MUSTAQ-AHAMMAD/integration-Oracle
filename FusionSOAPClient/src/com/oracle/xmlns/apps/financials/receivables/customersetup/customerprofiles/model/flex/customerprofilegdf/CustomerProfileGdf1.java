
package com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofilegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerProfileGdfJE_5FDE_5FZ4_5FREPORTING complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerProfileGdfJE_5FDE_5FZ4_5FREPORTING">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/}CustomerProfileGdf">
 *       &lt;sequence>
 *         &lt;element name="_Record__Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Record__Type_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reason_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerProfileGdfJE_5FDE_5FZ4_5FREPORTING", propOrder = {
    "recordType",
    "recordTypeDisplay",
    "reason",
    "reasonDisplay"
})
public class CustomerProfileGdf1
    extends CustomerProfileGdf
{

    @XmlElementRef(name = "_Record__Type", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recordType;
    @XmlElementRef(name = "_Record__Type_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recordTypeDisplay;
    @XmlElementRef(name = "_Reason", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reason;
    @XmlElementRef(name = "_Reason_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reasonDisplay;

    /**
     * Gets the value of the recordType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecordType() {
        return recordType;
    }

    /**
     * Sets the value of the recordType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecordType(JAXBElement<String> value) {
        this.recordType = value;
    }

    /**
     * Gets the value of the recordTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecordTypeDisplay() {
        return recordTypeDisplay;
    }

    /**
     * Sets the value of the recordTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecordTypeDisplay(JAXBElement<String> value) {
        this.recordTypeDisplay = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReason(JAXBElement<String> value) {
        this.reason = value;
    }

    /**
     * Gets the value of the reasonDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReasonDisplay() {
        return reasonDisplay;
    }

    /**
     * Sets the value of the reasonDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReasonDisplay(JAXBElement<String> value) {
        this.reasonDisplay = value;
    }

}
