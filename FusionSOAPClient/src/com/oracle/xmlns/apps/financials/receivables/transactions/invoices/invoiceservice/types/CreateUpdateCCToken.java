
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.UpdateCCToken;


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
 *         &lt;element name="updateCCToken" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}UpdateCCToken"/>
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
    "updateCCToken"
})
@XmlRootElement(name = "createUpdateCCToken")
public class CreateUpdateCCToken {

    @XmlElement(required = true)
    protected UpdateCCToken updateCCToken;

    /**
     * Gets the value of the updateCCToken property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCCToken }
     *     
     */
    public UpdateCCToken getUpdateCCToken() {
        return updateCCToken;
    }

    /**
     * Sets the value of the updateCCToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCCToken }
     *     
     */
    public void setUpdateCCToken(UpdateCCToken value) {
        this.updateCCToken = value;
    }

}
