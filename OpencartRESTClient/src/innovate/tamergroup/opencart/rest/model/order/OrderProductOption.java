package innovate.tamergroup.opencart.rest.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderProductOption implements Serializable {
    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("option_id")
    @Expose
    private Long optionId;
    @SerializedName("option_value_id")
    @Expose
    private Long optionValueId;
    @SerializedName("product_option_id")
    @Expose
    private Long productOptionId;
    @SerializedName("product_option_value_id")
    @Expose
    private Long productOptionValueId;
    private final static long serialVersionUID = -6199342553594849585L;


    public OrderProductOption(String name, String type, String value, String sku, long optionId, long optionValueId,
                              long productOptionId, long productOptionValueId) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.sku = sku;
        this.optionId = optionId;
        this.optionValueId = optionValueId;
        this.productOptionId = productOptionId;
        this.productOptionValueId = productOptionValueId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionValueId(long optionValueId) {
        this.optionValueId = optionValueId;
    }

    public long getOptionValueId() {
        return optionValueId;
    }

    public void setProductOptionId(long productOptionId) {
        this.productOptionId = productOptionId;
    }

    public long getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionValueId(long productOptionValueId) {
        this.productOptionValueId = productOptionValueId;
    }

    public long getProductOptionValueId() {
        return productOptionValueId;
    }
}
