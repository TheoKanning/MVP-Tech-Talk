package theo.mvp.api;

import javax.inject.Singleton;

import rx.Observable;

/**
 * Api that mocks sign in requests
 */

@Singleton
public class SignInApi {

    public Observable<Boolean> signIn(String email, String password) {
        boolean correct = email.equals("tkanning@nerdery.com") && password.equals("password");
        return Observable.just(correct);
    }
}
