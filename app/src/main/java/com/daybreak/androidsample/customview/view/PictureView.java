package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GuoTianqi on 2017/3/13.
 */

public class PictureView extends View {
    private Picture mPicture = new Picture();

    public PictureView(Context context) {
        this(context, null);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setLayerType(LAYER_TYPE_SOFTWARE, null);

        recording();
    }

    private void recording() {
        Canvas canvas = mPicture.beginRecording(500, 500);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        canvas.translate(250, 250);
        canvas.drawCircle(0, 0, 100, paint);

        mPicture.endRecording();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // mPicture.draw(canvas);
        // canvas.drawPicture(mPicture, new RectF(0, 0, mPicture.getWidth(), 200));
        PictureDrawable drawable = new PictureDrawable(mPicture);
        drawable.setBounds(0, 0, 250, mPicture.getHeight());
        drawable.draw(canvas);
    }
}
