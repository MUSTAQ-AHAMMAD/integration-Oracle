package innovate.tamergroup.vendhq.mapping;

import innovate.tamergroup.fusion.soap.model.ApplyReceiptRequest;
import innovate.tamergroup.fusion.soap.model.InvoiceHeader;
import innovate.tamergroup.fusion.soap.model.InvoiceLineModel;
import innovate.tamergroup.fusion.soap.model.InvoiceResponse;
import innovate.tamergroup.fusion.soap.model.JournalHeader;
import innovate.tamergroup.fusion.soap.model.JournalLine;
import innovate.tamergroup.fusion.soap.model.StandardReceiptRequest;
import innovate.tamergroup.persistence.entities.ServiceProviderJournalMapping;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class FusionJournalEntryMapping {
    
    private SessionEJB session;
    private FusionAppParams params;
    private Credential credential;
    private VendhqOutletsDB outlet;
    private HashMap<String, JournalHeader> journalEntryMap = new HashMap<>();
    private HashSet<String> journalLineSaleMap = new HashSet<>();
    

    public FusionJournalEntryMapping(SessionEJB session, FusionAppParams params, Credential credential, VendhqOutletsDB outlet) {
        super();
        this.params = params;
        this.credential = credential;
        this.session = session;
        this.outlet = outlet;
    }

    public JournalHeader getJournalEntryHeader(Boolean fixedCharge, InvoiceHeader invoice, String transactionNumber, String customerType, Boolean isCash) {
        String journalKey = getJournalKey(fixedCharge, transactionNumber, customerType);
        if (!journalEntryMap.containsKey(journalKey)) 
            journalEntryMap.put(journalKey, populateJournalHeader(fixedCharge, invoice, transactionNumber, 
                                                                  session.getServiceProviderMappingByRegion(customerType, "CREDIT", outlet.getRegion(), isCash)));
        return journalEntryMap.get(journalKey);
    }
    
    public void addToJournalEntryLine(Boolean fixedCharge, InvoiceHeader invoice, InvoiceLineModel invoiceLine,  
                                      InvoiceResponse invoiceResponse, String customerType, String orderCharge, 
                                      Boolean isCash, String costCenterCode) {
        JournalHeader journalHeader = getJournalEntryHeader(fixedCharge, invoice, invoiceResponse.getTransactionNumber(), customerType, isCash);
        
        ServiceProviderJournalMapping creditJournalMapping = session.getServiceProviderMappingByRegion(customerType, "CREDIT", outlet.getRegion(), isCash);
        ServiceProviderJournalMapping debitJournalMapping = session.getServiceProviderMappingByRegion(customerType, "DEBIT", outlet.getRegion(), isCash);
        
        
        if (journalLineSaleMap.contains(getJournalLineKey(fixedCharge, invoiceResponse.getTransactionNumber(), invoiceLine.getSalesOrder(), customerType)))
            return;
        else journalLineSaleMap.add(getJournalLineKey(fixedCharge, invoiceResponse.getTransactionNumber(), invoiceLine.getSalesOrder(), customerType));
        
        
        BigDecimal saleCharge = BigDecimal.valueOf(Double.valueOf(orderCharge));
        BigDecimal saleBankCharge = saleCharge.multiply(creditJournalMapping.getBankChargeRate() != null ? creditJournalMapping.getBankChargeRate() : BigDecimal.valueOf(0));
        BigDecimal finalCharge = fixedCharge ? (debitJournalMapping.getFixedFrieghtCharge() != null 
            ? debitJournalMapping.getFixedFrieghtCharge() :  saleBankCharge) : saleBankCharge;
        
        journalHeader.getJournalLines().add(generateJournalLine("CREDIT", journalHeader, invoice, invoiceLine, 
                                                                creditJournalMapping, finalCharge, costCenterCode));
        journalHeader.getJournalLines().add(generateJournalLine("DEBIT", journalHeader, invoice, invoiceLine, 
                                                                debitJournalMapping, finalCharge, costCenterCode));
    }
    
    private JournalLine generateJournalLine(String creditDebit, JournalHeader journalHeader, InvoiceHeader invoice, 
                                            InvoiceLineModel invoiceLine, ServiceProviderJournalMapping journalMapping, 
                                            BigDecimal charge, String costCenterCode) {
        JournalLine journalLine = new JournalLine();
        journalLine.setJeLineNum(journalHeader.getJournalLines().size()+1);
        journalLine.setPeriodName(getPeriodName(invoice.getSaleDate()));
        journalLine.setAccountingDate(invoice.getSaleDate());
        journalLine.setCurrencyCode(invoice.getInvoiceCurrencyCode());
        journalLine.setGroupId(journalHeader.getTxnNumber());
        
        journalLine.setSalesOrder(invoiceLine.getSalesOrder());
        journalLine.setLedgerId(journalMapping.getLedgerId().longValue());
        journalLine.setChartOfAccountsId(journalMapping.getChartOfAccountsId().longValue());
        journalLine.setJeSourceName(journalMapping.getJeSource());
        journalLine.setJeCategoryName(journalMapping.getJeCategory());
        journalLine.setUserJeSourceName(journalMapping.getJeSource());
        journalLine.setUserJeCategoryName(journalMapping.getJeCategory());
        //journalLine.setGroupId(journalMapping.getTaxGroupId() != null ? journalMapping.getTaxGroupId().longValue() : null);
        journalLine.setSegment1(journalMapping.getCompany());
        journalLine.setSegment2(journalMapping.getAccount());
        journalLine.setSegment3(journalMapping.getDepartment());
        journalLine.setSegment4(costCenterCode);
        journalLine.setSegment5("00");
        journalLine.setSegment6(journalMapping.getInterCompany());
        journalLine.setSegment7(journalMapping.getFutUsed());
        journalLine.setSegment8("00");
        journalLine.setSegment9("00");
        journalLine.setSegment10("00");
        journalLine.setTransactionDate(invoice.getSaleDate());

        if (!creditDebit.equals("CREDIT")) {
            journalLine.setEnteredCrAmount(charge);
            journalLine.setAccountedCr(charge);
        } else {
            journalLine.setEnteredDrAmount(charge);
            journalLine.setAccountedDr(charge);
        }
        
        journalLine.setUserCurrencyConversionType("User");
        journalLine.setCurrencyConversionType("Corporate");
        journalLine.setCurrencyConversionRate(BigDecimal.valueOf(1L));
        journalLine.setCurrencyConversionDate(invoice.getSaleDate());
        journalLine.setTaxCode("N");
        //journalLine.setStatus("P");
        journalLine.setAverageJournalFlag(false);

        return journalLine;
    }

    public List<JournalHeader> getJournalEntryList() {
        return new ArrayList<>(journalEntryMap.values());
    }
    
    private String getJournalKey(Boolean fixedCharge, String transactionNumber, String customerType) {
        StringBuilder builder = new StringBuilder();
        builder.append(fixedCharge ? "FIXED" : "BANK").append("***")
               .append(transactionNumber).append("***")
               .append(customerType);
        return builder.toString();
    }
    
    private String getJournalLineKey(Boolean fixedCharge, String transactionNumber, String salesOrder, String customerType) {
        StringBuilder builder = new StringBuilder();
        builder.append(getJournalKey(fixedCharge, transactionNumber, customerType)).append("***")
               .append(salesOrder);
        return builder.toString();
    }
    
    
    private JournalHeader populateJournalHeader(Boolean fixedCharge, InvoiceHeader invoice, String transactionNumber, 
                                ServiceProviderJournalMapping journalMapping) {
        JournalHeader journalHeader = new JournalHeader();
        journalHeader.setCustomerType(journalMapping.getServiceProvider());
        journalHeader.setCashCredit(fixedCharge ? "CASH" : "CREDIT");
        journalHeader.setBatchName(getPeriodName(invoice.getSaleDate()) + ": " + journalMapping.getServiceProvider());
        journalHeader.setBatchDescription("Journal Import: " + transactionNumber);
        journalHeader.setAccountingPeriodName(getPeriodName(invoice.getSaleDate()));
        journalHeader.setAccountingDate(invoice.getSaleDate());
        
        journalHeader.setLedgerId(journalMapping.getLedgerId().longValue());
        journalHeader.setUserSourceName(journalMapping.getJeSource());
        journalHeader.setUserCategoryName(journalMapping.getJeCategory());
        journalHeader.setTxnNumber(Long.valueOf(transactionNumber));
        
        journalHeader.setErrorToSuspenseFlag(false);
        journalHeader.setSummaryFlag(false);
        return journalHeader;
    }
    
    private String getPeriodName(Date saleDate) {
        DateFormat dateFormat = new SimpleDateFormat("MMM-yy");
        return dateFormat.format(saleDate);
    }
            
    private String getDayName(Date saleDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(saleDate);
        return calendar.get(Calendar.DAY_OF_WEEK) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
    }
}
