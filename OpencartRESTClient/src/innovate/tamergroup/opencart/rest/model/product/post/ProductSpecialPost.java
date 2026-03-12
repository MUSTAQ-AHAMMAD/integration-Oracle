package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ProductSpecialPost implements Serializable {

    @SerializedName("customer_group_id")
    @Expose
    private String customerGroupId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("date_start")
    @Expose
    private Date dateStart;
    @SerializedName("date_end")
    @Expose
    private Date dateEnd;
    private final static long serialVersionUID = -2251096377896434303L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductSpecialPost() {
    }

    /**
     *
     * @param price
     * @param priority
     * @param customerGroupId
     * @param dateEnd
     * @param dateStart
     */
    public ProductSpecialPost(String customerGroupId, String price, String priority, Date dateStart, Date dateEnd) {
        super();
        this.customerGroupId = customerGroupId;
        this.price = price;
        this.priority = priority;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public ProductSpecialPost withCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductSpecialPost withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ProductSpecialPost withPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public ProductSpecialPost withDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ProductSpecialPost withDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

}
