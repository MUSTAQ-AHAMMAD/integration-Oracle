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
 * To create ID generator sequence "SERVICE_PROVIDER_JOURNAL_MAPPING_ID_SEQ_GEN":
 * CREATE SEQUENCE "SERV_PROV_JOUR_ID_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ServiceProviderJournalMapping.findAll", query = "select o from VendhqServiceProviders o"),
                @NamedQuery(name = "ServiceProviderJournalMappingByRegion",
                            query = "select o from ServiceProviderJournalMapping o where o.region = :region and o.serviceProvider = :serviceProvider and o.creditDebit = :creditDebit and o.isCash = :isCash")
    })
@Table(name = "SERVICE_PROVIDER_JOURNAL_META")
@SequenceGenerator(name = "ServiceProviderJournalMapping_Id_Seq_Gen", sequenceName = "SERV_PROV_JOUR_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class ServiceProviderJournalMapping implements Serializable {
    
    private static final long serialVersionUID = 6744324948083444321L;
    
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ServiceProviderJournalMapping_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(name = "SERVICE_PROVIDER", nullable = false, unique = true, length = 100)
    private String serviceProvider;
    @Column(name = "IS_CASH", nullable = false)
    private Boolean isCash;
    @Column(name = "CREDIT_DEBIT", nullable = false, length = 10)
    private String creditDebit;
    @Column(name = "LEDGER_ID", nullable = false)
    private BigDecimal ledgerId;
    @Column(name = "CHART_OF_ACCOUNTS_ID", nullable = false)
    private BigDecimal chartOfAccountsId;
    @Column(name = "TAX_GROUP_ID", nullable = false)
    private BigDecimal taxGroupId;
    @Column(name = "FIXED_FREIGHT_CHARGE")
    private BigDecimal fixedFrieghtCharge;
    @Column(name = "BANK_CHARGE_RATE")
    private BigDecimal bankChargeRate;

    @Column(name = "COST_ISSUE", length = 100)
    private String costIssue;
    @Column(name = "COST_RMA", length = 100)
    private String costRMA;
    
    @Column(name = "COMPANY", length = 100)
    private String company;
    @Column(name = "ACCOUNT", length = 100)
    private String account;
    @Column(name = "DEPARTMENT", length = 100)
    private String department;
    @Column(name = "PRODUCT_CATEGORY", length = 100)
    private String productCategory;
    @Column(name = "INTER_COMPANY", length = 100)
    private String interCompany;
    @Column(name = "FUT_USED", length = 100)
    private String futUsed;
    @Column(name = "EXTRA_SEGMENT_1", length = 100)
    private String extraSegment1;
    @Column(name = "EXTRA_SEGMENT_2", length = 100)
    private String extraSegment2;
    @Column(name = "EXTRA_SEGMENT_3", length = 100)
    private String extraSegment3;
    
    @Column(name = "JE_CATEGORY", length = 200)
    private String jeCategory;
    @Column(name = "JE_SOURCE", length = 200)
    private String jeSource;
    @Column(name = "SUMMARY_FLAG", length = 1)
    private Boolean summaryFlag;


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

    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
    }

    public String getCreditDebit() {
        return creditDebit;
    }

    public void setLedgerId(BigDecimal ledgerId) {
        this.ledgerId = ledgerId;
    }

    public BigDecimal getLedgerId() {
        return ledgerId;
    }

    public void setChartOfAccountsId(BigDecimal chartOfAccountsId) {
        this.chartOfAccountsId = chartOfAccountsId;
    }

    public BigDecimal getChartOfAccountsId() {
        return chartOfAccountsId;
    }

    public void setTaxGroupId(BigDecimal taxGroupId) {
        this.taxGroupId = taxGroupId;
    }

    public BigDecimal getTaxGroupId() {
        return taxGroupId;
    }

    public void setCostIssue(String costIssue) {
        this.costIssue = costIssue;
    }

    public String getCostIssue() {
        return costIssue;
    }

    public void setCostRMA(String costRMA) {
        this.costRMA = costRMA;
    }

    public String getCostRMA() {
        return costRMA;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setInterCompany(String interCompany) {
        this.interCompany = interCompany;
    }

    public String getInterCompany() {
        return interCompany;
    }

    public void setFutUsed(String futUsed) {
        this.futUsed = futUsed;
    }

    public String getFutUsed() {
        return futUsed;
    }

    public void setExtraSegment1(String extraSegment1) {
        this.extraSegment1 = extraSegment1;
    }

    public String getExtraSegment1() {
        return extraSegment1;
    }

    public void setExtraSegment2(String extraSegment2) {
        this.extraSegment2 = extraSegment2;
    }

    public String getExtraSegment2() {
        return extraSegment2;
    }

    public void setExtraSegment3(String extraSegment3) {
        this.extraSegment3 = extraSegment3;
    }

    public String getExtraSegment3() {
        return extraSegment3;
    }

    public void setJeCategory(String jeCategory) {
        this.jeCategory = jeCategory;
    }

    public String getJeCategory() {
        return jeCategory;
    }

    public void setJeSource(String jeSource) {
        this.jeSource = jeSource;
    }

    public String getJeSource() {
        return jeSource;
    }

    public void setSummaryFlag(Boolean summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

    public Boolean getSummaryFlag() {
        return summaryFlag;
    }

    public void setIsCash(Boolean isCash) {
        this.isCash = isCash;
    }

    public Boolean getIsCash() {
        return isCash;
    }

    public void setFixedFrieghtCharge(BigDecimal fixedFrieghtCharge) {
        this.fixedFrieghtCharge = fixedFrieghtCharge;
    }

    public BigDecimal getFixedFrieghtCharge() {
        return fixedFrieghtCharge;
    }

    public void setBankChargeRate(BigDecimal bankChargeRate) {
        this.bankChargeRate = bankChargeRate;
    }

    public BigDecimal getBankChargeRate() {
        return bankChargeRate;
    }
}
