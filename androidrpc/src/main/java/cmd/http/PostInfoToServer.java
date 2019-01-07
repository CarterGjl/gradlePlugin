package cmd.http;

import cmd.ResponseBody;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostInfoToServer {

    @Headers(value = {"debug:afjnvRJ#@klfj132DFfFS"})
    @POST(value = "/rest/acweb/call")
    Observable<ResponseBody<JsonElement>> postInfo(@Body RequestBody requestBody);
}
