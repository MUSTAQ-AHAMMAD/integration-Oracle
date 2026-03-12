package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * To create ID generator sequence "VENDHQ_OUTLETS_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_OUTLETS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqOutletsDB.findAll", query = "select o from VendhqOutletsDB o"),
                @NamedQuery(name = "OutletDetails",
                            query = "select o from VendhqOutletsDB o where o.outletId = :outletId"),
                @NamedQuery(name = "OutletsMaxVersion", query = "select max(o.version) from VendhqOutletsDB o"),
                @NamedQuery(name = "VendhqOutletsByRegion",
                            query =
                            "select o from VendhqOutletsDB o where o.region = :region order by o.outletName asc"),
                @NamedQuery(name = "OutletDetailsByName",
                            query =
                            "select o from VendhqOutletsDB o where o.outletName = :outletName and o.region = :region")
    })
@Table(name = "VENDHQ_OUTLETS")
public class VendhqOutletsDB implements Serializable {
    private static final long serialVersionUID = 6165430153335278571L;
    @Temporal(TemporalType.DATE)
    @Column(name = "DELETED_AT")
    private Date deletedAt;
    @Id
    @Column(name = "OUTLET_ID", nullable = false, length = 100)
    private String outletId;
    @Column(name = "OUTLET_NAME", nullable = false, length = 250)
    private String outletName;
    @Column(name = "CURRENCY", nullable = false, length = 5)
    private String currency;
    @Column(nullable = false)
    private BigDecimal version;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public VendhqOutletsDB() {
    }


    public VendhqOutletsDB(Date deletedAt, String outletId, String outletName, String currency, BigDecimal version,
                           String region) {
        this.deletedAt = deletedAt;
        this.outletId = outletId;
        this.outletName = outletName;
        this.currency = currency;
        this.version = version;
        this.region = region;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
