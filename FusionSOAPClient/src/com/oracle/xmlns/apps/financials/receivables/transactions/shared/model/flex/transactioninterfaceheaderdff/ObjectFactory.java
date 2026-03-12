
package com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfaceheaderdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfaceheaderdff package. 
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

    private final static QName _TransactionInterfaceHeaderFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "transactionInterfaceHeaderFLEX");
    private final static QName _TransactionInterfaceHeaderFLEXCONTRACTINVOICES_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "transactionInterfaceHeaderFLEXCONTRACT__INVOICES");
    private final static QName _TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICES_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "transactionInterfaceHeaderFLEXCONTRACT__INTERNAL__INVOICES");
    private final static QName _TransactionInterfaceHeaderFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "__FLEX_Context_DisplayValue");
    private final static QName _TransactionInterfaceHeaderFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "_FLEX_NumOfSegments");
    private final static QName _TransactionInterfaceHeaderFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "__FLEX_Context");
    private final static QName _TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "_Contract__Number");
    private final static QName _TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESDraftInvoiceNumber_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "_Draft__Invoice__Number");
    private final static QName _TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "_Contract__Id");
    private final static QName _TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractOrganization_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", "_Contract__Organization");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactioninterfaceheaderdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionInterfaceHeaderFLEX2}
     *
     */
    public TransactionInterfaceHeaderFLEX2 createTransactionInterfaceHeaderFLEXCONTRACTINVOICES() {
        return new TransactionInterfaceHeaderFLEX2();
    }

    /**
     * Create an instance of {@link TransactionInterfaceHeaderFLEX1}
     *
     */
    public TransactionInterfaceHeaderFLEX1 createTransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICES() {
        return new TransactionInterfaceHeaderFLEX1();
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
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "transactionInterfaceHeaderFLEX")
    public JAXBElement<TransactionInterfaceHeaderFLEX> createTransactionInterfaceHeaderFLEX(TransactionInterfaceHeaderFLEX value) {
        return new JAXBElement<TransactionInterfaceHeaderFLEX>(_TransactionInterfaceHeaderFLEX_QNAME, TransactionInterfaceHeaderFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement} {@code <} {@link TransactionInterfaceHeaderFLEX2} {@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "transactionInterfaceHeaderFLEXCONTRACT__INVOICES")
    public JAXBElement<TransactionInterfaceHeaderFLEX2> createTransactionInterfaceHeaderFLEXCONTRACTINVOICES(TransactionInterfaceHeaderFLEX2 value) {
        return new JAXBElement<TransactionInterfaceHeaderFLEX2>(_TransactionInterfaceHeaderFLEXCONTRACTINVOICES_QNAME, TransactionInterfaceHeaderFLEX2.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement} {@code <} {@link TransactionInterfaceHeaderFLEX1} {@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "transactionInterfaceHeaderFLEXCONTRACT__INTERNAL__INVOICES")
    public JAXBElement<TransactionInterfaceHeaderFLEX1> createTransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICES(TransactionInterfaceHeaderFLEX1 value) {
        return new JAXBElement<TransactionInterfaceHeaderFLEX1>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICES_QNAME, TransactionInterfaceHeaderFLEX1.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "__FLEX_Context_DisplayValue", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXFLEXContextDisplayValue_QNAME, String.class, TransactionInterfaceHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_FLEX_NumOfSegments", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<Integer> createTransactionInterfaceHeaderFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_TransactionInterfaceHeaderFLEXFLEXNumOfSegments_QNAME, Integer.class, TransactionInterfaceHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "__FLEX_Context", scope = TransactionInterfaceHeaderFLEX.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXFLEXContext_QNAME, String.class, TransactionInterfaceHeaderFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Contract__Number", scope = TransactionInterfaceHeaderFLEX1.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractNumber(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractNumber_QNAME, String.class, TransactionInterfaceHeaderFLEX1.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Draft__Invoice__Number", scope = TransactionInterfaceHeaderFLEX1.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESDraftInvoiceNumber(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESDraftInvoiceNumber_QNAME, String.class, TransactionInterfaceHeaderFLEX1.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Contract__Id", scope = TransactionInterfaceHeaderFLEX1.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractId(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractId_QNAME, String.class, TransactionInterfaceHeaderFLEX1.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Contract__Organization", scope = TransactionInterfaceHeaderFLEX1.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractOrganization(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractOrganization_QNAME, String.class, TransactionInterfaceHeaderFLEX1.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Contract__Number", scope = TransactionInterfaceHeaderFLEX2.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINVOICESContractNumber(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractNumber_QNAME, String.class, TransactionInterfaceHeaderFLEX2.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Draft__Invoice__Number", scope = TransactionInterfaceHeaderFLEX2.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINVOICESDraftInvoiceNumber(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESDraftInvoiceNumber_QNAME, String.class, TransactionInterfaceHeaderFLEX2.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Contract__Id", scope = TransactionInterfaceHeaderFLEX2.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINVOICESContractId(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractId_QNAME, String.class, TransactionInterfaceHeaderFLEX2.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/", name = "_Contract__Organization", scope = TransactionInterfaceHeaderFLEX2.class)
    public JAXBElement<String> createTransactionInterfaceHeaderFLEXCONTRACTINVOICESContractOrganization(String value) {
        return new JAXBElement<String>(_TransactionInterfaceHeaderFLEXCONTRACTINTERNALINVOICESContractOrganization_QNAME, String.class, TransactionInterfaceHeaderFLEX2.class, value);
    }

}
