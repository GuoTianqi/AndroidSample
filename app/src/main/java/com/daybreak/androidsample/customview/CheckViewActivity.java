package com.daybreak.androidsample.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.customview.view.CheckView;

public class CheckViewActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CheckView");
        setContentLayout(R.layout.activity_check_view);

        final CheckView checkView = (CheckView) findViewById(R.id.check_view);
        final Button mCheck = (Button) findViewById(R.id.check);
        final Button mUnCheck = (Button) findViewById(R.id.uncheck);

        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkView.check();
            }
        });;

        mUnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkView.unCheck();
            }
        });
    }
}
