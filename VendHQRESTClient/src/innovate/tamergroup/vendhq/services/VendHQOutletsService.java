package innovate.tamergroup.vendhq.services;

import innovate.tamergroup.shared.utils.Credential;

import java.io.IOException;

import java.util.List;

import innovate.tamergroup.vendhq.model.outlets.Outlet;

import innovate.tamergroup.vendhq.utils.FetchListVendHQ;

public class VendHQOutletsService {
    
    private String domain;
    private Credential credential;


    public VendHQOutletsService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }

    public List<Outlet> getVendHQOutlets (Long after) throws IOException {
        
        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        List<Outlet> outlets = fetchVendHQList.execute(Outlet.class, 2, "outlets", null, after);
        
        return outlets;
    }
    
    public static void main(String[] args) throws IOException {
        VendHQOutletsService outletsService = new VendHQOutletsService("ibraheemalqurashi", new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"));
        
        for (Outlet outlet : outletsService.getVendHQOutlets(0L)) {
            System.out.println(outlet.getName());
        }
    }
}
