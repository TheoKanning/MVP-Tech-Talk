package theo.mvp.dagger;

import javax.inject.Singleton;

import dagger.Component;
import theo.mvp.ui.signin.SignInActivityTest;

@Singleton
@Component(modules = {
        ApiModule.class, // use original classes here
        SignInModule.class
})
public interface MockComponent extends MvpGraph {
    void inject(SignInActivityTest test);

    final class Initializer {

        public static MockComponent init() {
            return DaggerMockComponent.builder()
                    .signInModule(new MockSignInModule())  // create mock subclasses here
                    .apiModule(new MockApiModule())
                    .build();
        }

        private Initializer() {
            throw new AssertionError("No Instances.");
        }
    }
}
