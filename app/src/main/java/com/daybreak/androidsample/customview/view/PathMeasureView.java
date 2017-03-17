package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.daybreak.androidsample.R;

/**
 * Created by GuoTianqi on 2017/3/17.
 */

public class PathMeasureView extends BaseView {
    private float currentValue = 0;

    private float[] pos;
    private float[] tan;
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private boolean mRunnable = true;

    public PathMeasureView(Context context) {
        this(context, null);
    }

    public PathMeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);
        Path path = new Path();
        path.addCircle(0, 0, 200, Path.Direction.CW);
        PathMeasure measure = new PathMeasure(path, false);

        if (mRunnable) {
            currentValue += 0.005;
            if (currentValue >= 1) {
                currentValue = 0;
            }
        }

        measure.getPosTan(measure.getLength() * currentValue, pos, tan);
        Log.e("XXX", "tan[0]=" + tan[0] + ",tan[1]=" + tan[1]);
        mMatrix.reset();
        float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI);
        Log.e("XXX", "degrees=" + degrees);
        mMatrix.postRotate(degrees, mBitmap.getWidth() / 2, mBitmap.getHeight() / 2);
        mMatrix.postTranslate(pos[0] - mBitmap.getWidth() / 2, pos[1] - mBitmap.getHeight() / 2);

        canvas.drawPath(path, mPaint);
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);


        postInvalidate();
    }

    private void init(Context context) {
        pos = new float[2];
        tan = new float[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_arrow, options);
        mMatrix = new Matrix();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mRunnable = !mRunnable;

            return true;
        }

        return false;
    }
}
