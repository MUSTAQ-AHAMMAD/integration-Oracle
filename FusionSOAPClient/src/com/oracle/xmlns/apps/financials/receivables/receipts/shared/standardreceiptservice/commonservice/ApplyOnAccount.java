
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.applyonaccountdff.ReceivableApplicationFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.applyonaccountgdf.ReceivableApplicationGdf;


/**
 * <p>Java class for ApplyOnAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplyOnAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmountApplied" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ApplyDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ApplyGlDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="USSGLTransactionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicationReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryApplicationReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryApplicationReferenceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CustomerReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryApplicationReferenceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceivableApplicationFLEXVA" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ApplyOnAccountDff/}ReceivableApplicationFLEX" minOccurs="0"/>
 *         &lt;element name="ApplyOnAccountGdfVA" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ApplyOnAccountGdf/}ReceivableApplicationGdf" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplyOnAccount", propOrder = {
    "receiptNumber",
    "businessUnit",
    "amountApplied",
    "applyDate",
    "applyGlDate",
    "ussglTransactionCode",
    "comments",
    "applicationReferenceNumber",
    "secondaryApplicationReferenceNumber",
    "secondaryApplicationReferenceId",
    "customerReference",
    "customerReason",
    "secondaryApplicationReferenceType",
    "receivableApplicationFLEXVA",
    "applyOnAccountGdfVA"
})
public class ApplyOnAccount {

    @XmlElementRef(name = "ReceiptNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptNumber;
    @XmlElementRef(name = "BusinessUnit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessUnit;
    @XmlElement(name = "AmountApplied")
    protected BigDecimal amountApplied;
    @XmlElement(name = "ApplyDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar applyDate;
    @XmlElementRef(name = "ApplyGlDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> applyGlDate;
    @XmlElementRef(name = "USSGLTransactionCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ussglTransactionCode;
    @XmlElementRef(name = "Comments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "ApplicationReferenceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicationReferenceNumber;
    @XmlElementRef(name = "SecondaryApplicationReferenceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryApplicationReferenceNumber;
    @XmlElementRef(name = "SecondaryApplicationReferenceId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> secondaryApplicationReferenceId;
    @XmlElementRef(name = "CustomerReference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerReference;
    @XmlElementRef(name = "CustomerReason", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerReason;
    @XmlElementRef(name = "SecondaryApplicationReferenceType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryApplicationReferenceType;
    @XmlElement(name = "ReceivableApplicationFLEXVA")
    protected ReceivableApplicationFLEX receivableApplicationFLEXVA;
    @XmlElement(name = "ApplyOnAccountGdfVA")
    protected ReceivableApplicationGdf applyOnAccountGdfVA;

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
     * Gets the value of the amountApplied property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountApplied() {
        return amountApplied;
    }

    /**
     * Sets the value of the amountApplied property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountApplied(BigDecimal value) {
        this.amountApplied = value;
    }

    /**
     * Gets the value of the applyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplyDate() {
        return applyDate;
    }

    /**
     * Sets the value of the applyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplyDate(XMLGregorianCalendar value) {
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
     * Gets the value of the applicationReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplicationReferenceNumber() {
        return applicationReferenceNumber;
    }

    /**
     * Sets the value of the applicationReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplicationReferenceNumber(JAXBElement<String> value) {
        this.applicationReferenceNumber = value;
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
     * Gets the value of the secondaryApplicationReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSecondaryApplicationReferenceId() {
        return secondaryApplicationReferenceId;
    }

    /**
     * Sets the value of the secondaryApplicationReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSecondaryApplicationReferenceId(JAXBElement<Long> value) {
        this.secondaryApplicationReferenceId = value;
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
     * Gets the value of the applyOnAccountGdfVA property.
     * 
     * @return
     *     possible object is
     *     {@link ReceivableApplicationGdf }
     *     
     */
    public ReceivableApplicationGdf getApplyOnAccountGdfVA() {
        return applyOnAccountGdfVA;
    }

    /**
     * Sets the value of the applyOnAccountGdfVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivableApplicationGdf }
     *     
     */
    public void setApplyOnAccountGdfVA(ReceivableApplicationGdf value) {
        this.applyOnAccountGdfVA = value;
    }

}
