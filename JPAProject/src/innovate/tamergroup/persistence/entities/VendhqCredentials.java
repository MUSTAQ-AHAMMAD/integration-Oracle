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
 * To create ID generator sequence "VENDHQ_CREDENTIALS_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_CREDENTIALS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqCredentials.findAll", query = "select o from VendhqCredentials o"),
                @NamedQuery(name = "VendHqCredential",
                            query = "select o from VendhqCredentials o where o.active = 'Y'"),
                @NamedQuery(name = "VendHqCredentialByRegion",
                            query = "select o from VendhqCredentials o where o.region = :region")
    })
@Table(name = "VENDHQ_CREDENTIALS")
@SequenceGenerator(name = "VendhqCredentials_Id_Seq_Gen", sequenceName = "VENDHQ_CREDENTIALS_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class VendhqCredentials implements Serializable {
    private static final long serialVersionUID = 6744324948083444321L;
    @Column(nullable = false)
    private String active;
    @Column(name = "DOMAIN_NAME", nullable = false, unique = true, length = 30)
    private String domainName;
    @Column(name = "PERSONAL_TOKEN", nullable = false, length = 50)
    private String personalToken;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VendhqCredentials_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(nullable = false, length = 10, name = "FUSION_ORG_CODE")
    private String fusionOrgCode;
    @Column(nullable = false, length = 5, name = "FUSION_TAX_CODE")
    private String fusionTaxCode;
    @Column(nullable = false, name = "TIMEZONE_OFFSET")
    private BigDecimal timezoneOffset;
    @Temporal(TemporalType.DATE)
    @Column(name = "BUSINESS_START_DATE")
    private Date startDate;

    public VendhqCredentials() {
    }


    public VendhqCredentials(String active, String domainName, String personalToken, String region,
                             String fusionOrgCode, String fusionTaxCode, BigDecimal timezoneOffset, Date startDate) {
        this.active = active;
        this.domainName = domainName;
        this.personalToken = personalToken;
        this.region = region;
        this.fusionOrgCode = fusionOrgCode;
        this.fusionTaxCode = fusionTaxCode;
        this.timezoneOffset = timezoneOffset;
        this.startDate = startDate;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getPersonalToken() {
        return personalToken;
    }

    public void setPersonalToken(String personalToken) {
        this.personalToken = personalToken;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setFusionOrgCode(String fusionOrgCode) {
        this.fusionOrgCode = fusionOrgCode;
    }

    public String getFusionOrgCode() {
        return fusionOrgCode;
    }

    public void setTimezoneOffset(BigDecimal timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public BigDecimal getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setFusionTaxCode(String fusionTaxCode) {
        this.fusionTaxCode = fusionTaxCode;
    }

    public String getFusionTaxCode() {
        return fusionTaxCode;
    }

}
