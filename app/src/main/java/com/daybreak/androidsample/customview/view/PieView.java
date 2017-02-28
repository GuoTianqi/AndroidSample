package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.daybreak.androidsample.customview.data.PieData;

import java.util.ArrayList;

/**
 * Created by GuoTianqi on 2017/2/28.
 */

public class PieView extends View {
    private int[] mColors = {
            0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00
    };

    private float mStartAngle = 0;
    private ArrayList<PieData> mData;
    private int mWidth, mHeight;
    private Paint mPaint = new Paint();

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
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

        if (null == mData) {
            return;
        }

        float currentStartAngle = mStartAngle;
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);
        RectF rectf = new RectF(-r, -r, r, r);

        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectf, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }
    }

    public void setStartAngle(int startAngle) {
        mStartAngle = startAngle;
        invalidate();
    }

    public void setData(ArrayList<PieData> data) {
        mData = data;
        initData(data);
        invalidate();
    }

    private void initData(ArrayList<PieData> data) {
        if (data == null || data.size() == 0) {
            return;
        }

        float sumValue = 0;
        for (int i = 0; i < data.size(); i++) {
            PieData pie = data.get(i);
            sumValue += pie.getValue();
            int j = i % mColors.length;
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < data.size(); i++) {
            PieData pie = data.get(i);

            float percentage = pie.getValue() / sumValue;
            float angle = percentage * 360;

            pie.setPercentage(percentage);
            pie.setAngle(angle);
            sumAngle += angle;
        }
    }
}
