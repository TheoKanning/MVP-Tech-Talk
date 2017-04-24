package theo.mvp.api;

import javax.inject.Singleton;

import rx.Observable;

/**
 * Api that mocks sign in requests
 */

@Singleton
public class SignInApi {

    Observable<Boolean> signIn(String email, String password) {
        return Observable.just(true);
    }
}
