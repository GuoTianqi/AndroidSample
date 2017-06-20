package com.daybreak.androidsample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;

public class BaseToolBarActivity extends AppCompatActivity {
    protected CoordinatorLayout mCoordinatorLayout;
    protected AppBarLayout mAppBarLayout;
    protected Toolbar mToolBar;
    private ViewStub mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_tool_bar);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mContentLayout = (ViewStub) findViewById(R.id.content_layout);
    }

    public void setContentLayout(@LayoutRes int layoutResId) {
        mContentLayout.setLayoutResource(layoutResId);
        mContentLayout.inflate();
    }

    /**
     *
     * use {@link #setContentLayout(int)}
     *
     * @param layoutResID
     * @deprecated
     */
    @Deprecated
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
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
}
