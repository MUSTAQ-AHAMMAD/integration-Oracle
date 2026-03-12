package innovate.tamergroup.fusion.soap.transformation;


import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ObjectFactory;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ServiceException;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceiptResult;

import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.fusion.soap.model.StandardReceiptResponse;
import innovate.tamergroup.fusion.soap.services.FusionCustomerProfileClient;
import innovate.tamergroup.fusion.soap.utils.MappingUtils;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.math.BigDecimal;

import java.net.MalformedURLException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

public class FusionStdReceiptTransform {
    
    private FusionAppParams params;
    private Credential credential;
    private ObjectFactory standardReceiptObjectFactory;
    
    public FusionStdReceiptTransform(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.standardReceiptObjectFactory = new ObjectFactory();
    }
    
    public StandardReceipt mapStdReceiptModel(StandardReceiptRequest standardReceiptRequest) throws DatatypeConfigurationException,
                                                                       MalformedURLException, ServiceException,
            com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.ServiceException {
        StandardReceipt standardReceipt = new StandardReceipt();
        standardReceipt.setCurrencyCode(standardReceiptRequest.getCurrencyCode());
        standardReceipt.setReceiptMethodId(standardReceiptRequest.getReceiptMethodId()); 
        standardReceipt.setOrgId(standardReceiptRequest.getOrgId());
        
        standardReceipt.setReceiptNumber(standardReceiptObjectFactory
                                         .createStandardReceiptReceiptNumber(standardReceiptRequest.getReceiptNumber()));
        standardReceipt.setRemittanceBankAccountId(standardReceiptObjectFactory
                                                   .createStandardReceiptRemittanceBankAccountId(standardReceiptRequest
                                                                                                 .getRemittanceBankAccountId()));
        
        standardReceipt.setCustomerId(standardReceiptObjectFactory
                                      .createStandardReceiptCustomerId(
                new FusionCustomerProfileClient(params, credential).getCustomerAccountId(standardReceiptRequest.getAccountValue())));
        standardReceiptRequest.setCustomerId(standardReceipt.getCustomerId().getValue());
        
        XMLGregorianCalendar xmlSaleDate = MappingUtils.convertToGregCalendar(standardReceiptRequest.getSaleDate());
        standardReceipt.setReceiptDate(xmlSaleDate);
        standardReceipt.setGlDate(standardReceiptObjectFactory.createStandardReceiptGlDate(xmlSaleDate));
        standardReceipt.setDepositDate(standardReceiptObjectFactory.createStandardReceiptDepositDate(xmlSaleDate));
        
        AmountType receiptAmount = new AmountType();
        receiptAmount.setCurrencyCode(standardReceiptRequest.getCurrencyCode());
        receiptAmount.setValue(standardReceiptRequest.getReceiptAmount());
        standardReceipt.setAmount(receiptAmount);

        return standardReceipt;
    }

    public StandardReceiptResponse mapStdReceiptModel(StandardReceiptResult standardReceiptResult) {
        StandardReceiptResponse standardReceiptResponse = new StandardReceiptResponse();
        standardReceiptResponse.setSuccessResponse(standardReceiptResult.getValue() != null);
        if (standardReceiptResponse.getSuccessResponse())
            standardReceiptResult.getValue().stream()
                             .forEach(standardReceipt -> 
                                      standardReceiptResponse.getCustomerReceiptReferenceMap()
                                                             .put(standardReceipt.getReceiptNumber().getValue(), 
                                                                standardReceipt.getCustomerReceiptReference().getValue()));
        return standardReceiptResponse;
    }
}
