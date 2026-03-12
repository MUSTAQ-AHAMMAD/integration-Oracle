package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductAttributePost implements Serializable {

    @SerializedName("attribute_id")
    @Expose
    private String attributeId;
    @SerializedName("product_attribute_description")
    @Expose
    private List<ProductAttributeDescriptionPost> productAttributeDescription = null;
    private final static long serialVersionUID = 8708943382043611006L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductAttributePost() {
    }

    /**
     *
     * @param attributeId
     * @param productAttributeDescription
     */
    public ProductAttributePost(String attributeId, List<ProductAttributeDescriptionPost> productAttributeDescription) {
        super();
        this.attributeId = attributeId;
        this.productAttributeDescription = productAttributeDescription;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public ProductAttributePost withAttributeId(String attributeId) {
        this.attributeId = attributeId;
        return this;
    }

    public List<ProductAttributeDescriptionPost> getProductAttributeDescription() {
        return productAttributeDescription;
    }

    public void setProductAttributeDescription(List<ProductAttributeDescriptionPost> productAttributeDescription) {
        this.productAttributeDescription = productAttributeDescription;
    }

    public ProductAttributePost withProductAttributeDescription(List<ProductAttributeDescriptionPost> productAttributeDescription) {
        this.productAttributeDescription = productAttributeDescription;
        return this;
    }

}
