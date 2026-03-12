
package com.oracle.xmlns.apps.scm.productmodel.catalogs.itemcatalogservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.category.CategoryDFF;


/**
 * <p>Java class for Category complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Category">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CatalogCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="RestrictCategoryToItemAssignmentOnlyFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ESSRequestId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CategoryDFF" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/}CategoryDFF" minOccurs="0"/>
 *         &lt;element name="CategoryTranslation" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}CategoryTranslation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Attachment" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}Attachment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Category", propOrder = {
    "categoryName",
    "categoryCode",
    "categoryId",
    "description",
    "catalogCode",
    "parentCategoryCode",
    "startDate",
    "endDate",
    "restrictCategoryToItemAssignmentOnlyFlag",
    "essRequestId",
    "categoryDFF",
    "categoryTranslation",
    "attachment"
})
public class Category {

    @XmlElement(name = "CategoryName")
    protected String categoryName;
    @XmlElement(name = "CategoryCode")
    protected String categoryCode;
    @XmlElement(name = "CategoryId")
    protected Long categoryId;
    @XmlElementRef(name = "Description", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "CatalogCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> catalogCode;
    @XmlElementRef(name = "ParentCategoryCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> parentCategoryCode;
    @XmlElementRef(name = "StartDate", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startDate;
    @XmlElementRef(name = "EndDate", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDate;
    @XmlElementRef(name = "RestrictCategoryToItemAssignmentOnlyFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> restrictCategoryToItemAssignmentOnlyFlag;
    @XmlElementRef(name = "ESSRequestId", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> essRequestId;
    @XmlElement(name = "CategoryDFF")
    protected CategoryDFF categoryDFF;
    @XmlElement(name = "CategoryTranslation")
    protected List<CategoryTranslation> categoryTranslation;
    @XmlElement(name = "Attachment")
    protected List<Attachment> attachment;

    /**
     * Gets the value of the categoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

    /**
     * Gets the value of the categoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
    }

    /**
     * Gets the value of the categoryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCategoryId(Long value) {
        this.categoryId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

    /**
     * Gets the value of the catalogCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCatalogCode() {
        return catalogCode;
    }

    /**
     * Sets the value of the catalogCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCatalogCode(JAXBElement<String> value) {
        this.catalogCode = value;
    }

    /**
     * Gets the value of the parentCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParentCategoryCode() {
        return parentCategoryCode;
    }

    /**
     * Sets the value of the parentCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParentCategoryCode(JAXBElement<String> value) {
        this.parentCategoryCode = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setStartDate(JAXBElement<XMLGregorianCalendar> value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEndDate(JAXBElement<XMLGregorianCalendar> value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the restrictCategoryToItemAssignmentOnlyFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRestrictCategoryToItemAssignmentOnlyFlag() {
        return restrictCategoryToItemAssignmentOnlyFlag;
    }

    /**
     * Sets the value of the restrictCategoryToItemAssignmentOnlyFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRestrictCategoryToItemAssignmentOnlyFlag(JAXBElement<Boolean> value) {
        this.restrictCategoryToItemAssignmentOnlyFlag = value;
    }

    /**
     * Gets the value of the essRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getESSRequestId() {
        return essRequestId;
    }

    /**
     * Sets the value of the essRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setESSRequestId(JAXBElement<Long> value) {
        this.essRequestId = value;
    }

    /**
     * Gets the value of the categoryDFF property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryDFF }
     *     
     */
    public CategoryDFF getCategoryDFF() {
        return categoryDFF;
    }

    /**
     * Sets the value of the categoryDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryDFF }
     *     
     */
    public void setCategoryDFF(CategoryDFF value) {
        this.categoryDFF = value;
    }

    /**
     * Gets the value of the categoryTranslation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryTranslation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryTranslation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryTranslation }
     * 
     * 
     */
    public List<CategoryTranslation> getCategoryTranslation() {
        if (categoryTranslation == null) {
            categoryTranslation = new ArrayList<CategoryTranslation>();
        }
        return this.categoryTranslation;
    }

    /**
     * Gets the value of the attachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getAttachment() {
        if (attachment == null) {
            attachment = new ArrayList<Attachment>();
        }
        return this.attachment;
    }

}
