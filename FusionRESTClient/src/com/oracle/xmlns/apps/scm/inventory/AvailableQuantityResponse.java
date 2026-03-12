package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.oracle.xmlns.apps.shared.Link;

public class AvailableQuantityResponse implements Serializable {

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
    private String returnStatus;
    @SerializedName("ReturnMessageName")
    @Expose
    private String returnMessageName;
    @SerializedName("ReturnMessageText")
    @Expose
    private String returnMessageText;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    private final static long serialVersionUID = -4353572704871521737L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AvailableQuantityResponse() {
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
    public AvailableQuantityResponse(String organizationCode, Long organizationId, String itemNumber, Long inventoryItemId,
                             String itemRevision, String subinventory, String locatorId, String lot,
                             String owningEntityId, String primaryUnitOfMeasure, String quantityOnhand,
                             String availableToTransact, String secondaryUnitOfMeasure, String secondaryQuantityOnhand,
                             String secondaryAvailableToTransact, String returnStatus, String returnMessageName,
                             String returnMessageText, List<Link> links) {
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
        this.returnStatus = returnStatus;
        this.returnMessageName = returnMessageName;
        this.returnMessageText = returnMessageText;
        this.links = links;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemRevision() {
        return itemRevision;
    }

    public void setItemRevision(String itemRevision) {
        this.itemRevision = itemRevision;
    }

    public String getSubinventory() {
        return subinventory;
    }

    public void setSubinventory(String subinventory) {
        this.subinventory = subinventory;
    }

    public String getLocatorId() {
        return locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getOwningEntityId() {
        return owningEntityId;
    }

    public void setOwningEntityId(String owningEntityId) {
        this.owningEntityId = owningEntityId;
    }

    public String getPrimaryUnitOfMeasure() {
        return primaryUnitOfMeasure;
    }

    public void setPrimaryUnitOfMeasure(String primaryUnitOfMeasure) {
        this.primaryUnitOfMeasure = primaryUnitOfMeasure;
    }

    public String getQuantityOnhand() {
        return quantityOnhand;
    }

    public void setQuantityOnhand(String quantityOnhand) {
        this.quantityOnhand = quantityOnhand;
    }

    public String getAvailableToTransact() {
        return availableToTransact;
    }

    public void setAvailableToTransact(String availableToTransact) {
        this.availableToTransact = availableToTransact;
    }

    public String getSecondaryUnitOfMeasure() {
        return secondaryUnitOfMeasure;
    }

    public void setSecondaryUnitOfMeasure(String secondaryUnitOfMeasure) {
        this.secondaryUnitOfMeasure = secondaryUnitOfMeasure;
    }

    public String getSecondaryQuantityOnhand() {
        return secondaryQuantityOnhand;
    }

    public void setSecondaryQuantityOnhand(String secondaryQuantityOnhand) {
        this.secondaryQuantityOnhand = secondaryQuantityOnhand;
    }

    public String getSecondaryAvailableToTransact() {
        return secondaryAvailableToTransact;
    }

    public void setSecondaryAvailableToTransact(String secondaryAvailableToTransact) {
        this.secondaryAvailableToTransact = secondaryAvailableToTransact;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getReturnMessageName() {
        return returnMessageName;
    }

    public void setReturnMessageName(String returnMessageName) {
        this.returnMessageName = returnMessageName;
    }

    public String getReturnMessageText() {
        return returnMessageText;
    }

    public void setReturnMessageText(String returnMessageText) {
        this.returnMessageText = returnMessageText;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
