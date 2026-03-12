package innovate.tamergroup.vendhq.model.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LineItem {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("tax_id")
    @Expose
    private String taxId;
    @SerializedName("discount_total")
    @Expose
    private Double discountTotal;
    @SerializedName("discount")
    @Expose
    private Double discount;
    @SerializedName("price_total")
    @Expose
    private Double priceTotal;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("cost_total")
    @Expose
    private Double costTotal;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("tax_total")
    @Expose
    private Double taxTotal;
    @SerializedName("tax")
    @Expose
    private Double tax;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("loyalty_value")
    @Expose
    private Double loyaltyValue;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("price_set")
    @Expose
    private Boolean priceSet;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sequence")
    @Expose
    private Integer sequence;
    @SerializedName("tax_components")
    @Expose
    private List<TaxComponent> taxComponents = null;
    @SerializedName("promotions")
    @Expose
    private List<Promotion> promotions = null;
    @SerializedName("unit_cost")
    @Expose
    private Double unitCost;
    @SerializedName("unit_discount")
    @Expose
    private Double unitDiscount;
    @SerializedName("unit_loyalty_value")
    @Expose
    private Double unitLoyaltyValue;
    @SerializedName("unit_price")
    @Expose
    private Double unitPrice;
    @SerializedName("unit_tax")
    @Expose
    private Double unitTax;
    @SerializedName("total_cost")
    @Expose
    private Double totalCost;
    @SerializedName("total_discount")
    @Expose
    private Double totalDiscount;
    @SerializedName("total_loyalty_value")
    @Expose
    private Double totalLoyaltyValue;
    @SerializedName("total_tax")
    @Expose
    private Double totalTax;
    @SerializedName("total_price")
    @Expose
    private Double totalPrice;
    @SerializedName("is_return")
    @Expose
    private Boolean isReturn;
    
    public LineItem() {
        super();
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public Double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setCostTotal(Double costTotal) {
        this.costTotal = costTotal;
    }

    public Double getCostTotal() {
        return costTotal;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setLoyaltyValue(Double loyaltyValue) {
        this.loyaltyValue = loyaltyValue;
    }

    public Double getLoyaltyValue() {
        return loyaltyValue;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setPriceSet(Boolean priceSet) {
        this.priceSet = priceSet;
    }

    public Boolean getPriceSet() {
        return priceSet;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setTaxComponents(List<TaxComponent> taxComponents) {
        this.taxComponents = taxComponents;
    }

    public List<TaxComponent> getTaxComponents() {
        return taxComponents;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitDiscount(Double unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    public Double getUnitDiscount() {
        return unitDiscount;
    }

    public void setUnitLoyaltyValue(Double unitLoyaltyValue) {
        this.unitLoyaltyValue = unitLoyaltyValue;
    }

    public Double getUnitLoyaltyValue() {
        return unitLoyaltyValue;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitTax(Double unitTax) {
        this.unitTax = unitTax;
    }

    public Double getUnitTax() {
        return unitTax;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalLoyaltyValue(Double totalLoyaltyValue) {
        this.totalLoyaltyValue = totalLoyaltyValue;
    }

    public Double getTotalLoyaltyValue() {
        return totalLoyaltyValue;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    public Boolean getIsReturn() {
        return isReturn;
    }
}
