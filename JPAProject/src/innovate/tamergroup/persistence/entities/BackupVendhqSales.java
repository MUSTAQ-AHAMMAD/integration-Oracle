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
 * To create ID generator sequence "BACKUP_VENDHQ_SALES_SEQ_GEN":
 * CREATE SEQUENCE "BACKUP_VENDHQ_SALES_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "BackupVendhqSales.findAll", query = "select o from BackupVendhqSales o"),
                @NamedQuery(name = "SalesOutletBtwDate",
                            query =
                            "select o from BackupVendhqSales o where o.outletName = :outletName and o.saleDate between :startDate and :endDate order by o.saleDate asc"),
                @NamedQuery(name = "lastSaleVersionBackup",
                            query = "select max(o.version) from BackupVendhqSales o where o.region = :region"),
                @NamedQuery(name = "isSalesExists",
                            query =
                            "select count(o) from BackupVendhqSales o where o.invoiceNumber = :invoiceNumber and o.saleDate = :saleDate\t")
    })
@Table(name = "BACKUP_VENDHQ_SALES")
@SequenceGenerator(name = "BackupVendhqSales_Id_Seq_Gen", sequenceName = "BACKUP_VENDHQ_SALES_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class BackupVendhqSales implements Serializable {
    private static final long serialVersionUID = 2688602079101038614L;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BackupVendhqSales_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(name = "INVOICE_NUMBER", nullable = false, length = 15)
    private String invoiceNumber;
    @Column(name = "OUTLET_NAME", nullable = false, length = 15)
    private String outletName;
    @Column(nullable = false, length = 5)
    private String region;
    @Column(name = "REGISTER_NAME", nullable = false, length = 30)
    private String registerName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SALE_DATE", nullable = false)
    private Date saleDate;
    @Column(name = "TOTAL_LOYALTY")
    private BigDecimal totalLoyalty;
    @Column(name = "TOTAL_PRICE", nullable = false)
    private BigDecimal totalPrice;
    @Column(name = "TOTAL_PRICE_INCL_TAX", nullable = false)
    private BigDecimal totalPriceInclTax;
    @Column(name = "TOTAL_TAX")
    private BigDecimal totalTax;
    @Column(nullable = false)
    private BigDecimal version;
    @Column(name = "CUSTOMER_TYPE", nullable = false)
    private String customerType;

    public BackupVendhqSales() {
    }

    public BackupVendhqSales(String invoiceNumber, String outletName, String region, String registerName, Date saleDate,
                             BigDecimal totalLoyalty, BigDecimal totalPrice, BigDecimal totalPriceInclTax,
                             BigDecimal totalTax, BigDecimal version, String customerType) {
        this.invoiceNumber = invoiceNumber;
        this.outletName = outletName;
        this.region = region;
        this.registerName = registerName;
        this.saleDate = saleDate;
        this.totalLoyalty = totalLoyalty;
        this.totalPrice = totalPrice;
        this.totalPriceInclTax = totalPriceInclTax;
        this.totalTax = totalTax;
        this.version = version;
        this.customerType = customerType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public BigDecimal getTotalPriceInclTax() {
        return totalPriceInclTax;
    }

    public void setTotalPriceInclTax(BigDecimal totalPriceInclTax) {
        this.totalPriceInclTax = totalPriceInclTax;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public BigDecimal getRowId() {
        return rowId;
    }
}
