
package com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationgdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExESOnlineVatReporting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExESOnlineVatReporting">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/}ReceivableApplicationGdf">
 *       &lt;sequence>
 *         &lt;element name="TransactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAuthorityStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegisterType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegisterType_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateLastUpdated" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
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
    "transactionStatus",
    "transactionStatusDisplay",
    "taxAuthorityStatus",
    "taxAuthorityStatusDisplay",
    "registerType",
    "registerTypeDisplay",
    "messageCode",
    "messageDescription",
    "dateLastUpdated"
})
public class JExESOnlineVatReporting
    extends ReceivableApplicationGdf
{

    @XmlElementRef(name = "TransactionStatus", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatus;
    @XmlElementRef(name = "TransactionStatus_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatusDisplay;
    @XmlElementRef(name = "TaxAuthorityStatus", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatus;
    @XmlElementRef(name = "TaxAuthorityStatus_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxAuthorityStatusDisplay;
    @XmlElementRef(name = "RegisterType", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> registerType;
    @XmlElementRef(name = "RegisterType_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> registerTypeDisplay;
    @XmlElementRef(name = "MessageCode", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageCode;
    @XmlElementRef(name = "MessageDescription", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageDescription;
    @XmlElementRef(name = "DateLastUpdated", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateLastUpdated;

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionStatus(JAXBElement<String> value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the transactionStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionStatusDisplay() {
        return transactionStatusDisplay;
    }

    /**
     * Sets the value of the transactionStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionStatusDisplay(JAXBElement<String> value) {
        this.transactionStatusDisplay = value;
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
     * Gets the value of the registerType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegisterType() {
        return registerType;
    }

    /**
     * Sets the value of the registerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegisterType(JAXBElement<String> value) {
        this.registerType = value;
    }

    /**
     * Gets the value of the registerTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegisterTypeDisplay() {
        return registerTypeDisplay;
    }

    /**
     * Sets the value of the registerTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegisterTypeDisplay(JAXBElement<String> value) {
        this.registerTypeDisplay = value;
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
     * Gets the value of the dateLastUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateLastUpdated() {
        return dateLastUpdated;
    }

    /**
     * Sets the value of the dateLastUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateLastUpdated(JAXBElement<XMLGregorianCalendar> value) {
        this.dateLastUpdated = value;
    }

}
