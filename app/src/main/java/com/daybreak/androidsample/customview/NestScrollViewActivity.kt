package com.daybreak.androidsample.customview

import android.os.Bundle
import android.widget.ArrayAdapter
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R
import com.daybreak.androidsample.customview.view.MyListView

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

