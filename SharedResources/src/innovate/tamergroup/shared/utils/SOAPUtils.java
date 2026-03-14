package innovate.tamergroup.shared.utils;

import javax.xml.ws.BindingProvider;

/**
 * Utility class that provides helper methods for configuring Oracle Fusion
 * SOAP (JAX-WS) web service clients.
 *
 * <p>All JAX-WS proxy stubs generated from Oracle Fusion WSDL files implement
 * {@link BindingProvider}.  Before making any SOAP call the proxy must be
 * configured with the correct credentials; this class centralises that
 * configuration step.</p>
 *
 * <p><b>Step-by-step usage:</b></p>
 * <ol>
 *   <li>Generate or obtain the JAX-WS proxy stub for the target Oracle Fusion
 *       web service (e.g. {@code InvoiceService}, {@code ReceiptService}).
 *       The stub class implements both the service-specific port interface
 *       and {@link BindingProvider}.</li>
 *   <li>Load the Oracle Fusion credentials from the database into a
 *       {@link Credential} object:
 *       <pre>{@code
 *       Credential cred = new Credential(
 *           fusionCreds.getUsername(),
 *           fusionCreds.getPassword());
 *       }</pre></li>
 *   <li>Cast the stub to {@link BindingProvider} and call
 *       {@link #setCredentials(BindingProvider, Credential)}:
 *       <pre>{@code
 *       SOAPUtils.setCredentials((BindingProvider) servicePort, cred);
 *       }</pre></li>
 *   <li>The stub's request context now contains the
 *       {@link BindingProvider#USERNAME_PROPERTY} and
 *       {@link BindingProvider#PASSWORD_PROPERTY} entries.  JAX-WS will
 *       include these as HTTP Basic Authentication headers when the next
 *       SOAP operation is invoked.</li>
 *   <li>Invoke the desired SOAP operation on the port, e.g.
 *       {@code servicePort.createInvoice(...)}.</li>
 * </ol>
 */
public class SOAPUtils {

    /**
     * Constructs a new SOAPUtils instance.
     * All members are {@code static}; direct instantiation is not required.
     */
    public SOAPUtils() {
        super();
    }

    /**
     * Injects Basic Authentication credentials into a JAX-WS
     * {@link BindingProvider}'s request context.
     *
     * <p>Setting {@link BindingProvider#USERNAME_PROPERTY} and
     * {@link BindingProvider#PASSWORD_PROPERTY} causes the JAX-WS runtime to
     * add an HTTP {@code Authorization: Basic <base64>} header to every
     * outgoing SOAP request made through this port instance.</p>
     *
     * @param bindingProvider the JAX-WS stub (port) to configure; typically
     *                        cast from the generated service port interface
     *                        (e.g. {@code (BindingProvider) invoiceServicePort})
     * @param credential      the {@link Credential} containing the username
     *                        and password to use; the raw (non-encoded) values
     *                        are stored here because JAX-WS performs its own
     *                        encoding
     */
    public static void setCredentials(BindingProvider bindingProvider, Credential credential) {
        bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, credential.getUsername());
        bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, credential.getPassword());
    }
}
