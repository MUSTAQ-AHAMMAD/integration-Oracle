
package com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.category;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.category package. 
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

    private final static QName _CategoryDFF_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", "categoryDFF");
    private final static QName _CategoryDFFFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", "_FLEX_NumOfSegments");
    private final static QName _CategoryDFFFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", "__FLEX_Context");
    private final static QName _CategoryDFFFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.catalogs.flex.category
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CategoryDFF }
     * 
     */
    public CategoryDFF createCategoryDFF() {
        return new CategoryDFF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryDFF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", name = "categoryDFF")
    public JAXBElement<CategoryDFF> createCategoryDFF(CategoryDFF value) {
        return new JAXBElement<CategoryDFF>(_CategoryDFF_QNAME, CategoryDFF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", name = "_FLEX_NumOfSegments", scope = CategoryDFF.class)
    public JAXBElement<Integer> createCategoryDFFFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_CategoryDFFFLEXNumOfSegments_QNAME, Integer.class, CategoryDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", name = "__FLEX_Context", scope = CategoryDFF.class)
    public JAXBElement<String> createCategoryDFFFLEXContext(String value) {
        return new JAXBElement<String>(_CategoryDFFFLEXContext_QNAME, String.class, CategoryDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/flex/category/", name = "__FLEX_Context_DisplayValue", scope = CategoryDFF.class)
    public JAXBElement<String> createCategoryDFFFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_CategoryDFFFLEXContextDisplayValue_QNAME, String.class, CategoryDFF.class, value);
    }

}
