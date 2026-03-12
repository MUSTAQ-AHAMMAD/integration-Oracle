package com.oracle.xmlns.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.oracle.xmlns.apps.scm.inventory.AvailableQuantityRequest;
import com.oracle.xmlns.apps.scm.inventory.AvailableQuantityResponse;
import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionRequest;
import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionResponse;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;

import innovate.tamergroup.shared.utils.FusionAppParams;

import innovate.tamergroup.shared.utils.RESTUtils;

import java.io.IOException;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InsertObjectFusion {
    
    private FusionAppDomain appDomain;
    private FusionAppParams params;
    private Gson gson;
    private OkHttpClient client;
    private Credential credential;


    public InsertObjectFusion(FusionAppDomain appDomain, FusionAppParams params, Credential credential) {
        this.appDomain = appDomain;
        this.params = params;
        this.credential = credential;
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").create();
        client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .build();
    }
    
    public <T> T createTransaction(Class<T> klass, String api, Object payload) throws IOException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://")
            .append(params.getHostname()).append(".")
            .append("fa").append(".")
            .append(params.getRegion()).append(".oraclecloud.com")
            .append(api);
        
        
        Request request = new Request.Builder()
          .url(urlBuilder.toString())
          .post(RequestBody.create(MediaType.parse("application/vnd.oracle.adf.resourceitem+json"), gson.toJson(payload)))
          .addHeader("Authorization", "Basic " + credential)
          .addHeader("Content-type", "application/vnd.oracle.adf.resourceitem+json")
          .build();
        Response response = client.newCall(request).execute();
        T object = gson.fromJson(response.body().string(), klass);
        return object;
    }
    
}
