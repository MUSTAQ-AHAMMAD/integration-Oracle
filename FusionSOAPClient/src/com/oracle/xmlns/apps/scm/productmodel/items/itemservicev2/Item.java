
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;
import com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.item.categories.JItemEffCategory;
import com.oracle.xmlns.apps.scm.productmodel.items.flex.item.ItemDFF;
import com.oracle.xmlns.apps.scm.productmodel.items.flex.itemgdf.ItemGdf;


/**
 * <p>Java class for Item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrganizationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrganizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApprovalStatusValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemStatusValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LifecyclePhaseValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StyleItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StyleItemNumberValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Keyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IgnoreDuplicateItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UserItemTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LongDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FormattedDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryUOMValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackingUnitofMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UOMPricingValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionConversionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryUnitofMeasureValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultingControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PositiveDeviationFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="NegativeDeviationFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CopyItemAndApplyTemplatesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CopyAssociationsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CopyAttachmentsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CopyCategoriesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CopyFromItemValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CopyFromRevisionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CopyFromVersionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CopyOrganizationAssignmentsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VersionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="RevisionForVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VersionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VersionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VersionPlannedEffectiveDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastSubmittedNewItemRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChangeNotice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChangeOrderLineSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StructureItemTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreateConfiguredItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfigModelTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffectivityControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaseItemValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoCreatedConfigurationFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PickComponentsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AssembleToOrderFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CostingEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeInRollUpFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StandardLotSize" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InventoryAssetFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BuildInWIPFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="WIPSupplyTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WIPSupplyLocatorValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WIPSupplySubinventoryValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OvercompletionToleranceTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OvercompletionToleranceValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InventoryCarryPenalty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="OperationSlackPenalty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RecipeEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProcessQualityEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProcessCostingEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProcessExecutionEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProcessSupplySubinventoryValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessSupplyLocatorValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessYieldSubinventoryValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessYieldLocatorValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HazardousMaterialFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CASNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssetItemTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssetActivityCauseValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssetActivityShutdownTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssetTrackedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EAMActivityTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EAMActivitySourceValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EAMActivityNotificationFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AssetClassValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceRequestEnabledValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefectTrackingOnFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ServiceableProductFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CommsActivationReqdFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ServiceDurationTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceDuration" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ServiceDurationPeriodValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceStartTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceStartDelay" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AllowSuspendFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowTerminateFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RequiresFulfillmentLocFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RequiresItemAssociationFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TrackInstalledBaseFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CreateFixedAssetFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InstanceClassValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceBillingEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RecoveredPartDispositionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InventoryItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StockEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaterialTransactionEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReservableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CheckMaterialShortageFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RevisionQuantityControlFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BulkPickedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LotControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartingLotPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartingLotNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaturityDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="HoldDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LotExpirationControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShelfLifeDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RetestInterval" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ExpirationActionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpirationActionInterval" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ChildLotEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ChildLotFormatValidationFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CopyLotAttributeFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ChildLotPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChildLotStartingNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ChildLotParent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LotTranslateEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LotSplitEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LotDivisibleFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LotSubstitutionEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LotMergeEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GradeControlFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DefaultGradeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerialGenerationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerialStartingPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerialStartingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NegativeMeasurementError" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PositiveMeasurementError" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CycleCountEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LotStatusEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SerialStatusEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DefaultLotStatusValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultSerialStatusValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RestrictSubinventoriesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RestrictLocatorsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StockLocatorControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DimensionUOMValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitWidthQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="UnitLengthQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="UnitHeightQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="WeightUOMValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitWeightQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="VolumeUOMValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitVolumeQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="ContainerItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ContainerTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaximumLoadWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="VehicleItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InternalVolume" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MinimumFillPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="WarehouseEquipmentFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EventFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CollateralFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CustomerOrderFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CustomerOrderEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ATPComponentsValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PickingRuleValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RMAInspectionRequiredFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EligibilityRuleFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InternalOrderFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InternalOrderEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReturnableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ATPValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FinancingAllowedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SalesProductTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OrderManagementIndivisibleFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DefaultSalesOrderSourceTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ElectronicFormatFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShippableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DefaultShippingOrganizationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipModelCompleteFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DownloadableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OverShipmentTolerance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UnderShipmentTolerance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="OverReturnTolerance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UnderReturnTolerance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InvoicedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AccountingRuleValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentTermsValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutputTaxClassificationCodeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InvoicingRuleValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesAccountValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebStatusValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BackOrderableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OrderableOnWebFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MinimumLicenseQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="InventoryPlanningMethodValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlanningMakeBuyValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Planner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubcontractingComponentValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MinimumMinmaxQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="MaximumMinmaxQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="MinimumOrderQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="MaximumOrderQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="OrderCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CarryPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReplenishmentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceOrganizationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSubinventoryOrganizationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSubinventoryValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FixedOrderQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="FixedDaysSupply" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FixedLotSizeMultiplier" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReleaseAuthorizationRequiredValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutomaticallyExpireASNFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ConsignedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReplenishmentMinimumOrder" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReplenishmentMinimumDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MaximumOrder" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MaximumDaysOfSupply" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="VMIFixedOrderQuantity" type="{http://xmlns.oracle.com/adf/svc/types/}MeasureType" minOccurs="0"/>
 *         &lt;element name="ForecastTypelValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForecastHorizon" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PlanningMethodValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pegging" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoundingControlTypeFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CreateSupplyFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CriticalComponentFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PlanningTimeFence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DemandTimeFence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReleaseTimeFence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubstitutionWindow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShrinkageRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ForecastControlValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AcceptableEarlyDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PlannedInventoryPointFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ExcludeFromBudgetFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PlanningTimeDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DemandTimeDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ReleaseTimeDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SubstitutionDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MRPCalculateATPFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DRPPlannedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaximumInventoryWindow" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DaysMaximumInventorySupply" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TargetInventoryDaysofSupply" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TagetInventoryWindow" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RepairLeadtime" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RepairYield" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PrepositionPointFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RepairProgramValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreprocessingDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PostprocessingDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ProcessingDays" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="VariableLeadTime" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CumulativeTotalLeadTime" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FixedLeadTime" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CumulativeManufacturingLeadTime" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LeadTimeLotSize" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PurchasingFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UseApprovedSupplierFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NegotiationRequiredFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PurchasingInputTaxClassificationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitOfIssueValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceCloseTolerancePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="HazardClassValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssetCategoryValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchasableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowItemDescriptionUpdateFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TaxableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BuyerOrganizationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultBuyerValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptCloseTolerancePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UNNumberValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListPrice" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="PriceTolerancePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ExpenseAccountValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MarketPrice" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="RoundingFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="OutsourcedAssemblyFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutsideProcessingFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutsideProcessingUnitTypeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MatchApprovalLevelValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MatchConfigurationOptionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptRountingValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnforceShipToLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptDateActionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaysEarlyReceiptAllowed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DaysLateReceiptAllowed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AllowSubstituteReceiptsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowUnorderedReceiptsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowExpressDeliveryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="QuantityReceivedToleranceAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuantityReceivedTolerancePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ItemExtensibleFlexfieldCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdateDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="BackToBackEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ContractManufacturingFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DaysOfCover" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DemandPeriod" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SafetyStockPlanningMethodValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutsideProcessServiceFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowMaintenanceAssetFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EnableGenealogyTrackingFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CssEnabledFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="EngineeredItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StandardCoverage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemCategory" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}ItemCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemSupplierAssociation" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}ItemSupplierAssociation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemTranslation" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}ItemTranslation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemRevision" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}ItemRevision" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemEffCategory" type="{http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/}j_ItemEffCategory" minOccurs="0"/>
 *         &lt;element name="ItemDFF" type="{http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/}ItemDFF" minOccurs="0"/>
 *         &lt;element name="ItemGlobalDFF" type="{http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/}ItemGdf" minOccurs="0"/>
 *         &lt;element name="ItemAttachment" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}ItemAttachment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", propOrder = {
    "itemId",
    "organizationId",
    "organizationCode",
    "itemClass",
    "template",
    "itemNumber",
    "itemDescription",
    "approvalStatusValue",
    "itemStatusValue",
    "lifecyclePhaseValue",
    "styleItemFlag",
    "styleItemNumberValue",
    "keyword",
    "ignoreDuplicateItemFlag",
    "userItemTypeValue",
    "packTypeValue",
    "longDescription",
    "formattedDescription",
    "primaryUOMValue",
    "trackingUnitofMeasure",
    "uomPricingValue",
    "transactionConversionValue",
    "secondaryUnitofMeasureValue",
    "defaultingControlValue",
    "positiveDeviationFactor",
    "negativeDeviationFactor",
    "copyItemAndApplyTemplatesFlag",
    "copyAssociationsFlag",
    "copyAttachmentsFlag",
    "copyCategoriesFlag",
    "copyFromItemValue",
    "copyFromRevisionValue",
    "copyFromVersionValue",
    "copyOrganizationAssignmentsFlag",
    "versionId",
    "revisionForVersion",
    "version",
    "versionStatus",
    "versionDescription",
    "versionPlannedEffectiveDateTime",
    "lastSubmittedNewItemRequest",
    "changeNotice",
    "changeOrderLineSequenceNumber",
    "structureItemTypeValue",
    "createConfiguredItem",
    "configModelTypeValue",
    "effectivityControlValue",
    "baseItemValue",
    "autoCreatedConfigurationFlag",
    "pickComponentsFlag",
    "assembleToOrderFlag",
    "costingEnabledFlag",
    "includeInRollUpFlag",
    "standardLotSize",
    "inventoryAssetFlag",
    "buildInWIPFlag",
    "wipSupplyTypeValue",
    "wipSupplyLocatorValue",
    "wipSupplySubinventoryValue",
    "overcompletionToleranceTypeValue",
    "overcompletionToleranceValue",
    "inventoryCarryPenalty",
    "operationSlackPenalty",
    "recipeEnabledFlag",
    "processQualityEnabledFlag",
    "processCostingEnabledFlag",
    "processExecutionEnabledFlag",
    "processSupplySubinventoryValue",
    "processSupplyLocatorValue",
    "processYieldSubinventoryValue",
    "processYieldLocatorValue",
    "hazardousMaterialFlag",
    "casNumber",
    "assetItemTypeValue",
    "assetActivityCauseValue",
    "assetActivityShutdownTypeValue",
    "assetTrackedFlag",
    "eamActivityTypeValue",
    "eamActivitySourceValue",
    "eamActivityNotificationFlag",
    "assetClassValue",
    "serviceRequestEnabledValue",
    "defectTrackingOnFlag",
    "serviceableProductFlag",
    "commsActivationReqdFlag",
    "serviceDurationTypeValue",
    "serviceDuration",
    "serviceDurationPeriodValue",
    "serviceStartTypeValue",
    "serviceStartDelay",
    "allowSuspendFlag",
    "allowTerminateFlag",
    "requiresFulfillmentLocFlag",
    "requiresItemAssociationFlag",
    "trackInstalledBaseFlag",
    "createFixedAssetFlag",
    "instanceClassValue",
    "billingTypeValue",
    "serviceBillingEnabledFlag",
    "recoveredPartDispositionValue",
    "inventoryItemFlag",
    "stockEnabledFlag",
    "materialTransactionEnabledFlag",
    "reservableFlag",
    "checkMaterialShortageFlag",
    "revisionQuantityControlFlag",
    "bulkPickedFlag",
    "lotControlValue",
    "startingLotPrefix",
    "startingLotNumber",
    "maturityDays",
    "holdDays",
    "lotExpirationControlValue",
    "shelfLifeDays",
    "retestInterval",
    "expirationActionValue",
    "expirationActionInterval",
    "childLotEnabledFlag",
    "childLotFormatValidationFlag",
    "copyLotAttributeFlag",
    "childLotPrefix",
    "childLotStartingNumber",
    "childLotParent",
    "lotTranslateEnabledFlag",
    "lotSplitEnabledFlag",
    "lotDivisibleFlag",
    "lotSubstitutionEnabledFlag",
    "lotMergeEnabledFlag",
    "gradeControlFlag",
    "defaultGradeValue",
    "serialGenerationValue",
    "serialStartingPrefix",
    "serialStartingNumber",
    "negativeMeasurementError",
    "positiveMeasurementError",
    "cycleCountEnabledFlag",
    "lotStatusEnabledFlag",
    "serialStatusEnabledFlag",
    "defaultLotStatusValue",
    "defaultSerialStatusValue",
    "restrictSubinventoriesFlag",
    "restrictLocatorsFlag",
    "stockLocatorControlValue",
    "dimensionUOMValue",
    "unitWidthQuantity",
    "unitLengthQuantity",
    "unitHeightQuantity",
    "weightUOMValue",
    "unitWeightQuantity",
    "volumeUOMValue",
    "unitVolumeQuantity",
    "containerItemFlag",
    "containerTypeValue",
    "maximumLoadWeight",
    "vehicleItemFlag",
    "internalVolume",
    "minimumFillPercent",
    "warehouseEquipmentFlag",
    "eventFlag",
    "collateralFlag",
    "customerOrderFlag",
    "customerOrderEnabledFlag",
    "atpComponentsValue",
    "pickingRuleValue",
    "rmaInspectionRequiredFlag",
    "eligibilityRuleFlag",
    "internalOrderFlag",
    "internalOrderEnabledFlag",
    "returnableFlag",
    "atpValue",
    "financingAllowedFlag",
    "salesProductTypeValue",
    "transactionEnabledFlag",
    "orderManagementIndivisibleFlag",
    "defaultSalesOrderSourceTypeValue",
    "electronicFormatFlag",
    "shippableFlag",
    "defaultShippingOrganizationValue",
    "shipModelCompleteFlag",
    "downloadableFlag",
    "overShipmentTolerance",
    "underShipmentTolerance",
    "overReturnTolerance",
    "underReturnTolerance",
    "invoicedFlag",
    "accountingRuleValue",
    "paymentTermsValue",
    "outputTaxClassificationCodeValue",
    "invoiceEnabledFlag",
    "invoicingRuleValue",
    "salesAccountValue",
    "webStatusValue",
    "backOrderableFlag",
    "orderableOnWebFlag",
    "minimumLicenseQuantity",
    "inventoryPlanningMethodValue",
    "planningMakeBuyValue",
    "planner",
    "subcontractingComponentValue",
    "minimumMinmaxQuantity",
    "maximumMinmaxQuantity",
    "minimumOrderQuantity",
    "maximumOrderQuantity",
    "orderCost",
    "carryPercentage",
    "replenishmentType",
    "sourceOrganizationValue",
    "sourceSubinventoryOrganizationValue",
    "sourceSubinventoryValue",
    "fixedOrderQuantity",
    "fixedDaysSupply",
    "fixedLotSizeMultiplier",
    "releaseAuthorizationRequiredValue",
    "automaticallyExpireASNFlag",
    "consignedFlag",
    "replenishmentMinimumOrder",
    "replenishmentMinimumDays",
    "maximumOrder",
    "maximumDaysOfSupply",
    "vmiFixedOrderQuantity",
    "forecastTypelValue",
    "forecastHorizon",
    "planningMethodValue",
    "pegging",
    "roundingControlTypeFlag",
    "createSupplyFlag",
    "criticalComponentFlag",
    "planningTimeFence",
    "demandTimeFence",
    "releaseTimeFence",
    "substitutionWindow",
    "shrinkageRate",
    "forecastControlValue",
    "acceptableEarlyDays",
    "plannedInventoryPointFlag",
    "excludeFromBudgetFlag",
    "planningTimeDays",
    "demandTimeDays",
    "releaseTimeDays",
    "substitutionDays",
    "mrpCalculateATPFlag",
    "drpPlannedFlag",
    "maximumInventoryWindow",
    "daysMaximumInventorySupply",
    "targetInventoryDaysofSupply",
    "tagetInventoryWindow",
    "repairLeadtime",
    "repairYield",
    "prepositionPointFlag",
    "repairProgramValue",
    "preprocessingDays",
    "postprocessingDays",
    "processingDays",
    "variableLeadTime",
    "cumulativeTotalLeadTime",
    "fixedLeadTime",
    "cumulativeManufacturingLeadTime",
    "leadTimeLotSize",
    "purchasingFlag",
    "useApprovedSupplierFlag",
    "negotiationRequiredFlag",
    "purchasingInputTaxClassificationValue",
    "unitOfIssueValue",
    "invoiceCloseTolerancePercentage",
    "hazardClassValue",
    "assetCategoryValue",
    "purchasableFlag",
    "allowItemDescriptionUpdateFlag",
    "taxableFlag",
    "buyerOrganizationValue",
    "defaultBuyerValue",
    "receiptCloseTolerancePercentage",
    "unNumberValue",
    "listPrice",
    "priceTolerancePercentage",
    "expenseAccountValue",
    "marketPrice",
    "roundingFactor",
    "outsourcedAssemblyFlag",
    "outsideProcessingFlag",
    "outsideProcessingUnitTypeValue",
    "matchApprovalLevelValue",
    "matchConfigurationOptionValue",
    "receiptRountingValue",
    "enforceShipToLocation",
    "receiptDateActionValue",
    "daysEarlyReceiptAllowed",
    "daysLateReceiptAllowed",
    "allowSubstituteReceiptsFlag",
    "allowUnorderedReceiptsFlag",
    "allowExpressDeliveryFlag",
    "quantityReceivedToleranceAction",
    "quantityReceivedTolerancePercentage",
    "itemExtensibleFlexfieldCategoryCode",
    "creationDate",
    "lastUpdateDate",
    "backToBackEnabledFlag",
    "contractManufacturingFlag",
    "daysOfCover",
    "demandPeriod",
    "safetyStockPlanningMethodValue",
    "outsideProcessServiceFlag",
    "allowMaintenanceAssetFlag",
    "enableGenealogyTrackingFlag",
    "cssEnabledFlag",
    "engineeredItemFlag",
    "standardCoverage",
    "itemCategory",
    "itemSupplierAssociation",
    "itemTranslation",
    "itemRevision",
    "itemEffCategory",
    "itemDFF",
    "itemGlobalDFF",
    "itemAttachment"
})
public class Item {

    @XmlElement(name = "ItemId")
    protected Long itemId;
    @XmlElement(name = "OrganizationId")
    protected Long organizationId;
    @XmlElementRef(name = "OrganizationCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> organizationCode;
    @XmlElementRef(name = "ItemClass", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemClass;
    @XmlElementRef(name = "Template", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> template;
    @XmlElementRef(name = "ItemNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemNumber;
    @XmlElement(name = "ItemDescription")
    protected String itemDescription;
    @XmlElementRef(name = "ApprovalStatusValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> approvalStatusValue;
    @XmlElementRef(name = "ItemStatusValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemStatusValue;
    @XmlElementRef(name = "LifecyclePhaseValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lifecyclePhaseValue;
    @XmlElementRef(name = "StyleItemFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> styleItemFlag;
    @XmlElementRef(name = "StyleItemNumberValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> styleItemNumberValue;
    @XmlElementRef(name = "Keyword", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> keyword;
    @XmlElementRef(name = "IgnoreDuplicateItemFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> ignoreDuplicateItemFlag;
    @XmlElementRef(name = "UserItemTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userItemTypeValue;
    @XmlElementRef(name = "PackTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> packTypeValue;
    @XmlElementRef(name = "LongDescription", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> longDescription;
    @XmlElementRef(name = "FormattedDescription", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> formattedDescription;
    @XmlElementRef(name = "PrimaryUOMValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> primaryUOMValue;
    @XmlElementRef(name = "TrackingUnitofMeasure", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trackingUnitofMeasure;
    @XmlElementRef(name = "UOMPricingValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uomPricingValue;
    @XmlElementRef(name = "TransactionConversionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionConversionValue;
    @XmlElementRef(name = "SecondaryUnitofMeasureValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryUnitofMeasureValue;
    @XmlElementRef(name = "DefaultingControlValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultingControlValue;
    @XmlElementRef(name = "PositiveDeviationFactor", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> positiveDeviationFactor;
    @XmlElementRef(name = "NegativeDeviationFactor", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> negativeDeviationFactor;
    @XmlElementRef(name = "CopyItemAndApplyTemplatesFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> copyItemAndApplyTemplatesFlag;
    @XmlElementRef(name = "CopyAssociationsFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> copyAssociationsFlag;
    @XmlElementRef(name = "CopyAttachmentsFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> copyAttachmentsFlag;
    @XmlElementRef(name = "CopyCategoriesFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> copyCategoriesFlag;
    @XmlElementRef(name = "CopyFromItemValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> copyFromItemValue;
    @XmlElementRef(name = "CopyFromRevisionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> copyFromRevisionValue;
    @XmlElementRef(name = "CopyFromVersionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> copyFromVersionValue;
    @XmlElementRef(name = "CopyOrganizationAssignmentsFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> copyOrganizationAssignmentsFlag;
    @XmlElement(name = "VersionId")
    protected Long versionId;
    @XmlElementRef(name = "RevisionForVersion", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> revisionForVersion;
    @XmlElementRef(name = "Version", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> version;
    @XmlElementRef(name = "VersionStatus", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> versionStatus;
    @XmlElementRef(name = "VersionDescription", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> versionDescription;
    @XmlElementRef(name = "VersionPlannedEffectiveDateTime", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> versionPlannedEffectiveDateTime;
    @XmlElementRef(name = "LastSubmittedNewItemRequest", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastSubmittedNewItemRequest;
    @XmlElementRef(name = "ChangeNotice", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> changeNotice;
    @XmlElementRef(name = "ChangeOrderLineSequenceNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> changeOrderLineSequenceNumber;
    @XmlElementRef(name = "StructureItemTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> structureItemTypeValue;
    @XmlElementRef(name = "CreateConfiguredItem", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> createConfiguredItem;
    @XmlElementRef(name = "ConfigModelTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> configModelTypeValue;
    @XmlElementRef(name = "EffectivityControlValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> effectivityControlValue;
    @XmlElementRef(name = "BaseItemValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baseItemValue;
    @XmlElement(name = "AutoCreatedConfigurationFlag")
    protected Boolean autoCreatedConfigurationFlag;
    @XmlElement(name = "PickComponentsFlag")
    protected Boolean pickComponentsFlag;
    @XmlElement(name = "AssembleToOrderFlag")
    protected Boolean assembleToOrderFlag;
    @XmlElement(name = "CostingEnabledFlag")
    protected Boolean costingEnabledFlag;
    @XmlElementRef(name = "IncludeInRollUpFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> includeInRollUpFlag;
    @XmlElementRef(name = "StandardLotSize", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> standardLotSize;
    @XmlElement(name = "InventoryAssetFlag")
    protected Boolean inventoryAssetFlag;
    @XmlElement(name = "BuildInWIPFlag")
    protected Boolean buildInWIPFlag;
    @XmlElementRef(name = "WIPSupplyTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wipSupplyTypeValue;
    @XmlElementRef(name = "WIPSupplyLocatorValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wipSupplyLocatorValue;
    @XmlElementRef(name = "WIPSupplySubinventoryValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wipSupplySubinventoryValue;
    @XmlElementRef(name = "OvercompletionToleranceTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> overcompletionToleranceTypeValue;
    @XmlElementRef(name = "OvercompletionToleranceValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> overcompletionToleranceValue;
    @XmlElementRef(name = "InventoryCarryPenalty", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> inventoryCarryPenalty;
    @XmlElementRef(name = "OperationSlackPenalty", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> operationSlackPenalty;
    @XmlElementRef(name = "RecipeEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> recipeEnabledFlag;
    @XmlElementRef(name = "ProcessQualityEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> processQualityEnabledFlag;
    @XmlElementRef(name = "ProcessCostingEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> processCostingEnabledFlag;
    @XmlElementRef(name = "ProcessExecutionEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> processExecutionEnabledFlag;
    @XmlElementRef(name = "ProcessSupplySubinventoryValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processSupplySubinventoryValue;
    @XmlElementRef(name = "ProcessSupplyLocatorValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processSupplyLocatorValue;
    @XmlElementRef(name = "ProcessYieldSubinventoryValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processYieldSubinventoryValue;
    @XmlElementRef(name = "ProcessYieldLocatorValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processYieldLocatorValue;
    @XmlElementRef(name = "HazardousMaterialFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> hazardousMaterialFlag;
    @XmlElementRef(name = "CASNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> casNumber;
    @XmlElementRef(name = "AssetItemTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetItemTypeValue;
    @XmlElementRef(name = "AssetActivityCauseValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetActivityCauseValue;
    @XmlElementRef(name = "AssetActivityShutdownTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetActivityShutdownTypeValue;
    @XmlElementRef(name = "AssetTrackedFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> assetTrackedFlag;
    @XmlElementRef(name = "EAMActivityTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eamActivityTypeValue;
    @XmlElementRef(name = "EAMActivitySourceValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eamActivitySourceValue;
    @XmlElementRef(name = "EAMActivityNotificationFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> eamActivityNotificationFlag;
    @XmlElementRef(name = "AssetClassValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetClassValue;
    @XmlElementRef(name = "ServiceRequestEnabledValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceRequestEnabledValue;
    @XmlElementRef(name = "DefectTrackingOnFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> defectTrackingOnFlag;
    @XmlElement(name = "ServiceableProductFlag")
    protected Boolean serviceableProductFlag;
    @XmlElementRef(name = "CommsActivationReqdFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> commsActivationReqdFlag;
    @XmlElementRef(name = "ServiceDurationTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceDurationTypeValue;
    @XmlElementRef(name = "ServiceDuration", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> serviceDuration;
    @XmlElementRef(name = "ServiceDurationPeriodValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceDurationPeriodValue;
    @XmlElementRef(name = "ServiceStartTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceStartTypeValue;
    @XmlElementRef(name = "ServiceStartDelay", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> serviceStartDelay;
    @XmlElementRef(name = "AllowSuspendFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowSuspendFlag;
    @XmlElementRef(name = "AllowTerminateFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowTerminateFlag;
    @XmlElementRef(name = "RequiresFulfillmentLocFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> requiresFulfillmentLocFlag;
    @XmlElementRef(name = "RequiresItemAssociationFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> requiresItemAssociationFlag;
    @XmlElementRef(name = "TrackInstalledBaseFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> trackInstalledBaseFlag;
    @XmlElementRef(name = "CreateFixedAssetFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> createFixedAssetFlag;
    @XmlElementRef(name = "InstanceClassValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> instanceClassValue;
    @XmlElementRef(name = "BillingTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billingTypeValue;
    @XmlElementRef(name = "ServiceBillingEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> serviceBillingEnabledFlag;
    @XmlElementRef(name = "RecoveredPartDispositionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recoveredPartDispositionValue;
    @XmlElement(name = "InventoryItemFlag")
    protected Boolean inventoryItemFlag;
    @XmlElement(name = "StockEnabledFlag")
    protected Boolean stockEnabledFlag;
    @XmlElement(name = "MaterialTransactionEnabledFlag")
    protected Boolean materialTransactionEnabledFlag;
    @XmlElementRef(name = "ReservableFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> reservableFlag;
    @XmlElementRef(name = "CheckMaterialShortageFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> checkMaterialShortageFlag;
    @XmlElementRef(name = "RevisionQuantityControlFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> revisionQuantityControlFlag;
    @XmlElementRef(name = "BulkPickedFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> bulkPickedFlag;
    @XmlElementRef(name = "LotControlValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lotControlValue;
    @XmlElementRef(name = "StartingLotPrefix", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> startingLotPrefix;
    @XmlElementRef(name = "StartingLotNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> startingLotNumber;
    @XmlElementRef(name = "MaturityDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> maturityDays;
    @XmlElementRef(name = "HoldDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> holdDays;
    @XmlElementRef(name = "LotExpirationControlValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lotExpirationControlValue;
    @XmlElementRef(name = "ShelfLifeDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> shelfLifeDays;
    @XmlElementRef(name = "RetestInterval", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> retestInterval;
    @XmlElementRef(name = "ExpirationActionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> expirationActionValue;
    @XmlElementRef(name = "ExpirationActionInterval", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> expirationActionInterval;
    @XmlElementRef(name = "ChildLotEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> childLotEnabledFlag;
    @XmlElementRef(name = "ChildLotFormatValidationFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> childLotFormatValidationFlag;
    @XmlElementRef(name = "CopyLotAttributeFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> copyLotAttributeFlag;
    @XmlElementRef(name = "ChildLotPrefix", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> childLotPrefix;
    @XmlElementRef(name = "ChildLotStartingNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> childLotStartingNumber;
    @XmlElementRef(name = "ChildLotParent", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> childLotParent;
    @XmlElementRef(name = "LotTranslateEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> lotTranslateEnabledFlag;
    @XmlElementRef(name = "LotSplitEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> lotSplitEnabledFlag;
    @XmlElementRef(name = "LotDivisibleFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> lotDivisibleFlag;
    @XmlElementRef(name = "LotSubstitutionEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> lotSubstitutionEnabledFlag;
    @XmlElementRef(name = "LotMergeEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> lotMergeEnabledFlag;
    @XmlElementRef(name = "GradeControlFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> gradeControlFlag;
    @XmlElementRef(name = "DefaultGradeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultGradeValue;
    @XmlElementRef(name = "SerialGenerationValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serialGenerationValue;
    @XmlElementRef(name = "SerialStartingPrefix", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serialStartingPrefix;
    @XmlElementRef(name = "SerialStartingNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serialStartingNumber;
    @XmlElementRef(name = "NegativeMeasurementError", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> negativeMeasurementError;
    @XmlElementRef(name = "PositiveMeasurementError", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> positiveMeasurementError;
    @XmlElement(name = "CycleCountEnabledFlag")
    protected Boolean cycleCountEnabledFlag;
    @XmlElementRef(name = "LotStatusEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> lotStatusEnabledFlag;
    @XmlElementRef(name = "SerialStatusEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> serialStatusEnabledFlag;
    @XmlElementRef(name = "DefaultLotStatusValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultLotStatusValue;
    @XmlElementRef(name = "DefaultSerialStatusValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultSerialStatusValue;
    @XmlElementRef(name = "RestrictSubinventoriesFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> restrictSubinventoriesFlag;
    @XmlElementRef(name = "RestrictLocatorsFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> restrictLocatorsFlag;
    @XmlElementRef(name = "StockLocatorControlValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stockLocatorControlValue;
    @XmlElementRef(name = "DimensionUOMValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dimensionUOMValue;
    @XmlElementRef(name = "UnitWidthQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> unitWidthQuantity;
    @XmlElementRef(name = "UnitLengthQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> unitLengthQuantity;
    @XmlElementRef(name = "UnitHeightQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> unitHeightQuantity;
    @XmlElementRef(name = "WeightUOMValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> weightUOMValue;
    @XmlElementRef(name = "UnitWeightQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> unitWeightQuantity;
    @XmlElementRef(name = "VolumeUOMValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> volumeUOMValue;
    @XmlElementRef(name = "UnitVolumeQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> unitVolumeQuantity;
    @XmlElementRef(name = "ContainerItemFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> containerItemFlag;
    @XmlElementRef(name = "ContainerTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> containerTypeValue;
    @XmlElementRef(name = "MaximumLoadWeight", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> maximumLoadWeight;
    @XmlElementRef(name = "VehicleItemFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> vehicleItemFlag;
    @XmlElementRef(name = "InternalVolume", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> internalVolume;
    @XmlElementRef(name = "MinimumFillPercent", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> minimumFillPercent;
    @XmlElementRef(name = "WarehouseEquipmentFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> warehouseEquipmentFlag;
    @XmlElementRef(name = "EventFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> eventFlag;
    @XmlElementRef(name = "CollateralFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> collateralFlag;
    @XmlElement(name = "CustomerOrderFlag")
    protected Boolean customerOrderFlag;
    @XmlElement(name = "CustomerOrderEnabledFlag")
    protected Boolean customerOrderEnabledFlag;
    @XmlElementRef(name = "ATPComponentsValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> atpComponentsValue;
    @XmlElementRef(name = "PickingRuleValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pickingRuleValue;
    @XmlElementRef(name = "RMAInspectionRequiredFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> rmaInspectionRequiredFlag;
    @XmlElementRef(name = "EligibilityRuleFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> eligibilityRuleFlag;
    @XmlElement(name = "InternalOrderFlag")
    protected Boolean internalOrderFlag;
    @XmlElement(name = "InternalOrderEnabledFlag")
    protected Boolean internalOrderEnabledFlag;
    @XmlElementRef(name = "ReturnableFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> returnableFlag;
    @XmlElementRef(name = "ATPValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> atpValue;
    @XmlElementRef(name = "FinancingAllowedFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> financingAllowedFlag;
    @XmlElementRef(name = "SalesProductTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesProductTypeValue;
    @XmlElement(name = "TransactionEnabledFlag")
    protected Boolean transactionEnabledFlag;
    @XmlElementRef(name = "OrderManagementIndivisibleFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> orderManagementIndivisibleFlag;
    @XmlElementRef(name = "DefaultSalesOrderSourceTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultSalesOrderSourceTypeValue;
    @XmlElementRef(name = "ElectronicFormatFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> electronicFormatFlag;
    @XmlElement(name = "ShippableFlag")
    protected Boolean shippableFlag;
    @XmlElementRef(name = "DefaultShippingOrganizationValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultShippingOrganizationValue;
    @XmlElementRef(name = "ShipModelCompleteFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> shipModelCompleteFlag;
    @XmlElementRef(name = "DownloadableFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> downloadableFlag;
    @XmlElementRef(name = "OverShipmentTolerance", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> overShipmentTolerance;
    @XmlElementRef(name = "UnderShipmentTolerance", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> underShipmentTolerance;
    @XmlElementRef(name = "OverReturnTolerance", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> overReturnTolerance;
    @XmlElementRef(name = "UnderReturnTolerance", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> underReturnTolerance;
    @XmlElement(name = "InvoicedFlag")
    protected Boolean invoicedFlag;
    @XmlElementRef(name = "AccountingRuleValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountingRuleValue;
    @XmlElementRef(name = "PaymentTermsValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentTermsValue;
    @XmlElementRef(name = "OutputTaxClassificationCodeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outputTaxClassificationCodeValue;
    @XmlElement(name = "InvoiceEnabledFlag")
    protected Boolean invoiceEnabledFlag;
    @XmlElementRef(name = "InvoicingRuleValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoicingRuleValue;
    @XmlElementRef(name = "SalesAccountValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> salesAccountValue;
    @XmlElementRef(name = "WebStatusValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> webStatusValue;
    @XmlElementRef(name = "BackOrderableFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> backOrderableFlag;
    @XmlElementRef(name = "OrderableOnWebFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> orderableOnWebFlag;
    @XmlElementRef(name = "MinimumLicenseQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> minimumLicenseQuantity;
    @XmlElementRef(name = "InventoryPlanningMethodValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inventoryPlanningMethodValue;
    @XmlElementRef(name = "PlanningMakeBuyValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> planningMakeBuyValue;
    @XmlElementRef(name = "Planner", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> planner;
    @XmlElementRef(name = "SubcontractingComponentValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subcontractingComponentValue;
    @XmlElementRef(name = "MinimumMinmaxQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> minimumMinmaxQuantity;
    @XmlElementRef(name = "MaximumMinmaxQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> maximumMinmaxQuantity;
    @XmlElementRef(name = "MinimumOrderQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> minimumOrderQuantity;
    @XmlElementRef(name = "MaximumOrderQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> maximumOrderQuantity;
    @XmlElementRef(name = "OrderCost", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> orderCost;
    @XmlElementRef(name = "CarryPercentage", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> carryPercentage;
    @XmlElementRef(name = "ReplenishmentType", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> replenishmentType;
    @XmlElementRef(name = "SourceOrganizationValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceOrganizationValue;
    @XmlElementRef(name = "SourceSubinventoryOrganizationValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceSubinventoryOrganizationValue;
    @XmlElementRef(name = "SourceSubinventoryValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceSubinventoryValue;
    @XmlElementRef(name = "FixedOrderQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> fixedOrderQuantity;
    @XmlElementRef(name = "FixedDaysSupply", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> fixedDaysSupply;
    @XmlElementRef(name = "FixedLotSizeMultiplier", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> fixedLotSizeMultiplier;
    @XmlElementRef(name = "ReleaseAuthorizationRequiredValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> releaseAuthorizationRequiredValue;
    @XmlElementRef(name = "AutomaticallyExpireASNFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> automaticallyExpireASNFlag;
    @XmlElementRef(name = "ConsignedFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> consignedFlag;
    @XmlElementRef(name = "ReplenishmentMinimumOrder", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> replenishmentMinimumOrder;
    @XmlElementRef(name = "ReplenishmentMinimumDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> replenishmentMinimumDays;
    @XmlElementRef(name = "MaximumOrder", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> maximumOrder;
    @XmlElementRef(name = "MaximumDaysOfSupply", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> maximumDaysOfSupply;
    @XmlElementRef(name = "VMIFixedOrderQuantity", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<MeasureType> vmiFixedOrderQuantity;
    @XmlElementRef(name = "ForecastTypelValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> forecastTypelValue;
    @XmlElementRef(name = "ForecastHorizon", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> forecastHorizon;
    @XmlElementRef(name = "PlanningMethodValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> planningMethodValue;
    @XmlElementRef(name = "Pegging", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pegging;
    @XmlElementRef(name = "RoundingControlTypeFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> roundingControlTypeFlag;
    @XmlElementRef(name = "CreateSupplyFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> createSupplyFlag;
    @XmlElementRef(name = "CriticalComponentFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> criticalComponentFlag;
    @XmlElementRef(name = "PlanningTimeFence", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> planningTimeFence;
    @XmlElementRef(name = "DemandTimeFence", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> demandTimeFence;
    @XmlElementRef(name = "ReleaseTimeFence", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> releaseTimeFence;
    @XmlElementRef(name = "SubstitutionWindow", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> substitutionWindow;
    @XmlElementRef(name = "ShrinkageRate", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> shrinkageRate;
    @XmlElementRef(name = "ForecastControlValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> forecastControlValue;
    @XmlElementRef(name = "AcceptableEarlyDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> acceptableEarlyDays;
    @XmlElementRef(name = "PlannedInventoryPointFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> plannedInventoryPointFlag;
    @XmlElementRef(name = "ExcludeFromBudgetFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> excludeFromBudgetFlag;
    @XmlElementRef(name = "PlanningTimeDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> planningTimeDays;
    @XmlElementRef(name = "DemandTimeDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> demandTimeDays;
    @XmlElementRef(name = "ReleaseTimeDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> releaseTimeDays;
    @XmlElementRef(name = "SubstitutionDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> substitutionDays;
    @XmlElementRef(name = "MRPCalculateATPFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> mrpCalculateATPFlag;
    @XmlElementRef(name = "DRPPlannedFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> drpPlannedFlag;
    @XmlElementRef(name = "MaximumInventoryWindow", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> maximumInventoryWindow;
    @XmlElementRef(name = "DaysMaximumInventorySupply", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> daysMaximumInventorySupply;
    @XmlElementRef(name = "TargetInventoryDaysofSupply", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> targetInventoryDaysofSupply;
    @XmlElementRef(name = "TagetInventoryWindow", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> tagetInventoryWindow;
    @XmlElementRef(name = "RepairLeadtime", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> repairLeadtime;
    @XmlElementRef(name = "RepairYield", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> repairYield;
    @XmlElementRef(name = "PrepositionPointFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> prepositionPointFlag;
    @XmlElementRef(name = "RepairProgramValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> repairProgramValue;
    @XmlElementRef(name = "PreprocessingDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> preprocessingDays;
    @XmlElementRef(name = "PostprocessingDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> postprocessingDays;
    @XmlElementRef(name = "ProcessingDays", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> processingDays;
    @XmlElementRef(name = "VariableLeadTime", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> variableLeadTime;
    @XmlElementRef(name = "CumulativeTotalLeadTime", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> cumulativeTotalLeadTime;
    @XmlElementRef(name = "FixedLeadTime", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> fixedLeadTime;
    @XmlElementRef(name = "CumulativeManufacturingLeadTime", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> cumulativeManufacturingLeadTime;
    @XmlElementRef(name = "LeadTimeLotSize", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> leadTimeLotSize;
    @XmlElement(name = "PurchasingFlag")
    protected Boolean purchasingFlag;
    @XmlElement(name = "UseApprovedSupplierFlag")
    protected Boolean useApprovedSupplierFlag;
    @XmlElementRef(name = "NegotiationRequiredFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> negotiationRequiredFlag;
    @XmlElementRef(name = "PurchasingInputTaxClassificationValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchasingInputTaxClassificationValue;
    @XmlElementRef(name = "UnitOfIssueValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> unitOfIssueValue;
    @XmlElementRef(name = "InvoiceCloseTolerancePercentage", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> invoiceCloseTolerancePercentage;
    @XmlElementRef(name = "HazardClassValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hazardClassValue;
    @XmlElementRef(name = "AssetCategoryValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assetCategoryValue;
    @XmlElement(name = "PurchasableFlag")
    protected Boolean purchasableFlag;
    @XmlElementRef(name = "AllowItemDescriptionUpdateFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowItemDescriptionUpdateFlag;
    @XmlElementRef(name = "TaxableFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> taxableFlag;
    @XmlElementRef(name = "BuyerOrganizationValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buyerOrganizationValue;
    @XmlElementRef(name = "DefaultBuyerValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultBuyerValue;
    @XmlElementRef(name = "ReceiptCloseTolerancePercentage", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> receiptCloseTolerancePercentage;
    @XmlElementRef(name = "UNNumberValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> unNumberValue;
    @XmlElementRef(name = "ListPrice", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> listPrice;
    @XmlElementRef(name = "PriceTolerancePercentage", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> priceTolerancePercentage;
    @XmlElementRef(name = "ExpenseAccountValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> expenseAccountValue;
    @XmlElementRef(name = "MarketPrice", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> marketPrice;
    @XmlElementRef(name = "RoundingFactor", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> roundingFactor;
    @XmlElementRef(name = "OutsourcedAssemblyFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> outsourcedAssemblyFlag;
    @XmlElement(name = "OutsideProcessingFlag")
    protected Boolean outsideProcessingFlag;
    @XmlElementRef(name = "OutsideProcessingUnitTypeValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outsideProcessingUnitTypeValue;
    @XmlElementRef(name = "MatchApprovalLevelValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> matchApprovalLevelValue;
    @XmlElementRef(name = "MatchConfigurationOptionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> matchConfigurationOptionValue;
    @XmlElementRef(name = "ReceiptRountingValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptRountingValue;
    @XmlElementRef(name = "EnforceShipToLocation", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> enforceShipToLocation;
    @XmlElementRef(name = "ReceiptDateActionValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptDateActionValue;
    @XmlElementRef(name = "DaysEarlyReceiptAllowed", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> daysEarlyReceiptAllowed;
    @XmlElementRef(name = "DaysLateReceiptAllowed", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> daysLateReceiptAllowed;
    @XmlElementRef(name = "AllowSubstituteReceiptsFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowSubstituteReceiptsFlag;
    @XmlElementRef(name = "AllowUnorderedReceiptsFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowUnorderedReceiptsFlag;
    @XmlElementRef(name = "AllowExpressDeliveryFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowExpressDeliveryFlag;
    @XmlElementRef(name = "QuantityReceivedToleranceAction", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> quantityReceivedToleranceAction;
    @XmlElementRef(name = "QuantityReceivedTolerancePercentage", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> quantityReceivedTolerancePercentage;
    @XmlElementRef(name = "ItemExtensibleFlexfieldCategoryCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemExtensibleFlexfieldCategoryCode;
    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "LastUpdateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElementRef(name = "BackToBackEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> backToBackEnabledFlag;
    @XmlElementRef(name = "ContractManufacturingFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> contractManufacturingFlag;
    @XmlElementRef(name = "DaysOfCover", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> daysOfCover;
    @XmlElementRef(name = "DemandPeriod", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> demandPeriod;
    @XmlElementRef(name = "SafetyStockPlanningMethodValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> safetyStockPlanningMethodValue;
    @XmlElementRef(name = "OutsideProcessServiceFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> outsideProcessServiceFlag;
    @XmlElementRef(name = "AllowMaintenanceAssetFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> allowMaintenanceAssetFlag;
    @XmlElementRef(name = "EnableGenealogyTrackingFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> enableGenealogyTrackingFlag;
    @XmlElementRef(name = "CssEnabledFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> cssEnabledFlag;
    @XmlElementRef(name = "EngineeredItemFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> engineeredItemFlag;
    @XmlElementRef(name = "StandardCoverage", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> standardCoverage;
    @XmlElement(name = "ItemCategory")
    protected List<ItemCategory> itemCategory;
    @XmlElement(name = "ItemSupplierAssociation")
    protected List<ItemSupplierAssociation> itemSupplierAssociation;
    @XmlElement(name = "ItemTranslation")
    protected List<ItemTranslation> itemTranslation;
    @XmlElement(name = "ItemRevision")
    protected List<ItemRevision> itemRevision;
    @XmlElement(name = "ItemEffCategory")
    protected JItemEffCategory itemEffCategory;
    @XmlElement(name = "ItemDFF")
    protected ItemDFF itemDFF;
    @XmlElement(name = "ItemGlobalDFF")
    protected ItemGdf itemGlobalDFF;
    @XmlElement(name = "ItemAttachment")
    protected List<ItemAttachment> itemAttachment;

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemId(Long value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the organizationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets the value of the organizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrganizationId(Long value) {
        this.organizationId = value;
    }

    /**
     * Gets the value of the organizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrganizationCode() {
        return organizationCode;
    }

    /**
     * Sets the value of the organizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrganizationCode(JAXBElement<String> value) {
        this.organizationCode = value;
    }

    /**
     * Gets the value of the itemClass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemClass() {
        return itemClass;
    }

    /**
     * Sets the value of the itemClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemClass(JAXBElement<String> value) {
        this.itemClass = value;
    }

    /**
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTemplate(JAXBElement<String> value) {
        this.template = value;
    }

    /**
     * Gets the value of the itemNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the value of the itemNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemNumber(JAXBElement<String> value) {
        this.itemNumber = value;
    }

    /**
     * Gets the value of the itemDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Sets the value of the itemDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDescription(String value) {
        this.itemDescription = value;
    }

    /**
     * Gets the value of the approvalStatusValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApprovalStatusValue() {
        return approvalStatusValue;
    }

    /**
     * Sets the value of the approvalStatusValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApprovalStatusValue(JAXBElement<String> value) {
        this.approvalStatusValue = value;
    }

    /**
     * Gets the value of the itemStatusValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemStatusValue() {
        return itemStatusValue;
    }

    /**
     * Sets the value of the itemStatusValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemStatusValue(JAXBElement<String> value) {
        this.itemStatusValue = value;
    }

    /**
     * Gets the value of the lifecyclePhaseValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLifecyclePhaseValue() {
        return lifecyclePhaseValue;
    }

    /**
     * Sets the value of the lifecyclePhaseValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLifecyclePhaseValue(JAXBElement<String> value) {
        this.lifecyclePhaseValue = value;
    }

    /**
     * Gets the value of the styleItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getStyleItemFlag() {
        return styleItemFlag;
    }

    /**
     * Sets the value of the styleItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setStyleItemFlag(JAXBElement<Boolean> value) {
        this.styleItemFlag = value;
    }

    /**
     * Gets the value of the styleItemNumberValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStyleItemNumberValue() {
        return styleItemNumberValue;
    }

    /**
     * Sets the value of the styleItemNumberValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStyleItemNumberValue(JAXBElement<String> value) {
        this.styleItemNumberValue = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKeyword(JAXBElement<String> value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the ignoreDuplicateItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIgnoreDuplicateItemFlag() {
        return ignoreDuplicateItemFlag;
    }

    /**
     * Sets the value of the ignoreDuplicateItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIgnoreDuplicateItemFlag(JAXBElement<Boolean> value) {
        this.ignoreDuplicateItemFlag = value;
    }

    /**
     * Gets the value of the userItemTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserItemTypeValue() {
        return userItemTypeValue;
    }

    /**
     * Sets the value of the userItemTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserItemTypeValue(JAXBElement<String> value) {
        this.userItemTypeValue = value;
    }

    /**
     * Gets the value of the packTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPackTypeValue() {
        return packTypeValue;
    }

    /**
     * Sets the value of the packTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPackTypeValue(JAXBElement<String> value) {
        this.packTypeValue = value;
    }

    /**
     * Gets the value of the longDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLongDescription() {
        return longDescription;
    }

    /**
     * Sets the value of the longDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLongDescription(JAXBElement<String> value) {
        this.longDescription = value;
    }

    /**
     * Gets the value of the formattedDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFormattedDescription() {
        return formattedDescription;
    }

    /**
     * Sets the value of the formattedDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFormattedDescription(JAXBElement<String> value) {
        this.formattedDescription = value;
    }

    /**
     * Gets the value of the primaryUOMValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrimaryUOMValue() {
        return primaryUOMValue;
    }

    /**
     * Sets the value of the primaryUOMValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrimaryUOMValue(JAXBElement<String> value) {
        this.primaryUOMValue = value;
    }

    /**
     * Gets the value of the trackingUnitofMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackingUnitofMeasure() {
        return trackingUnitofMeasure;
    }

    /**
     * Sets the value of the trackingUnitofMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackingUnitofMeasure(JAXBElement<String> value) {
        this.trackingUnitofMeasure = value;
    }

    /**
     * Gets the value of the uomPricingValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUOMPricingValue() {
        return uomPricingValue;
    }

    /**
     * Sets the value of the uomPricingValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUOMPricingValue(JAXBElement<String> value) {
        this.uomPricingValue = value;
    }

    /**
     * Gets the value of the transactionConversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionConversionValue() {
        return transactionConversionValue;
    }

    /**
     * Sets the value of the transactionConversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionConversionValue(JAXBElement<String> value) {
        this.transactionConversionValue = value;
    }

    /**
     * Gets the value of the secondaryUnitofMeasureValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecondaryUnitofMeasureValue() {
        return secondaryUnitofMeasureValue;
    }

    /**
     * Sets the value of the secondaryUnitofMeasureValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecondaryUnitofMeasureValue(JAXBElement<String> value) {
        this.secondaryUnitofMeasureValue = value;
    }

    /**
     * Gets the value of the defaultingControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultingControlValue() {
        return defaultingControlValue;
    }

    /**
     * Sets the value of the defaultingControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultingControlValue(JAXBElement<String> value) {
        this.defaultingControlValue = value;
    }

    /**
     * Gets the value of the positiveDeviationFactor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPositiveDeviationFactor() {
        return positiveDeviationFactor;
    }

    /**
     * Sets the value of the positiveDeviationFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPositiveDeviationFactor(JAXBElement<BigDecimal> value) {
        this.positiveDeviationFactor = value;
    }

    /**
     * Gets the value of the negativeDeviationFactor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNegativeDeviationFactor() {
        return negativeDeviationFactor;
    }

    /**
     * Sets the value of the negativeDeviationFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNegativeDeviationFactor(JAXBElement<BigDecimal> value) {
        this.negativeDeviationFactor = value;
    }

    /**
     * Gets the value of the copyItemAndApplyTemplatesFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCopyItemAndApplyTemplatesFlag() {
        return copyItemAndApplyTemplatesFlag;
    }

    /**
     * Sets the value of the copyItemAndApplyTemplatesFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCopyItemAndApplyTemplatesFlag(JAXBElement<Boolean> value) {
        this.copyItemAndApplyTemplatesFlag = value;
    }

    /**
     * Gets the value of the copyAssociationsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCopyAssociationsFlag() {
        return copyAssociationsFlag;
    }

    /**
     * Sets the value of the copyAssociationsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCopyAssociationsFlag(JAXBElement<Boolean> value) {
        this.copyAssociationsFlag = value;
    }

    /**
     * Gets the value of the copyAttachmentsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCopyAttachmentsFlag() {
        return copyAttachmentsFlag;
    }

    /**
     * Sets the value of the copyAttachmentsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCopyAttachmentsFlag(JAXBElement<Boolean> value) {
        this.copyAttachmentsFlag = value;
    }

    /**
     * Gets the value of the copyCategoriesFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCopyCategoriesFlag() {
        return copyCategoriesFlag;
    }

    /**
     * Sets the value of the copyCategoriesFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCopyCategoriesFlag(JAXBElement<Boolean> value) {
        this.copyCategoriesFlag = value;
    }

    /**
     * Gets the value of the copyFromItemValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCopyFromItemValue() {
        return copyFromItemValue;
    }

    /**
     * Sets the value of the copyFromItemValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCopyFromItemValue(JAXBElement<String> value) {
        this.copyFromItemValue = value;
    }

    /**
     * Gets the value of the copyFromRevisionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCopyFromRevisionValue() {
        return copyFromRevisionValue;
    }

    /**
     * Sets the value of the copyFromRevisionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCopyFromRevisionValue(JAXBElement<String> value) {
        this.copyFromRevisionValue = value;
    }

    /**
     * Gets the value of the copyFromVersionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCopyFromVersionValue() {
        return copyFromVersionValue;
    }

    /**
     * Sets the value of the copyFromVersionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCopyFromVersionValue(JAXBElement<String> value) {
        this.copyFromVersionValue = value;
    }

    /**
     * Gets the value of the copyOrganizationAssignmentsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCopyOrganizationAssignmentsFlag() {
        return copyOrganizationAssignmentsFlag;
    }

    /**
     * Sets the value of the copyOrganizationAssignmentsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCopyOrganizationAssignmentsFlag(JAXBElement<Boolean> value) {
        this.copyOrganizationAssignmentsFlag = value;
    }

    /**
     * Gets the value of the versionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVersionId(Long value) {
        this.versionId = value;
    }

    /**
     * Gets the value of the revisionForVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRevisionForVersion() {
        return revisionForVersion;
    }

    /**
     * Sets the value of the revisionForVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRevisionForVersion(JAXBElement<String> value) {
        this.revisionForVersion = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersion(JAXBElement<String> value) {
        this.version = value;
    }

    /**
     * Gets the value of the versionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersionStatus() {
        return versionStatus;
    }

    /**
     * Sets the value of the versionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersionStatus(JAXBElement<String> value) {
        this.versionStatus = value;
    }

    /**
     * Gets the value of the versionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersionDescription() {
        return versionDescription;
    }

    /**
     * Sets the value of the versionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersionDescription(JAXBElement<String> value) {
        this.versionDescription = value;
    }

    /**
     * Gets the value of the versionPlannedEffectiveDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getVersionPlannedEffectiveDateTime() {
        return versionPlannedEffectiveDateTime;
    }

    /**
     * Sets the value of the versionPlannedEffectiveDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setVersionPlannedEffectiveDateTime(JAXBElement<XMLGregorianCalendar> value) {
        this.versionPlannedEffectiveDateTime = value;
    }

    /**
     * Gets the value of the lastSubmittedNewItemRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastSubmittedNewItemRequest() {
        return lastSubmittedNewItemRequest;
    }

    /**
     * Sets the value of the lastSubmittedNewItemRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastSubmittedNewItemRequest(JAXBElement<String> value) {
        this.lastSubmittedNewItemRequest = value;
    }

    /**
     * Gets the value of the changeNotice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChangeNotice() {
        return changeNotice;
    }

    /**
     * Sets the value of the changeNotice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChangeNotice(JAXBElement<String> value) {
        this.changeNotice = value;
    }

    /**
     * Gets the value of the changeOrderLineSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getChangeOrderLineSequenceNumber() {
        return changeOrderLineSequenceNumber;
    }

    /**
     * Sets the value of the changeOrderLineSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setChangeOrderLineSequenceNumber(JAXBElement<Integer> value) {
        this.changeOrderLineSequenceNumber = value;
    }

    /**
     * Gets the value of the structureItemTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStructureItemTypeValue() {
        return structureItemTypeValue;
    }

    /**
     * Sets the value of the structureItemTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStructureItemTypeValue(JAXBElement<String> value) {
        this.structureItemTypeValue = value;
    }

    /**
     * Gets the value of the createConfiguredItem property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreateConfiguredItem() {
        return createConfiguredItem;
    }

    /**
     * Sets the value of the createConfiguredItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreateConfiguredItem(JAXBElement<String> value) {
        this.createConfiguredItem = value;
    }

    /**
     * Gets the value of the configModelTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfigModelTypeValue() {
        return configModelTypeValue;
    }

    /**
     * Sets the value of the configModelTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfigModelTypeValue(JAXBElement<String> value) {
        this.configModelTypeValue = value;
    }

    /**
     * Gets the value of the effectivityControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEffectivityControlValue() {
        return effectivityControlValue;
    }

    /**
     * Sets the value of the effectivityControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEffectivityControlValue(JAXBElement<String> value) {
        this.effectivityControlValue = value;
    }

    /**
     * Gets the value of the baseItemValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaseItemValue() {
        return baseItemValue;
    }

    /**
     * Sets the value of the baseItemValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaseItemValue(JAXBElement<String> value) {
        this.baseItemValue = value;
    }

    /**
     * Gets the value of the autoCreatedConfigurationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoCreatedConfigurationFlag() {
        return autoCreatedConfigurationFlag;
    }

    /**
     * Sets the value of the autoCreatedConfigurationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoCreatedConfigurationFlag(Boolean value) {
        this.autoCreatedConfigurationFlag = value;
    }

    /**
     * Gets the value of the pickComponentsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPickComponentsFlag() {
        return pickComponentsFlag;
    }

    /**
     * Sets the value of the pickComponentsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPickComponentsFlag(Boolean value) {
        this.pickComponentsFlag = value;
    }

    /**
     * Gets the value of the assembleToOrderFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssembleToOrderFlag() {
        return assembleToOrderFlag;
    }

    /**
     * Sets the value of the assembleToOrderFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssembleToOrderFlag(Boolean value) {
        this.assembleToOrderFlag = value;
    }

    /**
     * Gets the value of the costingEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCostingEnabledFlag() {
        return costingEnabledFlag;
    }

    /**
     * Sets the value of the costingEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCostingEnabledFlag(Boolean value) {
        this.costingEnabledFlag = value;
    }

    /**
     * Gets the value of the includeInRollUpFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIncludeInRollUpFlag() {
        return includeInRollUpFlag;
    }

    /**
     * Sets the value of the includeInRollUpFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIncludeInRollUpFlag(JAXBElement<Boolean> value) {
        this.includeInRollUpFlag = value;
    }

    /**
     * Gets the value of the standardLotSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getStandardLotSize() {
        return standardLotSize;
    }

    /**
     * Sets the value of the standardLotSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setStandardLotSize(JAXBElement<BigDecimal> value) {
        this.standardLotSize = value;
    }

    /**
     * Gets the value of the inventoryAssetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInventoryAssetFlag() {
        return inventoryAssetFlag;
    }

    /**
     * Sets the value of the inventoryAssetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInventoryAssetFlag(Boolean value) {
        this.inventoryAssetFlag = value;
    }

    /**
     * Gets the value of the buildInWIPFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBuildInWIPFlag() {
        return buildInWIPFlag;
    }

    /**
     * Sets the value of the buildInWIPFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBuildInWIPFlag(Boolean value) {
        this.buildInWIPFlag = value;
    }

    /**
     * Gets the value of the wipSupplyTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWIPSupplyTypeValue() {
        return wipSupplyTypeValue;
    }

    /**
     * Sets the value of the wipSupplyTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWIPSupplyTypeValue(JAXBElement<String> value) {
        this.wipSupplyTypeValue = value;
    }

    /**
     * Gets the value of the wipSupplyLocatorValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWIPSupplyLocatorValue() {
        return wipSupplyLocatorValue;
    }

    /**
     * Sets the value of the wipSupplyLocatorValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWIPSupplyLocatorValue(JAXBElement<String> value) {
        this.wipSupplyLocatorValue = value;
    }

    /**
     * Gets the value of the wipSupplySubinventoryValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWIPSupplySubinventoryValue() {
        return wipSupplySubinventoryValue;
    }

    /**
     * Sets the value of the wipSupplySubinventoryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWIPSupplySubinventoryValue(JAXBElement<String> value) {
        this.wipSupplySubinventoryValue = value;
    }

    /**
     * Gets the value of the overcompletionToleranceTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOvercompletionToleranceTypeValue() {
        return overcompletionToleranceTypeValue;
    }

    /**
     * Sets the value of the overcompletionToleranceTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOvercompletionToleranceTypeValue(JAXBElement<String> value) {
        this.overcompletionToleranceTypeValue = value;
    }

    /**
     * Gets the value of the overcompletionToleranceValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOvercompletionToleranceValue() {
        return overcompletionToleranceValue;
    }

    /**
     * Sets the value of the overcompletionToleranceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOvercompletionToleranceValue(JAXBElement<BigDecimal> value) {
        this.overcompletionToleranceValue = value;
    }

    /**
     * Gets the value of the inventoryCarryPenalty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInventoryCarryPenalty() {
        return inventoryCarryPenalty;
    }

    /**
     * Sets the value of the inventoryCarryPenalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInventoryCarryPenalty(JAXBElement<BigDecimal> value) {
        this.inventoryCarryPenalty = value;
    }

    /**
     * Gets the value of the operationSlackPenalty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOperationSlackPenalty() {
        return operationSlackPenalty;
    }

    /**
     * Sets the value of the operationSlackPenalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOperationSlackPenalty(JAXBElement<BigDecimal> value) {
        this.operationSlackPenalty = value;
    }

    /**
     * Gets the value of the recipeEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRecipeEnabledFlag() {
        return recipeEnabledFlag;
    }

    /**
     * Sets the value of the recipeEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRecipeEnabledFlag(JAXBElement<Boolean> value) {
        this.recipeEnabledFlag = value;
    }

    /**
     * Gets the value of the processQualityEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getProcessQualityEnabledFlag() {
        return processQualityEnabledFlag;
    }

    /**
     * Sets the value of the processQualityEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setProcessQualityEnabledFlag(JAXBElement<Boolean> value) {
        this.processQualityEnabledFlag = value;
    }

    /**
     * Gets the value of the processCostingEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getProcessCostingEnabledFlag() {
        return processCostingEnabledFlag;
    }

    /**
     * Sets the value of the processCostingEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setProcessCostingEnabledFlag(JAXBElement<Boolean> value) {
        this.processCostingEnabledFlag = value;
    }

    /**
     * Gets the value of the processExecutionEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getProcessExecutionEnabledFlag() {
        return processExecutionEnabledFlag;
    }

    /**
     * Sets the value of the processExecutionEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setProcessExecutionEnabledFlag(JAXBElement<Boolean> value) {
        this.processExecutionEnabledFlag = value;
    }

    /**
     * Gets the value of the processSupplySubinventoryValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessSupplySubinventoryValue() {
        return processSupplySubinventoryValue;
    }

    /**
     * Sets the value of the processSupplySubinventoryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessSupplySubinventoryValue(JAXBElement<String> value) {
        this.processSupplySubinventoryValue = value;
    }

    /**
     * Gets the value of the processSupplyLocatorValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessSupplyLocatorValue() {
        return processSupplyLocatorValue;
    }

    /**
     * Sets the value of the processSupplyLocatorValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessSupplyLocatorValue(JAXBElement<String> value) {
        this.processSupplyLocatorValue = value;
    }

    /**
     * Gets the value of the processYieldSubinventoryValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessYieldSubinventoryValue() {
        return processYieldSubinventoryValue;
    }

    /**
     * Sets the value of the processYieldSubinventoryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessYieldSubinventoryValue(JAXBElement<String> value) {
        this.processYieldSubinventoryValue = value;
    }

    /**
     * Gets the value of the processYieldLocatorValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessYieldLocatorValue() {
        return processYieldLocatorValue;
    }

    /**
     * Sets the value of the processYieldLocatorValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessYieldLocatorValue(JAXBElement<String> value) {
        this.processYieldLocatorValue = value;
    }

    /**
     * Gets the value of the hazardousMaterialFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getHazardousMaterialFlag() {
        return hazardousMaterialFlag;
    }

    /**
     * Sets the value of the hazardousMaterialFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setHazardousMaterialFlag(JAXBElement<Boolean> value) {
        this.hazardousMaterialFlag = value;
    }

    /**
     * Gets the value of the casNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCASNumber() {
        return casNumber;
    }

    /**
     * Sets the value of the casNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCASNumber(JAXBElement<String> value) {
        this.casNumber = value;
    }

    /**
     * Gets the value of the assetItemTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetItemTypeValue() {
        return assetItemTypeValue;
    }

    /**
     * Sets the value of the assetItemTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssetItemTypeValue(JAXBElement<String> value) {
        this.assetItemTypeValue = value;
    }

    /**
     * Gets the value of the assetActivityCauseValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetActivityCauseValue() {
        return assetActivityCauseValue;
    }

    /**
     * Sets the value of the assetActivityCauseValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssetActivityCauseValue(JAXBElement<String> value) {
        this.assetActivityCauseValue = value;
    }

    /**
     * Gets the value of the assetActivityShutdownTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetActivityShutdownTypeValue() {
        return assetActivityShutdownTypeValue;
    }

    /**
     * Sets the value of the assetActivityShutdownTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssetActivityShutdownTypeValue(JAXBElement<String> value) {
        this.assetActivityShutdownTypeValue = value;
    }

    /**
     * Gets the value of the assetTrackedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAssetTrackedFlag() {
        return assetTrackedFlag;
    }

    /**
     * Sets the value of the assetTrackedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAssetTrackedFlag(JAXBElement<Boolean> value) {
        this.assetTrackedFlag = value;
    }

    /**
     * Gets the value of the eamActivityTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEAMActivityTypeValue() {
        return eamActivityTypeValue;
    }

    /**
     * Sets the value of the eamActivityTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEAMActivityTypeValue(JAXBElement<String> value) {
        this.eamActivityTypeValue = value;
    }

    /**
     * Gets the value of the eamActivitySourceValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEAMActivitySourceValue() {
        return eamActivitySourceValue;
    }

    /**
     * Sets the value of the eamActivitySourceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEAMActivitySourceValue(JAXBElement<String> value) {
        this.eamActivitySourceValue = value;
    }

    /**
     * Gets the value of the eamActivityNotificationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEAMActivityNotificationFlag() {
        return eamActivityNotificationFlag;
    }

    /**
     * Sets the value of the eamActivityNotificationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEAMActivityNotificationFlag(JAXBElement<Boolean> value) {
        this.eamActivityNotificationFlag = value;
    }

    /**
     * Gets the value of the assetClassValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetClassValue() {
        return assetClassValue;
    }

    /**
     * Sets the value of the assetClassValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssetClassValue(JAXBElement<String> value) {
        this.assetClassValue = value;
    }

    /**
     * Gets the value of the serviceRequestEnabledValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceRequestEnabledValue() {
        return serviceRequestEnabledValue;
    }

    /**
     * Sets the value of the serviceRequestEnabledValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceRequestEnabledValue(JAXBElement<String> value) {
        this.serviceRequestEnabledValue = value;
    }

    /**
     * Gets the value of the defectTrackingOnFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getDefectTrackingOnFlag() {
        return defectTrackingOnFlag;
    }

    /**
     * Sets the value of the defectTrackingOnFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setDefectTrackingOnFlag(JAXBElement<Boolean> value) {
        this.defectTrackingOnFlag = value;
    }

    /**
     * Gets the value of the serviceableProductFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServiceableProductFlag() {
        return serviceableProductFlag;
    }

    /**
     * Sets the value of the serviceableProductFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServiceableProductFlag(Boolean value) {
        this.serviceableProductFlag = value;
    }

    /**
     * Gets the value of the commsActivationReqdFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCommsActivationReqdFlag() {
        return commsActivationReqdFlag;
    }

    /**
     * Sets the value of the commsActivationReqdFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCommsActivationReqdFlag(JAXBElement<Boolean> value) {
        this.commsActivationReqdFlag = value;
    }

    /**
     * Gets the value of the serviceDurationTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceDurationTypeValue() {
        return serviceDurationTypeValue;
    }

    /**
     * Sets the value of the serviceDurationTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceDurationTypeValue(JAXBElement<String> value) {
        this.serviceDurationTypeValue = value;
    }

    /**
     * Gets the value of the serviceDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getServiceDuration() {
        return serviceDuration;
    }

    /**
     * Sets the value of the serviceDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setServiceDuration(JAXBElement<BigDecimal> value) {
        this.serviceDuration = value;
    }

    /**
     * Gets the value of the serviceDurationPeriodValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceDurationPeriodValue() {
        return serviceDurationPeriodValue;
    }

    /**
     * Sets the value of the serviceDurationPeriodValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceDurationPeriodValue(JAXBElement<String> value) {
        this.serviceDurationPeriodValue = value;
    }

    /**
     * Gets the value of the serviceStartTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceStartTypeValue() {
        return serviceStartTypeValue;
    }

    /**
     * Sets the value of the serviceStartTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceStartTypeValue(JAXBElement<String> value) {
        this.serviceStartTypeValue = value;
    }

    /**
     * Gets the value of the serviceStartDelay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getServiceStartDelay() {
        return serviceStartDelay;
    }

    /**
     * Sets the value of the serviceStartDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setServiceStartDelay(JAXBElement<BigDecimal> value) {
        this.serviceStartDelay = value;
    }

    /**
     * Gets the value of the allowSuspendFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowSuspendFlag() {
        return allowSuspendFlag;
    }

    /**
     * Sets the value of the allowSuspendFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowSuspendFlag(JAXBElement<Boolean> value) {
        this.allowSuspendFlag = value;
    }

    /**
     * Gets the value of the allowTerminateFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowTerminateFlag() {
        return allowTerminateFlag;
    }

    /**
     * Sets the value of the allowTerminateFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowTerminateFlag(JAXBElement<Boolean> value) {
        this.allowTerminateFlag = value;
    }

    /**
     * Gets the value of the requiresFulfillmentLocFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRequiresFulfillmentLocFlag() {
        return requiresFulfillmentLocFlag;
    }

    /**
     * Sets the value of the requiresFulfillmentLocFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRequiresFulfillmentLocFlag(JAXBElement<Boolean> value) {
        this.requiresFulfillmentLocFlag = value;
    }

    /**
     * Gets the value of the requiresItemAssociationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRequiresItemAssociationFlag() {
        return requiresItemAssociationFlag;
    }

    /**
     * Sets the value of the requiresItemAssociationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRequiresItemAssociationFlag(JAXBElement<Boolean> value) {
        this.requiresItemAssociationFlag = value;
    }

    /**
     * Gets the value of the trackInstalledBaseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getTrackInstalledBaseFlag() {
        return trackInstalledBaseFlag;
    }

    /**
     * Sets the value of the trackInstalledBaseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setTrackInstalledBaseFlag(JAXBElement<Boolean> value) {
        this.trackInstalledBaseFlag = value;
    }

    /**
     * Gets the value of the createFixedAssetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCreateFixedAssetFlag() {
        return createFixedAssetFlag;
    }

    /**
     * Sets the value of the createFixedAssetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCreateFixedAssetFlag(JAXBElement<Boolean> value) {
        this.createFixedAssetFlag = value;
    }

    /**
     * Gets the value of the instanceClassValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstanceClassValue() {
        return instanceClassValue;
    }

    /**
     * Sets the value of the instanceClassValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstanceClassValue(JAXBElement<String> value) {
        this.instanceClassValue = value;
    }

    /**
     * Gets the value of the billingTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillingTypeValue() {
        return billingTypeValue;
    }

    /**
     * Sets the value of the billingTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillingTypeValue(JAXBElement<String> value) {
        this.billingTypeValue = value;
    }

    /**
     * Gets the value of the serviceBillingEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getServiceBillingEnabledFlag() {
        return serviceBillingEnabledFlag;
    }

    /**
     * Sets the value of the serviceBillingEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setServiceBillingEnabledFlag(JAXBElement<Boolean> value) {
        this.serviceBillingEnabledFlag = value;
    }

    /**
     * Gets the value of the recoveredPartDispositionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecoveredPartDispositionValue() {
        return recoveredPartDispositionValue;
    }

    /**
     * Sets the value of the recoveredPartDispositionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecoveredPartDispositionValue(JAXBElement<String> value) {
        this.recoveredPartDispositionValue = value;
    }

    /**
     * Gets the value of the inventoryItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInventoryItemFlag() {
        return inventoryItemFlag;
    }

    /**
     * Sets the value of the inventoryItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInventoryItemFlag(Boolean value) {
        this.inventoryItemFlag = value;
    }

    /**
     * Gets the value of the stockEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStockEnabledFlag() {
        return stockEnabledFlag;
    }

    /**
     * Sets the value of the stockEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStockEnabledFlag(Boolean value) {
        this.stockEnabledFlag = value;
    }

    /**
     * Gets the value of the materialTransactionEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMaterialTransactionEnabledFlag() {
        return materialTransactionEnabledFlag;
    }

    /**
     * Sets the value of the materialTransactionEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaterialTransactionEnabledFlag(Boolean value) {
        this.materialTransactionEnabledFlag = value;
    }

    /**
     * Gets the value of the reservableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getReservableFlag() {
        return reservableFlag;
    }

    /**
     * Sets the value of the reservableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setReservableFlag(JAXBElement<Boolean> value) {
        this.reservableFlag = value;
    }

    /**
     * Gets the value of the checkMaterialShortageFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCheckMaterialShortageFlag() {
        return checkMaterialShortageFlag;
    }

    /**
     * Sets the value of the checkMaterialShortageFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCheckMaterialShortageFlag(JAXBElement<Boolean> value) {
        this.checkMaterialShortageFlag = value;
    }

    /**
     * Gets the value of the revisionQuantityControlFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRevisionQuantityControlFlag() {
        return revisionQuantityControlFlag;
    }

    /**
     * Sets the value of the revisionQuantityControlFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRevisionQuantityControlFlag(JAXBElement<Boolean> value) {
        this.revisionQuantityControlFlag = value;
    }

    /**
     * Gets the value of the bulkPickedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getBulkPickedFlag() {
        return bulkPickedFlag;
    }

    /**
     * Sets the value of the bulkPickedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setBulkPickedFlag(JAXBElement<Boolean> value) {
        this.bulkPickedFlag = value;
    }

    /**
     * Gets the value of the lotControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLotControlValue() {
        return lotControlValue;
    }

    /**
     * Sets the value of the lotControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLotControlValue(JAXBElement<String> value) {
        this.lotControlValue = value;
    }

    /**
     * Gets the value of the startingLotPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStartingLotPrefix() {
        return startingLotPrefix;
    }

    /**
     * Sets the value of the startingLotPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStartingLotPrefix(JAXBElement<String> value) {
        this.startingLotPrefix = value;
    }

    /**
     * Gets the value of the startingLotNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStartingLotNumber() {
        return startingLotNumber;
    }

    /**
     * Sets the value of the startingLotNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStartingLotNumber(JAXBElement<String> value) {
        this.startingLotNumber = value;
    }

    /**
     * Gets the value of the maturityDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMaturityDays() {
        return maturityDays;
    }

    /**
     * Sets the value of the maturityDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMaturityDays(JAXBElement<BigDecimal> value) {
        this.maturityDays = value;
    }

    /**
     * Gets the value of the holdDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getHoldDays() {
        return holdDays;
    }

    /**
     * Sets the value of the holdDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setHoldDays(JAXBElement<BigDecimal> value) {
        this.holdDays = value;
    }

    /**
     * Gets the value of the lotExpirationControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLotExpirationControlValue() {
        return lotExpirationControlValue;
    }

    /**
     * Sets the value of the lotExpirationControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLotExpirationControlValue(JAXBElement<String> value) {
        this.lotExpirationControlValue = value;
    }

    /**
     * Gets the value of the shelfLifeDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getShelfLifeDays() {
        return shelfLifeDays;
    }

    /**
     * Sets the value of the shelfLifeDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setShelfLifeDays(JAXBElement<BigDecimal> value) {
        this.shelfLifeDays = value;
    }

    /**
     * Gets the value of the retestInterval property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getRetestInterval() {
        return retestInterval;
    }

    /**
     * Sets the value of the retestInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setRetestInterval(JAXBElement<BigDecimal> value) {
        this.retestInterval = value;
    }

    /**
     * Gets the value of the expirationActionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExpirationActionValue() {
        return expirationActionValue;
    }

    /**
     * Sets the value of the expirationActionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExpirationActionValue(JAXBElement<String> value) {
        this.expirationActionValue = value;
    }

    /**
     * Gets the value of the expirationActionInterval property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getExpirationActionInterval() {
        return expirationActionInterval;
    }

    /**
     * Sets the value of the expirationActionInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setExpirationActionInterval(JAXBElement<BigDecimal> value) {
        this.expirationActionInterval = value;
    }

    /**
     * Gets the value of the childLotEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getChildLotEnabledFlag() {
        return childLotEnabledFlag;
    }

    /**
     * Sets the value of the childLotEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setChildLotEnabledFlag(JAXBElement<Boolean> value) {
        this.childLotEnabledFlag = value;
    }

    /**
     * Gets the value of the childLotFormatValidationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getChildLotFormatValidationFlag() {
        return childLotFormatValidationFlag;
    }

    /**
     * Sets the value of the childLotFormatValidationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setChildLotFormatValidationFlag(JAXBElement<Boolean> value) {
        this.childLotFormatValidationFlag = value;
    }

    /**
     * Gets the value of the copyLotAttributeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCopyLotAttributeFlag() {
        return copyLotAttributeFlag;
    }

    /**
     * Sets the value of the copyLotAttributeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCopyLotAttributeFlag(JAXBElement<Boolean> value) {
        this.copyLotAttributeFlag = value;
    }

    /**
     * Gets the value of the childLotPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChildLotPrefix() {
        return childLotPrefix;
    }

    /**
     * Sets the value of the childLotPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChildLotPrefix(JAXBElement<String> value) {
        this.childLotPrefix = value;
    }

    /**
     * Gets the value of the childLotStartingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getChildLotStartingNumber() {
        return childLotStartingNumber;
    }

    /**
     * Sets the value of the childLotStartingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setChildLotStartingNumber(JAXBElement<BigDecimal> value) {
        this.childLotStartingNumber = value;
    }

    /**
     * Gets the value of the childLotParent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChildLotParent() {
        return childLotParent;
    }

    /**
     * Sets the value of the childLotParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChildLotParent(JAXBElement<String> value) {
        this.childLotParent = value;
    }

    /**
     * Gets the value of the lotTranslateEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLotTranslateEnabledFlag() {
        return lotTranslateEnabledFlag;
    }

    /**
     * Sets the value of the lotTranslateEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLotTranslateEnabledFlag(JAXBElement<Boolean> value) {
        this.lotTranslateEnabledFlag = value;
    }

    /**
     * Gets the value of the lotSplitEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLotSplitEnabledFlag() {
        return lotSplitEnabledFlag;
    }

    /**
     * Sets the value of the lotSplitEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLotSplitEnabledFlag(JAXBElement<Boolean> value) {
        this.lotSplitEnabledFlag = value;
    }

    /**
     * Gets the value of the lotDivisibleFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLotDivisibleFlag() {
        return lotDivisibleFlag;
    }

    /**
     * Sets the value of the lotDivisibleFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLotDivisibleFlag(JAXBElement<Boolean> value) {
        this.lotDivisibleFlag = value;
    }

    /**
     * Gets the value of the lotSubstitutionEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLotSubstitutionEnabledFlag() {
        return lotSubstitutionEnabledFlag;
    }

    /**
     * Sets the value of the lotSubstitutionEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLotSubstitutionEnabledFlag(JAXBElement<Boolean> value) {
        this.lotSubstitutionEnabledFlag = value;
    }

    /**
     * Gets the value of the lotMergeEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLotMergeEnabledFlag() {
        return lotMergeEnabledFlag;
    }

    /**
     * Sets the value of the lotMergeEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLotMergeEnabledFlag(JAXBElement<Boolean> value) {
        this.lotMergeEnabledFlag = value;
    }

    /**
     * Gets the value of the gradeControlFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getGradeControlFlag() {
        return gradeControlFlag;
    }

    /**
     * Sets the value of the gradeControlFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setGradeControlFlag(JAXBElement<Boolean> value) {
        this.gradeControlFlag = value;
    }

    /**
     * Gets the value of the defaultGradeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultGradeValue() {
        return defaultGradeValue;
    }

    /**
     * Sets the value of the defaultGradeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultGradeValue(JAXBElement<String> value) {
        this.defaultGradeValue = value;
    }

    /**
     * Gets the value of the serialGenerationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSerialGenerationValue() {
        return serialGenerationValue;
    }

    /**
     * Sets the value of the serialGenerationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSerialGenerationValue(JAXBElement<String> value) {
        this.serialGenerationValue = value;
    }

    /**
     * Gets the value of the serialStartingPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSerialStartingPrefix() {
        return serialStartingPrefix;
    }

    /**
     * Sets the value of the serialStartingPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSerialStartingPrefix(JAXBElement<String> value) {
        this.serialStartingPrefix = value;
    }

    /**
     * Gets the value of the serialStartingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSerialStartingNumber() {
        return serialStartingNumber;
    }

    /**
     * Sets the value of the serialStartingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSerialStartingNumber(JAXBElement<String> value) {
        this.serialStartingNumber = value;
    }

    /**
     * Gets the value of the negativeMeasurementError property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNegativeMeasurementError() {
        return negativeMeasurementError;
    }

    /**
     * Sets the value of the negativeMeasurementError property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNegativeMeasurementError(JAXBElement<BigDecimal> value) {
        this.negativeMeasurementError = value;
    }

    /**
     * Gets the value of the positiveMeasurementError property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPositiveMeasurementError() {
        return positiveMeasurementError;
    }

    /**
     * Sets the value of the positiveMeasurementError property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPositiveMeasurementError(JAXBElement<BigDecimal> value) {
        this.positiveMeasurementError = value;
    }

    /**
     * Gets the value of the cycleCountEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCycleCountEnabledFlag() {
        return cycleCountEnabledFlag;
    }

    /**
     * Sets the value of the cycleCountEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCycleCountEnabledFlag(Boolean value) {
        this.cycleCountEnabledFlag = value;
    }

    /**
     * Gets the value of the lotStatusEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getLotStatusEnabledFlag() {
        return lotStatusEnabledFlag;
    }

    /**
     * Sets the value of the lotStatusEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setLotStatusEnabledFlag(JAXBElement<Boolean> value) {
        this.lotStatusEnabledFlag = value;
    }

    /**
     * Gets the value of the serialStatusEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getSerialStatusEnabledFlag() {
        return serialStatusEnabledFlag;
    }

    /**
     * Sets the value of the serialStatusEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setSerialStatusEnabledFlag(JAXBElement<Boolean> value) {
        this.serialStatusEnabledFlag = value;
    }

    /**
     * Gets the value of the defaultLotStatusValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultLotStatusValue() {
        return defaultLotStatusValue;
    }

    /**
     * Sets the value of the defaultLotStatusValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultLotStatusValue(JAXBElement<String> value) {
        this.defaultLotStatusValue = value;
    }

    /**
     * Gets the value of the defaultSerialStatusValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultSerialStatusValue() {
        return defaultSerialStatusValue;
    }

    /**
     * Sets the value of the defaultSerialStatusValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultSerialStatusValue(JAXBElement<String> value) {
        this.defaultSerialStatusValue = value;
    }

    /**
     * Gets the value of the restrictSubinventoriesFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRestrictSubinventoriesFlag() {
        return restrictSubinventoriesFlag;
    }

    /**
     * Sets the value of the restrictSubinventoriesFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRestrictSubinventoriesFlag(JAXBElement<Boolean> value) {
        this.restrictSubinventoriesFlag = value;
    }

    /**
     * Gets the value of the restrictLocatorsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRestrictLocatorsFlag() {
        return restrictLocatorsFlag;
    }

    /**
     * Sets the value of the restrictLocatorsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRestrictLocatorsFlag(JAXBElement<Boolean> value) {
        this.restrictLocatorsFlag = value;
    }

    /**
     * Gets the value of the stockLocatorControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStockLocatorControlValue() {
        return stockLocatorControlValue;
    }

    /**
     * Sets the value of the stockLocatorControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStockLocatorControlValue(JAXBElement<String> value) {
        this.stockLocatorControlValue = value;
    }

    /**
     * Gets the value of the dimensionUOMValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDimensionUOMValue() {
        return dimensionUOMValue;
    }

    /**
     * Sets the value of the dimensionUOMValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDimensionUOMValue(JAXBElement<String> value) {
        this.dimensionUOMValue = value;
    }

    /**
     * Gets the value of the unitWidthQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getUnitWidthQuantity() {
        return unitWidthQuantity;
    }

    /**
     * Sets the value of the unitWidthQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setUnitWidthQuantity(JAXBElement<MeasureType> value) {
        this.unitWidthQuantity = value;
    }

    /**
     * Gets the value of the unitLengthQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getUnitLengthQuantity() {
        return unitLengthQuantity;
    }

    /**
     * Sets the value of the unitLengthQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setUnitLengthQuantity(JAXBElement<MeasureType> value) {
        this.unitLengthQuantity = value;
    }

    /**
     * Gets the value of the unitHeightQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getUnitHeightQuantity() {
        return unitHeightQuantity;
    }

    /**
     * Sets the value of the unitHeightQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setUnitHeightQuantity(JAXBElement<MeasureType> value) {
        this.unitHeightQuantity = value;
    }

    /**
     * Gets the value of the weightUOMValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWeightUOMValue() {
        return weightUOMValue;
    }

    /**
     * Sets the value of the weightUOMValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWeightUOMValue(JAXBElement<String> value) {
        this.weightUOMValue = value;
    }

    /**
     * Gets the value of the unitWeightQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getUnitWeightQuantity() {
        return unitWeightQuantity;
    }

    /**
     * Sets the value of the unitWeightQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setUnitWeightQuantity(JAXBElement<MeasureType> value) {
        this.unitWeightQuantity = value;
    }

    /**
     * Gets the value of the volumeUOMValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVolumeUOMValue() {
        return volumeUOMValue;
    }

    /**
     * Sets the value of the volumeUOMValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVolumeUOMValue(JAXBElement<String> value) {
        this.volumeUOMValue = value;
    }

    /**
     * Gets the value of the unitVolumeQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getUnitVolumeQuantity() {
        return unitVolumeQuantity;
    }

    /**
     * Sets the value of the unitVolumeQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setUnitVolumeQuantity(JAXBElement<MeasureType> value) {
        this.unitVolumeQuantity = value;
    }

    /**
     * Gets the value of the containerItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getContainerItemFlag() {
        return containerItemFlag;
    }

    /**
     * Sets the value of the containerItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setContainerItemFlag(JAXBElement<Boolean> value) {
        this.containerItemFlag = value;
    }

    /**
     * Gets the value of the containerTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContainerTypeValue() {
        return containerTypeValue;
    }

    /**
     * Sets the value of the containerTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContainerTypeValue(JAXBElement<String> value) {
        this.containerTypeValue = value;
    }

    /**
     * Gets the value of the maximumLoadWeight property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMaximumLoadWeight() {
        return maximumLoadWeight;
    }

    /**
     * Sets the value of the maximumLoadWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMaximumLoadWeight(JAXBElement<BigDecimal> value) {
        this.maximumLoadWeight = value;
    }

    /**
     * Gets the value of the vehicleItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getVehicleItemFlag() {
        return vehicleItemFlag;
    }

    /**
     * Sets the value of the vehicleItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setVehicleItemFlag(JAXBElement<Boolean> value) {
        this.vehicleItemFlag = value;
    }

    /**
     * Gets the value of the internalVolume property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInternalVolume() {
        return internalVolume;
    }

    /**
     * Sets the value of the internalVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInternalVolume(JAXBElement<BigDecimal> value) {
        this.internalVolume = value;
    }

    /**
     * Gets the value of the minimumFillPercent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMinimumFillPercent() {
        return minimumFillPercent;
    }

    /**
     * Sets the value of the minimumFillPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMinimumFillPercent(JAXBElement<BigDecimal> value) {
        this.minimumFillPercent = value;
    }

    /**
     * Gets the value of the warehouseEquipmentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getWarehouseEquipmentFlag() {
        return warehouseEquipmentFlag;
    }

    /**
     * Sets the value of the warehouseEquipmentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setWarehouseEquipmentFlag(JAXBElement<Boolean> value) {
        this.warehouseEquipmentFlag = value;
    }

    /**
     * Gets the value of the eventFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEventFlag() {
        return eventFlag;
    }

    /**
     * Sets the value of the eventFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEventFlag(JAXBElement<Boolean> value) {
        this.eventFlag = value;
    }

    /**
     * Gets the value of the collateralFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCollateralFlag() {
        return collateralFlag;
    }

    /**
     * Sets the value of the collateralFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCollateralFlag(JAXBElement<Boolean> value) {
        this.collateralFlag = value;
    }

    /**
     * Gets the value of the customerOrderFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCustomerOrderFlag() {
        return customerOrderFlag;
    }

    /**
     * Sets the value of the customerOrderFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustomerOrderFlag(Boolean value) {
        this.customerOrderFlag = value;
    }

    /**
     * Gets the value of the customerOrderEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCustomerOrderEnabledFlag() {
        return customerOrderEnabledFlag;
    }

    /**
     * Sets the value of the customerOrderEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustomerOrderEnabledFlag(Boolean value) {
        this.customerOrderEnabledFlag = value;
    }

    /**
     * Gets the value of the atpComponentsValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getATPComponentsValue() {
        return atpComponentsValue;
    }

    /**
     * Sets the value of the atpComponentsValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setATPComponentsValue(JAXBElement<String> value) {
        this.atpComponentsValue = value;
    }

    /**
     * Gets the value of the pickingRuleValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPickingRuleValue() {
        return pickingRuleValue;
    }

    /**
     * Sets the value of the pickingRuleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPickingRuleValue(JAXBElement<String> value) {
        this.pickingRuleValue = value;
    }

    /**
     * Gets the value of the rmaInspectionRequiredFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRMAInspectionRequiredFlag() {
        return rmaInspectionRequiredFlag;
    }

    /**
     * Sets the value of the rmaInspectionRequiredFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRMAInspectionRequiredFlag(JAXBElement<Boolean> value) {
        this.rmaInspectionRequiredFlag = value;
    }

    /**
     * Gets the value of the eligibilityRuleFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEligibilityRuleFlag() {
        return eligibilityRuleFlag;
    }

    /**
     * Sets the value of the eligibilityRuleFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEligibilityRuleFlag(JAXBElement<Boolean> value) {
        this.eligibilityRuleFlag = value;
    }

    /**
     * Gets the value of the internalOrderFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternalOrderFlag() {
        return internalOrderFlag;
    }

    /**
     * Sets the value of the internalOrderFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternalOrderFlag(Boolean value) {
        this.internalOrderFlag = value;
    }

    /**
     * Gets the value of the internalOrderEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternalOrderEnabledFlag() {
        return internalOrderEnabledFlag;
    }

    /**
     * Sets the value of the internalOrderEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternalOrderEnabledFlag(Boolean value) {
        this.internalOrderEnabledFlag = value;
    }

    /**
     * Gets the value of the returnableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getReturnableFlag() {
        return returnableFlag;
    }

    /**
     * Sets the value of the returnableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setReturnableFlag(JAXBElement<Boolean> value) {
        this.returnableFlag = value;
    }

    /**
     * Gets the value of the atpValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getATPValue() {
        return atpValue;
    }

    /**
     * Sets the value of the atpValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setATPValue(JAXBElement<String> value) {
        this.atpValue = value;
    }

    /**
     * Gets the value of the financingAllowedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getFinancingAllowedFlag() {
        return financingAllowedFlag;
    }

    /**
     * Sets the value of the financingAllowedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setFinancingAllowedFlag(JAXBElement<Boolean> value) {
        this.financingAllowedFlag = value;
    }

    /**
     * Gets the value of the salesProductTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesProductTypeValue() {
        return salesProductTypeValue;
    }

    /**
     * Sets the value of the salesProductTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesProductTypeValue(JAXBElement<String> value) {
        this.salesProductTypeValue = value;
    }

    /**
     * Gets the value of the transactionEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransactionEnabledFlag() {
        return transactionEnabledFlag;
    }

    /**
     * Sets the value of the transactionEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransactionEnabledFlag(Boolean value) {
        this.transactionEnabledFlag = value;
    }

    /**
     * Gets the value of the orderManagementIndivisibleFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getOrderManagementIndivisibleFlag() {
        return orderManagementIndivisibleFlag;
    }

    /**
     * Sets the value of the orderManagementIndivisibleFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setOrderManagementIndivisibleFlag(JAXBElement<Boolean> value) {
        this.orderManagementIndivisibleFlag = value;
    }

    /**
     * Gets the value of the defaultSalesOrderSourceTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultSalesOrderSourceTypeValue() {
        return defaultSalesOrderSourceTypeValue;
    }

    /**
     * Sets the value of the defaultSalesOrderSourceTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultSalesOrderSourceTypeValue(JAXBElement<String> value) {
        this.defaultSalesOrderSourceTypeValue = value;
    }

    /**
     * Gets the value of the electronicFormatFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getElectronicFormatFlag() {
        return electronicFormatFlag;
    }

    /**
     * Sets the value of the electronicFormatFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setElectronicFormatFlag(JAXBElement<Boolean> value) {
        this.electronicFormatFlag = value;
    }

    /**
     * Gets the value of the shippableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShippableFlag() {
        return shippableFlag;
    }

    /**
     * Sets the value of the shippableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShippableFlag(Boolean value) {
        this.shippableFlag = value;
    }

    /**
     * Gets the value of the defaultShippingOrganizationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultShippingOrganizationValue() {
        return defaultShippingOrganizationValue;
    }

    /**
     * Sets the value of the defaultShippingOrganizationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultShippingOrganizationValue(JAXBElement<String> value) {
        this.defaultShippingOrganizationValue = value;
    }

    /**
     * Gets the value of the shipModelCompleteFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getShipModelCompleteFlag() {
        return shipModelCompleteFlag;
    }

    /**
     * Sets the value of the shipModelCompleteFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setShipModelCompleteFlag(JAXBElement<Boolean> value) {
        this.shipModelCompleteFlag = value;
    }

    /**
     * Gets the value of the downloadableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getDownloadableFlag() {
        return downloadableFlag;
    }

    /**
     * Sets the value of the downloadableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setDownloadableFlag(JAXBElement<Boolean> value) {
        this.downloadableFlag = value;
    }

    /**
     * Gets the value of the overShipmentTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOverShipmentTolerance() {
        return overShipmentTolerance;
    }

    /**
     * Sets the value of the overShipmentTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOverShipmentTolerance(JAXBElement<BigDecimal> value) {
        this.overShipmentTolerance = value;
    }

    /**
     * Gets the value of the underShipmentTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getUnderShipmentTolerance() {
        return underShipmentTolerance;
    }

    /**
     * Sets the value of the underShipmentTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setUnderShipmentTolerance(JAXBElement<BigDecimal> value) {
        this.underShipmentTolerance = value;
    }

    /**
     * Gets the value of the overReturnTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOverReturnTolerance() {
        return overReturnTolerance;
    }

    /**
     * Sets the value of the overReturnTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOverReturnTolerance(JAXBElement<BigDecimal> value) {
        this.overReturnTolerance = value;
    }

    /**
     * Gets the value of the underReturnTolerance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getUnderReturnTolerance() {
        return underReturnTolerance;
    }

    /**
     * Sets the value of the underReturnTolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setUnderReturnTolerance(JAXBElement<BigDecimal> value) {
        this.underReturnTolerance = value;
    }

    /**
     * Gets the value of the invoicedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInvoicedFlag() {
        return invoicedFlag;
    }

    /**
     * Sets the value of the invoicedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInvoicedFlag(Boolean value) {
        this.invoicedFlag = value;
    }

    /**
     * Gets the value of the accountingRuleValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountingRuleValue() {
        return accountingRuleValue;
    }

    /**
     * Sets the value of the accountingRuleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountingRuleValue(JAXBElement<String> value) {
        this.accountingRuleValue = value;
    }

    /**
     * Gets the value of the paymentTermsValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentTermsValue() {
        return paymentTermsValue;
    }

    /**
     * Sets the value of the paymentTermsValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTermsValue(JAXBElement<String> value) {
        this.paymentTermsValue = value;
    }

    /**
     * Gets the value of the outputTaxClassificationCodeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutputTaxClassificationCodeValue() {
        return outputTaxClassificationCodeValue;
    }

    /**
     * Sets the value of the outputTaxClassificationCodeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutputTaxClassificationCodeValue(JAXBElement<String> value) {
        this.outputTaxClassificationCodeValue = value;
    }

    /**
     * Gets the value of the invoiceEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInvoiceEnabledFlag() {
        return invoiceEnabledFlag;
    }

    /**
     * Sets the value of the invoiceEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInvoiceEnabledFlag(Boolean value) {
        this.invoiceEnabledFlag = value;
    }

    /**
     * Gets the value of the invoicingRuleValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoicingRuleValue() {
        return invoicingRuleValue;
    }

    /**
     * Sets the value of the invoicingRuleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoicingRuleValue(JAXBElement<String> value) {
        this.invoicingRuleValue = value;
    }

    /**
     * Gets the value of the salesAccountValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalesAccountValue() {
        return salesAccountValue;
    }

    /**
     * Sets the value of the salesAccountValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesAccountValue(JAXBElement<String> value) {
        this.salesAccountValue = value;
    }

    /**
     * Gets the value of the webStatusValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWebStatusValue() {
        return webStatusValue;
    }

    /**
     * Sets the value of the webStatusValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWebStatusValue(JAXBElement<String> value) {
        this.webStatusValue = value;
    }

    /**
     * Gets the value of the backOrderableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getBackOrderableFlag() {
        return backOrderableFlag;
    }

    /**
     * Sets the value of the backOrderableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setBackOrderableFlag(JAXBElement<Boolean> value) {
        this.backOrderableFlag = value;
    }

    /**
     * Gets the value of the orderableOnWebFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getOrderableOnWebFlag() {
        return orderableOnWebFlag;
    }

    /**
     * Sets the value of the orderableOnWebFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setOrderableOnWebFlag(JAXBElement<Boolean> value) {
        this.orderableOnWebFlag = value;
    }

    /**
     * Gets the value of the minimumLicenseQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getMinimumLicenseQuantity() {
        return minimumLicenseQuantity;
    }

    /**
     * Sets the value of the minimumLicenseQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setMinimumLicenseQuantity(JAXBElement<MeasureType> value) {
        this.minimumLicenseQuantity = value;
    }

    /**
     * Gets the value of the inventoryPlanningMethodValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInventoryPlanningMethodValue() {
        return inventoryPlanningMethodValue;
    }

    /**
     * Sets the value of the inventoryPlanningMethodValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInventoryPlanningMethodValue(JAXBElement<String> value) {
        this.inventoryPlanningMethodValue = value;
    }

    /**
     * Gets the value of the planningMakeBuyValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlanningMakeBuyValue() {
        return planningMakeBuyValue;
    }

    /**
     * Sets the value of the planningMakeBuyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlanningMakeBuyValue(JAXBElement<String> value) {
        this.planningMakeBuyValue = value;
    }

    /**
     * Gets the value of the planner property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlanner() {
        return planner;
    }

    /**
     * Sets the value of the planner property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlanner(JAXBElement<String> value) {
        this.planner = value;
    }

    /**
     * Gets the value of the subcontractingComponentValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubcontractingComponentValue() {
        return subcontractingComponentValue;
    }

    /**
     * Sets the value of the subcontractingComponentValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubcontractingComponentValue(JAXBElement<String> value) {
        this.subcontractingComponentValue = value;
    }

    /**
     * Gets the value of the minimumMinmaxQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getMinimumMinmaxQuantity() {
        return minimumMinmaxQuantity;
    }

    /**
     * Sets the value of the minimumMinmaxQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setMinimumMinmaxQuantity(JAXBElement<MeasureType> value) {
        this.minimumMinmaxQuantity = value;
    }

    /**
     * Gets the value of the maximumMinmaxQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getMaximumMinmaxQuantity() {
        return maximumMinmaxQuantity;
    }

    /**
     * Sets the value of the maximumMinmaxQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setMaximumMinmaxQuantity(JAXBElement<MeasureType> value) {
        this.maximumMinmaxQuantity = value;
    }

    /**
     * Gets the value of the minimumOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    /**
     * Sets the value of the minimumOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setMinimumOrderQuantity(JAXBElement<MeasureType> value) {
        this.minimumOrderQuantity = value;
    }

    /**
     * Gets the value of the maximumOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    /**
     * Sets the value of the maximumOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setMaximumOrderQuantity(JAXBElement<MeasureType> value) {
        this.maximumOrderQuantity = value;
    }

    /**
     * Gets the value of the orderCost property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOrderCost() {
        return orderCost;
    }

    /**
     * Sets the value of the orderCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOrderCost(JAXBElement<BigDecimal> value) {
        this.orderCost = value;
    }

    /**
     * Gets the value of the carryPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCarryPercentage() {
        return carryPercentage;
    }

    /**
     * Sets the value of the carryPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCarryPercentage(JAXBElement<BigDecimal> value) {
        this.carryPercentage = value;
    }

    /**
     * Gets the value of the replenishmentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReplenishmentType() {
        return replenishmentType;
    }

    /**
     * Sets the value of the replenishmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReplenishmentType(JAXBElement<String> value) {
        this.replenishmentType = value;
    }

    /**
     * Gets the value of the sourceOrganizationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceOrganizationValue() {
        return sourceOrganizationValue;
    }

    /**
     * Sets the value of the sourceOrganizationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceOrganizationValue(JAXBElement<String> value) {
        this.sourceOrganizationValue = value;
    }

    /**
     * Gets the value of the sourceSubinventoryOrganizationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceSubinventoryOrganizationValue() {
        return sourceSubinventoryOrganizationValue;
    }

    /**
     * Sets the value of the sourceSubinventoryOrganizationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceSubinventoryOrganizationValue(JAXBElement<String> value) {
        this.sourceSubinventoryOrganizationValue = value;
    }

    /**
     * Gets the value of the sourceSubinventoryValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceSubinventoryValue() {
        return sourceSubinventoryValue;
    }

    /**
     * Sets the value of the sourceSubinventoryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceSubinventoryValue(JAXBElement<String> value) {
        this.sourceSubinventoryValue = value;
    }

    /**
     * Gets the value of the fixedOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getFixedOrderQuantity() {
        return fixedOrderQuantity;
    }

    /**
     * Sets the value of the fixedOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setFixedOrderQuantity(JAXBElement<MeasureType> value) {
        this.fixedOrderQuantity = value;
    }

    /**
     * Gets the value of the fixedDaysSupply property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFixedDaysSupply() {
        return fixedDaysSupply;
    }

    /**
     * Sets the value of the fixedDaysSupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFixedDaysSupply(JAXBElement<BigDecimal> value) {
        this.fixedDaysSupply = value;
    }

    /**
     * Gets the value of the fixedLotSizeMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFixedLotSizeMultiplier() {
        return fixedLotSizeMultiplier;
    }

    /**
     * Sets the value of the fixedLotSizeMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFixedLotSizeMultiplier(JAXBElement<BigDecimal> value) {
        this.fixedLotSizeMultiplier = value;
    }

    /**
     * Gets the value of the releaseAuthorizationRequiredValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReleaseAuthorizationRequiredValue() {
        return releaseAuthorizationRequiredValue;
    }

    /**
     * Sets the value of the releaseAuthorizationRequiredValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReleaseAuthorizationRequiredValue(JAXBElement<String> value) {
        this.releaseAuthorizationRequiredValue = value;
    }

    /**
     * Gets the value of the automaticallyExpireASNFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAutomaticallyExpireASNFlag() {
        return automaticallyExpireASNFlag;
    }

    /**
     * Sets the value of the automaticallyExpireASNFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAutomaticallyExpireASNFlag(JAXBElement<Boolean> value) {
        this.automaticallyExpireASNFlag = value;
    }

    /**
     * Gets the value of the consignedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getConsignedFlag() {
        return consignedFlag;
    }

    /**
     * Sets the value of the consignedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setConsignedFlag(JAXBElement<Boolean> value) {
        this.consignedFlag = value;
    }

    /**
     * Gets the value of the replenishmentMinimumOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getReplenishmentMinimumOrder() {
        return replenishmentMinimumOrder;
    }

    /**
     * Sets the value of the replenishmentMinimumOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setReplenishmentMinimumOrder(JAXBElement<BigDecimal> value) {
        this.replenishmentMinimumOrder = value;
    }

    /**
     * Gets the value of the replenishmentMinimumDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getReplenishmentMinimumDays() {
        return replenishmentMinimumDays;
    }

    /**
     * Sets the value of the replenishmentMinimumDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setReplenishmentMinimumDays(JAXBElement<BigDecimal> value) {
        this.replenishmentMinimumDays = value;
    }

    /**
     * Gets the value of the maximumOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMaximumOrder() {
        return maximumOrder;
    }

    /**
     * Sets the value of the maximumOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMaximumOrder(JAXBElement<BigDecimal> value) {
        this.maximumOrder = value;
    }

    /**
     * Gets the value of the maximumDaysOfSupply property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMaximumDaysOfSupply() {
        return maximumDaysOfSupply;
    }

    /**
     * Sets the value of the maximumDaysOfSupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMaximumDaysOfSupply(JAXBElement<BigDecimal> value) {
        this.maximumDaysOfSupply = value;
    }

    /**
     * Gets the value of the vmiFixedOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public JAXBElement<MeasureType> getVMIFixedOrderQuantity() {
        return vmiFixedOrderQuantity;
    }

    /**
     * Sets the value of the vmiFixedOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     *     
     */
    public void setVMIFixedOrderQuantity(JAXBElement<MeasureType> value) {
        this.vmiFixedOrderQuantity = value;
    }

    /**
     * Gets the value of the forecastTypelValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getForecastTypelValue() {
        return forecastTypelValue;
    }

    /**
     * Sets the value of the forecastTypelValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setForecastTypelValue(JAXBElement<String> value) {
        this.forecastTypelValue = value;
    }

    /**
     * Gets the value of the forecastHorizon property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getForecastHorizon() {
        return forecastHorizon;
    }

    /**
     * Sets the value of the forecastHorizon property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setForecastHorizon(JAXBElement<BigDecimal> value) {
        this.forecastHorizon = value;
    }

    /**
     * Gets the value of the planningMethodValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlanningMethodValue() {
        return planningMethodValue;
    }

    /**
     * Sets the value of the planningMethodValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlanningMethodValue(JAXBElement<String> value) {
        this.planningMethodValue = value;
    }

    /**
     * Gets the value of the pegging property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPegging() {
        return pegging;
    }

    /**
     * Sets the value of the pegging property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPegging(JAXBElement<String> value) {
        this.pegging = value;
    }

    /**
     * Gets the value of the roundingControlTypeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRoundingControlTypeFlag() {
        return roundingControlTypeFlag;
    }

    /**
     * Sets the value of the roundingControlTypeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRoundingControlTypeFlag(JAXBElement<Boolean> value) {
        this.roundingControlTypeFlag = value;
    }

    /**
     * Gets the value of the createSupplyFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCreateSupplyFlag() {
        return createSupplyFlag;
    }

    /**
     * Sets the value of the createSupplyFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCreateSupplyFlag(JAXBElement<Boolean> value) {
        this.createSupplyFlag = value;
    }

    /**
     * Gets the value of the criticalComponentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCriticalComponentFlag() {
        return criticalComponentFlag;
    }

    /**
     * Sets the value of the criticalComponentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCriticalComponentFlag(JAXBElement<Boolean> value) {
        this.criticalComponentFlag = value;
    }

    /**
     * Gets the value of the planningTimeFence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlanningTimeFence() {
        return planningTimeFence;
    }

    /**
     * Sets the value of the planningTimeFence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlanningTimeFence(JAXBElement<String> value) {
        this.planningTimeFence = value;
    }

    /**
     * Gets the value of the demandTimeFence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDemandTimeFence() {
        return demandTimeFence;
    }

    /**
     * Sets the value of the demandTimeFence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDemandTimeFence(JAXBElement<String> value) {
        this.demandTimeFence = value;
    }

    /**
     * Gets the value of the releaseTimeFence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReleaseTimeFence() {
        return releaseTimeFence;
    }

    /**
     * Sets the value of the releaseTimeFence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReleaseTimeFence(JAXBElement<String> value) {
        this.releaseTimeFence = value;
    }

    /**
     * Gets the value of the substitutionWindow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubstitutionWindow() {
        return substitutionWindow;
    }

    /**
     * Sets the value of the substitutionWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubstitutionWindow(JAXBElement<String> value) {
        this.substitutionWindow = value;
    }

    /**
     * Gets the value of the shrinkageRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getShrinkageRate() {
        return shrinkageRate;
    }

    /**
     * Sets the value of the shrinkageRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setShrinkageRate(JAXBElement<BigDecimal> value) {
        this.shrinkageRate = value;
    }

    /**
     * Gets the value of the forecastControlValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getForecastControlValue() {
        return forecastControlValue;
    }

    /**
     * Sets the value of the forecastControlValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setForecastControlValue(JAXBElement<String> value) {
        this.forecastControlValue = value;
    }

    /**
     * Gets the value of the acceptableEarlyDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAcceptableEarlyDays() {
        return acceptableEarlyDays;
    }

    /**
     * Sets the value of the acceptableEarlyDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAcceptableEarlyDays(JAXBElement<BigDecimal> value) {
        this.acceptableEarlyDays = value;
    }

    /**
     * Gets the value of the plannedInventoryPointFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getPlannedInventoryPointFlag() {
        return plannedInventoryPointFlag;
    }

    /**
     * Sets the value of the plannedInventoryPointFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setPlannedInventoryPointFlag(JAXBElement<Boolean> value) {
        this.plannedInventoryPointFlag = value;
    }

    /**
     * Gets the value of the excludeFromBudgetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getExcludeFromBudgetFlag() {
        return excludeFromBudgetFlag;
    }

    /**
     * Sets the value of the excludeFromBudgetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setExcludeFromBudgetFlag(JAXBElement<Boolean> value) {
        this.excludeFromBudgetFlag = value;
    }

    /**
     * Gets the value of the planningTimeDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPlanningTimeDays() {
        return planningTimeDays;
    }

    /**
     * Sets the value of the planningTimeDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPlanningTimeDays(JAXBElement<BigDecimal> value) {
        this.planningTimeDays = value;
    }

    /**
     * Gets the value of the demandTimeDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDemandTimeDays() {
        return demandTimeDays;
    }

    /**
     * Sets the value of the demandTimeDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDemandTimeDays(JAXBElement<BigDecimal> value) {
        this.demandTimeDays = value;
    }

    /**
     * Gets the value of the releaseTimeDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getReleaseTimeDays() {
        return releaseTimeDays;
    }

    /**
     * Sets the value of the releaseTimeDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setReleaseTimeDays(JAXBElement<BigDecimal> value) {
        this.releaseTimeDays = value;
    }

    /**
     * Gets the value of the substitutionDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSubstitutionDays() {
        return substitutionDays;
    }

    /**
     * Sets the value of the substitutionDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSubstitutionDays(JAXBElement<BigDecimal> value) {
        this.substitutionDays = value;
    }

    /**
     * Gets the value of the mrpCalculateATPFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getMRPCalculateATPFlag() {
        return mrpCalculateATPFlag;
    }

    /**
     * Sets the value of the mrpCalculateATPFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setMRPCalculateATPFlag(JAXBElement<Boolean> value) {
        this.mrpCalculateATPFlag = value;
    }

    /**
     * Gets the value of the drpPlannedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getDRPPlannedFlag() {
        return drpPlannedFlag;
    }

    /**
     * Sets the value of the drpPlannedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setDRPPlannedFlag(JAXBElement<Boolean> value) {
        this.drpPlannedFlag = value;
    }

    /**
     * Gets the value of the maximumInventoryWindow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMaximumInventoryWindow() {
        return maximumInventoryWindow;
    }

    /**
     * Sets the value of the maximumInventoryWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMaximumInventoryWindow(JAXBElement<BigDecimal> value) {
        this.maximumInventoryWindow = value;
    }

    /**
     * Gets the value of the daysMaximumInventorySupply property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDaysMaximumInventorySupply() {
        return daysMaximumInventorySupply;
    }

    /**
     * Sets the value of the daysMaximumInventorySupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDaysMaximumInventorySupply(JAXBElement<BigDecimal> value) {
        this.daysMaximumInventorySupply = value;
    }

    /**
     * Gets the value of the targetInventoryDaysofSupply property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTargetInventoryDaysofSupply() {
        return targetInventoryDaysofSupply;
    }

    /**
     * Sets the value of the targetInventoryDaysofSupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTargetInventoryDaysofSupply(JAXBElement<BigDecimal> value) {
        this.targetInventoryDaysofSupply = value;
    }

    /**
     * Gets the value of the tagetInventoryWindow property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTagetInventoryWindow() {
        return tagetInventoryWindow;
    }

    /**
     * Sets the value of the tagetInventoryWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTagetInventoryWindow(JAXBElement<BigDecimal> value) {
        this.tagetInventoryWindow = value;
    }

    /**
     * Gets the value of the repairLeadtime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getRepairLeadtime() {
        return repairLeadtime;
    }

    /**
     * Sets the value of the repairLeadtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setRepairLeadtime(JAXBElement<BigDecimal> value) {
        this.repairLeadtime = value;
    }

    /**
     * Gets the value of the repairYield property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getRepairYield() {
        return repairYield;
    }

    /**
     * Sets the value of the repairYield property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setRepairYield(JAXBElement<BigDecimal> value) {
        this.repairYield = value;
    }

    /**
     * Gets the value of the prepositionPointFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getPrepositionPointFlag() {
        return prepositionPointFlag;
    }

    /**
     * Sets the value of the prepositionPointFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setPrepositionPointFlag(JAXBElement<Boolean> value) {
        this.prepositionPointFlag = value;
    }

    /**
     * Gets the value of the repairProgramValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRepairProgramValue() {
        return repairProgramValue;
    }

    /**
     * Sets the value of the repairProgramValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRepairProgramValue(JAXBElement<String> value) {
        this.repairProgramValue = value;
    }

    /**
     * Gets the value of the preprocessingDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPreprocessingDays() {
        return preprocessingDays;
    }

    /**
     * Sets the value of the preprocessingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPreprocessingDays(JAXBElement<BigDecimal> value) {
        this.preprocessingDays = value;
    }

    /**
     * Gets the value of the postprocessingDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPostprocessingDays() {
        return postprocessingDays;
    }

    /**
     * Sets the value of the postprocessingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPostprocessingDays(JAXBElement<BigDecimal> value) {
        this.postprocessingDays = value;
    }

    /**
     * Gets the value of the processingDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getProcessingDays() {
        return processingDays;
    }

    /**
     * Sets the value of the processingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setProcessingDays(JAXBElement<BigDecimal> value) {
        this.processingDays = value;
    }

    /**
     * Gets the value of the variableLeadTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getVariableLeadTime() {
        return variableLeadTime;
    }

    /**
     * Sets the value of the variableLeadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setVariableLeadTime(JAXBElement<BigDecimal> value) {
        this.variableLeadTime = value;
    }

    /**
     * Gets the value of the cumulativeTotalLeadTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCumulativeTotalLeadTime() {
        return cumulativeTotalLeadTime;
    }

    /**
     * Sets the value of the cumulativeTotalLeadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCumulativeTotalLeadTime(JAXBElement<BigDecimal> value) {
        this.cumulativeTotalLeadTime = value;
    }

    /**
     * Gets the value of the fixedLeadTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFixedLeadTime() {
        return fixedLeadTime;
    }

    /**
     * Sets the value of the fixedLeadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFixedLeadTime(JAXBElement<BigDecimal> value) {
        this.fixedLeadTime = value;
    }

    /**
     * Gets the value of the cumulativeManufacturingLeadTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCumulativeManufacturingLeadTime() {
        return cumulativeManufacturingLeadTime;
    }

    /**
     * Sets the value of the cumulativeManufacturingLeadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCumulativeManufacturingLeadTime(JAXBElement<BigDecimal> value) {
        this.cumulativeManufacturingLeadTime = value;
    }

    /**
     * Gets the value of the leadTimeLotSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLeadTimeLotSize() {
        return leadTimeLotSize;
    }

    /**
     * Sets the value of the leadTimeLotSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLeadTimeLotSize(JAXBElement<BigDecimal> value) {
        this.leadTimeLotSize = value;
    }

    /**
     * Gets the value of the purchasingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPurchasingFlag() {
        return purchasingFlag;
    }

    /**
     * Sets the value of the purchasingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPurchasingFlag(Boolean value) {
        this.purchasingFlag = value;
    }

    /**
     * Gets the value of the useApprovedSupplierFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseApprovedSupplierFlag() {
        return useApprovedSupplierFlag;
    }

    /**
     * Sets the value of the useApprovedSupplierFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseApprovedSupplierFlag(Boolean value) {
        this.useApprovedSupplierFlag = value;
    }

    /**
     * Gets the value of the negotiationRequiredFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getNegotiationRequiredFlag() {
        return negotiationRequiredFlag;
    }

    /**
     * Sets the value of the negotiationRequiredFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setNegotiationRequiredFlag(JAXBElement<Boolean> value) {
        this.negotiationRequiredFlag = value;
    }

    /**
     * Gets the value of the purchasingInputTaxClassificationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchasingInputTaxClassificationValue() {
        return purchasingInputTaxClassificationValue;
    }

    /**
     * Sets the value of the purchasingInputTaxClassificationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchasingInputTaxClassificationValue(JAXBElement<String> value) {
        this.purchasingInputTaxClassificationValue = value;
    }

    /**
     * Gets the value of the unitOfIssueValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnitOfIssueValue() {
        return unitOfIssueValue;
    }

    /**
     * Sets the value of the unitOfIssueValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnitOfIssueValue(JAXBElement<String> value) {
        this.unitOfIssueValue = value;
    }

    /**
     * Gets the value of the invoiceCloseTolerancePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInvoiceCloseTolerancePercentage() {
        return invoiceCloseTolerancePercentage;
    }

    /**
     * Sets the value of the invoiceCloseTolerancePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInvoiceCloseTolerancePercentage(JAXBElement<BigDecimal> value) {
        this.invoiceCloseTolerancePercentage = value;
    }

    /**
     * Gets the value of the hazardClassValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHazardClassValue() {
        return hazardClassValue;
    }

    /**
     * Sets the value of the hazardClassValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHazardClassValue(JAXBElement<String> value) {
        this.hazardClassValue = value;
    }

    /**
     * Gets the value of the assetCategoryValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssetCategoryValue() {
        return assetCategoryValue;
    }

    /**
     * Sets the value of the assetCategoryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssetCategoryValue(JAXBElement<String> value) {
        this.assetCategoryValue = value;
    }

    /**
     * Gets the value of the purchasableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPurchasableFlag() {
        return purchasableFlag;
    }

    /**
     * Sets the value of the purchasableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPurchasableFlag(Boolean value) {
        this.purchasableFlag = value;
    }

    /**
     * Gets the value of the allowItemDescriptionUpdateFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowItemDescriptionUpdateFlag() {
        return allowItemDescriptionUpdateFlag;
    }

    /**
     * Sets the value of the allowItemDescriptionUpdateFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowItemDescriptionUpdateFlag(JAXBElement<Boolean> value) {
        this.allowItemDescriptionUpdateFlag = value;
    }

    /**
     * Gets the value of the taxableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getTaxableFlag() {
        return taxableFlag;
    }

    /**
     * Sets the value of the taxableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setTaxableFlag(JAXBElement<Boolean> value) {
        this.taxableFlag = value;
    }

    /**
     * Gets the value of the buyerOrganizationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuyerOrganizationValue() {
        return buyerOrganizationValue;
    }

    /**
     * Sets the value of the buyerOrganizationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuyerOrganizationValue(JAXBElement<String> value) {
        this.buyerOrganizationValue = value;
    }

    /**
     * Gets the value of the defaultBuyerValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultBuyerValue() {
        return defaultBuyerValue;
    }

    /**
     * Sets the value of the defaultBuyerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultBuyerValue(JAXBElement<String> value) {
        this.defaultBuyerValue = value;
    }

    /**
     * Gets the value of the receiptCloseTolerancePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getReceiptCloseTolerancePercentage() {
        return receiptCloseTolerancePercentage;
    }

    /**
     * Sets the value of the receiptCloseTolerancePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setReceiptCloseTolerancePercentage(JAXBElement<BigDecimal> value) {
        this.receiptCloseTolerancePercentage = value;
    }

    /**
     * Gets the value of the unNumberValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUNNumberValue() {
        return unNumberValue;
    }

    /**
     * Sets the value of the unNumberValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUNNumberValue(JAXBElement<String> value) {
        this.unNumberValue = value;
    }

    /**
     * Gets the value of the listPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getListPrice() {
        return listPrice;
    }

    /**
     * Sets the value of the listPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setListPrice(JAXBElement<AmountType> value) {
        this.listPrice = value;
    }

    /**
     * Gets the value of the priceTolerancePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPriceTolerancePercentage() {
        return priceTolerancePercentage;
    }

    /**
     * Sets the value of the priceTolerancePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPriceTolerancePercentage(JAXBElement<BigDecimal> value) {
        this.priceTolerancePercentage = value;
    }

    /**
     * Gets the value of the expenseAccountValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExpenseAccountValue() {
        return expenseAccountValue;
    }

    /**
     * Sets the value of the expenseAccountValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExpenseAccountValue(JAXBElement<String> value) {
        this.expenseAccountValue = value;
    }

    /**
     * Gets the value of the marketPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getMarketPrice() {
        return marketPrice;
    }

    /**
     * Sets the value of the marketPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setMarketPrice(JAXBElement<AmountType> value) {
        this.marketPrice = value;
    }

    /**
     * Gets the value of the roundingFactor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getRoundingFactor() {
        return roundingFactor;
    }

    /**
     * Sets the value of the roundingFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setRoundingFactor(JAXBElement<BigDecimal> value) {
        this.roundingFactor = value;
    }

    /**
     * Gets the value of the outsourcedAssemblyFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getOutsourcedAssemblyFlag() {
        return outsourcedAssemblyFlag;
    }

    /**
     * Sets the value of the outsourcedAssemblyFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setOutsourcedAssemblyFlag(JAXBElement<Boolean> value) {
        this.outsourcedAssemblyFlag = value;
    }

    /**
     * Gets the value of the outsideProcessingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutsideProcessingFlag() {
        return outsideProcessingFlag;
    }

    /**
     * Sets the value of the outsideProcessingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutsideProcessingFlag(Boolean value) {
        this.outsideProcessingFlag = value;
    }

    /**
     * Gets the value of the outsideProcessingUnitTypeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutsideProcessingUnitTypeValue() {
        return outsideProcessingUnitTypeValue;
    }

    /**
     * Sets the value of the outsideProcessingUnitTypeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutsideProcessingUnitTypeValue(JAXBElement<String> value) {
        this.outsideProcessingUnitTypeValue = value;
    }

    /**
     * Gets the value of the matchApprovalLevelValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMatchApprovalLevelValue() {
        return matchApprovalLevelValue;
    }

    /**
     * Sets the value of the matchApprovalLevelValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMatchApprovalLevelValue(JAXBElement<String> value) {
        this.matchApprovalLevelValue = value;
    }

    /**
     * Gets the value of the matchConfigurationOptionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMatchConfigurationOptionValue() {
        return matchConfigurationOptionValue;
    }

    /**
     * Sets the value of the matchConfigurationOptionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMatchConfigurationOptionValue(JAXBElement<String> value) {
        this.matchConfigurationOptionValue = value;
    }

    /**
     * Gets the value of the receiptRountingValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptRountingValue() {
        return receiptRountingValue;
    }

    /**
     * Sets the value of the receiptRountingValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptRountingValue(JAXBElement<String> value) {
        this.receiptRountingValue = value;
    }

    /**
     * Gets the value of the enforceShipToLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEnforceShipToLocation() {
        return enforceShipToLocation;
    }

    /**
     * Sets the value of the enforceShipToLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEnforceShipToLocation(JAXBElement<String> value) {
        this.enforceShipToLocation = value;
    }

    /**
     * Gets the value of the receiptDateActionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptDateActionValue() {
        return receiptDateActionValue;
    }

    /**
     * Sets the value of the receiptDateActionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptDateActionValue(JAXBElement<String> value) {
        this.receiptDateActionValue = value;
    }

    /**
     * Gets the value of the daysEarlyReceiptAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDaysEarlyReceiptAllowed() {
        return daysEarlyReceiptAllowed;
    }

    /**
     * Sets the value of the daysEarlyReceiptAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDaysEarlyReceiptAllowed(JAXBElement<BigDecimal> value) {
        this.daysEarlyReceiptAllowed = value;
    }

    /**
     * Gets the value of the daysLateReceiptAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDaysLateReceiptAllowed() {
        return daysLateReceiptAllowed;
    }

    /**
     * Sets the value of the daysLateReceiptAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDaysLateReceiptAllowed(JAXBElement<BigDecimal> value) {
        this.daysLateReceiptAllowed = value;
    }

    /**
     * Gets the value of the allowSubstituteReceiptsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowSubstituteReceiptsFlag() {
        return allowSubstituteReceiptsFlag;
    }

    /**
     * Sets the value of the allowSubstituteReceiptsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowSubstituteReceiptsFlag(JAXBElement<Boolean> value) {
        this.allowSubstituteReceiptsFlag = value;
    }

    /**
     * Gets the value of the allowUnorderedReceiptsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowUnorderedReceiptsFlag() {
        return allowUnorderedReceiptsFlag;
    }

    /**
     * Sets the value of the allowUnorderedReceiptsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowUnorderedReceiptsFlag(JAXBElement<Boolean> value) {
        this.allowUnorderedReceiptsFlag = value;
    }

    /**
     * Gets the value of the allowExpressDeliveryFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowExpressDeliveryFlag() {
        return allowExpressDeliveryFlag;
    }

    /**
     * Sets the value of the allowExpressDeliveryFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowExpressDeliveryFlag(JAXBElement<Boolean> value) {
        this.allowExpressDeliveryFlag = value;
    }

    /**
     * Gets the value of the quantityReceivedToleranceAction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuantityReceivedToleranceAction() {
        return quantityReceivedToleranceAction;
    }

    /**
     * Sets the value of the quantityReceivedToleranceAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuantityReceivedToleranceAction(JAXBElement<String> value) {
        this.quantityReceivedToleranceAction = value;
    }

    /**
     * Gets the value of the quantityReceivedTolerancePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getQuantityReceivedTolerancePercentage() {
        return quantityReceivedTolerancePercentage;
    }

    /**
     * Sets the value of the quantityReceivedTolerancePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setQuantityReceivedTolerancePercentage(JAXBElement<BigDecimal> value) {
        this.quantityReceivedTolerancePercentage = value;
    }

    /**
     * Gets the value of the itemExtensibleFlexfieldCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemExtensibleFlexfieldCategoryCode() {
        return itemExtensibleFlexfieldCategoryCode;
    }

    /**
     * Sets the value of the itemExtensibleFlexfieldCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemExtensibleFlexfieldCategoryCode(JAXBElement<String> value) {
        this.itemExtensibleFlexfieldCategoryCode = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the backToBackEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getBackToBackEnabledFlag() {
        return backToBackEnabledFlag;
    }

    /**
     * Sets the value of the backToBackEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setBackToBackEnabledFlag(JAXBElement<Boolean> value) {
        this.backToBackEnabledFlag = value;
    }

    /**
     * Gets the value of the contractManufacturingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getContractManufacturingFlag() {
        return contractManufacturingFlag;
    }

    /**
     * Sets the value of the contractManufacturingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setContractManufacturingFlag(JAXBElement<Boolean> value) {
        this.contractManufacturingFlag = value;
    }

    /**
     * Gets the value of the daysOfCover property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDaysOfCover() {
        return daysOfCover;
    }

    /**
     * Sets the value of the daysOfCover property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDaysOfCover(JAXBElement<BigDecimal> value) {
        this.daysOfCover = value;
    }

    /**
     * Gets the value of the demandPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDemandPeriod() {
        return demandPeriod;
    }

    /**
     * Sets the value of the demandPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDemandPeriod(JAXBElement<BigDecimal> value) {
        this.demandPeriod = value;
    }

    /**
     * Gets the value of the safetyStockPlanningMethodValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSafetyStockPlanningMethodValue() {
        return safetyStockPlanningMethodValue;
    }

    /**
     * Sets the value of the safetyStockPlanningMethodValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSafetyStockPlanningMethodValue(JAXBElement<String> value) {
        this.safetyStockPlanningMethodValue = value;
    }

    /**
     * Gets the value of the outsideProcessServiceFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getOutsideProcessServiceFlag() {
        return outsideProcessServiceFlag;
    }

    /**
     * Sets the value of the outsideProcessServiceFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setOutsideProcessServiceFlag(JAXBElement<Boolean> value) {
        this.outsideProcessServiceFlag = value;
    }

    /**
     * Gets the value of the allowMaintenanceAssetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAllowMaintenanceAssetFlag() {
        return allowMaintenanceAssetFlag;
    }

    /**
     * Sets the value of the allowMaintenanceAssetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAllowMaintenanceAssetFlag(JAXBElement<Boolean> value) {
        this.allowMaintenanceAssetFlag = value;
    }

    /**
     * Gets the value of the enableGenealogyTrackingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEnableGenealogyTrackingFlag() {
        return enableGenealogyTrackingFlag;
    }

    /**
     * Sets the value of the enableGenealogyTrackingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEnableGenealogyTrackingFlag(JAXBElement<Boolean> value) {
        this.enableGenealogyTrackingFlag = value;
    }

    /**
     * Gets the value of the cssEnabledFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCssEnabledFlag() {
        return cssEnabledFlag;
    }

    /**
     * Sets the value of the cssEnabledFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCssEnabledFlag(JAXBElement<Boolean> value) {
        this.cssEnabledFlag = value;
    }

    /**
     * Gets the value of the engineeredItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEngineeredItemFlag() {
        return engineeredItemFlag;
    }

    /**
     * Sets the value of the engineeredItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEngineeredItemFlag(JAXBElement<Boolean> value) {
        this.engineeredItemFlag = value;
    }

    /**
     * Gets the value of the standardCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStandardCoverage() {
        return standardCoverage;
    }

    /**
     * Sets the value of the standardCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStandardCoverage(JAXBElement<String> value) {
        this.standardCoverage = value;
    }

    /**
     * Gets the value of the itemCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemCategory }
     * 
     * 
     */
    public List<ItemCategory> getItemCategory() {
        if (itemCategory == null) {
            itemCategory = new ArrayList<ItemCategory>();
        }
        return this.itemCategory;
    }

    /**
     * Gets the value of the itemSupplierAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemSupplierAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemSupplierAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemSupplierAssociation }
     * 
     * 
     */
    public List<ItemSupplierAssociation> getItemSupplierAssociation() {
        if (itemSupplierAssociation == null) {
            itemSupplierAssociation = new ArrayList<ItemSupplierAssociation>();
        }
        return this.itemSupplierAssociation;
    }

    /**
     * Gets the value of the itemTranslation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemTranslation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemTranslation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemTranslation }
     * 
     * 
     */
    public List<ItemTranslation> getItemTranslation() {
        if (itemTranslation == null) {
            itemTranslation = new ArrayList<ItemTranslation>();
        }
        return this.itemTranslation;
    }

    /**
     * Gets the value of the itemRevision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemRevision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemRevision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemRevision }
     * 
     * 
     */
    public List<ItemRevision> getItemRevision() {
        if (itemRevision == null) {
            itemRevision = new ArrayList<ItemRevision>();
        }
        return this.itemRevision;
    }

    /**
     * Gets the value of the itemEffCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JItemEffCategory }
     *     
     */
    public JItemEffCategory getItemEffCategory() {
        return itemEffCategory;
    }

    /**
     * Sets the value of the itemEffCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JItemEffCategory }
     *     
     */
    public void setItemEffCategory(JItemEffCategory value) {
        this.itemEffCategory = value;
    }

    /**
     * Gets the value of the itemDFF property.
     * 
     * @return
     *     possible object is
     *     {@link ItemDFF }
     *     
     */
    public ItemDFF getItemDFF() {
        return itemDFF;
    }

    /**
     * Sets the value of the itemDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemDFF }
     *     
     */
    public void setItemDFF(ItemDFF value) {
        this.itemDFF = value;
    }

    /**
     * Gets the value of the itemGlobalDFF property.
     * 
     * @return
     *     possible object is
     *     {@link ItemGdf }
     *     
     */
    public ItemGdf getItemGlobalDFF() {
        return itemGlobalDFF;
    }

    /**
     * Sets the value of the itemGlobalDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemGdf }
     *     
     */
    public void setItemGlobalDFF(ItemGdf value) {
        this.itemGlobalDFF = value;
    }

    /**
     * Gets the value of the itemAttachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemAttachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemAttachment }
     * 
     * 
     */
    public List<ItemAttachment> getItemAttachment() {
        if (itemAttachment == null) {
            itemAttachment = new ArrayList<ItemAttachment>();
        }
        return this.itemAttachment;
    }

}
