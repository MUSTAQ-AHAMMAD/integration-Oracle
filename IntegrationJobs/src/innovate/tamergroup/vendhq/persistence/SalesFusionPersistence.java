package innovate.tamergroup.vendhq.persistence;

import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ApplyReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceipt;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.Invoice;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceLine;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceResult;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceLineModel;
import innovate.tamergroup.fusion.soap.model.InvoiceResponse;
import innovate.tamergroup.fusion.soap.model.JournalHeader;
import innovate.tamergroup.fusion.soap.model.JournalLine;
import innovate.tamergroup.fusion.soap.model.MiscReceiptRequest;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.persistence.entities.FusionApplyReceipt;
import innovate.tamergroup.persistence.entities.FusionInvoiceHeader;
import innovate.tamergroup.persistence.entities.FusionInvoiceLine;
import innovate.tamergroup.persistence.entities.FusionJournalHeader;
import innovate.tamergroup.persistence.entities.FusionJournalLine;
import innovate.tamergroup.persistence.entities.FusionMiscReceipt;
import innovate.tamergroup.persistence.entities.FusionStandardReceipt;
import innovate.tamergroup.persistence.session.SessionEJB;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.Date;

import java.util.HashMap;

import javax.naming.NamingException;


public class SalesFusionPersistence {

    private SessionEJB session;
    private Integer requestId;
    private String region;
    private String integrationMode;


    public SalesFusionPersistence(SessionEJB session, Integer requestId, String region, String integrationMode) {
        this.session = session;
        this.requestId = requestId;
        this.region = region;
        this.integrationMode = integrationMode;
    }
    
    public void syncInvoice(InvoiceHeader invoice, InvoiceResponse invoiceResult,
                            HashMap<InvoiceLineModel, BigDecimal> saleVersionMapping, String message) {
        session.mergeEntity(transformInvoiceHeader(invoice, invoiceResult, message));
        for (InvoiceLineModel invoiceLine : invoice.getInvoiceLines()) {
            String status = invoiceResult != null ? (invoiceResult.getServiceStatus().equals("S") ? "Success" : "Failed") : "Failed";
            session.mergeEntity(transformInvoiceLine(invoiceLine, status.equals("Success") ? invoiceResult.getTransactionNumber() : "",
                saleVersionMapping.get(invoiceLine), status, message));
        }
    }
    
    public void syncStandardReceipt(StandardReceiptRequest standardReceipt, boolean status, String message) {
        session.mergeEntity(transformStandardReceipt(standardReceipt, status ? "Success" : "Failed", message));
    }
    
    public void syncMiscReceipt(MiscReceiptRequest miscReceipt, boolean status, String message) {
        session.mergeEntity(transformMiscReceipt(miscReceipt, status ? "Success" : "Failed", message));
    }
    
    public void syncReceiptApply(ApplyReceiptRequest applyReceipt, boolean status, String message) {
        session.mergeEntity(transformReceiptApply(applyReceipt, status ? "Success" : "Failed", message));
    }
    
    public void syncJournalEntry(JournalHeader journalHeader, Boolean journalResult, String message) {
        session.mergeEntity(transformJournalHeader(journalHeader, journalResult, message));
        for (JournalLine journalLine : journalHeader.getJournalLines()) {
            String status = journalResult != null ? "Success" : "Failed";
            session.mergeEntity(transformJournalLine(journalHeader, journalLine, status, message));
        }
    }

    private FusionInvoiceHeader transformInvoiceHeader(InvoiceHeader invoice, InvoiceResponse invoiceResult, String message) {
        FusionInvoiceHeader invoiceHeader = new FusionInvoiceHeader();
        if (invoiceResult != null) {
            invoiceHeader.setStatus(invoiceResult.getServiceStatus()
                                                 .equals("S") ? "Success" : "Failed");
            invoiceHeader.setCustomerTxnId(BigDecimal.valueOf(invoiceResult.getCustomerTransactionId()));
            invoiceHeader.setTxnNumber(BigDecimal.valueOf(Long.valueOf(invoiceResult.getTransactionNumber())));
        } else invoiceHeader.setStatus("Failed");
        
        invoiceHeader.setMessage(message != null ? (message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ") : " ");
        invoiceHeader.setRequestId(BigDecimal.valueOf(requestId));
        invoiceHeader.setRequestDate(new Date(System.currentTimeMillis()));
        invoiceHeader.setRegion(region);
        
        invoiceHeader.setBillToAccNumber(BigDecimal.valueOf(Long.valueOf(invoice.getBillToAccountNumber())));
        invoiceHeader.setBillToCustName(invoice.getBillToCustomerName());
        invoiceHeader.setBillToLocation(invoice.getBillToLocation());
        invoiceHeader.setBusinessUnit(invoice.getBusinessUnit());
        invoiceHeader.setCurrencyCode(invoice.getInvoiceCurrencyCode());
        invoiceHeader.setGlDate(invoice.getSaleDate());
        invoiceHeader.setPaymentTermsName(invoice.getPaymentTermsName());
        invoiceHeader.setTxnDate(invoice.getSaleDate());
        invoiceHeader.setTxnSource(invoice.getTransactionSource());
        invoiceHeader.setTxnType(invoice.getTransactionType());
        return invoiceHeader;
    }

    public FusionInvoiceLine transformInvoiceLine(InvoiceLineModel invoiceLine, String txnNumber, BigDecimal version, String status, String message) {
        FusionInvoiceLine invoiceDbLine = new FusionInvoiceLine();
        invoiceDbLine.setRequestId(BigDecimal.valueOf(requestId));
        invoiceDbLine.setStatus(status);
        invoiceDbLine.setMessage(message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ");
        invoiceDbLine.setRequestDate(new Date(System.currentTimeMillis()));
        invoiceDbLine.setRegion(region);
        
        invoiceDbLine.setInvoiceNumber(txnNumber);
        invoiceDbLine.setLineNumber(BigDecimal.valueOf(invoiceLine.getLineNumber()));
        invoiceDbLine.setItemNumber(invoiceLine.getItemNumber() != null ? invoiceLine.getItemNumber() : "");
        invoiceDbLine.setSalesOrder(invoiceLine.getSalesOrder());
        invoiceDbLine.setSalesOrderLine(BigDecimal.valueOf(Long.valueOf(invoiceLine.getSalesOrderLine())));
        invoiceDbLine.setDescription(invoiceLine.getDescription() != null ? invoiceLine.getDescription() : "");
        invoiceDbLine.setUom(invoiceLine.getUomCode());
        invoiceDbLine.setQuantity(invoiceLine.getQuantity());
        invoiceDbLine.setUnitSellingPrice(invoiceLine.getUnitSellingPrice().doubleValue());
        invoiceDbLine.setCurrencyCode(invoiceLine.getCurrencyCode());
        invoiceDbLine.setTaxCode(invoiceLine.getTaxClassificationCode());
        invoiceDbLine.setVersion(version);
        return invoiceDbLine;
    }


    private FusionStandardReceipt transformStandardReceipt(StandardReceiptRequest standardReceipt, String status, String message) {
        FusionStandardReceipt standardDBReceipt = new FusionStandardReceipt();
        standardDBReceipt.setRequestId(BigDecimal.valueOf(requestId));
        standardDBReceipt.setStatus(status);
        standardDBReceipt.setMessage(message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ");
        standardDBReceipt.setRequestDate(new Date(System.currentTimeMillis()));
        standardDBReceipt.setRegion(region);
        standardDBReceipt.setIntegrationMode(integrationMode);
        
        standardDBReceipt.setCurrencyCode(standardReceipt.getCurrencyCode());
        standardDBReceipt.setReceiptDate(standardReceipt.getSaleDate());
        standardDBReceipt.setGlDate(standardReceipt.getSaleDate());
        standardDBReceipt.setExchangeDate(null);
        standardDBReceipt.setExchangeRateType(null);
        standardDBReceipt.setReceiptMethodId(BigDecimal.valueOf(standardReceipt.getReceiptMethodId()));
        standardDBReceipt.setReceiptNumber(standardReceipt.getReceiptNumber());
        standardDBReceipt.setRemittanceBackAccId(String.valueOf(standardReceipt.getRemittanceBankAccountId()));
        standardDBReceipt.setDepositDate(standardReceipt.getSaleDate());
        standardDBReceipt.setCustomerId(BigDecimal.valueOf(standardReceipt.getCustomerId()));
        standardDBReceipt.setOrgId(BigDecimal.valueOf(standardReceipt.getOrgId()));
        standardDBReceipt.setAmount(standardReceipt.getReceiptAmount().doubleValue());
        
        return standardDBReceipt;
    }


    private FusionMiscReceipt transformMiscReceipt(MiscReceiptRequest miscReceipt, String status, String message) {
        FusionMiscReceipt miscDBReceipt = new FusionMiscReceipt();
        miscDBReceipt.setRequestId(BigDecimal.valueOf(requestId));
        miscDBReceipt.setStatus(status);
        miscDBReceipt.setMessage(message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ");
        miscDBReceipt.setRequestDate(new Date(System.currentTimeMillis()));
        miscDBReceipt.setRegion(region);
        miscDBReceipt.setIntegrationMode(integrationMode);
        
        miscDBReceipt.setCurrencyCode(miscReceipt.getCurrencyCode());
        miscDBReceipt.setReceiptDate(miscReceipt.getSaleDate());
        miscDBReceipt.setGlDate(miscReceipt.getSaleDate());
        miscDBReceipt.setExchangeDate(null);
        miscDBReceipt.setExchangeRateType(null);
        miscDBReceipt.setReceiptMethodName(miscReceipt.getReceiptMethodName());
        miscDBReceipt.setReceiptNumber(miscReceipt.getReceiptNumber());
        miscDBReceipt.setBankAccNumber(miscReceipt.getBankAccountName());
        miscDBReceipt.setRecActivityName(miscReceipt.getReceivableActivityName());
        miscDBReceipt.setAmount(miscReceipt.getReceiptAmount().doubleValue());
        
        return miscDBReceipt;
    }

    private FusionApplyReceipt transformReceiptApply(ApplyReceiptRequest applyReceipt, String status, String message) {
        FusionApplyReceipt applyDBReceipt = new FusionApplyReceipt();
        applyDBReceipt.setRequestId(BigDecimal.valueOf(requestId));
        applyDBReceipt.setStatus(status);
        applyDBReceipt.setMessage(message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ");
        applyDBReceipt.setRequestDate(new Date(System.currentTimeMillis()));
        applyDBReceipt.setRegion(region);
        applyDBReceipt.setIntegrationMode(integrationMode);

        applyDBReceipt.setAccountingDate(applyReceipt.getReceiptDate());
        applyDBReceipt.setApplicationDate(applyReceipt.getReceiptDate());
        applyDBReceipt.setTxnNumber(applyReceipt.getTransactionNumber());
        applyDBReceipt.setTxnSource(applyReceipt.getTransactionSource());
        applyDBReceipt.setReceiptNumber(applyReceipt.getReceiptNumber());
        applyDBReceipt.setAmountApplied(applyReceipt.getAmountApplied().doubleValue());
        applyDBReceipt.setCurrencyCode(applyReceipt.getReceiptCurrency());
                   
        return applyDBReceipt;
    }
    
    private FusionJournalHeader transformJournalHeader(JournalHeader journalEntry, Boolean response, String message) {
        FusionJournalHeader journalHeader = new FusionJournalHeader();
        journalHeader.setStatus(response != null && response ? "Success" : "Failed");
        journalHeader.setMessage(message != null ? (message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ") : " ");
        journalHeader.setRequestId(BigDecimal.valueOf(requestId));
        journalHeader.setRequestDate(new Date(System.currentTimeMillis()));
        journalHeader.setRegion(region);
        journalHeader.setIntegrationMode(integrationMode);
        
        journalHeader.setCustomerType(journalEntry.getCustomerType());
        journalHeader.setCashCredit(journalEntry.getCashCredit());
        journalHeader.setTxnNumber(BigDecimal.valueOf(journalEntry.getTxnNumber()));
        journalHeader.setJeHeaderId(journalEntry.getJeHeaderId() != null ? BigDecimal.valueOf(journalEntry.getJeHeaderId()) : null);
        journalHeader.setBatchName(journalEntry.getBatchName());
        journalHeader.setBatchDescription(journalEntry.getBatchDescription());
        journalHeader.setLedgerId(BigDecimal.valueOf(journalEntry.getLedgerId()));
        journalHeader.setAccountingPeriodName(journalEntry.getAccountingPeriodName());
        journalHeader.setAccountingDate(journalEntry.getAccountingDate());
        journalHeader.setUserSourceName(journalEntry.getUserSourceName());
        journalHeader.setUserCategoryName(journalEntry.getUserCategoryName());
        journalHeader.setErrorToSuspenseFlag(journalEntry.getErrorToSuspenseFlag());
        journalHeader.setSummaryFlag(journalEntry.getSummaryFlag());

        return journalHeader;
    }

    public FusionJournalLine transformJournalLine(JournalHeader journalHeader, JournalLine journalLine, String status, String message) {
        FusionJournalLine fusionJournalLine = new FusionJournalLine();
        fusionJournalLine.setRequestId(BigDecimal.valueOf(requestId));
        fusionJournalLine.setStatus(status);
        fusionJournalLine.setMessage(message != null ? (message.length() >= 500 ? message.substring(0, 500) : message) : " ");
        fusionJournalLine.setRequestDate(new Date(System.currentTimeMillis()));
        fusionJournalLine.setRegion(region);
        
        fusionJournalLine.setJeHeaderId(journalLine.getJeHeaderId() != null ? BigDecimal.valueOf(journalLine.getJeHeaderId()) : null);
        fusionJournalLine.setJeLineNum(BigDecimal.valueOf(journalLine.getJeLineNum()));
        fusionJournalLine.setTxnNumber(BigDecimal.valueOf(journalHeader.getTxnNumber()));
        fusionJournalLine.setCustomerType(journalHeader.getCustomerType());
        fusionJournalLine.setCashCredit(journalHeader.getCashCredit());
        fusionJournalLine.setLedgerId(BigDecimal.valueOf(journalLine.getLedgerId()));
        fusionJournalLine.setPeriodName(journalLine.getPeriodName());
        fusionJournalLine.setAccountingDate(journalLine.getAccountingDate());
        fusionJournalLine.setUserJeSourceName(journalLine.getUserJeSourceName());
        fusionJournalLine.setUserJeCategoryName(journalLine.getUserJeCategoryName());
        fusionJournalLine.setGroupId(journalLine.getGroupId() != null ? BigDecimal.valueOf(journalLine.getGroupId()) : null);
        fusionJournalLine.setChartOfAccountsId(BigDecimal.valueOf(journalLine.getChartOfAccountsId()));
        fusionJournalLine.setSegment1(journalLine.getSegment1());
        fusionJournalLine.setSegment2(journalLine.getSegment2());
        fusionJournalLine.setSegment3(journalLine.getSegment3());
        fusionJournalLine.setSegment4(journalLine.getSegment4());
        fusionJournalLine.setSegment5(journalLine.getSegment5());
        fusionJournalLine.setSegment6(journalLine.getSegment6());
        fusionJournalLine.setSegment7(journalLine.getSegment7());
        fusionJournalLine.setSegment8(journalLine.getSegment8());
        fusionJournalLine.setSegment9(journalLine.getSegment9());
        fusionJournalLine.setSegment10(journalLine.getSegment10());
        fusionJournalLine.setSalesOrder(journalLine.getSalesOrder());
        fusionJournalLine.setCurrencyCode(journalLine.getCurrencyCode());
        
        fusionJournalLine.setEnteredCrAmount(journalLine.getEnteredCrAmount());
        fusionJournalLine.setAccountedCr(journalLine.getAccountedCr());
        fusionJournalLine.setEnteredDrAmount(journalLine.getEnteredDrAmount());
        fusionJournalLine.setAccountedDr(journalLine.getAccountedDr());
        
        fusionJournalLine.setUserCurrencyConversionType(journalLine.getUserCurrencyConversionType());
        fusionJournalLine.setCurrencyConversionDate(journalLine.getCurrencyConversionDate());
        fusionJournalLine.setCurrencyConversionRate(journalLine.getCurrencyConversionRate());
        fusionJournalLine.setCurrencyConversionType(journalLine.getCurrencyConversionType());
        fusionJournalLine.setAverageJournalFlag(journalLine.getAverageJournalFlag());
        
        fusionJournalLine.setTaxCode(journalLine.getTaxCode());
        fusionJournalLine.setJeCategoryName(journalLine.getJeCategoryName());
        fusionJournalLine.setJeSourceName(journalLine.getJeSourceName());
        fusionJournalLine.setTransactionDate(journalLine.getTransactionDate());
        fusionJournalLine.setRecordType(journalLine.getRecordType());
        return fusionJournalLine;
    }
}
