
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2;

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
import com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.itemrevision.categories.JItemRevisionVersion;
import com.oracle.xmlns.apps.scm.productmodel.items.flex.itemrevision.ItemRevisionDFF;


/**
 * <p>Java class for ItemRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RevisionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrganizationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="RevisionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemRevisionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevisionReasonValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffectivityDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="RevisionExtensibleFlexfieldCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreationDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdateDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="ItemRevisionTranslation" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}ItemRevisionTranslation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ItemRevisionDFF" type="{http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/}ItemRevisionDFF" minOccurs="0"/>
 *         &lt;element name="ItemRevisionEffCategory" type="{http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/itemRevision/categories/}j_ItemRevisionVersion" minOccurs="0"/>
 *         &lt;element name="RevisionAttachment" type="{http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/}RevisionAttachment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemRevision", propOrder = {
    "revisionId",
    "itemId",
    "organizationId",
    "revisionCode",
    "itemRevisionDescription",
    "revisionReasonValue",
    "effectivityDate",
    "revisionExtensibleFlexfieldCategoryCode",
    "creationDateTime",
    "lastUpdateDateTime",
    "itemRevisionTranslation",
    "itemRevisionDFF",
    "itemRevisionEffCategory",
    "revisionAttachment"
})
public class ItemRevision {

    @XmlElement(name = "RevisionId")
    protected Long revisionId;
    @XmlElement(name = "ItemId")
    protected Long itemId;
    @XmlElement(name = "OrganizationId")
    protected Long organizationId;
    @XmlElement(name = "RevisionCode")
    protected String revisionCode;
    @XmlElementRef(name = "ItemRevisionDescription", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemRevisionDescription;
    @XmlElementRef(name = "RevisionReasonValue", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> revisionReasonValue;
    @XmlElement(name = "EffectivityDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectivityDate;
    @XmlElementRef(name = "RevisionExtensibleFlexfieldCategoryCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> revisionExtensibleFlexfieldCategoryCode;
    @XmlElement(name = "CreationDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDateTime;
    @XmlElement(name = "LastUpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDateTime;
    @XmlElement(name = "ItemRevisionTranslation")
    protected List<ItemRevisionTranslation> itemRevisionTranslation;
    @XmlElement(name = "ItemRevisionDFF")
    protected ItemRevisionDFF itemRevisionDFF;
    @XmlElement(name = "ItemRevisionEffCategory")
    protected JItemRevisionVersion itemRevisionEffCategory;
    @XmlElement(name = "RevisionAttachment")
    protected List<RevisionAttachment> revisionAttachment;

    /**
     * Gets the value of the revisionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRevisionId() {
        return revisionId;
    }

    /**
     * Sets the value of the revisionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRevisionId(Long value) {
        this.revisionId = value;
    }

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemId(Long value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the organizationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets the value of the organizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrganizationId(Long value) {
        this.organizationId = value;
    }

    /**
     * Gets the value of the revisionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevisionCode() {
        return revisionCode;
    }

    /**
     * Sets the value of the revisionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisionCode(String value) {
        this.revisionCode = value;
    }

    /**
     * Gets the value of the itemRevisionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemRevisionDescription() {
        return itemRevisionDescription;
    }

    /**
     * Sets the value of the itemRevisionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemRevisionDescription(JAXBElement<String> value) {
        this.itemRevisionDescription = value;
    }

    /**
     * Gets the value of the revisionReasonValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRevisionReasonValue() {
        return revisionReasonValue;
    }

    /**
     * Sets the value of the revisionReasonValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRevisionReasonValue(JAXBElement<String> value) {
        this.revisionReasonValue = value;
    }

    /**
     * Gets the value of the effectivityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectivityDate() {
        return effectivityDate;
    }

    /**
     * Sets the value of the effectivityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectivityDate(XMLGregorianCalendar value) {
        this.effectivityDate = value;
    }

    /**
     * Gets the value of the revisionExtensibleFlexfieldCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRevisionExtensibleFlexfieldCategoryCode() {
        return revisionExtensibleFlexfieldCategoryCode;
    }

    /**
     * Sets the value of the revisionExtensibleFlexfieldCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRevisionExtensibleFlexfieldCategoryCode(JAXBElement<String> value) {
        this.revisionExtensibleFlexfieldCategoryCode = value;
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
     * Gets the value of the itemRevisionTranslation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemRevisionTranslation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemRevisionTranslation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemRevisionTranslation }
     * 
     * 
     */
    public List<ItemRevisionTranslation> getItemRevisionTranslation() {
        if (itemRevisionTranslation == null) {
            itemRevisionTranslation = new ArrayList<ItemRevisionTranslation>();
        }
        return this.itemRevisionTranslation;
    }

    /**
     * Gets the value of the itemRevisionDFF property.
     * 
     * @return
     *     possible object is
     *     {@link ItemRevisionDFF }
     *     
     */
    public ItemRevisionDFF getItemRevisionDFF() {
        return itemRevisionDFF;
    }

    /**
     * Sets the value of the itemRevisionDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemRevisionDFF }
     *     
     */
    public void setItemRevisionDFF(ItemRevisionDFF value) {
        this.itemRevisionDFF = value;
    }

    /**
     * Gets the value of the itemRevisionEffCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JItemRevisionVersion }
     *     
     */
    public JItemRevisionVersion getItemRevisionEffCategory() {
        return itemRevisionEffCategory;
    }

    /**
     * Sets the value of the itemRevisionEffCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JItemRevisionVersion }
     *     
     */
    public void setItemRevisionEffCategory(JItemRevisionVersion value) {
        this.itemRevisionEffCategory = value;
    }

    /**
     * Gets the value of the revisionAttachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the revisionAttachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRevisionAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RevisionAttachment }
     * 
     * 
     */
    public List<RevisionAttachment> getRevisionAttachment() {
        if (revisionAttachment == null) {
            revisionAttachment = new ArrayList<RevisionAttachment>();
        }
        return this.revisionAttachment;
    }

}
