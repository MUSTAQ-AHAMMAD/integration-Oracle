package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "FUSION_INVOICE_LINE_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_INVOICE_LINE_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionInvoiceLine.findAll", query = "select o from FusionInvoiceLine o"),
                @NamedQuery(name = "FusionInvoiceLine.findSalesTxnLine",
                            query =
                            "select o.invoiceNumber from FusionInvoiceLine o where o.salesOrder = :salesOrder and o.salesOrderLine = :salesOrderLine and o.version = :version and o.region = :region and o.status = 'Success' order by o.requestId desc")
    })
@Table(name = "FUSION_INVOICE_LINE")
@SequenceGenerator(name = "FusionInvoiceLine_Id_Seq_Gen", sequenceName = "FUSION_INVOICE_LINE_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionInvoiceLine implements Serializable {
    private static final long serialVersionUID = 3346861130892450854L;
    @Column(name = "CURRENCY_CODE", length = 5)
    private String currencyCode;
    @Column(length = 250)
    private String description;
    @Column(name = "INVOICE_NUMBER", length = 20)
    private String invoiceNumber;
    @Column(name = "ITEM_NUMBER", length = 20)
    private String itemNumber;
    @Column(name = "LINE_NUMBER")
    private BigDecimal lineNumber;
    @Column(name = "SALES_ORDER", length = 10)
    private String salesOrder;
    @Column(name = "SALES_ORDER_LINE")
    private BigDecimal salesOrderLine;
    @Column(nullable = false, length = 500)
    private String message;
    private BigDecimal quantity;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionInvoiceLine_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 20)
    private String status;
    @Column(name = "TAX_CODE", length = 30)
    private String taxCode;
    @Column(name = "UNIT_SELLING_PRICE")
    private double unitSellingPrice;
    @Column(length = 10)
    private String uom;
    @Column(name = "VERSION")
    private BigDecimal version;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public FusionInvoiceLine() {
    }


    public FusionInvoiceLine(String currencyCode, String description, String invoiceNumber, String itemNumber,
                             BigDecimal lineNumber, String salesOrder, BigDecimal salesOrderLine, String message,
                             BigDecimal quantity, Date requestDate, BigDecimal requestId, BigDecimal rowId,
                             String status, String taxCode, double unitSellingPrice, String uom, BigDecimal version) {
        this.currencyCode = currencyCode;
        this.description = description;
        this.invoiceNumber = invoiceNumber;
        this.itemNumber = itemNumber;
        this.lineNumber = lineNumber;
        this.salesOrder = salesOrder;
        this.salesOrderLine = salesOrderLine;
        this.message = message;
        this.quantity = quantity;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.rowId = rowId;
        this.status = status;
        this.taxCode = taxCode;
        this.unitSellingPrice = unitSellingPrice;
        this.uom = uom;
        this.version = version;
    }


    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }

    public BigDecimal getRequestId() {
        return requestId;
    }

    public void setRowId(BigDecimal rowId) {
        this.rowId = rowId;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setUnitSellingPrice(double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getUom() {
        return uom;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrderLine(BigDecimal salesOrderLine) {
        this.salesOrderLine = salesOrderLine;
    }

    public BigDecimal getSalesOrderLine() {
        return salesOrderLine;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
