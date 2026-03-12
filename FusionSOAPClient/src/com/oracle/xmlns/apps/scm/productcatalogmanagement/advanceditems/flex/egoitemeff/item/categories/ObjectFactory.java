
package com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.item.categories;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.item.categories package. 
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

    private final static QName _JItemEffCategory_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", "j_ItemEffCategory");
    private final static QName _JItemRootIccPrivate_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", "j_ItemRootIccPrivate");
    private final static QName _JItemEffCategoryStyleItemId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", "StyleItemId");
    private final static QName _JItemEffCategoryStyleItemFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", "StyleItemFlag");
    private final static QName _JItemEffCategoryMasterOrganizationId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", "MasterOrganizationId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productcatalogmanagement.advanceditems.flex.egoitemeff.item.categories
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JItemRootIccPrivate }
     * 
     */
    public JItemRootIccPrivate createJItemRootIccPrivate() {
        return new JItemRootIccPrivate();
    }

    /**
     * Create an instance of {@link JItemEffCategory }
     * 
     */
    public JItemEffCategory createJItemEffCategory() {
        return new JItemEffCategory();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JItemEffCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", name = "j_ItemEffCategory")
    public JAXBElement<JItemEffCategory> createJItemEffCategory(JItemEffCategory value) {
        return new JAXBElement<JItemEffCategory>(_JItemEffCategory_QNAME, JItemEffCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JItemRootIccPrivate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", name = "j_ItemRootIccPrivate")
    public JAXBElement<JItemRootIccPrivate> createJItemRootIccPrivate(JItemRootIccPrivate value) {
        return new JAXBElement<JItemRootIccPrivate>(_JItemRootIccPrivate_QNAME, JItemRootIccPrivate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", name = "StyleItemId", scope = JItemEffCategory.class)
    public JAXBElement<Long> createJItemEffCategoryStyleItemId(Long value) {
        return new JAXBElement<Long>(_JItemEffCategoryStyleItemId_QNAME, Long.class, JItemEffCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", name = "StyleItemFlag", scope = JItemEffCategory.class)
    public JAXBElement<Boolean> createJItemEffCategoryStyleItemFlag(Boolean value) {
        return new JAXBElement<Boolean>(_JItemEffCategoryStyleItemFlag_QNAME, Boolean.class, JItemEffCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productCatalogManagement/advancedItems/flex/egoItemEff/item/categories/", name = "MasterOrganizationId", scope = JItemEffCategory.class)
    public JAXBElement<Long> createJItemEffCategoryMasterOrganizationId(Long value) {
        return new JAXBElement<Long>(_JItemEffCategoryMasterOrganizationId_QNAME, Long.class, JItemEffCategory.class, value);
    }

}
