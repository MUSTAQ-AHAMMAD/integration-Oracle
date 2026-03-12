package innovate.tamergroup.fusion.soap.model;

import java.math.BigDecimal;

import java.util.Date;

public class MiscReceiptRequest {
    
    private String currencyCode;
    private Date saleDate;
    private Long receiptMethodId;    
    private String receiptMethodName;
    private String receiptNumber;
    private String bankAccountName;    
    private String receivableActivityName;
    private Long orgId;
    private BigDecimal receiptAmount = BigDecimal.valueOf(0);    
    
    public MiscReceiptRequest() {
        super();
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setReceiptMethodName(String receiptMethodName) {
        this.receiptMethodName = receiptMethodName;
    }

    public String getReceiptMethodName() {
        return receiptMethodName;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setReceivableActivityName(String receivableActivityName) {
        this.receivableActivityName = receivableActivityName;
    }

    public String getReceivableActivityName() {
        return receivableActivityName;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptMethodId(Long receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    public Long getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }
}
