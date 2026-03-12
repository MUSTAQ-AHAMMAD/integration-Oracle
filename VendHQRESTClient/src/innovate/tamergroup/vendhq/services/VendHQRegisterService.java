package innovate.tamergroup.vendhq.services;

import innovate.tamergroup.shared.utils.Credential;

import java.io.IOException;

import java.util.List;

import innovate.tamergroup.vendhq.model.outlets.Outlet;

import innovate.tamergroup.vendhq.model.resgisters.Register;
import innovate.tamergroup.vendhq.utils.FetchListVendHQ;

public class VendHQRegisterService {
    
    private String domain;
    private Credential credential;


    public VendHQRegisterService(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
    }

    public List<Register> getVendHQRegisters (Long after) throws IOException {
        
        FetchListVendHQ fetchVendHQList = new FetchListVendHQ(domain, credential);
        List<Register> registers = fetchVendHQList.execute(Register.class, 2, "registers", null, after);
        
        return registers;
    }
    
    public static void main(String[] args) throws IOException {
        VendHQRegisterService outletsService = new VendHQRegisterService("ibraheemalqurashitest", new Credential("KiQSsELLtocyS8C60fqaf_nA9xljyU0KoUWvwrHu"));
        
        for (Register register : outletsService.getVendHQRegisters(0L)) {
            System.out.println(register.getName());
        }
    }
}
