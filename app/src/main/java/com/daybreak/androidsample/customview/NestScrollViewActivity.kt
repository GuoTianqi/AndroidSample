package com.daybreak.androidsample.customview

import android.content.Context
import android.os.Bundle
import androidx.annotation.Nullable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ListView
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R
import android.widget.ArrayAdapter
import android.widget.ScrollView

class NestScrollViewActivity : BaseToolBarActivity() {
    private lateinit var mMyListView: MyListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout(R.layout.activity_nest_scroll_view)

        mMyListView = findViewById<MyListView>(R.id.myListView)

        var l = arrayListOf("Hello", "World", "GuoTianqi", "Hello", "World", "GuoTianqi", "Hello", "World", "GuoTianqi", "Hello", "World", "GuoTianqi")
        mMyListView.adapter = ArrayAdapter<String>(NestScrollViewActivity@this, android.R.layout.simple_list_item_1,
                android.R.id.text1, l)
    }
}

class MyListView : ListView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val newHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(
                resources.displayMetrics.heightPixels / 2,
                View.MeasureSpec.AT_MOST)
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
