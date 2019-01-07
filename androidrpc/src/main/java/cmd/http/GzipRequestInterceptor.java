package cmd.http;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

import java.io.IOException;

public class GzipRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if (request.body() == null || request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        }
        Request newRequest = request.newBuilder()
                .header("Content-Encoding", "gzip")
                .method(request.method(), gzip(request.body())).build();
        return chain.proceed(newRequest);
    }
    private okhttp3.RequestBody gzip(final okhttp3.RequestBody requestBody){
        return new okhttp3.RequestBody(){

            @Override
            public MediaType contentType() {
                return requestBody.contentType();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                requestBody.writeTo(gzipSink);
                gzipSink.close();
            }
        };
    }
}
