package innovate.tamergroup.vendhq.jobs;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.ExceptionAlerter;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.integrations.FusionItemsToVendHQItemsIntegration;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class FusionItemsToVendHQItemsJob implements Job {

    public FusionItemsToVendHQItemsJob() {}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String region = null;
        try {
            JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
            System.out.println(jobKey+": "+ new Date());
            
            JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
            FusionAppParams fusionParams = new FusionAppParams(dataMap.getString("fusionHostname"), dataMap.getString("fusionServer"));
            Credential fusionCredential = new Credential(dataMap.getString("fusionUsername"), dataMap.getString("fusionPassword"));
            
            SessionEJB session = EJBClientUtil.getSessionEJB();
            List<VendhqCredentials> vendHqDomainCredentials = session.getVendhqCredentialsFindAll();
            
            for (VendhqCredentials vendHqDomainCredential : vendHqDomainCredentials) {
                region = vendHqDomainCredential.getRegion();
                Credential vendHqcredential = new Credential(vendHqDomainCredential.getPersonalToken());
                new FusionItemsToVendHQItemsIntegration(fusionParams, vendHqDomainCredential.getDomainName(), fusionCredential, vendHqcredential)
                    .doIntegration(vendHqDomainCredential.getRegion(), vendHqDomainCredential.getFusionOrgCode(), vendHqDomainCredential.getFusionTaxCode());
            }
            
        } catch (Exception e) {
            System.out.println("Exception in VendHQ Items Integration");
            System.out.println("====================================================================");
            System.out.println(e.getMessage());
            new ExceptionAlerter(region == null ? "" : region).sendException(e);
        }
    }
}
