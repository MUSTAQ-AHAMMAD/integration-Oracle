package innovate.tamergroup.vendhq.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import innovate.tamergroup.shared.utils.Credential;

import innovate.tamergroup.shared.utils.RESTUtils;
import innovate.tamergroup.vendhq.model.products.ImageUploadResponse;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import innovate.tamergroup.vendhq.model.products.ProductCreate;
import innovate.tamergroup.vendhq.model.products.ProductCreateResponse;

import java.io.File;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.MultipartBody;

public class InsertObjectVendHQ {
    
    private String domain;
    private Gson gson;
    private OkHttpClient client;
    private Credential credential;


    public InsertObjectVendHQ(String domain, Credential credential) {
        this.domain = domain;
        this.credential = credential;
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
        client = RESTUtils.configureToIgnoreCertificate(new OkHttpClient.Builder())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public ProductCreateResponse executeInventoryUpdate(ProductCreate payload) throws IOException {
        
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
        ProductCreateResponse object = gson.fromJson(response.body().string(), ProductCreateResponse.class);
        return object;
    }
    
    public ImageUploadResponse insertItemImage(String filePath, String productId) throws IOException {
        MediaType mediaType = filePath.endsWith("png") ? MediaType.parse("image/png") : MediaType.parse("image/jpeg");
        RequestBody body = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("image", filePath, RequestBody.create(mediaType, new File(filePath)))
                            .build();
        Request request = new Request.Builder()
          .url("https://"+ domain + ".vendhq.com/api/2.0/products/" + productId + "/actions/image_upload")
          .post(body)
          .addHeader("Content-Type", "multipart/form-data")
          .addHeader("Authorization", "Bearer " + credential)
          .build();

        Response response = client.newCall(request).execute();
        ImageUploadResponse object = gson.fromJson(response.body().string(), ImageUploadResponse.class);
        return object;
    }

}
