
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ItemRevision_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemRevision");
    private final static QName _ItemRevisionTranslationResult_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemRevisionTranslationResult");
    private final static QName _Item_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "item");
    private final static QName _RevisionAttachment_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "revisionAttachment");
    private final static QName _ItemCategory_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemCategory");
    private final static QName _ItemSupplierAssociation_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemSupplierAssociation");
    private final static QName _ItemTranslationResult_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemTranslationResult");
    private final static QName _ItemAttachment_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemAttachment");
    private final static QName _ItemCategoryResult_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemCategoryResult");
    private final static QName _ItemTranslation_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemTranslation");
    private final static QName _ItemRevisionTranslation_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "itemRevisionTranslation");
    private final static QName _ItemSupplierAssociationSupplierNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SupplierNumber");
    private final static QName _ItemSupplierAssociationSupplierSiteAssociationStatus_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SupplierSiteAssociationStatus");
    private final static QName _ItemSupplierAssociationSupplierExtensibleFlexfieldCategoryCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SupplierExtensibleFlexfieldCategoryCode");
    private final static QName _ItemSupplierAssociationAlternateSupplierNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AlternateSupplierNumber");
    private final static QName _ItemSupplierAssociationSupplierName_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SupplierName");
    private final static QName _ItemSupplierAssociationAddress_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Address");
    private final static QName _ItemSupplierAssociationPrimaryFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PrimaryFlag");
    private final static QName _ItemSupplierAssociationSupplierItemNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SupplierItemNumber");
    private final static QName _ItemSupplierAssociationPartySiteNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PartySiteNumber");
    private final static QName _ItemSupplierAssociationAddressName_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AddressName");
    private final static QName _ItemCategoryCategoryName_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CategoryName");
    private final static QName _ItemCategorySequenceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SequenceNumber");
    private final static QName _ItemCategoryItemCategoryAssignmentId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemCategoryAssignmentId");
    private final static QName _ItemCategoryItemCatalog_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemCatalog");
    private final static QName _ItemPlanningMakeBuyValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PlanningMakeBuyValue");
    private final static QName _ItemAllowSuspendFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowSuspendFlag");
    private final static QName _ItemSerialStartingPrefix_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SerialStartingPrefix");
    private final static QName _ItemMaximumOrderQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaximumOrderQuantity");
    private final static QName _ItemRepairYield_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RepairYield");
    private final static QName _ItemPrepositionPointFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PrepositionPointFlag");
    private final static QName _ItemCopyFromRevisionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyFromRevisionValue");
    private final static QName _ItemCopyItemAndApplyTemplatesFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyItemAndApplyTemplatesFlag");
    private final static QName _ItemProcessExecutionEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessExecutionEnabledFlag");
    private final static QName _ItemChangeOrderLineSequenceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChangeOrderLineSequenceNumber");
    private final static QName _ItemRMAInspectionRequiredFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RMAInspectionRequiredFlag");
    private final static QName _ItemKeyword_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Keyword");
    private final static QName _ItemFixedLotSizeMultiplier_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FixedLotSizeMultiplier");
    private final static QName _ItemMaximumDaysOfSupply_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaximumDaysOfSupply");
    private final static QName _ItemReturnableFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReturnableFlag");
    private final static QName _ItemCheckMaterialShortageFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CheckMaterialShortageFlag");
    private final static QName _ItemUnitVolumeQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnitVolumeQuantity");
    private final static QName _ItemForecastTypelValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ForecastTypelValue");
    private final static QName _ItemLotSplitEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotSplitEnabledFlag");
    private final static QName _ItemRestrictSubinventoriesFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RestrictSubinventoriesFlag");
    private final static QName _ItemAllowExpressDeliveryFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowExpressDeliveryFlag");
    private final static QName _ItemWIPSupplyLocatorValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "WIPSupplyLocatorValue");
    private final static QName _ItemUnderReturnTolerance_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnderReturnTolerance");
    private final static QName _ItemRoundingFactor_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RoundingFactor");
    private final static QName _ItemCssEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CssEnabledFlag");
    private final static QName _ItemProcessCostingEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessCostingEnabledFlag");
    private final static QName _ItemCopyAssociationsFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyAssociationsFlag");
    private final static QName _ItemProcessYieldLocatorValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessYieldLocatorValue");
    private final static QName _ItemDefectTrackingOnFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefectTrackingOnFlag");
    private final static QName _ItemForecastHorizon_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ForecastHorizon");
    private final static QName _ItemDaysMaximumInventorySupply_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DaysMaximumInventorySupply");
    private final static QName _ItemItemStatusValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemStatusValue");
    private final static QName _ItemHazardClassValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "HazardClassValue");
    private final static QName _ItemUnitOfIssueValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnitOfIssueValue");
    private final static QName _ItemVariableLeadTime_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VariableLeadTime");
    private final static QName _ItemReceiptDateActionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReceiptDateActionValue");
    private final static QName _ItemServiceBillingEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceBillingEnabledFlag");
    private final static QName _ItemNegativeMeasurementError_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "NegativeMeasurementError");
    private final static QName _ItemOrganizationCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OrganizationCode");
    private final static QName _ItemStartingLotNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StartingLotNumber");
    private final static QName _ItemReleaseAuthorizationRequiredValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReleaseAuthorizationRequiredValue");
    private final static QName _ItemLeadTimeLotSize_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LeadTimeLotSize");
    private final static QName _ItemSecondaryUnitofMeasureValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SecondaryUnitofMeasureValue");
    private final static QName _ItemVolumeUOMValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VolumeUOMValue");
    private final static QName _ItemQuantityReceivedToleranceAction_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "QuantityReceivedToleranceAction");
    private final static QName _ItemContainerTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ContainerTypeValue");
    private final static QName _ItemAllowUnorderedReceiptsFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowUnorderedReceiptsFlag");
    private final static QName _ItemSubstitutionDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SubstitutionDays");
    private final static QName _ItemDefaultLotStatusValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultLotStatusValue");
    private final static QName _ItemNegativeDeviationFactor_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "NegativeDeviationFactor");
    private final static QName _ItemPlanningMethodValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PlanningMethodValue");
    private final static QName _ItemDemandTimeFence_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DemandTimeFence");
    private final static QName _ItemVersionPlannedEffectiveDateTime_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VersionPlannedEffectiveDateTime");
    private final static QName _ItemCASNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CASNumber");
    private final static QName _ItemShipModelCompleteFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ShipModelCompleteFlag");
    private final static QName _ItemMinimumMinmaxQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MinimumMinmaxQuantity");
    private final static QName _ItemWeightUOMValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "WeightUOMValue");
    private final static QName _ItemPriceTolerancePercentage_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PriceTolerancePercentage");
    private final static QName _ItemRoundingControlTypeFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RoundingControlTypeFlag");
    private final static QName _ItemBackToBackEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "BackToBackEnabledFlag");
    private final static QName _ItemBaseItemValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "BaseItemValue");
    private final static QName _ItemDefaultingControlValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultingControlValue");
    private final static QName _ItemUNNumberValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UNNumberValue");
    private final static QName _ItemNegotiationRequiredFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "NegotiationRequiredFlag");
    private final static QName _ItemVersionStatus_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VersionStatus");
    private final static QName _ItemBackOrderableFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "BackOrderableFlag");
    private final static QName _ItemCumulativeManufacturingLeadTime_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CumulativeManufacturingLeadTime");
    private final static QName _ItemDefaultShippingOrganizationValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultShippingOrganizationValue");
    private final static QName _ItemDaysEarlyReceiptAllowed_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DaysEarlyReceiptAllowed");
    private final static QName _ItemChildLotEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChildLotEnabledFlag");
    private final static QName _ItemRecoveredPartDispositionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RecoveredPartDispositionValue");
    private final static QName _ItemPaymentTermsValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PaymentTermsValue");
    private final static QName _ItemAssetActivityShutdownTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AssetActivityShutdownTypeValue");
    private final static QName _ItemWebStatusValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "WebStatusValue");
    private final static QName _ItemAcceptableEarlyDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AcceptableEarlyDays");
    private final static QName _ItemChildLotParent_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChildLotParent");
    private final static QName _ItemSerialStatusEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SerialStatusEnabledFlag");
    private final static QName _ItemAssetCategoryValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AssetCategoryValue");
    private final static QName _ItemRestrictLocatorsFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RestrictLocatorsFlag");
    private final static QName _ItemCarryPercentage_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CarryPercentage");
    private final static QName _ItemMaximumOrder_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaximumOrder");
    private final static QName _ItemTaxableFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "TaxableFlag");
    private final static QName _ItemUnderShipmentTolerance_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnderShipmentTolerance");
    private final static QName _ItemLastSubmittedNewItemRequest_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LastSubmittedNewItemRequest");
    private final static QName _ItemShrinkageRate_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ShrinkageRate");
    private final static QName _ItemStructureItemTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StructureItemTypeValue");
    private final static QName _ItemProcessSupplyLocatorValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessSupplyLocatorValue");
    private final static QName _ItemEAMActivityTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EAMActivityTypeValue");
    private final static QName _ItemVehicleItemFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VehicleItemFlag");
    private final static QName _ItemCopyFromVersionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyFromVersionValue");
    private final static QName _ItemLotDivisibleFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotDivisibleFlag");
    private final static QName _ItemAllowSubstituteReceiptsFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowSubstituteReceiptsFlag");
    private final static QName _ItemExpirationActionInterval_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ExpirationActionInterval");
    private final static QName _ItemWIPSupplySubinventoryValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "WIPSupplySubinventoryValue");
    private final static QName _ItemReceiptRountingValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReceiptRountingValue");
    private final static QName _ItemChildLotFormatValidationFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChildLotFormatValidationFlag");
    private final static QName _ItemEffectivityControlValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EffectivityControlValue");
    private final static QName _ItemSalesAccountValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SalesAccountValue");
    private final static QName _ItemProcessingDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessingDays");
    private final static QName _ItemServiceStartTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceStartTypeValue");
    private final static QName _ItemServiceRequestEnabledValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceRequestEnabledValue");
    private final static QName _ItemStyleItemNumberValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StyleItemNumberValue");
    private final static QName _ItemChildLotStartingNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChildLotStartingNumber");
    private final static QName _ItemHazardousMaterialFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "HazardousMaterialFlag");
    private final static QName _ItemPlanningTimeDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PlanningTimeDays");
    private final static QName _ItemStandardLotSize_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StandardLotSize");
    private final static QName _ItemMarketPrice_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MarketPrice");
    private final static QName _ItemItemNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemNumber");
    private final static QName _ItemServiceDurationPeriodValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceDurationPeriodValue");
    private final static QName _ItemLotControlValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotControlValue");
    private final static QName _ItemATPValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ATPValue");
    private final static QName _ItemGradeControlFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "GradeControlFlag");
    private final static QName _ItemDefaultSalesOrderSourceTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultSalesOrderSourceTypeValue");
    private final static QName _ItemEnableGenealogyTrackingFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EnableGenealogyTrackingFlag");
    private final static QName _ItemTransactionConversionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "TransactionConversionValue");
    private final static QName _ItemReplenishmentType_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReplenishmentType");
    private final static QName _ItemCumulativeTotalLeadTime_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CumulativeTotalLeadTime");
    private final static QName _ItemInstanceClassValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "InstanceClassValue");
    private final static QName _ItemCriticalComponentFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CriticalComponentFlag");
    private final static QName _ItemConsignedFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ConsignedFlag");
    private final static QName _ItemLotExpirationControlValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotExpirationControlValue");
    private final static QName _ItemDimensionUOMValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DimensionUOMValue");
    private final static QName _ItemWarehouseEquipmentFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "WarehouseEquipmentFlag");
    private final static QName _ItemExpirationActionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ExpirationActionValue");
    private final static QName _ItemReservableFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReservableFlag");
    private final static QName _ItemShelfLifeDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ShelfLifeDays");
    private final static QName _ItemFinancingAllowedFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FinancingAllowedFlag");
    private final static QName _ItemDaysOfCover_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DaysOfCover");
    private final static QName _ItemChangeNotice_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChangeNotice");
    private final static QName _ItemInternalVolume_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "InternalVolume");
    private final static QName _ItemUnitLengthQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnitLengthQuantity");
    private final static QName _ItemTemplate_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Template");
    private final static QName _ItemUnitWidthQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnitWidthQuantity");
    private final static QName _ItemCopyLotAttributeFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyLotAttributeFlag");
    private final static QName _ItemMRPCalculateATPFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MRPCalculateATPFlag");
    private final static QName _ItemProcessQualityEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessQualityEnabledFlag");
    private final static QName _ItemPositiveMeasurementError_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PositiveMeasurementError");
    private final static QName _ItemQuantityReceivedTolerancePercentage_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "QuantityReceivedTolerancePercentage");
    private final static QName _ItemSafetyStockPlanningMethodValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SafetyStockPlanningMethodValue");
    private final static QName _ItemStartingLotPrefix_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StartingLotPrefix");
    private final static QName _ItemOrderManagementIndivisibleFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OrderManagementIndivisibleFlag");
    private final static QName _ItemSubstitutionWindow_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SubstitutionWindow");
    private final static QName _ItemDemandPeriod_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DemandPeriod");
    private final static QName _ItemAllowTerminateFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowTerminateFlag");
    private final static QName _ItemPlannedInventoryPointFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PlannedInventoryPointFlag");
    private final static QName _ItemFormattedDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FormattedDescription");
    private final static QName _ItemMatchConfigurationOptionValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MatchConfigurationOptionValue");
    private final static QName _ItemMaximumLoadWeight_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaximumLoadWeight");
    private final static QName _ItemVersionDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VersionDescription");
    private final static QName _ItemOutsideProcessServiceFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OutsideProcessServiceFlag");
    private final static QName _ItemDemandTimeDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DemandTimeDays");
    private final static QName _ItemPlanner_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Planner");
    private final static QName _ItemIgnoreDuplicateItemFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "IgnoreDuplicateItemFlag");
    private final static QName _ItemServiceDuration_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceDuration");
    private final static QName _ItemAssetActivityCauseValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AssetActivityCauseValue");
    private final static QName _ItemCollateralFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CollateralFlag");
    private final static QName _ItemInventoryPlanningMethodValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "InventoryPlanningMethodValue");
    private final static QName _ItemLongDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LongDescription");
    private final static QName _ItemServiceStartDelay_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceStartDelay");
    private final static QName _ItemCopyAttachmentsFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyAttachmentsFlag");
    private final static QName _ItemPurchasingInputTaxClassificationValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PurchasingInputTaxClassificationValue");
    private final static QName _ItemLifecyclePhaseValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LifecyclePhaseValue");
    private final static QName _ItemEventFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EventFlag");
    private final static QName _ItemOrderableOnWebFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OrderableOnWebFlag");
    private final static QName _ItemUOMPricingValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UOMPricingValue");
    private final static QName _ItemReplenishmentMinimumDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReplenishmentMinimumDays");
    private final static QName _ItemCopyOrganizationAssignmentsFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyOrganizationAssignmentsFlag");
    private final static QName _ItemItemClass_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemClass");
    private final static QName _ItemServiceDurationTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ServiceDurationTypeValue");
    private final static QName _ItemUnitWeightQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnitWeightQuantity");
    private final static QName _ItemCommsActivationReqdFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CommsActivationReqdFlag");
    private final static QName _ItemPackTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PackTypeValue");
    private final static QName _ItemMaximumMinmaxQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaximumMinmaxQuantity");
    private final static QName _ItemAllowMaintenanceAssetFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowMaintenanceAssetFlag");
    private final static QName _ItemRepairLeadtime_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RepairLeadtime");
    private final static QName _ItemEAMActivityNotificationFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EAMActivityNotificationFlag");
    private final static QName _ItemRequiresFulfillmentLocFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RequiresFulfillmentLocFlag");
    private final static QName _ItemOutsideProcessingUnitTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OutsideProcessingUnitTypeValue");
    private final static QName _ItemAssetClassValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AssetClassValue");
    private final static QName _ItemUnitHeightQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UnitHeightQuantity");
    private final static QName _ItemItemExtensibleFlexfieldCategoryCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemExtensibleFlexfieldCategoryCode");
    private final static QName _ItemPegging_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Pegging");
    private final static QName _ItemChildLotPrefix_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ChildLotPrefix");
    private final static QName _ItemDefaultGradeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultGradeValue");
    private final static QName _ItemApprovalStatusValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ApprovalStatusValue");
    private final static QName _ItemBuyerOrganizationValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "BuyerOrganizationValue");
    private final static QName _ItemUserItemTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UserItemTypeValue");
    private final static QName _ItemPlanningTimeFence_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PlanningTimeFence");
    private final static QName _ItemSalesProductTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SalesProductTypeValue");
    private final static QName _ItemInventoryCarryPenalty_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "InventoryCarryPenalty");
    private final static QName _ItemLotStatusEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotStatusEnabledFlag");
    private final static QName _ItemEligibilityRuleFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EligibilityRuleFlag");
    private final static QName _ItemReplenishmentMinimumOrder_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReplenishmentMinimumOrder");
    private final static QName _ItemDefaultSerialStatusValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultSerialStatusValue");
    private final static QName _ItemBulkPickedFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "BulkPickedFlag");
    private final static QName _ItemOverShipmentTolerance_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OverShipmentTolerance");
    private final static QName _ItemExcludeFromBudgetFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ExcludeFromBudgetFlag");
    private final static QName _ItemAllowItemDescriptionUpdateFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AllowItemDescriptionUpdateFlag");
    private final static QName _ItemEngineeredItemFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EngineeredItemFlag");
    private final static QName _ItemSourceSubinventoryValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SourceSubinventoryValue");
    private final static QName _ItemPreprocessingDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PreprocessingDays");
    private final static QName _ItemRequiresItemAssociationFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RequiresItemAssociationFlag");
    private final static QName _ItemOrderCost_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OrderCost");
    private final static QName _ItemLotMergeEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotMergeEnabledFlag");
    private final static QName _ItemOvercompletionToleranceValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OvercompletionToleranceValue");
    private final static QName _ItemMinimumFillPercent_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MinimumFillPercent");
    private final static QName _ItemReleaseTimeDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReleaseTimeDays");
    private final static QName _ItemCopyCategoriesFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyCategoriesFlag");
    private final static QName _ItemDRPPlannedFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DRPPlannedFlag");
    private final static QName _ItemRecipeEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RecipeEnabledFlag");
    private final static QName _ItemPostprocessingDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PostprocessingDays");
    private final static QName _ItemCreateSupplyFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CreateSupplyFlag");
    private final static QName _ItemRetestInterval_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RetestInterval");
    private final static QName _ItemContainerItemFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ContainerItemFlag");
    private final static QName _ItemTargetInventoryDaysofSupply_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "TargetInventoryDaysofSupply");
    private final static QName _ItemTagetInventoryWindow_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "TagetInventoryWindow");
    private final static QName _ItemDownloadableFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DownloadableFlag");
    private final static QName _ItemDaysLateReceiptAllowed_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DaysLateReceiptAllowed");
    private final static QName _ItemInvoicingRuleValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "InvoicingRuleValue");
    private final static QName _ItemSourceSubinventoryOrganizationValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SourceSubinventoryOrganizationValue");
    private final static QName _ItemMatchApprovalLevelValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MatchApprovalLevelValue");
    private final static QName _ItemInvoiceCloseTolerancePercentage_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "InvoiceCloseTolerancePercentage");
    private final static QName _ItemTrackingUnitofMeasure_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "TrackingUnitofMeasure");
    private final static QName _ItemOperationSlackPenalty_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OperationSlackPenalty");
    private final static QName _ItemForecastControlValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ForecastControlValue");
    private final static QName _ItemDefaultBuyerValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DefaultBuyerValue");
    private final static QName _ItemSourceOrganizationValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SourceOrganizationValue");
    private final static QName _ItemFixedDaysSupply_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FixedDaysSupply");
    private final static QName _ItemReceiptCloseTolerancePercentage_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReceiptCloseTolerancePercentage");
    private final static QName _ItemRevisionQuantityControlFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RevisionQuantityControlFlag");
    private final static QName _ItemMinimumOrderQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MinimumOrderQuantity");
    private final static QName _ItemRevisionForVersion_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RevisionForVersion");
    private final static QName _ItemStockLocatorControlValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StockLocatorControlValue");
    private final static QName _ItemReleaseTimeFence_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ReleaseTimeFence");
    private final static QName _ItemCopyFromItemValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CopyFromItemValue");
    private final static QName _ItemSerialStartingNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SerialStartingNumber");
    private final static QName _ItemFixedLeadTime_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FixedLeadTime");
    private final static QName _ItemEAMActivitySourceValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EAMActivitySourceValue");
    private final static QName _ItemSubcontractingComponentValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SubcontractingComponentValue");
    private final static QName _ItemAutomaticallyExpireASNFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AutomaticallyExpireASNFlag");
    private final static QName _ItemBillingTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "BillingTypeValue");
    private final static QName _ItemHoldDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "HoldDays");
    private final static QName _ItemSerialGenerationValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "SerialGenerationValue");
    private final static QName _ItemStyleItemFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StyleItemFlag");
    private final static QName _ItemPositiveDeviationFactor_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PositiveDeviationFactor");
    private final static QName _ItemLotSubstitutionEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotSubstitutionEnabledFlag");
    private final static QName _ItemContractManufacturingFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ContractManufacturingFlag");
    private final static QName _ItemTrackInstalledBaseFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "TrackInstalledBaseFlag");
    private final static QName _ItemPickingRuleValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PickingRuleValue");
    private final static QName _ItemAccountingRuleValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AccountingRuleValue");
    private final static QName _ItemATPComponentsValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ATPComponentsValue");
    private final static QName _ItemElectronicFormatFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ElectronicFormatFlag");
    private final static QName _ItemMaximumInventoryWindow_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaximumInventoryWindow");
    private final static QName _ItemPrimaryUOMValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "PrimaryUOMValue");
    private final static QName _ItemVMIFixedOrderQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "VMIFixedOrderQuantity");
    private final static QName _ItemOverReturnTolerance_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OverReturnTolerance");
    private final static QName _ItemProcessYieldSubinventoryValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessYieldSubinventoryValue");
    private final static QName _ItemAssetTrackedFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AssetTrackedFlag");
    private final static QName _ItemAssetItemTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "AssetItemTypeValue");
    private final static QName _ItemWIPSupplyTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "WIPSupplyTypeValue");
    private final static QName _ItemMaturityDays_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MaturityDays");
    private final static QName _ItemFixedOrderQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FixedOrderQuantity");
    private final static QName _ItemLotTranslateEnabledFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "LotTranslateEnabledFlag");
    private final static QName _ItemRepairProgramValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RepairProgramValue");
    private final static QName _ItemOutputTaxClassificationCodeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OutputTaxClassificationCodeValue");
    private final static QName _ItemListPrice_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ListPrice");
    private final static QName _ItemEnforceShipToLocation_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EnforceShipToLocation");
    private final static QName _ItemStandardCoverage_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "StandardCoverage");
    private final static QName _ItemConfigModelTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ConfigModelTypeValue");
    private final static QName _ItemExpenseAccountValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ExpenseAccountValue");
    private final static QName _ItemIncludeInRollUpFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "IncludeInRollUpFlag");
    private final static QName _ItemMinimumLicenseQuantity_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "MinimumLicenseQuantity");
    private final static QName _ItemCreateConfiguredItem_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CreateConfiguredItem");
    private final static QName _ItemOvercompletionToleranceTypeValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OvercompletionToleranceTypeValue");
    private final static QName _ItemCreateFixedAssetFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "CreateFixedAssetFlag");
    private final static QName _ItemOutsourcedAssemblyFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "OutsourcedAssemblyFlag");
    private final static QName _ItemVersion_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Version");
    private final static QName _ItemProcessSupplySubinventoryValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ProcessSupplySubinventoryValue");
    private final static QName _ItemRevisionRevisionReasonValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RevisionReasonValue");
    private final static QName _ItemRevisionRevisionExtensibleFlexfieldCategoryCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "RevisionExtensibleFlexfieldCategoryCode");
    private final static QName _ItemRevisionItemRevisionDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemRevisionDescription");
    private final static QName _ItemAttachmentURL_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "URL");
    private final static QName _ItemAttachmentUsageType_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "UsageType");
    private final static QName _ItemAttachmentUri_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Uri");
    private final static QName _ItemAttachmentAttachment_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Attachment");
    private final static QName _ItemAttachmentTitle_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Title");
    private final static QName _ItemAttachmentDocumentURL_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DocumentURL");
    private final static QName _ItemAttachmentFileName_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FileName");
    private final static QName _ItemAttachmentDmNode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DmNode");
    private final static QName _ItemAttachmentDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Description");
    private final static QName _ItemAttachmentStatus_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "Status");
    private final static QName _ItemAttachmentDocumentAttributes_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DocumentAttributes");
    private final static QName _ItemAttachmentDocumentEntityId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DocumentEntityId");
    private final static QName _ItemAttachmentDatabaseDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DatabaseDescription");
    private final static QName _ItemAttachmentDmVersionNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DmVersionNumber");
    private final static QName _ItemAttachmentDmRepository_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DmRepository");
    private final static QName _ItemAttachmentDmFolderPath_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DmFolderPath");
    private final static QName _ItemAttachmentEntityAttributes_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "EntityAttributes");
    private final static QName _ItemAttachmentDatabaseTitle_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DatabaseTitle");
    private final static QName _ItemAttachmentFileContents_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "FileContents");
    private final static QName _ItemAttachmentDmType_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DmType");
    private final static QName _ItemAttachmentDmDocumentId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DmDocumentId");
    private final static QName _ItemTranslationItemDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "ItemDescription");
    private final static QName _ItemTranslationHTMLLongDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "HTMLLongDescription");
    private final static QName _RevisionAttachmentDatatypeCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", "DatatypeCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link ItemAttachment }
     * 
     */
    public ItemAttachment createItemAttachment() {
        return new ItemAttachment();
    }

    /**
     * Create an instance of {@link ItemTranslationResult }
     * 
     */
    public ItemTranslationResult createItemTranslationResult() {
        return new ItemTranslationResult();
    }

    /**
     * Create an instance of {@link ItemSupplierAssociation }
     * 
     */
    public ItemSupplierAssociation createItemSupplierAssociation() {
        return new ItemSupplierAssociation();
    }

    /**
     * Create an instance of {@link RevisionAttachment }
     * 
     */
    public RevisionAttachment createRevisionAttachment() {
        return new RevisionAttachment();
    }

    /**
     * Create an instance of {@link ItemRevisionTranslationResult }
     * 
     */
    public ItemRevisionTranslationResult createItemRevisionTranslationResult() {
        return new ItemRevisionTranslationResult();
    }

    /**
     * Create an instance of {@link ItemCategory }
     * 
     */
    public ItemCategory createItemCategory() {
        return new ItemCategory();
    }

    /**
     * Create an instance of {@link ItemRevisionTranslation }
     * 
     */
    public ItemRevisionTranslation createItemRevisionTranslation() {
        return new ItemRevisionTranslation();
    }

    /**
     * Create an instance of {@link ItemRevision }
     * 
     */
    public ItemRevision createItemRevision() {
        return new ItemRevision();
    }

    /**
     * Create an instance of {@link ItemTranslation }
     * 
     */
    public ItemTranslation createItemTranslation() {
        return new ItemTranslation();
    }

    /**
     * Create an instance of {@link ItemCategoryResult }
     * 
     */
    public ItemCategoryResult createItemCategoryResult() {
        return new ItemCategoryResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemRevision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemRevision")
    public JAXBElement<ItemRevision> createItemRevision(ItemRevision value) {
        return new JAXBElement<ItemRevision>(_ItemRevision_QNAME, ItemRevision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemRevisionTranslationResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemRevisionTranslationResult")
    public JAXBElement<ItemRevisionTranslationResult> createItemRevisionTranslationResult(ItemRevisionTranslationResult value) {
        return new JAXBElement<ItemRevisionTranslationResult>(_ItemRevisionTranslationResult_QNAME, ItemRevisionTranslationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevisionAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "revisionAttachment")
    public JAXBElement<RevisionAttachment> createRevisionAttachment(RevisionAttachment value) {
        return new JAXBElement<RevisionAttachment>(_RevisionAttachment_QNAME, RevisionAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemCategory")
    public JAXBElement<ItemCategory> createItemCategory(ItemCategory value) {
        return new JAXBElement<ItemCategory>(_ItemCategory_QNAME, ItemCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemSupplierAssociation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemSupplierAssociation")
    public JAXBElement<ItemSupplierAssociation> createItemSupplierAssociation(ItemSupplierAssociation value) {
        return new JAXBElement<ItemSupplierAssociation>(_ItemSupplierAssociation_QNAME, ItemSupplierAssociation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemTranslationResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemTranslationResult")
    public JAXBElement<ItemTranslationResult> createItemTranslationResult(ItemTranslationResult value) {
        return new JAXBElement<ItemTranslationResult>(_ItemTranslationResult_QNAME, ItemTranslationResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemAttachment")
    public JAXBElement<ItemAttachment> createItemAttachment(ItemAttachment value) {
        return new JAXBElement<ItemAttachment>(_ItemAttachment_QNAME, ItemAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemCategoryResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemCategoryResult")
    public JAXBElement<ItemCategoryResult> createItemCategoryResult(ItemCategoryResult value) {
        return new JAXBElement<ItemCategoryResult>(_ItemCategoryResult_QNAME, ItemCategoryResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemTranslation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemTranslation")
    public JAXBElement<ItemTranslation> createItemTranslation(ItemTranslation value) {
        return new JAXBElement<ItemTranslation>(_ItemTranslation_QNAME, ItemTranslation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemRevisionTranslation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "itemRevisionTranslation")
    public JAXBElement<ItemRevisionTranslation> createItemRevisionTranslation(ItemRevisionTranslation value) {
        return new JAXBElement<ItemRevisionTranslation>(_ItemRevisionTranslation_QNAME, ItemRevisionTranslation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SupplierNumber", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationSupplierNumber(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationSupplierNumber_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SupplierSiteAssociationStatus", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationSupplierSiteAssociationStatus(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationSupplierSiteAssociationStatus_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SupplierExtensibleFlexfieldCategoryCode", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationSupplierExtensibleFlexfieldCategoryCode(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationSupplierExtensibleFlexfieldCategoryCode_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AlternateSupplierNumber", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationAlternateSupplierNumber(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationAlternateSupplierNumber_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SupplierName", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationSupplierName(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationSupplierName_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Address", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationAddress(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationAddress_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PrimaryFlag", scope = ItemSupplierAssociation.class)
    public JAXBElement<Boolean> createItemSupplierAssociationPrimaryFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemSupplierAssociationPrimaryFlag_QNAME, Boolean.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SupplierItemNumber", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationSupplierItemNumber(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationSupplierItemNumber_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PartySiteNumber", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationPartySiteNumber(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationPartySiteNumber_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AddressName", scope = ItemSupplierAssociation.class)
    public JAXBElement<String> createItemSupplierAssociationAddressName(String value) {
        return new JAXBElement<String>(_ItemSupplierAssociationAddressName_QNAME, String.class, ItemSupplierAssociation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CategoryName", scope = ItemCategory.class)
    public JAXBElement<String> createItemCategoryCategoryName(String value) {
        return new JAXBElement<String>(_ItemCategoryCategoryName_QNAME, String.class, ItemCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SequenceNumber", scope = ItemCategory.class)
    public JAXBElement<Integer> createItemCategorySequenceNumber(Integer value) {
        return new JAXBElement<Integer>(_ItemCategorySequenceNumber_QNAME, Integer.class, ItemCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemCategoryAssignmentId", scope = ItemCategory.class)
    public JAXBElement<Long> createItemCategoryItemCategoryAssignmentId(Long value) {
        return new JAXBElement<Long>(_ItemCategoryItemCategoryAssignmentId_QNAME, Long.class, ItemCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemCatalog", scope = ItemCategory.class)
    public JAXBElement<String> createItemCategoryItemCatalog(String value) {
        return new JAXBElement<String>(_ItemCategoryItemCatalog_QNAME, String.class, ItemCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PlanningMakeBuyValue", scope = Item.class)
    public JAXBElement<String> createItemPlanningMakeBuyValue(String value) {
        return new JAXBElement<String>(_ItemPlanningMakeBuyValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowSuspendFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowSuspendFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowSuspendFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SerialStartingPrefix", scope = Item.class)
    public JAXBElement<String> createItemSerialStartingPrefix(String value) {
        return new JAXBElement<String>(_ItemSerialStartingPrefix_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaximumOrderQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemMaximumOrderQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemMaximumOrderQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RepairYield", scope = Item.class)
    public JAXBElement<BigDecimal> createItemRepairYield(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemRepairYield_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PrepositionPointFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemPrepositionPointFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemPrepositionPointFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyFromRevisionValue", scope = Item.class)
    public JAXBElement<String> createItemCopyFromRevisionValue(String value) {
        return new JAXBElement<String>(_ItemCopyFromRevisionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyItemAndApplyTemplatesFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCopyItemAndApplyTemplatesFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCopyItemAndApplyTemplatesFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessExecutionEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemProcessExecutionEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemProcessExecutionEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChangeOrderLineSequenceNumber", scope = Item.class)
    public JAXBElement<Integer> createItemChangeOrderLineSequenceNumber(Integer value) {
        return new JAXBElement<Integer>(_ItemChangeOrderLineSequenceNumber_QNAME, Integer.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RMAInspectionRequiredFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRMAInspectionRequiredFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRMAInspectionRequiredFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Keyword", scope = Item.class)
    public JAXBElement<String> createItemKeyword(String value) {
        return new JAXBElement<String>(_ItemKeyword_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FixedLotSizeMultiplier", scope = Item.class)
    public JAXBElement<BigDecimal> createItemFixedLotSizeMultiplier(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemFixedLotSizeMultiplier_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaximumDaysOfSupply", scope = Item.class)
    public JAXBElement<BigDecimal> createItemMaximumDaysOfSupply(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemMaximumDaysOfSupply_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReturnableFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemReturnableFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemReturnableFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CheckMaterialShortageFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCheckMaterialShortageFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCheckMaterialShortageFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnitVolumeQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemUnitVolumeQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemUnitVolumeQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ForecastTypelValue", scope = Item.class)
    public JAXBElement<String> createItemForecastTypelValue(String value) {
        return new JAXBElement<String>(_ItemForecastTypelValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotSplitEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemLotSplitEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemLotSplitEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RestrictSubinventoriesFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRestrictSubinventoriesFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRestrictSubinventoriesFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowExpressDeliveryFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowExpressDeliveryFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowExpressDeliveryFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "WIPSupplyLocatorValue", scope = Item.class)
    public JAXBElement<String> createItemWIPSupplyLocatorValue(String value) {
        return new JAXBElement<String>(_ItemWIPSupplyLocatorValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnderReturnTolerance", scope = Item.class)
    public JAXBElement<BigDecimal> createItemUnderReturnTolerance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemUnderReturnTolerance_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RoundingFactor", scope = Item.class)
    public JAXBElement<BigDecimal> createItemRoundingFactor(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemRoundingFactor_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CssEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCssEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCssEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessCostingEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemProcessCostingEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemProcessCostingEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyAssociationsFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCopyAssociationsFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCopyAssociationsFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessYieldLocatorValue", scope = Item.class)
    public JAXBElement<String> createItemProcessYieldLocatorValue(String value) {
        return new JAXBElement<String>(_ItemProcessYieldLocatorValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefectTrackingOnFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemDefectTrackingOnFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemDefectTrackingOnFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ForecastHorizon", scope = Item.class)
    public JAXBElement<BigDecimal> createItemForecastHorizon(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemForecastHorizon_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DaysMaximumInventorySupply", scope = Item.class)
    public JAXBElement<BigDecimal> createItemDaysMaximumInventorySupply(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemDaysMaximumInventorySupply_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemStatusValue", scope = Item.class)
    public JAXBElement<String> createItemItemStatusValue(String value) {
        return new JAXBElement<String>(_ItemItemStatusValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "HazardClassValue", scope = Item.class)
    public JAXBElement<String> createItemHazardClassValue(String value) {
        return new JAXBElement<String>(_ItemHazardClassValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnitOfIssueValue", scope = Item.class)
    public JAXBElement<String> createItemUnitOfIssueValue(String value) {
        return new JAXBElement<String>(_ItemUnitOfIssueValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VariableLeadTime", scope = Item.class)
    public JAXBElement<BigDecimal> createItemVariableLeadTime(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemVariableLeadTime_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReceiptDateActionValue", scope = Item.class)
    public JAXBElement<String> createItemReceiptDateActionValue(String value) {
        return new JAXBElement<String>(_ItemReceiptDateActionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceBillingEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemServiceBillingEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemServiceBillingEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "NegativeMeasurementError", scope = Item.class)
    public JAXBElement<BigDecimal> createItemNegativeMeasurementError(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemNegativeMeasurementError_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OrganizationCode", scope = Item.class)
    public JAXBElement<String> createItemOrganizationCode(String value) {
        return new JAXBElement<String>(_ItemOrganizationCode_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StartingLotNumber", scope = Item.class)
    public JAXBElement<String> createItemStartingLotNumber(String value) {
        return new JAXBElement<String>(_ItemStartingLotNumber_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReleaseAuthorizationRequiredValue", scope = Item.class)
    public JAXBElement<String> createItemReleaseAuthorizationRequiredValue(String value) {
        return new JAXBElement<String>(_ItemReleaseAuthorizationRequiredValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LeadTimeLotSize", scope = Item.class)
    public JAXBElement<BigDecimal> createItemLeadTimeLotSize(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemLeadTimeLotSize_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SecondaryUnitofMeasureValue", scope = Item.class)
    public JAXBElement<String> createItemSecondaryUnitofMeasureValue(String value) {
        return new JAXBElement<String>(_ItemSecondaryUnitofMeasureValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VolumeUOMValue", scope = Item.class)
    public JAXBElement<String> createItemVolumeUOMValue(String value) {
        return new JAXBElement<String>(_ItemVolumeUOMValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "QuantityReceivedToleranceAction", scope = Item.class)
    public JAXBElement<String> createItemQuantityReceivedToleranceAction(String value) {
        return new JAXBElement<String>(_ItemQuantityReceivedToleranceAction_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ContainerTypeValue", scope = Item.class)
    public JAXBElement<String> createItemContainerTypeValue(String value) {
        return new JAXBElement<String>(_ItemContainerTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowUnorderedReceiptsFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowUnorderedReceiptsFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowUnorderedReceiptsFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SubstitutionDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemSubstitutionDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemSubstitutionDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultLotStatusValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultLotStatusValue(String value) {
        return new JAXBElement<String>(_ItemDefaultLotStatusValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "NegativeDeviationFactor", scope = Item.class)
    public JAXBElement<BigDecimal> createItemNegativeDeviationFactor(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemNegativeDeviationFactor_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PlanningMethodValue", scope = Item.class)
    public JAXBElement<String> createItemPlanningMethodValue(String value) {
        return new JAXBElement<String>(_ItemPlanningMethodValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DemandTimeFence", scope = Item.class)
    public JAXBElement<String> createItemDemandTimeFence(String value) {
        return new JAXBElement<String>(_ItemDemandTimeFence_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VersionPlannedEffectiveDateTime", scope = Item.class)
    public JAXBElement<XMLGregorianCalendar> createItemVersionPlannedEffectiveDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemVersionPlannedEffectiveDateTime_QNAME, XMLGregorianCalendar.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CASNumber", scope = Item.class)
    public JAXBElement<String> createItemCASNumber(String value) {
        return new JAXBElement<String>(_ItemCASNumber_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ShipModelCompleteFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemShipModelCompleteFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemShipModelCompleteFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MinimumMinmaxQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemMinimumMinmaxQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemMinimumMinmaxQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "WeightUOMValue", scope = Item.class)
    public JAXBElement<String> createItemWeightUOMValue(String value) {
        return new JAXBElement<String>(_ItemWeightUOMValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PriceTolerancePercentage", scope = Item.class)
    public JAXBElement<BigDecimal> createItemPriceTolerancePercentage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemPriceTolerancePercentage_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RoundingControlTypeFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRoundingControlTypeFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRoundingControlTypeFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "BackToBackEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemBackToBackEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemBackToBackEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "BaseItemValue", scope = Item.class)
    public JAXBElement<String> createItemBaseItemValue(String value) {
        return new JAXBElement<String>(_ItemBaseItemValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultingControlValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultingControlValue(String value) {
        return new JAXBElement<String>(_ItemDefaultingControlValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UNNumberValue", scope = Item.class)
    public JAXBElement<String> createItemUNNumberValue(String value) {
        return new JAXBElement<String>(_ItemUNNumberValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "NegotiationRequiredFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemNegotiationRequiredFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemNegotiationRequiredFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VersionStatus", scope = Item.class)
    public JAXBElement<String> createItemVersionStatus(String value) {
        return new JAXBElement<String>(_ItemVersionStatus_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "BackOrderableFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemBackOrderableFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemBackOrderableFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CumulativeManufacturingLeadTime", scope = Item.class)
    public JAXBElement<BigDecimal> createItemCumulativeManufacturingLeadTime(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemCumulativeManufacturingLeadTime_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultShippingOrganizationValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultShippingOrganizationValue(String value) {
        return new JAXBElement<String>(_ItemDefaultShippingOrganizationValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DaysEarlyReceiptAllowed", scope = Item.class)
    public JAXBElement<BigDecimal> createItemDaysEarlyReceiptAllowed(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemDaysEarlyReceiptAllowed_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChildLotEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemChildLotEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemChildLotEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RecoveredPartDispositionValue", scope = Item.class)
    public JAXBElement<String> createItemRecoveredPartDispositionValue(String value) {
        return new JAXBElement<String>(_ItemRecoveredPartDispositionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PaymentTermsValue", scope = Item.class)
    public JAXBElement<String> createItemPaymentTermsValue(String value) {
        return new JAXBElement<String>(_ItemPaymentTermsValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AssetActivityShutdownTypeValue", scope = Item.class)
    public JAXBElement<String> createItemAssetActivityShutdownTypeValue(String value) {
        return new JAXBElement<String>(_ItemAssetActivityShutdownTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "WebStatusValue", scope = Item.class)
    public JAXBElement<String> createItemWebStatusValue(String value) {
        return new JAXBElement<String>(_ItemWebStatusValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AcceptableEarlyDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemAcceptableEarlyDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemAcceptableEarlyDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChildLotParent", scope = Item.class)
    public JAXBElement<String> createItemChildLotParent(String value) {
        return new JAXBElement<String>(_ItemChildLotParent_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SerialStatusEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemSerialStatusEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemSerialStatusEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AssetCategoryValue", scope = Item.class)
    public JAXBElement<String> createItemAssetCategoryValue(String value) {
        return new JAXBElement<String>(_ItemAssetCategoryValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RestrictLocatorsFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRestrictLocatorsFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRestrictLocatorsFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CarryPercentage", scope = Item.class)
    public JAXBElement<BigDecimal> createItemCarryPercentage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemCarryPercentage_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaximumOrder", scope = Item.class)
    public JAXBElement<BigDecimal> createItemMaximumOrder(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemMaximumOrder_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "TaxableFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemTaxableFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemTaxableFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnderShipmentTolerance", scope = Item.class)
    public JAXBElement<BigDecimal> createItemUnderShipmentTolerance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemUnderShipmentTolerance_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LastSubmittedNewItemRequest", scope = Item.class)
    public JAXBElement<String> createItemLastSubmittedNewItemRequest(String value) {
        return new JAXBElement<String>(_ItemLastSubmittedNewItemRequest_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ShrinkageRate", scope = Item.class)
    public JAXBElement<BigDecimal> createItemShrinkageRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemShrinkageRate_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StructureItemTypeValue", scope = Item.class)
    public JAXBElement<String> createItemStructureItemTypeValue(String value) {
        return new JAXBElement<String>(_ItemStructureItemTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessSupplyLocatorValue", scope = Item.class)
    public JAXBElement<String> createItemProcessSupplyLocatorValue(String value) {
        return new JAXBElement<String>(_ItemProcessSupplyLocatorValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EAMActivityTypeValue", scope = Item.class)
    public JAXBElement<String> createItemEAMActivityTypeValue(String value) {
        return new JAXBElement<String>(_ItemEAMActivityTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VehicleItemFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemVehicleItemFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemVehicleItemFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyFromVersionValue", scope = Item.class)
    public JAXBElement<String> createItemCopyFromVersionValue(String value) {
        return new JAXBElement<String>(_ItemCopyFromVersionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotDivisibleFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemLotDivisibleFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemLotDivisibleFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowSubstituteReceiptsFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowSubstituteReceiptsFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowSubstituteReceiptsFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ExpirationActionInterval", scope = Item.class)
    public JAXBElement<BigDecimal> createItemExpirationActionInterval(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemExpirationActionInterval_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "WIPSupplySubinventoryValue", scope = Item.class)
    public JAXBElement<String> createItemWIPSupplySubinventoryValue(String value) {
        return new JAXBElement<String>(_ItemWIPSupplySubinventoryValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReceiptRountingValue", scope = Item.class)
    public JAXBElement<String> createItemReceiptRountingValue(String value) {
        return new JAXBElement<String>(_ItemReceiptRountingValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChildLotFormatValidationFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemChildLotFormatValidationFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemChildLotFormatValidationFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EffectivityControlValue", scope = Item.class)
    public JAXBElement<String> createItemEffectivityControlValue(String value) {
        return new JAXBElement<String>(_ItemEffectivityControlValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SalesAccountValue", scope = Item.class)
    public JAXBElement<String> createItemSalesAccountValue(String value) {
        return new JAXBElement<String>(_ItemSalesAccountValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessingDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemProcessingDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemProcessingDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceStartTypeValue", scope = Item.class)
    public JAXBElement<String> createItemServiceStartTypeValue(String value) {
        return new JAXBElement<String>(_ItemServiceStartTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceRequestEnabledValue", scope = Item.class)
    public JAXBElement<String> createItemServiceRequestEnabledValue(String value) {
        return new JAXBElement<String>(_ItemServiceRequestEnabledValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StyleItemNumberValue", scope = Item.class)
    public JAXBElement<String> createItemStyleItemNumberValue(String value) {
        return new JAXBElement<String>(_ItemStyleItemNumberValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChildLotStartingNumber", scope = Item.class)
    public JAXBElement<BigDecimal> createItemChildLotStartingNumber(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemChildLotStartingNumber_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "HazardousMaterialFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemHazardousMaterialFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemHazardousMaterialFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PlanningTimeDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemPlanningTimeDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemPlanningTimeDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StandardLotSize", scope = Item.class)
    public JAXBElement<BigDecimal> createItemStandardLotSize(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemStandardLotSize_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MarketPrice", scope = Item.class)
    public JAXBElement<AmountType> createItemMarketPrice(AmountType value) {
        return new JAXBElement<AmountType>(_ItemMarketPrice_QNAME, AmountType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemNumber", scope = Item.class)
    public JAXBElement<String> createItemItemNumber(String value) {
        return new JAXBElement<String>(_ItemItemNumber_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceDurationPeriodValue", scope = Item.class)
    public JAXBElement<String> createItemServiceDurationPeriodValue(String value) {
        return new JAXBElement<String>(_ItemServiceDurationPeriodValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotControlValue", scope = Item.class)
    public JAXBElement<String> createItemLotControlValue(String value) {
        return new JAXBElement<String>(_ItemLotControlValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ATPValue", scope = Item.class)
    public JAXBElement<String> createItemATPValue(String value) {
        return new JAXBElement<String>(_ItemATPValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "GradeControlFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemGradeControlFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemGradeControlFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultSalesOrderSourceTypeValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultSalesOrderSourceTypeValue(String value) {
        return new JAXBElement<String>(_ItemDefaultSalesOrderSourceTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EnableGenealogyTrackingFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemEnableGenealogyTrackingFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemEnableGenealogyTrackingFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "TransactionConversionValue", scope = Item.class)
    public JAXBElement<String> createItemTransactionConversionValue(String value) {
        return new JAXBElement<String>(_ItemTransactionConversionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReplenishmentType", scope = Item.class)
    public JAXBElement<String> createItemReplenishmentType(String value) {
        return new JAXBElement<String>(_ItemReplenishmentType_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CumulativeTotalLeadTime", scope = Item.class)
    public JAXBElement<BigDecimal> createItemCumulativeTotalLeadTime(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemCumulativeTotalLeadTime_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "InstanceClassValue", scope = Item.class)
    public JAXBElement<String> createItemInstanceClassValue(String value) {
        return new JAXBElement<String>(_ItemInstanceClassValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CriticalComponentFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCriticalComponentFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCriticalComponentFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ConsignedFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemConsignedFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemConsignedFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotExpirationControlValue", scope = Item.class)
    public JAXBElement<String> createItemLotExpirationControlValue(String value) {
        return new JAXBElement<String>(_ItemLotExpirationControlValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DimensionUOMValue", scope = Item.class)
    public JAXBElement<String> createItemDimensionUOMValue(String value) {
        return new JAXBElement<String>(_ItemDimensionUOMValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "WarehouseEquipmentFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemWarehouseEquipmentFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemWarehouseEquipmentFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ExpirationActionValue", scope = Item.class)
    public JAXBElement<String> createItemExpirationActionValue(String value) {
        return new JAXBElement<String>(_ItemExpirationActionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReservableFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemReservableFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemReservableFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ShelfLifeDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemShelfLifeDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemShelfLifeDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FinancingAllowedFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemFinancingAllowedFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemFinancingAllowedFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DaysOfCover", scope = Item.class)
    public JAXBElement<BigDecimal> createItemDaysOfCover(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemDaysOfCover_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChangeNotice", scope = Item.class)
    public JAXBElement<String> createItemChangeNotice(String value) {
        return new JAXBElement<String>(_ItemChangeNotice_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "InternalVolume", scope = Item.class)
    public JAXBElement<BigDecimal> createItemInternalVolume(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemInternalVolume_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnitLengthQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemUnitLengthQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemUnitLengthQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Template", scope = Item.class)
    public JAXBElement<String> createItemTemplate(String value) {
        return new JAXBElement<String>(_ItemTemplate_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnitWidthQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemUnitWidthQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemUnitWidthQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyLotAttributeFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCopyLotAttributeFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCopyLotAttributeFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MRPCalculateATPFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemMRPCalculateATPFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemMRPCalculateATPFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessQualityEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemProcessQualityEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemProcessQualityEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PositiveMeasurementError", scope = Item.class)
    public JAXBElement<BigDecimal> createItemPositiveMeasurementError(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemPositiveMeasurementError_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "QuantityReceivedTolerancePercentage", scope = Item.class)
    public JAXBElement<BigDecimal> createItemQuantityReceivedTolerancePercentage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemQuantityReceivedTolerancePercentage_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SafetyStockPlanningMethodValue", scope = Item.class)
    public JAXBElement<String> createItemSafetyStockPlanningMethodValue(String value) {
        return new JAXBElement<String>(_ItemSafetyStockPlanningMethodValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StartingLotPrefix", scope = Item.class)
    public JAXBElement<String> createItemStartingLotPrefix(String value) {
        return new JAXBElement<String>(_ItemStartingLotPrefix_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OrderManagementIndivisibleFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemOrderManagementIndivisibleFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemOrderManagementIndivisibleFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SubstitutionWindow", scope = Item.class)
    public JAXBElement<String> createItemSubstitutionWindow(String value) {
        return new JAXBElement<String>(_ItemSubstitutionWindow_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DemandPeriod", scope = Item.class)
    public JAXBElement<BigDecimal> createItemDemandPeriod(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemDemandPeriod_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowTerminateFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowTerminateFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowTerminateFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PlannedInventoryPointFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemPlannedInventoryPointFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemPlannedInventoryPointFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FormattedDescription", scope = Item.class)
    public JAXBElement<String> createItemFormattedDescription(String value) {
        return new JAXBElement<String>(_ItemFormattedDescription_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MatchConfigurationOptionValue", scope = Item.class)
    public JAXBElement<String> createItemMatchConfigurationOptionValue(String value) {
        return new JAXBElement<String>(_ItemMatchConfigurationOptionValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaximumLoadWeight", scope = Item.class)
    public JAXBElement<BigDecimal> createItemMaximumLoadWeight(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemMaximumLoadWeight_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VersionDescription", scope = Item.class)
    public JAXBElement<String> createItemVersionDescription(String value) {
        return new JAXBElement<String>(_ItemVersionDescription_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OutsideProcessServiceFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemOutsideProcessServiceFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemOutsideProcessServiceFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DemandTimeDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemDemandTimeDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemDemandTimeDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Planner", scope = Item.class)
    public JAXBElement<String> createItemPlanner(String value) {
        return new JAXBElement<String>(_ItemPlanner_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "IgnoreDuplicateItemFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemIgnoreDuplicateItemFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemIgnoreDuplicateItemFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceDuration", scope = Item.class)
    public JAXBElement<BigDecimal> createItemServiceDuration(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemServiceDuration_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AssetActivityCauseValue", scope = Item.class)
    public JAXBElement<String> createItemAssetActivityCauseValue(String value) {
        return new JAXBElement<String>(_ItemAssetActivityCauseValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CollateralFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCollateralFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCollateralFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "InventoryPlanningMethodValue", scope = Item.class)
    public JAXBElement<String> createItemInventoryPlanningMethodValue(String value) {
        return new JAXBElement<String>(_ItemInventoryPlanningMethodValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LongDescription", scope = Item.class)
    public JAXBElement<String> createItemLongDescription(String value) {
        return new JAXBElement<String>(_ItemLongDescription_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceStartDelay", scope = Item.class)
    public JAXBElement<BigDecimal> createItemServiceStartDelay(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemServiceStartDelay_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyAttachmentsFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCopyAttachmentsFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCopyAttachmentsFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PurchasingInputTaxClassificationValue", scope = Item.class)
    public JAXBElement<String> createItemPurchasingInputTaxClassificationValue(String value) {
        return new JAXBElement<String>(_ItemPurchasingInputTaxClassificationValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LifecyclePhaseValue", scope = Item.class)
    public JAXBElement<String> createItemLifecyclePhaseValue(String value) {
        return new JAXBElement<String>(_ItemLifecyclePhaseValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EventFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemEventFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemEventFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OrderableOnWebFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemOrderableOnWebFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemOrderableOnWebFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UOMPricingValue", scope = Item.class)
    public JAXBElement<String> createItemUOMPricingValue(String value) {
        return new JAXBElement<String>(_ItemUOMPricingValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReplenishmentMinimumDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemReplenishmentMinimumDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemReplenishmentMinimumDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyOrganizationAssignmentsFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCopyOrganizationAssignmentsFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCopyOrganizationAssignmentsFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemClass", scope = Item.class)
    public JAXBElement<String> createItemItemClass(String value) {
        return new JAXBElement<String>(_ItemItemClass_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ServiceDurationTypeValue", scope = Item.class)
    public JAXBElement<String> createItemServiceDurationTypeValue(String value) {
        return new JAXBElement<String>(_ItemServiceDurationTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnitWeightQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemUnitWeightQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemUnitWeightQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CommsActivationReqdFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCommsActivationReqdFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCommsActivationReqdFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PackTypeValue", scope = Item.class)
    public JAXBElement<String> createItemPackTypeValue(String value) {
        return new JAXBElement<String>(_ItemPackTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaximumMinmaxQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemMaximumMinmaxQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemMaximumMinmaxQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowMaintenanceAssetFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowMaintenanceAssetFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowMaintenanceAssetFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RepairLeadtime", scope = Item.class)
    public JAXBElement<BigDecimal> createItemRepairLeadtime(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemRepairLeadtime_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EAMActivityNotificationFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemEAMActivityNotificationFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemEAMActivityNotificationFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RequiresFulfillmentLocFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRequiresFulfillmentLocFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRequiresFulfillmentLocFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OutsideProcessingUnitTypeValue", scope = Item.class)
    public JAXBElement<String> createItemOutsideProcessingUnitTypeValue(String value) {
        return new JAXBElement<String>(_ItemOutsideProcessingUnitTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AssetClassValue", scope = Item.class)
    public JAXBElement<String> createItemAssetClassValue(String value) {
        return new JAXBElement<String>(_ItemAssetClassValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UnitHeightQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemUnitHeightQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemUnitHeightQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemExtensibleFlexfieldCategoryCode", scope = Item.class)
    public JAXBElement<String> createItemItemExtensibleFlexfieldCategoryCode(String value) {
        return new JAXBElement<String>(_ItemItemExtensibleFlexfieldCategoryCode_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Pegging", scope = Item.class)
    public JAXBElement<String> createItemPegging(String value) {
        return new JAXBElement<String>(_ItemPegging_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ChildLotPrefix", scope = Item.class)
    public JAXBElement<String> createItemChildLotPrefix(String value) {
        return new JAXBElement<String>(_ItemChildLotPrefix_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultGradeValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultGradeValue(String value) {
        return new JAXBElement<String>(_ItemDefaultGradeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ApprovalStatusValue", scope = Item.class)
    public JAXBElement<String> createItemApprovalStatusValue(String value) {
        return new JAXBElement<String>(_ItemApprovalStatusValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "BuyerOrganizationValue", scope = Item.class)
    public JAXBElement<String> createItemBuyerOrganizationValue(String value) {
        return new JAXBElement<String>(_ItemBuyerOrganizationValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UserItemTypeValue", scope = Item.class)
    public JAXBElement<String> createItemUserItemTypeValue(String value) {
        return new JAXBElement<String>(_ItemUserItemTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PlanningTimeFence", scope = Item.class)
    public JAXBElement<String> createItemPlanningTimeFence(String value) {
        return new JAXBElement<String>(_ItemPlanningTimeFence_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SalesProductTypeValue", scope = Item.class)
    public JAXBElement<String> createItemSalesProductTypeValue(String value) {
        return new JAXBElement<String>(_ItemSalesProductTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "InventoryCarryPenalty", scope = Item.class)
    public JAXBElement<BigDecimal> createItemInventoryCarryPenalty(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemInventoryCarryPenalty_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotStatusEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemLotStatusEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemLotStatusEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EligibilityRuleFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemEligibilityRuleFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemEligibilityRuleFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReplenishmentMinimumOrder", scope = Item.class)
    public JAXBElement<BigDecimal> createItemReplenishmentMinimumOrder(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemReplenishmentMinimumOrder_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultSerialStatusValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultSerialStatusValue(String value) {
        return new JAXBElement<String>(_ItemDefaultSerialStatusValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "BulkPickedFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemBulkPickedFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemBulkPickedFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OverShipmentTolerance", scope = Item.class)
    public JAXBElement<BigDecimal> createItemOverShipmentTolerance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemOverShipmentTolerance_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ExcludeFromBudgetFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemExcludeFromBudgetFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemExcludeFromBudgetFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AllowItemDescriptionUpdateFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAllowItemDescriptionUpdateFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAllowItemDescriptionUpdateFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EngineeredItemFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemEngineeredItemFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemEngineeredItemFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SourceSubinventoryValue", scope = Item.class)
    public JAXBElement<String> createItemSourceSubinventoryValue(String value) {
        return new JAXBElement<String>(_ItemSourceSubinventoryValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PreprocessingDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemPreprocessingDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemPreprocessingDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RequiresItemAssociationFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRequiresItemAssociationFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRequiresItemAssociationFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OrderCost", scope = Item.class)
    public JAXBElement<BigDecimal> createItemOrderCost(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemOrderCost_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotMergeEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemLotMergeEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemLotMergeEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OvercompletionToleranceValue", scope = Item.class)
    public JAXBElement<BigDecimal> createItemOvercompletionToleranceValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemOvercompletionToleranceValue_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MinimumFillPercent", scope = Item.class)
    public JAXBElement<BigDecimal> createItemMinimumFillPercent(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemMinimumFillPercent_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReleaseTimeDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemReleaseTimeDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemReleaseTimeDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyCategoriesFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCopyCategoriesFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCopyCategoriesFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DRPPlannedFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemDRPPlannedFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemDRPPlannedFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RecipeEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRecipeEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRecipeEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PostprocessingDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemPostprocessingDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemPostprocessingDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CreateSupplyFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCreateSupplyFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCreateSupplyFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RetestInterval", scope = Item.class)
    public JAXBElement<BigDecimal> createItemRetestInterval(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemRetestInterval_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ContainerItemFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemContainerItemFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemContainerItemFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "TargetInventoryDaysofSupply", scope = Item.class)
    public JAXBElement<BigDecimal> createItemTargetInventoryDaysofSupply(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemTargetInventoryDaysofSupply_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "TagetInventoryWindow", scope = Item.class)
    public JAXBElement<BigDecimal> createItemTagetInventoryWindow(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemTagetInventoryWindow_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DownloadableFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemDownloadableFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemDownloadableFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DaysLateReceiptAllowed", scope = Item.class)
    public JAXBElement<BigDecimal> createItemDaysLateReceiptAllowed(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemDaysLateReceiptAllowed_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "InvoicingRuleValue", scope = Item.class)
    public JAXBElement<String> createItemInvoicingRuleValue(String value) {
        return new JAXBElement<String>(_ItemInvoicingRuleValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SourceSubinventoryOrganizationValue", scope = Item.class)
    public JAXBElement<String> createItemSourceSubinventoryOrganizationValue(String value) {
        return new JAXBElement<String>(_ItemSourceSubinventoryOrganizationValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MatchApprovalLevelValue", scope = Item.class)
    public JAXBElement<String> createItemMatchApprovalLevelValue(String value) {
        return new JAXBElement<String>(_ItemMatchApprovalLevelValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "InvoiceCloseTolerancePercentage", scope = Item.class)
    public JAXBElement<BigDecimal> createItemInvoiceCloseTolerancePercentage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemInvoiceCloseTolerancePercentage_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "TrackingUnitofMeasure", scope = Item.class)
    public JAXBElement<String> createItemTrackingUnitofMeasure(String value) {
        return new JAXBElement<String>(_ItemTrackingUnitofMeasure_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OperationSlackPenalty", scope = Item.class)
    public JAXBElement<BigDecimal> createItemOperationSlackPenalty(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemOperationSlackPenalty_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ForecastControlValue", scope = Item.class)
    public JAXBElement<String> createItemForecastControlValue(String value) {
        return new JAXBElement<String>(_ItemForecastControlValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DefaultBuyerValue", scope = Item.class)
    public JAXBElement<String> createItemDefaultBuyerValue(String value) {
        return new JAXBElement<String>(_ItemDefaultBuyerValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SourceOrganizationValue", scope = Item.class)
    public JAXBElement<String> createItemSourceOrganizationValue(String value) {
        return new JAXBElement<String>(_ItemSourceOrganizationValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FixedDaysSupply", scope = Item.class)
    public JAXBElement<BigDecimal> createItemFixedDaysSupply(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemFixedDaysSupply_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReceiptCloseTolerancePercentage", scope = Item.class)
    public JAXBElement<BigDecimal> createItemReceiptCloseTolerancePercentage(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemReceiptCloseTolerancePercentage_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RevisionQuantityControlFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemRevisionQuantityControlFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemRevisionQuantityControlFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MinimumOrderQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemMinimumOrderQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemMinimumOrderQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RevisionForVersion", scope = Item.class)
    public JAXBElement<String> createItemRevisionForVersion(String value) {
        return new JAXBElement<String>(_ItemRevisionForVersion_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StockLocatorControlValue", scope = Item.class)
    public JAXBElement<String> createItemStockLocatorControlValue(String value) {
        return new JAXBElement<String>(_ItemStockLocatorControlValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ReleaseTimeFence", scope = Item.class)
    public JAXBElement<String> createItemReleaseTimeFence(String value) {
        return new JAXBElement<String>(_ItemReleaseTimeFence_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CopyFromItemValue", scope = Item.class)
    public JAXBElement<String> createItemCopyFromItemValue(String value) {
        return new JAXBElement<String>(_ItemCopyFromItemValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SerialStartingNumber", scope = Item.class)
    public JAXBElement<String> createItemSerialStartingNumber(String value) {
        return new JAXBElement<String>(_ItemSerialStartingNumber_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FixedLeadTime", scope = Item.class)
    public JAXBElement<BigDecimal> createItemFixedLeadTime(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemFixedLeadTime_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EAMActivitySourceValue", scope = Item.class)
    public JAXBElement<String> createItemEAMActivitySourceValue(String value) {
        return new JAXBElement<String>(_ItemEAMActivitySourceValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SubcontractingComponentValue", scope = Item.class)
    public JAXBElement<String> createItemSubcontractingComponentValue(String value) {
        return new JAXBElement<String>(_ItemSubcontractingComponentValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AutomaticallyExpireASNFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAutomaticallyExpireASNFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAutomaticallyExpireASNFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "BillingTypeValue", scope = Item.class)
    public JAXBElement<String> createItemBillingTypeValue(String value) {
        return new JAXBElement<String>(_ItemBillingTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "HoldDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemHoldDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemHoldDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "SerialGenerationValue", scope = Item.class)
    public JAXBElement<String> createItemSerialGenerationValue(String value) {
        return new JAXBElement<String>(_ItemSerialGenerationValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StyleItemFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemStyleItemFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemStyleItemFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PositiveDeviationFactor", scope = Item.class)
    public JAXBElement<BigDecimal> createItemPositiveDeviationFactor(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemPositiveDeviationFactor_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotSubstitutionEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemLotSubstitutionEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemLotSubstitutionEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ContractManufacturingFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemContractManufacturingFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemContractManufacturingFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "TrackInstalledBaseFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemTrackInstalledBaseFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemTrackInstalledBaseFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PickingRuleValue", scope = Item.class)
    public JAXBElement<String> createItemPickingRuleValue(String value) {
        return new JAXBElement<String>(_ItemPickingRuleValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AccountingRuleValue", scope = Item.class)
    public JAXBElement<String> createItemAccountingRuleValue(String value) {
        return new JAXBElement<String>(_ItemAccountingRuleValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ATPComponentsValue", scope = Item.class)
    public JAXBElement<String> createItemATPComponentsValue(String value) {
        return new JAXBElement<String>(_ItemATPComponentsValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ElectronicFormatFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemElectronicFormatFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemElectronicFormatFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaximumInventoryWindow", scope = Item.class)
    public JAXBElement<BigDecimal> createItemMaximumInventoryWindow(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemMaximumInventoryWindow_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "PrimaryUOMValue", scope = Item.class)
    public JAXBElement<String> createItemPrimaryUOMValue(String value) {
        return new JAXBElement<String>(_ItemPrimaryUOMValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "VMIFixedOrderQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemVMIFixedOrderQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemVMIFixedOrderQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OverReturnTolerance", scope = Item.class)
    public JAXBElement<BigDecimal> createItemOverReturnTolerance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemOverReturnTolerance_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessYieldSubinventoryValue", scope = Item.class)
    public JAXBElement<String> createItemProcessYieldSubinventoryValue(String value) {
        return new JAXBElement<String>(_ItemProcessYieldSubinventoryValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AssetTrackedFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemAssetTrackedFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemAssetTrackedFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "AssetItemTypeValue", scope = Item.class)
    public JAXBElement<String> createItemAssetItemTypeValue(String value) {
        return new JAXBElement<String>(_ItemAssetItemTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "WIPSupplyTypeValue", scope = Item.class)
    public JAXBElement<String> createItemWIPSupplyTypeValue(String value) {
        return new JAXBElement<String>(_ItemWIPSupplyTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MaturityDays", scope = Item.class)
    public JAXBElement<BigDecimal> createItemMaturityDays(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemMaturityDays_QNAME, BigDecimal.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FixedOrderQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemFixedOrderQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemFixedOrderQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LotTranslateEnabledFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemLotTranslateEnabledFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemLotTranslateEnabledFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RepairProgramValue", scope = Item.class)
    public JAXBElement<String> createItemRepairProgramValue(String value) {
        return new JAXBElement<String>(_ItemRepairProgramValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OutputTaxClassificationCodeValue", scope = Item.class)
    public JAXBElement<String> createItemOutputTaxClassificationCodeValue(String value) {
        return new JAXBElement<String>(_ItemOutputTaxClassificationCodeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ListPrice", scope = Item.class)
    public JAXBElement<AmountType> createItemListPrice(AmountType value) {
        return new JAXBElement<AmountType>(_ItemListPrice_QNAME, AmountType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EnforceShipToLocation", scope = Item.class)
    public JAXBElement<String> createItemEnforceShipToLocation(String value) {
        return new JAXBElement<String>(_ItemEnforceShipToLocation_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "StandardCoverage", scope = Item.class)
    public JAXBElement<String> createItemStandardCoverage(String value) {
        return new JAXBElement<String>(_ItemStandardCoverage_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ConfigModelTypeValue", scope = Item.class)
    public JAXBElement<String> createItemConfigModelTypeValue(String value) {
        return new JAXBElement<String>(_ItemConfigModelTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ExpenseAccountValue", scope = Item.class)
    public JAXBElement<String> createItemExpenseAccountValue(String value) {
        return new JAXBElement<String>(_ItemExpenseAccountValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "IncludeInRollUpFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemIncludeInRollUpFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemIncludeInRollUpFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "MinimumLicenseQuantity", scope = Item.class)
    public JAXBElement<MeasureType> createItemMinimumLicenseQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_ItemMinimumLicenseQuantity_QNAME, MeasureType.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CreateConfiguredItem", scope = Item.class)
    public JAXBElement<String> createItemCreateConfiguredItem(String value) {
        return new JAXBElement<String>(_ItemCreateConfiguredItem_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OvercompletionToleranceTypeValue", scope = Item.class)
    public JAXBElement<String> createItemOvercompletionToleranceTypeValue(String value) {
        return new JAXBElement<String>(_ItemOvercompletionToleranceTypeValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CreateFixedAssetFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemCreateFixedAssetFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemCreateFixedAssetFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "OutsourcedAssemblyFlag", scope = Item.class)
    public JAXBElement<Boolean> createItemOutsourcedAssemblyFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ItemOutsourcedAssemblyFlag_QNAME, Boolean.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Version", scope = Item.class)
    public JAXBElement<String> createItemVersion(String value) {
        return new JAXBElement<String>(_ItemVersion_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ProcessSupplySubinventoryValue", scope = Item.class)
    public JAXBElement<String> createItemProcessSupplySubinventoryValue(String value) {
        return new JAXBElement<String>(_ItemProcessSupplySubinventoryValue_QNAME, String.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RevisionReasonValue", scope = ItemRevision.class)
    public JAXBElement<String> createItemRevisionRevisionReasonValue(String value) {
        return new JAXBElement<String>(_ItemRevisionRevisionReasonValue_QNAME, String.class, ItemRevision.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "RevisionExtensibleFlexfieldCategoryCode", scope = ItemRevision.class)
    public JAXBElement<String> createItemRevisionRevisionExtensibleFlexfieldCategoryCode(String value) {
        return new JAXBElement<String>(_ItemRevisionRevisionExtensibleFlexfieldCategoryCode_QNAME, String.class, ItemRevision.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemRevisionDescription", scope = ItemRevision.class)
    public JAXBElement<String> createItemRevisionItemRevisionDescription(String value) {
        return new JAXBElement<String>(_ItemRevisionItemRevisionDescription_QNAME, String.class, ItemRevision.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "URL", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentURL(String value) {
        return new JAXBElement<String>(_ItemAttachmentURL_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UsageType", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentUsageType(String value) {
        return new JAXBElement<String>(_ItemAttachmentUsageType_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Uri", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentUri(String value) {
        return new JAXBElement<String>(_ItemAttachmentUri_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Attachment", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentAttachment(String value) {
        return new JAXBElement<String>(_ItemAttachmentAttachment_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Title", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentTitle(String value) {
        return new JAXBElement<String>(_ItemAttachmentTitle_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DocumentURL", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDocumentURL(String value) {
        return new JAXBElement<String>(_ItemAttachmentDocumentURL_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FileName", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentFileName(String value) {
        return new JAXBElement<String>(_ItemAttachmentFileName_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmNode", scope = ItemAttachment.class)
    public JAXBElement<Long> createItemAttachmentDmNode(Long value) {
        return new JAXBElement<Long>(_ItemAttachmentDmNode_QNAME, Long.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Description", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDescription(String value) {
        return new JAXBElement<String>(_ItemAttachmentDescription_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Status", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentStatus(String value) {
        return new JAXBElement<String>(_ItemAttachmentStatus_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DocumentAttributes", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDocumentAttributes(String value) {
        return new JAXBElement<String>(_ItemAttachmentDocumentAttributes_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DocumentEntityId", scope = ItemAttachment.class)
    public JAXBElement<Long> createItemAttachmentDocumentEntityId(Long value) {
        return new JAXBElement<Long>(_ItemAttachmentDocumentEntityId_QNAME, Long.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DatabaseDescription", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDatabaseDescription(String value) {
        return new JAXBElement<String>(_ItemAttachmentDatabaseDescription_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmVersionNumber", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDmVersionNumber(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmVersionNumber_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmRepository", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDmRepository(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmRepository_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CategoryName", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentCategoryName(String value) {
        return new JAXBElement<String>(_ItemCategoryCategoryName_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmFolderPath", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDmFolderPath(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmFolderPath_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EntityAttributes", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentEntityAttributes(String value) {
        return new JAXBElement<String>(_ItemAttachmentEntityAttributes_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DatabaseTitle", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDatabaseTitle(String value) {
        return new JAXBElement<String>(_ItemAttachmentDatabaseTitle_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FileContents", scope = ItemAttachment.class)
    public JAXBElement<byte[]> createItemAttachmentFileContents(byte[] value) {
        return new JAXBElement<byte[]>(_ItemAttachmentFileContents_QNAME, byte[].class, ItemAttachment.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmType", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDmType(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmType_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmDocumentId", scope = ItemAttachment.class)
    public JAXBElement<String> createItemAttachmentDmDocumentId(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmDocumentId_QNAME, String.class, ItemAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "ItemDescription", scope = ItemTranslation.class)
    public JAXBElement<String> createItemTranslationItemDescription(String value) {
        return new JAXBElement<String>(_ItemTranslationItemDescription_QNAME, String.class, ItemTranslation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "HTMLLongDescription", scope = ItemTranslation.class)
    public JAXBElement<String> createItemTranslationHTMLLongDescription(String value) {
        return new JAXBElement<String>(_ItemTranslationHTMLLongDescription_QNAME, String.class, ItemTranslation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "LongDescription", scope = ItemTranslation.class)
    public JAXBElement<String> createItemTranslationLongDescription(String value) {
        return new JAXBElement<String>(_ItemLongDescription_QNAME, String.class, ItemTranslation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Description", scope = ItemRevisionTranslation.class)
    public JAXBElement<String> createItemRevisionTranslationDescription(String value) {
        return new JAXBElement<String>(_ItemAttachmentDescription_QNAME, String.class, ItemRevisionTranslation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "URL", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentURL(String value) {
        return new JAXBElement<String>(_ItemAttachmentURL_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "UsageType", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentUsageType(String value) {
        return new JAXBElement<String>(_ItemAttachmentUsageType_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Uri", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentUri(String value) {
        return new JAXBElement<String>(_ItemAttachmentUri_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Attachment", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentAttachment(String value) {
        return new JAXBElement<String>(_ItemAttachmentAttachment_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FileName", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentFileName(String value) {
        return new JAXBElement<String>(_ItemAttachmentFileName_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmNode", scope = RevisionAttachment.class)
    public JAXBElement<BigDecimal> createRevisionAttachmentDmNode(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ItemAttachmentDmNode_QNAME, BigDecimal.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DatatypeCode", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDatatypeCode(String value) {
        return new JAXBElement<String>(_RevisionAttachmentDatatypeCode_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "Status", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentStatus(String value) {
        return new JAXBElement<String>(_ItemAttachmentStatus_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DocumentAttributes", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDocumentAttributes(String value) {
        return new JAXBElement<String>(_ItemAttachmentDocumentAttributes_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DatabaseDescription", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDatabaseDescription(String value) {
        return new JAXBElement<String>(_ItemAttachmentDatabaseDescription_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmVersionNumber", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDmVersionNumber(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmVersionNumber_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmRepository", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDmRepository(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmRepository_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "CategoryName", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentCategoryName(String value) {
        return new JAXBElement<String>(_ItemCategoryCategoryName_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmFolderPath", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDmFolderPath(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmFolderPath_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "EntityAttributes", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentEntityAttributes(String value) {
        return new JAXBElement<String>(_ItemAttachmentEntityAttributes_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DatabaseTitle", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDatabaseTitle(String value) {
        return new JAXBElement<String>(_ItemAttachmentDatabaseTitle_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "FileContents", scope = RevisionAttachment.class)
    public JAXBElement<byte[]> createRevisionAttachmentFileContents(byte[] value) {
        return new JAXBElement<byte[]>(_ItemAttachmentFileContents_QNAME, byte[].class, RevisionAttachment.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmType", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDmType(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmType_QNAME, String.class, RevisionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", name = "DmDocumentId", scope = RevisionAttachment.class)
    public JAXBElement<String> createRevisionAttachmentDmDocumentId(String value) {
        return new JAXBElement<String>(_ItemAttachmentDmDocumentId_QNAME, String.class, RevisionAttachment.class, value);
    }

}
