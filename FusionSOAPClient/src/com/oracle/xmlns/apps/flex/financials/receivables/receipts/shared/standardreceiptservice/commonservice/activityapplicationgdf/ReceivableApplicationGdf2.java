
package com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationgdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ReceivableApplicationGdfJL_5FBR_5FARXRWMAI_5FAdditional complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReceivableApplicationGdfJL_5FBR_5FARXRWMAI_5FAdditional">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/}ReceivableApplicationGdf">
 *       &lt;sequence>
 *         &lt;element name="_Main__Amount__Received" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Base__Interest__Calculation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Base__Interest__Calculation_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Calculated__Interest" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Received__Interest" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Interest__Difference__Action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Difference__Action_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Write__Off__Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Interest__Payment__Date" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="_Write_2DOff__Date" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="_Calculated__Interest__Tmp" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Received__Interest__Tmp" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="_Interest__Payment__Date__Tmp" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="debitMemoNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceivableApplicationGdfJL_5FBR_5FARXRWMAI_5FAdditional", propOrder = {
    "mainAmountReceived",
    "baseInterestCalculation",
    "baseInterestCalculationDisplay",
    "calculatedInterest",
    "receivedInterest",
    "interestDifferenceAction",
    "interestDifferenceActionDisplay",
    "writeOffReason",
    "interestPaymentDate",
    "write2DOffDate",
    "calculatedInterestTmp",
    "receivedInterestTmp",
    "interestPaymentDateTmp",
    "debitMemoNumber"
})
public class ReceivableApplicationGdf2
    extends ReceivableApplicationGdf
{

    @XmlElementRef(name = "_Main__Amount__Received", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> mainAmountReceived;
    @XmlElementRef(name = "_Base__Interest__Calculation", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baseInterestCalculation;
    @XmlElementRef(name = "_Base__Interest__Calculation_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baseInterestCalculationDisplay;
    @XmlElementRef(name = "_Calculated__Interest", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> calculatedInterest;
    @XmlElementRef(name = "_Received__Interest", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> receivedInterest;
    @XmlElementRef(name = "_Interest__Difference__Action", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestDifferenceAction;
    @XmlElementRef(name = "_Interest__Difference__Action_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interestDifferenceActionDisplay;
    @XmlElementRef(name = "_Write__Off__Reason", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> writeOffReason;
    @XmlElementRef(name = "_Interest__Payment__Date", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> interestPaymentDate;
    @XmlElementRef(name = "_Write_2DOff__Date", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> write2DOffDate;
    @XmlElementRef(name = "_Calculated__Interest__Tmp", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> calculatedInterestTmp;
    @XmlElementRef(name = "_Received__Interest__Tmp", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> receivedInterestTmp;
    @XmlElementRef(name = "_Interest__Payment__Date__Tmp", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> interestPaymentDateTmp;
    @XmlElementRef(name = "debitMemoNumber", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> debitMemoNumber;

    /**
     * Gets the value of the mainAmountReceived property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMainAmountReceived() {
        return mainAmountReceived;
    }

    /**
     * Sets the value of the mainAmountReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMainAmountReceived(JAXBElement<BigDecimal> value) {
        this.mainAmountReceived = value;
    }

    /**
     * Gets the value of the baseInterestCalculation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaseInterestCalculation() {
        return baseInterestCalculation;
    }

    /**
     * Sets the value of the baseInterestCalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaseInterestCalculation(JAXBElement<String> value) {
        this.baseInterestCalculation = value;
    }

    /**
     * Gets the value of the baseInterestCalculationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaseInterestCalculationDisplay() {
        return baseInterestCalculationDisplay;
    }

    /**
     * Sets the value of the baseInterestCalculationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaseInterestCalculationDisplay(JAXBElement<String> value) {
        this.baseInterestCalculationDisplay = value;
    }

    /**
     * Gets the value of the calculatedInterest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCalculatedInterest() {
        return calculatedInterest;
    }

    /**
     * Sets the value of the calculatedInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCalculatedInterest(JAXBElement<BigDecimal> value) {
        this.calculatedInterest = value;
    }

    /**
     * Gets the value of the receivedInterest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getReceivedInterest() {
        return receivedInterest;
    }

    /**
     * Sets the value of the receivedInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setReceivedInterest(JAXBElement<BigDecimal> value) {
        this.receivedInterest = value;
    }

    /**
     * Gets the value of the interestDifferenceAction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestDifferenceAction() {
        return interestDifferenceAction;
    }

    /**
     * Sets the value of the interestDifferenceAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestDifferenceAction(JAXBElement<String> value) {
        this.interestDifferenceAction = value;
    }

    /**
     * Gets the value of the interestDifferenceActionDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterestDifferenceActionDisplay() {
        return interestDifferenceActionDisplay;
    }

    /**
     * Sets the value of the interestDifferenceActionDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterestDifferenceActionDisplay(JAXBElement<String> value) {
        this.interestDifferenceActionDisplay = value;
    }

    /**
     * Gets the value of the writeOffReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWriteOffReason() {
        return writeOffReason;
    }

    /**
     * Sets the value of the writeOffReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWriteOffReason(JAXBElement<String> value) {
        this.writeOffReason = value;
    }

    /**
     * Gets the value of the interestPaymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getInterestPaymentDate() {
        return interestPaymentDate;
    }

    /**
     * Sets the value of the interestPaymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setInterestPaymentDate(JAXBElement<XMLGregorianCalendar> value) {
        this.interestPaymentDate = value;
    }

    /**
     * Gets the value of the write2DOffDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getWrite2DOffDate() {
        return write2DOffDate;
    }

    /**
     * Sets the value of the write2DOffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setWrite2DOffDate(JAXBElement<XMLGregorianCalendar> value) {
        this.write2DOffDate = value;
    }

    /**
     * Gets the value of the calculatedInterestTmp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCalculatedInterestTmp() {
        return calculatedInterestTmp;
    }

    /**
     * Sets the value of the calculatedInterestTmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCalculatedInterestTmp(JAXBElement<BigDecimal> value) {
        this.calculatedInterestTmp = value;
    }

    /**
     * Gets the value of the receivedInterestTmp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getReceivedInterestTmp() {
        return receivedInterestTmp;
    }

    /**
     * Sets the value of the receivedInterestTmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setReceivedInterestTmp(JAXBElement<BigDecimal> value) {
        this.receivedInterestTmp = value;
    }

    /**
     * Gets the value of the interestPaymentDateTmp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getInterestPaymentDateTmp() {
        return interestPaymentDateTmp;
    }

    /**
     * Sets the value of the interestPaymentDateTmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setInterestPaymentDateTmp(JAXBElement<XMLGregorianCalendar> value) {
        this.interestPaymentDateTmp = value;
    }

    /**
     * Gets the value of the debitMemoNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDebitMemoNumber() {
        return debitMemoNumber;
    }

    /**
     * Sets the value of the debitMemoNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDebitMemoNumber(JAXBElement<String> value) {
        this.debitMemoNumber = value;
    }

}
