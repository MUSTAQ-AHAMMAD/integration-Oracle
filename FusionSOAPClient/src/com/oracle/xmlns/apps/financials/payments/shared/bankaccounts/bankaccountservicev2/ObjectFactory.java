
package com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ExternalBankAccount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "externalBankAccount");
    private final static QName _ExternalBankAccountOwner_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "externalBankAccountOwner");
    private final static QName _IntermediaryBankAccount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "intermediaryBankAccount");
    private final static QName _ExternalBankAccountMaskedIBAN_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "MaskedIBAN");
    private final static QName _ExternalBankAccountBranchNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BranchNumber");
    private final static QName _ExternalBankAccountBankNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankNumber");
    private final static QName _ExternalBankAccountCurrencyCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "CurrencyCode");
    private final static QName _ExternalBankAccountBAUnmaskLength_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BAUnmaskLength");
    private final static QName _ExternalBankAccountEndDateDisp_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "EndDateDisp");
    private final static QName _ExternalBankAccountExchangeRateAgreementType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "ExchangeRateAgreementType");
    private final static QName _ExternalBankAccountExternalBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "ExternalBankAccountId");
    private final static QName _ExternalBankAccountEFTSWIFTCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "EFTSWIFTCode");
    private final static QName _ExternalBankAccountStartId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "StartId");
    private final static QName _ExternalBankAccountExchangeRate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "ExchangeRate");
    private final static QName _ExternalBankAccountPaymentFactorFlag_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "PaymentFactorFlag");
    private final static QName _ExternalBankAccountDescription_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "Description");
    private final static QName _ExternalBankAccountMaskedBankAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "MaskedBankAccountNumber");
    private final static QName _ExternalBankAccountEndId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "EndId");
    private final static QName _ExternalBankAccountExchangeRateAgreementNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "ExchangeRateAgreementNumber");
    private final static QName _ExternalBankAccountHedgingContractReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "HedgingContractReference");
    private final static QName _ExternalBankAccountAccountClassification_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "AccountClassification");
    private final static QName _ExternalBankAccountBankAccountName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankAccountName");
    private final static QName _ExternalBankAccountBankAccountNumberElectronic_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankAccountNumberElectronic");
    private final static QName _ExternalBankAccountAgencyLocationCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "AgencyLocationCode");
    private final static QName _ExternalBankAccountBAMaskSetting_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BAMaskSetting");
    private final static QName _ExternalBankAccountBankAccountType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankAccountType");
    private final static QName _ExternalBankAccountBankAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankAccountNumber");
    private final static QName _ExternalBankAccountLastUpdateLogin_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "LastUpdateLogin");
    private final static QName _ExternalBankAccountBankId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankId");
    private final static QName _ExternalBankAccountBankAccountNameAlt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankAccountNameAlt");
    private final static QName _ExternalBankAccountAccountSuffix_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "AccountSuffix");
    private final static QName _ExternalBankAccountSecondaryAccountReference_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "SecondaryAccountReference");
    private final static QName _ExternalBankAccountIBAN_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "IBAN");
    private final static QName _ExternalBankAccountForeignPaymentUseFlag_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "ForeignPaymentUseFlag");
    private final static QName _ExternalBankAccountBranchId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BranchId");
    private final static QName _ExternalBankAccountShortAccountName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "ShortAccountName");
    private final static QName _ExternalBankAccountCheckDigits_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "CheckDigits");
    private final static QName _ExternalBankAccountEndDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "EndDate");
    private final static QName _IntermediaryBankAccountBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankAccountId");
    private final static QName _IntermediaryBankAccountCountryCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "CountryCode");
    private final static QName _IntermediaryBankAccountBIC_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BIC");
    private final static QName _IntermediaryBankAccountBankName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankName");
    private final static QName _IntermediaryBankAccountComments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "Comments");
    private final static QName _IntermediaryBankAccountInternalBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "InternalBankAccountId");
    private final static QName _IntermediaryBankAccountBankCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "BankCode");
    private final static QName _IntermediaryBankAccountCity_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "City");
    private final static QName _IntermediaryBankAccountAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "AccountNumber");
    private final static QName _ExternalBankAccountOwnerPartyNameAlt_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", "PartyNameAlt");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExternalBankAccount }
     * 
     */
    public ExternalBankAccount createExternalBankAccount() {
        return new ExternalBankAccount();
    }

    /**
     * Create an instance of {@link ExternalBankAccountOwner }
     * 
     */
    public ExternalBankAccountOwner createExternalBankAccountOwner() {
        return new ExternalBankAccountOwner();
    }

    /**
     * Create an instance of {@link IntermediaryBankAccount }
     * 
     */
    public IntermediaryBankAccount createIntermediaryBankAccount() {
        return new IntermediaryBankAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "externalBankAccount")
    public JAXBElement<ExternalBankAccount> createExternalBankAccount(ExternalBankAccount value) {
        return new JAXBElement<ExternalBankAccount>(_ExternalBankAccount_QNAME, ExternalBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalBankAccountOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "externalBankAccountOwner")
    public JAXBElement<ExternalBankAccountOwner> createExternalBankAccountOwner(ExternalBankAccountOwner value) {
        return new JAXBElement<ExternalBankAccountOwner>(_ExternalBankAccountOwner_QNAME, ExternalBankAccountOwner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntermediaryBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "intermediaryBankAccount")
    public JAXBElement<IntermediaryBankAccount> createIntermediaryBankAccount(IntermediaryBankAccount value) {
        return new JAXBElement<IntermediaryBankAccount>(_IntermediaryBankAccount_QNAME, IntermediaryBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "MaskedIBAN", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountMaskedIBAN(String value) {
        return new JAXBElement<String>(_ExternalBankAccountMaskedIBAN_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BranchNumber", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBranchNumber(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBranchNumber_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankNumber", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBankNumber(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBankNumber_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "CurrencyCode", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountCurrencyCode(String value) {
        return new JAXBElement<String>(_ExternalBankAccountCurrencyCode_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BAUnmaskLength", scope = ExternalBankAccount.class)
    public JAXBElement<Integer> createExternalBankAccountBAUnmaskLength(Integer value) {
        return new JAXBElement<Integer>(_ExternalBankAccountBAUnmaskLength_QNAME, Integer.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "EndDateDisp", scope = ExternalBankAccount.class)
    public JAXBElement<XMLGregorianCalendar> createExternalBankAccountEndDateDisp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ExternalBankAccountEndDateDisp_QNAME, XMLGregorianCalendar.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "ExchangeRateAgreementType", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountExchangeRateAgreementType(String value) {
        return new JAXBElement<String>(_ExternalBankAccountExchangeRateAgreementType_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "ExternalBankAccountId", scope = ExternalBankAccount.class)
    public JAXBElement<Long> createExternalBankAccountExternalBankAccountId(Long value) {
        return new JAXBElement<Long>(_ExternalBankAccountExternalBankAccountId_QNAME, Long.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "EFTSWIFTCode", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountEFTSWIFTCode(String value) {
        return new JAXBElement<String>(_ExternalBankAccountEFTSWIFTCode_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "StartId", scope = ExternalBankAccount.class)
    public JAXBElement<Long> createExternalBankAccountStartId(Long value) {
        return new JAXBElement<Long>(_ExternalBankAccountStartId_QNAME, Long.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "ExchangeRate", scope = ExternalBankAccount.class)
    public JAXBElement<BigDecimal> createExternalBankAccountExchangeRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ExternalBankAccountExchangeRate_QNAME, BigDecimal.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "PaymentFactorFlag", scope = ExternalBankAccount.class)
    public JAXBElement<Boolean> createExternalBankAccountPaymentFactorFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ExternalBankAccountPaymentFactorFlag_QNAME, Boolean.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "Description", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountDescription(String value) {
        return new JAXBElement<String>(_ExternalBankAccountDescription_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "MaskedBankAccountNumber", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountMaskedBankAccountNumber(String value) {
        return new JAXBElement<String>(_ExternalBankAccountMaskedBankAccountNumber_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "EndId", scope = ExternalBankAccount.class)
    public JAXBElement<Long> createExternalBankAccountEndId(Long value) {
        return new JAXBElement<Long>(_ExternalBankAccountEndId_QNAME, Long.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "ExchangeRateAgreementNumber", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountExchangeRateAgreementNumber(String value) {
        return new JAXBElement<String>(_ExternalBankAccountExchangeRateAgreementNumber_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "HedgingContractReference", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountHedgingContractReference(String value) {
        return new JAXBElement<String>(_ExternalBankAccountHedgingContractReference_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "AccountClassification", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountAccountClassification(String value) {
        return new JAXBElement<String>(_ExternalBankAccountAccountClassification_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankAccountName", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBankAccountName(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBankAccountName_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankAccountNumberElectronic", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBankAccountNumberElectronic(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBankAccountNumberElectronic_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "AgencyLocationCode", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountAgencyLocationCode(String value) {
        return new JAXBElement<String>(_ExternalBankAccountAgencyLocationCode_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BAMaskSetting", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBAMaskSetting(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBAMaskSetting_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankAccountType", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBankAccountType(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBankAccountType_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankAccountNumber", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBankAccountNumber(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBankAccountNumber_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "LastUpdateLogin", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountLastUpdateLogin(String value) {
        return new JAXBElement<String>(_ExternalBankAccountLastUpdateLogin_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankId", scope = ExternalBankAccount.class)
    public JAXBElement<Long> createExternalBankAccountBankId(Long value) {
        return new JAXBElement<Long>(_ExternalBankAccountBankId_QNAME, Long.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankAccountNameAlt", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountBankAccountNameAlt(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBankAccountNameAlt_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "AccountSuffix", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountAccountSuffix(String value) {
        return new JAXBElement<String>(_ExternalBankAccountAccountSuffix_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "SecondaryAccountReference", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountSecondaryAccountReference(String value) {
        return new JAXBElement<String>(_ExternalBankAccountSecondaryAccountReference_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "IBAN", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountIBAN(String value) {
        return new JAXBElement<String>(_ExternalBankAccountIBAN_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "ForeignPaymentUseFlag", scope = ExternalBankAccount.class)
    public JAXBElement<Boolean> createExternalBankAccountForeignPaymentUseFlag(Boolean value) {
        return new JAXBElement<Boolean>(_ExternalBankAccountForeignPaymentUseFlag_QNAME, Boolean.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BranchId", scope = ExternalBankAccount.class)
    public JAXBElement<Long> createExternalBankAccountBranchId(Long value) {
        return new JAXBElement<Long>(_ExternalBankAccountBranchId_QNAME, Long.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "ShortAccountName", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountShortAccountName(String value) {
        return new JAXBElement<String>(_ExternalBankAccountShortAccountName_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "CheckDigits", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountCheckDigits(String value) {
        return new JAXBElement<String>(_ExternalBankAccountCheckDigits_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "EndDate", scope = ExternalBankAccount.class)
    public JAXBElement<XMLGregorianCalendar> createExternalBankAccountEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ExternalBankAccountEndDate_QNAME, XMLGregorianCalendar.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BranchNumber", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountBranchNumber(String value) {
        return new JAXBElement<String>(_ExternalBankAccountBranchNumber_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankAccountId", scope = IntermediaryBankAccount.class)
    public JAXBElement<Long> createIntermediaryBankAccountBankAccountId(Long value) {
        return new JAXBElement<Long>(_IntermediaryBankAccountBankAccountId_QNAME, Long.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "LastUpdateLogin", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountLastUpdateLogin(String value) {
        return new JAXBElement<String>(_ExternalBankAccountLastUpdateLogin_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "CountryCode", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountCountryCode(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountCountryCode_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BIC", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountBIC(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountBIC_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankName", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountBankName(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountBankName_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "Comments", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountComments(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountComments_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "InternalBankAccountId", scope = IntermediaryBankAccount.class)
    public JAXBElement<Long> createIntermediaryBankAccountInternalBankAccountId(Long value) {
        return new JAXBElement<Long>(_IntermediaryBankAccountInternalBankAccountId_QNAME, Long.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "IBAN", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountIBAN(String value) {
        return new JAXBElement<String>(_ExternalBankAccountIBAN_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "BankCode", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountBankCode(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountBankCode_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "City", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountCity(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountCity_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "AccountNumber", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountAccountNumber(String value) {
        return new JAXBElement<String>(_IntermediaryBankAccountAccountNumber_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "CheckDigits", scope = IntermediaryBankAccount.class)
    public JAXBElement<String> createIntermediaryBankAccountCheckDigits(String value) {
        return new JAXBElement<String>(_ExternalBankAccountCheckDigits_QNAME, String.class, IntermediaryBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "PartyNameAlt", scope = ExternalBankAccountOwner.class)
    public JAXBElement<String> createExternalBankAccountOwnerPartyNameAlt(String value) {
        return new JAXBElement<String>(_ExternalBankAccountOwnerPartyNameAlt_QNAME, String.class, ExternalBankAccountOwner.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "EndDateDisp", scope = ExternalBankAccountOwner.class)
    public JAXBElement<XMLGregorianCalendar> createExternalBankAccountOwnerEndDateDisp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ExternalBankAccountEndDateDisp_QNAME, XMLGregorianCalendar.class, ExternalBankAccountOwner.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "LastUpdateLogin", scope = ExternalBankAccountOwner.class)
    public JAXBElement<String> createExternalBankAccountOwnerLastUpdateLogin(String value) {
        return new JAXBElement<String>(_ExternalBankAccountLastUpdateLogin_QNAME, String.class, ExternalBankAccountOwner.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", name = "EndDate", scope = ExternalBankAccountOwner.class)
    public JAXBElement<XMLGregorianCalendar> createExternalBankAccountOwnerEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ExternalBankAccountEndDate_QNAME, XMLGregorianCalendar.class, ExternalBankAccountOwner.class, value);
    }

}
