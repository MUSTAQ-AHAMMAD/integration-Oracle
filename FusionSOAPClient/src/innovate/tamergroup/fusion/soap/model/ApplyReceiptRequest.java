package innovate.tamergroup.fusion.soap.model;

import java.math.BigDecimal;

import java.util.Date;

public class ApplyReceiptRequest {
    
    private Date receiptDate;
    private String transactionNumber;
    private String receiptNumber;
    private BigDecimal amountApplied;
    private String receiptCurrency;
    private String transactionSource;
    
    public ApplyReceiptRequest() {
        super();
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setAmountApplied(BigDecimal amountApplied) {
        this.amountApplied = amountApplied;
    }

    public BigDecimal getAmountApplied() {
        return amountApplied;
    }

    public void setReceiptCurrency(String receiptCurrency) {
        this.receiptCurrency = receiptCurrency;
    }

    public String getReceiptCurrency() {
        return receiptCurrency;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public String getTransactionSource() {
        return transactionSource;
    }
}
