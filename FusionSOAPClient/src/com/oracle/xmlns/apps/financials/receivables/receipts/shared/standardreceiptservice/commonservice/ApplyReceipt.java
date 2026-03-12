
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
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.applyreceiptdff.ReceivableApplicationFLEX;


/**
 * <p>Java class for ApplyReceipt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplyReceipt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmountApplied" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReceiptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Instalment" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="ReceiptDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="TransactionSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmountReceiptCurrency" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReceiptCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ApplicationDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="AccountingDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ApplyClosedInvoices" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InstalmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReceivableApplicationFLEXVA" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ApplyReceiptDff/}ReceivableApplicationFLEX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplyReceipt", propOrder = {
    "amountApplied",
    "receiptId",
    "comments",
    "customerTrxId",
    "discount",
    "instalment",
    "receiptNumber",
    "transactionNumber",
    "receiptAmount",
    "receiptDate",
    "customerName",
    "transactionDate",
    "transactionSource",
    "amountReceiptCurrency",
    "receiptCurrency",
    "exchangeRate",
    "applicationDate",
    "accountingDate",
    "applyClosedInvoices",
    "instalmentId",
    "receivableApplicationFLEXVA"
})
public class ApplyReceipt {

    @XmlElement(name = "AmountApplied")
    protected BigDecimal amountApplied;
    @XmlElementRef(name = "ReceiptId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> receiptId;
    @XmlElementRef(name = "Comments", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "CustomerTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> customerTrxId;
    @XmlElementRef(name = "Discount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> discount;
    @XmlElementRef(name = "Instalment", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> instalment;
    @XmlElementRef(name = "ReceiptNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptNumber;
    @XmlElementRef(name = "TransactionNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionNumber;
    @XmlElementRef(name = "ReceiptAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> receiptAmount;
    @XmlElementRef(name = "ReceiptDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> receiptDate;
    @XmlElementRef(name = "CustomerName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerName;
    @XmlElementRef(name = "TransactionDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> transactionDate;
    @XmlElementRef(name = "TransactionSource", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionSource;
    @XmlElementRef(name = "AmountReceiptCurrency", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> amountReceiptCurrency;
    @XmlElementRef(name = "ReceiptCurrency", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptCurrency;
    @XmlElementRef(name = "ExchangeRate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> exchangeRate;
    @XmlElement(name = "ApplicationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar applicationDate;
    @XmlElement(name = "AccountingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accountingDate;
    @XmlElementRef(name = "ApplyClosedInvoices", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applyClosedInvoices;
    @XmlElementRef(name = "InstalmentId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> instalmentId;
    @XmlElement(name = "ReceivableApplicationFLEXVA")
    protected ReceivableApplicationFLEX receivableApplicationFLEXVA;

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
     * Gets the value of the receiptId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getReceiptId() {
        return receiptId;
    }

    /**
     * Sets the value of the receiptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setReceiptId(JAXBElement<Long> value) {
        this.receiptId = value;
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
     * Gets the value of the customerTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustomerTrxId() {
        return customerTrxId;
    }

    /**
     * Sets the value of the customerTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustomerTrxId(JAXBElement<Long> value) {
        this.customerTrxId = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDiscount(JAXBElement<BigDecimal> value) {
        this.discount = value;
    }

    /**
     * Gets the value of the instalment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInstalment() {
        return instalment;
    }

    /**
     * Sets the value of the instalment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInstalment(JAXBElement<Long> value) {
        this.instalment = value;
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
     * Gets the value of the transactionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Sets the value of the transactionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionNumber(JAXBElement<String> value) {
        this.transactionNumber = value;
    }

    /**
     * Gets the value of the receiptAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getReceiptAmount() {
        return receiptAmount;
    }

    /**
     * Sets the value of the receiptAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setReceiptAmount(JAXBElement<AmountType> value) {
        this.receiptAmount = value;
    }

    /**
     * Gets the value of the receiptDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getReceiptDate() {
        return receiptDate;
    }

    /**
     * Sets the value of the receiptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setReceiptDate(JAXBElement<XMLGregorianCalendar> value) {
        this.receiptDate = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerName(JAXBElement<String> value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTransactionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the transactionSource property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionSource() {
        return transactionSource;
    }

    /**
     * Sets the value of the transactionSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionSource(JAXBElement<String> value) {
        this.transactionSource = value;
    }

    /**
     * Gets the value of the amountReceiptCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAmountReceiptCurrency() {
        return amountReceiptCurrency;
    }

    /**
     * Sets the value of the amountReceiptCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAmountReceiptCurrency(JAXBElement<BigDecimal> value) {
        this.amountReceiptCurrency = value;
    }

    /**
     * Gets the value of the receiptCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptCurrency() {
        return receiptCurrency;
    }

    /**
     * Sets the value of the receiptCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptCurrency(JAXBElement<String> value) {
        this.receiptCurrency = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setExchangeRate(JAXBElement<BigDecimal> value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the applicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDate() {
        return applicationDate;
    }

    /**
     * Sets the value of the applicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDate(XMLGregorianCalendar value) {
        this.applicationDate = value;
    }

    /**
     * Gets the value of the accountingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccountingDate() {
        return accountingDate;
    }

    /**
     * Sets the value of the accountingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccountingDate(XMLGregorianCalendar value) {
        this.accountingDate = value;
    }

    /**
     * Gets the value of the applyClosedInvoices property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplyClosedInvoices() {
        return applyClosedInvoices;
    }

    /**
     * Sets the value of the applyClosedInvoices property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplyClosedInvoices(JAXBElement<String> value) {
        this.applyClosedInvoices = value;
    }

    /**
     * Gets the value of the instalmentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInstalmentId() {
        return instalmentId;
    }

    /**
     * Sets the value of the instalmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInstalmentId(JAXBElement<Long> value) {
        this.instalmentId = value;
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

}
