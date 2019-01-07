package cmd.test;

import cmd.CMD;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * for  test
 */
public class Test {

    public static void main(String[] args) {

//        PostMessage postMessage = CMD.create(PostMessage.class);
////        postMessage.postMessage("hello");
//        System.out.println(postMessage.login());
//
//        Observable<ResponseBody> login = postMessage.login();
//        System.out.println(postMessage.postMessage("dsa", "www",1));

        ACUserLogin acUserLogin = CMD.create(ACUserLogin.class);
        Observable<ACUserTokenView> login = acUserLogin.login("zhanjing@aculearn.com.cn", "123456");
//        login.subscribe(System.out::println);
        login.subscribe(acUserTokenView -> {
            System.out.println("thread ::"+Thread.currentThread().getName());
            System.out.println(acUserTokenView);
        });
    }
}
