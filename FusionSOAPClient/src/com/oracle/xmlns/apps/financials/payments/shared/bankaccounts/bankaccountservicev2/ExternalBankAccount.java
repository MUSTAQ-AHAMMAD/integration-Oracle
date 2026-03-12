
package com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ExternalBankAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalBankAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExternalBankAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerritoryShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BankBranchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BankAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaskedBankAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BAMaskSetting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BAUnmaskLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaskedIBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckDigits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountClassification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentFactorFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ForeignPaymentUseFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ExchangeRateAgreementNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRateAgreementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="HedgingContractReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecondaryAccountReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="CreatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastUpdateDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdateLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObjectVersionNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BankAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountNameAlt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShortAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountNumberElectronic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankPartyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BranchPartyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BranchNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EFTSWIFTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EndDateDisp" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="EndId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TerritoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalBankAccountOwner" type="{http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/}ExternalBankAccountOwner" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IntermediaryBankAccount" type="{http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/}IntermediaryBankAccount" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExtBankAcctDffVLA" type="{http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/}ExternalBankAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalBankAccount", propOrder = {
    "externalBankAccountId",
    "countryCode",
    "territoryShortName",
    "bankName",
    "bankId",
    "bankBranchName",
    "branchId",
    "bankAccountNumber",
    "maskedBankAccountNumber",
    "baMaskSetting",
    "baUnmaskLength",
    "currencyCode",
    "iban",
    "maskedIBAN",
    "checkDigits",
    "bankAccountType",
    "accountClassification",
    "accountSuffix",
    "agencyLocationCode",
    "paymentFactorFlag",
    "foreignPaymentUseFlag",
    "exchangeRateAgreementNumber",
    "exchangeRateAgreementType",
    "exchangeRate",
    "hedgingContractReference",
    "secondaryAccountReference",
    "startDate",
    "endDate",
    "createdBy",
    "creationDate",
    "lastUpdatedBy",
    "lastUpdateDate",
    "lastUpdateLogin",
    "objectVersionNumber",
    "bankAccountName",
    "bankAccountNameAlt",
    "shortAccountName",
    "description",
    "bankAccountNumberElectronic",
    "bankPartyId",
    "branchPartyId",
    "branchNumber",
    "eftswiftCode",
    "endDateDisp",
    "name",
    "startId",
    "endId",
    "territoryCode",
    "bankNumber",
    "externalBankAccountOwner",
    "intermediaryBankAccount",
    "extBankAcctDffVLA"
})
public class ExternalBankAccount {

    @XmlElementRef(name = "ExternalBankAccountId", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> externalBankAccountId;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "TerritoryShortName")
    protected String territoryShortName;
    @XmlElement(name = "BankName")
    protected String bankName;
    @XmlElementRef(name = "BankId", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> bankId;
    @XmlElement(name = "BankBranchName")
    protected String bankBranchName;
    @XmlElementRef(name = "BranchId", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> branchId;
    @XmlElementRef(name = "BankAccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankAccountNumber;
    @XmlElementRef(name = "MaskedBankAccountNumber", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> maskedBankAccountNumber;
    @XmlElementRef(name = "BAMaskSetting", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baMaskSetting;
    @XmlElementRef(name = "BAUnmaskLength", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> baUnmaskLength;
    @XmlElementRef(name = "CurrencyCode", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currencyCode;
    @XmlElementRef(name = "IBAN", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> iban;
    @XmlElementRef(name = "MaskedIBAN", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> maskedIBAN;
    @XmlElementRef(name = "CheckDigits", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> checkDigits;
    @XmlElementRef(name = "BankAccountType", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankAccountType;
    @XmlElementRef(name = "AccountClassification", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountClassification;
    @XmlElementRef(name = "AccountSuffix", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountSuffix;
    @XmlElementRef(name = "AgencyLocationCode", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> agencyLocationCode;
    @XmlElementRef(name = "PaymentFactorFlag", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> paymentFactorFlag;
    @XmlElementRef(name = "ForeignPaymentUseFlag", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> foreignPaymentUseFlag;
    @XmlElementRef(name = "ExchangeRateAgreementNumber", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateAgreementNumber;
    @XmlElementRef(name = "ExchangeRateAgreementType", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exchangeRateAgreementType;
    @XmlElementRef(name = "ExchangeRate", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> exchangeRate;
    @XmlElementRef(name = "HedgingContractReference", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> hedgingContractReference;
    @XmlElementRef(name = "SecondaryAccountReference", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secondaryAccountReference;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElementRef(name = "EndDate", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDate;
    @XmlElement(name = "CreatedBy")
    protected String createdBy;
    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "LastUpdatedBy")
    protected String lastUpdatedBy;
    @XmlElement(name = "LastUpdateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElementRef(name = "LastUpdateLogin", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastUpdateLogin;
    @XmlElement(name = "ObjectVersionNumber")
    protected Integer objectVersionNumber;
    @XmlElementRef(name = "BankAccountName", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankAccountName;
    @XmlElementRef(name = "BankAccountNameAlt", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankAccountNameAlt;
    @XmlElementRef(name = "ShortAccountName", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shortAccountName;
    @XmlElementRef(name = "Description", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "BankAccountNumberElectronic", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankAccountNumberElectronic;
    @XmlElement(name = "BankPartyId")
    protected Long bankPartyId;
    @XmlElement(name = "BranchPartyId")
    protected Long branchPartyId;
    @XmlElementRef(name = "BranchNumber", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> branchNumber;
    @XmlElementRef(name = "EFTSWIFTCode", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eftswiftCode;
    @XmlElementRef(name = "EndDateDisp", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDateDisp;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElementRef(name = "StartId", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> startId;
    @XmlElementRef(name = "EndId", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> endId;
    @XmlElement(name = "TerritoryCode")
    protected String territoryCode;
    @XmlElementRef(name = "BankNumber", namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/bankAccountServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bankNumber;
    @XmlElement(name = "ExternalBankAccountOwner")
    protected List<ExternalBankAccountOwner> externalBankAccountOwner;
    @XmlElement(name = "IntermediaryBankAccount")
    protected List<IntermediaryBankAccount> intermediaryBankAccount;
    @XmlElement(name = "ExtBankAcctDffVLA")
    protected com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff.ExternalBankAccount extBankAcctDffVLA;

    /**
     * Gets the value of the externalBankAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExternalBankAccountId() {
        return externalBankAccountId;
    }

    /**
     * Sets the value of the externalBankAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExternalBankAccountId(JAXBElement<Long> value) {
        this.externalBankAccountId = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the territoryShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerritoryShortName() {
        return territoryShortName;
    }

    /**
     * Sets the value of the territoryShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerritoryShortName(String value) {
        this.territoryShortName = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the bankId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getBankId() {
        return bankId;
    }

    /**
     * Sets the value of the bankId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setBankId(JAXBElement<Long> value) {
        this.bankId = value;
    }

    /**
     * Gets the value of the bankBranchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankBranchName() {
        return bankBranchName;
    }

    /**
     * Sets the value of the bankBranchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankBranchName(String value) {
        this.bankBranchName = value;
    }

    /**
     * Gets the value of the branchId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getBranchId() {
        return branchId;
    }

    /**
     * Sets the value of the branchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setBranchId(JAXBElement<Long> value) {
        this.branchId = value;
    }

    /**
     * Gets the value of the bankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Sets the value of the bankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountNumber(JAXBElement<String> value) {
        this.bankAccountNumber = value;
    }

    /**
     * Gets the value of the maskedBankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMaskedBankAccountNumber() {
        return maskedBankAccountNumber;
    }

    /**
     * Sets the value of the maskedBankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMaskedBankAccountNumber(JAXBElement<String> value) {
        this.maskedBankAccountNumber = value;
    }

    /**
     * Gets the value of the baMaskSetting property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBAMaskSetting() {
        return baMaskSetting;
    }

    /**
     * Sets the value of the baMaskSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBAMaskSetting(JAXBElement<String> value) {
        this.baMaskSetting = value;
    }

    /**
     * Gets the value of the baUnmaskLength property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBAUnmaskLength() {
        return baUnmaskLength;
    }

    /**
     * Sets the value of the baUnmaskLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBAUnmaskLength(JAXBElement<Integer> value) {
        this.baUnmaskLength = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrencyCode(JAXBElement<String> value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIBAN(JAXBElement<String> value) {
        this.iban = value;
    }

    /**
     * Gets the value of the maskedIBAN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMaskedIBAN() {
        return maskedIBAN;
    }

    /**
     * Sets the value of the maskedIBAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMaskedIBAN(JAXBElement<String> value) {
        this.maskedIBAN = value;
    }

    /**
     * Gets the value of the checkDigits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCheckDigits() {
        return checkDigits;
    }

    /**
     * Sets the value of the checkDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCheckDigits(JAXBElement<String> value) {
        this.checkDigits = value;
    }

    /**
     * Gets the value of the bankAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountType() {
        return bankAccountType;
    }

    /**
     * Sets the value of the bankAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountType(JAXBElement<String> value) {
        this.bankAccountType = value;
    }

    /**
     * Gets the value of the accountClassification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountClassification() {
        return accountClassification;
    }

    /**
     * Sets the value of the accountClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountClassification(JAXBElement<String> value) {
        this.accountClassification = value;
    }

    /**
     * Gets the value of the accountSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountSuffix() {
        return accountSuffix;
    }

    /**
     * Sets the value of the accountSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountSuffix(JAXBElement<String> value) {
        this.accountSuffix = value;
    }

    /**
     * Gets the value of the agencyLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAgencyLocationCode() {
        return agencyLocationCode;
    }

    /**
     * Sets the value of the agencyLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAgencyLocationCode(JAXBElement<String> value) {
        this.agencyLocationCode = value;
    }

    /**
     * Gets the value of the paymentFactorFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getPaymentFactorFlag() {
        return paymentFactorFlag;
    }

    /**
     * Sets the value of the paymentFactorFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setPaymentFactorFlag(JAXBElement<Boolean> value) {
        this.paymentFactorFlag = value;
    }

    /**
     * Gets the value of the foreignPaymentUseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getForeignPaymentUseFlag() {
        return foreignPaymentUseFlag;
    }

    /**
     * Sets the value of the foreignPaymentUseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setForeignPaymentUseFlag(JAXBElement<Boolean> value) {
        this.foreignPaymentUseFlag = value;
    }

    /**
     * Gets the value of the exchangeRateAgreementNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateAgreementNumber() {
        return exchangeRateAgreementNumber;
    }

    /**
     * Sets the value of the exchangeRateAgreementNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateAgreementNumber(JAXBElement<String> value) {
        this.exchangeRateAgreementNumber = value;
    }

    /**
     * Gets the value of the exchangeRateAgreementType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExchangeRateAgreementType() {
        return exchangeRateAgreementType;
    }

    /**
     * Sets the value of the exchangeRateAgreementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExchangeRateAgreementType(JAXBElement<String> value) {
        this.exchangeRateAgreementType = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setExchangeRate(JAXBElement<BigDecimal> value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the hedgingContractReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHedgingContractReference() {
        return hedgingContractReference;
    }

    /**
     * Sets the value of the hedgingContractReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHedgingContractReference(JAXBElement<String> value) {
        this.hedgingContractReference = value;
    }

    /**
     * Gets the value of the secondaryAccountReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecondaryAccountReference() {
        return secondaryAccountReference;
    }

    /**
     * Sets the value of the secondaryAccountReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecondaryAccountReference(JAXBElement<String> value) {
        this.secondaryAccountReference = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastUpdatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Sets the value of the lastUpdatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdatedBy(String value) {
        this.lastUpdatedBy = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the lastUpdateLogin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    /**
     * Sets the value of the lastUpdateLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastUpdateLogin(JAXBElement<String> value) {
        this.lastUpdateLogin = value;
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
     * Gets the value of the bankAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountName() {
        return bankAccountName;
    }

    /**
     * Sets the value of the bankAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountName(JAXBElement<String> value) {
        this.bankAccountName = value;
    }

    /**
     * Gets the value of the bankAccountNameAlt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountNameAlt() {
        return bankAccountNameAlt;
    }

    /**
     * Sets the value of the bankAccountNameAlt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountNameAlt(JAXBElement<String> value) {
        this.bankAccountNameAlt = value;
    }

    /**
     * Gets the value of the shortAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShortAccountName() {
        return shortAccountName;
    }

    /**
     * Sets the value of the shortAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShortAccountName(JAXBElement<String> value) {
        this.shortAccountName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

    /**
     * Gets the value of the bankAccountNumberElectronic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountNumberElectronic() {
        return bankAccountNumberElectronic;
    }

    /**
     * Sets the value of the bankAccountNumberElectronic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountNumberElectronic(JAXBElement<String> value) {
        this.bankAccountNumberElectronic = value;
    }

    /**
     * Gets the value of the bankPartyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBankPartyId() {
        return bankPartyId;
    }

    /**
     * Sets the value of the bankPartyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBankPartyId(Long value) {
        this.bankPartyId = value;
    }

    /**
     * Gets the value of the branchPartyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBranchPartyId() {
        return branchPartyId;
    }

    /**
     * Sets the value of the branchPartyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBranchPartyId(Long value) {
        this.branchPartyId = value;
    }

    /**
     * Gets the value of the branchNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchNumber() {
        return branchNumber;
    }

    /**
     * Sets the value of the branchNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchNumber(JAXBElement<String> value) {
        this.branchNumber = value;
    }

    /**
     * Gets the value of the eftswiftCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEFTSWIFTCode() {
        return eftswiftCode;
    }

    /**
     * Sets the value of the eftswiftCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEFTSWIFTCode(JAXBElement<String> value) {
        this.eftswiftCode = value;
    }

    /**
     * Gets the value of the endDateDisp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEndDateDisp() {
        return endDateDisp;
    }

    /**
     * Sets the value of the endDateDisp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEndDateDisp(JAXBElement<XMLGregorianCalendar> value) {
        this.endDateDisp = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the startId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getStartId() {
        return startId;
    }

    /**
     * Sets the value of the startId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setStartId(JAXBElement<Long> value) {
        this.startId = value;
    }

    /**
     * Gets the value of the endId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getEndId() {
        return endId;
    }

    /**
     * Sets the value of the endId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setEndId(JAXBElement<Long> value) {
        this.endId = value;
    }

    /**
     * Gets the value of the territoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerritoryCode() {
        return territoryCode;
    }

    /**
     * Sets the value of the territoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerritoryCode(String value) {
        this.territoryCode = value;
    }

    /**
     * Gets the value of the bankNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankNumber() {
        return bankNumber;
    }

    /**
     * Sets the value of the bankNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankNumber(JAXBElement<String> value) {
        this.bankNumber = value;
    }

    /**
     * Gets the value of the externalBankAccountOwner property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalBankAccountOwner property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalBankAccountOwner().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalBankAccountOwner }
     * 
     * 
     */
    public List<ExternalBankAccountOwner> getExternalBankAccountOwner() {
        if (externalBankAccountOwner == null) {
            externalBankAccountOwner = new ArrayList<ExternalBankAccountOwner>();
        }
        return this.externalBankAccountOwner;
    }

    /**
     * Gets the value of the intermediaryBankAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intermediaryBankAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntermediaryBankAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntermediaryBankAccount }
     * 
     * 
     */
    public List<IntermediaryBankAccount> getIntermediaryBankAccount() {
        if (intermediaryBankAccount == null) {
            intermediaryBankAccount = new ArrayList<IntermediaryBankAccount>();
        }
        return this.intermediaryBankAccount;
    }

    /**
     * Gets the value of the extBankAcctDffVLA property.
     * 
     * @return
     *     possible object is
     *     {@link com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff.ExternalBankAccount }
     *     
     */
    public com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff.ExternalBankAccount getExtBankAcctDffVLA() {
        return extBankAcctDffVLA;
    }

    /**
     * Sets the value of the extBankAcctDffVLA property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff.ExternalBankAccount }
     *     
     */
    public void setExtBankAcctDffVLA(com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff.ExternalBankAccount value) {
        this.extBankAcctDffVLA = value;
    }

}
