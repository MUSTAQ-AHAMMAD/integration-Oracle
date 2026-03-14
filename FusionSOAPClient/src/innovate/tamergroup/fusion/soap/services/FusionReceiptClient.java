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

/**
 * SOAP client for creating receipts in Oracle Fusion Receivables.
 *
 * <p>Handles three receipt operations, each backed by a distinct Oracle Fusion SOAP service:
 * <ol>
 *   <li>Standard Receipt creation – {@link #saveStandardReceipt}</li>
 *   <li>Miscellaneous Receipt creation – {@link #saveMiscReceipt}</li>
 *   <li>Apply Receipt to Invoice – {@link #saveApplyStandardReceipt}</li>
 * </ol>
 *
 * <p><b>Authentication:</b> HTTP Basic Auth via {@link innovate.tamergroup.shared.utils.SOAPUtils#setCredentials}.
 */
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

    /**
     * Creates a standard (cash/bank) receipt in Oracle Fusion Receivables.
     *
     * <p><b>Endpoint:</b>
     * {@code https://{hostname}.fa.{region}.oraclecloud.com/fscmService/StandardReceiptService?WSDL}
     * <br>Service: {@code StandardReceiptService} (port: {@code StandardReceiptServiceSoapHttpPort})
     * <br>Namespace: {@code http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/}
     *
     * <p><b>SOAP Operation:</b> {@code createStandardReceipt}
     * <br><b>SOAP Action:</b>
     * {@code http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/createStandardReceipt}
     *
     * <p><b>Request payload fields ({@link innovate.tamergroup.fusion.soap.model.StandardReceiptRequest}):</b>
     * <ul>
     *   <li>{@code currencyCode}            – ISO currency code (e.g. {@code AED}, {@code USD})</li>
     *   <li>{@code saleDate}                – receipt date / GL date</li>
     *   <li>{@code receiptMethodId}         – payment method ID from Fusion (bank or cash method)</li>
     *   <li>{@code receiptNumber}           – receipt number, format: {@code {PaymentType}-{TransactionNumber}}</li>
     *   <li>{@code remittanceBankAccountId} – bank or cash account ID for remittance</li>
     *   <li>{@code accountValue}            – customer account number</li>
     *   <li>{@code region}                  – region code (e.g. {@code KW}, {@code OM})</li>
     *   <li>{@code orgId}                   – Oracle Fusion business unit / org ID</li>
     *   <li>{@code customerId}              – customer party ID in Fusion</li>
     *   <li>{@code receiptAmount}           – total receipt amount (sum of all payment lines)</li>
     * </ul>
     *
     * @param standardReceiptRequest the standard receipt data to submit
     * @return {@link innovate.tamergroup.fusion.soap.model.StandardReceiptResponse} containing
     *         {@code receiptNumber} and {@code customerReceiptReference}
     */
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
    
    /**
     * Creates a miscellaneous receipt in Oracle Fusion Receivables.
     *
     * <p>Miscellaneous receipts are used for non-customer-related cash collections such as
     * cash-rounding adjustments and non-invoice payments that are posted directly to a
     * receivable activity account instead of being applied to a customer invoice.
     *
     * <p><b>Endpoint:</b>
     * {@code https://{hostname}.fa.{region}.oraclecloud.com/fscmService/MiscellaneousReceiptService?WSDL}
     * <br>Service: {@code MiscellaneousReceiptService} (port: {@code MiscellaneousReceiptServiceSoapHttpPort})
     * <br>Namespace: {@code http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/}
     *
     * <p><b>SOAP Operation:</b> {@code createMiscellaneousReceipt}
     * <br><b>SOAP Action:</b>
     * {@code http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/miscellaneousReceiptService/commonService/createMiscellaneousReceipt}
     *
     * <p><b>Request payload fields ({@link innovate.tamergroup.fusion.soap.model.MiscReceiptRequest}):</b>
     * <ul>
     *   <li>{@code currencyCode}           – ISO currency code (e.g. {@code AED}, {@code USD})</li>
     *   <li>{@code saleDate}               – receipt date / GL date</li>
     *   <li>{@code receiptMethodId}        – payment method ID from Fusion</li>
     *   <li>{@code receiptMethodName}      – payment method name (e.g. {@code Cash}, {@code Credit Card})</li>
     *   <li>{@code receiptNumber}          – unique receipt number, format: {@code {PaymentType}-{TransactionNumber}-MISC}</li>
     *   <li>{@code bankAccountName}        – bank account name; uses cash account for rounding, bank account otherwise</li>
     *   <li>{@code receivableActivityName} – receivable activity name (e.g. {@code Cash Rounding})</li>
     *   <li>{@code orgId}                  – Oracle Fusion business unit / org ID</li>
     *   <li>{@code receiptAmount}          – receipt amount (negative for cash-rounding adjustments)</li>
     * </ul>
     *
     * @param miscReceiptRequest the miscellaneous receipt data to submit
     * @return {@link innovate.tamergroup.fusion.soap.model.MiscReceiptResponse} containing
     *         {@code receivablesTransactionId} and {@code receiptNumber}
     */
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
    
    /**
     * Applies an existing standard receipt to a customer invoice in Oracle Fusion Receivables.
     *
     * <p><b>Endpoint:</b>
     * {@code https://{hostname}.fa.{region}.oraclecloud.com/fscmService/StandardReceiptService?WSDL}
     * <br>Service: {@code StandardReceiptService} (port: {@code StandardReceiptServiceSoapHttpPort})
     * <br>Namespace: {@code http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/}
     *
     * <p><b>SOAP Operation:</b> {@code createApplyReceipt}
     * <br><b>SOAP Action:</b>
     * {@code http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/createApplyReceipt}
     *
     * <p><b>Request payload fields ({@link innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest}):</b>
     * <ul>
     *   <li>{@code transactionNumber}  – Fusion invoice transaction number to apply against</li>
     *   <li>{@code receiptNumber}      – receipt number of the previously created standard receipt</li>
     *   <li>{@code amountApplied}      – amount to apply from the receipt to the invoice</li>
     *   <li>{@code receiptCurrency}    – ISO currency code of the receipt</li>
     *   <li>{@code transactionSource}  – transaction source used on the invoice</li>
     *   <li>{@code accountingDate}     – accounting date for the application</li>
     *   <li>{@code applicationDate}    – application date</li>
     * </ul>
     *
     * @param standardReceiptApplyRequest the receipt application data to submit
     * @return {@link innovate.tamergroup.fusion.soap.model.ApplyReceiptResponse} containing
     *         {@code customerTrxId} and {@code receiptNumber}
     */
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
