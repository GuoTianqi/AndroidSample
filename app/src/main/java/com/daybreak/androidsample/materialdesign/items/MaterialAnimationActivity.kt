package com.daybreak.androidsample.materialdesign.items

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import android.transition.Fade
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.Window

import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R
import com.daybreak.androidsample.databinding.ActivityMaterialAnimationBinding

class MaterialAnimationActivity : BaseToolBarActivity() {
    private lateinit var binding: ActivityMaterialAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        }

        super.onCreate(savedInstanceState)

        binding = ActivityMaterialAnimationBinding.inflate(LayoutInflater.from(this))
        setContentLayout(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val typedValue = TypedValue()
            theme.resolveAttribute(
                android.R.attr.selectableItemBackgroundBorderless,
                typedValue,
                true
            )
            //            flower.setBackgroundResource(typedValue.resourceId);
        }

        binding.showFlower.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val cx = binding.flower.width / 2
                val cy = binding.flower.height / 2

                val finalRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()

                val animator =
                    ViewAnimationUtils.createCircularReveal(binding.flower, cx, cy, 0f, finalRadius)

                binding.flower.visibility = View.VISIBLE
                animator.start()
            } else {
                binding.flower.visibility = View.VISIBLE
            }
        }

        binding.hideFlower.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val cx = binding.flower.width / 2
                val cy = binding.flower.height / 2

                val finalRadius = Math.max(binding.flower.width, binding.flower.height)
                // get the initial radius for the clipping circle
                val initialRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()
                val animator =
                    ViewAnimationUtils.createCircularReveal(binding.flower, cx, cy, initialRadius, 0f)
                animator.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        binding.flower.visibility = View.INVISIBLE
                    }
                })

                animator.start()
            } else {
                binding.flower.visibility = View.INVISIBLE
            }
        }

        binding.flower.setOnClickListener {
            val intent = Intent(
                this@MaterialAnimationActivity,
                CoordinatorLayoutExploreActivity::class.java
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.exitTransition = Fade()
                window.reenterTransition = Fade()
                // getWindow().setSharedElementExitTransition(new ChangeImageTransform());
                startActivity(
                    intent, ActivityOptions.makeSceneTransitionAnimation(
                        this@MaterialAnimationActivity, binding.flower, "flower"
                    ).toBundle()
                )
            } else {
                startActivity(intent)
            }
        }

        val animatedVectorDrawable =
            AnimatedVectorDrawableCompat.create(this, R.drawable.animvectordrawable)
        binding.animVector.setImageDrawable(animatedVectorDrawable)
        animatedVectorDrawable?.start()

        binding.animVector.setOnClickListener { animatedVectorDrawable?.start() }

        binding.smileIv.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val path = Path()
                path.arcTo(it.x - 100f, it.y, it.x + 100f, it.y + 200f, 270f, -180f, true)
                ObjectAnimator.ofFloat(it, View.X, View.Y, path).apply {
                    duration = 2000
                    start()
                }
            }
        }
    }
}
