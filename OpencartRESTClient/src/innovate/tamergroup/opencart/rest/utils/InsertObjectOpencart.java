package innovate.tamergroup.opencart.rest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import innovate.tamergroup.opencart.rest.model.product.post.ProductPost;
import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.shared.utils.RESTUtils;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InsertObjectOpencart {
    
    private String domain;
    private Gson gson;
    private OkHttpClient client;
    private Credential credential;


    public InsertObjectOpencart(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
        client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public ProductPost executeProductPost (ProductPost payload) throws IOException {
        
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("https://").append(domain);
        urlBuilder.append(".vendhq.com/api/");
        urlBuilder.append("products");
        
        Request request = new Request.Builder()
          .url(urlBuilder.toString())
          .post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(payload)))
          .addHeader("Authorization", "Bearer " + credential)
          .addHeader("Content-Type", "application/json")
          .build();
        Response response = client.newCall(request).execute();
        ProductPost object = gson.fromJson(response.body().string(), ProductPost.class);
        return object;
    }
}
