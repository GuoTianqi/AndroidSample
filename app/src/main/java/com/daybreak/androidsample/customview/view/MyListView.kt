package com.daybreak.androidsample.customview.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ListView

class MyListView : ListView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
            resources.displayMetrics.heightPixels / 2,
            MeasureSpec.AT_MOST
        )
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val result = super.onInterceptTouchEvent(ev)
        Log.d(TAG, "onInterceptTouchEvent: result = " + result + " " + ev.toString())

        //        switch (ev.getAction()) {
        //            case MotionEvent.ACTION_DOWN:
        //            case MotionEvent.ACTION_MOVE:
        //                getParent().requestDisallowInterceptTouchEvent(true);
        //                break;
        //            case MotionEvent.ACTION_UP:
        //            case MotionEvent.ACTION_CANCEL:
        //                getParent().requestDisallowInterceptTouchEvent(false);
        //                break;
        //        }
        return result
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        val result =  super.onTouchEvent(ev)
        Log.d(TAG, "onTouchEvent: result = " + result + " " + ev.toString())

        return result
    }

    companion object {
        private val TAG = MyListView::class.java.simpleName
    }
}