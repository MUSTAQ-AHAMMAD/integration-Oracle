
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InterfaceContingency;


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
 *         &lt;element name="interfaceContingency" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}InterfaceContingency"/>
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
    "interfaceContingency"
})
@XmlRootElement(name = "createInterfaceContingency")
public class CreateInterfaceContingency {

    @XmlElement(required = true)
    protected InterfaceContingency interfaceContingency;

    /**
     * Gets the value of the interfaceContingency property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceContingency }
     *     
     */
    public InterfaceContingency getInterfaceContingency() {
        return interfaceContingency;
    }

    /**
     * Sets the value of the interfaceContingency property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceContingency }
     *     
     */
    public void setInterfaceContingency(InterfaceContingency value) {
        this.interfaceContingency = value;
    }

}
