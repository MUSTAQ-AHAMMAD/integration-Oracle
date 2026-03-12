
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.UnapplyOnAccount;


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
 *         &lt;element name="unapplyOnAccount" type="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/}UnapplyOnAccount"/>
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
    "unapplyOnAccount"
})
@XmlRootElement(name = "createUnapplyOnAccountAsync")
public class CreateUnapplyOnAccountAsync {

    @XmlElement(required = true)
    protected UnapplyOnAccount unapplyOnAccount;

    /**
     * Gets the value of the unapplyOnAccount property.
     * 
     * @return
     *     possible object is
     *     {@link UnapplyOnAccount }
     *     
     */
    public UnapplyOnAccount getUnapplyOnAccount() {
        return unapplyOnAccount;
    }

    /**
     * Sets the value of the unapplyOnAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnapplyOnAccount }
     *     
     */
    public void setUnapplyOnAccount(UnapplyOnAccount value) {
        this.unapplyOnAccount = value;
    }

}
