package com.daybreak.androidsample;

import android.content.Context;
import android.content.Intent;
import androidx.test.InstrumentationRegistry;
import androidx.test.filters.LargeTest;
import androidx.test.filters.SdkSuppress;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;

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
                .className(RecyclerView.class)
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
