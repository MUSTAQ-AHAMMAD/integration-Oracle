package innovate.tamergroup.vendhq.model.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VariantOption {
    
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose 
    private String value;


    public VariantOption(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
