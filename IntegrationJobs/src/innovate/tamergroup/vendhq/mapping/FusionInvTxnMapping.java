package innovate.tamergroup.vendhq.mapping;

import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import innovate.tamergroup.fusion.rest.services.FusionSubinventoryService;
import innovate.tamergroup.persistence.entities.BackupVendhqLineItems;
import innovate.tamergroup.persistence.entities.BackupVendhqSales;
import innovate.tamergroup.persistence.entities.ServiceProviderJournalMapping;
import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.HashMap;

public class FusionInvTxnMapping {
    
    private SessionEJB session;
    private FusionAppParams params;
    private Credential credential;
    private HashMap<String, String> outletOrgNameMapping;
    
    public FusionInvTxnMapping(SessionEJB session, FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.session = session;
        this.outletOrgNameMapping = new HashMap<>();
    }
    
    public TransactionLine mapToInvTransactionModel(BackupVendhqSales sale, VendhqItemMeta itemMeta, 
                                            BackupVendhqLineItems lineItem, VendhqOutletsDB outletDetail, String customerType) throws IOException {
        if (!outletOrgNameMapping.containsKey(outletDetail.getOutletName()))
            outletOrgNameMapping.put(outletDetail.getOutletName(), new FusionSubinventoryService(params, credential).getOrganizationName(outletDetail.getOutletName()));
        String costIssue = "Vend Sales Issue";
        String costRMA = "Vend RMA";
        if (!customerType.equals("NORMAL")) {
            ServiceProviderJournalMapping journalMapping = session.getServiceProviderMappingByRegion(customerType, "CREDIT", outletDetail.getRegion(), true);
            costIssue = journalMapping.getCostIssue();
            costRMA = journalMapping.getCostRMA();
        }
        
        TransactionLine transactionLine  = new TransactionLine();
        transactionLine.withOrganizationName(outletOrgNameMapping.get(outletDetail.getOutletName()))
                    .withItem(itemMeta.getSku())
                    .withTransactionSourceName(sale.getInvoiceNumber())
                    .withSubinventory(outletDetail.getOutletName())
                    .withTransactionUnitOfMeasure(itemMeta.getUomName())
                    .withTransactionDate(sale.getSaleDate())
                    .withTransactionQuantity(lineItem.getQuantity().doubleValue()*-1);
        if (lineItem.getTotalPrice().doubleValue() == 0)
            transactionLine.setTransactionType(lineItem.getQuantity().doubleValue() > 0 ? costIssue : costRMA);
        else if (lineItem.getTotalPrice().doubleValue() > 0)
            transactionLine.setTransactionType(costIssue);
        else transactionLine.setTransactionType(costRMA);
        
        return transactionLine;
    }
    
}
