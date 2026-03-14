package innovate.tamergroup.vendhq.jobs;

import com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2.ServiceException;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.email.ExceptionAlerter;
import innovate.tamergroup.fusion.ADFBeanUtils;
import innovate.tamergroup.persistence.entities.FusionCredentials;
import innovate.tamergroup.persistence.entities.SalesIntegrationStatus;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.vendhq.integrations.FusionInvToVendHQInvIntegration;
import innovate.tamergroup.vendhq.integrations.FusionItemsToVendHQItemsIntegration;
import innovate.tamergroup.vendhq.integrations.VendHQSalesToFusionInvRecIntParallel;

import static innovate.tamergroup.shared.utils.Constants.AUTOMATIC;
import static innovate.tamergroup.shared.utils.Constants.MANUAL;
import static innovate.tamergroup.shared.utils.Constants.RUNNING;
import static innovate.tamergroup.shared.utils.Constants.IDLE;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import javax.naming.NamingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichProgressIndicator;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.quartz.SchedulerException;

import weblogic.servlet.security.ServletAuthentication;

public class IntegrationSchedulerBean {
    
    private VendHQIntegrationScheduler vendHQIntegrationScheduler;
    private RichProgressIndicator itemStatusIndicator, salesStatusIndicator;
    private RichOutputText itemStatusText, salesStatusText;
    private RichButton changeItemStatusButton, changeSalesStatusButton;
    private RichPanelGroupLayout itemStatusLayout, salesStatusLayout;
    private RichOutputText itemStatusPrevDate, itemStatusNextDate;
    private RichOutputText salesStatusPrevDate, salesStatusNextDate;
    private RichInputNumberSpinbox daysToIntegrate;
    private RichOutputText manualOutletList;
    private RichPanelGroupLayout salesManualLayout;
    private RichButton runSalesJobOnceButton;
    private RichSelectOneChoice inventoryOutletName;
    private final String exceptionMessage = "An error has occurred, please contact the administrator!";

    public IntegrationSchedulerBean() {
        super();
    }
    
    public void refreshItemStatusLayout(ActionEvent actionEvent) throws SchedulerException, NamingException {
        vendHQIntegrationScheduler = this.getVendHQIntegrationScheduler();
        setComponentFaces("Items", vendHQIntegrationScheduler.getItemsSchedulerStatus(), this.getItemStatusIndicator(),
                          this.getItemStatusText(), this.getChangeItemStatusButton(), vendHQIntegrationScheduler.getItemsSchedulerDates(),
                          new RichOutputText[] {itemStatusPrevDate, itemStatusNextDate});       
        this.getItemStatusLayout().setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getItemStatusLayout());
    }

    public void toggleItemsSchedulerStatus(ActionEvent actionEvent) throws SchedulerException, NamingException {
        vendHQIntegrationScheduler = this.getVendHQIntegrationScheduler();
        setComponentFaces("Items", !vendHQIntegrationScheduler.getItemsSchedulerStatus(), this.getItemStatusIndicator(),
                          this.getItemStatusText(), this.getChangeItemStatusButton(), vendHQIntegrationScheduler.getItemsSchedulerDates(),
                          new RichOutputText[] {itemStatusPrevDate, itemStatusNextDate});  
        if (vendHQIntegrationScheduler.getItemsSchedulerStatus()) 
            vendHQIntegrationScheduler.stopItemsScheduleNow();
        else vendHQIntegrationScheduler.startItemsScheduleNow();
    }
    
    public void refreshSalesStatusLayout(ActionEvent actionEvent) throws SchedulerException {
        vendHQIntegrationScheduler = this.getVendHQIntegrationScheduler();
        setComponentFaces("Sales", vendHQIntegrationScheduler.getSalesSchedulerStatus(), this.getSalesStatusIndicator(),
                          this.getSalesStatusText(), this.getChangeSalesStatusButton(), vendHQIntegrationScheduler.getSalesSchedulerDates(),
                          new RichOutputText[] {salesStatusPrevDate, salesStatusNextDate});       
        this.getSalesStatusLayout().setVisible(true);
        this.getChangeSalesStatusButton().setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSalesStatusLayout());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getChangeSalesStatusButton());
    }
    
    public void toggleSalesSchedulerStatus(ActionEvent actionEvent) throws SchedulerException {
        vendHQIntegrationScheduler = this.getVendHQIntegrationScheduler();
        setComponentFaces("Sales", !vendHQIntegrationScheduler.getSalesSchedulerStatus(), this.getSalesStatusIndicator(),
                          this.getSalesStatusText(), this.getChangeSalesStatusButton(), vendHQIntegrationScheduler.getSalesSchedulerDates(),
                          new RichOutputText[] {salesStatusPrevDate, salesStatusNextDate});  
        if (vendHQIntegrationScheduler.getSalesSchedulerStatus()) 
            vendHQIntegrationScheduler.stopSalesScheduleNow();
        else vendHQIntegrationScheduler.startSalesScheduleNow();
    }
    
    public void refreshSalesManualLayout(ActionEvent actionEvent) throws SchedulerException {
        vendHQIntegrationScheduler = this.getVendHQIntegrationScheduler();    
        this.getSalesManualLayout().setVisible(true);
        this.getRunSalesJobOnceButton().setVisible(true);
        String currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.SelectedRegion.inputValue}");
        this.getManualOutletList().setValue(vendHQIntegrationScheduler.getManualOutletList(currentRegion));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getManualOutletList());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSalesManualLayout());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getRunSalesJobOnceButton());
    }
    
    public void runSalesJobOnce(ActionEvent actionEvent) {
        SessionEJB session = null;
        String currentRegion = null;
        SalesIntegrationStatus integStatus = null;
        try {
            session = EJBClientUtil.getSessionEJB();
            currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.SelectedRegion.inputValue}");
            
            integStatus = session.getSalesIntegrationStatus(currentRegion, MANUAL);
            if (integStatus.getStatus().equals(RUNNING)) 
                throw new Exception("An instance of Sales Integration is already running in " + currentRegion);
            integStatus.setStatus(RUNNING);
            session.mergeSalesIntegrationStatus(integStatus);
            
            FusionCredentials fusionParaCredential = session.getFusionCredential();
            VendhqCredentials vendHqDomainCredential = session.getVendHqCredentialByRegion(currentRegion);
            new VendHQSalesToFusionInvRecIntParallel(new FusionAppParams(fusionParaCredential.getHostName(), fusionParaCredential.getServer()), 
                                                     vendHqDomainCredential.getDomainName(), 
                                                 new Credential(fusionParaCredential.getUsername(), fusionParaCredential.getPassword()), 
                                               new Credential(vendHqDomainCredential.getPersonalToken()), vendHqDomainCredential.getFusionOrgCode())
            .doIntegration(currentRegion, Integer.valueOf(daysToIntegrate.getValue().toString()), vendHqDomainCredential.getTimezoneOffset(), 
                           vendHqDomainCredential.getFusionTaxCode(), true, vendHqDomainCredential.getStartDate());
            refreshAllTables();
            integStatus.setStatus(IDLE);
            session.mergeSalesIntegrationStatus(integStatus);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, exceptionMessage, null );
            FacesContext.getCurrentInstance().addMessage(null, message); 
            try {
                if (session != null && integStatus != null) {
                    integStatus.setStatus(IDLE);
                    session.mergeSalesIntegrationStatus(integStatus);
                }
            } catch (Exception statusEx) {
                System.err.println("[IntegrationSchedulerBean] Failed to reset integration status to IDLE: " + statusEx);
                statusEx.printStackTrace();
            }
            new ExceptionAlerter(currentRegion != null ? currentRegion : "UNKNOWN").sendException(e);
        }
    }
    
    public void runSalesAutomatedOnce(ActionEvent actionEvent) {
        SessionEJB session = null;
        String currentRegion = null;
        SalesIntegrationStatus integStatus = null;
        try {
            session = EJBClientUtil.getSessionEJB();
            currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.SelectedRegion.inputValue}");
            
            integStatus = session.getSalesIntegrationStatus(currentRegion, AUTOMATIC);
            if (integStatus.getStatus().equals(RUNNING)) 
                throw new Exception("An instance of Sales Integration is already running in " + currentRegion);
            integStatus.setStatus(RUNNING);
            session.mergeSalesIntegrationStatus(integStatus);
            
            FusionCredentials fusionParaCredential = session.getFusionCredential();
            VendhqCredentials vendHqDomainCredential = session.getVendHqCredentialByRegion(currentRegion);
            new VendHQSalesToFusionInvRecIntParallel(new FusionAppParams(fusionParaCredential.getHostName(), fusionParaCredential.getServer()), 
                                                     vendHqDomainCredential.getDomainName(), 
                                                 new Credential(fusionParaCredential.getUsername(), fusionParaCredential.getPassword()), 
                                               new Credential(vendHqDomainCredential.getPersonalToken()), vendHqDomainCredential.getFusionOrgCode())
            .doIntegration(currentRegion, 0, vendHqDomainCredential.getTimezoneOffset(), vendHqDomainCredential.getFusionTaxCode(), false, vendHqDomainCredential.getStartDate());
            refreshAllTables();
            integStatus.setStatus(IDLE);
            session.mergeSalesIntegrationStatus(integStatus);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, exceptionMessage, null );
            FacesContext.getCurrentInstance().addMessage(null, message); 
            try {
                if (session != null && integStatus != null) {
                    integStatus.setStatus(IDLE);
                    session.mergeSalesIntegrationStatus(integStatus);
                }
            } catch (Exception statusEx) {
                System.err.println("[IntegrationSchedulerBean] Failed to reset integration status to IDLE: " + statusEx);
                statusEx.printStackTrace();
            }
            new ExceptionAlerter(currentRegion != null ? currentRegion : "UNKNOWN").sendException(e);
        }
    }
    
    public void runItemsSyncAutomatedOnce(ActionEvent actionEvent) {
        String currentRegion = null;
        try {
            SessionEJB session = EJBClientUtil.getSessionEJB();
            currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.SelectedRegion.inputValue}");
            FusionCredentials fusionParaCredential = session.getFusionCredential();
            VendhqCredentials vendHqDomainCredential = session.getVendHqCredentialByRegion(currentRegion);
            new FusionItemsToVendHQItemsIntegration(new FusionAppParams(fusionParaCredential.getHostName(), fusionParaCredential.getServer()), vendHqDomainCredential.getDomainName(), 
                                                    new Credential(fusionParaCredential.getUsername(), fusionParaCredential.getPassword()), new Credential(vendHqDomainCredential.getPersonalToken()))
                .doIntegration(currentRegion, vendHqDomainCredential.getFusionOrgCode(), vendHqDomainCredential.getFusionTaxCode());
            refreshAllTables();
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, exceptionMessage, null );
            FacesContext.getCurrentInstance().addMessage(null, message); 
            new ExceptionAlerter(currentRegion).sendException(e);
        }
    }
    
    public void runInventorySync(ActionEvent actionEvent) throws IOException, NamingException, ServiceException {
        String currentRegion = null;
        try {
            currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.SelectedRegion.inputValue}");
            new FusionInvToVendHQInvIntegration().doIntegration(this.getInventoryOutletName().getValue().toString(), currentRegion);
        } catch(Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, exceptionMessage, null );
            FacesContext.getCurrentInstance().addMessage(null, message); 
            new ExceptionAlerter(currentRegion).sendException(e);
        }
        
    }
    
    private void setComponentFaces(String module, Boolean action, RichProgressIndicator progressIndicator, 
                                   RichOutputText statuText, RichButton statusButton, Date[] prevNextDates, RichOutputText[] runDatesText) {
        progressIndicator.setVisible(action);
        statuText.setValue(module + " Scheduler is " + (action ? "running!" : "stopped!"));
        statusButton.setText(action ? "Stop " : "Start ");
        statusButton.setIcon(action ? "/images/baseline_stop_black_18dp.png" : "/images/baseline_play_arrow_black_18dp.png");
        statusButton.setVisible(true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        runDatesText[0].setValue("Previous Run: " + (prevNextDates[0] != null ? dateFormat.format(prevNextDates[0]) : ""));
        runDatesText[1].setValue("Next Run: " + (prevNextDates[1] != null ? dateFormat.format(prevNextDates[1]) : ""));
        AdfFacesContext.getCurrentInstance().addPartialTarget(progressIndicator);
        AdfFacesContext.getCurrentInstance().addPartialTarget(statuText);
        AdfFacesContext.getCurrentInstance().addPartialTarget(statusButton);
        AdfFacesContext.getCurrentInstance().addPartialTarget(runDatesText[0]);
        AdfFacesContext.getCurrentInstance().addPartialTarget(runDatesText[1]);
    }
    
    public void logoutAction(ActionEvent actionEvent) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        
       
        String url = "/Fusion-VendHQ-Opencart-Integration-ViewController-context-root/login.html";
        HttpSession session = (HttpSession)ectx.getSession(false);
        session.getId();
        session.invalidate();

        HttpServletRequest request = (HttpServletRequest)ectx.getRequest();
        ServletAuthentication.logout(request);
        ServletAuthentication.invalidateAll(request);
        ServletAuthentication.killCookie(request);

        try {
            ectx.redirect(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fctx.responseComplete();
    }

    public void changeSelectedRegion(ActionEvent actionEvent) {
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams1").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams2").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams3").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams4").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams5").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams6").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams7").execute();
        
        refreshAllTables();
    }
    
    private void refreshAllTables() {
        ADFBeanUtils.refreshThisComponent("t4");
        ADFBeanUtils.refreshThisComponent("t5");
        ADFBeanUtils.refreshThisComponent("t6");
        ADFBeanUtils.refreshThisComponent("t7");
        ADFBeanUtils.refreshThisComponent("t8");
        ADFBeanUtils.refreshThisComponent("t9");
        ADFBeanUtils.refreshThisComponent("t1");
        ADFBeanUtils.refreshThisComponent("soc2");
    }


    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            if (!AdfFacesContext.getCurrentInstance().isPostback()) {
                changeSelectedRegion(null);
            }
        }
    }


    public void setVendHQIntegrationScheduler(VendHQIntegrationScheduler vendHQIntegrationScheduler) {
        this.vendHQIntegrationScheduler = vendHQIntegrationScheduler;
    }

    public VendHQIntegrationScheduler getVendHQIntegrationScheduler() {
        return vendHQIntegrationScheduler;
    }

    public void setItemStatusIndicator(RichProgressIndicator statusIndicator) {
        this.itemStatusIndicator = statusIndicator;
    }

    public RichProgressIndicator getItemStatusIndicator() {
        return itemStatusIndicator;
    }

    public void setItemStatusText(RichOutputText statusText) {
        this.itemStatusText = statusText;
    }

    public RichOutputText getItemStatusText() {
        return itemStatusText;
    }

    public void setChangeItemStatusButton(RichButton changeItemStatusButton) {
        this.changeItemStatusButton = changeItemStatusButton;
    }

    public RichButton getChangeItemStatusButton() {
        return changeItemStatusButton;
    }

    public void setItemStatusLayout(RichPanelGroupLayout itemStatusLayout) {
        this.itemStatusLayout = itemStatusLayout;
    }

    public RichPanelGroupLayout getItemStatusLayout() {
        return itemStatusLayout;
    }

    public void refreshOpencartSalesStatusLayout(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void refreshOpencartMoveOrderStatusLayout(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setSalesStatusLayout(RichPanelGroupLayout salesStatusLayout) {
        this.salesStatusLayout = salesStatusLayout;
    }

    public RichPanelGroupLayout getSalesStatusLayout() {
        return salesStatusLayout;
    }

    public void setSalesStatusIndicator(RichProgressIndicator salesStatusIndicator) {
        this.salesStatusIndicator = salesStatusIndicator;
    }

    public RichProgressIndicator getSalesStatusIndicator() {
        return salesStatusIndicator;
    }

    public void setSalesStatusText(RichOutputText salesStatusText) {
        this.salesStatusText = salesStatusText;
    }

    public RichOutputText getSalesStatusText() {
        return salesStatusText;
    }

    public void setChangeSalesStatusButton(RichButton changeSalesStatusButton) {
        this.changeSalesStatusButton = changeSalesStatusButton;
    }

    public RichButton getChangeSalesStatusButton() {
        return changeSalesStatusButton;
    }


    public void setItemStatusPrevDate(RichOutputText itemStatusPrevDate) {
        this.itemStatusPrevDate = itemStatusPrevDate;
    }

    public RichOutputText getItemStatusPrevDate() {
        return itemStatusPrevDate;
    }

    public void setItemStatusNextDate(RichOutputText itemStatusNextDate) {
        this.itemStatusNextDate = itemStatusNextDate;
    }

    public RichOutputText getItemStatusNextDate() {
        return itemStatusNextDate;
    }

    public void setSalesStatusPrevDate(RichOutputText salesStatusPrevDate) {
        this.salesStatusPrevDate = salesStatusPrevDate;
    }

    public RichOutputText getSalesStatusPrevDate() {
        return salesStatusPrevDate;
    }

    public void setSalesStatusNextDate(RichOutputText salesStatusNextDate) {
        this.salesStatusNextDate = salesStatusNextDate;
    }

    public RichOutputText getSalesStatusNextDate() {
        return salesStatusNextDate;
    }

    public void setDaysToIntegrate(RichInputNumberSpinbox daysToIntegrate) {
        this.daysToIntegrate = daysToIntegrate;
    }

    public RichInputNumberSpinbox getDaysToIntegrate() {
        return daysToIntegrate;
    }

    public void setManualOutletList(RichOutputText manualOutletList) {
        this.manualOutletList = manualOutletList;
    }

    public RichOutputText getManualOutletList() {
        return manualOutletList;
    }

    public void setSalesManualLayout(RichPanelGroupLayout salesManualLayout) {
        this.salesManualLayout = salesManualLayout;
    }

    public RichPanelGroupLayout getSalesManualLayout() {
        return salesManualLayout;
    }

    public void setRunSalesJobOnceButton(RichButton runSalesJobOnceButton) {
        this.runSalesJobOnceButton = runSalesJobOnceButton;
    }

    public RichButton getRunSalesJobOnceButton() {
        return runSalesJobOnceButton;
    }

    

    public void setInventoryOutletName(RichSelectOneChoice inventoryOutletName) {
        this.inventoryOutletName = inventoryOutletName;
    }

    public RichSelectOneChoice getInventoryOutletName() {
        return inventoryOutletName;
    }

    
}
