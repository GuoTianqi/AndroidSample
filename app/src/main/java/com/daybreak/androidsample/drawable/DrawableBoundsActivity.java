package com.daybreak.androidsample.drawable;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daybreak.androidsample.R;

public class DrawableBoundsActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_bounds);

        mTextView = findViewById(R.id.textView);

        Drawable drawable = getResources().getDrawable(R.drawable.flower);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mTextView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        mTextView.setCompoundDrawablesRelative(null, null, drawable, null);
    }
}
