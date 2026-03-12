package innovate.tamergroup.vendhq.integrations;

import com.oracle.xmlns.apps.scm.inventory.OnHandQuantityDetail;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.fusion.rest.services.FusionOnHandQtyService;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.BackgroundTaskExecutor;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.model.products.Product;
import innovate.tamergroup.vendhq.persistence.ItemOnHandSalesPersistence;
import innovate.tamergroup.vendhq.services.VendHQItemService;

import java.io.IOException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.NamingException;

public class FusionOnHandQtyFetch {

    private AtomicInteger count = new AtomicInteger(0);
    private SessionEJB session;
    private FusionAppParams params;
    private Credential fusionCredential;

    public FusionOnHandQtyFetch(FusionAppParams params, Credential fusionCredential) {
        this.params = params;
        this.fusionCredential = fusionCredential;
    }

    public void syncFusionOnHandQty(Credential vendHqCredential, String vendHqDomain, String region, 
                                    String fusionOrgCode) throws IOException, NamingException {
        session = EJBClientUtil.getSessionEJB();
        //TODO modify code to read countries from LOVs
        ItemOnHandSalesPersistence onHandPersistence = new ItemOnHandSalesPersistence(session, region);
        VendHQItemService vendHQItemService = new VendHQItemService(vendHqDomain, vendHqCredential);
        List<Product> products = vendHQItemService.getVendHQItems(0L);
        BackgroundTaskExecutor executorInstance = BackgroundTaskExecutor.getInstance();
        count = new AtomicInteger(0);
        Integer loaded = 0;

        for (Product product : products) {
            /*if (++loaded > 50)
                break;*/
            executorInstance.execute(() -> {
                try {
                    count.getAndIncrement();
                    List<OnHandQuantityDetail> qtyDetailList = new FusionOnHandQtyService(params, fusionCredential)
                                                                    .getOnHandQtyDetails(product.getSku(), fusionOrgCode);

                    System.out.println(product.getSku() + " - " + product.getDescription());
                    for (OnHandQuantityDetail inventory : qtyDetailList)
                        System.out.println("\t" + inventory.getSubinventoryCode() + " : " +
                                           inventory.getOnhandQuantity());
                    onHandPersistence.syncItemOnHand(product, qtyDetailList);

                    System.out.println("Count = " + count.get());
                    System.out.println();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, null);
        }

        //while (count.get() != 50) {
        while (count.get() != products.size()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
