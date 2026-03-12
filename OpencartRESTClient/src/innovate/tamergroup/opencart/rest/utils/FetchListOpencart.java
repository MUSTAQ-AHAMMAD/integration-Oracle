package innovate.tamergroup.opencart.rest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import innovate.tamergroup.opencart.rest.model.shared.OpencartListResponse;
import innovate.tamergroup.shared.utils.Credential;

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

public class FetchListOpencart {
    
    private String domain;
    private Gson gson;
    private OkHttpClient client;
    private Credential credential;


    public FetchListOpencart(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
        gson = new GsonBuilder().registerTypeAdapter(Date.class, new OpencartDateDeserializer()).create();
        client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public <T> List<T> execute(Class<T> klass, String module, String api, HashMap<String,String> queryParameters) throws IOException {
        
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://").append(domain)
                  .append("/index.php?route=rest/").append(module)
                  .append("/").append(api);
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
          .addHeader("X-Oc-Restadmin-Id", credential.toString())
          .build();
        Response response = client.newCall(request).execute();
        OpencartListResponse<T> objectListCollection = gson.fromJson(response.body().string(), new OpencartListReponseType<T>(klass));
        return objectListCollection.getData();
    }
}
