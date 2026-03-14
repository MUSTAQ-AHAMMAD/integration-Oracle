package innovate.tamergroup.vendhq.integrations;


import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionResponse;
import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.ExceptionAlerter;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.apache.commons.lang.exception.ExceptionUtils;


public class VendHQSalesToFusionInvRecIntBackup {
    
    private FusionAppParams fusionParams;
    private String vendHqDomain;
    private Credential fusionCredential;
    private Credential vendHqCredential;
    private String fusionOrgCode;
    private HashSet<String> invItems = new HashSet<>();
    final static Logger logger = Logger.getLogger(VendHQSalesToFusionInvRecIntBackup.class.getSimpleName());


    public VendHQSalesToFusionInvRecIntBackup(FusionAppParams fusionParams, String vendHqDomain,
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

        Date lastSaleDate = session.getLastSalesTxnDate(region, isManual, startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastSaleDate);

        // Normalize to calendar midnight so the day-count is based on calendar dates,
        // not raw milliseconds (avoids undercounting when lastSaleDate has a late time component).
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Calendar todayMidnight = Calendar.getInstance();
        todayMidnight.set(Calendar.HOUR_OF_DAY, 0);
        todayMidnight.set(Calendar.MINUTE, 0);
        todayMidnight.set(Calendar.SECOND, 0);
        todayMidnight.set(Calendar.MILLISECOND, 0);

        Long diffLong = todayMidnight.getTimeInMillis() - calendar.getTimeInMillis();
        Integer diffDays = (int) (diffLong/(1000*60*60*24));
                
        Integer daysToAdd = !isManual ? diffDays + 1 : (dateRange<=0 ? 1 : dateRange);
        Integer finalDaysAddition = daysToAdd<=7 ? daysToAdd-1 : 7;        
        
        Boolean intError = false;
        while (finalDaysAddition-- >= 0 && !intError) {
            Date processDate = new Date(calendar.getTimeInMillis());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            
            for (VendhqOutletsDB outlet : outletList) {          
                String integrationMode = null;
                switch(session.getOutletIntegStatus(outlet.getOutletName(), outlet.getRegion())) {
                    case NONE: integrationMode = NONE; 
                                continue;
                    case MANUAL: if (isManual){
                                       integrationMode = MANUAL; 
                                       break;
                                    } else continue;
                    case AUTOMATIC: if (!isManual) {
                                        integrationMode = AUTOMATIC; 
                                        break;
                                    } else continue;
                }
                
                SalesFusionPersistence salesPersistence = new SalesFusionPersistence(session, requestId, outlet.getRegion(), integrationMode);
                List<BackupVendhqSales> salesHeaders = session.getSalesOutletBtwDate(outlet.getOutletName(), region, processDate, timeZoneOffset);
                VendHQSalesToFusionInvRecTransBackup invRecTransformation =
                    new VendHQSalesToFusionInvRecTransBackup(session, emailNotify, outlet, fusionParams, fusionCredential, hoursOffset, minutesOffset);
                emailNotify.addInfoLine("SALES INTEGRATION LOG", "OUTLET: " + outlet.getOutletName() + ", DATE: " + new SimpleDateFormat("dd-MM-YYYY").format(processDate));
                emailNotify.addErrorLine("SALES INTEGRATION LOG", "OUTLET: " + outlet.getOutletName() + ", DATE: " + new SimpleDateFormat("dd-MM-YYYY").format(processDate));
                
                HashMap<String, FusionSalesMetadata> salesMetaDataMap = session.getFindSalesMetaDataAll(outlet.getOutletName(), "Vend HQ", outlet.getRegion());
                if (salesMetaDataMap.isEmpty()) {
                    emailNotify.addErrorLine("Invoice Metadata", "No Sales MetaData found in the Staging table");
                    emailNotify.addErrorLine("", "");
                    intError = true;
                    return;
                }
                
                for (BackupVendhqSales sale : salesHeaders) {
                    try {
                        invRecTransformation.addInvoiceMapping(sale, salesMetaDataMap);
                    } catch (Exception e) {
                        logger.severe("Failed to map Invoice: " + e.getMessage());
                        emailNotify.addErrorLine("Sales Transaction", e.getMessage());
                        emailNotify.addErrorLine("", "");
                        new ExceptionAlerter(region).sendException(e);
                        intError = true;
                        break;
                    }
                }
                
                InventoryFusionPersistence invPersistence = new InventoryFusionPersistence(session, requestId, outlet.getRegion(), integrationMode);
                FusionInvTxnService invTxnService = new FusionInvTxnService(fusionParams, fusionCredential);
                Iterator<List<TransactionLine>> invTxnIterator = invRecTransformation.getTransactionLineMapping().values().iterator();
                while (invTxnIterator.hasNext()) {
                    InventoryTransactionResponse invTxnResult = new InventoryTransactionResponse();
                    List<TransactionLine> invTxnLines = invTxnIterator.next();
                    try {
                        invTxnResult = invTxnService.insertInvTransactions(invTxnLines);
                    } catch(Exception e) {
                        invTxnResult.setTransactionLines(invTxnLines);
                        invTxnResult.setErrorCode(ExceptionUtils.getRootCauseMessage(e));
                        invTxnResult.setErrorExplanation(ExceptionUtils.getMessage(e));
                        new ExceptionAlerter(region).sendException(e);
                    } finally {
                        invPersistence.syncInvTxn(invTxnResult);
                        StringBuilder invLines = new StringBuilder();
                        List<String> tempInvItems = new ArrayList<>();
                        if (invTxnResult.getErrorCode() != null) {
                            invLines.append("Error: ").append(invTxnResult.getErrorCode()).append(". Error Explanation: ").append(invTxnResult.getErrorExplanation()).append("\n\t\t\t\t"); 
                            intError = true;
                        }
                        for (TransactionLine transactionLine : invTxnLines) {
                            invLines.append("Item# ").append(transactionLine.getItem()).append(" : ").append(transactionLine.getTransactionQuantity()).append(" ").append(transactionLine.getTransactionUnitOfMeasure()).append(" | ");
                            tempInvItems.add(transactionLine.getItem());
                        }
                        if (invTxnResult.getErrorCode() != null) {
                            emailNotify.addErrorLine("Inventory Transaction", invLines.toString());
                            emailNotify.addErrorLine("", "");
                        } else {
                            emailNotify.addInfoLine("Inventory Transaction", invLines.toString());
                            for (String item : tempInvItems)
                                if (!invItems.contains(item)) invItems.add(item);
                        }
                    }
                }
                if (intError) continue;
                emailNotify.addInfoLine("", "");
                

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
                            emailNotify.addInfoLine("Invoice", "\t\tInvoice#: " + invoiceResult.getTransactionNumber() + " created against orders: " + salesLines.toString().substring(2));
                        }
                        errorMessageInvoice = " ";
                    } catch (Exception e) {
                        System.out.println("Error in Invoice#: " + invoice.getSaleDate().toString() + ", TrxID:" 
                                           + (!invoice.getInvoiceLines().isEmpty() ? invoice.getInvoiceLines().get(0).getSalesOrder() : ""));
                        errorMessageInvoice = e.getMessage();
                        
                        emailNotify.addErrorLine("Invoice", "Error in Invoice#: " + invoice.getSaleDate().toString() + e.getMessage());
                        emailNotify.addErrorLine("", "");
                        new ExceptionAlerter(region).sendException(e);
                        intError = true;
                    } finally {
                        salesPersistence.syncInvoice(invoice, invoiceResult, invRecTransformation.getSaleVersionMapping(),
                                                     errorMessageInvoice);
                    }
                }
                emailNotify.addInfoLine("", "");

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
                    } else if (session.getFindStandardReceipt(standardReceipt.getReceiptNumber(), region)) {
                        invRecTransformation.doApplyReceiptOnInvoice(standardReceipt, salesMetaDataMap.get("NORMAL").getTxnSource());
                        continue;
                    }
                    String errorMessageReceipt = null;
                    StandardReceiptResponse standardReceiptResult = null;
                    try {
                        standardReceiptResult = fusionReceiptClient.saveStandardReceipt(standardReceipt);
                        if (standardReceiptResult.getSuccessResponse()) {
                            invRecTransformation.doApplyReceiptOnInvoice(standardReceipt, salesMetaDataMap.get("NORMAL").getTxnSource());
                            emailNotify.addInfoLine("Standard Receipt", "Receipt#: " + standardReceipt.getReceiptNumber() + " is created.");
                        }
                        errorMessageReceipt = " ";
                    } catch (Exception e) {
                        System.out.println("Error in Standard Receipt#: " + standardReceipt.getReceiptNumber());
                        errorMessageReceipt = e.getMessage();
                        
                        emailNotify.addErrorLine("Standard Receipt", "Receipt#: " + standardReceipt.getReceiptNumber() + e.getMessage());
                        emailNotify.addErrorLine("", "");
                        new ExceptionAlerter(region).sendException(e);
                        intError = true;
                    } finally {
                        salesPersistence.syncStandardReceipt(standardReceipt, standardReceiptResult != null, errorMessageReceipt);
                    }
                }
                emailNotify.addInfoLine("", "");

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
                        errorMessageMisc = " ";
                        emailNotify.addInfoLine("Misc Receipt", "\tReceipt#: " + miscReceipt.getReceiptNumber() + " is created.");
                    } catch (Exception e) {
                        System.out.println("Error in Misc Receipt#: " + miscReceipt.getReceiptNumber());
                        errorMessageMisc = e.getMessage();
                        emailNotify.addErrorLine("Misc Receipt", "\tReceipt#: " + miscReceipt.getReceiptNumber() + e.getMessage());
                        emailNotify.addErrorLine("", "");
                        new ExceptionAlerter(region).sendException(e);
                        intError = true;
                    } finally {
                        salesPersistence.syncMiscReceipt(miscReceipt, miscReceiptResult != null, errorMessageMisc);
                    } 
                }
                emailNotify.addInfoLine("", "");

                
                
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
                            emailNotify.addInfoLine("Apply Receipt", "\tReceipt#: " + applyReceipt.getReceiptNumber() + " is applied on Invoice#: " + applyReceipt.getTransactionNumber());
                        } catch (Exception e) {
                            errorMessageApply = e.getMessage();
                            if (repeat == 50) {
                                emailNotify.addErrorLine("Apply Receipt", "\tReceipt#: " + applyReceipt.getReceiptNumber() + e.getMessage());
                                emailNotify.addErrorLine("", "");
                                new ExceptionAlerter(region).sendException(e);
                                intError = true;
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
                emailNotify.addInfoLine("", "");
                
                
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
                        emailNotify.addInfoLine("Journal Entry", "\tJournal Entry for Invoice#: " + journalHeader.getTxnNumber() + " is created for " + journalHeader.getCustomerType() + " of type " + journalHeader.getCashCredit());
                    } catch (Exception e) {
                        System.out.println("Error in Journal Entry#: " + journalHeader.getBatchName());
                        errorMessageJournal = e.getMessage();
                        emailNotify.addErrorLine("Journal Entry", "\tJournal Entry for Invoice#: " + journalHeader.getTxnNumber() + " is NOT created for " + journalHeader.getCustomerType() + " of type " + journalHeader.getCashCredit() + " with this error: " + e.getMessage());
                        emailNotify.addErrorLine("", "");
                        new ExceptionAlerter(region).sendException(e);
                        intError = true;
                    } finally {
                        salesPersistence.syncJournalEntry(journalHeader, result, errorMessageJournal);
                    }
                }
                
                
                emailNotify.addInfoLine("", "");
                emailNotify.addInfoLine("", "");
                emailNotify.addInfoLine("", "");
            }
            
        }
        
        if (isManual && intError) emailNotify.setSubject("Error in Manual Sales Integration");
        else if (!isManual && intError) emailNotify.setSubject("Error in Automated Sales Integration");
        else if (isManual && !intError) emailNotify.setSubject("Successful Manual Sales Integration");
        else emailNotify.setSubject("Successful Automated Sales Integration");
        emailNotify.execute();
    }

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        new VendHQSalesToFusionInvRecIntBackup(new FusionAppParams("ehxk-test", "em2"), "iaqtest", 
                                                 new Credential("Ahmed.ali", "Tamer@123"), new Credential("4GYI1hpMtznv9KNsCUWD1_xsAfu5tlmxjdPhbL3a"), "VWH")
            .doIntegration("SA", 7, BigDecimal.valueOf(3), "OUTPUT-GOODS-DOM-5%", true, calendar.getTime());

    }

}
