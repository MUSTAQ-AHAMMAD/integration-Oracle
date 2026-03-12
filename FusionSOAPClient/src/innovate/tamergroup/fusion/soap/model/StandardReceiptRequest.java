package innovate.tamergroup.fusion.soap.model;

import java.math.BigDecimal;

import java.util.Date;

public class StandardReceiptRequest {
    
    private String currencyCode;
    private Date saleDate;
    private Long receiptMethodId;
    private String receiptNumber;
    private Long remittanceBankAccountId;
    private String accountValue;
    private String region;
    private Long orgId;
    private Long customerId;
    private BigDecimal receiptAmount = BigDecimal.valueOf(0);
    
    public StandardReceiptRequest() {
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

    public void setReceiptMethodId(Long receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    public Long getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setRemittanceBankAccountId(Long remittanceBankAccountId) {
        this.remittanceBankAccountId = remittanceBankAccountId;
    }

    public Long getRemittanceBankAccountId() {
        return remittanceBankAccountId;
    }

    public void setAccountValue(String accountValue) {
        this.accountValue = accountValue;
    }

    public String getAccountValue() {
        return accountValue;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
