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
 * To create ID generator sequence "VENDHQ_SERVICE_PROVIDERS_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_SERV_PROV_ID_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqServiceProviders.findAll", query = "select o from VendhqServiceProviders o"),
                @NamedQuery(name = "VendhqServiceProvidersByRegionAndCustomerID",
                            query = "select o from VendhqServiceProviders o where o.region = :region and o.vendHqCustomerId = :vendHqCustomerId")
    })
@Table(name = "VENDHQ_SERVICE_PROVIDERS")
@SequenceGenerator(name = "VendhqServiceProviders_Id_Seq_Gen", sequenceName = "VENDHQ_SERV_PROV_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class VendhqServiceProviders implements Serializable {
    
    private static final long serialVersionUID = 6744324948083444321L;
    
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VendhqServiceProviders_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(name = "SERVICE_PROVIDER", nullable = false, unique = true, length = 100)
    private String serviceProvider;
    @Column(name = "VEDNHQ_CUSTOMER_ID", nullable = false, length = 50)
    private String vendHqCustomerId;
   


    public VendhqServiceProviders() {
    }


    public VendhqServiceProviders(String region, String serviceProvider, String vendHqCustomerId) {
        this.region = region;
        this.serviceProvider = serviceProvider;
        this.vendHqCustomerId = vendHqCustomerId;
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

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setVendHqCustomerId(String vendHqCustomerId) {
        this.vendHqCustomerId = vendHqCustomerId;
    }

    public String getVendHqCustomerId() {
        return vendHqCustomerId;
    }

}
