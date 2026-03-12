package innovate.tamergroup.vendhq.services;

import innovate.tamergroup.shared.utils.Credential;

import java.io.IOException;

import java.util.List;

import innovate.tamergroup.vendhq.model.sales.Sale;
import innovate.tamergroup.vendhq.utils.FetchListVendHQ;

import java.util.HashMap;


public class VendHQSalesService {
    
    private String domain;
    private Credential credential;


    public VendHQSalesService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }

    public List<Sale> getVendHQSales(Long after) throws IOException {
        
        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        HashMap<String, String> queryParameters = new HashMap<>();
        //queryParameters.put("before", "6662511510");
        List<Sale> sales = fetchVendHQList.execute(Sale.class, 2, "sales", queryParameters, after);
        
        return sales;
    }
    
    public static void main(String[] args) throws IOException {
        VendHQSalesService salesService = new VendHQSalesService("ibraheemalqurashi", new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"));
        
        for (Sale sale : salesService.getVendHQSales(6797020384L)) {
            System.out.println(sale.getTotalPrice());
        }
    }
}
