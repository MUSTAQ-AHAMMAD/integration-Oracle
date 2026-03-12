package innovate.tamergroup.fusion.soap.transformation;

import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ApplyReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ApplyReceiptResult;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ObjectFactory;

import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.ApplyReceiptResponse;
import innovate.tamergroup.fusion.soap.utils.MappingUtils;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import javax.xml.datatype.XMLGregorianCalendar;

public class FusionApplyReceiptTransform {
    
    private FusionAppParams params;
    private Credential credential;
    private ObjectFactory standardReceiptObjectFactory;
    
    public FusionApplyReceiptTransform(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.standardReceiptObjectFactory = new ObjectFactory();
    }

    public ApplyReceipt mapApplyReceiptModel(ApplyReceiptRequest applyReceiptRequest) {
        ApplyReceipt applyReceipt = new ApplyReceipt();
        applyReceipt.setTransactionNumber(standardReceiptObjectFactory.createApplyReceiptTransactionNumber(applyReceiptRequest.getTransactionNumber()));
        applyReceipt.setReceiptNumber(standardReceiptObjectFactory.createApplyReceiptReceiptNumber(applyReceiptRequest.getReceiptNumber()));
        applyReceipt.setAmountApplied(applyReceiptRequest.getAmountApplied());
        applyReceipt.setReceiptCurrency(standardReceiptObjectFactory.createApplyReceiptReceiptCurrency(applyReceiptRequest.getReceiptCurrency()));
        applyReceipt.setTransactionSource(standardReceiptObjectFactory.createApplyReceiptTransactionSource(applyReceiptRequest.getTransactionSource()));
        
        XMLGregorianCalendar xmlSaleDate = MappingUtils.convertToGregCalendar(applyReceiptRequest.getReceiptDate());
        applyReceipt.setAccountingDate(xmlSaleDate);
        applyReceipt.setApplicationDate(xmlSaleDate);
        
        return applyReceipt;
    }

    public ApplyReceiptResponse mapApplyReceiptModel(ApplyReceiptResult result) {
        ApplyReceiptResponse receiptResponse = new ApplyReceiptResponse();
        receiptResponse.setSuccessResponse(result != null);
        return receiptResponse;
    }
}
