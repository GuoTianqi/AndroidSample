package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GuoTianqi on 2017/2/28.
 */

public class SloopView extends View {
    private Paint mPaint = new Paint();
    public SloopView(Context context) {
        super(context);

        init(context);
    }

    public SloopView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // point
        canvas.drawPoint(500, 200, mPaint);
        canvas.drawPoints(new float[] {
                500, 500,
                600, 600,
                500, 700
        }, mPaint);

        // line
        canvas.drawLine(300, 300, 500, 600, mPaint);

        canvas.drawRect(10, 10, 400, 200, mPaint);
        RectF rectF = new RectF(420, 10, 610, 200);
        canvas.drawRoundRect(rectF, 10, 10, mPaint);
        rectF = new RectF(10, 10, 400, 200);
        mPaint.setColor(Color.RED);
        canvas.drawRoundRect(rectF, 195, 95, mPaint);

        rectF = new RectF(10, 220, 200, 350);
        canvas.drawOval(rectF, mPaint);
    }

    private void init(Context context) {
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }
}
