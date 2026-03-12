
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.miscellaneousreceiptdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.miscellaneousreceiptdff package. 
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

    private final static QName _MiscellaneousReceiptFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", "miscellaneousReceiptFLEX");
    private final static QName _MiscellaneousReceiptFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", "_FLEX_NumOfSegments");
    private final static QName _MiscellaneousReceiptFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", "__FLEX_Context");
    private final static QName _MiscellaneousReceiptFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.miscellaneousreceiptdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MiscellaneousReceiptFLEX }
     * 
     */
    public MiscellaneousReceiptFLEX createMiscellaneousReceiptFLEX() {
        return new MiscellaneousReceiptFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MiscellaneousReceiptFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", name = "miscellaneousReceiptFLEX")
    public JAXBElement<MiscellaneousReceiptFLEX> createMiscellaneousReceiptFLEX(MiscellaneousReceiptFLEX value) {
        return new JAXBElement<MiscellaneousReceiptFLEX>(_MiscellaneousReceiptFLEX_QNAME, MiscellaneousReceiptFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", name = "_FLEX_NumOfSegments", scope = MiscellaneousReceiptFLEX.class)
    public JAXBElement<Integer> createMiscellaneousReceiptFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_MiscellaneousReceiptFLEXFLEXNumOfSegments_QNAME, Integer.class, MiscellaneousReceiptFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", name = "__FLEX_Context", scope = MiscellaneousReceiptFLEX.class)
    public JAXBElement<String> createMiscellaneousReceiptFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptFLEXFLEXContext_QNAME, String.class, MiscellaneousReceiptFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/MiscellaneousReceiptDff/", name = "__FLEX_Context_DisplayValue", scope = MiscellaneousReceiptFLEX.class)
    public JAXBElement<String> createMiscellaneousReceiptFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_MiscellaneousReceiptFLEXFLEXContextDisplayValue_QNAME, String.class, MiscellaneousReceiptFLEX.class, value);
    }

}
