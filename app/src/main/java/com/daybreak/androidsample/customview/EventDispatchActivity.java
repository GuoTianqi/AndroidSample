package com.daybreak.androidsample.customview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class EventDispatchActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_event_dispatch);
    }
}

class MyButton extends AppCompatButton {
    private static final String TAG = MyButton.class.getSimpleName();

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent: " + event + "  result = " + result);

        return result;
    }
}

class MyTextView extends AppCompatTextView {
    static final String TAG = MyTextView.class.getSimpleName();

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent: " + event + "  result = " + result);

        return result;
    }
}

class MyLinearLayout extends LinearLayout {
    static final String TAG = MyLinearLayout.class.getSimpleName();

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);

        Log.d(TAG, "onInterceptTouchEvent: " + ev + "  result = " + result);

        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent: " + event + "  result = " + result);

        return result;
    }
}

class MyFrameLayout extends FrameLayout {
    static final String TAG = MyFrameLayout.class.getSimpleName();

    public MyFrameLayout(Context context) {
        super(context);
    }

    public MyFrameLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);

        Log.d(TAG, "onInterceptTouchEvent: " + ev + "  result = " + result);

        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent: " + event + "  result = " + result);

        return result;
    }
}
