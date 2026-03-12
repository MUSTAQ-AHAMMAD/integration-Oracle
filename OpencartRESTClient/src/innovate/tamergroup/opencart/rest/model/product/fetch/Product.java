package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Product implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("original_image")
    @Expose
    private String originalImage;
    @SerializedName("original_images")
    @Expose
    private List<String> originalImages = null;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("tax_value")
    @Expose
    private Double taxValue;
    @SerializedName("price_formated")
    @Expose
    private String priceFormated;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("product_description")
    @Expose
    private List<ProductDescription> productDescription = null;
    @SerializedName("product_attributes")
    @Expose
    private List<Object> productAttributes = null;
    @SerializedName("stores")
    @Expose
    private List<Long> stores = null;
    @SerializedName("special")
    @Expose
    private List<Special> special = null;
    @SerializedName("discounts")
    @Expose
    private List<Object> discounts = null;
    @SerializedName("options")
    @Expose
    private List<Option> options = null;
    @SerializedName("minimum")
    @Expose
    private Long minimum;
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
    @SerializedName("stock_status")
    @Expose
    private String stockStatus;
    @SerializedName("manufacturer_id")
    @Expose
    private String manufacturerId;
    @SerializedName("tax_class_id")
    @Expose
    private Long taxClassId;
    @SerializedName("date_available")
    @Expose
    private Date dateAvailable;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("weight_class_id")
    @Expose
    private Long weightClassId;
    @SerializedName("length")
    @Expose
    private Double length;
    @SerializedName("width")
    @Expose
    private Double width;
    @SerializedName("height")
    @Expose
    private Double height;
    @SerializedName("length_class_id")
    @Expose
    private Long lengthClassId;
    @SerializedName("subtract")
    @Expose
    private Long subtract;
    @SerializedName("sort_order")
    @Expose
    private Long sortOrder;
    @SerializedName("status")
    @Expose
    private Long status;
    @SerializedName("stock_status_id")
    @Expose
    private Long stockStatusId;
    @SerializedName("date_added")
    @Expose
    private Date dateAdded;
    @SerializedName("date_modified")
    @Expose
    private Date dateModified;
    @SerializedName("viewed")
    @Expose
    private Long viewed;
    @SerializedName("weight_class")
    @Expose
    private String weightClass;
    @SerializedName("length_class")
    @Expose
    private String lengthClass;
    @SerializedName("reward")
    @Expose
    private String reward;
    @SerializedName("points")
    @Expose
    private Double points;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("shipping")
    @Expose
    private Long shipping;
    @SerializedName("category")
    @Expose
    private List<List<Category>> category = null;
    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("reviews")
    @Expose
    private Reviews reviews;
    @SerializedName("product_relateds")
    @Expose
    private List<Object> productRelateds = null;
    @SerializedName("filters")
    @Expose
    private List<Object> filters = null;
    @SerializedName("currency_id")
    @Expose
    private Long currencyId;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("currency_value")
    @Expose
    private String currencyValue;
    private final static long serialVersionUID = 2617003956751329976L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }


    /**
     *
     * @param weightClassId
     * @param dateModified
     * @param manufacturerId
     * @param productRelateds
     * @param productDescription
     * @param location
     * @param mpn
     * @param originalImages
     * @param lengthClass
     * @param shipping
     * @param height
     * @param quantity
     * @param jan
     * @param points
     * @param reviews
     * @param stockStatusId
     * @param lengthClassId
     * @param reward
     * @param status
     * @param sortOrder
     * @param taxClassId
     * @param width
     * @param image
     * @param taxValue
     * @param sku
     * @param ean
     * @param category
     * @param price
     * @param weightClass
     * @param manufacturer
     * @param images
     * @param dateAvailable
     * @param filters
     * @param model
     * @param weight
     * @param minimum
     * @param currencyId
     * @param dateAdded
     * @param productAttributes
     * @param id
     * @param originalImage
     * @param isbn
     * @param discounts
     * @param length
     * @param priceFormated
     * @param options
     * @param currencyCode
     * @param keyword
     * @param viewed
     * @param currencyValue
     * @param upc
     * @param subtract
     * @param stockStatus
     * @param special
     * @param rating
     * @param stores
     */
    public Product(long id, String manufacturer, String sku, String model, String image, List<String> images,
                   String originalImage, List<String> originalImages, Double price, Double taxValue,
                   String priceFormated, Double rating, List<ProductDescription> productDescription,
                   List<Object> productAttributes, List<Long> stores, List<Special> special, List<Object> discounts,
                   List<Option> options, Long minimum, String upc, String ean, String jan, String isbn, String mpn,
                   String location, String stockStatus, String manufacturerId, Long taxClassId, Date dateAvailable,
                   Double weight, Long weightClassId, Double length, Double width, Double height, Long lengthClassId,
                   Long subtract, Long sortOrder, Long status, Long stockStatusId, Date dateAdded, Date dateModified,
                   Long viewed, String weightClass, String lengthClass, String reward, Double points, String keyword,
                   Long shipping, List<List<Category>> category, Long quantity, Reviews reviews,
                   List<Object> productRelateds, List<Object> filters, Long currencyId, String currencyCode,
                   String currencyValue) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.sku = sku;
        this.model = model;
        this.image = image;
        this.images = images;
        this.originalImage = originalImage;
        this.originalImages = originalImages;
        this.price = price;
        this.taxValue = taxValue;
        this.priceFormated = priceFormated;
        this.rating = rating;
        this.productDescription = productDescription;
        this.productAttributes = productAttributes;
        this.stores = stores;
        this.special = special;
        this.discounts = discounts;
        this.options = options;
        this.minimum = minimum;
        this.upc = upc;
        this.ean = ean;
        this.jan = jan;
        this.isbn = isbn;
        this.mpn = mpn;
        this.location = location;
        this.stockStatus = stockStatus;
        this.manufacturerId = manufacturerId;
        this.taxClassId = taxClassId;
        this.dateAvailable = dateAvailable;
        this.weight = weight;
        this.weightClassId = weightClassId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.lengthClassId = lengthClassId;
        this.subtract = subtract;
        this.sortOrder = sortOrder;
        this.status = status;
        this.stockStatusId = stockStatusId;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.viewed = viewed;
        this.weightClass = weightClass;
        this.lengthClass = lengthClass;
        this.reward = reward;
        this.points = points;
        this.keyword = keyword;
        this.shipping = shipping;
        this.category = category;
        this.quantity = quantity;
        this.reviews = reviews;
        this.productRelateds = productRelateds;
        this.filters = filters;
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyValue = currencyValue;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setOriginalImage(String originalImage) {
        this.originalImage = originalImage;
    }

    public String getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImages(List<String> originalImages) {
        this.originalImages = originalImages;
    }

    public List<String> getOriginalImages() {
        return originalImages;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public void setPriceFormated(String priceFormated) {
        this.priceFormated = priceFormated;
    }

    public String getPriceFormated() {
        return priceFormated;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setProductDescription(List<ProductDescription> productDescription) {
        this.productDescription = productDescription;
    }

    public List<ProductDescription> getProductDescription() {
        return productDescription;
    }

    public void setProductAttributes(List<Object> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public List<Object> getProductAttributes() {
        return productAttributes;
    }

    public void setStores(List<Long> stores) {
        this.stores = stores;
    }

    public List<Long> getStores() {
        return stores;
    }

    public void setSpecial(List<Special> special) {
        this.special = special;
    }

    public List<Special> getSpecial() {
        return special;
    }

    public void setDiscounts(List<Object> discounts) {
        this.discounts = discounts;
    }

    public List<Object> getDiscounts() {
        return discounts;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setMinimum(Long minimum) {
        this.minimum = minimum;
    }

    public Long getMinimum() {
        return minimum;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getUpc() {
        return upc;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getEan() {
        return ean;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public String getJan() {
        return jan;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public String getMpn() {
        return mpn;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setTaxClassId(Long taxClassId) {
        this.taxClassId = taxClassId;
    }

    public Long getTaxClassId() {
        return taxClassId;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeightClassId(Long weightClassId) {
        this.weightClassId = weightClassId;
    }

    public Long getWeightClassId() {
        return weightClassId;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getLength() {
        return length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public void setLengthClassId(Long lengthClassId) {
        this.lengthClassId = lengthClassId;
    }

    public Long getLengthClassId() {
        return lengthClassId;
    }

    public void setSubtract(Long subtract) {
        this.subtract = subtract;
    }

    public Long getSubtract() {
        return subtract;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setStockStatusId(Long stockStatusId) {
        this.stockStatusId = stockStatusId;
    }

    public Long getStockStatusId() {
        return stockStatusId;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setViewed(Long viewed) {
        this.viewed = viewed;
    }

    public Long getViewed() {
        return viewed;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setLengthClass(String lengthClass) {
        this.lengthClass = lengthClass;
    }

    public String getLengthClass() {
        return lengthClass;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Double getPoints() {
        return points;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setShipping(Long shipping) {
        this.shipping = shipping;
    }

    public Long getShipping() {
        return shipping;
    }

    public void setCategory(List<List<Category>> category) {
        this.category = category;
    }

    public List<List<Category>> getCategory() {
        return category;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setProductRelateds(List<Object> productRelateds) {
        this.productRelateds = productRelateds;
    }

    public List<Object> getProductRelateds() {
        return productRelateds;
    }

    public void setFilters(List<Object> filters) {
        this.filters = filters;
    }

    public List<Object> getFilters() {
        return filters;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

}
