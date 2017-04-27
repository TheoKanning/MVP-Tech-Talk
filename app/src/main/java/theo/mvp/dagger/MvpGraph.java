package theo.mvp.dagger;

import theo.mvp.MvpApplication;
import theo.mvp.ui.signin.SignInActivity;

/**
 * This interface provides methods for all of the Dagger injection targets in the app. Making it
 * a separate interface allows normal and test components to access these methods.
 */
public interface MvpGraph {
    void inject(MvpApplication application);

    void inject(SignInActivity activity);
}
