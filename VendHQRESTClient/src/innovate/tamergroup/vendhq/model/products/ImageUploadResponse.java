package innovate.tamergroup.vendhq.model.products;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.crypto.Data;

public class ImageUploadResponse implements Serializable {

    @SerializedName("data")
    @Expose
    private ImageUploadResponseData data;
    private final static long serialVersionUID = 5260617244339610612L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ImageUploadResponse() {
    }

    /**
     *
     * @param data
     */
    public ImageUploadResponse(ImageUploadResponseData data) {
        super();
        this.data = data;
    }

    public ImageUploadResponseData getData() {
        return data;
    }

    public void setData(ImageUploadResponseData data) {
        this.data = data;
    }

}
