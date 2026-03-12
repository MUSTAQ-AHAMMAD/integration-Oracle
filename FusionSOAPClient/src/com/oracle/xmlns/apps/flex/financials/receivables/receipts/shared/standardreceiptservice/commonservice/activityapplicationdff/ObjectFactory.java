
package com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationdff package. 
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

    private final static QName _ReceivableApplicationFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", "receivableApplicationFLEX");
    private final static QName _ReceivableApplicationFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", "__FLEX_Context");
    private final static QName _ReceivableApplicationFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", "_FLEX_NumOfSegments");
    private final static QName _ReceivableApplicationFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.flex.financials.receivables.receipts.shared.standardreceiptservice.commonservice.activityapplicationdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceivableApplicationFLEX }
     * 
     */
    public ReceivableApplicationFLEX createReceivableApplicationFLEX() {
        return new ReceivableApplicationFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceivableApplicationFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", name = "receivableApplicationFLEX")
    public JAXBElement<ReceivableApplicationFLEX> createReceivableApplicationFLEX(ReceivableApplicationFLEX value) {
        return new JAXBElement<ReceivableApplicationFLEX>(_ReceivableApplicationFLEX_QNAME, ReceivableApplicationFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", name = "__FLEX_Context", scope = ReceivableApplicationFLEX.class)
    public JAXBElement<String> createReceivableApplicationFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_ReceivableApplicationFLEXFLEXContext_QNAME, String.class, ReceivableApplicationFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", name = "_FLEX_NumOfSegments", scope = ReceivableApplicationFLEX.class)
    public JAXBElement<Integer> createReceivableApplicationFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_ReceivableApplicationFLEXFLEXNumOfSegments_QNAME, Integer.class, ReceivableApplicationFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ActivityApplicationDff/", name = "__FLEX_Context_DisplayValue", scope = ReceivableApplicationFLEX.class)
    public JAXBElement<String> createReceivableApplicationFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_ReceivableApplicationFLEXFLEXContextDisplayValue_QNAME, String.class, ReceivableApplicationFLEX.class, value);
    }

}
