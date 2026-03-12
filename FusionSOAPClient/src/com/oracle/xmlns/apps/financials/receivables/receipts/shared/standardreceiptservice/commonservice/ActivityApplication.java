
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationdff.ReceivableApplicationFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationgdf.ReceivableApplicationGdf;


/**
 * <p>Java class for ActivityApplication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityApplication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusinessUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceivableTrxName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmountApplied" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ApplyDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ApplyGlDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="AppliedPaymentScheduleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LinkToCustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReceivablesTrxId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="USSGLTransactionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentSetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CustomerReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValWriteoffLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NettedReceipt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NettedCashReceiptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SecondaryApplicationReferenceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryApplicationReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayGroupLookupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAlone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentReasonComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryChannelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RemitMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RemittanceMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RemitingMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PartySiteId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BankAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReceivableApplicationFLEXVA" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/}ReceivableApplicationFLEX" minOccurs="0"/>
 *         &lt;element name="ActivityApplicationGdfVA" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/}ReceivableApplicationGdf" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityApplication", propOrder = {
    "businessUnit",
    "receiptNumber",
    "receivableTrxName",
    "amountApplied",
    "applyDate",
    "applyGlDate",
    "appliedPaymentScheduleId",
    "linkToCustomerTrxId",
    "receivablesTrxId",
    "ussglTransactionCode",
    "comments",
    "paymentSetId",
    "customerReference",
    "valWriteoffLimits",
    "nettedReceipt",
    "nettedCashReceiptId",
    "secondaryApplicationReferenceType",
    "secondaryApplicationReferenceNumber",
    "customerReason",
    "payGroupLookupCode",
    "payAlone",
    "paymentMethodCode",
    "paymentReasonCode",
    "paymentReasonComments",
    "deliveryChannelCode",
    "remitMessage",
    "remittanceMessage",
    "remitingMessage",
    "partyId",
    "partySiteId",
    "bankAccountId",
    "receivableApplicationFLEXVA",
    "activityApplicationGdfVA"
})
public class ActivityApplication {

    @XmlElementRef(name = "BusinessUnit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessUnit;
    @XmlElementRef(name = "ReceiptNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptNumber;
    @XmlElementRef(name = "ReceivableTrxName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receivableTrxName;
    @XmlElementRef(name = "AmountApplied", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> amountApplied;
    @XmlElementRef(name = "ApplyDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> applyDate;
    @XmlElementRef(name = "ApplyGlDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> applyGlDate;
    @XmlElementRef(name = "AppliedPaymentScheduleId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> appliedPaymentScheduleId;
    @XmlElementRef(name = "LinkToCustomerTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> linkToCustomerTrxId;
    @XmlElementRef(name = "ReceivablesTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> receivablesTrxId;
    @XmlElementRef(name = "USSGLTransactionCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ussglTransactionCode;
    @XmlElementRef(name = "Comments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "PaymentSetId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> paymentSetId;
    @XmlElementRef(name = "CustomerReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerReference;
    @XmlElementRef(name = "ValWriteoffLimits", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> valWriteoffLimits;
    @XmlElementRef(name = "NettedReceipt", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nettedReceipt;
    @XmlElementRef(name = "NettedCashReceiptId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> nettedCashReceiptId;
    @XmlElementRef(name = "SecondaryApplicationReferenceType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryApplicationReferenceType;
    @XmlElementRef(name = "SecondaryApplicationReferenceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryApplicationReferenceNumber;
    @XmlElementRef(name = "CustomerReason", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerReason;
    @XmlElementRef(name = "PayGroupLookupCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> payGroupLookupCode;
    @XmlElementRef(name = "PayAlone", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> payAlone;
    @XmlElementRef(name = "PaymentMethodCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentMethodCode;
    @XmlElementRef(name = "PaymentReasonCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentReasonCode;
    @XmlElementRef(name = "PaymentReasonComments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentReasonComments;
    @XmlElementRef(name = "DeliveryChannelCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deliveryChannelCode;
    @XmlElementRef(name = "RemitMessage", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remitMessage;
    @XmlElementRef(name = "RemittanceMessage", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remittanceMessage;
    @XmlElementRef(name = "RemitingMessage", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remitingMessage;
    @XmlElementRef(name = "PartyId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> partyId;
    @XmlElementRef(name = "PartySiteId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> partySiteId;
    @XmlElementRef(name = "BankAccountId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> bankAccountId;
    @XmlElement(name = "ReceivableApplicationFLEXVA")
    protected ReceivableApplicationFLEX receivableApplicationFLEXVA;
    @XmlElement(name = "ActivityApplicationGdfVA")
    protected ReceivableApplicationGdf activityApplicationGdfVA;

    /**
     * Gets the value of the businessUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Sets the value of the businessUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessUnit(JAXBElement<String> value) {
        this.businessUnit = value;
    }

    /**
     * Gets the value of the receiptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * Sets the value of the receiptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptNumber(JAXBElement<String> value) {
        this.receiptNumber = value;
    }

    /**
     * Gets the value of the receivableTrxName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceivableTrxName() {
        return receivableTrxName;
    }

    /**
     * Sets the value of the receivableTrxName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceivableTrxName(JAXBElement<String> value) {
        this.receivableTrxName = value;
    }

    /**
     * Gets the value of the amountApplied property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAmountApplied() {
        return amountApplied;
    }

    /**
     * Sets the value of the amountApplied property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAmountApplied(JAXBElement<BigDecimal> value) {
        this.amountApplied = value;
    }

    /**
     * Gets the value of the applyDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getApplyDate() {
        return applyDate;
    }

    /**
     * Sets the value of the applyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setApplyDate(JAXBElement<XMLGregorianCalendar> value) {
        this.applyDate = value;
    }

    /**
     * Gets the value of the applyGlDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getApplyGlDate() {
        return applyGlDate;
    }

    /**
     * Sets the value of the applyGlDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setApplyGlDate(JAXBElement<XMLGregorianCalendar> value) {
        this.applyGlDate = value;
    }

    /**
     * Gets the value of the appliedPaymentScheduleId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAppliedPaymentScheduleId() {
        return appliedPaymentScheduleId;
    }

    /**
     * Sets the value of the appliedPaymentScheduleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAppliedPaymentScheduleId(JAXBElement<Long> value) {
        this.appliedPaymentScheduleId = value;
    }

    /**
     * Gets the value of the linkToCustomerTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getLinkToCustomerTrxId() {
        return linkToCustomerTrxId;
    }

    /**
     * Sets the value of the linkToCustomerTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setLinkToCustomerTrxId(JAXBElement<Long> value) {
        this.linkToCustomerTrxId = value;
    }

    /**
     * Gets the value of the receivablesTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getReceivablesTrxId() {
        return receivablesTrxId;
    }

    /**
     * Sets the value of the receivablesTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setReceivablesTrxId(JAXBElement<Long> value) {
        this.receivablesTrxId = value;
    }

    /**
     * Gets the value of the ussglTransactionCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUSSGLTransactionCode() {
        return ussglTransactionCode;
    }

    /**
     * Sets the value of the ussglTransactionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUSSGLTransactionCode(JAXBElement<String> value) {
        this.ussglTransactionCode = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComments(JAXBElement<String> value) {
        this.comments = value;
    }

    /**
     * Gets the value of the paymentSetId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPaymentSetId() {
        return paymentSetId;
    }

    /**
     * Sets the value of the paymentSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPaymentSetId(JAXBElement<Long> value) {
        this.paymentSetId = value;
    }

    /**
     * Gets the value of the customerReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerReference() {
        return customerReference;
    }

    /**
     * Sets the value of the customerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerReference(JAXBElement<String> value) {
        this.customerReference = value;
    }

    /**
     * Gets the value of the valWriteoffLimits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getValWriteoffLimits() {
        return valWriteoffLimits;
    }

    /**
     * Sets the value of the valWriteoffLimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setValWriteoffLimits(JAXBElement<String> value) {
        this.valWriteoffLimits = value;
    }

    /**
     * Gets the value of the nettedReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNettedReceipt() {
        return nettedReceipt;
    }

    /**
     * Sets the value of the nettedReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNettedReceipt(JAXBElement<String> value) {
        this.nettedReceipt = value;
    }

    /**
     * Gets the value of the nettedCashReceiptId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getNettedCashReceiptId() {
        return nettedCashReceiptId;
    }

    /**
     * Sets the value of the nettedCashReceiptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setNettedCashReceiptId(JAXBElement<Long> value) {
        this.nettedCashReceiptId = value;
    }

    /**
     * Gets the value of the secondaryApplicationReferenceType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecondaryApplicationReferenceType() {
        return secondaryApplicationReferenceType;
    }

    /**
     * Sets the value of the secondaryApplicationReferenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecondaryApplicationReferenceType(JAXBElement<String> value) {
        this.secondaryApplicationReferenceType = value;
    }

    /**
     * Gets the value of the secondaryApplicationReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecondaryApplicationReferenceNumber() {
        return secondaryApplicationReferenceNumber;
    }

    /**
     * Sets the value of the secondaryApplicationReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecondaryApplicationReferenceNumber(JAXBElement<String> value) {
        this.secondaryApplicationReferenceNumber = value;
    }

    /**
     * Gets the value of the customerReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerReason() {
        return customerReason;
    }

    /**
     * Sets the value of the customerReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerReason(JAXBElement<String> value) {
        this.customerReason = value;
    }

    /**
     * Gets the value of the payGroupLookupCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayGroupLookupCode() {
        return payGroupLookupCode;
    }

    /**
     * Sets the value of the payGroupLookupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayGroupLookupCode(JAXBElement<String> value) {
        this.payGroupLookupCode = value;
    }

    /**
     * Gets the value of the payAlone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayAlone() {
        return payAlone;
    }

    /**
     * Sets the value of the payAlone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayAlone(JAXBElement<String> value) {
        this.payAlone = value;
    }

    /**
     * Gets the value of the paymentMethodCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentMethodCode() {
        return paymentMethodCode;
    }

    /**
     * Sets the value of the paymentMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentMethodCode(JAXBElement<String> value) {
        this.paymentMethodCode = value;
    }

    /**
     * Gets the value of the paymentReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentReasonCode() {
        return paymentReasonCode;
    }

    /**
     * Sets the value of the paymentReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentReasonCode(JAXBElement<String> value) {
        this.paymentReasonCode = value;
    }

    /**
     * Gets the value of the paymentReasonComments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentReasonComments() {
        return paymentReasonComments;
    }

    /**
     * Sets the value of the paymentReasonComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentReasonComments(JAXBElement<String> value) {
        this.paymentReasonComments = value;
    }

    /**
     * Gets the value of the deliveryChannelCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeliveryChannelCode() {
        return deliveryChannelCode;
    }

    /**
     * Sets the value of the deliveryChannelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeliveryChannelCode(JAXBElement<String> value) {
        this.deliveryChannelCode = value;
    }

    /**
     * Gets the value of the remitMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemitMessage() {
        return remitMessage;
    }

    /**
     * Sets the value of the remitMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemitMessage(JAXBElement<String> value) {
        this.remitMessage = value;
    }

    /**
     * Gets the value of the remittanceMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemittanceMessage() {
        return remittanceMessage;
    }

    /**
     * Sets the value of the remittanceMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemittanceMessage(JAXBElement<String> value) {
        this.remittanceMessage = value;
    }

    /**
     * Gets the value of the remitingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemitingMessage() {
        return remitingMessage;
    }

    /**
     * Sets the value of the remitingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemitingMessage(JAXBElement<String> value) {
        this.remitingMessage = value;
    }

    /**
     * Gets the value of the partyId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPartyId() {
        return partyId;
    }

    /**
     * Sets the value of the partyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPartyId(JAXBElement<Long> value) {
        this.partyId = value;
    }

    /**
     * Gets the value of the partySiteId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getPartySiteId() {
        return partySiteId;
    }

    /**
     * Sets the value of the partySiteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setPartySiteId(JAXBElement<Long> value) {
        this.partySiteId = value;
    }

    /**
     * Gets the value of the bankAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getBankAccountId() {
        return bankAccountId;
    }

    /**
     * Sets the value of the bankAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setBankAccountId(JAXBElement<Long> value) {
        this.bankAccountId = value;
    }

    /**
     * Gets the value of the receivableApplicationFLEXVA property.
     * 
     * @return
     *     possible object is
     *     {@link ReceivableApplicationFLEX }
     *     
     */
    public ReceivableApplicationFLEX getReceivableApplicationFLEXVA() {
        return receivableApplicationFLEXVA;
    }

    /**
     * Sets the value of the receivableApplicationFLEXVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivableApplicationFLEX }
     *     
     */
    public void setReceivableApplicationFLEXVA(ReceivableApplicationFLEX value) {
        this.receivableApplicationFLEXVA = value;
    }

    /**
     * Gets the value of the activityApplicationGdfVA property.
     * 
     * @return
     *     possible object is
     *     {@link ReceivableApplicationGdf }
     *     
     */
    public ReceivableApplicationGdf getActivityApplicationGdfVA() {
        return activityApplicationGdfVA;
    }

    /**
     * Sets the value of the activityApplicationGdfVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivableApplicationGdf }
     *     
     */
    public void setActivityApplicationGdfVA(ReceivableApplicationGdf value) {
        this.activityApplicationGdfVA = value;
    }

}
