package innovate.tamergroup.vendhq.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.shared.utils.RESTUtils;
import innovate.tamergroup.vendhq.model.customers.Customer;
import innovate.tamergroup.vendhq.model.products.ImageUploadResponse;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import innovate.tamergroup.vendhq.model.products.InventoryUpdate;
import innovate.tamergroup.vendhq.model.products.Product;
import innovate.tamergroup.vendhq.model.products.ProductCreate;
import innovate.tamergroup.vendhq.model.products.ProductCreateResponse;

import innovate.tamergroup.vendhq.model.shared.VendHQObjectList;
import innovate.tamergroup.vendhq.utils.FetchListVendHQ;
import innovate.tamergroup.vendhq.utils.FetchSingleVendHQ;
import innovate.tamergroup.vendhq.utils.InsertObjectVendHQ;
import innovate.tamergroup.vendhq.utils.VendHQObjectListType;

import java.io.File;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class VendHQCustomerService {
    
    private String domain;
    private Credential credential;


    public VendHQCustomerService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }
    
    public Customer getVendHQCustomerDetail(String customerId) throws IOException {
        /*Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
        OkHttpClient client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
          .url("https://" + domain + ".vendhq.com/api/2.0/customers/" + productId)
          .get()
          .addHeader("Authorization", "Bearer " + credential)
          .build();
        Response response = client.newCall(request).execute();
        return gson.fromJson(response.body().string().replace("data", "product"), Product.class);*/
        
        FetchSingleVendHQ fetchVendHQSingle = new FetchSingleVendHQ(domain, credential);
        Customer customer = fetchVendHQSingle.execute(Customer.class, 2, "customers", null, customerId);
        
        return customer;
    }


    public List<Customer> getVendHQCustomers(Long after) throws IOException {
        
        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        List<Customer> customers = fetchVendHQList.execute(Customer.class, 2, "customers", null, after);
        
        return customers;
    }
    
    
    public static void main(String[] args) throws IOException {
        VendHQCustomerService customerService = new VendHQCustomerService("ibraheemalqurashi", new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"));
        
        /*for (Customer customer : customerService.getVendHQCustomers(0L)) 
            System.out.println(customer.getFirstName());*/
        System.out.println(customerService.getVendHQCustomerDetail("02dcd191-aef0-11e8-ed44-51ccd2ded300").getFirstName());
        
        /*InventoryUpdate inventory = new InventoryUpdate();
        inventory.withOutletId("0afa8de1-1450-11e8-edec-179c012ae288")
                 .withOutletName("IBRAHEEM ALQURASHI TAHLIA")
                 .withCount("10");
        List<InventoryUpdate> inventoryList = new ArrayList<>();
        inventoryList.add(inventory);
        
        ProductCreate createItem = new ProductCreate();
        createItem.withName("MukhtarItem")
                  .withHandle("MUKH")
                  .withSku("INV-SKU")
                  .withSourceId("300000001100015")
                  .withRetailPrice(6.25)
                  .withInventory(inventoryList);
        
        ProductCreateResponse response = itemService.insertVendHQItems(createItem);
        System.out.println(response.getProduct().getId());
        for (InventoryUpdate inventoryResponse : response.getProduct().getInventory())
            System.out.println("Count = " + inventoryResponse.getCount());*/

    }
        
}
