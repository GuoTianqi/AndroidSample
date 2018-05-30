package com.daybreak.androidsample.materialdesign.items

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.daybreak.androidsample.R

import kotlinx.android.synthetic.main.activity_bottom_sheet_behavior.*
import kotlinx.android.synthetic.main.activity_camera_distance.*

class BottomSheetBehaviorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_behavior)
        setSupportActionBar(toolbar)

        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d(TAG, "slideOffset = $slideOffset")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.d(TAG, "newState = $newState")
            }

        })

        showBottomSheet.setOnClickListener {
            BottomSheetDialog(this).apply {
                setTitle("Bottom Sheet Dialog")
                val flower = ImageView(context)
                flower.setImageResource(R.drawable.flower)
                setContentView(flower)
            }.show()
        }
    }

    companion object {
        val TAG = BottomSheetBehaviorActivity::class.simpleName
    }
}
