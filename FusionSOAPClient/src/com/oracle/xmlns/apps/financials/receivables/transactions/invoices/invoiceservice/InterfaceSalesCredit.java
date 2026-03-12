
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionsalescreditdff.TransactionSalesCreditFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionsalescreditinterfacelinedff.TransactionInterfaceLineFLEX;


/**
 * <p>Java class for InterfaceSalesCredit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterfaceSalesCredit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ResourceSalesrepId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SalesCreditAmountSplit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SalesCreditPercentSplit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SalesCreditTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SalesCreditTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesgroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SalesrepNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesCreditInterfaceLineDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditInterfaceLineDff/}TransactionInterfaceLineFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionSalesCreditDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/}TransactionSalesCreditFLEX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterfaceSalesCredit", propOrder = {
    "orgId",
    "resourceSalesrepId",
    "salesCreditAmountSplit",
    "salesCreditPercentSplit",
    "salesCreditTypeId",
    "salesCreditTypeName",
    "salesgroupId",
    "salesrepNumber",
    "salesCreditInterfaceLineDff",
    "transactionSalesCreditDff"
})
public class InterfaceSalesCredit {

    @XmlElement(name = "OrgId")
    protected Long orgId;
    @XmlElementRef(name = "ResourceSalesrepId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> resourceSalesrepId;
    @XmlElementRef(name = "SalesCreditAmountSplit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> salesCreditAmountSplit;
    @XmlElementRef(name = "SalesCreditPercentSplit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> salesCreditPercentSplit;
    @XmlElementRef(name = "SalesCreditTypeId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> salesCreditTypeId;
    @XmlElementRef(name = "SalesCreditTypeName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesCreditTypeName;
    @XmlElementRef(name = "SalesgroupId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> salesgroupId;
    @XmlElementRef(name = "SalesrepNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesrepNumber;
    @XmlElement(name = "SalesCreditInterfaceLineDff")
    protected TransactionInterfaceLineFLEX salesCreditInterfaceLineDff;
    @XmlElement(name = "TransactionSalesCreditDff")
    protected TransactionSalesCreditFLEX transactionSalesCreditDff;

    /**
     * Gets the value of the orgId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgId(Long value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the resourceSalesrepId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getResourceSalesrepId() {
        return resourceSalesrepId;
    }

    /**
     * Sets the value of the resourceSalesrepId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setResourceSalesrepId(JAXBElement<Long> value) {
        this.resourceSalesrepId = value;
    }

    /**
     * Gets the value of the salesCreditAmountSplit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSalesCreditAmountSplit() {
        return salesCreditAmountSplit;
    }

    /**
     * Sets the value of the salesCreditAmountSplit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSalesCreditAmountSplit(JAXBElement<BigDecimal> value) {
        this.salesCreditAmountSplit = value;
    }

    /**
     * Gets the value of the salesCreditPercentSplit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSalesCreditPercentSplit() {
        return salesCreditPercentSplit;
    }

    /**
     * Sets the value of the salesCreditPercentSplit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSalesCreditPercentSplit(JAXBElement<BigDecimal> value) {
        this.salesCreditPercentSplit = value;
    }

    /**
     * Gets the value of the salesCreditTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSalesCreditTypeId() {
        return salesCreditTypeId;
    }

    /**
     * Sets the value of the salesCreditTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSalesCreditTypeId(JAXBElement<Long> value) {
        this.salesCreditTypeId = value;
    }

    /**
     * Gets the value of the salesCreditTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesCreditTypeName() {
        return salesCreditTypeName;
    }

    /**
     * Sets the value of the salesCreditTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesCreditTypeName(JAXBElement<String> value) {
        this.salesCreditTypeName = value;
    }

    /**
     * Gets the value of the salesgroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getSalesgroupId() {
        return salesgroupId;
    }

    /**
     * Sets the value of the salesgroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setSalesgroupId(JAXBElement<Long> value) {
        this.salesgroupId = value;
    }

    /**
     * Gets the value of the salesrepNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesrepNumber() {
        return salesrepNumber;
    }

    /**
     * Sets the value of the salesrepNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesrepNumber(JAXBElement<String> value) {
        this.salesrepNumber = value;
    }

    /**
     * Gets the value of the salesCreditInterfaceLineDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public TransactionInterfaceLineFLEX getSalesCreditInterfaceLineDff() {
        return salesCreditInterfaceLineDff;
    }

    /**
     * Sets the value of the salesCreditInterfaceLineDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public void setSalesCreditInterfaceLineDff(TransactionInterfaceLineFLEX value) {
        this.salesCreditInterfaceLineDff = value;
    }

    /**
     * Gets the value of the transactionSalesCreditDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionSalesCreditFLEX }
     *     
     */
    public TransactionSalesCreditFLEX getTransactionSalesCreditDff() {
        return transactionSalesCreditDff;
    }

    /**
     * Sets the value of the transactionSalesCreditDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionSalesCreditFLEX }
     *     
     */
    public void setTransactionSalesCreditDff(TransactionSalesCreditFLEX value) {
        this.transactionSalesCreditDff = value;
    }

}
