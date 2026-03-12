package com.oracle.xmlns.apps.scm.inventory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InventoryOrganization {

    @SerializedName("OrganizationId")
    @Expose
    private long organizationId;
    @SerializedName("OrganizationCode")
    @Expose
    private String organizationCode;
    @SerializedName("OrganizationName")
    @Expose
    private String organizationName;
    @SerializedName("ManagementBusinessUnitId")
    @Expose
    private long managementBusinessUnitId;
    @SerializedName("ManagementBusinessUnitName")
    @Expose
    private String managementBusinessUnitName;
    @SerializedName("LegalEntityId")
    @Expose
    private long legalEntityId;
    @SerializedName("LegalEntityName")
    @Expose
    private String legalEntityName;
    @SerializedName("ProfitCenterBusinessUnitId")
    @Expose
    private long profitCenterBusinessUnitId;
    @SerializedName("ProfitCenterBusinessUnitName")
    @Expose
    private String profitCenterBusinessUnitName;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("LocationId")
    @Expose
    private long locationId;
    @SerializedName("LocationCode")
    @Expose
    private Object locationCode;
    @SerializedName("InventoryFlag")
    @Expose
    private boolean inventoryFlag;
    @SerializedName("ManufacturingPlantFlag")
    @Expose
    private boolean manufacturingPlantFlag;
    @SerializedName("ContractManufacturingFlag")
    @Expose
    private boolean contractManufacturingFlag;
    @SerializedName("MaintenanceEnabledFlag")
    @Expose
    private boolean maintenanceEnabledFlag;
    private final static long serialVersionUID = -6386930993981675343L;

    public InventoryOrganization() {
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
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

    public long getManagementBusinessUnitId() {
        return managementBusinessUnitId;
    }

    public void setManagementBusinessUnitId(long managementBusinessUnitId) {
        this.managementBusinessUnitId = managementBusinessUnitId;
    }

    public String getManagementBusinessUnitName() {
        return managementBusinessUnitName;
    }

    public void setManagementBusinessUnitName(String managementBusinessUnitName) {
        this.managementBusinessUnitName = managementBusinessUnitName;
    }

    public long getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(long legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public String getLegalEntityName() {
        return legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) {
        this.legalEntityName = legalEntityName;
    }

    public long getProfitCenterBusinessUnitId() {
        return profitCenterBusinessUnitId;
    }

    public void setProfitCenterBusinessUnitId(long profitCenterBusinessUnitId) {
        this.profitCenterBusinessUnitId = profitCenterBusinessUnitId;
    }

    public String getProfitCenterBusinessUnitName() {
        return profitCenterBusinessUnitName;
    }

    public void setProfitCenterBusinessUnitName(String profitCenterBusinessUnitName) {
        this.profitCenterBusinessUnitName = profitCenterBusinessUnitName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public Object getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(Object locationCode) {
        this.locationCode = locationCode;
    }

    public boolean isInventoryFlag() {
        return inventoryFlag;
    }

    public void setInventoryFlag(boolean inventoryFlag) {
        this.inventoryFlag = inventoryFlag;
    }

    public boolean isManufacturingPlantFlag() {
        return manufacturingPlantFlag;
    }

    public void setManufacturingPlantFlag(boolean manufacturingPlantFlag) {
        this.manufacturingPlantFlag = manufacturingPlantFlag;
    }

    public boolean isContractManufacturingFlag() {
        return contractManufacturingFlag;
    }

    public void setContractManufacturingFlag(boolean contractManufacturingFlag) {
        this.contractManufacturingFlag = contractManufacturingFlag;
    }

    public boolean isMaintenanceEnabledFlag() {
        return maintenanceEnabledFlag;
    }

    public void setMaintenanceEnabledFlag(boolean maintenanceEnabledFlag) {
        this.maintenanceEnabledFlag = maintenanceEnabledFlag;
    }

}
