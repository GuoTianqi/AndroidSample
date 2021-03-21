package com.daybreak.androidsample.customview.view;

import android.os.Bundle;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

public class MirrorImageViewActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MirrorImageView");
        setContentLayout(R.layout.activity_mirror_image_view);
    }
}
