
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.standardreceiptgdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StandardReceiptGdfJA_5FCN_5FREMIT_5FBILL_5FNUM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardReceiptGdfJA_5FCN_5FREMIT_5FBILL_5FNUM">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/}StandardReceiptGdf">
 *       &lt;sequence>
 *         &lt;element name="_Remittance__Bill__Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardReceiptGdfJA_5FCN_5FREMIT_5FBILL_5FNUM", propOrder = {
    "remittanceBillNumber"
})
public class StandardReceiptGdf1
    extends StandardReceiptGdf
{

    @XmlElementRef(name = "_Remittance__Bill__Number", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remittanceBillNumber;

    /**
     * Gets the value of the remittanceBillNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemittanceBillNumber() {
        return remittanceBillNumber;
    }

    /**
     * Sets the value of the remittanceBillNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemittanceBillNumber(JAXBElement<String> value) {
        this.remittanceBillNumber = value;
    }

}
