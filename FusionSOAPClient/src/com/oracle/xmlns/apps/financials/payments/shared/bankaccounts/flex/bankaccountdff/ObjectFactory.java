
package com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff package. 
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

    private final static QName _ExternalBankAccount_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", "externalBankAccount");
    private final static QName _ExternalBankAccountFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", "__FLEX_Context_DisplayValue");
    private final static QName _ExternalBankAccountExtBankAccountId_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", "ExtBankAccountId");
    private final static QName _ExternalBankAccountFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", "__FLEX_Context");
    private final static QName _ExternalBankAccountFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", "_FLEX_NumOfSegments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.flex.bankaccountdff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExternalBankAccount }
     * 
     */
    public ExternalBankAccount createExternalBankAccount() {
        return new ExternalBankAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", name = "externalBankAccount")
    public JAXBElement<ExternalBankAccount> createExternalBankAccount(ExternalBankAccount value) {
        return new JAXBElement<ExternalBankAccount>(_ExternalBankAccount_QNAME, ExternalBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", name = "__FLEX_Context_DisplayValue", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_ExternalBankAccountFLEXContextDisplayValue_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", name = "ExtBankAccountId", scope = ExternalBankAccount.class)
    public JAXBElement<Long> createExternalBankAccountExtBankAccountId(Long value) {
        return new JAXBElement<Long>(_ExternalBankAccountExtBankAccountId_QNAME, Long.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", name = "__FLEX_Context", scope = ExternalBankAccount.class)
    public JAXBElement<String> createExternalBankAccountFLEXContext(String value) {
        return new JAXBElement<String>(_ExternalBankAccountFLEXContext_QNAME, String.class, ExternalBankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/payments/shared/bankAccounts/flex/bankAccountDff/", name = "_FLEX_NumOfSegments", scope = ExternalBankAccount.class)
    public JAXBElement<Integer> createExternalBankAccountFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_ExternalBankAccountFLEXNumOfSegments_QNAME, Integer.class, ExternalBankAccount.class, value);
    }

}
