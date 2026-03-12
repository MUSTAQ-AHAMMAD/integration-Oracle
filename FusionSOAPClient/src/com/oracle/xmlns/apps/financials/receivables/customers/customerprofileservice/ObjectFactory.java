
package com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice package. 
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

    private final static QName _CustomerProfile_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "customerProfile");
    private final static QName _CustomerProfileResult_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "customerProfileResult");
    private final static QName _CustomerProfileAutoReceiptsIncludeDisputedItems_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "AutoReceiptsIncludeDisputedItems");
    private final static QName _CustomerProfileCreditHold_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditHold");
    private final static QName _CustomerProfileOverrideTerms_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "OverrideTerms");
    private final static QName _CustomerProfileBillLevel_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "BillLevel");
    private final static QName _CustomerProfileRiskCodeValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "RiskCodeValue");
    private final static QName _CustomerProfileCreditReviewCycleName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditReviewCycleName");
    private final static QName _CustomerProfileClearingDays_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "ClearingDays");
    private final static QName _CustomerProfilePreferredDeliveryMethod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "PreferredDeliveryMethod");
    private final static QName _CustomerProfilePreferredContactMethod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "PreferredContactMethod");
    private final static QName _CustomerProfileCollectorName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CollectorName");
    private final static QName _CustomerProfileCreditRatingValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditRatingValue");
    private final static QName _CustomerProfilePercentCollectable_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "PercentCollectable");
    private final static QName _CustomerProfileMatchByAutoupdate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "MatchByAutoupdate");
    private final static QName _CustomerProfileAutoMatchRuleSet_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "AutoMatchRuleSet");
    private final static QName _CustomerProfileStatementDeliveryMethod_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "StatementDeliveryMethod");
    private final static QName _CustomerProfileNextCreditReviewDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "NextCreditReviewDate");
    private final static QName _CustomerProfilePaymentTerms_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "PaymentTerms");
    private final static QName _CustomerProfileGroupingRule_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "GroupingRule");
    private final static QName _CustomerProfileConversionRateType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "ConversionRateType");
    private final static QName _CustomerProfileGenerateBill_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "GenerateBill");
    private final static QName _CustomerProfileCreditCurrencyCode_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditCurrencyCode");
    private final static QName _CustomerProfileProfileClassName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "ProfileClassName");
    private final static QName _CustomerProfileCustomerAccountProfileId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CustomerAccountProfileId");
    private final static QName _CustomerProfileMatchReceiptsBy_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "MatchReceiptsBy");
    private final static QName _CustomerProfileDiscountTerms_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "DiscountTerms");
    private final static QName _CustomerProfileConsolidatedInvoice_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "ConsolidatedInvoice");
    private final static QName _CustomerProfileCreditChecking_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditChecking");
    private final static QName _CustomerProfileCreditClassificationValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditClassificationValue");
    private final static QName _CustomerProfileDiscountGraceDays_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "DiscountGraceDays");
    private final static QName _CustomerProfileCreditBalanceStatements_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditBalanceStatements");
    private final static QName _CustomerProfileEffectiveStartDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "EffectiveStartDate");
    private final static QName _CustomerProfileApplicationExceptionRuleSet_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "ApplicationExceptionRuleSet");
    private final static QName _CustomerProfileAutoCashRuleSet_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "AutoCashRuleSet");
    private final static QName _CustomerProfileAccountStatusValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "AccountStatusValue");
    private final static QName _CustomerProfileOrderAmountLimit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "OrderAmountLimit");
    private final static QName _CustomerProfileBillType_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "BillType");
    private final static QName _CustomerProfileCreditLimit_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditLimit");
    private final static QName _CustomerProfileLastCreditReviewDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "LastCreditReviewDate");
    private final static QName _CustomerProfileReminderRuleSet_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "ReminderRuleSet");
    private final static QName _CustomerProfileEffectiveEndDate_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "EffectiveEndDate");
    private final static QName _CustomerProfileStatementCycle_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "StatementCycle");
    private final static QName _CustomerProfileCreditAnalystName_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "CreditAnalystName");
    private final static QName _CustomerProfileSendStatements_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "SendStatements");
    private final static QName _CustomerProfileTolerance_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "Tolerance");
    private final static QName _CustomerProfileAccountNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "AccountNumber");
    private final static QName _CustomerProfileDunningLetters_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "DunningLetters");
    private final static QName _CustomerProfileSiteNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", "SiteNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerProfileResult }
     * 
     */
    public CustomerProfileResult createCustomerProfileResult() {
        return new CustomerProfileResult();
    }

    /**
     * Create an instance of {@link CustomerProfile }
     * 
     */
    public CustomerProfile createCustomerProfile() {
        return new CustomerProfile();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "customerProfile")
    public JAXBElement<CustomerProfile> createCustomerProfile(CustomerProfile value) {
        return new JAXBElement<CustomerProfile>(_CustomerProfile_QNAME, CustomerProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerProfileResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "customerProfileResult")
    public JAXBElement<CustomerProfileResult> createCustomerProfileResult(CustomerProfileResult value) {
        return new JAXBElement<CustomerProfileResult>(_CustomerProfileResult_QNAME, CustomerProfileResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "AutoReceiptsIncludeDisputedItems", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileAutoReceiptsIncludeDisputedItems(String value) {
        return new JAXBElement<String>(_CustomerProfileAutoReceiptsIncludeDisputedItems_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditHold", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditHold(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditHold_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "OverrideTerms", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileOverrideTerms(String value) {
        return new JAXBElement<String>(_CustomerProfileOverrideTerms_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "BillLevel", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileBillLevel(String value) {
        return new JAXBElement<String>(_CustomerProfileBillLevel_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "RiskCodeValue", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileRiskCodeValue(String value) {
        return new JAXBElement<String>(_CustomerProfileRiskCodeValue_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditReviewCycleName", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditReviewCycleName(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditReviewCycleName_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "ClearingDays", scope = CustomerProfile.class)
    public JAXBElement<Integer> createCustomerProfileClearingDays(Integer value) {
        return new JAXBElement<Integer>(_CustomerProfileClearingDays_QNAME, Integer.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "PreferredDeliveryMethod", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfilePreferredDeliveryMethod(String value) {
        return new JAXBElement<String>(_CustomerProfilePreferredDeliveryMethod_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "PreferredContactMethod", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfilePreferredContactMethod(String value) {
        return new JAXBElement<String>(_CustomerProfilePreferredContactMethod_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CollectorName", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCollectorName(String value) {
        return new JAXBElement<String>(_CustomerProfileCollectorName_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditRatingValue", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditRatingValue(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditRatingValue_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "PercentCollectable", scope = CustomerProfile.class)
    public JAXBElement<BigDecimal> createCustomerProfilePercentCollectable(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CustomerProfilePercentCollectable_QNAME, BigDecimal.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "MatchByAutoupdate", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileMatchByAutoupdate(String value) {
        return new JAXBElement<String>(_CustomerProfileMatchByAutoupdate_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "AutoMatchRuleSet", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileAutoMatchRuleSet(String value) {
        return new JAXBElement<String>(_CustomerProfileAutoMatchRuleSet_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "StatementDeliveryMethod", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileStatementDeliveryMethod(String value) {
        return new JAXBElement<String>(_CustomerProfileStatementDeliveryMethod_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "NextCreditReviewDate", scope = CustomerProfile.class)
    public JAXBElement<XMLGregorianCalendar> createCustomerProfileNextCreditReviewDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CustomerProfileNextCreditReviewDate_QNAME, XMLGregorianCalendar.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "PaymentTerms", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfilePaymentTerms(String value) {
        return new JAXBElement<String>(_CustomerProfilePaymentTerms_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "GroupingRule", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileGroupingRule(String value) {
        return new JAXBElement<String>(_CustomerProfileGroupingRule_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "ConversionRateType", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileConversionRateType(String value) {
        return new JAXBElement<String>(_CustomerProfileConversionRateType_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "GenerateBill", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileGenerateBill(String value) {
        return new JAXBElement<String>(_CustomerProfileGenerateBill_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditCurrencyCode", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditCurrencyCode(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditCurrencyCode_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "ProfileClassName", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileProfileClassName(String value) {
        return new JAXBElement<String>(_CustomerProfileProfileClassName_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CustomerAccountProfileId", scope = CustomerProfile.class)
    public JAXBElement<Long> createCustomerProfileCustomerAccountProfileId(Long value) {
        return new JAXBElement<Long>(_CustomerProfileCustomerAccountProfileId_QNAME, Long.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "MatchReceiptsBy", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileMatchReceiptsBy(String value) {
        return new JAXBElement<String>(_CustomerProfileMatchReceiptsBy_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "DiscountTerms", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileDiscountTerms(String value) {
        return new JAXBElement<String>(_CustomerProfileDiscountTerms_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "ConsolidatedInvoice", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileConsolidatedInvoice(String value) {
        return new JAXBElement<String>(_CustomerProfileConsolidatedInvoice_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditChecking", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditChecking(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditChecking_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditClassificationValue", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditClassificationValue(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditClassificationValue_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "DiscountGraceDays", scope = CustomerProfile.class)
    public JAXBElement<Integer> createCustomerProfileDiscountGraceDays(Integer value) {
        return new JAXBElement<Integer>(_CustomerProfileDiscountGraceDays_QNAME, Integer.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditBalanceStatements", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditBalanceStatements(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditBalanceStatements_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "EffectiveStartDate", scope = CustomerProfile.class)
    public JAXBElement<XMLGregorianCalendar> createCustomerProfileEffectiveStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CustomerProfileEffectiveStartDate_QNAME, XMLGregorianCalendar.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "ApplicationExceptionRuleSet", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileApplicationExceptionRuleSet(String value) {
        return new JAXBElement<String>(_CustomerProfileApplicationExceptionRuleSet_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "AutoCashRuleSet", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileAutoCashRuleSet(String value) {
        return new JAXBElement<String>(_CustomerProfileAutoCashRuleSet_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "AccountStatusValue", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileAccountStatusValue(String value) {
        return new JAXBElement<String>(_CustomerProfileAccountStatusValue_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "OrderAmountLimit", scope = CustomerProfile.class)
    public JAXBElement<BigDecimal> createCustomerProfileOrderAmountLimit(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CustomerProfileOrderAmountLimit_QNAME, BigDecimal.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "BillType", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileBillType(String value) {
        return new JAXBElement<String>(_CustomerProfileBillType_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditLimit", scope = CustomerProfile.class)
    public JAXBElement<BigDecimal> createCustomerProfileCreditLimit(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CustomerProfileCreditLimit_QNAME, BigDecimal.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "LastCreditReviewDate", scope = CustomerProfile.class)
    public JAXBElement<XMLGregorianCalendar> createCustomerProfileLastCreditReviewDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CustomerProfileLastCreditReviewDate_QNAME, XMLGregorianCalendar.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "ReminderRuleSet", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileReminderRuleSet(String value) {
        return new JAXBElement<String>(_CustomerProfileReminderRuleSet_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "EffectiveEndDate", scope = CustomerProfile.class)
    public JAXBElement<XMLGregorianCalendar> createCustomerProfileEffectiveEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CustomerProfileEffectiveEndDate_QNAME, XMLGregorianCalendar.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "StatementCycle", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileStatementCycle(String value) {
        return new JAXBElement<String>(_CustomerProfileStatementCycle_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "CreditAnalystName", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileCreditAnalystName(String value) {
        return new JAXBElement<String>(_CustomerProfileCreditAnalystName_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "SendStatements", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileSendStatements(String value) {
        return new JAXBElement<String>(_CustomerProfileSendStatements_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "Tolerance", scope = CustomerProfile.class)
    public JAXBElement<BigDecimal> createCustomerProfileTolerance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CustomerProfileTolerance_QNAME, BigDecimal.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "AccountNumber", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileAccountNumber(String value) {
        return new JAXBElement<String>(_CustomerProfileAccountNumber_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "DunningLetters", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileDunningLetters(String value) {
        return new JAXBElement<String>(_CustomerProfileDunningLetters_QNAME, String.class, CustomerProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", name = "SiteNumber", scope = CustomerProfile.class)
    public JAXBElement<String> createCustomerProfileSiteNumber(String value) {
        return new JAXBElement<String>(_CustomerProfileSiteNumber_QNAME, String.class, CustomerProfile.class, value);
    }

}
