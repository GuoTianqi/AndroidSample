package com.daybreak.androidsample.materialdesign.items;

import android.animation.Animator;
import android.annotation.TargetApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

import com.daybreak.androidsample.R;

public class ConstraintLayoutActivity extends AppCompatActivity {
    private ImageView mFlower;

    @TargetApi(21)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        mFlower = (ImageView) findViewById(R.id.flower);
        mFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cx = (mFlower.getLeft() + mFlower.getRight()) / 2;
                int cy = (mFlower.getTop() + mFlower.getBottom()) / 2;

                int finalRadius = Math.max(mFlower.getWidth(), mFlower.getHeight());
                Animator anim = ViewAnimationUtils.createCircularReveal(mFlower, cx, cy, 0, finalRadius);
                anim.setDuration(10000);
                anim.start();
            }
        });
    }

}
