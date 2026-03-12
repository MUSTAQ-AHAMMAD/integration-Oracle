package innovate.tamergroup.vendhq.services;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.model.tax.Rate;
import innovate.tamergroup.vendhq.model.tax.TaxInfo;
import innovate.tamergroup.vendhq.utils.FetchListVendHQ;

import java.io.IOException;

import java.util.List;

public class VendHQTaxService {

    private String domain;
    private Credential credential;


    public VendHQTaxService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }

    public List<TaxInfo> getVendHQTaxes(Long after) throws IOException {

        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        List<TaxInfo> taxes = fetchVendHQList.execute(TaxInfo.class, 2, "taxes", null, after);

        return taxes;
    }

    public static void main(String[] args) throws IOException {
        VendHQTaxService taxesService =
            new VendHQTaxService("ibraheemalqurashi", new Credential("JOSupr0WY4xCYzKiXMZun_yAoitfnaNuuDvM5UFw"));


        for (TaxInfo taxInfo : taxesService.getVendHQTaxes(0L)) {
            System.out.println(taxInfo.getName());
            for (Rate rate : taxInfo.getRates()) {
                System.out.println("\t" + rate.getName());
            }
        }
    }
}
