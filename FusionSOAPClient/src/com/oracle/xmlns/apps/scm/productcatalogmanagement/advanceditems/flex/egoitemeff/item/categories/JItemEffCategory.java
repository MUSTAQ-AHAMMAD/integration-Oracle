
package com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.item.categories;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for j_ItemEffCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="j_ItemEffCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InventoryItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrganizationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StyleItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MasterOrganizationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StyleItemFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TemplateItemFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "j_ItemEffCategory", propOrder = {
    "inventoryItemId",
    "organizationId",
    "styleItemId",
    "masterOrganizationId",
    "styleItemFlag",
    "templateItemFlag"
})
@XmlSeeAlso({
    JItemRootIccPrivate.class
})
public class JItemEffCategory {

    @XmlElement(name = "InventoryItemId")
    protected Long inventoryItemId;
    @XmlElement(name = "OrganizationId")
    protected Long organizationId;
    @XmlElementRef(name = "StyleItemId", namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> styleItemId;
    @XmlElementRef(name = "MasterOrganizationId", namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> masterOrganizationId;
    @XmlElementRef(name = "StyleItemFlag", namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> styleItemFlag;
    @XmlElement(name = "TemplateItemFlag")
    protected String templateItemFlag;

    /**
     * Gets the value of the inventoryItemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    /**
     * Sets the value of the inventoryItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInventoryItemId(Long value) {
        this.inventoryItemId = value;
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
     * Gets the value of the styleItemId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getStyleItemId() {
        return styleItemId;
    }

    /**
     * Sets the value of the styleItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setStyleItemId(JAXBElement<Long> value) {
        this.styleItemId = value;
    }

    /**
     * Gets the value of the masterOrganizationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getMasterOrganizationId() {
        return masterOrganizationId;
    }

    /**
     * Sets the value of the masterOrganizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setMasterOrganizationId(JAXBElement<Long> value) {
        this.masterOrganizationId = value;
    }

    /**
     * Gets the value of the styleItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getStyleItemFlag() {
        return styleItemFlag;
    }

    /**
     * Sets the value of the styleItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setStyleItemFlag(JAXBElement<Boolean> value) {
        this.styleItemFlag = value;
    }

    /**
     * Gets the value of the templateItemFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateItemFlag() {
        return templateItemFlag;
    }

    /**
     * Sets the value of the templateItemFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateItemFlag(String value) {
        this.templateItemFlag = value;
    }

}
