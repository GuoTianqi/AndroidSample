package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

import com.daybreak.androidsample.R;

public class MirrorImageView extends BaseView implements ViewTreeObserver.OnPreDrawListener {
    private Bitmap mBitmap;
    private Rect mDstRect;

    public MirrorImageView(Context context) {
        super(context);
        init(context);
    }

    public MirrorImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.flower);
        mDstRect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        Rect rect = mDstRect;
        rect.set(0, 0, mWidth, mHeight);
        canvas.translate(mWidth, 0);
        canvas.scale(-1.0f, 1.0f);
        canvas.drawBitmap(mBitmap, null, mDstRect, mPaint);
        canvas.restore();
    }

    @Override
    public boolean onPreDraw() {
        return true;
    }
}
