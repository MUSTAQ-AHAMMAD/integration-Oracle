package innovate.tamergroup.fusion.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
import java.util.List;


public class FusionInvTxnService {

    private FusionAppParams params;
    private Credential credential;


    public FusionInvTxnService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }

    public InventoryTransactionResponse insertInvTransactions(List<TransactionLine> invTxnLines) throws IOException {
        InventoryTransactionRequest transactionLinesRequest = new InventoryTransactionRequest();
        transactionLinesRequest.setTransactionLines(invTxnLines);
        
        InsertObjectFusion insertObject = new InsertObjectFusion(FusionAppDomain.SCM, params, credential);
        InventoryTransactionResponse transactionResponse = 
            insertObject.createTransaction(InventoryTransactionResponse.class, "/fscmRestApi/resources/11.13.17.11/inventoryTransactions", transactionLinesRequest);

        return transactionResponse;
    }

    public static void main(String[] args) throws IOException {

        /*TransactionLine transactionLine = new TransactionLine();
        transactionLine.withOrganizationName("Ibrahim AL Qurashi - KSA")
            .withItem("OIL00001")
            .withSubinventory("IBRAHEEM ALQURASHI TAHLIA")
            .withTransactionType("Miscellaneous issue")
            .withTransactionUnitOfMeasure("Gram")
            .withTransactionQuantity(-3.00)
            .withTransactionDate(new Date());
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").create();
        System.out.println(gson.toJson(new Date()));
        
        InventoryTransactionRequest transactionRequest = new InventoryTransactionRequest();
        transactionRequest.setTransactionLines(new ArrayList<>());
        transactionRequest.getTransactionLines().add(transactionLine);

        InventoryTransactionResponse response = new FusionInvTxnService(new FusionAppParams("ehxk-test", "em2"),
                                new Credential("Ahmed.ali", "Tamer@123")).insertInvTransactions(transactionRequest);
        System.out.println(response);*/

    }

}
