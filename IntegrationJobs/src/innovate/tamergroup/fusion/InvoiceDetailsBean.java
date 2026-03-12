package innovate.tamergroup.fusion;

import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.context.AdfFacesContext;

public class InvoiceDetailsBean {
    
    private Integer invoiceNumber;
    private String selectedRegion;

    public InvoiceDetailsBean() {
        super();
        Map<String,String> queryMap = ADFBeanUtils.getFacesContext().getExternalContext().getRequestParameterMap();
        String[] params = queryMap.get("txnNumber").split("---");
        invoiceNumber = Integer.valueOf(params[0]);
        selectedRegion = params[1];
    }
    
    public void setInvoiceDetails(ActionEvent actionEvent) {
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams1").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams2").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams3").execute();
        ADFBeanUtils.getBindings().getOperationBinding("ExecuteWithParams4").execute();
        ADFBeanUtils.refreshThisComponent("pfl1");
    }
    
    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            if (!AdfFacesContext.getCurrentInstance().isPostback()) {
                setInvoiceDetails(null);
            }
        }
    }


    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setSelectedRegion(String selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    public String getSelectedRegion() {
        return selectedRegion;
    }
}
