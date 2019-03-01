package com.daybreak.androidsample;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.runner.AndroidJUnitRunner;
import android.util.Log;

import com.daybreak.androidsample.customview.CustomViewActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
