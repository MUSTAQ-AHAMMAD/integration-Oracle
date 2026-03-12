package innovate.tamergroup.fusion.soap.services;

import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.JournalImportService;
import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.JournalImportService_Service;

import innovate.tamergroup.fusion.soap.model.JournalHeader;
import innovate.tamergroup.fusion.soap.model.JournalLine;
import innovate.tamergroup.fusion.soap.transformation.FusionJournalTransform;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.shared.utils.SOAPUtils;

import java.io.ByteArrayInputStream;

import java.math.BigDecimal;

import java.util.GregorianCalendar;
import java.util.Calendar;

import java.util.stream.Stream;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;

public class FusionJournalClient {
    
    private FusionAppParams params;
    private Credential credential;
    private FusionJournalTransform fusionJournalTransform;


    public FusionJournalClient(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
        this.fusionJournalTransform = new FusionJournalTransform();
    }

    public boolean saveImportJournal(JournalHeader journalHeader) throws Exception {
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));
        
        JournalImportService journalImportService =
            new JournalImportService_Service(params).getJournalImportServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)journalImportService, credential);

        Long result = journalImportService.importJournals(fusionJournalTransform.importJournalModel(journalHeader));
        if (result != null) {
            journalHeader.setJeHeaderId(result);
            journalHeader.getJournalLines().stream().forEach(journalLine -> journalLine.setJeHeaderId(result));
        }
        System.out.println();
        System.out.println("JE Header ID: " + result);
        
        return result != null;
    }
    

    public static void main(String[] args) throws Exception {
            FusionJournalClient journalUtils = new FusionJournalClient(new FusionAppParams("ehxk-test", "em2"), new Credential("Ahmed.ali", "Tamer@123"));
            
            try {
            boolean status = journalUtils.testCallImportJournals();
             System.out.println(status);   
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
        
        
       
         
         
         
        public boolean testCallImportJournals( ) throws Exception {

                JournalHeader journalHeader = new JournalHeader();
                journalHeader.setBatchName("Jan-21: HUNGERSTATION");
                journalHeader.setBatchDescription("Journal Import: 209354");
                journalHeader.setLedgerId(300000001418025L);
                journalHeader.setAccountingPeriodName("Jan-21");
                Calendar c = Calendar.getInstance();
                c.set(c.YEAR , 2021);
                c.set(c.MONTH , 0);
                c.set(c.DAY_OF_MONTH , 14);

                journalHeader.setAccountingDate(c.getTime());
                journalHeader.setUserSourceName("Vend");
                journalHeader.setUserCategoryName("Vend");
                journalHeader.setErrorToSuspenseFlag(false);
                journalHeader.setSummaryFlag(false);
                
            
                JournalLine journalLine = new JournalLine();
                journalLine.setLedgerId(300000001418025L);
                journalLine.setPeriodName("Jan-18");
                journalLine.setAccountingDate(c.getTime());
                journalLine.setUserJeSourceName("Vend");
                journalLine.setJeCategoryName("Vend");
                journalLine.setGroupId(209354L);
                journalLine.setChartOfAccountsId(2001L);
                journalLine.setSegment1("01");
                journalLine.setSegment2("5000104");
                journalLine.setSegment3("52");
                journalLine.setSegment4("0203");
                journalLine.setSegment5("00");
                journalLine.setSegment6("01");
                journalLine.setSegment7("00");
                journalLine.setSegment8("00");
                journalLine.setSegment9("00");
                journalLine.setSegment10("00");
                journalLine.setCurrencyCode("SAR");
                journalLine.setEnteredCrAmount(BigDecimal.valueOf(1580.5));
                journalLine.setAccountedCr(BigDecimal.valueOf(1580.5));
                journalLine.setUserCurrencyConversionType("User");
                

                journalLine.setCurrencyConversionDate(c.getTime());
                journalLine.setCurrencyConversionRate(new BigDecimal(1));
                journalLine.setCurrencyConversionType("Corporate");
                journalLine.setAverageJournalFlag(false);
                journalLine.setJeCategoryName("Vend");
                journalLine.setJeSourceName("Vend");
                journalLine.setStatus("P");
                journalLine.setTaxCode("N");
                journalLine.setTransactionDate(c.getTime());
                
                
                journalHeader.getJournalLines().add(journalLine);
                
                
                return saveImportJournal(journalHeader);
            
            
            }
    

}
