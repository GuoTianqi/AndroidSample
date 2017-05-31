package com.daybreak.androidsample;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.base.BaseLayerModule$FailureHandlerHolder_Factory;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.daybreak.androidsample.mvp.view.UserLoginActivity;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by GuoTianqi on 2017/5/27.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserLoginActivityTest {
    private String mUserName;
    private String mPassword;

    @Rule
    public ActivityTestRule<UserLoginActivity> mActivityRule =
            new ActivityTestRule<>(UserLoginActivity.class);

    @Before
    public void initValidString() {
        mUserName = "gtq";
        mPassword = "123";
    }

    @Test
    public void loginSuccess() {
        onView(withId(R.id.username))
                .perform(typeText(mUserName));

        onView(withId(R.id.password ))
                .perform(typeText(mPassword), closeSoftKeyboard());

        onView(withId(R.id.username))
                .check(matches(withText(mUserName)));
        onView(withId(R.id.password))
                .check(matches(withText(mPassword)));

        onView(withId(R.id.clear)).perform(click());

        onView(withId(R.id.username))
                .check(matches(withText("")));
        onView(withId(R.id.password))
                .check(matches(withText("")));
    }

}
