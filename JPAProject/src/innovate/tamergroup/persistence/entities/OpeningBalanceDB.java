package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
              @NamedQuery(name = "OpeningBalanceDB.findAll", query = "select o from OpeningBalanceDB o"),
              @NamedQuery(name = "OpeningBalanceDB.findItemRow",
                          query = "select o from OpeningBalanceDB o where o.itemCode = :itemCode")
    })
@Table(name = "XX_OPENING_BALANCE")
public class OpeningBalanceDB implements Serializable {
    private static final long serialVersionUID = -251216798274613357L;
    @Id
    @Column(name = "ITEM_CODE", length = 30)
    private String itemCode;
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "ITEM_NAME", length = 200)
    private String itemName;
    @Column(name = "ORGANIZATION_CODE", length = 10)
    private String organizationCode;
    @Column(name = "ORGANIZATION_ID")
    private Long organizationId;
    @Column(name = "ORGANIZATION_NAME", length = 200)
    private String organizationName;
    @Column(length = 20)
    private String status;
    @Column(length = 30)
    private String subinventory;
    @Column(name = "TRX_COST")
    private Long trxCost;
    @Column(name = "TRX_SELLING_PRICE")
    private BigDecimal trxSellingPrice;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRX_DATE")
    private Date trxDate;
    @Column(name = "TRX_QTY")
    private Integer trxQty;
    @Column(name = "TRX_SOURCE_CODE", length = 30)
    private String trxSourceCode;
    @Column(name = "TRX_SOURCE_NAME", length = 100)
    private String trxSourceName;
    @Column(name = "TRX_UOM", length = 10)
    private String trxUom;

    public OpeningBalanceDB() {
    }


    public OpeningBalanceDB(String itemCode, Long itemId, String itemName, String organizationCode, Long organizationId,
                            String organizationName, String status, String subinventory, Long trxCost,
                            BigDecimal trxSellingPrice, Date trxDate, Integer trxQty, String trxSourceCode,
                            String trxSourceName, String trxUom) {
        this.itemCode = itemCode;
        this.itemId = itemId;
        this.itemName = itemName;
        this.organizationCode = organizationCode;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.status = status;
        this.subinventory = subinventory;
        this.trxCost = trxCost;
        this.trxSellingPrice = trxSellingPrice;
        this.trxDate = trxDate;
        this.trxQty = trxQty;
        this.trxSourceCode = trxSourceCode;
        this.trxSourceName = trxSourceName;
        this.trxUom = trxUom;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public Long getTrxCost() {
        return trxCost;
    }

    public void setTrxCost(Long trxCost) {
        this.trxCost = trxCost;
    }

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public Integer getTrxQty() {
        return trxQty;
    }

    public void setTrxQty(Integer trxQty) {
        this.trxQty = trxQty;
    }

    public String getTrxSourceCode() {
        return trxSourceCode;
    }

    public void setTrxSourceCode(String trxSourceCode) {
        this.trxSourceCode = trxSourceCode;
    }

    public String getTrxSourceName() {
        return trxSourceName;
    }

    public void setTrxSourceName(String trxSourceName) {
        this.trxSourceName = trxSourceName;
    }

    public String getTrxUom() {
        return trxUom;
    }

    public void setTrxUom(String trxUom) {
        this.trxUom = trxUom;
    }

    public void setTrxSellingPrice(BigDecimal trxSellingPrice) {
        this.trxSellingPrice = trxSellingPrice;
    }

    public BigDecimal getTrxSellingPrice() {
        return trxSellingPrice;
    }
}
