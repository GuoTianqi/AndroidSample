package com.daybreak.androidsample.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class PathMeasureActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("PathMeasure");
        setContentLayout(R.layout.activity_path_measure);
    }
}
