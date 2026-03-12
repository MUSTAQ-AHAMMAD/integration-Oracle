
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.types;

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
 *         &lt;element name="itemCategoryAssignmentId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "itemCategoryAssignmentId"
})
@XmlRootElement(name = "deleteItemCategoryAssociation")
public class DeleteItemCategoryAssociation {

    protected long itemCategoryAssignmentId;

    /**
     * Gets the value of the itemCategoryAssignmentId property.
     * 
     */
    public long getItemCategoryAssignmentId() {
        return itemCategoryAssignmentId;
    }

    /**
     * Sets the value of the itemCategoryAssignmentId property.
     * 
     */
    public void setItemCategoryAssignmentId(long value) {
        this.itemCategoryAssignmentId = value;
    }

}
