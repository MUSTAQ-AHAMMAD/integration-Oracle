package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.jar.Attributes;

public class ProductAttributes implements Serializable {

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    private final static long serialVersionUID = -6499139754247989874L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductAttributes() {
    }

    /**
     *
     * @param attributes
     */
    public ProductAttributes(Attributes attributes) {
        super();
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
