package com.daybreak.androidsample;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by GuoTianqi on 2017/9/29.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
