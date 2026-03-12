package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnHandQuantityDetail {

    @SerializedName("OrganizationId")
    @Expose
    private long organizationId;
    @SerializedName("OrganizationCode")
    @Expose
    private String organizationCode;
    @SerializedName("InventoryItemId")
    @Expose
    private long inventoryItemId;
    @SerializedName("ItemNumber")
    @Expose
    private String itemNumber;
    @SerializedName("SubinventoryCode")
    @Expose
    private String subinventoryCode;
    @SerializedName("LocatorId")
    @Expose
    private Long locatorId;
    @SerializedName("LotNumber")
    @Expose
    private String lotNumber;
    @SerializedName("OnhandQuantity")
    @Expose
    private Double onhandQuantity;
    @SerializedName("SecondaryOnhandQuantity")
    @Expose
    private Double secondaryOnhandQuantity;
    @SerializedName("ReceivingQuantity")
    @Expose
    private Double receivingQuantity;
    @SerializedName("SecondaryReceivingQuantity")
    @Expose
    private Double secondaryReceivingQuantity;
    @SerializedName("ReservedQuantity")
    @Expose
    private Double reservedQuantity;
    @SerializedName("SecondaryReservedQuantity")
    @Expose
    private Double secondaryReservedQuantity;
    @SerializedName("InboundQuantity")
    @Expose
    private Double inboundQuantity;
    @SerializedName("SecondaryInboundQuantity")
    @Expose
    private Double secondaryInboundQuantity;
    @SerializedName("ConsignedQuantity")
    @Expose
    private Double consignedQuantity;
    @SerializedName("SecondaryConsignedQuantity")
    @Expose
    private Double secondaryConsignedQuantity;
    @SerializedName("OwningOrganizationId")
    @Expose
    private Long owningOrganizationId;
    @SerializedName("OwningOrganization")
    @Expose
    private String owningOrganization;
    @SerializedName("SerialNumber")
    @Expose
    private String serialNumber;
    @SerializedName("PrimaryUOMCode")
    @Expose
    private String primaryUOMCode;
    @SerializedName("SecondaryUOMCode")
    @Expose
    private String secondaryUOMCode;
    @SerializedName("ConsignedQuantityDetails")
    @Expose
    private List<ConsignedQuantityDetail> consignedQuantityDetails = null;
    @SerializedName("InboundQuantityDetails")
    @Expose
    private List<InboundQuantityDetail> inboundQuantityDetails = null;
    private final static long serialVersionUID = 4226751651283786299L;

    /**
     * No args constructor for use in serialization
     *
     */
    public OnHandQuantityDetail() {
    }


    /**
     *
     * @param owningOrganization
     * @param locatorId
     * @param consignedQuantity
     * @param secondaryReservedQuantity
     * @param serialNumber
     * @param lotNumber
     * @param organizationId
     * @param owningOrganizationId
     * @param secondaryInboundQuantity
     * @param inboundQuantity
     * @param secondaryOnhandQuantity
     * @param onhandQuantity
     * @param organizationCode
     * @param primaryUOMCode
     * @param secondaryReceivingQuantity
     * @param secondaryUOMCode
     * @param receivingQuantity
     * @param reservedQuantity
     * @param secondaryConsignedQuantity
     * @param subinventoryCode
     * @param inboundQuantityDetails
     * @param inventoryItemId
     * @param itemNumber
     * @param consignedQuantityDetails
     */
    public OnHandQuantityDetail(long organizationId, String organizationCode, long inventoryItemId, String itemNumber,
                                String subinventoryCode, Long locatorId, String lotNumber, Double onhandQuantity,
                                Double secondaryOnhandQuantity, Double receivingQuantity,
                                Double secondaryReceivingQuantity, Double reservedQuantity,
                                Double secondaryReservedQuantity, Double inboundQuantity,
                                Double secondaryInboundQuantity, Double consignedQuantity,
                                Double secondaryConsignedQuantity, Long owningOrganizationId, String owningOrganization,
                                String serialNumber, String primaryUOMCode, String secondaryUOMCode,
                                List<ConsignedQuantityDetail> consignedQuantityDetails,
                                List<InboundQuantityDetail> inboundQuantityDetails) {
        this.organizationId = organizationId;
        this.organizationCode = organizationCode;
        this.inventoryItemId = inventoryItemId;
        this.itemNumber = itemNumber;
        this.subinventoryCode = subinventoryCode;
        this.locatorId = locatorId;
        this.lotNumber = lotNumber;
        this.onhandQuantity = onhandQuantity;
        this.secondaryOnhandQuantity = secondaryOnhandQuantity;
        this.receivingQuantity = receivingQuantity;
        this.secondaryReceivingQuantity = secondaryReceivingQuantity;
        this.reservedQuantity = reservedQuantity;
        this.secondaryReservedQuantity = secondaryReservedQuantity;
        this.inboundQuantity = inboundQuantity;
        this.secondaryInboundQuantity = secondaryInboundQuantity;
        this.consignedQuantity = consignedQuantity;
        this.secondaryConsignedQuantity = secondaryConsignedQuantity;
        this.owningOrganizationId = owningOrganizationId;
        this.owningOrganization = owningOrganization;
        this.serialNumber = serialNumber;
        this.primaryUOMCode = primaryUOMCode;
        this.secondaryUOMCode = secondaryUOMCode;
        this.consignedQuantityDetails = consignedQuantityDetails;
        this.inboundQuantityDetails = inboundQuantityDetails;
    }


    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setInventoryItemId(long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setLocatorId(Long locatorId) {
        this.locatorId = locatorId;
    }

    public Long getLocatorId() {
        return locatorId;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setOnhandQuantity(Double onhandQuantity) {
        this.onhandQuantity = onhandQuantity;
    }

    public Double getOnhandQuantity() {
        return onhandQuantity;
    }

    public void setSecondaryOnhandQuantity(Double secondaryOnhandQuantity) {
        this.secondaryOnhandQuantity = secondaryOnhandQuantity;
    }

    public Double getSecondaryOnhandQuantity() {
        return secondaryOnhandQuantity;
    }

    public void setReceivingQuantity(Double receivingQuantity) {
        this.receivingQuantity = receivingQuantity;
    }

    public Double getReceivingQuantity() {
        return receivingQuantity;
    }

    public void setSecondaryReceivingQuantity(Double secondaryReceivingQuantity) {
        this.secondaryReceivingQuantity = secondaryReceivingQuantity;
    }

    public Double getSecondaryReceivingQuantity() {
        return secondaryReceivingQuantity;
    }

    public void setReservedQuantity(Double reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public Double getReservedQuantity() {
        return reservedQuantity;
    }

    public void setSecondaryReservedQuantity(Double secondaryReservedQuantity) {
        this.secondaryReservedQuantity = secondaryReservedQuantity;
    }

    public Double getSecondaryReservedQuantity() {
        return secondaryReservedQuantity;
    }

    public void setInboundQuantity(Double inboundQuantity) {
        this.inboundQuantity = inboundQuantity;
    }

    public Double getInboundQuantity() {
        return inboundQuantity;
    }

    public void setSecondaryInboundQuantity(Double secondaryInboundQuantity) {
        this.secondaryInboundQuantity = secondaryInboundQuantity;
    }

    public Double getSecondaryInboundQuantity() {
        return secondaryInboundQuantity;
    }

    public void setConsignedQuantity(Double consignedQuantity) {
        this.consignedQuantity = consignedQuantity;
    }

    public Double getConsignedQuantity() {
        return consignedQuantity;
    }

    public void setSecondaryConsignedQuantity(Double secondaryConsignedQuantity) {
        this.secondaryConsignedQuantity = secondaryConsignedQuantity;
    }

    public Double getSecondaryConsignedQuantity() {
        return secondaryConsignedQuantity;
    }

    public void setOwningOrganizationId(Long owningOrganizationId) {
        this.owningOrganizationId = owningOrganizationId;
    }

    public Long getOwningOrganizationId() {
        return owningOrganizationId;
    }

    public void setOwningOrganization(String owningOrganization) {
        this.owningOrganization = owningOrganization;
    }

    public String getOwningOrganization() {
        return owningOrganization;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setPrimaryUOMCode(String primaryUOMCode) {
        this.primaryUOMCode = primaryUOMCode;
    }

    public String getPrimaryUOMCode() {
        return primaryUOMCode;
    }

    public void setSecondaryUOMCode(String secondaryUOMCode) {
        this.secondaryUOMCode = secondaryUOMCode;
    }

    public String getSecondaryUOMCode() {
        return secondaryUOMCode;
    }

    public void setConsignedQuantityDetails(List<ConsignedQuantityDetail> consignedQuantityDetails) {
        this.consignedQuantityDetails = consignedQuantityDetails;
    }

    public List<ConsignedQuantityDetail> getConsignedQuantityDetails() {
        return consignedQuantityDetails;
    }

    public void setInboundQuantityDetails(List<InboundQuantityDetail> inboundQuantityDetails) {
        this.inboundQuantityDetails = inboundQuantityDetails;
    }

    public List<InboundQuantityDetail> getInboundQuantityDetails() {
        return inboundQuantityDetails;
    }
}
