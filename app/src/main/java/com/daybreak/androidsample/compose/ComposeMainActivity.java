package com.daybreak.androidsample.compose;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.compose.items.ComposeTestActivity;
import com.daybreak.androidsample.rxandroid.items.AsyncSubjectActivity;
import com.daybreak.androidsample.rxandroid.items.BaseUseRxAndroidActivity;
import com.daybreak.androidsample.rxandroid.items.RxSingleActivity;

public class ComposeMainActivity extends BaseClassListActivity {
    public static final Class[] classes = new Class[] {
            ComposeTestActivity.class
    };

    @Override
    public Class[] getClassList() {
        return classes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onItemClick(int position) {
        Intent intent = new Intent(this, classes[position]);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }

        return true;
    }
}
