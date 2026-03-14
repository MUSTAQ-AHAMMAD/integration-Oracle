package innovate.tamergroup.shared.utils;

/**
 * Enumerates the Oracle Fusion application domains used when constructing
 * REST API base URLs.
 *
 * <p>Oracle Fusion Cloud ERP exposes its REST APIs under different URL path
 * prefixes depending on the functional area (domain) being accessed.  This
 * enum maps each domain to the short string segment that appears in the URL
 * path, keeping URL construction centralised and avoiding hard-coded strings
 * in multiple places.</p>
 *
 * <p><b>Known domains:</b></p>
 * <ul>
 *   <li>{@link #SCM} – Supply Chain Management ({@code /scm/...})</li>
 *   <li>{@link #FIN} – Financials / Accounts Receivable ({@code /fin/...})</li>
 * </ul>
 *
 * <p><b>Step-by-step usage:</b></p>
 * <ol>
 *   <li>Decide which Oracle Fusion functional area your REST call targets
 *       (e.g. Inventory Transactions → {@code SCM}, Invoices → {@code FIN}).</li>
 *   <li>Retrieve the path segment via {@link #getAppDomain()}, e.g.
 *       {@code FusionAppDomain.SCM.getAppDomain()} returns {@code "scm"}.</li>
 *   <li>Embed the segment into the REST URL:
 *       {@code "https://" + hostname + "/" + appDomain + "/restApi/version/..."}</li>
 * </ol>
 */
public enum FusionAppDomain {

    /**
     * Supply Chain Management domain.
     * Used for REST APIs related to inventory, items, and on-hand quantities.
     * URL path segment: {@code scm}.
     */
    SCM("scm"),

    /**
     * Financials domain.
     * Used for REST APIs related to invoices, receipts, and journal entries.
     * URL path segment: {@code fin}.
     */
    FIN("fin");

    /** The URL path segment for this domain (e.g. {@code "scm"} or {@code "fin"}). */
    private String appDomain;

    /**
     * Creates a {@code FusionAppDomain} constant with the given URL path segment.
     *
     * @param appDomain the short path segment used in Oracle Fusion REST URLs
     */
    private FusionAppDomain(String appDomain) {
        this.appDomain = appDomain;
    }

    /**
     * Returns the URL path segment for this application domain.
     *
     * @return the path segment string (e.g. {@code "scm"} or {@code "fin"})
     */
    public String getAppDomain() {
        return this.appDomain;
    }

}
