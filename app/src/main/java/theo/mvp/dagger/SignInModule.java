package theo.mvp.dagger;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import theo.mvp.api.SignInApi;
import theo.mvp.ui.signin.SignInPresenter;

@Module
public class SignInModule {

    @Provides
    SignInPresenter provideSignInPresenter(SignInApi api) {
        return new SignInPresenter(api);
    }
}
