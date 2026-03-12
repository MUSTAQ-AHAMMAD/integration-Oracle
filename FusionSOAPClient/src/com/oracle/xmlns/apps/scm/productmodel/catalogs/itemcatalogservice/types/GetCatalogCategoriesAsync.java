
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
 *         &lt;element name="catalogId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="catalogCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "catalogId",
    "catalogCode",
    "catalogName"
})
@XmlRootElement(name = "getCatalogCategoriesAsync")
public class GetCatalogCategoriesAsync {

    protected long catalogId;
    @XmlElement(required = true)
    protected String catalogCode;
    @XmlElement(required = true)
    protected String catalogName;

    /**
     * Gets the value of the catalogId property.
     * 
     */
    public long getCatalogId() {
        return catalogId;
    }

    /**
     * Sets the value of the catalogId property.
     * 
     */
    public void setCatalogId(long value) {
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

}
