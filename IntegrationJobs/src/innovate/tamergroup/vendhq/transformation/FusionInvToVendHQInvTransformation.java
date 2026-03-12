package innovate.tamergroup.vendhq.transformation;


import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.model.outlets.Outlet;
import innovate.tamergroup.vendhq.model.products.InventoryUpdate;
import innovate.tamergroup.vendhq.model.products.Product;
import innovate.tamergroup.vendhq.model.products.ProductCreate;

import innovate.tamergroup.vendhq.services.VendHQItemService;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class FusionInvToVendHQInvTransformation {
    
    private ProductCreate invItem;
    private List<InventoryUpdate> inventoryList;
    private FusionAppParams params;
    private Credential credential;


    public FusionInvToVendHQInvTransformation(FusionAppParams params, Credential credential) {
        this.params = params;
        this.credential = credential;
        invItem = new ProductCreate();
        inventoryList = new ArrayList<>();
    }
    
    public void addInventoryRecord(String qtyResponse, Outlet outlet) {
        
        InventoryUpdate inventory = new InventoryUpdate();
        inventory.withOutletId(outlet.getId())
                 .withOutletName(outlet.getName())
                 .withCount(qtyResponse);
        inventoryList.add(inventory);
        
    }
    
    public void addInventoryRecord(String qtyResponse, VendhqOutletsDB outlet) {
        
        InventoryUpdate inventory = new InventoryUpdate();
        inventory.withOutletId(outlet.getOutletId())
                 .withOutletName(outlet.getOutletName())
                 .withCount(qtyResponse);
        inventoryList.add(inventory);
        
    }
    

    public ProductCreate doTransformation(Product product)  {
        
        invItem.withName(product.getName())
                .withId(product.getId())
                .withHandle(product.getHandle())
                .withSku(product.getSku())
                .withRetailPrice(product.getPriceExcludingTax())
                .withInventory(inventoryList);
        
        return invItem;
    }
    
    public ProductCreate doTransformation(String productId, VendHQItemService vendHQItemService)  {
        try {
            Product productOnline = vendHQItemService.getVendHQItemDetail(productId);
            invItem.withName(productOnline.getName())
                    .withId(productOnline.getId())
                    .withHandle(productOnline.getHandle())
                    .withSku(productOnline.getSku())
                    .withRetailPrice(productOnline.getPriceExcludingTax())
                    .withInventory(inventoryList);
            return invItem;
        } catch (IOException e) {
            return null;
        }
    }

    public List<InventoryUpdate> getInventoryList() {
        return inventoryList;
    }

}
