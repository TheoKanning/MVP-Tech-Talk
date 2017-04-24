package theo.mvp;


import android.app.Application;

import theo.mvp.dagger.ApplicationComponent;
import theo.mvp.dagger.DaggerApplicationComponent;

public class MvpApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.create();
        component.inject(this);
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
