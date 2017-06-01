package com.daybreak.androidsample;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by GuoTianqi on 2017/6/1.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
@SdkSuppress(minSdkVersion = 18)
public class MultiAppsTest {
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.daybreak.androidsample";
    private static final int LAUNCH_TIMEOUT = 3000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    @Test
    public void userLoginActivityTest() throws UiObjectNotFoundException, InterruptedException {
//        UiScrollable listView = new UiScrollable(new UiSelector()
//                .scrollable(true)
//                .className("android.widget.ListView"));
//        listView.setMaxSearchSwipes(100);
//        listView.scrollTextIntoView("MVP");
//        listView.waitForExists(5000);
//        UiObject item = listView.getChildByText(new UiSelector()
//                .className("android.widget.TextView"), "MVP");
//        item.click();

        UiObject appItem = mDevice.findObject(new UiSelector()
                .className(android.widget.ListView.class)
                .instance(0)
                .childSelector(new UiSelector()
                        .text("MVP")));
        appItem.click();

        UiObject item = mDevice.findObject(new UiSelector()
                .className(android.support.v7.widget.RecyclerView.class)
                .instance(0)
                .childSelector(new UiSelector()
                        .text("UserLoginActivity")));
        item.click();

        UiObject usernameText = mDevice.findObject(new UiSelector()
                .className(android.widget.EditText.class)
                .instance(0));
        UiObject passwordText = mDevice.findObject(new UiSelector()
                .className(android.widget.EditText.class)
                .instance(1));

        usernameText.setText("郭天祈");
        passwordText.setText("123");

        UiObject loginBtn = mDevice.findObject(new UiSelector()
                .className(android.widget.Button.class)
                .instance(0));
        loginBtn.click();

        mDevice.wait(Until.gone(By.clazz(android.widget.ProgressBar.class)), 5000);
    }
}
