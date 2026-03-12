package innovate.tamergroup.vendhq.model.paymentTypes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PaymentType {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type_id")
    @Expose
    private Integer typeId;
    @SerializedName("config")
    @Expose
    private String config;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("version")
    @Expose
    private Long version;
    
    public String getId() {
    return id;
    }
    
    public void setId(String id) {
    this.id = id;
    }
    
    public String getName() {
    return name;
    }
    
    public void setName(String name) {
    this.name = name;
    }
    
    public Integer getTypeId() {
    return typeId;
    }
    
    public void setTypeId(Integer typeId) {
    this.typeId = typeId;
    }
    
    public String getConfig() {
    return config;
    }
    
    public void setConfig(String config) {
    this.config = config;
    }
    
    public Date getDeletedAt() {
    return deletedAt;
    }
    
    public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
    }
    
    public Long getVersion() {
    return version;
    }
    
    public void setVersion(Long version) {
    this.version = version;
    }

}