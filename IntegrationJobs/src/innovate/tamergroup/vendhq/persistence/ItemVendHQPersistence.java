package innovate.tamergroup.vendhq.persistence;

import com.oracle.xmlns.apps.scm.item.Item;

import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.vendhq.model.products.Productv1;

import java.math.BigDecimal;

import java.util.Date;


public class ItemVendHQPersistence {
    
    private Integer requestId;
    private SessionEJB session;
    private String region;

    public ItemVendHQPersistence(Integer requestId, SessionEJB session, String region) {
        this.requestId = requestId;
        this.session = session;
        this.region = region;
    }
    
    public VendhqItemMeta transformAndSaveItemDb(Item item) {
        VendhqItemMeta itemDb = new VendhqItemMeta();
        itemDb.setRequestId(BigDecimal.valueOf(requestId));
        itemDb.setStatus("New");
        itemDb.setMessage(" ");
        itemDb.setRequestDate(new Date(System.currentTimeMillis()));
        
        itemDb.setSourceId(BigDecimal.valueOf(item.getItemId()));
        itemDb.setUomCode(item.getPrimaryUOMCode());
    
        itemDb.setUomName(item.getPrimaryUOMValue());
        itemDb.setName(item.getLongDescription());
        itemDb.setDescription(item.getItemDescription());
        itemDb.setType(item.getUserItemTypeValue());
        itemDb.setSku(item.getItemNumber());
        itemDb.setLastUpdateDate(item.getLastUpdateDate());
        
        itemDb.setTrackInventory("1");
        itemDb.setRegion(region);
        
        return itemDb;
    }
    
    public void transformAndSaveProductDb(VendhqItemMeta itemDb, Productv1 product, String brandId, String status, String message) {
        itemDb.setStatus(status);
        itemDb.setMessage(message);
        
        if (product != null) {
            itemDb.setHandle(product.getHandle());
            itemDb.setActive(product.isActive() ? "1" : "0");
            itemDb.setItemId(product.getId());
            itemDb.setBrandId(brandId);
            itemDb.setTaxId(product.getTaxId());
            itemDb.setRetailPrice(BigDecimal.valueOf(product.getPrice()));
        }
    }
    
    public void saveItemDb(VendhqItemMeta itemDb) {
        session.mergeEntity(itemDb); 
    }
}
