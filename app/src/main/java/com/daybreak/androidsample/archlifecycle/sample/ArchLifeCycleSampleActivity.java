package com.daybreak.androidsample.archlifecycle.sample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArchLifeCycleSampleActivity extends BaseToolBarActivity {
    @BindView(R.id.name_tv)
    TextView mNameTv;

    private SampleViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sample");
        setContentLayout(R.layout.activity_arch_life_cycle_sample);

        ButterKnife.bind(this);

        mModel = ViewModelProviders.of(this).get(SampleViewModel.class);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newName) {
                mNameTv.setText(newName);
            }
        };

        mModel.getCurrentName().observe(this, nameObserver);
    }
}
