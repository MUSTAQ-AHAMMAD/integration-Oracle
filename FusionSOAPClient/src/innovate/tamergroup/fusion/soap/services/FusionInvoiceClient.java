package innovate.tamergroup.fusion.soap.services;


import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceResult;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceService;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceService_Service;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.ServiceException;

import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceResponse;
import innovate.tamergroup.fusion.soap.transformation.FusionInvoiceTransform;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.shared.utils.SOAPUtils;

import java.io.ByteArrayInputStream;

import java.net.MalformedURLException;

import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;


public class FusionInvoiceClient {
    
    private FusionAppParams params;
    private Credential credential;
    private Logger logger = Logger.getLogger(FusionInvoiceClient.class.getSimpleName());
    private FusionInvoiceTransform fusionInvoiceTransform;
    
    public FusionInvoiceClient(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.fusionInvoiceTransform = new FusionInvoiceTransform(params, credential);
    }

    public InvoiceResponse saveInvoice(InvoiceHeader invoiceHeader) throws ServiceException, 
                                        MalformedURLException, DatatypeConfigurationException, 
        com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.ServiceException {
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));

        InvoiceService invoiceService = new InvoiceService_Service(params).getInvoiceServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider) invoiceService, credential);

        InvoiceResult invoiceResult = invoiceService.createSimpleInvoice(fusionInvoiceTransform.mapInvoiceModel(invoiceHeader));
        System.out.println("Result: " + invoiceResult.getServiceStatus().getValue());
        System.out.println("TxnNumber: " + invoiceResult.getTransactionNumber().getValue());
        System.out.println("CustomerTrxnId: " + invoiceResult.getCustomerTrxId().getValue());

        return fusionInvoiceTransform.mapToInvoiceResponse(invoiceResult);
    }
    
    
    


    public static void main(String[] args) throws ServiceException, MalformedURLException, DatatypeConfigurationException,
            com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.ServiceException {
        /*FusionInvoiceClient fusionInvoiceClient = new FusionInvoiceClient();
        ObjectFactory invoiceObjectFactory  = new ObjectFactory();

        IIntegrationService integrationService = new IntegrationService("172.16.2.101", 8642).getBasicHttpBindingIIntegrationService();
        Transaction sale = integrationService.getTransaction(10000000000000006L);
        Invoice invoice = new Invoice();
        int saleItemCounter = 1;
        for (TransactionItem saleItem : sale.getSaleItems().getValue().getTransactionItems()) {
            //System.out.println("\t" + saleItem.getProductId().getValue());
            InvoiceLine invoiceLine = new InvoiceLine();
            invoiceLine.setLineNumber(saleItemCounter++);
            invoiceLine.setDescription(invoiceObjectFactory.createInvoiceLineDescription("iVend Invoice for Product ID: " + saleItem.getProductId().getValue()));
            MeasureType quantity = new MeasureType();
            //quantity.setUnitCode(saleItem.getUOMId().getValue());
            quantity.setValue(saleItem.getQuantity());
            invoiceLine.setQuantity(invoiceObjectFactory.createInvoiceLineQuantity(quantity));
            //double saleTotal = sale.getTotalPrice() + sale.getTotalTax();
            AmountType unitSellingPrice = new AmountType();
            unitSellingPrice.setCurrencyCode(sale.getPayments().getValue().getTransactionPayments().get(0).getCurrencyId().getValue());
            unitSellingPrice.setValue(saleItem.getTotalPostSaleDiscount());
            invoiceLine.setUnitSellingPrice(invoiceObjectFactory.createInvoiceLineUnitSellingPrice(unitSellingPrice));
            invoice.getInvoiceLine().add(invoiceLine);
        }


        invoice.setBillToAccountNumber(invoiceObjectFactory.createInvoiceBillToAccountNumber("3"));
        invoice.setBillToCustomerName(invoiceObjectFactory.createInvoiceBillToCustomerName("CHARTER BROKERS"));
        invoice.setBusinessUnit(invoiceObjectFactory.createInvoiceBusinessUnit("PASA BU"));
        invoice.setConversionRateType(invoiceObjectFactory.createInvoiceConversionRateType("Corporate"));
        invoice.setGlDate(invoiceObjectFactory.createInvoiceGlDate(sale.getTransactionDate()));
        invoice.setInvoiceCurrencyCode(sale.getPayments().getValue().getTransactionPayments().get(0).getCurrencyId().getValue());
        invoice.setPaymentTermsName(invoiceObjectFactory.createInvoicePaymentTermsName("IMMEDIATE"));
        //invoice.setPurchaseOrder(invoiceObjectFactory.createInvoicePurchaseOrder(sale.getTransactionId().getValue()));
        invoice.setTransactionSource(invoiceObjectFactory.createInvoiceTransactionSource("Manual"));
        invoice.setTransactionType(invoiceObjectFactory.createInvoiceTransactionType("PASA CONSULTING SALE"));


        fusionInvoiceClient.saveInvoice(invoice, new Credential("Starsha", "St@1975"));*/
    }
}

