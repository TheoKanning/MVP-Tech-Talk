package theo.mvp.ui.signin;


import android.support.annotation.VisibleForTesting;

import theo.mvp.api.SignInApi;
import theo.mvp.base.BasePresenter;

public class SignInPresenter extends BasePresenter<SignInView> {

    private SignInApi signInApi;

    public SignInPresenter(SignInApi signInApi) {
        this.signInApi = signInApi;
    }

    @VisibleForTesting
    public void submit(String email, String password) {
        signInApi.signIn(email, password)
                .subscribe(this::displaySignInResult);
    }

    private void displaySignInResult(boolean success) {
        if (success) {
            getView().displaySuccess();
        } else {
            getView().displayError();
        }
    }
}
