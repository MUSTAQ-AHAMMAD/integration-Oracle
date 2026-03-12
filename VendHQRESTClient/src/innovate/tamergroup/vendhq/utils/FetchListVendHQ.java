package innovate.tamergroup.vendhq.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.shared.utils.RESTUtils;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import innovate.tamergroup.vendhq.model.shared.VendHQObjectList;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class FetchListVendHQ {

    private String domain;
    private Gson gson;
    private OkHttpClient client;
    private Credential credential;


    public FetchListVendHQ(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX"/*EEE, dd MMM yyyy HH:mm:ss zzz*/).create();
        client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public <T> List<T> execute(Class<T> klass, Integer apiVersion, String api, 
                               HashMap<String,String> queryParameters, Long after) throws IOException {
        
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://").append(domain);
        if (apiVersion == 2) urlBuilder.append(".vendhq.com/api/2.0/");
        else urlBuilder.append(".vendhq.com/api/");
        urlBuilder.append(api).append("?after=").append(String.valueOf(after));
        if (queryParameters != null) {
            Iterator<Map.Entry<String,String>> iterator = queryParameters.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String,String> pair = iterator.next();
                urlBuilder.append("&").append(pair.getKey()).append("=").append(pair.getValue());
                iterator.remove();
            }
        }
        
        Request request = new Request.Builder()
          .url(urlBuilder.toString())
          .get()
          .addHeader("Authorization", "Bearer " + credential)
          .build();
        Response response = client.newCall(request).execute();
        VendHQObjectList<T> objectListCollection = gson.fromJson(response.body().string(), new VendHQObjectListType<T>(klass));
        return objectListCollection.getItems();
    }
    
}
