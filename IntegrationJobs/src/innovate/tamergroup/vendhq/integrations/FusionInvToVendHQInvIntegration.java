package innovate.tamergroup.vendhq.integrations;

import com.oracle.xmlns.apps.scm.inventory.OnHandQuantityDetail;
import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.ServiceException;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.LoggerHelper;
import innovate.tamergroup.email.SendEmailNotification;
import innovate.tamergroup.fusion.rest.services.FusionOnHandQtyService;
import innovate.tamergroup.persistence.entities.FusionCredentials;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.model.products.InventoryUpdate;
import innovate.tamergroup.vendhq.model.products.Product;
import innovate.tamergroup.vendhq.model.products.ProductCreate;
import innovate.tamergroup.vendhq.model.products.ProductCreateResponse;
import innovate.tamergroup.vendhq.services.VendHQItemService;
import innovate.tamergroup.vendhq.transformation.FusionInvToVendHQInvTransformation;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.NamingException;


public class FusionInvToVendHQInvIntegration {

    private AtomicInteger count = new AtomicInteger(0);
    
    public FusionInvToVendHQInvIntegration() {}

    public void doIntegration(String outletName, String region) throws Exception {
        SessionEJB session = EJBClientUtil.getSessionEJB();
        Integer requestId = session.getSessionRequestID();
        
        FusionCredentials fusionCredentials = session.getFusionCredential();
        FusionAppParams params = new FusionAppParams(fusionCredentials.getHostName(), fusionCredentials.getServer());
        Credential fusionCredential = new Credential(fusionCredentials.getUsername(), fusionCredentials.getPassword());
        
        VendhqCredentials vendHqCredentials = session.getVendHqCredentialByRegion(region);
        String vendHqDomain = vendHqCredentials.getDomainName();
        Credential vendHqCredential = new Credential(vendHqCredentials.getPersonalToken());
        
        SendEmailNotification emailNotify = new SendEmailNotification(requestId, region);
        
        VendHQItemService vendHQItemService = new VendHQItemService(vendHqDomain, vendHqCredential);
        List<Product> products = vendHQItemService.getVendHQItems(0L);
        
        VendhqOutletsDB outletDetail = session.getOutletDetailsByName(outletName, region);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
        List<Future<LoggerHelper>> futures = new ArrayList<Future<LoggerHelper>>();
        
        //Integer productCount = 20;

        for (Product product : products) {
            //if (--productCount == 0) break;
            Callable<LoggerHelper> callable = new Callable<LoggerHelper>(){
                @Override
                public LoggerHelper call() throws Exception {
                    LoggerHelper loggerHelper = new LoggerHelper();
                    try {
                        FusionInvToVendHQInvTransformation invTransformation = new FusionInvToVendHQInvTransformation(params, fusionCredential);

                        List<OnHandQuantityDetail> qtyDetailList =
                            new FusionOnHandQtyService(params, fusionCredential).getOnHandQtyDetails(product.getSku(), vendHqCredentials.getFusionOrgCode());
                        for (OnHandQuantityDetail qtyDetail : qtyDetailList) {
                            if (outletDetail.getOutletName().equals(qtyDetail.getSubinventoryCode())) {
                                invTransformation.addInventoryRecord(String.valueOf(qtyDetail.getOnhandQuantity()), outletDetail);
                                break;
                            }
                        }

                         if (!invTransformation.getInventoryList().isEmpty()) {
                             ProductCreate productCreate = invTransformation.doTransformation(product);
                             ProductCreateResponse createResponse = vendHQItemService.insertVendHQItems(productCreate);
 
                             if (createResponse != null) {
                                 for (InventoryUpdate inventory : createResponse.getProduct().getInventory()) {
                                     if (outletDetail.getOutletName().equals(inventory.getOutletName())) {
                                         loggerHelper.getInfoLines().add(new String[]{"Item# " + count.incrementAndGet(), createResponse.getProduct().getSku() + " - " + createResponse.getProduct().getDescription()});
                                         loggerHelper.getInfoLines().add(new String[]{"Stock ", "\t\t" + inventory.getCount()});
                                         break;
                                     }                                 
                                }
                                 loggerHelper.getInfoLines().add(new String[]{"", ""});
                             } else loggerHelper.getErrorLines().add(new String[]{"Item Stock Sync Issue", productCreate.getSku() + " - " + productCreate.getDescription()});
                             

                         }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return loggerHelper;
                }
            };      
            futures.add(executorService.submit(callable));
        }
        
        try {
            for (Future<LoggerHelper> future : futures) {
                LoggerHelper loggerHelper = future.get();
                for (String[] infoLine : loggerHelper.getInfoLines())
                    emailNotify.addInfoLine(infoLine[0], infoLine[1]);
                for (String[] errorLine : loggerHelper.getErrorLines())
                    emailNotify.addErrorLine(errorLine[0], errorLine[1]);
            } 
        } catch (ExecutionException | InterruptedException e) {}

        emailNotify.setSubject("Physical Inventory Sync Results: " + outletName);
        emailNotify.execute();
    }

    public static void main(String[] args) throws Exception {
        new FusionInvToVendHQInvIntegration().doIntegration("FLAMINGO", "SA");
    }
}
