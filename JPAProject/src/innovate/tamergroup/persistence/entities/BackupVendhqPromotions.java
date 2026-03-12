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
 * To create ID generator sequence "BACKUP_VENDHQ_PROMOTIONS_ID_SEQ_GEN":
 * CREATE SEQUENCE "BACKUP_VENDHQ_PROMOTIONS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "BackupVendhqPromotions.findAll",
                            query = "select o from BackupVendhqPromotions o") })
@Table(name = "BACKUP_VENDHQ_PROMOTIONS")
@SequenceGenerator(name = "BackupVendhqPromotions_Id_Seq_Gen", sequenceName = "BACKUP_VENDHQ_PROMO_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class BackupVendhqPromotions implements Serializable {
    private static final long serialVersionUID = 2573411836613577070L;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(name = "INVOICE_NUMBER", nullable = false, length = 15)
    private String invoiceNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SALE_DATE", nullable = false)
    private Date saleDate;
    @Column(name = "LINE_NUMBER", nullable = false)
    private BigDecimal lineNumber;
    @Column(nullable = false, length = 40, name = "NAME")
    private String name;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BackupVendhqPromotions_Id_Seq_Gen")
    private BigDecimal rowId;

    public BackupVendhqPromotions() {
    }


    public BackupVendhqPromotions(BigDecimal amount, String invoiceNumber, Date saleDate, BigDecimal lineNumber,
                                  String name, String region) {
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.saleDate = saleDate;
        this.lineNumber = lineNumber;
        this.name = name;
        this.region = region;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
