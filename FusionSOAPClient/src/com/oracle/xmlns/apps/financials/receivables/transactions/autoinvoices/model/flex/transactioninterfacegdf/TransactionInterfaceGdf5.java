
package com.oracle.xmlns.apps.financials.receivables.transactions.autoinvoices.model.flex.transactioninterfacegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInterfaceGdfJAxKRReceivablesInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterfaceGdfJAxKRReceivablesInformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/}TransactionInterfaceGdf">
 *       &lt;sequence>
 *         &lt;element name="_SentByElectronicMedia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_SentByElectronicMedia_Display" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterfaceGdfJAxKRReceivablesInformation", propOrder = {
    "sentByElectronicMedia",
    "sentByElectronicMediaDisplay"
})
public class TransactionInterfaceGdf5
    extends TransactionInterfaceGdf
{

    @XmlElementRef(name = "_SentByElectronicMedia", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sentByElectronicMedia;
    @XmlElementRef(name = "_SentByElectronicMedia_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sentByElectronicMediaDisplay;

    /**
     * Gets the value of the sentByElectronicMedia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSentByElectronicMedia() {
        return sentByElectronicMedia;
    }

    /**
     * Sets the value of the sentByElectronicMedia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSentByElectronicMedia(JAXBElement<String> value) {
        this.sentByElectronicMedia = value;
    }

    /**
     * Gets the value of the sentByElectronicMediaDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSentByElectronicMediaDisplay() {
        return sentByElectronicMediaDisplay;
    }

    /**
     * Sets the value of the sentByElectronicMediaDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSentByElectronicMediaDisplay(JAXBElement<String> value) {
        this.sentByElectronicMediaDisplay = value;
    }

}
