package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GuoTianqi on 2017/3/1.
 */

public class PlaygroundView extends View {
    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;

    public PlaygroundView(Context context) {
        this(context, null);
    }

    public PlaygroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw x, y 轴
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.RED);
        canvas.drawLine(0, mHeight / 2, mWidth, mHeight / 2, mPaint);
        canvas.drawLine(mWidth / 2, 0, mWidth / 2, mHeight, mPaint);

        mPaint.setStrokeWidth(8);

        canvas.translate(mWidth / 2, mHeight / 2);

//        RectF rectf = new RectF(0, -200, 200, 0);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rectf, mPaint);
//
//        canvas.scale(-0.5f, -0.5f, 100, 0);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectf, mPaint);

//        RectF rect = new RectF(-400, -400, 400, 400);
//        for (int i = 0; i < 20; i++) {
//            canvas.scale(0.9f, 0.9f);
//            canvas.drawRect(rect, mPaint);
//        }

//        RectF rectf = new RectF(0, -200, 200, 0);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawRect(rectf, mPaint);
//        canvas.rotate(180, 100, 0);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectf, mPaint);

//        canvas.drawCircle(0, 0, 300, mPaint);
//        canvas.drawCircle(0, 0, 280, mPaint);
//
//        for (int i = 0; i <= 360; i += 10) {
//            canvas.drawLine(0, 280, 0, 300, mPaint);
//            canvas.rotate(10);
//        }

        RectF rect = new RectF(0, 0, 100, 100);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect, mPaint);

        //canvas.skew(1, 0);
        canvas.skew(0, 1);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
    }
}
