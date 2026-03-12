package innovate.tamergroup.opencart.rest.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderMini {

    @SerializedName("order_id")
    @Expose
    private long orderId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("products")
    @Expose
    private long products;
    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("currency_value")
    @Expose
    private String currencyValue;
    private final static long serialVersionUID = -8327261445736251235L;

    /**
     * No args constructor for use in serialization
     *
     */
    public OrderMini() {
    }

    /**
     *
     * @param total
     * @param currencyCode
     * @param status
     * @param name
     * @param dateAdded
     * @param currencyValue
     * @param products
     * @param orderId
     */
    public OrderMini(long orderId, String name, String status, String dateAdded, long products, Double total,
                     String currencyCode, String currencyValue) {
        super();
        this.orderId = orderId;
        this.name = name;
        this.status = status;
        this.dateAdded = dateAdded;
        this.products = products;
        this.total = total;
        this.currencyCode = currencyCode;
        this.currencyValue = currencyValue;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public long getProducts() {
        return products;
    }

    public void setProducts(long products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

}
