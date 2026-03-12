package innovate.tamergroup.opencart.rest.model.product.post;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ProductDiscountPost implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("customer_group_id")
    @Expose
    private String customerGroupId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("date_start")
    @Expose
    private Date dateStart;
    @SerializedName("date_end")
    @Expose
    private Date dateEnd;
    private final static long serialVersionUID = -1621801333322776908L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductDiscountPost() {
    }

    /**
     *
     * @param price
     * @param priority
     * @param customerGroupId
     * @param name
     * @param dateEnd
     * @param quantity
     * @param dateStart
     */
    public ProductDiscountPost(String name, String customerGroupId, String price, String priority, String quantity,
                           Date dateStart, Date dateEnd) {
        super();
        this.name = name;
        this.customerGroupId = customerGroupId;
        this.price = price;
        this.priority = priority;
        this.quantity = quantity;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDiscountPost withName(String name) {
        this.name = name;
        return this;
    }

    public String getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public ProductDiscountPost withCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductDiscountPost withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ProductDiscountPost withPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductDiscountPost withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public ProductDiscountPost withDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ProductDiscountPost withDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

}
