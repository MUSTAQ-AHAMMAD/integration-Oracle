
package com.oracle.xmlns.apps.scm.productmodel.items.flex.itemgdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemGdfJA_5FCN_5FITEM_5FINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemGdfJA_5FCN_5FITEM_5FINFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/}ItemGdf">
 *       &lt;sequence>
 *         &lt;element name="_Item__Model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="_Tax__Denomination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemGdfJA_5FCN_5FITEM_5FINFO", propOrder = {
    "itemModel",
    "taxDenomination"
})
public class ItemGdfJA5FCN5FITEM5FINFO
    extends ItemGdf
{

    @XmlElementRef(name = "_Item__Model", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> itemModel;
    @XmlElementRef(name = "_Tax__Denomination", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxDenomination;

    /**
     * Gets the value of the itemModel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemModel() {
        return itemModel;
    }

    /**
     * Sets the value of the itemModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemModel(JAXBElement<String> value) {
        this.itemModel = value;
    }

    /**
     * Gets the value of the taxDenomination property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxDenomination() {
        return taxDenomination;
    }

    /**
     * Sets the value of the taxDenomination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxDenomination(JAXBElement<String> value) {
        this.taxDenomination = value;
    }

}
