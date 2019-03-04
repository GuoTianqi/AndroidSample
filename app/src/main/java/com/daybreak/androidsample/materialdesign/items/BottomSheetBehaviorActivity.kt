package com.daybreak.androidsample.materialdesign.items

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.daybreak.androidsample.R

import kotlinx.android.synthetic.main.activity_bottom_sheet_behavior.*

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
