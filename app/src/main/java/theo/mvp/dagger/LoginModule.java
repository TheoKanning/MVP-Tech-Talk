package theo.mvp.dagger;

import android.content.Context;

import dagger.Module;

@Module
public class LoginModule {

    private Context context;

    public LoginModule(Context context) {
        this.context = context;
    }
}
