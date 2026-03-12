
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.UpdateCCTokenResult;


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
 *         &lt;element name="result" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}UpdateCCTokenResult"/>
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
    "result"
})
@XmlRootElement(name = "createUpdateCCTokenAsyncResponse")
public class CreateUpdateCCTokenAsyncResponse {

    @XmlElement(required = true)
    protected UpdateCCTokenResult result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCCTokenResult }
     *     
     */
    public UpdateCCTokenResult getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCCTokenResult }
     *     
     */
    public void setResult(UpdateCCTokenResult value) {
        this.result = value;
    }

}
