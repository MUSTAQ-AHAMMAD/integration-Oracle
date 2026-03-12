
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JExRUAdditionalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JExRUAdditionalInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
 *       &lt;sequence>
 *         &lt;element name="FLEX_PARAM_DocumentSubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_OrgId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_InvoiceDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_BillToSiteUseId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FLEX_PARAM_CustomerTrxId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PrintStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrintStatus_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreviousInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PreviousInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevisedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RevisedInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevisionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorrectedInvoice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CorrectedInvoice_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxPointDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="ConsignorParty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsignorParty_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Consignor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Consignor_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSupplier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSupplier_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnSupplierSite" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnSupplierSite_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnSupplierInv" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnSupplierInv_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnCustomer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnCustomer_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnCustomerSite" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IntermediaryTrxnCustomerSite_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfirmedbyThirdParties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrepaymentCashReceipt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PrepaymentCashReceipt_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CancellationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CancellationType_DisplayValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JExRUAdditionalInfo", propOrder = {
    "flexparamDocumentSubType",
    "flexparamOrgId",
    "flexparamInvoiceDate",
    "flexparamBillToSiteUseId",
    "flexparamCustomerTrxId",
    "printStatus",
    "printStatusDisplay",
    "previousInvoice",
    "previousInvoiceDisplay",
    "revisedInvoice",
    "revisedInvoiceDisplay",
    "revisionNumber",
    "correctedInvoice",
    "correctedInvoiceDisplay",
    "taxPointDate",
    "consignorParty",
    "consignorPartyDisplay",
    "consignor",
    "consignorDisplay",
    "sourceSupplier",
    "sourceSupplierDisplay",
    "intermediaryTrxnSupplierSite",
    "intermediaryTrxnSupplierSiteDisplay",
    "intermediaryTrxnSupplierInv",
    "intermediaryTrxnSupplierInvDisplay",
    "intermediaryTrxnCustomer",
    "intermediaryTrxnCustomerDisplay",
    "intermediaryTrxnCustomerSite",
    "intermediaryTrxnCustomerSiteDisplay",
    "confirmedbyThirdParties",
    "prepaymentCashReceipt",
    "prepaymentCashReceiptDisplay",
    "cancellationType",
    "cancellationTypeDisplayValue"
})
public class JExRUAdditionalInfo
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "FLEX_PARAM_DocumentSubType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flexparamDocumentSubType;
    @XmlElementRef(name = "FLEX_PARAM_OrgId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamOrgId;
    @XmlElementRef(name = "FLEX_PARAM_InvoiceDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> flexparamInvoiceDate;
    @XmlElementRef(name = "FLEX_PARAM_BillToSiteUseId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamBillToSiteUseId;
    @XmlElementRef(name = "FLEX_PARAM_CustomerTrxId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> flexparamCustomerTrxId;
    @XmlElementRef(name = "PrintStatus", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> printStatus;
    @XmlElementRef(name = "PrintStatus_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> printStatusDisplay;
    @XmlElementRef(name = "PreviousInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> previousInvoice;
    @XmlElementRef(name = "PreviousInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> previousInvoiceDisplay;
    @XmlElementRef(name = "RevisedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> revisedInvoice;
    @XmlElementRef(name = "RevisedInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> revisedInvoiceDisplay;
    @XmlElementRef(name = "RevisionNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> revisionNumber;
    @XmlElementRef(name = "CorrectedInvoice", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> correctedInvoice;
    @XmlElementRef(name = "CorrectedInvoice_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> correctedInvoiceDisplay;
    @XmlElementRef(name = "TaxPointDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> taxPointDate;
    @XmlElementRef(name = "ConsignorParty", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consignorParty;
    @XmlElementRef(name = "ConsignorParty_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consignorPartyDisplay;
    @XmlElementRef(name = "Consignor", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> consignor;
    @XmlElementRef(name = "Consignor_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consignorDisplay;
    @XmlElementRef(name = "SourceSupplier", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceSupplier;
    @XmlElementRef(name = "SourceSupplier_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceSupplierDisplay;
    @XmlElementRef(name = "IntermediaryTrxnSupplierSite", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> intermediaryTrxnSupplierSite;
    @XmlElementRef(name = "IntermediaryTrxnSupplierSite_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intermediaryTrxnSupplierSiteDisplay;
    @XmlElementRef(name = "IntermediaryTrxnSupplierInv", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> intermediaryTrxnSupplierInv;
    @XmlElementRef(name = "IntermediaryTrxnSupplierInv_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intermediaryTrxnSupplierInvDisplay;
    @XmlElementRef(name = "IntermediaryTrxnCustomer", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intermediaryTrxnCustomer;
    @XmlElementRef(name = "IntermediaryTrxnCustomer_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intermediaryTrxnCustomerDisplay;
    @XmlElementRef(name = "IntermediaryTrxnCustomerSite", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> intermediaryTrxnCustomerSite;
    @XmlElementRef(name = "IntermediaryTrxnCustomerSite_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intermediaryTrxnCustomerSiteDisplay;
    @XmlElementRef(name = "ConfirmedbyThirdParties", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> confirmedbyThirdParties;
    @XmlElementRef(name = "PrepaymentCashReceipt", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> prepaymentCashReceipt;
    @XmlElementRef(name = "PrepaymentCashReceipt_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> prepaymentCashReceiptDisplay;
    @XmlElementRef(name = "CancellationType", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cancellationType;
    @XmlElementRef(name = "CancellationType_DisplayValue", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cancellationTypeDisplayValue;

    /**
     * Gets the value of the flexparamDocumentSubType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFLEXPARAMDocumentSubType() {
        return flexparamDocumentSubType;
    }

    /**
     * Sets the value of the flexparamDocumentSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFLEXPARAMDocumentSubType(JAXBElement<String> value) {
        this.flexparamDocumentSubType = value;
    }

    /**
     * Gets the value of the flexparamOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMOrgId() {
        return flexparamOrgId;
    }

    /**
     * Sets the value of the flexparamOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMOrgId(JAXBElement<BigDecimal> value) {
        this.flexparamOrgId = value;
    }

    /**
     * Gets the value of the flexparamInvoiceDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFLEXPARAMInvoiceDate() {
        return flexparamInvoiceDate;
    }

    /**
     * Sets the value of the flexparamInvoiceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFLEXPARAMInvoiceDate(JAXBElement<XMLGregorianCalendar> value) {
        this.flexparamInvoiceDate = value;
    }

    /**
     * Gets the value of the flexparamBillToSiteUseId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMBillToSiteUseId() {
        return flexparamBillToSiteUseId;
    }

    /**
     * Sets the value of the flexparamBillToSiteUseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMBillToSiteUseId(JAXBElement<BigDecimal> value) {
        this.flexparamBillToSiteUseId = value;
    }

    /**
     * Gets the value of the flexparamCustomerTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFLEXPARAMCustomerTrxId() {
        return flexparamCustomerTrxId;
    }

    /**
     * Sets the value of the flexparamCustomerTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFLEXPARAMCustomerTrxId(JAXBElement<BigDecimal> value) {
        this.flexparamCustomerTrxId = value;
    }

    /**
     * Gets the value of the printStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrintStatus() {
        return printStatus;
    }

    /**
     * Sets the value of the printStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrintStatus(JAXBElement<String> value) {
        this.printStatus = value;
    }

    /**
     * Gets the value of the printStatusDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrintStatusDisplay() {
        return printStatusDisplay;
    }

    /**
     * Sets the value of the printStatusDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrintStatusDisplay(JAXBElement<String> value) {
        this.printStatusDisplay = value;
    }

    /**
     * Gets the value of the previousInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPreviousInvoice() {
        return previousInvoice;
    }

    /**
     * Sets the value of the previousInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPreviousInvoice(JAXBElement<BigDecimal> value) {
        this.previousInvoice = value;
    }

    /**
     * Gets the value of the previousInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreviousInvoiceDisplay() {
        return previousInvoiceDisplay;
    }

    /**
     * Sets the value of the previousInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreviousInvoiceDisplay(JAXBElement<String> value) {
        this.previousInvoiceDisplay = value;
    }

    /**
     * Gets the value of the revisedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getRevisedInvoice() {
        return revisedInvoice;
    }

    /**
     * Sets the value of the revisedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setRevisedInvoice(JAXBElement<BigDecimal> value) {
        this.revisedInvoice = value;
    }

    /**
     * Gets the value of the revisedInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRevisedInvoiceDisplay() {
        return revisedInvoiceDisplay;
    }

    /**
     * Sets the value of the revisedInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRevisedInvoiceDisplay(JAXBElement<String> value) {
        this.revisedInvoiceDisplay = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRevisionNumber(JAXBElement<String> value) {
        this.revisionNumber = value;
    }

    /**
     * Gets the value of the correctedInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getCorrectedInvoice() {
        return correctedInvoice;
    }

    /**
     * Sets the value of the correctedInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setCorrectedInvoice(JAXBElement<BigDecimal> value) {
        this.correctedInvoice = value;
    }

    /**
     * Gets the value of the correctedInvoiceDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorrectedInvoiceDisplay() {
        return correctedInvoiceDisplay;
    }

    /**
     * Sets the value of the correctedInvoiceDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorrectedInvoiceDisplay(JAXBElement<String> value) {
        this.correctedInvoiceDisplay = value;
    }

    /**
     * Gets the value of the taxPointDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * Sets the value of the taxPointDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setTaxPointDate(JAXBElement<XMLGregorianCalendar> value) {
        this.taxPointDate = value;
    }

    /**
     * Gets the value of the consignorParty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsignorParty() {
        return consignorParty;
    }

    /**
     * Sets the value of the consignorParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsignorParty(JAXBElement<String> value) {
        this.consignorParty = value;
    }

    /**
     * Gets the value of the consignorPartyDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsignorPartyDisplay() {
        return consignorPartyDisplay;
    }

    /**
     * Sets the value of the consignorPartyDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsignorPartyDisplay(JAXBElement<String> value) {
        this.consignorPartyDisplay = value;
    }

    /**
     * Gets the value of the consignor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getConsignor() {
        return consignor;
    }

    /**
     * Sets the value of the consignor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setConsignor(JAXBElement<BigDecimal> value) {
        this.consignor = value;
    }

    /**
     * Gets the value of the consignorDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsignorDisplay() {
        return consignorDisplay;
    }

    /**
     * Sets the value of the consignorDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsignorDisplay(JAXBElement<String> value) {
        this.consignorDisplay = value;
    }

    /**
     * Gets the value of the sourceSupplier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceSupplier() {
        return sourceSupplier;
    }

    /**
     * Sets the value of the sourceSupplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceSupplier(JAXBElement<String> value) {
        this.sourceSupplier = value;
    }

    /**
     * Gets the value of the sourceSupplierDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceSupplierDisplay() {
        return sourceSupplierDisplay;
    }

    /**
     * Sets the value of the sourceSupplierDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceSupplierDisplay(JAXBElement<String> value) {
        this.sourceSupplierDisplay = value;
    }

    /**
     * Gets the value of the intermediaryTrxnSupplierSite property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIntermediaryTrxnSupplierSite() {
        return intermediaryTrxnSupplierSite;
    }

    /**
     * Sets the value of the intermediaryTrxnSupplierSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIntermediaryTrxnSupplierSite(JAXBElement<BigDecimal> value) {
        this.intermediaryTrxnSupplierSite = value;
    }

    /**
     * Gets the value of the intermediaryTrxnSupplierSiteDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntermediaryTrxnSupplierSiteDisplay() {
        return intermediaryTrxnSupplierSiteDisplay;
    }

    /**
     * Sets the value of the intermediaryTrxnSupplierSiteDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntermediaryTrxnSupplierSiteDisplay(JAXBElement<String> value) {
        this.intermediaryTrxnSupplierSiteDisplay = value;
    }

    /**
     * Gets the value of the intermediaryTrxnSupplierInv property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIntermediaryTrxnSupplierInv() {
        return intermediaryTrxnSupplierInv;
    }

    /**
     * Sets the value of the intermediaryTrxnSupplierInv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIntermediaryTrxnSupplierInv(JAXBElement<BigDecimal> value) {
        this.intermediaryTrxnSupplierInv = value;
    }

    /**
     * Gets the value of the intermediaryTrxnSupplierInvDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntermediaryTrxnSupplierInvDisplay() {
        return intermediaryTrxnSupplierInvDisplay;
    }

    /**
     * Sets the value of the intermediaryTrxnSupplierInvDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntermediaryTrxnSupplierInvDisplay(JAXBElement<String> value) {
        this.intermediaryTrxnSupplierInvDisplay = value;
    }

    /**
     * Gets the value of the intermediaryTrxnCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntermediaryTrxnCustomer() {
        return intermediaryTrxnCustomer;
    }

    /**
     * Sets the value of the intermediaryTrxnCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntermediaryTrxnCustomer(JAXBElement<String> value) {
        this.intermediaryTrxnCustomer = value;
    }

    /**
     * Gets the value of the intermediaryTrxnCustomerDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntermediaryTrxnCustomerDisplay() {
        return intermediaryTrxnCustomerDisplay;
    }

    /**
     * Sets the value of the intermediaryTrxnCustomerDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntermediaryTrxnCustomerDisplay(JAXBElement<String> value) {
        this.intermediaryTrxnCustomerDisplay = value;
    }

    /**
     * Gets the value of the intermediaryTrxnCustomerSite property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getIntermediaryTrxnCustomerSite() {
        return intermediaryTrxnCustomerSite;
    }

    /**
     * Sets the value of the intermediaryTrxnCustomerSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setIntermediaryTrxnCustomerSite(JAXBElement<BigDecimal> value) {
        this.intermediaryTrxnCustomerSite = value;
    }

    /**
     * Gets the value of the intermediaryTrxnCustomerSiteDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntermediaryTrxnCustomerSiteDisplay() {
        return intermediaryTrxnCustomerSiteDisplay;
    }

    /**
     * Sets the value of the intermediaryTrxnCustomerSiteDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntermediaryTrxnCustomerSiteDisplay(JAXBElement<String> value) {
        this.intermediaryTrxnCustomerSiteDisplay = value;
    }

    /**
     * Gets the value of the confirmedbyThirdParties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfirmedbyThirdParties() {
        return confirmedbyThirdParties;
    }

    /**
     * Sets the value of the confirmedbyThirdParties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfirmedbyThirdParties(JAXBElement<String> value) {
        this.confirmedbyThirdParties = value;
    }

    /**
     * Gets the value of the prepaymentCashReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPrepaymentCashReceipt() {
        return prepaymentCashReceipt;
    }

    /**
     * Sets the value of the prepaymentCashReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPrepaymentCashReceipt(JAXBElement<BigDecimal> value) {
        this.prepaymentCashReceipt = value;
    }

    /**
     * Gets the value of the prepaymentCashReceiptDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrepaymentCashReceiptDisplay() {
        return prepaymentCashReceiptDisplay;
    }

    /**
     * Sets the value of the prepaymentCashReceiptDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrepaymentCashReceiptDisplay(JAXBElement<String> value) {
        this.prepaymentCashReceiptDisplay = value;
    }

    /**
     * Gets the value of the cancellationType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCancellationType() {
        return cancellationType;
    }

    /**
     * Sets the value of the cancellationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCancellationType(JAXBElement<String> value) {
        this.cancellationType = value;
    }

    /**
     * Gets the value of the cancellationTypeDisplayValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCancellationTypeDisplayValue() {
        return cancellationTypeDisplayValue;
    }

    /**
     * Sets the value of the cancellationTypeDisplayValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCancellationTypeDisplayValue(JAXBElement<String> value) {
        this.cancellationTypeDisplayValue = value;
    }

}
