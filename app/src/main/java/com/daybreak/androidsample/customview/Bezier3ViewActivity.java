package com.daybreak.androidsample.customview;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.customview.view.Bezier3View;

public class Bezier3ViewActivity extends BaseToolBarActivity {
    private Bezier3View mBezier3View;
    private RadioGroup mRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("三阶贝塞尔曲线");
        setContentLayout(R.layout.activity_bezier3_view);


        mBezier3View = (Bezier3View) findViewById(R.id.bezier3_view);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.control_1) {
                    mBezier3View.setMode(true);
                } else {
                    mBezier3View.setMode(false);
                }
            }
        });
    }
}
