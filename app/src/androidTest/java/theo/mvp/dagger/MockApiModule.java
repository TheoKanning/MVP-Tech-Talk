package theo.mvp.dagger;

import org.mockito.Mockito;

import theo.mvp.api.SignInApi;

/**
 * Extension of {@link ApiModule} that returns mocks
 */
// no @Module annotation required
public class MockApiModule extends ApiModule {

    // no @Provides or @Singleton
    @Override
    SignInApi provideSignInApi() {
        return Mockito.mock(SignInApi.class);
    }
}
