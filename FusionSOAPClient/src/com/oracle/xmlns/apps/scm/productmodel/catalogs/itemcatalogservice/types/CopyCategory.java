
package com.oracle.xmlns.apps.scm.productmodel.catalogs.itemcatalogservice.types;

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
 *         &lt;element name="sourceCatalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetCatalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CopyChildCategoriesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CopyItemAssignmentsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sourceCatalogCode",
    "sourceCategoryCode",
    "targetCatalogCode",
    "targetCategoryCode",
    "copyChildCategoriesFlag",
    "copyItemAssignmentsFlag"
})
@XmlRootElement(name = "copyCategory")
public class CopyCategory {

    @XmlElement(required = true)
    protected String sourceCatalogCode;
    @XmlElement(required = true)
    protected String sourceCategoryCode;
    @XmlElement(required = true)
    protected String targetCatalogCode;
    protected String targetCategoryCode;
    @XmlElement(name = "CopyChildCategoriesFlag")
    protected boolean copyChildCategoriesFlag;
    @XmlElement(name = "CopyItemAssignmentsFlag")
    protected boolean copyItemAssignmentsFlag;

    /**
     * Gets the value of the sourceCatalogCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCatalogCode() {
        return sourceCatalogCode;
    }

    /**
     * Sets the value of the sourceCatalogCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCatalogCode(String value) {
        this.sourceCatalogCode = value;
    }

    /**
     * Gets the value of the sourceCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCategoryCode() {
        return sourceCategoryCode;
    }

    /**
     * Sets the value of the sourceCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCategoryCode(String value) {
        this.sourceCategoryCode = value;
    }

    /**
     * Gets the value of the targetCatalogCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetCatalogCode() {
        return targetCatalogCode;
    }

    /**
     * Sets the value of the targetCatalogCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetCatalogCode(String value) {
        this.targetCatalogCode = value;
    }

    /**
     * Gets the value of the targetCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetCategoryCode() {
        return targetCategoryCode;
    }

    /**
     * Sets the value of the targetCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetCategoryCode(String value) {
        this.targetCategoryCode = value;
    }

    /**
     * Gets the value of the copyChildCategoriesFlag property.
     * 
     */
    public boolean isCopyChildCategoriesFlag() {
        return copyChildCategoriesFlag;
    }

    /**
     * Sets the value of the copyChildCategoriesFlag property.
     * 
     */
    public void setCopyChildCategoriesFlag(boolean value) {
        this.copyChildCategoriesFlag = value;
    }

    /**
     * Gets the value of the copyItemAssignmentsFlag property.
     * 
     */
    public boolean isCopyItemAssignmentsFlag() {
        return copyItemAssignmentsFlag;
    }

    /**
     * Sets the value of the copyItemAssignmentsFlag property.
     * 
     */
    public void setCopyItemAssignmentsFlag(boolean value) {
        this.copyItemAssignmentsFlag = value;
    }

}
