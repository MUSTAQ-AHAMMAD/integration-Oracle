package innovate.tamergroup.fusion.soap.utils;

import weblogic.wsee.jws.jaxws.owsm.SecurityPoliciesFeature;

public class FusionSOAPUtils {
    
    public static SecurityPoliciesFeature securityFeatures =
            new SecurityPoliciesFeature(new String[] { "oracle/wss11_saml_or_username_token_with_message_protection_service_policy"
                                                       /*"oracle/wss_username_token_over_ssl_client_policy"*/ });
}
