package innovate.tamergroup.vendhq.services;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.model.outlets.Outlet;
import innovate.tamergroup.vendhq.model.products.Brand;
import innovate.tamergroup.vendhq.utils.FetchListVendHQ;

import java.io.IOException;

import java.util.List;

public class VendHQBrandService {
    
    private String domain;
    private Credential credential;

    public VendHQBrandService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }
    
    public List<Brand> getVendHQBrands(Long after) throws IOException {
        
        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        List<Brand> brands = fetchVendHQList.execute(Brand.class, 2, "brands", null, after);
        
        return brands;
    }
    
    public static void main(String[] args) throws IOException {
        VendHQBrandService brandsService = new VendHQBrandService("ibraheemalqurashi", new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"));
        
        for (Brand brand : brandsService.getVendHQBrands(0L)) {
            System.out.println(brand.getName());
        }
    }
}
