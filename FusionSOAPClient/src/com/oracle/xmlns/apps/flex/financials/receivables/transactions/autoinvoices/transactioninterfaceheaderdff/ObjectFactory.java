
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioninterfaceheaderdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioninterfaceheaderdff package. 
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

    private final static QName _TransactionInterfaceHeaderFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", "transactionInterfaceHeaderFLEX");
    private final static QName _TransactionInterfaceHeaderFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", "__FLEX_Context_DisplayValue");
    private final static QName _TransactionInterfaceHeaderFLEXInterfaceLineGuid_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", "InterfaceLineGuid");
    private final static QName _TransactionInterfaceHeaderFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", "_FLEX_NumOfSegments");
    private final static QName _TransactionInterfaceHeaderFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", "__FLEX_Context");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactioninterfaceheaderdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionInterfaceHeaderFLEX }
     * 
     */
    public TransactionInterfaceHeaderFLEX createTransactionInterfaceHeaderFLEX() {
        return new TransactionInterfaceHeaderFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionInterfaceHeaderFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", name = "transactionInterfaceHeaderFLEX")
    public JAXBElement<TransactionInterfaceHeaderFLEX> createTransactionInterfaceHeaderFLEX(TransactionInterfaceHeaderFLEX value) {
        return new JAXBElement<TransactionInterfaceHeaderFLEX>(_TransactionInterfaceHeaderFLEX_QNAME, TransactionInterfaceHeaderFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", name = "__FLEX_Context_DisplayValue", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXFLEXContextDisplayValue_QNAME, String.class, TransactionInterfaceHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", name = "InterfaceLineGuid", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXInterfaceLineGuid(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXInterfaceLineGuid_QNAME, String.class, TransactionInterfaceHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", name = "_FLEX_NumOfSegments", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<Integer> createTransactionInterfaceHeaderFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_TransactionInterfaceHeaderFLEXFLEXNumOfSegments_QNAME, Integer.class, TransactionInterfaceHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/", name = "__FLEX_Context", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXFLEXContext_QNAME, String.class, TransactionInterfaceHeaderFLEX.class, value);
    }

}
