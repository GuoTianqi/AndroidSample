package com.daybreak.androidsample.test

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.TargetApi
import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewConfiguration
import android.view.animation.RotateAnimation
import android.widget.*
import com.daybreak.androidsample.R
import kotlinx.android.synthetic.main.activity_swipe_refresh_layout.*

@TargetApi(16)
class CameraDistanceActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mImageView: ImageView
    private lateinit var mEditText: EditText
    private lateinit var mConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_distance)

        mImageView = findViewById(R.id.imageView)
        mEditText = findViewById(R.id.editText)
        mConfirm = findViewById(R.id.confirm)

        mEditText.setText("${mImageView.cameraDistance / resources.displayMetrics.density}")

        mConfirm.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.confirm -> {
                val globalRect = Rect()
                mImageView.getGlobalVisibleRect(globalRect)
                Log.e("XXX", "global visible rect = $globalRect")
                val localRect = Rect()
                mImageView.getLocalVisibleRect(localRect)
                Log.e("XXX", "local visible rect = $localRect")

                if (!mEditText.text.isNullOrEmpty()) {
                    mImageView.cameraDistance = mEditText.text.toString().toFloat() *
                            resources.displayMetrics.density

                    val anim = ObjectAnimator.ofFloat(mImageView, "rotationY", 0f, 360f)
                    anim.duration = 3000
                    anim.start()

                    Toast.makeText(CameraDistanceActivity@this, "densityDpi = ${resources.displayMetrics.densityDpi}",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
