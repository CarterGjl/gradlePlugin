package cmd.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class HttpClient {

    private final Retrofit retrofit;
    private static HttpClient httpClient;

    private HttpClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)
                .setLevel(HttpLoggingInterceptor.Level.BODY)
                .setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new GzipRequestInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(NetUrl.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    private static HttpClient getInstance() {
        synchronized (HttpClient.class) {
            if (httpClient == null) {
                httpClient = new HttpClient();
            }
        }
        return httpClient;
    }

    public static PostInfoToServer create() {
        return HttpClient.getInstance().retrofit.create(PostInfoToServer.class);
    }
}
