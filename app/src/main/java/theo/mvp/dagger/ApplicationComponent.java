package theo.mvp.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        SignInModule.class
})
public interface ApplicationComponent extends MvpGraph {
}

