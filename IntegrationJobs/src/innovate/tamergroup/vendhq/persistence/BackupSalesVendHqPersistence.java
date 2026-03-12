package innovate.tamergroup.vendhq.persistence;

import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.ServiceException;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.SendEmailNotification;
import innovate.tamergroup.persistence.entities.BackupVendhqLineItems;
import innovate.tamergroup.persistence.entities.BackupVendhqPayments;
import innovate.tamergroup.persistence.entities.BackupVendhqPromotions;
import innovate.tamergroup.persistence.entities.BackupVendhqSales;
import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.entities.VendhqServiceProviders;
import innovate.tamergroup.persistence.entities.VendhqTaxMeta;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.model.products.Product;
import innovate.tamergroup.vendhq.model.sales.LineItem;
import innovate.tamergroup.vendhq.model.sales.Payment;
import innovate.tamergroup.vendhq.model.sales.Promotion;
import innovate.tamergroup.vendhq.model.sales.Sale;
import innovate.tamergroup.vendhq.services.VendHQItemService;
import innovate.tamergroup.vendhq.services.VendHQSalesService;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.HashMap;

import javax.naming.NamingException;

import javax.persistence.NoResultException;

import org.apache.commons.lang.exception.ExceptionUtils;


public class BackupSalesVendHqPersistence {
    
    private SessionEJB session;
    private String region;
    private SendEmailNotification emailNotify;
    private String domainName;
    private Credential credential;
    private HashMap<String, Product> tempProductCache;
    private Boolean itemError = false;

    public BackupSalesVendHqPersistence(String region) {
        this.region = region;
        emailNotify = new SendEmailNotification(1111111, region);
        tempProductCache = new HashMap<>();
    }

    public BackupSalesVendHqPersistence(SessionEJB session, String region) {
        this.session = session;
        this.region = region;
    }

    public void syncSales (Sale sale) throws Exception {
        if (!session.getIsSalesExists(sale.getInvoiceNumber(), sale.getSaleDate())) {
            VendhqServiceProviders serviceProvider = session.getGetVendHqServiceProviderByCustomerId(region, sale.getCustomerId());
            session.mergeBackupVendhqSales(transform(sale, serviceProvider));
            for (LineItem lineItem : sale.getLineItems()) {
                String taxName = null;
                if (!lineItem.getTaxComponents().isEmpty()) {
                    VendhqTaxMeta taxMeta = session.getGetTaxRow(lineItem.getTaxComponents().get(0).getRateId());
                    if (taxMeta == null)
                        throw new Exception("Tax Name not available for ID: " + lineItem.getTaxComponents().get(0).getRateId());
                    else taxName = taxMeta.getTaxName();
                }
                else throw new Exception("No tax component available for line: " + sale.getInvoiceNumber() + "-" + lineItem.getSequence());
                session.mergeBackupVendhqLineItems(transform(sale, lineItem, taxName));
                for (Promotion promotion : lineItem.getPromotions())
                    session.mergeBackupVendhqPromotions(transform(sale, lineItem.getSequence(), promotion));
            }
            for (Payment payment : sale.getPayments())
                session.mergeBackupVendhqPayments(transform(sale, payment));
        }
    }

    private BackupVendhqSales transform(Sale sale, VendhqServiceProviders serviceProvider) {       
        BackupVendhqSales salesPersistence = new BackupVendhqSales();
        salesPersistence.setInvoiceNumber(sale.getInvoiceNumber());
        salesPersistence.setOutletName(session.getOutletDetails(sale.getOutletId()).getOutletName());
        salesPersistence.setRegion(region);
        salesPersistence.setRegisterName(session.getRegisterDetails(sale.getRegisterId()).getRegisterName());
        salesPersistence.setSaleDate(sale.getSaleDate());
        salesPersistence.setTotalLoyalty(sale.getTotalLoyalty() != null ? BigDecimal.valueOf(sale.getTotalLoyalty()) : null);
        salesPersistence.setTotalPrice(BigDecimal.valueOf(sale.getTotalPrice()));
        salesPersistence.setTotalPriceInclTax(BigDecimal.valueOf(sale.getTotalPriceInclTax()));
        salesPersistence.setTotalTax(BigDecimal.valueOf(sale.getTotalTax()));
        salesPersistence.setVersion(BigDecimal.valueOf(sale.getVersion()));   
        salesPersistence.setCustomerType(serviceProvider == null ? "NORMAL" : serviceProvider.getServiceProvider());
        return salesPersistence;
    }

    private BackupVendhqLineItems transform(Sale sale, LineItem lineItem, String taxName) throws IOException {
        BackupVendhqLineItems lineItemPersistence = new BackupVendhqLineItems();
        lineItemPersistence.setInvoiceNumber(sale.getInvoiceNumber());
        lineItemPersistence.setSaleDate(sale.getSaleDate());
        lineItemPersistence.setLineNumber(BigDecimal.valueOf(lineItem.getSequence()+1));
        lineItemPersistence.setTaxName(taxName);

        try {      
            System.out.println(lineItem.getProductId());
            VendhqItemMeta itemMeta = session.getGetVendHqItemRowProductId(lineItem.getProductId());
            Boolean discount = lineItem.getProductId().equals(session.getDiscountItemByRegion(region));
            lineItemPersistence.setItemName(discount ? "Discount Item" : itemMeta.getDescription());
            lineItemPersistence.setItemNumber(discount ? " " : itemMeta.getSku());
        } catch (Exception e) {
            itemError = true;
            emailNotify.setSubject("Sales Backup Issue");
            emailNotify.addErrorLine("Items Backup Issue", "Line Item with Seq# " + lineItem.getSequence() + " from Invoice# " + sale.getInvoiceNumber() + " missing!");
            Product product = tempProductCache.get(lineItem.getProductId());
            if (product == null) {
                product = new VendHQItemService(domainName, credential).getVendHQItemDetail(lineItem.getProductId());
                tempProductCache.put(lineItem.getProductId(), product);
            }
            lineItemPersistence.setItemName(product.getDescription());
            lineItemPersistence.setItemNumber(product.getHandle());
        }
        
        lineItemPersistence.setLoyaltyValue(lineItem.getLoyaltyValue() != null ? BigDecimal.valueOf(lineItem.getLoyaltyValue()) : null);
        lineItemPersistence.setQuantity(BigDecimal.valueOf(lineItem.getQuantity()));
        lineItemPersistence.setRegion(region);
        lineItemPersistence.setTotalDiscount(lineItem.getTotalDiscount() != null ? BigDecimal.valueOf(lineItem.getTotalDiscount()) : null);
        lineItemPersistence.setTotalPrice(BigDecimal.valueOf(lineItem.getTotalPrice()));
        lineItemPersistence.setTotalTax(BigDecimal.valueOf(lineItem.getTotalTax()));
        
        return lineItemPersistence;
    }

    private BackupVendhqPromotions transform(Sale sale, int sequence, Promotion promotion) {
        BackupVendhqPromotions promoPersistence = new BackupVendhqPromotions();
        promoPersistence.setInvoiceNumber(sale.getInvoiceNumber());
        promoPersistence.setSaleDate(sale.getSaleDate());
        promoPersistence.setLineNumber(BigDecimal.valueOf(sequence+1));
        promoPersistence.setName(promotion.getName());
        promoPersistence.setAmount(BigDecimal.valueOf(promotion.getAmount()));
        promoPersistence.setRegion(region);
        return promoPersistence;
    }

    private BackupVendhqPayments transform(Sale sale, Payment payment) {       
        BackupVendhqPayments payPersistence = new BackupVendhqPayments();
        payPersistence.setAmount(BigDecimal.valueOf(payment.getAmount()));
        
        VendhqOutletsDB outletDetails = session.getOutletDetails(sale.getOutletId());
        payPersistence.setCurrency(outletDetails.getCurrency());
        payPersistence.setOutletName(outletDetails.getOutletName());
        
        payPersistence.setDeletedAt(payment.getDeletedAt());
        payPersistence.setInvoiceNumber(sale.getInvoiceNumber());
        payPersistence.setSaleDate(sale.getSaleDate());
        payPersistence.setPaymentDate(payment.getPaymentDate());
        payPersistence.setPaymentType(payment.getName());
        payPersistence.setRegion(region);
        payPersistence.setRegisterName(session.getRegisterDetails(sale.getRegisterId()).getRegisterName());
        return payPersistence;
    }
    
    public void backupSales(String domainName, Credential vendHqCredential) {
        this.domainName = domainName;
        this.credential = vendHqCredential;
        try {
            session = EJBClientUtil.getSessionEJB();
            VendHQSalesService salesService = new VendHQSalesService(domainName, vendHqCredential);
            Long lastVersion = session.getLastSaleVersionBackup(region);
            try {
                session.getDiscountItemByRegion(region);
                for (Sale sale : salesService.getVendHQSales(lastVersion)) {
                    if (sale.getStatus().equals("CLOSED")) {
                        System.out.println(sale.getInvoiceNumber());
                        System.out.println(sale.getSaleDate());
                        syncSales(sale);
                    }
                }
            } catch (Exception e) {
                if (e instanceof NoResultException) {
                    emailNotify.setSubject("Discount Item Issue");
                    emailNotify.addErrorLine("Discount Item", "There is no Discount Item configured for " + region);
                } else if (!ExceptionUtils.getFullStackTrace(e).contains("Temporary failure in name resolution")){
                    emailNotify.setSubject("Sales Backup Error");
                    emailNotify.addErrorLine("Backup Error", ExceptionUtils.getFullStackTrace(e));
                }
                itemError = true;
            }
            if (itemError) emailNotify.execute();
        } catch (IOException | NamingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, NamingException, ServiceException {
        new BackupSalesVendHqPersistence("SA").backupSales("iaqtest",
                                            new Credential("4GYI1hpMtznv9KNsCUWD1_xsAfu5tlmxjdPhbL3a"));
    }
}
