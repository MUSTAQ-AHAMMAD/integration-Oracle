package innovate.tamergroup.vendhq.persistence;

import com.oracle.xmlns.apps.scm.inventory.OnHandQuantityDetail;

import innovate.tamergroup.persistence.entities.VendhqSaleItemsOnhand;
import innovate.tamergroup.persistence.session.SessionEJB;

import innovate.tamergroup.vendhq.model.products.Product;

import innovate.tamergroup.vendhq.model.sales.LineItem;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;



public class ItemOnHandSalesPersistence {
    
    private SessionEJB session;
    private String region;

    public ItemOnHandSalesPersistence(SessionEJB session, String region) {
        this.session = session;
        this.region = region;
    }

    public synchronized void syncItemOnHand (Product product, List<OnHandQuantityDetail> qtyDetailList) {
        for (OnHandQuantityDetail inventory : qtyDetailList) {
            if (inventory.getSubinventoryCode() != null && !inventory.getSubinventoryCode().isEmpty())
                session.mergeVendhqSaleItemsOnhand(transformItemOnHand(product, inventory));
        }
    }

    private VendhqSaleItemsOnhand transformItemOnHand(Product product, OnHandQuantityDetail inventory) {
        VendhqSaleItemsOnhand itemsOnHand = session.getFindItemOnHandRow(product.getSku(), inventory.getSubinventoryCode());
        if (itemsOnHand == null) itemsOnHand = new VendhqSaleItemsOnhand();
        itemsOnHand.setOrgCode(inventory.getOrganizationCode());
        itemsOnHand.setSubinventory(inventory.getSubinventoryCode());
        itemsOnHand.setItemNumber(product.getSku());
        itemsOnHand.setUomCode(inventory.getPrimaryUOMCode());
        itemsOnHand.setOnhandQty(inventory.getOnhandQuantity() != null ? BigDecimal.valueOf(inventory.getOnhandQuantity()) : null);
        itemsOnHand.setReservedQty(inventory.getReservedQuantity() != null ? BigDecimal.valueOf(inventory.getReservedQuantity()) : null);
        itemsOnHand.setReceivingQty(inventory.getReceivingQuantity() != null ? BigDecimal.valueOf(inventory.getReceivingQuantity()) : null);
        itemsOnHand.setLastUpdateDate(new Date());
        itemsOnHand.setSaleQty(session.getItemSoldQuantity(product.getSku(), inventory.getSubinventoryCode()));   
        itemsOnHand.setRegion(region);
        return itemsOnHand;
    }
}
