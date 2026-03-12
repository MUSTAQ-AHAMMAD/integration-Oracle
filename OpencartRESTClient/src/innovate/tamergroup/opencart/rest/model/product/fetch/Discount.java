package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Discount implements Serializable {

    @SerializedName("customer_group_id")
    @Expose
    private Long customerGroupId;
    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("date_start")
    @Expose
    private Date dateStart;
    @SerializedName("date_end")
    @Expose
    private Date dateEnd;
    private final static long serialVersionUID = -8223742694426035559L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Discount() {
    }

    /**
     *
     * @param price
     * @param priority
     * @param customerGroupId
     * @param dateEnd
     * @param quantity
     * @param dateStart
     */
    public Discount(Long customerGroupId, Long quantity, String priority, String price, Date dateStart,
                    Date dateEnd) {
        super();
        this.customerGroupId = customerGroupId;
        this.quantity = quantity;
        this.priority = priority;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Long getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
