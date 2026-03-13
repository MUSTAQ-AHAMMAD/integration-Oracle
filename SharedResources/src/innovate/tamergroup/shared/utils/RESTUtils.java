package innovate.tamergroup.shared.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * Utility class providing helper methods for configuring the
 * {@link OkHttpClient} used by all REST API clients in the integration
 * middleware.
 *
 * <p>Currently the primary responsibility of this class is to support a
 * <b>test-mode</b> configuration in which SSL certificate validation is
 * intentionally bypassed.  This is necessary when connecting to Oracle Fusion
 * sandbox instances or other development environments that use self-signed
 * or expired TLS certificates.</p>
 *
 * <p><b>⚠ Security warning:</b> The {@link #configureToIgnoreCertificate}
 * method trusts <em>all</em> certificates and accepts <em>all</em> hostnames.
 * It must <b>never</b> be used in a production environment because it makes
 * connections vulnerable to man-in-the-middle attacks.  Use proper CA-signed
 * certificates in production.</p>
 *
 * <p><b>Step-by-step usage:</b></p>
 * <ol>
 *   <li>Create a fresh {@link OkHttpClient.Builder}:
 *       {@code OkHttpClient.Builder builder = new OkHttpClient.Builder();}</li>
 *   <li>In test / development environments call
 *       {@link #configureToIgnoreCertificate(OkHttpClient.Builder)} to apply
 *       the trust-all configuration:
 *       {@code builder = RESTUtils.configureToIgnoreCertificate(builder);}</li>
 *   <li>Add any other client-wide settings (timeouts, interceptors, etc.) to
 *       the builder.</li>
 *   <li>Build the final client: {@code OkHttpClient client = builder.build();}</li>
 *   <li>Use {@code client} for all REST calls in that integration module.</li>
 * </ol>
 */
public class RESTUtils {
    
    /**
     * Configures the supplied {@link OkHttpClient.Builder} to skip all TLS
     * certificate and hostname validation checks.
     *
     * <p>This is intended exclusively for <b>test / sandbox</b> environments
     * where Oracle Fusion or another target API is running with a self-signed
     * certificate that would otherwise be rejected by the default Java SSL
     * trust store.</p>
     *
     * <p><b>How it works step by step:</b></p>
     * <ol>
     *   <li>An {@link X509TrustManager} that accepts every certificate without
     *       performing any validation is created (both
     *       {@code checkClientTrusted} and {@code checkServerTrusted} are
     *       no-ops, and {@code getAcceptedIssuers} returns an empty array).</li>
     *   <li>An {@link SSLContext} is initialised with that trust manager, and
     *       the resulting {@link SSLSocketFactory} is installed on the
     *       builder.</li>
     *   <li>A {@link HostnameVerifier} that always returns {@code true} is
     *       set on the builder, disabling hostname verification.</li>
     *   <li>The modified builder is returned so further configuration can be
     *       chained.</li>
     * </ol>
     *
     * <p>Any exception during setup is caught and logged to standard output;
     * in that case the builder is returned unchanged.</p>
     *
     * @param builder the {@link OkHttpClient.Builder} to configure; must not
     *                be {@code null}
     * @return the same builder instance, now configured to trust all
     *         certificates and hostnames
     */
    /*Setting testMode configuration. If set as testMode, the connection will skip certification check*/
    public static OkHttpClient.Builder configureToIgnoreCertificate(OkHttpClient.Builder builder) {
        try {
    
            /*Create a trust manager that does not validate certificate chains*/
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }
    
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }
    
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
    
            /*Install the all-trusting trust manager*/
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            /*Create an ssl socket factory with our all-trusting manager*/
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
    
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            System.out.println("Exception while configuring IgnoreSslCertificate: " + e.getMessage());
        }
        return builder;
    }
}
