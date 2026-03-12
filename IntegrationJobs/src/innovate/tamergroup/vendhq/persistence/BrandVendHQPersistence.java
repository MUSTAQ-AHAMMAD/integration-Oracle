package innovate.tamergroup.vendhq.persistence;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.VendhqBrandMeta;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.model.products.Brand;
import innovate.tamergroup.vendhq.services.VendHQBrandService;

import java.io.IOException;

import java.util.List;

import javax.naming.NamingException;

public class BrandVendHQPersistence {
    
    public BrandVendHQPersistence() {
        super();
    }
    
    public static void syncBrands(SessionEJB session, String region) throws IOException, NamingException {
        VendHQBrandService brandsService = new VendHQBrandService("iaqtest", new Credential("4GYI1hpMtznv9KNsCUWD1_xsAfu5tlmxjdPhbL3a"));
        List<Brand> brandList = brandsService.getVendHQBrands(session.getVendhqBrandMetaMaxVersion());
        for (Brand brand : brandList)
            session.mergeVendhqBrandMeta(transformOutlet(brand, region));        
    }
    
    private static VendhqBrandMeta transformOutlet(Brand brand, String region) {
        VendhqBrandMeta brandDb = new VendhqBrandMeta();
        brandDb.setBrandId(brand.getId());
        brandDb.setName(brand.getName());
        brandDb.setVersion(String.valueOf(brand.getVersion())); 
        brandDb.setRegion(region);
        return brandDb;
    }
    
    public static void main(String[] args) {
        try {
            SessionEJB session = EJBClientUtil.getSessionEJB();
            syncBrands(session, "SA");
            /* System.out.println(session.getReceiptMethod("Cash rounding").getReceiptMethodName());*/
        } catch (IOException | NamingException e) {
            e.printStackTrace();
        }
    }
}
