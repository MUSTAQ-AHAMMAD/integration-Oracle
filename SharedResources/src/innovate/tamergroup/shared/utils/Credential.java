package innovate.tamergroup.shared.utils;

import java.util.Base64;

/**
 * Represents an authentication credential used when calling external APIs
 * (Oracle Fusion REST / SOAP, VendHQ REST, Opencart REST).
 *
 * <p>Two credential styles are supported:</p>
 * <ul>
 *   <li><b>Basic Authentication</b> – supply a username and password via
 *       {@link #Credential(String, String)}.  The {@link #toString()} method
 *       will return a Base64-encoded {@code "username:password"} string
 *       suitable for use in an {@code Authorization: Basic <token>} HTTP
 *       header.</li>
 *   <li><b>Token / Bearer Authentication</b> – supply a pre-existing token
 *       via {@link #Credential(String)}.  {@link #toString()} returns the
 *       token as-is.</li>
 * </ul>
 *
 * <p><b>Step-by-step usage (Basic Auth):</b></p>
 * <ol>
 *   <li>Load the username and password from the database
 *       (e.g. from a {@code FusionCredentials} JPA entity).</li>
 *   <li>Create a {@code Credential} object:
 *       {@code Credential cred = new Credential(username, password);}</li>
 *   <li>Pass it to {@link SOAPUtils#setCredentials(javax.xml.ws.BindingProvider, Credential)}
 *       for SOAP calls, or append {@code "Basic " + cred.toString()} to the
 *       {@code Authorization} header for REST calls.</li>
 * </ol>
 *
 * <p><b>Step-by-step usage (Token Auth):</b></p>
 * <ol>
 *   <li>Obtain the token string (e.g. from a VendHQ API key stored in
 *       the database).</li>
 *   <li>Create a {@code Credential} object:
 *       {@code Credential cred = new Credential(token);}</li>
 *   <li>Append {@code "Bearer " + cred.toString()} to the
 *       {@code Authorization} header of every REST request.</li>
 * </ol>
 */
public class Credential {

    /** The username for Basic Authentication. {@code null} when token auth is used. */
    private String username;

    /** The password for Basic Authentication. {@code null} when token auth is used. */
    private String password;

    /** The pre-existing token for Bearer / token-based authentication.
     *  {@code null} when Basic Auth is used. */
    private String token;

    /**
     * Creates a credential for HTTP Basic Authentication.
     *
     * @param username the API username (e.g. the Oracle Fusion login name)
     * @param password the API password in plain text; it will be Base64-encoded
     *                 only when {@link #toString()} is called
     */
    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a credential for token-based (Bearer) authentication.
     *
     * @param token the pre-generated API token (e.g. a VendHQ personal API key)
     */
    public Credential(String token) {
        this.token = token;
    }

    /**
     * Returns the credential in a format ready to be appended to an
     * {@code Authorization} HTTP header value.
     *
     * <ul>
     *   <li>If a token was provided, the raw token string is returned.</li>
     *   <li>Otherwise, the username and password are combined as
     *       {@code "username:password"} and Base64-encoded (RFC 4648).</li>
     * </ul>
     *
     * @return the Base64-encoded {@code "username:password"} string for Basic
     *         Auth, or the raw token string for token-based Auth
     */
    @Override
    public String toString() {
        return token == null ? Base64.getEncoder().encodeToString((username + ":" + password).getBytes()) : token;
    }

    /**
     * Sets the username used for Basic Authentication.
     *
     * @param username the new username value
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the username used for Basic Authentication.
     *
     * @return the username, or {@code null} if token-based auth is used
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the password used for Basic Authentication.
     *
     * @param password the new password value in plain text
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the password used for Basic Authentication.
     *
     * @return the plain-text password, or {@code null} if token-based auth is used
     */
    public String getPassword() {
        return password;
    }
}
