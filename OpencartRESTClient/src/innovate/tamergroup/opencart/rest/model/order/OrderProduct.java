package innovate.tamergroup.opencart.rest.model.order;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderProduct implements Serializable {

    @SerializedName("order_product_id")
    @Expose
    private Long orderProductId;
    @SerializedName("product_id")
    @Expose
    private Long productId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("option")
    @Expose
    private List<OrderProductOption> option = null;
    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("currency_value")
    @Expose
    private String currencyValue;
    @SerializedName("price_formated")
    @Expose
    private String priceFormated;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("price_exclude_tax")
    @Expose
    private Double priceExcludeTax;
    @SerializedName("tax")
    @Expose
    private Double tax;
    @SerializedName("total_formated")
    @Expose
    private String totalFormated;
    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("total_exclude_tax")
    @Expose
    private Double totalExcludeTax;
    @SerializedName("total_tax")
    @Expose
    private Double totalTax;
    private final static long serialVersionUID = 3479255828769994204L;

    /**
     * No args constructor for use in serialization
     *
     */
    public OrderProduct() {
    }

    /**
     *
     * @param totalExcludeTax
     * @param total
     * @param model
     * @param currencyCode
     * @param sku
     * @param currencyValue
     * @param productId
     * @param totalFormated
     * @param price
     * @param tax
     * @param priceExcludeTax
     * @param name
     * @param orderProductId
     * @param quantity
     * @param totalTax
     * @param priceFormated
     * @param option
     */
    public OrderProduct(Long orderProductId, Long productId, String name, String model, String sku, List<OrderProductOption> option,
                        Long quantity, String currencyCode, String currencyValue, String priceFormated, Double price,
                        Double priceExcludeTax, Double tax, String totalFormated, Double total, Double totalExcludeTax,
                        Double totalTax) {
        super();
        this.orderProductId = orderProductId;
        this.productId = productId;
        this.name = name;
        this.model = model;
        this.sku = sku;
        this.option = option;
        this.quantity = quantity;
        this.currencyCode = currencyCode;
        this.currencyValue = currencyValue;
        this.priceFormated = priceFormated;
        this.price = price;
        this.priceExcludeTax = priceExcludeTax;
        this.tax = tax;
        this.totalFormated = totalFormated;
        this.total = total;
        this.totalExcludeTax = totalExcludeTax;
        this.totalTax = totalTax;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<OrderProductOption> getOption() {
        return option;
    }

    public void setOption(List<OrderProductOption> option) {
        this.option = option;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public String getPriceFormated() {
        return priceFormated;
    }

    public void setPriceFormated(String priceFormated) {
        this.priceFormated = priceFormated;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceExcludeTax() {
        return priceExcludeTax;
    }

    public void setPriceExcludeTax(Double priceExcludeTax) {
        this.priceExcludeTax = priceExcludeTax;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getTotalFormated() {
        return totalFormated;
    }

    public void setTotalFormated(String totalFormated) {
        this.totalFormated = totalFormated;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalExcludeTax() {
        return totalExcludeTax;
    }

    public void setTotalExcludeTax(Double totalExcludeTax) {
        this.totalExcludeTax = totalExcludeTax;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

}
