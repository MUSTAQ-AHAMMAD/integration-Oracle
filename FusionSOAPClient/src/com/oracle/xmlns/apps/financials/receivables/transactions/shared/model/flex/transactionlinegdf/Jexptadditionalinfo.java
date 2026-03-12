
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinegdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Jexptadditionalinfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Jexptadditionalinfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/}TransactionLineGdf">
 *       &lt;sequence>
 *         &lt;element name="ARCno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExcisePayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Jexptadditionalinfo", propOrder = {
    "arCno",
    "excisePayment"
})
public class Jexptadditionalinfo
    extends TransactionLineGdf
{

    @XmlElementRef(name = "ARCno", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> arCno;
    @XmlElementRef(name = "ExcisePayment", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> excisePayment;

    /**
     * Gets the value of the arCno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getARCno() {
        return arCno;
    }

    /**
     * Sets the value of the arCno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setARCno(JAXBElement<String> value) {
        this.arCno = value;
    }

    /**
     * Gets the value of the excisePayment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExcisePayment() {
        return excisePayment;
    }

    /**
     * Sets the value of the excisePayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExcisePayment(JAXBElement<String> value) {
        this.excisePayment = value;
    }

}
