
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactiondistributiondff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactiondistributiondff package. 
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

    private final static QName _TransactionDistributionFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", "transactionDistributionFLEX");
    private final static QName _TransactionDistributionFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", "__FLEX_Context_DisplayValue");
    private final static QName _TransactionDistributionFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", "__FLEX_Context");
    private final static QName _TransactionDistributionFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", "_FLEX_NumOfSegments");
    private final static QName _TransactionDistributionFLEXInterfaceDistributionGuid_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", "InterfaceDistributionGuid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactiondistributiondff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionDistributionFLEX }
     * 
     */
    public TransactionDistributionFLEX createTransactionDistributionFLEX() {
        return new TransactionDistributionFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionDistributionFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", name = "transactionDistributionFLEX")
    public JAXBElement<TransactionDistributionFLEX> createTransactionDistributionFLEX(TransactionDistributionFLEX value) {
        return new JAXBElement<TransactionDistributionFLEX>(_TransactionDistributionFLEX_QNAME, TransactionDistributionFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", name = "__FLEX_Context_DisplayValue", scope = TransactionDistributionFLEX.class)
    public JAXBElement<String> createTransactionDistributionFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_TransactionDistributionFLEXFLEXContextDisplayValue_QNAME, String.class, TransactionDistributionFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", name = "__FLEX_Context", scope = TransactionDistributionFLEX.class)
    public JAXBElement<String> createTransactionDistributionFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_TransactionDistributionFLEXFLEXContext_QNAME, String.class, TransactionDistributionFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", name = "_FLEX_NumOfSegments", scope = TransactionDistributionFLEX.class)
    public JAXBElement<Integer> createTransactionDistributionFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_TransactionDistributionFLEXFLEXNumOfSegments_QNAME, Integer.class, TransactionDistributionFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/", name = "InterfaceDistributionGuid", scope = TransactionDistributionFLEX.class)
    public JAXBElement<String> createTransactionDistributionFLEXInterfaceDistributionGuid(String value) {
        return new JAXBElement<String>(_TransactionDistributionFLEXInterfaceDistributionGuid_QNAME, String.class, TransactionDistributionFLEX.class, value);
    }

}
