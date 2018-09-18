package org.karma.mytestapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TEST_INPUT = "Kartikeya";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void initialSetup() {
        System.out.println("beforeClass");
    }

    @Before
    public void setup() {
        System.out.println("before");
    }

    @Test
    public void useAppContext() {
        System.out.println("test");
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("org.karma.mytestapp", appContext.getPackageName());
    }

    @Test
    public void shouldDisplayHelloWorld() {
        //Espresso.onView -> Find ui components (using ViewMatcher)
        //Espresso.perform -> Perform action (using ViewAction)
        //Espresso.check -> Validate (using ViewAssertion (uses ViewMatcher))

        onView(withText("Hello World!")).check(matches(isDisplayed()));

//        ViewInteraction element = onView(withText("Hello World!"));
//        element.check(matches(isDisplayed()));
//        element.perform(click());
    }

    @Test
    public void validateLoginButton() throws InterruptedException {
        System.out.println("test");
        TimeUnit.SECONDS.sleep(3);
        onView(withId(R.id.button)).check(matches(withText(R.string.login_button))).perform(click()).check(matches(isClickable()));
    }

    @Test
    public void validateTextField() throws InterruptedException {
        System.out.println("test");
        TimeUnit.SECONDS.sleep(3);
        onView(withId(R.id.name)).perform(typeText(TEST_INPUT), clearText()).check(matches(withHint("First Name")));
    }

    @After
    public void destroy() {
        System.out.println("after");
    }

    @AfterClass
    public static void finalDestroy() {
        System.out.println("afterClass");
    }

}
