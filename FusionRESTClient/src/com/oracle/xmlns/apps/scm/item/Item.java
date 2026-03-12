package com.oracle.xmlns.apps.scm.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Item {

    @SerializedName("ItemId")
    @Expose
    private Long itemId;
    @SerializedName("OrganizationId")
    @Expose
    private Long organizationId;
    @SerializedName("OrganizationCode")
    @Expose
    private String organizationCode;
    @SerializedName("ItemCatalogGroupId")
    @Expose
    private Long itemCatalogGroupId;
    @SerializedName("ItemClass")
    @Expose
    private String itemClass;
    @SerializedName("TemplateId")
    @Expose
    private String templateId;
    @SerializedName("Template")
    @Expose
    private String template;
    @SerializedName("ItemNumber")
    @Expose
    private String itemNumber;
    @SerializedName("ItemDescription")
    @Expose
    private String itemDescription;
    @SerializedName("ApprovalStatus")
    @Expose
    private String approvalStatus;
    @SerializedName("ApprovalStatusValue")
    @Expose
    private String approvalStatusValue;
    @SerializedName("InventoryItemStatusCode")
    @Expose
    private String inventoryItemStatusCode;
    @SerializedName("ItemStatusValue")
    @Expose
    private String itemStatusValue;
    @SerializedName("CurrentPhaseCode")
    @Expose
    private String currentPhaseCode;
    @SerializedName("LifecyclePhaseValue")
    @Expose
    private String lifecyclePhaseValue;
    @SerializedName("StyleItemFlag")
    @Expose
    private String styleItemFlag;
    @SerializedName("StyleItemId")
    @Expose
    private Long styleItemId;
    @SerializedName("StyleItemNumberValue")
    @Expose
    private String styleItemNumberValue;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("Keyword")
    @Expose
    private String keyword;
    @SerializedName("TextIndexItemId")
    @Expose
    private Long textIndexItemId;
    @SerializedName("OrgId")
    @Expose
    private Long orgId;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("IgnoreDuplicateItemFlag")
    @Expose
    private String ignoreDuplicateItemFlag;
    @SerializedName("ItemType")
    @Expose
    private String itemType;
    @SerializedName("UserItemTypeValue")
    @Expose
    private String userItemTypeValue;
    @SerializedName("TradeItemDescriptor")
    @Expose
    private String tradeItemDescriptor;
    @SerializedName("PackTypeValue")
    @Expose
    private String packTypeValue;
    @SerializedName("LongDescription")
    @Expose
    private String longDescription;
    @SerializedName("FormattedDescription")
    @Expose
    private String formattedDescription;
    @SerializedName("PrimaryUOMCode")
    @Expose
    private String primaryUOMCode;
    @SerializedName("PrimaryUOMValue")
    @Expose
    private String primaryUOMValue;
    @SerializedName("TrackingQuantityId")
    @Expose
    private String trackingQuantityId;
    @SerializedName("TrackingUnitofMeasure")
    @Expose
    private String trackingUnitofMeasure;
    @SerializedName("OntPricingQuantitySource")
    @Expose
    private String ontPricingQuantitySource;
    @SerializedName("UOMPricingValue")
    @Expose
    private String uOMPricingValue;
    @SerializedName("AllowedUnitsLookupCode")
    @Expose
    private Long allowedUnitsLookupCode;
    @SerializedName("TransactionConversionValue")
    @Expose
    private String transactionConversionValue;
    @SerializedName("SecondaryUOMCode")
    @Expose
    private String secondaryUOMCode;
    @SerializedName("SecondaryUnitofMeasureValue")
    @Expose
    private String secondaryUnitofMeasureValue;
    @SerializedName("SecondaryDefaultId")
    @Expose
    private String secondaryDefaultId;
    @SerializedName("DefaultingControlValue")
    @Expose
    private String defaultingControlValue;
    @SerializedName("PositiveDeviationFactor")
    @Expose
    private Long positiveDeviationFactor;
    @SerializedName("NegativeDeviationFactor")
    @Expose
    private Long negativeDeviationFactor;
    @SerializedName("CopyItemAndApplyTemplatesFlag")
    @Expose
    private String copyItemAndApplyTemplatesFlag;
    @SerializedName("CopyAssociationsFlag")
    @Expose
    private String copyAssociationsFlag;
    @SerializedName("CopyAttachmentsFlag")
    @Expose
    private String copyAttachmentsFlag;
    @SerializedName("CopyCategoriesFlag")
    @Expose
    private String copyCategoriesFlag;
    @SerializedName("CopyFromItemId")
    @Expose
    private String copyFromItemId;
    @SerializedName("CopyFromItemValue")
    @Expose
    private String copyFromItemValue;
    @SerializedName("CopyFromOrganizationId")
    @Expose
    private String copyFromOrganizationId;
    @SerializedName("CopyFromOrganizationValue")
    @Expose
    private String copyFromOrganizationValue;
    @SerializedName("CopyFromRevisionId")
    @Expose
    private String copyFromRevisionId;
    @SerializedName("CopyFromRevisionValue")
    @Expose
    private String copyFromRevisionValue;
    @SerializedName("CopyFromVersionId")
    @Expose
    private String copyFromVersionId;
    @SerializedName("CopyFromVersionValue")
    @Expose
    private String copyFromVersionValue;
    @SerializedName("CopyOrganizationAssignmentsFlag")
    @Expose
    private String copyOrganizationAssignmentsFlag;
    @SerializedName("VersionId")
    @Expose
    private Long versionId;
    @SerializedName("RevisionForVersion")
    @Expose
    private String revisionForVersion;
    @SerializedName("Version")
    @Expose
    private String version;
    @SerializedName("VersionStatus")
    @Expose
    private String versionStatus;
    @SerializedName("VersionDescription")
    @Expose
    private String versionDescription;
    @SerializedName("VersionPlannedEffectiveDateTime")
    @Expose
    private String versionPlannedEffectiveDateTime;
    @SerializedName("LastSubmittedNirId")
    @Expose
    private String lastSubmittedNirId;
    @SerializedName("LastSubmittedNewItemRequest")
    @Expose
    private String lastSubmittedNewItemRequest;
    @SerializedName("ChangeNotice")
    @Expose
    private String changeNotice;
    @SerializedName("ChangeOrderLineSequenceNumber")
    @Expose
    private String changeOrderLineSequenceNumber;
    @SerializedName("BOMItemType")
    @Expose
    private Long bOMItemType;
    @SerializedName("StructureItemTypeValue")
    @Expose
    private String structureItemTypeValue;
    @SerializedName("ConfigOrganization")
    @Expose
    private String configOrganization;
    @SerializedName("CreateConfiguredItem")
    @Expose
    private String createConfiguredItem;
    @SerializedName("ConfigModelType")
    @Expose
    private String configModelType;
    @SerializedName("ConfigModelTypeValue")
    @Expose
    private String configModelTypeValue;
    @SerializedName("EffectivityControl")
    @Expose
    private Long effectivityControl;
    @SerializedName("EffectivityControlValue")
    @Expose
    private String effectivityControlValue;
    @SerializedName("BaseItemId")
    @Expose
    private String baseItemId;
    @SerializedName("BaseItemValue")
    @Expose
    private String baseItemValue;
    @SerializedName("AutoCreatedConfigurationFlag")
    @Expose
    private Boolean autoCreatedConfigurationFlag;
    @SerializedName("PickComponentsFlag")
    @Expose
    private Boolean pickComponentsFlag;
    @SerializedName("AssembleToOrderFlag")
    @Expose
    private Boolean assembleToOrderFlag;
    @SerializedName("CostingEnabledFlag")
    @Expose
    private Boolean costingEnabledFlag;
    @SerializedName("IncludeInRollUpFlag")
    @Expose
    private Boolean includeInRollUpFlag;
    @SerializedName("StandardLotSize")
    @Expose
    private String standardLotSize;
    @SerializedName("InventoryAssetFlag")
    @Expose
    private Boolean inventoryAssetFlag;
    @SerializedName("BuildInWIPFlag")
    @Expose
    private Boolean buildInWIPFlag;
    @SerializedName("WIPSupplyType")
    @Expose
    private Long wIPSupplyType;
    @SerializedName("WIPSupplyTypeValue")
    @Expose
    private String wIPSupplyTypeValue;
    @SerializedName("StructureInstanceNumber")
    @Expose
    private String structureInstanceNumber;
    @SerializedName("SubInventoryId")
    @Expose
    private String subInventoryId;
    @SerializedName("WipSupplyLocatorId")
    @Expose
    private String wipSupplyLocatorId;
    @SerializedName("WIPSupplyLocatorValue")
    @Expose
    private String wIPSupplyLocatorValue;
    @SerializedName("WIPSupplySubinventory")
    @Expose
    private String wIPSupplySubinventory;
    @SerializedName("WIPSupplySubinventoryValue")
    @Expose
    private String wIPSupplySubinventoryValue;
    @SerializedName("OvercompletionToleranceType")
    @Expose
    private String overcompletionToleranceType;
    @SerializedName("OvercompletionToleranceTypeValue")
    @Expose
    private String overcompletionToleranceTypeValue;
    @SerializedName("OvercompletionToleranceValue")
    @Expose
    private String overcompletionToleranceValue;
    @SerializedName("InventoryCarryPenalty")
    @Expose
    private String inventoryCarryPenalty;
    @SerializedName("OperationSlackPenalty")
    @Expose
    private String operationSlackPenalty;
    @SerializedName("RecipeEnabledFlag")
    @Expose
    private Boolean recipeEnabledFlag;
    @SerializedName("ProcessQualityEnabledFlag")
    @Expose
    private Boolean processQualityEnabledFlag;
    @SerializedName("ProcessCostingEnabledFlag")
    @Expose
    private Boolean processCostingEnabledFlag;
    @SerializedName("ProcessExecutionEnabledFlag")
    @Expose
    private Boolean processExecutionEnabledFlag;
    @SerializedName("ProcessSupplySubinventory")
    @Expose
    private String processSupplySubinventory;
    @SerializedName("ProcessSupplySubinventoryValue")
    @Expose
    private String processSupplySubinventoryValue;
    @SerializedName("PSStructureInstanceNumber")
    @Expose
    private String pSStructureInstanceNumber;
    @SerializedName("PSSubInventoryId")
    @Expose
    private String pSSubInventoryId;
    @SerializedName("ProcessSupplyLocatorId")
    @Expose
    private String processSupplyLocatorId;
    @SerializedName("ProcessSupplyLocatorValue")
    @Expose
    private String processSupplyLocatorValue;
    @SerializedName("ProcessYieldSubinventory")
    @Expose
    private String processYieldSubinventory;
    @SerializedName("ProcessYieldSubinventoryValue")
    @Expose
    private String processYieldSubinventoryValue;
    @SerializedName("PYStructureInstanceNumber")
    @Expose
    private String pYStructureInstanceNumber;
    @SerializedName("PYSubInventoryId")
    @Expose
    private String pYSubInventoryId;
    @SerializedName("ProcessYieldLocatorId")
    @Expose
    private String processYieldLocatorId;
    @SerializedName("ProcessYieldLocatorValue")
    @Expose
    private String processYieldLocatorValue;
    @SerializedName("HazardousMaterialFlag")
    @Expose
    private Boolean hazardousMaterialFlag;
    @SerializedName("CASNumber")
    @Expose
    private String cASNumber;
    @SerializedName("EAMItemType")
    @Expose
    private String eAMItemType;
    @SerializedName("AssetItemTypeValue")
    @Expose
    private String assetItemTypeValue;
    @SerializedName("EAMActivityCauseCode")
    @Expose
    private String eAMActivityCauseCode;
    @SerializedName("AssetActivityCauseValue")
    @Expose
    private String assetActivityCauseValue;
    @SerializedName("EAMActivityShutdownStatus")
    @Expose
    private String eAMActivityShutdownStatus;
    @SerializedName("AssetActivityShutdownTypeValue")
    @Expose
    private String assetActivityShutdownTypeValue;
    @SerializedName("AssetTrackedFlag")
    @Expose
    private Boolean assetTrackedFlag;
    @SerializedName("EAMActivityTypeCode")
    @Expose
    private String eAMActivityTypeCode;
    @SerializedName("EAMActivityTypeValue")
    @Expose
    private String eAMActivityTypeValue;
    @SerializedName("EAMActivitySourceCode")
    @Expose
    private String eAMActivitySourceCode;
    @SerializedName("EAMActivitySourceValue")
    @Expose
    private String eAMActivitySourceValue;
    @SerializedName("EAMActivityNotificationFlag")
    @Expose
    private String eAMActivityNotificationFlag;
    @SerializedName("AssetClass")
    @Expose
    private String assetClass;
    @SerializedName("AssetClassValue")
    @Expose
    private String assetClassValue;
    @SerializedName("ServiceRequestEnabledCode")
    @Expose
    private String serviceRequestEnabledCode;
    @SerializedName("ServiceRequestEnabledValue")
    @Expose
    private String serviceRequestEnabledValue;
    @SerializedName("DefectTrackingOnFlag")
    @Expose
    private String defectTrackingOnFlag;
    @SerializedName("ServiceableProductFlag")
    @Expose
    private Boolean serviceableProductFlag;
    @SerializedName("CommsActivationReqdFlag")
    @Expose
    private String commsActivationReqdFlag;
    @SerializedName("ServiceDurationTypeCode")
    @Expose
    private String serviceDurationTypeCode;
    @SerializedName("ServiceDurationTypeValue")
    @Expose
    private String serviceDurationTypeValue;
    @SerializedName("ServiceDuration")
    @Expose
    private String serviceDuration;
    @SerializedName("ServiceDurationPeriodCode")
    @Expose
    private String serviceDurationPeriodCode;
    @SerializedName("ServiceDurationPeriodValue")
    @Expose
    private String serviceDurationPeriodValue;
    @SerializedName("ServiceStartTypeCode")
    @Expose
    private String serviceStartTypeCode;
    @SerializedName("ServiceStartTypeValue")
    @Expose
    private String serviceStartTypeValue;
    @SerializedName("ServiceStartDelay")
    @Expose
    private Long serviceStartDelay;
    @SerializedName("ServiceStartingDelay")
    @Expose
    private String serviceStartingDelay;
    @SerializedName("AllowSuspendFlag")
    @Expose
    private Boolean allowSuspendFlag;
    @SerializedName("AllowTerminateFlag")
    @Expose
    private Boolean allowTerminateFlag;
    @SerializedName("RequiresFulfillmentLocFlag")
    @Expose
    private Boolean requiresFulfillmentLocFlag;
    @SerializedName("RequiresItemAssociationFlag")
    @Expose
    private Boolean requiresItemAssociationFlag;
    @SerializedName("TrackInstalledBaseFlag")
    @Expose
    private String trackInstalledBaseFlag;
    @SerializedName("CreateFixedAssetFlag")
    @Expose
    private String createFixedAssetFlag;
    @SerializedName("IbItemInstanceClass")
    @Expose
    private String ibItemInstanceClass;
    @SerializedName("InstanceClassValue")
    @Expose
    private String instanceClassValue;
    @SerializedName("MaterialBillableCode")
    @Expose
    private String materialBillableCode;
    @SerializedName("BillingTypeValue")
    @Expose
    private String billingTypeValue;
    @SerializedName("ServiceBillingEnabledFlag")
    @Expose
    private Boolean serviceBillingEnabledFlag;
    @SerializedName("RecoveredPartDispCode")
    @Expose
    private String recoveredPartDispCode;
    @SerializedName("RecoveredPartDispositionValue")
    @Expose
    private String recoveredPartDispositionValue;
    @SerializedName("InventoryItemFlag")
    @Expose
    private Boolean inventoryItemFlag;
    @SerializedName("StockEnabledFlag")
    @Expose
    private Boolean stockEnabledFlag;
    @SerializedName("MaterialTransactionEnabledFlag")
    @Expose
    private Boolean materialTransactionEnabledFlag;
    @SerializedName("ReservableFlag")
    @Expose
    private Long reservableFlag;
    @SerializedName("CheckMaterialShortageFlag")
    @Expose
    private Boolean checkMaterialShortageFlag;
    @SerializedName("RevisionQuantityControlFlag")
    @Expose
    private Long revisionQuantityControlFlag;
    @SerializedName("BulkPickedFlag")
    @Expose
    private Boolean bulkPickedFlag;
    @SerializedName("LotControlCode")
    @Expose
    private Long lotControlCode;
    @SerializedName("LotControlValue")
    @Expose
    private String lotControlValue;
    @SerializedName("StartingLotPrefix")
    @Expose
    private String startingLotPrefix;
    @SerializedName("StartingLotNumber")
    @Expose
    private String startingLotNumber;
    @SerializedName("MaturityDays")
    @Expose
    private String maturityDays;
    @SerializedName("HoldDays")
    @Expose
    private String holdDays;
    @SerializedName("ShelfLifeCode")
    @Expose
    private Long shelfLifeCode;
    @SerializedName("LotExpirationControlValue")
    @Expose
    private String lotExpirationControlValue;
    @SerializedName("ShelfLifeDays")
    @Expose
    private Long shelfLifeDays;
    @SerializedName("RetestInterval")
    @Expose
    private String retestInterval;
    @SerializedName("ExpirationActionCode")
    @Expose
    private String expirationActionCode;
    @SerializedName("ExpirationActionValue")
    @Expose
    private String expirationActionValue;
    @SerializedName("ExpirationActionInterval")
    @Expose
    private String expirationActionInterval;
    @SerializedName("ChildLotEnabledFlag")
    @Expose
    private Boolean childLotEnabledFlag;
    @SerializedName("ChildLotFormatValidationFlag")
    @Expose
    private Boolean childLotFormatValidationFlag;
    @SerializedName("CopyLotAttributeFlag")
    @Expose
    private Boolean copyLotAttributeFlag;
    @SerializedName("ChildLotPrefix")
    @Expose
    private String childLotPrefix;
    @SerializedName("ChildLotStartingNumber")
    @Expose
    private String childLotStartingNumber;
    @SerializedName("ParentChildGenerationCode")
    @Expose
    private String parentChildGenerationCode;
    @SerializedName("ChildLotParent")
    @Expose
    private String childLotParent;
    @SerializedName("LotTranslateEnabledFlag")
    @Expose
    private Boolean lotTranslateEnabledFlag;
    @SerializedName("LotSplitEnabledFlag")
    @Expose
    private Boolean lotSplitEnabledFlag;
    @SerializedName("LotDivisibleFlag")
    @Expose
    private Boolean lotDivisibleFlag;
    @SerializedName("LotSubstitutionEnabledFlag")
    @Expose
    private String lotSubstitutionEnabledFlag;
    @SerializedName("LotMergeEnabledFlag")
    @Expose
    private Boolean lotMergeEnabledFlag;
    @SerializedName("GradeControlFlag")
    @Expose
    private Boolean gradeControlFlag;
    @SerializedName("DefaultGrade")
    @Expose
    private String defaultGrade;
    @SerializedName("DefaultGradeValue")
    @Expose
    private String defaultGradeValue;
    @SerializedName("SerialNumberControlCode")
    @Expose
    private Long serialNumberControlCode;
    @SerializedName("SerialGenerationValue")
    @Expose
    private String serialGenerationValue;
    @SerializedName("SerialStartingPrefix")
    @Expose
    private String serialStartingPrefix;
    @SerializedName("SerialStartingNumber")
    @Expose
    private String serialStartingNumber;
    @SerializedName("NegativeMeasurementError")
    @Expose
    private String negativeMeasurementError;
    @SerializedName("PositiveMeasurementError")
    @Expose
    private String positiveMeasurementError;
    @SerializedName("CycleCountEnabledFlag")
    @Expose
    private Boolean cycleCountEnabledFlag;
    @SerializedName("LotStatusEnabledFlag")
    @Expose
    private Boolean lotStatusEnabledFlag;
    @SerializedName("SerialStatusEnabledFlag")
    @Expose
    private Boolean serialStatusEnabledFlag;
    @SerializedName("DefaultLotStatusId")
    @Expose
    private String defaultLotStatusId;
    @SerializedName("DefaultLotStatusValue")
    @Expose
    private String defaultLotStatusValue;
    @SerializedName("DefaultSerialStatusId")
    @Expose
    private String defaultSerialStatusId;
    @SerializedName("DefaultSerialStatusValue")
    @Expose
    private String defaultSerialStatusValue;
    @SerializedName("RestrictSubinventoriesFlag")
    @Expose
    private Long restrictSubinventoriesFlag;
    @SerializedName("RestrictLocatorsFlag")
    @Expose
    private Long restrictLocatorsFlag;
    @SerializedName("LocationControlCode")
    @Expose
    private Long locationControlCode;
    @SerializedName("StockLocatorControlValue")
    @Expose
    private String stockLocatorControlValue;
    @SerializedName("DimensionUOMCode")
    @Expose
    private String dimensionUOMCode;
    @SerializedName("DimensionUOMValue")
    @Expose
    private String dimensionUOMValue;
    @SerializedName("UnitWidthQuantity")
    @Expose
    private String unitWidthQuantity;
    @SerializedName("UnitLengthQuantity")
    @Expose
    private String unitLengthQuantity;
    @SerializedName("UnitHeightQuantity")
    @Expose
    private String unitHeightQuantity;
    @SerializedName("WeightUOMCode")
    @Expose
    private String weightUOMCode;
    @SerializedName("WeightUOMValue")
    @Expose
    private String weightUOMValue;
    @SerializedName("UnitWeightQuantity")
    @Expose
    private String unitWeightQuantity;
    @SerializedName("VolumeUOMCode")
    @Expose
    private String volumeUOMCode;
    @SerializedName("VolumeUOMValue")
    @Expose
    private String volumeUOMValue;
    @SerializedName("UnitVolumeQuantity")
    @Expose
    private String unitVolumeQuantity;
    @SerializedName("ContainerItemFlag")
    @Expose
    private String containerItemFlag;
    @SerializedName("ContainerTypeCode")
    @Expose
    private String containerTypeCode;
    @SerializedName("ContainerTypeValue")
    @Expose
    private String containerTypeValue;
    @SerializedName("MaximumLoadWeight")
    @Expose
    private String maximumLoadWeight;
    @SerializedName("VehicleItemFlag")
    @Expose
    private String vehicleItemFlag;
    @SerializedName("InternalVolume")
    @Expose
    private String internalVolume;
    @SerializedName("MinimumFillPercent")
    @Expose
    private String minimumFillPercent;
    @SerializedName("WarehouseEquipmentFlag")
    @Expose
    private Long warehouseEquipmentFlag;
    @SerializedName("EventFlag")
    @Expose
    private String eventFlag;
    @SerializedName("CollateralFlag")
    @Expose
    private String collateralFlag;
    @SerializedName("CustomerOrderFlag")
    @Expose
    private Boolean customerOrderFlag;
    @SerializedName("CustomerOrderEnabledFlag")
    @Expose
    private Boolean customerOrderEnabledFlag;
    @SerializedName("ATPComponentsCode")
    @Expose
    private String aTPComponentsCode;
    @SerializedName("ATPComponentsValue")
    @Expose
    private String aTPComponentsValue;
    @SerializedName("PickingRuleId")
    @Expose
    private String pickingRuleId;
    @SerializedName("PickingRuleValue")
    @Expose
    private String pickingRuleValue;
    @SerializedName("RMAInspectionRequiredFlag")
    @Expose
    private Long rMAInspectionRequiredFlag;
    @SerializedName("EligibilityRuleFlag")
    @Expose
    private String eligibilityRuleFlag;
    @SerializedName("InternalOrderFlag")
    @Expose
    private Boolean internalOrderFlag;
    @SerializedName("InternalOrderEnabledFlag")
    @Expose
    private Boolean internalOrderEnabledFlag;
    @SerializedName("ReturnableFlag")
    @Expose
    private Boolean returnableFlag;
    @SerializedName("ATPCode")
    @Expose
    private String aTPCode;
    @SerializedName("ATPValue")
    @Expose
    private String aTPValue;
    @SerializedName("FinancingAllowedFlag")
    @Expose
    private String financingAllowedFlag;
    @SerializedName("SalesProductType")
    @Expose
    private String salesProductType;
    @SerializedName("SalesProductTypeValue")
    @Expose
    private String salesProductTypeValue;
    @SerializedName("TransactionEnabledFlag")
    @Expose
    private Boolean transactionEnabledFlag;
    @SerializedName("OrderManagementIndivisibleFlag")
    @Expose
    private String orderManagementIndivisibleFlag;
    @SerializedName("DefaultSoSourceType")
    @Expose
    private String defaultSoSourceType;
    @SerializedName("DefaultSalesOrderSourceTypeValue")
    @Expose
    private String defaultSalesOrderSourceTypeValue;
    @SerializedName("ElectronicFormatFlag")
    @Expose
    private String electronicFormatFlag;
    @SerializedName("ShippableFlag")
    @Expose
    private Boolean shippableFlag;
    @SerializedName("DefaultShippingOrganization")
    @Expose
    private String defaultShippingOrganization;
    @SerializedName("DefaultShippingOrganizationValue")
    @Expose
    private String defaultShippingOrganizationValue;
    @SerializedName("ShipModelCompleteFlag")
    @Expose
    private Boolean shipModelCompleteFlag;
    @SerializedName("DownloadableFlag")
    @Expose
    private String downloadableFlag;
    @SerializedName("OverShipmentTolerance")
    @Expose
    private String overShipmentTolerance;
    @SerializedName("UnderShipmentTolerance")
    @Expose
    private String underShipmentTolerance;
    @SerializedName("OverReturnTolerance")
    @Expose
    private String overReturnTolerance;
    @SerializedName("UnderReturnTolerance")
    @Expose
    private String underReturnTolerance;
    @SerializedName("InvoicedFlag")
    @Expose
    private Boolean invoicedFlag;
    @SerializedName("AccountingRuleId")
    @Expose
    private String accountingRuleId;
    @SerializedName("AccountingRuleValue")
    @Expose
    private String accountingRuleValue;
    @SerializedName("PaymentTermsId")
    @Expose
    private String paymentTermsId;
    @SerializedName("PaymentTermsValue")
    @Expose
    private String paymentTermsValue;
    @SerializedName("TaxCode")
    @Expose
    private String taxCode;
    @SerializedName("OutputTaxClassificationCodeValue")
    @Expose
    private String outputTaxClassificationCodeValue;
    @SerializedName("InvoiceEnabledFlag")
    @Expose
    private Boolean invoiceEnabledFlag;
    @SerializedName("InvoicingRuleId")
    @Expose
    private String invoicingRuleId;
    @SerializedName("InvoicingRuleValue")
    @Expose
    private String invoicingRuleValue;
    @SerializedName("SalesSIN")
    @Expose
    private Long salesSIN;
    @SerializedName("SalesAccount")
    @Expose
    private String salesAccount;
    @SerializedName("SalesAccountValue")
    @Expose
    private String salesAccountValue;
    @SerializedName("WebStatus")
    @Expose
    private String webStatus;
    @SerializedName("WebStatusValue")
    @Expose
    private String webStatusValue;
    @SerializedName("BackOrderableFlag")
    @Expose
    private String backOrderableFlag;
    @SerializedName("OrderableOnWebFlag")
    @Expose
    private Boolean orderableOnWebFlag;
    @SerializedName("MinimumLicenseQuantity")
    @Expose
    private String minimumLicenseQuantity;
    @SerializedName("InventoryPlanningCode")
    @Expose
    private Long inventoryPlanningCode;
    @SerializedName("InventoryPlanningMethodValue")
    @Expose
    private String inventoryPlanningMethodValue;
    @SerializedName("PlanningMakeBuyCode")
    @Expose
    private Long planningMakeBuyCode;
    @SerializedName("PlanningMakeBuyValue")
    @Expose
    private String planningMakeBuyValue;
    @SerializedName("PlannerCode")
    @Expose
    private String plannerCode;
    @SerializedName("Planner")
    @Expose
    private String planner;
    @SerializedName("SubcontractingComponent")
    @Expose
    private String subcontractingComponent;
    @SerializedName("SubcontractingComponentValue")
    @Expose
    private String subcontractingComponentValue;
    @SerializedName("MinimumMinmaxQuantity")
    @Expose
    private String minimumMinmaxQuantity;
    @SerializedName("MaximumMinmaxQuantity")
    @Expose
    private String maximumMinmaxQuantity;
    @SerializedName("MinimumOrderQuantity")
    @Expose
    private String minimumOrderQuantity;
    @SerializedName("MaximumOrderQuantity")
    @Expose
    private String maximumOrderQuantity;
    @SerializedName("OrderCost")
    @Expose
    private String orderCost;
    @SerializedName("CarryPercentage")
    @Expose
    private String carryPercentage;
    @SerializedName("SourceType")
    @Expose
    private String sourceType;
    @SerializedName("ReplenishmentType")
    @Expose
    private String replenishmentType;
    @SerializedName("SourceOrganizationId")
    @Expose
    private String sourceOrganizationId;
    @SerializedName("SourceOrganizationValue")
    @Expose
    private String sourceOrganizationValue;
    @SerializedName("SourceSubinventoryOrganizationId")
    @Expose
    private String sourceSubinventoryOrganizationId;
    @SerializedName("SourceSubinventoryOrganizationValue")
    @Expose
    private String sourceSubinventoryOrganizationValue;
    @SerializedName("SourceSubinventory")
    @Expose
    private String sourceSubinventory;
    @SerializedName("SourceSubinventoryValue")
    @Expose
    private String sourceSubinventoryValue;
    @SerializedName("FixedOrderQuantity")
    @Expose
    private String fixedOrderQuantity;
    @SerializedName("FixedDaysSupply")
    @Expose
    private String fixedDaysSupply;
    @SerializedName("FixedLotSizeMultiplier")
    @Expose
    private String fixedLotSizeMultiplier;
    @SerializedName("SOAuthorizationCode")
    @Expose
    private Long sOAuthorizationCode;
    @SerializedName("ReleaseAuthorizationRequiredValue")
    @Expose
    private String releaseAuthorizationRequiredValue;
    @SerializedName("AutomaticallyExpireASNFlag")
    @Expose
    private Long automaticallyExpireASNFlag;
    @SerializedName("ConsignedFlag")
    @Expose
    private Long consignedFlag;
    @SerializedName("ReplenishmentMinimumOrder")
    @Expose
    private String replenishmentMinimumOrder;
    @SerializedName("ReplenishmentMinimumDays")
    @Expose
    private String replenishmentMinimumDays;
    @SerializedName("MaximumOrder")
    @Expose
    private String maximumOrder;
    @SerializedName("MaximumDaysOfSupply")
    @Expose
    private String maximumDaysOfSupply;
    @SerializedName("VMIFixedOrderQuantity")
    @Expose
    private String vMIFixedOrderQuantity;
    @SerializedName("VMIForecastType")
    @Expose
    private Long vMIForecastType;
    @SerializedName("ForecastTypelValue")
    @Expose
    private String forecastTypelValue;
    @SerializedName("ForecastHorizon")
    @Expose
    private String forecastHorizon;
    @SerializedName("MRPPlanningCode")
    @Expose
    private Long mRPPlanningCode;
    @SerializedName("PlanningMethodValue")
    @Expose
    private String planningMethodValue;
    @SerializedName("EndAssemblyPeggingCode")
    @Expose
    private String endAssemblyPeggingCode;
    @SerializedName("Pegging")
    @Expose
    private String pegging;
    @SerializedName("RoundingControlTypeFlag")
    @Expose
    private Long roundingControlTypeFlag;
    @SerializedName("CreateSupplyFlag")
    @Expose
    private Boolean createSupplyFlag;
    @SerializedName("CriticalComponentFlag")
    @Expose
    private Long criticalComponentFlag;
    @SerializedName("PlanningTimeFenceCode")
    @Expose
    private Long planningTimeFenceCode;
    @SerializedName("PlanningTimeFence")
    @Expose
    private String planningTimeFence;
    @SerializedName("DemandTimeFenceCode")
    @Expose
    private String demandTimeFenceCode;
    @SerializedName("DemandTimeFence")
    @Expose
    private String demandTimeFence;
    @SerializedName("ReleaseTimeFenceCode")
    @Expose
    private String releaseTimeFenceCode;
    @SerializedName("ReleaseTimeFence")
    @Expose
    private String releaseTimeFence;
    @SerializedName("SubstitutionWindowCode")
    @Expose
    private String substitutionWindowCode;
    @SerializedName("SubstitutionWindow")
    @Expose
    private String substitutionWindow;
    @SerializedName("ShrinkageRate")
    @Expose
    private String shrinkageRate;
    @SerializedName("ATOForecastControl")
    @Expose
    private Long aTOForecastControl;
    @SerializedName("ForecastControlValue")
    @Expose
    private String forecastControlValue;
    @SerializedName("AcceptableEarlyDays")
    @Expose
    private String acceptableEarlyDays;
    @SerializedName("PlannedInventoryPointFlag")
    @Expose
    private String plannedInventoryPointFlag;
    @SerializedName("ExcludeFromBudgetFlag")
    @Expose
    private Long excludeFromBudgetFlag;
    @SerializedName("PlanningTimeDays")
    @Expose
    private Long planningTimeDays;
    @SerializedName("DemandTimeDays")
    @Expose
    private String demandTimeDays;
    @SerializedName("ReleaseTimeDays")
    @Expose
    private String releaseTimeDays;
    @SerializedName("SubstitutionDays")
    @Expose
    private String substitutionDays;
    @SerializedName("MRPCalculateATPFlag")
    @Expose
    private String mRPCalculateATPFlag;
    @SerializedName("DRPPlannedFlag")
    @Expose
    private Long dRPPlannedFlag;
    @SerializedName("MaximumInventoryWindow")
    @Expose
    private String maximumInventoryWindow;
    @SerializedName("DaysMaximumInventorySupply")
    @Expose
    private String daysMaximumInventorySupply;
    @SerializedName("TargetInventoryDaysofSupply")
    @Expose
    private String targetInventoryDaysofSupply;
    @SerializedName("TagetInventoryWindow")
    @Expose
    private String tagetInventoryWindow;
    @SerializedName("RepairLeadtime")
    @Expose
    private String repairLeadtime;
    @SerializedName("RepairYield")
    @Expose
    private String repairYield;
    @SerializedName("PrepositionPointFlag")
    @Expose
    private Boolean prepositionPointFlag;
    @SerializedName("RepairProgram")
    @Expose
    private Long repairProgram;
    @SerializedName("RepairProgramValue")
    @Expose
    private String repairProgramValue;
    @SerializedName("PreprocessingDays")
    @Expose
    private String preprocessingDays;
    @SerializedName("PostprocessingDays")
    @Expose
    private Long postprocessingDays;
    @SerializedName("ProcessingDays")
    @Expose
    private String processingDays;
    @SerializedName("VariableLeadTime")
    @Expose
    private String variableLeadTime;
    @SerializedName("CumulativeTotalLeadTime")
    @Expose
    private String cumulativeTotalLeadTime;
    @SerializedName("FixedLeadTime")
    @Expose
    private String fixedLeadTime;
    @SerializedName("CumulativeManufacturingLeadTime")
    @Expose
    private String cumulativeManufacturingLeadTime;
    @SerializedName("LeadTimeLotSize")
    @Expose
    private Long leadTimeLotSize;
    @SerializedName("PurchasingFlag")
    @Expose
    private Boolean purchasingFlag;
    @SerializedName("UseApprovedSupplierFlag")
    @Expose
    private Boolean useApprovedSupplierFlag;
    @SerializedName("NegotiationRequiredFlag")
    @Expose
    private String negotiationRequiredFlag;
    @SerializedName("PurchasingTaxCode")
    @Expose
    private String purchasingTaxCode;
    @SerializedName("PurchasingInputTaxClassificationValue")
    @Expose
    private String purchasingInputTaxClassificationValue;
    @SerializedName("UnitOfIssue")
    @Expose
    private String unitOfIssue;
    @SerializedName("UnitOfIssueValue")
    @Expose
    private String unitOfIssueValue;
    @SerializedName("InvoiceCloseTolerancePercentage")
    @Expose
    private String invoiceCloseTolerancePercentage;
    @SerializedName("HazardClassId")
    @Expose
    private String hazardClassId;
    @SerializedName("HazardClassValue")
    @Expose
    private String hazardClassValue;
    @SerializedName("AssetCategorySIN")
    @Expose
    private Long assetCategorySIN;
    @SerializedName("AssetCategoryId")
    @Expose
    private String assetCategoryId;
    @SerializedName("AssetCategoryValue")
    @Expose
    private String assetCategoryValue;
    @SerializedName("PurchasableFlag")
    @Expose
    private Boolean purchasableFlag;
    @SerializedName("AllowItemDescriptionUpdateFlag")
    @Expose
    private Boolean allowItemDescriptionUpdateFlag;
    @SerializedName("TaxableFlag")
    @Expose
    private Boolean taxableFlag;
    @SerializedName("BuyerOrganizationId")
    @Expose
    private String buyerOrganizationId;
    @SerializedName("BuyerOrganizationValue")
    @Expose
    private String buyerOrganizationValue;
    @SerializedName("BuyerId")
    @Expose
    private String buyerId;
    @SerializedName("DefaultBuyerValue")
    @Expose
    private String defaultBuyerValue;
    @SerializedName("ReceiptCloseTolerancePercentage")
    @Expose
    private String receiptCloseTolerancePercentage;
    @SerializedName("UNNumberId")
    @Expose
    private String uNNumberId;
    @SerializedName("UNNumberValue")
    @Expose
    private String uNNumberValue;
    @SerializedName("ListPrice")
    @Expose
    private String listPrice;
    @SerializedName("PriceTolerancePercentage")
    @Expose
    private String priceTolerancePercentage;
    @SerializedName("ExpenseSIN")
    @Expose
    private Long expenseSIN;
    @SerializedName("ExpenseAccount")
    @Expose
    private String expenseAccount;
    @SerializedName("ExpenseAccountValue")
    @Expose
    private String expenseAccountValue;
    @SerializedName("MarketPrice")
    @Expose
    private String marketPrice;
    @SerializedName("RoundingFactor")
    @Expose
    private String roundingFactor;
    @SerializedName("OutsourcedAssemblyFlag")
    @Expose
    private String outsourcedAssemblyFlag;
    @SerializedName("OutsideProcessingFlag")
    @Expose
    private String outsideProcessingFlag;
    @SerializedName("OutsideOperationUOMType")
    @Expose
    private String outsideOperationUOMType;
    @SerializedName("OutsideProcessingUnitTypeValue")
    @Expose
    private String outsideProcessingUnitTypeValue;
    @SerializedName("MatchApprovalLevel")
    @Expose
    private Long matchApprovalLevel;
    @SerializedName("MatchApprovalLevelValue")
    @Expose
    private String matchApprovalLevelValue;
    @SerializedName("ConfigMatch")
    @Expose
    private String configMatch;
    @SerializedName("MatchConfigurationOptionValue")
    @Expose
    private String matchConfigurationOptionValue;
    @SerializedName("ReceivingRoutingId")
    @Expose
    private Long receivingRoutingId;
    @SerializedName("ReceiptRountingValue")
    @Expose
    private String receiptRountingValue;
    @SerializedName("EnforceShipToLocationCode")
    @Expose
    private String enforceShipToLocationCode;
    @SerializedName("EnforceShipToLocation")
    @Expose
    private String enforceShipToLocation;
    @SerializedName("ReceiptDaysExceptionCode")
    @Expose
    private String receiptDaysExceptionCode;
    @SerializedName("ReceiptDateActionValue")
    @Expose
    private String receiptDateActionValue;
    @SerializedName("DaysEarlyReceiptAllowed")
    @Expose
    private String daysEarlyReceiptAllowed;
    @SerializedName("DaysLateReceiptAllowed")
    @Expose
    private String daysLateReceiptAllowed;
    @SerializedName("AllowSubstituteReceiptsFlag")
    @Expose
    private String allowSubstituteReceiptsFlag;
    @SerializedName("AllowUnorderedReceiptsFlag")
    @Expose
    private String allowUnorderedReceiptsFlag;
    @SerializedName("AllowExpressDeliveryFlag")
    @Expose
    private String allowExpressDeliveryFlag;
    @SerializedName("QuantityRcvExceptionCode")
    @Expose
    private String quantityRcvExceptionCode;
    @SerializedName("QuantityReceivedToleranceAction")
    @Expose
    private String quantityReceivedToleranceAction;
    @SerializedName("QuantityReceivedTolerancePercentage")
    @Expose
    private String quantityReceivedTolerancePercentage;
    @SerializedName("WhUpdateDate")
    @Expose
    private Date whUpdateDate;
    @SerializedName("SummaryFlag")
    @Expose
    private String summaryFlag;
    @SerializedName("EndDateActive")
    @Expose
    private String endDateActive;
    @SerializedName("EnabledFlag")
    @Expose
    private String enabledFlag;
    @SerializedName("StartDateActive")
    @Expose
    private String startDateActive;
    @SerializedName("GdsnOutboundEnabledFlag")
    @Expose
    private String gdsnOutboundEnabledFlag;
    @SerializedName("AltItemCode")
    @Expose
    private String altItemCode;
    @SerializedName("AcdType")
    @Expose
    private String acdType;
    @SerializedName("ChangeBitMap")
    @Expose
    private String changeBitMap;
    @SerializedName("ChangeLineId")
    @Expose
    private Long changeLineId;
    @SerializedName("ImplementationDate")
    @Expose
    private Date implementationDate;
    @SerializedName("VersionEnableFlagAtICC")
    @Expose
    private String versionEnableFlagAtICC;
    @SerializedName("VersionAsOfDate")
    @Expose
    private String versionAsOfDate;
    @SerializedName("ContextChangeLineId")
    @Expose
    private Long contextChangeLineId;
    @SerializedName("ContextVersionId")
    @Expose
    private Long contextVersionId;
    @SerializedName("ContextDate")
    @Expose
    private Date contextDate;
    @SerializedName("PUOMClass")
    @Expose
    private String pUOMClass;
    @SerializedName("SUOMClass")
    @Expose
    private String sUOMClass;
    @SerializedName("CoverageScheduleId")
    @Expose
    private String coverageScheduleId;
    @SerializedName("InventoryOrganizationId")
    @Expose
    private Long inventoryOrganizationId;
    @SerializedName("InventoryOrganizationValue")
    @Expose
    private String inventoryOrganizationValue;
    @SerializedName("VersionEndDate")
    @Expose
    private Date versionEndDate;
    @SerializedName("VersionStartDate")
    @Expose
    private Date versionStartDate;
    @SerializedName("ItemExtensibleFlexfieldCategoryCode")
    @Expose
    private String itemExtensibleFlexfieldCategoryCode;
    @SerializedName("ObjectVersionNumber")
    @Expose
    private Long objectVersionNumber;
    @SerializedName("CreationDate")
    @Expose
    private Date creationDate;
    @SerializedName("LastUpdateDate")
    @Expose
    private Date lastUpdateDate;
    @SerializedName("BackToBackEnabledFlag")
    @Expose
    private Boolean backToBackEnabledFlag;
    @SerializedName("ContractManufacturingFlag")
    @Expose
    private Boolean contractManufacturingFlag;
    @SerializedName("DaysOfCover")
    @Expose
    private String daysOfCover;
    @SerializedName("DemandPeriod")
    @Expose
    private String demandPeriod;
    @SerializedName("SafetyStockPlanningMethod")
    @Expose
    private String safetyStockPlanningMethod;
    @SerializedName("SafetyStockPlanningMethodValue")
    @Expose
    private String safetyStockPlanningMethodValue;
    @SerializedName("AttachmentEntityName")
    @Expose
    private String attachmentEntityName;
    @SerializedName("OutsideProcessServiceFlag")
    @Expose
    private Boolean outsideProcessServiceFlag;
    @SerializedName("AllowMaintenanceAssetFlag")
    @Expose
    private Boolean allowMaintenanceAssetFlag;
    @SerializedName("EnableGenealogyTrackingFlag")
    @Expose
    private Boolean enableGenealogyTrackingFlag;
    @SerializedName("CssEnabledFlag")
    @Expose
    private Boolean cssEnabledFlag;
    @SerializedName("ServiceDurationPeriodCodeClass")
    @Expose
    private String serviceDurationPeriodCodeClass;
    @SerializedName("EngineeredItemFlag")
    @Expose
    private Boolean engineeredItemFlag;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("StandardCoverage")
    @Expose
    private String standardCoverage;
    @SerializedName("InvItemIdChar")
    @Expose
    private String invItemIdChar;
    @SerializedName("OrgIdChar")
    @Expose
    private String orgIdChar;
    @SerializedName("FND_ACFF_Account_ConcatenatedStorage")
    @Expose
    private String fNDACFFAccountConcatenatedStorage;
    @SerializedName("FND_ACFF_Account_Delimiter")
    @Expose
    private String fNDACFFAccountDelimiter;
    @SerializedName("FND_ACFF_LocatorFlexField_ConcatenatedStorage")
    @Expose
    private String fNDACFFLocatorFlexFieldConcatenatedStorage;
    @SerializedName("FND_ACFF_LocatorFlexField_Delimiter")
    @Expose
    private String fNDACFFLocatorFlexFieldDelimiter;
    @SerializedName("FND_ACFF_Account1_ConcatenatedStorage")
    @Expose
    private String fNDACFFAccount1ConcatenatedStorage;
    @SerializedName("FND_ACFF_Account1_Delimiter")
    @Expose
    private String fNDACFFAccount1Delimiter;
    @SerializedName("FND_ACFF_LocatorFlexField2_ConcatenatedStorage")
    @Expose
    private String fNDACFFLocatorFlexField2ConcatenatedStorage;
    @SerializedName("FND_ACFF_LocatorFlexField2_Delimiter")
    @Expose
    private String fNDACFFLocatorFlexField2Delimiter;
    @SerializedName("FND_ACFF_Category_ConcatenatedStorage")
    @Expose
    private String fNDACFFCategoryConcatenatedStorage;
    @SerializedName("FND_ACFF_Category_Delimiter")
    @Expose
    private String fNDACFFCategoryDelimiter;
    @SerializedName("FND_ACFF_LocatorFlexField1_ConcatenatedStorage")
    @Expose
    private String fNDACFFLocatorFlexField1ConcatenatedStorage;
    @SerializedName("FND_ACFF_LocatorFlexField1_Delimiter")
    @Expose
    private String fNDACFFLocatorFlexField1Delimiter;
    private final static long serialVersionUID = -8009484252206433450L;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public Long getItemCatalogGroupId() {
        return itemCatalogGroupId;
    }

    public void setItemCatalogGroupId(Long itemCatalogGroupId) {
        this.itemCatalogGroupId = itemCatalogGroupId;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatusValue() {
        return approvalStatusValue;
    }

    public void setApprovalStatusValue(String approvalStatusValue) {
        this.approvalStatusValue = approvalStatusValue;
    }

    public String getInventoryItemStatusCode() {
        return inventoryItemStatusCode;
    }

    public void setInventoryItemStatusCode(String inventoryItemStatusCode) {
        this.inventoryItemStatusCode = inventoryItemStatusCode;
    }

    public String getItemStatusValue() {
        return itemStatusValue;
    }

    public void setItemStatusValue(String itemStatusValue) {
        this.itemStatusValue = itemStatusValue;
    }

    public String getCurrentPhaseCode() {
        return currentPhaseCode;
    }

    public void setCurrentPhaseCode(String currentPhaseCode) {
        this.currentPhaseCode = currentPhaseCode;
    }

    public String getLifecyclePhaseValue() {
        return lifecyclePhaseValue;
    }

    public void setLifecyclePhaseValue(String lifecyclePhaseValue) {
        this.lifecyclePhaseValue = lifecyclePhaseValue;
    }

    public String getStyleItemFlag() {
        return styleItemFlag;
    }

    public void setStyleItemFlag(String styleItemFlag) {
        this.styleItemFlag = styleItemFlag;
    }

    public Long getStyleItemId() {
        return styleItemId;
    }

    public void setStyleItemId(Long styleItemId) {
        this.styleItemId = styleItemId;
    }

    public String getStyleItemNumberValue() {
        return styleItemNumberValue;
    }

    public void setStyleItemNumberValue(String styleItemNumberValue) {
        this.styleItemNumberValue = styleItemNumberValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getTextIndexItemId() {
        return textIndexItemId;
    }

    public void setTextIndexItemId(Long textIndexItemId) {
        this.textIndexItemId = textIndexItemId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIgnoreDuplicateItemFlag() {
        return ignoreDuplicateItemFlag;
    }

    public void setIgnoreDuplicateItemFlag(String ignoreDuplicateItemFlag) {
        this.ignoreDuplicateItemFlag = ignoreDuplicateItemFlag;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getUserItemTypeValue() {
        return userItemTypeValue;
    }

    public void setUserItemTypeValue(String userItemTypeValue) {
        this.userItemTypeValue = userItemTypeValue;
    }

    public String getTradeItemDescriptor() {
        return tradeItemDescriptor;
    }

    public void setTradeItemDescriptor(String tradeItemDescriptor) {
        this.tradeItemDescriptor = tradeItemDescriptor;
    }

    public String getPackTypeValue() {
        return packTypeValue;
    }

    public void setPackTypeValue(String packTypeValue) {
        this.packTypeValue = packTypeValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFormattedDescription() {
        return formattedDescription;
    }

    public void setFormattedDescription(String formattedDescription) {
        this.formattedDescription = formattedDescription;
    }

    public String getPrimaryUOMCode() {
        return primaryUOMCode;
    }

    public void setPrimaryUOMCode(String primaryUOMCode) {
        this.primaryUOMCode = primaryUOMCode;
    }

    public String getPrimaryUOMValue() {
        return primaryUOMValue;
    }

    public void setPrimaryUOMValue(String primaryUOMValue) {
        this.primaryUOMValue = primaryUOMValue;
    }

    public String getTrackingQuantityId() {
        return trackingQuantityId;
    }

    public void setTrackingQuantityId(String trackingQuantityId) {
        this.trackingQuantityId = trackingQuantityId;
    }

    public String getTrackingUnitofMeasure() {
        return trackingUnitofMeasure;
    }

    public void setTrackingUnitofMeasure(String trackingUnitofMeasure) {
        this.trackingUnitofMeasure = trackingUnitofMeasure;
    }

    public String getOntPricingQuantitySource() {
        return ontPricingQuantitySource;
    }

    public void setOntPricingQuantitySource(String ontPricingQuantitySource) {
        this.ontPricingQuantitySource = ontPricingQuantitySource;
    }

    public String getUOMPricingValue() {
        return uOMPricingValue;
    }

    public void setUOMPricingValue(String uOMPricingValue) {
        this.uOMPricingValue = uOMPricingValue;
    }

    public Long getAllowedUnitsLookupCode() {
        return allowedUnitsLookupCode;
    }

    public void setAllowedUnitsLookupCode(Long allowedUnitsLookupCode) {
        this.allowedUnitsLookupCode = allowedUnitsLookupCode;
    }

    public String getTransactionConversionValue() {
        return transactionConversionValue;
    }

    public void setTransactionConversionValue(String transactionConversionValue) {
        this.transactionConversionValue = transactionConversionValue;
    }

    public String getSecondaryUOMCode() {
        return secondaryUOMCode;
    }

    public void setSecondaryUOMCode(String secondaryUOMCode) {
        this.secondaryUOMCode = secondaryUOMCode;
    }

    public String getSecondaryUnitofMeasureValue() {
        return secondaryUnitofMeasureValue;
    }

    public void setSecondaryUnitofMeasureValue(String secondaryUnitofMeasureValue) {
        this.secondaryUnitofMeasureValue = secondaryUnitofMeasureValue;
    }

    public String getSecondaryDefaultId() {
        return secondaryDefaultId;
    }

    public void setSecondaryDefaultId(String secondaryDefaultId) {
        this.secondaryDefaultId = secondaryDefaultId;
    }

    public String getDefaultingControlValue() {
        return defaultingControlValue;
    }

    public void setDefaultingControlValue(String defaultingControlValue) {
        this.defaultingControlValue = defaultingControlValue;
    }

    public Long getPositiveDeviationFactor() {
        return positiveDeviationFactor;
    }

    public void setPositiveDeviationFactor(Long positiveDeviationFactor) {
        this.positiveDeviationFactor = positiveDeviationFactor;
    }

    public Long getNegativeDeviationFactor() {
        return negativeDeviationFactor;
    }

    public void setNegativeDeviationFactor(Long negativeDeviationFactor) {
        this.negativeDeviationFactor = negativeDeviationFactor;
    }

    public String getCopyItemAndApplyTemplatesFlag() {
        return copyItemAndApplyTemplatesFlag;
    }

    public void setCopyItemAndApplyTemplatesFlag(String copyItemAndApplyTemplatesFlag) {
        this.copyItemAndApplyTemplatesFlag = copyItemAndApplyTemplatesFlag;
    }

    public String getCopyAssociationsFlag() {
        return copyAssociationsFlag;
    }

    public void setCopyAssociationsFlag(String copyAssociationsFlag) {
        this.copyAssociationsFlag = copyAssociationsFlag;
    }

    public String getCopyAttachmentsFlag() {
        return copyAttachmentsFlag;
    }

    public void setCopyAttachmentsFlag(String copyAttachmentsFlag) {
        this.copyAttachmentsFlag = copyAttachmentsFlag;
    }

    public String getCopyCategoriesFlag() {
        return copyCategoriesFlag;
    }

    public void setCopyCategoriesFlag(String copyCategoriesFlag) {
        this.copyCategoriesFlag = copyCategoriesFlag;
    }

    public String getCopyFromItemId() {
        return copyFromItemId;
    }

    public void setCopyFromItemId(String copyFromItemId) {
        this.copyFromItemId = copyFromItemId;
    }

    public String getCopyFromItemValue() {
        return copyFromItemValue;
    }

    public void setCopyFromItemValue(String copyFromItemValue) {
        this.copyFromItemValue = copyFromItemValue;
    }

    public String getCopyFromOrganizationId() {
        return copyFromOrganizationId;
    }

    public void setCopyFromOrganizationId(String copyFromOrganizationId) {
        this.copyFromOrganizationId = copyFromOrganizationId;
    }

    public String getCopyFromOrganizationValue() {
        return copyFromOrganizationValue;
    }

    public void setCopyFromOrganizationValue(String copyFromOrganizationValue) {
        this.copyFromOrganizationValue = copyFromOrganizationValue;
    }

    public String getCopyFromRevisionId() {
        return copyFromRevisionId;
    }

    public void setCopyFromRevisionId(String copyFromRevisionId) {
        this.copyFromRevisionId = copyFromRevisionId;
    }

    public String getCopyFromRevisionValue() {
        return copyFromRevisionValue;
    }

    public void setCopyFromRevisionValue(String copyFromRevisionValue) {
        this.copyFromRevisionValue = copyFromRevisionValue;
    }

    public String getCopyFromVersionId() {
        return copyFromVersionId;
    }

    public void setCopyFromVersionId(String copyFromVersionId) {
        this.copyFromVersionId = copyFromVersionId;
    }

    public String getCopyFromVersionValue() {
        return copyFromVersionValue;
    }

    public void setCopyFromVersionValue(String copyFromVersionValue) {
        this.copyFromVersionValue = copyFromVersionValue;
    }

    public String getCopyOrganizationAssignmentsFlag() {
        return copyOrganizationAssignmentsFlag;
    }

    public void setCopyOrganizationAssignmentsFlag(String copyOrganizationAssignmentsFlag) {
        this.copyOrganizationAssignmentsFlag = copyOrganizationAssignmentsFlag;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getRevisionForVersion() {
        return revisionForVersion;
    }

    public void setRevisionForVersion(String revisionForVersion) {
        this.revisionForVersion = revisionForVersion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(String versionStatus) {
        this.versionStatus = versionStatus;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public String getVersionPlannedEffectiveDateTime() {
        return versionPlannedEffectiveDateTime;
    }

    public void setVersionPlannedEffectiveDateTime(String versionPlannedEffectiveDateTime) {
        this.versionPlannedEffectiveDateTime = versionPlannedEffectiveDateTime;
    }

    public String getLastSubmittedNirId() {
        return lastSubmittedNirId;
    }

    public void setLastSubmittedNirId(String lastSubmittedNirId) {
        this.lastSubmittedNirId = lastSubmittedNirId;
    }

    public String getLastSubmittedNewItemRequest() {
        return lastSubmittedNewItemRequest;
    }

    public void setLastSubmittedNewItemRequest(String lastSubmittedNewItemRequest) {
        this.lastSubmittedNewItemRequest = lastSubmittedNewItemRequest;
    }

    public String getChangeNotice() {
        return changeNotice;
    }

    public void setChangeNotice(String changeNotice) {
        this.changeNotice = changeNotice;
    }

    public String getChangeOrderLineSequenceNumber() {
        return changeOrderLineSequenceNumber;
    }

    public void setChangeOrderLineSequenceNumber(String changeOrderLineSequenceNumber) {
        this.changeOrderLineSequenceNumber = changeOrderLineSequenceNumber;
    }

    public Long getBOMItemType() {
        return bOMItemType;
    }

    public void setBOMItemType(Long bOMItemType) {
        this.bOMItemType = bOMItemType;
    }

    public String getStructureItemTypeValue() {
        return structureItemTypeValue;
    }

    public void setStructureItemTypeValue(String structureItemTypeValue) {
        this.structureItemTypeValue = structureItemTypeValue;
    }

    public String getConfigOrganization() {
        return configOrganization;
    }

    public void setConfigOrganization(String configOrganization) {
        this.configOrganization = configOrganization;
    }

    public String getCreateConfiguredItem() {
        return createConfiguredItem;
    }

    public void setCreateConfiguredItem(String createConfiguredItem) {
        this.createConfiguredItem = createConfiguredItem;
    }

    public String getConfigModelType() {
        return configModelType;
    }

    public void setConfigModelType(String configModelType) {
        this.configModelType = configModelType;
    }

    public String getConfigModelTypeValue() {
        return configModelTypeValue;
    }

    public void setConfigModelTypeValue(String configModelTypeValue) {
        this.configModelTypeValue = configModelTypeValue;
    }

    public Long getEffectivityControl() {
        return effectivityControl;
    }

    public void setEffectivityControl(Long effectivityControl) {
        this.effectivityControl = effectivityControl;
    }

    public String getEffectivityControlValue() {
        return effectivityControlValue;
    }

    public void setEffectivityControlValue(String effectivityControlValue) {
        this.effectivityControlValue = effectivityControlValue;
    }

    public String getBaseItemId() {
        return baseItemId;
    }

    public void setBaseItemId(String baseItemId) {
        this.baseItemId = baseItemId;
    }

    public String getBaseItemValue() {
        return baseItemValue;
    }

    public void setBaseItemValue(String baseItemValue) {
        this.baseItemValue = baseItemValue;
    }

    public Boolean isAutoCreatedConfigurationFlag() {
        return autoCreatedConfigurationFlag;
    }

    public void setAutoCreatedConfigurationFlag(Boolean autoCreatedConfigurationFlag) {
        this.autoCreatedConfigurationFlag = autoCreatedConfigurationFlag;
    }

    public Boolean isPickComponentsFlag() {
        return pickComponentsFlag;
    }

    public void setPickComponentsFlag(Boolean pickComponentsFlag) {
        this.pickComponentsFlag = pickComponentsFlag;
    }

    public Boolean isAssembleToOrderFlag() {
        return assembleToOrderFlag;
    }

    public void setAssembleToOrderFlag(Boolean assembleToOrderFlag) {
        this.assembleToOrderFlag = assembleToOrderFlag;
    }

    public Boolean isCostingEnabledFlag() {
        return costingEnabledFlag;
    }

    public void setCostingEnabledFlag(Boolean costingEnabledFlag) {
        this.costingEnabledFlag = costingEnabledFlag;
    }

    public Boolean isIncludeInRollUpFlag() {
        return includeInRollUpFlag;
    }

    public void setIncludeInRollUpFlag(Boolean includeInRollUpFlag) {
        this.includeInRollUpFlag = includeInRollUpFlag;
    }

    public String getStandardLotSize() {
        return standardLotSize;
    }

    public void setStandardLotSize(String standardLotSize) {
        this.standardLotSize = standardLotSize;
    }

    public Boolean isInventoryAssetFlag() {
        return inventoryAssetFlag;
    }

    public void setInventoryAssetFlag(Boolean inventoryAssetFlag) {
        this.inventoryAssetFlag = inventoryAssetFlag;
    }

    public Boolean isBuildInWIPFlag() {
        return buildInWIPFlag;
    }

    public void setBuildInWIPFlag(Boolean buildInWIPFlag) {
        this.buildInWIPFlag = buildInWIPFlag;
    }

    public Long getWIPSupplyType() {
        return wIPSupplyType;
    }

    public void setWIPSupplyType(Long wIPSupplyType) {
        this.wIPSupplyType = wIPSupplyType;
    }

    public String getWIPSupplyTypeValue() {
        return wIPSupplyTypeValue;
    }

    public void setWIPSupplyTypeValue(String wIPSupplyTypeValue) {
        this.wIPSupplyTypeValue = wIPSupplyTypeValue;
    }

    public String getStructureInstanceNumber() {
        return structureInstanceNumber;
    }

    public void setStructureInstanceNumber(String structureInstanceNumber) {
        this.structureInstanceNumber = structureInstanceNumber;
    }

    public String getSubInventoryId() {
        return subInventoryId;
    }

    public void setSubInventoryId(String subInventoryId) {
        this.subInventoryId = subInventoryId;
    }

    public String getWipSupplyLocatorId() {
        return wipSupplyLocatorId;
    }

    public void setWipSupplyLocatorId(String wipSupplyLocatorId) {
        this.wipSupplyLocatorId = wipSupplyLocatorId;
    }

    public String getWIPSupplyLocatorValue() {
        return wIPSupplyLocatorValue;
    }

    public void setWIPSupplyLocatorValue(String wIPSupplyLocatorValue) {
        this.wIPSupplyLocatorValue = wIPSupplyLocatorValue;
    }

    public String getWIPSupplySubinventory() {
        return wIPSupplySubinventory;
    }

    public void setWIPSupplySubinventory(String wIPSupplySubinventory) {
        this.wIPSupplySubinventory = wIPSupplySubinventory;
    }

    public String getWIPSupplySubinventoryValue() {
        return wIPSupplySubinventoryValue;
    }

    public void setWIPSupplySubinventoryValue(String wIPSupplySubinventoryValue) {
        this.wIPSupplySubinventoryValue = wIPSupplySubinventoryValue;
    }

    public String getOvercompletionToleranceType() {
        return overcompletionToleranceType;
    }

    public void setOvercompletionToleranceType(String overcompletionToleranceType) {
        this.overcompletionToleranceType = overcompletionToleranceType;
    }

    public String getOvercompletionToleranceTypeValue() {
        return overcompletionToleranceTypeValue;
    }

    public void setOvercompletionToleranceTypeValue(String overcompletionToleranceTypeValue) {
        this.overcompletionToleranceTypeValue = overcompletionToleranceTypeValue;
    }

    public String getOvercompletionToleranceValue() {
        return overcompletionToleranceValue;
    }

    public void setOvercompletionToleranceValue(String overcompletionToleranceValue) {
        this.overcompletionToleranceValue = overcompletionToleranceValue;
    }

    public String getInventoryCarryPenalty() {
        return inventoryCarryPenalty;
    }

    public void setInventoryCarryPenalty(String inventoryCarryPenalty) {
        this.inventoryCarryPenalty = inventoryCarryPenalty;
    }

    public String getOperationSlackPenalty() {
        return operationSlackPenalty;
    }

    public void setOperationSlackPenalty(String operationSlackPenalty) {
        this.operationSlackPenalty = operationSlackPenalty;
    }

    public Boolean isRecipeEnabledFlag() {
        return recipeEnabledFlag;
    }

    public void setRecipeEnabledFlag(Boolean recipeEnabledFlag) {
        this.recipeEnabledFlag = recipeEnabledFlag;
    }

    public Boolean isProcessQualityEnabledFlag() {
        return processQualityEnabledFlag;
    }

    public void setProcessQualityEnabledFlag(Boolean processQualityEnabledFlag) {
        this.processQualityEnabledFlag = processQualityEnabledFlag;
    }

    public Boolean isProcessCostingEnabledFlag() {
        return processCostingEnabledFlag;
    }

    public void setProcessCostingEnabledFlag(Boolean processCostingEnabledFlag) {
        this.processCostingEnabledFlag = processCostingEnabledFlag;
    }

    public Boolean isProcessExecutionEnabledFlag() {
        return processExecutionEnabledFlag;
    }

    public void setProcessExecutionEnabledFlag(Boolean processExecutionEnabledFlag) {
        this.processExecutionEnabledFlag = processExecutionEnabledFlag;
    }

    public String getProcessSupplySubinventory() {
        return processSupplySubinventory;
    }

    public void setProcessSupplySubinventory(String processSupplySubinventory) {
        this.processSupplySubinventory = processSupplySubinventory;
    }

    public String getProcessSupplySubinventoryValue() {
        return processSupplySubinventoryValue;
    }

    public void setProcessSupplySubinventoryValue(String processSupplySubinventoryValue) {
        this.processSupplySubinventoryValue = processSupplySubinventoryValue;
    }

    public String getPSStructureInstanceNumber() {
        return pSStructureInstanceNumber;
    }

    public void setPSStructureInstanceNumber(String pSStructureInstanceNumber) {
        this.pSStructureInstanceNumber = pSStructureInstanceNumber;
    }

    public String getPSSubInventoryId() {
        return pSSubInventoryId;
    }

    public void setPSSubInventoryId(String pSSubInventoryId) {
        this.pSSubInventoryId = pSSubInventoryId;
    }

    public String getProcessSupplyLocatorId() {
        return processSupplyLocatorId;
    }

    public void setProcessSupplyLocatorId(String processSupplyLocatorId) {
        this.processSupplyLocatorId = processSupplyLocatorId;
    }

    public String getProcessSupplyLocatorValue() {
        return processSupplyLocatorValue;
    }

    public void setProcessSupplyLocatorValue(String processSupplyLocatorValue) {
        this.processSupplyLocatorValue = processSupplyLocatorValue;
    }

    public String getProcessYieldSubinventory() {
        return processYieldSubinventory;
    }

    public void setProcessYieldSubinventory(String processYieldSubinventory) {
        this.processYieldSubinventory = processYieldSubinventory;
    }

    public String getProcessYieldSubinventoryValue() {
        return processYieldSubinventoryValue;
    }

    public void setProcessYieldSubinventoryValue(String processYieldSubinventoryValue) {
        this.processYieldSubinventoryValue = processYieldSubinventoryValue;
    }

    public String getPYStructureInstanceNumber() {
        return pYStructureInstanceNumber;
    }

    public void setPYStructureInstanceNumber(String pYStructureInstanceNumber) {
        this.pYStructureInstanceNumber = pYStructureInstanceNumber;
    }

    public String getPYSubInventoryId() {
        return pYSubInventoryId;
    }

    public void setPYSubInventoryId(String pYSubInventoryId) {
        this.pYSubInventoryId = pYSubInventoryId;
    }

    public String getProcessYieldLocatorId() {
        return processYieldLocatorId;
    }

    public void setProcessYieldLocatorId(String processYieldLocatorId) {
        this.processYieldLocatorId = processYieldLocatorId;
    }

    public String getProcessYieldLocatorValue() {
        return processYieldLocatorValue;
    }

    public void setProcessYieldLocatorValue(String processYieldLocatorValue) {
        this.processYieldLocatorValue = processYieldLocatorValue;
    }

    public Boolean isHazardousMaterialFlag() {
        return hazardousMaterialFlag;
    }

    public void setHazardousMaterialFlag(Boolean hazardousMaterialFlag) {
        this.hazardousMaterialFlag = hazardousMaterialFlag;
    }

    public String getCASNumber() {
        return cASNumber;
    }

    public void setCASNumber(String cASNumber) {
        this.cASNumber = cASNumber;
    }

    public String getEAMItemType() {
        return eAMItemType;
    }

    public void setEAMItemType(String eAMItemType) {
        this.eAMItemType = eAMItemType;
    }

    public String getAssetItemTypeValue() {
        return assetItemTypeValue;
    }

    public void setAssetItemTypeValue(String assetItemTypeValue) {
        this.assetItemTypeValue = assetItemTypeValue;
    }

    public String getEAMActivityCauseCode() {
        return eAMActivityCauseCode;
    }

    public void setEAMActivityCauseCode(String eAMActivityCauseCode) {
        this.eAMActivityCauseCode = eAMActivityCauseCode;
    }

    public String getAssetActivityCauseValue() {
        return assetActivityCauseValue;
    }

    public void setAssetActivityCauseValue(String assetActivityCauseValue) {
        this.assetActivityCauseValue = assetActivityCauseValue;
    }

    public String getEAMActivityShutdownStatus() {
        return eAMActivityShutdownStatus;
    }

    public void setEAMActivityShutdownStatus(String eAMActivityShutdownStatus) {
        this.eAMActivityShutdownStatus = eAMActivityShutdownStatus;
    }

    public String getAssetActivityShutdownTypeValue() {
        return assetActivityShutdownTypeValue;
    }

    public void setAssetActivityShutdownTypeValue(String assetActivityShutdownTypeValue) {
        this.assetActivityShutdownTypeValue = assetActivityShutdownTypeValue;
    }

    public Boolean isAssetTrackedFlag() {
        return assetTrackedFlag;
    }

    public void setAssetTrackedFlag(Boolean assetTrackedFlag) {
        this.assetTrackedFlag = assetTrackedFlag;
    }

    public String getEAMActivityTypeCode() {
        return eAMActivityTypeCode;
    }

    public void setEAMActivityTypeCode(String eAMActivityTypeCode) {
        this.eAMActivityTypeCode = eAMActivityTypeCode;
    }

    public String getEAMActivityTypeValue() {
        return eAMActivityTypeValue;
    }

    public void setEAMActivityTypeValue(String eAMActivityTypeValue) {
        this.eAMActivityTypeValue = eAMActivityTypeValue;
    }

    public String getEAMActivitySourceCode() {
        return eAMActivitySourceCode;
    }

    public void setEAMActivitySourceCode(String eAMActivitySourceCode) {
        this.eAMActivitySourceCode = eAMActivitySourceCode;
    }

    public String getEAMActivitySourceValue() {
        return eAMActivitySourceValue;
    }

    public void setEAMActivitySourceValue(String eAMActivitySourceValue) {
        this.eAMActivitySourceValue = eAMActivitySourceValue;
    }

    public String getEAMActivityNotificationFlag() {
        return eAMActivityNotificationFlag;
    }

    public void setEAMActivityNotificationFlag(String eAMActivityNotificationFlag) {
        this.eAMActivityNotificationFlag = eAMActivityNotificationFlag;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getAssetClassValue() {
        return assetClassValue;
    }

    public void setAssetClassValue(String assetClassValue) {
        this.assetClassValue = assetClassValue;
    }

    public String getServiceRequestEnabledCode() {
        return serviceRequestEnabledCode;
    }

    public void setServiceRequestEnabledCode(String serviceRequestEnabledCode) {
        this.serviceRequestEnabledCode = serviceRequestEnabledCode;
    }

    public String getServiceRequestEnabledValue() {
        return serviceRequestEnabledValue;
    }

    public void setServiceRequestEnabledValue(String serviceRequestEnabledValue) {
        this.serviceRequestEnabledValue = serviceRequestEnabledValue;
    }

    public String getDefectTrackingOnFlag() {
        return defectTrackingOnFlag;
    }

    public void setDefectTrackingOnFlag(String defectTrackingOnFlag) {
        this.defectTrackingOnFlag = defectTrackingOnFlag;
    }

    public Boolean isServiceableProductFlag() {
        return serviceableProductFlag;
    }

    public void setServiceableProductFlag(Boolean serviceableProductFlag) {
        this.serviceableProductFlag = serviceableProductFlag;
    }

    public String getCommsActivationReqdFlag() {
        return commsActivationReqdFlag;
    }

    public void setCommsActivationReqdFlag(String commsActivationReqdFlag) {
        this.commsActivationReqdFlag = commsActivationReqdFlag;
    }

    public String getServiceDurationTypeCode() {
        return serviceDurationTypeCode;
    }

    public void setServiceDurationTypeCode(String serviceDurationTypeCode) {
        this.serviceDurationTypeCode = serviceDurationTypeCode;
    }

    public String getServiceDurationTypeValue() {
        return serviceDurationTypeValue;
    }

    public void setServiceDurationTypeValue(String serviceDurationTypeValue) {
        this.serviceDurationTypeValue = serviceDurationTypeValue;
    }

    public String getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(String serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getServiceDurationPeriodCode() {
        return serviceDurationPeriodCode;
    }

    public void setServiceDurationPeriodCode(String serviceDurationPeriodCode) {
        this.serviceDurationPeriodCode = serviceDurationPeriodCode;
    }

    public String getServiceDurationPeriodValue() {
        return serviceDurationPeriodValue;
    }

    public void setServiceDurationPeriodValue(String serviceDurationPeriodValue) {
        this.serviceDurationPeriodValue = serviceDurationPeriodValue;
    }

    public String getServiceStartTypeCode() {
        return serviceStartTypeCode;
    }

    public void setServiceStartTypeCode(String serviceStartTypeCode) {
        this.serviceStartTypeCode = serviceStartTypeCode;
    }

    public String getServiceStartTypeValue() {
        return serviceStartTypeValue;
    }

    public void setServiceStartTypeValue(String serviceStartTypeValue) {
        this.serviceStartTypeValue = serviceStartTypeValue;
    }

    public Long getServiceStartDelay() {
        return serviceStartDelay;
    }

    public void setServiceStartDelay(Long serviceStartDelay) {
        this.serviceStartDelay = serviceStartDelay;
    }

    public String getServiceStartingDelay() {
        return serviceStartingDelay;
    }

    public void setServiceStartingDelay(String serviceStartingDelay) {
        this.serviceStartingDelay = serviceStartingDelay;
    }

    public Boolean isAllowSuspendFlag() {
        return allowSuspendFlag;
    }

    public void setAllowSuspendFlag(Boolean allowSuspendFlag) {
        this.allowSuspendFlag = allowSuspendFlag;
    }

    public Boolean isAllowTerminateFlag() {
        return allowTerminateFlag;
    }

    public void setAllowTerminateFlag(Boolean allowTerminateFlag) {
        this.allowTerminateFlag = allowTerminateFlag;
    }

    public Boolean isRequiresFulfillmentLocFlag() {
        return requiresFulfillmentLocFlag;
    }

    public void setRequiresFulfillmentLocFlag(Boolean requiresFulfillmentLocFlag) {
        this.requiresFulfillmentLocFlag = requiresFulfillmentLocFlag;
    }

    public Boolean isRequiresItemAssociationFlag() {
        return requiresItemAssociationFlag;
    }

    public void setRequiresItemAssociationFlag(Boolean requiresItemAssociationFlag) {
        this.requiresItemAssociationFlag = requiresItemAssociationFlag;
    }

    public String getTrackInstalledBaseFlag() {
        return trackInstalledBaseFlag;
    }

    public void setTrackInstalledBaseFlag(String trackInstalledBaseFlag) {
        this.trackInstalledBaseFlag = trackInstalledBaseFlag;
    }

    public String getCreateFixedAssetFlag() {
        return createFixedAssetFlag;
    }

    public void setCreateFixedAssetFlag(String createFixedAssetFlag) {
        this.createFixedAssetFlag = createFixedAssetFlag;
    }

    public String getIbItemInstanceClass() {
        return ibItemInstanceClass;
    }

    public void setIbItemInstanceClass(String ibItemInstanceClass) {
        this.ibItemInstanceClass = ibItemInstanceClass;
    }

    public String getInstanceClassValue() {
        return instanceClassValue;
    }

    public void setInstanceClassValue(String instanceClassValue) {
        this.instanceClassValue = instanceClassValue;
    }

    public String getMaterialBillableCode() {
        return materialBillableCode;
    }

    public void setMaterialBillableCode(String materialBillableCode) {
        this.materialBillableCode = materialBillableCode;
    }

    public String getBillingTypeValue() {
        return billingTypeValue;
    }

    public void setBillingTypeValue(String billingTypeValue) {
        this.billingTypeValue = billingTypeValue;
    }

    public Boolean isServiceBillingEnabledFlag() {
        return serviceBillingEnabledFlag;
    }

    public void setServiceBillingEnabledFlag(Boolean serviceBillingEnabledFlag) {
        this.serviceBillingEnabledFlag = serviceBillingEnabledFlag;
    }

    public String getRecoveredPartDispCode() {
        return recoveredPartDispCode;
    }

    public void setRecoveredPartDispCode(String recoveredPartDispCode) {
        this.recoveredPartDispCode = recoveredPartDispCode;
    }

    public String getRecoveredPartDispositionValue() {
        return recoveredPartDispositionValue;
    }

    public void setRecoveredPartDispositionValue(String recoveredPartDispositionValue) {
        this.recoveredPartDispositionValue = recoveredPartDispositionValue;
    }

    public Boolean isInventoryItemFlag() {
        return inventoryItemFlag;
    }

    public void setInventoryItemFlag(Boolean inventoryItemFlag) {
        this.inventoryItemFlag = inventoryItemFlag;
    }

    public Boolean isStockEnabledFlag() {
        return stockEnabledFlag;
    }

    public void setStockEnabledFlag(Boolean stockEnabledFlag) {
        this.stockEnabledFlag = stockEnabledFlag;
    }

    public Boolean isMaterialTransactionEnabledFlag() {
        return materialTransactionEnabledFlag;
    }

    public void setMaterialTransactionEnabledFlag(Boolean materialTransactionEnabledFlag) {
        this.materialTransactionEnabledFlag = materialTransactionEnabledFlag;
    }

    public Long getReservableFlag() {
        return reservableFlag;
    }

    public void setReservableFlag(Long reservableFlag) {
        this.reservableFlag = reservableFlag;
    }

    public Boolean isCheckMaterialShortageFlag() {
        return checkMaterialShortageFlag;
    }

    public void setCheckMaterialShortageFlag(Boolean checkMaterialShortageFlag) {
        this.checkMaterialShortageFlag = checkMaterialShortageFlag;
    }

    public Long getRevisionQuantityControlFlag() {
        return revisionQuantityControlFlag;
    }

    public void setRevisionQuantityControlFlag(Long revisionQuantityControlFlag) {
        this.revisionQuantityControlFlag = revisionQuantityControlFlag;
    }

    public Boolean isBulkPickedFlag() {
        return bulkPickedFlag;
    }

    public void setBulkPickedFlag(Boolean bulkPickedFlag) {
        this.bulkPickedFlag = bulkPickedFlag;
    }

    public Long getLotControlCode() {
        return lotControlCode;
    }

    public void setLotControlCode(Long lotControlCode) {
        this.lotControlCode = lotControlCode;
    }

    public String getLotControlValue() {
        return lotControlValue;
    }

    public void setLotControlValue(String lotControlValue) {
        this.lotControlValue = lotControlValue;
    }

    public String getStartingLotPrefix() {
        return startingLotPrefix;
    }

    public void setStartingLotPrefix(String startingLotPrefix) {
        this.startingLotPrefix = startingLotPrefix;
    }

    public String getStartingLotNumber() {
        return startingLotNumber;
    }

    public void setStartingLotNumber(String startingLotNumber) {
        this.startingLotNumber = startingLotNumber;
    }

    public String getMaturityDays() {
        return maturityDays;
    }

    public void setMaturityDays(String maturityDays) {
        this.maturityDays = maturityDays;
    }

    public String getHoldDays() {
        return holdDays;
    }

    public void setHoldDays(String holdDays) {
        this.holdDays = holdDays;
    }

    public Long getShelfLifeCode() {
        return shelfLifeCode;
    }

    public void setShelfLifeCode(Long shelfLifeCode) {
        this.shelfLifeCode = shelfLifeCode;
    }

    public String getLotExpirationControlValue() {
        return lotExpirationControlValue;
    }

    public void setLotExpirationControlValue(String lotExpirationControlValue) {
        this.lotExpirationControlValue = lotExpirationControlValue;
    }

    public Long getShelfLifeDays() {
        return shelfLifeDays;
    }

    public void setShelfLifeDays(Long shelfLifeDays) {
        this.shelfLifeDays = shelfLifeDays;
    }

    public String getRetestInterval() {
        return retestInterval;
    }

    public void setRetestInterval(String retestInterval) {
        this.retestInterval = retestInterval;
    }

    public String getExpirationActionCode() {
        return expirationActionCode;
    }

    public void setExpirationActionCode(String expirationActionCode) {
        this.expirationActionCode = expirationActionCode;
    }

    public String getExpirationActionValue() {
        return expirationActionValue;
    }

    public void setExpirationActionValue(String expirationActionValue) {
        this.expirationActionValue = expirationActionValue;
    }

    public String getExpirationActionInterval() {
        return expirationActionInterval;
    }

    public void setExpirationActionInterval(String expirationActionInterval) {
        this.expirationActionInterval = expirationActionInterval;
    }

    public Boolean isChildLotEnabledFlag() {
        return childLotEnabledFlag;
    }

    public void setChildLotEnabledFlag(Boolean childLotEnabledFlag) {
        this.childLotEnabledFlag = childLotEnabledFlag;
    }

    public Boolean isChildLotFormatValidationFlag() {
        return childLotFormatValidationFlag;
    }

    public void setChildLotFormatValidationFlag(Boolean childLotFormatValidationFlag) {
        this.childLotFormatValidationFlag = childLotFormatValidationFlag;
    }

    public Boolean isCopyLotAttributeFlag() {
        return copyLotAttributeFlag;
    }

    public void setCopyLotAttributeFlag(Boolean copyLotAttributeFlag) {
        this.copyLotAttributeFlag = copyLotAttributeFlag;
    }

    public String getChildLotPrefix() {
        return childLotPrefix;
    }

    public void setChildLotPrefix(String childLotPrefix) {
        this.childLotPrefix = childLotPrefix;
    }

    public String getChildLotStartingNumber() {
        return childLotStartingNumber;
    }

    public void setChildLotStartingNumber(String childLotStartingNumber) {
        this.childLotStartingNumber = childLotStartingNumber;
    }

    public String getParentChildGenerationCode() {
        return parentChildGenerationCode;
    }

    public void setParentChildGenerationCode(String parentChildGenerationCode) {
        this.parentChildGenerationCode = parentChildGenerationCode;
    }

    public String getChildLotParent() {
        return childLotParent;
    }

    public void setChildLotParent(String childLotParent) {
        this.childLotParent = childLotParent;
    }

    public Boolean isLotTranslateEnabledFlag() {
        return lotTranslateEnabledFlag;
    }

    public void setLotTranslateEnabledFlag(Boolean lotTranslateEnabledFlag) {
        this.lotTranslateEnabledFlag = lotTranslateEnabledFlag;
    }

    public Boolean isLotSplitEnabledFlag() {
        return lotSplitEnabledFlag;
    }

    public void setLotSplitEnabledFlag(Boolean lotSplitEnabledFlag) {
        this.lotSplitEnabledFlag = lotSplitEnabledFlag;
    }

    public Boolean isLotDivisibleFlag() {
        return lotDivisibleFlag;
    }

    public void setLotDivisibleFlag(Boolean lotDivisibleFlag) {
        this.lotDivisibleFlag = lotDivisibleFlag;
    }

    public String getLotSubstitutionEnabledFlag() {
        return lotSubstitutionEnabledFlag;
    }

    public void setLotSubstitutionEnabledFlag(String lotSubstitutionEnabledFlag) {
        this.lotSubstitutionEnabledFlag = lotSubstitutionEnabledFlag;
    }

    public Boolean isLotMergeEnabledFlag() {
        return lotMergeEnabledFlag;
    }

    public void setLotMergeEnabledFlag(Boolean lotMergeEnabledFlag) {
        this.lotMergeEnabledFlag = lotMergeEnabledFlag;
    }

    public Boolean isGradeControlFlag() {
        return gradeControlFlag;
    }

    public void setGradeControlFlag(Boolean gradeControlFlag) {
        this.gradeControlFlag = gradeControlFlag;
    }

    public String getDefaultGrade() {
        return defaultGrade;
    }

    public void setDefaultGrade(String defaultGrade) {
        this.defaultGrade = defaultGrade;
    }

    public String getDefaultGradeValue() {
        return defaultGradeValue;
    }

    public void setDefaultGradeValue(String defaultGradeValue) {
        this.defaultGradeValue = defaultGradeValue;
    }

    public Long getSerialNumberControlCode() {
        return serialNumberControlCode;
    }

    public void setSerialNumberControlCode(Long serialNumberControlCode) {
        this.serialNumberControlCode = serialNumberControlCode;
    }

    public String getSerialGenerationValue() {
        return serialGenerationValue;
    }

    public void setSerialGenerationValue(String serialGenerationValue) {
        this.serialGenerationValue = serialGenerationValue;
    }

    public String getSerialStartingPrefix() {
        return serialStartingPrefix;
    }

    public void setSerialStartingPrefix(String serialStartingPrefix) {
        this.serialStartingPrefix = serialStartingPrefix;
    }

    public String getSerialStartingNumber() {
        return serialStartingNumber;
    }

    public void setSerialStartingNumber(String serialStartingNumber) {
        this.serialStartingNumber = serialStartingNumber;
    }

    public String getNegativeMeasurementError() {
        return negativeMeasurementError;
    }

    public void setNegativeMeasurementError(String negativeMeasurementError) {
        this.negativeMeasurementError = negativeMeasurementError;
    }

    public String getPositiveMeasurementError() {
        return positiveMeasurementError;
    }

    public void setPositiveMeasurementError(String positiveMeasurementError) {
        this.positiveMeasurementError = positiveMeasurementError;
    }

    public Boolean isCycleCountEnabledFlag() {
        return cycleCountEnabledFlag;
    }

    public void setCycleCountEnabledFlag(Boolean cycleCountEnabledFlag) {
        this.cycleCountEnabledFlag = cycleCountEnabledFlag;
    }

    public Boolean isLotStatusEnabledFlag() {
        return lotStatusEnabledFlag;
    }

    public void setLotStatusEnabledFlag(Boolean lotStatusEnabledFlag) {
        this.lotStatusEnabledFlag = lotStatusEnabledFlag;
    }

    public Boolean isSerialStatusEnabledFlag() {
        return serialStatusEnabledFlag;
    }

    public void setSerialStatusEnabledFlag(Boolean serialStatusEnabledFlag) {
        this.serialStatusEnabledFlag = serialStatusEnabledFlag;
    }

    public String getDefaultLotStatusId() {
        return defaultLotStatusId;
    }

    public void setDefaultLotStatusId(String defaultLotStatusId) {
        this.defaultLotStatusId = defaultLotStatusId;
    }

    public String getDefaultLotStatusValue() {
        return defaultLotStatusValue;
    }

    public void setDefaultLotStatusValue(String defaultLotStatusValue) {
        this.defaultLotStatusValue = defaultLotStatusValue;
    }

    public String getDefaultSerialStatusId() {
        return defaultSerialStatusId;
    }

    public void setDefaultSerialStatusId(String defaultSerialStatusId) {
        this.defaultSerialStatusId = defaultSerialStatusId;
    }

    public String getDefaultSerialStatusValue() {
        return defaultSerialStatusValue;
    }

    public void setDefaultSerialStatusValue(String defaultSerialStatusValue) {
        this.defaultSerialStatusValue = defaultSerialStatusValue;
    }

    public Long getRestrictSubinventoriesFlag() {
        return restrictSubinventoriesFlag;
    }

    public void setRestrictSubinventoriesFlag(Long restrictSubinventoriesFlag) {
        this.restrictSubinventoriesFlag = restrictSubinventoriesFlag;
    }

    public Long getRestrictLocatorsFlag() {
        return restrictLocatorsFlag;
    }

    public void setRestrictLocatorsFlag(Long restrictLocatorsFlag) {
        this.restrictLocatorsFlag = restrictLocatorsFlag;
    }

    public Long getLocationControlCode() {
        return locationControlCode;
    }

    public void setLocationControlCode(Long locationControlCode) {
        this.locationControlCode = locationControlCode;
    }

    public String getStockLocatorControlValue() {
        return stockLocatorControlValue;
    }

    public void setStockLocatorControlValue(String stockLocatorControlValue) {
        this.stockLocatorControlValue = stockLocatorControlValue;
    }

    public String getDimensionUOMCode() {
        return dimensionUOMCode;
    }

    public void setDimensionUOMCode(String dimensionUOMCode) {
        this.dimensionUOMCode = dimensionUOMCode;
    }

    public String getDimensionUOMValue() {
        return dimensionUOMValue;
    }

    public void setDimensionUOMValue(String dimensionUOMValue) {
        this.dimensionUOMValue = dimensionUOMValue;
    }

    public String getUnitWidthQuantity() {
        return unitWidthQuantity;
    }

    public void setUnitWidthQuantity(String unitWidthQuantity) {
        this.unitWidthQuantity = unitWidthQuantity;
    }

    public String getUnitLengthQuantity() {
        return unitLengthQuantity;
    }

    public void setUnitLengthQuantity(String unitLengthQuantity) {
        this.unitLengthQuantity = unitLengthQuantity;
    }

    public String getUnitHeightQuantity() {
        return unitHeightQuantity;
    }

    public void setUnitHeightQuantity(String unitHeightQuantity) {
        this.unitHeightQuantity = unitHeightQuantity;
    }

    public String getWeightUOMCode() {
        return weightUOMCode;
    }

    public void setWeightUOMCode(String weightUOMCode) {
        this.weightUOMCode = weightUOMCode;
    }

    public String getWeightUOMValue() {
        return weightUOMValue;
    }

    public void setWeightUOMValue(String weightUOMValue) {
        this.weightUOMValue = weightUOMValue;
    }

    public String getUnitWeightQuantity() {
        return unitWeightQuantity;
    }

    public void setUnitWeightQuantity(String unitWeightQuantity) {
        this.unitWeightQuantity = unitWeightQuantity;
    }

    public String getVolumeUOMCode() {
        return volumeUOMCode;
    }

    public void setVolumeUOMCode(String volumeUOMCode) {
        this.volumeUOMCode = volumeUOMCode;
    }

    public String getVolumeUOMValue() {
        return volumeUOMValue;
    }

    public void setVolumeUOMValue(String volumeUOMValue) {
        this.volumeUOMValue = volumeUOMValue;
    }

    public String getUnitVolumeQuantity() {
        return unitVolumeQuantity;
    }

    public void setUnitVolumeQuantity(String unitVolumeQuantity) {
        this.unitVolumeQuantity = unitVolumeQuantity;
    }

    public String getContainerItemFlag() {
        return containerItemFlag;
    }

    public void setContainerItemFlag(String containerItemFlag) {
        this.containerItemFlag = containerItemFlag;
    }

    public String getContainerTypeCode() {
        return containerTypeCode;
    }

    public void setContainerTypeCode(String containerTypeCode) {
        this.containerTypeCode = containerTypeCode;
    }

    public String getContainerTypeValue() {
        return containerTypeValue;
    }

    public void setContainerTypeValue(String containerTypeValue) {
        this.containerTypeValue = containerTypeValue;
    }

    public String getMaximumLoadWeight() {
        return maximumLoadWeight;
    }

    public void setMaximumLoadWeight(String maximumLoadWeight) {
        this.maximumLoadWeight = maximumLoadWeight;
    }

    public String getVehicleItemFlag() {
        return vehicleItemFlag;
    }

    public void setVehicleItemFlag(String vehicleItemFlag) {
        this.vehicleItemFlag = vehicleItemFlag;
    }

    public String getInternalVolume() {
        return internalVolume;
    }

    public void setInternalVolume(String internalVolume) {
        this.internalVolume = internalVolume;
    }

    public String getMinimumFillPercent() {
        return minimumFillPercent;
    }

    public void setMinimumFillPercent(String minimumFillPercent) {
        this.minimumFillPercent = minimumFillPercent;
    }

    public Long getWarehouseEquipmentFlag() {
        return warehouseEquipmentFlag;
    }

    public void setWarehouseEquipmentFlag(Long warehouseEquipmentFlag) {
        this.warehouseEquipmentFlag = warehouseEquipmentFlag;
    }

    public String getEventFlag() {
        return eventFlag;
    }

    public void setEventFlag(String eventFlag) {
        this.eventFlag = eventFlag;
    }

    public String getCollateralFlag() {
        return collateralFlag;
    }

    public void setCollateralFlag(String collateralFlag) {
        this.collateralFlag = collateralFlag;
    }

    public Boolean isCustomerOrderFlag() {
        return customerOrderFlag;
    }

    public void setCustomerOrderFlag(Boolean customerOrderFlag) {
        this.customerOrderFlag = customerOrderFlag;
    }

    public Boolean isCustomerOrderEnabledFlag() {
        return customerOrderEnabledFlag;
    }

    public void setCustomerOrderEnabledFlag(Boolean customerOrderEnabledFlag) {
        this.customerOrderEnabledFlag = customerOrderEnabledFlag;
    }

    public String getATPComponentsCode() {
        return aTPComponentsCode;
    }

    public void setATPComponentsCode(String aTPComponentsCode) {
        this.aTPComponentsCode = aTPComponentsCode;
    }

    public String getATPComponentsValue() {
        return aTPComponentsValue;
    }

    public void setATPComponentsValue(String aTPComponentsValue) {
        this.aTPComponentsValue = aTPComponentsValue;
    }

    public String getPickingRuleId() {
        return pickingRuleId;
    }

    public void setPickingRuleId(String pickingRuleId) {
        this.pickingRuleId = pickingRuleId;
    }

    public String getPickingRuleValue() {
        return pickingRuleValue;
    }

    public void setPickingRuleValue(String pickingRuleValue) {
        this.pickingRuleValue = pickingRuleValue;
    }

    public Long getRMAInspectionRequiredFlag() {
        return rMAInspectionRequiredFlag;
    }

    public void setRMAInspectionRequiredFlag(Long rMAInspectionRequiredFlag) {
        this.rMAInspectionRequiredFlag = rMAInspectionRequiredFlag;
    }

    public String getEligibilityRuleFlag() {
        return eligibilityRuleFlag;
    }

    public void setEligibilityRuleFlag(String eligibilityRuleFlag) {
        this.eligibilityRuleFlag = eligibilityRuleFlag;
    }

    public Boolean isInternalOrderFlag() {
        return internalOrderFlag;
    }

    public void setInternalOrderFlag(Boolean internalOrderFlag) {
        this.internalOrderFlag = internalOrderFlag;
    }

    public Boolean isInternalOrderEnabledFlag() {
        return internalOrderEnabledFlag;
    }

    public void setInternalOrderEnabledFlag(Boolean internalOrderEnabledFlag) {
        this.internalOrderEnabledFlag = internalOrderEnabledFlag;
    }

    public Boolean isReturnableFlag() {
        return returnableFlag;
    }

    public void setReturnableFlag(Boolean returnableFlag) {
        this.returnableFlag = returnableFlag;
    }

    public String getATPCode() {
        return aTPCode;
    }

    public void setATPCode(String aTPCode) {
        this.aTPCode = aTPCode;
    }

    public String getATPValue() {
        return aTPValue;
    }

    public void setATPValue(String aTPValue) {
        this.aTPValue = aTPValue;
    }

    public String getFinancingAllowedFlag() {
        return financingAllowedFlag;
    }

    public void setFinancingAllowedFlag(String financingAllowedFlag) {
        this.financingAllowedFlag = financingAllowedFlag;
    }

    public String getSalesProductType() {
        return salesProductType;
    }

    public void setSalesProductType(String salesProductType) {
        this.salesProductType = salesProductType;
    }

    public String getSalesProductTypeValue() {
        return salesProductTypeValue;
    }

    public void setSalesProductTypeValue(String salesProductTypeValue) {
        this.salesProductTypeValue = salesProductTypeValue;
    }

    public Boolean isTransactionEnabledFlag() {
        return transactionEnabledFlag;
    }

    public void setTransactionEnabledFlag(Boolean transactionEnabledFlag) {
        this.transactionEnabledFlag = transactionEnabledFlag;
    }

    public String getOrderManagementIndivisibleFlag() {
        return orderManagementIndivisibleFlag;
    }

    public void setOrderManagementIndivisibleFlag(String orderManagementIndivisibleFlag) {
        this.orderManagementIndivisibleFlag = orderManagementIndivisibleFlag;
    }

    public String getDefaultSoSourceType() {
        return defaultSoSourceType;
    }

    public void setDefaultSoSourceType(String defaultSoSourceType) {
        this.defaultSoSourceType = defaultSoSourceType;
    }

    public String getDefaultSalesOrderSourceTypeValue() {
        return defaultSalesOrderSourceTypeValue;
    }

    public void setDefaultSalesOrderSourceTypeValue(String defaultSalesOrderSourceTypeValue) {
        this.defaultSalesOrderSourceTypeValue = defaultSalesOrderSourceTypeValue;
    }

    public String getElectronicFormatFlag() {
        return electronicFormatFlag;
    }

    public void setElectronicFormatFlag(String electronicFormatFlag) {
        this.electronicFormatFlag = electronicFormatFlag;
    }

    public Boolean isShippableFlag() {
        return shippableFlag;
    }

    public void setShippableFlag(Boolean shippableFlag) {
        this.shippableFlag = shippableFlag;
    }

    public String getDefaultShippingOrganization() {
        return defaultShippingOrganization;
    }

    public void setDefaultShippingOrganization(String defaultShippingOrganization) {
        this.defaultShippingOrganization = defaultShippingOrganization;
    }

    public String getDefaultShippingOrganizationValue() {
        return defaultShippingOrganizationValue;
    }

    public void setDefaultShippingOrganizationValue(String defaultShippingOrganizationValue) {
        this.defaultShippingOrganizationValue = defaultShippingOrganizationValue;
    }

    public Boolean isShipModelCompleteFlag() {
        return shipModelCompleteFlag;
    }

    public void setShipModelCompleteFlag(Boolean shipModelCompleteFlag) {
        this.shipModelCompleteFlag = shipModelCompleteFlag;
    }

    public String getDownloadableFlag() {
        return downloadableFlag;
    }

    public void setDownloadableFlag(String downloadableFlag) {
        this.downloadableFlag = downloadableFlag;
    }

    public String getOverShipmentTolerance() {
        return overShipmentTolerance;
    }

    public void setOverShipmentTolerance(String overShipmentTolerance) {
        this.overShipmentTolerance = overShipmentTolerance;
    }

    public String getUnderShipmentTolerance() {
        return underShipmentTolerance;
    }

    public void setUnderShipmentTolerance(String underShipmentTolerance) {
        this.underShipmentTolerance = underShipmentTolerance;
    }

    public String getOverReturnTolerance() {
        return overReturnTolerance;
    }

    public void setOverReturnTolerance(String overReturnTolerance) {
        this.overReturnTolerance = overReturnTolerance;
    }

    public String getUnderReturnTolerance() {
        return underReturnTolerance;
    }

    public void setUnderReturnTolerance(String underReturnTolerance) {
        this.underReturnTolerance = underReturnTolerance;
    }

    public Boolean isInvoicedFlag() {
        return invoicedFlag;
    }

    public void setInvoicedFlag(Boolean invoicedFlag) {
        this.invoicedFlag = invoicedFlag;
    }

    public String getAccountingRuleId() {
        return accountingRuleId;
    }

    public void setAccountingRuleId(String accountingRuleId) {
        this.accountingRuleId = accountingRuleId;
    }

    public String getAccountingRuleValue() {
        return accountingRuleValue;
    }

    public void setAccountingRuleValue(String accountingRuleValue) {
        this.accountingRuleValue = accountingRuleValue;
    }

    public String getPaymentTermsId() {
        return paymentTermsId;
    }

    public void setPaymentTermsId(String paymentTermsId) {
        this.paymentTermsId = paymentTermsId;
    }

    public String getPaymentTermsValue() {
        return paymentTermsValue;
    }

    public void setPaymentTermsValue(String paymentTermsValue) {
        this.paymentTermsValue = paymentTermsValue;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getOutputTaxClassificationCodeValue() {
        return outputTaxClassificationCodeValue;
    }

    public void setOutputTaxClassificationCodeValue(String outputTaxClassificationCodeValue) {
        this.outputTaxClassificationCodeValue = outputTaxClassificationCodeValue;
    }

    public Boolean isInvoiceEnabledFlag() {
        return invoiceEnabledFlag;
    }

    public void setInvoiceEnabledFlag(Boolean invoiceEnabledFlag) {
        this.invoiceEnabledFlag = invoiceEnabledFlag;
    }

    public String getInvoicingRuleId() {
        return invoicingRuleId;
    }

    public void setInvoicingRuleId(String invoicingRuleId) {
        this.invoicingRuleId = invoicingRuleId;
    }

    public String getInvoicingRuleValue() {
        return invoicingRuleValue;
    }

    public void setInvoicingRuleValue(String invoicingRuleValue) {
        this.invoicingRuleValue = invoicingRuleValue;
    }

    public Long getSalesSIN() {
        return salesSIN;
    }

    public void setSalesSIN(Long salesSIN) {
        this.salesSIN = salesSIN;
    }

    public String getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(String salesAccount) {
        this.salesAccount = salesAccount;
    }

    public String getSalesAccountValue() {
        return salesAccountValue;
    }

    public void setSalesAccountValue(String salesAccountValue) {
        this.salesAccountValue = salesAccountValue;
    }

    public String getWebStatus() {
        return webStatus;
    }

    public void setWebStatus(String webStatus) {
        this.webStatus = webStatus;
    }

    public String getWebStatusValue() {
        return webStatusValue;
    }

    public void setWebStatusValue(String webStatusValue) {
        this.webStatusValue = webStatusValue;
    }

    public String getBackOrderableFlag() {
        return backOrderableFlag;
    }

    public void setBackOrderableFlag(String backOrderableFlag) {
        this.backOrderableFlag = backOrderableFlag;
    }

    public Boolean isOrderableOnWebFlag() {
        return orderableOnWebFlag;
    }

    public void setOrderableOnWebFlag(Boolean orderableOnWebFlag) {
        this.orderableOnWebFlag = orderableOnWebFlag;
    }

    public String getMinimumLicenseQuantity() {
        return minimumLicenseQuantity;
    }

    public void setMinimumLicenseQuantity(String minimumLicenseQuantity) {
        this.minimumLicenseQuantity = minimumLicenseQuantity;
    }

    public Long getInventoryPlanningCode() {
        return inventoryPlanningCode;
    }

    public void setInventoryPlanningCode(Long inventoryPlanningCode) {
        this.inventoryPlanningCode = inventoryPlanningCode;
    }

    public String getInventoryPlanningMethodValue() {
        return inventoryPlanningMethodValue;
    }

    public void setInventoryPlanningMethodValue(String inventoryPlanningMethodValue) {
        this.inventoryPlanningMethodValue = inventoryPlanningMethodValue;
    }

    public Long getPlanningMakeBuyCode() {
        return planningMakeBuyCode;
    }

    public void setPlanningMakeBuyCode(Long planningMakeBuyCode) {
        this.planningMakeBuyCode = planningMakeBuyCode;
    }

    public String getPlanningMakeBuyValue() {
        return planningMakeBuyValue;
    }

    public void setPlanningMakeBuyValue(String planningMakeBuyValue) {
        this.planningMakeBuyValue = planningMakeBuyValue;
    }

    public String getPlannerCode() {
        return plannerCode;
    }

    public void setPlannerCode(String plannerCode) {
        this.plannerCode = plannerCode;
    }

    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner;
    }

    public String getSubcontractingComponent() {
        return subcontractingComponent;
    }

    public void setSubcontractingComponent(String subcontractingComponent) {
        this.subcontractingComponent = subcontractingComponent;
    }

    public String getSubcontractingComponentValue() {
        return subcontractingComponentValue;
    }

    public void setSubcontractingComponentValue(String subcontractingComponentValue) {
        this.subcontractingComponentValue = subcontractingComponentValue;
    }

    public String getMinimumMinmaxQuantity() {
        return minimumMinmaxQuantity;
    }

    public void setMinimumMinmaxQuantity(String minimumMinmaxQuantity) {
        this.minimumMinmaxQuantity = minimumMinmaxQuantity;
    }

    public String getMaximumMinmaxQuantity() {
        return maximumMinmaxQuantity;
    }

    public void setMaximumMinmaxQuantity(String maximumMinmaxQuantity) {
        this.maximumMinmaxQuantity = maximumMinmaxQuantity;
    }

    public String getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(String minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public String getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    public void setMaximumOrderQuantity(String maximumOrderQuantity) {
        this.maximumOrderQuantity = maximumOrderQuantity;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getCarryPercentage() {
        return carryPercentage;
    }

    public void setCarryPercentage(String carryPercentage) {
        this.carryPercentage = carryPercentage;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getReplenishmentType() {
        return replenishmentType;
    }

    public void setReplenishmentType(String replenishmentType) {
        this.replenishmentType = replenishmentType;
    }

    public String getSourceOrganizationId() {
        return sourceOrganizationId;
    }

    public void setSourceOrganizationId(String sourceOrganizationId) {
        this.sourceOrganizationId = sourceOrganizationId;
    }

    public String getSourceOrganizationValue() {
        return sourceOrganizationValue;
    }

    public void setSourceOrganizationValue(String sourceOrganizationValue) {
        this.sourceOrganizationValue = sourceOrganizationValue;
    }

    public String getSourceSubinventoryOrganizationId() {
        return sourceSubinventoryOrganizationId;
    }

    public void setSourceSubinventoryOrganizationId(String sourceSubinventoryOrganizationId) {
        this.sourceSubinventoryOrganizationId = sourceSubinventoryOrganizationId;
    }

    public String getSourceSubinventoryOrganizationValue() {
        return sourceSubinventoryOrganizationValue;
    }

    public void setSourceSubinventoryOrganizationValue(String sourceSubinventoryOrganizationValue) {
        this.sourceSubinventoryOrganizationValue = sourceSubinventoryOrganizationValue;
    }

    public String getSourceSubinventory() {
        return sourceSubinventory;
    }

    public void setSourceSubinventory(String sourceSubinventory) {
        this.sourceSubinventory = sourceSubinventory;
    }

    public String getSourceSubinventoryValue() {
        return sourceSubinventoryValue;
    }

    public void setSourceSubinventoryValue(String sourceSubinventoryValue) {
        this.sourceSubinventoryValue = sourceSubinventoryValue;
    }

    public String getFixedOrderQuantity() {
        return fixedOrderQuantity;
    }

    public void setFixedOrderQuantity(String fixedOrderQuantity) {
        this.fixedOrderQuantity = fixedOrderQuantity;
    }

    public String getFixedDaysSupply() {
        return fixedDaysSupply;
    }

    public void setFixedDaysSupply(String fixedDaysSupply) {
        this.fixedDaysSupply = fixedDaysSupply;
    }

    public String getFixedLotSizeMultiplier() {
        return fixedLotSizeMultiplier;
    }

    public void setFixedLotSizeMultiplier(String fixedLotSizeMultiplier) {
        this.fixedLotSizeMultiplier = fixedLotSizeMultiplier;
    }

    public Long getSOAuthorizationCode() {
        return sOAuthorizationCode;
    }

    public void setSOAuthorizationCode(Long sOAuthorizationCode) {
        this.sOAuthorizationCode = sOAuthorizationCode;
    }

    public String getReleaseAuthorizationRequiredValue() {
        return releaseAuthorizationRequiredValue;
    }

    public void setReleaseAuthorizationRequiredValue(String releaseAuthorizationRequiredValue) {
        this.releaseAuthorizationRequiredValue = releaseAuthorizationRequiredValue;
    }

    public Long getAutomaticallyExpireASNFlag() {
        return automaticallyExpireASNFlag;
    }

    public void setAutomaticallyExpireASNFlag(Long automaticallyExpireASNFlag) {
        this.automaticallyExpireASNFlag = automaticallyExpireASNFlag;
    }

    public Long getConsignedFlag() {
        return consignedFlag;
    }

    public void setConsignedFlag(Long consignedFlag) {
        this.consignedFlag = consignedFlag;
    }

    public String getReplenishmentMinimumOrder() {
        return replenishmentMinimumOrder;
    }

    public void setReplenishmentMinimumOrder(String replenishmentMinimumOrder) {
        this.replenishmentMinimumOrder = replenishmentMinimumOrder;
    }

    public String getReplenishmentMinimumDays() {
        return replenishmentMinimumDays;
    }

    public void setReplenishmentMinimumDays(String replenishmentMinimumDays) {
        this.replenishmentMinimumDays = replenishmentMinimumDays;
    }

    public String getMaximumOrder() {
        return maximumOrder;
    }

    public void setMaximumOrder(String maximumOrder) {
        this.maximumOrder = maximumOrder;
    }

    public String getMaximumDaysOfSupply() {
        return maximumDaysOfSupply;
    }

    public void setMaximumDaysOfSupply(String maximumDaysOfSupply) {
        this.maximumDaysOfSupply = maximumDaysOfSupply;
    }

    public String getVMIFixedOrderQuantity() {
        return vMIFixedOrderQuantity;
    }

    public void setVMIFixedOrderQuantity(String vMIFixedOrderQuantity) {
        this.vMIFixedOrderQuantity = vMIFixedOrderQuantity;
    }

    public Long getVMIForecastType() {
        return vMIForecastType;
    }

    public void setVMIForecastType(Long vMIForecastType) {
        this.vMIForecastType = vMIForecastType;
    }

    public String getForecastTypelValue() {
        return forecastTypelValue;
    }

    public void setForecastTypelValue(String forecastTypelValue) {
        this.forecastTypelValue = forecastTypelValue;
    }

    public String getForecastHorizon() {
        return forecastHorizon;
    }

    public void setForecastHorizon(String forecastHorizon) {
        this.forecastHorizon = forecastHorizon;
    }

    public Long getMRPPlanningCode() {
        return mRPPlanningCode;
    }

    public void setMRPPlanningCode(Long mRPPlanningCode) {
        this.mRPPlanningCode = mRPPlanningCode;
    }

    public String getPlanningMethodValue() {
        return planningMethodValue;
    }

    public void setPlanningMethodValue(String planningMethodValue) {
        this.planningMethodValue = planningMethodValue;
    }

    public String getEndAssemblyPeggingCode() {
        return endAssemblyPeggingCode;
    }

    public void setEndAssemblyPeggingCode(String endAssemblyPeggingCode) {
        this.endAssemblyPeggingCode = endAssemblyPeggingCode;
    }

    public String getPegging() {
        return pegging;
    }

    public void setPegging(String pegging) {
        this.pegging = pegging;
    }

    public Long getRoundingControlTypeFlag() {
        return roundingControlTypeFlag;
    }

    public void setRoundingControlTypeFlag(Long roundingControlTypeFlag) {
        this.roundingControlTypeFlag = roundingControlTypeFlag;
    }

    public Boolean isCreateSupplyFlag() {
        return createSupplyFlag;
    }

    public void setCreateSupplyFlag(Boolean createSupplyFlag) {
        this.createSupplyFlag = createSupplyFlag;
    }

    public Long getCriticalComponentFlag() {
        return criticalComponentFlag;
    }

    public void setCriticalComponentFlag(Long criticalComponentFlag) {
        this.criticalComponentFlag = criticalComponentFlag;
    }

    public Long getPlanningTimeFenceCode() {
        return planningTimeFenceCode;
    }

    public void setPlanningTimeFenceCode(Long planningTimeFenceCode) {
        this.planningTimeFenceCode = planningTimeFenceCode;
    }

    public String getPlanningTimeFence() {
        return planningTimeFence;
    }

    public void setPlanningTimeFence(String planningTimeFence) {
        this.planningTimeFence = planningTimeFence;
    }

    public String getDemandTimeFenceCode() {
        return demandTimeFenceCode;
    }

    public void setDemandTimeFenceCode(String demandTimeFenceCode) {
        this.demandTimeFenceCode = demandTimeFenceCode;
    }

    public String getDemandTimeFence() {
        return demandTimeFence;
    }

    public void setDemandTimeFence(String demandTimeFence) {
        this.demandTimeFence = demandTimeFence;
    }

    public String getReleaseTimeFenceCode() {
        return releaseTimeFenceCode;
    }

    public void setReleaseTimeFenceCode(String releaseTimeFenceCode) {
        this.releaseTimeFenceCode = releaseTimeFenceCode;
    }

    public String getReleaseTimeFence() {
        return releaseTimeFence;
    }

    public void setReleaseTimeFence(String releaseTimeFence) {
        this.releaseTimeFence = releaseTimeFence;
    }

    public String getSubstitutionWindowCode() {
        return substitutionWindowCode;
    }

    public void setSubstitutionWindowCode(String substitutionWindowCode) {
        this.substitutionWindowCode = substitutionWindowCode;
    }

    public String getSubstitutionWindow() {
        return substitutionWindow;
    }

    public void setSubstitutionWindow(String substitutionWindow) {
        this.substitutionWindow = substitutionWindow;
    }

    public String getShrinkageRate() {
        return shrinkageRate;
    }

    public void setShrinkageRate(String shrinkageRate) {
        this.shrinkageRate = shrinkageRate;
    }

    public Long getATOForecastControl() {
        return aTOForecastControl;
    }

    public void setATOForecastControl(Long aTOForecastControl) {
        this.aTOForecastControl = aTOForecastControl;
    }

    public String getForecastControlValue() {
        return forecastControlValue;
    }

    public void setForecastControlValue(String forecastControlValue) {
        this.forecastControlValue = forecastControlValue;
    }

    public String getAcceptableEarlyDays() {
        return acceptableEarlyDays;
    }

    public void setAcceptableEarlyDays(String acceptableEarlyDays) {
        this.acceptableEarlyDays = acceptableEarlyDays;
    }

    public String getPlannedInventoryPointFlag() {
        return plannedInventoryPointFlag;
    }

    public void setPlannedInventoryPointFlag(String plannedInventoryPointFlag) {
        this.plannedInventoryPointFlag = plannedInventoryPointFlag;
    }

    public Long getExcludeFromBudgetFlag() {
        return excludeFromBudgetFlag;
    }

    public void setExcludeFromBudgetFlag(Long excludeFromBudgetFlag) {
        this.excludeFromBudgetFlag = excludeFromBudgetFlag;
    }

    public Long getPlanningTimeDays() {
        return planningTimeDays;
    }

    public void setPlanningTimeDays(Long planningTimeDays) {
        this.planningTimeDays = planningTimeDays;
    }

    public String getDemandTimeDays() {
        return demandTimeDays;
    }

    public void setDemandTimeDays(String demandTimeDays) {
        this.demandTimeDays = demandTimeDays;
    }

    public String getReleaseTimeDays() {
        return releaseTimeDays;
    }

    public void setReleaseTimeDays(String releaseTimeDays) {
        this.releaseTimeDays = releaseTimeDays;
    }

    public String getSubstitutionDays() {
        return substitutionDays;
    }

    public void setSubstitutionDays(String substitutionDays) {
        this.substitutionDays = substitutionDays;
    }

    public String getMRPCalculateATPFlag() {
        return mRPCalculateATPFlag;
    }

    public void setMRPCalculateATPFlag(String mRPCalculateATPFlag) {
        this.mRPCalculateATPFlag = mRPCalculateATPFlag;
    }

    public Long getDRPPlannedFlag() {
        return dRPPlannedFlag;
    }

    public void setDRPPlannedFlag(Long dRPPlannedFlag) {
        this.dRPPlannedFlag = dRPPlannedFlag;
    }

    public String getMaximumInventoryWindow() {
        return maximumInventoryWindow;
    }

    public void setMaximumInventoryWindow(String maximumInventoryWindow) {
        this.maximumInventoryWindow = maximumInventoryWindow;
    }

    public String getDaysMaximumInventorySupply() {
        return daysMaximumInventorySupply;
    }

    public void setDaysMaximumInventorySupply(String daysMaximumInventorySupply) {
        this.daysMaximumInventorySupply = daysMaximumInventorySupply;
    }

    public String getTargetInventoryDaysofSupply() {
        return targetInventoryDaysofSupply;
    }

    public void setTargetInventoryDaysofSupply(String targetInventoryDaysofSupply) {
        this.targetInventoryDaysofSupply = targetInventoryDaysofSupply;
    }

    public String getTagetInventoryWindow() {
        return tagetInventoryWindow;
    }

    public void setTagetInventoryWindow(String tagetInventoryWindow) {
        this.tagetInventoryWindow = tagetInventoryWindow;
    }

    public String getRepairLeadtime() {
        return repairLeadtime;
    }

    public void setRepairLeadtime(String repairLeadtime) {
        this.repairLeadtime = repairLeadtime;
    }

    public String getRepairYield() {
        return repairYield;
    }

    public void setRepairYield(String repairYield) {
        this.repairYield = repairYield;
    }

    public Boolean isPrepositionPointFlag() {
        return prepositionPointFlag;
    }

    public void setPrepositionPointFlag(Boolean prepositionPointFlag) {
        this.prepositionPointFlag = prepositionPointFlag;
    }

    public Long getRepairProgram() {
        return repairProgram;
    }

    public void setRepairProgram(Long repairProgram) {
        this.repairProgram = repairProgram;
    }

    public String getRepairProgramValue() {
        return repairProgramValue;
    }

    public void setRepairProgramValue(String repairProgramValue) {
        this.repairProgramValue = repairProgramValue;
    }

    public String getPreprocessingDays() {
        return preprocessingDays;
    }

    public void setPreprocessingDays(String preprocessingDays) {
        this.preprocessingDays = preprocessingDays;
    }

    public Long getPostprocessingDays() {
        return postprocessingDays;
    }

    public void setPostprocessingDays(Long postprocessingDays) {
        this.postprocessingDays = postprocessingDays;
    }

    public String getProcessingDays() {
        return processingDays;
    }

    public void setProcessingDays(String processingDays) {
        this.processingDays = processingDays;
    }

    public String getVariableLeadTime() {
        return variableLeadTime;
    }

    public void setVariableLeadTime(String variableLeadTime) {
        this.variableLeadTime = variableLeadTime;
    }

    public String getCumulativeTotalLeadTime() {
        return cumulativeTotalLeadTime;
    }

    public void setCumulativeTotalLeadTime(String cumulativeTotalLeadTime) {
        this.cumulativeTotalLeadTime = cumulativeTotalLeadTime;
    }

    public String getFixedLeadTime() {
        return fixedLeadTime;
    }

    public void setFixedLeadTime(String fixedLeadTime) {
        this.fixedLeadTime = fixedLeadTime;
    }

    public String getCumulativeManufacturingLeadTime() {
        return cumulativeManufacturingLeadTime;
    }

    public void setCumulativeManufacturingLeadTime(String cumulativeManufacturingLeadTime) {
        this.cumulativeManufacturingLeadTime = cumulativeManufacturingLeadTime;
    }

    public Long getLeadTimeLotSize() {
        return leadTimeLotSize;
    }

    public void setLeadTimeLotSize(Long leadTimeLotSize) {
        this.leadTimeLotSize = leadTimeLotSize;
    }

    public Boolean isPurchasingFlag() {
        return purchasingFlag;
    }

    public void setPurchasingFlag(Boolean purchasingFlag) {
        this.purchasingFlag = purchasingFlag;
    }

    public Boolean isUseApprovedSupplierFlag() {
        return useApprovedSupplierFlag;
    }

    public void setUseApprovedSupplierFlag(Boolean useApprovedSupplierFlag) {
        this.useApprovedSupplierFlag = useApprovedSupplierFlag;
    }

    public String getNegotiationRequiredFlag() {
        return negotiationRequiredFlag;
    }

    public void setNegotiationRequiredFlag(String negotiationRequiredFlag) {
        this.negotiationRequiredFlag = negotiationRequiredFlag;
    }

    public String getPurchasingTaxCode() {
        return purchasingTaxCode;
    }

    public void setPurchasingTaxCode(String purchasingTaxCode) {
        this.purchasingTaxCode = purchasingTaxCode;
    }

    public String getPurchasingInputTaxClassificationValue() {
        return purchasingInputTaxClassificationValue;
    }

    public void setPurchasingInputTaxClassificationValue(String purchasingInputTaxClassificationValue) {
        this.purchasingInputTaxClassificationValue = purchasingInputTaxClassificationValue;
    }

    public String getUnitOfIssue() {
        return unitOfIssue;
    }

    public void setUnitOfIssue(String unitOfIssue) {
        this.unitOfIssue = unitOfIssue;
    }

    public String getUnitOfIssueValue() {
        return unitOfIssueValue;
    }

    public void setUnitOfIssueValue(String unitOfIssueValue) {
        this.unitOfIssueValue = unitOfIssueValue;
    }

    public String getInvoiceCloseTolerancePercentage() {
        return invoiceCloseTolerancePercentage;
    }

    public void setInvoiceCloseTolerancePercentage(String invoiceCloseTolerancePercentage) {
        this.invoiceCloseTolerancePercentage = invoiceCloseTolerancePercentage;
    }

    public String getHazardClassId() {
        return hazardClassId;
    }

    public void setHazardClassId(String hazardClassId) {
        this.hazardClassId = hazardClassId;
    }

    public String getHazardClassValue() {
        return hazardClassValue;
    }

    public void setHazardClassValue(String hazardClassValue) {
        this.hazardClassValue = hazardClassValue;
    }

    public Long getAssetCategorySIN() {
        return assetCategorySIN;
    }

    public void setAssetCategorySIN(Long assetCategorySIN) {
        this.assetCategorySIN = assetCategorySIN;
    }

    public String getAssetCategoryId() {
        return assetCategoryId;
    }

    public void setAssetCategoryId(String assetCategoryId) {
        this.assetCategoryId = assetCategoryId;
    }

    public String getAssetCategoryValue() {
        return assetCategoryValue;
    }

    public void setAssetCategoryValue(String assetCategoryValue) {
        this.assetCategoryValue = assetCategoryValue;
    }

    public Boolean isPurchasableFlag() {
        return purchasableFlag;
    }

    public void setPurchasableFlag(Boolean purchasableFlag) {
        this.purchasableFlag = purchasableFlag;
    }

    public Boolean isAllowItemDescriptionUpdateFlag() {
        return allowItemDescriptionUpdateFlag;
    }

    public void setAllowItemDescriptionUpdateFlag(Boolean allowItemDescriptionUpdateFlag) {
        this.allowItemDescriptionUpdateFlag = allowItemDescriptionUpdateFlag;
    }

    public Boolean isTaxableFlag() {
        return taxableFlag;
    }

    public void setTaxableFlag(Boolean taxableFlag) {
        this.taxableFlag = taxableFlag;
    }

    public String getBuyerOrganizationId() {
        return buyerOrganizationId;
    }

    public void setBuyerOrganizationId(String buyerOrganizationId) {
        this.buyerOrganizationId = buyerOrganizationId;
    }

    public String getBuyerOrganizationValue() {
        return buyerOrganizationValue;
    }

    public void setBuyerOrganizationValue(String buyerOrganizationValue) {
        this.buyerOrganizationValue = buyerOrganizationValue;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getDefaultBuyerValue() {
        return defaultBuyerValue;
    }

    public void setDefaultBuyerValue(String defaultBuyerValue) {
        this.defaultBuyerValue = defaultBuyerValue;
    }

    public String getReceiptCloseTolerancePercentage() {
        return receiptCloseTolerancePercentage;
    }

    public void setReceiptCloseTolerancePercentage(String receiptCloseTolerancePercentage) {
        this.receiptCloseTolerancePercentage = receiptCloseTolerancePercentage;
    }

    public String getUNNumberId() {
        return uNNumberId;
    }

    public void setUNNumberId(String uNNumberId) {
        this.uNNumberId = uNNumberId;
    }

    public String getUNNumberValue() {
        return uNNumberValue;
    }

    public void setUNNumberValue(String uNNumberValue) {
        this.uNNumberValue = uNNumberValue;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getPriceTolerancePercentage() {
        return priceTolerancePercentage;
    }

    public void setPriceTolerancePercentage(String priceTolerancePercentage) {
        this.priceTolerancePercentage = priceTolerancePercentage;
    }

    public Long getExpenseSIN() {
        return expenseSIN;
    }

    public void setExpenseSIN(Long expenseSIN) {
        this.expenseSIN = expenseSIN;
    }

    public String getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(String expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public String getExpenseAccountValue() {
        return expenseAccountValue;
    }

    public void setExpenseAccountValue(String expenseAccountValue) {
        this.expenseAccountValue = expenseAccountValue;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getRoundingFactor() {
        return roundingFactor;
    }

    public void setRoundingFactor(String roundingFactor) {
        this.roundingFactor = roundingFactor;
    }

    public String getOutsourcedAssemblyFlag() {
        return outsourcedAssemblyFlag;
    }

    public void setOutsourcedAssemblyFlag(String outsourcedAssemblyFlag) {
        this.outsourcedAssemblyFlag = outsourcedAssemblyFlag;
    }

    public String getOutsideProcessingFlag() {
        return outsideProcessingFlag;
    }

    public void setOutsideProcessingFlag(String outsideProcessingFlag) {
        this.outsideProcessingFlag = outsideProcessingFlag;
    }

    public String getOutsideOperationUOMType() {
        return outsideOperationUOMType;
    }

    public void setOutsideOperationUOMType(String outsideOperationUOMType) {
        this.outsideOperationUOMType = outsideOperationUOMType;
    }

    public String getOutsideProcessingUnitTypeValue() {
        return outsideProcessingUnitTypeValue;
    }

    public void setOutsideProcessingUnitTypeValue(String outsideProcessingUnitTypeValue) {
        this.outsideProcessingUnitTypeValue = outsideProcessingUnitTypeValue;
    }

    public Long getMatchApprovalLevel() {
        return matchApprovalLevel;
    }

    public void setMatchApprovalLevel(Long matchApprovalLevel) {
        this.matchApprovalLevel = matchApprovalLevel;
    }

    public String getMatchApprovalLevelValue() {
        return matchApprovalLevelValue;
    }

    public void setMatchApprovalLevelValue(String matchApprovalLevelValue) {
        this.matchApprovalLevelValue = matchApprovalLevelValue;
    }

    public String getConfigMatch() {
        return configMatch;
    }

    public void setConfigMatch(String configMatch) {
        this.configMatch = configMatch;
    }

    public String getMatchConfigurationOptionValue() {
        return matchConfigurationOptionValue;
    }

    public void setMatchConfigurationOptionValue(String matchConfigurationOptionValue) {
        this.matchConfigurationOptionValue = matchConfigurationOptionValue;
    }

    public Long getReceivingRoutingId() {
        return receivingRoutingId;
    }

    public void setReceivingRoutingId(Long receivingRoutingId) {
        this.receivingRoutingId = receivingRoutingId;
    }

    public String getReceiptRountingValue() {
        return receiptRountingValue;
    }

    public void setReceiptRountingValue(String receiptRountingValue) {
        this.receiptRountingValue = receiptRountingValue;
    }

    public String getEnforceShipToLocationCode() {
        return enforceShipToLocationCode;
    }

    public void setEnforceShipToLocationCode(String enforceShipToLocationCode) {
        this.enforceShipToLocationCode = enforceShipToLocationCode;
    }

    public String getEnforceShipToLocation() {
        return enforceShipToLocation;
    }

    public void setEnforceShipToLocation(String enforceShipToLocation) {
        this.enforceShipToLocation = enforceShipToLocation;
    }

    public String getReceiptDaysExceptionCode() {
        return receiptDaysExceptionCode;
    }

    public void setReceiptDaysExceptionCode(String receiptDaysExceptionCode) {
        this.receiptDaysExceptionCode = receiptDaysExceptionCode;
    }

    public String getReceiptDateActionValue() {
        return receiptDateActionValue;
    }

    public void setReceiptDateActionValue(String receiptDateActionValue) {
        this.receiptDateActionValue = receiptDateActionValue;
    }

    public String getDaysEarlyReceiptAllowed() {
        return daysEarlyReceiptAllowed;
    }

    public void setDaysEarlyReceiptAllowed(String daysEarlyReceiptAllowed) {
        this.daysEarlyReceiptAllowed = daysEarlyReceiptAllowed;
    }

    public String getDaysLateReceiptAllowed() {
        return daysLateReceiptAllowed;
    }

    public void setDaysLateReceiptAllowed(String daysLateReceiptAllowed) {
        this.daysLateReceiptAllowed = daysLateReceiptAllowed;
    }

    public String getAllowSubstituteReceiptsFlag() {
        return allowSubstituteReceiptsFlag;
    }

    public void setAllowSubstituteReceiptsFlag(String allowSubstituteReceiptsFlag) {
        this.allowSubstituteReceiptsFlag = allowSubstituteReceiptsFlag;
    }

    public String getAllowUnorderedReceiptsFlag() {
        return allowUnorderedReceiptsFlag;
    }

    public void setAllowUnorderedReceiptsFlag(String allowUnorderedReceiptsFlag) {
        this.allowUnorderedReceiptsFlag = allowUnorderedReceiptsFlag;
    }

    public String getAllowExpressDeliveryFlag() {
        return allowExpressDeliveryFlag;
    }

    public void setAllowExpressDeliveryFlag(String allowExpressDeliveryFlag) {
        this.allowExpressDeliveryFlag = allowExpressDeliveryFlag;
    }

    public String getQuantityRcvExceptionCode() {
        return quantityRcvExceptionCode;
    }

    public void setQuantityRcvExceptionCode(String quantityRcvExceptionCode) {
        this.quantityRcvExceptionCode = quantityRcvExceptionCode;
    }

    public String getQuantityReceivedToleranceAction() {
        return quantityReceivedToleranceAction;
    }

    public void setQuantityReceivedToleranceAction(String quantityReceivedToleranceAction) {
        this.quantityReceivedToleranceAction = quantityReceivedToleranceAction;
    }

    public String getQuantityReceivedTolerancePercentage() {
        return quantityReceivedTolerancePercentage;
    }

    public void setQuantityReceivedTolerancePercentage(String quantityReceivedTolerancePercentage) {
        this.quantityReceivedTolerancePercentage = quantityReceivedTolerancePercentage;
    }


    public String getSummaryFlag() {
        return summaryFlag;
    }

    public void setSummaryFlag(String summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

    public String getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(String endDateActive) {
        this.endDateActive = endDateActive;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(String startDateActive) {
        this.startDateActive = startDateActive;
    }

    public String getGdsnOutboundEnabledFlag() {
        return gdsnOutboundEnabledFlag;
    }

    public void setGdsnOutboundEnabledFlag(String gdsnOutboundEnabledFlag) {
        this.gdsnOutboundEnabledFlag = gdsnOutboundEnabledFlag;
    }

    public String getAltItemCode() {
        return altItemCode;
    }

    public void setAltItemCode(String altItemCode) {
        this.altItemCode = altItemCode;
    }

    public String getAcdType() {
        return acdType;
    }

    public void setAcdType(String acdType) {
        this.acdType = acdType;
    }

    public String getChangeBitMap() {
        return changeBitMap;
    }

    public void setChangeBitMap(String changeBitMap) {
        this.changeBitMap = changeBitMap;
    }

    public Long getChangeLineId() {
        return changeLineId;
    }

    public void setChangeLineId(Long changeLineId) {
        this.changeLineId = changeLineId;
    }

    public String getVersionEnableFlagAtICC() {
        return versionEnableFlagAtICC;
    }

    public void setVersionEnableFlagAtICC(String versionEnableFlagAtICC) {
        this.versionEnableFlagAtICC = versionEnableFlagAtICC;
    }

    public String getVersionAsOfDate() {
        return versionAsOfDate;
    }

    public void setVersionAsOfDate(String versionAsOfDate) {
        this.versionAsOfDate = versionAsOfDate;
    }

    public Long getContextChangeLineId() {
        return contextChangeLineId;
    }

    public void setContextChangeLineId(Long contextChangeLineId) {
        this.contextChangeLineId = contextChangeLineId;
    }

    public Long getContextVersionId() {
        return contextVersionId;
    }

    public void setContextVersionId(Long contextVersionId) {
        this.contextVersionId = contextVersionId;
    }

    public String getPUOMClass() {
        return pUOMClass;
    }

    public void setPUOMClass(String pUOMClass) {
        this.pUOMClass = pUOMClass;
    }

    public String getSUOMClass() {
        return sUOMClass;
    }

    public void setSUOMClass(String sUOMClass) {
        this.sUOMClass = sUOMClass;
    }

    public String getCoverageScheduleId() {
        return coverageScheduleId;
    }

    public void setCoverageScheduleId(String coverageScheduleId) {
        this.coverageScheduleId = coverageScheduleId;
    }

    public Long getInventoryOrganizationId() {
        return inventoryOrganizationId;
    }

    public void setInventoryOrganizationId(Long inventoryOrganizationId) {
        this.inventoryOrganizationId = inventoryOrganizationId;
    }

    public String getInventoryOrganizationValue() {
        return inventoryOrganizationValue;
    }

    public void setInventoryOrganizationValue(String inventoryOrganizationValue) {
        this.inventoryOrganizationValue = inventoryOrganizationValue;
    }

    public String getItemExtensibleFlexfieldCategoryCode() {
        return itemExtensibleFlexfieldCategoryCode;
    }

    public void setItemExtensibleFlexfieldCategoryCode(String itemExtensibleFlexfieldCategoryCode) {
        this.itemExtensibleFlexfieldCategoryCode = itemExtensibleFlexfieldCategoryCode;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }


    public Boolean isBackToBackEnabledFlag() {
        return backToBackEnabledFlag;
    }

    public void setBackToBackEnabledFlag(Boolean backToBackEnabledFlag) {
        this.backToBackEnabledFlag = backToBackEnabledFlag;
    }

    public Boolean isContractManufacturingFlag() {
        return contractManufacturingFlag;
    }

    public void setContractManufacturingFlag(Boolean contractManufacturingFlag) {
        this.contractManufacturingFlag = contractManufacturingFlag;
    }

    public String getDaysOfCover() {
        return daysOfCover;
    }

    public void setDaysOfCover(String daysOfCover) {
        this.daysOfCover = daysOfCover;
    }

    public String getDemandPeriod() {
        return demandPeriod;
    }

    public void setDemandPeriod(String demandPeriod) {
        this.demandPeriod = demandPeriod;
    }

    public String getSafetyStockPlanningMethod() {
        return safetyStockPlanningMethod;
    }

    public void setSafetyStockPlanningMethod(String safetyStockPlanningMethod) {
        this.safetyStockPlanningMethod = safetyStockPlanningMethod;
    }

    public String getSafetyStockPlanningMethodValue() {
        return safetyStockPlanningMethodValue;
    }

    public void setSafetyStockPlanningMethodValue(String safetyStockPlanningMethodValue) {
        this.safetyStockPlanningMethodValue = safetyStockPlanningMethodValue;
    }

    public String getAttachmentEntityName() {
        return attachmentEntityName;
    }

    public void setAttachmentEntityName(String attachmentEntityName) {
        this.attachmentEntityName = attachmentEntityName;
    }

    public Boolean isOutsideProcessServiceFlag() {
        return outsideProcessServiceFlag;
    }

    public void setOutsideProcessServiceFlag(Boolean outsideProcessServiceFlag) {
        this.outsideProcessServiceFlag = outsideProcessServiceFlag;
    }

    public Boolean isAllowMaintenanceAssetFlag() {
        return allowMaintenanceAssetFlag;
    }

    public void setAllowMaintenanceAssetFlag(Boolean allowMaintenanceAssetFlag) {
        this.allowMaintenanceAssetFlag = allowMaintenanceAssetFlag;
    }

    public Boolean isEnableGenealogyTrackingFlag() {
        return enableGenealogyTrackingFlag;
    }

    public void setEnableGenealogyTrackingFlag(Boolean enableGenealogyTrackingFlag) {
        this.enableGenealogyTrackingFlag = enableGenealogyTrackingFlag;
    }

    public Boolean isCssEnabledFlag() {
        return cssEnabledFlag;
    }

    public void setCssEnabledFlag(Boolean cssEnabledFlag) {
        this.cssEnabledFlag = cssEnabledFlag;
    }

    public String getServiceDurationPeriodCodeClass() {
        return serviceDurationPeriodCodeClass;
    }

    public void setServiceDurationPeriodCodeClass(String serviceDurationPeriodCodeClass) {
        this.serviceDurationPeriodCodeClass = serviceDurationPeriodCodeClass;
    }

    public Boolean isEngineeredItemFlag() {
        return engineeredItemFlag;
    }

    public void setEngineeredItemFlag(Boolean engineeredItemFlag) {
        this.engineeredItemFlag = engineeredItemFlag;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStandardCoverage() {
        return standardCoverage;
    }

    public void setStandardCoverage(String standardCoverage) {
        this.standardCoverage = standardCoverage;
    }

    public String getInvItemIdChar() {
        return invItemIdChar;
    }

    public void setInvItemIdChar(String invItemIdChar) {
        this.invItemIdChar = invItemIdChar;
    }

    public String getOrgIdChar() {
        return orgIdChar;
    }

    public void setOrgIdChar(String orgIdChar) {
        this.orgIdChar = orgIdChar;
    }

    public String getFNDACFFAccountConcatenatedStorage() {
        return fNDACFFAccountConcatenatedStorage;
    }

    public void setFNDACFFAccountConcatenatedStorage(String fNDACFFAccountConcatenatedStorage) {
        this.fNDACFFAccountConcatenatedStorage = fNDACFFAccountConcatenatedStorage;
    }

    public String getFNDACFFAccountDelimiter() {
        return fNDACFFAccountDelimiter;
    }

    public void setFNDACFFAccountDelimiter(String fNDACFFAccountDelimiter) {
        this.fNDACFFAccountDelimiter = fNDACFFAccountDelimiter;
    }

    public String getFNDACFFLocatorFlexFieldConcatenatedStorage() {
        return fNDACFFLocatorFlexFieldConcatenatedStorage;
    }

    public void setFNDACFFLocatorFlexFieldConcatenatedStorage(String fNDACFFLocatorFlexFieldConcatenatedStorage) {
        this.fNDACFFLocatorFlexFieldConcatenatedStorage = fNDACFFLocatorFlexFieldConcatenatedStorage;
    }

    public String getFNDACFFLocatorFlexFieldDelimiter() {
        return fNDACFFLocatorFlexFieldDelimiter;
    }

    public void setFNDACFFLocatorFlexFieldDelimiter(String fNDACFFLocatorFlexFieldDelimiter) {
        this.fNDACFFLocatorFlexFieldDelimiter = fNDACFFLocatorFlexFieldDelimiter;
    }

    public String getFNDACFFAccount1ConcatenatedStorage() {
        return fNDACFFAccount1ConcatenatedStorage;
    }

    public void setFNDACFFAccount1ConcatenatedStorage(String fNDACFFAccount1ConcatenatedStorage) {
        this.fNDACFFAccount1ConcatenatedStorage = fNDACFFAccount1ConcatenatedStorage;
    }

    public String getFNDACFFAccount1Delimiter() {
        return fNDACFFAccount1Delimiter;
    }

    public void setFNDACFFAccount1Delimiter(String fNDACFFAccount1Delimiter) {
        this.fNDACFFAccount1Delimiter = fNDACFFAccount1Delimiter;
    }

    public String getFNDACFFLocatorFlexField2ConcatenatedStorage() {
        return fNDACFFLocatorFlexField2ConcatenatedStorage;
    }

    public void setFNDACFFLocatorFlexField2ConcatenatedStorage(String fNDACFFLocatorFlexField2ConcatenatedStorage) {
        this.fNDACFFLocatorFlexField2ConcatenatedStorage = fNDACFFLocatorFlexField2ConcatenatedStorage;
    }

    public String getFNDACFFLocatorFlexField2Delimiter() {
        return fNDACFFLocatorFlexField2Delimiter;
    }

    public void setFNDACFFLocatorFlexField2Delimiter(String fNDACFFLocatorFlexField2Delimiter) {
        this.fNDACFFLocatorFlexField2Delimiter = fNDACFFLocatorFlexField2Delimiter;
    }

    public String getFNDACFFCategoryConcatenatedStorage() {
        return fNDACFFCategoryConcatenatedStorage;
    }

    public void setFNDACFFCategoryConcatenatedStorage(String fNDACFFCategoryConcatenatedStorage) {
        this.fNDACFFCategoryConcatenatedStorage = fNDACFFCategoryConcatenatedStorage;
    }

    public String getFNDACFFCategoryDelimiter() {
        return fNDACFFCategoryDelimiter;
    }

    public void setFNDACFFCategoryDelimiter(String fNDACFFCategoryDelimiter) {
        this.fNDACFFCategoryDelimiter = fNDACFFCategoryDelimiter;
    }

    public String getFNDACFFLocatorFlexField1ConcatenatedStorage() {
        return fNDACFFLocatorFlexField1ConcatenatedStorage;
    }

    public void setFNDACFFLocatorFlexField1ConcatenatedStorage(String fNDACFFLocatorFlexField1ConcatenatedStorage) {
        this.fNDACFFLocatorFlexField1ConcatenatedStorage = fNDACFFLocatorFlexField1ConcatenatedStorage;
    }

    public String getFNDACFFLocatorFlexField1Delimiter() {
        return fNDACFFLocatorFlexField1Delimiter;
    }

    public void setFNDACFFLocatorFlexField1Delimiter(String fNDACFFLocatorFlexField1Delimiter) {
        this.fNDACFFLocatorFlexField1Delimiter = fNDACFFLocatorFlexField1Delimiter;
    }

    public void setWhUpdateDate(Date whUpdateDate) {
        this.whUpdateDate = whUpdateDate;
    }

    public Date getWhUpdateDate() {
        return whUpdateDate;
    }

    public void setContextDate(Date contextDate) {
        this.contextDate = contextDate;
    }

    public Date getContextDate() {
        return contextDate;
    }

    public void setVersionEndDate(Date versionEndDate) {
        this.versionEndDate = versionEndDate;
    }

    public Date getVersionEndDate() {
        return versionEndDate;
    }

    public void setVersionStartDate(Date versionStartDate) {
        this.versionStartDate = versionStartDate;
    }

    public Date getVersionStartDate() {
        return versionStartDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setImplementationDate(Date implementationDate) {
        this.implementationDate = implementationDate;
    }

    public Date getImplementationDate() {
        return implementationDate;
    }

}
