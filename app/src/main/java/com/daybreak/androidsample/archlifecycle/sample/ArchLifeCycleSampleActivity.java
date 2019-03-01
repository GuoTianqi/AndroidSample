package com.daybreak.androidsample.archlifecycle.sample;

import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;
import com.daybreak.androidsample.glide.GlideApp;

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
    @BindView(R.id.image_view)
    ImageView mImageView;

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

        GlideApp.with(this)
                .load("https://images.pexels.com/photos/433524/pexels-photo-433524.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                .placeholder(R.drawable.flower)
                .centerCrop()
                .into(mImageView);
    }
}
