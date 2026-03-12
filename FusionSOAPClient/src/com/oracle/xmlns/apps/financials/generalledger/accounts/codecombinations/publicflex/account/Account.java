
package com.oracle.xmlns.apps.financials.generalledger.accounts.codecombinations.publicflex.account;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Account complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Account"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="JgzzReconFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Reference3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinancialCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SummaryFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DetailPostingAllowedFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DetailBudgetingAllowedFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="_FLEX_StructureInstanceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="_FLEX_StructureInstanceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="StartDateActive" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="EndDateActive" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="EnabledFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="_CODE_COMBINATION_ID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="_CHART_OF_ACCOUNTS_ID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="FND_ACFF_ConcatenatedStorage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FND_ACFF_Delimiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
         "jgzzReconFlag", "reference3", "financialCategory", "summaryFlag", "detailPostingAllowedFlag", "accountType",
         "detailBudgetingAllowedFlag", "flexStructureInstanceCode", "flexStructureInstanceId", "startDateActive",
         "endDateActive", "enabledFlag", "codecombinationid", "chartofaccountsid", "fndacffConcatenatedStorage",
         "fndacffDelimiter"
    })
@XmlSeeAlso({ Mstiledger.class, Mteledger.class, Tamledger.class, Tscledger.class, Fmtiledger.class })
public class Account {

    @XmlElementRef(name = "JgzzReconFlag",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> jgzzReconFlag;
    @XmlElementRef(name = "Reference3",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference3;
    @XmlElementRef(name = "FinancialCategory",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> financialCategory;
    @XmlElement(name = "SummaryFlag")
    protected String summaryFlag;
    @XmlElement(name = "DetailPostingAllowedFlag")
    protected String detailPostingAllowedFlag;
    @XmlElement(name = "AccountType")
    protected String accountType;
    @XmlElement(name = "DetailBudgetingAllowedFlag")
    protected String detailBudgetingAllowedFlag;
    @XmlElement(name = "_FLEX_StructureInstanceCode")
    protected String flexStructureInstanceCode;
    @XmlElement(name = "_FLEX_StructureInstanceId")
    protected Long flexStructureInstanceId;
    @XmlElementRef(name = "StartDateActive",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startDateActive;
    @XmlElementRef(name = "EndDateActive",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDateActive;
    @XmlElement(name = "EnabledFlag")
    protected String enabledFlag;
    @XmlElement(name = "_CODE_COMBINATION_ID")
    protected Long codecombinationid;
    @XmlElement(name = "_CHART_OF_ACCOUNTS_ID")
    protected Long chartofaccountsid;
    @XmlElementRef(name = "FND_ACFF_ConcatenatedStorage",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> fndacffConcatenatedStorage;
    @XmlElementRef(name = "FND_ACFF_Delimiter",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/publicFlex/Account/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> fndacffDelimiter;

    /**
     * Gets the value of the jgzzReconFlag property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getJgzzReconFlag() {
        return jgzzReconFlag;
    }

    /**
     * Sets the value of the jgzzReconFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setJgzzReconFlag(JAXBElement<String> value) {
        this.jgzzReconFlag = value;
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
     * Gets the value of the financialCategory property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getFinancialCategory() {
        return financialCategory;
    }

    /**
     * Sets the value of the financialCategory property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setFinancialCategory(JAXBElement<String> value) {
        this.financialCategory = value;
    }

    /**
     * Gets the value of the summaryFlag property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSummaryFlag() {
        return summaryFlag;
    }

    /**
     * Sets the value of the summaryFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSummaryFlag(String value) {
        this.summaryFlag = value;
    }

    /**
     * Gets the value of the detailPostingAllowedFlag property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDetailPostingAllowedFlag() {
        return detailPostingAllowedFlag;
    }

    /**
     * Sets the value of the detailPostingAllowedFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDetailPostingAllowedFlag(String value) {
        this.detailPostingAllowedFlag = value;
    }

    /**
     * Gets the value of the accountType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the detailBudgetingAllowedFlag property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDetailBudgetingAllowedFlag() {
        return detailBudgetingAllowedFlag;
    }

    /**
     * Sets the value of the detailBudgetingAllowedFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDetailBudgetingAllowedFlag(String value) {
        this.detailBudgetingAllowedFlag = value;
    }

    /**
     * Gets the value of the flexStructureInstanceCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFLEXStructureInstanceCode() {
        return flexStructureInstanceCode;
    }

    /**
     * Sets the value of the flexStructureInstanceCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFLEXStructureInstanceCode(String value) {
        this.flexStructureInstanceCode = value;
    }

    /**
     * Gets the value of the flexStructureInstanceId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getFLEXStructureInstanceId() {
        return flexStructureInstanceId;
    }

    /**
     * Sets the value of the flexStructureInstanceId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setFLEXStructureInstanceId(Long value) {
        this.flexStructureInstanceId = value;
    }

    /**
     * Gets the value of the startDateActive property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getStartDateActive() {
        return startDateActive;
    }

    /**
     * Sets the value of the startDateActive property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setStartDateActive(JAXBElement<XMLGregorianCalendar> value) {
        this.startDateActive = value;
    }

    /**
     * Gets the value of the endDateActive property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getEndDateActive() {
        return endDateActive;
    }

    /**
     * Sets the value of the endDateActive property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setEndDateActive(JAXBElement<XMLGregorianCalendar> value) {
        this.endDateActive = value;
    }

    /**
     * Gets the value of the enabledFlag property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEnabledFlag() {
        return enabledFlag;
    }

    /**
     * Sets the value of the enabledFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEnabledFlag(String value) {
        this.enabledFlag = value;
    }

    /**
     * Gets the value of the codecombinationid property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getCODECOMBINATIONID() {
        return codecombinationid;
    }

    /**
     * Sets the value of the codecombinationid property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setCODECOMBINATIONID(Long value) {
        this.codecombinationid = value;
    }

    /**
     * Gets the value of the chartofaccountsid property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getCHARTOFACCOUNTSID() {
        return chartofaccountsid;
    }

    /**
     * Sets the value of the chartofaccountsid property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setCHARTOFACCOUNTSID(Long value) {
        this.chartofaccountsid = value;
    }

    /**
     * Gets the value of the fndacffConcatenatedStorage property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getFNDACFFConcatenatedStorage() {
        return fndacffConcatenatedStorage;
    }

    /**
     * Sets the value of the fndacffConcatenatedStorage property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setFNDACFFConcatenatedStorage(JAXBElement<String> value) {
        this.fndacffConcatenatedStorage = value;
    }

    /**
     * Gets the value of the fndacffDelimiter property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getFNDACFFDelimiter() {
        return fndacffDelimiter;
    }

    /**
     * Sets the value of the fndacffDelimiter property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setFNDACFFDelimiter(JAXBElement<String> value) {
        this.fndacffDelimiter = value;
    }

}
