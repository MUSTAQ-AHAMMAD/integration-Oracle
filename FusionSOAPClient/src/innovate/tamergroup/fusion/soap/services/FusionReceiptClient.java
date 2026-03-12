package innovate.tamergroup.fusion.soap.services;


import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceiptResult;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceiptService;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceiptService_Service;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ApplyReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ApplyReceiptResult;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceiptResult;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceiptService;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceiptService_Service;

import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.ApplyReceiptResponse;
import innovate.tamergroup.fusion.soap.model.MiscReceiptRequest;
import innovate.tamergroup.fusion.soap.model.MiscReceiptResponse;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.fusion.soap.model.StandardReceiptResponse;
import innovate.tamergroup.fusion.soap.transformation.FusionApplyReceiptTransform;
import innovate.tamergroup.fusion.soap.transformation.FusionMiscReceiptTransform;
import innovate.tamergroup.fusion.soap.transformation.FusionStdReceiptTransform;
import innovate.tamergroup.fusion.soap.utils.FusionSOAPUtils;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.shared.utils.SOAPUtils;

import java.io.ByteArrayInputStream;

import javax.xml.ws.BindingProvider;

import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;

public class FusionReceiptClient {
    
    private FusionAppParams params;
    private Credential credential;
    private FusionStdReceiptTransform fusionStdReceiptTransform;
    private FusionApplyReceiptTransform fusionApplyStandardReceiptTransform;
    private FusionMiscReceiptTransform fusionMiscReceiptTransform;


    public FusionReceiptClient(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
        this.fusionStdReceiptTransform = new FusionStdReceiptTransform(params, credential);
        this.fusionApplyStandardReceiptTransform = new FusionApplyReceiptTransform(params, credential);
        this.fusionMiscReceiptTransform = new FusionMiscReceiptTransform(params, credential);
    }

    public StandardReceiptResponse saveStandardReceipt(StandardReceiptRequest standardReceiptRequest) throws Exception {
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));
        
        StandardReceiptService standardReceiptService =
            new StandardReceiptService_Service(params).getStandardReceiptServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)standardReceiptService, credential);

        StandardReceiptResult result = standardReceiptService.createStandardReceipt(fusionStdReceiptTransform.mapStdReceiptModel(standardReceiptRequest));
        System.out.println();
        System.out.println("Message: " + result.getMessage());
        for (StandardReceipt resultItem : result.getValue()) {
            System.out.println("Cust Receipt Ref: " + resultItem.getCustomerReceiptReference().getValue());
            System.out.println("Receipt#: " + resultItem.getReceiptNumber().getValue());
            System.out.println();                                    
        }
        
        return fusionStdReceiptTransform.mapStdReceiptModel(result);
    }
    
    public MiscReceiptResponse saveMiscReceipt(MiscReceiptRequest miscReceiptRequest) throws Exception {
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));
        
        MiscellaneousReceiptService miscellaneousReceiptService =
            new MiscellaneousReceiptService_Service(params).getMiscellaneousReceiptServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)miscellaneousReceiptService, credential);
        
        MiscellaneousReceiptResult result = miscellaneousReceiptService.createMiscellaneousReceipt(fusionMiscReceiptTransform.mapMiscReceiptModel(miscReceiptRequest));
        System.out.println();
        System.out.println("Message: " + result.getMessage());
        for (MiscellaneousReceipt resultItem : result.getValue()) {
            System.out.println("Rec Txn ID: " + resultItem.getReceivablesTransactionId().getValue());
            System.out.println("Receipt#: " + resultItem.getReceiptNumber().getValue());
            System.out.println();                                    
        }
        
        return fusionMiscReceiptTransform.mapMiscReceiptModel(result);
    }
    
    public ApplyReceiptResponse saveApplyStandardReceipt(ApplyReceiptRequest standardReceiptApplyRequest) throws Exception {      
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));
        
        StandardReceiptService standardReceiptService =
            new StandardReceiptService_Service(params).getStandardReceiptServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)standardReceiptService, credential);

        ApplyReceiptResult result = standardReceiptService.createApplyReceipt(fusionApplyStandardReceiptTransform.mapApplyReceiptModel(standardReceiptApplyRequest));
        System.out.println();
        System.out.println("Message: " + result.getMessage());
        for (ApplyReceipt resultItem : result.getValue()) {
            System.out.println("Cust Txn ID: " + resultItem.getCustomerTrxId().getValue());
            System.out.println("Receipt#: " + resultItem.getReceiptNumber().getValue());
            System.out.println();                                    
        }
        
        return fusionApplyStandardReceiptTransform.mapApplyReceiptModel(result);
    }

    public static void main(String[] args) {
        //saveReceiptAndApply
    }

}
