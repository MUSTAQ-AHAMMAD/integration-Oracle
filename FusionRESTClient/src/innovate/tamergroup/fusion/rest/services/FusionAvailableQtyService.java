package innovate.tamergroup.fusion.rest.services;

import com.oracle.xmlns.apps.scm.inventory.AvailableQuantityRequest;
import com.oracle.xmlns.apps.scm.inventory.AvailableQuantityResponse;
import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionRequest;
import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionResponse;
import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import com.oracle.xmlns.utils.InsertObjectFusion;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;

import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;


public class FusionAvailableQtyService {

    private FusionAppParams params;
    private Credential credential;


    public FusionAvailableQtyService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }

    public AvailableQuantityResponse getAvailableQty(AvailableQuantityRequest availableQtyRequest) throws IOException {

        InsertObjectFusion insertObject = new InsertObjectFusion(FusionAppDomain.SCM, params, credential);

        AvailableQuantityResponse availableQtyResponse = 
            insertObject.createTransaction(AvailableQuantityResponse.class, "/fscmRestApi/resources/11.13.17.11/availableQuantityDetails", availableQtyRequest);

        return availableQtyResponse;
    }

    public static void main(String[] args) throws IOException {

        AvailableQuantityRequest qtyRequest = new AvailableQuantityRequest();
        qtyRequest.withOrganizationCode("WH1")
                    .withItemNumber("1030081335")
                    .withSubinventory("TAHLIA");

        AvailableQuantityResponse response = new FusionAvailableQtyService(new FusionAppParams("ehxk-test", "em2"),
                                new Credential("KAMAL", "Kemo1401")).getAvailableQty(qtyRequest);

        System.out.println(response.getReturnStatus());
        System.out.println(response.getReturnMessageText());
        System.out.println(response.getQuantityOnhand());
    }

}
