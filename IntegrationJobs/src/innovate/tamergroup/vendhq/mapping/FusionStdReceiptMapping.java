package innovate.tamergroup.vendhq.mapping;

import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.persistence.entities.FusionReceiptMethod;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.entities.VendhqRegisters;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

public class FusionStdReceiptMapping {
    
    private FusionAppParams params;
    private Credential credential;
    private SessionEJB session;

    public FusionStdReceiptMapping(SessionEJB session, FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.session = session;
    }
    
    public StandardReceiptRequest mapToStandardReceipt(String paymentType, InvoiceHeader invoice, 
                                                       VendhqOutletsDB outletDetail, VendhqRegisters registerDetails, 
                                                       FusionReceiptMethod receiptMethodMeta, String transactionNumber) {
        StandardReceiptRequest standardReceipt = new StandardReceiptRequest();
        standardReceipt.setCurrencyCode(invoice.getInvoiceCurrencyCode());
        standardReceipt.setSaleDate(invoice.getSaleDate());
        standardReceipt.setReceiptMethodId(receiptMethodMeta.getReceiptMethodId().longValue()); 
        standardReceipt.setReceiptNumber(paymentType + "-" + transactionNumber);
        standardReceipt.setRemittanceBankAccountId(receiptMethodMeta.getReceiptIsCash().equals("1") 
                                                   ? registerDetails.getCashAccountId().longValue() 
                                                   : registerDetails.getBankAccountId().longValue());
        standardReceipt.setAccountValue(invoice.getBillToAccountNumber());
        standardReceipt.setOrgId(session.getFusionBusinessUnitIdMapfindByRegion(outletDetail.getRegion()).getBusinessUnitId().longValue());
        return standardReceipt;
    }
}
