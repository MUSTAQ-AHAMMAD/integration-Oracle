package innovate.tamergroup.fusion.rest.services;

import com.oracle.xmlns.apps.scm.item.Uom;
import com.oracle.xmlns.utils.FetchListFusion;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;


public class FusionUomService {
    
    private FusionAppParams params;
    private Credential credential;


    public FusionUomService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }

    public String getUomCode(String uomName) throws IOException {

        FetchListFusion fetchSCMList = new FetchListFusion(FusionAppDomain.SCM, params, credential);
        
        HashMap<String, String> queryParameters = new HashMap<>();
        queryParameters.put("q", "UOM=" + uomName);
        queryParameters.put("fields", "UOMCode");
        List<Uom> uomList =
            fetchSCMList.execute(Uom.class, "/fscmRestApi/resources/11.13.17.11/unitsOfMeasure", queryParameters, 1);

        for (Uom uom : uomList)
            System.out.println(uom.getUOMCode());

        return uomList.get(0).getUOMCode();

    }

    public static void main(String[] args) throws IOException {
        new FusionUomService(new FusionAppParams("ehxk", "em2"), new Credential("mahmood.alrae@tamergroup.com", "Welcome123"))
            .getUomCode("Each");
    }


}
