package innovate.tamergroup.vendhq.transformation;


import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import innovate.tamergroup.email.SendEmailNotification;
import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceLineModel;
import innovate.tamergroup.fusion.soap.model.InvoiceResponse;
import innovate.tamergroup.fusion.soap.model.JournalHeader;
import innovate.tamergroup.fusion.soap.model.MiscReceiptRequest;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.persistence.entities.BackupVendhqLineItems;
import innovate.tamergroup.persistence.entities.BackupVendhqPayments;
import innovate.tamergroup.persistence.entities.BackupVendhqSales;
import innovate.tamergroup.persistence.entities.FusionReceiptMethod;
import innovate.tamergroup.persistence.entities.FusionSalesMetadata;
import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.entities.VendhqRegisters;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.mapping.FusionApplyReceiptMapping;
import innovate.tamergroup.vendhq.mapping.FusionInvTxnMapping;
import innovate.tamergroup.vendhq.mapping.FusionInvoiceMapping;
import innovate.tamergroup.vendhq.mapping.FusionJournalEntryMapping;
import innovate.tamergroup.vendhq.mapping.FusionMiscReceiptMapping;
import innovate.tamergroup.vendhq.mapping.FusionStdReceiptMapping;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class VendHQSalesToFusionInvRecTransBackup {

    private SessionEJB session;
    private SendEmailNotification emailNotify;
    private VendhqOutletsDB outletDetail;
    private FusionAppParams params;
    private Credential credential;
    private Integer hoursOffset, minutesOffset;
    private FusionInvoiceMapping fusionInvoiceMapping;
    private FusionInvTxnMapping fusionInvTxnMapping;
    private FusionStdReceiptMapping fusionStdReceiptMapping;
    private FusionApplyReceiptMapping fusionApplyReceiptMapping;
    private FusionJournalEntryMapping fusionJournalEntryMapping;
    private FusionMiscReceiptMapping fusionMiscReceiptMapping;
    
    private HashMap<String, InvoiceHeader> invoiceMapping;
    private HashMap<InvoiceLineModel, Date> invoiceLineDateMapping;
    private HashMap<InvoiceLineModel, BigDecimal> saleVersionMapping;
    private HashMap<StandardReceiptRequest, String> receiptInvoiceResultMapping;
    private List<ApplyReceiptRequest> applyReceiptList;
    private HashMap<String, String[]> metaMapping;
    private HashMap<String, StandardReceiptRequest> standardReceiptMapping;
    private HashMap<String, MiscReceiptRequest> miscReceiptMapping;
    private HashSet<String> salesReceiptDoneStatus;
    private HashMap<String, List<TransactionLine>> salesTransactionLinesMapping;


    public VendHQSalesToFusionInvRecTransBackup(SessionEJB session, SendEmailNotification emailNotify, VendhqOutletsDB outlet, FusionAppParams params, 
                                                Credential credential, Integer hoursOffset, Integer minutesOffset) {
        super();
        this.emailNotify = emailNotify;
        this.outletDetail = outlet;
        this.session = session;
        this.params = params;
        this.credential = credential;
        this.hoursOffset = hoursOffset;
        this.minutesOffset = minutesOffset;
        this.fusionInvoiceMapping = new FusionInvoiceMapping(params, credential);
        this.fusionInvTxnMapping = new FusionInvTxnMapping(session, params, credential);
        this.fusionStdReceiptMapping = new FusionStdReceiptMapping(session, params, credential);
        this.fusionApplyReceiptMapping = new FusionApplyReceiptMapping(params, credential);
        this.fusionJournalEntryMapping = new FusionJournalEntryMapping(session, params, credential, outlet);
        this.fusionMiscReceiptMapping = new FusionMiscReceiptMapping(session, params, credential);

        invoiceMapping = new HashMap<>();
        receiptInvoiceResultMapping = new HashMap<>();
        applyReceiptList = new ArrayList<>();
        standardReceiptMapping = new HashMap<>();
        miscReceiptMapping = new HashMap<>();
        salesTransactionLinesMapping = new HashMap<>();
        saleVersionMapping = new HashMap<>();
        metaMapping = new HashMap<>();
        salesReceiptDoneStatus = new HashSet<>();
        invoiceLineDateMapping = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public void addInvoiceMapping(BackupVendhqSales sale, HashMap<String, FusionSalesMetadata> salesMetaDataMap) throws Exception {
        
        StringBuilder saleKeys = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getTimeZoneOffsetDate(sale.getSaleDate()).getTime());
        saleKeys.append(calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR));
        saleKeys.append(sale.getCustomerType());
        
        List<BackupVendhqPayments> payments = session.getPaymentsByInvoiceNumber(sale.getInvoiceNumber(), sale.getSaleDate(), outletDetail.getRegion());
        for (BackupVendhqPayments payment : payments) {
            if (payment.getPaymentType().equals("Credit On Cust")) {
                saleKeys.append("**Credit");
                break;
            }
        }
        
        System.out.println("Invoice#: " + sale.getInvoiceNumber());
        
        /*--------     INVOICE HEADER CREATION     ------------ */ 
        if (!invoiceMapping.containsKey(saleKeys.toString()))           
            invoiceMapping.put(saleKeys.toString(), 
                               fusionInvoiceMapping.mapToInvoiceHeader(sale, salesMetaDataMap.get(sale.getCustomerType()), 
                                                                       outletDetail, hoursOffset, minutesOffset));
        
        String[] metaMappings = new String[]{sale.getRegisterName(), salesMetaDataMap.get(sale.getCustomerType()).getRecActivityNameCash(), 
                                             salesMetaDataMap.get(sale.getCustomerType()).getRecActivityNameBank(), sale.getCustomerType(), 
                                             saleKeys.toString().contains("Credit") ? "Credit" : "Normal", sale.getTotalPriceInclTax().toString(),
                                             salesMetaDataMap.get(sale.getCustomerType()).getCostCenterCode()};
        metaMapping.put(sale.getInvoiceNumber(), metaMappings);
        
        InvoiceHeader invoiceHeader = invoiceMapping.get(saleKeys.toString());
        List<BackupVendhqLineItems> lineItems = session.getLineItemsByInvoice(sale.getInvoiceNumber(), sale.getSaleDate(), outletDetail.getRegion());
        for (BackupVendhqLineItems lineItem : lineItems) {
            if (lineItem.getQuantity().intValue() == 0) continue;
            String existingInvoiceNumber = session.getFusionInvoiceLineFindSalesTxnLine(sale.getInvoiceNumber(), lineItem.getLineNumber(), sale.getVersion(), outletDetail.getRegion());

            /*--------      INVOICE LINE CREATION     ------------ */ 
            VendhqItemMeta itemMeta = session.getVendHQItemRowFusion(lineItem.getItemNumber(), outletDetail.getRegion());
            InvoiceLineModel invoiceLine = fusionInvoiceMapping.mapToInvoiceLine(invoiceHeader, sale, lineItem, itemMeta);
            invoiceLineDateMapping.put(invoiceLine, sale.getSaleDate());
            saleVersionMapping.put(invoiceLine, sale.getVersion());
            
            if (existingInvoiceNumber == null) invoiceHeader.getInvoiceLines().add(invoiceLine);
            else {
                addReceiptMappingLine(invoiceHeader, invoiceLine, existingInvoiceNumber);
                addJournalEntry(invoiceHeader, invoiceLine, new InvoiceResponse(existingInvoiceNumber));
            }
            
            /*--------      INVENTORY TRANSACTION LINES CREATION     ------------ */ 
            if (itemMeta != null && !session.getFindInvTxn(sale.getInvoiceNumber(), sale.getSaleDate(), itemMeta.getSku(), outletDetail.getRegion())) {
                if (!salesTransactionLinesMapping.containsKey(saleKeys.toString()))
                    salesTransactionLinesMapping.put(saleKeys.toString(), new ArrayList<TransactionLine>());
                salesTransactionLinesMapping.get(saleKeys.toString()).add(fusionInvTxnMapping.mapToInvTransactionModel(sale, itemMeta, lineItem, outletDetail, sale.getCustomerType()));
            }
        }
    }


    public void addReceiptMapping(InvoiceHeader invoice, InvoiceResponse invoiceResult) throws Exception {
        for (InvoiceLineModel invoiceLine : invoice.getInvoiceLines()) {
            if (!metaMapping.get(invoiceLine.getSalesOrder())[4].equals("Credit"))
                addReceiptMappingLine(invoice, invoiceLine, invoiceResult.getTransactionNumber());
        }
    }
    
    public void addReceiptMappingLine(InvoiceHeader invoice, InvoiceLineModel invoiceLine, String transactionNumber) throws Exception {      
        if (!salesReceiptDoneStatus.contains(invoiceLine.getSalesOrder() + "**" + invoiceLineDateMapping.get(invoiceLine).getTime())) 
            salesReceiptDoneStatus.add(invoiceLine.getSalesOrder() + "**" + invoiceLineDateMapping.get(invoiceLine).getTime());
        else return;
        
        StringBuilder standardKeysCommonBuilder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(invoice.getSaleDate());
        standardKeysCommonBuilder.append(calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR)).append("**")
                    .append(invoice.getConversionRateType() != null ? invoice.getConversionRateType() : "").append("**");
        
        String[] metaMappings = metaMapping.get(invoiceLine.getSalesOrder());
        
        String standardKeysCommon = standardKeysCommonBuilder.append(metaMappings[3]).append("**").toString();
        
        VendhqRegisters registerDetails = session.getRegisterDetailsByName(metaMappings[0], outletDetail.getRegion());
        if (registerDetails.getBankAccount() == null || registerDetails.getBankAccountId() == null 
            || registerDetails.getCashAccount() == null || registerDetails.getCashAccountId() == null) {
            throw new Exception("Bank Account Details for Register: " + registerDetails.getRegisterName() + " is not entered!!");
        }

        List<BackupVendhqPayments> payments = session.getPaymentsByInvoiceNumber(invoiceLine.getSalesOrder(), invoiceLineDateMapping.get(invoiceLine), outletDetail.getRegion());
        
        for (BackupVendhqPayments payment : payments) {
            String standardKeys = standardKeysCommon + payment.getPaymentType();
            FusionReceiptMethod receiptMethodMeta = session.getReceiptMethodByRegion(payment.getPaymentType(), outletDetail.getRegion());
            
            if (receiptMethodMeta == null) {
                emailNotify.addErrorLine("Receipt Method", "Receipt Method: " + payment.getPaymentType() + " is not configured!");
                return;
            }
            
            /*--------      STANDARD RECEIPT CREATION     ------------ */ 
            if (!payment.getPaymentType().toLowerCase().equals("cash rounding")) {
                
                if (!standardReceiptMapping.containsKey(standardKeys)) {
                    StandardReceiptRequest standardReceiptRequest = fusionStdReceiptMapping.mapToStandardReceipt(payment.getPaymentType(), invoice, outletDetail, 
                                                                                                                 registerDetails, receiptMethodMeta, transactionNumber);
                    standardReceiptMapping.put(standardKeys, standardReceiptRequest);
                    receiptInvoiceResultMapping.put(standardReceiptRequest, transactionNumber);
                }
                
                StandardReceiptRequest standardReceiptRequest = standardReceiptMapping.get(standardKeys);
                standardReceiptRequest.setReceiptAmount(standardReceiptRequest.getReceiptAmount().add(payment.getAmount()));
                
            } else if (!session.getFindStandardReceipt(payment.getPaymentType() + "-" + transactionNumber, outletDetail.getRegion())) {
                
                standardKeys = standardKeysCommon + (outletDetail.getRegion().equals("KW") ? "Cash KW" : "Cash");
                if (!standardReceiptMapping.containsKey(standardKeys)) {
                    StandardReceiptRequest standardReceiptRequest = fusionStdReceiptMapping.mapToStandardReceipt(outletDetail.getRegion().equals("KW") ? "Cash KW" : "Cash", 
                                                                                                          invoice, outletDetail, registerDetails, receiptMethodMeta, 
                                                                                                          transactionNumber);
                    standardReceiptMapping.put(standardKeys, standardReceiptRequest);
                    receiptInvoiceResultMapping.put(standardReceiptRequest, transactionNumber);
                }
                
                StandardReceiptRequest standardReceiptRequest = standardReceiptMapping.get(standardKeys);
                standardReceiptRequest.setReceiptAmount(standardReceiptRequest.getReceiptAmount().add(payment.getAmount()));
                standardKeys = standardKeysCommon + payment.getPaymentType();
            }
        }
        
        
        /*--------      MISCELLANEOUS RECEIPT CREATION     ------------ */    
        for (BackupVendhqPayments payment : payments) {
            String standardKeys = standardKeysCommon + payment.getPaymentType();
            FusionReceiptMethod receiptMethodMeta = session.getReceiptMethodByRegion(payment.getPaymentType(), outletDetail.getRegion());
                
            if (!receiptMethodMeta.getReceiptIsCash().equals("1") && !session.getFindMiscReceipt(payment.getPaymentType() + "-" + transactionNumber + "-MISC", outletDetail.getRegion())) {
                if (!miscReceiptMapping.containsKey(standardKeys)) 
                    miscReceiptMapping.put(standardKeys, fusionMiscReceiptMapping.mapToMiscReceipt(payment, invoice, receiptMethodMeta, outletDetail, registerDetails, metaMappings, transactionNumber));
                
                MiscReceiptRequest miscReceiptRequest = miscReceiptMapping.get(standardKeys);
                BigDecimal miscCharges = BigDecimal.valueOf(0);
                if (payment.getPaymentType().toLowerCase().equals("cash rounding")) miscCharges = payment.getAmount();
                else {
                    BigDecimal temp1 = payment.getAmount().multiply(receiptMethodMeta.getReceiptBankCharge());
                    BigDecimal temp2 = receiptMethodMeta.getReceiptMethodTax().add(BigDecimal.valueOf(1));
                    miscCharges = temp1.multiply(temp2);
                    
                    if (payment.getPaymentType().equals("Debit Card") && outletDetail.getRegion().equals("OM") && miscCharges.compareTo(BigDecimal.valueOf(10)) > 1)
                        miscCharges = BigDecimal.valueOf(10);
                }
                miscReceiptRequest.setReceiptAmount(miscReceiptRequest.getReceiptAmount().subtract(miscCharges));
            }
        }
        
    }
    
    /*--------      APPLY RECEIPT CREATION     ------------ */ 
    public void doApplyReceiptOnInvoice(StandardReceiptRequest standardReceiptRequest, String transactionSource) {
        applyReceiptList.add(fusionApplyReceiptMapping.mapToApplyReceiptModel(standardReceiptRequest, receiptInvoiceResultMapping, transactionSource));
    }
    
    /*--------      JOURNAL ENTRY CREATION     ------------ */
    public void addJournalEntry(InvoiceHeader invoice, InvoiceResponse invoiceResponse) {
        for (InvoiceLineModel invoiceLine : invoice.getInvoiceLines()) 
                addJournalEntry(invoice, invoiceLine, invoiceResponse);
    }
    
    public void addJournalEntry(InvoiceHeader invoice, InvoiceLineModel invoiceLine, InvoiceResponse invoiceResponse) {
        if (!metaMapping.get(invoiceLine.getSalesOrder())[3].equals("NORMAL")) {
            addFixedServiceCharge(invoice, invoiceLine, invoiceResponse);
            addBankServiceCharge(invoice, invoiceLine, invoiceResponse);
        }
    }
    
    public void addFixedServiceCharge(InvoiceHeader invoice, InvoiceLineModel invoiceLine,  InvoiceResponse invoiceResponse) {
        fusionJournalEntryMapping.addToJournalEntryLine(true, invoice, invoiceLine, invoiceResponse, 
                                                        metaMapping.get(invoiceLine.getSalesOrder())[3], 
                                                        metaMapping.get(invoiceLine.getSalesOrder())[5], true,
                                                        metaMapping.get(invoiceLine.getSalesOrder())[6]);
    }
    
    public void addBankServiceCharge(InvoiceHeader invoice, InvoiceLineModel invoiceLine,  InvoiceResponse invoiceResponse) {
        if (metaMapping.get(invoiceLine.getSalesOrder())[4].equals("Credit"))
            fusionJournalEntryMapping.addToJournalEntryLine(false, invoice, invoiceLine, invoiceResponse, 
                                                            metaMapping.get(invoiceLine.getSalesOrder())[3], 
                                                            metaMapping.get(invoiceLine.getSalesOrder())[5], false,
                                                            metaMapping.get(invoiceLine.getSalesOrder())[6]);
    }
    
    private Date getTimeZoneOffsetDate(Date utcDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utcDate);
        calendar.add(Calendar.HOUR, hoursOffset);
        calendar.add(Calendar.MINUTE, minutesOffset);
        return calendar.getTime();
    }


    public HashMap<String, InvoiceHeader> getInvoiceMapping() {
        return invoiceMapping;
    }

    public HashMap<String, StandardReceiptRequest> getStandardReceiptMapping() {
        return standardReceiptMapping;
    }

    public HashMap<String, MiscReceiptRequest> getMiscReceiptMapping() {
        return miscReceiptMapping;
    }


    public List<ApplyReceiptRequest> getApplyReceiptList() {
        return applyReceiptList;
    }

    public List<JournalHeader> getJournalEntryList() {
        return fusionJournalEntryMapping.getJournalEntryList();
    }

    public HashMap<String, List<TransactionLine>> getTransactionLineMapping() {
        return salesTransactionLinesMapping;
    }


    public HashMap<InvoiceLineModel, BigDecimal> getSaleVersionMapping() {
        return saleVersionMapping;
    }
}
