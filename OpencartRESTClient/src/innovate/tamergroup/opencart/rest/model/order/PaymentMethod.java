package innovate.tamergroup.opencart.rest.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentMethod {

    @SerializedName("extension_id")
    @Expose
    private String extensionId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("code")
    @Expose
    private String code;
    private final static long serialVersionUID = 3508204147582245734L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentMethod() {
    }

    /**
     *
     * @param extensionId
     * @param code
     * @param type
     */
    public PaymentMethod(String extensionId, String type, String code) {
        super();
        this.extensionId = extensionId;
        this.type = type;
        this.code = code;
    }

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
