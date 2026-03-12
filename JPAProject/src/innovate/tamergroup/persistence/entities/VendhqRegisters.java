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
 * To create ID generator sequence "VENDHQ_REGISTERS_ID_SEQ_GEN":
 * CREATE SEQUENCE "VENDHQ_REGISTERS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "VendhqRegisters.findAll", query = "select o from VendhqRegisters o"),
                @NamedQuery(name = "RegisterDetails",
                            query = "select o from VendhqRegisters o where o.registerId = :registerId"),
                @NamedQuery(name = "RegisterMaxVersion", query = "select max(o.version) from VendhqRegisters o"),
                @NamedQuery(name = "RegisterDetailsByName",
                            query =
                            "select o from VendhqRegisters o where o.registerName = :registerName and o.region = :region")
    })
@Table(name = "VENDHQ_REGISTERS")
public class VendhqRegisters implements Serializable {
    private static final long serialVersionUID = -281317110780428119L;
    @Column(name = "BANK_ACCOUNT", length = 100)
    private String bankAccount;
    @Column(name = "CASH_ACCOUNT", length = 100)
    private String cashAccount;
    @Column(name = "BANK_ACCOUNT_ID", length = 20)
    private BigDecimal bankAccountId;
    @Column(name = "CASH_ACCOUNT_ID", length = 20)
    private BigDecimal cashAccountId;
    @Temporal(TemporalType.DATE)
    @Column(name = "DELETED_AT")
    private Date deletedAt;
    @Column(name = "OUTLET_ID", nullable = false, length = 40)
    private String outletId;
    @Id
    @Column(name = "REGISTER_ID", nullable = false, unique = true, length = 40)
    private String registerId;
    @Column(name = "REGISTER_NAME", nullable = false, length = 30)
    private String registerName;
    @Column(nullable = false)
    private BigDecimal version;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public VendhqRegisters() {
    }


    public VendhqRegisters(String bankAccount, String cashAccount, BigDecimal bankAccountId, BigDecimal cashAccountId,
                           Date deletedAt, String outletId, String registerId, String registerName,
                           BigDecimal version, String region) {
        this.bankAccount = bankAccount;
        this.cashAccount = cashAccount;
        this.bankAccountId = bankAccountId;
        this.cashAccountId = cashAccountId;
        this.deletedAt = deletedAt;
        this.outletId = outletId;
        this.registerId = registerId;
        this.registerName = registerName;
        this.version = version;
        this.region = region;
    }


    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setBankAccountId(BigDecimal bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getBankAccountId() {
        return bankAccountId;
    }

    public void setCashAccountId(BigDecimal cashAccountId) {
        this.cashAccountId = cashAccountId;
    }

    public BigDecimal getCashAccountId() {
        return cashAccountId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

}
