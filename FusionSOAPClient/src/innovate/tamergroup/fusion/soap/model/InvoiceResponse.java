package innovate.tamergroup.fusion.soap.model;

public class InvoiceResponse {
    
    private Long customerTransactionId;
    private String transactionNumber;
    private String serviceStatus;
    
    public InvoiceResponse() {
        super();
    }
    
    public InvoiceResponse(String transactionNumber) {
        super();
        this.transactionNumber = transactionNumber;
        this.serviceStatus = "S";
    }

    public void setCustomerTransactionId(Long customerTransactionId) {
        this.customerTransactionId = customerTransactionId;
    }

    public Long getCustomerTransactionId() {
        return customerTransactionId;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }
}
