
package com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice;

import java.math.BigDecimal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.financials.generalledger.accounts.codecombinations.publicflex.account.Account;


/**
 * <p>Java class for GlInterface complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlInterface"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Reference4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LedgerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="PeriodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountingDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="UserJeSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserJeCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ChartOfAccountsId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="BalanceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodeCombinationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="Segment1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment25" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment26" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment27" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Segment30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EnteredCrAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="EnteredDrAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AccountedCr" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="AccountedDr" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="StatisticalValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="UserCurrencyConversionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversionRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyConversionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference25" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference26" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference27" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="Attribute1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attribute20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AttributeCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AttributeCategory2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AttributeCategory3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AverageJournalFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="BalancingSegmentValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DescrFlexErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GlSlLinkId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="GlSlLinkTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="JeCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="JeSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="JgzzReconReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ManagementSegmentValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ObjectVersionNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OriginatingBalSegValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SetOfBooksId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="USSGLTransactionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GlInterfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="AccountKFF" type="{http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/}Account" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlInterface", propOrder = {
         "reference4", "reference5", "ledgerId", "periodName", "accountingDate", "userJeSourceName",
         "userJeCategoryName", "groupId", "chartOfAccountsId", "balanceType", "codeCombinationId", "segment1",
         "segment2", "segment3", "segment4", "segment5", "segment6", "segment7", "segment8", "segment9", "segment10",
         "segment11", "segment12", "segment13", "segment14", "segment15", "segment16", "segment17", "segment18",
         "segment19", "segment20", "segment21", "segment22", "segment23", "segment24", "segment25", "segment26",
         "segment27", "segment28", "segment29", "segment30", "currencyCode", "enteredCrAmount", "enteredDrAmount",
         "accountedCr", "accountedDr", "statisticalValue", "userCurrencyConversionType", "currencyConversionDate",
         "currencyConversionRate", "currencyConversionType", "reference1", "reference2", "reference3", "reference6",
         "reference7", "reference8", "reference9", "reference10", "reference11", "reference12", "reference13",
         "reference14", "reference15", "reference16", "reference17", "reference18", "reference19", "reference20",
         "reference21", "reference22", "reference23", "reference24", "reference25", "reference26", "reference27",
         "reference28", "reference29", "reference30", "referenceDate", "attribute1", "attribute2", "attribute3",
         "attribute4", "attribute5", "attribute6", "attribute7", "attribute8", "attribute9", "attribute10",
         "attribute11", "attribute12", "attribute13", "attribute14", "attribute15", "attribute16", "attribute17",
         "attribute18", "attribute19", "attribute20", "attributeCategory", "attributeCategory2", "attributeCategory3",
         "averageJournalFlag", "balancingSegmentValue", "descrFlexErrorMessage", "glSlLinkId", "glSlLinkTable",
         "invoiceAmount", "invoiceDate", "invoiceIdentifier", "jeCategoryName", "jeSourceName", "jgzzReconReference",
         "managementSegmentValue", "objectVersionNumber", "originatingBalSegValue", "setOfBooksId", "status", "taxCode",
         "transactionDate", "ussglTransactionCode", "glInterfaceId", "accountKFF"
    })
public class GlInterface {

    @XmlElementRef(name = "Reference4",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference4;
    @XmlElementRef(name = "Reference5",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference5;
    @XmlElement(name = "LedgerId")
    protected Long ledgerId;
    @XmlElementRef(name = "PeriodName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> periodName;
    @XmlElement(name = "AccountingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accountingDate;
    @XmlElement(name = "UserJeSourceName")
    protected String userJeSourceName;
    @XmlElement(name = "UserJeCategoryName")
    protected String userJeCategoryName;
    @XmlElement(name = "GroupId")
    protected Long groupId;
    @XmlElementRef(name = "ChartOfAccountsId",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Long> chartOfAccountsId;
    @XmlElement(name = "BalanceType")
    protected String balanceType;
    @XmlElementRef(name = "CodeCombinationId",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Long> codeCombinationId;
    @XmlElementRef(name = "Segment1",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment1;
    @XmlElementRef(name = "Segment2",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment2;
    @XmlElementRef(name = "Segment3",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment3;
    @XmlElementRef(name = "Segment4",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment4;
    @XmlElementRef(name = "Segment5",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment5;
    @XmlElementRef(name = "Segment6",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment6;
    @XmlElementRef(name = "Segment7",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment7;
    @XmlElementRef(name = "Segment8",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment8;
    @XmlElementRef(name = "Segment9",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment9;
    @XmlElementRef(name = "Segment10",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment10;
    @XmlElementRef(name = "Segment11",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment11;
    @XmlElementRef(name = "Segment12",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment12;
    @XmlElementRef(name = "Segment13",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment13;
    @XmlElementRef(name = "Segment14",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment14;
    @XmlElementRef(name = "Segment15",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment15;
    @XmlElementRef(name = "Segment16",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment16;
    @XmlElementRef(name = "Segment17",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment17;
    @XmlElementRef(name = "Segment18",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment18;
    @XmlElementRef(name = "Segment19",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment19;
    @XmlElementRef(name = "Segment20",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment20;
    @XmlElementRef(name = "Segment21",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment21;
    @XmlElementRef(name = "Segment22",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment22;
    @XmlElementRef(name = "Segment23",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment23;
    @XmlElementRef(name = "Segment24",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment24;
    @XmlElementRef(name = "Segment25",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment25;
    @XmlElementRef(name = "Segment26",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment26;
    @XmlElementRef(name = "Segment27",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment27;
    @XmlElementRef(name = "Segment28",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment28;
    @XmlElementRef(name = "Segment29",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment29;
    @XmlElementRef(name = "Segment30",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> segment30;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElementRef(name = "EnteredCrAmount",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> enteredCrAmount;
    @XmlElementRef(name = "EnteredDrAmount",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> enteredDrAmount;
    @XmlElementRef(name = "AccountedCr",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> accountedCr;
    @XmlElementRef(name = "AccountedDr",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> accountedDr;
    @XmlElementRef(name = "StatisticalValue",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> statisticalValue;
    @XmlElementRef(name = "UserCurrencyConversionType",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> userCurrencyConversionType;
    @XmlElementRef(name = "CurrencyConversionDate",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> currencyConversionDate;
    @XmlElementRef(name = "CurrencyConversionRate",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> currencyConversionRate;
    @XmlElementRef(name = "CurrencyConversionType",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> currencyConversionType;
    @XmlElementRef(name = "Reference1",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference1;
    @XmlElementRef(name = "Reference2",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference2;
    @XmlElementRef(name = "Reference3",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference3;
    @XmlElementRef(name = "Reference6",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference6;
    @XmlElementRef(name = "Reference7",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference7;
    @XmlElementRef(name = "Reference8",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference8;
    @XmlElementRef(name = "Reference9",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference9;
    @XmlElementRef(name = "Reference10",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference10;
    @XmlElementRef(name = "Reference11",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference11;
    @XmlElementRef(name = "Reference12",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference12;
    @XmlElementRef(name = "Reference13",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference13;
    @XmlElementRef(name = "Reference14",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference14;
    @XmlElementRef(name = "Reference15",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference15;
    @XmlElementRef(name = "Reference16",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference16;
    @XmlElementRef(name = "Reference17",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference17;
    @XmlElementRef(name = "Reference18",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference18;
    @XmlElementRef(name = "Reference19",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference19;
    @XmlElementRef(name = "Reference20",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference20;
    @XmlElementRef(name = "Reference21",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference21;
    @XmlElementRef(name = "Reference22",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference22;
    @XmlElementRef(name = "Reference23",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference23;
    @XmlElementRef(name = "Reference24",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference24;
    @XmlElementRef(name = "Reference25",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference25;
    @XmlElementRef(name = "Reference26",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference26;
    @XmlElementRef(name = "Reference27",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference27;
    @XmlElementRef(name = "Reference28",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference28;
    @XmlElementRef(name = "Reference29",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference29;
    @XmlElementRef(name = "Reference30",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference30;
    @XmlElementRef(name = "ReferenceDate",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> referenceDate;
    @XmlElementRef(name = "Attribute1",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute1;
    @XmlElementRef(name = "Attribute2",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute2;
    @XmlElementRef(name = "Attribute3",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute3;
    @XmlElementRef(name = "Attribute4",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute4;
    @XmlElementRef(name = "Attribute5",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute5;
    @XmlElementRef(name = "Attribute6",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute6;
    @XmlElementRef(name = "Attribute7",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute7;
    @XmlElementRef(name = "Attribute8",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute8;
    @XmlElementRef(name = "Attribute9",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute9;
    @XmlElementRef(name = "Attribute10",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute10;
    @XmlElementRef(name = "Attribute11",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute11;
    @XmlElementRef(name = "Attribute12",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute12;
    @XmlElementRef(name = "Attribute13",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute13;
    @XmlElementRef(name = "Attribute14",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute14;
    @XmlElementRef(name = "Attribute15",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute15;
    @XmlElementRef(name = "Attribute16",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute16;
    @XmlElementRef(name = "Attribute17",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute17;
    @XmlElementRef(name = "Attribute18",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute18;
    @XmlElementRef(name = "Attribute19",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute19;
    @XmlElementRef(name = "Attribute20",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attribute20;
    @XmlElementRef(name = "AttributeCategory",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attributeCategory;
    @XmlElementRef(name = "AttributeCategory2",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attributeCategory2;
    @XmlElementRef(name = "AttributeCategory3",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> attributeCategory3;
    @XmlElementRef(name = "AverageJournalFlag",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> averageJournalFlag;
    @XmlElementRef(name = "BalancingSegmentValue",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> balancingSegmentValue;
    @XmlElementRef(name = "DescrFlexErrorMessage",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> descrFlexErrorMessage;
    @XmlElementRef(name = "GlSlLinkId",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> glSlLinkId;
    @XmlElementRef(name = "GlSlLinkTable",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> glSlLinkTable;
    @XmlElementRef(name = "InvoiceAmount",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> invoiceAmount;
    @XmlElementRef(name = "InvoiceDate",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> invoiceDate;
    @XmlElementRef(name = "InvoiceIdentifier",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> invoiceIdentifier;
    @XmlElementRef(name = "JeCategoryName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> jeCategoryName;
    @XmlElementRef(name = "JeSourceName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> jeSourceName;
    @XmlElementRef(name = "JgzzReconReference",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> jgzzReconReference;
    @XmlElementRef(name = "ManagementSegmentValue",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> managementSegmentValue;
    @XmlElement(name = "ObjectVersionNumber")
    protected Integer objectVersionNumber;
    @XmlElementRef(name = "OriginatingBalSegValue",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> originatingBalSegValue;
    @XmlElementRef(name = "SetOfBooksId",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Long> setOfBooksId;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElementRef(name = "TaxCode",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxCode;
    @XmlElementRef(name = "TransactionDate",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> transactionDate;
    @XmlElementRef(name = "USSGLTransactionCode",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> ussglTransactionCode;
    @XmlElementRef(name = "GlInterfaceId",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Long> glInterfaceId;
    @XmlElement(name = "AccountKFF")
    protected Account accountKFF;

    /**
     * Gets the value of the reference4 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference4() {
        return reference4;
    }

    /**
     * Sets the value of the reference4 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference4(JAXBElement<String> value) {
        this.reference4 = value;
    }

    /**
     * Gets the value of the reference5 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference5() {
        return reference5;
    }

    /**
     * Sets the value of the reference5 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference5(JAXBElement<String> value) {
        this.reference5 = value;
    }

    /**
     * Gets the value of the ledgerId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getLedgerId() {
        return ledgerId;
    }

    /**
     * Sets the value of the ledgerId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setLedgerId(Long value) {
        this.ledgerId = value;
    }

    /**
     * Gets the value of the periodName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getPeriodName() {
        return periodName;
    }

    /**
     * Sets the value of the periodName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setPeriodName(JAXBElement<String> value) {
        this.periodName = value;
    }

    /**
     * Gets the value of the accountingDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getAccountingDate() {
        return accountingDate;
    }

    /**
     * Sets the value of the accountingDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setAccountingDate(XMLGregorianCalendar value) {
        this.accountingDate = value;
    }

    /**
     * Gets the value of the userJeSourceName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserJeSourceName() {
        return userJeSourceName;
    }

    /**
     * Sets the value of the userJeSourceName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserJeSourceName(String value) {
        this.userJeSourceName = value;
    }

    /**
     * Gets the value of the userJeCategoryName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserJeCategoryName() {
        return userJeCategoryName;
    }

    /**
     * Sets the value of the userJeCategoryName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserJeCategoryName(String value) {
        this.userJeCategoryName = value;
    }

    /**
     * Gets the value of the groupId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setGroupId(Long value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the chartOfAccountsId property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public JAXBElement<Long> getChartOfAccountsId() {
        return chartOfAccountsId;
    }

    /**
     * Sets the value of the chartOfAccountsId property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public void setChartOfAccountsId(JAXBElement<Long> value) {
        this.chartOfAccountsId = value;
    }

    /**
     * Gets the value of the balanceType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * Sets the value of the balanceType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBalanceType(String value) {
        this.balanceType = value;
    }

    /**
     * Gets the value of the codeCombinationId property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public JAXBElement<Long> getCodeCombinationId() {
        return codeCombinationId;
    }

    /**
     * Sets the value of the codeCombinationId property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public void setCodeCombinationId(JAXBElement<Long> value) {
        this.codeCombinationId = value;
    }

    /**
     * Gets the value of the segment1 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment1() {
        return segment1;
    }

    /**
     * Sets the value of the segment1 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment1(JAXBElement<String> value) {
        this.segment1 = value;
    }

    /**
     * Gets the value of the segment2 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment2() {
        return segment2;
    }

    /**
     * Sets the value of the segment2 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment2(JAXBElement<String> value) {
        this.segment2 = value;
    }

    /**
     * Gets the value of the segment3 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment3() {
        return segment3;
    }

    /**
     * Sets the value of the segment3 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment3(JAXBElement<String> value) {
        this.segment3 = value;
    }

    /**
     * Gets the value of the segment4 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment4() {
        return segment4;
    }

    /**
     * Sets the value of the segment4 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment4(JAXBElement<String> value) {
        this.segment4 = value;
    }

    /**
     * Gets the value of the segment5 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment5() {
        return segment5;
    }

    /**
     * Sets the value of the segment5 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment5(JAXBElement<String> value) {
        this.segment5 = value;
    }

    /**
     * Gets the value of the segment6 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment6() {
        return segment6;
    }

    /**
     * Sets the value of the segment6 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment6(JAXBElement<String> value) {
        this.segment6 = value;
    }

    /**
     * Gets the value of the segment7 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment7() {
        return segment7;
    }

    /**
     * Sets the value of the segment7 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment7(JAXBElement<String> value) {
        this.segment7 = value;
    }

    /**
     * Gets the value of the segment8 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment8() {
        return segment8;
    }

    /**
     * Sets the value of the segment8 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment8(JAXBElement<String> value) {
        this.segment8 = value;
    }

    /**
     * Gets the value of the segment9 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment9() {
        return segment9;
    }

    /**
     * Sets the value of the segment9 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment9(JAXBElement<String> value) {
        this.segment9 = value;
    }

    /**
     * Gets the value of the segment10 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment10() {
        return segment10;
    }

    /**
     * Sets the value of the segment10 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment10(JAXBElement<String> value) {
        this.segment10 = value;
    }

    /**
     * Gets the value of the segment11 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment11() {
        return segment11;
    }

    /**
     * Sets the value of the segment11 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment11(JAXBElement<String> value) {
        this.segment11 = value;
    }

    /**
     * Gets the value of the segment12 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment12() {
        return segment12;
    }

    /**
     * Sets the value of the segment12 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment12(JAXBElement<String> value) {
        this.segment12 = value;
    }

    /**
     * Gets the value of the segment13 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment13() {
        return segment13;
    }

    /**
     * Sets the value of the segment13 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment13(JAXBElement<String> value) {
        this.segment13 = value;
    }

    /**
     * Gets the value of the segment14 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment14() {
        return segment14;
    }

    /**
     * Sets the value of the segment14 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment14(JAXBElement<String> value) {
        this.segment14 = value;
    }

    /**
     * Gets the value of the segment15 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment15() {
        return segment15;
    }

    /**
     * Sets the value of the segment15 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment15(JAXBElement<String> value) {
        this.segment15 = value;
    }

    /**
     * Gets the value of the segment16 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment16() {
        return segment16;
    }

    /**
     * Sets the value of the segment16 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment16(JAXBElement<String> value) {
        this.segment16 = value;
    }

    /**
     * Gets the value of the segment17 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment17() {
        return segment17;
    }

    /**
     * Sets the value of the segment17 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment17(JAXBElement<String> value) {
        this.segment17 = value;
    }

    /**
     * Gets the value of the segment18 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment18() {
        return segment18;
    }

    /**
     * Sets the value of the segment18 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment18(JAXBElement<String> value) {
        this.segment18 = value;
    }

    /**
     * Gets the value of the segment19 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment19() {
        return segment19;
    }

    /**
     * Sets the value of the segment19 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment19(JAXBElement<String> value) {
        this.segment19 = value;
    }

    /**
     * Gets the value of the segment20 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment20() {
        return segment20;
    }

    /**
     * Sets the value of the segment20 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment20(JAXBElement<String> value) {
        this.segment20 = value;
    }

    /**
     * Gets the value of the segment21 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment21() {
        return segment21;
    }

    /**
     * Sets the value of the segment21 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment21(JAXBElement<String> value) {
        this.segment21 = value;
    }

    /**
     * Gets the value of the segment22 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment22() {
        return segment22;
    }

    /**
     * Sets the value of the segment22 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment22(JAXBElement<String> value) {
        this.segment22 = value;
    }

    /**
     * Gets the value of the segment23 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment23() {
        return segment23;
    }

    /**
     * Sets the value of the segment23 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment23(JAXBElement<String> value) {
        this.segment23 = value;
    }

    /**
     * Gets the value of the segment24 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment24() {
        return segment24;
    }

    /**
     * Sets the value of the segment24 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment24(JAXBElement<String> value) {
        this.segment24 = value;
    }

    /**
     * Gets the value of the segment25 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment25() {
        return segment25;
    }

    /**
     * Sets the value of the segment25 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment25(JAXBElement<String> value) {
        this.segment25 = value;
    }

    /**
     * Gets the value of the segment26 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment26() {
        return segment26;
    }

    /**
     * Sets the value of the segment26 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment26(JAXBElement<String> value) {
        this.segment26 = value;
    }

    /**
     * Gets the value of the segment27 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment27() {
        return segment27;
    }

    /**
     * Sets the value of the segment27 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment27(JAXBElement<String> value) {
        this.segment27 = value;
    }

    /**
     * Gets the value of the segment28 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment28() {
        return segment28;
    }

    /**
     * Sets the value of the segment28 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment28(JAXBElement<String> value) {
        this.segment28 = value;
    }

    /**
     * Gets the value of the segment29 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment29() {
        return segment29;
    }

    /**
     * Sets the value of the segment29 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment29(JAXBElement<String> value) {
        this.segment29 = value;
    }

    /**
     * Gets the value of the segment30 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getSegment30() {
        return segment30;
    }

    /**
     * Sets the value of the segment30 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setSegment30(JAXBElement<String> value) {
        this.segment30 = value;
    }

    /**
     * Gets the value of the currencyCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the enteredCrAmount property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *
     */
    public JAXBElement<AmountType> getEnteredCrAmount() {
        return enteredCrAmount;
    }

    /**
     * Sets the value of the enteredCrAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *
     */
    public void setEnteredCrAmount(JAXBElement<AmountType> value) {
        this.enteredCrAmount = value;
    }

    /**
     * Gets the value of the enteredDrAmount property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *
     */
    public JAXBElement<AmountType> getEnteredDrAmount() {
        return enteredDrAmount;
    }

    /**
     * Sets the value of the enteredDrAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *
     */
    public void setEnteredDrAmount(JAXBElement<AmountType> value) {
        this.enteredDrAmount = value;
    }

    /**
     * Gets the value of the accountedCr property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public JAXBElement<BigDecimal> getAccountedCr() {
        return accountedCr;
    }

    /**
     * Sets the value of the accountedCr property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public void setAccountedCr(JAXBElement<BigDecimal> value) {
        this.accountedCr = value;
    }

    /**
     * Gets the value of the accountedDr property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public JAXBElement<BigDecimal> getAccountedDr() {
        return accountedDr;
    }

    /**
     * Sets the value of the accountedDr property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public void setAccountedDr(JAXBElement<BigDecimal> value) {
        this.accountedDr = value;
    }

    /**
     * Gets the value of the statisticalValue property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public JAXBElement<BigDecimal> getStatisticalValue() {
        return statisticalValue;
    }

    /**
     * Sets the value of the statisticalValue property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public void setStatisticalValue(JAXBElement<BigDecimal> value) {
        this.statisticalValue = value;
    }

    /**
     * Gets the value of the userCurrencyConversionType property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getUserCurrencyConversionType() {
        return userCurrencyConversionType;
    }

    /**
     * Sets the value of the userCurrencyConversionType property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setUserCurrencyConversionType(JAXBElement<String> value) {
        this.userCurrencyConversionType = value;
    }

    /**
     * Gets the value of the currencyConversionDate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getCurrencyConversionDate() {
        return currencyConversionDate;
    }

    /**
     * Sets the value of the currencyConversionDate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setCurrencyConversionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.currencyConversionDate = value;
    }

    /**
     * Gets the value of the currencyConversionRate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public JAXBElement<BigDecimal> getCurrencyConversionRate() {
        return currencyConversionRate;
    }

    /**
     * Sets the value of the currencyConversionRate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public void setCurrencyConversionRate(JAXBElement<BigDecimal> value) {
        this.currencyConversionRate = value;
    }

    /**
     * Gets the value of the currencyConversionType property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getCurrencyConversionType() {
        return currencyConversionType;
    }

    /**
     * Sets the value of the currencyConversionType property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setCurrencyConversionType(JAXBElement<String> value) {
        this.currencyConversionType = value;
    }

    /**
     * Gets the value of the reference1 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference1() {
        return reference1;
    }

    /**
     * Sets the value of the reference1 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference1(JAXBElement<String> value) {
        this.reference1 = value;
    }

    /**
     * Gets the value of the reference2 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference2() {
        return reference2;
    }

    /**
     * Sets the value of the reference2 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference2(JAXBElement<String> value) {
        this.reference2 = value;
    }

    /**
     * Gets the value of the reference3 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference3() {
        return reference3;
    }

    /**
     * Sets the value of the reference3 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference3(JAXBElement<String> value) {
        this.reference3 = value;
    }

    /**
     * Gets the value of the reference6 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference6() {
        return reference6;
    }

    /**
     * Sets the value of the reference6 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference6(JAXBElement<String> value) {
        this.reference6 = value;
    }

    /**
     * Gets the value of the reference7 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference7() {
        return reference7;
    }

    /**
     * Sets the value of the reference7 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference7(JAXBElement<String> value) {
        this.reference7 = value;
    }

    /**
     * Gets the value of the reference8 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference8() {
        return reference8;
    }

    /**
     * Sets the value of the reference8 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference8(JAXBElement<String> value) {
        this.reference8 = value;
    }

    /**
     * Gets the value of the reference9 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference9() {
        return reference9;
    }

    /**
     * Sets the value of the reference9 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference9(JAXBElement<String> value) {
        this.reference9 = value;
    }

    /**
     * Gets the value of the reference10 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference10() {
        return reference10;
    }

    /**
     * Sets the value of the reference10 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference10(JAXBElement<String> value) {
        this.reference10 = value;
    }

    /**
     * Gets the value of the reference11 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference11() {
        return reference11;
    }

    /**
     * Sets the value of the reference11 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference11(JAXBElement<String> value) {
        this.reference11 = value;
    }

    /**
     * Gets the value of the reference12 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference12() {
        return reference12;
    }

    /**
     * Sets the value of the reference12 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference12(JAXBElement<String> value) {
        this.reference12 = value;
    }

    /**
     * Gets the value of the reference13 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference13() {
        return reference13;
    }

    /**
     * Sets the value of the reference13 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference13(JAXBElement<String> value) {
        this.reference13 = value;
    }

    /**
     * Gets the value of the reference14 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference14() {
        return reference14;
    }

    /**
     * Sets the value of the reference14 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference14(JAXBElement<String> value) {
        this.reference14 = value;
    }

    /**
     * Gets the value of the reference15 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference15() {
        return reference15;
    }

    /**
     * Sets the value of the reference15 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference15(JAXBElement<String> value) {
        this.reference15 = value;
    }

    /**
     * Gets the value of the reference16 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference16() {
        return reference16;
    }

    /**
     * Sets the value of the reference16 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference16(JAXBElement<String> value) {
        this.reference16 = value;
    }

    /**
     * Gets the value of the reference17 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference17() {
        return reference17;
    }

    /**
     * Sets the value of the reference17 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference17(JAXBElement<String> value) {
        this.reference17 = value;
    }

    /**
     * Gets the value of the reference18 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference18() {
        return reference18;
    }

    /**
     * Sets the value of the reference18 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference18(JAXBElement<String> value) {
        this.reference18 = value;
    }

    /**
     * Gets the value of the reference19 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference19() {
        return reference19;
    }

    /**
     * Sets the value of the reference19 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference19(JAXBElement<String> value) {
        this.reference19 = value;
    }

    /**
     * Gets the value of the reference20 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference20() {
        return reference20;
    }

    /**
     * Sets the value of the reference20 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference20(JAXBElement<String> value) {
        this.reference20 = value;
    }

    /**
     * Gets the value of the reference21 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference21() {
        return reference21;
    }

    /**
     * Sets the value of the reference21 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference21(JAXBElement<String> value) {
        this.reference21 = value;
    }

    /**
     * Gets the value of the reference22 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference22() {
        return reference22;
    }

    /**
     * Sets the value of the reference22 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference22(JAXBElement<String> value) {
        this.reference22 = value;
    }

    /**
     * Gets the value of the reference23 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference23() {
        return reference23;
    }

    /**
     * Sets the value of the reference23 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference23(JAXBElement<String> value) {
        this.reference23 = value;
    }

    /**
     * Gets the value of the reference24 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference24() {
        return reference24;
    }

    /**
     * Sets the value of the reference24 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference24(JAXBElement<String> value) {
        this.reference24 = value;
    }

    /**
     * Gets the value of the reference25 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference25() {
        return reference25;
    }

    /**
     * Sets the value of the reference25 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference25(JAXBElement<String> value) {
        this.reference25 = value;
    }

    /**
     * Gets the value of the reference26 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference26() {
        return reference26;
    }

    /**
     * Sets the value of the reference26 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference26(JAXBElement<String> value) {
        this.reference26 = value;
    }

    /**
     * Gets the value of the reference27 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference27() {
        return reference27;
    }

    /**
     * Sets the value of the reference27 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference27(JAXBElement<String> value) {
        this.reference27 = value;
    }

    /**
     * Gets the value of the reference28 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference28() {
        return reference28;
    }

    /**
     * Sets the value of the reference28 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference28(JAXBElement<String> value) {
        this.reference28 = value;
    }

    /**
     * Gets the value of the reference29 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference29() {
        return reference29;
    }

    /**
     * Sets the value of the reference29 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference29(JAXBElement<String> value) {
        this.reference29 = value;
    }

    /**
     * Gets the value of the reference30 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getReference30() {
        return reference30;
    }

    /**
     * Sets the value of the reference30 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setReference30(JAXBElement<String> value) {
        this.reference30 = value;
    }

    /**
     * Gets the value of the referenceDate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getReferenceDate() {
        return referenceDate;
    }

    /**
     * Sets the value of the referenceDate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setReferenceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.referenceDate = value;
    }

    /**
     * Gets the value of the attribute1 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute1() {
        return attribute1;
    }

    /**
     * Sets the value of the attribute1 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute1(JAXBElement<String> value) {
        this.attribute1 = value;
    }

    /**
     * Gets the value of the attribute2 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute2() {
        return attribute2;
    }

    /**
     * Sets the value of the attribute2 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute2(JAXBElement<String> value) {
        this.attribute2 = value;
    }

    /**
     * Gets the value of the attribute3 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute3() {
        return attribute3;
    }

    /**
     * Sets the value of the attribute3 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute3(JAXBElement<String> value) {
        this.attribute3 = value;
    }

    /**
     * Gets the value of the attribute4 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute4() {
        return attribute4;
    }

    /**
     * Sets the value of the attribute4 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute4(JAXBElement<String> value) {
        this.attribute4 = value;
    }

    /**
     * Gets the value of the attribute5 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute5() {
        return attribute5;
    }

    /**
     * Sets the value of the attribute5 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute5(JAXBElement<String> value) {
        this.attribute5 = value;
    }

    /**
     * Gets the value of the attribute6 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute6() {
        return attribute6;
    }

    /**
     * Sets the value of the attribute6 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute6(JAXBElement<String> value) {
        this.attribute6 = value;
    }

    /**
     * Gets the value of the attribute7 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute7() {
        return attribute7;
    }

    /**
     * Sets the value of the attribute7 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute7(JAXBElement<String> value) {
        this.attribute7 = value;
    }

    /**
     * Gets the value of the attribute8 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute8() {
        return attribute8;
    }

    /**
     * Sets the value of the attribute8 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute8(JAXBElement<String> value) {
        this.attribute8 = value;
    }

    /**
     * Gets the value of the attribute9 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute9() {
        return attribute9;
    }

    /**
     * Sets the value of the attribute9 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute9(JAXBElement<String> value) {
        this.attribute9 = value;
    }

    /**
     * Gets the value of the attribute10 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute10() {
        return attribute10;
    }

    /**
     * Sets the value of the attribute10 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute10(JAXBElement<String> value) {
        this.attribute10 = value;
    }

    /**
     * Gets the value of the attribute11 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute11() {
        return attribute11;
    }

    /**
     * Sets the value of the attribute11 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute11(JAXBElement<String> value) {
        this.attribute11 = value;
    }

    /**
     * Gets the value of the attribute12 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute12() {
        return attribute12;
    }

    /**
     * Sets the value of the attribute12 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute12(JAXBElement<String> value) {
        this.attribute12 = value;
    }

    /**
     * Gets the value of the attribute13 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute13() {
        return attribute13;
    }

    /**
     * Sets the value of the attribute13 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute13(JAXBElement<String> value) {
        this.attribute13 = value;
    }

    /**
     * Gets the value of the attribute14 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute14() {
        return attribute14;
    }

    /**
     * Sets the value of the attribute14 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute14(JAXBElement<String> value) {
        this.attribute14 = value;
    }

    /**
     * Gets the value of the attribute15 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute15() {
        return attribute15;
    }

    /**
     * Sets the value of the attribute15 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute15(JAXBElement<String> value) {
        this.attribute15 = value;
    }

    /**
     * Gets the value of the attribute16 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute16() {
        return attribute16;
    }

    /**
     * Sets the value of the attribute16 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute16(JAXBElement<String> value) {
        this.attribute16 = value;
    }

    /**
     * Gets the value of the attribute17 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute17() {
        return attribute17;
    }

    /**
     * Sets the value of the attribute17 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute17(JAXBElement<String> value) {
        this.attribute17 = value;
    }

    /**
     * Gets the value of the attribute18 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute18() {
        return attribute18;
    }

    /**
     * Sets the value of the attribute18 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute18(JAXBElement<String> value) {
        this.attribute18 = value;
    }

    /**
     * Gets the value of the attribute19 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute19() {
        return attribute19;
    }

    /**
     * Sets the value of the attribute19 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute19(JAXBElement<String> value) {
        this.attribute19 = value;
    }

    /**
     * Gets the value of the attribute20 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttribute20() {
        return attribute20;
    }

    /**
     * Sets the value of the attribute20 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttribute20(JAXBElement<String> value) {
        this.attribute20 = value;
    }

    /**
     * Gets the value of the attributeCategory property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttributeCategory() {
        return attributeCategory;
    }

    /**
     * Sets the value of the attributeCategory property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttributeCategory(JAXBElement<String> value) {
        this.attributeCategory = value;
    }

    /**
     * Gets the value of the attributeCategory2 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttributeCategory2() {
        return attributeCategory2;
    }

    /**
     * Sets the value of the attributeCategory2 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttributeCategory2(JAXBElement<String> value) {
        this.attributeCategory2 = value;
    }

    /**
     * Gets the value of the attributeCategory3 property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAttributeCategory3() {
        return attributeCategory3;
    }

    /**
     * Sets the value of the attributeCategory3 property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAttributeCategory3(JAXBElement<String> value) {
        this.attributeCategory3 = value;
    }

    /**
     * Gets the value of the averageJournalFlag property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public JAXBElement<Boolean> getAverageJournalFlag() {
        return averageJournalFlag;
    }

    /**
     * Sets the value of the averageJournalFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public void setAverageJournalFlag(JAXBElement<Boolean> value) {
        this.averageJournalFlag = value;
    }

    /**
     * Gets the value of the balancingSegmentValue property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getBalancingSegmentValue() {
        return balancingSegmentValue;
    }

    /**
     * Sets the value of the balancingSegmentValue property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setBalancingSegmentValue(JAXBElement<String> value) {
        this.balancingSegmentValue = value;
    }

    /**
     * Gets the value of the descrFlexErrorMessage property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getDescrFlexErrorMessage() {
        return descrFlexErrorMessage;
    }

    /**
     * Sets the value of the descrFlexErrorMessage property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setDescrFlexErrorMessage(JAXBElement<String> value) {
        this.descrFlexErrorMessage = value;
    }

    /**
     * Gets the value of the glSlLinkId property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public JAXBElement<BigDecimal> getGlSlLinkId() {
        return glSlLinkId;
    }

    /**
     * Sets the value of the glSlLinkId property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *
     */
    public void setGlSlLinkId(JAXBElement<BigDecimal> value) {
        this.glSlLinkId = value;
    }

    /**
     * Gets the value of the glSlLinkTable property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getGlSlLinkTable() {
        return glSlLinkTable;
    }

    /**
     * Sets the value of the glSlLinkTable property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setGlSlLinkTable(JAXBElement<String> value) {
        this.glSlLinkTable = value;
    }

    /**
     * Gets the value of the invoiceAmount property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *
     */
    public JAXBElement<AmountType> getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * Sets the value of the invoiceAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *
     */
    public void setInvoiceAmount(JAXBElement<AmountType> value) {
        this.invoiceAmount = value;
    }

    /**
     * Gets the value of the invoiceDate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Sets the value of the invoiceDate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.invoiceDate = value;
    }

    /**
     * Gets the value of the invoiceIdentifier property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getInvoiceIdentifier() {
        return invoiceIdentifier;
    }

    /**
     * Sets the value of the invoiceIdentifier property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setInvoiceIdentifier(JAXBElement<String> value) {
        this.invoiceIdentifier = value;
    }

    /**
     * Gets the value of the jeCategoryName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getJeCategoryName() {
        return jeCategoryName;
    }

    /**
     * Sets the value of the jeCategoryName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setJeCategoryName(JAXBElement<String> value) {
        this.jeCategoryName = value;
    }

    /**
     * Gets the value of the jeSourceName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getJeSourceName() {
        return jeSourceName;
    }

    /**
     * Sets the value of the jeSourceName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setJeSourceName(JAXBElement<String> value) {
        this.jeSourceName = value;
    }

    /**
     * Gets the value of the jgzzReconReference property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getJgzzReconReference() {
        return jgzzReconReference;
    }

    /**
     * Sets the value of the jgzzReconReference property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setJgzzReconReference(JAXBElement<String> value) {
        this.jgzzReconReference = value;
    }

    /**
     * Gets the value of the managementSegmentValue property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getManagementSegmentValue() {
        return managementSegmentValue;
    }

    /**
     * Sets the value of the managementSegmentValue property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setManagementSegmentValue(JAXBElement<String> value) {
        this.managementSegmentValue = value;
    }

    /**
     * Gets the value of the objectVersionNumber property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    /**
     * Sets the value of the objectVersionNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setObjectVersionNumber(Integer value) {
        this.objectVersionNumber = value;
    }

    /**
     * Gets the value of the originatingBalSegValue property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getOriginatingBalSegValue() {
        return originatingBalSegValue;
    }

    /**
     * Sets the value of the originatingBalSegValue property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setOriginatingBalSegValue(JAXBElement<String> value) {
        this.originatingBalSegValue = value;
    }

    /**
     * Gets the value of the setOfBooksId property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public JAXBElement<Long> getSetOfBooksId() {
        return setOfBooksId;
    }

    /**
     * Sets the value of the setOfBooksId property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public void setSetOfBooksId(JAXBElement<Long> value) {
        this.setOfBooksId = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the taxCode property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of the taxCode property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setTaxCode(JAXBElement<String> value) {
        this.taxCode = value;
    }

    /**
     * Gets the value of the transactionDate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setTransactionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the ussglTransactionCode property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getUSSGLTransactionCode() {
        return ussglTransactionCode;
    }

    /**
     * Sets the value of the ussglTransactionCode property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setUSSGLTransactionCode(JAXBElement<String> value) {
        this.ussglTransactionCode = value;
    }

    /**
     * Gets the value of the glInterfaceId property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public JAXBElement<Long> getGlInterfaceId() {
        return glInterfaceId;
    }

    /**
     * Sets the value of the glInterfaceId property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public void setGlInterfaceId(JAXBElement<Long> value) {
        this.glInterfaceId = value;
    }

    /**
     * Gets the value of the accountKFF property.
     *
     * @return
     *     possible object is
     *     {@link Account }
     *
     */
    public Account getAccountKFF() {
        return accountKFF;
    }

    /**
     * Sets the value of the accountKFF property.
     *
     * @param value
     *     allowed object is
     *     {@link Account }
     *
     */
    public void setAccountKFF(Account value) {
        this.accountKFF = value;
    }

}
