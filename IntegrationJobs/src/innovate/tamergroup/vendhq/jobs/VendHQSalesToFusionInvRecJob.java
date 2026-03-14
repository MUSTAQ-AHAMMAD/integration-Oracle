package innovate.tamergroup.vendhq.jobs;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.ExceptionAlerter;
import innovate.tamergroup.persistence.entities.SalesIntegrationStatus;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.integrations.VendHQSalesToFusionInvRecIntBackup;

import java.util.Date;
import java.util.List;

import static innovate.tamergroup.shared.utils.Constants.AUTOMATIC;
import static innovate.tamergroup.shared.utils.Constants.RUNNING;
import static innovate.tamergroup.shared.utils.Constants.IDLE;

import javax.naming.NamingException;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class VendHQSalesToFusionInvRecJob implements Job {

    public VendHQSalesToFusionInvRecJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println(jobKey + ": " + new Date());

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        FusionAppParams fusionParams = new FusionAppParams(dataMap.getString("fusionHostname"), dataMap.getString("fusionServer"));
        Credential fusionCredential = new Credential(dataMap.getString("fusionUsername"), dataMap.getString("fusionPassword"));


        try {
            SessionEJB session = EJBClientUtil.getSessionEJB();
            List<VendhqCredentials> vendHqDomainCredentials = session.getVendhqCredentialsFindAll();

            for (VendhqCredentials vendHqDomainCredential : vendHqDomainCredentials) {
                SalesIntegrationStatus integStatus = null;
                try {
                    integStatus = session.getSalesIntegrationStatus(vendHqDomainCredential.getRegion(), AUTOMATIC);
                    if (integStatus.getStatus().equals(RUNNING)) continue;
                    integStatus.setStatus(RUNNING);
                    session.mergeSalesIntegrationStatus(integStatus);
                    
                    Credential vendHqcredential = new Credential(vendHqDomainCredential.getPersonalToken());
                    new VendHQSalesToFusionInvRecIntBackup(fusionParams, vendHqDomainCredential.getDomainName(),
                                                           fusionCredential, vendHqcredential,
                                                           vendHqDomainCredential.getFusionOrgCode())
                        .doIntegration(vendHqDomainCredential.getRegion(), 0,
                                       vendHqDomainCredential.getTimezoneOffset(),
                                       vendHqDomainCredential.getFusionTaxCode(), false,
                                       vendHqDomainCredential.getStartDate());
                    
                    integStatus.setStatus(IDLE);
                    session.mergeSalesIntegrationStatus(integStatus);
                } catch (Exception e) {
                    System.out.println("Exception in VendHQ Sales Integration");
                    System.out.println("====================================================================");
                    System.out.println(e.getMessage());
                    try {
                        if (session != null && integStatus != null) {
                            integStatus.setStatus(IDLE);
                            session.mergeSalesIntegrationStatus(integStatus);
                        }
                    } catch (Exception statusEx) {
                        System.err.println("[VendHQSalesToFusionInvRecJob] Failed to reset integration status to IDLE: " + statusEx);
                        statusEx.printStackTrace();
                    }
                    new ExceptionAlerter(vendHqDomainCredential.getRegion()).sendException(e);
                }
            }
        } catch (NamingException e) {
            System.err.println("[VendHQSalesToFusionInvRecJob] Failed to obtain EJB session, integration job could not run: " + e);
            e.printStackTrace();
            new ExceptionAlerter("UNKNOWN").sendException(e);
        }

    }
}
