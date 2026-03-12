
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.itemsupplier.categories.JRevisedItemSupplierAssociation;


/**
 * <p>Java class for ItemSupplierAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemSupplierAssociation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssociationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrganizationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SupplierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AlternateSupplierNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartySiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierItemNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SupplierSiteAssociationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierExtensibleFlexfieldCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreationDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="LastUpdateDateTime" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="ItemSupplierEffCategory" type="{http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/itemSupplier/categories/}j_RevisedItemSupplierAssociation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemSupplierAssociation", propOrder = {
    "associationId",
    "itemId",
    "organizationId",
    "supplierName",
    "supplierNumber",
    "alternateSupplierNumber",
    "partySiteNumber",
    "addressName",
    "address",
    "supplierItemNumber",
    "primaryFlag",
    "supplierSiteAssociationStatus",
    "supplierExtensibleFlexfieldCategoryCode",
    "creationDateTime",
    "lastUpdateDateTime",
    "itemSupplierEffCategory"
})
public class ItemSupplierAssociation {

    @XmlElement(name = "AssociationId")
    protected Long associationId;
    @XmlElement(name = "ItemId")
    protected Long itemId;
    @XmlElement(name = "OrganizationId")
    protected Long organizationId;
    @XmlElementRef(name = "SupplierName", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> supplierName;
    @XmlElementRef(name = "SupplierNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> supplierNumber;
    @XmlElementRef(name = "AlternateSupplierNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> alternateSupplierNumber;
    @XmlElementRef(name = "PartySiteNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partySiteNumber;
    @XmlElementRef(name = "AddressName", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressName;
    @XmlElementRef(name = "Address", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address;
    @XmlElementRef(name = "SupplierItemNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> supplierItemNumber;
    @XmlElementRef(name = "PrimaryFlag", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> primaryFlag;
    @XmlElementRef(name = "SupplierSiteAssociationStatus", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> supplierSiteAssociationStatus;
    @XmlElementRef(name = "SupplierExtensibleFlexfieldCategoryCode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> supplierExtensibleFlexfieldCategoryCode;
    @XmlElement(name = "CreationDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDateTime;
    @XmlElement(name = "LastUpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDateTime;
    @XmlElement(name = "ItemSupplierEffCategory")
    protected JRevisedItemSupplierAssociation itemSupplierEffCategory;

    /**
     * Gets the value of the associationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssociationId() {
        return associationId;
    }

    /**
     * Sets the value of the associationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssociationId(Long value) {
        this.associationId = value;
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
     * Gets the value of the supplierName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplierName() {
        return supplierName;
    }

    /**
     * Sets the value of the supplierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplierName(JAXBElement<String> value) {
        this.supplierName = value;
    }

    /**
     * Gets the value of the supplierNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplierNumber() {
        return supplierNumber;
    }

    /**
     * Sets the value of the supplierNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplierNumber(JAXBElement<String> value) {
        this.supplierNumber = value;
    }

    /**
     * Gets the value of the alternateSupplierNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlternateSupplierNumber() {
        return alternateSupplierNumber;
    }

    /**
     * Sets the value of the alternateSupplierNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlternateSupplierNumber(JAXBElement<String> value) {
        this.alternateSupplierNumber = value;
    }

    /**
     * Gets the value of the partySiteNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartySiteNumber() {
        return partySiteNumber;
    }

    /**
     * Sets the value of the partySiteNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartySiteNumber(JAXBElement<String> value) {
        this.partySiteNumber = value;
    }

    /**
     * Gets the value of the addressName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressName() {
        return addressName;
    }

    /**
     * Sets the value of the addressName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressName(JAXBElement<String> value) {
        this.addressName = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress(JAXBElement<String> value) {
        this.address = value;
    }

    /**
     * Gets the value of the supplierItemNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplierItemNumber() {
        return supplierItemNumber;
    }

    /**
     * Sets the value of the supplierItemNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplierItemNumber(JAXBElement<String> value) {
        this.supplierItemNumber = value;
    }

    /**
     * Gets the value of the primaryFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getPrimaryFlag() {
        return primaryFlag;
    }

    /**
     * Sets the value of the primaryFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setPrimaryFlag(JAXBElement<Boolean> value) {
        this.primaryFlag = value;
    }

    /**
     * Gets the value of the supplierSiteAssociationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplierSiteAssociationStatus() {
        return supplierSiteAssociationStatus;
    }

    /**
     * Sets the value of the supplierSiteAssociationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplierSiteAssociationStatus(JAXBElement<String> value) {
        this.supplierSiteAssociationStatus = value;
    }

    /**
     * Gets the value of the supplierExtensibleFlexfieldCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplierExtensibleFlexfieldCategoryCode() {
        return supplierExtensibleFlexfieldCategoryCode;
    }

    /**
     * Sets the value of the supplierExtensibleFlexfieldCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplierExtensibleFlexfieldCategoryCode(JAXBElement<String> value) {
        this.supplierExtensibleFlexfieldCategoryCode = value;
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
     * Gets the value of the itemSupplierEffCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JRevisedItemSupplierAssociation }
     *     
     */
    public JRevisedItemSupplierAssociation getItemSupplierEffCategory() {
        return itemSupplierEffCategory;
    }

    /**
     * Sets the value of the itemSupplierEffCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JRevisedItemSupplierAssociation }
     *     
     */
    public void setItemSupplierEffCategory(JRevisedItemSupplierAssociation value) {
        this.itemSupplierEffCategory = value;
    }

}
