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
 * To create ID generator sequence "FUSION_APPLY_RECEIPT_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_APPLY_RECEIPT_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionApplyReceipt.findAll", query = "select o from FusionApplyReceipt o"),
                @NamedQuery(name = "findApplyReceipt",
                            query =
                            "select o.status from FusionApplyReceipt o where o.receiptNumber = :receiptNumber and o.region = :region order by o.requestId desc")
    })
@Table(name = "FUSION_APPLY_RECEIPT")
@SequenceGenerator(name = "FusionApplyReceipt_Id_Seq_Gen", sequenceName = "FUSION_APPLY_RECEIPT_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionApplyReceipt implements Serializable {
    private static final long serialVersionUID = 2771778458718168881L;
    @Temporal(TemporalType.DATE)
    @Column(name = "ACCOUNTING_DATE")
    private Date accountingDate;
    @Column(name = "AMOUNT_APPLIED")
    private double amountApplied;
    @Temporal(TemporalType.DATE)
    @Column(name = "APPLICATION_DATE")
    private Date applicationDate;
    @Column(name = "CURRENCY_CODE", length = 5)
    private String currencyCode;
    @Column(nullable = false, length = 500)
    private String message;
    @Column(name = "RECEIPT_NUMBER", length = 20)
    private String receiptNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionApplyReceipt_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 20)
    private String status;
    @Column(name = "TXN_NUMBER", length = 20)
    private String txnNumber;
    @Column(name = "TXN_SOURCE", length = 30)
    private String txnSource;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(nullable = false, length = 15, name = "INTEG_MODE")
    private String integrationMode;

    public FusionApplyReceipt() {
    }


    public FusionApplyReceipt(Date accountingDate, double amountApplied, Date applicationDate, String currencyCode,
                              String message, String receiptNumber, Date requestDate, BigDecimal requestId,
                              String status, String txnNumber, String txnSource, String region,
                              String integrationMode) {
        this.accountingDate = accountingDate;
        this.amountApplied = amountApplied;
        this.applicationDate = applicationDate;
        this.currencyCode = currencyCode;
        this.message = message;
        this.receiptNumber = receiptNumber;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.status = status;
        this.txnNumber = txnNumber;
        this.txnSource = txnSource;
        this.region = region;
        this.integrationMode = integrationMode;
    }


    public void setTxnSource(String txnSource) {
        this.txnSource = txnSource;
    }

    public String getTxnSource() {
        return txnSource;
    }

    public void setIntegrationMode(String integrationMode) {
        this.integrationMode = integrationMode;
    }

    public String getIntegrationMode() {
        return integrationMode;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public double getAmountApplied() {
        return amountApplied;
    }

    public void setAmountApplied(double amountApplied) {
        this.amountApplied = amountApplied;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public BigDecimal getRequestId() {
        return requestId;
    }

    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTxnNumber() {
        return txnNumber;
    }

    public void setTxnNumber(String txnNumber) {
        this.txnNumber = txnNumber;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
