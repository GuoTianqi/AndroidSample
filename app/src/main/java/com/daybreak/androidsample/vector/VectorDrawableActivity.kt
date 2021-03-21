package com.daybreak.androidsample.vector

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.View
import com.daybreak.androidsample.R
import com.daybreak.androidsample.databinding.ActivityVectorDrawableBinding

class VectorDrawableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVectorDrawableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVectorDrawableBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.contentVector.avdIv.setOnClickListener {
            val drawable = binding.contentVector.avdIv.drawable
            if (drawable is Animatable) {
                drawable.start()
            }
        }

        binding.contentVector.smileIv.setOnClickListener {
            val drawable = binding.contentVector.smileIv.drawable
            if (drawable is Animatable) {
                drawable.start()
            }
        }

        binding.contentVector.androidRobot.setOnClickListener {
            binding.contentVector.androidRobot.isActivated = !binding.contentVector.androidRobot.isActivated
//            val drawable = androidRobot.drawable
//            if (drawable is Animatable) {
//                drawable.start()
//            }
        }
    }

}
