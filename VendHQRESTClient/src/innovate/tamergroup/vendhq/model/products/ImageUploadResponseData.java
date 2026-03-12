package innovate.tamergroup.vendhq.model.products;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageUploadResponseData implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("position")
    @Expose
    private long position;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("version")
    @Expose
    private long version;
    private final static long serialVersionUID = 6802394894469788314L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ImageUploadResponseData() {
    }

    /**
     *
     * @param position
     * @param id
     * @param status
     * @param version
     * @param productId
     */
    public ImageUploadResponseData(String id, String productId, long position, String status, long version) {
        super();
        this.id = id;
        this.productId = productId;
        this.position = position;
        this.status = status;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
