
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InterfaceLine;


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
 *         &lt;element name="interfaceLine" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/}InterfaceLine"/>
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
    "interfaceLine"
})
@XmlRootElement(name = "createInterfaceLine")
public class CreateInterfaceLine {

    @XmlElement(required = true)
    protected InterfaceLine interfaceLine;

    /**
     * Gets the value of the interfaceLine property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceLine }
     *     
     */
    public InterfaceLine getInterfaceLine() {
        return interfaceLine;
    }

    /**
     * Sets the value of the interfaceLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceLine }
     *     
     */
    public void setInterfaceLine(InterfaceLine value) {
        this.interfaceLine = value;
    }

}
