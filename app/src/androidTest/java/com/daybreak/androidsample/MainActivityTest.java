package com.daybreak.androidsample;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("Custom View"),
                        childAtPosition(
                                withId(R.id.list_view),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(4, click()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.check), withText("Check"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.uncheck), withText("UnCheck"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.check), withText("Check"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.uncheck), withText("UnCheck"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.check), withText("Check"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.uncheck), withText("UnCheck"), isDisplayed()));
        appCompatButton6.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("Material Design"),
                        childAtPosition(
                                withId(R.id.list_view),
                                4),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        pressBack();

        pressBack();

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(android.R.id.text1), withText("MVP"),
                        childAtPosition(
                                withId(R.id.list_view),
                                3),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.username), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.username), isDisplayed()));
        appCompatEditText2.perform(replaceText("呱呱呱呱呱呱个"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.password), isDisplayed()));
        appCompatEditText3.perform(replaceText("天天反反复复"), closeSoftKeyboard());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.login), withText("Login"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.clear), withText("Clear"), isDisplayed()));
        appCompatButton8.perform(click());

        pressBack();

        pressBack();

    }

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
}
