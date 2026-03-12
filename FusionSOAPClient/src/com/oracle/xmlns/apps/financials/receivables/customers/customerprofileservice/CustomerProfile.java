
package com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofiledff.CustomerProfileFLEX;
import com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofilegdf.CustomerProfileGdf;


/**
 * <p>Java class for CustomerProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProfileClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClearingDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CreditBalanceStatements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditChecking" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditHold" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerAccountProfileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DiscountGraceDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DiscountTerms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DunningLetters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffectiveEndDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="EffectiveStartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="LastCreditReviewDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="NextCreditReviewDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="OverrideTerms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PercentCollectable" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SendStatements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Tolerance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CollectorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConversionRateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentTerms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoCashRuleSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicationExceptionRuleSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoMatchRuleSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReminderRuleSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatementCycle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupingRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditClassificationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountStatusValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RiskCodeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditRatingValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MatchReceiptsBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreferredContactMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreferredDeliveryMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GenerateBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MatchByAutoupdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoReceiptsIncludeDisputedItems" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsolidatedInvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditReviewCycleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditAnalystName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CreditCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatementDeliveryMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderAmountLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CustomerProfileFLEX" type="{http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/}CustomerProfileFLEX" minOccurs="0"/>
 *         &lt;element name="CustomerProfileGdf" type="{http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/}CustomerProfileGdf" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerProfile", propOrder = {
    "accountNumber",
    "siteNumber",
    "profileClassName",
    "clearingDays",
    "creditBalanceStatements",
    "creditChecking",
    "creditHold",
    "customerAccountProfileId",
    "discountGraceDays",
    "discountTerms",
    "dunningLetters",
    "effectiveEndDate",
    "effectiveStartDate",
    "lastCreditReviewDate",
    "nextCreditReviewDate",
    "overrideTerms",
    "partyId",
    "percentCollectable",
    "sendStatements",
    "customerAccountId",
    "tolerance",
    "collectorName",
    "conversionRateType",
    "paymentTerms",
    "autoCashRuleSet",
    "applicationExceptionRuleSet",
    "autoMatchRuleSet",
    "reminderRuleSet",
    "statementCycle",
    "groupingRule",
    "creditClassificationValue",
    "accountStatusValue",
    "riskCodeValue",
    "creditRatingValue",
    "billLevel",
    "billType",
    "matchReceiptsBy",
    "preferredContactMethod",
    "preferredDeliveryMethod",
    "generateBill",
    "matchByAutoupdate",
    "autoReceiptsIncludeDisputedItems",
    "consolidatedInvoice",
    "creditReviewCycleName",
    "creditAnalystName",
    "creditLimit",
    "creditCurrencyCode",
    "statementDeliveryMethod",
    "orderAmountLimit",
    "customerProfileFLEX",
    "customerProfileGdf"
})
public class CustomerProfile {

    @XmlElementRef(name = "AccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountNumber;
    @XmlElementRef(name = "SiteNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> siteNumber;
    @XmlElementRef(name = "ProfileClassName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profileClassName;
    @XmlElementRef(name = "ClearingDays", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> clearingDays;
    @XmlElementRef(name = "CreditBalanceStatements", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditBalanceStatements;
    @XmlElementRef(name = "CreditChecking", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditChecking;
    @XmlElementRef(name = "CreditHold", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditHold;
    @XmlElementRef(name = "CustomerAccountProfileId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> customerAccountProfileId;
    @XmlElementRef(name = "DiscountGraceDays", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> discountGraceDays;
    @XmlElementRef(name = "DiscountTerms", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> discountTerms;
    @XmlElementRef(name = "DunningLetters", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dunningLetters;
    @XmlElementRef(name = "EffectiveEndDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> effectiveEndDate;
    @XmlElementRef(name = "EffectiveStartDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> effectiveStartDate;
    @XmlElementRef(name = "LastCreditReviewDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> lastCreditReviewDate;
    @XmlElementRef(name = "NextCreditReviewDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> nextCreditReviewDate;
    @XmlElementRef(name = "OverrideTerms", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> overrideTerms;
    @XmlElement(name = "PartyId")
    protected Long partyId;
    @XmlElementRef(name = "PercentCollectable", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> percentCollectable;
    @XmlElementRef(name = "SendStatements", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sendStatements;
    @XmlElement(name = "CustomerAccountId")
    protected Long customerAccountId;
    @XmlElementRef(name = "Tolerance", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> tolerance;
    @XmlElementRef(name = "CollectorName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> collectorName;
    @XmlElementRef(name = "ConversionRateType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> conversionRateType;
    @XmlElementRef(name = "PaymentTerms", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentTerms;
    @XmlElementRef(name = "AutoCashRuleSet", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> autoCashRuleSet;
    @XmlElementRef(name = "ApplicationExceptionRuleSet", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicationExceptionRuleSet;
    @XmlElementRef(name = "AutoMatchRuleSet", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> autoMatchRuleSet;
    @XmlElementRef(name = "ReminderRuleSet", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reminderRuleSet;
    @XmlElementRef(name = "StatementCycle", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statementCycle;
    @XmlElementRef(name = "GroupingRule", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> groupingRule;
    @XmlElementRef(name = "CreditClassificationValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditClassificationValue;
    @XmlElementRef(name = "AccountStatusValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountStatusValue;
    @XmlElementRef(name = "RiskCodeValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> riskCodeValue;
    @XmlElementRef(name = "CreditRatingValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditRatingValue;
    @XmlElementRef(name = "BillLevel", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billLevel;
    @XmlElementRef(name = "BillType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> billType;
    @XmlElementRef(name = "MatchReceiptsBy", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> matchReceiptsBy;
    @XmlElementRef(name = "PreferredContactMethod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> preferredContactMethod;
    @XmlElementRef(name = "PreferredDeliveryMethod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> preferredDeliveryMethod;
    @XmlElementRef(name = "GenerateBill", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> generateBill;
    @XmlElementRef(name = "MatchByAutoupdate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> matchByAutoupdate;
    @XmlElementRef(name = "AutoReceiptsIncludeDisputedItems", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> autoReceiptsIncludeDisputedItems;
    @XmlElementRef(name = "ConsolidatedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consolidatedInvoice;
    @XmlElementRef(name = "CreditReviewCycleName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditReviewCycleName;
    @XmlElementRef(name = "CreditAnalystName", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditAnalystName;
    @XmlElementRef(name = "CreditLimit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> creditLimit;
    @XmlElementRef(name = "CreditCurrencyCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditCurrencyCode;
    @XmlElementRef(name = "StatementDeliveryMethod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> statementDeliveryMethod;
    @XmlElementRef(name = "OrderAmountLimit", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customers/customerProfileService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> orderAmountLimit;
    @XmlElement(name = "CustomerProfileFLEX")
    protected CustomerProfileFLEX customerProfileFLEX;
    @XmlElement(name = "CustomerProfileGdf")
    protected List<CustomerProfileGdf> customerProfileGdf;

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountNumber(JAXBElement<String> value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the siteNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSiteNumber() {
        return siteNumber;
    }

    /**
     * Sets the value of the siteNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSiteNumber(JAXBElement<String> value) {
        this.siteNumber = value;
    }

    /**
     * Gets the value of the profileClassName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfileClassName() {
        return profileClassName;
    }

    /**
     * Sets the value of the profileClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfileClassName(JAXBElement<String> value) {
        this.profileClassName = value;
    }

    /**
     * Gets the value of the clearingDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getClearingDays() {
        return clearingDays;
    }

    /**
     * Sets the value of the clearingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setClearingDays(JAXBElement<Integer> value) {
        this.clearingDays = value;
    }

    /**
     * Gets the value of the creditBalanceStatements property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditBalanceStatements() {
        return creditBalanceStatements;
    }

    /**
     * Sets the value of the creditBalanceStatements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditBalanceStatements(JAXBElement<String> value) {
        this.creditBalanceStatements = value;
    }

    /**
     * Gets the value of the creditChecking property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditChecking() {
        return creditChecking;
    }

    /**
     * Sets the value of the creditChecking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditChecking(JAXBElement<String> value) {
        this.creditChecking = value;
    }

    /**
     * Gets the value of the creditHold property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditHold() {
        return creditHold;
    }

    /**
     * Sets the value of the creditHold property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditHold(JAXBElement<String> value) {
        this.creditHold = value;
    }

    /**
     * Gets the value of the customerAccountProfileId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCustomerAccountProfileId() {
        return customerAccountProfileId;
    }

    /**
     * Sets the value of the customerAccountProfileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCustomerAccountProfileId(JAXBElement<Long> value) {
        this.customerAccountProfileId = value;
    }

    /**
     * Gets the value of the discountGraceDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDiscountGraceDays() {
        return discountGraceDays;
    }

    /**
     * Sets the value of the discountGraceDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDiscountGraceDays(JAXBElement<Integer> value) {
        this.discountGraceDays = value;
    }

    /**
     * Gets the value of the discountTerms property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDiscountTerms() {
        return discountTerms;
    }

    /**
     * Sets the value of the discountTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDiscountTerms(JAXBElement<String> value) {
        this.discountTerms = value;
    }

    /**
     * Gets the value of the dunningLetters property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDunningLetters() {
        return dunningLetters;
    }

    /**
     * Sets the value of the dunningLetters property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDunningLetters(JAXBElement<String> value) {
        this.dunningLetters = value;
    }

    /**
     * Gets the value of the effectiveEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEffectiveEndDate() {
        return effectiveEndDate;
    }

    /**
     * Sets the value of the effectiveEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEffectiveEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.effectiveEndDate = value;
    }

    /**
     * Gets the value of the effectiveStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEffectiveStartDate() {
        return effectiveStartDate;
    }

    /**
     * Sets the value of the effectiveStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEffectiveStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.effectiveStartDate = value;
    }

    /**
     * Gets the value of the lastCreditReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastCreditReviewDate() {
        return lastCreditReviewDate;
    }

    /**
     * Sets the value of the lastCreditReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastCreditReviewDate(JAXBElement<XMLGregorianCalendar> value) {
        this.lastCreditReviewDate = value;
    }

    /**
     * Gets the value of the nextCreditReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getNextCreditReviewDate() {
        return nextCreditReviewDate;
    }

    /**
     * Sets the value of the nextCreditReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setNextCreditReviewDate(JAXBElement<XMLGregorianCalendar> value) {
        this.nextCreditReviewDate = value;
    }

    /**
     * Gets the value of the overrideTerms property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOverrideTerms() {
        return overrideTerms;
    }

    /**
     * Sets the value of the overrideTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOverrideTerms(JAXBElement<String> value) {
        this.overrideTerms = value;
    }

    /**
     * Gets the value of the partyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartyId() {
        return partyId;
    }

    /**
     * Sets the value of the partyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartyId(Long value) {
        this.partyId = value;
    }

    /**
     * Gets the value of the percentCollectable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPercentCollectable() {
        return percentCollectable;
    }

    /**
     * Sets the value of the percentCollectable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPercentCollectable(JAXBElement<BigDecimal> value) {
        this.percentCollectable = value;
    }

    /**
     * Gets the value of the sendStatements property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSendStatements() {
        return sendStatements;
    }

    /**
     * Sets the value of the sendStatements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSendStatements(JAXBElement<String> value) {
        this.sendStatements = value;
    }

    /**
     * Gets the value of the customerAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerAccountId() {
        return customerAccountId;
    }

    /**
     * Sets the value of the customerAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerAccountId(Long value) {
        this.customerAccountId = value;
    }

    /**
     * Gets the value of the tolerance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTolerance() {
        return tolerance;
    }

    /**
     * Sets the value of the tolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTolerance(JAXBElement<BigDecimal> value) {
        this.tolerance = value;
    }

    /**
     * Gets the value of the collectorName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCollectorName() {
        return collectorName;
    }

    /**
     * Sets the value of the collectorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCollectorName(JAXBElement<String> value) {
        this.collectorName = value;
    }

    /**
     * Gets the value of the conversionRateType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConversionRateType() {
        return conversionRateType;
    }

    /**
     * Sets the value of the conversionRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConversionRateType(JAXBElement<String> value) {
        this.conversionRateType = value;
    }

    /**
     * Gets the value of the paymentTerms property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Sets the value of the paymentTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTerms(JAXBElement<String> value) {
        this.paymentTerms = value;
    }

    /**
     * Gets the value of the autoCashRuleSet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAutoCashRuleSet() {
        return autoCashRuleSet;
    }

    /**
     * Sets the value of the autoCashRuleSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAutoCashRuleSet(JAXBElement<String> value) {
        this.autoCashRuleSet = value;
    }

    /**
     * Gets the value of the applicationExceptionRuleSet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplicationExceptionRuleSet() {
        return applicationExceptionRuleSet;
    }

    /**
     * Sets the value of the applicationExceptionRuleSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplicationExceptionRuleSet(JAXBElement<String> value) {
        this.applicationExceptionRuleSet = value;
    }

    /**
     * Gets the value of the autoMatchRuleSet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAutoMatchRuleSet() {
        return autoMatchRuleSet;
    }

    /**
     * Sets the value of the autoMatchRuleSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAutoMatchRuleSet(JAXBElement<String> value) {
        this.autoMatchRuleSet = value;
    }

    /**
     * Gets the value of the reminderRuleSet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReminderRuleSet() {
        return reminderRuleSet;
    }

    /**
     * Sets the value of the reminderRuleSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReminderRuleSet(JAXBElement<String> value) {
        this.reminderRuleSet = value;
    }

    /**
     * Gets the value of the statementCycle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatementCycle() {
        return statementCycle;
    }

    /**
     * Sets the value of the statementCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatementCycle(JAXBElement<String> value) {
        this.statementCycle = value;
    }

    /**
     * Gets the value of the groupingRule property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGroupingRule() {
        return groupingRule;
    }

    /**
     * Sets the value of the groupingRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGroupingRule(JAXBElement<String> value) {
        this.groupingRule = value;
    }

    /**
     * Gets the value of the creditClassificationValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditClassificationValue() {
        return creditClassificationValue;
    }

    /**
     * Sets the value of the creditClassificationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditClassificationValue(JAXBElement<String> value) {
        this.creditClassificationValue = value;
    }

    /**
     * Gets the value of the accountStatusValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountStatusValue() {
        return accountStatusValue;
    }

    /**
     * Sets the value of the accountStatusValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountStatusValue(JAXBElement<String> value) {
        this.accountStatusValue = value;
    }

    /**
     * Gets the value of the riskCodeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRiskCodeValue() {
        return riskCodeValue;
    }

    /**
     * Sets the value of the riskCodeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRiskCodeValue(JAXBElement<String> value) {
        this.riskCodeValue = value;
    }

    /**
     * Gets the value of the creditRatingValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditRatingValue() {
        return creditRatingValue;
    }

    /**
     * Sets the value of the creditRatingValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditRatingValue(JAXBElement<String> value) {
        this.creditRatingValue = value;
    }

    /**
     * Gets the value of the billLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillLevel() {
        return billLevel;
    }

    /**
     * Sets the value of the billLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillLevel(JAXBElement<String> value) {
        this.billLevel = value;
    }

    /**
     * Gets the value of the billType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillType() {
        return billType;
    }

    /**
     * Sets the value of the billType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillType(JAXBElement<String> value) {
        this.billType = value;
    }

    /**
     * Gets the value of the matchReceiptsBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMatchReceiptsBy() {
        return matchReceiptsBy;
    }

    /**
     * Sets the value of the matchReceiptsBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMatchReceiptsBy(JAXBElement<String> value) {
        this.matchReceiptsBy = value;
    }

    /**
     * Gets the value of the preferredContactMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreferredContactMethod() {
        return preferredContactMethod;
    }

    /**
     * Sets the value of the preferredContactMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreferredContactMethod(JAXBElement<String> value) {
        this.preferredContactMethod = value;
    }

    /**
     * Gets the value of the preferredDeliveryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreferredDeliveryMethod() {
        return preferredDeliveryMethod;
    }

    /**
     * Sets the value of the preferredDeliveryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreferredDeliveryMethod(JAXBElement<String> value) {
        this.preferredDeliveryMethod = value;
    }

    /**
     * Gets the value of the generateBill property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGenerateBill() {
        return generateBill;
    }

    /**
     * Sets the value of the generateBill property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGenerateBill(JAXBElement<String> value) {
        this.generateBill = value;
    }

    /**
     * Gets the value of the matchByAutoupdate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMatchByAutoupdate() {
        return matchByAutoupdate;
    }

    /**
     * Sets the value of the matchByAutoupdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMatchByAutoupdate(JAXBElement<String> value) {
        this.matchByAutoupdate = value;
    }

    /**
     * Gets the value of the autoReceiptsIncludeDisputedItems property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAutoReceiptsIncludeDisputedItems() {
        return autoReceiptsIncludeDisputedItems;
    }

    /**
     * Sets the value of the autoReceiptsIncludeDisputedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAutoReceiptsIncludeDisputedItems(JAXBElement<String> value) {
        this.autoReceiptsIncludeDisputedItems = value;
    }

    /**
     * Gets the value of the consolidatedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsolidatedInvoice() {
        return consolidatedInvoice;
    }

    /**
     * Sets the value of the consolidatedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsolidatedInvoice(JAXBElement<String> value) {
        this.consolidatedInvoice = value;
    }

    /**
     * Gets the value of the creditReviewCycleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditReviewCycleName() {
        return creditReviewCycleName;
    }

    /**
     * Sets the value of the creditReviewCycleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditReviewCycleName(JAXBElement<String> value) {
        this.creditReviewCycleName = value;
    }

    /**
     * Gets the value of the creditAnalystName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditAnalystName() {
        return creditAnalystName;
    }

    /**
     * Sets the value of the creditAnalystName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditAnalystName(JAXBElement<String> value) {
        this.creditAnalystName = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCreditLimit(JAXBElement<BigDecimal> value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the creditCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditCurrencyCode() {
        return creditCurrencyCode;
    }

    /**
     * Sets the value of the creditCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditCurrencyCode(JAXBElement<String> value) {
        this.creditCurrencyCode = value;
    }

    /**
     * Gets the value of the statementDeliveryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatementDeliveryMethod() {
        return statementDeliveryMethod;
    }

    /**
     * Sets the value of the statementDeliveryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatementDeliveryMethod(JAXBElement<String> value) {
        this.statementDeliveryMethod = value;
    }

    /**
     * Gets the value of the orderAmountLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOrderAmountLimit() {
        return orderAmountLimit;
    }

    /**
     * Sets the value of the orderAmountLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOrderAmountLimit(JAXBElement<BigDecimal> value) {
        this.orderAmountLimit = value;
    }

    /**
     * Gets the value of the customerProfileFLEX property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerProfileFLEX }
     *     
     */
    public CustomerProfileFLEX getCustomerProfileFLEX() {
        return customerProfileFLEX;
    }

    /**
     * Sets the value of the customerProfileFLEX property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerProfileFLEX }
     *     
     */
    public void setCustomerProfileFLEX(CustomerProfileFLEX value) {
        this.customerProfileFLEX = value;
    }

    /**
     * Gets the value of the customerProfileGdf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerProfileGdf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerProfileGdf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerProfileGdf }
     * 
     * 
     */
    public List<CustomerProfileGdf> getCustomerProfileGdf() {
        if (customerProfileGdf == null) {
            customerProfileGdf = new ArrayList<CustomerProfileGdf>();
        }
        return this.customerProfileGdf;
    }

}
