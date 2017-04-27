package theo.mvp.ui.signin;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import theo.mvp.MvpApplication;
import theo.mvp.R;

public class SignInActivity extends Activity implements SignInView{

    @BindView(R.id.background) View background;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.sign_in_success) View successMessage;

    @Inject SignInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ((MvpApplication) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void displaySuccess() {
        successMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayError() {
        Snackbar.make(background, R.string.sign_in_failure, Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.sign_in)
    void onLogInClicked(){
        submit();
    }

    @OnEditorAction(R.id.password)
    boolean onDonePressed(int actionId){
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            submit();
        }

        return false;
    }

    private void submit(){
        presenter.submit(email.getText().toString(), password.getText().toString());
    }
}
