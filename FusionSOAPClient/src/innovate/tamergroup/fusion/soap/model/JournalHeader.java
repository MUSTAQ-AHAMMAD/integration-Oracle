package innovate.tamergroup.fusion.soap.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class JournalHeader {
    
    private Long jeHeaderId;
    private String batchName;
    private String batchDescription;
    private Long ledgerId;
    private String accountingPeriodName;
    private Date accountingDate;
    private String userSourceName;
    private String userCategoryName;
    private Boolean errorToSuspenseFlag;
    private Boolean summaryFlag;
    private String importDescriptiveFlexField;
    private Long txnNumber;
    private String customerType;
    private String cashCredit;
    private List<JournalLine> journalLines = new ArrayList<>();
    

    
    public JournalHeader() {
        super();
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

    public void setLedgerId(Long ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Long getLedgerId() {
        return ledgerId;
    }

    public void setAccountingPeriodName(String accountingPeriodName) {
        this.accountingPeriodName = accountingPeriodName;
    }

    public String getAccountingPeriodName() {
        return accountingPeriodName;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setUserSourceName(String userSourceName) {
        this.userSourceName = userSourceName;
    }

    public String getUserSourceName() {
        return userSourceName;
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

    public void setImportDescriptiveFlexField(String importDescriptiveFlexField) {
        this.importDescriptiveFlexField = importDescriptiveFlexField;
    }

    public String getImportDescriptiveFlexField() {
        return importDescriptiveFlexField;
    }

    public void setJournalLines(List<JournalLine> journalLines) {
        this.journalLines = journalLines;
    }

    public List<JournalLine> getJournalLines() {
        return journalLines;
    }

    public void setJeHeaderId(Long jeHeaderId) {
        this.jeHeaderId = jeHeaderId;
    }

    public Long getJeHeaderId() {
        return jeHeaderId;
    }

    public void setTxnNumber(Long txnNumber) {
        this.txnNumber = txnNumber;
    }

    public Long getTxnNumber() {
        return txnNumber;
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
