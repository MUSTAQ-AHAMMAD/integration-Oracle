
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfacelinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OraGeneralFees complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OraGeneralFees">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/}TransactionInterfaceLineFLEX">
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
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OraGeneralFees", propOrder = {
    "transactionPost",
    "institution",
    "institutionDisplay",
    "acadPeriod",
    "acadPeriodDisplay",
    "feeId",
    "feeIdDisplay",
    "discId",
    "discIdDisplay",
    "reference"
})
public class OraGeneralFees
    extends TransactionInterfaceLineFLEX
{

    @XmlElementRef(name = "transactionPost", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionPost;
    @XmlElementRef(name = "institution", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> institution;
    @XmlElementRef(name = "institution_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> institutionDisplay;
    @XmlElementRef(name = "acadPeriod", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acadPeriod;
    @XmlElementRef(name = "acadPeriod_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acadPeriodDisplay;
    @XmlElementRef(name = "feeId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeId;
    @XmlElementRef(name = "feeId_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> feeIdDisplay;
    @XmlElementRef(name = "discId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> discId;
    @XmlElementRef(name = "discId_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> discIdDisplay;
    @XmlElementRef(name = "reference", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference;

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
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReference(JAXBElement<String> value) {
        this.reference = value;
    }

}
