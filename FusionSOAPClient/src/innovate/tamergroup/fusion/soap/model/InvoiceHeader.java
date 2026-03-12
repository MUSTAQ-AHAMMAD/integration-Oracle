package innovate.tamergroup.fusion.soap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceHeader {
    
    private String billToCustomerName;
    private String billToLocation;
    private String billToAccountNumber;
    private String businessUnit;
    private String outletName;
    private Date saleDate;
    private String paymentTermsName;
    private String transactionSource;
    private String transactionType;
    private String invoiceCurrencyCode;
    private String conversionRateType;
    private List<InvoiceLineModel> invoiceLines = new ArrayList<>();

    
    public InvoiceHeader() {
        super();
    }

    public void setBillToCustomerName(String billToCustomerName) {
        this.billToCustomerName = billToCustomerName;
    }

    public String getBillToCustomerName() {
        return billToCustomerName;
    }

    public void setBillToLocation(String billToLocation) {
        this.billToLocation = billToLocation;
    }

    public String getBillToLocation() {
        return billToLocation;
    }

    public void setBillToAccountNumber(String billToAccountNumber) {
        this.billToAccountNumber = billToAccountNumber;
    }

    public String getBillToAccountNumber() {
        return billToAccountNumber;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setInvoiceCurrencyCode(String invoiceCurrencyCode) {
        this.invoiceCurrencyCode = invoiceCurrencyCode;
    }

    public String getInvoiceCurrencyCode() {
        return invoiceCurrencyCode;
    }

    public void setConversionRateType(String conversionRateType) {
        this.conversionRateType = conversionRateType;
    }

    public String getConversionRateType() {
        return conversionRateType;
    }
    
    public void setInvoiceLines(List<InvoiceLineModel> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public List<InvoiceLineModel> getInvoiceLines() {
        return invoiceLines;
    }

    public void setPaymentTermsName(String paymentTermsName) {
        this.paymentTermsName = paymentTermsName;
    }

    public String getPaymentTermsName() {
        return paymentTermsName;
    }
}
