package com.daybreak.androidsample.materialdesign.items

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import butterknife.ButterKnife
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R

import kotlinx.android.synthetic.main.content_custom_tabs.*

class CustomTabsActivity : BaseToolBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout(R.layout.content_custom_tabs)

        ButterKnife.bind(this)

        launch.setOnClickListener {
            val url = "https://news.ycombinator.com/"
            val builder = CustomTabsIntent.Builder()
            builder.setToolbarColor(Color.parseColor("#EE6F2E"))
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }
    }

}
