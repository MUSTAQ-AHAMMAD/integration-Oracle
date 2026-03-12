package innovate.tamergroup.vendhq.model.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    
    public String getId() {
    return id;
    }
    
    public void setId(String id) {
    this.id = id;
    }
    
    public String getUrl() {
    return url;
    }
    
    public void setUrl(String url) {
    this.url = url;
    }
    
    public Long getVersion() {
    return version;
    }
    
    public void setVersion(Long version) {
    this.version = version;
    }
    
    public Sizes getSizes() {
    return sizes;
    }
    
    public void setSizes(Sizes sizes) {
    this.sizes = sizes;
    }

}