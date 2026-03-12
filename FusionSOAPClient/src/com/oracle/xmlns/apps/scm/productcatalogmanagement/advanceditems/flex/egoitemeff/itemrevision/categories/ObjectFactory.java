
package com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.itemrevision.categories;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.itemrevision.categories package. 
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

    private final static QName _JItemRevisionVersion_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/itemRevision/categories/", "j_ItemRevisionVersion");
    private final static QName _JItemRevisionRootIccPrivate_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/itemRevision/categories/", "j_ItemRevisionRootIccPrivate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.itemrevision.categories
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JItemRevisionVersion }
     * 
     */
    public JItemRevisionVersion createJItemRevisionVersion() {
        return new JItemRevisionVersion();
    }

    /**
     * Create an instance of {@link JItemRevisionRootIccPrivate }
     * 
     */
    public JItemRevisionRootIccPrivate createJItemRevisionRootIccPrivate() {
        return new JItemRevisionRootIccPrivate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JItemRevisionVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/itemRevision/categories/", name = "j_ItemRevisionVersion")
    public JAXBElement<JItemRevisionVersion> createJItemRevisionVersion(JItemRevisionVersion value) {
        return new JAXBElement<JItemRevisionVersion>(_JItemRevisionVersion_QNAME, JItemRevisionVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JItemRevisionRootIccPrivate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/itemRevision/categories/", name = "j_ItemRevisionRootIccPrivate")
    public JAXBElement<JItemRevisionRootIccPrivate> createJItemRevisionRootIccPrivate(JItemRevisionRootIccPrivate value) {
        return new JAXBElement<JItemRevisionRootIccPrivate>(_JItemRevisionRootIccPrivate_QNAME, JItemRevisionRootIccPrivate.class, null, value);
    }

}
