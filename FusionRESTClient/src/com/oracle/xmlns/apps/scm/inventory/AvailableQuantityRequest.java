package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.oracle.xmlns.apps.shared.Link;

public class AvailableQuantityRequest implements Serializable {

    @SerializedName("OrganizationCode")
    @Expose
    private String organizationCode;
    @SerializedName("OrganizationId")
    @Expose
    private Long organizationId;
    @SerializedName("ItemNumber")
    @Expose
    private String itemNumber;
    @SerializedName("InventoryItemId")
    @Expose
    private Long inventoryItemId;
    @SerializedName("ItemRevision")
    @Expose
    private String itemRevision;
    @SerializedName("Subinventory")
    @Expose
    private String subinventory;
    @SerializedName("LocatorId")
    @Expose
    private String locatorId;
    @SerializedName("Lot")
    @Expose
    private String lot;
    @SerializedName("OwningEntityId")
    @Expose
    private String owningEntityId;
    @SerializedName("PrimaryUnitOfMeasure")
    @Expose
    private String primaryUnitOfMeasure;
    @SerializedName("QuantityOnhand")
    @Expose
    private String quantityOnhand;
    @SerializedName("AvailableToTransact")
    @Expose
    private String availableToTransact;
    @SerializedName("SecondaryUnitOfMeasure")
    @Expose
    private String secondaryUnitOfMeasure;
    @SerializedName("SecondaryQuantityOnhand")
    @Expose
    private String secondaryQuantityOnhand;
    @SerializedName("SecondaryAvailableToTransact")
    @Expose
    private String secondaryAvailableToTransact;
    @SerializedName("ReturnStatus")
    @Expose
    private final static long serialVersionUID = -4353572704871521737L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AvailableQuantityRequest() {
    }

    /**
     *
     * @param subinventory
     * @param locatorId
     * @param primaryUnitOfMeasure
     * @param secondaryQuantityOnhand
     * @param returnMessageText
     * @param itemRevision
     * @param returnMessageName
     * @param secondaryAvailableToTransact
     * @param links
     * @param organizationId
     * @param organizationCode
     * @param quantityOnhand
     * @param availableToTransact
     * @param owningEntityId
     * @param returnStatus
     * @param secondaryUnitOfMeasure
     * @param lot
     * @param itemNumber
     * @param inventoryItemId
     */
    public AvailableQuantityRequest(String organizationCode, Long organizationId, String itemNumber, Long inventoryItemId,
                             String itemRevision, String subinventory, String locatorId, String lot,
                             String owningEntityId, String primaryUnitOfMeasure, String quantityOnhand,
                             String availableToTransact, String secondaryUnitOfMeasure, String secondaryQuantityOnhand,
                             String secondaryAvailableToTransact) {
        super();
        this.organizationCode = organizationCode;
        this.organizationId = organizationId;
        this.itemNumber = itemNumber;
        this.inventoryItemId = inventoryItemId;
        this.itemRevision = itemRevision;
        this.subinventory = subinventory;
        this.locatorId = locatorId;
        this.lot = lot;
        this.owningEntityId = owningEntityId;
        this.primaryUnitOfMeasure = primaryUnitOfMeasure;
        this.quantityOnhand = quantityOnhand;
        this.availableToTransact = availableToTransact;
        this.secondaryUnitOfMeasure = secondaryUnitOfMeasure;
        this.secondaryQuantityOnhand = secondaryQuantityOnhand;
        this.secondaryAvailableToTransact = secondaryAvailableToTransact;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public AvailableQuantityRequest withOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
        return this;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public AvailableQuantityRequest withOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public AvailableQuantityRequest withItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public AvailableQuantityRequest withInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
        return this;
    }

    public String getItemRevision() {
        return itemRevision;
    }

    public void setItemRevision(String itemRevision) {
        this.itemRevision = itemRevision;
    }

    public AvailableQuantityRequest withItemRevision(String itemRevision) {
        this.itemRevision = itemRevision;
        return this;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public AvailableQuantityRequest withSubinventory(String subinventory) {
        this.subinventory = subinventory;
        return this;
    }

    public String getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    public AvailableQuantityRequest withLocatorId(String locatorId) {
        this.locatorId = locatorId;
        return this;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public AvailableQuantityRequest withLot(String lot) {
        this.lot = lot;
        return this;
    }

    public String getOwningEntityId() {
        return owningEntityId;
    }

    public void setOwningEntityId(String owningEntityId) {
        this.owningEntityId = owningEntityId;
    }

    public AvailableQuantityRequest withOwningEntityId(String owningEntityId) {
        this.owningEntityId = owningEntityId;
        return this;
    }

    public String getPrimaryUnitOfMeasure() {
        return primaryUnitOfMeasure;
    }

    public void setPrimaryUnitOfMeasure(String primaryUnitOfMeasure) {
        this.primaryUnitOfMeasure = primaryUnitOfMeasure;
    }

    public AvailableQuantityRequest withPrimaryUnitOfMeasure(String primaryUnitOfMeasure) {
        this.primaryUnitOfMeasure = primaryUnitOfMeasure;
        return this;
    }

    public String getQuantityOnhand() {
        return quantityOnhand;
    }

    public void setQuantityOnhand(String quantityOnhand) {
        this.quantityOnhand = quantityOnhand;
    }

    public AvailableQuantityRequest withQuantityOnhand(String quantityOnhand) {
        this.quantityOnhand = quantityOnhand;
        return this;
    }

    public String getAvailableToTransact() {
        return availableToTransact;
    }

    public void setAvailableToTransact(String availableToTransact) {
        this.availableToTransact = availableToTransact;
    }

    public AvailableQuantityRequest withAvailableToTransact(String availableToTransact) {
        this.availableToTransact = availableToTransact;
        return this;
    }

    public String getSecondaryUnitOfMeasure() {
        return secondaryUnitOfMeasure;
    }

    public void setSecondaryUnitOfMeasure(String secondaryUnitOfMeasure) {
        this.secondaryUnitOfMeasure = secondaryUnitOfMeasure;
    }

    public AvailableQuantityRequest withSecondaryUnitOfMeasure(String secondaryUnitOfMeasure) {
        this.secondaryUnitOfMeasure = secondaryUnitOfMeasure;
        return this;
    }

    public String getSecondaryQuantityOnhand() {
        return secondaryQuantityOnhand;
    }

    public void setSecondaryQuantityOnhand(String secondaryQuantityOnhand) {
        this.secondaryQuantityOnhand = secondaryQuantityOnhand;
    }

    public AvailableQuantityRequest withSecondaryQuantityOnhand(String secondaryQuantityOnhand) {
        this.secondaryQuantityOnhand = secondaryQuantityOnhand;
        return this;
    }

    public String getSecondaryAvailableToTransact() {
        return secondaryAvailableToTransact;
    }

    public void setSecondaryAvailableToTransact(String secondaryAvailableToTransact) {
        this.secondaryAvailableToTransact = secondaryAvailableToTransact;
    }

    public AvailableQuantityRequest withSecondaryAvailableToTransact(String secondaryAvailableToTransact) {
        this.secondaryAvailableToTransact = secondaryAvailableToTransact;
        return this;
    }

}
