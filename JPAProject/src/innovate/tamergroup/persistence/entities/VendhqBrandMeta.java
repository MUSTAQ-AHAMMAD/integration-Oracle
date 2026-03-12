package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
              @NamedQuery(name = "VendhqBrandMeta.findAll", query = "select o from VendhqBrandMeta o"),
              @NamedQuery(name = "VendhqBrandMetaMaxVersion", query = "select max(o.version) from VendhqBrandMeta o")
    })
@Table(name = "VENDHQ_BRAND_META")
public class VendhqBrandMeta implements Serializable {
    private static final long serialVersionUID = -2535460057592654478L;
    @Id
    @Column(name = "BRAND_ID", nullable = false, length = 50)
    private String brandId;
    @Column(nullable = false, length = 100)
    private String name;
    private String version;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public VendhqBrandMeta() {
    }


    public VendhqBrandMeta(String brandId, String name, String version, String region) {
        this.brandId = brandId;
        this.name = name;
        this.version = version;
        this.region = region;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
