package innovate.tamergroup.vendhq.model.products;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("source_id")
    @Expose
    private String sourceId;
    @SerializedName("source_variant_id")
    @Expose
    private String sourceVariantId;
    @SerializedName("variant_parent_id")
    @Expose
    private String variantParentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("variant_name")
    @Expose
    private String variantName;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("supplier_code")
    @Expose
    private String supplierCode;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("has_inventory")
    @Expose
    private Boolean hasInventory;
    @SerializedName("is_composite")
    @Expose
    private Boolean isComposite;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose
    private Date updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("account_code")
    @Expose
    private String accountCode;
    @SerializedName("account_code_purchase")
    @Expose
    private String accountCodePurchase;
    @SerializedName("supply_price")
    @Expose
    private Double supplyPrice;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("supplier")
    @Expose
    private String supplier;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("variant_options")
    @Expose
    private List<VariantOption> variantOptions = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("has_variants")
    @Expose
    private Boolean hasVariants;
    @SerializedName("variant_count")
    @Expose
    private String variantCount;
    @SerializedName("button_order")
    @Expose
    private Integer buttonOrder;
    @SerializedName("price_including_tax")
    @Expose
    private Double priceIncludingTax;
    @SerializedName("price_excluding_tax")
    @Expose
    private Double priceExcludingTax;
    @SerializedName("loyalty_amount")
    @Expose
    private String loyaltyAmount;
    @SerializedName("supplier_id")
    @Expose
    private String supplierId;
    @SerializedName("product_type_id")
    @Expose
    private String productTypeId;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("image_thumbnail_url")
    @Expose
    private String imageThumbnailUrl;
    @SerializedName("tag_ids")
    @Expose
    private List<String> tagIds = null;
    @SerializedName("attributes")
    @Expose
    private List<String> attributes = null;
    
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
    
    public String getSourceVariantId() {
    return sourceVariantId;
    }
    
    public void setSourceVariantId(String sourceVariantId) {
    this.sourceVariantId = sourceVariantId;
    }
    
    public String getVariantParentId() {
    return variantParentId;
    }
    
    public void setVariantParentId(String variantParentId) {
    this.variantParentId = variantParentId;
    }
    
    public String getName() {
    return name;
    }
    
    public void setName(String name) {
    this.name = name;
    }
    
    public String getVariantName() {
    return variantName;
    }
    
    public void setVariantName(String variantName) {
    this.variantName = variantName;
    }
    
    public String getHandle() {
    return handle;
    }
    
    public void setHandle(String handle) {
    this.handle = handle;
    }
    
    public String getSku() {
    return sku;
    }
    
    public void setSku(String sku) {
    this.sku = sku;
    }
    
    public String getSupplierCode() {
    return supplierCode;
    }
    
    public void setSupplierCode(String supplierCode) {
    this.supplierCode = supplierCode;
    }
    
    public Boolean getActive() {
    return active;
    }
    
    public void setActive(Boolean active) {
    this.active = active;
    }
    
    public Boolean getHasInventory() {
    return hasInventory;
    }
    
    public void setHasInventory(Boolean hasInventory) {
    this.hasInventory = hasInventory;
    }
    
    public Boolean getIsComposite() {
    return isComposite;
    }
    
    public void setIsComposite(Boolean isComposite) {
    this.isComposite = isComposite;
    }
    
    public String getDescription() {
    return description;
    }
    
    public void setDescription(String description) {
    this.description = description;
    }
    
    public String getImageUrl() {
    return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    }
    
    public Date getCreatedAt() {
    return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
    return updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    }
    
    public Date getDeletedAt() {
    return deletedAt;
    }
    
    public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
    }
    
    public String getSource() {
    return source;
    }
    
    public void setSource(String source) {
    this.source = source;
    }
    
    public String getAccountCode() {
    return accountCode;
    }
    
    public void setAccountCode(String accountCode) {
    this.accountCode = accountCode;
    }
    
    public String getAccountCodePurchase() {
    return accountCodePurchase;
    }
    
    public void setAccountCodePurchase(String accountCodePurchase) {
    this.accountCodePurchase = accountCodePurchase;
    }
    
    public Double getSupplyPrice() {
    return supplyPrice;
    }
    
    public void setSupplyPrice(Double supplyPrice) {
    this.supplyPrice = supplyPrice;
    }
    
    public Long getVersion() {
    return version;
    }
    
    public void setVersion(Long version) {
    this.version = version;
    }
    
    public Type getType() {
    return type;
    }
    
    public void setType(Type type) {
    this.type = type;
    }
    
    public String getSupplier() {
    return supplier;
    }
    
    public void setSupplier(String supplier) {
    this.supplier = supplier;
    }
    
    public Brand getBrand() {
    return brand;
    }
    
    public void setBrand(Brand brand) {
    this.brand = brand;
    }
    
    public List<VariantOption> getVariantOptions() {
    return variantOptions;
    }
    
    public void setVariantOptions(List<VariantOption> variantOptions) {
    this.variantOptions = variantOptions;
    }
    
    public List<Category> getCategories() {
    return categories;
    }
    
    public void setCategories(List<Category> categories) {
    this.categories = categories;
    }
    
    public List<Image> getImages() {
    return images;
    }
    
    public void setImages(List<Image> images) {
    this.images = images;
    }
    
    public Boolean getHasVariants() {
    return hasVariants;
    }
    
    public void setHasVariants(Boolean hasVariants) {
    this.hasVariants = hasVariants;
    }
    
    public String getVariantCount() {
    return variantCount;
    }
    
    public void setVariantCount(String variantCount) {
    this.variantCount = variantCount;
    }
    
    public Integer getButtonOrder() {
    return buttonOrder;
    }
    
    public void setButtonOrder(Integer buttonOrder) {
    this.buttonOrder = buttonOrder;
    }
    
    public Double getPriceIncludingTax() {
    return priceIncludingTax;
    }
    
    public void setPriceIncludingTax(Double priceIncludingTax) {
    this.priceIncludingTax = priceIncludingTax;
    }
    
    public Double getPriceExcludingTax() {
    return priceExcludingTax;
    }
    
    public void setPriceExcludingTax(Double priceExcludingTax) {
    this.priceExcludingTax = priceExcludingTax;
    }
    
    public String getLoyaltyAmount() {
    return loyaltyAmount;
    }
    
    public void setLoyaltyAmount(String loyaltyAmount) {
    this.loyaltyAmount = loyaltyAmount;
    }
    
    public String getSupplierId() {
    return supplierId;
    }
    
    public void setSupplierId(String supplierId) {
    this.supplierId = supplierId;
    }
    
    public String getProductTypeId() {
    return productTypeId;
    }
    
    public void setProductTypeId(String productTypeId) {
    this.productTypeId = productTypeId;
    }
    
    public String getBrandId() {
    return brandId;
    }
    
    public void setBrandId(String brandId) {
    this.brandId = brandId;
    }
    
    public Boolean getIsActive() {
    return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
    }
    
    public String getImageThumbnailUrl() {
    return imageThumbnailUrl;
    }
    
    public void setImageThumbnailUrl(String imageThumbnailUrl) {
    this.imageThumbnailUrl = imageThumbnailUrl;
    }
    
    public List<String> getTagIds() {
    return tagIds;
    }
    
    public void setTagIds(List<String> tagIds) {
    this.tagIds = tagIds;
    }
    
    public List<String> getAttributes() {
    return attributes;
    }
    
    public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
    }

}