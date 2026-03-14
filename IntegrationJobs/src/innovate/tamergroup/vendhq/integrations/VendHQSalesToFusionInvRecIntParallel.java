package innovate.tamergroup.vendhq.integrations;


import com.google.gson.Gson;

import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionResponse;
import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.ExceptionAlerter;
import innovate.tamergroup.email.LoggerHelper;
import innovate.tamergroup.email.SendEmailNotification;
import innovate.tamergroup.fusion.rest.services.FusionInvTxnService;
import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.ApplyReceiptResponse;
import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceLineModel;
import innovate.tamergroup.fusion.soap.model.InvoiceResponse;
import innovate.tamergroup.fusion.soap.model.JournalHeader;
import innovate.tamergroup.fusion.soap.model.MiscReceiptRequest;
import innovate.tamergroup.fusion.soap.model.MiscReceiptResponse;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.fusion.soap.model.StandardReceiptResponse;
import innovate.tamergroup.fusion.soap.services.FusionInvoiceClient;
import innovate.tamergroup.fusion.soap.services.FusionJournalClient;
import innovate.tamergroup.fusion.soap.services.FusionReceiptClient;
import innovate.tamergroup.persistence.entities.BackupVendhqSales;
import innovate.tamergroup.persistence.entities.FusionSalesMetadata;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.session.SessionEJB;
import static innovate.tamergroup.shared.utils.Constants.AUTOMATIC;
import static innovate.tamergroup.shared.utils.Constants.MANUAL;
import static innovate.tamergroup.shared.utils.Constants.NONE;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.persistence.InventoryFusionPersistence;
import innovate.tamergroup.vendhq.persistence.SalesFusionPersistence;
import innovate.tamergroup.vendhq.transformation.VendHQSalesToFusionInvRecTransBackup;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.apache.commons.lang.exception.ExceptionUtils;


public class VendHQSalesToFusionInvRecIntParallel {
    
    private FusionAppParams fusionParams;
    private String vendHqDomain;
    private Credential fusionCredential;
    private Credential vendHqCredential;
    private String fusionOrgCode;
    private HashSet<String> invItems = new HashSet<>();
    final static Logger logger = Logger.getLogger(VendHQSalesToFusionInvRecIntParallel.class.getSimpleName());


    public VendHQSalesToFusionInvRecIntParallel(FusionAppParams fusionParams, String vendHqDomain,
                                                Credential fusionCredential, Credential vendHqCredential, 
                                              String fusionOrgCode) {
        this.fusionParams = fusionParams;
        this.vendHqDomain = vendHqDomain;
        this.fusionCredential = fusionCredential;
        this.vendHqCredential = vendHqCredential;
        this.fusionOrgCode = fusionOrgCode;
    }

    public void doIntegration(String region, Integer dateRange, BigDecimal timeZoneOffset, String fusionTaxCode, Boolean isManual, Date startDate) throws Exception {
        SessionEJB session = EJBClientUtil.getSessionEJB();
        Integer requestId = session.getSessionRequestID();
        SendEmailNotification emailNotify = new SendEmailNotification(requestId, region);
        
        List<VendhqOutletsDB> outletList = session.getVendhqOutletsByRegion(region);
        
        Integer hoursOffset = timeZoneOffset.intValue();
        Float minutesDecimal = timeZoneOffset.abs().floatValue();
        Integer minutesOffset = (int) ((minutesDecimal * 100 % 100) * 60 / 100);

        Calendar currentCalendar = Calendar.getInstance();
        Date lastSaleDate = session.getLastSalesTxnDate(region, isManual, startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastSaleDate);
        //calendar.add(Calendar.DAY_OF_MONTH, 1);
                
        Long diffLong = currentCalendar.getTimeInMillis() - lastSaleDate.getTime();
        Integer diffDays = (int) (diffLong/(1000*60*60*24));
                
        Integer daysToAdd = !isManual ? diffDays + 1 : (dateRange<=0 ? 1 : dateRange);
        Integer finalDaysAddition = daysToAdd<=7 ? daysToAdd-1 : 7;     
        
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
        
        AtomicBoolean intError = new AtomicBoolean(false);
        while (finalDaysAddition-- >= 0 && !intError.get()) {
            Date processDate = new Date(calendar.getTimeInMillis());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            
            List<Future<LoggerHelper>> futures = new ArrayList<Future<LoggerHelper>>();
            
            for (VendhqOutletsDB outlet : outletList) {
                Callable<LoggerHelper> callable = new Callable<LoggerHelper>() {
                    @Override
                    public LoggerHelper call() {
                        LoggerHelper loggerHelper = new LoggerHelper();
                        VendHQSalesToFusionInvRecTransBackup invRecTransformation = null;
                        try {
                            String integrationMode = null;
                            switch(session.getOutletIntegStatus(outlet.getOutletName(), outlet.getRegion())) {
                                case NONE: integrationMode = NONE; 
                                            return loggerHelper;
                                case MANUAL: if (isManual){
                                                   integrationMode = MANUAL; 
                                                   break;
                                                } else return loggerHelper;
                                case AUTOMATIC: if (!isManual) {
                                                    integrationMode = AUTOMATIC; 
                                                    break;
                                                } else return loggerHelper;
                            }
                            
                            SalesFusionPersistence salesPersistence = new SalesFusionPersistence(session, requestId, outlet.getRegion(), integrationMode);
                            List<BackupVendhqSales> salesHeaders = session.getSalesOutletBtwDate(outlet.getOutletName(), region, processDate, timeZoneOffset);
                            invRecTransformation =
                                new VendHQSalesToFusionInvRecTransBackup(session, emailNotify, outlet, fusionParams, fusionCredential, hoursOffset, minutesOffset);
                            loggerHelper.getInfoLines().add(new String[]{"SALES INTEGRATION LOG", "OUTLET: " + outlet.getOutletName() + ", DATE: " + new SimpleDateFormat("dd-MM-YYYY").format(processDate)});
                            loggerHelper.getErrorLines().add(new String[]{"SALES INTEGRATION LOG", "OUTLET: " + outlet.getOutletName() + ", DATE: " + new SimpleDateFormat("dd-MM-YYYY").format(processDate)});
                            
                            HashMap<String, FusionSalesMetadata> salesMetaDataMap = session.getFindSalesMetaDataAll(outlet.getOutletName(), "Vend HQ", outlet.getRegion());
                            if (salesMetaDataMap.isEmpty()) {
                                loggerHelper.getErrorLines().add(new String[]{"Invoice Metadata", "No Sales MetaData found in the Staging table"});
                                loggerHelper.getErrorLines().add(new String[]{"", ""});
                                intError.set(true);
                                return loggerHelper;
                            }
                            
                            for (BackupVendhqSales sale : salesHeaders) {
                                try {
                                    invRecTransformation.addInvoiceMapping(sale, salesMetaDataMap);
                                } catch (Exception e) {
                                    logger.severe("Failed to map Invoice: " + e.getMessage());
                                    loggerHelper.getErrorLines().add(new String[]{"Sales Transaction", e.getMessage()});
                                    loggerHelper.getErrorLines().add(new String[]{"", ""});
                                    new ExceptionAlerter(region).sendException(e);
                                    intError.set(true);
                                    break;
                                }
                            }
                            
                            InventoryFusionPersistence invPersistence = new InventoryFusionPersistence(session, requestId, outlet.getRegion(), integrationMode);
                            FusionInvTxnService invTxnService = new FusionInvTxnService(fusionParams, fusionCredential);
                            Iterator<List<TransactionLine>> invTxnIterator = invRecTransformation.getTransactionLineMapping().values().iterator();
                            while (invTxnIterator.hasNext()) {
                                List<TransactionLine> invTxnLines = invTxnIterator.next();
                                InventoryTransactionResponse invTxnResult = invTxnService.insertInvTransactions(invTxnLines);
                                invPersistence.syncInvTxn(invTxnResult);
                                StringBuilder invLines = new StringBuilder();
                                List<String> tempInvItems = new ArrayList<>();
                                if (invTxnResult.getErrorCode() != null) {
                                    invLines.append("Error: ").append(invTxnResult.getErrorCode()).append(". Error Explanation: ").append(invTxnResult.getErrorExplanation()).append("\n\t\t\t\t"); 
                                    intError.set(true);
                                }
                                for (TransactionLine transactionLine : invTxnLines) {
                                    invLines.append("Item# ").append(transactionLine.getItem()).append(" : ").append(transactionLine.getTransactionQuantity()).append(" ").append(transactionLine.getTransactionUnitOfMeasure()).append(" | ");
                                    tempInvItems.add(transactionLine.getItem());
                                }
                                if (invTxnResult.getErrorCode() != null) {
                                    loggerHelper.getErrorLines().add(new String[]{"Inventory Transaction", invLines.toString()});
                                    loggerHelper.getErrorLines().add(new String[]{"", ""});
                                } else {
                                    loggerHelper.getInfoLines().add(new String[]{"Inventory Transaction", invLines.toString()});
                                    for (String item : tempInvItems)
                                        if (!invItems.contains(item)) invItems.add(item);
                                    loggerHelper.getInfoLines().add(new String[]{"", ""});
                                }
                            }
                            if (intError.get()) return loggerHelper;
                            
    
                            Iterator<InvoiceHeader> invoiceIterator = invRecTransformation.getInvoiceMapping().values().iterator();
                            while (invoiceIterator.hasNext()) {
                                InvoiceHeader invoice = invoiceIterator.next();
                                if (invoice.getInvoiceLines().isEmpty()) continue;
                                String errorMessageInvoice = null;
                                InvoiceResponse invoiceResult = null;
                                try {
                                    invoiceResult = new FusionInvoiceClient(fusionParams, fusionCredential).saveInvoice(invoice);
                                    if (invoiceResult.getServiceStatus().equals("S")) {
                                        invRecTransformation.addReceiptMapping(invoice, invoiceResult);
                                        invRecTransformation.addJournalEntry(invoice, invoiceResult);
                                        StringBuilder salesLines = new StringBuilder();
                                        HashSet<String> invoices = new HashSet<>();
                                        for (InvoiceLineModel invoiceLine : invoice.getInvoiceLines()) {
                                            if (!invoices.contains(invoiceLine.getSalesOrder())) {
                                                salesLines.append(", ").append(invoiceLine.getSalesOrder());
                                                invoices.add(invoiceLine.getSalesOrder());
                                            }
                                        }
                                        loggerHelper.getInfoLines().add(new String[]{"Invoice", "\t\tInvoice#: " + invoiceResult.getTransactionNumber() + " created against orders: " + salesLines.toString().substring(2)});
                                        loggerHelper.getInfoLines().add(new String[]{"", ""});
                                    }
                                    errorMessageInvoice = " ";
                                } catch (Exception e) {
                                    System.out.println("Error in Invoice#: " + invoice.getSaleDate().toString() + ", TrxID:" 
                                                       + (!invoice.getInvoiceLines().isEmpty() ? invoice.getInvoiceLines().get(0).getSalesOrder() : ""));
                                    errorMessageInvoice = e.getMessage();
                                    
                                    loggerHelper.getErrorLines().add(new String[]{"Invoice", "Error in Invoice#: " + invoice.getSaleDate().toString() + e.getMessage()});
                                    loggerHelper.getErrorLines().add(new String[]{"", ""});
                                    new ExceptionAlerter(region).sendException(e);
                                    intError.set(true);
                                } finally {
                                    salesPersistence.syncInvoice(invoice, invoiceResult, invRecTransformation.getSaleVersionMapping(),
                                                                 errorMessageInvoice);
                                }
                            }
    
                            Double negativeReceiptAmount = null;
                            FusionReceiptClient fusionReceiptClient = new FusionReceiptClient(fusionParams, fusionCredential);
                            Iterator<StandardReceiptRequest> standardReceiptIterator = invRecTransformation.getStandardReceiptMapping().values().iterator();
                            while (standardReceiptIterator.hasNext()) {
                                StandardReceiptRequest standardReceipt = standardReceiptIterator.next();
                                if (standardReceipt.getReceiptAmount().doubleValue() == 0 || 
                                    standardReceipt.getReceiptNumber().toLowerCase().contains("credit")) continue;
                                else if (standardReceipt.getReceiptAmount().doubleValue() < 0) {
                                    negativeReceiptAmount = standardReceipt.getReceiptAmount().doubleValue();
                                    continue;
                                } else if (standardReceipt.getReceiptNumber() == null) continue;
                                else if (session.getFindStandardReceipt(standardReceipt.getReceiptNumber(), region)) {
                                    invRecTransformation.doApplyReceiptOnInvoice(standardReceipt, salesMetaDataMap.get("NORMAL").getTxnSource());
                                    continue;
                                }
                                String errorMessageReceipt = null;
                                StandardReceiptResponse standardReceiptResult = null;
                                try {
                                    standardReceiptResult = fusionReceiptClient.saveStandardReceipt(standardReceipt);
                                    if (standardReceiptResult.getSuccessResponse()) {
                                        invRecTransformation.doApplyReceiptOnInvoice(standardReceipt, salesMetaDataMap.get("NORMAL").getTxnSource());
                                        loggerHelper.getInfoLines().add(new String[]{"Standard Receipt", "Receipt#: " + standardReceipt.getReceiptNumber() + " is created."});
                                    }
                                    errorMessageReceipt = " ";
                                } catch (Exception e) {
                                    System.out.println("Error in Standard Receipt#: " + standardReceipt.getReceiptNumber());
                                    errorMessageReceipt = e.getMessage();
                                    
                                    loggerHelper.getErrorLines().add(new String[]{"Standard Receipt", "Receipt#: " + standardReceipt.getReceiptNumber() + e.getMessage()});
                                    loggerHelper.getErrorLines().add(new String[]{"", ""});
                                    new ExceptionAlerter(region).sendException(e);
                                    intError.set(true);
                                } finally {
                                    salesPersistence.syncStandardReceipt(standardReceipt, standardReceiptResult != null,
                                                                         errorMessageReceipt);
                                }
                            }
                            loggerHelper.getInfoLines().add(new String[]{"", ""});
    
                            Iterator<MiscReceiptRequest> miscReceiptIterator = invRecTransformation.getMiscReceiptMapping().values().iterator();
                            while (miscReceiptIterator.hasNext()) {
                                MiscReceiptRequest miscReceipt = miscReceiptIterator.next();
                                if (miscReceipt.getReceiptAmount().doubleValue() == 0 || 
                                    (miscReceipt.getReceiptAmount().doubleValue() > 0 &&
                                     !miscReceipt.getReceivableActivityName().equals("Cash Rounding"))) continue;
                                String errorMessageMisc = null;
                                MiscReceiptResponse miscReceiptResult = null;
                                try {
                                    miscReceiptResult = fusionReceiptClient.saveMiscReceipt(miscReceipt);
                                    /*if (miscReceiptResult.getValue() != null)
                                        invRecTransformation.doApplyReceiptOnInvoice(miscReceipt, miscReceiptResult);*/
                                    errorMessageMisc = " ";
                                    loggerHelper.getInfoLines().add(new String[]{"Misc Receipt", "\tReceipt#: " + miscReceipt.getReceiptNumber() + " is created."});
                                } catch (Exception e) {
                                    System.out.println("Error in Misc Receipt#: " + miscReceipt.getReceiptNumber());
                                    errorMessageMisc = e.getMessage();
                                    loggerHelper.getErrorLines().add(new String[]{"Misc Receipt", "\tReceipt#: " + miscReceipt.getReceiptNumber() + e.getMessage()});
                                    loggerHelper.getErrorLines().add(new String[]{"", ""});
                                    new ExceptionAlerter(region).sendException(e);
                                    intError.set(true);
                                } finally {
                                    salesPersistence.syncMiscReceipt(miscReceipt, miscReceiptResult != null,
                                                                         errorMessageMisc);
                                } 
                            }
                            loggerHelper.getInfoLines().add(new String[]{"", ""});
    
                            System.out.println();
                            System.out.println("Apply Receipt");
                            for (ApplyReceiptRequest applyReceipt : invRecTransformation.getApplyReceiptList()) {
                                if (session.getFindApplyReceipt(applyReceipt.getReceiptNumber(), region)) continue;
                                String errorMessageApply = null;
                                ApplyReceiptResponse result = null;
                                int repeat = 0;
                                for (;;) {
                                    try {
                                        result = fusionReceiptClient.saveApplyStandardReceipt(applyReceipt);
                                        errorMessageApply = " ";
                                        loggerHelper.getInfoLines().add(new String[]{"Apply Receipt", "\tReceipt#: " + applyReceipt.getReceiptNumber() + " is applied on Invoice#: " + applyReceipt.getTransactionNumber()});
                                    } catch (Exception e) {
                                        errorMessageApply = e.getMessage();
                                        if (repeat == 50) {
                                            loggerHelper.getErrorLines().add(new String[]{"Apply Receipt", "\tReceipt#: " + applyReceipt.getReceiptNumber() + e.getMessage()});
                                            loggerHelper.getErrorLines().add(new String[]{"", ""});
                                            new ExceptionAlerter(region).sendException(e);
                                            intError.set(true);
                                        }
                                    } finally {
                                        if (errorMessageApply.equals(" ") || repeat == 50) {
                                            salesPersistence.syncReceiptApply(applyReceipt, result != null, errorMessageApply);
                                            break;
                                        } else if (negativeReceiptAmount != null) { 
                                            applyReceipt.setAmountApplied(applyReceipt.getAmountApplied().add(BigDecimal.valueOf(negativeReceiptAmount)));
                                            negativeReceiptAmount = null;
                                        } else {
                                            applyReceipt.setAmountApplied(applyReceipt.getAmountApplied().subtract(BigDecimal.valueOf(0.01)));
                                            repeat++;
                                        }
                                    }
                                }
                            }
                            loggerHelper.getInfoLines().add(new String[]{"", ""});
                            
                            
                            System.out.println();
                            System.out.println("Journal Entry");
                            FusionJournalClient fusionJournalClient = new FusionJournalClient(fusionParams, fusionCredential);
                            for (JournalHeader journalHeader : invRecTransformation.getJournalEntryList()) {
                                if (session.getFindJournalHeader(journalHeader.getTxnNumber(), journalHeader.getCustomerType(), journalHeader.getCashCredit(), region)) continue;
                                String errorMessageJournal = null;
                                Boolean result = null;
                                try {
                                    result = fusionJournalClient.saveImportJournal(journalHeader);
                                    errorMessageJournal = " ";
                                    loggerHelper.getInfoLines().add(new String[]{"Journal Entry", "\tJournal Entry for Invoice#: " + journalHeader.getTxnNumber() + " is created for " + journalHeader.getCustomerType() + " of type " + journalHeader.getCashCredit()});
                                } catch (Exception e) {
                                    System.out.println("Error in Journal Entry#: " + journalHeader.getBatchName());
                                    errorMessageJournal = e.getMessage();
                                    loggerHelper.getErrorLines().add(new String[]{"Journal Entry", "\tJournal Entry for Invoice#: " + journalHeader.getTxnNumber() + " is NOT created for " + journalHeader.getCustomerType() + " of type " + journalHeader.getCashCredit() + " with this error: " + e.getMessage()});
                                    loggerHelper.getInfoLines().add(new String[]{"", ""});
                                    new ExceptionAlerter(region).sendException(e);
                                    intError.set(true);
                                } finally {
                                    salesPersistence.syncJournalEntry(journalHeader, result, errorMessageJournal);
                                }
                            }
                            loggerHelper.getInfoLines().add(new String[]{"", ""});
                            loggerHelper.getInfoLines().add(new String[]{"", ""});
                        
                        } catch (Exception e) {
                            loggerHelper.setExceptionRaised(e);
                            try {
                                Gson errorJson = new Gson();
                                Iterator<InvoiceHeader> invoiceIterator = invRecTransformation.getInvoiceMapping().values().iterator();
                                Iterator<StandardReceiptRequest> standardReceiptIterator = invRecTransformation.getStandardReceiptMapping().values().iterator();
                                
                                StackTraceElement[] traceElements = new StackTraceElement[3];
                                traceElements[0] = new StackTraceElement("Outlet", "name", outlet.getOutletName(), 100);
                                if (invoiceIterator.hasNext()) 
                                    traceElements[1] = new StackTraceElement("Invoice", "value", errorJson.toJson(invoiceIterator.next()), 100);
                                if (standardReceiptIterator.hasNext())
                                    traceElements[2] = new StackTraceElement("Receipt", "value", errorJson.toJson(standardReceiptIterator.next()), 100);
                                
                                int stackLength = e.getStackTrace().length;
                                int totalLength = stackLength + 1 + (traceElements[1] != null ? 1 : 0) + (traceElements[2] != null ? 1 : 0);
                                StackTraceElement[] stacks = new StackTraceElement[totalLength];
                                stacks = Arrays.copyOf(e.getStackTrace(), stackLength);
                                
                                stacks[stackLength] = traceElements[0];
                                if (traceElements[1] != null) stacks[stackLength+1] = traceElements[1];
                                if (traceElements[2] != null) stacks[stackLength+2] = traceElements[2];
                                
                                e.setStackTrace(stacks);
                            } catch (Exception ignored) {}
                        } finally {
                            return loggerHelper;
                        }
                    }
                };
                futures.add(executorService.submit(callable));
            }
            
            for (Future<LoggerHelper> future : futures) {
                LoggerHelper loggerHelper = future.get();
                if (loggerHelper.getExceptionRaised() != null)
                    throw loggerHelper.getExceptionRaised();
                for (String[] infoLine : loggerHelper.getInfoLines())
                    emailNotify.addInfoLine(infoLine[0], infoLine[1]);
                for (String[] errorLine : loggerHelper.getErrorLines())
                    emailNotify.addErrorLine(errorLine[0], errorLine[1]);
            }
        
        }
        
        executorService.shutdown();
        
        if (isManual && intError.get()) emailNotify.setSubject("Error in Manual Sales Integration");
        else if (!isManual && intError.get()) emailNotify.setSubject("Error in Automated Sales Integration");
        else if (isManual && !intError.get()) emailNotify.setSubject("Successful Manual Sales Integration");
        else emailNotify.setSubject("Successful Automated Sales Integration");
        emailNotify.execute();
    }

    public static void main(String[] args) throws Exception {
        new VendHQSalesToFusionInvRecIntParallel(new FusionAppParams("ehxk-test", "em2"), "ibraheemalqurashi", 
                                                 new Credential("Ahmed.ali", "Tamer@123"), new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"), "VWH")
            .doIntegration("SA", 0, BigDecimal.valueOf(3), "OUTPUT-GOODS-DOM-5%", true, new Date());

    }
    

}
