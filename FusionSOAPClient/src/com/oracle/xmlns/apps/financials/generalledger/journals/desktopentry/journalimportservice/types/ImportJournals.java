
package com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.GlInterfaceTransHeader;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="interfaceRows" type="{http://xmlns.oracle.com/apps/financials/generalLedger/journals/desktopEntry/journalImportService/}GlInterfaceTransHeader"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "interfaceRows" })
@XmlRootElement(name = "importJournals")
public class ImportJournals {

    @XmlElement(required = true)
    protected GlInterfaceTransHeader interfaceRows;

    /**
     * Gets the value of the interfaceRows property.
     *
     * @return
     *     possible object is
     *     {@link GlInterfaceTransHeader }
     *
     */
    public GlInterfaceTransHeader getInterfaceRows() {
        return interfaceRows;
    }

    /**
     * Sets the value of the interfaceRows property.
     *
     * @param value
     *     allowed object is
     *     {@link GlInterfaceTransHeader }
     *
     */
    public void setInterfaceRows(GlInterfaceTransHeader value) {
        this.interfaceRows = value;
    }

}
