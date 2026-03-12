package innovate.tamergroup.fusion.rest.services;

import com.oracle.xmlns.apps.scm.inventory.ActiveSubinventory;
import com.oracle.xmlns.utils.FetchListFusion;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;


public class FusionSubinventoryService {
    
    private FusionAppParams params;
    private Credential credential;


    public FusionSubinventoryService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }
    
    private List<ActiveSubinventory> getOrganizations(String subinventoryName) throws IOException {
        FetchListFusion fetchSCMList = new FetchListFusion(FusionAppDomain.SCM, params, credential);
        
        HashMap<String, String> queryParameters = new HashMap<>();
        queryParameters.put("q", "SecondaryInventoryName=" + subinventoryName);
        queryParameters.put("fields", "OrganizationName,OrganizationCode");
        return fetchSCMList.execute(ActiveSubinventory.class, "/fscmRestApi/resources/11.13.17.11/activeSubinventories", queryParameters, 1);

    }

    public String getOrganizationName(String subinventoryName) throws IOException {
        List<ActiveSubinventory> subinventoryList = getOrganizations(subinventoryName);
        for (ActiveSubinventory subinventory : subinventoryList)
            System.out.println(subinventory.getOrganizationName());
        return subinventoryList.get(0).getOrganizationName();
    }
    
    public String getOrganizationCode(String subinventoryName) throws IOException {
        List<ActiveSubinventory> subinventoryList = getOrganizations(subinventoryName);
        for (ActiveSubinventory subinventory : subinventoryList)
            System.out.println(subinventory.getOrganizationCode());
        return subinventoryList.get(0).getOrganizationCode();
    }

    public static void main(String[] args) throws IOException {
        new FusionSubinventoryService(new FusionAppParams("ehxk", "em2"), new Credential("mahmood.alrae@tamergroup.com", "Welcome123"))
            .getOrganizationName("FLAMINGO");
    }


}
