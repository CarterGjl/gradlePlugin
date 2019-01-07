package cmd.test;

import cmd.ResponseBody;
import io.reactivex.Observable;

/**
 * for test
 */
public interface PostMessage {

    String postMessage(String name, String pwd, int a);
    Observable<ResponseBody> login();
}
