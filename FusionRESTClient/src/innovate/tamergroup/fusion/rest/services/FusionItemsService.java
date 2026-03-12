package innovate.tamergroup.fusion.rest.services;

import com.oracle.xmlns.apps.scm.item.Item;
import com.oracle.xmlns.utils.FetchListFusion;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;

import innovate.tamergroup.shared.utils.FusionAppParams;

import java.io.IOException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Date;



public class FusionItemsService {
    
    private FusionAppParams params;
    private Credential credential;


    public FusionItemsService(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
    }

    public List<Item> getFusionItems(Date lastFetchedDate, String orgCode) throws IOException {

        FetchListFusion fetchSCMList = new FetchListFusion(FusionAppDomain.SCM, params, credential);
        
        HashMap<String, String> queryParameters = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        queryParameters.put("orderBy", "LastUpdateDate");
        queryParameters.put("q", "LastUpdateDate>" + dateFormat.format(lastFetchedDate) 
                                 + ";UserItemTypeValue=Finished%20Good;OrganizationCode=" + orgCode + ";");
        queryParameters.put("fields", "ItemId,ItemClass,OrganizationId,OrganizationCode,ItemNumber,ItemDescription," +
            "MarketPrice,PrimaryUOMCode,PrimaryUOMValue,UserItemTypeValue,InventoryItemStatusCode,LongDescription," +
            "OutputTaxClassificationCodeValue,LastUpdateDate,CreationDate");
        List<Item> itemList =
            fetchSCMList.execute(Item.class, "/fscmRestApi/resources/11.13.17.11/items", queryParameters, 500);

        for (Item item : itemList)
            System.out.println(item.getItemNumber() + " " + item.getMarketPrice() + "  " + item.getItemDescription() + "  " + item.getLastUpdateDate());
        
        System.out.println(itemList.size());

        return itemList;

    }

    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -10);
        new FusionItemsService(new FusionAppParams("ehxk-test", "em2"), new Credential("INTEGRATION", "Welcome123"))
            .getFusionItems(new Date(calendar.getTimeInMillis()), "VWH");
    }


}
