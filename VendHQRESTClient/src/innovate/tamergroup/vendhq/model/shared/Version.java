package innovate.tamergroup.vendhq.model.shared;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Version {
    
    @SerializedName("min")
    @Expose
    private Long min;
    @SerializedName("max")
    @Expose
    private Long max;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Version() {
        super();
    }


    public void setMin(Long min) {
        Long oldMin = this.min;
        this.min = min;
        _propertyChangeSupport.firePropertyChange("min", oldMin, min);
    }

    public Long getMin() {
        return min;
    }

    public void setMax(Long max) {
        Long oldMax = this.max;
        this.max = max;
        _propertyChangeSupport.firePropertyChange("max", oldMax, max);
    }

    public Long getMax() {
        return max;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
