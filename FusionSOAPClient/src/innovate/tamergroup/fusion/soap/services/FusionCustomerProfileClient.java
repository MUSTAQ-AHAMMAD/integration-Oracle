package innovate.tamergroup.fusion.soap.services;

import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.CustomerProfile;
import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.CustomerProfileResult;
import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.CustomerProfileService;

import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.CustomerProfileService_Service;

import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.ObjectFactory;
import com.oracle.xmlns.apps.financials.receivables.customers.customerprofileservice.ServiceException;

import innovate.tamergroup.fusion.soap.utils.FusionSOAPUtils;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.shared.utils.SOAPUtils;

import java.io.ByteArrayInputStream;

import java.net.MalformedURLException;

import javax.xml.ws.BindingProvider;

import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;

public class FusionCustomerProfileClient {
    
    private FusionAppParams params;
    private Credential credential;


    public FusionCustomerProfileClient(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }
    
    private CustomerProfile getCustomerProfile(String accountNumber) throws MalformedURLException, ServiceException {
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));

        CustomerProfileService customerProfileService =
            new CustomerProfileService_Service(params).getCustomerProfileServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)customerProfileService, credential);
        
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setAccountNumber(new ObjectFactory().createCustomerProfileAccountNumber(accountNumber));
        CustomerProfileResult result = customerProfileService.getActiveCustomerProfile(customerProfile);
        
        return result.getValue().get(0);
    }

    public Long getCustomerAccountId(String accountNumber) throws MalformedURLException, ServiceException {
        return getCustomerProfile(accountNumber).getCustomerAccountId();
    }
    
    public String getPaymentTerms(String accountNumber) throws MalformedURLException, ServiceException {
        return getCustomerProfile(accountNumber).getPaymentTerms().getValue();
    }
    
    public static void main(String[] args) throws MalformedURLException, ServiceException {
        System.out.println(new FusionCustomerProfileClient(new FusionAppParams("ehxk", "em2"), new Credential("mahmood.alrae@tamergroup.com", "Welcome123")).getPaymentTerms("12"));
    }
}
