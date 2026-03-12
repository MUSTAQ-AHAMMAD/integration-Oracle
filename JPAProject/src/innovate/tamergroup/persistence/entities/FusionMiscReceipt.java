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
 * To create ID generator sequence "FUSION_MISC_RECEIPT_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_MISC_RECEIPT_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionMiscReceipt.findAll", query = "select o from FusionMiscReceipt o"),
                @NamedQuery(name = "findMiscReceipt",
                            query =
                            "select o.status from FusionMiscReceipt o where o.receiptNumber = :receiptNumber and o.region = :region order by o.requestId desc")
    })
@Table(name = "FUSION_MISC_RECEIPT")
@SequenceGenerator(name = "FusionMiscReceipt_Id_Seq_Gen", sequenceName = "FUSION_MISC_RECEIPT_ID_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionMiscReceipt implements Serializable {
    private static final long serialVersionUID = 6437927361393046042L;
    private double amount;
    @Column(name = "BANK_ACC_NUMBER", length = 20)
    private String bankAccNumber;
    @Column(name = "CURRENCY_CODE", length = 5)
    private String currencyCode;
    @Temporal(TemporalType.DATE)
    @Column(name = "EXCHANGE_DATE")
    private Date exchangeDate;
    @Column(name = "EXCHANGE_RATE_TYPE", length = 20)
    private String exchangeRateType;
    @Temporal(TemporalType.DATE)
    @Column(name = "GL_DATE")
    private Date glDate;
    @Column(nullable = false, length = 500)
    private String message;
    @Column(name = "REC_ACTIVITY_NAME", length = 20)
    private String recActivityName;
    @Temporal(TemporalType.DATE)
    @Column(name = "RECEIPT_DATE")
    private Date receiptDate;
    @Column(name = "RECEIPT_METHOD_NAME", length = 20)
    private String receiptMethodName;
    @Column(name = "RECEIPT_NUMBER", length = 30)
    private String receiptNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionMiscReceipt_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 20)
    private String status;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(nullable = false, length = 15, name = "INTEG_MODE")
    private String integrationMode;

    public FusionMiscReceipt() {
    }


    public FusionMiscReceipt(double amount, String bankAccNumber, String currencyCode, Date exchangeDate,
                             String exchangeRateType, Date glDate, String message, String recActivityName,
                             Date receiptDate, String receiptMethodName, String receiptNumber, Date requestDate,
                             BigDecimal requestId, BigDecimal rowId, String status, String region,
                             String integrationMode) {
        this.amount = amount;
        this.bankAccNumber = bankAccNumber;
        this.currencyCode = currencyCode;
        this.exchangeDate = exchangeDate;
        this.exchangeRateType = exchangeRateType;
        this.glDate = glDate;
        this.message = message;
        this.recActivityName = recActivityName;
        this.receiptDate = receiptDate;
        this.receiptMethodName = receiptMethodName;
        this.receiptNumber = receiptNumber;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.rowId = rowId;
        this.status = status;
        this.region = region;
        this.integrationMode = integrationMode;
    }

    public void setIntegrationMode(String integrationMode) {
        this.integrationMode = integrationMode;
    }

    public String getIntegrationMode() {
        return integrationMode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBankAccNumber() {
        return bankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        this.bankAccNumber = bankAccNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getExchangeRateType() {
        return exchangeRateType;
    }

    public void setExchangeRateType(String exchangeRateType) {
        this.exchangeRateType = exchangeRateType;
    }

    public Date getGlDate() {
        return glDate;
    }

    public void setGlDate(Date glDate) {
        this.glDate = glDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecActivityName() {
        return recActivityName;
    }

    public void setRecActivityName(String recActivityName) {
        this.recActivityName = recActivityName;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptMethod) {
        this.receiptDate = receiptMethod;
    }

    public String getReceiptMethodName() {
        return receiptMethodName;
    }

    public void setReceiptMethodName(String receiptMethodName) {
        this.receiptMethodName = receiptMethodName;
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

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
