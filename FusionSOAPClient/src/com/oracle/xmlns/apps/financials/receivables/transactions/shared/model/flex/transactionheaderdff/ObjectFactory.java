
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheaderdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheaderdff package. 
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

    private final static QName _TransactionHeaderFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", "transactionHeaderFLEX");
    private final static QName _TransactionHeaderFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", "_FLEX_NumOfSegments");
    private final static QName _TransactionHeaderFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", "__FLEX_Context");
    private final static QName _TransactionHeaderFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionheaderdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionHeaderFLEX }
     * 
     */
    public TransactionHeaderFLEX createTransactionHeaderFLEX() {
        return new TransactionHeaderFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionHeaderFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", name = "transactionHeaderFLEX")
    public JAXBElement<TransactionHeaderFLEX> createTransactionHeaderFLEX(TransactionHeaderFLEX value) {
        return new JAXBElement<TransactionHeaderFLEX>(_TransactionHeaderFLEX_QNAME, TransactionHeaderFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", name = "_FLEX_NumOfSegments", scope = TransactionHeaderFLEX.class)
    public JAXBElement<Integer> createTransactionHeaderFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_TransactionHeaderFLEXFLEXNumOfSegments_QNAME, Integer.class, TransactionHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", name = "__FLEX_Context", scope = TransactionHeaderFLEX.class)
    public JAXBElement<String> createTransactionHeaderFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_TransactionHeaderFLEXFLEXContext_QNAME, String.class, TransactionHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/", name = "__FLEX_Context_DisplayValue", scope = TransactionHeaderFLEX.class)
    public JAXBElement<String> createTransactionHeaderFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_TransactionHeaderFLEXFLEXContextDisplayValue_QNAME, String.class, TransactionHeaderFLEX.class, value);
    }

}
