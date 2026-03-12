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
 * To create ID generator sequence "VENDHQ_SALE_ITEMS_ONHAND_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_SALE_ONHAND_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqSaleItemsOnhand.findAll", query = "select o from VendhqSaleItemsOnhand o"),
                @NamedQuery(name = "findItemOnHandRow",
                            query =
                            "select o from VendhqSaleItemsOnhand o where o.itemNumber = :itemNumber and o.subinventory = :subInventoryCode")
    })
@Table(name = "VENDHQ_SALE_ITEMS_ONHAND")
@SequenceGenerator(name = "VendhqSaleItemsOnhand_Id_Seq_Gen", sequenceName = "VENDHQ_SALE_ONHAND_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class VendhqSaleItemsOnhand implements Serializable {
    private static final long serialVersionUID = -8271405303156433533L;
    @Column(name = "ITEM_NUMBER", nullable = false, length = 20)
    private String itemNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Date lastUpdateDate;
    @Column(name = "ONHAND_QTY")
    private BigDecimal onhandQty;
    @Column(name = "ORG_CODE", nullable = false, length = 20)
    private String orgCode;
    @Column(name = "RECEIVING_QTY")
    private BigDecimal receivingQty;
    @Column(name = "RESERVED_QTY")
    private BigDecimal reservedQty;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VendhqSaleItemsOnhand_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(name = "SALE_QTY")
    private BigDecimal saleQty;
    @Column(nullable = false, length = 12)
    private String subinventory;
    @Column(name = "UOM_CODE", nullable = false, length = 5)
    private String uomCode;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public VendhqSaleItemsOnhand() {
    }


    public VendhqSaleItemsOnhand(String itemNumber, Date lastUpdateDate, BigDecimal reservedQty,
                                 BigDecimal onhandQty, String orgCode, BigDecimal receivingQty, 
                                 BigDecimal saleQty, String subinventory, String uomCode) {
        this.itemNumber = itemNumber;
        this.lastUpdateDate = lastUpdateDate;
        this.onhandQty = onhandQty;
        this.orgCode = orgCode;
        this.receivingQty = receivingQty;
        this.reservedQty = reservedQty;
        this.saleQty = saleQty;
        this.subinventory = subinventory;
        this.uomCode = uomCode;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigDecimal getOnhandQty() {
        return onhandQty;
    }

    public void setOnhandQty(BigDecimal onhandQty) {
        this.onhandQty = onhandQty;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public BigDecimal getReceivingQty() {
        return receivingQty;
    }

    public void setReceivingQty(BigDecimal receivingQty) {
        this.receivingQty = receivingQty;
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public BigDecimal getSaleQty() {
        return saleQty;
    }

    public void setSaleQty(BigDecimal saleQty) {
        this.saleQty = saleQty;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
