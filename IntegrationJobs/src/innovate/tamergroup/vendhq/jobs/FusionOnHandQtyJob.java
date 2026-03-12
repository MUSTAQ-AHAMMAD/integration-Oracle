package innovate.tamergroup.vendhq.jobs;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.FusionCredentials;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.integrations.FusionOnHandQtyFetch;
import innovate.tamergroup.vendhq.integrations.VendHQSalesToFusionInvRecIntBackup;
import innovate.tamergroup.vendhq.persistence.BackupSalesVendHqPersistence;

import java.util.Date;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class FusionOnHandQtyJob implements Job {

    public FusionOnHandQtyJob() {}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
            System.out.println(jobKey+": "+ new Date());
            
            JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
            
            FusionAppParams fusionParams = new FusionAppParams(dataMap.getString("fusionHostname"), dataMap.getString("fusionServer"));
            Credential fusionCredential = new Credential(dataMap.getString("fusionUsername"), dataMap.getString("fusionPassword"));
            
            SessionEJB session = EJBClientUtil.getSessionEJB();
            List<VendhqCredentials> vendHqDomainCredentials = session.getVendhqCredentialsFindAll();
            FusionOnHandQtyFetch onHandQtyFetchService = new FusionOnHandQtyFetch(fusionParams, fusionCredential);
            
            
            for (VendhqCredentials vendHqDomainCredential : vendHqDomainCredentials) {
                Credential vendHqcredential = new Credential(vendHqDomainCredential.getPersonalToken());
                onHandQtyFetchService.syncFusionOnHandQty(vendHqcredential, vendHqDomainCredential.getDomainName(), 
                                                          vendHqDomainCredential.getRegion(), 
                                                          vendHqDomainCredential.getFusionOrgCode());
            }
            
        } catch (Exception e) {
            System.out.println("Exception in Sync Fusion On Hand Qty");
            System.out.println("====================================================================");
            System.out.println(e.getMessage());
        }
    }
}
