
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.UnapplyReceipt;


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
 *         &lt;element name="unapplyReceipt" type="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/}UnapplyReceipt"/>
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
    "unapplyReceipt"
})
@XmlRootElement(name = "createUnapplyReceiptAsync")
public class CreateUnapplyReceiptAsync {

    @XmlElement(required = true)
    protected UnapplyReceipt unapplyReceipt;

    /**
     * Gets the value of the unapplyReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link UnapplyReceipt }
     *     
     */
    public UnapplyReceipt getUnapplyReceipt() {
        return unapplyReceipt;
    }

    /**
     * Sets the value of the unapplyReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnapplyReceipt }
     *     
     */
    public void setUnapplyReceipt(UnapplyReceipt value) {
        this.unapplyReceipt = value;
    }

}
