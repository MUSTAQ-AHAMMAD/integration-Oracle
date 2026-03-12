
package com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactioninterfacegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceGdfJE_5FIT_5FESL_5FOF_5FSERVICES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceGdfJE_5FIT_5FESL_5FOF_5FSERVICES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/}TransactionInterfaceGdf">
 *       &lt;sequence>
 *         &lt;element name="_Service__Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Service__Code_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Service__Mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Service__Mode_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reporting__Payment__Method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reporting__Payment__Method_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reporting__Payment__Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Reporting__Payment__Country_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportingExclusionIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportingExclusionIndicator_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatNotExposed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatNotExposed_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDeclarationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceGdfJE_5FIT_5FESL_5FOF_5FSERVICES", propOrder = {
    "serviceCode",
    "serviceCodeDisplay",
    "serviceMode",
    "serviceModeDisplay",
    "reportingPaymentMethod",
    "reportingPaymentMethodDisplay",
    "reportingPaymentCountry",
    "reportingPaymentCountryDisplay",
    "reportingExclusionIndicator",
    "reportingExclusionIndicatorDisplay",
    "vatNotExposed",
    "vatNotExposedDisplay",
    "eDeclarationId",
    "errorCode"
})
public class TransactionInterfaceGdf9
    extends TransactionInterfaceGdf
{

    @XmlElementRef(name = "_Service__Code", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceCode;
    @XmlElementRef(name = "_Service__Code_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceCodeDisplay;
    @XmlElementRef(name = "_Service__Mode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceMode;
    @XmlElementRef(name = "_Service__Mode_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceModeDisplay;
    @XmlElementRef(name = "_Reporting__Payment__Method", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingPaymentMethod;
    @XmlElementRef(name = "_Reporting__Payment__Method_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingPaymentMethodDisplay;
    @XmlElementRef(name = "_Reporting__Payment__Country", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingPaymentCountry;
    @XmlElementRef(name = "_Reporting__Payment__Country_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingPaymentCountryDisplay;
    @XmlElementRef(name = "reportingExclusionIndicator", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingExclusionIndicator;
    @XmlElementRef(name = "reportingExclusionIndicator_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingExclusionIndicatorDisplay;
    @XmlElementRef(name = "vatNotExposed", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vatNotExposed;
    @XmlElementRef(name = "vatNotExposed_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vatNotExposedDisplay;
    @XmlElementRef(name = "EDeclarationId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eDeclarationId;
    @XmlElementRef(name = "ErrorCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorCode;

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
     * Gets the value of the reportingPaymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingPaymentMethod() {
        return reportingPaymentMethod;
    }

    /**
     * Sets the value of the reportingPaymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingPaymentMethod(JAXBElement<String> value) {
        this.reportingPaymentMethod = value;
    }

    /**
     * Gets the value of the reportingPaymentMethodDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingPaymentMethodDisplay() {
        return reportingPaymentMethodDisplay;
    }

    /**
     * Sets the value of the reportingPaymentMethodDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingPaymentMethodDisplay(JAXBElement<String> value) {
        this.reportingPaymentMethodDisplay = value;
    }

    /**
     * Gets the value of the reportingPaymentCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingPaymentCountry() {
        return reportingPaymentCountry;
    }

    /**
     * Sets the value of the reportingPaymentCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingPaymentCountry(JAXBElement<String> value) {
        this.reportingPaymentCountry = value;
    }

    /**
     * Gets the value of the reportingPaymentCountryDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingPaymentCountryDisplay() {
        return reportingPaymentCountryDisplay;
    }

    /**
     * Sets the value of the reportingPaymentCountryDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingPaymentCountryDisplay(JAXBElement<String> value) {
        this.reportingPaymentCountryDisplay = value;
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

    /**
     * Gets the value of the vatNotExposed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVatNotExposed() {
        return vatNotExposed;
    }

    /**
     * Sets the value of the vatNotExposed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVatNotExposed(JAXBElement<String> value) {
        this.vatNotExposed = value;
    }

    /**
     * Gets the value of the vatNotExposedDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVatNotExposedDisplay() {
        return vatNotExposedDisplay;
    }

    /**
     * Sets the value of the vatNotExposedDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVatNotExposedDisplay(JAXBElement<String> value) {
        this.vatNotExposedDisplay = value;
    }

    /**
     * Gets the value of the eDeclarationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEDeclarationId() {
        return eDeclarationId;
    }

    /**
     * Sets the value of the eDeclarationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEDeclarationId(JAXBElement<String> value) {
        this.eDeclarationId = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<String> value) {
        this.errorCode = value;
    }

}
