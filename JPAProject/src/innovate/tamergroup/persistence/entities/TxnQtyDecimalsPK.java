package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.util.Date;

public class TxnQtyDecimalsPK implements Serializable {
    
    private String region;
    private String outletName;
    private String invoiceNumber;
    private Date saleDate;
    private String itemNumber;
    
    public TxnQtyDecimalsPK() {
        super();
    }


    public TxnQtyDecimalsPK(String region, String outletName, String invoiceNumber, Date saleDate, String itemNumber) {
        this.region = region;
        this.outletName = outletName;
        this.invoiceNumber = invoiceNumber;
        this.saleDate = saleDate;
        this.itemNumber = itemNumber;
    }
    
    public boolean equals(Object other) {
        if (other instanceof TxnQtyDecimalsPK) {
            final TxnQtyDecimalsPK otherTxnQtyDecimalsPK = (TxnQtyDecimalsPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }


    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }
}
