package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductPost implements Serializable {

    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("tax_class_id")
    @Expose
    private String taxClassId;
    @SerializedName("manufacturer_id")
    @Expose
    private String manufacturerId;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("points")
    @Expose
    private Long points;
    @SerializedName("reward")
    @Expose
    private Long reward;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("other_images")
    @Expose
    private List<String> otherImages = null;
    @SerializedName("shipping")
    @Expose
    private String shipping;
    @SerializedName("stock_status_id")
    @Expose
    private Long stockStatusId;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("jan")
    @Expose
    private String jan;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("mpn")
    @Expose
    private String mpn;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("date_available")
    @Expose
    private String dateAvailable;
    @SerializedName("weight")
    @Expose
    private Long weight;
    @SerializedName("weight_class_id")
    @Expose
    private Long weightClassId;
    @SerializedName("length")
    @Expose
    private Long length;
    @SerializedName("width")
    @Expose
    private Long width;
    @SerializedName("height")
    @Expose
    private Long height;
    @SerializedName("length_class_id")
    @Expose
    private Long lengthClassId;
    @SerializedName("subtract")
    @Expose
    private Long subtract;
    @SerializedName("minimum")
    @Expose
    private Long minimum;
    @SerializedName("sort_order")
    @Expose
    private String sortOrder;
    @SerializedName("product_store")
    @Expose
    private List<String> productStore = null;
    @SerializedName("product_related")
    @Expose
    private List<String> productRelated = null;
    @SerializedName("product_filter")
    @Expose
    private List<String> productFilter = null;
    @SerializedName("product_description")
    @Expose
    private List<ProductDescriptionPost> productDescription = null;
    @SerializedName("product_category")
    @Expose
    private List<String> productCategory = null;
    @SerializedName("product_special")
    @Expose
    private List<ProductSpecialPost> productSpecial = null;
    @SerializedName("product_discount")
    @Expose
    private List<ProductDiscountPost> productDiscount = null;
    @SerializedName("product_attribute")
    @Expose
    private List<ProductAttributePost> productAttribute = null;
    @SerializedName("product_option")
    @Expose
    private List<ProductOptionPost> productOption = null;
    private final static long serialVersionUID = -6294428663870329529L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductPost() {
    }

    /**
     *
     * @param weightClassId
     * @param productSpecial
     * @param model
     * @param weight
     * @param manufacturerId
     * @param productDescription
     * @param minimum
     * @param location
     * @param productCategory
     * @param productDiscount
     * @param mpn
     * @param productAttribute
     * @param shipping
     * @param height
     * @param isbn
     * @param length
     * @param productStore
     * @param quantity
     * @param jan
     * @param points
     * @param productFilter
     * @param productOption
     * @param stockStatusId
     * @param lengthClassId
     * @param reward
     * @param status
     * @param sortOrder
     * @param width
     * @param keyword
     * @param taxClassId
     * @param image
     * @param otherImages
     * @param sku
     * @param upc
     * @param productRelated
     * @param ean
     * @param subtract
     * @param price
     * @param dateAvailable
     */
    public ProductPost(String model, String quantity, String price, String taxClassId, String manufacturerId, String sku,
                   String keyword, String status, Long points, Long reward, String image, List<String> otherImages,
                   String shipping, Long stockStatusId, String upc, String ean, String jan, String isbn, String mpn,
                   String location, String dateAvailable, Long weight, Long weightClassId, Long length, Long width,
                   Long height, Long lengthClassId, Long subtract, Long minimum, String sortOrder,
                   List<String> productStore, List<String> productRelated, List<String> productFilter,
                   List<ProductDescriptionPost> productDescription, List<String> productCategory,
                   List<ProductSpecialPost> productSpecial, List<ProductDiscountPost> productDiscount,
                   List<ProductAttributePost> productAttribute, List<ProductOptionPost> productOption) {
        super();
        this.model = model;
        this.quantity = quantity;
        this.price = price;
        this.taxClassId = taxClassId;
        this.manufacturerId = manufacturerId;
        this.sku = sku;
        this.keyword = keyword;
        this.status = status;
        this.points = points;
        this.reward = reward;
        this.image = image;
        this.otherImages = otherImages;
        this.shipping = shipping;
        this.stockStatusId = stockStatusId;
        this.upc = upc;
        this.ean = ean;
        this.jan = jan;
        this.isbn = isbn;
        this.mpn = mpn;
        this.location = location;
        this.dateAvailable = dateAvailable;
        this.weight = weight;
        this.weightClassId = weightClassId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.lengthClassId = lengthClassId;
        this.subtract = subtract;
        this.minimum = minimum;
        this.sortOrder = sortOrder;
        this.productStore = productStore;
        this.productRelated = productRelated;
        this.productFilter = productFilter;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productSpecial = productSpecial;
        this.productDiscount = productDiscount;
        this.productAttribute = productAttribute;
        this.productOption = productOption;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ProductPost withModel(String model) {
        this.model = model;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductPost withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductPost withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(String taxClassId) {
        this.taxClassId = taxClassId;
    }

    public ProductPost withTaxClassId(String taxClassId) {
        this.taxClassId = taxClassId;
        return this;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public ProductPost withManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public ProductPost withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public ProductPost withKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductPost withStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public ProductPost withPoints(Long points) {
        this.points = points;
        return this;
    }

    public Long getReward() {
        return reward;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    public ProductPost withReward(Long reward) {
        this.reward = reward;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductPost withImage(String image) {
        this.image = image;
        return this;
    }

    public List<String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }

    public ProductPost withOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
        return this;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public ProductPost withShipping(String shipping) {
        this.shipping = shipping;
        return this;
    }

    public Long getStockStatusId() {
        return stockStatusId;
    }

    public void setStockStatusId(Long stockStatusId) {
        this.stockStatusId = stockStatusId;
    }

    public ProductPost withStockStatusId(Long stockStatusId) {
        this.stockStatusId = stockStatusId;
        return this;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public ProductPost withUpc(String upc) {
        this.upc = upc;
        return this;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public ProductPost withEan(String ean) {
        this.ean = ean;
        return this;
    }

    public String getJan() {
        return jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public ProductPost withJan(String jan) {
        this.jan = jan;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ProductPost withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public ProductPost withMpn(String mpn) {
        this.mpn = mpn;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ProductPost withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public ProductPost withDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
        return this;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public ProductPost withWeight(Long weight) {
        this.weight = weight;
        return this;
    }

    public Long getWeightClassId() {
        return weightClassId;
    }

    public void setWeightClassId(Long weightClassId) {
        this.weightClassId = weightClassId;
    }

    public ProductPost withWeightClassId(Long weightClassId) {
        this.weightClassId = weightClassId;
        return this;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public ProductPost withLength(Long length) {
        this.length = length;
        return this;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public ProductPost withWidth(Long width) {
        this.width = width;
        return this;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public ProductPost withHeight(Long height) {
        this.height = height;
        return this;
    }

    public Long getLengthClassId() {
        return lengthClassId;
    }

    public void setLengthClassId(Long lengthClassId) {
        this.lengthClassId = lengthClassId;
    }

    public ProductPost withLengthClassId(Long lengthClassId) {
        this.lengthClassId = lengthClassId;
        return this;
    }

    public Long getSubtract() {
        return subtract;
    }

    public void setSubtract(Long subtract) {
        this.subtract = subtract;
    }

    public ProductPost withSubtract(Long subtract) {
        this.subtract = subtract;
        return this;
    }

    public Long getMinimum() {
        return minimum;
    }

    public void setMinimum(Long minimum) {
        this.minimum = minimum;
    }

    public ProductPost withMinimum(Long minimum) {
        this.minimum = minimum;
        return this;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public ProductPost withSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public List<String> getProductStore() {
        return productStore;
    }

    public void setProductStore(List<String> productStore) {
        this.productStore = productStore;
    }

    public ProductPost withProductStore(List<String> productStore) {
        this.productStore = productStore;
        return this;
    }

    public List<String> getProductRelated() {
        return productRelated;
    }

    public void setProductRelated(List<String> productRelated) {
        this.productRelated = productRelated;
    }

    public ProductPost withProductRelated(List<String> productRelated) {
        this.productRelated = productRelated;
        return this;
    }

    public List<String> getProductFilter() {
        return productFilter;
    }

    public void setProductFilter(List<String> productFilter) {
        this.productFilter = productFilter;
    }

    public ProductPost withProductFilter(List<String> productFilter) {
        this.productFilter = productFilter;
        return this;
    }

    public List<ProductDescriptionPost> getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(List<ProductDescriptionPost> productDescription) {
        this.productDescription = productDescription;
    }

    public ProductPost withProductDescription(List<ProductDescriptionPost> productDescription) {
        this.productDescription = productDescription;
        return this;
    }

    public List<String> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(List<String> productCategory) {
        this.productCategory = productCategory;
    }

    public ProductPost withProductCategory(List<String> productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public List<ProductSpecialPost> getProductSpecial() {
        return productSpecial;
    }

    public void setProductSpecial(List<ProductSpecialPost> productSpecial) {
        this.productSpecial = productSpecial;
    }

    public ProductPost withProductSpecial(List<ProductSpecialPost> productSpecial) {
        this.productSpecial = productSpecial;
        return this;
    }

    public List<ProductDiscountPost> getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(List<ProductDiscountPost> productDiscount) {
        this.productDiscount = productDiscount;
    }

    public ProductPost withProductDiscount(List<ProductDiscountPost> productDiscount) {
        this.productDiscount = productDiscount;
        return this;
    }

    public List<ProductAttributePost> getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(List<ProductAttributePost> productAttribute) {
        this.productAttribute = productAttribute;
    }

    public ProductPost withProductAttribute(List<ProductAttributePost> productAttribute) {
        this.productAttribute = productAttribute;
        return this;
    }

    public List<ProductOptionPost> getProductOption() {
        return productOption;
    }

    public void setProductOption(List<ProductOptionPost> productOption) {
        this.productOption = productOption;
    }

    public ProductPost withProductOption(List<ProductOptionPost> productOption) {
        this.productOption = productOption;
        return this;
    }

}
