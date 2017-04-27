package theo.mvp;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;


/**
 * Test runner that makes Android tests use {@link TestApplication}
 */
public class TestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // loads test application
        return super.newApplication(cl, TestApplication.class.getName(), context);
    }
}
