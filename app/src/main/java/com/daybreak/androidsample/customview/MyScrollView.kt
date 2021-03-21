package com.daybreak.androidsample.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ScrollView
import androidx.annotation.Nullable

class MyScrollView : ScrollView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val result = super.onInterceptTouchEvent(ev)
        Log.d(TAG, "onInterceptTouchEvent: result = " + result + " " + ev.toString())

        return result
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        val result = super.onTouchEvent(ev)
        Log.d(TAG, "onTouchEvent: result = " + result + " " + ev.toString())

        return result
    }

    companion object {
        private val TAG = MyScrollView::class.java.simpleName
    }
}