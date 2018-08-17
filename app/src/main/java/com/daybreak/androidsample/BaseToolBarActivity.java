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
    private View mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logActivityLifeCycle();

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_tool_bar);
        mCoordinatorLayout = findViewById(R.id.coordinator_layout);
        mAppBarLayout = findViewById(R.id.app_bar_layout);
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
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
        View contentLayout = getLayoutInflater().inflate(layoutResId, mCoordinatorLayout, false);
        setContentLayout(contentLayout);
    }

    public void setContentLayout(View contentLayout) {
        mContentLayout = contentLayout;
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(
                CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT
        );
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        mCoordinatorLayout.addView(contentLayout, lp);
    }

    public View getContentLayout() {
        return mContentLayout;
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
