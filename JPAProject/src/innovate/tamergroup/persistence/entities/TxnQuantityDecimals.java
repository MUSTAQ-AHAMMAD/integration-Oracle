package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({ @NamedQuery(name = "TxnQuantityDecimals.findAll", query = "select o from TxnQuantityDecimals o"),
                @NamedQuery(name = "TxnQtyDecimalsByRegion",
                            query = "select o from TxnQuantityDecimals o where o.region = :region")
    })
@Table(name = "TXN_QUANTITY_DECIMALS")
@IdClass(TxnQtyDecimalsPK.class)
public class TxnQuantityDecimals implements Serializable {
    private static final long serialVersionUID = -2036081844684720697L;
    private BigDecimal decim;
    @Id
    @Column(name = "INVOICE_NUMBER", length = 15)
    private String invoiceNumber;
    @Id
    @Column(name = "ITEM_NUMBER", length = 20)
    private String itemNumber;
    @Id
    @Column(name = "OUTLET_NAME", nullable = false, length = 15)
    private String outletName;
    private BigDecimal quantity;
    @Column(name = "TOTAL_PRICE", nullable = false, length = 15)
    private BigDecimal totalPrice;
    @Id
    @Column(nullable = false, length = 5)
    private String region;
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SALE_DATE", nullable = false)
    private Date saleDate;
    @Column(name = "UOM_NAME", length = 20)
    private String uomName;

    public TxnQuantityDecimals() {
    }


    public TxnQuantityDecimals(BigDecimal decim, String invoiceNumber, String itemNumber, String outletName,
                               BigDecimal quantity, BigDecimal totalPrice, String region, Date saleDate,
                               String uomName) {
        this.decim = decim;
        this.invoiceNumber = invoiceNumber;
        this.itemNumber = itemNumber;
        this.outletName = outletName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.region = region;
        this.saleDate = saleDate;
        this.uomName = uomName;
    }

    public BigDecimal getDecim() {
        return decim;
    }

    public void setDecim(BigDecimal decim) {
        this.decim = decim;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
