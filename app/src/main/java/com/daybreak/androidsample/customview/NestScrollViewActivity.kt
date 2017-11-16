package com.daybreak.androidsample.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R

class NestScrollViewActivity : BaseToolBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout(R.layout.activity_nest_scroll_view)
    }
}
