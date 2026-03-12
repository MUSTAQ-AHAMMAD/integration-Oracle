
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InterfaceSalesCredit;


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
 *         &lt;element name="interfaceSalesCredit" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}InterfaceSalesCredit"/>
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
    "interfaceSalesCredit"
})
@XmlRootElement(name = "createInterfaceSalesCredit")
public class CreateInterfaceSalesCredit {

    @XmlElement(required = true)
    protected InterfaceSalesCredit interfaceSalesCredit;

    /**
     * Gets the value of the interfaceSalesCredit property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceSalesCredit }
     *     
     */
    public InterfaceSalesCredit getInterfaceSalesCredit() {
        return interfaceSalesCredit;
    }

    /**
     * Sets the value of the interfaceSalesCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceSalesCredit }
     *     
     */
    public void setInterfaceSalesCredit(InterfaceSalesCredit value) {
        this.interfaceSalesCredit = value;
    }

}
