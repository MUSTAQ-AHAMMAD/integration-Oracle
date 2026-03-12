
package com.oracle.xmlns.apps.financials.generalledger.journals.desktopentry.journalimportservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.oracle.xmlns.adf.svc.types.ObjAttrHints;


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
 *         &lt;element name="result" type="{http://xmlns.oracle.com/adf/svc/types/}ObjAttrHints"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "result" })
@XmlRootElement(name = "getDfltObjAttrHintsResponse")
public class GetDfltObjAttrHintsResponse {

    @XmlElement(required = true)
    protected ObjAttrHints result;

    /**
     * Gets the value of the result property.
     *
     * @return
     *     possible object is
     *     {@link ObjAttrHints }
     *
     */
    public ObjAttrHints getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     *
     * @param value
     *     allowed object is
     *     {@link ObjAttrHints }
     *
     */
    public void setResult(ObjAttrHints value) {
        this.result = value;
    }

}
