package com.daybreak.androidsample.customview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.customview.animation.Rotate3dAnimation;

public class Rotate3dAnimationActivity extends BaseToolBarActivity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rotate3D");
        setContentLayout(R.layout.activity_rotate3d_animation);
        mImageView = (ImageView) findViewById(R.id.image);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float centerX = v.getWidth() / 2.0f;
                final float centerY = v.getHeight() / 2.0f;
                final Rotate3dAnimation rotate3dAnimation =
                        new Rotate3dAnimation(Rotate3dAnimationActivity.this,
                                0, 180, centerX, centerY, 0f, true);
                rotate3dAnimation.setDuration(3000);
                rotate3dAnimation.setFillAfter(true);
                rotate3dAnimation.setInterpolator(new LinearInterpolator());
                v.startAnimation(rotate3dAnimation);
            }
        });
    }
}
