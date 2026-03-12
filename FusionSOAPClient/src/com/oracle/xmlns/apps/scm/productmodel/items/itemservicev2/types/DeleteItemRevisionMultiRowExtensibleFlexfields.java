
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
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="itemRevision" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "itemId",
    "orgId",
    "itemRevision",
    "extensibleFlexFieldLineId",
    "contextCode"
})
@XmlRootElement(name = "deleteItemRevisionMultiRowExtensibleFlexfields")
public class DeleteItemRevisionMultiRowExtensibleFlexfields {

    protected long itemId;
    protected long orgId;
    @XmlElement(required = true)
    protected String itemRevision;
    protected long extensibleFlexFieldLineId;
    @XmlElement(required = true)
    protected String contextCode;

    /**
     * Gets the value of the itemId property.
     * 
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(long value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the orgId property.
     * 
     */
    public long getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     */
    public void setOrgId(long value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the itemRevision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemRevision() {
        return itemRevision;
    }

    /**
     * Sets the value of the itemRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemRevision(String value) {
        this.itemRevision = value;
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
