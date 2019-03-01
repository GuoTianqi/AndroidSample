package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by GuoTianqi on 2017/4/14.
 */

public class MultiTouchView extends BaseView {
    private boolean mHaveSecondPoint = false;

    private PointF mSecondPoint = new PointF(0, 0);

    public MultiTouchView(Context context) {
        this(context, null);
    }

    public MultiTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setLayerType(LAYER_TYPE_SOFTWARE, null);

        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerId(index) == 1) {
                    mHaveSecondPoint = true;
                    mSecondPoint.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerId(index) == 1) {
                    mHaveSecondPoint = false;
                    mSecondPoint.set(0, 0);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mHaveSecondPoint) {
                    int pointerIndex = event.findPointerIndex(1);
                    mSecondPoint.set(event.getX(pointerIndex), event.getY(pointerIndex));
                }
                break;
        }

        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawText("追踪第2个按下手指的位置", 0, 0, mPaint);
        canvas.restore();

        if (mHaveSecondPoint) {
            canvas.drawCircle(mSecondPoint.x, mSecondPoint.y, 50, mPaint);
        }
    }
}
