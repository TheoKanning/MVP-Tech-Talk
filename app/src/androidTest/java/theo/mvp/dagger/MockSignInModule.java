package theo.mvp.dagger;

import org.mockito.Mockito;

import theo.mvp.api.SignInApi;
import theo.mvp.ui.signin.SignInPresenter;

/**
 * Extension of {@link SignInModule} that returns mocks
 */
// no @Module annotation
public class MockSignInModule extends SignInModule {

    // no @Provides of @Singleton annotation
    @Override
    SignInPresenter provideSignInPresenter(SignInApi api) {
        return Mockito.mock(SignInPresenter.class);
    }
}
