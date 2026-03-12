package innovate.tamergroup.shared.utils;

import javax.xml.ws.BindingProvider;

public class SOAPUtils {
    
    public SOAPUtils() {
        super();
    }
    
    public static void setCredentials(BindingProvider bindingProvider, Credential credential) {
        bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, credential.getUsername());
        bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, credential.getPassword());
    }
}
