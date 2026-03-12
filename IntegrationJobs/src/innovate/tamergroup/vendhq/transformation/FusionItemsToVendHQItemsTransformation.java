package innovate.tamergroup.vendhq.transformation;

import com.oracle.xmlns.apps.scm.item.Item;

import innovate.tamergroup.persistence.entities.VendhqItemMeta;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.model.products.ProductCreate;
import innovate.tamergroup.vendhq.services.VendHQItemService;

public class FusionItemsToVendHQItemsTransformation {
    
    private String brandId;
    private String taxId;
    private SessionEJB session;
    private ProductCreate createItem;
    private String vendHqDomain;
    private Credential credential;


    public FusionItemsToVendHQItemsTransformation(String brandId, String taxId, SessionEJB session, 
                                                  String vendHqDomain,
                                                  Credential credential) {
        this.brandId = brandId;
        this.taxId = taxId;
        this.vendHqDomain = vendHqDomain;
        this.session = session;
        this.credential = credential;
    }

    public ProductCreate doTransformation(Item item, String region) throws Exception {
        createItem = new ProductCreate();
        createItem.withSourceId(String.valueOf(item.getItemId()))
                  .withVariantSourceId(item.getPrimaryUOMCode())
                  .withHandle(item.getItemNumber())
                  .withType(item.getUserItemTypeValue())  //Add Item Catalog Category
                  //.withVariantOptionOneName("Unit of Measure")
                  //.withVariantOptionOneValue(item.getPrimaryUOMValue())
                  .withActive(item.getInventoryItemStatusCode().equals("Active"))
                  .withSupplierCode(item.getItemNumber().substring(item.getItemNumber().length()-4, item.getItemNumber().length()))   //extract last 4 digits of item number
                  .withName(item.getLongDescription())
                  .withDescription(item.getItemDescription())
                  .withSku(item.getItemNumber())
                  .withTrackInventory(true)
                  .withTaxId(taxId);  //Constant value from Tax Classification Code
                  
        //createItem.setRetailPrice(session.getOpeningBalanceDBFindItemRow(item.getItemNumber()).getTrxSellingPrice().doubleValue());
        
        /*try {
            VendhqItemMeta itemMeta = session.getVendHQItemRowFusion(item.getItemNumber(), region);   //getGetVendHqItemRowProductId(item.getItemNumber());
            createItem.setRetailPrice(new VendHQItemService(vendHqDomain, credential).getVendHQItemDetail(itemMeta.getItemId()).getPriceExcludingTax());
        } catch (Exception e) {
            if (item.getMarketPrice() == null) throw new Exception("Market Price for the item is null. Please enter the market price and try again");
            else createItem.setRetailPrice(Double.valueOf(item.getMarketPrice()));
        }*/
        
        if (item.getMarketPrice() == null) throw new Exception("Market Price for the item is null. Please enter the market price and try again");
        else createItem.setRetailPrice(Double.valueOf(item.getMarketPrice()));
        
        return createItem;
    }
    
    public void setProductId(String productId) {
        createItem.setId(productId);
        //TODO depends on business condition
        createItem.setSupplierCode(null);
    }
}
