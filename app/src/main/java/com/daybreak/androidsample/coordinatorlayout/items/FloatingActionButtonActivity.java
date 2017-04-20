package com.daybreak.androidsample.coordinatorlayout.items;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daybreak.androidsample.R;

public class FloatingActionButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v , "FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });
    }
}
