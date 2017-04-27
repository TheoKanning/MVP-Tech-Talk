package theo.mvp;


import android.app.Application;

import theo.mvp.dagger.DaggerApplicationComponent;
import theo.mvp.dagger.MvpGraph;

public class MvpApplication extends Application {

    protected MvpGraph component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.create();
        component.inject(this);
    }

    public MvpGraph getComponent() {
        return component;
    }
}
