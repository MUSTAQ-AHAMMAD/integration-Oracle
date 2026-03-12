
package com.oracle.xmlns.apps.scm.productmodel.items.flex.item;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.items.flex.item package. 
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

    private final static QName _ItemDFF_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", "itemDFF");
    private final static QName _ItemDFFFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", "__FLEX_Context_DisplayValue");
    private final static QName _ItemDFFFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", "__FLEX_Context");
    private final static QName _ItemDFFFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", "_FLEX_NumOfSegments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.items.flex.item
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ItemDFF }
     * 
     */
    public ItemDFF createItemDFF() {
        return new ItemDFF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemDFF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", name = "itemDFF")
    public JAXBElement<ItemDFF> createItemDFF(ItemDFF value) {
        return new JAXBElement<ItemDFF>(_ItemDFF_QNAME, ItemDFF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", name = "__FLEX_Context_DisplayValue", scope = ItemDFF.class)
    public JAXBElement<String> createItemDFFFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_ItemDFFFLEXContextDisplayValue_QNAME, String.class, ItemDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", name = "__FLEX_Context", scope = ItemDFF.class)
    public JAXBElement<String> createItemDFFFLEXContext(String value) {
        return new JAXBElement<String>(_ItemDFFFLEXContext_QNAME, String.class, ItemDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/item/", name = "_FLEX_NumOfSegments", scope = ItemDFF.class)
    public JAXBElement<Integer> createItemDFFFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_ItemDFFFLEXNumOfSegments_QNAME, Integer.class, ItemDFF.class, value);
    }

}
