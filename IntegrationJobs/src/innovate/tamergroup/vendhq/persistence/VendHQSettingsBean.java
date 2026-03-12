package innovate.tamergroup.vendhq.persistence;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.fusion.ADFBeanUtils;

import innovate.tamergroup.persistence.session.SessionEJB;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.io.IOException;

import javax.faces.event.ActionEvent;

import javax.naming.NamingException;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;

public class VendHQSettingsBean {

    public VendHQSettingsBean() {
        super();
    }

    public void syncVendOutlets(ActionEvent actionEvent) throws IOException, NamingException {
        String currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.Selected_Region.inputValue}");
        SessionEJB session = EJBClientUtil.getSessionEJB();
        OutletVendHQPersistence.syncOutlets(session, currentRegion);
        ADFBeanUtils.refreshThisComponent("t8");
    }

    public void syncVendRegisters(ActionEvent actionEvent) throws IOException, NamingException {
        String currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.Selected_Region1.inputValue}");
        SessionEJB session = EJBClientUtil.getSessionEJB();
        RegisterVendHQPersistence.syncRegisters(session, currentRegion);
        ADFBeanUtils.refreshThisComponent("t3");
    }
    
    public void syncOutletsConfig(ActionEvent actionEvent) throws IOException, NamingException {
        String currentRegion = ADFBeanUtils.resolveExpressionAsString("#{bindings.Selected_Region2.inputValue}");
        SessionEJB session = EJBClientUtil.getSessionEJB();
        OutletVendHQPersistence.syncOutletsConfig(session, currentRegion);
        ADFBeanUtils.refreshThisComponent("t7");
    }

}
