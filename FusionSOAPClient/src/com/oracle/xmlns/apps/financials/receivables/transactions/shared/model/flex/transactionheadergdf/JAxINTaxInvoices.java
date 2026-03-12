
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JAxINTaxInvoices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JAxINTaxInvoices">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
 *         &lt;element name="TaxInvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TaxInvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="OriginalTaxInvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="OriginalTaxInvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ShippingBillNoOrBillOfExportNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingBillDateOrBillOfExport" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="PortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JAxINTaxInvoices", propOrder = {
    "taxInvoiceNumber",
    "taxInvoiceDate",
    "originalTaxInvoiceNumber",
    "originalTaxInvoiceDate",
    "shippingBillNoOrBillOfExportNo",
    "shippingBillDateOrBillOfExport",
    "portCode"
})
public class JAxINTaxInvoices
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "TaxInvoiceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> taxInvoiceNumber;
    @XmlElementRef(name = "TaxInvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxInvoiceDate;
    @XmlElementRef(name = "OriginalTaxInvoiceNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> originalTaxInvoiceNumber;
    @XmlElementRef(name = "OriginalTaxInvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> originalTaxInvoiceDate;
    @XmlElementRef(name = "ShippingBillNoOrBillOfExportNo", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shippingBillNoOrBillOfExportNo;
    @XmlElementRef(name = "ShippingBillDateOrBillOfExport", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> shippingBillDateOrBillOfExport;
    @XmlElementRef(name = "PortCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> portCode;

    /**
     * Gets the value of the taxInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTaxInvoiceNumber() {
        return taxInvoiceNumber;
    }

    /**
     * Sets the value of the taxInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTaxInvoiceNumber(JAXBElement<BigDecimal> value) {
        this.taxInvoiceNumber = value;
    }

    /**
     * Gets the value of the taxInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTaxInvoiceDate() {
        return taxInvoiceDate;
    }

    /**
     * Sets the value of the taxInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTaxInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.taxInvoiceDate = value;
    }

    /**
     * Gets the value of the originalTaxInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOriginalTaxInvoiceNumber() {
        return originalTaxInvoiceNumber;
    }

    /**
     * Sets the value of the originalTaxInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOriginalTaxInvoiceNumber(JAXBElement<BigDecimal> value) {
        this.originalTaxInvoiceNumber = value;
    }

    /**
     * Gets the value of the originalTaxInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getOriginalTaxInvoiceDate() {
        return originalTaxInvoiceDate;
    }

    /**
     * Sets the value of the originalTaxInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setOriginalTaxInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.originalTaxInvoiceDate = value;
    }

    /**
     * Gets the value of the shippingBillNoOrBillOfExportNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingBillNoOrBillOfExportNo() {
        return shippingBillNoOrBillOfExportNo;
    }

    /**
     * Sets the value of the shippingBillNoOrBillOfExportNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingBillNoOrBillOfExportNo(JAXBElement<String> value) {
        this.shippingBillNoOrBillOfExportNo = value;
    }

    /**
     * Gets the value of the shippingBillDateOrBillOfExport property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getShippingBillDateOrBillOfExport() {
        return shippingBillDateOrBillOfExport;
    }

    /**
     * Sets the value of the shippingBillDateOrBillOfExport property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setShippingBillDateOrBillOfExport(JAXBElement<XMLGregorianCalendar> value) {
        this.shippingBillDateOrBillOfExport = value;
    }

    /**
     * Gets the value of the portCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPortCode() {
        return portCode;
    }

    /**
     * Sets the value of the portCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPortCode(JAXBElement<String> value) {
        this.portCode = value;
    }

}
