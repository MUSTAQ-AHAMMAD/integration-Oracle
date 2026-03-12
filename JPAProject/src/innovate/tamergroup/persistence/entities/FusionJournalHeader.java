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
 * To create ID generator sequence "FUSION_JOURN_HDR_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_JOURN_HDR_ID_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionJournalHeader.findAll", query = "select o from FusionJournalHeader o"),
                @NamedQuery(name = "findJournalHeader", query =
                            "select o.status from FusionJournalHeader o where o.txnNumber = :txnNumber and o.customerType = :customerType and o.cashCredit = :cashCredit and o.region = :region order by o.requestId desc")})
@Table(name = "FUSION_JOURNAL_HEADER")
@SequenceGenerator(name = "FusionJournalHeader_Id_Seq_Gen", sequenceName = "FUSION_JOURN_HDR_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionJournalHeader implements Serializable {
    
    private static final long serialVersionUID = -7799673882912738775L;
    
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionJournalHeader_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 500)
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Column(nullable = false, length = 20)
    private String status;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(nullable = false, length = 15, name = "INTEG_MODE")
    private String integrationMode;
    @Column(nullable = false, length = 50, name = "CUSTOMER_TYPE")
    private String customerType;
    @Column(nullable = false, length = 30, name = "CASH_CREDIT")
    private String cashCredit;
    
    @Column(name = "JE_HEADER_ID")
    private BigDecimal jeHeaderId;
    @Column(name = "LEDGER_ID")
    private BigDecimal ledgerId;
    @Column(name = "BATCH_NAME")
    private String batchName;
    @Column(name = "BATCH_DESCRIPTION")
    private String batchDescription;
    @Column(name = "ACCOUNTING_PERIOD_NAME")
    private String accountingPeriodName;
    @Column(name = "USER_SOURCE_NAME")
    private String userSourceName;
    @Temporal(TemporalType.DATE)
    @Column(name = "ACCOUNTING_DATE")
    private Date accountingDate;
    @Column(name = "USER_CATEGORY_NAME")
    private String userCategoryName;
    @Column(name = "ERROR_TO_SUSPENSE_FLAG")
    private Boolean errorToSuspenseFlag;
    @Column(name = "SUMMARY_FLAG")
    private Boolean summaryFlag;
    @Column(name = "TXN_NUMBER", nullable = false)
    private BigDecimal txnNumber;
    @Column(name = "IMPORT_DESCRIPTIVE_FLEX_FIELD")
    private String importDescriptiveFlexField;
    

    public FusionJournalHeader() {
    }

    public FusionJournalHeader(String message, Date requestDate, BigDecimal requestId, String status, String region,
                               String integrationMode, BigDecimal jeHeaderId, BigDecimal ledgerId, String batchName,
                               String batchDescription, String accountingPeriodName, String userSourceName,
                               Date accountingDate, String userCategoryName, Boolean errorToSuspenseFlag,
                               Boolean summaryFlag, BigDecimal txnNumber, String importDescriptiveFlexField) {
        this.message = message;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.status = status;
        this.region = region;
        this.integrationMode = integrationMode;
        this.jeHeaderId = jeHeaderId;
        this.ledgerId = ledgerId;
        this.batchName = batchName;
        this.batchDescription = batchDescription;
        this.accountingPeriodName = accountingPeriodName;
        this.userSourceName = userSourceName;
        this.accountingDate = accountingDate;
        this.userCategoryName = userCategoryName;
        this.errorToSuspenseFlag = errorToSuspenseFlag;
        this.summaryFlag = summaryFlag;
        this.txnNumber = txnNumber;
        this.importDescriptiveFlexField = importDescriptiveFlexField;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }

    public BigDecimal getRequestId() {
        return requestId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setIntegrationMode(String integrationMode) {
        this.integrationMode = integrationMode;
    }

    public String getIntegrationMode() {
        return integrationMode;
    }

    public void setJeHeaderId(BigDecimal jeHeaderId) {
        this.jeHeaderId = jeHeaderId;
    }

    public BigDecimal getJeHeaderId() {
        return jeHeaderId;
    }

    public void setLedgerId(BigDecimal ledgerId) {
        this.ledgerId = ledgerId;
    }

    public BigDecimal getLedgerId() {
        return ledgerId;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setAccountingPeriodName(String accountingPeriodName) {
        this.accountingPeriodName = accountingPeriodName;
    }

    public String getAccountingPeriodName() {
        return accountingPeriodName;
    }

    public void setUserSourceName(String userSourceName) {
        this.userSourceName = userSourceName;
    }

    public String getUserSourceName() {
        return userSourceName;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setUserCategoryName(String userCategoryName) {
        this.userCategoryName = userCategoryName;
    }

    public String getUserCategoryName() {
        return userCategoryName;
    }

    public void setErrorToSuspenseFlag(Boolean errorToSuspenseFlag) {
        this.errorToSuspenseFlag = errorToSuspenseFlag;
    }

    public Boolean getErrorToSuspenseFlag() {
        return errorToSuspenseFlag;
    }

    public void setSummaryFlag(Boolean summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

    public Boolean getSummaryFlag() {
        return summaryFlag;
    }

    public void setTxnNumber(BigDecimal txnNumber) {
        this.txnNumber = txnNumber;
    }

    public BigDecimal getTxnNumber() {
        return txnNumber;
    }

    public void setImportDescriptiveFlexField(String importDescriptiveFlexField) {
        this.importDescriptiveFlexField = importDescriptiveFlexField;
    }

    public String getImportDescriptiveFlexField() {
        return importDescriptiveFlexField;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCashCredit(String cashCredit) {
        this.cashCredit = cashCredit;
    }

    public String getCashCredit() {
        return cashCredit;
    }
}
