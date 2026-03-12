package innovate.tamergroup.vendhq.persistence;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.OutletsIntegrationConfig;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.vendhq.services.VendHQOutletsService;
import innovate.tamergroup.vendhq.model.outlets.Outlet;

import java.io.IOException;

import java.util.List;

import java.math.BigDecimal;

import javax.naming.NamingException;


public class OutletVendHQPersistence {

    public OutletVendHQPersistence() {
    }

    public static void syncOutlets(SessionEJB session, String region) throws IOException, NamingException {
        if (session == null) session = EJBClientUtil.getSessionEJB();
        VendhqCredentials paraCredential = session.getVendHqCredentialByRegion(region);
        VendHQOutletsService outletsService = new VendHQOutletsService(paraCredential.getDomainName(), new Credential(paraCredential.getPersonalToken()));
        List<Outlet> outlets = outletsService.getVendHQOutlets(session.getOutletsMaxVersion());
        for (Outlet outlet : outlets) 
            session.mergeVendhqOutletsDB(transformOutlet(outlet, region));        
    }
    
    private static VendhqOutletsDB transformOutlet(Outlet outlet, String region) {
        VendhqOutletsDB outletDb = new VendhqOutletsDB();
        outletDb.setOutletName(outlet.getName());
        outletDb.setOutletId(outlet.getId());
        outletDb.setCurrency(outlet.getCurrency());
        outletDb.setVersion(BigDecimal.valueOf(outlet.getVersion()));
        outletDb.setDeletedAt(outlet.getDeletedAt());
        outletDb.setRegion(region);
        return outletDb;
    }
    
    public static void syncOutletsConfig(SessionEJB session, String region) throws IOException, NamingException {
        if (session == null) session = EJBClientUtil.getSessionEJB();
        VendhqCredentials paraCredential = session.getVendHqCredentialByRegion(region);
        VendHQOutletsService outletsService = new VendHQOutletsService(paraCredential.getDomainName(), new Credential(paraCredential.getPersonalToken()));
        List<Outlet> outlets = outletsService.getVendHQOutlets(0L);
        for (Outlet outlet : outlets) {
            String status = session.getOutletIntegStatus(outlet.getName(), region);
            session.mergeEntity(transformOutletConfig(outlet, status, region));       
        }
    }
    
    private static OutletsIntegrationConfig transformOutletConfig(Outlet outlet, String status, String region) {
        OutletsIntegrationConfig outletDb = new OutletsIntegrationConfig();
        outletDb.setOutletName(outlet.getName());
        outletDb.setIntegMode(status);
        outletDb.setRegion(region);
        return outletDb;
    }
    
    public static void main(String[] args) {
        try {
            SessionEJB session = EJBClientUtil.getSessionEJB();
            syncOutlets(session, "SA");
        } catch (IOException | NamingException e) {
            e.printStackTrace();
        }
    }
}
