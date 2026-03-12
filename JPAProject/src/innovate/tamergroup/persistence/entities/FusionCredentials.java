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
 * To create ID generator sequence "FUSION_CREDENTIALS_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_CREDENTIALS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({
              @NamedQuery(name = "FusionCredentials.findAll", query = "select o from FusionCredentials o"),
              @NamedQuery(name = "FusionCredential", query = "select o from FusionCredentials o where o.active = 'Y'")
    })
@Table(name = "FUSION_CREDENTIALS")
@SequenceGenerator(name = "FusionCredentials_Id_Seq_Gen", sequenceName = "FUSION_CREDENTIALS_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionCredentials implements Serializable {
    private static final long serialVersionUID = 2941804048550797722L;
    @Column(nullable = false)
    private String active;
    @Column(name = "HOST_NAME", nullable = false, unique = true, length = 4)
    private String hostName;
    @Column(nullable = false, length = 30)
    private String password;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionCredentials_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 3)
    private String server;
    @Column(nullable = false, length = 30)
    private String username;

    public FusionCredentials() {
    }


    public FusionCredentials(String active, String hostName, String password, BigDecimal rowId, String server,
                             String username) {
        this.active = active;
        this.hostName = hostName;
        this.password = password;
        this.rowId = rowId;
        this.server = server;
        this.username = username;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActive() {
        return active;
    }
}
