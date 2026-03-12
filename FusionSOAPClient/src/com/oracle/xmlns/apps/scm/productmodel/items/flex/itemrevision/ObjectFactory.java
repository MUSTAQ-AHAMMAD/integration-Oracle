
package com.oracle.xmlns.apps.scm.productmodel.items.flex.itemrevision;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.items.flex.itemrevision package. 
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

    private final static QName _ItemRevisionDFF_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", "itemRevisionDFF");
    private final static QName _ItemRevisionDFFFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", "__FLEX_Context_DisplayValue");
    private final static QName _ItemRevisionDFFFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", "__FLEX_Context");
    private final static QName _ItemRevisionDFFFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", "_FLEX_NumOfSegments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.items.flex.itemrevision
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ItemRevisionDFF }
     * 
     */
    public ItemRevisionDFF createItemRevisionDFF() {
        return new ItemRevisionDFF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemRevisionDFF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", name = "itemRevisionDFF")
    public JAXBElement<ItemRevisionDFF> createItemRevisionDFF(ItemRevisionDFF value) {
        return new JAXBElement<ItemRevisionDFF>(_ItemRevisionDFF_QNAME, ItemRevisionDFF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", name = "__FLEX_Context_DisplayValue", scope = ItemRevisionDFF.class)
    public JAXBElement<String> createItemRevisionDFFFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_ItemRevisionDFFFLEXContextDisplayValue_QNAME, String.class, ItemRevisionDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", name = "__FLEX_Context", scope = ItemRevisionDFF.class)
    public JAXBElement<String> createItemRevisionDFFFLEXContext(String value) {
        return new JAXBElement<String>(_ItemRevisionDFFFLEXContext_QNAME, String.class, ItemRevisionDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/flex/itemRevision/", name = "_FLEX_NumOfSegments", scope = ItemRevisionDFF.class)
    public JAXBElement<Integer> createItemRevisionDFFFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_ItemRevisionDFFFLEXNumOfSegments_QNAME, Integer.class, ItemRevisionDFF.class, value);
    }

}
