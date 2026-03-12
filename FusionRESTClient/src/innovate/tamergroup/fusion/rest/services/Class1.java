package innovate.tamergroup.fusion.rest.services;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Class1 {
    public Class1() {
        super();
    }

    public static void main(String[] args) throws IOException {
        Class1 class1 = new Class1();
        
        
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"password\": \"sd123asdd\",\n    \"email\": \"alomostafa@gmail.com\"\n}");
        Request request = new Request.Builder()
          .url("http://87.101.136.180:1989/default/Tasks")
          .get()
          .addHeader("Content-Type", "application/json")
          .addHeader("cache-control", "no-cache")
          .build();

        Response response = client.newCall(request).execute();
        
        System.out.println(response.body().string());
    }
}
