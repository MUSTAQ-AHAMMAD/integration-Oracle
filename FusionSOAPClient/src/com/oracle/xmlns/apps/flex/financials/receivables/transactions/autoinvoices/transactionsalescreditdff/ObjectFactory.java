
package com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionsalescreditdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionsalescreditdff package. 
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

    private final static QName _TransactionSalesCreditFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", "transactionSalesCreditFLEX");
    private final static QName _TransactionSalesCreditFLEXInterfaceSalescreditGuid_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", "InterfaceSalescreditGuid");
    private final static QName _TransactionSalesCreditFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", "_FLEX_NumOfSegments");
    private final static QName _TransactionSalesCreditFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", "__FLEX_Context");
    private final static QName _TransactionSalesCreditFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactionsalescreditdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionSalesCreditFLEX }
     * 
     */
    public TransactionSalesCreditFLEX createTransactionSalesCreditFLEX() {
        return new TransactionSalesCreditFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionSalesCreditFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", name = "transactionSalesCreditFLEX")
    public JAXBElement<TransactionSalesCreditFLEX> createTransactionSalesCreditFLEX(TransactionSalesCreditFLEX value) {
        return new JAXBElement<TransactionSalesCreditFLEX>(_TransactionSalesCreditFLEX_QNAME, TransactionSalesCreditFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", name = "InterfaceSalescreditGuid", scope = TransactionSalesCreditFLEX.class)
    public JAXBElement<String> createTransactionSalesCreditFLEXInterfaceSalescreditGuid(String value) {
        return new JAXBElement<String>(_TransactionSalesCreditFLEXInterfaceSalescreditGuid_QNAME, String.class, TransactionSalesCreditFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", name = "_FLEX_NumOfSegments", scope = TransactionSalesCreditFLEX.class)
    public JAXBElement<Integer> createTransactionSalesCreditFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_TransactionSalesCreditFLEXFLEXNumOfSegments_QNAME, Integer.class, TransactionSalesCreditFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", name = "__FLEX_Context", scope = TransactionSalesCreditFLEX.class)
    public JAXBElement<String> createTransactionSalesCreditFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_TransactionSalesCreditFLEXFLEXContext_QNAME, String.class, TransactionSalesCreditFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionSalesCreditDff/", name = "__FLEX_Context_DisplayValue", scope = TransactionSalesCreditFLEX.class)
    public JAXBElement<String> createTransactionSalesCreditFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_TransactionSalesCreditFLEXFLEXContextDisplayValue_QNAME, String.class, TransactionSalesCreditFLEX.class, value);
    }

}
