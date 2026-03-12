package com.oracle.xmlns.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.oracle.xmlns.apps.shared.ObjectList;

import innovate.tamergroup.shared.utils.Credential;
import innovate.tamergroup.shared.utils.FusionAppDomain;
import innovate.tamergroup.shared.utils.FusionAppParams;
import innovate.tamergroup.shared.utils.RESTUtils;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FetchListFusion {
    
    private FusionAppDomain appDomain;
    private FusionAppParams params;
    private Gson gson;
    private OkHttpClient client;
    private Credential credential;


    public FetchListFusion(FusionAppDomain appDomain, FusionAppParams params, Credential credential) {
        this.appDomain = appDomain;
        this.params = params;
        this.credential = credential;
        gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();
        client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(150, TimeUnit.SECONDS)
                .build();
    }

    public <T> List<T> execute(Class<T> klass, String api, HashMap<String,String> queryParameters, Integer limit) throws IOException {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://")
            .append(params.getHostname()).append(".")
            .append("fa").append(".")
            .append(params.getRegion()).append(".oraclecloud.com")
            .append(api).append("?onlyData=true&limit=").append(String.valueOf(limit));
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
          .addHeader("Authorization", "Basic " + credential)
          .build();
        Response response = client.newCall(request).execute();
        ObjectList<T> objectListCollection = gson.fromJson(response.body().string(), new FusionObjectListType<T>(klass));
        return objectListCollection.getItems();
    }
    
}
