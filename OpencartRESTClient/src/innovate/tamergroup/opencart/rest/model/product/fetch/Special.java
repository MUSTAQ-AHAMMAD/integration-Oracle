package innovate.tamergroup.opencart.rest.model.product.fetch;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Special implements Serializable {

    @SerializedName("customer_group_id")
    @Expose
    private long customerGroupId;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("date_start")
    @Expose
    private String dateStart;
    @SerializedName("date_end")
    @Expose
    private String dateEnd;
    private final static long serialVersionUID = -2291074082259386075L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Special() {
    }

    /**
     *
     * @param price
     * @param priority
     * @param customerGroupId
     * @param dateEnd
     * @param dateStart
     */
    public Special(long customerGroupId, String priority, String price, String dateStart, String dateEnd) {
        super();
        this.customerGroupId = customerGroupId;
        this.priority = priority;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public long getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(long customerGroupId) {
        this.customerGroupId = customerGroupId;
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

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

}
