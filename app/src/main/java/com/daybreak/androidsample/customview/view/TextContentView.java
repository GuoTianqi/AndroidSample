package com.daybreak.androidsample.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoTianqi on 2017/5/22.
 */

public class TextContentView extends BaseView {
    public static class MainContent {
        public String label;
        public String content;

        public MainContent(String label, String content) {
            this.label = label;
            this.content = content;
        }
    }

    private static final int HORIZONTAL_PADDING = 16;
    private static final int VERTICAL_PADDING = 20;
    private TextPaint mTextPaint;
    private float mScale = 1.0f;
    private List<MainContent> mMainContentList;

    public TextContentView(Context context) {
        this(context, null);
    }

    public TextContentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = mWidth;
        int height = mHeight;
        float scale = mScale;
        int horizontalPadding = (int) (HORIZONTAL_PADDING * mScale + 0.5);
        int verticalPadding = (int) (VERTICAL_PADDING * scale + 0.5);
        TextPaint paint = mTextPaint;

        int drawTop = verticalPadding;
        int drawLeft = horizontalPadding;

        // title
        paint.setTextSize(22 * scale);
        paint.setUnderlineText(true);
        StaticLayout textLayout = new StaticLayout(
                "订单信息确认单", paint, width - horizontalPadding * 2,
                Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, false);
        canvas.save();
        canvas.translate(drawLeft, drawTop);
        textLayout.draw(canvas);
        canvas.restore();
        drawTop += textLayout.getHeight() + 10 * scale;

        // 订单信息
        drawTop = drawMainContent(canvas, drawTop, horizontalPadding);

        // 客户签名
        paint.setTextSize(18 * scale);
        paint.setUnderlineText(false);
        textLayout = new StaticLayout(
                "客户签名：", paint, width - horizontalPadding * 2,
                Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, false);
        canvas.save();
        canvas.translate(width / 6f, drawTop + 24 *scale);
        textLayout.draw(canvas);
        canvas.restore();
    }

    private int drawMainContent(Canvas canvas, int drawTop, int horizontalPadding) {
        int width = mWidth;
        float scale = mScale;
        int labelWidth = (int) (80 * scale + 0.5);
        int itemPadding = (int) (4 * scale + 0.5);
        int drawLeft = horizontalPadding;

        TextPaint paint = mTextPaint;
        // label + content
        paint.setUnderlineText(false);
        paint.setTextSize(16 * scale);

        StaticLayout textLayout;
        for (MainContent mainContent : mMainContentList) {
            textLayout = new StaticLayout(
                    mainContent.label, paint, labelWidth,
                    Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, false);
            canvas.save();
            canvas.translate(drawLeft, drawTop);
            textLayout.draw(canvas);
            canvas.restore();

            textLayout = new StaticLayout(
                    mainContent.content, paint, width - horizontalPadding * 2 - labelWidth,
                    Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, false);
            canvas.save();
            canvas.translate(drawLeft + labelWidth, drawTop);
            textLayout.draw(canvas);
            canvas.restore();
            drawTop += textLayout.getHeight() + itemPadding;
        }

        return drawTop;
    }

    private void init(Context context) {
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        mScale = context.getResources().getDisplayMetrics().density;

        mMainContentList = new ArrayList<>(10);
        mMainContentList.add(new MainContent("订单号", "1384082309580938509839084585038"));
        mMainContentList.add(new MainContent("商家编码", "3840348250823095890238490823490"));
        mMainContentList.add(new MainContent("商户名称", "烦恼么哦就附近饿哦微积分分附近饿哦"));
        mMainContentList.add(new MainContent("收银台号", "112"));
        mMainContentList.add(new MainContent("支付金额", "334"));
        mMainContentList.add(new MainContent("交易结果", "成功"));
        mMainContentList.add(new MainContent("交易时间", "2017-05-22 16:31:39"));
        mMainContentList.add(new MainContent("关联信息", "就foe较为乏力阿胶物理攻击力文件管理危机感攻击力文件关机了我就金佛鞥呢啦go俄铝价格过呢哦"));
        mMainContentList.add(new MainContent("客户电话", "18705927468"));
        mMainContentList.add(new MainContent("备注信息", "减肥own刚刚弄饿我难过放假了文化节给了我构建了我就两个攻击力文件"));
    }
}
