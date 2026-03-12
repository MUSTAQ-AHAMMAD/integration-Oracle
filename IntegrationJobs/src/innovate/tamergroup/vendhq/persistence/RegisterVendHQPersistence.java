package innovate.tamergroup.vendhq.persistence;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.VendhqCredentials;
import innovate.tamergroup.persistence.session.SessionEJB;
import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.entities.VendhqRegisters;
import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.vendhq.services.VendHQOutletsService;
import innovate.tamergroup.vendhq.model.outlets.Outlet;

import innovate.tamergroup.vendhq.model.resgisters.Register;
import innovate.tamergroup.vendhq.services.VendHQRegisterService;

import java.io.IOException;

import java.util.List;

import java.math.BigDecimal;

import javax.naming.NamingException;


public class RegisterVendHQPersistence {
    
    public RegisterVendHQPersistence() {
        super();
    }
    
    public static void syncRegisters(SessionEJB session, String region) throws IOException, NamingException {
        if (session == null) session = EJBClientUtil.getSessionEJB();
        VendhqCredentials paraCredential = session.getVendHqCredentialByRegion(region);
        VendHQRegisterService registersService = new VendHQRegisterService(paraCredential.getDomainName(), new Credential(paraCredential.getPersonalToken()));
        List<Register> registers = registersService.getVendHQRegisters(session.getRegisterMaxVersion());
        for (Register register : registers) {
            VendhqRegisters registerDetail = session.getRegisterDetails(register.getId());
            session.mergeVendhqRegisters(transformRegister(register, registerDetail, region)); 
        }
    }
    
    private static VendhqRegisters transformRegister(Register register, VendhqRegisters registerDetail, String region) {
        VendhqRegisters registerDb = new VendhqRegisters();
        registerDb.setRegisterName(register.getName());
        registerDb.setOutletId(register.getOutletId()); 
        registerDb.setRegisterId(register.getId());
        registerDb.setVersion(BigDecimal.valueOf(register.getVersion()));
        registerDb.setDeletedAt(register.getDeletedAt());
        registerDb.setRegion(region);
        if (registerDetail != null) {
            registerDb.setBankAccount(registerDetail.getBankAccount());
            registerDb.setBankAccountId(registerDetail.getBankAccountId());
            registerDb.setCashAccount(registerDetail.getCashAccount());
            registerDb.setCashAccountId(registerDetail.getCashAccountId());
        }
        return registerDb;
    }
    
    public static void main(String[] args) {
        try {
            SessionEJB session = EJBClientUtil.getSessionEJB();
            syncRegisters(session, "SA");
        } catch (IOException | NamingException e) {
            e.printStackTrace();
        }
    }
}
