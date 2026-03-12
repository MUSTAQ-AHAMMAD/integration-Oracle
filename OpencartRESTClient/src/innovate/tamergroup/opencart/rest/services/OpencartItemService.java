package innovate.tamergroup.opencart.rest.services;

import innovate.tamergroup.opencart.rest.model.product.fetch.Product;
import innovate.tamergroup.opencart.rest.model.product.post.ProductPost;
import innovate.tamergroup.opencart.rest.utils.FetchListOpencart;
import innovate.tamergroup.opencart.rest.utils.InsertObjectOpencart;
import innovate.tamergroup.shared.utils.Credential;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class OpencartItemService {
    
    private String domain;
    private Credential credential;


    public OpencartItemService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }
    
    public List<Product> getOpencartItems () throws IOException {
        
        FetchListOpencart fetchOpencartList = new FetchListOpencart(domain, credential);
        List<Product> products = fetchOpencartList.execute(Product.class, "product_admin", "products", null);
        
        return products;
    }
    
    public ProductPost insertVendHQItems (ProductPost createItem) throws IOException {
        
        InsertObjectOpencart insertItemVendHQ = new InsertObjectOpencart(domain, credential);
        ProductPost response = insertItemVendHQ.executeProductPost(createItem);
        
        return response;
    }
    
    public static void main(String[] args) throws IOException {
        OpencartItemService itemService = new OpencartItemService("forzalove.com/erp", new Credential("kzsMDr1P4RyO7TYhZVrwnlFjHllZPbgm"));
        
        for (Product product : itemService.getOpencartItems()) 
            System.out.println(product.getProductDescription().get(0).getName());
    }
}
