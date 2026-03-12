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
 * To create ID generator sequence "FUSION_INV_TXN_ID_SEQ_GEN":
 * CREATE SEQUENCE "FUSION_INV_TXN_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "FusionInvTxn.findAll", query = "select o from FusionInvTxn o"),
                @NamedQuery(name = "findInvTxn",
                            query =
                            "select o.status from FusionInvTxn o where o.txnSourceName = :salesOrder and o.txnDate = :saleDate and o.itemNumber = :itemNumber and o.region = :region order by o.requestId desc"),
                @NamedQuery(name = "testQuery",
                            query = "select o from BackupVendhqLineItems o where o.saleDate = :saleDate ")
    })
@Table(name = "FUSION_INV_TXN")
@SequenceGenerator(name = "FusionInvTxn_Id_Seq_Gen", sequenceName = "FUSION_INV_TXN_ID_SEQ_GEN", allocationSize = 1,
                   initialValue = 1)
public class FusionInvTxn implements Serializable {
    private static final long serialVersionUID = -4629844821258815757L;
    @Column(name = "ITEM_NUMBER", length = 30)
    private String itemNumber;
    @Column(nullable = false, length = 500)
    private String message;
    @Column(name = "ORGANIZATION_NAME", length = 50)
    private String organizationName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;
    @Column(name = "REQUEST_ID", nullable = false)
    private BigDecimal requestId;
    @Id
    @Column(name = "ROW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FusionInvTxn_Id_Seq_Gen")
    private BigDecimal rowId;
    @Column(nullable = false, length = 20)
    private String status;
    @Column(length = 10)
    private String sunbinventory;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TXN_DATE")
    private Date txnDate;
    @Column(name = "TXN_QTY")
    private BigDecimal txnQty;
    @Column(name = "TXN_SOURCE_NAME", length = 30)
    private String txnSourceName;
    @Column(name = "TXN_UOM", length = 10)
    private String txnUom;
    @Column(nullable = false, length = 5, name = "REGION")
    private String region;
    @Column(nullable = false, length = 15, name = "INTEG_MODE")
    private String integrationMode;

    public FusionInvTxn() {
    }


    public FusionInvTxn(String itemNumber, String message, String organizationName, Date requestDate,
                        BigDecimal requestId, BigDecimal rowId, String status, String sunbinventory, Date txnDate,
                        BigDecimal txnQty, String txnSourceName, String txnUom, String region, String integrationMode) {
        this.itemNumber = itemNumber;
        this.message = message;
        this.organizationName = organizationName;
        this.requestDate = requestDate;
        this.requestId = requestId;
        this.rowId = rowId;
        this.status = status;
        this.sunbinventory = sunbinventory;
        this.txnDate = txnDate;
        this.txnQty = txnQty;
        this.txnSourceName = txnSourceName;
        this.txnUom = txnUom;
        this.region = region;
        this.integrationMode = integrationMode;
    }

    public void setIntegrationMode(String integrationMode) {
        this.integrationMode = integrationMode;
    }

    public String getIntegrationMode() {
        return integrationMode;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
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

    public String getSunbinventory() {
        return sunbinventory;
    }

    public void setSunbinventory(String sunbinventory) {
        this.sunbinventory = sunbinventory;
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

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
