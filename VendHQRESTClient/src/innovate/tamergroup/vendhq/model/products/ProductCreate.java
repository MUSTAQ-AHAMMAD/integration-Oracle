package innovate.tamergroup.vendhq.model.products;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductCreate implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("source_id")
    @Expose
    private String sourceId;
    @SerializedName("variant_source_id")
    @Expose
    private String variantSourceId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("variant_option_one_name")
    @Expose
    private String variantOptionOneName;
    @SerializedName("variant_option_one_value")
    @Expose
    private String variantOptionOneValue;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("tax_id")
    @Expose
    private String taxId;
    @SerializedName("track_inventory")
    @Expose
    private Boolean trackInventory;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("supplier_code")
    @Expose
    private String supplierCode;
    @SerializedName("retail_price")
    @Expose
    private Double retailPrice;
    @SerializedName("inventory")
    @Expose
    private List<InventoryUpdate> inventory = null;
    private final static long serialVersionUID = -5974644346352170114L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductCreate() {
    }

    /**
     *
     * @param handle
     * @param trackInventory
     * @param type
     * @param sku
     * @param brandId
     * @param sourceId
     * @param id
     * @param retailPrice
     * @param taxId
     * @param inventory
     * @param description
     * @param name
     * @param variantSourceId
     * @param active
     */
    public ProductCreate(String id, String sourceId, String variantSourceId, String type, String variantOptionOneName,
                         String variantOptionOneValue, String description, String brandId, String taxId,
                         Boolean trackInventory, Boolean active, String name, String handle, String sku,
                         String supplierCode, Double retailPrice, List<InventoryUpdate> inventory) {
        this.id = id;
        this.sourceId = sourceId;
        this.variantSourceId = variantSourceId;
        this.type = type;
        this.variantOptionOneName = variantOptionOneName;
        this.variantOptionOneValue = variantOptionOneValue;
        this.description = description;
        this.brandId = brandId;
        this.taxId = taxId;
        this.trackInventory = trackInventory;
        this.active = active;
        this.name = name;
        this.handle = handle;
        this.sku = sku;
        this.supplierCode = supplierCode;
        this.retailPrice = retailPrice;
        this.inventory = inventory;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductCreate withId(String id) {
        this.id = id;
        return this;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public ProductCreate withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public String getVariantSourceId() {
        return variantSourceId;
    }

    public void setVariantSourceId(String variantSourceId) {
        this.variantSourceId = variantSourceId;
    }

    public ProductCreate withVariantSourceId(String variantSourceId) {
        this.variantSourceId = variantSourceId;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductCreate withType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCreate withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public ProductCreate withBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public ProductCreate withTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public Boolean isTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(Boolean trackInventory) {
        this.trackInventory = trackInventory;
    }

    public ProductCreate withTrackInventory(Boolean trackInventory) {
        this.trackInventory = trackInventory;
        return this;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ProductCreate withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCreate withName(String name) {
        this.name = name;
        return this;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public ProductCreate withHandle(String handle) {
        this.handle = handle;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public ProductCreate withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public ProductCreate withRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public List<InventoryUpdate> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryUpdate> inventory) {
        this.inventory = inventory;
    }

    public ProductCreate withInventory(List<InventoryUpdate> inventory) {
        this.inventory = inventory;
        return this;
    }

    public void setVariantOptionOneName(String variantOptionOneName) {
        this.variantOptionOneName = variantOptionOneName;
    }

    public String getVariantOptionOneName() {
        return variantOptionOneName;
    }
    
    public ProductCreate withVariantOptionOneName(String variantOptionOneName) {
        this.variantOptionOneName = variantOptionOneName;
        return this;
    }

    public void setVariantOptionOneValue(String variantOptionOneValue) {
        this.variantOptionOneValue = variantOptionOneValue;
    }

    public String getVariantOptionOneValue() {
        return variantOptionOneValue;
    }
    
    public ProductCreate withVariantOptionOneValue(String variantOptionOneValue) {
        this.variantOptionOneValue = variantOptionOneValue;
        return this;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }
    
    public ProductCreate withSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
        return this;
    }

}
