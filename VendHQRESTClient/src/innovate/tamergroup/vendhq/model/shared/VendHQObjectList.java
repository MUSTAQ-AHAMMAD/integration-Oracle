package innovate.tamergroup.vendhq.model.shared;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class VendHQObjectList<T extends Object> {
    
    @SerializedName("data")
    @Expose
    private List<T> items = null;
    @SerializedName("version")
    @Expose
    private Version version;


    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public Version getVersion() {
    return version;
    }
    
    public void setVersion(Version version) {
    this.version = version;
    }
}
