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

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "SessionEJB", mappedName = "Fusion VendHQ Opencart Integration-JPAProject-SessionEJB")
public class SessionEJBBean implements SessionEJB, SessionEJBLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "JPAProject")
    private EntityManager em;

    public SessionEJBBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }


    public void commit() {
        em.getTransaction().commit();
    }

    public Integer getSessionRequestID() {
        return Integer.parseInt(em.createNativeQuery("SELECT REQUEST_SEQ_GEN.NEXTVAL FROM DUAL").getSingleResult() +
                                "");
    }

    public VendhqOutletsDB persistVendhqOutletsDB(VendhqOutletsDB vendhqOutletsDB) {
        em.persist(vendhqOutletsDB);
        return vendhqOutletsDB;
    }

    public VendhqOutletsDB mergeVendhqOutletsDB(VendhqOutletsDB vendhqOutletsDB) {
        return em.merge(vendhqOutletsDB);
    }

    public void removeVendhqOutletsDB(VendhqOutletsDB vendhqOutletsDB) {
        vendhqOutletsDB = em.find(VendhqOutletsDB.class, vendhqOutletsDB.getOutletId());
        em.remove(vendhqOutletsDB);
    }

    /** <code>select o from VendhqOutletsDB o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqOutletsDB> getVendhqOutletsDBFindAll() {
        return em.createNamedQuery("VendhqOutletsDB.findAll", VendhqOutletsDB.class).getResultList();
    }
    
    public List<VendhqOutletsDB> getVendhqOutletsByRegion(String region) {
        return em.createNamedQuery("VendhqOutletsByRegion", VendhqOutletsDB.class)
                 .setParameter("region", region)
                 .getResultList();
    }

    public VendhqBrandMeta persistVendhqBrandMeta(VendhqBrandMeta vendhqBrandMeta) {
        em.persist(vendhqBrandMeta);
        return vendhqBrandMeta;
    }

    public VendhqBrandMeta mergeVendhqBrandMeta(VendhqBrandMeta vendhqBrandMeta) {
        return em.merge(vendhqBrandMeta);
    }

    public void removeVendhqBrandMeta(VendhqBrandMeta vendhqBrandMeta) {
        vendhqBrandMeta = em.find(VendhqBrandMeta.class, vendhqBrandMeta.getBrandId());
        em.remove(vendhqBrandMeta);
    }

    /** <code>select o from VendhqBrandMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqBrandMeta> getVendhqBrandMetaFindAll() {
        return em.createNamedQuery("VendhqBrandMeta.findAll", VendhqBrandMeta.class).getResultList();
    }

    public VendhqTaxMeta persistVendhqTaxMeta(VendhqTaxMeta vendhqTaxMeta) {
        em.persist(vendhqTaxMeta);
        return vendhqTaxMeta;
    }

    public VendhqTaxMeta mergeVendhqTaxMeta(VendhqTaxMeta vendhqTaxMeta) {
        return em.merge(vendhqTaxMeta);
    }

    public void removeVendhqTaxMeta(VendhqTaxMeta vendhqTaxMeta) {
        vendhqTaxMeta = em.find(VendhqTaxMeta.class, vendhqTaxMeta.getTaxId());
        em.remove(vendhqTaxMeta);
    }

    /** <code>select o from VendhqTaxMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqTaxMeta> getVendhqTaxMetaFindAll() {
        return em.createNamedQuery("VendhqTaxMeta.findAll", VendhqTaxMeta.class).getResultList();
    }
    
    /** <code>select o from VendhqTaxMeta o where o.region = :region and o.taxName = :taxName</code> */
    public List<VendhqTaxMeta> getVendhqTaxMetaFindAllByRegion(String region, String taxName) {
        if (taxName != null) return em.createNamedQuery("VendhqTaxMetaFindAllByRegion", VendhqTaxMeta.class)
                 .setParameter("region", region)
                 .setParameter("taxName", taxName)
                 .getResultList();
        else return em.createNamedQuery("VendhqTaxMetaFindAllByRegionNameNull", VendhqTaxMeta.class)
                 .setParameter("region", region)
                 .getResultList();
    }

    public VendhqItemMeta persistVendhqItemMeta(VendhqItemMeta vendhqItemMeta) {
        em.persist(vendhqItemMeta);
        return vendhqItemMeta;
    }

    public VendhqItemMeta mergeVendhqItemMeta(VendhqItemMeta vendhqItemMeta) {
        return em.merge(vendhqItemMeta);
    }

    public void removeVendhqItemMeta(VendhqItemMeta vendhqItemMeta) {
        vendhqItemMeta = em.find(VendhqItemMeta.class, vendhqItemMeta.getRowId());
        em.remove(vendhqItemMeta);
    }

    /** <code>select o from VendhqItemMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqItemMeta> getVendhqItemMetaFindAll() {
        return em.createNamedQuery("VendhqItemMeta.findAll", VendhqItemMeta.class).getResultList();
    }

    /** <code>select distinct(o.itemId) from VendhqItemMeta o where o.sourceId = :sourceId</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String getGetVendHqItemId(BigDecimal sourceId, String region) {
        List<String> itemIds = em.createNamedQuery("getVendHqItemId", String.class)
                                 .setParameter("sourceId", sourceId)
                                 .setParameter("region", region)
                                 .getResultList();
        if (itemIds.isEmpty())
            return null;
        else
            return itemIds.get(0);
    }

    /** <code>select max(o.requestDate) from VendhqItemMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Date getGetVenHqItemsLastRequestDate() {
        List<Date> requestedDates = em.createNamedQuery("getVenHqItemsLastRequestDate", Date.class).getResultList();
        if (requestedDates.isEmpty())
            return null;
        else
            return requestedDates.get(0);
    }

    /** <code>select o from VendhqItemMeta o where o.requestId = :requestId and o.sourceId = :sourceId</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqItemMeta getGetVendHqItemRow(BigDecimal requestId, BigDecimal sourceId) {
        List<VendhqItemMeta> dbRows = em.createNamedQuery("getVendHqItemRow", VendhqItemMeta.class)
                                        .setParameter("requestId", requestId)
                                        .setParameter("sourceId", sourceId)
                                        .getResultList();
        if (!dbRows.isEmpty())
            return dbRows.get(0);
        else
            return null;
    }

    /** <code>select o from FusionReceiptMethod o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionReceiptMethod> getFusionReceiptMethodFindAll() {
        return em.createNamedQuery("FusionReceiptMethod.findAll", FusionReceiptMethod.class).getResultList();
    }

    /** <code>select o from FusionSalesMetadata o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionSalesMetadata> getFusionSalesMetadataFindAll() {
        return em.createNamedQuery("FusionSalesMetadata.findAll", FusionSalesMetadata.class).getResultList();
    }

    /** <code>select o from VendhqItemMeta o where o.itemId = :itemId and o.requestId = (select max(o.requestId) from VendhqItemMeta o where o.itemId = :itemId)</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqItemMeta getGetVendHqItemRowProductId(String itemId) {
        List<VendhqItemMeta> itemList = em.createNamedQuery("getVendHqItemRowProductId", VendhqItemMeta.class)
                                          .setParameter("itemId", itemId)
                                          .getResultList();
        if (itemList.isEmpty())
            throw new NoResultException("This product# " + itemId + " is not present in Fusion. Please create this item in Fusion and refrain from creating items in VendHQ!");
        else
            return itemList.get(0);
    }
    
    /** <code>select o from VendhqServiceProviders o where o.region = :region and o.vendHqCustomerId = :vendHqCustomerId</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqServiceProviders getGetVendHqServiceProviderByCustomerId(String region, String vendHqCustomerId) {
        if (vendHqCustomerId == null) return null;
        List<VendhqServiceProviders> serviceProviderList = em.createNamedQuery("VendhqServiceProvidersByRegionAndCustomerID", VendhqServiceProviders.class)
                                          .setParameter("vendHqCustomerId", vendHqCustomerId)
                                          .setParameter("region", region)
                                          .getResultList();
        if (serviceProviderList.isEmpty())
            return null;
        else
            return serviceProviderList.get(0);
    }

    /** <code>select o from VendhqTaxMeta o where o.taxId = :taxId</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqTaxMeta getGetTaxRow(String taxId) {
        List<VendhqTaxMeta> taxMetas = em.createNamedQuery("getTaxRow", VendhqTaxMeta.class)
                 .setParameter("taxId", taxId)
                 .getResultList();
        if (taxMetas == null || taxMetas.isEmpty()) return null;
        else return taxMetas.get(0);
    }

    /** <code>select o from VendhqOutletsDB o where o.outletId = :outletId</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqOutletsDB getOutletDetails(String outletId) {
        return em.createNamedQuery("OutletDetails", VendhqOutletsDB.class)
                 .setParameter("outletId", outletId)
                 .getSingleResult();
    }

    public VendhqRegisters persistVendhqRegisters(VendhqRegisters vendhqRegisters) {
        em.persist(vendhqRegisters);
        return vendhqRegisters;
    }

    public VendhqRegisters mergeVendhqRegisters(VendhqRegisters vendhqRegisters) {
        return em.merge(vendhqRegisters);
    }

    public void removeVendhqRegisters(VendhqRegisters vendhqRegisters) {
        vendhqRegisters = em.find(VendhqRegisters.class, vendhqRegisters.getRegisterId());
        em.remove(vendhqRegisters);
    }

    /** <code>select o from VendhqRegisters o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqRegisters> getVendhqRegistersFindAll() {
        return em.createNamedQuery("VendhqRegisters.findAll", VendhqRegisters.class).getResultList();
    }

    /** <code>select o from VendhqRegisters o where o.registerId = :registerId</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqRegisters getRegisterDetails(String registerId) {
        return em.find(VendhqRegisters.class, registerId);
    }

    public FusionInvoiceLine persistFusionInvoiceLine(FusionInvoiceLine fusionInvoiceLine) {
        em.persist(fusionInvoiceLine);
        return fusionInvoiceLine;
    }

    public FusionInvoiceLine mergeFusionInvoiceLine(FusionInvoiceLine fusionInvoiceLine) {
        return em.merge(fusionInvoiceLine);
    }

    public void removeFusionInvoiceLine(FusionInvoiceLine fusionInvoiceLine) {
        fusionInvoiceLine = em.find(FusionInvoiceLine.class, fusionInvoiceLine.getRowId());
        em.remove(fusionInvoiceLine);
    }

    /** <code>select o from FusionInvoiceLine o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionInvoiceLine> getFusionInvoiceLineFindAll() {
        return em.createNamedQuery("FusionInvoiceLine.findAll", FusionInvoiceLine.class).getResultList();
    }

    public FusionStandardReceipt persistFusionStandardReceipt(FusionStandardReceipt fusionStandardReceipt) {
        em.persist(fusionStandardReceipt);
        return fusionStandardReceipt;
    }

    public FusionStandardReceipt mergeFusionStandardReceipt(FusionStandardReceipt fusionStandardReceipt) {
        return em.merge(fusionStandardReceipt);
    }

    public void removeFusionStandardReceipt(FusionStandardReceipt fusionStandardReceipt) {
        fusionStandardReceipt = em.find(FusionStandardReceipt.class, fusionStandardReceipt.getRowId());
        em.remove(fusionStandardReceipt);
    }

    /** <code>select o from FusionStandardReceipt o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionStandardReceipt> getFusionStandardReceiptFindAll() {
        return em.createNamedQuery("FusionStandardReceipt.findAll", FusionStandardReceipt.class).getResultList();
    }

    public FusionInvoiceHeader persistFusionInvoiceHeader(FusionInvoiceHeader fusionInvoiceHeader) {
        em.persist(fusionInvoiceHeader);
        return fusionInvoiceHeader;
    }

    public FusionInvoiceHeader mergeFusionInvoiceHeader(FusionInvoiceHeader fusionInvoiceHeader) {
        return em.merge(fusionInvoiceHeader);
    }

    public void removeFusionInvoiceHeader(FusionInvoiceHeader fusionInvoiceHeader) {
        fusionInvoiceHeader = em.find(FusionInvoiceHeader.class, fusionInvoiceHeader.getRowId());
        em.remove(fusionInvoiceHeader);
    }

    /** <code>select o from FusionInvoiceHeader o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionInvoiceHeader> getFusionInvoiceHeaderFindAll() {
        return em.createNamedQuery("FusionInvoiceHeader.findAll", FusionInvoiceHeader.class).getResultList();
    }

    public FusionApplyReceipt persistFusionApplyReceipt(FusionApplyReceipt fusionApplyReceipt) {
        em.persist(fusionApplyReceipt);
        return fusionApplyReceipt;
    }

    public FusionApplyReceipt mergeFusionApplyReceipt(FusionApplyReceipt fusionApplyReceipt) {
        return em.merge(fusionApplyReceipt);
    }

    public void removeFusionApplyReceipt(FusionApplyReceipt fusionApplyReceipt) {
        fusionApplyReceipt = em.find(FusionApplyReceipt.class, fusionApplyReceipt.getRowId());
        em.remove(fusionApplyReceipt);
    }

    /** <code>select o from FusionApplyReceipt o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionApplyReceipt> getFusionApplyReceiptFindAll() {
        return em.createNamedQuery("FusionApplyReceipt.findAll", FusionApplyReceipt.class).getResultList();
    }

    public FusionTransactionLines persistFusionTransactionLines(FusionTransactionLines fusionTransactionLines) {
        em.persist(fusionTransactionLines);
        return fusionTransactionLines;
    }

    public FusionTransactionLines mergeFusionTransactionLines(FusionTransactionLines fusionTransactionLines) {
        return em.merge(fusionTransactionLines);
    }

    public void removeFusionTransactionLines(FusionTransactionLines fusionTransactionLines) {
        fusionTransactionLines = em.find(FusionTransactionLines.class, fusionTransactionLines.getRowId());
        em.remove(fusionTransactionLines);
    }

    /** <code>select o from FusionTransactionLines o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionTransactionLines> getFusionTransactionLinesFindAll() {
        return em.createNamedQuery("FusionTransactionLines.findAll", FusionTransactionLines.class).getResultList();
    }

    public FusionMiscReceipt persistFusionMiscReceipt(FusionMiscReceipt fusionMiscReceipt) {
        em.persist(fusionMiscReceipt);
        return fusionMiscReceipt;
    }

    public FusionMiscReceipt mergeFusionMiscReceipt(FusionMiscReceipt fusionMiscReceipt) {
        return em.merge(fusionMiscReceipt);
    }

    public void removeFusionMiscReceipt(FusionMiscReceipt fusionMiscReceipt) {
        fusionMiscReceipt = em.find(FusionMiscReceipt.class, fusionMiscReceipt.getRowId());
        em.remove(fusionMiscReceipt);
    }

    /** <code>select o from FusionMiscReceipt o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionMiscReceipt> getFusionMiscReceiptFindAll() {
        return em.createNamedQuery("FusionMiscReceipt.findAll", FusionMiscReceipt.class).getResultList();
    }

    /** <code>select o from FusionSalesMetadata o where o.subInventory = :subInventory and o.integrationSource = :integrationSource</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public FusionSalesMetadata getFindSalesMetaData(String subInventory, String integrationSource, String region, String customerType) {
        return em.createNamedQuery("findSalesMetaData", FusionSalesMetadata.class)
                 .setParameter("subInventory", subInventory)
                 .setParameter("integrationSource", integrationSource)
                 .setParameter("region", region)
                 .setParameter("customerType", customerType)
                 .getSingleResult();
    }
    
    /** <code>select o from FusionSalesMetadata o where o.subInventory = :subInventory and o.integrationSource = :integrationSource</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public HashMap<String, FusionSalesMetadata> getFindSalesMetaDataAll(String subInventory, String integrationSource, String region) {
        List<FusionSalesMetadata> salesMetaDataList = em.createNamedQuery("findSalesMetaDataAll", FusionSalesMetadata.class)
                 .setParameter("subInventory", subInventory)
                 .setParameter("integrationSource", integrationSource)
                 .setParameter("region", region)
                 .getResultList();
        HashMap<String, FusionSalesMetadata> metaDataHashMap = new HashMap<>();
        salesMetaDataList.stream().forEach(metaData -> metaDataHashMap.put(metaData.getCustomerType(), metaData));
        return metaDataHashMap;
    }

    @Override
    public void refreshVendhqRegisters(VendhqRegisters vendhqRegisters) {
        em.refresh(vendhqRegisters);
    }

    /** <code>select o from FusionReceiptMethod o where o.receiptMethodName like :methodName</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public FusionReceiptMethod getReceiptMethod(String methodName) {
        return em.find(FusionReceiptMethod.class, methodName);
    }
    
    public FusionReceiptMethod getReceiptMethodByRegion(String receiptMethodName, String region) {
        return em.createNamedQuery("ReceiptMethodByRegion", FusionReceiptMethod.class)
                 .setParameter("region", region)
                 .setParameter("receiptMethodName", receiptMethodName)
                 .getSingleResult();
    }

    /** <code>select o from OpeningBalanceDB o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<OpeningBalanceDB> getOpeningBalanceDBFindAll() {
        return em.createNamedQuery("OpeningBalanceDB.findAll", OpeningBalanceDB.class).getResultList();
    }

    /** <code>select o from OpeningBalanceDB o where o.itemCode = :itemCode</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public OpeningBalanceDB getOpeningBalanceDBFindItemRow(String itemCode) {
        return em.find(OpeningBalanceDB.class, itemCode);
    }

    public FusionInvTxn persistFusionInvTxn(FusionInvTxn fusionInvTxn) {
        em.persist(fusionInvTxn);
        return fusionInvTxn;
    }

    public FusionInvTxn mergeFusionInvTxn(FusionInvTxn fusionInvTxn) {
        return em.merge(fusionInvTxn);
    }

    public void removeFusionInvTxn(FusionInvTxn fusionInvTxn) {
        fusionInvTxn = em.find(FusionInvTxn.class, fusionInvTxn.getRowId());
        em.remove(fusionInvTxn);
    }

    /** <code>select o from FusionInvTxn o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionInvTxn> getFusionInvTxnFindAll() {
        return em.createNamedQuery("FusionInvTxn.findAll", FusionInvTxn.class).getResultList();
    }

    public VendhqCredentials persistVendhqCredentials(VendhqCredentials vendhqCredentials) {
        em.persist(vendhqCredentials);
        return vendhqCredentials;
    }

    public VendhqCredentials mergeVendhqCredentials(VendhqCredentials vendhqCredentials) {
        return em.merge(vendhqCredentials);
    }

    public void removeVendhqCredentials(VendhqCredentials vendhqCredentials) {
        vendhqCredentials = em.find(VendhqCredentials.class, vendhqCredentials.getRowId());
        em.remove(vendhqCredentials);
    }

    /** <code>select o from VendhqCredentials o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqCredentials> getVendhqCredentialsFindAll() {
        return em.createNamedQuery("VendhqCredentials.findAll", VendhqCredentials.class).getResultList();
    }

    public FusionCredentials persistFusionCredentials(FusionCredentials fusionCredentials) {
        em.persist(fusionCredentials);
        return fusionCredentials;
    }

    public FusionCredentials mergeFusionCredentials(FusionCredentials fusionCredentials) {
        return em.merge(fusionCredentials);
    }

    public void removeFusionCredentials(FusionCredentials fusionCredentials) {
        fusionCredentials = em.find(FusionCredentials.class, fusionCredentials.getRowId());
        em.remove(fusionCredentials);
    }

    /** <code>select o from FusionCredentials o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<FusionCredentials> getFusionCredentialsFindAll() {
        return em.createNamedQuery("FusionCredentials.findAll", FusionCredentials.class).getResultList();
    }

    /** <code>select o from VendhqCredentials o where o.active = 'Y'</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqCredentials getVendHqCredential() {
        List<VendhqCredentials> credentials =
            em.createNamedQuery("VendHqCredential", VendhqCredentials.class).getResultList();
        if (!credentials.isEmpty())
            return credentials.get(0);
        else
            throw new NoResultException("VendHQ Credentials are not configured!!");
    }

    /** <code>select o from FusionCredentials o where o.active = 'Y'</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public FusionCredentials getFusionCredential() {
        List<FusionCredentials> credentials =
            em.createNamedQuery("FusionCredential", FusionCredentials.class).getResultList();
        if (!credentials.isEmpty())
            return credentials.get(0);
        else
            throw new NoResultException("Fusion Credentials are not configured!!");
    }

    /** <code>select max(o.version) from VendhqOutletsDB o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long getOutletsMaxVersion() {
        BigDecimal maxVersion = em.createNamedQuery("OutletsMaxVersion", BigDecimal.class).getSingleResult();
        if (maxVersion != null)
            return maxVersion.longValue();
        else
            return 0L;
    }

    /** <code>select max(o.version) from VendhqRegisters o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long getRegisterMaxVersion() {
        BigDecimal maxVersion = em.createNamedQuery("RegisterMaxVersion", BigDecimal.class).getSingleResult();
        if (maxVersion != null)
            return maxVersion.longValue();
        else
            return 0L;
    }

    /** <code>select max(o.version) from VendhqTaxMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long getVendHqTaxMaxVersion() {
        BigDecimal maxVersion = em.createNamedQuery("VendHqTaxMaxVersion", BigDecimal.class).getSingleResult();
        if (maxVersion != null)
            return maxVersion.longValue();
        else
            return 0L;
    }

    /** <code>select max(o.version) from VendhqBrandMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long getVendhqBrandMetaMaxVersion() {
        BigDecimal maxVersion = em.createNamedQuery("VendhqBrandMetaMaxVersion", BigDecimal.class).getSingleResult();
        if (maxVersion != null)
            return maxVersion.longValue();
        else
            return 0L;
    }

    /** <code>select max(o.lastUpdatedDate) from VendhqItemMeta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Date getGetVenHqItemsLastUpdatedDate(String region) {
        List<Date> timeStamps = em.createNamedQuery("getVenHqItemsLastUpdatedDate", Date.class)
                                  .setParameter("region", region)
                                  .getResultList();
        if (timeStamps.isEmpty())
            return new Date();
        else
            return timeStamps.get(0);
    }

    /** <code>select distinct(o.itemId) from VendhqItemMeta o where o.handle = :itemNumber and o.itemId is not null and o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String getVendHQItemIDFromNumber(String itemNumber, String region) {
        List<String> idList = em.createNamedQuery("VendHQItemIDFromNumber", String.class)
                                .setParameter("itemNumber", itemNumber)
                                .setParameter("region", region)
                                .getResultList();
        if (idList.isEmpty())
            return "";
        else
            return idList.get(0);
    }

    public NotificationEmailRecipients persistNotificationEmailRecipients(NotificationEmailRecipients notificationEmailRecipients) {
        em.persist(notificationEmailRecipients);
        return notificationEmailRecipients;
    }

    public NotificationEmailRecipients mergeNotificationEmailRecipients(NotificationEmailRecipients notificationEmailRecipients) {
        return em.merge(notificationEmailRecipients);
    }

    public void removeNotificationEmailRecipients(NotificationEmailRecipients notificationEmailRecipients) {
        notificationEmailRecipients =
            em.find(NotificationEmailRecipients.class, notificationEmailRecipients.getRowId());
        em.remove(notificationEmailRecipients);
    }

    /** <code>select o from NotificationEmailRecipients o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<NotificationEmailRecipients> getNotificationEmailRecipientsFindAll() {
        return em.createNamedQuery("NotificationEmailRecipients.findAll", NotificationEmailRecipients.class)
               .getResultList();
    }

    /** <code>select o from NotificationEmailRecipients o where o.status = 'Y'</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<NotificationEmailRecipients> getNotificationEmailRecipientsFindActive() {
        return em.createNamedQuery("NotificationEmailRecipients.findActive", NotificationEmailRecipients.class)
               .getResultList();
    }

    /** <code>select o.invoiceNumber from FusionInvoiceLine o where o.salesOrder = :salesOrder and o.salesOrderLine = :salesOrderLine and 
     * o.version = :version and o.region = :region and o.status = 'Success' order by o.requestId desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String getFusionInvoiceLineFindSalesTxnLine(String salesOrder, BigDecimal salesOrderLine, BigDecimal version, String region) {
        List<String> resultSet = em.createNamedQuery("FusionInvoiceLine.findSalesTxnLine", String.class)
                                   .setParameter("salesOrder", salesOrder)
                                   .setParameter("salesOrderLine", salesOrderLine)
                                   .setParameter("region", region)
                                   .setParameter("version", version)
                                   .setMaxResults(1)
                                   .getResultList();
        if (resultSet.isEmpty())
            return null;
        else
            return resultSet.get(0);
    }

    public Long getLastSalesTxnVersion(String region) {
        //List requestList = em.createNativeQuery("SELECT DISTINCT(REQUEST_ID) from FUSION_INVOICE_LINE WHERE SALES_ORDER NOT LIKE 'FLA%' AND REGION LIKE ? ORDER BY REQUEST_ID DESC")
        List requestList = em.createNativeQuery("SELECT DISTINCT(REQUEST_ID) from FUSION_INVOICE_LINE WHERE REGION LIKE ? ORDER BY REQUEST_ID DESC")
                             .setParameter(1, region)
                             .setMaxResults(2)
                             .getResultList();
        System.out.println("requestList:" + requestList);
        if (requestList.isEmpty())
            return 0L;

        BigDecimal version =
            (BigDecimal) em.createNativeQuery("SELECT MAX(VERSION) from FUSION_INVOICE_LINE WHERE REQUEST_ID = ?")
                                            .setParameter(1, requestList.get(getSelectedPosition(requestList.get(0)
                                                                                              .toString(), requestList.size(), region, "")))
                                            .getSingleResult();
        System.out.println("version:" + version);
        return version.longValue();
    }

    public Date getLastSalesTxnDate(String region, Boolean isManual, Date startDate) throws ParseException {
        List<String> manualOutlets = getOutletsByStatus("MANUAL", region);      
        StringBuilder manualCustomerNames = new StringBuilder();
        for (String outlet : manualOutlets) {
            FusionSalesMetadata salesMetadata = getFindSalesMetaData(outlet, "Vend HQ", region, "NORMAL");
            if (salesMetadata != null) manualCustomerNames.append(",'").append(salesMetadata.getBillToName()).append("'");
        }
        
        List<String> automatedOutlets = getOutletsByStatus("AUTOMATIC", region);      
        StringBuilder automatedCustomerNames = new StringBuilder();
        for (String outlet : automatedOutlets) {
            FusionSalesMetadata salesMetadata = getFindSalesMetaData(outlet, "Vend HQ", region, "NORMAL");
            if (salesMetadata != null) automatedCustomerNames.append(",'").append(salesMetadata.getBillToName()).append("'");
        }
        
        String queryURL = null;
        if (isManual && !manualCustomerNames.toString().isEmpty()) 
            queryURL = "SELECT DISTINCT(REQUEST_ID) from FUSION_INVOICE_HEADER WHERE BILL_TO_CUST_NAME IN (" 
                                 + manualCustomerNames.toString().substring(1) 
                                 + ") AND REGION LIKE ? ORDER BY REQUEST_ID DESC";
        else if (!automatedCustomerNames.toString().isEmpty()) 
            queryURL = "SELECT DISTINCT(REQUEST_ID) from FUSION_INVOICE_HEADER WHERE BILL_TO_CUST_NAME IN (" 
                                 + automatedCustomerNames.toString().substring(1) 
                                 + ") AND REGION LIKE ? ORDER BY REQUEST_ID DESC";
        if (queryURL != null) {
            List requestList = em.createNativeQuery(queryURL)
                                 .setParameter(1, region)
                                 .setMaxResults(2)
                                 .getResultList();
            System.out.println("requestList:" + requestList);
            if (requestList.isEmpty()) return startDate;
            
    
            Timestamp lastDate =
                (Timestamp) em.createNativeQuery("SELECT MAX(TXN_DATE) from FUSION_INVOICE_HEADER WHERE REQUEST_ID = ?")
                                               .setParameter(1, requestList.get(getSelectedPosition(requestList.get(0)
                                                                                                 .toString(), 
                                                                                                    requestList.size(), 
                                                                                                    region,
                                                                                                    isManual ? "MANUAL" : "AUTOMATIC")))
                                                .getSingleResult();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Date: " + lastDate);
            return format.parse(lastDate.toString());
        } else return startDate;
    }

    public int getSelectedPosition(String requestId, int size, String region, String integrationMode) {
        List invoiceStatusList = em.createNativeQuery("SELECT DISTINCT(STATUS) from FUSION_INVOICE_LINE WHERE REQUEST_ID = ?")
                                   .setParameter(1, requestId)
                                   .getResultList();
        System.out.println("invoiceStatusList:" + invoiceStatusList);
        List stdRecStatusList =
            em.createNativeQuery("SELECT DISTINCT(STATUS) from FUSION_STANDARD_RECEIPT WHERE REQUEST_ID" +
                                 "= (SELECT MAX(REQUEST_ID) FROM FUSION_STANDARD_RECEIPT WHERE REGION = ? AND INTEG_MODE = ?)")
                .setParameter(1, region)
                .setParameter(2, integrationMode)
                .getResultList();
        System.out.println("stdRecStatusList:" + stdRecStatusList);
        List stdRecApplyStatusList =
            em.createNativeQuery("SELECT DISTINCT(STATUS) from FUSION_APPLY_RECEIPT WHERE REQUEST_ID" +
                                 "= (SELECT MAX(REQUEST_ID) FROM FUSION_APPLY_RECEIPT WHERE REGION = ? AND INTEG_MODE = ?)")
            .setParameter(1, region)
            .setParameter(2, integrationMode)
            .getResultList();
        System.out.println("stdRecApplyStatusList:" + stdRecApplyStatusList);
        List miscRecStatusList =
            em.createNativeQuery("SELECT DISTINCT(STATUS) from FUSION_MISC_RECEIPT WHERE REQUEST_ID" +
                                 "= (SELECT MAX(REQUEST_ID) FROM FUSION_MISC_RECEIPT WHERE REGION = ? AND INTEG_MODE = ?)")
            .setParameter(1, region)
            .setParameter(2, integrationMode)
            .getResultList();
        System.out.println("miscRecStatusList:" + miscRecStatusList);
        List invTxnStatusList =
            em.createNativeQuery("SELECT DISTINCT(STATUS) from FUSION_INV_TXN WHERE REQUEST_ID " +
                                 "= (SELECT MAX(REQUEST_ID) FROM FUSION_INV_TXN WHERE REGION = ? AND INTEG_MODE = ?)")
            .setParameter(1, region)
            .setParameter(2, integrationMode)
            .getResultList();
        System.out.println("invTxnStatusList:" + invTxnStatusList);
        List journalEntryList =
            em.createNativeQuery("SELECT DISTINCT(STATUS) from FUSION_JOURNAL_HEADER WHERE REQUEST_ID " +
                                 "= (SELECT MAX(REQUEST_ID) FROM FUSION_JOURNAL_HEADER WHERE REGION = ? AND INTEG_MODE = ?)")
            .setParameter(1, region)
            .setParameter(2, integrationMode)
            .getResultList();
        System.out.println("journalEntryList:" + invTxnStatusList);
        /*
        Integer invoiceStatus = invoiceStatusList.size() == 1 && invoiceStatusList.get(0).equals("Success") ? 1 : 0;
        Integer stdRecStatus = stdRecStatusList.size() == 1 && stdRecStatusList.get(0).equals("Success") ? 1 : 0;
        Integer stdRecApplyStatus = stdRecApplyStatusList.size() == 1 && stdRecApplyStatusList.get(0).equals("Success") ? 1 : 0;
        Integer miscRecStatus = miscRecStatusList.size() == 1 && miscRecStatusList.get(0).equals("Success") ? 1 : 0;
        Integer invTxnStatus = invTxnStatusList.size() == 1 && invTxnStatusList.get(0).equals("Success") ? 1 : 0;
        Integer sumStatuses = invoiceStatus + stdRecStatus + stdRecApplyStatus + miscRecStatus + invTxnStatus;
         */
        Integer selectPosition =
            (invoiceStatusList.size() == 1 && invoiceStatusList.get(0).equals("Success") ? 0 : 1) |
            (stdRecStatusList.size() == 1 && stdRecStatusList.get(0).equals("Success") ? 0 : 1) |
            (stdRecApplyStatusList.size() == 1 && stdRecApplyStatusList.get(0).equals("Success") ? 0 : 1) |
            (miscRecStatusList.size() == 1 && miscRecStatusList.get(0).equals("Success") ? 0 : 1) |
            (invTxnStatusList.size() == 1 && invTxnStatusList.get(0).equals("Success") ? 0 : 1) |
            (journalEntryList.size() == 1 && journalEntryList.get(0).equals("Success") ? 0 : 1);
        System.out.println("selectPosition:" + selectPosition);
        if (selectPosition == 0 || (size == 1 && selectPosition == 1))
            return 0;
        else
            return 1;
    }

    /** <code>select o from VendhqItemMeta o where o.handle = :itemNumber order by o.lastUpdateDate desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqItemMeta getVendHQItemRowFusion(String itemNumber, String region) {
        List<VendhqItemMeta> itemList = em.createNamedQuery("VendHQItemRowFusion", VendhqItemMeta.class)
                                          .setParameter("itemNumber", itemNumber)
                                          .setParameter("region", region)
                                          .setMaxResults(1)
                                          .getResultList();
        if (itemList.isEmpty()) return null;
        else return itemList.get(0);
    }

    /** <code>select o from OpencartGlobalSites o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<OpencartGlobalSites> getOpencartGlobalSitesFindAll() {
        return em.createNamedQuery("OpencartGlobalSites.findAll", OpencartGlobalSites.class).getResultList();
    }

    /** <code>select o.status from FusionStandardReceipt o where o.receiptNumber = :receiptNumber order by o.requestId desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Boolean getFindStandardReceipt(String receiptNumber, String region) {
        List<String> statusList = em.createNamedQuery("findStandardReceipt", String.class)
                                    .setParameter("receiptNumber", receiptNumber)
                                    .setParameter("region", region)
                                    .setMaxResults(1)
                                    .getResultList();
        if (statusList.isEmpty())
            return false;
        else
            return statusList.get(0).equals("Success");
    }

    /** <code>select o.status from FusionMiscReceipt o where o.receiptNumber = :receiptNumber order by o.requestId desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Boolean getFindMiscReceipt(String receiptNumber, String region) {
        List<String> statusList = em.createNamedQuery("findMiscReceipt", String.class)
                                    .setParameter("receiptNumber", receiptNumber)
                                    .setParameter("region", region)
                                    .setMaxResults(1)
                                    .getResultList();
        if (statusList.isEmpty())
            return false;
        else
            return statusList.get(0).equals("Success");
    }

    /** <code>select o.status from FusionInvTxn o where o.txnSourceName = :salesOrder and o.itemNumber = :itemNumber order by o.requestId desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Boolean getFindInvTxn(String salesOrder, Date saleDate, String itemNumber, String region) {
        List<String> statusList = em.createNamedQuery("findInvTxn", String.class)
                                    .setParameter("salesOrder", salesOrder)
                                    .setParameter("itemNumber", itemNumber)
                                    .setParameter("region", region)
                                    .setParameter("saleDate", saleDate)
                                    .setMaxResults(1)
                                    .getResultList();
        if (statusList.isEmpty())
            return false;
        else
            return statusList.get(0).equals("Success");
    }

    /** <code>select o.status from FusionApplyReceipt o where o.receiptNumber = :receiptNumber order by o.requestId desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Boolean getFindApplyReceipt(String receiptNumber, String region) {
        List<String> statusList = em.createNamedQuery("findApplyReceipt", String.class)
                                    .setParameter("receiptNumber", receiptNumber)
                                    .setParameter("region", region)
                                    .getResultList();
        if (statusList.isEmpty())
            return false;
        else
            return statusList.get(0).equals("Success");
    }
    
    /** <code>select o.status from FusionJournalHeader o where o.txnNumber = :txnNumber and o.customerType = :customerType and o.cashCredit = :cashCredit and o.region = :region order by o.requestId desc</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Boolean getFindJournalHeader(Long txnNumber, String customerType, String cashCredit, String region) {
        List<String> statusList = em.createNamedQuery("findJournalHeader", String.class)
                                    .setParameter("txnNumber", txnNumber)
                                    .setParameter("customerType", customerType)
                                    .setParameter("cashCredit", cashCredit)
                                    .setParameter("region", region)
                                    .getResultList();
        if (statusList.isEmpty())
            return false;
        else
            return statusList.get(0).equals("Success");
    }

    public VendhqSaleItemsOnhand persistVendhqSaleItemsOnhand(VendhqSaleItemsOnhand vendhqSaleItemsOnhand) {
        em.persist(vendhqSaleItemsOnhand);
        return vendhqSaleItemsOnhand;
    }

    public VendhqSaleItemsOnhand mergeVendhqSaleItemsOnhand(VendhqSaleItemsOnhand vendhqSaleItemsOnhand) {
        return em.merge(vendhqSaleItemsOnhand);
    }

    public void removeVendhqSaleItemsOnhand(VendhqSaleItemsOnhand vendhqSaleItemsOnhand) {
        vendhqSaleItemsOnhand = em.find(VendhqSaleItemsOnhand.class, vendhqSaleItemsOnhand.getRowId());
        em.remove(vendhqSaleItemsOnhand);
    }

    /** <code>select o from VendhqSaleItemsOnhand o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<VendhqSaleItemsOnhand> getVendhqSaleItemsOnhandFindAll() {
        return em.createNamedQuery("VendhqSaleItemsOnhand.findAll", VendhqSaleItemsOnhand.class).getResultList();
    }

    /** <code>select o from VendhqSaleItemsOnhand o where o.itemNumber = :itemNumber and o.subinventory = :subInventoryCode</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqSaleItemsOnhand getFindItemOnHandRow(String itemNumber, String subInventoryCode) {
        List<VendhqSaleItemsOnhand> rows = em.createNamedQuery("findItemOnHandRow", VendhqSaleItemsOnhand.class)
                                             .setParameter("itemNumber", itemNumber)
                                             .setParameter("subInventoryCode", subInventoryCode)
                                             .getResultList();
        if (rows.isEmpty())
            return null;
        else
            return rows.get(0);
    }

    public BackupVendhqPayments persistBackupVendhqPayments(BackupVendhqPayments backupVendhqPayments) {
        em.persist(backupVendhqPayments);
        return backupVendhqPayments;
    }

    public BackupVendhqPayments mergeBackupVendhqPayments(BackupVendhqPayments backupVendhqPayments) {
        return em.merge(backupVendhqPayments);
    }

    public void removeBackupVendhqPayments(BackupVendhqPayments backupVendhqPayments) {
        backupVendhqPayments = em.find(BackupVendhqPayments.class, backupVendhqPayments.getRowId());
        em.remove(backupVendhqPayments);
    }

    /** <code>select o from BackupVendhqPayments o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqPayments> getBackupVendhqPaymentsFindAll() {
        return em.createNamedQuery("BackupVendhqPayments.findAll", BackupVendhqPayments.class).getResultList();
    }

    public FusionSalesMetadata persistFusionSalesMetadata(FusionSalesMetadata fusionSalesMetadata) {
        em.persist(fusionSalesMetadata);
        return fusionSalesMetadata;
    }

    public FusionSalesMetadata mergeFusionSalesMetadata(FusionSalesMetadata fusionSalesMetadata) {
        return em.merge(fusionSalesMetadata);
    }

    public void removeFusionSalesMetadata(FusionSalesMetadata fusionSalesMetadata) {
        fusionSalesMetadata = em.find(FusionSalesMetadata.class, fusionSalesMetadata.getRowId());
        em.remove(fusionSalesMetadata);
    }

    public BackupVendhqPromotions persistBackupVendhqPromotions(BackupVendhqPromotions backupVendhqPromotions) {
        em.persist(backupVendhqPromotions);
        return backupVendhqPromotions;
    }

    public BackupVendhqPromotions mergeBackupVendhqPromotions(BackupVendhqPromotions backupVendhqPromotions) {
        return em.merge(backupVendhqPromotions);
    }

    public void removeBackupVendhqPromotions(BackupVendhqPromotions backupVendhqPromotions) {
        backupVendhqPromotions = em.find(BackupVendhqPromotions.class, backupVendhqPromotions.getRowId());
        em.remove(backupVendhqPromotions);
    }

    /** <code>select o from BackupVendhqPromotions o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqPromotions> getBackupVendhqPromotionsFindAll() {
        return em.createNamedQuery("BackupVendhqPromotions.findAll", BackupVendhqPromotions.class).getResultList();
    }

    public OpeningBalanceDB persistOpeningBalanceDB(OpeningBalanceDB openingBalanceDB) {
        em.persist(openingBalanceDB);
        return openingBalanceDB;
    }

    public OpeningBalanceDB mergeOpeningBalanceDB(OpeningBalanceDB openingBalanceDB) {
        return em.merge(openingBalanceDB);
    }

    public void removeOpeningBalanceDB(OpeningBalanceDB openingBalanceDB) {
        openingBalanceDB = em.find(OpeningBalanceDB.class, openingBalanceDB.getItemCode());
        em.remove(openingBalanceDB);
    }

    public BackupVendhqSales persistBackupVendhqSales(BackupVendhqSales backupVendhqSales) {
        em.persist(backupVendhqSales);
        return backupVendhqSales;
    }

    public BackupVendhqSales mergeBackupVendhqSales(BackupVendhqSales backupVendhqSales) {
        return em.merge(backupVendhqSales);
    }

    public void removeBackupVendhqSales(BackupVendhqSales backupVendhqSales) {
        backupVendhqSales = em.find(BackupVendhqSales.class, backupVendhqSales.getInvoiceNumber());
        em.remove(backupVendhqSales);
    }

    /** <code>select o from BackupVendhqSales o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqSales> getBackupVendhqSalesFindAll() {
        return em.createNamedQuery("BackupVendhqSales.findAll", BackupVendhqSales.class).getResultList();
    }

    public FusionReceiptMethod persistFusionReceiptMethod(FusionReceiptMethod fusionReceiptMethod) {
        em.persist(fusionReceiptMethod);
        return fusionReceiptMethod;
    }

    public FusionReceiptMethod mergeFusionReceiptMethod(FusionReceiptMethod fusionReceiptMethod) {
        return em.merge(fusionReceiptMethod);
    }

    public void removeFusionReceiptMethod(FusionReceiptMethod fusionReceiptMethod) {
        fusionReceiptMethod = em.find(FusionReceiptMethod.class, fusionReceiptMethod.getReceiptMethodName());
        em.remove(fusionReceiptMethod);
    }

    public BackupVendhqLineItems persistBackupVendhqLineItems(BackupVendhqLineItems backupVendhqLineItems) {
        em.persist(backupVendhqLineItems);
        return backupVendhqLineItems;
    }

    public BackupVendhqLineItems mergeBackupVendhqLineItems(BackupVendhqLineItems backupVendhqLineItems) {
        return em.merge(backupVendhqLineItems);
    }

    public void removeBackupVendhqLineItems(BackupVendhqLineItems backupVendhqLineItems) {
        backupVendhqLineItems = em.find(BackupVendhqLineItems.class, backupVendhqLineItems.getRowId());
        em.remove(backupVendhqLineItems);
    }

    /** <code>select o from BackupVendhqLineItems o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqLineItems> getBackupVendhqLineItemsFindAll() {
        return em.createNamedQuery("BackupVendhqLineItems.findAll", BackupVendhqLineItems.class).getResultList();
    }

    public OpencartGlobalSites persistOpencartGlobalSites(OpencartGlobalSites opencartGlobalSites) {
        em.persist(opencartGlobalSites);
        return opencartGlobalSites;
    }

    public OpencartGlobalSites mergeOpencartGlobalSites(OpencartGlobalSites opencartGlobalSites) {
        return em.merge(opencartGlobalSites);
    }

    public void removeOpencartGlobalSites(OpencartGlobalSites opencartGlobalSites) {
        opencartGlobalSites = em.find(OpencartGlobalSites.class, opencartGlobalSites.getRowId());
        em.remove(opencartGlobalSites);
    }

    /** <code>select max(o.version) from BackupVendhqSales o where o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long getLastSaleVersionBackup(String region) {
        BigDecimal lastVersion = em.createNamedQuery("lastSaleVersionBackup", BigDecimal.class)
                                   .setParameter("region", region)
                                   .getSingleResult();
        return lastVersion != null ? lastVersion.longValue() : 0L;
    }

    /** <code>select sum(o.quantity) from BackupVendhqLineItems o where o.itemNumber = :itemNumber and o.invoiceNumber
     * in (select k.invoiceNumber from BackupVendhqSales k where k.outletName = :outletName)</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public BigDecimal getItemSoldQuantity(String itemNumber, String outletName) {
        return em.createNamedQuery("ItemSoldQuantity", BigDecimal.class)
                 .setParameter("itemNumber", itemNumber)
                 .setParameter("outletName", outletName)
                 .getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqSales> getSalesOutletBtwDate(String outletName, String region, Date processDate, BigDecimal timeZoneOffset) {
        StringBuilder sqlStatement = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Integer hoursOffset = timeZoneOffset.intValue();
        Float minutesDecimal = timeZoneOffset.abs().floatValue();
        Integer minutesOffset = (int) ((minutesDecimal * 100 % 100) * 60 / 100);
        sqlStatement.append("SELECT * FROM BACKUP_VENDHQ_SALES WHERE OUTLET_NAME = ? AND REGION = ? AND SALE_DATE BETWEEN TO_TIMESTAMP_TZ('")
                    .append(dateFormat.format(processDate)).append(" 00:00:00 ")
                    .append(hoursOffset>=0 ? "+" : "-").append(hoursOffset).append(":").append(minutesOffset==0 ? "00" : minutesOffset)
                    .append("', 'DD-MM-YYYY HH24:MI:SS TZH:TZM') AND TO_TIMESTAMP_TZ('")
                    .append(dateFormat.format(processDate)).append(" 23:59:59 ")
                    .append(hoursOffset>=0 ? "+" : "-").append(hoursOffset).append(":").append(minutesOffset==0 ? "00" : minutesOffset)
                    .append("', 'DD-MM-YYYY HH24:MI:SS TZH:TZM')");
        
        return em.createNativeQuery(sqlStatement.toString(), BackupVendhqSales.class)
                 .setParameter(1, outletName)
                 .setParameter(2, region)
                 .getResultList();
    }

    /** <code>select o from BackupVendhqPayments o where o.invoiceNumber = :invoiceNumber</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqPayments> getPaymentsByInvoiceNumber(String invoiceNumber, Date saleDate, String region) {
        return em.createNamedQuery("PaymentsByInvoiceNumber", BackupVendhqPayments.class)
                 .setParameter("invoiceNumber", invoiceNumber)
                 .setParameter("region", region)
                 .setParameter("saleDate", saleDate)
                 .getResultList();
    }
    
    /** <code>select o from ServiceProviderJournalMapping o where o.region = :region and o.serviceProvider = :serviceProvider and o.creditDebit = :creditDebit and o.isCash = :isCash</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ServiceProviderJournalMapping getServiceProviderMappingByRegion(String serviceProvider, String creditDebit, String region, Boolean isCash) {
        return em.createNamedQuery("ServiceProviderJournalMappingByRegion", ServiceProviderJournalMapping.class)
                 .setParameter("serviceProvider", serviceProvider)
                 .setParameter("region", region)
                 .setParameter("creditDebit", creditDebit)
                 .setParameter("isCash", isCash)
                 .getSingleResult();
    }

    /** <code>select o from BackupVendhqLineItems o where o.invoiceNumber = :invoiceNumber and o.saleDate = :saleDate and o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<BackupVendhqLineItems> getLineItemsByInvoice(String invoiceNumber, Date saleDate, String region) {
        return em.createNamedQuery("LineItemsByInvoice", BackupVendhqLineItems.class)
                 .setParameter("invoiceNumber", invoiceNumber)
                 .setParameter("region", region)
                 .setParameter("saleDate", saleDate)
                 .getResultList();
    }

    /** <code>select o from VendhqRegisters o where o.registerName = :registerName</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqRegisters getRegisterDetailsByName(String registerName, String region) {
        return em.createNamedQuery("RegisterDetailsByName", VendhqRegisters.class)
                 .setParameter("registerName", registerName)
                 .setParameter("region", region)
                 .getSingleResult();
    }

    /** <code>select count(o) from BackupVendhqSales o where o.invoiceNumber = :invoiceNumber and o.version = :version</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Boolean getIsSalesExists(String invoiceNumber, Date saleDate) {
        Long rowCount = em.createNamedQuery("isSalesExists", Long.class)
                 .setParameter("invoiceNumber", invoiceNumber)
                 .setParameter("saleDate", saleDate)
                 .getSingleResult();
        if (rowCount == 0) return false;
        else return true;
    }
    
    /** <code>select o.integMode from OutletsIntegrationConfig o where o.outletName = :outletName and o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String getOutletIntegStatus(String outletName, String region) {
        List<String> statusList = em.createNamedQuery("getOutletIntegStatus", String.class)
                 .setParameter("outletName", outletName)
                 .setParameter("region", region)
                 .getResultList();
        if (statusList.isEmpty()) return "NONE";
        else return statusList.get(0);
    }
    
    /** <code>select o.integMode from OutletsIntegrationConfig o where o.outletName = :outletName and o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> getOutletsByStatus(String integMode, String region) {
        return em.createNamedQuery("getOutletsByStatus", String.class)
                 .setParameter("integMode", integMode)
                 .setParameter("region", region)
                 .getResultList();
    }
    
    /** <code>select o from VendhqOutletsDB o where o.outletName = :outletName and o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqOutletsDB getOutletDetailsByName(String outletName, String region) {
        return em.createNamedQuery("OutletDetailsByName", VendhqOutletsDB.class)
                 .setParameter("outletName", outletName)
                 .setParameter("region", region)
                 .getSingleResult();
    }
    
    /** <code>select o from VendhqCredentials o where o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public VendhqCredentials getVendHqCredentialByRegion(String region) {
        return em.createNamedQuery("VendHqCredentialByRegion", VendhqCredentials.class)
                 .setParameter("region", region)
                 .getSingleResult();
    }
    
    /** <code>select o.discountItemId from VendhqDiscountItems o where o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String getDiscountItemByRegion(String region) {
        return em.createNamedQuery("DiscountItemByRegion", String.class)
                 .setParameter("region", region)
                 .getSingleResult();
    }
    
    /** <code>select o from SalesIntegrationStatus o where o.region = :region and o.integMode = :integMode</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public SalesIntegrationStatus getSalesIntegrationStatus(String region, String integMode) {
        List<SalesIntegrationStatus> statusList = em.createNamedQuery("SalesIntegrationStatus", SalesIntegrationStatus.class)
                 .setParameter("region", region)
                 .setParameter("integMode", integMode)
                 .getResultList();
        if (statusList.isEmpty()) return new SalesIntegrationStatus(integMode, region, "IDLE");
        else return statusList.get(0);
    }
    
    public SalesIntegrationStatus mergeSalesIntegrationStatus(SalesIntegrationStatus salesIntegrationStatus) {
        return em.merge(salesIntegrationStatus);
    }
    
    /** <code>select o from TxnQuantityDecimals o where o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TxnQuantityDecimals> getTxnQtyDecimalsByRegion(String region) {
        return em.createNamedQuery("TxnQtyDecimalsByRegion", TxnQuantityDecimals.class)
                 .setParameter("region", region)
                 .getResultList();
    }
    
    /** <code>select o from FusionBusinessUnitIdMap o where o.region = :region</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public FusionBusinessUnitIdMap getFusionBusinessUnitIdMapfindByRegion(String region) {
        List<FusionBusinessUnitIdMap> results = em.createNamedQuery("FusionBusinessUnitIdMap.findByRegion", FusionBusinessUnitIdMap.class)
                 .setParameter("region", region)
                 .getResultList();
        if (results.isEmpty()) throw new NoResultException("Fusion BU ID Map not configured for " + region + "!!");
        return results.get(0);
    }
}
