package innovate.tamergroup.ejb.utils;

import innovate.tamergroup.persistence.session.SessionEJB;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBClientUtil {
    
    private static SessionEJB sessionEJB;
    
    public EJBClientUtil() {
        super();
    }

    public static SessionEJB getSessionEJB() throws NamingException {
        try {
        final Context context = getInitialContext();
        sessionEJB =
            (SessionEJB) context.lookup("Fusion VendHQ Opencart Integration-JPAProject-SessionEJB" +
            "#innovate.tamergroup.persistence.session.SessionEJB");
        } catch (NamingException e) {   
            e.printStackTrace();
        }
        return sessionEJB;
    }
    
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, /*"t3://127.0.0.1:7101"*/"t3://fmwprodoci-wls-0.wlssubnet.prodvcn.oraclevcn.com:9073");
        return new InitialContext(env);
    }
    
}
