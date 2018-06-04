package com.daybreak.androidsample.vector

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.daybreak.androidsample.R
import kotlinx.android.synthetic.main.activity_vector_drawable.*
import kotlinx.android.synthetic.main.content_vector_drawable.*

class VectorDrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector_drawable)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        avdIv.setOnClickListener {
            val drawable = avdIv.drawable
            if (drawable is Animatable) {
                drawable.start()
            }
        }

        smileIv.setOnClickListener {
            val drawable = smileIv.drawable
            if (drawable is Animatable) {
                drawable.start()
            }
        }

        androidRobot.setOnClickListener {
            androidRobot.isActivated = !androidRobot.isActivated
//            val drawable = androidRobot.drawable
//            if (drawable is Animatable) {
//                drawable.start()
//            }
        }
    }

}
