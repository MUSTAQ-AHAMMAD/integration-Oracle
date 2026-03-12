
package com.oracle.xmlns.apps.scm.productmodel.catalogs.itemcatalogservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.category.CategoryDFF;


/**
 * <p>Java class for CategoryHierarchyReadOnly complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryHierarchyReadOnly">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDateActive" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="EndDateActive" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="CategorySetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ParentCategoryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CreationDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdateDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}CategoryHierarchyReadOnly" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CategoryDFF" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/}CategoryDFF" minOccurs="0"/>
 *         &lt;element name="Attachment" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}Attachment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemCategoryAssignment" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}ItemCategoryAssignment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CategoryTranslation" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}CategoryTranslation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryHierarchyReadOnly", propOrder = {
    "categoryId",
    "categoryName",
    "categoryCode",
    "description",
    "startDateActive",
    "endDateActive",
    "categorySetId",
    "parentCategoryId",
    "creationDateTime",
    "lastUpdateDateTime",
    "category",
    "categoryDFF",
    "attachment",
    "itemCategoryAssignment",
    "categoryTranslation"
})
public class CategoryHierarchyReadOnly {

    @XmlElement(name = "CategoryId")
    protected Long categoryId;
    @XmlElement(name = "CategoryName")
    protected String categoryName;
    @XmlElementRef(name = "CategoryCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> categoryCode;
    @XmlElementRef(name = "Description", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "StartDateActive", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startDateActive;
    @XmlElementRef(name = "EndDateActive", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDateActive;
    @XmlElement(name = "CategorySetId")
    protected Long categorySetId;
    @XmlElementRef(name = "ParentCategoryId", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> parentCategoryId;
    @XmlElement(name = "CreationDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDateTime;
    @XmlElement(name = "LastUpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDateTime;
    @XmlElement(name = "Category")
    protected List<CategoryHierarchyReadOnly> category;
    @XmlElement(name = "CategoryDFF")
    protected CategoryDFF categoryDFF;
    @XmlElement(name = "Attachment")
    protected List<Attachment> attachment;
    @XmlElement(name = "ItemCategoryAssignment")
    protected List<ItemCategoryAssignment> itemCategoryAssignment;
    @XmlElement(name = "CategoryTranslation")
    protected List<CategoryTranslation> categoryTranslation;

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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCategoryCode(JAXBElement<String> value) {
        this.categoryCode = value;
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
     * Gets the value of the startDateActive property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getStartDateActive() {
        return startDateActive;
    }

    /**
     * Sets the value of the startDateActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setStartDateActive(JAXBElement<XMLGregorianCalendar> value) {
        this.startDateActive = value;
    }

    /**
     * Gets the value of the endDateActive property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEndDateActive() {
        return endDateActive;
    }

    /**
     * Sets the value of the endDateActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEndDateActive(JAXBElement<XMLGregorianCalendar> value) {
        this.endDateActive = value;
    }

    /**
     * Gets the value of the categorySetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCategorySetId() {
        return categorySetId;
    }

    /**
     * Sets the value of the categorySetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCategorySetId(Long value) {
        this.categorySetId = value;
    }

    /**
     * Gets the value of the parentCategoryId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getParentCategoryId() {
        return parentCategoryId;
    }

    /**
     * Sets the value of the parentCategoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setParentCategoryId(JAXBElement<Long> value) {
        this.parentCategoryId = value;
    }

    /**
     * Gets the value of the creationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Sets the value of the creationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDateTime(XMLGregorianCalendar value) {
        this.creationDateTime = value;
    }

    /**
     * Gets the value of the lastUpdateDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    /**
     * Sets the value of the lastUpdateDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDateTime(XMLGregorianCalendar value) {
        this.lastUpdateDateTime = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryHierarchyReadOnly }
     * 
     * 
     */
    public List<CategoryHierarchyReadOnly> getCategory() {
        if (category == null) {
            category = new ArrayList<CategoryHierarchyReadOnly>();
        }
        return this.category;
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

    /**
     * Gets the value of the itemCategoryAssignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemCategoryAssignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemCategoryAssignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemCategoryAssignment }
     * 
     * 
     */
    public List<ItemCategoryAssignment> getItemCategoryAssignment() {
        if (itemCategoryAssignment == null) {
            itemCategoryAssignment = new ArrayList<ItemCategoryAssignment>();
        }
        return this.itemCategoryAssignment;
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

}
