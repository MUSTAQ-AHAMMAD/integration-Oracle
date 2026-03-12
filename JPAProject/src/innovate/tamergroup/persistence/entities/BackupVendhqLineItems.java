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
 * To create ID generator sequence "BACKUP_VENDHQ_LINE_ITEMS_ID_SEQ_GEN":
 * CREATE SEQUENCE "BACKUP_VENDHQ_LINE_ITEMS_ID_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "BackupVendhqLineItems.findAll", query = "select o from BackupVendhqLineItems o"),
                @NamedQuery(name = "ItemSoldQuantity",
                            query =
                            "select sum(o.quantity) from BackupVendhqLineItems o where o.itemNumber = :itemNumber and o.invoiceNumber in (select k.invoiceNumber from BackupVendhqSales k where k.outletName = :outletName)"),
                @NamedQuery(name = "LineItemsByInvoice",
                            query =
                            "select o from BackupVendhqLineItems o where o.invoiceNumber = :invoiceNumber and o.saleDate = :saleDate and o.region =:region")
    })
@Table(name = "BACKUP_VENDHQ_LINE_ITEMS")
@SequenceGenerator(name = "BackupVendhqLineItems_Id_Seq_Gen", sequenceName = "BACKUP_VENDHQ_LINE_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class BackupVendhqLineItems implements Serializable {
    private static final long serialVersionUID = 1830038916617373578L;
    @Column(name = "INVOICE_NUMBER", nullable = false, length = 15)
    private String invoiceNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SALE_DATE", nullable = false)
    private Date saleDate;
    @Column(name = "ITEM_NAME", nullable = false, length = 50)
    private String itemName;
    @Column(name = "ITEM_NUMBER", nullable = false, length = 20)
    private String itemNumber;
    @Column(name = "LINE_NUMBER", nullable = false)
    private BigDecimal lineNumber;
    @Column(name = "LOYALTY_VALUE")
    private BigDecimal loyaltyValue;
    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false, length = 5)
    private String region;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BackupVendhqLineItems_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(name = "TOTAL_DISCOUNT")
    private BigDecimal totalDiscount;
    @Column(name = "TOTAL_LOYALTY")
    private BigDecimal totalLoyalty;
    @Column(name = "TOTAL_PRICE", nullable = false)
    private BigDecimal totalPrice;
    @Column(name = "TOTAL_TAX")
    private BigDecimal totalTax;
    @Column(name = "TAX_NAME", nullable = false, length = 100)
    private String taxName;

    public BackupVendhqLineItems() {
    }


    public BackupVendhqLineItems(String invoiceNumber, Date saleDate, String itemName, String itemNumber,
                                 BigDecimal lineNumber, BigDecimal loyaltyValue, BigDecimal quantity, String region,
                                 BigDecimal rowId, BigDecimal totalDiscount, BigDecimal totalLoyalty,
                                 BigDecimal totalPrice, BigDecimal totalTax, String taxName) {
        this.invoiceNumber = invoiceNumber;
        this.saleDate = saleDate;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.lineNumber = lineNumber;
        this.loyaltyValue = loyaltyValue;
        this.quantity = quantity;
        this.region = region;
        this.rowId = rowId;
        this.totalDiscount = totalDiscount;
        this.totalLoyalty = totalLoyalty;
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
        this.taxName = taxName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public BigDecimal getLoyaltyValue() {
        return loyaltyValue;
    }

    public void setLoyaltyValue(BigDecimal loyaltyValue) {
        this.loyaltyValue = loyaltyValue;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getTotalLoyalty() {
        return totalLoyalty;
    }

    public void setTotalLoyalty(BigDecimal totalLoyalty) {
        this.totalLoyalty = totalLoyalty;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getTaxName() {
        return taxName;
    }

}
