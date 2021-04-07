package com.daybreak.androidsample;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.daybreak.androidsample.mvp.view.UserLoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
