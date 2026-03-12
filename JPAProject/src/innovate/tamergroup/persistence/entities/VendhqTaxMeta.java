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
@NamedQueries({ @NamedQuery(name = "VendhqTaxMeta.findAll", query = "select o from VendhqTaxMeta o"),
                @NamedQuery(name = "getTaxRow", query = "select o from VendhqTaxMeta o where o.taxId = :taxId"),
                @NamedQuery(name = "VendHqTaxMaxVersion", query = "select max(o.version) from VendhqTaxMeta o"),
                @NamedQuery(name = "VendhqTaxMetaFindAllByRegion",
                            query = "select o from VendhqTaxMeta o where o.region = :region and o.taxName = :taxName"),
                @NamedQuery(name = "VendhqTaxMetaFindAllByRegionNameNull",
                            query = "select o from VendhqTaxMeta o where o.region = :region and o.taxName is null")
    })
@Table(name = "VENDHQ_TAX_META")
public class VendhqTaxMeta implements Serializable {
    private static final long serialVersionUID = -4495330930143775225L;
    @Column(nullable = false)
    private double rate;
    @Id
    @Column(name = "TAX_ID", nullable = false, length = 50)
    private String taxId;
    @Column(name = "TAX_NAME", nullable = false, length = 50)
    private String taxName;
    @Column(name = "FUSION_NAME", nullable = true, length = 30)
    private String fusionName;
    @Column(nullable = false)
    private BigDecimal version;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public VendhqTaxMeta() {
    }


    public VendhqTaxMeta(double rate, String taxId, String taxName, String fusionName, BigDecimal version,
                         String region) {
        this.rate = rate;
        this.taxId = taxId;
        this.taxName = taxName;
        this.fusionName = fusionName;
        this.version = version;
        this.region = region;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }


    public void setFusionName(String fusionName) {
        this.fusionName = fusionName;
    }

    public String getFusionName() {
        return fusionName;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
