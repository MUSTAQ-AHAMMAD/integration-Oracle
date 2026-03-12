package innovate.tamergroup.fusion.soap.services;

import com.oracle.xmlns.adf.svc.types.FindControl;
import com.oracle.xmlns.adf.svc.types.FindCriteria;
import com.oracle.xmlns.adf.svc.types.ViewCriteria;
import com.oracle.xmlns.adf.svc.types.ViewCriteriaItem;
import com.oracle.xmlns.adf.svc.types.ViewCriteriaRow;
import com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2.ExternalBankAccount;
import com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2.ExternalBankAccountService;
import com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2.ExternalBankAccountService_Service;
import com.oracle.xmlns.apps.financials.payments.shared.bankaccounts.bankaccountservicev2.ServiceException;

import innovate.tamergroup.fusion.soap.utils.FusionSOAPUtils;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.shared.utils.SOAPUtils;

import java.io.ByteArrayInputStream;

import java.net.MalformedURLException;

import java.util.List;

import javax.xml.ws.BindingProvider;

import weblogic.jws.jaxws.ClientPolicyFeature;
import weblogic.jws.jaxws.policy.InputStreamPolicySource;


public class FusionExternalBankClient {
    
    public FusionExternalBankClient() {
        super();
    }
    
    public static Long getBankAccountId(FusionAppParams params, Credential credential, String accountNumber) throws MalformedURLException,
                                                                                                ServiceException {
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));
        
        ExternalBankAccountService externalBankAccountService =
            new ExternalBankAccountService_Service(params).getExternalBankAccountServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)externalBankAccountService, credential);
        
        ViewCriteriaItem criteriaItem = new ViewCriteriaItem();
        criteriaItem.setAttribute("BankAccountNumber");
        criteriaItem.setOperator("=");
        criteriaItem.getValue().add(accountNumber);
        
        ViewCriteriaRow criteriaRow = new ViewCriteriaRow();
        criteriaRow.getItem().add(criteriaItem);
        
        ViewCriteria viewCriteria = new ViewCriteria();
        viewCriteria.getGroup().add(criteriaRow);
        
        FindCriteria findCriteria = new FindCriteria();
        findCriteria.setFetchSize(1);
        findCriteria.setFetchStart(0);
        findCriteria.setFilter(viewCriteria);
        
        FindControl findControl = new FindControl();
        findControl.setRetrieveAllTranslations(false);
        
        List<ExternalBankAccount> externalBankAccounts = externalBankAccountService.findExternalBankAccount(findCriteria, findControl);
        
        return externalBankAccounts.get(0).getExternalBankAccountId().getValue();
    }
    
    public static void main(String[] args) throws MalformedURLException, ServiceException {
        System.out.println(getBankAccountId(new FusionAppParams("ehxk-test", "em2"), new Credential("Ahmed.ali", "Tamer@123"), "1011203"));
    }
}
