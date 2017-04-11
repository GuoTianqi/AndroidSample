package com.daybreak.androidsample.customview.animation;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by GuoTianqi on 2017/3/23.
 */

public class Rotate3dAnimation extends Animation {
    private final float mFromDegrees;
    private final float mToDegrees;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final boolean mReverse;
    private Camera mCamera;

    private float mScale = 1;

    public Rotate3dAnimation(Context context, float fromDegrees, float toDegrees,
                             float centerX, float centerY, float depthZ, boolean reverse) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mCenterX = centerX;
        mCenterY = centerY;
        mDepthZ = depthZ;
        mReverse = reverse;

        mScale = context.getResources().getDisplayMetrics().density;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float degress = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        final Matrix matrix = t.getMatrix();
        mCamera.save();

        if (mReverse) {
            mCamera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
        } else {
            mCamera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
        }

        mCamera.rotateY(degress);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        // 修正失真
        float[] values = new float[9];
        matrix.getValues(values);
        values[6] = values[6] / mScale;
        values[7] = values[7] /mScale;
        matrix.setValues(values);

        matrix.postTranslate(mCenterX, mCenterY);
        matrix.preTranslate(-mCenterX, -mCenterY);

    }
}
