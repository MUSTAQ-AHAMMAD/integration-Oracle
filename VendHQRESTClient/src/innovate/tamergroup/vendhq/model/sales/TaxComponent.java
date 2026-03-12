package innovate.tamergroup.vendhq.model.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TaxComponent {
    
    @SerializedName("rate_id")
    @Expose
    private String rateId;
    @SerializedName("total_tax")
    @Expose
    private Double totalTax;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    
    public TaxComponent() {
        super();
    }


    public void setRateId(String rateId) {
        String oldRateId = this.rateId;
        this.rateId = rateId;
        _propertyChangeSupport.firePropertyChange("rateId", oldRateId, rateId);
    }

    public String getRateId() {
        return rateId;
    }

    public void setTotalTax(Double totalTax) {
        Double oldTotalTax = this.totalTax;
        this.totalTax = totalTax;
        _propertyChangeSupport.firePropertyChange("totalTax", oldTotalTax, totalTax);
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
