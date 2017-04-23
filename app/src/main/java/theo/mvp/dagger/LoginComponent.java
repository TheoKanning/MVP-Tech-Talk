package theo.mvp.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = LoginModule.class)
public interface LoginComponent {
    //application
    void inject(Application application);
}

