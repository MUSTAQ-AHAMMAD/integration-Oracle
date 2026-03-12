package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionValue implements Serializable {

    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("price_formated")
    @Expose
    private String priceFormated;
    @SerializedName("price_prefix")
    @Expose
    private String pricePrefix;
    @SerializedName("product_option_value_id")
    @Expose
    private long productOptionValueId;
    @SerializedName("option_value_id")
    @Expose
    private long optionValueId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("quantity")
    @Expose
    private long quantity;
    @SerializedName("subtract")
    @Expose
    private long subtract;
    @SerializedName("points")
    @Expose
    private long points;
    @SerializedName("points_prefix")
    @Expose
    private String pointsPrefix;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("weight_prefix")
    @Expose
    private String weightPrefix;
    @SerializedName("sku")
    @Expose
    private String sku;
    private final static long serialVersionUID = 2209943944842847085L;

    /**
     * No args constructor for use in serialization
     *
     */
    public OptionValue() {
    }

    /**
     *
     * @param pricePrefix
     * @param weight
     * @param weightPrefix
     * @param image
     * @param sku
     * @param pointsPrefix
     * @param subtract
     * @param price
     * @param optionValueId
     * @param name
     * @param productOptionValueId
     * @param quantity
     * @param priceFormated
     * @param points
     */
    public OptionValue(Object image, double price, String priceFormated, String pricePrefix, long productOptionValueId,
                       long optionValueId, String name, long quantity, long subtract, long points, String pointsPrefix,
                       String weight, String weightPrefix, String sku) {
        super();
        this.image = image;
        this.price = price;
        this.priceFormated = priceFormated;
        this.pricePrefix = pricePrefix;
        this.productOptionValueId = productOptionValueId;
        this.optionValueId = optionValueId;
        this.name = name;
        this.quantity = quantity;
        this.subtract = subtract;
        this.points = points;
        this.pointsPrefix = pointsPrefix;
        this.weight = weight;
        this.weightPrefix = weightPrefix;
        this.sku = sku;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceFormated() {
        return priceFormated;
    }

    public void setPriceFormated(String priceFormated) {
        this.priceFormated = priceFormated;
    }

    public String getPricePrefix() {
        return pricePrefix;
    }

    public void setPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
    }

    public long getProductOptionValueId() {
        return productOptionValueId;
    }

    public void setProductOptionValueId(long productOptionValueId) {
        this.productOptionValueId = productOptionValueId;
    }

    public long getOptionValueId() {
        return optionValueId;
    }

    public void setOptionValueId(long optionValueId) {
        this.optionValueId = optionValueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSubtract() {
        return subtract;
    }

    public void setSubtract(long subtract) {
        this.subtract = subtract;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getPointsPrefix() {
        return pointsPrefix;
    }

    public void setPointsPrefix(String pointsPrefix) {
        this.pointsPrefix = pointsPrefix;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightPrefix() {
        return weightPrefix;
    }

    public void setWeightPrefix(String weightPrefix) {
        this.weightPrefix = weightPrefix;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
