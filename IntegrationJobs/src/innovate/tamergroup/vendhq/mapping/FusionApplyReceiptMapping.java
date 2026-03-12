package innovate.tamergroup.vendhq.mapping;

import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.util.HashMap;

public class FusionApplyReceiptMapping {
    
    private FusionAppParams params;
    private Credential credential;
    
    public FusionApplyReceiptMapping(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
    }
    
    public ApplyReceiptRequest mapToApplyReceiptModel(StandardReceiptRequest standardReceiptRequest, HashMap<StandardReceiptRequest, String> receiptInvoiceResultMapping, String transactionSource) {
        ApplyReceiptRequest applyReceiptRequest = new ApplyReceiptRequest();
        applyReceiptRequest.setReceiptDate(standardReceiptRequest.getSaleDate());
        applyReceiptRequest.setTransactionNumber(receiptInvoiceResultMapping.get(standardReceiptRequest));
        applyReceiptRequest.setReceiptNumber(standardReceiptRequest.getReceiptNumber());
        applyReceiptRequest.setAmountApplied(standardReceiptRequest.getReceiptAmount());
        applyReceiptRequest.setReceiptCurrency(standardReceiptRequest.getCurrencyCode());
        applyReceiptRequest.setTransactionSource(transactionSource);
        return applyReceiptRequest;
    }
}
