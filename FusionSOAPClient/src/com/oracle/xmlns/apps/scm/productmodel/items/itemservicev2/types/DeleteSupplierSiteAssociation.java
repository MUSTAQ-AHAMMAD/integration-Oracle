
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
 *         &lt;element name="deleteGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "deleteGroupName"
})
@XmlRootElement(name = "deleteSupplierSiteAssociation")
public class DeleteSupplierSiteAssociation {

    protected long associationId;
    @XmlElement(required = true)
    protected String deleteGroupName;

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
     * Gets the value of the deleteGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteGroupName() {
        return deleteGroupName;
    }

    /**
     * Sets the value of the deleteGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteGroupName(String value) {
        this.deleteGroupName = value;
    }

}
