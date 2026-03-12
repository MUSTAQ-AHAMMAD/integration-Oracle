
package com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GlInterfaceTransHeader complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlInterfaceTransHeader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BatchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BatchDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LedgerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="AccountingPeriodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountingDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/&gt;
 *         &lt;element name="UserSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ErrorToSuspenseFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="SummaryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ImportDescriptiveFlexField" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GlInterface" type="{http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/}GlInterface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlInterfaceTransHeader", propOrder = {
         "batchName", "batchDescription", "ledgerId", "accountingPeriodName", "accountingDate", "userSourceName",
         "userCategoryName", "errorToSuspenseFlag", "summaryFlag", "importDescriptiveFlexField", "glInterface"
    })
public class GlInterfaceTransHeader {

    @XmlElementRef(name = "BatchName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> batchName;
    @XmlElementRef(name = "BatchDescription",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> batchDescription;
    @XmlElementRef(name = "LedgerId",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Long> ledgerId;
    @XmlElementRef(name = "AccountingPeriodName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountingPeriodName;
    @XmlElementRef(name = "AccountingDate",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> accountingDate;
    @XmlElementRef(name = "UserSourceName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> userSourceName;
    @XmlElementRef(name = "UserCategoryName",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> userCategoryName;
    @XmlElementRef(name = "ErrorToSuspenseFlag",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> errorToSuspenseFlag;
    @XmlElementRef(name = "SummaryFlag",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> summaryFlag;
    @XmlElementRef(name = "ImportDescriptiveFlexField",
                   namespace =
                   "http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/",
                   type = JAXBElement.class, required = false)
    protected JAXBElement<String> importDescriptiveFlexField;
    @XmlElement(name = "GlInterface")
    protected List<GlInterface> glInterface;

    /**
     * Gets the value of the batchName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getBatchName() {
        return batchName;
    }

    /**
     * Sets the value of the batchName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setBatchName(JAXBElement<String> value) {
        this.batchName = value;
    }

    /**
     * Gets the value of the batchDescription property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getBatchDescription() {
        return batchDescription;
    }

    /**
     * Sets the value of the batchDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setBatchDescription(JAXBElement<String> value) {
        this.batchDescription = value;
    }

    /**
     * Gets the value of the ledgerId property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public JAXBElement<Long> getLedgerId() {
        return ledgerId;
    }

    /**
     * Sets the value of the ledgerId property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *
     */
    public void setLedgerId(JAXBElement<Long> value) {
        this.ledgerId = value;
    }

    /**
     * Gets the value of the accountingPeriodName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getAccountingPeriodName() {
        return accountingPeriodName;
    }

    /**
     * Sets the value of the accountingPeriodName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setAccountingPeriodName(JAXBElement<String> value) {
        this.accountingPeriodName = value;
    }

    /**
     * Gets the value of the accountingDate property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public JAXBElement<XMLGregorianCalendar> getAccountingDate() {
        return accountingDate;
    }

    /**
     * Sets the value of the accountingDate property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *
     */
    public void setAccountingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.accountingDate = value;
    }

    /**
     * Gets the value of the userSourceName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getUserSourceName() {
        return userSourceName;
    }

    /**
     * Sets the value of the userSourceName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setUserSourceName(JAXBElement<String> value) {
        this.userSourceName = value;
    }

    /**
     * Gets the value of the userCategoryName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getUserCategoryName() {
        return userCategoryName;
    }

    /**
     * Sets the value of the userCategoryName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setUserCategoryName(JAXBElement<String> value) {
        this.userCategoryName = value;
    }

    /**
     * Gets the value of the errorToSuspenseFlag property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public JAXBElement<Boolean> getErrorToSuspenseFlag() {
        return errorToSuspenseFlag;
    }

    /**
     * Sets the value of the errorToSuspenseFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public void setErrorToSuspenseFlag(JAXBElement<Boolean> value) {
        this.errorToSuspenseFlag = value;
    }

    /**
     * Gets the value of the summaryFlag property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public JAXBElement<Boolean> getSummaryFlag() {
        return summaryFlag;
    }

    /**
     * Sets the value of the summaryFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *
     */
    public void setSummaryFlag(JAXBElement<Boolean> value) {
        this.summaryFlag = value;
    }

    /**
     * Gets the value of the importDescriptiveFlexField property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getImportDescriptiveFlexField() {
        return importDescriptiveFlexField;
    }

    /**
     * Sets the value of the importDescriptiveFlexField property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setImportDescriptiveFlexField(JAXBElement<String> value) {
        this.importDescriptiveFlexField = value;
    }

    /**
     * Gets the value of the glInterface property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the glInterface property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlInterface().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlInterface }
     *
     *
     */
    public List<GlInterface> getGlInterface() {
        if (glInterface == null) {
            glInterface = new ArrayList<GlInterface>();
        }
        return this.glInterface;
    }

}
