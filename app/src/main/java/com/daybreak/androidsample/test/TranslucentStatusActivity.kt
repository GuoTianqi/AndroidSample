package com.daybreak.androidsample.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.daybreak.androidsample.R
import com.daybreak.androidsample.utils.StatusBarUtil

class TranslucentStatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StatusBarUtil.immersive(this)

        setContentView(R.layout.activity_translucent_status)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}