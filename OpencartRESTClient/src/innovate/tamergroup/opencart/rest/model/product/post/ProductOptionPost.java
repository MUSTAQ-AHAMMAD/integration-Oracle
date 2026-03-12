package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductOptionPost implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("option_id")
    @Expose
    private String optionId;
    @SerializedName("required")
    @Expose
    private String required;
    @SerializedName("product_option_value")
    @Expose
    private List<ProductOptionValuePost> productOptionValue = null;
    private final static long serialVersionUID = 5601846115144266763L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductOptionPost() {
    }

    /**
     *
     * @param optionId
     * @param required
     * @param type
     * @param productOptionValue
     */
    public ProductOptionPost(String type, String optionId, String required, List<ProductOptionValuePost> productOptionValue) {
        super();
        this.type = type;
        this.optionId = optionId;
        this.required = required;
        this.productOptionValue = productOptionValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductOptionPost withType(String type) {
        this.type = type;
        return this;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public ProductOptionPost withOptionId(String optionId) {
        this.optionId = optionId;
        return this;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public ProductOptionPost withRequired(String required) {
        this.required = required;
        return this;
    }

    public List<ProductOptionValuePost> getProductOptionValue() {
        return productOptionValue;
    }

    public void setProductOptionValue(List<ProductOptionValuePost> productOptionValue) {
        this.productOptionValue = productOptionValue;
    }

    public ProductOptionPost withProductOptionValue(List<ProductOptionValuePost> productOptionValue) {
        this.productOptionValue = productOptionValue;
        return this;
    }

}
