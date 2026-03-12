
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfaceheaderdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceHeaderFLEXCONTRACT__INVOICES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceHeaderFLEXCONTRACT__INVOICES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/}TransactionInterfaceHeaderFLEX">
 *       &lt;sequence>
 *         &lt;element name="_Contract__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Contract__Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Draft__Invoice__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Contract__Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceHeaderFLEXCONTRACT__INVOICES", propOrder = {
    "contractNumber",
    "contractId",
    "draftInvoiceNumber",
    "contractOrganization"
})
public class TransactionInterfaceHeaderFLEX2
    extends TransactionInterfaceHeaderFLEX
{

    @XmlElementRef(name = "_Contract__Number", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contractNumber;
    @XmlElementRef(name = "_Contract__Id", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contractId;
    @XmlElementRef(name = "_Draft__Invoice__Number", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> draftInvoiceNumber;
    @XmlElementRef(name = "_Contract__Organization", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contractOrganization;

    /**
     * Gets the value of the contractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets the value of the contractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContractNumber(JAXBElement<String> value) {
        this.contractNumber = value;
    }

    /**
     * Gets the value of the contractId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContractId() {
        return contractId;
    }

    /**
     * Sets the value of the contractId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContractId(JAXBElement<String> value) {
        this.contractId = value;
    }

    /**
     * Gets the value of the draftInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDraftInvoiceNumber() {
        return draftInvoiceNumber;
    }

    /**
     * Sets the value of the draftInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDraftInvoiceNumber(JAXBElement<String> value) {
        this.draftInvoiceNumber = value;
    }

    /**
     * Gets the value of the contractOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContractOrganization() {
        return contractOrganization;
    }

    /**
     * Sets the value of the contractOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContractOrganization(JAXBElement<String> value) {
        this.contractOrganization = value;
    }

}
