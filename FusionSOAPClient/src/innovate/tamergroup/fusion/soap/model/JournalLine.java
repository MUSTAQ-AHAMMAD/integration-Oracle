package innovate.tamergroup.fusion.soap.model;

import java.math.BigDecimal;
import java.util.Date;

public class JournalLine {
    
    private Long jeHeaderId;
    private Integer jeLineNum;
    private Long ledgerId;
    private String periodName;
    private Date accountingDate;
    private String userJeSourceName;
    private String userJeCategoryName;
    private Long groupId;
    private Long chartOfAccountsId;
    private String salesOrder;
    private String segment1;
    private String segment2;
    private String segment3;
    private String segment4;
    private String segment5;
    private String segment6;
    private String segment7;
    private String segment8;
    private String segment9;
    private String segment10;
    private String currencyCode;
    private BigDecimal enteredCrAmount;
    private BigDecimal accountedCr;
    private BigDecimal enteredDrAmount;
    private BigDecimal accountedDr;
    private String userCurrencyConversionType;
    private Date currencyConversionDate;
    private BigDecimal currencyConversionRate;
    private String currencyConversionType;
    private Boolean averageJournalFlag;
    private String jeCategoryName;
    private String jeSourceName;
    private String status;
    private String taxCode;
    private Date transactionDate;
    private String recordType;
    
    public JournalLine() {
        super();
    }


    public void setLedgerId(Long ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Long getLedgerId() {
        return ledgerId;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setUserJeSourceName(String userJeSourceName) {
        this.userJeSourceName = userJeSourceName;
    }

    public String getUserJeSourceName() {
        return userJeSourceName;
    }

    public void setUserJeCategoryName(String userJeCategoryName) {
        this.userJeCategoryName = userJeCategoryName;
    }

    public String getUserJeCategoryName() {
        return userJeCategoryName;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setChartOfAccountsId(Long chartOfAccountsId) {
        this.chartOfAccountsId = chartOfAccountsId;
    }

    public long getChartOfAccountsId() {
        return chartOfAccountsId;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment2(String segment2) {
        this.segment2 = segment2;
    }

    public String getSegment2() {
        return segment2;
    }

    public void setSegment3(String segment3) {
        this.segment3 = segment3;
    }

    public String getSegment3() {
        return segment3;
    }

    public void setSegment4(String segment4) {
        this.segment4 = segment4;
    }

    public String getSegment4() {
        return segment4;
    }

    public void setSegment5(String segment5) {
        this.segment5 = segment5;
    }

    public String getSegment5() {
        return segment5;
    }

    public void setSegment6(String segment6) {
        this.segment6 = segment6;
    }

    public String getSegment6() {
        return segment6;
    }

    public void setSegment7(String segment7) {
        this.segment7 = segment7;
    }

    public String getSegment7() {
        return segment7;
    }

    public void setSegment8(String segment8) {
        this.segment8 = segment8;
    }

    public String getSegment8() {
        return segment8;
    }

    public void setSegment9(String segment9) {
        this.segment9 = segment9;
    }

    public String getSegment9() {
        return segment9;
    }

    public void setSegment10(String segment10) {
        this.segment10 = segment10;
    }

    public String getSegment10() {
        return segment10;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setEnteredCrAmount(BigDecimal enteredCrAmount) {
        this.enteredCrAmount = enteredCrAmount;
    }

    public BigDecimal getEnteredCrAmount() {
        return enteredCrAmount;
    }

    public void setAccountedCr(BigDecimal accountedCr) {
        this.accountedCr = accountedCr;
    }

    public BigDecimal getAccountedCr() {
        return accountedCr;
    }

    public void setEnteredDrAmount(BigDecimal enteredDrAmount) {
        this.enteredDrAmount = enteredDrAmount;
    }

    public BigDecimal getEnteredDrAmount() {
        return enteredDrAmount;
    }

    public void setAccountedDr(BigDecimal accountedDr) {
        this.accountedDr = accountedDr;
    }

    public BigDecimal getAccountedDr() {
        return accountedDr;
    }

    public void setUserCurrencyConversionType(String userCurrencyConversionType) {
        this.userCurrencyConversionType = userCurrencyConversionType;
    }

    public String getUserCurrencyConversionType() {
        return userCurrencyConversionType;
    }

    public void setCurrencyConversionDate(Date currencyConversionDate) {
        this.currencyConversionDate = currencyConversionDate;
    }

    public Date getCurrencyConversionDate() {
        return currencyConversionDate;
    }

    public void setCurrencyConversionRate(BigDecimal currencyConversionRate) {
        this.currencyConversionRate = currencyConversionRate;
    }

    public BigDecimal getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    public void setCurrencyConversionType(String currencyConversionType) {
        this.currencyConversionType = currencyConversionType;
    }

    public String getCurrencyConversionType() {
        return currencyConversionType;
    }

    public void setAverageJournalFlag(Boolean averageJournalFlag) {
        this.averageJournalFlag = averageJournalFlag;
    }

    public Boolean getAverageJournalFlag() {
        return averageJournalFlag;
    }

    public void setJeCategoryName(String jeCategoryName) {
        this.jeCategoryName = jeCategoryName;
    }

    public String getJeCategoryName() {
        return jeCategoryName;
    }

    public void setJeSourceName(String jeSourceName) {
        this.jeSourceName = jeSourceName;
    }

    public String getJeSourceName() {
        return jeSourceName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setJeHeaderId(Long jeHeaderId) {
        this.jeHeaderId = jeHeaderId;
    }

    public Long getJeHeaderId() {
        return jeHeaderId;
    }

    public void setJeLineNum(Integer jeLineNum) {
        this.jeLineNum = jeLineNum;
    }

    public Integer getJeLineNum() {
        return jeLineNum;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getSalesOrder() {
        return salesOrder;
    }
}
