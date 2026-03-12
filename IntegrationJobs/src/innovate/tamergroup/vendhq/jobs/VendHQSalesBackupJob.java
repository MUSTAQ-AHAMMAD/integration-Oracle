package innovate.tamergroup.vendhq.jobs;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.ExceptionAlerter;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.vendhq.integrations.VendHQSalesToFusionInvRecIntBackup;
import innovate.tamergroup.vendhq.persistence.BackupSalesVendHqPersistence;

import java.util.Date;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class VendHQSalesBackupJob implements Job {

    public VendHQSalesBackupJob() {}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String region = null;
        try {
            JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
            System.out.println(jobKey+": "+ new Date());
            
            SessionEJB session = EJBClientUtil.getSessionEJB();
            List<VendhqCredentials> vendHqDomainCredentials = session.getVendhqCredentialsFindAll();
            
            for (VendhqCredentials vendHqDomainCredential : vendHqDomainCredentials) {
                region = vendHqDomainCredential.getRegion();
                Credential vendHqcredential = new Credential(vendHqDomainCredential.getPersonalToken());
                new BackupSalesVendHqPersistence(vendHqDomainCredential.getRegion())
                    .backupSales(vendHqDomainCredential.getDomainName(), vendHqcredential);
            }
            
        } catch (Exception e) {
            System.out.println("Exception in VendHQ Sales Backup");
            System.out.println("====================================================================");
            System.out.println(e.getMessage());
            new ExceptionAlerter(region == null ? "" : region).sendException(e);
        }
    }
}
