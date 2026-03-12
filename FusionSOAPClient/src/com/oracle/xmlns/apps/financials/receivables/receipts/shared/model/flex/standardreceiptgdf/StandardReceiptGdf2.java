
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.standardreceiptgdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for StandardReceiptGdfJE_5FPT_5FRECEIPTS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardReceiptGdfJE_5FPT_5FRECEIPTS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/}StandardReceiptGdf">
 *       &lt;sequence>
 *         &lt;element name="_Receipt__Acknowledgment__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Receipt__Acknowledgment__Date" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="_Document__Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentType_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceBilling" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceBilling_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardReceiptGdfJE_5FPT_5FRECEIPTS", propOrder = {
    "receiptAcknowledgmentNumber",
    "receiptAcknowledgmentDate",
    "documentCategory",
    "paymentType",
    "paymentTypeDisplay",
    "sourceBilling",
    "sourceBillingDisplay"
})
public class StandardReceiptGdf2
    extends StandardReceiptGdf
{

    @XmlElementRef(name = "_Receipt__Acknowledgment__Number", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptAcknowledgmentNumber;
    @XmlElementRef(name = "_Receipt__Acknowledgment__Date", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> receiptAcknowledgmentDate;
    @XmlElementRef(name = "_Document__Category", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentCategory;
    @XmlElementRef(name = "PaymentType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentType;
    @XmlElementRef(name = "PaymentType_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentTypeDisplay;
    @XmlElementRef(name = "SourceBilling", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceBilling;
    @XmlElementRef(name = "SourceBilling_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceBillingDisplay;

    /**
     * Gets the value of the receiptAcknowledgmentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptAcknowledgmentNumber() {
        return receiptAcknowledgmentNumber;
    }

    /**
     * Sets the value of the receiptAcknowledgmentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptAcknowledgmentNumber(JAXBElement<String> value) {
        this.receiptAcknowledgmentNumber = value;
    }

    /**
     * Gets the value of the receiptAcknowledgmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getReceiptAcknowledgmentDate() {
        return receiptAcknowledgmentDate;
    }

    /**
     * Sets the value of the receiptAcknowledgmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setReceiptAcknowledgmentDate(JAXBElement<XMLGregorianCalendar> value) {
        this.receiptAcknowledgmentDate = value;
    }

    /**
     * Gets the value of the documentCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentCategory() {
        return documentCategory;
    }

    /**
     * Sets the value of the documentCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentCategory(JAXBElement<String> value) {
        this.documentCategory = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentType(JAXBElement<String> value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the paymentTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentTypeDisplay() {
        return paymentTypeDisplay;
    }

    /**
     * Sets the value of the paymentTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTypeDisplay(JAXBElement<String> value) {
        this.paymentTypeDisplay = value;
    }

    /**
     * Gets the value of the sourceBilling property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceBilling() {
        return sourceBilling;
    }

    /**
     * Sets the value of the sourceBilling property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceBilling(JAXBElement<String> value) {
        this.sourceBilling = value;
    }

    /**
     * Gets the value of the sourceBillingDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceBillingDisplay() {
        return sourceBillingDisplay;
    }

    /**
     * Sets the value of the sourceBillingDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceBillingDisplay(JAXBElement<String> value) {
        this.sourceBillingDisplay = value;
    }

}
