package innovate.tamergroup.fusion.rest.services;

import com.oracle.xmlns.apps.scm.inventory.OnHandQuantityDetail;
import com.oracle.xmlns.apps.scm.item.Uom;
import com.oracle.xmlns.utils.FetchListFusion;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;
import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;


public class FusionOnHandQtyService {
    
    private FusionAppParams params;
    private Credential credential;


    public FusionOnHandQtyService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }

    public List<OnHandQuantityDetail> getOnHandQtyDetails(String itemNumber, String orgCode) throws IOException {

        FetchListFusion fetchSCMList = new FetchListFusion(FusionAppDomain.SCM, params, credential);
        
        HashMap<String, String> queryParameters = new HashMap<>();
        queryParameters.put("q", "ItemNumber=" + itemNumber + ";OrganizationCode=" + orgCode);
        queryParameters.put("fields", "OrganizationCode,ItemNumber,SubinventoryCode,OnhandQuantity,OrganizationId," +
                       "InventoryItemId,PrimaryUOMCode,ReservedQuantity,ReceivingQuantity");
        List<OnHandQuantityDetail> qtyDetailList =
            fetchSCMList.execute(OnHandQuantityDetail.class, "/fscmRestApi/resources/11.13.17.11/onhandQuantityDetails", queryParameters, 500);

        System.out.println("ItemNumber: " + itemNumber);
        for (OnHandQuantityDetail qytDetail : qtyDetailList)
            System.out.println(qytDetail.getSubinventoryCode() + ": " + qytDetail.getOnhandQuantity());
        System.out.println();

        return qtyDetailList;

    }

    public static void main(String[] args) throws IOException {
        new FusionOnHandQtyService(new FusionAppParams("ehxk", "em2"), new Credential("mahmood.alrae@tamergroup.com", "Welcome123"))
            .getOnHandQtyDetails("1030041111", "VWH");
    }


}
