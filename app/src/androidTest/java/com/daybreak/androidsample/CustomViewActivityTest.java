package com.daybreak.androidsample;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;
import android.util.Log;

import com.daybreak.androidsample.customview.CustomViewActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by GuoTianqi on 2017/5/31.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CustomViewActivityTest {
    @Rule
    public ActivityTestRule<CustomViewActivity> mActivityRule =
            new ActivityTestRule<>(CustomViewActivity.class);

    @Before
    public void init() {
        Log.d("XXX", "----------INIT-----------------");
    }

    @Test
    public void dragViewTest() {
        onView(withId(R.id.recycler_view))
                .perform(actionOnItemAtPosition(16, click()));
        scrollTo();
        pressBack();
    }
}
