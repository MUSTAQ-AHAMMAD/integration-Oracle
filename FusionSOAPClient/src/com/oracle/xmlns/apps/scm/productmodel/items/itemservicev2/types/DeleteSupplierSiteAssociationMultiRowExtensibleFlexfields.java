
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="associationId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="extensibleFlexFieldLineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="contextCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "associationId",
    "extensibleFlexFieldLineId",
    "contextCode"
})
@XmlRootElement(name = "deleteSupplierSiteAssociationMultiRowExtensibleFlexfields")
public class DeleteSupplierSiteAssociationMultiRowExtensibleFlexfields {

    protected long associationId;
    protected long extensibleFlexFieldLineId;
    @XmlElement(required = true)
    protected String contextCode;

    /**
     * Gets the value of the associationId property.
     * 
     */
    public long getAssociationId() {
        return associationId;
    }

    /**
     * Sets the value of the associationId property.
     * 
     */
    public void setAssociationId(long value) {
        this.associationId = value;
    }

    /**
     * Gets the value of the extensibleFlexFieldLineId property.
     * 
     */
    public long getExtensibleFlexFieldLineId() {
        return extensibleFlexFieldLineId;
    }

    /**
     * Sets the value of the extensibleFlexFieldLineId property.
     * 
     */
    public void setExtensibleFlexFieldLineId(long value) {
        this.extensibleFlexFieldLineId = value;
    }

    /**
     * Gets the value of the contextCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextCode() {
        return contextCode;
    }

    /**
     * Sets the value of the contextCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextCode(String value) {
        this.contextCode = value;
    }

}
