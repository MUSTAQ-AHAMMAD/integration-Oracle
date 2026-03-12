package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "FusionBusinessUnitIdMap.findAll",
                            query = "select o from FusionBusinessUnitIdMap o"),
                @NamedQuery(name = "FusionBusinessUnitIdMap.findByRegion",
                            query = "select o from FusionBusinessUnitIdMap o where o.region = :region")
    })
@Table(name = "FUSION_BUSINESS_UNIT_ID_MAP")
public class FusionBusinessUnitIdMap implements Serializable {
    private static final long serialVersionUID = -8024177897734753941L;
    @Id
    @Column(name = "BUSINESS_UNIT_ID", nullable = false)
    private BigDecimal businessUnitId;
    @Column(name = "BUSINESS_UNIT_NAME", nullable = false)
    private String businessUnitName;
    @Column(nullable = false, length = 5)
    private String region;

    public FusionBusinessUnitIdMap() {
    }

    public FusionBusinessUnitIdMap(BigDecimal businessUnitId, String businessUnitName, String region) {
        this.businessUnitId = businessUnitId;
        this.businessUnitName = businessUnitName;
        this.region = region;
    }

    public BigDecimal getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(BigDecimal businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getBusinessUnitName() {
        return businessUnitName;
    }

    public void setBusinessUnitName(String businessUnitName) {
        this.businessUnitName = businessUnitName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
