package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.daybreak.androidsample.R;

/**
 * Created by GuoTianqi on 2017/4/14.
 */

public class DragView extends BaseView {
    private Bitmap mBitmap;
    private RectF mBitmapRectF;
    private Matrix mBitmapMatrix;

    private boolean mCanDrag = false;
    private PointF mLastPoint = new PointF(0, 0);

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setLayerType(LAYER_TYPE_SOFTWARE, null);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = 960 / 2;
        options.outHeight = 800 / 2;
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.poly_test, options);
        mBitmapRectF = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        mBitmapMatrix = new Matrix();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerId(event.getActionIndex()) == 0 &&
                        mBitmapRectF.contains((int) event.getX(), (int) event.getY())) {
                    mCanDrag = true;
                    mLastPoint.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerId(event.getActionIndex()) == 0) {
                    mCanDrag = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mCanDrag) {
                    mBitmapMatrix.postTranslate(event.getX() - mLastPoint.x, event.getY() - mLastPoint.y);
                    mLastPoint.set(event.getX(), event.getY());

                    mBitmapRectF = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
                    mBitmapMatrix.mapRect(mBitmapRectF);

                    invalidate();
                }
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, mBitmapMatrix, mPaint);
    }
}
