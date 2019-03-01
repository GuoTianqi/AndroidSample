package com.daybreak.androidsample.animation;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

/**
 * Created by GuoTianqi on 2016/7/15.
 */
public class Animation2Activity extends BaseToolBarActivity {
    private int i = 0;
    private LinearLayout container;
    private LayoutTransition mTransitioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentLayout(R.layout.activity_aniamtion2);

        container = (LinearLayout) findViewById(R.id.parent);

        initTransition();
        setTransition();
    }

    /**
     * 初始化容器动画
     */
    private void initTransition() {
        mTransitioner = new LayoutTransition();
        container.setLayoutTransition(mTransitioner);
    }


    private void setTransition() {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        /**
         * view出现时 view自身的动画效果
         */
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "x", screenWidth, 50).
                setDuration(mTransitioner.getDuration(LayoutTransition.APPEARING));
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animator1);

        /**
         * view 消失时，view自身的动画效果
         */
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "alpha", 1.0f, .25f).
                setDuration(mTransitioner.getDuration(LayoutTransition.DISAPPEARING));
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animator2);

        /**
         * view 动画改变时，布局中的每个子view动画的时间间隔
         */
        mTransitioner.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
        mTransitioner.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);


        /**
         * 为什么这里要这么写？具体我也不清楚，ViewGroup源码里面是这么写的，我只是模仿而已
         * 不这么写貌似就没有动画效果了，所以你懂的！
         */
        PropertyValuesHolder pvhLeft =
                PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop =
                PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight =
                PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom =
                PropertyValuesHolder.ofInt("bottom", 0, 1);


        /**
         * view出现时，导致整个布局改变的动画
         */
//        PropertyValuesHolder animator3 = PropertyValuesHolder.ofFloat("scaleX", 1F, 2F, 1F);
//        final ObjectAnimator changeIn = ObjectAnimator.ofPropertyValuesHolder(
//                this, pvhLeft, pvhTop, pvhRight, pvhBottom, animator3).
//                setDuration(mTransitioner.getDuration(LayoutTransition.CHANGE_APPEARING));
//        changeIn.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                View view = (View) ((ObjectAnimator) animation).getTarget();
//                view.setScaleX(1.0f);
//            }
//        });
//        mTransitioner.setAnimator(LayoutTransition.CHANGE_APPEARING, changeIn);


        /**
         * view消失，导致整个布局改变时的动画
         */
//        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
//        Keyframe kf1 = Keyframe.ofFloat(.5f, 2f);
//        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
//        PropertyValuesHolder pvhRotation =
//                PropertyValuesHolder.ofKeyframe("scaleX", kf0, kf1, kf2);
//        final ObjectAnimator changeOut = ObjectAnimator.ofPropertyValuesHolder(
//                this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhRotation).
//                setDuration(mTransitioner.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
//        changeOut.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                View view = (View) ((ObjectAnimator) animation).getTarget();
//                view.setScaleX(1.0f);
//            }
//        });
//        mTransitioner.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeOut);

        mTransitioner.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }
        });
    }


    public void buttonClick(View view) {
        if (container.getChildCount() > 1) {
            removeButtonView();
        }
        addButtonView();
    }

    public void buttonClick1(View view) {
        removeButtonView();
    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        container.addView(button, params);
    }

    private void removeButtonView() {
        if (container.getChildCount() > 0) {
            container.removeViewAt(0);
        }
    }
}
