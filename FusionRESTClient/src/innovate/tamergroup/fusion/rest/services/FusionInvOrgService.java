package innovate.tamergroup.fusion.rest.services;

import com.oracle.xmlns.apps.scm.inventory.InventoryOrganization;
import com.oracle.xmlns.utils.FetchListFusion;

import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.shared.utils.FusionAppDomain;

import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

public class FusionInvOrgService {
    
    private FusionAppParams params;
    private Credential credential;


    public FusionInvOrgService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }

    public Long getbuIdFromName(String buName) throws IOException {
        
        FetchListFusion fetchSCMList = new FetchListFusion(FusionAppDomain.SCM, params, credential);
        HashMap<String, String> queryParameters = new HashMap<>();
        queryParameters.put("q", "ManagementBusinessUnitName=" + buName);
        List<InventoryOrganization> orgList =
            fetchSCMList.execute(InventoryOrganization.class, "/fscmRestApi/resources/11.13.17.11/inventoryOrganizations", queryParameters, 1000);

        System.out.println(orgList.get(0).getManagementBusinessUnitId());

        return orgList.get(0).getManagementBusinessUnitId();
    }

    public static void main(String[] args) throws IOException {
        new FusionInvOrgService(new FusionAppParams("ehxk-test", "em2"), new Credential("Ahmed.ali", "Tamer@123"))
            .getbuIdFromName("Ibrahim AL Qurashi - KSA");

    }
}
