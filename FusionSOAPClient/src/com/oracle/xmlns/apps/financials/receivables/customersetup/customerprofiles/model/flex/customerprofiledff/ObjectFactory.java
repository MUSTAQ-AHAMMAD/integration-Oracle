
package com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofiledff;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofiledff package. 
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

    private final static QName _CustomerProfileFLEX_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", "customerProfileFLEX");
    private final static QName _CustomerProfileFLEXFLEXContext_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", "__FLEX_Context");
    private final static QName _CustomerProfileFLEXFLEXNumOfSegments_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", "_FLEX_NumOfSegments");
    private final static QName _CustomerProfileFLEXFLEXContextDisplayValue_QNAME = new QName("http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", "__FLEX_Context_DisplayValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.apps.financials.receivables.customersetup.customerprofiles.model.flex.customerprofiledff
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerProfileFLEX }
     * 
     */
    public CustomerProfileFLEX createCustomerProfileFLEX() {
        return new CustomerProfileFLEX();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerProfileFLEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", name = "customerProfileFLEX")
    public JAXBElement<CustomerProfileFLEX> createCustomerProfileFLEX(CustomerProfileFLEX value) {
        return new JAXBElement<CustomerProfileFLEX>(_CustomerProfileFLEX_QNAME, CustomerProfileFLEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", name = "__FLEX_Context", scope = CustomerProfileFLEX.class)
    public JAXBElement<String> createCustomerProfileFLEXFLEXContext(String value) {
        return new JAXBElement<String>(_CustomerProfileFLEXFLEXContext_QNAME, String.class, CustomerProfileFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", name = "_FLEX_NumOfSegments", scope = CustomerProfileFLEX.class)
    public JAXBElement<Integer> createCustomerProfileFLEXFLEXNumOfSegments(Integer value) {
        return new JAXBElement<Integer>(_CustomerProfileFLEXFLEXNumOfSegments_QNAME, Integer.class, CustomerProfileFLEX.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/financials/receivables/customerSetup/customerProfiles/model/flex/CustomerProfileDff/", name = "__FLEX_Context_DisplayValue", scope = CustomerProfileFLEX.class)
    public JAXBElement<String> createCustomerProfileFLEXFLEXContextDisplayValue(String value) {
        return new JAXBElement<String>(_CustomerProfileFLEXFLEXContextDisplayValue_QNAME, String.class, CustomerProfileFLEX.class, value);
    }

}
