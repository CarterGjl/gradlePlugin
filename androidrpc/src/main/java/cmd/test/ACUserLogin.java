package cmd.test;

import io.reactivex.Observable;

interface ACUserLogin {

    Observable<ACUserTokenView> login(String account, String password);
}
