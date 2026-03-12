package innovate.tamergroup.vendhq.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.shared.utils.RESTUtils;
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
import innovate.tamergroup.vendhq.utils.InsertObjectVendHQ;
import innovate.tamergroup.vendhq.utils.VendHQObjectListType;

import java.io.File;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class VendHQItemService {
    
    private String domain;
    private Credential credential;


    public VendHQItemService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }
    
    public Product getVendHQItemDetail(String productId) throws IOException {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
        OkHttpClient client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
          .url("https://" + domain + ".vendhq.com/api/2.0/products/" + productId)
          .get()
          .addHeader("Authorization", "Bearer " + credential)
          .build();
        Response response = client.newCall(request).execute();
        return gson.fromJson(response.body().string().replace("data", "product"), Product.class);
    }


    public List<Product> getVendHQItems(Long after) throws IOException {
        
        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        List<Product> products = fetchVendHQList.execute(Product.class, 2, "products", null, after);
        
        return products;
    }
    
    public ProductCreateResponse insertVendHQItems(ProductCreate createItem) throws IOException {
        
        InsertObjectVendHQ insertItemVendHQ = new InsertObjectVendHQ(domain, credential);
        ProductCreateResponse response = insertItemVendHQ.executeInventoryUpdate(createItem);
        
        return response;
    }
    
    public Boolean insertVendHQItemImage(String filePath, String productId) throws IOException {
        
        InsertObjectVendHQ insertItemImageVendHQ = new InsertObjectVendHQ(domain, credential);
        ImageUploadResponse response = insertItemImageVendHQ.insertItemImage(filePath, productId);
        
        return !response.getData().getStatus().equals("failed");
    }
    
    public static void main(String[] args) throws IOException {
        VendHQItemService itemService = new VendHQItemService("ibraheemalqurashi", new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"));
        
        for (Product product : itemService.getVendHQItems(0L)) 
            System.out.println(product.getName());
        System.out.println(itemService.getVendHQItems(0L).size());
        
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
