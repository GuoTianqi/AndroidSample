package com.daybreak.androidsample.materialdesign.items

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.transition.Fade
import android.util.TypedValue
import android.view.View
import android.view.ViewAnimationUtils
import android.view.Window

import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R
import kotlinx.android.synthetic.main.activity_material_animation.*

class MaterialAnimationActivity : BaseToolBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        }

        super.onCreate(savedInstanceState)

        setContentLayout(R.layout.activity_material_animation)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val typedValue = TypedValue()
            theme.resolveAttribute(
                android.R.attr.selectableItemBackgroundBorderless,
                typedValue,
                true
            )
            //            flower.setBackgroundResource(typedValue.resourceId);
        }

        showFlower.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val cx = flower.width / 2
                val cy = flower.height / 2

                val finalRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()

                val animator =
                    ViewAnimationUtils.createCircularReveal(flower, cx, cy, 0f, finalRadius)

                flower.visibility = View.VISIBLE
                animator.start()
            } else {
                flower.visibility = View.VISIBLE
            }
        }

        hideFlower.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val cx = flower.width / 2
                val cy = flower.height / 2

                val finalRadius = Math.max(flower.width, flower.height)
                // get the initial radius for the clipping circle
                val initialRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()
                val animator =
                    ViewAnimationUtils.createCircularReveal(flower, cx, cy, initialRadius, 0f)
                animator.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        flower.visibility = View.INVISIBLE
                    }
                })

                animator.start()
            } else {
                flower.visibility = View.INVISIBLE
            }
        }

        flower.setOnClickListener {
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
                        this@MaterialAnimationActivity, flower, "flower"
                    ).toBundle()
                )
            } else {
                startActivity(intent)
            }
        }

        val animatedVectorDrawable =
            AnimatedVectorDrawableCompat.create(this, R.drawable.animvectordrawable)
        animVector.setImageDrawable(animatedVectorDrawable)
        animatedVectorDrawable?.start()

        animVector.setOnClickListener { animatedVectorDrawable?.start() }

        smileIv.setOnClickListener {
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
