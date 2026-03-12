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
 * To create ID generator sequence "FUSION_TRANSACTION_LINES_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_TRANSACTION_LINES_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionTransactionLines.findAll",
                            query = "select o from FusionTransactionLines o") })
@Table(name = "FUSION_TRANSACTION_LINES")
@SequenceGenerator(name = "FusionTransactionLines_Id_Seq_Gen", sequenceName = "FUSION_TXN_LINES_SEQ_GEN",
                   allocationSize = 1, initialValue = 1)
public class FusionTransactionLines implements Serializable {
    private static final long serialVersionUID = -3371135211478396494L;
    @Column(length = 20)
    private String item;
    @Column(nullable = false, length = 500)
    private String message;
    @Column(name = "ORGANIZATION_NAME", length = 20)
    private String organizationName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionTransactionLines_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 20)
    private String status;
    @Column(length = 20)
    private String subinventory;
    @Temporal(TemporalType.DATE)
    @Column(name = "TXN_DATE")
    private Date txnDate;
    @Column(name = "TXN_QTY")
    private BigDecimal txnQty;
    @Column(name = "TXN_SOURCE_NAME", length = 20)
    private String txnSourceName;
    @Column(name = "TXN_UOM", length = 10)
    private String txnUom;

    public FusionTransactionLines() {
    }

    public FusionTransactionLines(String item, String message, String organizationName, Date requestDate,
                                  BigDecimal requestId, BigDecimal rowId, String status, String subinventory,
                                  Date txnDate, BigDecimal txnQty, String txnSourceName, String txnUom) {
        this.item = item;
        this.message = message;
        this.organizationName = organizationName;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.rowId = rowId;
        this.status = status;
        this.subinventory = subinventory;
        this.txnDate = txnDate;
        this.txnQty = txnQty;
        this.txnSourceName = txnSourceName;
        this.txnUom = txnUom;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public BigDecimal getRequestId() {
        return requestId;
    }

    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public BigDecimal getTxnQty() {
        return txnQty;
    }

    public void setTxnQty(BigDecimal txnQty) {
        this.txnQty = txnQty;
    }

    public String getTxnSourceName() {
        return txnSourceName;
    }

    public void setTxnSourceName(String txnSourceName) {
        this.txnSourceName = txnSourceName;
    }

    public String getTxnUom() {
        return txnUom;
    }

    public void setTxnUom(String txnUom) {
        this.txnUom = txnUom;
    }
}
