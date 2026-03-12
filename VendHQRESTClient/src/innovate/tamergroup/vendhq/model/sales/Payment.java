package innovate.tamergroup.vendhq.model.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.Date;
import java.util.List;


public class Payment {
    
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("register_id")
    @Expose
    private String registerId;
    @SerializedName("outlet_id")
    @Expose
    private String outletId;
    @SerializedName("retailer_payment_type_id")
    @Expose
    private String retailerPaymentTypeId;
    @SerializedName("payment_type_id")
    @Expose
    private String paymentTypeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("payment_date")
    @Expose
    private Date paymentDate;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("external_attributes")
    @Expose
    private List<Object> externalAttributes = null;
    @SerializedName("source_id")
    @Expose
    private Object sourceId;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Payment() {
        super();
    }


    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        _propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public String getId() {
        return id;
    }

    public void setRegisterId(String registerId) {
        String oldRegisterId = this.registerId;
        this.registerId = registerId;
        _propertyChangeSupport.firePropertyChange("registerId", oldRegisterId, registerId);
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setOutletId(String outletId) {
        String oldOutletId = this.outletId;
        this.outletId = outletId;
        _propertyChangeSupport.firePropertyChange("outletId", oldOutletId, outletId);
    }

    public String getOutletId() {
        return outletId;
    }

    public void setRetailerPaymentTypeId(String retailerPaymentTypeId) {
        String oldRetailerPaymentTypeId = this.retailerPaymentTypeId;
        this.retailerPaymentTypeId = retailerPaymentTypeId;
        _propertyChangeSupport.firePropertyChange("retailerPaymentTypeId", oldRetailerPaymentTypeId,
                                                  retailerPaymentTypeId);
    }

    public String getRetailerPaymentTypeId() {
        return retailerPaymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        String oldPaymentTypeId = this.paymentTypeId;
        this.paymentTypeId = paymentTypeId;
        _propertyChangeSupport.firePropertyChange("paymentTypeId", oldPaymentTypeId, paymentTypeId);
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        _propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setAmount(Double amount) {
        Double oldAmount = this.amount;
        this.amount = amount;
        _propertyChangeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Double getAmount() {
        return amount;
    }

    public void setPaymentDate(Date paymentDate) {
        Date oldPaymentDate = this.paymentDate;
        this.paymentDate = paymentDate;
        _propertyChangeSupport.firePropertyChange("paymentDate", oldPaymentDate, paymentDate);
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setDeletedAt(Date deletedAt) {
        Object oldDeletedAt = this.deletedAt;
        this.deletedAt = deletedAt;
        _propertyChangeSupport.firePropertyChange("deletedAt", oldDeletedAt, deletedAt);
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setExternalAttributes(List externalAttributes) {
        List oldExternalAttributes = this.externalAttributes;
        this.externalAttributes = externalAttributes;
        _propertyChangeSupport.firePropertyChange("externalAttributes", oldExternalAttributes, externalAttributes);
    }

    public List<Object> getExternalAttributes() {
        return externalAttributes;
    }

    public void setSourceId(Object sourceId) {
        Object oldSourceId = this.sourceId;
        this.sourceId = sourceId;
        _propertyChangeSupport.firePropertyChange("sourceId", oldSourceId, sourceId);
    }

    public Object getSourceId() {
        return sourceId;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
