package innovate.tamergroup.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "FusionReceiptMethod.findAll", query = "select o from FusionReceiptMethod o"),
                @NamedQuery(name = "ReceiptMethodByRegion",
                            query =
                            "select o from FusionReceiptMethod o where o.region = :region and o.receiptMethodName = :receiptMethodName")
    })
@Table(name = "FUSION_RECEIPT_METHOD")
public class FusionReceiptMethod implements Serializable {
    private static final long serialVersionUID = -752634995847142632L;
    @Column(name = "RECEIPT_BANK_CHARGE", nullable = false)
    private BigDecimal receiptBankCharge;
    @Column(name = "RECEIPT_IS_CASH", nullable = false)
    private String receiptIsCash;
    @Column(name = "RECEIPT_METHOD_ID", nullable = false)
    private BigDecimal receiptMethodId;
    @Id
    @Column(name = "RECEIPT_METHOD_NAME", nullable = false, unique = true, length = 20)
    private String receiptMethodName;
    @Column(name = "RECEIPT_METHOD_TAX", nullable = false)
    private BigDecimal receiptMethodTax;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;

    public FusionReceiptMethod() {
    }

    public FusionReceiptMethod(BigDecimal receiptBankCharge, String receiptIsCash, BigDecimal receiptMethodId,
                               String receiptMethodName, BigDecimal receiptMethodTax) {
        this.receiptBankCharge = receiptBankCharge;
        this.receiptIsCash = receiptIsCash;
        this.receiptMethodId = receiptMethodId;
        this.receiptMethodName = receiptMethodName;
        this.receiptMethodTax = receiptMethodTax;
    }

    public BigDecimal getReceiptBankCharge() {
        return receiptBankCharge;
    }

    public void setReceiptBankCharge(BigDecimal receiptBankCharge) {
        this.receiptBankCharge = receiptBankCharge;
    }

    public String getReceiptIsCash() {
        return receiptIsCash;
    }

    public void setReceiptIsCash(String receiptIsCash) {
        this.receiptIsCash = receiptIsCash;
    }

    public BigDecimal getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setReceiptMethodId(BigDecimal receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    public String getReceiptMethodName() {
        return receiptMethodName;
    }

    public void setReceiptMethodName(String receiptMethodName) {
        this.receiptMethodName = receiptMethodName;
    }

    public BigDecimal getReceiptMethodTax() {
        return receiptMethodTax;
    }

    public void setReceiptMethodTax(BigDecimal receiptMethodTax) {
        this.receiptMethodTax = receiptMethodTax;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
