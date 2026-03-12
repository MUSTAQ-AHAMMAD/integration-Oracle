package innovate.tamergroup.fusion.soap.model;

import java.math.BigDecimal;

public class InvoiceLineModel {
    
    private Integer lineNumber;
    private String itemNumber;
    private String memoLineName;
    private BigDecimal quantity;
    private String uomCode;
    private String description;
    private String currencyCode;
    private BigDecimal unitSellingPrice;
    private String salesOrder;
    private String salesOrderLine;
    private String taxClassificationCode;
    
    public InvoiceLineModel() {
        super();
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setMemoLineName(String memoLineName) {
        this.memoLineName = memoLineName;
    }

    public String getMemoLineName() {
        return memoLineName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrderLine(String salesOrderLine) {
        this.salesOrderLine = salesOrderLine;
    }

    public String getSalesOrderLine() {
        return salesOrderLine;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = taxClassificationCode;
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public String getUomCode() {
        return uomCode;
    }
}
