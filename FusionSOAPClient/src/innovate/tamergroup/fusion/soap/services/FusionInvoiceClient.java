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


/**
 * SOAP client for creating invoices in Oracle Fusion Receivables.
 *
 * <p><b>Endpoint:</b>
 * {@code https://{hostname}.fa.{region}.oraclecloud.com/fscmService/RecInvoiceService?WSDL}
 * <br>Service: {@code InvoiceService} (port: {@code InvoiceServiceSoapHttpPort})
 * <br>Namespace: {@code http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}
 *
 * <p><b>Authentication:</b> HTTP Basic Auth via {@link innovate.tamergroup.shared.utils.SOAPUtils#setCredentials}.
 */
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

    /**
     * Creates a simple invoice in Oracle Fusion Receivables.
     *
     * <p><b>SOAP Operation:</b> {@code createSimpleInvoice}
     * <br><b>SOAP Action:</b>
     * {@code http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/createSimpleInvoice}
     *
     * <p><b>Request payload fields ({@link innovate.tamergroup.fusion.soap.model.InvoiceHeader}):</b>
     * <ul>
     *   <li>{@code billToCustomerName}  – customer name for the bill-to party</li>
     *   <li>{@code billToLocation}      – customer site / location number</li>
     *   <li>{@code billToAccountNumber} – customer account number in Fusion</li>
     *   <li>{@code businessUnit}        – Oracle Fusion business unit name</li>
     *   <li>{@code transactionSource}   – transaction source (e.g. {@code Manual})</li>
     *   <li>{@code transactionType}     – transaction type (e.g. {@code PASA CONSULTING SALE})</li>
     *   <li>{@code invoiceCurrencyCode} – ISO currency code (e.g. {@code AED}, {@code USD})</li>
     *   <li>{@code conversionRateType}  – {@code Corporate} or {@code User}</li>
     *   <li>{@code paymentTermsName}    – payment terms fetched from CustomerProfileService</li>
     *   <li>{@code saleDate}            – invoice date / GL date</li>
     *   <li>{@code invoiceLines}        – list of {@link innovate.tamergroup.fusion.soap.model.InvoiceLineModel}:
     *     <ul>
     *       <li>{@code lineNumber}           – sequential line number</li>
     *       <li>{@code itemNumber}           – Fusion inventory item number</li>
     *       <li>{@code memoLineName}         – memo line name (used for discount lines)</li>
     *       <li>{@code description}          – line description</li>
     *       <li>{@code quantity}             – quantity sold</li>
     *       <li>{@code uomCode}              – unit of measure code</li>
     *       <li>{@code unitSellingPrice}     – selling price per unit</li>
     *       <li>{@code currencyCode}         – line currency code</li>
     *       <li>{@code salesOrder}           – VendHQ invoice number used as sales order reference</li>
     *       <li>{@code salesOrderLine}       – sales order line number</li>
     *       <li>{@code taxClassificationCode}– tax classification code</li>
     *     </ul>
     *   </li>
     * </ul>
     *
     * @param invoiceHeader the invoice header and line data to submit
     * @return {@link innovate.tamergroup.fusion.soap.model.InvoiceResponse} containing
     *         {@code serviceStatus}, {@code transactionNumber}, and {@code customerTransactionId}
     */
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

