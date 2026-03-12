package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * To create ID generator sequence "OUTLET_INTEG_CONFIG_SEQ":
 * CREATE SEQUENCE "OUTLET_INTEG_CONFIG_SEQ" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "OutletsIntegrationConfig.findAll",
                            query = "select o from OutletsIntegrationConfig o"),
                @NamedQuery(name = "getOutletIntegStatus",
                            query =
                            "select o.integMode from OutletsIntegrationConfig o where o.outletName = :outletName and o.region = :region"),
                @NamedQuery(name = "getOutletsByStatus",
                            query =
                            "select o.outletName from OutletsIntegrationConfig o where o.integMode = :integMode and o.region = :region")
    })
@Table(name = "OUTLETS_INTEGRATION_CONFIG")
@SequenceGenerator(name = "OutletsIntegrationConfig_Id_Seq_Gen", sequenceName = "OUTLET_INTEG_CONFIG_SEQ",
                   allocationSize = 1, initialValue = 1)
public class OutletsIntegrationConfig implements Serializable {
    private static final long serialVersionUID = 2250658396988387627L;
    @Column(name = "INTEG_MODE", nullable = false, length = 20)
    private String integMode;
    @Column(name = "OUTLET_NAME", nullable = false, length = 200)
    private String outletName;
    @Column(nullable = false, length = 5)
    private String region;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OutletsIntegrationConfig_Id_Seq_Gen")
    private BigDecimal rowId;

    public OutletsIntegrationConfig() {
    }

    public OutletsIntegrationConfig(String integMode, String outletName, String region, BigDecimal rowId) {
        this.integMode = integMode;
        this.outletName = outletName;
        this.region = region;
        this.rowId = rowId;
    }

    public String getIntegMode() {
        return integMode;
    }

    public void setIntegMode(String integMode) {
        this.integMode = integMode;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

}

