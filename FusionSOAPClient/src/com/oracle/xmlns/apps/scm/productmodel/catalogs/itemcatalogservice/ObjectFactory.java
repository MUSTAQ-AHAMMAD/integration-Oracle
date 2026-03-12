
package com.oracle.xmlns.apps.scm.productmodel.catalogs.itemcatalogservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.scm.productmodel.catalogs.itemcatalogservice package. 
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

    private final static QName _CategoryHierarchyReadOnly_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "categoryHierarchyReadOnly");
    private final static QName _Catalog_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "catalog");
    private final static QName _CatalogTranslation_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "catalogTranslation");
    private final static QName _CatalogReadOnly_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "catalogReadOnly");
    private final static QName _Attachment_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "attachment");
    private final static QName _CategoryTranslation_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "categoryTranslation");
    private final static QName _Category_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "category");
    private final static QName _ItemCategoryAssignment_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "itemCategoryAssignment");
    private final static QName _CatalogTranslationDescription_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "Description");
    private final static QName _ItemCategoryAssignmentItemCategoryAssignmentId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "ItemCategoryAssignmentId");
    private final static QName _ItemCategoryAssignmentStartDate_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "StartDate");
    private final static QName _ItemCategoryAssignmentEndDate_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "EndDate");
    private final static QName _CategoryHierarchyReadOnlyCategoryCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "CategoryCode");
    private final static QName _CategoryHierarchyReadOnlyStartDateActive_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "StartDateActive");
    private final static QName _CategoryHierarchyReadOnlyEndDateActive_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "EndDateActive");
    private final static QName _CategoryHierarchyReadOnlyParentCategoryId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "ParentCategoryId");
    private final static QName _CatalogPublicCatalogFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "PublicCatalogFlag");
    private final static QName _CatalogAssignItemsToLeafLevelCategoriesOnlyFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "AssignItemsToLeafLevelCategoriesOnlyFlag");
    private final static QName _CatalogControlledAt_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "ControlledAt");
    private final static QName _AttachmentDmNode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DmNode");
    private final static QName _AttachmentFileName_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "FileName");
    private final static QName _AttachmentStatus_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "Status");
    private final static QName _AttachmentUsageType_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "UsageType");
    private final static QName _AttachmentUri_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "Uri");
    private final static QName _AttachmentURL_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "URL");
    private final static QName _AttachmentTitle_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "Title");
    private final static QName _AttachmentAttachment_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "Attachment");
    private final static QName _AttachmentEntityAttributes_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "EntityAttributes");
    private final static QName _AttachmentDmDocumentId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DmDocumentId");
    private final static QName _AttachmentDmType_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DmType");
    private final static QName _AttachmentDmVersionNumber_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DmVersionNumber");
    private final static QName _AttachmentDocumentAttributes_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DocumentAttributes");
    private final static QName _AttachmentDocumentEntityId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DocumentEntityId");
    private final static QName _AttachmentDmFolderPath_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DmFolderPath");
    private final static QName _AttachmentCategoryName_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "CategoryName");
    private final static QName _AttachmentDmRepository_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "DmRepository");
    private final static QName _CategoryParentCategoryCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "ParentCategoryCode");
    private final static QName _CategoryRestrictCategoryToItemAssignmentOnlyFlag_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "RestrictCategoryToItemAssignmentOnlyFlag");
    private final static QName _CategoryESSRequestId_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "ESSRequestId");
    private final static QName _CategoryCatalogCode_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "CatalogCode");
    private final static QName _CatalogReadOnlyPublicCatalog_QNAME = new QName("http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", "PublicCatalog");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.scm.productmodel.catalogs.itemcatalogservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Catalog }
     * 
     */
    public Catalog createCatalog() {
        return new Catalog();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link CatalogReadOnly }
     * 
     */
    public CatalogReadOnly createCatalogReadOnly() {
        return new CatalogReadOnly();
    }

    /**
     * Create an instance of {@link Attachment }
     * 
     */
    public Attachment createAttachment() {
        return new Attachment();
    }

    /**
     * Create an instance of {@link CategoryHierarchyReadOnly }
     * 
     */
    public CategoryHierarchyReadOnly createCategoryHierarchyReadOnly() {
        return new CategoryHierarchyReadOnly();
    }

    /**
     * Create an instance of {@link CategoryTranslation }
     * 
     */
    public CategoryTranslation createCategoryTranslation() {
        return new CategoryTranslation();
    }

    /**
     * Create an instance of {@link CatalogTranslation }
     * 
     */
    public CatalogTranslation createCatalogTranslation() {
        return new CatalogTranslation();
    }

    /**
     * Create an instance of {@link ItemCategoryAssignment }
     * 
     */
    public ItemCategoryAssignment createItemCategoryAssignment() {
        return new ItemCategoryAssignment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryHierarchyReadOnly }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "categoryHierarchyReadOnly")
    public JAXBElement<CategoryHierarchyReadOnly> createCategoryHierarchyReadOnly(CategoryHierarchyReadOnly value) {
        return new JAXBElement<CategoryHierarchyReadOnly>(_CategoryHierarchyReadOnly_QNAME, CategoryHierarchyReadOnly.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Catalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "catalog")
    public JAXBElement<Catalog> createCatalog(Catalog value) {
        return new JAXBElement<Catalog>(_Catalog_QNAME, Catalog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogTranslation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "catalogTranslation")
    public JAXBElement<CatalogTranslation> createCatalogTranslation(CatalogTranslation value) {
        return new JAXBElement<CatalogTranslation>(_CatalogTranslation_QNAME, CatalogTranslation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogReadOnly }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "catalogReadOnly")
    public JAXBElement<CatalogReadOnly> createCatalogReadOnly(CatalogReadOnly value) {
        return new JAXBElement<CatalogReadOnly>(_CatalogReadOnly_QNAME, CatalogReadOnly.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Attachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "attachment")
    public JAXBElement<Attachment> createAttachment(Attachment value) {
        return new JAXBElement<Attachment>(_Attachment_QNAME, Attachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryTranslation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "categoryTranslation")
    public JAXBElement<CategoryTranslation> createCategoryTranslation(CategoryTranslation value) {
        return new JAXBElement<CategoryTranslation>(_CategoryTranslation_QNAME, CategoryTranslation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemCategoryAssignment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "itemCategoryAssignment")
    public JAXBElement<ItemCategoryAssignment> createItemCategoryAssignment(ItemCategoryAssignment value) {
        return new JAXBElement<ItemCategoryAssignment>(_ItemCategoryAssignment_QNAME, ItemCategoryAssignment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = CatalogTranslation.class)
    public JAXBElement<String> createCatalogTranslationDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, CatalogTranslation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "ItemCategoryAssignmentId", scope = ItemCategoryAssignment.class)
    public JAXBElement<Long> createItemCategoryAssignmentItemCategoryAssignmentId(Long value) {
        return new JAXBElement<Long>(_ItemCategoryAssignmentItemCategoryAssignmentId_QNAME, Long.class, ItemCategoryAssignment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "StartDate", scope = ItemCategoryAssignment.class)
    public JAXBElement<XMLGregorianCalendar> createItemCategoryAssignmentStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentStartDate_QNAME, XMLGregorianCalendar.class, ItemCategoryAssignment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "EndDate", scope = ItemCategoryAssignment.class)
    public JAXBElement<XMLGregorianCalendar> createItemCategoryAssignmentEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentEndDate_QNAME, XMLGregorianCalendar.class, ItemCategoryAssignment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "CategoryCode", scope = CategoryHierarchyReadOnly.class)
    public JAXBElement<String> createCategoryHierarchyReadOnlyCategoryCode(String value) {
        return new JAXBElement<String>(_CategoryHierarchyReadOnlyCategoryCode_QNAME, String.class, CategoryHierarchyReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "StartDateActive", scope = CategoryHierarchyReadOnly.class)
    public JAXBElement<XMLGregorianCalendar> createCategoryHierarchyReadOnlyStartDateActive(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CategoryHierarchyReadOnlyStartDateActive_QNAME, XMLGregorianCalendar.class, CategoryHierarchyReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "EndDateActive", scope = CategoryHierarchyReadOnly.class)
    public JAXBElement<XMLGregorianCalendar> createCategoryHierarchyReadOnlyEndDateActive(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CategoryHierarchyReadOnlyEndDateActive_QNAME, XMLGregorianCalendar.class, CategoryHierarchyReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = CategoryHierarchyReadOnly.class)
    public JAXBElement<String> createCategoryHierarchyReadOnlyDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, CategoryHierarchyReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "ParentCategoryId", scope = CategoryHierarchyReadOnly.class)
    public JAXBElement<Long> createCategoryHierarchyReadOnlyParentCategoryId(Long value) {
        return new JAXBElement<Long>(_CategoryHierarchyReadOnlyParentCategoryId_QNAME, Long.class, CategoryHierarchyReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = CategoryTranslation.class)
    public JAXBElement<String> createCategoryTranslationDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, CategoryTranslation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "PublicCatalogFlag", scope = Catalog.class)
    public JAXBElement<Boolean> createCatalogPublicCatalogFlag(Boolean value) {
        return new JAXBElement<Boolean>(_CatalogPublicCatalogFlag_QNAME, Boolean.class, Catalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "StartDate", scope = Catalog.class)
    public JAXBElement<XMLGregorianCalendar> createCatalogStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentStartDate_QNAME, XMLGregorianCalendar.class, Catalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = Catalog.class)
    public JAXBElement<String> createCatalogDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, Catalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "AssignItemsToLeafLevelCategoriesOnlyFlag", scope = Catalog.class)
    public JAXBElement<Boolean> createCatalogAssignItemsToLeafLevelCategoriesOnlyFlag(Boolean value) {
        return new JAXBElement<Boolean>(_CatalogAssignItemsToLeafLevelCategoriesOnlyFlag_QNAME, Boolean.class, Catalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "EndDate", scope = Catalog.class)
    public JAXBElement<XMLGregorianCalendar> createCatalogEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentEndDate_QNAME, XMLGregorianCalendar.class, Catalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "ControlledAt", scope = Catalog.class)
    public JAXBElement<String> createCatalogControlledAt(String value) {
        return new JAXBElement<String>(_CatalogControlledAt_QNAME, String.class, Catalog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DmNode", scope = Attachment.class)
    public JAXBElement<Long> createAttachmentDmNode(Long value) {
        return new JAXBElement<Long>(_AttachmentDmNode_QNAME, Long.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "FileName", scope = Attachment.class)
    public JAXBElement<String> createAttachmentFileName(String value) {
        return new JAXBElement<String>(_AttachmentFileName_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Status", scope = Attachment.class)
    public JAXBElement<String> createAttachmentStatus(String value) {
        return new JAXBElement<String>(_AttachmentStatus_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "UsageType", scope = Attachment.class)
    public JAXBElement<String> createAttachmentUsageType(String value) {
        return new JAXBElement<String>(_AttachmentUsageType_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Uri", scope = Attachment.class)
    public JAXBElement<String> createAttachmentUri(String value) {
        return new JAXBElement<String>(_AttachmentUri_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "URL", scope = Attachment.class)
    public JAXBElement<String> createAttachmentURL(String value) {
        return new JAXBElement<String>(_AttachmentURL_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Title", scope = Attachment.class)
    public JAXBElement<String> createAttachmentTitle(String value) {
        return new JAXBElement<String>(_AttachmentTitle_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Attachment", scope = Attachment.class)
    public JAXBElement<String> createAttachmentAttachment(String value) {
        return new JAXBElement<String>(_AttachmentAttachment_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "EntityAttributes", scope = Attachment.class)
    public JAXBElement<String> createAttachmentEntityAttributes(String value) {
        return new JAXBElement<String>(_AttachmentEntityAttributes_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DmDocumentId", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDmDocumentId(String value) {
        return new JAXBElement<String>(_AttachmentDmDocumentId_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DmType", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDmType(String value) {
        return new JAXBElement<String>(_AttachmentDmType_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DmVersionNumber", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDmVersionNumber(String value) {
        return new JAXBElement<String>(_AttachmentDmVersionNumber_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DocumentAttributes", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDocumentAttributes(String value) {
        return new JAXBElement<String>(_AttachmentDocumentAttributes_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DocumentEntityId", scope = Attachment.class)
    public JAXBElement<Long> createAttachmentDocumentEntityId(Long value) {
        return new JAXBElement<Long>(_AttachmentDocumentEntityId_QNAME, Long.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DmFolderPath", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDmFolderPath(String value) {
        return new JAXBElement<String>(_AttachmentDmFolderPath_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "CategoryName", scope = Attachment.class)
    public JAXBElement<String> createAttachmentCategoryName(String value) {
        return new JAXBElement<String>(_AttachmentCategoryName_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "DmRepository", scope = Attachment.class)
    public JAXBElement<String> createAttachmentDmRepository(String value) {
        return new JAXBElement<String>(_AttachmentDmRepository_QNAME, String.class, Attachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "ParentCategoryCode", scope = Category.class)
    public JAXBElement<String> createCategoryParentCategoryCode(String value) {
        return new JAXBElement<String>(_CategoryParentCategoryCode_QNAME, String.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "StartDate", scope = Category.class)
    public JAXBElement<XMLGregorianCalendar> createCategoryStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentStartDate_QNAME, XMLGregorianCalendar.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "RestrictCategoryToItemAssignmentOnlyFlag", scope = Category.class, defaultValue = "false")
    public JAXBElement<Boolean> createCategoryRestrictCategoryToItemAssignmentOnlyFlag(Boolean value) {
        return new JAXBElement<Boolean>(_CategoryRestrictCategoryToItemAssignmentOnlyFlag_QNAME, Boolean.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "ESSRequestId", scope = Category.class)
    public JAXBElement<Long> createCategoryESSRequestId(Long value) {
        return new JAXBElement<Long>(_CategoryESSRequestId_QNAME, Long.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = Category.class)
    public JAXBElement<String> createCategoryDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "EndDate", scope = Category.class)
    public JAXBElement<XMLGregorianCalendar> createCategoryEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentEndDate_QNAME, XMLGregorianCalendar.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "CatalogCode", scope = Category.class)
    public JAXBElement<String> createCategoryCatalogCode(String value) {
        return new JAXBElement<String>(_CategoryCatalogCode_QNAME, String.class, Category.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "StartDate", scope = CatalogReadOnly.class)
    public JAXBElement<XMLGregorianCalendar> createCatalogReadOnlyStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentStartDate_QNAME, XMLGregorianCalendar.class, CatalogReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "Description", scope = CatalogReadOnly.class)
    public JAXBElement<String> createCatalogReadOnlyDescription(String value) {
        return new JAXBElement<String>(_CatalogTranslationDescription_QNAME, String.class, CatalogReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "EndDate", scope = CatalogReadOnly.class)
    public JAXBElement<XMLGregorianCalendar> createCatalogReadOnlyEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ItemCategoryAssignmentEndDate_QNAME, XMLGregorianCalendar.class, CatalogReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "ControlledAt", scope = CatalogReadOnly.class)
    public JAXBElement<String> createCatalogReadOnlyControlledAt(String value) {
        return new JAXBElement<String>(_CatalogControlledAt_QNAME, String.class, CatalogReadOnly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/scm/productModel/catalogs/itemCatalogService/", name = "PublicCatalog", scope = CatalogReadOnly.class)
    public JAXBElement<String> createCatalogReadOnlyPublicCatalog(String value) {
        return new JAXBElement<String>(_CatalogReadOnlyPublicCatalog_QNAME, String.class, CatalogReadOnly.class, value);
    }

}
