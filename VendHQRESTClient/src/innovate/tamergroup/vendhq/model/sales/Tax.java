package innovate.tamergroup.vendhq.model.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tax {
    
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("id")
    @Expose
    private String id;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Tax() {
        super();
    }


    public void setAmount(Double amount) {
        Double oldAmount = this.amount;
        this.amount = amount;
        _propertyChangeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Double getAmount() {
        return amount;
    }

    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        _propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public String getId() {
        return id;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
