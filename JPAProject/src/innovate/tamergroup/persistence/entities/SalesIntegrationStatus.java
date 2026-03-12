package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "SalesIntegrationStatus.findAll", query = "select o from SalesIntegrationStatus o"),
                @NamedQuery(name = "SalesIntegrationStatus",
                            query =
                            "select o from SalesIntegrationStatus o where o.region = :region and o.integMode = :integMode")
    })
@Table(name = "SALES_INTEGRATION_STATUS")
@IdClass(SalesIntegrationStatusPK.class)
public class SalesIntegrationStatus implements Serializable {
    private static final long serialVersionUID = 1609326022418900462L;
    @Id
    @Column(name = "INTEG_MODE", nullable = false, length = 25)
    private String integMode;
    @Id
    @Column(nullable = false, length = 5)
    private String region;
    @Column(nullable = false, length = 25)
    private String status;

    public SalesIntegrationStatus() {
    }

    public SalesIntegrationStatus(String integMode, String region, String status) {
        this.integMode = integMode;
        this.region = region;
        this.status = status;
    }

    public String getIntegMode() {
        return integMode;
    }

    public void setIntegMode(String integMode) {
        this.integMode = integMode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
