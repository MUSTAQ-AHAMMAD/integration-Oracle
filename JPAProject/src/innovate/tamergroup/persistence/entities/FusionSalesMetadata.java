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
@NamedQueries({ @NamedQuery(name = "FusionSalesMetadata.findAll", query = "select o from FusionSalesMetadata o"),
                @NamedQuery(name = "findSalesMetaData",
                            query =
                            "select o from FusionSalesMetadata o where o.subInventory = :subInventory and o.integrationSource = :integrationSource and o.region = :region and o.customerType = :customerType"),
                                @NamedQuery(name = "findSalesMetaDataAll",
                            query =
                            "select o from FusionSalesMetadata o where o.subInventory = :subInventory and o.integrationSource = :integrationSource and o.region = :region")
    })
@Table(name = "FUSION_SALES_METADATA")
public class FusionSalesMetadata implements Serializable {
    private static final long serialVersionUID = 7874266311455724334L;
    @Column(name = "BILL_TO_ACCOUNT", nullable = false)
    private BigDecimal billToAccount;
    @Column(name = "BILL_TO_NAME", nullable = false, unique = true, length = 50)
    private String billToName;
    @Column(name = "BUSINESS_UNIT", nullable = false, length = 20)
    private String businessUnit;
    @Column(name = "RATE_IS_CORPORATE", nullable = false)
    private String rateIsCorporate;
    @Column(name = "REC_ACTIVITY_NAME_BANK", nullable = false, length = 30)
    private String recActivityNameBank;
    @Column(name = "REC_ACTIVITY_NAME_CASH", nullable = false, length = 30)
    private String recActivityNameCash;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    private BigDecimal rowId;
    @Column(name = "SITE_NUMBER", nullable = false, length = 20)
    private String siteNumber;
    @Column(name = "TXN_SOURCE", nullable = false, length = 20)
    private String txnSource;
    @Column(name = "TXN_TYPE", nullable = false, length = 20)
    private String txnType;
    @Column(name = "SUBINVENTORY", nullable = false, length = 30)
    private String subInventory;
    @Column(name = "CUSTOMER_TYPE", nullable = false, length = 30)
    private String customerType;
    @Column(name = "INTEGRATION_SOURCE", nullable = false, length = 20)
    private String integrationSource;
    @Column(name = "DISTRIBUTION_ACC_ID", nullable = false)
    private BigDecimal distributionAccId;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(length = 10, name = "COST_CENTER_CODE")
    private String costCenterCode;
    

    public FusionSalesMetadata() {
    }


    public FusionSalesMetadata(BigDecimal billToAccount, String billToName, String businessUnit, String rateIsCorporate,
                               String recActivityNameBank, String recActivityNameCash, BigDecimal rowId,
                               String siteNumber, String txnSource, String txnType, String subInventory,
                               String integrationSource, BigDecimal distributionAccId) {
        this.billToAccount = billToAccount;
        this.billToName = billToName;
        this.businessUnit = businessUnit;
        this.rateIsCorporate = rateIsCorporate;
        this.recActivityNameBank = recActivityNameBank;
        this.recActivityNameCash = recActivityNameCash;
        this.rowId = rowId;
        this.siteNumber = siteNumber;
        this.txnSource = txnSource;
        this.txnType = txnType;
        this.subInventory = subInventory;
        this.integrationSource = integrationSource;
        this.distributionAccId = distributionAccId;
    }


    public void setBillToAccount(BigDecimal billToAccount) {
        this.billToAccount = billToAccount;
    }

    public BigDecimal getBillToAccount() {
        return billToAccount;
    }

    public void setBillToName(String billToName) {
        this.billToName = billToName;
    }

    public String getBillToName() {
        return billToName;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setRateIsCorporate(String rateIsCorporate) {
        this.rateIsCorporate = rateIsCorporate;
    }

    public String getRateIsCorporate() {
        return rateIsCorporate;
    }

    public void setRecActivityNameBank(String recActivityNameBank) {
        this.recActivityNameBank = recActivityNameBank;
    }

    public String getRecActivityNameBank() {
        return recActivityNameBank;
    }

    public void setRecActivityNameCash(String recActivityNameCash) {
        this.recActivityNameCash = recActivityNameCash;
    }

    public String getRecActivityNameCash() {
        return recActivityNameCash;
    }

    public void setRowId(BigDecimal rowId) {
        this.rowId = rowId;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setSiteNumber(String siteNumber) {
        this.siteNumber = siteNumber;
    }

    public String getSiteNumber() {
        return siteNumber;
    }

    public void setTxnSource(String txnSource) {
        this.txnSource = txnSource;
    }

    public String getTxnSource() {
        return txnSource;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setSubInventory(String subInventory) {
        this.subInventory = subInventory;
    }

    public String getSubInventory() {
        return subInventory;
    }

    public void setIntegrationSource(String integrationSource) {
        this.integrationSource = integrationSource;
    }

    public String getIntegrationSource() {
        return integrationSource;
    }

    public void setDistributionAccId(BigDecimal distributionAccId) {
        this.distributionAccId = distributionAccId;
    }

    public BigDecimal getDistributionAccId() {
        return distributionAccId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }
}
