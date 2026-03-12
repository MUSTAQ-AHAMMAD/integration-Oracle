
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioncontingencyinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for oraAcademicPeriodFees complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oraAcademicPeriodFees">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="transactionPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institution_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportingAcademicPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportingAcademicPeriod_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeId_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeGroup_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currId_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="studentAcademicPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="studentAcademicPeriod_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjustmentCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjustmentCalendar_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjustmentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjustmentReason_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acadPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acadPeriod_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oraAcademicPeriodFees", propOrder = {
    "transactionPost",
    "institution",
    "institutionDisplay",
    "reportingAcademicPeriod",
    "reportingAcademicPeriodDisplay",
    "feeId",
    "feeIdDisplay",
    "feeGroup",
    "feeGroupDisplay",
    "currId",
    "currIdDisplay",
    "studentAcademicPeriod",
    "studentAcademicPeriodDisplay",
    "adjustmentCalendar",
    "adjustmentCalendarDisplay",
    "adjustmentReason",
    "adjustmentReasonDisplay",
    "acadPeriod",
    "acadPeriodDisplay"
})
public class OraAcademicPeriodFees
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "transactionPost", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionPost;
    @XmlElementRef(name = "institution", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> institution;
    @XmlElementRef(name = "institution_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> institutionDisplay;
    @XmlElementRef(name = "reportingAcademicPeriod", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingAcademicPeriod;
    @XmlElementRef(name = "reportingAcademicPeriod_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reportingAcademicPeriodDisplay;
    @XmlElementRef(name = "feeId", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeId;
    @XmlElementRef(name = "feeId_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeIdDisplay;
    @XmlElementRef(name = "feeGroup", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeGroup;
    @XmlElementRef(name = "feeGroup_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeGroupDisplay;
    @XmlElementRef(name = "currId", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currId;
    @XmlElementRef(name = "currId_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currIdDisplay;
    @XmlElementRef(name = "studentAcademicPeriod", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> studentAcademicPeriod;
    @XmlElementRef(name = "studentAcademicPeriod_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> studentAcademicPeriodDisplay;
    @XmlElementRef(name = "adjustmentCalendar", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjustmentCalendar;
    @XmlElementRef(name = "adjustmentCalendar_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjustmentCalendarDisplay;
    @XmlElementRef(name = "adjustmentReason", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjustmentReason;
    @XmlElementRef(name = "adjustmentReason_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjustmentReasonDisplay;
    @XmlElementRef(name = "acadPeriod", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acadPeriod;
    @XmlElementRef(name = "acadPeriod_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionContingencyInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acadPeriodDisplay;

    /**
     * Gets the value of the transactionPost property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionPost() {
        return transactionPost;
    }

    /**
     * Sets the value of the transactionPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionPost(JAXBElement<String> value) {
        this.transactionPost = value;
    }

    /**
     * Gets the value of the institution property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstitution() {
        return institution;
    }

    /**
     * Sets the value of the institution property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstitution(JAXBElement<String> value) {
        this.institution = value;
    }

    /**
     * Gets the value of the institutionDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstitutionDisplay() {
        return institutionDisplay;
    }

    /**
     * Sets the value of the institutionDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstitutionDisplay(JAXBElement<String> value) {
        this.institutionDisplay = value;
    }

    /**
     * Gets the value of the reportingAcademicPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingAcademicPeriod() {
        return reportingAcademicPeriod;
    }

    /**
     * Sets the value of the reportingAcademicPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingAcademicPeriod(JAXBElement<String> value) {
        this.reportingAcademicPeriod = value;
    }

    /**
     * Gets the value of the reportingAcademicPeriodDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReportingAcademicPeriodDisplay() {
        return reportingAcademicPeriodDisplay;
    }

    /**
     * Sets the value of the reportingAcademicPeriodDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReportingAcademicPeriodDisplay(JAXBElement<String> value) {
        this.reportingAcademicPeriodDisplay = value;
    }

    /**
     * Gets the value of the feeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFeeId() {
        return feeId;
    }

    /**
     * Sets the value of the feeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFeeId(JAXBElement<String> value) {
        this.feeId = value;
    }

    /**
     * Gets the value of the feeIdDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFeeIdDisplay() {
        return feeIdDisplay;
    }

    /**
     * Sets the value of the feeIdDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFeeIdDisplay(JAXBElement<String> value) {
        this.feeIdDisplay = value;
    }

    /**
     * Gets the value of the feeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFeeGroup() {
        return feeGroup;
    }

    /**
     * Sets the value of the feeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFeeGroup(JAXBElement<String> value) {
        this.feeGroup = value;
    }

    /**
     * Gets the value of the feeGroupDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFeeGroupDisplay() {
        return feeGroupDisplay;
    }

    /**
     * Sets the value of the feeGroupDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFeeGroupDisplay(JAXBElement<String> value) {
        this.feeGroupDisplay = value;
    }

    /**
     * Gets the value of the currId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrId() {
        return currId;
    }

    /**
     * Sets the value of the currId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrId(JAXBElement<String> value) {
        this.currId = value;
    }

    /**
     * Gets the value of the currIdDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrIdDisplay() {
        return currIdDisplay;
    }

    /**
     * Sets the value of the currIdDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrIdDisplay(JAXBElement<String> value) {
        this.currIdDisplay = value;
    }

    /**
     * Gets the value of the studentAcademicPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStudentAcademicPeriod() {
        return studentAcademicPeriod;
    }

    /**
     * Sets the value of the studentAcademicPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStudentAcademicPeriod(JAXBElement<String> value) {
        this.studentAcademicPeriod = value;
    }

    /**
     * Gets the value of the studentAcademicPeriodDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStudentAcademicPeriodDisplay() {
        return studentAcademicPeriodDisplay;
    }

    /**
     * Sets the value of the studentAcademicPeriodDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStudentAcademicPeriodDisplay(JAXBElement<String> value) {
        this.studentAcademicPeriodDisplay = value;
    }

    /**
     * Gets the value of the adjustmentCalendar property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjustmentCalendar() {
        return adjustmentCalendar;
    }

    /**
     * Sets the value of the adjustmentCalendar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjustmentCalendar(JAXBElement<String> value) {
        this.adjustmentCalendar = value;
    }

    /**
     * Gets the value of the adjustmentCalendarDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjustmentCalendarDisplay() {
        return adjustmentCalendarDisplay;
    }

    /**
     * Sets the value of the adjustmentCalendarDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjustmentCalendarDisplay(JAXBElement<String> value) {
        this.adjustmentCalendarDisplay = value;
    }

    /**
     * Gets the value of the adjustmentReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjustmentReason() {
        return adjustmentReason;
    }

    /**
     * Sets the value of the adjustmentReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjustmentReason(JAXBElement<String> value) {
        this.adjustmentReason = value;
    }

    /**
     * Gets the value of the adjustmentReasonDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjustmentReasonDisplay() {
        return adjustmentReasonDisplay;
    }

    /**
     * Sets the value of the adjustmentReasonDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjustmentReasonDisplay(JAXBElement<String> value) {
        this.adjustmentReasonDisplay = value;
    }

    /**
     * Gets the value of the acadPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAcadPeriod() {
        return acadPeriod;
    }

    /**
     * Sets the value of the acadPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAcadPeriod(JAXBElement<String> value) {
        this.acadPeriod = value;
    }

    /**
     * Gets the value of the acadPeriodDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAcadPeriodDisplay() {
        return acadPeriodDisplay;
    }

    /**
     * Sets the value of the acadPeriodDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAcadPeriodDisplay(JAXBElement<String> value) {
        this.acadPeriodDisplay = value;
    }

}
