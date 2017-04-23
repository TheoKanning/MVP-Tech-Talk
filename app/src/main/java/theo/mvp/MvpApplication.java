package theo.mvp;


import android.app.Application;

import theo.mvp.dagger.DaggerLoginComponent;
import theo.mvp.dagger.LoginComponent;
import theo.mvp.dagger.LoginModule;

public class MvpApplication extends Application {

    private LoginComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build();
        component.inject(this);
    }

    public LoginComponent getComponent() {
        return component;
    }
}
