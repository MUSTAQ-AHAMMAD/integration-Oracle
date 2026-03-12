package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

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
 * To create ID generator sequence "VENDHQ_ITEM_META_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_ITEM_META_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqItemMeta.findAll", query = "select o from VendhqItemMeta o"),
                @NamedQuery(name = "getVendHqItemId",
                            query =
                            "select distinct(o.itemId) from VendhqItemMeta o where o.sourceId = :sourceId and o.region = :region and o.itemId is not null"),
                @NamedQuery(name = "getVenHqItemsLastUpdatedDate",
                            query = "select max(o.lastUpdateDate) from VendhqItemMeta o where o.region = :region"),
                @NamedQuery(name = "getVendHqItemRow",
                            query =
                            "select o from VendhqItemMeta o where o.requestId = :requestId and o.sourceId = :sourceId"),
                @NamedQuery(name = "getVendHqItemRowProductId",
                            query =
                            "select o from VendhqItemMeta o where o.itemId = :itemId and o.requestId = (select max(o.requestId) from VendhqItemMeta o where o.itemId = :itemId and o.itemId is not null)"),
                @NamedQuery(name = "VendHQItemIDFromNumber",
                            query =
                            "select distinct(o.itemId) from VendhqItemMeta o where o.handle = :itemNumber and o.itemId is not null and o.region = :region"),
                @NamedQuery(name = "VendHQItemRowFusion",
                            query =
                            "select o from VendhqItemMeta o where o.handle = :itemNumber and o.region = :region order by o.lastUpdateDate desc")
    })
@Table(name = "VENDHQ_ITEM_META")
@SequenceGenerator(name = "VendhqItemMeta_Id_Seq_Gen", sequenceName = "VENDHQ_ITEM_META_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class VendhqItemMeta implements Serializable {
    private static final long serialVersionUID = 6783334539087071156L;
    private String active;
    @Column(name = "BRAND_ID", length = 50)
    private String brandId;
    @Column(length = 2000)
    private String description;
    @Column(length = 25)
    private String handle;
    @Column(name = "ITEM_ID", length = 50)
    private String itemId;
    @Column(nullable = false, length = 500)
    private String message;
    @Column(length = 50)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE")
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Column(name = "RETAIL_PRICE")
    private BigDecimal retailPrice;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VendhqItemMeta_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(length = 30)
    private String sku;
    @Column(name = "SOURCE_ID")
    private BigDecimal sourceId;
    @Column(nullable = false, length = 10)
    private String status;
    @Column(name = "TAX_ID", length = 50)
    private String taxId;
    @Column(name = "TRACK_INVENTORY")
    private String trackInventory;
    @Column(length = 50)
    private String type;
    @Column(name = "UOM_NAME", length = 20)
    private String uomName;
    @Column(name = "UOM_CODE", length = 10)
    private String uomCode;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public VendhqItemMeta() {
    }


    public VendhqItemMeta(String active, String brandId, String description, String handle, String itemId,
                          String message, String name, Date requestDate, BigDecimal requestId, BigDecimal retailPrice,
                          BigDecimal rowId, String sku, BigDecimal sourceId, String status, String taxId,
                          String trackInventory, String type, String uomName, String uomCode, Date lastUpdateDate) {
        this.active = active;
        this.brandId = brandId;
        this.description = description;
        this.handle = handle;
        this.itemId = itemId;
        this.message = message;
        this.name = name;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.retailPrice = retailPrice;
        this.rowId = rowId;
        this.sku = sku;
        this.sourceId = sourceId;
        this.status = status;
        this.taxId = taxId;
        this.trackInventory = trackInventory;
        this.type = type;
        this.uomName = uomName;
        this.uomCode = uomCode;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public BigDecimal getRequestId() {
        return requestId;
    }

    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getSourceId() {
        return sourceId;
    }

    public void setSourceId(BigDecimal sourceId) {
        this.sourceId = sourceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(String trackInventory) {
        this.trackInventory = trackInventory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
