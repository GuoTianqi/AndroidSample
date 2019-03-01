package com.daybreak.androidsample.customview.view;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by GuoTianqi on 2017/6/14.
 */

public class GestureDetectorView extends BaseView {
    private static final String TAG = GestureDetector.class.getSimpleName();

    GestureDetector mGestureDetector;

    public GestureDetectorView(Context context) {
        this(context, null);
    }

    public GestureDetectorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.v(TAG, "onDown");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.v(TAG, "onShowPress");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.v(TAG, "onSingleTapUp");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.v(TAG, "onScroll");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.v(TAG, "onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.v(TAG, "onFling");
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = mGestureDetector.onTouchEvent(event);
        if (!result) {
            Log.v(TAG, "gesture detector onTouchEvent return false");
        }
        return true;
    }
}
