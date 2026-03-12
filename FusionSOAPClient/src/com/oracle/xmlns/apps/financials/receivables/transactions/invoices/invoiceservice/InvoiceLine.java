
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfacelinedff.TransactionInterfaceLineFLEX;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinedff.TransactionLineFLEX;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinegdf.TransactionLineGdf;


/**
 * <p>Java class for InvoiceLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceLine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LineNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ItemNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemoLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="UnitSellingPrice" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="TaxClassificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesOrder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesOrderLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionInterfaceLineFLEX" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/}TransactionInterfaceLineFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionLineFLEX" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/}TransactionLineFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionLineGdf" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/}TransactionLineGdf" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceLine", propOrder = {
    "lineNumber",
    "itemNumber",
    "memoLineName",
    "description",
    "quantity",
    "unitSellingPrice",
    "taxClassificationCode",
    "salesOrder",
    "salesOrderLine",
    "transactionInterfaceLineFLEX",
    "transactionLineFLEX",
    "transactionLineGdf"
})
public class InvoiceLine {

    @XmlElement(name = "LineNumber")
    protected Integer lineNumber;
    @XmlElementRef(name = "ItemNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemNumber;
    @XmlElementRef(name = "MemoLineName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> memoLineName;
    @XmlElementRef(name = "Description", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "Quantity", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> quantity;
    @XmlElementRef(name = "UnitSellingPrice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> unitSellingPrice;
    @XmlElementRef(name = "TaxClassificationCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxClassificationCode;
    @XmlElementRef(name = "SalesOrder", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesOrder;
    @XmlElementRef(name = "SalesOrderLine", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesOrderLine;
    @XmlElement(name = "TransactionInterfaceLineFLEX")
    protected TransactionInterfaceLineFLEX transactionInterfaceLineFLEX;
    @XmlElement(name = "TransactionLineFLEX")
    protected TransactionLineFLEX transactionLineFLEX;
    @XmlElement(name = "TransactionLineGdf")
    protected TransactionLineGdf transactionLineGdf;

    /**
     * Gets the value of the lineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLineNumber(Integer value) {
        this.lineNumber = value;
    }

    /**
     * Gets the value of the itemNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the value of the itemNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemNumber(JAXBElement<String> value) {
        this.itemNumber = value;
    }

    /**
     * Gets the value of the memoLineName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemoLineName() {
        return memoLineName;
    }

    /**
     * Sets the value of the memoLineName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemoLineName(JAXBElement<String> value) {
        this.memoLineName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setQuantity(JAXBElement<MeasureType> value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the unitSellingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getUnitSellingPrice() {
        return unitSellingPrice;
    }

    /**
     * Sets the value of the unitSellingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setUnitSellingPrice(JAXBElement<AmountType> value) {
        this.unitSellingPrice = value;
    }

    /**
     * Gets the value of the taxClassificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxClassificationCode() {
        return taxClassificationCode;
    }

    /**
     * Sets the value of the taxClassificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxClassificationCode(JAXBElement<String> value) {
        this.taxClassificationCode = value;
    }

    /**
     * Gets the value of the salesOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesOrder() {
        return salesOrder;
    }

    /**
     * Sets the value of the salesOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesOrder(JAXBElement<String> value) {
        this.salesOrder = value;
    }

    /**
     * Gets the value of the salesOrderLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesOrderLine() {
        return salesOrderLine;
    }

    /**
     * Sets the value of the salesOrderLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesOrderLine(JAXBElement<String> value) {
        this.salesOrderLine = value;
    }

    /**
     * Gets the value of the transactionInterfaceLineFLEX property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public TransactionInterfaceLineFLEX getTransactionInterfaceLineFLEX() {
        return transactionInterfaceLineFLEX;
    }

    /**
     * Sets the value of the transactionInterfaceLineFLEX property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public void setTransactionInterfaceLineFLEX(TransactionInterfaceLineFLEX value) {
        this.transactionInterfaceLineFLEX = value;
    }

    /**
     * Gets the value of the transactionLineFLEX property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionLineFLEX }
     *     
     */
    public TransactionLineFLEX getTransactionLineFLEX() {
        return transactionLineFLEX;
    }

    /**
     * Sets the value of the transactionLineFLEX property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionLineFLEX }
     *     
     */
    public void setTransactionLineFLEX(TransactionLineFLEX value) {
        this.transactionLineFLEX = value;
    }

    /**
     * Gets the value of the transactionLineGdf property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionLineGdf }
     *     
     */
    public TransactionLineGdf getTransactionLineGdf() {
        return transactionLineGdf;
    }

    /**
     * Sets the value of the transactionLineGdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionLineGdf }
     *     
     */
    public void setTransactionLineGdf(TransactionLineGdf value) {
        this.transactionLineGdf = value;
    }

}
