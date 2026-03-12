
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
 *         &lt;element name="intermediaryAccountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "intermediaryAccountId"
})
@XmlRootElement(name = "getIntermediaryBankAccountRemoteAsync")
public class GetIntermediaryBankAccountRemoteAsync {

    protected long intermediaryAccountId;

    /**
     * Gets the value of the intermediaryAccountId property.
     * 
     */
    public long getIntermediaryAccountId() {
        return intermediaryAccountId;
    }

    /**
     * Sets the value of the intermediaryAccountId property.
     * 
     */
    public void setIntermediaryAccountId(long value) {
        this.intermediaryAccountId = value;
    }

}
