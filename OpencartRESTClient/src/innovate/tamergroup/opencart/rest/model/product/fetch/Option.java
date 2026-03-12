package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("option_value")
    @Expose
    private List<OptionValue> optionValue = null;
    @SerializedName("required")
    @Expose
    private long required;
    @SerializedName("product_option_id")
    @Expose
    private long productOptionId;
    @SerializedName("option_id")
    @Expose
    private long optionId;
    private final static long serialVersionUID = -6199342553594849585L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Option() {
    }

    /**
     *
     * @param optionId
     * @param productOptionId
     * @param name
     * @param required
     * @param type
     * @param optionValue
     */
    public Option(String name, String type, List<OptionValue> optionValue, long required, long productOptionId,
                  long optionId) {
        super();
        this.name = name;
        this.type = type;
        this.optionValue = optionValue;
        this.required = required;
        this.productOptionId = productOptionId;
        this.optionId = optionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OptionValue> getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(List<OptionValue> optionValue) {
        this.optionValue = optionValue;
    }

    public long getRequired() {
        return required;
    }

    public void setRequired(long required) {
        this.required = required;
    }

    public long getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(long productOptionId) {
        this.productOptionId = productOptionId;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

}
