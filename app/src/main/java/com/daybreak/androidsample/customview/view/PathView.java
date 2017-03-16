package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GuoTianqi on 2017/3/14.
 */

public class PathView extends View {
    private Paint mPaint;
    private Path mPath;
    private int mWidth;
    private int mHeight;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);

        mPath = new Path();
        mPath.lineTo(200, 200);
        mPath.lineTo(200, 0);
        mPath.close();

        mPath.addRect(-200, -200, 200, 200, Path.Direction.CCW);
        mPath.setLastPoint(-300, 300);

        canvas.drawPath(mPath, mPaint);
    }
}
