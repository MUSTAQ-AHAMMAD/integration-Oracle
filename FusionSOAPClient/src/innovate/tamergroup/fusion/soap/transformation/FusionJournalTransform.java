package innovate.tamergroup.fusion.soap.transformation;

import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.GlInterface;
import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.GlInterfaceTransHeader;
import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.ObjectFactory;
import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.ServiceException;

import innovate.tamergroup.fusion.soap.model.JournalHeader;
import innovate.tamergroup.fusion.soap.model.JournalLine;

import innovate.tamergroup.fusion.soap.utils.MappingUtils;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class FusionJournalTransform {

    private ObjectFactory objectFactory = new ObjectFactory();

    public FusionJournalTransform() {
        this.objectFactory = new ObjectFactory();
    }

    public GlInterfaceTransHeader importJournalModel(JournalHeader journalheader) throws ServiceException,
                                                                                         DatatypeConfigurationException {

        GlInterfaceTransHeader glInterfaceTransHeader = objectFactory.createGlInterfaceTransHeader();

        glInterfaceTransHeader.setBatchName(objectFactory.createGlInterfaceTransHeaderBatchName(journalheader.getBatchName()));
        glInterfaceTransHeader.setBatchDescription(objectFactory.createGlInterfaceTransHeaderBatchDescription(journalheader.getBatchDescription()));
        glInterfaceTransHeader.setLedgerId(objectFactory.createGlInterfaceTransHeaderLedgerId(journalheader.getLedgerId()));
        glInterfaceTransHeader.setAccountingPeriodName(objectFactory.createGlInterfaceTransHeaderAccountingPeriodName(journalheader.getAccountingPeriodName()));

        glInterfaceTransHeader.setAccountingDate(objectFactory.createGlInterfaceTransHeaderAccountingDate(MappingUtils.convertToGregCalendar(journalheader.getAccountingDate())));
        glInterfaceTransHeader.setUserSourceName(objectFactory.createGlInterfaceTransHeaderUserSourceName(journalheader.getUserSourceName()));
        glInterfaceTransHeader.setUserCategoryName(objectFactory.createGlInterfaceTransHeaderUserCategoryName(journalheader.getUserCategoryName()));
        glInterfaceTransHeader.setErrorToSuspenseFlag(objectFactory.createGlInterfaceTransHeaderErrorToSuspenseFlag(journalheader.getErrorToSuspenseFlag()));
        glInterfaceTransHeader.setSummaryFlag(objectFactory.createGlInterfaceTransHeaderSummaryFlag(journalheader.getSummaryFlag()));
        //glInterfaceTransHeader.setImportDescriptiveFlexField(objectFactory.createGlInterfaceTransHeaderImportDescriptiveFlexField("N"));


        List<GlInterface> glInterfaces = glInterfaceTransHeader.getGlInterface();

        for (JournalLine line : journalheader.getJournalLines()) {
            GlInterface glInterfaceLine = objectFactory.createGlInterface();
            glInterfaceLine.setLedgerId(line.getLedgerId());
            glInterfaceLine.setPeriodName(objectFactory.createGlInterfacePeriodName(line.getPeriodName()));
            
            glInterfaceLine.setAccountingDate(MappingUtils.convertToGregCalendar(line.getAccountingDate()));
            glInterfaceLine.setUserJeSourceName(line.getUserJeSourceName());
            glInterfaceLine.setUserJeCategoryName(line.getUserJeCategoryName());
            glInterfaceLine.setGroupId(line.getGroupId());
            glInterfaceLine.setChartOfAccountsId(objectFactory.createGlInterfaceChartOfAccountsId(line.getChartOfAccountsId()));
            glInterfaceLine.setSegment1(objectFactory.createGlInterfaceSegment1(line.getSegment1()));
            glInterfaceLine.setSegment2(objectFactory.createGlInterfaceSegment2(line.getSegment2()));
            glInterfaceLine.setSegment3(objectFactory.createGlInterfaceSegment3(line.getSegment3()));
            glInterfaceLine.setSegment4(objectFactory.createGlInterfaceSegment4(line.getSegment4()));
            glInterfaceLine.setSegment5(objectFactory.createGlInterfaceSegment5(line.getSegment5()));
            glInterfaceLine.setSegment6(objectFactory.createGlInterfaceSegment6(line.getSegment6()));
            glInterfaceLine.setSegment7(objectFactory.createGlInterfaceSegment7(line.getSegment7()));
            glInterfaceLine.setSegment8(objectFactory.createGlInterfaceSegment8(line.getSegment8()));
            glInterfaceLine.setSegment9(objectFactory.createGlInterfaceSegment9(line.getSegment9()));
            glInterfaceLine.setSegment10(objectFactory.createGlInterfaceSegment10(line.getSegment10()));
            glInterfaceLine.setCurrencyCode(line.getCurrencyCode());
            glInterfaceLine.setUserCurrencyConversionType(objectFactory.createGlInterfaceUserCurrencyConversionType(line.getUserCurrencyConversionType()));

            glInterfaceLine.setCurrencyConversionDate(objectFactory.createGlInterfaceCurrencyConversionDate(MappingUtils.convertToGregCalendar(line.getCurrencyConversionDate())));
            glInterfaceLine.setCurrencyConversionRate(objectFactory.createGlInterfaceCurrencyConversionRate(line.getCurrencyConversionRate()));
            glInterfaceLine.setCurrencyConversionType(objectFactory.createGlInterfaceCurrencyConversionType(line.getCurrencyConversionType()));
            glInterfaceLine.setAverageJournalFlag(objectFactory.createGlInterfaceAverageJournalFlag(line.getAverageJournalFlag()));
            glInterfaceLine.setJeCategoryName(objectFactory.createGlInterfaceJeCategoryName(line.getJeCategoryName()));
            glInterfaceLine.setJeSourceName(objectFactory.createGlInterfaceJeSourceName(line.getJeSourceName()));
            glInterfaceLine.setStatus(line.getStatus());
            glInterfaceLine.setTaxCode(objectFactory.createGlInterfaceTaxCode(line.getTaxCode()));
            glInterfaceLine.setTransactionDate(objectFactory.createGlInterfaceTransactionDate(MappingUtils.convertToGregCalendar(line.getTransactionDate())));

            // if(line.getRecordType()!=null && line.getRecordType().equals("CR"))
            // {
            AmountType credirAmount = new AmountType();
            credirAmount.setValue(line.getEnteredCrAmount());
            credirAmount.setCurrencyCode(line.getCurrencyCode());
            glInterfaceLine.setEnteredCrAmount(objectFactory.createGlInterfaceEnteredCrAmount(credirAmount));
            glInterfaceLine.setAccountedCr(objectFactory.createGlInterfaceAccountedCr(line.getAccountedCr()));
            //}
            //else if(line.getRecordType()!=null && line.getRecordType().equals("DB"))
            // {
            AmountType debitAmount = new AmountType();
            debitAmount.setValue(line.getEnteredDrAmount());
            debitAmount.setCurrencyCode(line.getCurrencyCode());
            glInterfaceLine.setEnteredDrAmount(objectFactory.createGlInterfaceEnteredDrAmount(debitAmount));
            glInterfaceLine.setAccountedDr(objectFactory.createGlInterfaceAccountedDr(line.getAccountedDr()));

            //   }

            glInterfaces.add(glInterfaceLine);

        }


        return glInterfaceTransHeader;


    }
}
