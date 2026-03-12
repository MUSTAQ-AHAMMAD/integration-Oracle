package innovate.tamergroup.persistence.session;

import innovate.tamergroup.persistence.entities.BackupVendhqLineItems;
import innovate.tamergroup.persistence.entities.BackupVendhqPayments;
import innovate.tamergroup.persistence.entities.BackupVendhqPromotions;
import innovate.tamergroup.persistence.entities.BackupVendhqSales;
import innovate.tamergroup.persistence.entities.FusionApplyReceipt;
import innovate.tamergroup.persistence.entities.FusionBusinessUnitIdMap;
import innovate.tamergroup.persistence.entities.FusionCredentials;
import innovate.tamergroup.persistence.entities.FusionInvTxn;
import innovate.tamergroup.persistence.entities.FusionInvoiceHeader;
import innovate.tamergroup.persistence.entities.FusionInvoiceLine;
import innovate.tamergroup.persistence.entities.FusionMiscReceipt;
import innovate.tamergroup.persistence.entities.FusionReceiptMethod;
import innovate.tamergroup.persistence.entities.FusionSalesMetadata;
import innovate.tamergroup.persistence.entities.FusionStandardReceipt;
import innovate.tamergroup.persistence.entities.FusionTransactionLines;
import innovate.tamergroup.persistence.entities.NotificationEmailRecipients;
import innovate.tamergroup.persistence.entities.OpencartGlobalSites;
import innovate.tamergroup.persistence.entities.OpeningBalanceDB;
import innovate.tamergroup.persistence.entities.SalesIntegrationStatus;
import innovate.tamergroup.persistence.entities.ServiceProviderJournalMapping;
import innovate.tamergroup.persistence.entities.TxnQuantityDecimals;
import innovate.tamergroup.persistence.entities.VendhqBrandMeta;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.entities.VendhqRegisters;
import innovate.tamergroup.persistence.entities.VendhqSaleItemsOnhand;
import innovate.tamergroup.persistence.entities.VendhqServiceProviders;
import innovate.tamergroup.persistence.entities.VendhqTaxMeta;

import java.math.BigDecimal;

import java.text.ParseException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;

@Local
public interface SessionEJBLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    public void commit();

    public Integer getSessionRequestID();

    VendhqOutletsDB persistVendhqOutletsDB(VendhqOutletsDB vendhqOutletsDB);

    VendhqOutletsDB mergeVendhqOutletsDB(VendhqOutletsDB vendhqOutletsDB);

    void removeVendhqOutletsDB(VendhqOutletsDB vendhqOutletsDB);

    List<VendhqOutletsDB> getVendhqOutletsDBFindAll();
    
    List<VendhqOutletsDB> getVendhqOutletsByRegion(String region);

    VendhqBrandMeta persistVendhqBrandMeta(VendhqBrandMeta vendhqBrandMeta);

    VendhqBrandMeta mergeVendhqBrandMeta(VendhqBrandMeta vendhqBrandMeta);

    void removeVendhqBrandMeta(VendhqBrandMeta vendhqBrandMeta);

    List<VendhqBrandMeta> getVendhqBrandMetaFindAll();

    VendhqTaxMeta persistVendhqTaxMeta(VendhqTaxMeta vendhqTaxMeta);

    VendhqTaxMeta mergeVendhqTaxMeta(VendhqTaxMeta vendhqTaxMeta);

    void removeVendhqTaxMeta(VendhqTaxMeta vendhqTaxMeta);

    List<VendhqTaxMeta> getVendhqTaxMetaFindAll();

    VendhqItemMeta persistVendhqItemMeta(VendhqItemMeta vendhqItemMeta);

    VendhqItemMeta mergeVendhqItemMeta(VendhqItemMeta vendhqItemMeta);

    void removeVendhqItemMeta(VendhqItemMeta vendhqItemMeta);

    List<VendhqItemMeta> getVendhqItemMetaFindAll();

    String getGetVendHqItemId(BigDecimal sourceId, String region);

    Date getGetVenHqItemsLastRequestDate();

    VendhqItemMeta getGetVendHqItemRow(BigDecimal requestId, BigDecimal sourceId);

    List<FusionReceiptMethod> getFusionReceiptMethodFindAll();

    List<FusionSalesMetadata> getFusionSalesMetadataFindAll();

    VendhqItemMeta getGetVendHqItemRowProductId(String itemId);

    VendhqTaxMeta getGetTaxRow(String taxId);

    VendhqOutletsDB getOutletDetails(String outletId);

    VendhqRegisters persistVendhqRegisters(VendhqRegisters vendhqRegisters);

    VendhqRegisters mergeVendhqRegisters(VendhqRegisters vendhqRegisters);

    void removeVendhqRegisters(VendhqRegisters vendhqRegisters);

    void refreshVendhqRegisters(VendhqRegisters vendhqRegisters);

    List<VendhqRegisters> getVendhqRegistersFindAll();

    VendhqRegisters getRegisterDetails(String registerId);

    FusionInvoiceLine persistFusionInvoiceLine(FusionInvoiceLine fusionInvoiceLine);

    FusionInvoiceLine mergeFusionInvoiceLine(FusionInvoiceLine fusionInvoiceLine);

    void removeFusionInvoiceLine(FusionInvoiceLine fusionInvoiceLine);

    List<FusionInvoiceLine> getFusionInvoiceLineFindAll();

    FusionStandardReceipt persistFusionStandardReceipt(FusionStandardReceipt fusionStandardReceipt);

    FusionStandardReceipt mergeFusionStandardReceipt(FusionStandardReceipt fusionStandardReceipt);

    void removeFusionStandardReceipt(FusionStandardReceipt fusionStandardReceipt);

    List<FusionStandardReceipt> getFusionStandardReceiptFindAll();

    FusionInvoiceHeader persistFusionInvoiceHeader(FusionInvoiceHeader fusionInvoiceHeader);

    FusionInvoiceHeader mergeFusionInvoiceHeader(FusionInvoiceHeader fusionInvoiceHeader);

    void removeFusionInvoiceHeader(FusionInvoiceHeader fusionInvoiceHeader);

    List<FusionInvoiceHeader> getFusionInvoiceHeaderFindAll();

    FusionApplyReceipt persistFusionApplyReceipt(FusionApplyReceipt fusionApplyReceipt);

    FusionApplyReceipt mergeFusionApplyReceipt(FusionApplyReceipt fusionApplyReceipt);

    void removeFusionApplyReceipt(FusionApplyReceipt fusionApplyReceipt);

    List<FusionApplyReceipt> getFusionApplyReceiptFindAll();

    FusionTransactionLines persistFusionTransactionLines(FusionTransactionLines fusionTransactionLines);

    FusionTransactionLines mergeFusionTransactionLines(FusionTransactionLines fusionTransactionLines);

    void removeFusionTransactionLines(FusionTransactionLines fusionTransactionLines);

    List<FusionTransactionLines> getFusionTransactionLinesFindAll();

    FusionMiscReceipt persistFusionMiscReceipt(FusionMiscReceipt fusionMiscReceipt);

    FusionMiscReceipt mergeFusionMiscReceipt(FusionMiscReceipt fusionMiscReceipt);

    void removeFusionMiscReceipt(FusionMiscReceipt fusionMiscReceipt);

    List<FusionMiscReceipt> getFusionMiscReceiptFindAll();

    FusionSalesMetadata getFindSalesMetaData(String subInventory, String integrationSource, String region, String customerType);

    FusionReceiptMethod getReceiptMethod(String methodName);

    List<OpeningBalanceDB> getOpeningBalanceDBFindAll();

    OpeningBalanceDB getOpeningBalanceDBFindItemRow(String itemCode);

    FusionInvTxn persistFusionInvTxn(FusionInvTxn fusionInvTxn);

    FusionInvTxn mergeFusionInvTxn(FusionInvTxn fusionInvTxn);

    void removeFusionInvTxn(FusionInvTxn fusionInvTxn);

    List<FusionInvTxn> getFusionInvTxnFindAll();

    VendhqCredentials persistVendhqCredentials(VendhqCredentials vendhqCredentials);

    VendhqCredentials mergeVendhqCredentials(VendhqCredentials vendhqCredentials);

    void removeVendhqCredentials(VendhqCredentials vendhqCredentials);

    List<VendhqCredentials> getVendhqCredentialsFindAll();

    FusionCredentials persistFusionCredentials(FusionCredentials fusionCredentials);

    FusionCredentials mergeFusionCredentials(FusionCredentials fusionCredentials);

    void removeFusionCredentials(FusionCredentials fusionCredentials);

    List<FusionCredentials> getFusionCredentialsFindAll();

    VendhqCredentials getVendHqCredential();

    FusionCredentials getFusionCredential();

    Long getOutletsMaxVersion();

    Long getRegisterMaxVersion();

    Long getVendHqTaxMaxVersion();

    Long getVendhqBrandMetaMaxVersion();

    Date getGetVenHqItemsLastUpdatedDate(String region);

    String getVendHQItemIDFromNumber(String itemNumber, String region);

    NotificationEmailRecipients persistNotificationEmailRecipients(NotificationEmailRecipients notificationEmailRecipients);

    NotificationEmailRecipients mergeNotificationEmailRecipients(NotificationEmailRecipients notificationEmailRecipients);

    void removeNotificationEmailRecipients(NotificationEmailRecipients notificationEmailRecipients);

    List<NotificationEmailRecipients> getNotificationEmailRecipientsFindAll();

    List<NotificationEmailRecipients> getNotificationEmailRecipientsFindActive();

    String getFusionInvoiceLineFindSalesTxnLine(String salesOrder, BigDecimal salesOrderLine, BigDecimal version, String region);

    Long getLastSalesTxnVersion(String region);

    Date getLastSalesTxnDate(String region, Boolean isManual, Date startDate) throws ParseException;

    VendhqItemMeta getVendHQItemRowFusion(String itemNumber, String region);

    List<OpencartGlobalSites> getOpencartGlobalSitesFindAll();

    Boolean getFindStandardReceipt(String receiptNumber, String region);

    Boolean getFindMiscReceipt(String receiptNumber, String region);

    Boolean getFindInvTxn(String salesOrder, Date saleDate, String itemNumber, String region);

    Boolean getFindApplyReceipt(String receiptNumber, String region);

    VendhqSaleItemsOnhand persistVendhqSaleItemsOnhand(VendhqSaleItemsOnhand vendhqSaleItemsOnhand);

    VendhqSaleItemsOnhand mergeVendhqSaleItemsOnhand(VendhqSaleItemsOnhand vendhqSaleItemsOnhand);

    void removeVendhqSaleItemsOnhand(VendhqSaleItemsOnhand vendhqSaleItemsOnhand);

    List<VendhqSaleItemsOnhand> getVendhqSaleItemsOnhandFindAll();

    VendhqSaleItemsOnhand getFindItemOnHandRow(String productId, String outletId);

    BackupVendhqPayments persistBackupVendhqPayments(BackupVendhqPayments backupVendhqPayments);

    BackupVendhqPayments mergeBackupVendhqPayments(BackupVendhqPayments backupVendhqPayments);

    void removeBackupVendhqPayments(BackupVendhqPayments backupVendhqPayments);

    List<BackupVendhqPayments> getBackupVendhqPaymentsFindAll();

    FusionSalesMetadata persistFusionSalesMetadata(FusionSalesMetadata fusionSalesMetadata);

    FusionSalesMetadata mergeFusionSalesMetadata(FusionSalesMetadata fusionSalesMetadata);

    void removeFusionSalesMetadata(FusionSalesMetadata fusionSalesMetadata);

    BackupVendhqPromotions persistBackupVendhqPromotions(BackupVendhqPromotions backupVendhqPromotions);

    BackupVendhqPromotions mergeBackupVendhqPromotions(BackupVendhqPromotions backupVendhqPromotions);

    void removeBackupVendhqPromotions(BackupVendhqPromotions backupVendhqPromotions);

    List<BackupVendhqPromotions> getBackupVendhqPromotionsFindAll();

    OpeningBalanceDB persistOpeningBalanceDB(OpeningBalanceDB openingBalanceDB);

    OpeningBalanceDB mergeOpeningBalanceDB(OpeningBalanceDB openingBalanceDB);

    void removeOpeningBalanceDB(OpeningBalanceDB openingBalanceDB);

    BackupVendhqSales persistBackupVendhqSales(BackupVendhqSales backupVendhqSales);

    BackupVendhqSales mergeBackupVendhqSales(BackupVendhqSales backupVendhqSales);

    void removeBackupVendhqSales(BackupVendhqSales backupVendhqSales);

    List<BackupVendhqSales> getBackupVendhqSalesFindAll();

    FusionReceiptMethod persistFusionReceiptMethod(FusionReceiptMethod fusionReceiptMethod);

    FusionReceiptMethod mergeFusionReceiptMethod(FusionReceiptMethod fusionReceiptMethod);

    void removeFusionReceiptMethod(FusionReceiptMethod fusionReceiptMethod);

    BackupVendhqLineItems persistBackupVendhqLineItems(BackupVendhqLineItems backupVendhqLineItems);

    BackupVendhqLineItems mergeBackupVendhqLineItems(BackupVendhqLineItems backupVendhqLineItems);

    void removeBackupVendhqLineItems(BackupVendhqLineItems backupVendhqLineItems);

    List<BackupVendhqLineItems> getBackupVendhqLineItemsFindAll();

    OpencartGlobalSites persistOpencartGlobalSites(OpencartGlobalSites opencartGlobalSites);

    OpencartGlobalSites mergeOpencartGlobalSites(OpencartGlobalSites opencartGlobalSites);

    void removeOpencartGlobalSites(OpencartGlobalSites opencartGlobalSites);

    Long getLastSaleVersionBackup(String region);

    BigDecimal getItemSoldQuantity(String itemNumber, String outletName);

    List<BackupVendhqSales> getSalesOutletBtwDate(String outletName, String region, Date processDate, BigDecimal timeZoneOffset);

    List<BackupVendhqPayments> getPaymentsByInvoiceNumber(String invoiceNumber, Date saleDate, String region);

    List<BackupVendhqLineItems> getLineItemsByInvoice(String invoiceNumber, Date saleDate, String region);

    VendhqRegisters getRegisterDetailsByName(String registerName, String region);

    Boolean getIsSalesExists(String invoiceNumber, Date saleDate);
    
    FusionReceiptMethod getReceiptMethodByRegion(String receiptMethodName, String region);
    
    List<VendhqTaxMeta> getVendhqTaxMetaFindAllByRegion(String region, String taxName);
    
    String getOutletIntegStatus(String outletName, String region);
    
    List<String> getOutletsByStatus(String integMode, String region);
    
    VendhqOutletsDB getOutletDetailsByName(String outletName, String region);
    
    VendhqCredentials getVendHqCredentialByRegion(String region);
    
    String getDiscountItemByRegion(String region);
    
    SalesIntegrationStatus getSalesIntegrationStatus(String region, String integMode);
    
    SalesIntegrationStatus mergeSalesIntegrationStatus(SalesIntegrationStatus salesIntegrationStatus);
    
    List<TxnQuantityDecimals> getTxnQtyDecimalsByRegion(String region);
    
    FusionBusinessUnitIdMap getFusionBusinessUnitIdMapfindByRegion(String region);
    
    Boolean getFindJournalHeader(Long txnNumber, String customerType, String cashCredit, String region);
    
    VendhqServiceProviders getGetVendHqServiceProviderByCustomerId(String region, String customerId);
    
    ServiceProviderJournalMapping getServiceProviderMappingByRegion(String serviceProvider, String creditDebit, String region, Boolean isCash);
    
    HashMap<String, FusionSalesMetadata> getFindSalesMetaDataAll(String subInventory, String integrationSource, String region);
}
