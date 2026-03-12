package innovate.tamergroup.vendhq.persistence;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.entities.VendhqTaxMeta;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.model.tax.TaxInfo;
import innovate.tamergroup.vendhq.model.tax.Rate;
import innovate.tamergroup.vendhq.services.VendHQTaxService;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.List;

import javax.naming.NamingException;


public class TaxVendHQPersistence {
    
    public TaxVendHQPersistence() {
        super();
    }
    
    public static void syncTaxes(SessionEJB session, String region) throws IOException, NamingException {
        VendhqCredentials paraCredential = session.getVendHqCredentialByRegion(region);
        VendHQTaxService taxesService = new VendHQTaxService(paraCredential.getDomainName(), new Credential(paraCredential.getPersonalToken()));
        List<TaxInfo> taxes = taxesService.getVendHQTaxes(session.getVendHqTaxMaxVersion());
        for (TaxInfo taxInfo : taxes)
            for (Rate rate : taxInfo.getRates()) 
                session.mergeVendhqTaxMeta(transformOutlet(taxInfo, rate, region));        
    }
    
    private static VendhqTaxMeta transformOutlet(TaxInfo taxInfo, Rate rate, String region) {
        VendhqTaxMeta taxDb = new VendhqTaxMeta();
        taxDb.setTaxId(rate.getId());
        taxDb.setTaxName(rate.getDisplayName());
        taxDb.setRate(rate.getRate());
        taxDb.setVersion(BigDecimal.valueOf(taxInfo.getVersion()));
        taxDb.setRegion(region);
        return taxDb;
    }
    
    public static void main(String[] args) {
        try {
            SessionEJB session = EJBClientUtil.getSessionEJB();
            syncTaxes(session, "SA");
        } catch (IOException | NamingException e) {
            e.printStackTrace();
        }
    }
}
