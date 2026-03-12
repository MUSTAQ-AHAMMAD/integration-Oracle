package innovate.tamergroup.vendhq.model.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Sale {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("outlet_id")
    @Expose
    private String outletId;
    @SerializedName("register_id")
    @Expose
    private String registerId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("invoice_number")
    @Expose
    private String invoiceNumber;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("source_id")
    @Expose
    private String sourceId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("short_code")
    @Expose
    private String shortCode;
    @SerializedName("return_for")
    @Expose
    private String returnFor;
    @SerializedName("total_price")
    @Expose
    private Double totalPrice;
    @SerializedName("total_price_incl")
    @Expose
    private Double totalPriceInclTax;
    @SerializedName("total_tax")
    @Expose
    private Double totalTax;
    @SerializedName("total_loyalty")
    @Expose
    private Double totalLoyalty;
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose
    private Date updatedAt;
    @SerializedName("sale_date")
    @Expose
    private Date saleDate;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("line_items")
    @Expose
    private List<LineItem> lineItems = null;
    @SerializedName("payments")
    @Expose
    private List<Payment> payments = null;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("receipt_number")
    @Expose
    private String receiptNumber;
    @SerializedName("taxes")
    @Expose
    private List<Tax> taxes = null;

    public Sale() {
        super();
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setReturnFor(String returnFor) {
        this.returnFor = returnFor;
    }

    public String getReturnFor() {
        return returnFor;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalLoyalty(Double totalLoyalty) {
        this.totalLoyalty = totalLoyalty;
    }

    public Double getTotalLoyalty() {
        return totalLoyalty;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTotalPriceInclTax(Double totalPriceInclTax) {
        this.totalPriceInclTax = totalPriceInclTax;
    }

    public Double getTotalPriceInclTax() {
        return totalPriceInclTax;
    }
}
