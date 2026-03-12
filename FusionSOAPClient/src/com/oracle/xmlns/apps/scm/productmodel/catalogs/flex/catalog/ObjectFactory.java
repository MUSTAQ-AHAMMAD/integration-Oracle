
package com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.catalog;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.catalog package. 
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

    private final static QName _CatalogDFF_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", "catalogDFF");
    private final static QName _CatalogDFFFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", "__FLEX_Context");
    private final static QName _CatalogDFFFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", "_FLEX_NumOfSegments");
    private final static QName _CatalogDFFFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.catalog
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CatalogDFF }
     * 
     */
    public CatalogDFF createCatalogDFF() {
        return new CatalogDFF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogDFF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", name = "catalogDFF")
    public JAXBElement<CatalogDFF> createCatalogDFF(CatalogDFF value) {
        return new JAXBElement<CatalogDFF>(_CatalogDFF_QNAME, CatalogDFF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", name = "__FLEX_Context", scope = CatalogDFF.class)
    public JAXBElement<String> createCatalogDFFFLEXContext(String value) {
        return new JAXBElement<String>(_CatalogDFFFLEXContext_QNAME, String.class, CatalogDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", name = "_FLEX_NumOfSegments", scope = CatalogDFF.class)
    public JAXBElement<Integer> createCatalogDFFFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_CatalogDFFFLEXNumOfSegments_QNAME, Integer.class, CatalogDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/catalog/", name = "__FLEX_Context_DisplayValue", scope = CatalogDFF.class)
    public JAXBElement<String> createCatalogDFFFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_CatalogDFFFLEXContextDisplayValue_QNAME, String.class, CatalogDFF.class, value);
    }

}
