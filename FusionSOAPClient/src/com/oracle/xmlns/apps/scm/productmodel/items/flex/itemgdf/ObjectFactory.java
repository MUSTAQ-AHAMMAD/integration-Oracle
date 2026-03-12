
package com.oracle.xmlns.apps.scm.productmodel.items.flex.itemgdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.items.flex.itemgdf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ItemGdf_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "itemGdf");
    private final static QName _ItemGdfJA5FCN5FITEM5FINFO_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "itemGdfJA_5FCN_5FITEM_5FINFO");
    private final static QName _ItemGdfFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "__FLEX_Context");
    private final static QName _ItemGdfFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "_FLEX_NumOfSegments");
    private final static QName _ItemGdfFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "__FLEX_Context_DisplayValue");
    private final static QName _ItemGdfFLEXPARAMGLOBALCOUNTRYCODE_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "FLEX_PARAM_GLOBAL_COUNTRY_CODE");
    private final static QName _ItemGdfJA5FCN5FITEM5FINFOItemModel_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "_Item__Model");
    private final static QName _ItemGdfJA5FCN5FITEM5FINFOTaxDenomination_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", "_Tax__Denomination");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.items.flex.itemgdf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ItemGdf }
     * 
     */
    public ItemGdf createItemGdf() {
        return new ItemGdf();
    }

    /**
     * Create an instance of {@link ItemGdfJA5FCN5FITEM5FINFO }
     * 
     */
    public ItemGdfJA5FCN5FITEM5FINFO createItemGdfJA5FCN5FITEM5FINFO() {
        return new ItemGdfJA5FCN5FITEM5FINFO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemGdf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "itemGdf")
    public JAXBElement<ItemGdf> createItemGdf(ItemGdf value) {
        return new JAXBElement<ItemGdf>(_ItemGdf_QNAME, ItemGdf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemGdfJA5FCN5FITEM5FINFO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "itemGdfJA_5FCN_5FITEM_5FINFO")
    public JAXBElement<ItemGdfJA5FCN5FITEM5FINFO> createItemGdfJA5FCN5FITEM5FINFO(ItemGdfJA5FCN5FITEM5FINFO value) {
        return new JAXBElement<ItemGdfJA5FCN5FITEM5FINFO>(_ItemGdfJA5FCN5FITEM5FINFO_QNAME, ItemGdfJA5FCN5FITEM5FINFO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "__FLEX_Context", scope = ItemGdf.class)
    public JAXBElement<String> createItemGdfFLEXContext(String value) {
        return new JAXBElement<String>(_ItemGdfFLEXContext_QNAME, String.class, ItemGdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "_FLEX_NumOfSegments", scope = ItemGdf.class)
    public JAXBElement<Integer> createItemGdfFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_ItemGdfFLEXNumOfSegments_QNAME, Integer.class, ItemGdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "__FLEX_Context_DisplayValue", scope = ItemGdf.class)
    public JAXBElement<String> createItemGdfFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_ItemGdfFLEXContextDisplayValue_QNAME, String.class, ItemGdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "FLEX_PARAM_GLOBAL_COUNTRY_CODE", scope = ItemGdf.class)
    public JAXBElement<String> createItemGdfFLEXPARAMGLOBALCOUNTRYCODE(String value) {
        return new JAXBElement<String>(_ItemGdfFLEXPARAMGLOBALCOUNTRYCODE_QNAME, String.class, ItemGdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "_Item__Model", scope = ItemGdfJA5FCN5FITEM5FINFO.class)
    public JAXBElement<String> createItemGdfJA5FCN5FITEM5FINFOItemModel(String value) {
        return new JAXBElement<String>(_ItemGdfJA5FCN5FITEM5FINFOItemModel_QNAME, String.class, ItemGdfJA5FCN5FITEM5FINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemGdf/", name = "_Tax__Denomination", scope = ItemGdfJA5FCN5FITEM5FINFO.class)
    public JAXBElement<String> createItemGdfJA5FCN5FITEM5FINFOTaxDenomination(String value) {
        return new JAXBElement<String>(_ItemGdfJA5FCN5FITEM5FINFOTaxDenomination_QNAME, String.class, ItemGdfJA5FCN5FITEM5FINFO.class, value);
    }

}
