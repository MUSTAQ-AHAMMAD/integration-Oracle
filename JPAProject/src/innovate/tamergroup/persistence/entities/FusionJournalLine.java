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
 * To create ID generator sequence "FUSION_JOURN_LINE_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_JOURN_LINE_ID_SEQ_GEN" INCREMENT BY 1 START WITH 1;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionJournalLine.findAll", query = "select o from FusionJournalLine o")})
@Table(name = "FUSION_JOURNAL_LINE")
@SequenceGenerator(name = "FusionJournalLine_Id_Seq_Gen", sequenceName = "FUSION_JOURN_LINE_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionJournalLine implements Serializable {
    
    private static final long serialVersionUID = 3346861130892450854L;
    
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionJournalLine_Id_Seq_Gen")
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
    
    @Column(name = "TXN_NUMBER", nullable = false)
    private BigDecimal txnNumber;
    @Column(name = "JE_HEADER_ID")
    private BigDecimal jeHeaderId;
    @Column(name = "JE_LINE_NUM")
    private BigDecimal jeLineNum;
    
    @Column(name = "PERIOD_NAME")
    private String periodName;
    @Column(name = "USER_JE_SOURCE_NAME")
    private String userJeSourceName;
    @Column(name = "USER_JE_CATEGORY_NAME")
    private String userJeCategoryName;
    @Column(name = "SEGMENT1")
    private String segment1;
    @Column(name = "SEGMENT2")
    private String segment2;
    @Column(name = "SEGMENT3")
    private String segment3;
    @Column(name = "SEGMENT4")
    private String segment4;
    @Column(name = "SEGMENT5")
    private String segment5;
    @Column(name = "SEGMENT6")
    private String segment6;
    @Column(name = "SEGMENT7")
    private String segment7;
    @Column(name = "SEGMENT8")
    private String segment8;
    @Column(name = "SEGMENT9")
    private String segment9;
    @Column(name = "SEGMENT10")
    private String segment10;
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Column(name = "SALES_ORDER")
    private String salesOrder;
    @Column(name = "USER_CURRENCY_CONVERSION_TYPE")
    private String userCurrencyConversionType;
    @Column(name = "CURRENCY_CONVERSION_TYPE")
    private String currencyConversionType;
    @Column(name = "JE_CATEGORY_NAME")
    private String jeCategoryName;
    @Column(name = "JE_SOURCE_NAME")
    private String jeSourceName;
    @Column(name = "TAX_CODE")
    private String taxCode;
    @Column(name = "RECORD_TYPE")
    private String recordType;
    @Column(nullable = false, length = 50, name = "CUSTOMER_TYPE")
    private String customerType;
    @Column(nullable = false, length = 30, name = "CASH_CREDIT")
    private String cashCredit;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "ACCOUNTING_DATE")
    private Date accountingDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "CURRENCY_CONVERSION_DATE")
    private Date currencyConversionDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;


    @Column(name = "LEDGER_ID")
    private BigDecimal ledgerId;
    @Column(name = "GROUP_ID")
    private BigDecimal groupId;
    @Column(name = "CHART_OF_ACCOUNTS_ID")
    private BigDecimal chartOfAccountsId;
    @Column(name = "ENTERED_CR_AMOUNT")
    private BigDecimal enteredCrAmount;
    @Column(name = "ACCOUNTED_CR")
    private BigDecimal accountedCr;
    @Column(name = "ENTERED_DR_AMOUNT")
    private BigDecimal enteredDrAmount;
    @Column(name = "ACCOUNTED_DR")
    private BigDecimal accountedDr;
    @Column(name = "CURRENCY_CONVERSION_RATE")
    private BigDecimal currencyConversionRate;
    
    @Column(name = "AVERAGE_JOURNAL_FLAG")
    private Boolean averageJournalFlag;

    public FusionJournalLine() {
    }

    public FusionJournalLine(String message, Date requestDate, BigDecimal requestId, String status, String region,
                             BigDecimal txnNumber, BigDecimal jeHeaderId, BigDecimal jeLineNum, String periodName,
                             String userJeSourceName, String userJeCategoryName, String segment1, String segment2,
                             String segment3, String segment4, String segment5, String segment6, String segment7,
                             String segment8, String segment9, String segment10, String currencyCode, String salesOrder,
                             String userCurrencyConversionType, String currencyConversionType, String jeCategoryName,
                             String jeSourceName, String taxCode, String recordType, Date accountingDate,
                             Date currencyConversionDate, Date transactionDate, BigDecimal ledgerId, BigDecimal groupId,
                             BigDecimal chartOfAccountsId, BigDecimal enteredCrAmount, BigDecimal accountedCr,
                             BigDecimal enteredDrAmount, BigDecimal accountedDr, BigDecimal currencyConversionRate,
                             Boolean averageJournalFlag) {
        this.message = message;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.status = status;
        this.region = region;
        this.txnNumber = txnNumber;
        this.jeHeaderId = jeHeaderId;
        this.jeLineNum = jeLineNum;
        this.periodName = periodName;
        this.userJeSourceName = userJeSourceName;
        this.userJeCategoryName = userJeCategoryName;
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
        this.segment4 = segment4;
        this.segment5 = segment5;
        this.segment6 = segment6;
        this.segment7 = segment7;
        this.segment8 = segment8;
        this.segment9 = segment9;
        this.segment10 = segment10;
        this.currencyCode = currencyCode;
        this.salesOrder = salesOrder;
        this.userCurrencyConversionType = userCurrencyConversionType;
        this.currencyConversionType = currencyConversionType;
        this.jeCategoryName = jeCategoryName;
        this.jeSourceName = jeSourceName;
        this.taxCode = taxCode;
        this.recordType = recordType;
        this.accountingDate = accountingDate;
        this.currencyConversionDate = currencyConversionDate;
        this.transactionDate = transactionDate;
        this.ledgerId = ledgerId;
        this.groupId = groupId;
        this.chartOfAccountsId = chartOfAccountsId;
        this.enteredCrAmount = enteredCrAmount;
        this.accountedCr = accountedCr;
        this.enteredDrAmount = enteredDrAmount;
        this.accountedDr = accountedDr;
        this.currencyConversionRate = currencyConversionRate;
        this.averageJournalFlag = averageJournalFlag;
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

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getPeriodName() {
        return periodName;
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

    public void setUserCurrencyConversionType(String userCurrencyConversionType) {
        this.userCurrencyConversionType = userCurrencyConversionType;
    }

    public String getUserCurrencyConversionType() {
        return userCurrencyConversionType;
    }

    public void setCurrencyConversionType(String currencyConversionType) {
        this.currencyConversionType = currencyConversionType;
    }

    public String getCurrencyConversionType() {
        return currencyConversionType;
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

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setCurrencyConversionDate(Date currencyConversionDate) {
        this.currencyConversionDate = currencyConversionDate;
    }

    public Date getCurrencyConversionDate() {
        return currencyConversionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setLedgerId(BigDecimal ledgerId) {
        this.ledgerId = ledgerId;
    }

    public BigDecimal getLedgerId() {
        return ledgerId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setChartOfAccountsId(BigDecimal chartOfAccountsId) {
        this.chartOfAccountsId = chartOfAccountsId;
    }

    public BigDecimal getChartOfAccountsId() {
        return chartOfAccountsId;
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

    public void setCurrencyConversionRate(BigDecimal currencyConversionRate) {
        this.currencyConversionRate = currencyConversionRate;
    }

    public BigDecimal getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    public void setAverageJournalFlag(Boolean averageJournalFlag) {
        this.averageJournalFlag = averageJournalFlag;
    }

    public Boolean getAverageJournalFlag() {
        return averageJournalFlag;
    }

    public void setJeHeaderId(BigDecimal jeHeaderId) {
        this.jeHeaderId = jeHeaderId;
    }

    public BigDecimal getJeHeaderId() {
        return jeHeaderId;
    }

    public void setJeLineNum(BigDecimal jeLineNum) {
        this.jeLineNum = jeLineNum;
    }

    public BigDecimal getJeLineNum() {
        return jeLineNum;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setTxnNumber(BigDecimal txnNumber) {
        this.txnNumber = txnNumber;
    }

    public BigDecimal getTxnNumber() {
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
