package innovate.tamergroup.vendhq.mapping;

import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.adf.svc.types.MeasureType;

import innovate.tamergroup.fusion.rest.services.FusionUomService;
import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceLineModel;
import innovate.tamergroup.fusion.soap.utils.MappingUtils;
import innovate.tamergroup.persistence.entities.BackupVendhqLineItems;
import innovate.tamergroup.persistence.entities.BackupVendhqSales;
import innovate.tamergroup.persistence.entities.FusionSalesMetadata;
import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.HashMap;

public class FusionInvoiceMapping {
    
    private FusionAppParams params;
    private Credential credential;
    private HashMap<String, String> uomCodeMapping;
    
    public FusionInvoiceMapping(FusionAppParams params, Credential credential) {
        super();
        this.params = params;
        this.credential = credential;
        this.uomCodeMapping = new HashMap<>();
    }
    
    public InvoiceHeader mapToInvoiceHeader(BackupVendhqSales sale, FusionSalesMetadata salesMetaData, 
                                            VendhqOutletsDB outletDetail, Integer hoursOffset, Integer minutesOffset) {
        InvoiceHeader invoiceHeader = new InvoiceHeader();
        invoiceHeader.setBillToCustomerName(salesMetaData.getBillToName());
        invoiceHeader.setBillToLocation(salesMetaData.getSiteNumber());
        invoiceHeader.setBillToAccountNumber(String.valueOf(salesMetaData.getBillToAccount()));
        invoiceHeader.setBusinessUnit(salesMetaData.getBusinessUnit());
        invoiceHeader.setOutletName(outletDetail.getOutletName());
        invoiceHeader.setSaleDate(MappingUtils.getTimeZoneOffsetDate(sale.getSaleDate(), hoursOffset, minutesOffset));


        invoiceHeader.setTransactionSource(salesMetaData.getTxnSource());
        invoiceHeader.setTransactionType(salesMetaData.getTxnType());
        invoiceHeader.setInvoiceCurrencyCode(outletDetail.getCurrency());
        invoiceHeader.setConversionRateType(salesMetaData.getRateIsCorporate().equals("1") ? "Corporate" : "User");
        
        return invoiceHeader;
    }
    
    public InvoiceLineModel mapToInvoiceLine(InvoiceHeader invoiceHeader, BackupVendhqSales sale, 
                                             BackupVendhqLineItems lineItem, VendhqItemMeta itemMeta) throws IOException {
        InvoiceLineModel invoiceLine = new InvoiceLineModel();
        invoiceLine.setLineNumber(invoiceHeader.getInvoiceLines().size()+1);
        invoiceLine.setItemNumber(lineItem.getItemNumber());
        if (lineItem.getItemName().equals("Discount Item"))
            invoiceLine.setMemoLineName("Discount Item");
        
        invoiceLine.setQuantity(lineItem.getQuantity());
        if (lineItem.getItemName().equals("Discount Item") && lineItem.getTotalPrice().intValue() > 0)
            invoiceLine.setQuantity(BigDecimal.valueOf(1));
                                                              
        if (itemMeta != null) {    
            invoiceLine.setDescription(itemMeta.getDescription());
            if (!uomCodeMapping.containsKey(itemMeta.getUomName()))
                uomCodeMapping.put(itemMeta.getUomName(), new FusionUomService(params, credential).getUomCode(itemMeta.getUomName()));
            invoiceLine.setUomCode(uomCodeMapping.get(itemMeta.getUomName()));
        } else invoiceLine.setDescription(lineItem.getItemName());
        
        invoiceLine.setCurrencyCode(invoiceHeader.getInvoiceCurrencyCode());
        BigDecimal sellingPrice = lineItem.getTotalPrice().divide(lineItem.getQuantity());
        invoiceLine.setUnitSellingPrice(sellingPrice.abs());
        
        invoiceLine.setSalesOrder(sale.getInvoiceNumber());
        invoiceLine.setSalesOrderLine(String.valueOf(lineItem.getLineNumber()));
        invoiceLine.setTaxClassificationCode(lineItem.getTaxName());
        
        return invoiceLine;
    }
}
