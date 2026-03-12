package innovate.tamergroup.fusion.soap.services;

import com.oracle.xmlns.adf.svc.types.FindControl;
import com.oracle.xmlns.adf.svc.types.FindCriteria;
import com.oracle.xmlns.adf.svc.types.ViewCriteria;
import com.oracle.xmlns.adf.svc.types.ViewCriteriaItem;
import com.oracle.xmlns.adf.svc.types.ViewCriteriaRow;

import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.Item;
import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.ItemService;
import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.ItemService_Service;
import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.ServiceException;

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


public class FusionItemClient {
    
    public FusionItemClient() {
        super();
    }
    
    public static String getItemNameTranslation(FusionAppParams params, Credential credential, String itemNumber) throws MalformedURLException, ServiceException {
        
        String empty_policy = "<wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"/>";
        ClientPolicyFeature feature = new ClientPolicyFeature();
        feature.setEffectivePolicy(new InputStreamPolicySource(new ByteArrayInputStream(empty_policy.getBytes())));
        
        ItemService itemService =
            new ItemService_Service(params).getItemServiceSoapHttpPort(feature);
        SOAPUtils.setCredentials((BindingProvider)itemService, credential);
        
        ViewCriteriaItem criteriaItem = new ViewCriteriaItem();
        criteriaItem.setAttribute("ItemNumber");
        criteriaItem.setOperator("=");
        criteriaItem.getValue().add(itemNumber);
        
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
        
        List<Item> items = itemService.findItem(findCriteria, findControl);
        
        return items.get(0).getItemTranslation().get(0).getItemDescription().getValue();
    }
    
    public static void main(String[] args) throws MalformedURLException, ServiceException {
        System.out.println(getItemNameTranslation(new FusionAppParams("ehxk-test", "em2"), new Credential("Ahmed.ali", "Tamer@123"), "OIL00001"));
    }
}
