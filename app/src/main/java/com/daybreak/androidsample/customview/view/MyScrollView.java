package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by guotianqi on 2017/11/9.
 */

public class MyScrollView extends ScrollView {
    private static final String TAG = MyScrollView.class.getSimpleName();

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);
        Log.d(TAG, "onInterceptTouchEvent: result = " + result + " " + ev.toString());

        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);
        Log.d(TAG, "onTouchEvent: result = " + result + " " + ev.toString());

        return result;
    }
}
