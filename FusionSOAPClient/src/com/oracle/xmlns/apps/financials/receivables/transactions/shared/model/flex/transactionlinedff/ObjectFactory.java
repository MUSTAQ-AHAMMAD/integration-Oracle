
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinedff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinedff package. 
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

    private final static QName _TransactionLineFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", "transactionLineFLEX");
    private final static QName _TransactionLineFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", "__FLEX_Context_DisplayValue");
    private final static QName _TransactionLineFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", "_FLEX_NumOfSegments");
    private final static QName _TransactionLineFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", "__FLEX_Context");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactionlinedff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionLineFLEX }
     * 
     */
    public TransactionLineFLEX createTransactionLineFLEX() {
        return new TransactionLineFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionLineFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", name = "transactionLineFLEX")
    public JAXBElement<TransactionLineFLEX> createTransactionLineFLEX(TransactionLineFLEX value) {
        return new JAXBElement<TransactionLineFLEX>(_TransactionLineFLEX_QNAME, TransactionLineFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", name = "__FLEX_Context_DisplayValue", scope = TransactionLineFLEX.class)
    public JAXBElement<String> createTransactionLineFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_TransactionLineFLEXFLEXContextDisplayValue_QNAME, String.class, TransactionLineFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", name = "_FLEX_NumOfSegments", scope = TransactionLineFLEX.class)
    public JAXBElement<Integer> createTransactionLineFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_TransactionLineFLEXFLEXNumOfSegments_QNAME, Integer.class, TransactionLineFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/", name = "__FLEX_Context", scope = TransactionLineFLEX.class)
    public JAXBElement<String> createTransactionLineFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_TransactionLineFLEXFLEXContext_QNAME, String.class, TransactionLineFLEX.class, value);
    }

}
