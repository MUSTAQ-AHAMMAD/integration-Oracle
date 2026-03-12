
package com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofilegdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerProfileGdfJL_5FBR_5FARXCUDCI_5FAdditional complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerProfileGdfJL_5FBR_5FARXCUDCI_5FAdditional">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/}CustomerProfileGdf">
 *       &lt;sequence>
 *         &lt;element name="_Remittance__Protest__Instruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Remittance__Protest__Instruction_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Remittance__Interest__Instructio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Remittance__Interest__Instructio_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Type_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Rate___2F__Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Interest__Period" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Interest__Formula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Formula_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Grace__Days" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Interest__Penalty__Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Penalty__Type_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Penalty__Rate___2F__Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Consolidate__Payment__Schedules" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Consolidate__Payment__Schedules_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Installment__Due__Date__Derivatio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Installment__Due__Date__Derivatio_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerProfileGdfJL_5FBR_5FARXCUDCI_5FAdditional", propOrder = {
    "remittanceProtestInstruction",
    "remittanceProtestInstructionDisplay",
    "remittanceInterestInstructio",
    "remittanceInterestInstructioDisplay",
    "interestType",
    "interestTypeDisplay",
    "interestRate2FAmount",
    "interestPeriod",
    "interestFormula",
    "interestFormulaDisplay",
    "interestGraceDays",
    "interestPenaltyType",
    "interestPenaltyTypeDisplay",
    "interestPenaltyRate2FAmount",
    "consolidatePaymentSchedules",
    "consolidatePaymentSchedulesDisplay",
    "installmentDueDateDerivatio",
    "installmentDueDateDerivatioDisplay"
})
public class CustomerProfileGdf2
    extends CustomerProfileGdf
{

    @XmlElementRef(name = "_Remittance__Protest__Instruction", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remittanceProtestInstruction;
    @XmlElementRef(name = "_Remittance__Protest__Instruction_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remittanceProtestInstructionDisplay;
    @XmlElementRef(name = "_Remittance__Interest__Instructio", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remittanceInterestInstructio;
    @XmlElementRef(name = "_Remittance__Interest__Instructio_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remittanceInterestInstructioDisplay;
    @XmlElementRef(name = "_Interest__Type", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestType;
    @XmlElementRef(name = "_Interest__Type_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestTypeDisplay;
    @XmlElementRef(name = "_Interest__Rate___2F__Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestRate2FAmount;
    @XmlElementRef(name = "_Interest__Period", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestPeriod;
    @XmlElementRef(name = "_Interest__Formula", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestFormula;
    @XmlElementRef(name = "_Interest__Formula_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestFormulaDisplay;
    @XmlElementRef(name = "_Interest__Grace__Days", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestGraceDays;
    @XmlElementRef(name = "_Interest__Penalty__Type", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestPenaltyType;
    @XmlElementRef(name = "_Interest__Penalty__Type_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestPenaltyTypeDisplay;
    @XmlElementRef(name = "_Interest__Penalty__Rate___2F__Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestPenaltyRate2FAmount;
    @XmlElementRef(name = "_Consolidate__Payment__Schedules", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consolidatePaymentSchedules;
    @XmlElementRef(name = "_Consolidate__Payment__Schedules_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consolidatePaymentSchedulesDisplay;
    @XmlElementRef(name = "_Installment__Due__Date__Derivatio", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> installmentDueDateDerivatio;
    @XmlElementRef(name = "_Installment__Due__Date__Derivatio_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> installmentDueDateDerivatioDisplay;

    /**
     * Gets the value of the remittanceProtestInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemittanceProtestInstruction() {
        return remittanceProtestInstruction;
    }

    /**
     * Sets the value of the remittanceProtestInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemittanceProtestInstruction(JAXBElement<String> value) {
        this.remittanceProtestInstruction = value;
    }

    /**
     * Gets the value of the remittanceProtestInstructionDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemittanceProtestInstructionDisplay() {
        return remittanceProtestInstructionDisplay;
    }

    /**
     * Sets the value of the remittanceProtestInstructionDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemittanceProtestInstructionDisplay(JAXBElement<String> value) {
        this.remittanceProtestInstructionDisplay = value;
    }

    /**
     * Gets the value of the remittanceInterestInstructio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemittanceInterestInstructio() {
        return remittanceInterestInstructio;
    }

    /**
     * Sets the value of the remittanceInterestInstructio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemittanceInterestInstructio(JAXBElement<String> value) {
        this.remittanceInterestInstructio = value;
    }

    /**
     * Gets the value of the remittanceInterestInstructioDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemittanceInterestInstructioDisplay() {
        return remittanceInterestInstructioDisplay;
    }

    /**
     * Sets the value of the remittanceInterestInstructioDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemittanceInterestInstructioDisplay(JAXBElement<String> value) {
        this.remittanceInterestInstructioDisplay = value;
    }

    /**
     * Gets the value of the interestType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestType() {
        return interestType;
    }

    /**
     * Sets the value of the interestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestType(JAXBElement<String> value) {
        this.interestType = value;
    }

    /**
     * Gets the value of the interestTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestTypeDisplay() {
        return interestTypeDisplay;
    }

    /**
     * Sets the value of the interestTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestTypeDisplay(JAXBElement<String> value) {
        this.interestTypeDisplay = value;
    }

    /**
     * Gets the value of the interestRate2FAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInterestRate2FAmount() {
        return interestRate2FAmount;
    }

    /**
     * Sets the value of the interestRate2FAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInterestRate2FAmount(JAXBElement<BigDecimal> value) {
        this.interestRate2FAmount = value;
    }

    /**
     * Gets the value of the interestPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInterestPeriod() {
        return interestPeriod;
    }

    /**
     * Sets the value of the interestPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInterestPeriod(JAXBElement<BigDecimal> value) {
        this.interestPeriod = value;
    }

    /**
     * Gets the value of the interestFormula property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestFormula() {
        return interestFormula;
    }

    /**
     * Sets the value of the interestFormula property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestFormula(JAXBElement<String> value) {
        this.interestFormula = value;
    }

    /**
     * Gets the value of the interestFormulaDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestFormulaDisplay() {
        return interestFormulaDisplay;
    }

    /**
     * Sets the value of the interestFormulaDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestFormulaDisplay(JAXBElement<String> value) {
        this.interestFormulaDisplay = value;
    }

    /**
     * Gets the value of the interestGraceDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInterestGraceDays() {
        return interestGraceDays;
    }

    /**
     * Sets the value of the interestGraceDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInterestGraceDays(JAXBElement<BigDecimal> value) {
        this.interestGraceDays = value;
    }

    /**
     * Gets the value of the interestPenaltyType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestPenaltyType() {
        return interestPenaltyType;
    }

    /**
     * Sets the value of the interestPenaltyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestPenaltyType(JAXBElement<String> value) {
        this.interestPenaltyType = value;
    }

    /**
     * Gets the value of the interestPenaltyTypeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestPenaltyTypeDisplay() {
        return interestPenaltyTypeDisplay;
    }

    /**
     * Sets the value of the interestPenaltyTypeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestPenaltyTypeDisplay(JAXBElement<String> value) {
        this.interestPenaltyTypeDisplay = value;
    }

    /**
     * Gets the value of the interestPenaltyRate2FAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getInterestPenaltyRate2FAmount() {
        return interestPenaltyRate2FAmount;
    }

    /**
     * Sets the value of the interestPenaltyRate2FAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setInterestPenaltyRate2FAmount(JAXBElement<BigDecimal> value) {
        this.interestPenaltyRate2FAmount = value;
    }

    /**
     * Gets the value of the consolidatePaymentSchedules property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsolidatePaymentSchedules() {
        return consolidatePaymentSchedules;
    }

    /**
     * Sets the value of the consolidatePaymentSchedules property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsolidatePaymentSchedules(JAXBElement<String> value) {
        this.consolidatePaymentSchedules = value;
    }

    /**
     * Gets the value of the consolidatePaymentSchedulesDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsolidatePaymentSchedulesDisplay() {
        return consolidatePaymentSchedulesDisplay;
    }

    /**
     * Sets the value of the consolidatePaymentSchedulesDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsolidatePaymentSchedulesDisplay(JAXBElement<String> value) {
        this.consolidatePaymentSchedulesDisplay = value;
    }

    /**
     * Gets the value of the installmentDueDateDerivatio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstallmentDueDateDerivatio() {
        return installmentDueDateDerivatio;
    }

    /**
     * Sets the value of the installmentDueDateDerivatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstallmentDueDateDerivatio(JAXBElement<String> value) {
        this.installmentDueDateDerivatio = value;
    }

    /**
     * Gets the value of the installmentDueDateDerivatioDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstallmentDueDateDerivatioDisplay() {
        return installmentDueDateDerivatioDisplay;
    }

    /**
     * Sets the value of the installmentDueDateDerivatioDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstallmentDueDateDerivatioDisplay(JAXBElement<String> value) {
        this.installmentDueDateDerivatioDisplay = value;
    }

}
