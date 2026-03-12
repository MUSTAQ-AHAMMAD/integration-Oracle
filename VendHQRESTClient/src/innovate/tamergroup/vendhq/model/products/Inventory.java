package innovate.tamergroup.vendhq.model.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Inventory {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("outlet_id")
    @Expose
    private String outletId;
    @SerializedName("inventory_level")
    @Expose
    private Long inventoryLevel;
    @SerializedName("reorder_point")
    @Expose
    private Long reorderPoint;
    @SerializedName("reorder_amount")
    @Expose
    private Long reorderAmount;
    @SerializedName("version")
    @Expose
    private Long version;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);


    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        _propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public String getId() {
        return id;
    }

    public void setProductId(String productId) {
        String oldProductId = this.productId;
        this.productId = productId;
        _propertyChangeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    public String getProductId() {
        return productId;
    }

    public void setOutletId(String outletId) {
        String oldOutletId = this.outletId;
        this.outletId = outletId;
        _propertyChangeSupport.firePropertyChange("outletId", oldOutletId, outletId);
    }

    public String getOutletId() {
        return outletId;
    }

    public void setInventoryLevel(Long inventoryLevel) {
        Long oldInventoryLevel = this.inventoryLevel;
        this.inventoryLevel = inventoryLevel;
        _propertyChangeSupport.firePropertyChange("inventoryLevel", oldInventoryLevel, inventoryLevel);
    }

    public Long getInventoryLevel() {
        return inventoryLevel;
    }

    public void setReorderPoint(Long reorderPoint) {
        Long oldReorderPoint = this.reorderPoint;
        this.reorderPoint = reorderPoint;
        _propertyChangeSupport.firePropertyChange("reorderPoint", oldReorderPoint, reorderPoint);
    }

    public Long getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderAmount(Long reorderAmount) {
        Long oldReorderAmount = this.reorderAmount;
        this.reorderAmount = reorderAmount;
        _propertyChangeSupport.firePropertyChange("reorderAmount", oldReorderAmount, reorderAmount);
    }

    public Long getReorderAmount() {
        return reorderAmount;
    }

    public void setVersion(Long version) {
        Long oldVersion = this.version;
        this.version = version;
        _propertyChangeSupport.firePropertyChange("version", oldVersion, version);
    }

    public Long getVersion() {
        return version;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}

