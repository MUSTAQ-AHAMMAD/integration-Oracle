package innovate.tamergroup.ejb.client;

import innovate.tamergroup.persistence.entities.VendhqOutletsDB;
import innovate.tamergroup.persistence.session.SessionEJB;

import java.util.Hashtable;
import java.util.List;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SessionEJBClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            SessionEJB sessionEJB =
                (SessionEJB) context.lookup("Fusion VendHQ Opencart Integration-JPAProject-SessionEJB#innovate.tamergroup.persistence.session.SessionEJB");
            for (VendhqOutletsDB vendhqoutletsdb : (List<VendhqOutletsDB>) sessionEJB.getVendhqOutletsDBFindAll()) {
                printVendhqOutletsDB(vendhqoutletsdb);
            }
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printVendhqOutletsDB(VendhqOutletsDB vendhqoutletsdb) {
        System.out.println("deletedAt = " + vendhqoutletsdb.getDeletedAt());
        System.out.println("outletId = " + vendhqoutletsdb.getOutletId());
        System.out.println("outletName = " + vendhqoutletsdb.getOutletName());
        System.out.println("version = " + vendhqoutletsdb.getVersion());
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }
}
