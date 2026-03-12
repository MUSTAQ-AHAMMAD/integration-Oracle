package innovate.tamergroup.opencart.rest.model.order;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingLine implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("tax")
    @Expose
    private Double tax;
    private final static long serialVersionUID = 8408037719697478293L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ShippingLine() {
    }

    /**
     *
     * @param price
     * @param tax
     * @param name
     */
    public ShippingLine(String name, Double price, Double tax) {
        super();
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

}
