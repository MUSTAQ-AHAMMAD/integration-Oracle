package innovate.tamergroup.fusion.soap.transformation;

import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.ObjectFactory;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceiptResult;

import innovate.tamergroup.fusion.soap.model.MiscReceiptRequest;
import innovate.tamergroup.fusion.soap.model.MiscReceiptResponse;
import innovate.tamergroup.fusion.soap.utils.MappingUtils;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

public class FusionMiscReceiptTransform {
    
    private FusionAppParams params;
    private Credential credential;
    private ObjectFactory miscReceiptObjectFactory;
    
    public FusionMiscReceiptTransform(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.miscReceiptObjectFactory = new ObjectFactory();
    }

    public MiscellaneousReceipt mapMiscReceiptModel(MiscReceiptRequest miscReceiptRequest) {
        MiscellaneousReceipt miscReceipt = new MiscellaneousReceipt();
        miscReceipt.setCurrencyCode(miscReceiptRequest.getCurrencyCode());
        miscReceipt.setReceiptMethodId(miscReceiptRequest.getReceiptMethodId()); 
        miscReceipt.setReceiptMethodName(miscReceiptObjectFactory.createMiscellaneousReceiptReceiptMethodName(miscReceiptRequest.getReceiptMethodName()));
        miscReceipt.setReceiptNumber(miscReceiptObjectFactory.createMiscellaneousReceiptReceiptNumber(miscReceiptRequest.getReceiptNumber()));
        miscReceipt.setBankAccountName(miscReceiptObjectFactory.createMiscellaneousReceiptBankAccountName(miscReceiptRequest.getBankAccountName()));
        miscReceipt.setReceivableActivityName(miscReceiptObjectFactory.createMiscellaneousReceiptReceivableActivityName(miscReceiptRequest.getReceivableActivityName()));
        miscReceipt.setOrgId(miscReceiptRequest.getOrgId());
        
        XMLGregorianCalendar xmlSaleDate = MappingUtils.convertToGregCalendar(miscReceiptRequest.getSaleDate());
        miscReceipt.setReceiptDate(xmlSaleDate);
        miscReceipt.setGlDate(miscReceiptObjectFactory.createMiscellaneousReceiptGlDate(xmlSaleDate));
        
        AmountType receiptAmount = new AmountType();
        receiptAmount.setCurrencyCode(miscReceiptRequest.getCurrencyCode());
        receiptAmount.setValue(miscReceiptRequest.getReceiptAmount());
        miscReceipt.setAmount(receiptAmount);

        return miscReceipt;
    }

    public MiscReceiptResponse mapMiscReceiptModel(MiscellaneousReceiptResult result) {
        MiscReceiptResponse miscReceiptResponse = new MiscReceiptResponse();
        miscReceiptResponse.setSuccessResponse(result.getValue() != null);
        return miscReceiptResponse;
    }
}
