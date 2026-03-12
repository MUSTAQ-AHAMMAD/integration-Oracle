package innovate.tamergroup.fusion.loader;

import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionRequest;
import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionResponse;
import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.fusion.rest.services.FusionInvTxnService;
import innovate.tamergroup.persistence.entities.FusionCredentials;
import innovate.tamergroup.persistence.entities.FusionInvTxn;
import innovate.tamergroup.persistence.entities.TxnQuantityDecimals;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;

public class FusionInvDataLoader {
    
    private SessionEJB session;
    private HashMap<String, String> orgMapping = new HashMap<>();
    private HashMap<String, List<TransactionLine>> salesTransactionLinesMapping = new HashMap<>();
    
    public FusionInvDataLoader() {
        super();
        orgMapping.put("SA", "Showrooms Stores");
        orgMapping.put("AE", "Dubai Showrooms Stores");
        salesTransactionLinesMapping.put("SA", new ArrayList<TransactionLine>());
        salesTransactionLinesMapping.put("AE", new ArrayList<TransactionLine>());
    }
    
    private void runTxnReconciliation() throws NamingException {
        session = EJBClientUtil.getSessionEJB();
        List<VendhqCredentials> vendHqDomainCredentials = session.getVendhqCredentialsFindAll();
        
        for (VendhqCredentials outlet : vendHqDomainCredentials) {
            if (orgMapping.containsKey(outlet.getRegion())) {
                List<TxnQuantityDecimals> txnQtyDecimals = session.getTxnQtyDecimalsByRegion(outlet.getRegion());
                
                for (TxnQuantityDecimals qtyDecimal : txnQtyDecimals) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(qtyDecimal.getSaleDate());
                    if (calendar.get(Calendar.YEAR) == 2019) {
                        TransactionLine transactionLine  = new TransactionLine();
                        transactionLine.withOrganizationName(orgMapping.get(outlet.getRegion()))
                                       .withItem(qtyDecimal.getItemNumber())
                                       .withTransactionSourceName(qtyDecimal.getInvoiceNumber())
                                       .withSubinventory(qtyDecimal.getOutletName())
                                       .withTransactionUnitOfMeasure(qtyDecimal.getUomName())
                                       .withTransactionDate(qtyDecimal.getSaleDate())
                                       .withTransactionQuantity(qtyDecimal.getDecim().doubleValue()*-1);
                        
                        if (qtyDecimal.getTotalPrice().doubleValue() == 0)
                            transactionLine.setTransactionType(qtyDecimal.getDecim().doubleValue() > 0 ? "Vend Sales Issue" : "Vend RMA");
                        else if (qtyDecimal.getTotalPrice().doubleValue() > 0)
                            transactionLine.setTransactionType("Vend Sales Issue");
                        else transactionLine.setTransactionType("Vend RMA");
                        
                        salesTransactionLinesMapping.get(outlet.getRegion()).add(transactionLine);
                    } else continue;
                }
            } else continue;
        }
    }
    
    public static void main(String[] args) throws NamingException, IOException {
        FusionInvDataLoader loader = new FusionInvDataLoader();
        loader.runTxnReconciliation();
        Iterator<List<TransactionLine>> iterator = loader.getSalesTransactionLinesMapping().values().iterator();
        FusionCredentials fusionCredentials = loader.getSession().getFusionCredential();
        FusionInvTxnService invTxnService = new FusionInvTxnService(new FusionAppParams(fusionCredentials.getHostName(),
                                                                                        fusionCredentials.getServer()), 
                                                                    new Credential(fusionCredentials.getUsername(), fusionCredentials.getPassword()));
        while (iterator.hasNext()) {
            List<TransactionLine> invTxnLines = iterator.next();
            InventoryTransactionResponse invTxnResult = invTxnService.insertInvTransactions(invTxnLines);
            String orgName = invTxnLines.get(0).getOrganizationName();
            if (invTxnResult.getErrorCode() == null)
                System.out.println("Status of " + orgName + ": " + invTxnResult.getReturnStatus());
            else {
                System.out.println("Error in " + orgName);
                System.out.println(invTxnResult.getErrorCode() + ": " + invTxnResult.getErrorExplanation());
            }
        }
    }


    public void setSession(SessionEJB session) {
        this.session = session;
    }

    public SessionEJB getSession() {
        return session;
    }

    public void setOrgMapping(HashMap<String, String> orgMapping) {
        this.orgMapping = orgMapping;
    }

    public HashMap<String, String> getOrgMapping() {
        return orgMapping;
    }

    public void setSalesTransactionLinesMapping(HashMap<String, List<TransactionLine>> salesTransactionLinesMapping) {
        this.salesTransactionLinesMapping = salesTransactionLinesMapping;
    }

    public HashMap<String, List<TransactionLine>> getSalesTransactionLinesMapping() {
        return salesTransactionLinesMapping;
    }


}
