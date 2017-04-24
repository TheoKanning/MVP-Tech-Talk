package theo.mvp.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import theo.mvp.api.SignInApi;

@Module
public class ApiModule {

    @Singleton
    @Provides
    SignInApi provideSignInApi() {
        return new SignInApi();
    }
}
