
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionlineinterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OraCurriculumFees complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OraCurriculumFees">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/}TransactionInterfaceLineFLEX">
 *       &lt;sequence>
 *         &lt;element name="transactionPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institution_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acadPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acadPeriod_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeId_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discId_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currId_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stdntCurrId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stdntCurrId_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjCal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjCal_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adjReason_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OraCurriculumFees", propOrder = {
    "transactionPost",
    "institution",
    "institutionDisplay",
    "acadPeriod",
    "acadPeriodDisplay",
    "feeId",
    "feeIdDisplay",
    "discId",
    "discIdDisplay",
    "currId",
    "currIdDisplay",
    "stdntCurrId",
    "stdntCurrIdDisplay",
    "adjCal",
    "adjCalDisplay",
    "adjReason",
    "adjReasonDisplay"
})
public class OraCurriculumFees
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "transactionPost", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionPost;
    @XmlElementRef(name = "institution", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> institution;
    @XmlElementRef(name = "institution_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> institutionDisplay;
    @XmlElementRef(name = "acadPeriod", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acadPeriod;
    @XmlElementRef(name = "acadPeriod_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acadPeriodDisplay;
    @XmlElementRef(name = "feeId", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeId;
    @XmlElementRef(name = "feeId_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeIdDisplay;
    @XmlElementRef(name = "discId", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> discId;
    @XmlElementRef(name = "discId_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> discIdDisplay;
    @XmlElementRef(name = "currId", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currId;
    @XmlElementRef(name = "currId_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currIdDisplay;
    @XmlElementRef(name = "stdntCurrId", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stdntCurrId;
    @XmlElementRef(name = "stdntCurrId_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stdntCurrIdDisplay;
    @XmlElementRef(name = "adjCal", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjCal;
    @XmlElementRef(name = "adjCal_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjCalDisplay;
    @XmlElementRef(name = "adjReason", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjReason;
    @XmlElementRef(name = "adjReason_Display", namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adjReasonDisplay;

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
     * Gets the value of the discId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDiscId() {
        return discId;
    }

    /**
     * Sets the value of the discId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDiscId(JAXBElement<String> value) {
        this.discId = value;
    }

    /**
     * Gets the value of the discIdDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDiscIdDisplay() {
        return discIdDisplay;
    }

    /**
     * Sets the value of the discIdDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDiscIdDisplay(JAXBElement<String> value) {
        this.discIdDisplay = value;
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
     * Gets the value of the stdntCurrId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStdntCurrId() {
        return stdntCurrId;
    }

    /**
     * Sets the value of the stdntCurrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStdntCurrId(JAXBElement<String> value) {
        this.stdntCurrId = value;
    }

    /**
     * Gets the value of the stdntCurrIdDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStdntCurrIdDisplay() {
        return stdntCurrIdDisplay;
    }

    /**
     * Sets the value of the stdntCurrIdDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStdntCurrIdDisplay(JAXBElement<String> value) {
        this.stdntCurrIdDisplay = value;
    }

    /**
     * Gets the value of the adjCal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjCal() {
        return adjCal;
    }

    /**
     * Sets the value of the adjCal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjCal(JAXBElement<String> value) {
        this.adjCal = value;
    }

    /**
     * Gets the value of the adjCalDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjCalDisplay() {
        return adjCalDisplay;
    }

    /**
     * Sets the value of the adjCalDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjCalDisplay(JAXBElement<String> value) {
        this.adjCalDisplay = value;
    }

    /**
     * Gets the value of the adjReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjReason() {
        return adjReason;
    }

    /**
     * Sets the value of the adjReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjReason(JAXBElement<String> value) {
        this.adjReason = value;
    }

    /**
     * Gets the value of the adjReasonDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdjReasonDisplay() {
        return adjReasonDisplay;
    }

    /**
     * Sets the value of the adjReasonDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdjReasonDisplay(JAXBElement<String> value) {
        this.adjReasonDisplay = value;
    }

}
