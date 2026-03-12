
package com.oracle.xmlns.apps.flex.fnd.applcore.attachments.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.flex.fnd.applcore.attachments.model package. 
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

    private final static QName _AttachedDocumentsDFF_QNAME = new QName("http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", "attachedDocumentsDFF");
    private final static QName _AttachedDocumentsDFFFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", "__FLEX_Context");
    private final static QName _AttachedDocumentsDFFFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", "_FLEX_NumOfSegments");
    private final static QName _AttachedDocumentsDFFFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.flex.fnd.applcore.attachments.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AttachedDocumentsDFF }
     * 
     */
    public AttachedDocumentsDFF createAttachedDocumentsDFF() {
        return new AttachedDocumentsDFF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachedDocumentsDFF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", name = "attachedDocumentsDFF")
    public JAXBElement<AttachedDocumentsDFF> createAttachedDocumentsDFF(AttachedDocumentsDFF value) {
        return new JAXBElement<AttachedDocumentsDFF>(_AttachedDocumentsDFF_QNAME, AttachedDocumentsDFF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", name = "__FLEX_Context", scope = AttachedDocumentsDFF.class)
    public JAXBElement<String> createAttachedDocumentsDFFFLEXContext(String value) {
        return new JAXBElement<String>(_AttachedDocumentsDFFFLEXContext_QNAME, String.class, AttachedDocumentsDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", name = "_FLEX_NumOfSegments", scope = AttachedDocumentsDFF.class)
    public JAXBElement<Integer> createAttachedDocumentsDFFFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_AttachedDocumentsDFFFLEXNumOfSegments_QNAME, Integer.class, AttachedDocumentsDFF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/", name = "__FLEX_Context_DisplayValue", scope = AttachedDocumentsDFF.class)
    public JAXBElement<String> createAttachedDocumentsDFFFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_AttachedDocumentsDFFFLEXContextDisplayValue_QNAME, String.class, AttachedDocumentsDFF.class, value);
    }

}
