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
 * To create ID generator sequence "FUSION_INVOICE_HEADER_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_INVOICE_HEADER_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionInvoiceHeader.findAll", query = "select o from FusionInvoiceHeader o") })
@Table(name = "FUSION_INVOICE_HEADER")
@SequenceGenerator(name = "FusionInvoiceHeader_Id_Seq_Gen", sequenceName = "FUSION_INVOICE_HEADER_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionInvoiceHeader implements Serializable {
    private static final long serialVersionUID = -7799673882912738775L;
    @Column(name = "BILL_TO_ACC_NUMBER")
    private BigDecimal billToAccNumber;
    @Column(name = "BILL_TO_CUST_NAME", length = 30)
    private String billToCustName;
    @Column(name = "BILL_TO_LOCATION", length = 20)
    private String billToLocation;
    @Column(name = "BUSINESS_UNIT", length = 30)
    private String businessUnit;
    @Column(name = "CURRENCY_CODE", length = 5)
    private String currencyCode;
    @Temporal(TemporalType.DATE)
    @Column(name = "GL_DATE")
    private Date glDate;
    @Column(nullable = false, length = 500)
    private String message;
    @Column(name = "PAYMENT_TERMS_NAME", length = 20)
    private String paymentTermsName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionInvoiceHeader_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 20)
    private String status;
    @Temporal(TemporalType.DATE)
    @Column(name = "TXN_DATE")
    private Date txnDate;
    @Column(name = "TXN_SOURCE", length = 20)
    private String txnSource;
    @Column(name = "TXN_TYPE", length = 20)
    private String txnType;
    @Column(name = "TXN_NUMBER")
    private BigDecimal txnNumber;
    @Column(name = "CUSTOMER_TXN_ID")
    private BigDecimal customerTxnId;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public FusionInvoiceHeader() {
    }


    public FusionInvoiceHeader(BigDecimal billToAccNumber, String billToCustName, String billToLocation,
                               String businessUnit, String currencyCode, Date glDate, String message,
                               String paymentTermsName, Date requestDate, BigDecimal requestId, BigDecimal rowId,
                               String status, Date txnDate, String txnSource, String txnType, BigDecimal txnNumber,
                               BigDecimal customerTxnId) {
        this.billToAccNumber = billToAccNumber;
        this.billToCustName = billToCustName;
        this.billToLocation = billToLocation;
        this.businessUnit = businessUnit;
        this.currencyCode = currencyCode;
        this.glDate = glDate;
        this.message = message;
        this.paymentTermsName = paymentTermsName;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.rowId = rowId;
        this.status = status;
        this.txnDate = txnDate;
        this.txnSource = txnSource;
        this.txnType = txnType;
        this.txnNumber = txnNumber;
        this.customerTxnId = customerTxnId;
    }

    public BigDecimal getBillToAccNumber() {
        return billToAccNumber;
    }

    public void setBillToAccNumber(BigDecimal billToAccNumber) {
        this.billToAccNumber = billToAccNumber;
    }

    public String getBillToCustName() {
        return billToCustName;
    }

    public void setBillToCustName(String billToCustName) {
        this.billToCustName = billToCustName;
    }

    public String getBillToLocation() {
        return billToLocation;
    }

    public void setBillToLocation(String billToLocation) {
        this.billToLocation = billToLocation;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    public String getPaymentTermsName() {
        return paymentTermsName;
    }

    public void setPaymentTermsName(String paymentTermsName) {
        this.paymentTermsName = paymentTermsName;
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

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnSource() {
        return txnSource;
    }

    public void setTxnSource(String txnSource) {
        this.txnSource = txnSource;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public void setTxnNumber(BigDecimal txnNumber) {
        this.txnNumber = txnNumber;
    }

    public BigDecimal getTxnNumber() {
        return txnNumber;
    }

    public void setCustomerTxnId(BigDecimal customerTxnId) {
        this.customerTxnId = customerTxnId;
    }

    public BigDecimal getCustomerTxnId() {
        return customerTxnId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
