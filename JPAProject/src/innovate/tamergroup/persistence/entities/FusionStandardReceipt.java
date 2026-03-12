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
 * To create ID generator sequence "FUSION_STANDARD_RECEIPT_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_STANDARD_RECEIPT_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionStandardReceipt.findAll", query = "select o from FusionStandardReceipt o"),
                @NamedQuery(name = "findStandardReceipt",
                            query =
                            "select o.status from FusionStandardReceipt o where o.receiptNumber = :receiptNumber and o.region = :region order by o.requestId desc")
    })
@Table(name = "FUSION_STANDARD_RECEIPT")
@SequenceGenerator(name = "FusionStandardReceipt_Id_Seq_Gen", sequenceName = "FUSION_STANDARD_REC_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionStandardReceipt implements Serializable {
    private static final long serialVersionUID = -985474863827234765L;
    private double amount;
    @Column(name = "CURRENCY_CODE", length = 5)
    private String currencyCode;
    @Column(name = "CUSTOMER_ID")
    private BigDecimal customerId;
    @Temporal(TemporalType.DATE)
    @Column(name = "DEPOSIT_DATE")
    private Date depositDate;
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
    @Column(name = "ORG_ID")
    private BigDecimal orgId;
    @Temporal(TemporalType.DATE)
    @Column(name = "RECEIPT_DATE")
    private Date receiptDate;
    @Column(name = "RECEIPT_METHOD_ID")
    private BigDecimal receiptMethodId;
    @Column(name = "RECEIPT_NUMBER", length = 20)
    private String receiptNumber;
    @Column(name = "REMITTANCE_BACK_ACC_ID", length = 20)
    private String remittanceBackAccId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionStandardReceipt_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 10)
    private String status;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(nullable = false, length = 15, name = "INTEG_MODE")
    private String integrationMode;

    public FusionStandardReceipt() {
    }


    public FusionStandardReceipt(double amount, String currencyCode, BigDecimal customerId, Date depositDate,
                                 Date exchangeDate, String exchangeRateType, Date glDate, String message,
                                 BigDecimal orgId, Date receiptDate, BigDecimal receiptMethodId, String receiptNumber,
                                 String remittanceBackAccId, Date requestDate, BigDecimal requestId, BigDecimal rowId,
                                 String status, String region, String integrationMode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.customerId = customerId;
        this.depositDate = depositDate;
        this.exchangeDate = exchangeDate;
        this.exchangeRateType = exchangeRateType;
        this.glDate = glDate;
        this.message = message;
        this.orgId = orgId;
        this.receiptDate = receiptDate;
        this.receiptMethodId = receiptMethodId;
        this.receiptNumber = receiptNumber;
        this.remittanceBackAccId = remittanceBackAccId;
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigDecimal customerId) {
        this.customerId = customerId;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
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

    public BigDecimal getOrgId() {
        return orgId;
    }

    public void setOrgId(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public BigDecimal getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setReceiptMethodId(BigDecimal receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getRemittanceBackAccId() {
        return remittanceBackAccId;
    }

    public void setRemittanceBackAccId(String remittanceBackAccId) {
        this.remittanceBackAccId = remittanceBackAccId;
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
