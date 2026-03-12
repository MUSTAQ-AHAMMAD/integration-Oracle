
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheaderdff.TransactionHeaderFLEX;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf.TransactionHeaderGdf;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfaceheaderdff.TransactionInterfaceHeaderFLEX;


/**
 * <p>Java class for Invoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Invoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusinessUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrxDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="GlDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="BillToCustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentTermsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConversionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ConversionRateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PurchaseOrder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SoldToCustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToContact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceLine" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}InvoiceLine" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TransactionHeaderFLEX" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/}TransactionHeaderFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionHeaderGdf" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceHeaderFLEX" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/}TransactionInterfaceHeaderFLEX" minOccurs="0"/>
 *         &lt;element name="InvoiceDistribution" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}InvoiceDistribution" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Invoice", propOrder = {
    "businessUnit",
    "transactionSource",
    "transactionType",
    "trxNumber",
    "trxDate",
    "glDate",
    "billToCustomerName",
    "billToAccountNumber",
    "billToLocation",
    "paymentTermsName",
    "invoiceCurrencyCode",
    "conversionDate",
    "conversionRateType",
    "conversionRate",
    "purchaseOrder",
    "soldToCustomerName",
    "billToContact",
    "invoiceLine",
    "transactionHeaderFLEX",
    "transactionHeaderGdf",
    "transactionInterfaceHeaderFLEX",
    "invoiceDistribution"
})
public class Invoice {

    @XmlElementRef(name = "BusinessUnit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessUnit;
    @XmlElementRef(name = "TransactionSource", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionSource;
    @XmlElementRef(name = "TransactionType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionType;
    @XmlElementRef(name = "TrxNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trxNumber;
    @XmlElement(name = "TrxDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar trxDate;
    @XmlElementRef(name = "GlDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> glDate;
    @XmlElementRef(name = "BillToCustomerName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billToCustomerName;
    @XmlElementRef(name = "BillToAccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billToAccountNumber;
    @XmlElementRef(name = "BillToLocation", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billToLocation;
    @XmlElementRef(name = "PaymentTermsName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentTermsName;
    @XmlElement(name = "InvoiceCurrencyCode")
    protected String invoiceCurrencyCode;
    @XmlElementRef(name = "ConversionDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> conversionDate;
    @XmlElementRef(name = "ConversionRateType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> conversionRateType;
    @XmlElementRef(name = "ConversionRate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> conversionRate;
    @XmlElementRef(name = "PurchaseOrder", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaseOrder;
    @XmlElementRef(name = "SoldToCustomerName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> soldToCustomerName;
    @XmlElementRef(name = "BillToContact", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billToContact;
    @XmlElement(name = "InvoiceLine")
    protected List<InvoiceLine> invoiceLine;
    @XmlElement(name = "TransactionHeaderFLEX")
    protected TransactionHeaderFLEX transactionHeaderFLEX;
    @XmlElement(name = "TransactionHeaderGdf")
    protected TransactionHeaderGdf transactionHeaderGdf;
    @XmlElement(name = "TransactionInterfaceHeaderFLEX")
    protected TransactionInterfaceHeaderFLEX transactionInterfaceHeaderFLEX;
    @XmlElement(name = "InvoiceDistribution")
    protected List<InvoiceDistribution> invoiceDistribution;

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
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionType(JAXBElement<String> value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the trxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrxNumber() {
        return trxNumber;
    }

    /**
     * Sets the value of the trxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrxNumber(JAXBElement<String> value) {
        this.trxNumber = value;
    }

    /**
     * Gets the value of the trxDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTrxDate() {
        return trxDate;
    }

    /**
     * Sets the value of the trxDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTrxDate(XMLGregorianCalendar value) {
        this.trxDate = value;
    }

    /**
     * Gets the value of the glDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getGlDate() {
        return glDate;
    }

    /**
     * Sets the value of the glDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setGlDate(JAXBElement<XMLGregorianCalendar> value) {
        this.glDate = value;
    }

    /**
     * Gets the value of the billToCustomerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillToCustomerName() {
        return billToCustomerName;
    }

    /**
     * Sets the value of the billToCustomerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillToCustomerName(JAXBElement<String> value) {
        this.billToCustomerName = value;
    }

    /**
     * Gets the value of the billToAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillToAccountNumber() {
        return billToAccountNumber;
    }

    /**
     * Sets the value of the billToAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillToAccountNumber(JAXBElement<String> value) {
        this.billToAccountNumber = value;
    }

    /**
     * Gets the value of the billToLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillToLocation() {
        return billToLocation;
    }

    /**
     * Sets the value of the billToLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillToLocation(JAXBElement<String> value) {
        this.billToLocation = value;
    }

    /**
     * Gets the value of the paymentTermsName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentTermsName() {
        return paymentTermsName;
    }

    /**
     * Sets the value of the paymentTermsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTermsName(JAXBElement<String> value) {
        this.paymentTermsName = value;
    }

    /**
     * Gets the value of the invoiceCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceCurrencyCode() {
        return invoiceCurrencyCode;
    }

    /**
     * Sets the value of the invoiceCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceCurrencyCode(String value) {
        this.invoiceCurrencyCode = value;
    }

    /**
     * Gets the value of the conversionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getConversionDate() {
        return conversionDate;
    }

    /**
     * Sets the value of the conversionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setConversionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.conversionDate = value;
    }

    /**
     * Gets the value of the conversionRateType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConversionRateType() {
        return conversionRateType;
    }

    /**
     * Sets the value of the conversionRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConversionRateType(JAXBElement<String> value) {
        this.conversionRateType = value;
    }

    /**
     * Gets the value of the conversionRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getConversionRate() {
        return conversionRate;
    }

    /**
     * Sets the value of the conversionRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setConversionRate(JAXBElement<BigDecimal> value) {
        this.conversionRate = value;
    }

    /**
     * Gets the value of the purchaseOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * Sets the value of the purchaseOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseOrder(JAXBElement<String> value) {
        this.purchaseOrder = value;
    }

    /**
     * Gets the value of the soldToCustomerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSoldToCustomerName() {
        return soldToCustomerName;
    }

    /**
     * Sets the value of the soldToCustomerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSoldToCustomerName(JAXBElement<String> value) {
        this.soldToCustomerName = value;
    }

    /**
     * Gets the value of the billToContact property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillToContact() {
        return billToContact;
    }

    /**
     * Sets the value of the billToContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillToContact(JAXBElement<String> value) {
        this.billToContact = value;
    }

    /**
     * Gets the value of the invoiceLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLine }
     * 
     * 
     */
    public List<InvoiceLine> getInvoiceLine() {
        if (invoiceLine == null) {
            invoiceLine = new ArrayList<InvoiceLine>();
        }
        return this.invoiceLine;
    }

    /**
     * Gets the value of the transactionHeaderFLEX property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionHeaderFLEX }
     *     
     */
    public TransactionHeaderFLEX getTransactionHeaderFLEX() {
        return transactionHeaderFLEX;
    }

    /**
     * Sets the value of the transactionHeaderFLEX property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionHeaderFLEX }
     *     
     */
    public void setTransactionHeaderFLEX(TransactionHeaderFLEX value) {
        this.transactionHeaderFLEX = value;
    }

    /**
     * Gets the value of the transactionHeaderGdf property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionHeaderGdf }
     *     
     */
    public TransactionHeaderGdf getTransactionHeaderGdf() {
        return transactionHeaderGdf;
    }

    /**
     * Sets the value of the transactionHeaderGdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionHeaderGdf }
     *     
     */
    public void setTransactionHeaderGdf(TransactionHeaderGdf value) {
        this.transactionHeaderGdf = value;
    }

    /**
     * Gets the value of the transactionInterfaceHeaderFLEX property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceHeaderFLEX }
     *     
     */
    public TransactionInterfaceHeaderFLEX getTransactionInterfaceHeaderFLEX() {
        return transactionInterfaceHeaderFLEX;
    }

    /**
     * Sets the value of the transactionInterfaceHeaderFLEX property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceHeaderFLEX }
     *     
     */
    public void setTransactionInterfaceHeaderFLEX(TransactionInterfaceHeaderFLEX value) {
        this.transactionInterfaceHeaderFLEX = value;
    }

    /**
     * Gets the value of the invoiceDistribution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceDistribution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceDistribution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceDistribution }
     * 
     * 
     */
    public List<InvoiceDistribution> getInvoiceDistribution() {
        if (invoiceDistribution == null) {
            invoiceDistribution = new ArrayList<InvoiceDistribution>();
        }
        return this.invoiceDistribution;
    }

}
