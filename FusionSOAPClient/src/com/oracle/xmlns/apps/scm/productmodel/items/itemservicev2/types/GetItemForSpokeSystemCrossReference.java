
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
 *         &lt;element name="sourceSystemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="crossReference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="organizationId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "sourceSystemId",
    "sourceSystem",
    "crossReference",
    "organizationId"
})
@XmlRootElement(name = "getItemForSpokeSystemCrossReference")
public class GetItemForSpokeSystemCrossReference {

    protected long sourceSystemId;
    @XmlElement(required = true)
    protected String sourceSystem;
    @XmlElement(required = true)
    protected String crossReference;
    protected long organizationId;

    /**
     * Gets the value of the sourceSystemId property.
     * 
     */
    public long getSourceSystemId() {
        return sourceSystemId;
    }

    /**
     * Sets the value of the sourceSystemId property.
     * 
     */
    public void setSourceSystemId(long value) {
        this.sourceSystemId = value;
    }

    /**
     * Gets the value of the sourceSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the value of the sourceSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystem(String value) {
        this.sourceSystem = value;
    }

    /**
     * Gets the value of the crossReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrossReference() {
        return crossReference;
    }

    /**
     * Sets the value of the crossReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrossReference(String value) {
        this.crossReference = value;
    }

    /**
     * Gets the value of the organizationId property.
     * 
     */
    public long getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets the value of the organizationId property.
     * 
     */
    public void setOrganizationId(long value) {
        this.organizationId = value;
    }

}
