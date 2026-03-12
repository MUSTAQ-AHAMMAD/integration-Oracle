package innovate.tamergroup.vendhq.model.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Type {
    
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
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
