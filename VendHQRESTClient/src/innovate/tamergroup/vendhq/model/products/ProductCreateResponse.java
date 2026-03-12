package innovate.tamergroup.vendhq.model.products;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductCreateResponse implements Serializable {

    @SerializedName("product")
    @Expose
    private Productv1 product;
    private final static long serialVersionUID = -4915405386793092066L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductCreateResponse() {
    }

    /**
     *
     * @param product
     */
    public ProductCreateResponse(Productv1 product) {
        super();
        this.product = product;
    }

    public Productv1 getProduct() {
        return product;
    }

    public void setProduct(Productv1 product) {
        this.product = product;
    }

}


