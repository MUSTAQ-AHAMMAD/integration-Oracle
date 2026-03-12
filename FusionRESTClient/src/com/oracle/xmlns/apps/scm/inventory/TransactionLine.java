package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TransactionLine implements Serializable {

    @SerializedName("UniqueTransactionId")
    @Expose
    private Long uniqueTransactionId;
    @SerializedName("TransactionHeaderId")
    @Expose
    private Long transactionHeaderId;
    @SerializedName("OrganizationId")
    @Expose
    private Long organizationId;
    @SerializedName("OrganizationName")
    @Expose
    private String organizationName;
    @SerializedName("InventoryItemId")
    @Expose
    private String inventoryItemId;
    @SerializedName("Item")
    @Expose
    private String item;
    @SerializedName("Revision")
    @Expose
    private String revision;
    @SerializedName("Subinventory")
    @Expose
    private String subinventory;
    @SerializedName("LocatorId")
    @Expose
    private String locatorId;
    @SerializedName("Locator")
    @Expose
    private String locator;
    @SerializedName("LocationType")
    @Expose
    private String locationType;
    @SerializedName("PrimaryQuantity")
    @Expose
    private String primaryQuantity;
    @SerializedName("TransactionQuantity")
    @Expose
    private Double transactionQuantity;
    @SerializedName("TransactionUOM")
    @Expose
    private String transactionUOM;
    @SerializedName("TransactionUnitOfMeasure")
    @Expose
    private String transactionUnitOfMeasure;
    @SerializedName("SecondaryTransactionQuantity")
    @Expose
    private String secondaryTransactionQuantity;
    @SerializedName("SourceLineId")
    @Expose
    private Long sourceLineId;
    @SerializedName("SourceHeaderId")
    @Expose
    private Long sourceHeaderId;
    @SerializedName("TransactionDate")
    @Expose
    private Date transactionDate;
    @SerializedName("TransactionSourceId")
    @Expose
    private String transactionSourceId;
    @SerializedName("TransactionSourceName")
    @Expose
    private String transactionSourceName;
    @SerializedName("ReasonId")
    @Expose
    private String reasonId;
    @SerializedName("ReasonName")
    @Expose
    private String reasonName;
    @SerializedName("DistributionAccountId")
    @Expose
    private Long distributionAccountId;
    @SerializedName("OwningOrganizationId")
    @Expose
    private String owningOrganizationId;
    @SerializedName("OwningOrganizationName")
    @Expose
    private String owningOrganizationName;
    @SerializedName("OwningTpType")
    @Expose
    private String owningTpType;
    @SerializedName("TransferOrganizationId")
    @Expose
    private String transferOrganizationId;
    @SerializedName("TransferOrganizationName")
    @Expose
    private String transferOrganizationName;
    @SerializedName("TransferOwningOrganizationId")
    @Expose
    private String transferOwningOrganizationId;
    @SerializedName("TransferOwningOrganizationName")
    @Expose
    private String transferOwningOrganizationName;
    @SerializedName("TransferOwningTpType")
    @Expose
    private String transferOwningTpType;
    @SerializedName("TransferSubinventory")
    @Expose
    private String transferSubinventory;
    @SerializedName("TransferLocator")
    @Expose
    private String transferLocator;
    @SerializedName("TransferLocatorName")
    @Expose
    private String transferLocatorName;
    @SerializedName("ProcurementBU")
    @Expose
    private String procurementBU;
    @SerializedName("VendorName")
    @Expose
    private String vendorName;
    @SerializedName("VendorNumber")
    @Expose
    private String vendorNumber;
    @SerializedName("AgingOnsetDate")
    @Expose
    private Date agingOnsetDate;
    @SerializedName("TransactionSourceTypeId")
    @Expose
    private String transactionSourceTypeId;
    @SerializedName("TransactionSourceTypeName")
    @Expose
    private String transactionSourceTypeName;
    @SerializedName("TransactionActionId")
    @Expose
    private String transactionActionId;
    @SerializedName("TransactionAction")
    @Expose
    private String transactionAction;
    @SerializedName("TransactionTypeId")
    @Expose
    private String transactionTypeId;
    @SerializedName("TransactionType")
    @Expose
    private String transactionType;
    @SerializedName("ShipmentNumber")
    @Expose
    private String shipmentNumber;
    private final static long serialVersionUID = -6086821314082503422L;

    /**
     * No args constructor for use in serialization
     *
     */
    public TransactionLine() {
    }

    /**
     *
     * @param transferOrganizationName
     * @param subinventory
     * @param transferOwningTpType
     * @param locatorId
     * @param transactionUOM
     * @param reasonId
     * @param organizationName
     * @param sourceHeaderId
     * @param transactionQuantity
     * @param transactionSourceName
     * @param vendorNumber
     * @param owningTpType
     * @param organizationId
     * @param owningOrganizationId
     * @param transferLocator
     * @param transferOwningOrganizationId
     * @param revision
     * @param shipmentNumber
     * @param transactionUnitOfMeasure
     * @param secondaryTransactionQuantity
     * @param locationType
     * @param transactionAction
     * @param inventoryItemId
     * @param transferOrganizationId
     * @param agingOnsetDate
     * @param transferSubinventory
     * @param locator
     * @param vendorName
     * @param distributionAccountId
     * @param procurementBU
     * @param transactionHeaderId
     * @param transactionSourceTypeId
     * @param transactionSourceTypeName
     * @param sourceLineId
     * @param uniqueTransactionId
     * @param transactionDate
     * @param transactionSourceId
     * @param transactionType
     * @param item
     * @param reasonName
     * @param transactionTypeId
     * @param transferOwningOrganizationName
     * @param owningOrganizationName
     * @param transferLocatorName
     * @param transactionActionId
     * @param primaryQuantity
     */
    public TransactionLine(Long uniqueTransactionId, Long transactionHeaderId, Long organizationId,
                           String organizationName, String inventoryItemId, String item, String revision,
                           String subinventory, String locatorId, String locator, String locationType,
                           String primaryQuantity, Double transactionQuantity, String transactionUOM,
                           String transactionUnitOfMeasure, String secondaryTransactionQuantity, Long sourceLineId,
                           Long sourceHeaderId, Date transactionDate, String transactionSourceId,
                           String transactionSourceName, String reasonId, String reasonName,
                           Long distributionAccountId, String owningOrganizationId, String owningOrganizationName,
                           String owningTpType, String transferOrganizationId, String transferOrganizationName,
                           String transferOwningOrganizationId, String transferOwningOrganizationName,
                           String transferOwningTpType, String transferSubinventory, String transferLocator,
                           String transferLocatorName, String procurementBU, String vendorName, String vendorNumber,
                           Date agingOnsetDate, String transactionSourceTypeId, String transactionSourceTypeName,
                           String transactionActionId, String transactionAction, String transactionTypeId,
                           String transactionType, String shipmentNumber) {
        super();
        this.uniqueTransactionId = uniqueTransactionId;
        this.transactionHeaderId = transactionHeaderId;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.inventoryItemId = inventoryItemId;
        this.item = item;
        this.revision = revision;
        this.subinventory = subinventory;
        this.locatorId = locatorId;
        this.locator = locator;
        this.locationType = locationType;
        this.primaryQuantity = primaryQuantity;
        this.transactionQuantity = transactionQuantity;
        this.transactionUOM = transactionUOM;
        this.transactionUnitOfMeasure = transactionUnitOfMeasure;
        this.secondaryTransactionQuantity = secondaryTransactionQuantity;
        this.sourceLineId = sourceLineId;
        this.sourceHeaderId = sourceHeaderId;
        this.transactionDate = transactionDate;
        this.transactionSourceId = transactionSourceId;
        this.transactionSourceName = transactionSourceName;
        this.reasonId = reasonId;
        this.reasonName = reasonName;
        this.distributionAccountId = distributionAccountId;
        this.owningOrganizationId = owningOrganizationId;
        this.owningOrganizationName = owningOrganizationName;
        this.owningTpType = owningTpType;
        this.transferOrganizationId = transferOrganizationId;
        this.transferOrganizationName = transferOrganizationName;
        this.transferOwningOrganizationId = transferOwningOrganizationId;
        this.transferOwningOrganizationName = transferOwningOrganizationName;
        this.transferOwningTpType = transferOwningTpType;
        this.transferSubinventory = transferSubinventory;
        this.transferLocator = transferLocator;
        this.transferLocatorName = transferLocatorName;
        this.procurementBU = procurementBU;
        this.vendorName = vendorName;
        this.vendorNumber = vendorNumber;
        this.agingOnsetDate = agingOnsetDate;
        this.transactionSourceTypeId = transactionSourceTypeId;
        this.transactionSourceTypeName = transactionSourceTypeName;
        this.transactionActionId = transactionActionId;
        this.transactionAction = transactionAction;
        this.transactionTypeId = transactionTypeId;
        this.transactionType = transactionType;
        this.shipmentNumber = shipmentNumber;
    }

    public Long getUniqueTransactionId() {
        return uniqueTransactionId;
    }

    public void setUniqueTransactionId(Long uniqueTransactionId) {
        this.uniqueTransactionId = uniqueTransactionId;
    }

    public TransactionLine withUniqueTransactionId(Long uniqueTransactionId) {
        this.uniqueTransactionId = uniqueTransactionId;
        return this;
    }

    public Long getTransactionHeaderId() {
        return transactionHeaderId;
    }

    public void setTransactionHeaderId(Long transactionHeaderId) {
        this.transactionHeaderId = transactionHeaderId;
    }

    public TransactionLine withTransactionHeaderId(Long transactionHeaderId) {
        this.transactionHeaderId = transactionHeaderId;
        return this;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public TransactionLine withOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public TransactionLine withOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public TransactionLine withInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
        return this;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TransactionLine withItem(String item) {
        this.item = item;
        return this;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public TransactionLine withRevision(String revision) {
        this.revision = revision;
        return this;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public TransactionLine withSubinventory(String subinventory) {
        this.subinventory = subinventory;
        return this;
    }

    public String getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    public TransactionLine withLocatorId(String locatorId) {
        this.locatorId = locatorId;
        return this;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public TransactionLine withLocator(String locator) {
        this.locator = locator;
        return this;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public TransactionLine withLocationType(String locationType) {
        this.locationType = locationType;
        return this;
    }

    public String getPrimaryQuantity() {
        return primaryQuantity;
    }

    public void setPrimaryQuantity(String primaryQuantity) {
        this.primaryQuantity = primaryQuantity;
    }

    public TransactionLine withPrimaryQuantity(String primaryQuantity) {
        this.primaryQuantity = primaryQuantity;
        return this;
    }

    public Double getTransactionQuantity() {
        return transactionQuantity;
    }
    
    public void addTransactionQuantity(Integer quantity) {
        transactionQuantity += quantity;
    }

    public void setTransactionQuantity(Double transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public TransactionLine withTransactionQuantity(Double transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
        return this;
    }

    public String getTransactionUOM() {
        return transactionUOM;
    }

    public void setTransactionUOM(String transactionUOM) {
        this.transactionUOM = transactionUOM;
    }

    public TransactionLine withTransactionUOM(String transactionUOM) {
        this.transactionUOM = transactionUOM;
        return this;
    }

    public String getTransactionUnitOfMeasure() {
        return transactionUnitOfMeasure;
    }

    public void setTransactionUnitOfMeasure(String transactionUnitOfMeasure) {
        this.transactionUnitOfMeasure = transactionUnitOfMeasure;
    }

    public TransactionLine withTransactionUnitOfMeasure(String transactionUnitOfMeasure) {
        this.transactionUnitOfMeasure = transactionUnitOfMeasure;
        return this;
    }

    public String getSecondaryTransactionQuantity() {
        return secondaryTransactionQuantity;
    }

    public void setSecondaryTransactionQuantity(String secondaryTransactionQuantity) {
        this.secondaryTransactionQuantity = secondaryTransactionQuantity;
    }

    public TransactionLine withSecondaryTransactionQuantity(String secondaryTransactionQuantity) {
        this.secondaryTransactionQuantity = secondaryTransactionQuantity;
        return this;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public TransactionLine withSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
        return this;
    }

    public Long getSourceHeaderId() {
        return sourceHeaderId;
    }

    public void setSourceHeaderId(Long sourceHeaderId) {
        this.sourceHeaderId = sourceHeaderId;
    }

    public TransactionLine withSourceHeaderId(Long sourceHeaderId) {
        this.sourceHeaderId = sourceHeaderId;
        return this;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionLine withTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public String getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(String transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

    public TransactionLine withTransactionSourceId(String transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
        return this;
    }

    public String getTransactionSourceName() {
        return transactionSourceName;
    }

    public void setTransactionSourceName(String transactionSourceName) {
        this.transactionSourceName = transactionSourceName;
    }

    public TransactionLine withTransactionSourceName(String transactionSourceName) {
        this.transactionSourceName = transactionSourceName;
        return this;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public TransactionLine withReasonId(String reasonId) {
        this.reasonId = reasonId;
        return this;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public TransactionLine withReasonName(String reasonName) {
        this.reasonName = reasonName;
        return this;
    }

    public Long getDistributionAccountId() {
        return distributionAccountId;
    }

    public void setDistributionAccountId(Long distributionAccountId) {
        this.distributionAccountId = distributionAccountId;
    }

    public TransactionLine withDistributionAccountId(Long distributionAccountId) {
        this.distributionAccountId = distributionAccountId;
        return this;
    }

    public String getOwningOrganizationId() {
        return owningOrganizationId;
    }

    public void setOwningOrganizationId(String owningOrganizationId) {
        this.owningOrganizationId = owningOrganizationId;
    }

    public TransactionLine withOwningOrganizationId(String owningOrganizationId) {
        this.owningOrganizationId = owningOrganizationId;
        return this;
    }

    public String getOwningOrganizationName() {
        return owningOrganizationName;
    }

    public void setOwningOrganizationName(String owningOrganizationName) {
        this.owningOrganizationName = owningOrganizationName;
    }

    public TransactionLine withOwningOrganizationName(String owningOrganizationName) {
        this.owningOrganizationName = owningOrganizationName;
        return this;
    }

    public String getOwningTpType() {
        return owningTpType;
    }

    public void setOwningTpType(String owningTpType) {
        this.owningTpType = owningTpType;
    }

    public TransactionLine withOwningTpType(String owningTpType) {
        this.owningTpType = owningTpType;
        return this;
    }

    public String getTransferOrganizationId() {
        return transferOrganizationId;
    }

    public void setTransferOrganizationId(String transferOrganizationId) {
        this.transferOrganizationId = transferOrganizationId;
    }

    public TransactionLine withTransferOrganizationId(String transferOrganizationId) {
        this.transferOrganizationId = transferOrganizationId;
        return this;
    }

    public String getTransferOrganizationName() {
        return transferOrganizationName;
    }

    public void setTransferOrganizationName(String transferOrganizationName) {
        this.transferOrganizationName = transferOrganizationName;
    }

    public TransactionLine withTransferOrganizationName(String transferOrganizationName) {
        this.transferOrganizationName = transferOrganizationName;
        return this;
    }

    public String getTransferOwningOrganizationId() {
        return transferOwningOrganizationId;
    }

    public void setTransferOwningOrganizationId(String transferOwningOrganizationId) {
        this.transferOwningOrganizationId = transferOwningOrganizationId;
    }

    public TransactionLine withTransferOwningOrganizationId(String transferOwningOrganizationId) {
        this.transferOwningOrganizationId = transferOwningOrganizationId;
        return this;
    }

    public String getTransferOwningOrganizationName() {
        return transferOwningOrganizationName;
    }

    public void setTransferOwningOrganizationName(String transferOwningOrganizationName) {
        this.transferOwningOrganizationName = transferOwningOrganizationName;
    }

    public TransactionLine withTransferOwningOrganizationName(String transferOwningOrganizationName) {
        this.transferOwningOrganizationName = transferOwningOrganizationName;
        return this;
    }

    public String getTransferOwningTpType() {
        return transferOwningTpType;
    }

    public void setTransferOwningTpType(String transferOwningTpType) {
        this.transferOwningTpType = transferOwningTpType;
    }

    public TransactionLine withTransferOwningTpType(String transferOwningTpType) {
        this.transferOwningTpType = transferOwningTpType;
        return this;
    }

    public String getTransferSubinventory() {
        return transferSubinventory;
    }

    public void setTransferSubinventory(String transferSubinventory) {
        this.transferSubinventory = transferSubinventory;
    }

    public TransactionLine withTransferSubinventory(String transferSubinventory) {
        this.transferSubinventory = transferSubinventory;
        return this;
    }

    public String getTransferLocator() {
        return transferLocator;
    }

    public void setTransferLocator(String transferLocator) {
        this.transferLocator = transferLocator;
    }

    public TransactionLine withTransferLocator(String transferLocator) {
        this.transferLocator = transferLocator;
        return this;
    }

    public String getTransferLocatorName() {
        return transferLocatorName;
    }

    public void setTransferLocatorName(String transferLocatorName) {
        this.transferLocatorName = transferLocatorName;
    }

    public TransactionLine withTransferLocatorName(String transferLocatorName) {
        this.transferLocatorName = transferLocatorName;
        return this;
    }

    public String getProcurementBU() {
        return procurementBU;
    }

    public void setProcurementBU(String procurementBU) {
        this.procurementBU = procurementBU;
    }

    public TransactionLine withProcurementBU(String procurementBU) {
        this.procurementBU = procurementBU;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public TransactionLine withVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public TransactionLine withVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
        return this;
    }

    public Date getAgingOnsetDate() {
        return agingOnsetDate;
    }

    public void setAgingOnsetDate(Date agingOnsetDate) {
        this.agingOnsetDate = agingOnsetDate;
    }

    public TransactionLine withAgingOnsetDate(Date agingOnsetDate) {
        this.agingOnsetDate = agingOnsetDate;
        return this;
    }

    public String getTransactionSourceTypeId() {
        return transactionSourceTypeId;
    }

    public void setTransactionSourceTypeId(String transactionSourceTypeId) {
        this.transactionSourceTypeId = transactionSourceTypeId;
    }

    public TransactionLine withTransactionSourceTypeId(String transactionSourceTypeId) {
        this.transactionSourceTypeId = transactionSourceTypeId;
        return this;
    }

    public String getTransactionSourceTypeName() {
        return transactionSourceTypeName;
    }

    public void setTransactionSourceTypeName(String transactionSourceTypeName) {
        this.transactionSourceTypeName = transactionSourceTypeName;
    }

    public TransactionLine withTransactionSourceTypeName(String transactionSourceTypeName) {
        this.transactionSourceTypeName = transactionSourceTypeName;
        return this;
    }

    public String getTransactionActionId() {
        return transactionActionId;
    }

    public void setTransactionActionId(String transactionActionId) {
        this.transactionActionId = transactionActionId;
    }

    public TransactionLine withTransactionActionId(String transactionActionId) {
        this.transactionActionId = transactionActionId;
        return this;
    }

    public String getTransactionAction() {
        return transactionAction;
    }

    public void setTransactionAction(String transactionAction) {
        this.transactionAction = transactionAction;
    }

    public TransactionLine withTransactionAction(String transactionAction) {
        this.transactionAction = transactionAction;
        return this;
    }

    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public TransactionLine withTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionLine withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public TransactionLine withShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
        return this;
    }

}
