package com.daybreak.androidsample.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.daybreak.androidsample.R;

public class AnimationActivity extends AppCompatActivity {
    private ViewGroup mAnimLayout;
    private Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mAnimLayout = (ViewGroup) findViewById(R.id.anim_layout);
        mSend = (Button) findViewById(R.id.send);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView textView = new TextView(AnimationActivity.this);
                textView.setText("舅佛额外舅费劲儿哦\nf舅弗兰克舅费劲儿另外富而无骄类");
                textView.setTextSize(20);
                textView.setTextColor(Color.BLUE);
                textView.setBackgroundColor(Color.RED);

                mAnimLayout.addView(textView, 300, 100);
                int viewWidht = 300;
                int viewHeight = 100;
                Log.e("XXX", "view width = " + viewWidht);
                int screenWidth = getResources().getDisplayMetrics().widthPixels;

                int startY = 400;
                int endY = viewHeight * 2;
                AnimatorSet set1 = new AnimatorSet();
                set1.setInterpolator(new AccelerateInterpolator(4.0f));
                set1.setDuration(500);
                set1.playTogether(
                        ObjectAnimator.ofFloat(textView, "translationX", screenWidth - 40, screenWidth - viewWidht),
                        ObjectAnimator.ofFloat(textView, "translationY", startY, startY)
                );

                AnimatorSet set2 = new AnimatorSet();
                set2.setDuration(1000);
                set2.playTogether(
                        ObjectAnimator.ofFloat(textView, "translationY", startY, endY),
                        ObjectAnimator.ofFloat(textView, "alpha", 1, 0.25f)
                );
                AnimatorSet set = new AnimatorSet();
                set.playSequentially(set1,set2);
                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mAnimLayout.removeView(textView);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                set.start();
            }
        });
    }
}
