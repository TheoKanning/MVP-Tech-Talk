package theo.mvp.ui.signin;


import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import theo.mvp.R;
import theo.mvp.TestApplication;
import theo.mvp.dagger.MockComponent;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class SignInActivityTest {

    SignInPresenter mockPresenter;

    // use launchActivity = false so we can set the application beforehand
    @Rule
    public final ActivityTestRule<SignInActivity> activityTestRule = new
            ActivityTestRule<>(SignInActivity.class, false, false);

    @Before
    public void setup() {
        TestApplication app = ((TestApplication) InstrumentationRegistry.getTargetContext().getApplicationContext());
        MockComponent component = MockComponent.Initializer.init();
        component.inject(this);

        // tell test application to use mock component
        app.setHyVeeGraph(component);

        // launch activity after mock component is set
        activityTestRule.launchActivity(null);

        // get presenter here so we have the same instance
        mockPresenter = activityTestRule.getActivity().presenter;
    }

    @Test
    public void enterDataAndPressSubmit_callsPresenter() {
        onView(withId(R.id.email))
                .perform(typeText("email"));

        onView(withId(R.id.password))
                .perform(typeText("password"));

        onView(withId(R.id.sign_in))
                .perform(click());

        verify(mockPresenter).submit("email", "password");
    }

    @Test
    public void showsSuccessMessage() {
        onView(withId(R.id.sign_in_success))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

        SignInActivity activity = activityTestRule.getActivity();
        activity.runOnUiThread(activity::displaySuccess);

        onView(withId(R.id.sign_in_success))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void showsErrorMessage() {
        SignInActivity activity = activityTestRule.getActivity();
        activity.runOnUiThread(activity::displayError);

        SystemClock.sleep(1000);

        onView(withId(android.support.design.R.id.snackbar_text))
                .check(matches(isDisplayed()));
    }
}
