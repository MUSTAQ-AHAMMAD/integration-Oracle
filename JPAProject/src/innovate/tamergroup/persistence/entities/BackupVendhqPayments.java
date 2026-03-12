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
 * To create ID generator sequence "BACKUP_VENDHQ_PAYMENTS_ID_SEQ_GEN":
 * CREATE SEQUENCE "BACKUP_VENDHQ_PAYMENTS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "BackupVendhqPayments.findAll", query = "select o from BackupVendhqPayments o"),
                @NamedQuery(name = "PaymentsByInvoiceNumber",
                            query =
                            "select o from BackupVendhqPayments o where o.invoiceNumber = :invoiceNumber and o.saleDate = :saleDate  and o.region = :region")
    })
@Table(name = "BACKUP_VENDHQ_PAYMENTS")
@SequenceGenerator(name = "BackupVendhqPayments_Id_Seq_Gen", sequenceName = "BACKUP_VENDHQ_PAY_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class BackupVendhqPayments implements Serializable {
    private static final long serialVersionUID = -3932799947398613807L;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false, length = 5)
    private String currency;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELETED_AT")
    private Date deletedAt;
    @Column(name = "INVOICE_NUMBER", nullable = false, length = 15)
    private String invoiceNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SALE_DATE", nullable = false)
    private Date saleDate;
    @Column(name = "OUTLET_NAME", nullable = false, length = 15)
    private String outletName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PAYMENT_DATE", nullable = false)
    private Date paymentDate;
    @Column(name = "PAYMENT_TYPE", nullable = false, length = 15)
    private String paymentType;
    @Column(nullable = false, length = 5)
    private String region;
    @Column(name = "REGISTER_NAME", nullable = false, length = 40)
    private String registerName;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BackupVendhqPayments_Id_Seq_Gen")
    private BigDecimal rowId;

    public BackupVendhqPayments() {
    }

    public BackupVendhqPayments(BigDecimal amount, String currency, Date deletedAt, String invoiceNumber, Date saleDate,
                                String outletName, Date paymentDate, String paymentType, String region,
                                String registerName, BigDecimal rowId) {
        this.amount = amount;
        this.currency = currency;
        this.deletedAt = deletedAt;
        this.invoiceNumber = invoiceNumber;
        this.saleDate = saleDate;
        this.outletName = outletName;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.region = region;
        this.registerName = registerName;
        this.rowId = rowId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

}
