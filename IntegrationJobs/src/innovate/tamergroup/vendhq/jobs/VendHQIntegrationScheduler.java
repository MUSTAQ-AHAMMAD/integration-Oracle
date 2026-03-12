package innovate.tamergroup.vendhq.jobs;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.FusionCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.naming.NamingException;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.logging.Logger;

import org.quartz.SimpleScheduleBuilder;


public class VendHQIntegrationScheduler {
    
    private SessionEJB session;
    private Scheduler scheduler;
    private JobDetail itemsJob, salesJob, salesBackupJob, onHandFetchJob;
    private Trigger itemsTrigger, salesTrigger, salesBackupTrigger, onHandFetchTrigger;
    private Boolean itemsSchedulerStatus, salesSchedulerStatus;
    final static Logger logger = Logger.getLogger(VendHQIntegrationScheduler.class.getSimpleName());

    public VendHQIntegrationScheduler() {
        logger.setLevel(Level.INFO);
        try {
            prepareSchedule();
        } catch(Exception e) {
            logger.severe(e.getMessage());
        }
    }
    
    private void prepareSchedule() throws NamingException, SchedulerException {
        session = EJBClientUtil.getSessionEJB();
        FusionCredentials fusionParaCredential = session.getFusionCredential();
        
        itemsJob = JobBuilder.newJob(FusionItemsToVendHQItemsJob.class)
                                .withIdentity("FusionItemsToVendHQItemsJob", "Items Integration")
                                .usingJobData("fusionUsername", fusionParaCredential.getUsername())
                                .usingJobData("fusionPassword", fusionParaCredential.getPassword())
                                .usingJobData("fusionHostname", fusionParaCredential.getHostName())
                                .usingJobData("fusionServer", fusionParaCredential.getServer())
                                .build();
        itemsTrigger = TriggerBuilder.newTrigger()
                                .withIdentity("VendHQItemsIntegrationTrigger", "Items Integration")
                                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0/6 1/1 * ? *"))
                                .build();
        
        salesJob = JobBuilder.newJob(VendHQSalesToFusionInvRecJob.class)
                                .withIdentity("VendHQSalesIntegrationJob", "Sales Integration")
                                /*.usingJobData("fusionUsername", "Ahmed.ali")
                                .usingJobData("fusionPassword", "Tamer@123")
                                .usingJobData("fusionHostname", "ehxk-test")*/
                                .usingJobData("fusionUsername", fusionParaCredential.getUsername())
                                .usingJobData("fusionPassword", fusionParaCredential.getPassword())
                                .usingJobData("fusionHostname", fusionParaCredential.getHostName())
                                .usingJobData("fusionServer", fusionParaCredential.getServer())
                                .build();
        salesTrigger = TriggerBuilder.newTrigger()
                .withIdentity("VendHQSalesIntegrationTrigger", "Sales Integration")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 3 1/1 * ? *"))
                .build();
        
        salesBackupJob = JobBuilder.newJob(VendHQSalesBackupJob.class)
                                .withIdentity("VendHQSalesBackupJob", "Sales Backup")
                                .build();
        salesBackupTrigger = TriggerBuilder.newTrigger()
                .withIdentity("VendHQSalesBackupTrigger", "Sales Backup")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(10)
                .repeatForever())
                .build();
        
        /*onHandFetchJob = JobBuilder.newJob(FusionOnHandQtyJob.class)
                                .withIdentity("FusionOnHandQtyJob", "Items OnHand Sync")
                                .usingJobData("fusionUsername", fusionParaCredential.getUsername())
                                .usingJobData("fusionPassword", fusionParaCredential.getPassword())
                                .usingJobData("fusionHostname", fusionParaCredential.getHostName())
                                .usingJobData("fusionServer", fusionParaCredential.getServer())
                                .build();
        onHandFetchTrigger = TriggerBuilder.newTrigger()
                .withIdentity("FusionOnHandQtyTrigger", "Items OnHand Sync")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(4)
                .repeatForever())
                .build();*/
        
        scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(salesBackupJob, salesBackupTrigger);
        //scheduler.scheduleJob(onHandFetchJob, onHandFetchTrigger);
        logger.info("Scheduler is prepared & ready!");
    }
    
    public void startItemsScheduleNow() throws SchedulerException {
        scheduler.scheduleJob(itemsJob, itemsTrigger);
        itemsSchedulerStatus = true;
        logger.info("Items Scheduler STARTED :)");
    }
    
    public void stopItemsScheduleNow() throws SchedulerException {
        scheduler.unscheduleJob(itemsTrigger.getKey());
        itemsSchedulerStatus = false;
        logger.info("Items Scheduler STOPPED!! :(");
    }
    
    public Boolean getItemsSchedulerStatus() throws SchedulerException {
        if (itemsSchedulerStatus == null) return false;
        return itemsSchedulerStatus;
    }
    
    public Date[] getItemsSchedulerDates() throws SchedulerException {
        return new Date[] {itemsTrigger.getPreviousFireTime(), itemsTrigger.getNextFireTime()};
    }
    
    public void startSalesScheduleNow() throws SchedulerException {
        scheduler.scheduleJob(salesJob, salesTrigger);
        salesSchedulerStatus = true;
        logger.info("Sales Scheduler STARTED :)");
    }
    
    public void stopSalesScheduleNow() throws SchedulerException {
        scheduler.unscheduleJob(salesTrigger.getKey());
        salesSchedulerStatus = false;
        logger.info("Sales Scheduler STOPPED!! :(");
    }
    
    public Boolean getSalesSchedulerStatus() throws SchedulerException {
        if (salesSchedulerStatus == null) return false;
        return salesSchedulerStatus;
    }
    
    public void triggerSalesJobNow() throws SchedulerException {
        Boolean scheduleStatus = getSalesSchedulerStatus();
        if (!scheduleStatus) startSalesScheduleNow();
        scheduler.triggerJob(salesJob.getKey());
        if (!scheduleStatus) stopSalesScheduleNow();
    }
    
    public Date[] getSalesSchedulerDates() throws SchedulerException {
        return new Date[] {salesTrigger.getPreviousFireTime(), salesTrigger.getNextFireTime()};
    }
    
    public String getManualOutletList(String region) {
        List<String> manualOutlets = session.getOutletsByStatus("MANUAL", region);
        StringBuilder builder = new StringBuilder();
        for (String outlet : manualOutlets)
            builder.append(", ").append(outlet);
        return builder.toString().isEmpty() ? "No outlets to be integrated" : builder.toString().substring(2);
    }
    
    /*public static void main(String[] args) throws SchedulerException, NamingException {
        prepareSchedule();
        startScheduleNow();
    }*/
}
