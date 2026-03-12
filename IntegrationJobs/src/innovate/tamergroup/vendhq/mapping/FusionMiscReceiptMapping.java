package innovate.tamergroup.vendhq.mapping;

import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceipt;

import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.MiscReceiptRequest;
import innovate.tamergroup.persistence.entities.BackupVendhqPayments;
import innovate.tamergroup.persistence.entities.FusionReceiptMethod;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.entities.VendhqRegisters;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

public class FusionMiscReceiptMapping {
    
    private FusionAppParams params;
    private Credential credential;
    private SessionEJB session;

    public FusionMiscReceiptMapping(SessionEJB session, FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.session = session;
    }
    
    public MiscReceiptRequest mapToMiscReceipt(BackupVendhqPayments payment, InvoiceHeader invoice, 
                                                   FusionReceiptMethod receiptMethodMeta, VendhqOutletsDB outletDetail,
                                                   VendhqRegisters registerDetails, String[] metaMappings, String transactionNumber) {
        MiscReceiptRequest miscReceiptRequest = new MiscReceiptRequest();
        miscReceiptRequest.setCurrencyCode(invoice.getInvoiceCurrencyCode());
        miscReceiptRequest.setSaleDate(invoice.getSaleDate());
        miscReceiptRequest.setReceiptMethodId(receiptMethodMeta.getReceiptMethodId().longValue()); 
        
        miscReceiptRequest.setReceiptMethodName(!payment.getPaymentType().contains("Cash") ? payment.getPaymentType() : "Cash");
        miscReceiptRequest.setReceiptNumber(payment.getPaymentType() + "-" + transactionNumber + "-MISC");
        miscReceiptRequest.setBankAccountName(payment.getPaymentType().toLowerCase().contains("rounding")
                                              ? registerDetails.getCashAccount() : registerDetails.getBankAccount());
        miscReceiptRequest.setReceivableActivityName(payment.getPaymentType().toLowerCase().equals("cash rounding") ? metaMappings[1] : metaMappings[2]);
        
        miscReceiptRequest.setOrgId(session.getFusionBusinessUnitIdMapfindByRegion(outletDetail.getRegion()).getBusinessUnitId().longValue());
        
        return miscReceiptRequest;
    }
}
