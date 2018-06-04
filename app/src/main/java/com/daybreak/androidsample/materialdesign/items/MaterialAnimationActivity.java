package com.daybreak.androidsample.materialdesign.items;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class MaterialAnimationActivity extends BaseToolBarActivity {
    private Button mShowFlower;
    private Button mHideFlower;
    private ImageView mFlower;
    private ImageView mAnimVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
       }

        super.onCreate(savedInstanceState);

        setContentLayout(R.layout.activity_material_animation);

        mFlower = (ImageView) findViewById(R.id.flower);
        mShowFlower = (Button) findViewById(R.id.show_flower);
        mHideFlower = (Button) findViewById(R.id.hide_flower);

        mAnimVector = (ImageView) findViewById(R.id.anim_vector);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TypedValue typedValue = new TypedValue();
            getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true);
//            mFlower.setBackgroundResource(typedValue.resourceId);
        }


        mShowFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = mFlower.getWidth() / 2;
                    int cy = mFlower.getHeight() / 2;

                    final float finalRadius = (float) Math.hypot(cx, cy);

                    Animator animator = ViewAnimationUtils.createCircularReveal(mFlower, cx, cy, 0, finalRadius);

                    mFlower.setVisibility(View.VISIBLE);
                    animator.start();
                } else {
                    mFlower.setVisibility(View.VISIBLE);
                }
            }
        });

        mHideFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = mFlower.getWidth() / 2;
                    int cy = mFlower.getHeight() / 2;

                    int finalRadius = Math.max(mFlower.getWidth(), mFlower.getHeight());
                    // get the initial radius for the clipping circle
                    final float initialRadius = (float) Math.hypot(cx, cy);
                    Animator animator = ViewAnimationUtils.createCircularReveal(mFlower, cx, cy, initialRadius, 0);
                    animator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mFlower.setVisibility(View.INVISIBLE);
                        }
                    });

                    animator.start();
                } else {
                    mFlower.setVisibility(View.INVISIBLE);
                }
            }
        });

        mFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaterialAnimationActivity.this,
                        CoordinatorLayoutExploreActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setExitTransition(new Fade());
                    getWindow().setReenterTransition(new Fade());
                    // getWindow().setSharedElementExitTransition(new ChangeImageTransform());
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                            MaterialAnimationActivity.this, mFlower, "flower").toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });

        final AnimatedVectorDrawableCompat animatedVectorDrawable = AnimatedVectorDrawableCompat.create(this, R.drawable.animvectordrawable);
        mAnimVector.setImageDrawable(animatedVectorDrawable);
        animatedVectorDrawable.start();

        mAnimVector.setOnClickListener((view) -> {
            animatedVectorDrawable.start();
        });
    }
}
