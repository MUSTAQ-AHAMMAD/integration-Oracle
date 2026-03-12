package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductOptionValuePost implements Serializable {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("price_prefix")
    @Expose
    private String pricePrefix;
    @SerializedName("subtract")
    @Expose
    private String subtract;
    @SerializedName("points")
    @Expose
    private String points;
    @SerializedName("points_prefix")
    @Expose
    private String pointsPrefix;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("weight_prefix")
    @Expose
    private String weightPrefix;
    @SerializedName("option_value_id")
    @Expose
    private String optionValueId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    private final static long serialVersionUID = 3647451750964107420L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductOptionValuePost() {
    }

    /**
     *
     * @param subtract
     * @param optionValueId
     * @param weight
     * @param pricePrefix
     * @param price
     * @param weightPrefix
     * @param quantity
     * @param points
     * @param pointsPrefix
     */
    public ProductOptionValuePost(String price, String pricePrefix, String subtract, String points, String pointsPrefix,
                              String weight, String weightPrefix, String optionValueId, String quantity) {
        super();
        this.price = price;
        this.pricePrefix = pricePrefix;
        this.subtract = subtract;
        this.points = points;
        this.pointsPrefix = pointsPrefix;
        this.weight = weight;
        this.weightPrefix = weightPrefix;
        this.optionValueId = optionValueId;
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductOptionValuePost withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getPricePrefix() {
        return pricePrefix;
    }

    public void setPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
    }

    public ProductOptionValuePost withPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
        return this;
    }

    public String getSubtract() {
        return subtract;
    }

    public void setSubtract(String subtract) {
        this.subtract = subtract;
    }

    public ProductOptionValuePost withSubtract(String subtract) {
        this.subtract = subtract;
        return this;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public ProductOptionValuePost withPoints(String points) {
        this.points = points;
        return this;
    }

    public String getPointsPrefix() {
        return pointsPrefix;
    }

    public void setPointsPrefix(String pointsPrefix) {
        this.pointsPrefix = pointsPrefix;
    }

    public ProductOptionValuePost withPointsPrefix(String pointsPrefix) {
        this.pointsPrefix = pointsPrefix;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public ProductOptionValuePost withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getWeightPrefix() {
        return weightPrefix;
    }

    public void setWeightPrefix(String weightPrefix) {
        this.weightPrefix = weightPrefix;
    }

    public ProductOptionValuePost withWeightPrefix(String weightPrefix) {
        this.weightPrefix = weightPrefix;
        return this;
    }

    public String getOptionValueId() {
        return optionValueId;
    }

    public void setOptionValueId(String optionValueId) {
        this.optionValueId = optionValueId;
    }

    public ProductOptionValuePost withOptionValueId(String optionValueId) {
        this.optionValueId = optionValueId;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductOptionValuePost withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

}
