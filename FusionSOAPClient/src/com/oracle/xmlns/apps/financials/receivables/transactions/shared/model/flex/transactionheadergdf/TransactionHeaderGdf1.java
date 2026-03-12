
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheadergdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionHeaderGdfJAxKRReceivablesInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionHeaderGdfJAxKRReceivablesInformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/}TransactionHeaderGdf">
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
@XmlType(name = "TransactionHeaderGdfJAxKRReceivablesInformation", propOrder = {
    "sentByElectronicMedia",
    "sentByElectronicMediaDisplay"
})
public class TransactionHeaderGdf1
    extends TransactionHeaderGdf
{

    @XmlElementRef(name = "_SentByElectronicMedia", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sentByElectronicMedia;
    @XmlElementRef(name = "_SentByElectronicMedia_Display", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/", type = JAXBElement.class, required = false)
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
