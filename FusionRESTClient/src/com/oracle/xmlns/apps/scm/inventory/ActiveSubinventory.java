package com.oracle.xmlns.apps.scm.inventory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import java.util.Date;

public class ActiveSubinventory implements Serializable {

    @SerializedName("SubinventoryId")
    @Expose
    private Long subinventoryId;
    @SerializedName("SecondaryInventoryName")
    @Expose
    private String secondaryInventoryName;
    @SerializedName("OrganizationId")
    @Expose
    private Long organizationId;
    @SerializedName("OrganizationCode")
    @Expose
    private String organizationCode;
    @SerializedName("OrganizationName")
    @Expose
    private String organizationName;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DisableDate")
    @Expose
    private Date disableDate;
    @SerializedName("InventoryATPCode")
    @Expose
    private Long inventoryATPCode;
    @SerializedName("IncludeInATP")
    @Expose
    private String includeInATP;
    @SerializedName("NettableCode")
    @Expose
    private Long nettableCode;
    @SerializedName("Nettable")
    @Expose
    private String nettable;
    @SerializedName("ReservableType")
    @Expose
    private Long reservableType;
    @SerializedName("AllowReservations")
    @Expose
    private String allowReservations;
    @SerializedName("LocatorTypeCode")
    @Expose
    private String locatorTypeCode;
    @SerializedName("LocatorType")
    @Expose
    private String locatorType;
    @SerializedName("PickingOrder")
    @Expose
    private String pickingOrder;
    @SerializedName("QuantityTrackedCode")
    @Expose
    private Long quantityTrackedCode;
    @SerializedName("QuantityTracked")
    @Expose
    private String quantityTracked;
    @SerializedName("AssetInventoryCode")
    @Expose
    private Long assetInventoryCode;
    @SerializedName("AssetInventory")
    @Expose
    private String assetInventory;
    @SerializedName("SourceTypeCode")
    @Expose
    private String sourceTypeCode;
    @SerializedName("SourceType")
    @Expose
    private String sourceType;
    @SerializedName("SourceSubinventory")
    @Expose
    private String sourceSubinventory;
    @SerializedName("SourceOrganizationId")
    @Expose
    private String sourceOrganizationId;
    @SerializedName("SourceOrganizationCode")
    @Expose
    private String sourceOrganizationCode;
    @SerializedName("SourceOrganizationName")
    @Expose
    private String sourceOrganizationName;
    @SerializedName("PreprocessingLeadTime")
    @Expose
    private String preprocessingLeadTime;
    @SerializedName("ProcessingLeadTime")
    @Expose
    private String processingLeadTime;
    @SerializedName("PostprocessingLeadTime")
    @Expose
    private String postprocessingLeadTime;
    @SerializedName("LocationId")
    @Expose
    private String locationId;
    @SerializedName("LocationName")
    @Expose
    private String locationName;
    @SerializedName("DepreciableCode")
    @Expose
    private Long depreciableCode;
    @SerializedName("Depreciable")
    @Expose
    private String depreciable;
    @SerializedName("StatusId")
    @Expose
    private Long statusId;
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("SubinventoryTypeCode")
    @Expose
    private String subinventoryTypeCode;
    @SerializedName("SubinventoryType")
    @Expose
    private String subinventoryType;
    private final static long serialVersionUID = 7957349096834231917L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ActiveSubinventory() {
    }

    /**
     *
     * @param preprocessingLeadTime
     * @param organizationName
     * @param sourceOrganizationCode
     * @param locationId
     * @param inventoryATPCode
     * @param locationName
     * @param organizationId
     * @param secondaryInventoryName
     * @param sourceSubinventory
     * @param sourceOrganizationId
     * @param statusCode
     * @param statusId
     * @param locatorTypeCode
     * @param assetInventory
     * @param description
     * @param pickingOrder
     * @param quantityTrackedCode
     * @param nettable
     * @param sourceType
     * @param subinventoryTypeCode
     * @param subinventoryType
     * @param nettableCode
     * @param includeInATP
     * @param assetInventoryCode
     * @param sourceOrganizationName
     * @param organizationCode
     * @param reservableType
     * @param allowReservations
     * @param disableDate
     * @param subinventoryId
     * @param postprocessingLeadTime
     * @param processingLeadTime
     * @param depreciable
     * @param quantityTracked
     * @param locatorType
     * @param depreciableCode
     * @param sourceTypeCode
     */
    public ActiveSubinventory(Long subinventoryId, String secondaryInventoryName, Long organizationId,
                              String organizationCode, String organizationName, String description, Date disableDate,
                              Long inventoryATPCode, String includeInATP, Long nettableCode, String nettable,
                              Long reservableType, String allowReservations, String locatorTypeCode, String locatorType,
                              String pickingOrder, Long quantityTrackedCode, String quantityTracked,
                              Long assetInventoryCode, String assetInventory, String sourceTypeCode, String sourceType,
                              String sourceSubinventory, String sourceOrganizationId, String sourceOrganizationCode,
                              String sourceOrganizationName, String preprocessingLeadTime, String processingLeadTime,
                              String postprocessingLeadTime, String locationId, String locationName,
                              Long depreciableCode, String depreciable, Long statusId, String statusCode,
                              String subinventoryTypeCode, String subinventoryType) {
        super();
        this.subinventoryId = subinventoryId;
        this.secondaryInventoryName = secondaryInventoryName;
        this.organizationId = organizationId;
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.description = description;
        this.disableDate = disableDate;
        this.inventoryATPCode = inventoryATPCode;
        this.includeInATP = includeInATP;
        this.nettableCode = nettableCode;
        this.nettable = nettable;
        this.reservableType = reservableType;
        this.allowReservations = allowReservations;
        this.locatorTypeCode = locatorTypeCode;
        this.locatorType = locatorType;
        this.pickingOrder = pickingOrder;
        this.quantityTrackedCode = quantityTrackedCode;
        this.quantityTracked = quantityTracked;
        this.assetInventoryCode = assetInventoryCode;
        this.assetInventory = assetInventory;
        this.sourceTypeCode = sourceTypeCode;
        this.sourceType = sourceType;
        this.sourceSubinventory = sourceSubinventory;
        this.sourceOrganizationId = sourceOrganizationId;
        this.sourceOrganizationCode = sourceOrganizationCode;
        this.sourceOrganizationName = sourceOrganizationName;
        this.preprocessingLeadTime = preprocessingLeadTime;
        this.processingLeadTime = processingLeadTime;
        this.postprocessingLeadTime = postprocessingLeadTime;
        this.locationId = locationId;
        this.locationName = locationName;
        this.depreciableCode = depreciableCode;
        this.depreciable = depreciable;
        this.statusId = statusId;
        this.statusCode = statusCode;
        this.subinventoryTypeCode = subinventoryTypeCode;
        this.subinventoryType = subinventoryType;
    }

    public Long getSubinventoryId() {
        return subinventoryId;
    }

    public void setSubinventoryId(Long subinventoryId) {
        this.subinventoryId = subinventoryId;
    }

    public String getSecondaryInventoryName() {
        return secondaryInventoryName;
    }

    public void setSecondaryInventoryName(String secondaryInventoryName) {
        this.secondaryInventoryName = secondaryInventoryName;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public Long getInventoryATPCode() {
        return inventoryATPCode;
    }

    public void setInventoryATPCode(Long inventoryATPCode) {
        this.inventoryATPCode = inventoryATPCode;
    }

    public String getIncludeInATP() {
        return includeInATP;
    }

    public void setIncludeInATP(String includeInATP) {
        this.includeInATP = includeInATP;
    }

    public Long getNettableCode() {
        return nettableCode;
    }

    public void setNettableCode(Long nettableCode) {
        this.nettableCode = nettableCode;
    }

    public String getNettable() {
        return nettable;
    }

    public void setNettable(String nettable) {
        this.nettable = nettable;
    }

    public Long getReservableType() {
        return reservableType;
    }

    public void setReservableType(Long reservableType) {
        this.reservableType = reservableType;
    }

    public String getAllowReservations() {
        return allowReservations;
    }

    public void setAllowReservations(String allowReservations) {
        this.allowReservations = allowReservations;
    }

    public String getLocatorTypeCode() {
        return locatorTypeCode;
    }

    public void setLocatorTypeCode(String locatorTypeCode) {
        this.locatorTypeCode = locatorTypeCode;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public void setLocatorType(String locatorType) {
        this.locatorType = locatorType;
    }

    public String getPickingOrder() {
        return pickingOrder;
    }

    public void setPickingOrder(String pickingOrder) {
        this.pickingOrder = pickingOrder;
    }

    public Long getQuantityTrackedCode() {
        return quantityTrackedCode;
    }

    public void setQuantityTrackedCode(Long quantityTrackedCode) {
        this.quantityTrackedCode = quantityTrackedCode;
    }

    public String getQuantityTracked() {
        return quantityTracked;
    }

    public void setQuantityTracked(String quantityTracked) {
        this.quantityTracked = quantityTracked;
    }

    public Long getAssetInventoryCode() {
        return assetInventoryCode;
    }

    public void setAssetInventoryCode(Long assetInventoryCode) {
        this.assetInventoryCode = assetInventoryCode;
    }

    public String getAssetInventory() {
        return assetInventory;
    }

    public void setAssetInventory(String assetInventory) {
        this.assetInventory = assetInventory;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceSubinventory() {
        return sourceSubinventory;
    }

    public void setSourceSubinventory(String sourceSubinventory) {
        this.sourceSubinventory = sourceSubinventory;
    }

    public String getSourceOrganizationId() {
        return sourceOrganizationId;
    }

    public void setSourceOrganizationId(String sourceOrganizationId) {
        this.sourceOrganizationId = sourceOrganizationId;
    }

    public String getSourceOrganizationCode() {
        return sourceOrganizationCode;
    }

    public void setSourceOrganizationCode(String sourceOrganizationCode) {
        this.sourceOrganizationCode = sourceOrganizationCode;
    }

    public String getSourceOrganizationName() {
        return sourceOrganizationName;
    }

    public void setSourceOrganizationName(String sourceOrganizationName) {
        this.sourceOrganizationName = sourceOrganizationName;
    }

    public String getPreprocessingLeadTime() {
        return preprocessingLeadTime;
    }

    public void setPreprocessingLeadTime(String preprocessingLeadTime) {
        this.preprocessingLeadTime = preprocessingLeadTime;
    }

    public String getProcessingLeadTime() {
        return processingLeadTime;
    }

    public void setProcessingLeadTime(String processingLeadTime) {
        this.processingLeadTime = processingLeadTime;
    }

    public String getPostprocessingLeadTime() {
        return postprocessingLeadTime;
    }

    public void setPostprocessingLeadTime(String postprocessingLeadTime) {
        this.postprocessingLeadTime = postprocessingLeadTime;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getDepreciableCode() {
        return depreciableCode;
    }

    public void setDepreciableCode(Long depreciableCode) {
        this.depreciableCode = depreciableCode;
    }

    public String getDepreciable() {
        return depreciable;
    }

    public void setDepreciable(String depreciable) {
        this.depreciable = depreciable;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSubinventoryTypeCode() {
        return subinventoryTypeCode;
    }

    public void setSubinventoryTypeCode(String subinventoryTypeCode) {
        this.subinventoryTypeCode = subinventoryTypeCode;
    }

    public String getSubinventoryType() {
        return subinventoryType;
    }

    public void setSubinventoryType(String subinventoryType) {
        this.subinventoryType = subinventoryType;
    }
}
