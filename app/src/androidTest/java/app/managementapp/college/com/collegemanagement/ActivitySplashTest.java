/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ActivitySplashTest {

    @Rule
    public ActivityTestRule<ActivitySplash> mActivityTestRule = new ActivityTestRule<>(ActivitySplash.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void activitySplashTest() {
        ViewInteraction scrollView = onView(
                allOf(withId(R.id.login_form),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        scrollView.check(matches(isDisplayed()));

        ViewInteraction scrollView2 = onView(
                allOf(withId(R.id.login_form),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        scrollView2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.email_sign_in_button), withText("Sign in"),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.email_sign_in_button), withText("Sign in"),
                        withParent(allOf(withId(R.id.email_login_form),
                                withParent(withId(R.id.login_form))))));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.clickListener),
                        childAtPosition(
                                allOf(withId(R.id.lyt_parent),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.present), isDisplayed()));
        linearLayout2.perform(click());

        pressBack();

        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.present), isDisplayed()));
        linearLayout3.perform(click());

        pressBack();

        ViewInteraction linearLayout4 = onView(
                allOf(withId(R.id.absent), isDisplayed()));
        linearLayout4.perform(click());

        pressBack();

        pressBack();

        pressBack();

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.searchStudents), withText("Search"), isDisplayed()));
        appCompatButton3.perform(click());

    }
}
