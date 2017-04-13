package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by GuoTianqi on 2017/4/13.
 */

public class RemoteControlMenu extends BaseView {
    private Path mUpPath, mDownPath, mLeftPath, mRightPath, mCenterPath;
    private Region mUpRegion, mDownRegion, mLeftRegion, mRightRegion, mCenterRegion;
    private Matrix mMapMatrix = null;

    private static final int CENTER = 0;
    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;

    private MenuListener mListener = null;

    private int mTouchFlag = -1;
    private int mCurrentFlag = -1;

    private int mDefaultColor = 0xff4e5268;
    private int mTouchedColor = 0xffdf9c81;

    public RemoteControlMenu(Context context) {
        this(context, null);
    }

    public RemoteControlMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mUpPath = new Path();
        mDownPath = new Path();
        mLeftPath = new Path();
        mRightPath = new Path();
        mCenterPath = new Path();

        mUpRegion = new Region();
        mDownRegion = new Region();
        mLeftRegion = new Region();
        mRightRegion = new Region();
        mCenterRegion = new Region();

        mPaint.setColor(mDefaultColor);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);

        mMapMatrix = new Matrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mMapMatrix.reset();

        Region globalRegion = new Region(-w, -h, w, h);
        int minWidth = w > h ? h : w;
        minWidth *= 0.8;

        int br = minWidth / 2;
        RectF bigCircle = new RectF(-br, -br, br, br);

        int sr = minWidth / 4;
        RectF smallCircle = new RectF(-sr, -sr, sr, sr);

        float bigSweepAngle = 84;
        float smallSweepAngle = -80;

        mCenterPath.addCircle(0, 0, 0.2f * minWidth, Path.Direction.CW);
        mCenterRegion.setPath(mCenterPath, globalRegion);

        mRightPath.addArc(bigCircle, -40, bigSweepAngle);
        mRightPath.arcTo(smallCircle, 40, smallSweepAngle);
        mRightPath.close();
        mRightRegion.setPath(mRightPath, globalRegion);

        mDownPath.addArc(bigCircle, 50, bigSweepAngle);
        mDownPath.arcTo(smallCircle, 130, smallSweepAngle);
        mDownPath.close();
        mDownRegion.setPath(mDownPath, globalRegion);

        mLeftPath.addArc(bigCircle, 140, bigSweepAngle);
        mLeftPath.arcTo(smallCircle, 220, smallSweepAngle);
        mLeftPath.close();
        mLeftRegion.setPath(mLeftPath, globalRegion);

        mUpPath.addArc(bigCircle, 230, bigSweepAngle);
        mUpPath.arcTo(smallCircle, 310, smallSweepAngle);
        mUpPath.close();
        mUpRegion.setPath(mUpPath, globalRegion);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float[] pts = new float[2];
        if (!isHardwareAccelerated()) {
            pts[0] = event.getRawX();
            pts[1] = event.getRawY();
        } else {
            pts[0] = event.getX();
            pts[1] = event.getY();
        }
        Log.e("XXX", "x, y=" + pts[0] + "," + pts[1]);
        mMapMatrix.mapPoints(pts);
        Log.e("XXX", "raw  x, y=" + event.getRawX() + "," + event.getRawY());
        Log.e("XXX", "map x, y=" + pts[0] + "," + pts[1]);

        int x = (int) pts[0];
        int y = (int) pts[1];

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mTouchFlag = getTouchedPath(x, y);
                mCurrentFlag = mTouchFlag;
                break;
            case MotionEvent.ACTION_MOVE:
                mCurrentFlag = getTouchedPath(x, y);
                break;
            case MotionEvent.ACTION_UP:
                mCurrentFlag = getTouchedPath(x, y);
                if (mCurrentFlag == mTouchFlag && mCurrentFlag != -1 && mListener != null) {
                    switch (mCurrentFlag) {
                        case CENTER:
                            mListener.onCenterCliched();
                            break;
                        case UP:
                            mListener.onUpCliched();
                            break;
                        case RIGHT:
                            mListener.onRightCliched();
                            break;
                        case DOWN:
                            mListener.onDownCliched();
                            break;
                        case LEFT:
                            mListener.onLeftCliched();
                            break;
                    }
                }

                mTouchFlag = mCurrentFlag = -1;
                break;
            case MotionEvent.ACTION_CANCEL:
                mTouchFlag = mCurrentFlag = -1;
                break;
        }

        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);

        if (mMapMatrix.isIdentity()) {
            canvas.getMatrix().invert(mMapMatrix);
        }

        mPaint.setColor(mDefaultColor);
        canvas.drawPath(mCenterPath, mPaint);
        canvas.drawPath(mUpPath, mPaint);
        canvas.drawPath(mRightPath, mPaint);
        canvas.drawPath(mDownPath, mPaint);
        canvas.drawPath(mLeftPath, mPaint);

        mPaint.setColor(mTouchedColor);
        if (mCurrentFlag == CENTER) {
            canvas.drawPath(mCenterPath, mPaint);
        } else if (mCurrentFlag == UP) {
            canvas.drawPath(mUpPath, mPaint);
        } else if (mCurrentFlag == RIGHT) {
            canvas.drawPath(mRightPath, mPaint);
        } else if (mCurrentFlag == DOWN) {
            canvas.drawPath(mDownPath, mPaint);
        } else if (mCurrentFlag == LEFT) {
            canvas.drawPath(mLeftPath, mPaint);
        }
    }

    // 获取当前触摸点在哪个区域
    private int getTouchedPath(int x, int y) {
        if (mCenterRegion.contains(x, y)) {
            return CENTER;
        } else if (mUpRegion.contains(x, y)) {
            return UP;
        } else if (mRightRegion.contains(x, y)) {
            return RIGHT;
        } else if (mDownRegion.contains(x, y)) {
            return DOWN;
        } else if (mLeftRegion.contains(x, y)) {
            return LEFT;
        }
        return -1;
    }

    public void setListener(MenuListener listener) {
        mListener = listener;
    }

    // 点击事件监听器
    public interface MenuListener {
        void onCenterCliched();

        void onUpCliched();

        void onRightCliched();

        void onDownCliched();

        void onLeftCliched();
    }
}
