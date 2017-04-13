package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by GuoTianqi on 2017/4/11.
 */

public class RegionClickView extends BaseView {
    private Region mCircleRegion;
    private Path mCirclePath;

    public RegionClickView(Context context) {
        this(context, null);
    }

    public RegionClickView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(0xFF4E5268);
        mCirclePath = new Path();
        mCircleRegion = new Region();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int minWidth = w < h ? w : h;
        mCirclePath.addCircle(w / 2, h / 2, minWidth / 2, Path.Direction.CW);
        Region globalRegion = new Region(0, 0, w, h);
        mCircleRegion.setPath(mCirclePath, globalRegion);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int x = (int) event.getX();
                int y = (int) event.getY();

                if (mCircleRegion.contains(x, y)) {
                    Toast.makeText(getContext(), "圆被点击", Toast.LENGTH_SHORT).show();
                }

                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path circle = mCirclePath;
        canvas.drawPath(circle, mPaint);
    }
}
