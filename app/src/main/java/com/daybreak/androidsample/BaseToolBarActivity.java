package com.daybreak.androidsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

public class BaseToolBarActivity extends AppCompatActivity {
    private static final boolean DEBUG = BuildConfig.DEBUG;
    private static final String TAG = "ActivityLifeCycle";

    protected CoordinatorLayout mCoordinatorLayout;
    protected AppBarLayout mAppBarLayout;
    protected Toolbar mToolBar;
    private ViewStub mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logActivityLifeCycle();

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_tool_bar);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mContentLayout = (ViewStub) findViewById(R.id.content_layout);
    }

    @Override
    protected void onRestart() {
        logActivityLifeCycle();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        logActivityLifeCycle();
        super.onStart();
    }

    @Override
    protected void onResume() {
        logActivityLifeCycle();
        super.onResume();
    }

    @Override
    protected void onPause() {
        logActivityLifeCycle();
        super.onPause();
    }

    @Override
    protected void onStop() {
        logActivityLifeCycle();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        logActivityLifeCycle();
        super.onDestroy();
    }

    @Override
    public void onAttachedToWindow() {
        logActivityLifeCycle();
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        logActivityLifeCycle();
        super.onDetachedFromWindow();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        logActivityLifeCycle();
        super.onNewIntent(intent);
    }

    public void setContentLayout(@LayoutRes int layoutResId) {
        mContentLayout.setLayoutResource(layoutResId);
        mContentLayout.inflate();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentLayout(layoutResID);
    }

    /**
     *
     * use {@link #setContentLayout(int)}
     *
     * @param view
     * @deprecated
     */
    @Deprecated
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    private void logActivityLifeCycle() {
        if (DEBUG) {
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            //            StackTraceElement stackTraceElement = stacks[3];
//

            boolean found = false;
            int index = 0;
            for (StackTraceElement element : stacks) {
                if (TextUtils.equals(element.getMethodName(), "logActivityLifeCycle")) {
                    found = true;
                    break;
                }

                index++;
            }

            if (found) {
                Log.d(TAG, getClass().getSimpleName() + ": " + stacks[index + 1].getMethodName());
            }
        }
    }
}
