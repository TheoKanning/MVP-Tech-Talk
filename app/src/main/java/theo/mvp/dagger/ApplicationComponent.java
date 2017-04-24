package theo.mvp.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import theo.mvp.MvpApplication;
import theo.mvp.ui.signin.SignInActivity;

@Singleton
@Component(modules = {
        ApiModule.class,
        SignInModule.class
})
public interface ApplicationComponent {
    void inject(MvpApplication application);
    void inject(SignInActivity activity);
}

