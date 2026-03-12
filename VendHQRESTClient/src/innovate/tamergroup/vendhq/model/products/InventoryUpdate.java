package innovate.tamergroup.vendhq.model.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class InventoryUpdate {


    @SerializedName("outlet_id")
    @Expose
    private String outletId;
    @SerializedName("outlet_name")
    @Expose
    private String outletName;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("reorder_point")
    @Expose
    private String reorderPoint;
    @SerializedName("restock_level")
    @Expose
    private String restockLevel;
    private final static long serialVersionUID = -5014172181977793666L;

    /**
     * No args constructor for use in serialization
     *
     */
    public InventoryUpdate() {
    }

    /**
     *
     * @param restockLevel
     * @param reorderPoint
     * @param count
     * @param outletId
     * @param outletName
     */
    public InventoryUpdate(String outletId, String outletName, String count, String reorderPoint, String restockLevel) {
        super();
        this.outletId = outletId;
        this.outletName = outletName;
        this.count = count;
        this.reorderPoint = reorderPoint;
        this.restockLevel = restockLevel;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public InventoryUpdate withOutletId(String outletId) {
        this.outletId = outletId;
        return this;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public InventoryUpdate withOutletName(String outletName) {
        this.outletName = outletName;
        return this;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public InventoryUpdate withCount(String count) {
        this.count = count;
        return this;
    }

    public String getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(String reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public InventoryUpdate withReorderPoint(String reorderPoint) {
        this.reorderPoint = reorderPoint;
        return this;
    }

    public String getRestockLevel() {
        return restockLevel;
    }

    public void setRestockLevel(String restockLevel) {
        this.restockLevel = restockLevel;
    }

    public InventoryUpdate withRestockLevel(String restockLevel) {
        this.restockLevel = restockLevel;
        return this;
    }
}
