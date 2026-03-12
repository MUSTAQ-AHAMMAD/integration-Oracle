package innovate.tamergroup.vendhq.integrations;

import com.oracle.xmlns.apps.scm.item.Item;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.SendEmailNotification;
import innovate.tamergroup.fusion.rest.services.FusionItemsService;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqTaxMeta;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.model.products.ProductCreate;
import innovate.tamergroup.vendhq.model.products.ProductCreateResponse;
import innovate.tamergroup.vendhq.persistence.ItemVendHQPersistence;
import innovate.tamergroup.vendhq.services.VendHQItemService;
import innovate.tamergroup.vendhq.transformation.FusionItemsToVendHQItemsTransformation;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;


public class FusionItemsToVendHQItemsIntegration {
    
    private FusionAppParams fusionParams;
    private String vendHqDomain;
    private Credential fusionCredential, vendHqCredential;

    public FusionItemsToVendHQItemsIntegration(FusionAppParams fusionParams, String vendHqDomain,
                                               Credential fusionCredential, Credential vendHqCredential) {
        this.fusionParams = fusionParams;
        this.vendHqDomain = vendHqDomain;
        this.fusionCredential = fusionCredential;
        this.vendHqCredential = vendHqCredential;
    }

    public void doIntegration(String region, String fusionOrgCode, String fusionTaxCode) throws Exception {
        FusionItemsService fusionItemService = new FusionItemsService(fusionParams, fusionCredential);
        VendHQItemService vendHQItemService = new VendHQItemService(vendHqDomain, vendHqCredential);
        SessionEJB session = EJBClientUtil.getSessionEJB();
        Integer requestId = session.getSessionRequestID();
        SendEmailNotification emailNotify = new SendEmailNotification(requestId, region);
        ItemVendHQPersistence itemPersistence = new ItemVendHQPersistence(requestId, session, region);
        emailNotify.addInfoLine("ITEMS INTEGRATION LOG", "REGION: " + region);
        emailNotify.addErrorLine("ITEMS INTEGRATION LOG", "REGION: " + region);

        //TODO Assuming that Brand & Tax are first in the list
        /*String brandId = session.getVendhqBrandMetaFindAll()
                                .get(3)
                                .getBrandId();*/
        List<VendhqTaxMeta> taxMeta = session.getVendhqTaxMetaFindAllByRegion(region, fusionTaxCode);
        String taxId = taxMeta.get(0).getTaxId();
        FusionItemsToVendHQItemsTransformation itemsTransformation =
            new FusionItemsToVendHQItemsTransformation("", taxId, session, vendHqDomain, vendHqCredential);

        Boolean intError = false;
        Date lastRequestedDate = session.getGetVenHqItemsLastUpdatedDate(region);
        if (lastRequestedDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -10);
            lastRequestedDate = new Date(calendar.getTimeInMillis());
        }
        List<Item> items = fusionItemService.getFusionItems(lastRequestedDate, fusionOrgCode);
        for (Item item : items) {
            VendhqItemMeta itemMeta = session.getVendHQItemRowFusion(item.getItemNumber(), region);
            if (itemMeta != null && (item.getLastUpdateDate().getTime() - itemMeta.getLastUpdateDate().getTime()) < 1000) continue; 
            
            String productId = session.getGetVendHqItemId(BigDecimal.valueOf(item.getItemId()), region);
            VendhqItemMeta itemMetaDb = itemPersistence.transformAndSaveItemDb(item);
            try {
                ProductCreate productCreate = itemsTransformation.doTransformation(item, region);
                if (productId != null) itemsTransformation.setProductId(productId);

                ProductCreateResponse createResponse = vendHQItemService.insertVendHQItems(productCreate);
                itemPersistence.transformAndSaveProductDb(itemMetaDb, createResponse.getProduct(),
                                                          productCreate.getBrandId(), "Success", " ");
                emailNotify.addInfoLine("Item Sync", "ItemNumber# " + item.getItemNumber() + "  is " 
                                                     + (productId != null ? "updated" : "created")
                                                     + ", with Item Name: " + productCreate.getDescription());
            } catch (Exception e) {
                itemPersistence.transformAndSaveProductDb(itemMetaDb, null, null, "Failed",
                                                          e.getMessage() != null ? (e.getMessage().length() >= 500 ?
                                                          e.getMessage().substring(500) : e.getMessage()) : " ");
                emailNotify.addErrorLine("Item Sync", "ItemNumber# " + item.getItemNumber() + "  is NOT " 
                                                     + (productId == null ? "updated" : "created")
                                                     + ", Error: " + e.getMessage());
                emailNotify.addErrorLine("", "");
                intError = true;
            } finally {
                itemPersistence.saveItemDb(itemMetaDb);
            }
        }
        
        if (intError) emailNotify.setSubject("Error in Items Integration");
        else emailNotify.setSubject("Successful Items Integration");
        emailNotify.execute();
    }

    public static void main(String[] args) {
        try {
            new FusionItemsToVendHQItemsIntegration(new FusionAppParams("ehxk-test", "em2"), "iaqtest", 
                                                    new Credential("INTEGRATION", "Welcome123"), new Credential("4GYI1hpMtznv9KNsCUWD1_xsAfu5tlmxjdPhbL3a"))
                .doIntegration("SA", "VWH", "OUTPUT-GOODS-DOM-5%");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
