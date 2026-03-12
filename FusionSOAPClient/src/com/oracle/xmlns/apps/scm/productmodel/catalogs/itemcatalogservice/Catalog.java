
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
import com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.catalog.CatalogDFF;


/**
 * <p>Java class for Catalog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Catalog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CatalogId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CatalogCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CatalogName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ControlledAt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="AssignItemsToLeafLevelCategoriesOnlyFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowMultipleItemCategoryAssignmentsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PublicCatalogFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdateDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="CatalogDFF" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/}CatalogDFF" minOccurs="0"/>
 *         &lt;element name="CatalogTranslation" type="{http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/}CatalogTranslation" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Catalog", propOrder = {
    "catalogId",
    "catalogCode",
    "catalogName",
    "description",
    "controlledAt",
    "startDate",
    "endDate",
    "assignItemsToLeafLevelCategoriesOnlyFlag",
    "allowMultipleItemCategoryAssignmentsFlag",
    "publicCatalogFlag",
    "creationDate",
    "lastUpdateDate",
    "catalogDFF",
    "catalogTranslation",
    "attachment"
})
public class Catalog {

    @XmlElement(name = "CatalogId")
    protected Long catalogId;
    @XmlElement(name = "CatalogCode")
    protected String catalogCode;
    @XmlElement(name = "CatalogName")
    protected String catalogName;
    @XmlElementRef(name = "Description", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "ControlledAt", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> controlledAt;
    @XmlElementRef(name = "StartDate", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> startDate;
    @XmlElementRef(name = "EndDate", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> endDate;
    @XmlElementRef(name = "AssignItemsToLeafLevelCategoriesOnlyFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> assignItemsToLeafLevelCategoriesOnlyFlag;
    @XmlElement(name = "AllowMultipleItemCategoryAssignmentsFlag", defaultValue = "false")
    protected Boolean allowMultipleItemCategoryAssignmentsFlag;
    @XmlElementRef(name = "PublicCatalogFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> publicCatalogFlag;
    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "LastUpdateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElement(name = "CatalogDFF")
    protected CatalogDFF catalogDFF;
    @XmlElement(name = "CatalogTranslation")
    protected List<CatalogTranslation> catalogTranslation;
    @XmlElement(name = "Attachment")
    protected List<Attachment> attachment;

    /**
     * Gets the value of the catalogId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCatalogId() {
        return catalogId;
    }

    /**
     * Sets the value of the catalogId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCatalogId(Long value) {
        this.catalogId = value;
    }

    /**
     * Gets the value of the catalogCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogCode() {
        return catalogCode;
    }

    /**
     * Sets the value of the catalogCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogCode(String value) {
        this.catalogCode = value;
    }

    /**
     * Gets the value of the catalogName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * Sets the value of the catalogName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogName(String value) {
        this.catalogName = value;
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
     * Gets the value of the controlledAt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getControlledAt() {
        return controlledAt;
    }

    /**
     * Sets the value of the controlledAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setControlledAt(JAXBElement<String> value) {
        this.controlledAt = value;
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
     * Gets the value of the assignItemsToLeafLevelCategoriesOnlyFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAssignItemsToLeafLevelCategoriesOnlyFlag() {
        return assignItemsToLeafLevelCategoriesOnlyFlag;
    }

    /**
     * Sets the value of the assignItemsToLeafLevelCategoriesOnlyFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAssignItemsToLeafLevelCategoriesOnlyFlag(JAXBElement<Boolean> value) {
        this.assignItemsToLeafLevelCategoriesOnlyFlag = value;
    }

    /**
     * Gets the value of the allowMultipleItemCategoryAssignmentsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowMultipleItemCategoryAssignmentsFlag() {
        return allowMultipleItemCategoryAssignmentsFlag;
    }

    /**
     * Sets the value of the allowMultipleItemCategoryAssignmentsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowMultipleItemCategoryAssignmentsFlag(Boolean value) {
        this.allowMultipleItemCategoryAssignmentsFlag = value;
    }

    /**
     * Gets the value of the publicCatalogFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getPublicCatalogFlag() {
        return publicCatalogFlag;
    }

    /**
     * Sets the value of the publicCatalogFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setPublicCatalogFlag(JAXBElement<Boolean> value) {
        this.publicCatalogFlag = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the catalogDFF property.
     * 
     * @return
     *     possible object is
     *     {@link CatalogDFF }
     *     
     */
    public CatalogDFF getCatalogDFF() {
        return catalogDFF;
    }

    /**
     * Sets the value of the catalogDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link CatalogDFF }
     *     
     */
    public void setCatalogDFF(CatalogDFF value) {
        this.catalogDFF = value;
    }

    /**
     * Gets the value of the catalogTranslation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the catalogTranslation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCatalogTranslation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CatalogTranslation }
     * 
     * 
     */
    public List<CatalogTranslation> getCatalogTranslation() {
        if (catalogTranslation == null) {
            catalogTranslation = new ArrayList<CatalogTranslation>();
        }
        return this.catalogTranslation;
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
