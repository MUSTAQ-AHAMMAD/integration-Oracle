package innovate.tamergroup.shared.utils;

/**
 * Holds the connection parameters required to reach an Oracle Fusion Cloud
 * REST or SOAP endpoint.
 *
 * <p>These parameters are typically loaded once from the database
 * ({@code FusionCredentials} JPA entity) at scheduler startup and then
 * passed through the integration layers so that each API client can build
 * the correct base URL.</p>
 *
 * <p><b>URL construction pattern:</b></p>
 * <pre>
 *   https://&lt;hostname&gt;-&lt;region&gt;.oraclecloud.com/&lt;appDomain&gt;/restApi/...
 * </pre>
 *
 * <p><b>Step-by-step usage:</b></p>
 * <ol>
 *   <li>Read the {@code hostname} and {@code region} values from the
 *       {@code FusionCredentials} record in the database via the EJB session
 *       bean:
 *       <pre>{@code
 *       FusionCredentials creds = session.getFusionCredential();
 *       FusionAppParams params = new FusionAppParams(
 *           creds.getHostName(), creds.getServer());
 *       }</pre></li>
 *   <li>Pass the {@code FusionAppParams} object to the REST or SOAP client
 *       that needs to build the target URL.</li>
 *   <li>The client concatenates hostname and region to form the full Oracle
 *       Cloud instance URL, e.g.
 *       {@code "https://" + params.getHostname() + params.getRegion() + ".oraclecloud.com"}.</li>
 * </ol>
 */
public class FusionAppParams {

    /**
     * The Oracle Fusion instance hostname prefix (e.g. {@code "ehxk-test"}).
     * Combined with {@link #region} it forms the full instance subdomain.
     */
    private String hostname;

    /**
     * The Oracle Fusion data-center region / server code (e.g. {@code "fa"}).
     * Appended to {@link #hostname} to produce the complete subdomain portion
     * of the Oracle Cloud URL.
     */
    private String region;

    /**
     * Creates a new {@code FusionAppParams} with the supplied hostname and region.
     *
     * @param hostname the instance hostname prefix as stored in the
     *                 {@code FusionCredentials} database record
     * @param region   the Oracle Cloud region / server code as stored in the
     *                 {@code FusionCredentials} database record
     */
    public FusionAppParams(String hostname, String region) {
        this.hostname = hostname;
        this.region = region;
    }

    /**
     * Sets the Oracle Fusion instance hostname prefix.
     *
     * @param hostname the new hostname value
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Returns the Oracle Fusion instance hostname prefix.
     *
     * @return the hostname prefix (e.g. {@code "ehxk-test"})
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets the Oracle Cloud data-center region / server code.
     *
     * @param region the new region value
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Returns the Oracle Cloud data-center region / server code.
     *
     * @return the region code (e.g. {@code "fa"})
     */
    public String getRegion() {
        return region;
    }
}
