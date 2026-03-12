
package com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="externalBankAccountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "externalBankAccountId"
})
@XmlRootElement(name = "getExternalBankAccountDetails")
public class GetExternalBankAccountDetails {

    protected long externalBankAccountId;

    /**
     * Gets the value of the externalBankAccountId property.
     * 
     */
    public long getExternalBankAccountId() {
        return externalBankAccountId;
    }

    /**
     * Sets the value of the externalBankAccountId property.
     * 
     */
    public void setExternalBankAccountId(long value) {
        this.externalBankAccountId = value;
    }

}
