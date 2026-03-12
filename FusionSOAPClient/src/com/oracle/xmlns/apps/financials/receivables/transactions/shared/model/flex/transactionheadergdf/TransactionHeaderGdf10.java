
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionHeaderGdfJL_5FBR_5FARXTWMAI_5FAdditional complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionHeaderGdfJL_5FBR_5FARXTWMAI_5FAdditional">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
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
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionHeaderGdfJL_5FBR_5FARXTWMAI_5FAdditional", propOrder = {
    "interestType",
    "interestTypeDisplay",
    "interestRate2FAmount",
    "interestPeriod",
    "interestFormula",
    "interestFormulaDisplay",
    "interestGraceDays",
    "interestPenaltyType",
    "interestPenaltyTypeDisplay",
    "interestPenaltyRate2FAmount"
})
public class TransactionHeaderGdf10
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "_Interest__Type", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestType;
    @XmlElementRef(name = "_Interest__Type_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestTypeDisplay;
    @XmlElementRef(name = "_Interest__Rate___2F__Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestRate2FAmount;
    @XmlElementRef(name = "_Interest__Period", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestPeriod;
    @XmlElementRef(name = "_Interest__Formula", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestFormula;
    @XmlElementRef(name = "_Interest__Formula_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestFormulaDisplay;
    @XmlElementRef(name = "_Interest__Grace__Days", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestGraceDays;
    @XmlElementRef(name = "_Interest__Penalty__Type", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestPenaltyType;
    @XmlElementRef(name = "_Interest__Penalty__Type_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestPenaltyTypeDisplay;
    @XmlElementRef(name = "_Interest__Penalty__Rate___2F__Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> interestPenaltyRate2FAmount;

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

}
