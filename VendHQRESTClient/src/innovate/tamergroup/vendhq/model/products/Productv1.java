package innovate.tamergroup.vendhq.model.products;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Productv1 implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("source_id")
    @Expose
    private String sourceId;
    @SerializedName("variant_source_id")
    @Expose
    private String variantSourceId;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("has_variants")
    @Expose
    private boolean hasVariants;
    @SerializedName("variant_parent_id")
    @Expose
    private String variantParentId;
    @SerializedName("variant_option_one_name")
    @Expose
    private String variantOptionOneName;
    @SerializedName("variant_option_one_value")
    @Expose
    private String variantOptionOneValue;
    @SerializedName("variant_option_two_name")
    @Expose
    private String variantOptionTwoName;
    @SerializedName("variant_option_two_value")
    @Expose
    private String variantOptionTwoValue;
    @SerializedName("variant_option_three_name")
    @Expose
    private String variantOptionThreeName;
    @SerializedName("variant_option_three_value")
    @Expose
    private String variantOptionThreeValue;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("base_name")
    @Expose
    private String baseName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("image_large")
    @Expose
    private String imageLarge;
    @SerializedName("images")
    @Expose
    private Object images;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("supplier_name")
    @Expose
    private String supplierName;
    @SerializedName("supplier_code")
    @Expose
    private String supplierCode;
    @SerializedName("supply_price")
    @Expose
    private String supplyPrice;
    @SerializedName("account_code_purchase")
    @Expose
    private String accountCodePurchase;
    @SerializedName("account_code_sales")
    @Expose
    private String accountCodeSales;
    @SerializedName("track_inventory")
    @Expose
    private boolean trackInventory;
    @SerializedName("button_order")
    @Expose
    private String buttonOrder;
    @SerializedName("inventory")
    @Expose
    private List<InventoryUpdate> inventory = null;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("tax")
    @Expose
    private double tax;
    @SerializedName("tax_id")
    @Expose
    private String taxId;
    @SerializedName("tax_rate")
    @Expose
    private double taxRate;
    @SerializedName("tax_name")
    @Expose
    private String taxName;
    @SerializedName("taxes")
    @Expose
    private Object taxes;
    @SerializedName("display_retail_price_tax_inclusive")
    @Expose
    private long displayRetailPriceTaxInclusive;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;
    private final static long serialVersionUID = -2613078306873725035L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Productv1() {
    }

    /**
     *
     * @param displayRetailPriceTaxInclusive
     * @param imageLarge
     * @param supplierName
     * @param handle
     * @param accountCodePurchase
     * @param type
     * @param brandId
     * @param brandName
     * @param sourceId
     * @param id
     * @param description
     * @param name
     * @param deletedAt
     * @param variantOptionTwoName
     * @param variantSourceId
     * @param accountCodeSales
     * @param variantOptionThreeName
     * @param hasVariants
     * @param buttonOrder
     * @param tags
     * @param variantOptionOneValue
     * @param variantOptionThreeValue
     * @param taxRate
     * @param taxName
     * @param trackInventory
     * @param image
     * @param supplierCode
     * @param sku
     * @param updatedAt
     * @param variantOptionOneName
     * @param priceBookEntries
     * @param price
     * @param tax
     * @param taxId
     * @param inventory
     * @param variantOptionTwoValue
     * @param supplyPrice
     * @param variantParentId
     * @param active
     * @param baseName
     * @param images
     * @param taxes
     */
    public Productv1(String id, String sourceId, String variantSourceId, String handle, String type,
                     boolean hasVariants, String variantParentId, String variantOptionOneName,
                     String variantOptionOneValue, String variantOptionTwoName, String variantOptionTwoValue,
                     String variantOptionThreeName, String variantOptionThreeValue, boolean active, String name,
                     String baseName, String description, String image, String imageLarge, Object images, String sku,
                     String tags, String brandId, String brandName, String supplierName, String supplierCode,
                     String supplyPrice, String accountCodePurchase, String accountCodeSales, boolean trackInventory,
                     String buttonOrder, List<InventoryUpdate> inventory, double price,
                     double tax, String taxId, double taxRate, String taxName, Object taxes,
                     long displayRetailPriceTaxInclusive, String updatedAt, String deletedAt) {
        super();
        this.id = id;
        this.sourceId = sourceId;
        this.variantSourceId = variantSourceId;
        this.handle = handle;
        this.type = type;
        this.hasVariants = hasVariants;
        this.variantParentId = variantParentId;
        this.variantOptionOneName = variantOptionOneName;
        this.variantOptionOneValue = variantOptionOneValue;
        this.variantOptionTwoName = variantOptionTwoName;
        this.variantOptionTwoValue = variantOptionTwoValue;
        this.variantOptionThreeName = variantOptionThreeName;
        this.variantOptionThreeValue = variantOptionThreeValue;
        this.active = active;
        this.name = name;
        this.baseName = baseName;
        this.description = description;
        this.image = image;
        this.imageLarge = imageLarge;
        this.images = images;
        this.sku = sku;
        this.tags = tags;
        this.brandId = brandId;
        this.brandName = brandName;
        this.supplierName = supplierName;
        this.supplierCode = supplierCode;
        this.supplyPrice = supplyPrice;
        this.accountCodePurchase = accountCodePurchase;
        this.accountCodeSales = accountCodeSales;
        this.trackInventory = trackInventory;
        this.buttonOrder = buttonOrder;
        this.inventory = inventory;
        this.price = price;
        this.tax = tax;
        this.taxId = taxId;
        this.taxRate = taxRate;
        this.taxName = taxName;
        this.taxes = taxes;
        this.displayRetailPriceTaxInclusive = displayRetailPriceTaxInclusive;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getVariantSourceId() {
        return variantSourceId;
    }

    public void setVariantSourceId(String variantSourceId) {
        this.variantSourceId = variantSourceId;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasVariants() {
        return hasVariants;
    }

    public void setHasVariants(boolean hasVariants) {
        this.hasVariants = hasVariants;
    }

    public String getVariantParentId() {
        return variantParentId;
    }

    public void setVariantParentId(String variantParentId) {
        this.variantParentId = variantParentId;
    }

    public String getVariantOptionOneName() {
        return variantOptionOneName;
    }

    public void setVariantOptionOneName(String variantOptionOneName) {
        this.variantOptionOneName = variantOptionOneName;
    }

    public String getVariantOptionOneValue() {
        return variantOptionOneValue;
    }

    public void setVariantOptionOneValue(String variantOptionOneValue) {
        this.variantOptionOneValue = variantOptionOneValue;
    }

    public String getVariantOptionTwoName() {
        return variantOptionTwoName;
    }

    public void setVariantOptionTwoName(String variantOptionTwoName) {
        this.variantOptionTwoName = variantOptionTwoName;
    }

    public String getVariantOptionTwoValue() {
        return variantOptionTwoValue;
    }

    public void setVariantOptionTwoValue(String variantOptionTwoValue) {
        this.variantOptionTwoValue = variantOptionTwoValue;
    }

    public String getVariantOptionThreeName() {
        return variantOptionThreeName;
    }

    public void setVariantOptionThreeName(String variantOptionThreeName) {
        this.variantOptionThreeName = variantOptionThreeName;
    }

    public String getVariantOptionThreeValue() {
        return variantOptionThreeValue;
    }

    public void setVariantOptionThreeValue(String variantOptionThreeValue) {
        this.variantOptionThreeValue = variantOptionThreeValue;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(String imageLarge) {
        this.imageLarge = imageLarge;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(String supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public String getAccountCodePurchase() {
        return accountCodePurchase;
    }

    public void setAccountCodePurchase(String accountCodePurchase) {
        this.accountCodePurchase = accountCodePurchase;
    }

    public String getAccountCodeSales() {
        return accountCodeSales;
    }

    public void setAccountCodeSales(String accountCodeSales) {
        this.accountCodeSales = accountCodeSales;
    }

    public boolean isTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(boolean trackInventory) {
        this.trackInventory = trackInventory;
    }

    public String getButtonOrder() {
        return buttonOrder;
    }

    public void setButtonOrder(String buttonOrder) {
        this.buttonOrder = buttonOrder;
    }

    public List<InventoryUpdate> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryUpdate> inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Object getTaxes() {
        return taxes;
    }

    public void setTaxes(Object taxes) {
        this.taxes = taxes;
    }

    public long getDisplayRetailPriceTaxInclusive() {
        return displayRetailPriceTaxInclusive;
    }

    public void setDisplayRetailPriceTaxInclusive(long displayRetailPriceTaxInclusive) {
        this.displayRetailPriceTaxInclusive = displayRetailPriceTaxInclusive;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

}
