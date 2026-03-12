
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionLineGdfJE_5FIT_5FESL_5FOF_5FSERVICES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionLineGdfJE_5FIT_5FESL_5FOF_5FSERVICES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/}TransactionLineGdf">
 *       &lt;sequence>
 *         &lt;element name="_Service__Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Service__Code_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Service__Mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Service__Mode_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportingExclusionIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportingExclusionIndicator_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionLineGdfJE_5FIT_5FESL_5FOF_5FSERVICES", propOrder = {
    "serviceCode",
    "serviceCodeDisplay",
    "serviceMode",
    "serviceModeDisplay",
    "reportingExclusionIndicator",
    "reportingExclusionIndicatorDisplay"
})
public class TransactionLineGdf1
    extends TransactionLineGdf
{

    @XmlElementRef(name = "_Service__Code", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceCode;
    @XmlElementRef(name = "_Service__Code_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceCodeDisplay;
    @XmlElementRef(name = "_Service__Mode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceMode;
    @XmlElementRef(name = "_Service__Mode_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceModeDisplay;
    @XmlElementRef(name = "reportingExclusionIndicator", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingExclusionIndicator;
    @XmlElementRef(name = "reportingExclusionIndicator_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingExclusionIndicatorDisplay;

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceCode(JAXBElement<String> value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the serviceCodeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceCodeDisplay() {
        return serviceCodeDisplay;
    }

    /**
     * Sets the value of the serviceCodeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceCodeDisplay(JAXBElement<String> value) {
        this.serviceCodeDisplay = value;
    }

    /**
     * Gets the value of the serviceMode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceMode() {
        return serviceMode;
    }

    /**
     * Sets the value of the serviceMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceMode(JAXBElement<String> value) {
        this.serviceMode = value;
    }

    /**
     * Gets the value of the serviceModeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceModeDisplay() {
        return serviceModeDisplay;
    }

    /**
     * Sets the value of the serviceModeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceModeDisplay(JAXBElement<String> value) {
        this.serviceModeDisplay = value;
    }

    /**
     * Gets the value of the reportingExclusionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingExclusionIndicator() {
        return reportingExclusionIndicator;
    }

    /**
     * Sets the value of the reportingExclusionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingExclusionIndicator(JAXBElement<String> value) {
        this.reportingExclusionIndicator = value;
    }

    /**
     * Gets the value of the reportingExclusionIndicatorDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingExclusionIndicatorDisplay() {
        return reportingExclusionIndicatorDisplay;
    }

    /**
     * Sets the value of the reportingExclusionIndicatorDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingExclusionIndicatorDisplay(JAXBElement<String> value) {
        this.reportingExclusionIndicatorDisplay = value;
    }

}
