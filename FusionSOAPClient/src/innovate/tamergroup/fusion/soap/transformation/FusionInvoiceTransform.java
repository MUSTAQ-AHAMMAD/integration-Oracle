package innovate.tamergroup.fusion.soap.transformation;

import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;
import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.ServiceException;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.Invoice;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceLine;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceResult;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.ObjectFactory;

import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceLineModel;
import innovate.tamergroup.fusion.soap.model.InvoiceResponse;
import innovate.tamergroup.fusion.soap.services.FusionCustomerProfileClient;
import innovate.tamergroup.fusion.soap.utils.MappingUtils;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.net.MalformedURLException;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class FusionInvoiceTransform {
    
    private FusionAppParams params;
    private Credential credential;
    private ObjectFactory invoiceObjectFactory;
    
    public FusionInvoiceTransform(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.invoiceObjectFactory = new ObjectFactory();
    }
    
    public Invoice mapInvoiceModel(InvoiceHeader invoiceHeader) throws DatatypeConfigurationException,
                                                                       MalformedURLException, ServiceException {
        Invoice invoice = new Invoice();
        invoice.setBillToCustomerName(invoiceObjectFactory.createInvoiceBillToCustomerName(invoiceHeader.getBillToCustomerName()));
        invoice.setBillToLocation(invoiceObjectFactory.createInvoiceBillToLocation(invoiceHeader.getBillToLocation()));
        invoice.setBillToAccountNumber(invoiceObjectFactory.createInvoiceBillToAccountNumber(invoiceHeader.getBillToAccountNumber()));
        invoice.setBusinessUnit(invoiceObjectFactory.createInvoiceBusinessUnit(invoiceHeader.getBusinessUnit()));
        invoice.setTransactionSource(invoiceObjectFactory.createInvoiceTransactionSource(invoiceHeader.getTransactionSource()));
        invoice.setTransactionType(invoiceObjectFactory.createInvoiceTransactionType(invoiceHeader.getTransactionType()));
        invoice.setInvoiceCurrencyCode(invoiceHeader.getInvoiceCurrencyCode());
        invoice.setConversionRateType(invoiceObjectFactory.createInvoiceConversionRateType(invoiceHeader.getConversionRateType()));

        invoiceHeader.setPaymentTermsName(new FusionCustomerProfileClient(params, credential).getPaymentTerms(invoiceHeader.getBillToAccountNumber()));
        invoice.setPaymentTermsName(invoiceObjectFactory.createInvoicePaymentTermsName(invoiceHeader.getPaymentTermsName()));
        
        XMLGregorianCalendar xmlSaleDate = MappingUtils.convertToGregCalendar(invoiceHeader.getSaleDate());
        invoice.setTrxDate(xmlSaleDate);
        invoice.setGlDate(invoiceObjectFactory.createInvoiceGlDate(xmlSaleDate));
        
        for (InvoiceLineModel invoiceLineModel : invoiceHeader.getInvoiceLines()) 
            invoice.getInvoiceLine().add(mapInvoiceLineModel(invoiceLineModel));        

        return invoice;
    }
    
    public InvoiceLine mapInvoiceLineModel(InvoiceLineModel invoiceLineModel) throws DatatypeConfigurationException,
                                                                       MalformedURLException, ServiceException {
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setLineNumber(invoiceLineModel.getLineNumber());
        invoiceLine.setItemNumber(invoiceObjectFactory.createInvoiceLineItemNumber(invoiceLineModel.getItemNumber()));
        invoiceLine.setMemoLineName(invoiceObjectFactory.createInvoiceLineMemoLineName(invoiceLineModel.getMemoLineName()));
        invoiceLine.setDescription(invoiceObjectFactory.createInvoiceLineDescription(invoiceLineModel.getDescription()));
        
        MeasureType quantity = new MeasureType();
        quantity.setValue(invoiceLineModel.getQuantity());
        quantity.setUnitCode(invoiceLineModel.getUomCode());
        invoiceLine.setQuantity(invoiceObjectFactory.createInvoiceLineQuantity(quantity));                                       

        AmountType unitSellingPrice = new AmountType();
        unitSellingPrice.setCurrencyCode(invoiceLineModel.getCurrencyCode());
        unitSellingPrice.setValue(invoiceLineModel.getUnitSellingPrice());
        invoiceLine.setUnitSellingPrice(invoiceObjectFactory.createInvoiceLineUnitSellingPrice(unitSellingPrice));
        
        invoiceLine.setSalesOrder(invoiceObjectFactory.createInvoiceLineSalesOrder(invoiceLineModel.getSalesOrder()));
        invoiceLine.setSalesOrderLine(invoiceObjectFactory.createInvoiceLineSalesOrderLine(invoiceLineModel.getSalesOrderLine()));
        invoiceLine.setTaxClassificationCode(invoiceObjectFactory.createInvoiceLineTaxClassificationCode(invoiceLineModel.getTaxClassificationCode()));

        return invoiceLine;
    }
    
    public InvoiceResponse mapToInvoiceResponse(InvoiceResult invoiceResult) {
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setServiceStatus(invoiceResult.getServiceStatus().getValue());
        invoiceResponse.setTransactionNumber(invoiceResult.getTransactionNumber().getValue());
        invoiceResponse.setCustomerTransactionId(invoiceResult.getCustomerTrxId().getValue());
        return invoiceResponse;
    }
}
