package com.daybreak.androidsample.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class Bezier2ViewActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("二阶贝塞尔曲线");
        setContentLayout(R.layout.activity_bezier);
    }
}
