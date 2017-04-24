package theo.mvp.ui.signin;


import theo.mvp.api.SignInApi;
import theo.mvp.base.BasePresenter;

public class SignInPresenter extends BasePresenter<SignInView> {

    private SignInApi signInApi;

    public SignInPresenter(SignInApi signInApi) {
        this.signInApi = signInApi;
    }
}
