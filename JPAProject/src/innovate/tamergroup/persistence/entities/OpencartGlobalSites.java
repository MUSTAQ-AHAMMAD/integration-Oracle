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
 * To create ID generator sequence "OPENCART_GLOBAL_SITES_ID_SEQ_GEN":
 * CREATE SEQUENCE "OPENCART_GLOBAL_SITES_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "OpencartGlobalSites.findAll", query = "select o from OpencartGlobalSites o") })
@Table(name = "OPENCART_GLOBAL_SITES")
@SequenceGenerator(name = "OpencartGlobalSites_Id_Seq_Gen", sequenceName = "OPENCART_GBL_SITE_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class OpencartGlobalSites implements Serializable {
    private static final long serialVersionUID = -7471561961007540807L;
    @Column(name = "BANK_ACCOUNT", nullable = false, length = 30)
    private String bankAccount;
    @Column(name = "BANK_ACCOUNT_ID", nullable = false)
    private BigDecimal bankAccountId;
    @Column(name = "CASH_ACCOUNT", nullable = false, length = 30)
    private String cashAccount;
    @Column(name = "CASH_ACCOUNT_ID", nullable = false)
    private BigDecimal cashAccountId;
    @Column(name = "COUNTRY_CODE", nullable = false, unique = true, length = 10)
    private String countryCode;
    @Column(name = "CURRENCY_CODE", nullable = false, unique = true, length = 3)
    private String currencyCode;
    @Column(name = "DOMAIN_NAME", nullable = false, length = 50)
    private String domainName;
    @Column(name = "DOMAIN_TOKEN", nullable = false, length = 100)
    private String domainToken;
    @Column(name = "SUBINVENTORY", nullable = false, length = 30)
    private String subinventory;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OpencartGlobalSites_Id_Seq_Gen")
    private BigDecimal rowId;

    public OpencartGlobalSites() {
    }


    public OpencartGlobalSites(String bankAccount, BigDecimal bankAccountId, String cashAccount,
                               BigDecimal cashAccountId, String countryCode, String currencyCode, String domainName,
                               String domainToken, String subinventory) {
        this.bankAccount = bankAccount;
        this.bankAccountId = bankAccountId;
        this.cashAccount = cashAccount;
        this.cashAccountId = cashAccountId;
        this.countryCode = countryCode;
        this.currencyCode = currencyCode;
        this.domainName = domainName;
        this.domainToken = domainToken;
        this.subinventory = subinventory;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BigDecimal getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BigDecimal bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    public BigDecimal getCashAccountId() {
        return cashAccountId;
    }

    public void setCashAccountId(BigDecimal cashAccountId) {
        this.cashAccountId = cashAccountId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainToken() {
        return domainToken;
    }

    public void setDomainToken(String domainToken) {
        this.domainToken = domainToken;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public String getSubinventory() {
        return subinventory;
    }

}
