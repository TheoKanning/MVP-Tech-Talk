package theo.mvp.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import theo.mvp.R;

public class LoginActivity extends Activity {

    @BindView(R.id.email) EditText email;
    @BindView(R.id.password) EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.log_in)
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

    }
}
