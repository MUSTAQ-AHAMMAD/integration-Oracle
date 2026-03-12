
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceipt;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="standardReceipt" type="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/}StandardReceipt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "standardReceipt"
})
@XmlRootElement(name = "createStandardReceipt")
public class CreateStandardReceipt {

    @XmlElement(required = true)
    protected StandardReceipt standardReceipt;

    /**
     * Gets the value of the standardReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link StandardReceipt }
     *     
     */
    public StandardReceipt getStandardReceipt() {
        return standardReceipt;
    }

    /**
     * Sets the value of the standardReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardReceipt }
     *     
     */
    public void setStandardReceipt(StandardReceipt value) {
        this.standardReceipt = value;
    }

}
