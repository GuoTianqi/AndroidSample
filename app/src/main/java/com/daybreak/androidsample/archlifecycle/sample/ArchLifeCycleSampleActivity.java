package com.daybreak.androidsample.archlifecycle.sample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArchLifeCycleSampleActivity extends BaseToolBarActivity {
    private static String[] NAMES = {
            "Hello World!",
            "Hey, guys!",
            "Guo Tianqi",
    };

    @BindView(R.id.name_tv)
    TextView mNameTv;

    @BindView(R.id.change_name)
    Button mChangeName;

    private SampleViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sample");
        setContentLayout(R.layout.activity_arch_life_cycle_sample);

        ButterKnife.bind(this);

        mModel = ViewModelProviders.of(this).get(SampleViewModel.class);

        final Observer<String> nameObserver = newName -> {

            mNameTv.setText(newName);
        };

        // mModel.getCurrentName().observe(this, nameObserver);
        Transformations.map(mModel.getCurrentName(), name -> name + ", Ahh!").observe(this, nameObserver);

        mChangeName.setOnClickListener(v -> {
            String anotherName = NAMES[(int) (System.currentTimeMillis() % NAMES.length)];

            mModel.getCurrentName().setValue(anotherName);
        });
    }
}
